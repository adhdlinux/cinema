package com.startapp;

import android.graphics.Bitmap;
import com.startapp.la;
import com.startapp.sdk.adsbase.adinformation.ImageResourceConfig;

public class i7 implements la.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageResourceConfig f34687a;

    public i7(ImageResourceConfig imageResourceConfig) {
        this.f34687a = imageResourceConfig;
    }

    public void a(Bitmap bitmap, int i2) {
        ImageResourceConfig imageResourceConfig = this.f34687a;
        imageResourceConfig.f36279a = bitmap;
        if (bitmap != null) {
            imageResourceConfig.f36281c = bitmap;
        }
    }
}
