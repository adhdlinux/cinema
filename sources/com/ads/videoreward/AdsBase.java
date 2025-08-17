package com.ads.videoreward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.original.tase.Logger;
import com.utils.Utils;

public abstract class AdsBase implements Comparable<AdsBase> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f13548b = false;

    /* renamed from: c  reason: collision with root package name */
    private InitTask f13549c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f13550d = "0";

    /* renamed from: e  reason: collision with root package name */
    protected AdBaseListener f13551e = null;

    public interface AdBaseListener {
        void a(AdsBase adsBase, Boolean bool);

        boolean b(AdsBase adsBase, AdBaseType adBaseType, AdsStatus adsStatus);
    }

    public enum AdBaseType {
        BANNER,
        NATIVE,
        FULLSCREEN,
        RETURN
    }

    public enum AdsStatus {
        NOT_LOAD,
        NOT_SHOW,
        SHOWED,
        COMPLETED,
        CLICKED
    }

    private class InitTask extends AsyncTask<AdsBase, Integer, Boolean> {
        private InitTask() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(AdsBase... adsBaseArr) {
            try {
                adsBaseArr[0].f();
                Logger.b("InitTask", adsBaseArr[0].getClass().getSimpleName());
                return Boolean.TRUE;
            } catch (Exception e2) {
                Logger.b("InitTask", adsBaseArr[0].getClass().getSimpleName() + " : " + e2.getMessage());
                return Boolean.FALSE;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            boolean unused = AdsBase.this.f13548b = bool.booleanValue();
            AdsBase adsBase = AdsBase.this;
            adsBase.f13551e.a(adsBase, bool);
        }
    }

    public enum Tag {
        ADMOB,
        FACEBOOK,
        ADCOLONY,
        VUNGLE,
        UNITY,
        CHARTBOOST,
        HOUSEADS,
        COUNT
    }

    public void b() {
        InitTask initTask = this.f13549c;
        if (initTask == null || initTask.isCancelled()) {
            InitTask initTask2 = new InitTask();
            this.f13549c = initTask2;
            initTask2.execute(new AdsBase[]{this});
        }
    }

    public void c() {
        InitTask initTask = this.f13549c;
        if (initTask != null && !initTask.isCancelled()) {
            this.f13549c.cancel(true);
        }
    }

    /* renamed from: d */
    public int compareTo(AdsBase adsBase) {
        if (Float.valueOf(this.f13550d) == Float.valueOf(adsBase.f13550d)) {
            return 0;
        }
        if (Float.valueOf(this.f13550d).floatValue() > Float.valueOf(adsBase.f13550d).floatValue()) {
            return -1;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public Context e() {
        return Utils.v();
    }

    public void f() {
    }

    public void g(int i2, int i3, Intent intent) {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m(AdBaseListener adBaseListener) {
        this.f13551e = adBaseListener;
    }

    public void n(String str) {
        this.f13550d = str;
    }

    public void o(ViewGroup viewGroup) {
        this.f13551e.b(this, AdBaseType.BANNER, AdsStatus.NOT_SHOW);
    }

    public void p(Activity activity) {
        this.f13551e.b(this, AdBaseType.FULLSCREEN, AdsStatus.NOT_SHOW);
    }

    public void q(FrameLayout frameLayout) {
        this.f13551e.b(this, AdBaseType.NATIVE, AdsStatus.NOT_SHOW);
    }
}
