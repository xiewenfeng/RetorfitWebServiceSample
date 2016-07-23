package com.smilexie.retrofitsoapsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.smilexie.retrofitsoapsample.adapter.WeatherResponseAdapter;
import com.smilexie.retrofitsoapsample.databinding.ActivityMainBinding;
import com.smilexie.retrofitsoapsample.webservice.RetrofitGenerator;
import com.smilexie.retrofitsoapsample.webservice.request.RequestBody;
import com.smilexie.retrofitsoapsample.webservice.request.RequestEnvelope;
import com.smilexie.retrofitsoapsample.webservice.request.RequestModel;
import com.smilexie.retrofitsoapsample.webservice.response.ResponseEnvelope;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 主类，用于模拟请求每个城市天气情况
 * Created by SmileXie on 16/7/15.
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private WeatherResponseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rvElements.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * 根据城市名称获取天气
     * @param view
     */
    public void sendRequest(View view) {
        if(TextUtils.isEmpty(binding.etCityName.getText())) {
            Toast.makeText(this, getString(R.string.make_request), Toast.LENGTH_SHORT).show();
        } else {
            hideKeyboard();
            getWeatherbyCityName();
        }
    }

    /**
     * 根据城市名获取天气情况
     * @return
     */
    public void getWeatherbyCityName() {
        binding.progressbar.setVisibility(View.VISIBLE);
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        RequestModel requestModel = new RequestModel();
        requestModel.theCityName = binding.etCityName.getText().toString();
        requestModel.cityNameAttribute = "http://WebXml.com.cn/";
        requestBody.getWeatherbyCityName = requestModel;
        requestEnvelop.body = requestBody;
        Call<ResponseEnvelope> call = RetrofitGenerator.getWeatherInterfaceApi().getWeatherbyCityName(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Response<ResponseEnvelope> response) {
                binding.progressbar.setVisibility(View.GONE);
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null ) {
                    List<String> weatherResult = responseEnvelope.body.getWeatherbyCityNameResponse.result;
                    adapter = new WeatherResponseAdapter(weatherResult);
                    binding.rvElements.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                binding.progressbar.setVisibility(View.GONE);
            }
        });
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
