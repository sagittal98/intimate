package com.intimate.common.sms;


import com.intimate.pojo.Province;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VerifyIdCardUtils {

    /**
     * The ID card verification tool is used to verify the validity of the ID
     * card number . It is verified by national standards.
     * The national standard structure states that the ID card number is
     * composed of address code, birthday code, sequence code and check code.
     *
     * 身份证验证工具用来验证身份证号码的有效性。它通过国家规定的标准进行验证的。
     * 国家标准结构说明身份证号码是由地址码、生日期码、顺序码和校验码组成的。
     * 它的计算方法：
     * 1.将身份证号码前十七位数字分别乘以不同的系数。从第一位到第十七位的系数分别为：
     * 7－9－10－5－8－4－2－1－6－3－7－9－10－5－8－4－2。
     * 2.将这17位数字和系数相乘的结果相加。
     * 3.用加出来的数除以11，得余数。
     * 4.余数只可能有0－1－2－3－4－5－6－7－8－9－10这11个数字，其分别对应的身份证号码
     * 最后一位数为1－0－X －9－8－7－6－5－4－3－2。
     *
     */

    // coefficient constant  系数常量集合
    final private static int[] COEFFICIENT_SET = new int[]{7 ,9 ,10 ,5 ,8 ,4 ,2 ,1 ,6 ,3 ,7 ,9 ,10, 5 ,8, 4 ,2};
    // remainder constant 余数常量集合
    final private static char[] REMAINDER_SET = new char[]{'1','0','X','9','8','7','6','5','4','3','2'};
    // network request base address 网络请求基址
    final private static String ID_CARD_BASE_URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/";

    // address info set 地址信息集合
    private Vector<Vector<Vector>> addressInfoSet = new Vector<>();
    // province set 省集合
    private Vector<Vector> provinceSet = new Vector<>();
    // city set 市集合
    private Vector<Vector> citySet = new Vector<>();
    // country set 县集合
    private Vector<Vector> countrySet = new Vector<>();
    // town set 镇集合
    private Vector<Vector> townSet = new Vector<>();
    // village set 村集合
    private Vector<Vector> villageSet = new Vector<>();
    // data set 集合
    private Vector<String> data;

    // network request tools 网络请求
    private static HttpRequestUtils httpRequestUtils = new HttpRequestUtils();

    /**
     * This is a verify ID card number method.
     * @param IDCard  ID card number.
     * @return  result TRUE or FALSE.
     */
    public boolean verifyIdCard(String IDCard){
        // ID card verification code.
        char idCardCheckCode = IDCard.charAt(17);
        if (IDCard.length() == 18){
            // product sum
            int idCardSum = 0;
            // remainder
            int remainder;
            for (int i = 0 ; i < IDCard.length() -1 ; i ++ ){
                idCardSum += Integer.parseInt(String.valueOf(IDCard.charAt(i))) * COEFFICIENT_SET[i];
            }
            remainder = idCardSum % 11 ;
            // get result TRUE or FALSE.
            return idCardCheckCode == REMAINDER_SET[remainder];
        }else {
            // if there are no 18 digits in the ID card number, it is a fake ID card number.
            return false;
        }
    }

    // 提取身份证号码所有已知信息
//    public IDCardInfo idCardInfos(String idCardNumber){
//        IDCardInfo idCardInfo = new IDCardInfo();
//        idCardInfo.setIDCardNumber(idCardNumber);
//        idCardInfo.setProvinceCode(Integer.valueOf(idCardNumber.substring(0,2)));
//        idCardInfo.setCityCode(Integer.valueOf(idCardNumber.substring(0,4)));
//        idCardInfo.setCountryCode(Integer.valueOf(idCardNumber.substring(0,6)));
//        // 现将一连串数字转换成日期
//        String birthStr = idCardNumber.substring(6,14);
//        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
//        // 再将日期转换成需要的格式
//        SimpleDateFormat birth = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = new Date() ;
//        try {
//            parse = yyyyMMdd.parse(birthStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        idCardInfo.setBirth(birth.format(parse));
//        idCardInfo.setSex(Integer.parseInt(idCardNumber.substring(16,17))%2);
//        idCardInfo.setAge(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) -  Integer.parseInt(idCardNumber.substring(6,10)));
//        return idCardInfo;
//    }



    /**
     * 获取区域信息，预备插入数据库
     * @return
     */
    public Vector<Vector<Vector>> getAddressInfo(){
//        // 省
//        provinceSet = getProvinceSet();
//
        addressInfoSet.add(0,provinceSet);
////
//        // 市
//        for (Vector v : provinceSet){
//            citySet = getCitySet(String.valueOf(v.get(0)));
//        }
        addressInfoSet.add(1,citySet);
////
//        // 县
//        for (Vector v:citySet){
//            countrySet = getCountrySet(String.valueOf(v.get(0)));
//        }
        addressInfoSet.add(2,countrySet);
////
//        // 镇
//        for (Vector v:countrySet){
//            if (!String.valueOf(v.get(1)).equals("市辖区")){
//                townSet = getTownSet(String.valueOf(v.get(0)));
//            }
//        }
        addressInfoSet.add(3,townSet);
//        System.out.println(addressInfoSet);
////
//         村
//        for (Vector v : townSet){
            villageSet = getVillageSet("441900003");
//            villageSet = getVillageSet(String.valueOf(v.get(0)));
//        }
        System.out.println(villageSet);
        addressInfoSet.add(4,villageSet);
        return addressInfoSet;
    }

    private String getValues(Vector<Vector> vectors){
        StringBuilder values = new StringBuilder();
        int i = 0;
        for (Vector v:vectors){
            String cont = "(" + v.get(0) + "," + v.get(1);
            if(v.size() == 3) {
                cont += ","+"'"+v.get(2)+"')";
            }else {
                cont += ")";
            }
            if (i == vectors.size() - 1){
                values.append(cont);
            }else {
                values.append(cont).append(",");
            }
            i +=1;
        }
        return String.valueOf(values);
    }

    // 省
    private Vector<Vector> getProvinceSet(){
        String url = ID_CARD_BASE_URL + "index.HTML";
        // 获取网页代码
        String webCodes = httpRequestUtils.address(url);
        // 分割网页代码形成数组
        String[] webCodesArray = webCodes.split("<a");
        // 通过遍历获取页面数据
        for (String provinceInfo : webCodesArray){
            // 判断代码里面是否有href和html关键代码，存在则是预期代码
            if (provinceInfo.contains("href")&&provinceInfo.contains(".html")){
                // 构建数据集
                data = new Vector<>();
                // 获取代码
                String provinceCode = provinceInfo.substring(provinceInfo.indexOf("href='")+6,provinceInfo.indexOf(".html'>"));
                // 获取昵称
                String provinceName = provinceInfo.substring(provinceInfo.indexOf("html'>")+6, provinceInfo.indexOf("<br/>"));
                // 省代号
                data.add(provinceCode);
                // 省名称
                data.add(provinceName);
                provinceSet.add(data);

            }
        }
        return provinceSet;
    }
    // 市
    private Vector<Vector> getCitySet(String provinceCode){
        // 请求地址
        String url = ID_CARD_BASE_URL + provinceCode.substring(0,2) + ".HTML";
        // 爬取网页代码
        String webCodes = httpRequestUtils.address(url);
        // 对网页代码进行分割
        String[] webCodesArray = webCodes.split("citytr");
        // 通过遍历获取页面数据
        for (String cityInfo : webCodesArray){
            // 再次分割
            String[] infoArray = cityInfo.split("<a");
            // 构建数据集
            data = new Vector<>();
            // 循环抓取页面数据
            for (String info : infoArray) {
                // 判断代码里面是否有href和html关键代码，存在则是预期代码
                if (info.contains("href") && info.contains(".html")) {
                    // 获取内容
                    String content = info.substring(info.indexOf("html'>") + 6, info.indexOf("</a>"));
                    // 存内容
                    if (content.length() == 12 && content.substring(0,2).equals(provinceCode)){
                        data.add(content.substring(0,4));
                    }else {
                        data.add(content);
                    }
                }
            }
            // 判断是否为空，为空则不写入集合
            if (data.size()!=0){
                citySet.add(data);
            }
        }
        // 返回结果集
        return citySet;
    }
    // 县
    private Vector<Vector> getCountrySet(String cityCode){
        String url = ID_CARD_BASE_URL + cityCode.substring(0,2) + "/" + cityCode + ".HTML";
        String webCodes = httpRequestUtils.address(url);
        String[] webCodesArray = webCodes.split("href");
        data = new Vector<>();
        // 通过遍历获取页面数据
        for (String countryInfo : webCodesArray){
            // 判断代码里面是否有href和html关键代码，存在则是预期代码
            if (countryInfo.contains(".html'>") && countryInfo.contains("</a>")) {
                // 获取内容
                String content = countryInfo.substring(countryInfo.indexOf("html'>") + 6, countryInfo.indexOf("</a>"));
                if (content.length() == 12 && content.substring(0, 4).equals(cityCode)){
                    if (content.substring(6,9).equals("000")){
                        data.add(content.substring(0,6));
                    }else {
                        data.add(content.substring(0,9));
                    }
                }else {
                    data.add(content);
                }
            }
            if (countryInfo.contains("市辖区")){
                String countryCode = cityCode + "01";
                data.add(countryCode);
                data.add("市辖区");
            }
            if (data.size() == 2){
                if (data.get(0).length() == 6){
                    countrySet.add(data);
                }else {
                    townSet.add(data);
                }
                data = new Vector<>();
            }
        }
        return countrySet;
    }
    // 镇
    private Vector<Vector> getTownSet(String countryCode){
        String url = ID_CARD_BASE_URL + countryCode.substring(0,2) + "/" +countryCode.substring(2,4) +"/"+ countryCode + ".HTML";
        String webCodes = httpRequestUtils.address(url);
        String[] webCodesArray = webCodes.split("towntr");
        // 通过遍历获取页面数据
        for (String townInfo : webCodesArray){
            String[] infoArray = townInfo.split("href");
            // 构建数据集
            data = new Vector<>();
            for (String info : infoArray) {
                // 判断代码里面是否有href和html关键代码，存在则是预期代码
                if (info.contains(".html'>") && info.contains("</a>")) {
                    // 获取内容
                    String content = info.substring(info.indexOf("html'>") + 6, info.indexOf("</a>"));
                    if (content.length() == 12 && content.substring(0, 6).equals(countryCode)){
                        data.add(content.substring(0,9));
                    }else {
                        data.add(content);
                    }
                }
            }
            // 出去空值
            if (data.size()!=0){
                townSet.add(data);
            }
        }
        return townSet;
    }
    // 村
    public Vector<Vector> getVillageSet(String townCode){
        // 清空
        villageSet.clear();
        String url = ID_CARD_BASE_URL + townCode.substring(0,2) + "/" +townCode.substring(2,4) +"/"+ townCode.substring(4,6) + "/"+townCode + ".HTML";
        if (
                townCode.substring(0,4).equals("4419")
                ||townCode.substring(0,4).equals("4420")
                ||townCode.substring(0,4).equals("4604")
        ){
            url = ID_CARD_BASE_URL + townCode.substring(0,2) + "/" +townCode.substring(2,4) +"/"+townCode + ".HTML";
        }
        String webCodes = httpRequestUtils.address(url);
        String[] webCodesArray = webCodes.split("villagetr");
        // 通过遍历获取页面数据
        for (String villageInfo : webCodesArray) {
            data = new Vector<>();
            String[] infos = villageInfo.split("<td>");
            if (infos.length == 2){
                continue;
            }
            // 村代号
            data.add(infos[1].substring(0,12));
            // 村分类
            data.add(infos[2].substring(0, infos[2].indexOf("</td>")));
            // 村名称
            data.add(infos[3].substring(0, infos[3].indexOf("</td>")));
            villageSet.add(data);
        }
        return villageSet;
    }


}
