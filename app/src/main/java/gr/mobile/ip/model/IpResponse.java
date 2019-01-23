package gr.mobile.ip.model;

import com.google.gson.annotations.SerializedName;

public class IpResponse {

    @SerializedName("ip")
    public String ip;
    @SerializedName("type")
    public String type;
    @SerializedName("continent_code")
    public String continentCode;
    @SerializedName("continent_name")
    public String continentName;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_name")
    public String countryName;
    @SerializedName("region_code")
    public String regionCode;
    @SerializedName("region_name")
    public String regionName;
    @SerializedName("city")
    public String city;
    @SerializedName("zip")
    public String zip;
    @SerializedName("latitude")
    public double latitude;
    @SerializedName("longitude")
    public double longitude;
    @SerializedName("location")
    public Location location;

    public String getIp() {
        return ip;
    }

    public String getType() {
        return type;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Location getLocation() {
        return location;
    }
}
