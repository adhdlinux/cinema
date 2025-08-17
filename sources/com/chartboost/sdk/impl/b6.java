package com.chartboost.sdk.impl;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public final class b6 extends v0 {

    /* renamed from: b  reason: collision with root package name */
    public final Context f17292b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b6(Context context) {
        super(context);
        Intrinsics.f(context, "context");
        this.f17292b = context;
    }

    public u0 b() {
        yb ybVar;
        String str = null;
        if (a()) {
            return new u0(yb.TRACKING_LIMITED, (String) null);
        }
        yb ybVar2 = yb.TRACKING_UNKNOWN;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f17292b);
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                ybVar = yb.TRACKING_LIMITED;
            } else {
                ybVar2 = yb.TRACKING_ENABLED;
                String id = advertisingIdInfo.getId();
                try {
                    if (Intrinsics.a("00000000-0000-0000-0000-000000000000", id)) {
                        ybVar = yb.TRACKING_LIMITED;
                    } else {
                        str = id;
                        return new u0(ybVar2, str);
                    }
                } catch (IllegalStateException e2) {
                    String str2 = id;
                    e = e2;
                    str = str2;
                    String a2 = c6.f17328a;
                    Intrinsics.e(a2, "TAG");
                    w7.b(a2, "This should have been called off the main thread. " + e);
                    return new u0(ybVar2, str);
                } catch (IOException e3) {
                    String str3 = id;
                    e = e3;
                    str = str3;
                    String a3 = c6.f17328a;
                    Intrinsics.e(a3, "TAG");
                    w7.b(a3, "The connection to Google Play Services failed. " + e);
                    return new u0(ybVar2, str);
                } catch (GooglePlayServicesRepairableException e4) {
                    String str4 = id;
                    e = e4;
                    str = str4;
                    String a4 = c6.f17328a;
                    Intrinsics.e(a4, "TAG");
                    w7.b(a4, "There was a recoverable error connecting to Google Play Services. " + e);
                    return new u0(ybVar2, str);
                } catch (GooglePlayServicesNotAvailableException e5) {
                    String str5 = id;
                    e = e5;
                    str = str5;
                    String a5 = c6.f17328a;
                    Intrinsics.e(a5, "TAG");
                    w7.b(a5, "Google play service is not available. " + e);
                    return new u0(ybVar2, str);
                }
            }
            ybVar2 = ybVar;
        } catch (IllegalStateException e6) {
            e = e6;
            String a22 = c6.f17328a;
            Intrinsics.e(a22, "TAG");
            w7.b(a22, "This should have been called off the main thread. " + e);
            return new u0(ybVar2, str);
        } catch (IOException e7) {
            e = e7;
            String a32 = c6.f17328a;
            Intrinsics.e(a32, "TAG");
            w7.b(a32, "The connection to Google Play Services failed. " + e);
            return new u0(ybVar2, str);
        } catch (GooglePlayServicesRepairableException e8) {
            e = e8;
            String a42 = c6.f17328a;
            Intrinsics.e(a42, "TAG");
            w7.b(a42, "There was a recoverable error connecting to Google Play Services. " + e);
            return new u0(ybVar2, str);
        } catch (GooglePlayServicesNotAvailableException e9) {
            e = e9;
            String a52 = c6.f17328a;
            Intrinsics.e(a52, "TAG");
            w7.b(a52, "Google play service is not available. " + e);
            return new u0(ybVar2, str);
        }
        return new u0(ybVar2, str);
    }
}
