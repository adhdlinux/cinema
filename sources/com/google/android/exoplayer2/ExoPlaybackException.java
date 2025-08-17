package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;

public final class ExoPlaybackException extends PlaybackException {

    /* renamed from: q  reason: collision with root package name */
    public static final Bundleable.Creator<ExoPlaybackException> f22891q = new e();

    /* renamed from: r  reason: collision with root package name */
    private static final String f22892r = Util.u0(1001);

    /* renamed from: s  reason: collision with root package name */
    private static final String f22893s = Util.u0(1002);

    /* renamed from: t  reason: collision with root package name */
    private static final String f22894t = Util.u0(1003);

    /* renamed from: u  reason: collision with root package name */
    private static final String f22895u = Util.u0(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);

    /* renamed from: v  reason: collision with root package name */
    private static final String f22896v = Util.u0(1005);

    /* renamed from: w  reason: collision with root package name */
    private static final String f22897w = Util.u0(1006);

    /* renamed from: j  reason: collision with root package name */
    public final int f22898j;

    /* renamed from: k  reason: collision with root package name */
    public final String f22899k;

    /* renamed from: l  reason: collision with root package name */
    public final int f22900l;

    /* renamed from: m  reason: collision with root package name */
    public final Format f22901m;

    /* renamed from: n  reason: collision with root package name */
    public final int f22902n;

    /* renamed from: o  reason: collision with root package name */
    public final MediaPeriodId f22903o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f22904p;

    private ExoPlaybackException(int i2, Throwable th, int i3) {
        this(i2, th, (String) null, i3, (String) null, -1, (Format) null, 4, false);
    }

    public static /* synthetic */ ExoPlaybackException d(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    public static ExoPlaybackException f(Throwable th, String str, int i2, Format format, int i3, boolean z2, int i4) {
        int i5;
        if (format == null) {
            i5 = 4;
        } else {
            i5 = i3;
        }
        return new ExoPlaybackException(1, th, (String) null, i4, str, i2, format, i5, z2);
    }

    public static ExoPlaybackException g(IOException iOException, int i2) {
        return new ExoPlaybackException(0, iOException, i2);
    }

    @Deprecated
    public static ExoPlaybackException h(RuntimeException runtimeException) {
        return i(runtimeException, 1000);
    }

    public static ExoPlaybackException i(RuntimeException runtimeException, int i2) {
        return new ExoPlaybackException(2, runtimeException, i2);
    }

    private static String j(int i2, String str, String str2, int i3, Format format, int i4) {
        String str3;
        if (i2 == 0) {
            str3 = "Source error";
        } else if (i2 == 1) {
            str3 = str2 + " error, index=" + i3 + ", format=" + format + ", format_supported=" + Util.Y(i4);
        } else if (i2 != 3) {
            str3 = "Unexpected runtime error";
        } else {
            str3 = "Remote error";
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    /* access modifiers changed from: package-private */
    public ExoPlaybackException e(MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.j(getMessage()), getCause(), this.f23374b, this.f22898j, this.f22899k, this.f22900l, this.f22901m, this.f22902n, mediaPeriodId, this.f23375c, this.f22904p);
    }

    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(f22892r, this.f22898j);
        bundle.putString(f22893s, this.f22899k);
        bundle.putInt(f22894t, this.f22900l);
        Format format = this.f22901m;
        if (format != null) {
            bundle.putBundle(f22895u, format.toBundle());
        }
        bundle.putInt(f22896v, this.f22902n);
        bundle.putBoolean(f22897w, this.f22904p);
        return bundle;
    }

    private ExoPlaybackException(int i2, Throwable th, String str, int i3, String str2, int i4, Format format, int i5, boolean z2) {
        this(j(i2, str, str2, i4, format, i5), th, i3, i2, str2, i4, format, i5, (MediaPeriodId) null, SystemClock.elapsedRealtime(), z2);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        Format format;
        this.f22898j = bundle.getInt(f22892r, 2);
        this.f22899k = bundle.getString(f22893s);
        this.f22900l = bundle.getInt(f22894t, -1);
        Bundle bundle2 = bundle.getBundle(f22895u);
        if (bundle2 == null) {
            format = null;
        } else {
            format = Format.f23059q0.a(bundle2);
        }
        this.f22901m = format;
        this.f22902n = bundle.getInt(f22896v, 4);
        this.f22904p = bundle.getBoolean(f22897w, false);
        this.f22903o = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ExoPlaybackException(String str, Throwable th, int i2, int i3, String str2, int i4, Format format, int i5, MediaPeriodId mediaPeriodId, long j2, boolean z2) {
        super(str, th, i2, j2);
        int i6 = i3;
        boolean z3 = z2;
        boolean z4 = false;
        Assertions.a(!z3 || i6 == 1);
        Assertions.a((th != null || i6 == 3) ? true : z4);
        this.f22898j = i6;
        this.f22899k = str2;
        this.f22900l = i4;
        this.f22901m = format;
        this.f22902n = i5;
        this.f22903o = mediaPeriodId;
        this.f22904p = z3;
    }
}
