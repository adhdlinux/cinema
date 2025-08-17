package com.ads.videoreward;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ads.videoreward.AdsBase;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.AppConfig;
import com.original.tase.Logger;
import com.original.tase.utils.DeviceUtils;
import com.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import timber.log.Timber;

public class AdsManager implements AdsBase.AdBaseListener {

    /* renamed from: l  reason: collision with root package name */
    private static AdsManager f13573l;

    /* renamed from: a  reason: collision with root package name */
    private boolean f13574a = false;

    /* renamed from: b  reason: collision with root package name */
    private List<AdsBase> f13575b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<AdsBase> f13576c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f13577d = false;

    /* renamed from: e  reason: collision with root package name */
    long f13578e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f13579f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f13580g = 0;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f13581h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f13582i = 0;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f13583j = null;

    /* renamed from: k  reason: collision with root package name */
    private int f13584k = 0;

    /* renamed from: com.ads.videoreward.AdsManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13585a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ads.videoreward.AdsBase$AdBaseType[] r0 = com.ads.videoreward.AdsBase.AdBaseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13585a = r0
                com.ads.videoreward.AdsBase$AdBaseType r1 = com.ads.videoreward.AdsBase.AdBaseType.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13585a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ads.videoreward.AdsBase$AdBaseType r1 = com.ads.videoreward.AdsBase.AdBaseType.FULLSCREEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13585a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ads.videoreward.AdsBase$AdBaseType r1 = com.ads.videoreward.AdsBase.AdBaseType.NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13585a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ads.videoreward.AdsBase$AdBaseType r1 = com.ads.videoreward.AdsBase.AdBaseType.RETURN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ads.videoreward.AdsManager.AnonymousClass1.<clinit>():void");
        }
    }

    public static AdsManager d() {
        if (f13573l == null) {
            f13573l = new AdsManager();
        }
        return f13573l;
    }

    private void g(boolean z2) {
        if (GlobalVariable.c().b().getAds() != null) {
            GlobalVariable.c().b().getAds().getAdmob();
            GlobalVariable.c().b().getAds().getFacebookAds();
            AppConfig.AdsBean.StartAppBean startApp = GlobalVariable.c().b().getAds().getStartApp();
            AppConfig.AdsBean.HouseAdsBean house_ads = GlobalVariable.c().b().getAds().getHouse_ads();
            AppConfig.AdsBean.ApplovinBean applovin = GlobalVariable.c().b().getAds().getApplovin();
            GlobalVariable.c().b().getAds().getIronsrc();
            boolean b2 = DeviceUtils.b();
            if (!z2 && startApp != null && startApp.isEnable()) {
                this.f13576c.add(new StartApp());
            }
            if (!b2 && house_ads != null && house_ads.isEnable()) {
                this.f13576c.add(new HouseAds());
            }
            if (applovin != null && applovin.isEnable()) {
                this.f13576c.add(new ApplovinAds());
            }
        }
    }

    private void h(boolean z2) {
        if (GlobalVariable.c().b().getAds() == null || z2) {
            return;
        }
        if (!DeviceUtils.b()) {
            AppConfig.AdsBean.VungleBean vungle = GlobalVariable.c().b().getAds().getVungle();
            if (vungle != null && vungle.isEnable()) {
                this.f13576c.add(new MyVungleAds());
            }
            AppConfig.AdsBean.ChartBoostBean chartBoost = GlobalVariable.c().b().getAds().getChartBoost();
            if (chartBoost != null && chartBoost.isEnable()) {
                this.f13576c.add(new ChartboostAds());
            }
            AppConfig.AdsBean.UnityAdsBean unity_ads = GlobalVariable.c().b().getAds().getUnity_ads();
            if (unity_ads != null && unity_ads.isEnable()) {
                this.f13576c.add(new Unity_Ads());
                return;
            }
            return;
        }
        AppConfig.AdsBean.VungleBean vungle_amz = GlobalVariable.c().b().getAds().getVungle_amz();
        if (vungle_amz != null && vungle_amz.isEnable()) {
            this.f13576c.add(new MyVungleAds());
        }
        AppConfig.AdsBean.ChartBoostBean chartBoost_amz = GlobalVariable.c().b().getAds().getChartBoost_amz();
        if (chartBoost_amz != null && chartBoost_amz.isEnable()) {
            this.f13576c.add(new ChartboostAds());
        }
        AppConfig.AdsBean.UnityAdsBean unity_ads_amz = GlobalVariable.c().b().getAds().getUnity_ads_amz();
        if (unity_ads_amz != null && unity_ads_amz.isEnable()) {
            this.f13576c.add(new Unity_Ads());
        }
    }

    public void a(AdsBase adsBase, Boolean bool) {
        if (bool.booleanValue()) {
            this.f13575b.add(adsBase);
            Collections.sort(this.f13575b);
            this.f13582i = 0;
            this.f13580g = 0;
            this.f13579f = 0;
        } else if (this.f13575b.contains(adsBase)) {
            this.f13575b.remove(adsBase);
        }
    }

    public boolean b(AdsBase adsBase, AdsBase.AdBaseType adBaseType, AdsBase.AdsStatus adsStatus) {
        Timber.f("%s type =%s status=%s", adsBase.getClass().getName(), adBaseType.name(), adsStatus.name());
        if (adsStatus == AdsBase.AdsStatus.NOT_SHOW) {
            int i2 = AnonymousClass1.f13585a[adBaseType.ordinal()];
            if (i2 == 1) {
                int i3 = this.f13580g + 1;
                this.f13580g = i3;
                if (this.f13581h == null || i3 >= this.f13575b.size()) {
                    this.f13580g = 0;
                } else {
                    o(this.f13581h);
                }
            } else if (i2 == 2) {
                int i4 = this.f13579f + 1;
                this.f13579f = i4;
                if (i4 < this.f13575b.size()) {
                    q();
                } else {
                    Timber.f("All ads didn't show", new Object[0]);
                    this.f13579f = 0;
                }
            } else if (i2 == 3) {
                int i5 = this.f13582i + 1;
                this.f13582i = i5;
                if (this.f13583j == null || i5 >= this.f13575b.size()) {
                    this.f13582i = 0;
                } else {
                    r(this.f13583j);
                }
            }
        } else {
            int i6 = AnonymousClass1.f13585a[adBaseType.ordinal()];
            if (i6 == 1) {
                this.f13580g = 0;
            } else if (i6 == 2) {
                this.f13578e = System.currentTimeMillis();
                this.f13579f = 0;
            } else if (i6 == 3) {
                this.f13582i = 0;
            }
        }
        return false;
    }

    public void c() {
        this.f13574a = false;
        for (AdsBase next : this.f13576c) {
            next.c();
            next.h();
        }
        this.f13576c.clear();
        for (AdsBase next2 : this.f13575b) {
            next2.c();
            next2.h();
        }
        this.f13575b.clear();
        ViewGroup viewGroup = this.f13581h;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    public List<AdsBase> e() {
        return this.f13575b;
    }

    public void f() {
        boolean j2 = Utils.j();
        if (GlobalVariable.c().b().getAds() != null) {
            this.f13577d = FreeMoviesApp.s();
            if (!this.f13574a) {
                this.f13576c.clear();
                h(j2);
                g(j2);
                for (AdsBase next : this.f13576c) {
                    next.m(this);
                    next.b();
                }
                this.f13574a = true;
                return;
            }
            return;
        }
        this.f13574a = false;
    }

    public void i(int i2, int i3, Intent intent) {
        for (AdsBase g2 : this.f13575b) {
            g2.g(i2, i3, intent);
        }
    }

    public void j() {
        this.f13583j = null;
        this.f13581h = null;
        for (AdsBase h2 : this.f13575b) {
            h2.h();
        }
    }

    public void k() {
        for (AdsBase i2 : this.f13575b) {
            i2.i();
        }
    }

    public void l() {
        for (AdsBase j2 : this.f13575b) {
            j2.j();
        }
    }

    public void m() {
        for (AdsBase k2 : this.f13575b) {
            k2.k();
        }
    }

    public void n() {
        for (AdsBase l2 : this.f13575b) {
            l2.l();
        }
    }

    public void o(ViewGroup viewGroup) {
        if (GlobalVariable.c().b().getAds() != null) {
            this.f13581h = viewGroup;
            if (!this.f13575b.isEmpty()) {
                AdsBase adsBase = this.f13575b.get(this.f13580g);
                Logger.b("AdsManager", "try to show BANNER " + adsBase.getClass().getName());
                adsBase.o(viewGroup);
            }
        }
    }

    public void p(Activity activity) {
        if (GlobalVariable.c().b().getAds() != null && activity != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f13578e;
            if (this.f13575b.isEmpty() || currentTimeMillis < GlobalVariable.c().b().getAds().getLimitAdsTime()) {
                Timber.f("You can't show app many times within %s", Long.valueOf(GlobalVariable.c().b().getAds().getLimitAdsTime()));
                Timber.f("deltaTime= %s", Long.valueOf(currentTimeMillis));
                return;
            }
            AdsBase adsBase = this.f13575b.get(this.f13579f);
            Timber.f("Try to show full screen with ads %s", adsBase.getClass().getName());
            adsBase.p(activity);
        }
    }

    public void q() {
        if (GlobalVariable.c().b().getAds() != null && Utils.A() != null && !this.f13575b.isEmpty()) {
            AdsBase adsBase = this.f13575b.get(this.f13579f);
            Logger.b("AdsManager", "showFullScreenFallback " + adsBase.getClass().getName());
            adsBase.p(Utils.A());
        }
    }

    public void r(FrameLayout frameLayout) {
        if (GlobalVariable.c().b().getAds() != null) {
            this.f13583j = frameLayout;
            if (!this.f13577d && !this.f13575b.isEmpty()) {
                AdsBase adsBase = this.f13575b.get(this.f13582i);
                adsBase.q(this.f13583j);
                Logger.b("AdsManager", "try to show NATIVE " + adsBase.getClass().getName());
            }
        }
    }
}
