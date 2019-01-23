package gr.mobile.ip.retrofit.api;

import gr.mobile.ip.model.IpResponse;
import gr.mobile.ip.model.PublicIpResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("{" + "ip" + "}")
    Call<IpResponse> getIpAddress(@Path(value = "ip", encoded = true) String ip, @Query("access_key") String access_key);

    @GET("https://api.ipify.org/?format=json")
    Call<PublicIpResponse> getPublicIpAddress();
}
