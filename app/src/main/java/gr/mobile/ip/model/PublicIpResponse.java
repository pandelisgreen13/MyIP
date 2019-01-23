package gr.mobile.ip.model;

import com.google.gson.annotations.SerializedName;

public class PublicIpResponse {

    @SerializedName("ip")
    public String ip;

    public String getIp() {
        return ip;
    }
}
