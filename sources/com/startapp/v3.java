package com.startapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.model.AdPreferences;

public abstract class v3 {

    /* renamed from: a  reason: collision with root package name */
    public Intent f36703a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f36704b;

    /* renamed from: c  reason: collision with root package name */
    public AdInformationObject f36705c = null;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f36706d = new a();

    /* renamed from: e  reason: collision with root package name */
    public String[] f36707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f36708f;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f36709g = {true};

    /* renamed from: h  reason: collision with root package name */
    public String f36710h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f36711i;

    /* renamed from: j  reason: collision with root package name */
    public String[] f36712j;

    /* renamed from: k  reason: collision with root package name */
    public String[] f36713k;

    /* renamed from: l  reason: collision with root package name */
    public Ad f36714l;

    /* renamed from: m  reason: collision with root package name */
    public String f36715m;

    /* renamed from: n  reason: collision with root package name */
    public AdPreferences.Placement f36716n;

    /* renamed from: o  reason: collision with root package name */
    public AdInformationOverrides f36717o;

    /* renamed from: p  reason: collision with root package name */
    public String f36718p;

    /* renamed from: q  reason: collision with root package name */
    public Long f36719q;

    /* renamed from: r  reason: collision with root package name */
    public Boolean[] f36720r = null;

    /* renamed from: s  reason: collision with root package name */
    public int f36721s = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f36722t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f36723u = false;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            v3.this.b();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            v3.this.f36704b.finish();
        }
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(Bundle bundle);

    public boolean a(int i2) {
        boolean[] zArr = this.f36709g;
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return true;
        }
        return zArr[i2];
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    public void b() {
        this.f36704b.runOnUiThread(new b());
    }

    public void b(Bundle bundle) {
    }

    public boolean c() {
        return false;
    }

    public void d() {
        if (this.f36706d != null) {
            wb.a((Context) this.f36704b).a(this.f36706d);
        }
        this.f36706d = null;
    }

    public abstract void e();

    public abstract void f();

    public void g() {
    }

    public void h() {
        wb.a((Context) this.f36704b).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
    }

    public String a() {
        try {
            String[] strArr = this.f36711i;
            if (strArr == null || strArr.length <= 0) {
                return "";
            }
            return o6.a(strArr[0], (String) null);
        } catch (Throwable th) {
            y8.a((Context) this.f36704b, th);
            return "";
        }
    }

    public void a(String str) {
        String str2;
        if (str == null || (str2 = this.f36718p) == null || str2.length() <= 0) {
            this.f36715m = str;
        } else {
            this.f36715m = str.replaceAll("startapp_adtag_placeholder", this.f36718p);
        }
    }
}
