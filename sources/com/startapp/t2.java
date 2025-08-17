package com.startapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import com.startapp.networkTest.enums.AppCategoryTypes;

public class t2 {

    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f36565a;

        public a(Activity activity) {
            this.f36565a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            t2.c(this.f36565a);
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f36566a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f36567b;

        public b(boolean z2, Activity activity) {
            this.f36566a = z2;
            this.f36567b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f36566a) {
                this.f36567b.finish();
            }
        }
    }

    public static boolean a(Context context) {
        return new Intent("android.settings.USAGE_ACCESS_SETTINGS").resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean b(Context context) {
        if (((AppOpsManager) context.getApplicationContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getApplicationContext().getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        try {
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            intent.setFlags(411074560);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            l2.a(th);
            return false;
        }
    }

    public static boolean a(Activity activity, int i2, int i3, int i4, int i5, boolean z2) {
        if (!a((Context) activity)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(i2);
        builder.setCancelable(false);
        builder.setMessage(i3);
        builder.setPositiveButton(i4, new a(activity));
        builder.setNegativeButton(i5, new b(z2, activity));
        builder.create().show();
        return true;
    }

    public static AppCategoryTypes a(int i2) {
        AppCategoryTypes appCategoryTypes = AppCategoryTypes.Unknown;
        switch (i2) {
            case -1:
                return AppCategoryTypes.Undefined;
            case 0:
                return AppCategoryTypes.Game;
            case 1:
                return AppCategoryTypes.Audio;
            case 2:
                return AppCategoryTypes.Video;
            case 3:
                return AppCategoryTypes.Image;
            case 4:
                return AppCategoryTypes.Social;
            case 5:
                return AppCategoryTypes.News;
            case 6:
                return AppCategoryTypes.Maps;
            case 7:
                return AppCategoryTypes.Productivity;
            default:
                return appCategoryTypes;
        }
    }
}
