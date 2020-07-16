package com.example.weatherapp;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.Api.ApiEndPoint;
import com.example.weatherapp.Api.ApiModule;
import com.example.weatherapp.Api.Data;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cityText)
    EditText cityText;
    @BindView(R.id.tempText)
    TextView temperature;
    @BindView(R.id.feelsLike)
    TextView feelsLike;
    @BindView(R.id.humidityText)
    TextView humidity;
    @BindView(R.id.imageWeather)
    ImageView imageWeather;

    public static Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actionComponent();
    }

    private void actionComponent() {
        cityText.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                getWeatherData(cityText.getText().toString().trim());
                hideKeyboard(this);
                handled = true;
            }
            return handled;
        });

    }

    @OnClick(R.id.container)
    public void onContainerTouch() {
        hideKeyboard(this);
    }

    @OnClick(R.id.searchBtn)
    public void getCityWeather() {
        getWeatherData(cityText.getText().toString().trim());
    }

    private void getWeatherData(String city) {
        ApiEndPoint apiEndPoint;

        apiEndPoint = ApiModule.getClient().create(ApiEndPoint.class);

        Call<Data> call = apiEndPoint.getWeatherData(city);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                temperature.setText(response.body().getMainData().getTemp() + "°C");
                feelsLike.setText(response.body().getMainData().getFeelsLike());
                humidity.setText(response.body().getMainData().getHumidity());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.getStackTrace();
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}