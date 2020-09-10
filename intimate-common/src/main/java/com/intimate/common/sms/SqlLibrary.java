package com.intimate.common.sms;



import java.util.Vector;

/**
 * 数据库语句库
 */
public class SqlLibrary {

    public String insertProvince (String values){
        return "INSERT INTO province(province_code,province_name) " +
                "VALUES " +
                values;
    }

    public String insertCity(String values){
        return "INSERT INTO city(city_code,city_name)" +
                " VALUES " +
                values;
    }
    public String insertCountry(String values){
        return "INSERT INTO country(country_code,country_name)" +
                " VALUES " +
                values;
    }
    public String insertTown(String values){
        return "INSERT INTO town(town_code,town_name)" +
                " VALUES " +
                values;
    }
    public String insertVillage(String values){
        return "INSERT INTO village(village_code,village_type,village_name)" +
                " VALUES " +
                values;
    }

    String selectIdCardInfo(String code){
        // 省代号
        Integer provinceCode = Integer.valueOf(code.substring(0,2));
        // 市代号
        Integer cityCode = Integer.valueOf(code.substring(0,4));
        // 县代号
        Integer countryCode = Integer.valueOf(code.substring(0,6));
        System.out.println(provinceCode);
        return "SELECT p.province_name AS provinceName,c.city_name AS cityName,co.country_name AS countryName from province AS p,city As c,country AS co" +
                " WHERE " +
                "p.province_code = " + provinceCode+
                " AND c.city_code = "+cityCode +
                " AND co.country_code = "+countryCode;

    }


}
