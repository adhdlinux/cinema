package com.facebook.ads.internal.q.a;

import android.os.Handler;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Handler f20620a;

    /* renamed from: b  reason: collision with root package name */
    private final a f20621b;

    /* renamed from: c  reason: collision with root package name */
    private int f20622c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20623d;

    public interface a {
        void a();

        void a(int i2);
    }

    public f(int i2, a aVar) {
        this(i2, aVar, new Handler());
    }

    f(int i2, a aVar, Handler handler) {
        this.f20623d = false;
        this.f20622c = i2;
        this.f20621b = aVar;
        this.f20620a = handler;
    }

    /* access modifiers changed from: private */
    public void e() {
        int i2 = this.f20622c - 1;
        this.f20622c = i2;
        this.f20621b.a(i2);
        if (this.f20622c == 0) {
            this.f20621b.a();
            this.f20623d = false;
        }
    }

    public boolean a() {
        if (this.f20622c <= 0 || c()) {
            return false;
        }
        this.f20623d = true;
        this.f20621b.a(this.f20622c);
        this.f20620a.postDelayed(new Runnable() {
            public void run() {
                if (f.this.c()) {
                    f.this.e();
                    f.this.f20620a.postDelayed(this, 1000);
                }
            }
        }, 1000);
        return true;
    }

    public boolean b() {
        if (!c()) {
            return false;
        }
        this.f20623d = false;
        return true;
    }

    public boolean c() {
        return this.f20623d;
    }

    public boolean d() {
        return this.f20622c <= 0;
    }
}
