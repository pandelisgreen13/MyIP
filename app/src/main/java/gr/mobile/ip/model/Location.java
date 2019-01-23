package gr.mobile.ip.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Location {

    @SerializedName("geoname_id")
    public int geonameId;
    @SerializedName("capital")
    public String capital;
    @SerializedName("languages")
    public List<Language> languages = null;
    @SerializedName("country_flag")
    public String countryFlag;
    @SerializedName("country_flag_emoji")
    public String countryFlagEmoji;
    @SerializedName("country_flag_emoji_unicode")
    public String countryFlagEmojiUnicode;
    @SerializedName("calling_code")
    public String callingCode;
    @SerializedName("is_eu")
    public boolean isEu;

    public int getGeonameId() {
        return geonameId;
    }

    public String getCapital() {
        return capital;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getCountryFlagEmoji() {
        return countryFlagEmoji;
    }

    public String getCountryFlagEmojiUnicode() {
        return countryFlagEmojiUnicode;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public boolean isEu() {
        return isEu;
    }
}
