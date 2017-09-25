package com.example.yunwen.myselfweblist;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import static com.example.yunwen.myselfweblist.MainActivity.dayMode;
import static com.example.yunwen.myselfweblist.MainActivity.nightMode;

/**
 * Created by yunwen on 2017/9/25.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();




        /**初始化夜间模式*/
        /**MODE_NIGHT_NO： 亮色(light)主题，不使用夜间模式
         MODE_NIGHT_YES：暗色(dark)主题，使用夜间模式
         MODE_NIGHT_AUTO：根据当前时间自动切换 亮色( light )/暗色( dark )主题（22：00-07：00时间段内自动切换为夜间模式）
         MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为MODE_NIGHT_NO
         * */
        /**第一种方式：直接在application中初始化为夜间模式*/
//         AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        /**第二种方式：进入时候显示为之前设置的状态*/
        /**获取sp中的值，没有就不操作，使用默认的background等——第一次点击之前会为空值*/
        int mode_in_sp = SharedPreferenceUtils.getInt(getApplicationContext(), "mode", 0);
        if(mode_in_sp==0){
            Log.e("application_onCreate: ", "sp为空值，将默认的主题给sp");
            SharedPreferenceUtils.putInt(getApplicationContext(), "mode",dayMode);
            return;
        }else if(mode_in_sp== dayMode){
            Log.e("application_onCreate: ", "sp为day");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else if(mode_in_sp== nightMode){
            Log.e("application_onCreate: ", "sp为night");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }


}
