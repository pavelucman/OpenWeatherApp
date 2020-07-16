// Generated code from Butter Knife. Do not modify!
package com.example.weatherapp;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f080059;

  private View view7f0800db;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.cityText = Utils.findRequiredViewAsType(source, R.id.cityText, "field 'cityText'", EditText.class);
    target.temperature = Utils.findRequiredViewAsType(source, R.id.tempText, "field 'temperature'", TextView.class);
    target.feelsLike = Utils.findRequiredViewAsType(source, R.id.feelsLike, "field 'feelsLike'", TextView.class);
    target.humidity = Utils.findRequiredViewAsType(source, R.id.humidityText, "field 'humidity'", TextView.class);
    target.imageWeather = Utils.findRequiredViewAsType(source, R.id.imageWeather, "field 'imageWeather'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.container, "method 'onContainerTouch'");
    view7f080059 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onContainerTouch();
      }
    });
    view = Utils.findRequiredView(source, R.id.searchBtn, "method 'getCityWeather'");
    view7f0800db = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.getCityWeather();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cityText = null;
    target.temperature = null;
    target.feelsLike = null;
    target.humidity = null;
    target.imageWeather = null;

    view7f080059.setOnClickListener(null);
    view7f080059 = null;
    view7f0800db.setOnClickListener(null);
    view7f0800db = null;
  }
}
