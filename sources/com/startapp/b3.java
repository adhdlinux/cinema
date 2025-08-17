package com.startapp;

import android.content.Context;

public class b3 {
    public static boolean a(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_CALL_LOG") == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        return false;
    }
}
