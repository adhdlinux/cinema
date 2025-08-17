package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

public interface LoadErrorHandlingPolicy {

    public static final class FallbackOptions {

        /* renamed from: a  reason: collision with root package name */
        public final int f7522a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7523b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7524c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7525d;

        public FallbackOptions(int i2, int i3, int i4, int i5) {
            this.f7522a = i2;
            this.f7523b = i3;
            this.f7524c = i4;
            this.f7525d = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(int r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                if (r4 != r1) goto L_0x000c
                int r4 = r3.f7522a
                int r2 = r3.f7523b
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0014
                goto L_0x0013
            L_0x000c:
                int r4 = r3.f7524c
                int r2 = r3.f7525d
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0014
            L_0x0013:
                r0 = 1
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy.FallbackOptions.a(int):boolean");
        }
    }

    public static final class FallbackSelection {

        /* renamed from: a  reason: collision with root package name */
        public final int f7526a;

        /* renamed from: b  reason: collision with root package name */
        public final long f7527b;

        public FallbackSelection(int i2, long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f7526a = i2;
            this.f7527b = j2;
        }
    }

    public static final class LoadErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final LoadEventInfo f7528a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaLoadData f7529b;

        /* renamed from: c  reason: collision with root package name */
        public final IOException f7530c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7531d;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i2) {
            this.f7528a = loadEventInfo;
            this.f7529b = mediaLoadData;
            this.f7530c = iOException;
            this.f7531d = i2;
        }
    }

    int a(int i2);

    void b(long j2);

    long c(LoadErrorInfo loadErrorInfo);

    FallbackSelection d(FallbackOptions fallbackOptions, LoadErrorInfo loadErrorInfo);
}
