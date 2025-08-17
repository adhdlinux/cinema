package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinSdkSettings {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16048a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16049b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16050c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16051d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16052e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16053f = true;

    /* renamed from: g  reason: collision with root package name */
    private String f16054g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f16055h = Collections.emptyList();

    /* renamed from: i  reason: collision with root package name */
    private List<String> f16056i = Collections.emptyList();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, String> f16057j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private final Object f16058k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private m f16059l;
    private final Map<String, Object> localSettings = new HashMap();
    private final Map<String, String> metaData = new HashMap();

    public AppLovinSdkSettings(Context context) {
        this.f16048a = Utils.isVerboseLoggingEnabled(context);
        this.f16050c = true;
        this.f16051d = true;
        this.f16052e = true;
    }

    /* access modifiers changed from: protected */
    public void attachAppLovinSdk(m mVar) {
        this.f16059l = mVar;
        if (StringUtils.isValidString(this.f16054g)) {
            mVar.J().a(true);
            mVar.J().a(this.f16054g);
            this.f16054g = null;
        }
    }

    public Map<String, String> getExtraParameters() {
        HashMap hashMap;
        synchronized (this.f16058k) {
            hashMap = new HashMap(this.f16057j);
        }
        return hashMap;
    }

    public List<String> getInitializationAdUnitIds() {
        return this.f16056i;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.f16055h;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f16050c;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.f16051d;
    }

    public boolean isLocationCollectionEnabled() {
        return this.f16052e;
    }

    public boolean isMuted() {
        return this.f16049b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f16048a;
    }

    public void setCreativeDebuggerEnabled(boolean z2) {
        this.f16050c = z2;
    }

    public void setExceptionHandlerEnabled(boolean z2) {
        this.f16051d = z2;
    }

    public void setExtraParameter(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str2 != null ? str2.trim() : null;
            synchronized (this.f16058k) {
                this.f16057j.put(str, trim);
            }
            if (!"test_mode_network".equalsIgnoreCase(str)) {
                return;
            }
            if (this.f16059l == null) {
                this.f16054g = trim;
            } else if (StringUtils.isValidString(trim)) {
                this.f16059l.J().a(true);
                this.f16059l.J().a(trim);
            } else {
                this.f16059l.J().a(false);
                this.f16059l.J().a((String) null);
            }
        } else if (v.a()) {
            v.i("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
        }
    }

    public void setInitializationAdUnitIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (StringUtils.isValidString(next) && next.length() > 0) {
                    if (next.length() == 16) {
                        arrayList.add(next);
                    } else if (v.a()) {
                        v.i("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + next + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.f16056i = arrayList;
            return;
        }
        this.f16056i = Collections.emptyList();
    }

    public void setLocationCollectionEnabled(boolean z2) {
        this.f16052e = z2;
    }

    public void setMuted(boolean z2) {
        this.f16049b = z2;
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z2) {
        this.f16053f = z2;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next != null && next.length() == 36) {
                    arrayList.add(next);
                } else if (v.a()) {
                    v.i("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                }
            }
            this.f16055h = arrayList;
            return;
        }
        this.f16055h = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z2) {
        if (Utils.isVerboseLoggingConfigured()) {
            if (v.a()) {
                v.i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
            }
            if (Utils.isVerboseLoggingEnabled((Context) null) != z2) {
                v.i("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.f16048a = z2;
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.f16053f;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f16048a + ", muted=" + this.f16049b + ", testDeviceAdvertisingIds=" + this.f16055h.toString() + ", initializationAdUnitIds=" + this.f16056i.toString() + ", creativeDebuggerEnabled=" + this.f16050c + ", exceptionHandlerEnabled=" + this.f16051d + ", locationCollectionEnabled=" + this.f16052e + '}';
    }
}
