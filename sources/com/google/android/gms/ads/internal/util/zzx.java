package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import java.util.Locale;

@TargetApi(28)
public class zzx extends zzv {
    static final /* synthetic */ WindowInsets zzm(Activity activity, View view, WindowInsets windowInsets) {
        if (zzt.zzo().zzh().zzm() == null) {
            DisplayCutout a2 = windowInsets.getDisplayCutout();
            String str = "";
            if (a2 != null) {
                zzg zzh = zzt.zzo().zzh();
                for (Rect rect : a2.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = str.concat("|");
                    }
                    str = str.concat(String.valueOf(format));
                }
                zzh.zzC(str);
            } else {
                zzt.zzo().zzh().zzC(str);
            }
        }
        zzp(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void zzp(boolean z2, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a2 = attributes.layoutInDisplayCutoutMode;
        int i2 = 1;
        if (true != z2) {
            i2 = 2;
        }
        if (i2 != a2) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    public final int zzk(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }

    public final void zzl(Activity activity) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbc)).booleanValue() && zzt.zzo().zzh().zzm() == null && !activity.isInMultiWindowMode()) {
            zzp(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzw(this, activity));
        }
    }
}
