package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.c5;
import com.startapp.j0;
import com.startapp.lb;
import com.startapp.o6;
import com.startapp.y8;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class SplashConfig implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Theme f36021a = Theme.OCEAN;

    /* renamed from: b  reason: collision with root package name */
    public static final MinSplashTime f36022b = MinSplashTime.REGULAR;

    /* renamed from: c  reason: collision with root package name */
    public static final long f36023c = 7500;

    /* renamed from: d  reason: collision with root package name */
    public static final MaxAdDisplayTime f36024d = MaxAdDisplayTime.FOR_EVER;

    /* renamed from: e  reason: collision with root package name */
    public static final Orientation f36025e = Orientation.AUTO;
    private static final long serialVersionUID = 1;
    private String appName = "";
    private int customScreen = -1;
    @j0(type = MaxAdDisplayTime.class)
    private MaxAdDisplayTime defaultMaxAdDisplayTime = f36024d;
    private Long defaultMaxLoadTime = Long.valueOf(f36023c);
    @j0(type = MinSplashTime.class)
    private MinSplashTime defaultMinSplashTime = f36022b;
    @j0(type = Orientation.class)
    private Orientation defaultOrientation = f36025e;
    @j0(type = Theme.class)
    private Theme defaultTheme = f36021a;

    /* renamed from: f  reason: collision with root package name */
    public transient Drawable f36026f = null;
    private boolean forceNative = false;

    /* renamed from: g  reason: collision with root package name */
    public transient String f36027g = "";
    private boolean htmlSplash = true;
    private byte[] logoByteArray = null;
    private int logoRes = -1;
    private String splashBgColor = "#066CAA";
    private String splashFontColor = "ffffff";
    private String splashLoadingType = "LoadingDots";

    /* renamed from: com.startapp.sdk.ads.splash.SplashConfig$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0032 */
        static {
            /*
                com.startapp.sdk.ads.splash.SplashConfig.Theme.values()
                r0 = 7
                int[] r1 = new int[r0]
                $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme = r1
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.DEEP_BLUE     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0011 }
                r3 = 1
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x001c }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.SKY     // Catch:{ NoSuchFieldError -> 0x001c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x001c }
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x0027 }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.ASHEN_SKY     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.BLAZE     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x003d }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.GLOOMY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3 = 5
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.OCEAN     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r3 = 6
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r1 = $SwitchMap$com$startapp$sdk$ads$splash$SplashConfig$Theme     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.startapp.sdk.ads.splash.SplashConfig$Theme r2 = com.startapp.sdk.ads.splash.SplashConfig.Theme.USER_DEFINED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.splash.SplashConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MaxAdDisplayTime {
        SHORT(5000),
        LONG(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS),
        FOR_EVER(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        
        private long index;

        private MaxAdDisplayTime(long j2) {
            this.index = j2;
        }

        public static MaxAdDisplayTime getByIndex(long j2) {
            MaxAdDisplayTime maxAdDisplayTime = SHORT;
            MaxAdDisplayTime[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                if (values[i2].getIndex() == j2) {
                    maxAdDisplayTime = values[i2];
                }
            }
            return maxAdDisplayTime;
        }

        public static MaxAdDisplayTime getByName(String str) {
            MaxAdDisplayTime maxAdDisplayTime = FOR_EVER;
            MaxAdDisplayTime[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                if (values[i2].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    maxAdDisplayTime = values[i2];
                }
            }
            return maxAdDisplayTime;
        }

        public long getIndex() {
            return this.index;
        }
    }

    public enum MinSplashTime {
        REGULAR(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS),
        SHORT(2000),
        LONG(5000);
        
        private long index;

        private MinSplashTime(int i2) {
            this.index = (long) i2;
        }

        public static MinSplashTime getByIndex(long j2) {
            MinSplashTime minSplashTime = SHORT;
            MinSplashTime[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                if (values[i2].getIndex() == j2) {
                    minSplashTime = values[i2];
                }
            }
            return minSplashTime;
        }

        public static MinSplashTime getByName(String str) {
            MinSplashTime minSplashTime = LONG;
            MinSplashTime[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                if (values[i2].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    minSplashTime = values[i2];
                }
            }
            return minSplashTime;
        }

        public long getIndex() {
            return this.index;
        }
    }

    public enum Orientation {
        PORTRAIT(1),
        LANDSCAPE(2),
        AUTO(3);
        
        private int index;

        private Orientation(int i2) {
            this.index = i2;
        }

        public static Orientation getByIndex(int i2) {
            Orientation orientation = PORTRAIT;
            Orientation[] values = values();
            for (int i3 = 0; i3 < 3; i3++) {
                if (values[i3].getIndex() == i2) {
                    orientation = values[i3];
                }
            }
            return orientation;
        }

        public static Orientation getByName(String str) {
            Orientation orientation = AUTO;
            Orientation[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                if (values[i2].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    orientation = values[i2];
                }
            }
            return orientation;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public enum Theme {
        DEEP_BLUE(1),
        SKY(2),
        ASHEN_SKY(3),
        BLAZE(4),
        GLOOMY(5),
        OCEAN(6),
        USER_DEFINED(0);
        
        private int index;

        private Theme(int i2) {
            this.index = i2;
        }

        public static Theme getByIndex(int i2) {
            Theme theme = DEEP_BLUE;
            Theme[] values = values();
            for (int i3 = 0; i3 < 7; i3++) {
                if (values[i3].getIndex() == i2) {
                    theme = values[i3];
                }
            }
            return theme;
        }

        public static Theme getByName(String str) {
            Theme theme = DEEP_BLUE;
            Theme[] values = values();
            for (int i2 = 0; i2 < 7; i2++) {
                if (values[i2].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    theme = values[i2];
                }
            }
            return theme;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static SplashConfig getDefaultSplashConfig() {
        SplashConfig splashConfig = new SplashConfig();
        SplashConfig minSplashTime = splashConfig.setTheme(f36021a).setMinSplashTime(f36022b);
        minSplashTime.defaultMaxLoadTime = Long.valueOf(f36023c);
        minSplashTime.setMaxAdDisplayTime(f36024d).setOrientation(f36025e).setLoadingType("LoadingDots").setAppName("");
        return splashConfig;
    }

    public Long a() {
        return this.defaultMaxLoadTime;
    }

    public boolean b() {
        return this.defaultTheme == Theme.USER_DEFINED || getCustomScreen() != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SplashConfig splashConfig = (SplashConfig) obj;
        if (this.forceNative == splashConfig.forceNative && this.customScreen == splashConfig.customScreen && this.logoRes == splashConfig.logoRes && this.htmlSplash == splashConfig.htmlSplash && lb.a(this.appName, splashConfig.appName) && Arrays.equals(this.logoByteArray, splashConfig.logoByteArray) && this.defaultTheme == splashConfig.defaultTheme && this.defaultMinSplashTime == splashConfig.defaultMinSplashTime && lb.a(this.defaultMaxLoadTime, splashConfig.defaultMaxLoadTime) && this.defaultMaxAdDisplayTime == splashConfig.defaultMaxAdDisplayTime && this.defaultOrientation == splashConfig.defaultOrientation && lb.a(this.splashBgColor, splashConfig.splashBgColor) && lb.a(this.splashFontColor, splashConfig.splashFontColor) && lb.a(this.splashLoadingType, splashConfig.splashLoadingType)) {
            return true;
        }
        return false;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getBgColor() {
        return this.splashBgColor;
    }

    public int getCustomScreen() {
        return this.customScreen;
    }

    public String getErrorMessage() {
        return this.f36027g;
    }

    public String getFontColor() {
        return this.splashFontColor;
    }

    public String getLoadingType() {
        return this.splashLoadingType;
    }

    public Drawable getLogo() {
        return this.f36026f;
    }

    public byte[] getLogoByteArray() {
        return this.logoByteArray;
    }

    public int getLogoRes() {
        return this.logoRes;
    }

    public MaxAdDisplayTime getMaxAdDisplayTime() {
        return this.defaultMaxAdDisplayTime;
    }

    public MinSplashTime getMinSplashTime() {
        return this.defaultMinSplashTime;
    }

    public Orientation getOrientation() {
        return this.defaultOrientation;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.forceNative), Integer.valueOf(this.customScreen), this.appName, Integer.valueOf(this.logoRes), this.defaultTheme, this.defaultMinSplashTime, this.defaultMaxLoadTime, this.defaultMaxAdDisplayTime, this.defaultOrientation, Boolean.valueOf(this.htmlSplash), this.splashBgColor, this.splashFontColor, this.splashLoadingType};
        Map<Activity, Integer> map = lb.f34876a;
        return (Arrays.deepHashCode(objArr) * 31) + Arrays.hashCode(this.logoByteArray);
    }

    public boolean isHtmlSplash() {
        if (this.forceNative) {
            return false;
        }
        return this.htmlSplash;
    }

    public SplashConfig setAppName(String str) {
        this.appName = str;
        return this;
    }

    public SplashConfig setCustomScreen(int i2) {
        this.customScreen = i2;
        return this;
    }

    public void setDefaults(Context context) {
        ApplicationInfo applicationInfo;
        SplashConfig a2 = SplashMetaData.f36048a.a();
        if (a2 == null) {
            a2 = getDefaultSplashConfig();
        } else {
            this.htmlSplash = a2.isHtmlSplash();
        }
        SplashConfig defaultSplashConfig = getDefaultSplashConfig();
        if (a2.defaultTheme == null) {
            a2.setTheme(defaultSplashConfig.defaultTheme);
        }
        if (a2.getMinSplashTime() == null) {
            a2.setMinSplashTime(defaultSplashConfig.getMinSplashTime());
        }
        if (a2.defaultMaxLoadTime == null) {
            a2.defaultMaxLoadTime = Long.valueOf(defaultSplashConfig.defaultMaxLoadTime.longValue());
        }
        if (a2.getMaxAdDisplayTime() == null) {
            a2.setMaxAdDisplayTime(defaultSplashConfig.getMaxAdDisplayTime());
        }
        if (a2.getOrientation() == null) {
            a2.setOrientation(defaultSplashConfig.getOrientation());
        }
        if (a2.getLoadingType() == null) {
            a2.setLoadingType(defaultSplashConfig.getLoadingType());
        }
        if (a2.getAppName().equals("")) {
            a2.setAppName(o6.a(context, "Welcome!"));
        }
        if (getMaxAdDisplayTime() == null) {
            setMaxAdDisplayTime(a2.getMaxAdDisplayTime());
        }
        if (this.defaultMaxLoadTime == null) {
            this.defaultMaxLoadTime = Long.valueOf(a2.defaultMaxLoadTime.longValue());
        }
        if (getMinSplashTime() == null) {
            setMinSplashTime(a2.getMinSplashTime());
        }
        if (getOrientation() == null) {
            setOrientation(a2.getOrientation());
        }
        if (this.defaultTheme == null) {
            setTheme(a2.defaultTheme);
        }
        if (getLogoRes() == -1 && (applicationInfo = context.getApplicationInfo()) != null) {
            setLogo(applicationInfo.icon);
        }
        if (getAppName().equals("")) {
            setAppName(a2.getAppName());
        }
    }

    public SplashConfig setLoadingType(String str) {
        this.splashLoadingType = str;
        return this;
    }

    public SplashConfig setLogo(int i2) {
        this.logoRes = i2;
        return this;
    }

    public SplashConfig setMaxAdDisplayTime(MaxAdDisplayTime maxAdDisplayTime) {
        this.defaultMaxAdDisplayTime = maxAdDisplayTime;
        return this;
    }

    public SplashConfig setMinSplashTime(MinSplashTime minSplashTime) {
        this.defaultMinSplashTime = minSplashTime;
        return this;
    }

    public SplashConfig setOrientation(Orientation orientation) {
        this.defaultOrientation = orientation;
        return this;
    }

    public SplashConfig setTheme(Theme theme) {
        this.defaultTheme = theme;
        return this;
    }

    public View a(Context context) {
        if (this.defaultTheme.ordinal() != 6) {
            int ordinal = this.defaultTheme.ordinal();
            if (ordinal == 0) {
                View a2 = c5.a(context, this);
                a2.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-16356182, -15029533, -16356182}));
                ((TextView) a2.findViewById(100)).setTextColor(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE));
                ((TextView) a2.findViewById(105)).setTextColor(Color.rgb(208, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE));
                return a2;
            } else if (ordinal == 1) {
                View a3 = c5.a(context, this);
                int i2 = context.getResources().getDisplayMetrics().widthPixels;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-921103, -6040347});
                gradientDrawable.setGradientType(1);
                gradientDrawable.setGradientRadius((float) (i2 / 2));
                a3.setBackgroundDrawable(gradientDrawable);
                ((TextView) a3.findViewById(100)).setTextColor(Color.rgb(51, 51, 51));
                ((TextView) a3.findViewById(105)).setTextColor(Color.rgb(162, 172, 175));
                return a3;
            } else if (ordinal == 2) {
                View a4 = c5.a(context, this);
                a4.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3881788, -1}));
                ((TextView) a4.findViewById(100)).setTextColor(Color.rgb(51, 51, 51));
                ((TextView) a4.findViewById(105)).setTextColor(Color.rgb(153, 153, 153));
                return a4;
            } else if (ordinal == 3) {
                View a5 = c5.a(context, this);
                int i3 = context.getResources().getDisplayMetrics().widthPixels;
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-92376, -40960});
                gradientDrawable2.setGradientType(1);
                gradientDrawable2.setGradientRadius((float) (i3 / 2));
                a5.setBackgroundDrawable(gradientDrawable2);
                ((TextView) a5.findViewById(100)).setTextColor(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE));
                ((TextView) a5.findViewById(105)).setTextColor(Color.rgb(JfifUtil.MARKER_FIRST_BYTE, 198, 151));
                return a5;
            } else if (ordinal == 4) {
                View a6 = c5.a(context, this);
                a6.setBackgroundColor(Color.rgb(47, 53, 63));
                ((TextView) a6.findViewById(100)).setTextColor(Color.rgb(51, 181, 229));
                ((TextView) a6.findViewById(105)).setTextColor(Color.rgb(122, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 139));
                return a6;
            } else if (ordinal != 5) {
                return null;
            } else {
                View a7 = c5.a(context, this);
                a7.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14451558, -7876130}));
                ((TextView) a7.findViewById(100)).setTextColor(Color.rgb(6, 61, 82));
                ((TextView) a7.findViewById(105)).setTextColor(Color.rgb(6, 61, 82));
                return a7;
            }
        } else {
            try {
                return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getCustomScreen(), (ViewGroup) null);
            } catch (Resources.NotFoundException unused) {
                throw new Resources.NotFoundException("StartApp: Can't find Custom layout resource");
            } catch (InflateException unused2) {
                throw new InflateException("StartApp: Can't inflate layout in Custom mode, Are you sure layout resource is valid?");
            } catch (Throwable th) {
                y8.a(context, th);
                return null;
            }
        }
    }

    public SplashConfig setLogo(byte[] bArr) {
        this.logoByteArray = bArr;
        return this;
    }

    public boolean b(Context context) {
        if (this.defaultTheme.ordinal() != 6) {
            if (getAppName().equals("")) {
                setAppName(o6.a(context, "Welcome!"));
            }
            if (getLogo() == null && getLogoByteArray() == null) {
                try {
                    if (getLogoRes() == -1) {
                        setLogo(context.getApplicationInfo().icon);
                        this.f36026f = context.getResources().getDrawable(context.getApplicationInfo().icon);
                    } else {
                        this.f36026f = context.getResources().getDrawable(getLogoRes());
                    }
                } catch (Throwable th) {
                    y8.a(context, th);
                }
            }
        } else if (getCustomScreen() == -1) {
            this.f36027g = "StartApp: Exception getting custom screen resource id, make sure it is set";
            return false;
        }
        return true;
    }

    public SplashHtml a(Activity activity) {
        int ordinal = this.defaultTheme.ordinal();
        String str = "#FFFFFF";
        String str2 = "#066CAA";
        if (ordinal != 0) {
            if (ordinal == 1) {
                str2 = "#a3d4e5";
            } else if (ordinal == 2) {
                str2 = "#E3E3E3";
            } else if (ordinal == 3) {
                str2 = "#FF6600";
            } else if (ordinal == 4) {
                str = "#33B5E5";
                str2 = "#2F353F";
            } else if (ordinal != 5) {
                str = "ffffff";
            } else {
                str = "#063D51";
                str2 = "#237C9A";
            }
            str = "#333333";
        }
        this.splashBgColor = str2;
        this.splashFontColor = str;
        SplashHtml splashHtml = new SplashHtml(activity);
        splashHtml.a(this);
        splashHtml.d();
        return splashHtml;
    }
}
