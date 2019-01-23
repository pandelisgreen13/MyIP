package gr.mobile.ip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import gr.mobile.ip.model.IpResponse;
import gr.mobile.ip.model.PublicIpResponse;
import gr.mobile.ip.retrofit.api.RetrofitApi;
import gr.mobile.ip.retrofit.client.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView ipTextView;
    private TextView publicIpTextView;
    private ProgressBar progressBar;

    private RetrofitApi retrofitApi;
    private String ipAddress = null;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.titleTextView);
        ipTextView = findViewById(R.id.ipTextView);
        publicIpTextView = findViewById(R.id.publicIpTextView);
        progressBar = findViewById(R.id.progressBar);

        retrofitApi = RetrofitClient.initRetrofit().create(RetrofitApi.class);

        //Get local Ip
        getLocalIp();

        //public ip
        getPublicIp();
    }

    private void getPublicIp() {
        Call<PublicIpResponse> callIp = retrofitApi.getPublicIpAddress();
        callIp.enqueue(new Callback<PublicIpResponse>() {
            @Override
            public void onResponse(@NonNull Call<PublicIpResponse> call, @NonNull Response<PublicIpResponse> response) {
                if (response.body() != null) {
                    publicIpTextView.setText(response.body().getIp());
                    getIp(response.body().getIp());
                }
            }

            @Override
            public void onFailure(@NonNull Call<PublicIpResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void getLocalIp() {
        WifiManager wifiMan = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiMan != null) {
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            ipAddress = String.valueOf(String.format("%d.%d.%d.%d", (wifiInf.getIpAddress() & 0xff), (wifiInf.getIpAddress() >> 8 & 0xff), (wifiInf.getIpAddress() >> 16 & 0xff),
                    (wifiInf.getIpAddress() >> 24 & 0xff)));
            ipTextView.setText(ipAddress);
        }
    }

    private void getIp(String ipAddress) {
        Call<IpResponse> call = retrofitApi.getIpAddress(ipAddress, "your_api_key");
        call.enqueue(new Callback<IpResponse>() {
            @Override
            public void onResponse(@NonNull Call<IpResponse> call, @NonNull Response<IpResponse> response) {
                if (response.body() != null) {
                    textView.setText(response.body().getCountryName());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<IpResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
