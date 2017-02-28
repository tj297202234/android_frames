package com.tongjin.frames;

import android.app.Activity;
import android.os.Bundle;
import android.os.UserHandle;
import android.support.annotation.IdRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.itheima.wheelpicker.WheelPicker;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.tongjin.frames.Bean.Bean;
import com.tongjin.frames.Net.NetRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // RetrofitUtils
        // useRetrofitUtils();
        // WheelPicker
        // useWheelPicker();
        // BottomBar
        useBottomBar();

    }

    private void useBottomBar() {

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bb);



        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return bottomBar.getTabCount();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        });

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_first:

                        break;
                    case R.id.tab_second:
                        break;
                    case R.id.tab_third:
                }

            }
        });
    }

    private void useWheelPicker() {
//        <com.itheima.wheelpicker.WheelPicker
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        app:wheel_atmospheric="true"
//        app:wheel_curved="true"
//        app:wheel_cyclic="true"
//        app:wheel_selected_item_position="5"
//        app:wheel_item_text_color="#66ff0000"
//        app:wheel_selected_item_text_color="#6600ffff"/>
//
//
//        属性解释:
//
//        wheel_atmospheric :  条目颜色是否执行衔接处理 效果更好
//        wheel_curved ： 是否是弧形状态显示
//        wheel_cyclic : 是否可循环
//        wheel_selected_item_position ： 默认选中第几个条目
//        wheel_item_text_color 未选中的条目颜色
//        wheel_selected_item_text_color  选中的条目颜色

        WheelPicker wp = (WheelPicker) findViewById(R.id.wp);
        wp.setVisibility(View.VISIBLE);
        ArrayList<String> data = new ArrayList<>();
        data.add("android");
        data.add("ios");
        data.add("java");
        data.add("php");
        data.add("python");
        data.add(".net");
        wp.setData(data);
    }

    private void useRetrofitUtils() {
        final TextView tv = (TextView) findViewById(R.id.tv);
        tv.setVisibility(View.VISIBLE);
        /*NetRequest.getInstance().getString("bdb8ca2b58fc4eea9833e0fbf7aed998", "1", "20", "1", "81b8332933cd47b09d742ea716af7f3b", "1", "1", new HttpResponseListener<String>() {

            @Override
            public void onResponse(String s, Headers headers) {
                Log.e("------；", s);
                tv.setText(s);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                tv.setText(e.toString());
            }
        });*/

        Map<String, Object> params = new HashMap<>();
        params.put("deviceId", "bdb8ca2b58fc4eea9833e0fbf7aed998");
        params.put("bt_id", "1");
        params.put("page_size","20");
        params.put("cat_id","1");
        params.put("access_token", "81b8332933cd47b09d742ea716af7f3b");
        params.put("page_no","1");
        params.put("act_id","1");
        NetRequest.getInstance().getBean(params, new HttpResponseListener<Bean>(){
            @Override
            public void onResponse(Bean bean, Headers headers) {
                tv.setText(bean.banner.get(0).burl);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                tv.setText("0000");
            }
        });
        tv.setText("请求");
    }
}
