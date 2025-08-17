package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.util.UriUtil;
import com.startapp.ba;
import com.startapp.ca;
import com.startapp.da;
import com.startapp.hc;
import com.startapp.j0;
import com.startapp.ja;
import com.startapp.ka;
import com.startapp.la;
import com.startapp.lb;
import com.startapp.ra;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.consent.ConsentConfig;
import com.startapp.sdk.adsbase.crashreport.ANRRemoteConfig;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.insight.NetworkTestsMetaData;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import com.startapp.x6;
import com.startapp.y8;
import com.startapp.z8;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.joda.time.DateTimeConstants;

public class MetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f36372a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f36373b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f36374c = new HashSet(Arrays.asList(new String[]{Constants.f36416a}));

    /* renamed from: d  reason: collision with root package name */
    public static final List<String> f36375d = Arrays.asList(new String[]{"https://adsmetadata.startappservice.com/adsmetadata/api/v1.0/", "https://adsmetadata.mobileadexchange.net/adsmetadata/api/v1.0/", "https://d26xw8rp6mlgfg.cloudfront.net/adsmetadata/api/v1.0/"});

    /* renamed from: e  reason: collision with root package name */
    public static final String f36376e = "https://req.startappservice.com/1.5/";

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f36377f = {60, 60, 240};

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f36378g = new HashSet(Arrays.asList(new String[]{"com.facebook.katana", "com.yandex.browser"}));

    /* renamed from: h  reason: collision with root package name */
    public static volatile MetaData f36379h = new MetaData();

    /* renamed from: i  reason: collision with root package name */
    public static ba f36380i = null;
    private static final long serialVersionUID = 2196687860909560228L;
    private long IABDisplayImpressionDelayInSeconds;
    private long IABVideoImpressionDelayInSeconds;
    @j0(complex = true)
    private SimpleTokenConfig SimpleToken = new SimpleTokenConfig();
    private boolean SupportIABViewability;
    private String adPlatformBannerHostSecured;
    public String adPlatformHostSecured;
    private String adPlatformNativeHostSecured;
    private String adPlatformOverlayHostSecured;
    private String adPlatformReturnHostSecured;
    private String adPlatformSplashHostSecured;
    @j0(complex = true)
    private AdvertisingIdResolverMetadata air;
    private boolean alwaysSendToken;
    @j0(complex = true)
    public AnalyticsConfig analytics;
    @j0(complex = true)
    private ANRRemoteConfig anrConfig;
    private String assetsBaseUrlSecured;
    @j0(complex = true)
    private BluetoothConfig btConfig;
    private String calcProd;
    private boolean chromeCustomeTabsExternal;
    private boolean chromeCustomeTabsInternal;
    private boolean compressionEnabled;
    @j0(complex = true)
    private ConsentConfig consentDetails;
    private boolean disableSendAdvertisingId;
    private boolean dns;
    private double flh;
    private double ibt;
    private boolean inAppBrowser;
    @j0(type = HashSet.class)
    private Set<String> installersList;
    @j0(type = HashSet.class)
    private Set<Integer> invalidForRetry;
    private boolean isToken1Mandatory;

    /* renamed from: j  reason: collision with root package name */
    public transient boolean f36381j;

    /* renamed from: k  reason: collision with root package name */
    public transient boolean f36382k;

    /* renamed from: l  reason: collision with root package name */
    public transient List<da> f36383l;
    @j0(type = ArrayList.class)
    public List<String> metaDataHosts = f36375d;
    private String metadataUpdateVersion;
    @j0(complex = true)
    private MotionMetadata motion;
    @j0(complex = true)
    private NetworkDiagnosticConfig netDiag;
    @j0(complex = true)
    private NetworkTestsMetaData networkTests;
    private int notVisibleBannerReloadInterval;
    private boolean omSdkEnabled;
    private int[] periodicEventIntMin;
    private int[] periodicForegroundEventSec;
    private boolean periodicInfoEventEnabled;
    private boolean periodicMetaDataEnabled;
    private int periodicMetaDataIntervalInMinutes;
    @j0(type = HashSet.class)
    private Set<String> preInstalledPackages;
    private String profileId;
    @j0(complex = true)
    private RcdMetadata rcd;
    @j0(complex = true)
    private RscMetadata rsc;
    @j0(complex = true)
    private SensorsConfig sensorsConfig;
    private int sessionMaxBackgroundTime;
    private boolean simpleToken2;
    @j0(complex = true)
    private StaleDcConfig staleDc;
    private int stopAutoLoadAmount;
    private int stopAutoLoadPreCacheAmount;
    @j0(complex = true)
    private TelephonyMetadata telephony;
    private String trackDownloadHost;
    @j0(complex = true)
    private TriggeredLinksMetadata triggeredLinks;
    private boolean trueNetEnabled;
    private String vastRecorderHost;
    private boolean webViewSecured;

    public static class a implements la.b {

        /* renamed from: a  reason: collision with root package name */
        public Context f36384a;

        /* renamed from: b  reason: collision with root package name */
        public String f36385b;

        public a(Context context, String str) {
            this.f36384a = context;
            this.f36385b = str;
        }

        public void a(Bitmap bitmap, int i2) {
            if (bitmap != null) {
                Context context = this.f36384a;
                String str = this.f36385b;
                Map<String, Bitmap> map = ka.f34839a;
                ComponentLocator.a(context).h().execute(new ja(str, ".png", bitmap, context));
            }
        }
    }

    public MetaData() {
        String str = f36376e;
        this.adPlatformHostSecured = str;
        this.trackDownloadHost = str;
        this.sessionMaxBackgroundTime = 1800;
        this.profileId = null;
        this.installersList = f36374c;
        this.preInstalledPackages = f36378g;
        this.simpleToken2 = true;
        this.alwaysSendToken = true;
        this.isToken1Mandatory = true;
        this.compressionEnabled = false;
        this.periodicMetaDataEnabled = false;
        this.periodicMetaDataIntervalInMinutes = 360;
        this.periodicInfoEventEnabled = false;
        this.periodicEventIntMin = f36377f;
        this.inAppBrowser = true;
        this.SupportIABViewability = true;
        this.IABDisplayImpressionDelayInSeconds = 1;
        this.IABVideoImpressionDelayInSeconds = 2;
        this.sensorsConfig = new SensorsConfig();
        this.btConfig = new BluetoothConfig();
        this.assetsBaseUrlSecured = "";
        this.invalidForRetry = null;
        this.notVisibleBannerReloadInterval = DateTimeConstants.SECONDS_PER_HOUR;
        this.analytics = new AnalyticsConfig();
        this.f36381j = false;
        this.f36382k = false;
        this.f36383l = new ArrayList();
        this.metadataUpdateVersion = "4.10.0";
        this.dns = false;
        this.stopAutoLoadAmount = 3;
        this.stopAutoLoadPreCacheAmount = 3;
        this.trueNetEnabled = false;
        this.webViewSecured = true;
        this.omSdkEnabled = false;
        this.chromeCustomeTabsInternal = true;
        this.chromeCustomeTabsExternal = true;
        this.disableSendAdvertisingId = false;
        this.ibt = 1.0d;
        this.networkTests = new NetworkTestsMetaData();
        this.staleDc = new StaleDcConfig();
        this.telephony = new TelephonyMetadata();
        this.anrConfig = new ANRRemoteConfig();
    }

    public static void a(MetaData metaData) {
        synchronized (f36372a) {
            metaData.f36383l.addAll(f36379h.f36383l);
            f36379h = metaData;
        }
    }

    public static void c(Context context) {
        if (!f36373b.getAndSet(true)) {
            MetaData metaData = (MetaData) ra.a(context, "StartappMetadata", MetaData.class);
            MetaData metaData2 = new MetaData();
            if (metaData != null) {
                boolean b2 = lb.b(metaData, metaData2);
                if (!(true ^ "4.10.0".equals(metaData.metadataUpdateVersion)) && b2) {
                    y8 y8Var = new y8(z8.f36996c);
                    y8Var.f36954d = "metadata_null";
                    y8Var.a(context);
                }
                metaData.f36381j = false;
                metaData.f36382k = false;
                metaData.f36383l = new ArrayList();
                a(metaData);
            } else {
                a(metaData2);
            }
            f36379h.a();
        }
    }

    public static MetaData r() {
        return f36379h;
    }

    public RcdMetadata A() {
        return this.rcd;
    }

    public RscMetadata B() {
        return this.rsc;
    }

    public SensorsConfig C() {
        return this.sensorsConfig;
    }

    public long D() {
        return TimeUnit.SECONDS.toMillis((long) this.sessionMaxBackgroundTime);
    }

    public SimpleTokenConfig E() {
        return this.SimpleToken;
    }

    public StaleDcConfig F() {
        return this.staleDc;
    }

    public int G() {
        return this.stopAutoLoadAmount;
    }

    public int H() {
        return this.stopAutoLoadPreCacheAmount;
    }

    public TelephonyMetadata I() {
        return this.telephony;
    }

    public String J() {
        String str = this.trackDownloadHost;
        return str != null ? str : c();
    }

    public TriggeredLinksMetadata K() {
        return this.triggeredLinks;
    }

    public String L() {
        return this.vastRecorderHost;
    }

    public boolean M() {
        return this.alwaysSendToken;
    }

    public boolean N() {
        return this.compressionEnabled;
    }

    public boolean O() {
        Map<Activity, Integer> map = lb.f34876a;
        return this.inAppBrowser;
    }

    public boolean P() {
        return this.omSdkEnabled;
    }

    public boolean Q() {
        return this.periodicForegroundEventSec != null;
    }

    public boolean R() {
        return this.periodicInfoEventEnabled;
    }

    public boolean S() {
        return this.periodicMetaDataEnabled;
    }

    public boolean T() {
        return this.SupportIABViewability;
    }

    public boolean U() {
        return this.isToken1Mandatory;
    }

    public int b(Context context) {
        return a(context, this.periodicEventIntMin);
    }

    public AdvertisingIdResolverMetadata d() {
        return this.air;
    }

    public ANRRemoteConfig e() {
        return this.anrConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MetaData.class != obj.getClass()) {
            return false;
        }
        MetaData metaData = (MetaData) obj;
        if (this.sessionMaxBackgroundTime != metaData.sessionMaxBackgroundTime || this.simpleToken2 != metaData.simpleToken2 || this.alwaysSendToken != metaData.alwaysSendToken || this.isToken1Mandatory != metaData.isToken1Mandatory || this.compressionEnabled != metaData.compressionEnabled || this.periodicMetaDataEnabled != metaData.periodicMetaDataEnabled || this.periodicMetaDataIntervalInMinutes != metaData.periodicMetaDataIntervalInMinutes || this.periodicInfoEventEnabled != metaData.periodicInfoEventEnabled || this.inAppBrowser != metaData.inAppBrowser || this.SupportIABViewability != metaData.SupportIABViewability || this.IABDisplayImpressionDelayInSeconds != metaData.IABDisplayImpressionDelayInSeconds || this.IABVideoImpressionDelayInSeconds != metaData.IABVideoImpressionDelayInSeconds || this.notVisibleBannerReloadInterval != metaData.notVisibleBannerReloadInterval || this.dns != metaData.dns || this.stopAutoLoadAmount != metaData.stopAutoLoadAmount || this.stopAutoLoadPreCacheAmount != metaData.stopAutoLoadPreCacheAmount || this.trueNetEnabled != metaData.trueNetEnabled || this.webViewSecured != metaData.webViewSecured || this.omSdkEnabled != metaData.omSdkEnabled || this.chromeCustomeTabsInternal != metaData.chromeCustomeTabsInternal || this.chromeCustomeTabsExternal != metaData.chromeCustomeTabsExternal || this.disableSendAdvertisingId != metaData.disableSendAdvertisingId || Double.compare(this.ibt, metaData.ibt) != 0 || Double.compare(this.flh, metaData.flh) != 0 || !lb.a(this.SimpleToken, metaData.SimpleToken) || !lb.a(this.consentDetails, metaData.consentDetails) || !lb.a(this.calcProd, metaData.calcProd) || !lb.a(this.metaDataHosts, metaData.metaDataHosts) || !lb.a(this.adPlatformHostSecured, metaData.adPlatformHostSecured) || !lb.a(this.trackDownloadHost, metaData.trackDownloadHost) || !lb.a(this.vastRecorderHost, metaData.vastRecorderHost) || !lb.a(this.adPlatformBannerHostSecured, metaData.adPlatformBannerHostSecured) || !lb.a(this.adPlatformSplashHostSecured, metaData.adPlatformSplashHostSecured) || !lb.a(this.adPlatformReturnHostSecured, metaData.adPlatformReturnHostSecured) || !lb.a(this.adPlatformOverlayHostSecured, metaData.adPlatformOverlayHostSecured) || !lb.a(this.adPlatformNativeHostSecured, metaData.adPlatformNativeHostSecured) || !lb.a(this.profileId, metaData.profileId) || !lb.a(this.installersList, metaData.installersList) || !lb.a(this.preInstalledPackages, metaData.preInstalledPackages) || !Arrays.equals(this.periodicEventIntMin, metaData.periodicEventIntMin) || !Arrays.equals(this.periodicForegroundEventSec, metaData.periodicForegroundEventSec) || !lb.a(this.sensorsConfig, metaData.sensorsConfig) || !lb.a(this.btConfig, metaData.btConfig) || !lb.a(this.assetsBaseUrlSecured, metaData.assetsBaseUrlSecured) || !lb.a(this.invalidForRetry, metaData.invalidForRetry) || !lb.a(this.analytics, metaData.analytics) || !lb.a(this.metadataUpdateVersion, metaData.metadataUpdateVersion) || !lb.a(this.networkTests, metaData.networkTests) || !lb.a(this.triggeredLinks, metaData.triggeredLinks) || !lb.a(this.rsc, metaData.rsc) || !lb.a(this.rcd, metaData.rcd) || !lb.a(this.netDiag, metaData.netDiag) || !lb.a(this.staleDc, metaData.staleDc) || !lb.a(this.motion, metaData.motion) || !lb.a(this.air, metaData.air) || !lb.a(this.telephony, metaData.telephony) || !lb.a(this.anrConfig, metaData.anrConfig)) {
            return false;
        }
        return true;
    }

    public String f() {
        String str = this.assetsBaseUrlSecured;
        return str != null ? str : "";
    }

    public BluetoothConfig g() {
        return this.btConfig;
    }

    public String h() {
        return this.calcProd;
    }

    public int hashCode() {
        Object[] objArr = {this.SimpleToken, this.consentDetails, this.calcProd, this.metaDataHosts, this.adPlatformHostSecured, this.trackDownloadHost, this.vastRecorderHost, this.adPlatformBannerHostSecured, this.adPlatformSplashHostSecured, this.adPlatformReturnHostSecured, this.adPlatformOverlayHostSecured, this.adPlatformNativeHostSecured, Integer.valueOf(this.sessionMaxBackgroundTime), this.profileId, this.installersList, this.preInstalledPackages, Boolean.valueOf(this.simpleToken2), Boolean.valueOf(this.alwaysSendToken), Boolean.valueOf(this.isToken1Mandatory), Boolean.valueOf(this.compressionEnabled), Boolean.valueOf(this.periodicMetaDataEnabled), Integer.valueOf(this.periodicMetaDataIntervalInMinutes), Boolean.valueOf(this.periodicInfoEventEnabled), this.periodicEventIntMin, this.periodicForegroundEventSec, Boolean.valueOf(this.inAppBrowser), Boolean.valueOf(this.SupportIABViewability), Long.valueOf(this.IABDisplayImpressionDelayInSeconds), Long.valueOf(this.IABVideoImpressionDelayInSeconds), this.sensorsConfig, this.btConfig, this.assetsBaseUrlSecured, this.invalidForRetry, Integer.valueOf(this.notVisibleBannerReloadInterval), this.analytics, this.metadataUpdateVersion, Boolean.valueOf(this.dns), Integer.valueOf(this.stopAutoLoadAmount), Integer.valueOf(this.stopAutoLoadPreCacheAmount), Boolean.valueOf(this.trueNetEnabled), Boolean.valueOf(this.webViewSecured), Boolean.valueOf(this.omSdkEnabled), Boolean.valueOf(this.chromeCustomeTabsInternal), Boolean.valueOf(this.chromeCustomeTabsExternal), Boolean.valueOf(this.disableSendAdvertisingId), Double.valueOf(this.ibt), Double.valueOf(this.flh), this.networkTests, this.triggeredLinks, this.rsc, this.rcd, this.netDiag, this.staleDc, this.motion, this.air, this.telephony, this.anrConfig};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public boolean i() {
        return this.chromeCustomeTabsExternal;
    }

    public boolean j() {
        return this.chromeCustomeTabsInternal;
    }

    public ConsentConfig k() {
        return this.consentDetails;
    }

    public boolean l() {
        return this.disableSendAdvertisingId;
    }

    public String m() {
        String str;
        int indexOf;
        String c2 = f36379h.c();
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = this.webViewSecured;
        if (i2 > 26 || z2) {
            str = UriUtil.HTTPS_SCHEME;
        } else {
            str = UriUtil.HTTP_SCHEME;
        }
        if (c2.startsWith(str + "://") || (indexOf = c2.indexOf(58)) == -1) {
            return c2;
        }
        return str + c2.substring(indexOf);
    }

    public long n() {
        return this.IABDisplayImpressionDelayInSeconds;
    }

    public long o() {
        return this.IABVideoImpressionDelayInSeconds;
    }

    public double p() {
        return this.ibt;
    }

    public Set<String> q() {
        return this.installersList;
    }

    public Set<Integer> s() {
        return this.invalidForRetry;
    }

    public MotionMetadata t() {
        return this.motion;
    }

    public NetworkDiagnosticConfig u() {
        return this.netDiag;
    }

    public NetworkTestsMetaData v() {
        return this.networkTests;
    }

    public int w() {
        return this.notVisibleBannerReloadInterval;
    }

    public int x() {
        return this.periodicMetaDataIntervalInMinutes;
    }

    public Set<String> y() {
        Set<String> set = this.preInstalledPackages;
        if (set == null) {
            set = f36378g;
        }
        return Collections.unmodifiableSet(set);
    }

    public String z() {
        return this.profileId;
    }

    public boolean b() {
        return !this.dns;
    }

    public static void a(Context context, MetaData metaData, MetaDataRequest.RequestReason requestReason, boolean z2) {
        ArrayList arrayList;
        boolean z3;
        Handler handler;
        synchronized (f36372a) {
            arrayList = new ArrayList(f36379h.f36383l);
            f36379h.f36383l.clear();
            metaData.f36383l = f36379h.f36383l;
            metaData.a();
            metaData.metadataUpdateVersion = "4.10.0";
            ra.b(context, "StartappMetadata", metaData);
            z3 = false;
            metaData.f36381j = false;
            metaData.f36382k = true;
            if (!lb.a(f36379h, metaData)) {
                z2 = true;
            }
            f36379h = metaData;
            if (lb.e(context)) {
                try {
                    x6 d2 = ComponentLocator.a(context).d();
                    int i2 = d2.getInt("totalSessions", 0);
                    x6.a a2 = d2.edit();
                    int i3 = i2 + 1;
                    a2.a("totalSessions", Integer.valueOf(i3));
                    a2.f36915a.putInt("totalSessions", i3);
                    a2.apply();
                } catch (Throwable th) {
                    y8.a(context, th);
                }
            }
            handler = null;
            f36380i = null;
        }
        if (Math.random() < f36379h.flh) {
            z3 = true;
        }
        if (z3) {
            handler = new Handler(Looper.getMainLooper());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            da daVar = (da) it2.next();
            if (z3) {
                handler.post(new ca(daVar, requestReason, z2));
            } else {
                daVar.a(requestReason, z2);
            }
        }
    }

    public String c() {
        String str = this.adPlatformHostSecured;
        return str != null ? str : f36376e;
    }

    public static void a(MetaDataRequest.RequestReason requestReason) {
        ArrayList arrayList;
        synchronized (f36372a) {
            arrayList = new ArrayList(f36379h.f36383l);
            f36379h.f36383l.clear();
            f36379h.f36381j = false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((da) it2.next()).a(requestReason);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r7 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r8 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r8.a(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4, com.startapp.sdk.adsbase.model.AdPreferences r5, com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest.RequestReason r6, boolean r7, com.startapp.da r8, boolean r9) {
        /*
            r3 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0008
            if (r8 == 0) goto L_0x0008
            r8.a(r6, r0)
        L_0x0008:
            java.lang.Object r1 = f36372a
            monitor-enter(r1)
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = f36379h     // Catch:{ all -> 0x0052 }
            boolean r2 = r2.f36382k     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x001d
            if (r9 == 0) goto L_0x0014
            goto L_0x001d
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            if (r7 == 0) goto L_0x001c
            if (r8 == 0) goto L_0x001c
            r8.a(r6, r0)
        L_0x001c:
            return
        L_0x001d:
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = f36379h     // Catch:{ all -> 0x0052 }
            boolean r2 = r2.f36381j     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x0025
            if (r9 == 0) goto L_0x0047
        L_0x0025:
            r9 = 1
            r3.f36381j = r9     // Catch:{ all -> 0x0052 }
            r3.f36382k = r0     // Catch:{ all -> 0x0052 }
            com.startapp.ba r0 = f36380i     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0030
            r0.f34258j = r9     // Catch:{ all -> 0x0052 }
        L_0x0030:
            com.startapp.ba r9 = new com.startapp.ba     // Catch:{ all -> 0x0052 }
            r9.<init>(r4, r5, r6)     // Catch:{ all -> 0x0052 }
            f36380i = r9     // Catch:{ all -> 0x0052 }
            com.startapp.sdk.components.ComponentLocator r4 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r4)     // Catch:{ all -> 0x0052 }
            java.util.concurrent.Executor r5 = r4.o()     // Catch:{ all -> 0x0052 }
            com.startapp.aa r6 = new com.startapp.aa     // Catch:{ all -> 0x0052 }
            r6.<init>(r9, r4)     // Catch:{ all -> 0x0052 }
            r5.execute(r6)     // Catch:{ all -> 0x0052 }
        L_0x0047:
            if (r7 == 0) goto L_0x0050
            if (r8 == 0) goto L_0x0050
            com.startapp.sdk.adsbase.remoteconfig.MetaData r4 = f36379h     // Catch:{ all -> 0x0052 }
            r4.a((com.startapp.da) r8)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            return
        L_0x0052:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0052 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.remoteconfig.MetaData.a(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences, com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest$RequestReason, boolean, com.startapp.da, boolean):void");
    }

    public void a(da daVar) {
        synchronized (f36372a) {
            this.f36383l.add(daVar);
        }
    }

    public int a(Context context) {
        return a(context, this.periodicForegroundEventSec);
    }

    public static int a(Context context, int[] iArr) {
        if (iArr == null || iArr.length < 3) {
            iArr = f36377f;
        }
        if (hc.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            int i2 = iArr[0];
            if (i2 <= 0) {
                return f36377f[0];
            }
            return i2;
        } else if (!hc.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return iArr[2];
        } else {
            int i3 = iArr[1];
            if (i3 <= 0) {
                return f36377f[1];
            }
            return i3;
        }
    }

    public String a(AdPreferences.Placement placement) {
        int ordinal = placement.ordinal();
        if (ordinal == 1) {
            String str = this.adPlatformBannerHostSecured;
            return str != null ? str : c();
        } else if (ordinal == 7) {
            String str2 = this.adPlatformReturnHostSecured;
            return str2 != null ? str2 : c();
        } else if (ordinal == 3) {
            String str3 = this.adPlatformSplashHostSecured;
            return str3 != null ? str3 : c();
        } else if (ordinal == 4) {
            String str4 = this.adPlatformOverlayHostSecured;
            return str4 != null ? str4 : c();
        } else if (ordinal != 5) {
            return c();
        } else {
            String str5 = this.adPlatformNativeHostSecured;
            return str5 != null ? str5 : c();
        }
    }

    public void a() {
        ArrayList arrayList;
        this.adPlatformHostSecured = a(this.adPlatformHostSecured, f36376e);
        List<String> list = this.metaDataHosts;
        if (list != null) {
            arrayList = new ArrayList(list.size());
            for (String a2 : list) {
                String a3 = a(a2, (String) null);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
        } else {
            arrayList = null;
        }
        this.metaDataHosts = arrayList;
        this.adPlatformBannerHostSecured = a(this.adPlatformBannerHostSecured, (String) null);
        this.adPlatformSplashHostSecured = a(this.adPlatformSplashHostSecured, (String) null);
        this.adPlatformReturnHostSecured = a(this.adPlatformReturnHostSecured, (String) null);
        this.adPlatformOverlayHostSecured = a(this.adPlatformOverlayHostSecured, (String) null);
        this.adPlatformNativeHostSecured = a(this.adPlatformNativeHostSecured, (String) null);
    }

    public final String a(String str, String str2) {
        return str != null ? str.replace("%AdPlatformProtocol%", "1.5") : str2;
    }

    public static void a(Context context, String str) {
        if (str != null && !str.equals("")) {
            if (!ka.a(context, "close_button", ".png")) {
                Map<Activity, Integer> map = lb.f34876a;
                new la(context, str + "close_button" + ".png", new a(context, "close_button"), 0).a();
            }
            Map<Activity, Integer> map2 = lb.f34876a;
            for (String str2 : AdsConstants.f36195i) {
                if (!ka.a(context, str2, ".png")) {
                    new la(context, str + str2 + ".png", new a(context, str2), 0).a();
                }
            }
            Map<Activity, Integer> map3 = lb.f34876a;
            for (String str3 : AdsConstants.f36196j) {
                if (!ka.a(context, str3, ".png")) {
                    new la(context, str + str3 + ".png", new a(context, str3), 0).a();
                }
            }
            if (!ka.a(context, "logo", ".png")) {
                new la(context, str + "logo" + ".png", new a(context, "logo"), 0).a();
            }
        }
    }
}
