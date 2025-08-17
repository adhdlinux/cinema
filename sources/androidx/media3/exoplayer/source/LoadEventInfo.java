package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class LoadEventInfo {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f6935h = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final long f6936a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f6937b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f6938c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<String>> f6939d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6940e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6941f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6942g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoadEventInfo(long r13, androidx.media3.datasource.DataSpec r15, long r16) {
        /*
            r12 = this;
            r3 = r15
            android.net.Uri r4 = r3.f4823a
            java.util.Map r5 = java.util.Collections.emptyMap()
            r8 = 0
            r10 = 0
            r0 = r12
            r1 = r13
            r6 = r16
            r0.<init>(r1, r3, r4, r5, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.LoadEventInfo.<init>(long, androidx.media3.datasource.DataSpec, long):void");
    }

    public static long a() {
        return f6935h.getAndIncrement();
    }

    public LoadEventInfo(long j2, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j3, long j4, long j5) {
        this.f6936a = j2;
        this.f6937b = dataSpec;
        this.f6938c = uri;
        this.f6939d = map;
        this.f6940e = j3;
        this.f6941f = j4;
        this.f6942g = j5;
    }
}
