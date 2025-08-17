package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.components.ComponentLocator;

public class la {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34869a;

    /* renamed from: b  reason: collision with root package name */
    public String f34870b;

    /* renamed from: c  reason: collision with root package name */
    public b f34871c;

    /* renamed from: d  reason: collision with root package name */
    public int f34872d;

    public class a implements Runnable {

        /* renamed from: com.startapp.la$a$a  reason: collision with other inner class name */
        public class C0053a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bitmap f34874a;

            public C0053a(Bitmap bitmap) {
                this.f34874a = bitmap;
            }

            public void run() {
                la laVar = la.this;
                b bVar = laVar.f34871c;
                if (bVar != null) {
                    bVar.a(this.f34874a, laVar.f34872d);
                }
            }
        }

        public a() {
        }

        public void run() {
            new Handler(Looper.getMainLooper()).post(new C0053a(ma.b(la.this.f34870b)));
        }
    }

    public interface b {
        void a(Bitmap bitmap, int i2);
    }

    public la(Context context, String str, b bVar, int i2) {
        this.f34869a = context;
        this.f34870b = str;
        this.f34871c = bVar;
        this.f34872d = i2;
    }

    public void a() {
        ComponentLocator.a(this.f34869a).B.b().execute(new a());
    }
}
