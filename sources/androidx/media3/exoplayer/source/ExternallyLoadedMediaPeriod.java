package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ExternalLoader;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Charsets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class ExternallyLoadedMediaPeriod implements MediaPeriod {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f6914b;

    /* renamed from: c  reason: collision with root package name */
    private final ExternalLoader f6915c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final TrackGroupArray f6916d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f6917e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f6918f = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Throwable> f6919g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    private ListenableFuture<?> f6920h;

    private final class SampleStreamImpl implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private int f6922b = 0;

        public SampleStreamImpl() {
        }

        public void a() throws IOException {
            Throwable th = (Throwable) ExternallyLoadedMediaPeriod.this.f6919g.get();
            if (th != null) {
                throw new IOException(th);
            }
        }

        public int d(long j2) {
            return 0;
        }

        public boolean isReady() {
            return ExternallyLoadedMediaPeriod.this.f6918f.get();
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int i3 = this.f6922b;
            if (i3 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f5385b = ExternallyLoadedMediaPeriod.this.f6916d.b(0).a(0);
                this.f6922b = 1;
                return -5;
            } else if (!ExternallyLoadedMediaPeriod.this.f6918f.get()) {
                return -3;
            } else {
                int length = ExternallyLoadedMediaPeriod.this.f6917e.length;
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.f5069f = 0;
                if ((i2 & 4) == 0) {
                    decoderInputBuffer.f(length);
                    decoderInputBuffer.f5067d.put(ExternallyLoadedMediaPeriod.this.f6917e, 0, length);
                }
                if ((i2 & 1) == 0) {
                    this.f6922b = 2;
                }
                return -4;
            }
        }
    }

    public ExternallyLoadedMediaPeriod(Uri uri, String str, ExternalLoader externalLoader) {
        this.f6914b = uri;
        Format K = new Format.Builder().o0(str).K();
        this.f6915c = externalLoader;
        this.f6916d = new TrackGroupArray(new TrackGroup(K));
        this.f6917e = uri.toString().getBytes(Charsets.UTF_8);
    }

    public long b() {
        return this.f6918f.get() ? Long.MIN_VALUE : 0;
    }

    public boolean c() {
        return !this.f6918f.get();
    }

    public long e() {
        return this.f6918f.get() ? Long.MIN_VALUE : 0;
    }

    public void f(long j2) {
    }

    public boolean g(LoadingInfo loadingInfo) {
        return !this.f6918f.get();
    }

    public long h(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public long i(long j2) {
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() {
    }

    public TrackGroupArray n() {
        return this.f6916d;
    }

    public void o(long j2, boolean z2) {
    }

    public void p() {
        ListenableFuture<?> listenableFuture = this.f6920h;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
        }
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                sampleStreamArr[i2] = new SampleStreamImpl();
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        callback.m(this);
        ListenableFuture<?> a2 = this.f6915c.a(new ExternalLoader.LoadRequest(this.f6914b));
        this.f6920h = a2;
        Futures.a(a2, new FutureCallback<Object>() {
            public void onFailure(Throwable th) {
                ExternallyLoadedMediaPeriod.this.f6919g.set(th);
            }

            public void onSuccess(Object obj) {
                ExternallyLoadedMediaPeriod.this.f6918f.set(true);
            }
        }, MoreExecutors.a());
    }
}
