package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public abstract class v9 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36734a;

    /* renamed from: b  reason: collision with root package name */
    public final xb f36735b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f36736c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36737d = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v9.this.a();
        }
    }

    public class b implements xb {

        /* renamed from: a  reason: collision with root package name */
        public boolean f36739a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ xb f36740b;

        public b(xb xbVar) {
            this.f36740b = xbVar;
        }

        public synchronized void a(Object obj) {
            if (!this.f36739a) {
                this.f36739a = true;
                v9.this.f36736c.removeCallbacksAndMessages((Object) null);
                this.f36740b.a(obj);
            }
        }
    }

    public v9(Context context, xb xbVar) {
        this.f36734a = context;
        this.f36735b = new b(xbVar);
        this.f36736c = new Handler(Looper.getMainLooper());
    }

    public abstract void a();
}
