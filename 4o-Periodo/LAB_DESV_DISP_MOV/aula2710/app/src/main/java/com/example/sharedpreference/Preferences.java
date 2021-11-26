package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    public static final String PREF_ID = "livroandroid";

    public static void setBooelan(Context context, String flag, boolean on) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(flag, on);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getBoolean(flag, true);
    }

    public static void setInteger(Context context, String flag, int valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(flag, valor);
        editor.commit();
    }

    public static int getInteger(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getInt(flag, 0);
    }


}
