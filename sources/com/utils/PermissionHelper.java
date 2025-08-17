package com.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionHelper {
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public static void b(Activity activity, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
                activity.startActivityForResult(intent, i2);
            } catch (Exception unused) {
                if (ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.g(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i2);
                }
            }
        } else if (i3 >= 23 && ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.g(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i2);
        }
    }
}
