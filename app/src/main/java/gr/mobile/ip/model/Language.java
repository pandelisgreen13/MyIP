package gr.mobile.ip.model;

import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("code")
    public String code;
    @SerializedName("name")
    public String name;
    @SerializedName("native")
    public String _native;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String get_native() {
        return _native;
    }
}
