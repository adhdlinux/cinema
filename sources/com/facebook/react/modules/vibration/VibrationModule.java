package com.facebook.react.modules.vibration;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.facebook.fbreact.specs.NativeVibrationSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@SuppressLint({"MissingPermission"})
@ReactModule(name = "Vibration")
public class VibrationModule extends NativeVibrationSpec {
    public static final String NAME = "Vibration";

    public VibrationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void cancel() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    public String getName() {
        return NAME;
    }

    public void vibrate(double d2) {
        int i2 = (int) d2;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot((long) i2, -1));
            } else {
                vibrator.vibrate((long) i2);
            }
        }
    }

    public void vibrateByPattern(ReadableArray readableArray, double d2) {
        int i2 = (int) d2;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            long[] jArr = new long[readableArray.size()];
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                jArr[i3] = (long) readableArray.getInt(i3);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createWaveform(jArr, i2));
            } else {
                vibrator.vibrate(jArr, i2);
            }
        }
    }
}
