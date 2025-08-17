package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.util.Map;

public final class ja implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f34762a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34763b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f34764c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f34765d;

    public ja(String str, String str2, Bitmap bitmap, Context context) {
        this.f34762a = str;
        this.f34763b = str2;
        this.f34764c = bitmap;
        this.f34765d = context;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        Throwable th;
        Map<String, Bitmap> map = ka.f34839a;
        map.put(this.f34762a + this.f34763b, this.f34764c);
        try {
            fileOutputStream = new FileOutputStream(this.f34765d.getFilesDir().getPath() + "/" + this.f34762a + this.f34763b);
            try {
                this.f34764c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            try {
                y8.a(this.f34765d, th);
                lb.a((Closeable) fileOutputStream);
            } catch (Throwable th4) {
                lb.a((Closeable) fileOutputStream);
                throw th4;
            }
        }
        lb.a((Closeable) fileOutputStream);
    }
}
