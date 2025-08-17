package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.hermes.intl.Constants;
import com.startapp.d8;
import com.startapp.lb;
import com.startapp.ne;
import com.startapp.p;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.y8;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public abstract class HtmlAd extends Ad {

    /* renamed from: c  reason: collision with root package name */
    public static String f36200c = null;
    private static final long serialVersionUID = 1;
    private List<AppPresenceDetails> apps;
    private String[] closingUrl = {""};
    private Long delayImpressionInSeconds;
    private int height;
    private String htmlUuid = "";
    public boolean[] inAppBrowserEnabled = {true};
    private boolean isMraidAd = false;
    private int orientation = 0;
    private String[] packageNames = {""};
    private int rewardDuration = 0;
    private boolean rewardedHideTimer = false;
    private Boolean[] sendRedirectHops = null;
    public boolean[] smartRedirect = {false};
    private String[] trackingClickUrls = {""};
    public String[] trackingUrls = {""};
    private int width;

    public HtmlAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
        if (f36200c == null) {
            q();
        }
    }

    public void a(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public void b(String str) {
        Long l2 = null;
        for (String str2 : str.split(",")) {
            if (!str2.equals("")) {
                try {
                    long parseLong = Long.parseLong(str2);
                    if (parseLong > 0 && (l2 == null || parseLong < l2.longValue())) {
                        l2 = Long.valueOf(parseLong);
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (l2 != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l2.longValue()));
        }
    }

    public void c(String str) {
        if (Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\'])mraid\\.js\\1[^>]*>\\s*</script>\\n*", 2).matcher(new StringBuffer(str)).find()) {
            this.isMraidAd = true;
        }
        if (MetaData.f36379h.P()) {
            try {
                str = p.b(ne.a(), str);
            } catch (Throwable th) {
                y8.a(this.f36173b, th);
            }
        }
        Map<Activity, Integer> map = lb.f34876a;
        d8 d8Var = d8.f34354a;
        d8Var.getClass();
        String uuid = UUID.randomUUID().toString();
        d8Var.f34356c.put(uuid, str);
        this.htmlUuid = uuid;
        String a2 = lb.a(str, "@smartRedirect@", "@smartRedirect@");
        if (a2 != null) {
            String[] split = a2.split(",");
            this.smartRedirect = new boolean[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                if (split[i2].compareTo("true") == 0) {
                    this.smartRedirect[i2] = true;
                } else {
                    this.smartRedirect[i2] = false;
                }
            }
        }
        String a3 = lb.a(str, "@trackingClickUrl@", "@trackingClickUrl@");
        if (a3 != null) {
            this.trackingClickUrls = a3.split(",");
        }
        String a4 = lb.a(str, "@closeUrl@", "@closeUrl@");
        if (a4 != null) {
            this.closingUrl = a4.split(",");
        }
        String a5 = lb.a(str, "@tracking@", "@tracking@");
        if (a5 != null) {
            this.trackingUrls = a5.split(",");
        }
        String a6 = lb.a(str, "@packageName@", "@packageName@");
        if (a6 != null) {
            this.packageNames = a6.split(",");
        }
        String a7 = lb.a(str, "@startappBrowserEnabled@", "@startappBrowserEnabled@");
        if (a7 != null) {
            String[] split2 = a7.split(",");
            this.inAppBrowserEnabled = new boolean[split2.length];
            for (int i3 = 0; i3 < split2.length; i3++) {
                if (split2[i3].compareTo(Constants.CASEFIRST_FALSE) == 0) {
                    this.inAppBrowserEnabled[i3] = false;
                } else {
                    this.inAppBrowserEnabled[i3] = true;
                }
            }
        }
        String a8 = lb.a(str, "@orientation@", "@orientation@");
        if (a8 != null) {
            a(SplashConfig.Orientation.getByName(a8));
        }
        String a9 = lb.a(str, "@adInfoEnable@", "@adInfoEnable@");
        if (a9 != null) {
            getAdInfoOverride().a(Boolean.parseBoolean(a9));
        }
        String a10 = lb.a(str, "@adInfoPosition@", "@adInfoPosition@");
        if (a10 != null) {
            getAdInfoOverride().a(AdInformationPositions.Position.getByName(a10));
        }
        String a11 = lb.a(str, "@ttl@", "@ttl@");
        if (a11 != null) {
            b(a11);
        }
        String a12 = lb.a(str, "@belowMinCPM@", "@belowMinCPM@");
        if (a12 != null) {
            if (Arrays.asList(a12.split(",")).contains(Constants.CASEFIRST_FALSE)) {
                this.belowMinCPM = false;
            } else {
                this.belowMinCPM = true;
            }
        }
        String a13 = lb.a(str, "@delayImpressionInSeconds@", "@delayImpressionInSeconds@");
        if (a13 != null && !a13.equals("")) {
            try {
                this.delayImpressionInSeconds = Long.valueOf(Long.parseLong(a13));
            } catch (NumberFormatException unused) {
            }
        }
        String a14 = lb.a(str, "@rewardDuration@", "@rewardDuration@");
        if (a14 != null) {
            try {
                this.rewardDuration = Integer.parseInt(a14);
            } catch (Throwable th2) {
                y8.a(this.f36173b, th2);
            }
        }
        String a15 = lb.a(str, "@rewardedHideTimer@", "@rewardedHideTimer@");
        if (a15 != null) {
            try {
                this.rewardedHideTimer = Boolean.parseBoolean(a15);
            } catch (Throwable th3) {
                y8.a(this.f36173b, th3);
            }
        }
        String a16 = lb.a(str, "@sendRedirectHops@", "@sendRedirectHops@");
        if (a16 != null && !a16.equals("")) {
            String[] split3 = a16.split(",");
            this.sendRedirectHops = new Boolean[split3.length];
            for (int i4 = 0; i4 < split3.length; i4++) {
                if (split3[i4].compareTo("true") == 0) {
                    this.sendRedirectHops[i4] = Boolean.TRUE;
                } else if (split3[i4].compareTo(Constants.CASEFIRST_FALSE) == 0) {
                    this.sendRedirectHops[i4] = Boolean.FALSE;
                } else {
                    this.sendRedirectHops[i4] = null;
                }
            }
        }
        ConsentData consentData = new ConsentData();
        this.consentData = consentData;
        consentData.b(lb.a(str, "@infoDparam@", "@infoDparam@"));
        this.consentData.c(lb.a(str, "@infoImpUrl@", "@infoImpUrl@"));
        this.consentData.a(lb.a(str, "@infoClickUrl@", "@infoClickUrl@"));
        try {
            String a17 = lb.a(str, "@ct@", "@ct@");
            if (!TextUtils.isEmpty(a17)) {
                this.consentData.a(Integer.valueOf(Integer.parseInt(a17)));
            }
        } catch (Throwable th4) {
            y8.a(this.f36173b, th4);
        }
        try {
            String a18 = lb.a(str, "@tsc@", "@tsc@");
            if (!TextUtils.isEmpty(a18)) {
                this.consentData.a(Long.valueOf(Long.parseLong(a18)));
            }
        } catch (Throwable th5) {
            y8.a(this.f36173b, th5);
        }
        try {
            String a19 = lb.a(str, "@apc@", "@apc@");
            if (!TextUtils.isEmpty(a19)) {
                this.consentData.a(Boolean.valueOf(Boolean.parseBoolean(a19)));
            }
        } catch (Throwable th6) {
            y8.a(this.f36173b, th6);
        }
        int length = this.smartRedirect.length;
        String[] strArr = this.trackingUrls;
        if (length < strArr.length) {
            boolean[] zArr = new boolean[strArr.length];
            int i5 = 0;
            while (true) {
                boolean[] zArr2 = this.smartRedirect;
                if (i5 >= zArr2.length) {
                    break;
                }
                zArr[i5] = zArr2[i5];
                i5++;
            }
            while (i5 < this.trackingUrls.length) {
                zArr[i5] = false;
                i5++;
            }
            this.smartRedirect = zArr;
        }
    }

    public String[] g() {
        return this.closingUrl;
    }

    public String getAdId() {
        return lb.a(j(), "@adId@", "@adId@");
    }

    public String getBidToken() {
        return lb.a(j(), "bidToken", "bidToken");
    }

    public Long h() {
        return this.delayImpressionInSeconds;
    }

    public int i() {
        return this.height;
    }

    public String j() {
        d8 d8Var = d8.f34354a;
        return d8Var.f34356c.get(this.htmlUuid);
    }

    public String k() {
        return this.htmlUuid;
    }

    public int l() {
        return this.orientation;
    }

    public String[] m() {
        return this.packageNames;
    }

    public int n() {
        return this.rewardDuration;
    }

    public String[] o() {
        return this.trackingClickUrls;
    }

    public int p() {
        return this.width;
    }

    public final void q() {
        f36200c = lb.a(getContext());
    }

    public boolean r() {
        return this.isMraidAd;
    }

    public boolean s() {
        return this.rewardedHideTimer;
    }

    public Boolean[] t() {
        return this.sendRedirectHops;
    }

    public void a(SplashConfig.Orientation orientation2) {
        this.orientation = 0;
        Map<Activity, Integer> map = lb.f34876a;
        if (orientation2 == null) {
            return;
        }
        if (orientation2.equals(SplashConfig.Orientation.PORTRAIT)) {
            this.orientation = 1;
        } else if (orientation2.equals(SplashConfig.Orientation.LANDSCAPE)) {
            this.orientation = 2;
        }
    }

    public Boolean b(int i2) {
        Boolean[] boolArr = this.sendRedirectHops;
        if (boolArr == null || i2 < 0 || i2 >= boolArr.length) {
            return null;
        }
        return boolArr[i2];
    }

    public boolean a(int i2) {
        boolean[] zArr = this.inAppBrowserEnabled;
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return true;
        }
        return zArr[i2];
    }

    public void a(List<AppPresenceDetails> list) {
        this.apps = list;
    }
}
