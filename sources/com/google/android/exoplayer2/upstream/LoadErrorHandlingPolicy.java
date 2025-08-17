package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public interface LoadErrorHandlingPolicy {

    public static final class FallbackOptions {

        /* renamed from: a  reason: collision with root package name */
        public final int f28452a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28453b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28454c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28455d;

        public FallbackOptions(int i2, int i3, int i4, int i5) {
            this.f28452a = i2;
            this.f28453b = i3;
            this.f28454c = i4;
            this.f28455d = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(int r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                if (r4 != r1) goto L_0x000c
                int r4 = r3.f28452a
                int r2 = r3.f28453b
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0014
                goto L_0x0013
            L_0x000c:
                int r4 = r3.f28454c
                int r2 = r3.f28455d
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0014
            L_0x0013:
                r0 = 1
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.FallbackOptions.a(int):boolean");
        }
    }

    public static final class FallbackSelection {

        /* renamed from: a  reason: collision with root package name */
        public final int f28456a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28457b;

        public FallbackSelection(int i2, long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f28456a = i2;
            this.f28457b = j2;
        }
    }

    public static final class LoadErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final LoadEventInfo f28458a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaLoadData f28459b;

        /* renamed from: c  reason: collision with root package name */
        public final IOException f28460c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28461d;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i2) {
            this.f28458a = loadEventInfo;
            this.f28459b = mediaLoadData;
            this.f28460c = iOException;
            this.f28461d = i2;
        }
    }

    int a(int i2);

    void b(long j2);

    long c(LoadErrorInfo loadErrorInfo);

    FallbackSelection d(FallbackOptions fallbackOptions, LoadErrorInfo loadErrorInfo);
}
