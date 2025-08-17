package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.h5;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import java.net.URL;

public class b6 {

    /* renamed from: a  reason: collision with root package name */
    public Context f34238a;

    /* renamed from: b  reason: collision with root package name */
    public URL f34239b;

    /* renamed from: c  reason: collision with root package name */
    public String f34240c;

    /* renamed from: d  reason: collision with root package name */
    public b f34241d;

    /* renamed from: e  reason: collision with root package name */
    public h5.a f34242e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f34243a;

        public a(String str) {
            this.f34243a = str;
        }

        public void run() {
            b bVar = b6.this.f34241d;
            if (bVar != null) {
                bVar.a(this.f34243a);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public b6(Context context, URL url, String str, b bVar, h5.a aVar) {
        this.f34238a = context;
        this.f34239b = url;
        this.f34240c = str;
        this.f34241d = bVar;
        this.f34242e = aVar;
    }

    public void a() {
        String str;
        try {
            if (AdsCommonMetaData.f36186h.G().p()) {
                str = h5.b.f34617a.a(this.f34238a, this.f34239b, this.f34240c, this.f34242e);
            } else {
                str = p.a(this.f34238a, this.f34239b, this.f34240c);
            }
        } catch (Exception unused) {
            str = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(str));
    }
}
