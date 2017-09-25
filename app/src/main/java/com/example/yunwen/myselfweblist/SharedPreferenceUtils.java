package com.example.yunwen.myselfweblist;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 孟晨 on 2017/9/25.
 */

public class SharedPreferenceUtils {

    /**
     * 保存在手机里的SP文件名
     */
    public static final String FILE_NAME = "sp_utils";

    /**
     * 保存数据
     */
    public static void putInt(Context context, String key, int obj) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, (Integer) obj);
        editor.commit();
    }


    /**
     * 获取指定数据
     */
    public static Integer getInt(Context context, String key, int defaultObj) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
            return sp.getInt(key,defaultObj);
    }
}
