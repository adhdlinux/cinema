package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;

public final class ExoPlaybackException extends PlaybackException {

    /* renamed from: r  reason: collision with root package name */
    private static final String f5230r = Util.B0(1001);

    /* renamed from: s  reason: collision with root package name */
    private static final String f5231s = Util.B0(1002);

    /* renamed from: t  reason: collision with root package name */
    private static final String f5232t = Util.B0(1003);

    /* renamed from: u  reason: collision with root package name */
    private static final String f5233u = Util.B0(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);

    /* renamed from: v  reason: collision with root package name */
    private static final String f5234v = Util.B0(1005);

    /* renamed from: w  reason: collision with root package name */
    private static final String f5235w = Util.B0(1006);

    /* renamed from: k  reason: collision with root package name */
    public final int f5236k;

    /* renamed from: l  reason: collision with root package name */
    public final String f5237l;

    /* renamed from: m  reason: collision with root package name */
    public final int f5238m;

    /* renamed from: n  reason: collision with root package name */
    public final Format f5239n;

    /* renamed from: o  reason: collision with root package name */
    public final int f5240o;

    /* renamed from: p  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f5241p;

    /* renamed from: q  reason: collision with root package name */
    final boolean f5242q;

    private ExoPlaybackException(int i2, Throwable th, int i3) {
        this(i2, th, (String) null, i3, (String) null, -1, (Format) null, 4, false);
    }

    public static ExoPlaybackException d(Throwable th, String str, int i2, Format format, int i3, boolean z2, int i4) {
        int i5;
        if (format == null) {
            i5 = 4;
        } else {
            i5 = i3;
        }
        return new ExoPlaybackException(1, th, (String) null, i4, str, i2, format, i5, z2);
    }

    public static ExoPlaybackException e(IOException iOException, int i2) {
        return new ExoPlaybackException(0, iOException, i2);
    }

    public static ExoPlaybackException f(RuntimeException runtimeException, int i2) {
        return new ExoPlaybackException(2, runtimeException, i2);
    }

    private static String g(int i2, String str, String str2, int i3, Format format, int i4) {
        String str3;
        if (i2 == 0) {
            str3 = "Source error";
        } else if (i2 == 1) {
            str3 = str2 + " error, index=" + i3 + ", format=" + format + ", format_supported=" + Util.a0(i4);
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
    public ExoPlaybackException c(MediaSource.MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.i(getMessage()), getCause(), this.f4300b, this.f5236k, this.f5237l, this.f5238m, this.f5239n, this.f5240o, mediaPeriodId, this.f4301c, this.f5242q);
    }

    private ExoPlaybackException(int i2, Throwable th, String str, int i3, String str2, int i4, Format format, int i5, boolean z2) {
        this(g(i2, str, str2, i4, format, i5), th, i3, i2, str2, i4, format, i5, (MediaSource.MediaPeriodId) null, SystemClock.elapsedRealtime(), z2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ExoPlaybackException(String str, Throwable th, int i2, int i3, String str2, int i4, Format format, int i5, MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2) {
        super(str, th, i2, Bundle.EMPTY, j2);
        int i6 = i3;
        boolean z3 = z2;
        boolean z4 = false;
        Assertions.a(!z3 || i6 == 1);
        Assertions.a((th != null || i6 == 3) ? true : z4);
        this.f5236k = i6;
        this.f5237l = str2;
        this.f5238m = i4;
        this.f5239n = format;
        this.f5240o = i5;
        this.f5241p = mediaPeriodId;
        this.f5242q = z3;
    }
}
