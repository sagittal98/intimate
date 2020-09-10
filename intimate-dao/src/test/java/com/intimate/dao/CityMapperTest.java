package com.intimate.dao;


import com.intimate.common.sms.SqlLibrary;
import com.intimate.common.sms.VerifyIdCardUtils;
import com.intimate.pojo.*;
import org.apache.commons.collections.list.AbstractListDecorator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private TownMapper townMapper;
    @Autowired
    private VillageMapper villageMapper;

    @Test
    public void insertList() {
        VerifyIdCardUtils verifyIdCardUtils = new VerifyIdCardUtils();
//        Vector<Vector<Vector>> addressInfo = verifyIdCardUtils.getAddressInfo();
        // 省
//        Vector<Vector> provinceSet = addressInfo.get(0);
//        // 市
//        Vector<Vector> citySet = addressInfo.get(1);
//        // 县
//        Vector<Vector> countrySet = addressInfo.get(2);
//        // 镇
//        Vector<Vector> townSet = addressInfo.get(3);
//        // 村
//        Vector<Vector> villageSet = new Vector<>();
//        List<Province> provinceList = new ArrayList<>();
//        for (Vector v:provinceSet){
//            Province province = new Province();
//            int s1 = Integer.parseInt(v.get(0).toString());
//            byte[] code = new byte[1];
//            code[0] = (byte) s1;
//            province.setProvinceCode(code[0]);
//            province.setProvinceName((String) v.get(1));
//            System.out.println(province.toString());
//            provinceList.add(province);
//        }
//        System.out.println(Arrays.toString(provinceList.toArray()));
//        int i = provinceMapper.insertList(provinceList);
//        System.out.println(i);

//        List<City> cityList = new ArrayList<>();
//        for (Vector v : citySet){
//            City city = new City();
//            city.setCityCode(Short.parseShort((String) v.get(0)));
//            city.setCityName((String) v.get(1));
//            cityList.add(city);
//        }
//        int i = cityMapper.insertList(cityList);
//        System.out.println(i);


//        List<Country> countryList = new ArrayList<>();
//        for (Vector v : countrySet){
//            Country country = new Country();
//            country.setCountryCode(Integer.parseInt((String)v.get(0)));
//            country.setCountryName((String) v.get(1));
//            countryList.add(country);
//        }
//        int i = countryMapper.insertList(countryList);
//        System.out.println(i);

//        List<Town> townList = new ArrayList<>();
//        for (Vector v : townSet){
//            Town town = new Town();
//            town.setTownCode(Integer.parseInt((String)v.get(0)));
//            town.setTownName((String) v.get(1));
//            townList.add(town);
//        }
//        System.out.println(townList.size());
//        int i = townMapper.insertList(townList);
//        System.out.println(i);

//        Vector<Vector> villageSet1 = verifyIdCardUtils.getVillageSet("441900122");

        List<Town> townList = townMapper.selectByExample(null);


        for (Town town:townList){
            Vector<Vector> villageSet = new Vector<>();
            List<Village> villageList = new ArrayList<>();
            System.out.println("第" + town.getTownId() + "次循环！");
            System.out.println("size = " +villageSet.size());

            if (town.getTownId() >= 12664){
                try {
                    System.out.println("village 01");
                    villageSet = verifyIdCardUtils.getVillageSet(String.valueOf(town.getTownCode()));
                }catch (Exception e){
                    try {
                        System.out.println(villageSet);
                        System.out.println("village 02");
                        villageSet = verifyIdCardUtils.getVillageSet(String.valueOf(town.getTownCode()));
                    }catch (Exception e1){
                        System.out.println(villageSet);
                        System.out.println("village 03");
                        villageSet = verifyIdCardUtils.getVillageSet(String.valueOf(town.getTownCode()));
                    }
                }
                System.out.println(villageSet);
                for (Vector v : villageSet) {
                    Village village = new Village();
                    village.setVillageCode(Long.valueOf((String) v.get(0)));
                    village.setVillageType(Short.parseShort(String.valueOf(v.get(1))));
                    village.setVillageName((String) v.get(2));
                    villageList.add(village);
                }

                try {
                    System.out.println("第一次");
                    System.out.println(Arrays.toString(villageList.toArray()));
                    int result = villageMapper.insertList(villageList);
                    System.out.println(result);
                }catch (Exception e){
                    try {
                        System.out.println("第二次");
                        int result = villageMapper.insertList(villageList);
                        System.out.println(result);
                    }catch (Exception e1){
                        System.out.println("第三次");
                        int result = villageMapper.insertList(villageList);
                        System.out.println(result);
                    }
                }
            }

        }




//        List<Village> villageList = new ArrayList<>();
//        for (Vector v: villageSet){
//
//        }
//        System.out.println(villageList.size());
//        int i1 = villageMapper.insertList(villageList);
//        System.out.println(i1);
    }
}