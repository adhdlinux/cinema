package com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.yoku.marumovie.R;
import java.util.regex.Pattern;

public class FilenameUtils {
    public static String a(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return b(str, Pattern.compile(defaultSharedPreferences.getString(context.getString(R.string.settings_file_charset_key), context.getString(R.string.default_file_charset_value))), defaultSharedPreferences.getString(context.getString(R.string.settings_file_replacement_character_key), "_"));
    }

    private static String b(String str, Pattern pattern, String str2) {
        return str.replaceAll(pattern.pattern(), str2);
    }
}
