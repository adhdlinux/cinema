package com.startapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.consent.ConsentActivity;
import com.startapp.sdk.adsbase.consent.ConsentConfig;
import com.startapp.sdk.adsbase.consent.ConsentTypeInfoConfig;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import com.vungle.ads.internal.Constants;

public final class s8 implements da {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35851a;

    /* renamed from: b  reason: collision with root package name */
    public final x6 f35852b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f35853c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35854d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35855e = true;

    public s8(Context context, x6 x6Var) {
        this.f35851a = context;
        this.f35852b = x6Var;
    }

    public void a(Integer num, Long l2, Boolean bool, boolean z2, boolean z3) {
        if (d()) {
            long j2 = this.f35852b.getLong("consentTimestamp", 0);
            int i2 = this.f35852b.getInt("consentType", -1);
            boolean contains = this.f35852b.contains("consentApc");
            boolean z4 = true;
            boolean z5 = (num == null || i2 == num.intValue()) ? false : true;
            boolean z6 = bool != null && (!contains || this.f35852b.getBoolean("consentApc", false) != bool.booleanValue());
            if (l2 == null || l2.longValue() <= j2) {
                z4 = false;
            }
            if (!z2 && !z4) {
                return;
            }
            if (z5 || z6) {
                x6.a a2 = this.f35852b.edit();
                if (z5) {
                    int intValue = num.intValue();
                    a2.a("consentType", Integer.valueOf(intValue));
                    a2.f36915a.putInt("consentType", intValue);
                }
                if (z6) {
                    boolean booleanValue = bool.booleanValue();
                    a2.a("consentApc", Boolean.valueOf(booleanValue));
                    a2.f36915a.putBoolean("consentApc", booleanValue);
                }
                if (z4) {
                    long longValue = l2.longValue();
                    a2.a("consentTimestamp", Long.valueOf(longValue));
                    a2.f36915a.putLong("consentTimestamp", longValue);
                }
                a2.apply();
                if (z3) {
                    MetaData.f36379h.a(this.f35851a, new AdPreferences(), MetaDataRequest.RequestReason.CONSENT, false, (da) null, true);
                }
            }
        }
    }

    public Integer b() {
        if (d()) {
            int hashCode = ComponentLocator.a(this.f35851a).a().a().f36967b.hashCode();
            if (!this.f35852b.contains("advIdHash") || this.f35852b.getInt("advIdHash", 0) != hashCode) {
                x6.a a2 = this.f35852b.edit().remove("consentType").remove("consentTimestamp");
                a2.a("advIdHash", Integer.valueOf(hashCode));
                a2.f36915a.putInt("advIdHash", hashCode);
                a2.apply();
            }
        }
        if (!d() || !this.f35852b.contains("consentType")) {
            return null;
        }
        return Integer.valueOf(this.f35852b.getInt("consentType", -1));
    }

    public boolean c() {
        Boolean a2 = a();
        if (a2 == null || !a2.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        ConsentConfig k2 = MetaData.f36379h.k();
        if (!this.f35855e || k2 == null || !k2.k()) {
            return false;
        }
        return true;
    }

    public Boolean a() {
        if (!d() || !this.f35852b.contains("consentApc")) {
            return null;
        }
        return Boolean.valueOf(this.f35852b.getBoolean("consentApc", false));
    }

    public final void a(boolean z2, String str, String str2, String str3) {
        ConsentConfig k2;
        String str4;
        int i2;
        int i3;
        Integer b2;
        if ((!z2 && !StartAppSDKInternal.c()) || (k2 = MetaData.f36379h.k()) == null) {
            return;
        }
        if ((!d() && !z2) || this.f35854d || !lb.g(this.f35851a) || !lb.e(this.f35851a)) {
            return;
        }
        if (z2 || !(k2.h() == null || k2.g() == null || this.f35852b.contains("consentApc"))) {
            if (z2) {
                str4 = AdInformationMetaData.f36260a.a().c();
            } else {
                str4 = k2.f();
            }
            if (str4 != null) {
                Intent intent = new Intent(this.f35851a, ConsentActivity.class);
                intent.setFlags(805306368);
                intent.setData(Uri.parse(str4));
                intent.putExtra("allowCT", k2.k());
                intent.putExtra("timestamp", k2.i());
                if (z2) {
                    i2 = 4;
                } else {
                    i2 = k2.h().intValue();
                }
                Integer valueOf = Integer.valueOf(i2);
                if (valueOf != null) {
                    intent.putExtra("templateName", valueOf);
                }
                if (z2) {
                    i3 = 7;
                } else {
                    i3 = k2.g().intValue();
                }
                Integer valueOf2 = Integer.valueOf(i3);
                if (valueOf2 != null) {
                    intent.putExtra("templateId", valueOf2);
                }
                if (!z2) {
                    str = k2.d();
                }
                if (str != null) {
                    intent.putExtra("dParam", str);
                }
                if (!z2) {
                    str2 = k2.e();
                }
                if (str2 != null) {
                    intent.putExtra("impressionUrl", str2);
                }
                if (!z2) {
                    str3 = k2.a();
                }
                if (str3 != null) {
                    intent.putExtra(Constants.CLICK_URL, str3);
                }
                if (z2) {
                    intent.putExtra("advertisingId", ComponentLocator.a(this.f35851a).a().a().f36967b);
                    if (this.f35852b.contains("consentType")) {
                        intent.putExtra("consentType", this.f35852b.getInt("consentType", -1));
                    }
                }
                ConsentTypeInfoConfig c2 = k2.c();
                if (c2 != null) {
                    if (c2.b() != null) {
                        intent.putExtra("impression", c2.b());
                    }
                    if (c2.a() != null) {
                        intent.putExtra("falseClick", c2.a());
                    }
                    if (c2.c() != null) {
                        intent.putExtra("trueClick", c2.c());
                    }
                }
                if (z2 && (b2 = AdInformationMetaData.f36260a.a().b()) != null) {
                    intent.putExtra("trueClick", b2);
                }
                try {
                    this.f35851a.startActivity(intent);
                    this.f35854d = true;
                } catch (Throwable th) {
                    y8.a(this.f35851a, th);
                }
            }
        }
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
        MetaData.f36379h.a((da) this);
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
        MetaData.f36379h.a((da) this);
        ConsentConfig k2 = MetaData.f36379h.k();
        if (k2 != null && d()) {
            Integer b2 = k2.b();
            if (b2 != null) {
                a(b2, Long.valueOf(k2.i()), (Boolean) null, false, false);
            }
            if (requestReason == MetaDataRequest.RequestReason.CONSENT) {
                x6.a a2 = this.f35852b.edit();
                long i2 = k2.i();
                a2.a("consentTimestamp", Long.valueOf(i2));
                a2.f36915a.putLong("consentTimestamp", i2);
                a2.apply();
            } else if (requestReason == MetaDataRequest.RequestReason.LAUNCH) {
                a(false, (String) null, (String) null, (String) null);
            }
        }
    }
}
