package com.intimate.common.address;

import java.util.Vector;

public class GetAddressInfo {


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

    public static void main(String[] args) {

        // 获取省/市/县/镇 信息
        GetAddressInfo getAddressInfo = new GetAddressInfo();
        Vector<Vector<Vector>> addressInfo = getAddressInfo.getAddressInfo();
        // 省
        Vector<Vector> provinceVector = addressInfo.get(0);

        // 形成批量插入数据values 格式
        String provinceValues = getAddressInfo.getValues(provinceVector);

        // 市
        Vector<Vector> cityVector = addressInfo.get(1);

        // 形成批量插入数据values 格式
        String cityValues = getAddressInfo.getValues(cityVector);

        // 县
        Vector<Vector> countryVector = addressInfo.get(2);

        // 形成批量插入数据values 格式
        String countryValues = getAddressInfo.getValues(countryVector);

        // 镇
        Vector<Vector> townVector = addressInfo.get(3);

        // 形成批量插入数据values 格式
        String townValues = getAddressInfo.getValues(townVector);


        // 获取村
        for (Vector v : townVector){
            //  一个镇的所有村  循环获取村
            Vector<Vector> villageSet = getAddressInfo.getVillageSet(String.valueOf(v.get(0)));

        }

    }


    /**
     * 获取区域信息，预备插入数据库
     * @return
     */
    public Vector<Vector<Vector>> getAddressInfo(){
        // 省
        provinceSet = getProvinceSet();

        addressInfoSet.add(0,provinceSet);

        // 市
        for (Vector v : provinceSet){
            citySet = getCitySet(String.valueOf(v.get(0)));
        }
        addressInfoSet.add(1,citySet);

        // 县
        for (Vector v:citySet){
            countrySet = getCountrySet(String.valueOf(v.get(0)));
        }
        addressInfoSet.add(2,countrySet);

        // 镇
        for (Vector v:countrySet){
            if (!String.valueOf(v.get(1)).equals("市辖区")){
                townSet = getTownSet(String.valueOf(v.get(0)));
            }
        }
        addressInfoSet.add(3,townSet);
        return addressInfoSet;
    }

    public String getValues(Vector<Vector> vectors){
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
    private Vector<Vector> getVillageSet(String townCode){
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
