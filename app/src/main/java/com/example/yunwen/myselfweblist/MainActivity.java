package com.example.yunwen.myselfweblist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int dayMode = Configuration.UI_MODE_NIGHT_NO;
    public static final int nightMode = Configuration.UI_MODE_NIGHT_YES;
    Button bt_background, bt_textview_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        clickView();
    }

    private void clickView() {
        bt_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("onClick: ","点击了" );
                set_day_night_mode_change();
            }
        });
    }

    private void set_day_night_mode_change() {
        /**获取sp中的值，没有就不操作，使用默认的background等——第一次点击之前会为空值*/
        int mode_in_sp =SharedPreferenceUtils.getInt(getApplicationContext(), "mode", 0);
        if(mode_in_sp==0){
            Log.e("mainactivity_oncreat", "sp为空值(sp的默认赋值0没成功)，不会走这一步");
            SharedPreferenceUtils.putInt(getApplicationContext(), "mode",dayMode);
            return;
        }
        /**白切换成黑（存入黑的模式）——recreate*/
        if(mode_in_sp==dayMode){
            Log.e("mainavtivity_onCreate: ", "sp为day，换成night");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            SharedPreferenceUtils.putInt(getApplicationContext(), "mode",nightMode);
            recreate();
            /**解決白屏的方法*/
//            startActivity(new Intent(this,MainActivity.class));
//            overridePendingTransition(R.anim.anim_activity_alpha,R.anim.anim_activity_alpha);
            return;
        }
        /**黑切換成白（存入白的模式）——recreate*/
        if(mode_in_sp==nightMode){
            Log.e("mainavtivity_onCreate: ", "sp为night，换成day");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            SharedPreferenceUtils.putInt(getApplicationContext(), "mode",dayMode);
            recreate();
            /**解決白屏的方法*/
//            startActivity(new Intent(this,MainActivity.class));
//            overridePendingTransition(R.anim.anim_activity_alpha,R.anim.anim_activity_alpha);
            return;
        }
    }

    private void initView() {
        bt_background = (Button) findViewById(R.id.bt_change_mode);
        bt_textview_color = (Button) findViewById(R.id.text_button_change_color);
    }
}
