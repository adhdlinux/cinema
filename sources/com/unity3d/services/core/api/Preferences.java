package com.unity3d.services.core.api;

import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.preferences.PreferencesError;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Preferences {
    @WebViewExposed
    public static void getBoolean(String str, String str2, WebViewCallback webViewCallback) {
        Boolean bool = AndroidPreferences.getBoolean(str, str2);
        if (bool != null) {
            webViewCallback.invoke(bool);
            return;
        }
        webViewCallback.error(PreferencesError.COULDNT_GET_VALUE, str, str2);
    }

    @WebViewExposed
    public static void getFloat(String str, String str2, WebViewCallback webViewCallback) {
        Float f2 = AndroidPreferences.getFloat(str, str2);
        if (f2 != null) {
            webViewCallback.invoke(f2);
            return;
        }
        webViewCallback.error(PreferencesError.COULDNT_GET_VALUE, str, str2);
    }

    @WebViewExposed
    public static void getInt(String str, String str2, WebViewCallback webViewCallback) {
        Integer integer = AndroidPreferences.getInteger(str, str2);
        if (integer != null) {
            webViewCallback.invoke(integer);
            return;
        }
        webViewCallback.error(PreferencesError.COULDNT_GET_VALUE, str, str2);
    }

    @WebViewExposed
    public static void getLong(String str, String str2, WebViewCallback webViewCallback) {
        Long l2 = AndroidPreferences.getLong(str, str2);
        if (l2 != null) {
            webViewCallback.invoke(l2);
            return;
        }
        webViewCallback.error(PreferencesError.COULDNT_GET_VALUE, str, str2);
    }

    @WebViewExposed
    public static void getString(String str, String str2, WebViewCallback webViewCallback) {
        String string = AndroidPreferences.getString(str, str2);
        if (string != null) {
            webViewCallback.invoke(string);
            return;
        }
        webViewCallback.error(PreferencesError.COULDNT_GET_VALUE, str, str2);
    }

    @WebViewExposed
    public static void hasKey(String str, String str2, WebViewCallback webViewCallback) {
        webViewCallback.invoke(Boolean.valueOf(AndroidPreferences.hasKey(str, str2)));
    }

    @WebViewExposed
    public static void removeKey(String str, String str2, WebViewCallback webViewCallback) {
        AndroidPreferences.removeKey(str, str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setBoolean(String str, String str2, Boolean bool, WebViewCallback webViewCallback) {
        AndroidPreferences.setBoolean(str, str2, bool);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setFloat(String str, String str2, Double d2, WebViewCallback webViewCallback) {
        AndroidPreferences.setFloat(str, str2, d2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setInt(String str, String str2, Integer num, WebViewCallback webViewCallback) {
        AndroidPreferences.setInteger(str, str2, num);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setLong(String str, String str2, Long l2, WebViewCallback webViewCallback) {
        AndroidPreferences.setLong(str, str2, l2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setString(String str, String str2, String str3, WebViewCallback webViewCallback) {
        AndroidPreferences.setString(str, str2, str3);
        webViewCallback.invoke(new Object[0]);
    }
}
