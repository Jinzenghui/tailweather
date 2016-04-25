package util;

import android.text.TextUtils;

import db.TailWeatherDB;
import model.City;
import model.County;
import model.Province;

/**
 * Created by BIAC on 2016/4/25.
 */
public class Utility {

    public synchronized  static boolean handleProvinceResponse(TailWeatherDB tailWeatherDB, String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if(allProvinces != null && allProvinces.length > 0){
                for(String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    tailWeatherDB.saveProvince(province);
                }

                return true;
            }
        }

        return false;
    }

    public static boolean handleCitiesResponse(TailWeatherDB tailWeatherDB, String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if(allCities != null && allCities.length > 0){
                for(String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    tailWeatherDB.saveCity(city);
                }

                return true;
            }
        }

        return false;
    }

    public static boolean handleCountiesResponse(TailWeatherDB tailWeatherDB, String response, int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if(allCounties != null && allCounties.length > 0){
                for(String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    tailWeatherDB.saveCounty(county);
                }
                return true;
            }
        }

        return false;
    }

}
























