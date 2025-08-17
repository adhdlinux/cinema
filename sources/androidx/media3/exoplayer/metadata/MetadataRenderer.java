package androidx.media3.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.metadata.MetadataDecoder;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import e.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private long A;
    private Metadata B;
    private long C;

    /* renamed from: s  reason: collision with root package name */
    private final MetadataDecoderFactory f6765s;

    /* renamed from: t  reason: collision with root package name */
    private final MetadataOutput f6766t;

    /* renamed from: u  reason: collision with root package name */
    private final Handler f6767u;

    /* renamed from: v  reason: collision with root package name */
    private final MetadataInputBuffer f6768v;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f6769w;

    /* renamed from: x  reason: collision with root package name */
    private MetadataDecoder f6770x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f6771y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f6772z;

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.f6764a);
    }

    private void c0(Metadata metadata, List<Metadata.Entry> list) {
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Format D = metadata.e(i2).D();
            if (D == null || !this.f6765s.c(D)) {
                list.add(metadata.e(i2));
            } else {
                MetadataDecoder a2 = this.f6765s.a(D);
                byte[] bArr = (byte[]) Assertions.f(metadata.e(i2).E());
                this.f6768v.clear();
                this.f6768v.f(bArr.length);
                ((ByteBuffer) Util.i(this.f6768v.f5067d)).put(bArr);
                this.f6768v.g();
                Metadata a3 = a2.a(this.f6768v);
                if (a3 != null) {
                    c0(a3, list);
                }
            }
        }
    }

    @SideEffectFree
    private long d0(long j2) {
        boolean z2;
        boolean z3 = true;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.C == -9223372036854775807L) {
            z3 = false;
        }
        Assertions.h(z3);
        return j2 - this.C;
    }

    private void e0(Metadata metadata) {
        Handler handler = this.f6767u;
        if (handler != null) {
            handler.obtainMessage(1, metadata).sendToTarget();
        } else {
            f0(metadata);
        }
    }

    private void f0(Metadata metadata) {
        this.f6766t.B(metadata);
    }

    private boolean g0(long j2) {
        boolean z2;
        Metadata metadata = this.B;
        if (metadata == null || (!this.f6769w && metadata.f4284c > d0(j2))) {
            z2 = false;
        } else {
            e0(this.B);
            this.B = null;
            z2 = true;
        }
        if (this.f6771y && this.B == null) {
            this.f6772z = true;
        }
        return z2;
    }

    private void h0() {
        if (!this.f6771y && this.B == null) {
            this.f6768v.clear();
            FormatHolder I = I();
            int Z = Z(I, this.f6768v, 0);
            if (Z == -4) {
                if (this.f6768v.isEndOfStream()) {
                    this.f6771y = true;
                } else if (this.f6768v.f5069f >= K()) {
                    MetadataInputBuffer metadataInputBuffer = this.f6768v;
                    metadataInputBuffer.f8265j = this.A;
                    metadataInputBuffer.g();
                    Metadata a2 = ((MetadataDecoder) Util.i(this.f6770x)).a(this.f6768v);
                    if (a2 != null) {
                        ArrayList arrayList = new ArrayList(a2.f());
                        c0(a2, arrayList);
                        if (!arrayList.isEmpty()) {
                            this.B = new Metadata(d0(this.f6768v.f5069f), (List<? extends Metadata.Entry>) arrayList);
                        }
                    }
                }
            } else if (Z == -5) {
                this.A = ((Format) Assertions.f(I.f5385b)).f4020s;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.B = null;
        this.f6770x = null;
        this.C = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) {
        this.B = null;
        this.f6771y = false;
        this.f6772z = false;
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f6770x = this.f6765s.a(formatArr[0]);
        Metadata metadata = this.B;
        if (metadata != null) {
            this.B = metadata.d((metadata.f4284c + this.C) - j3);
        }
        this.C = j3;
    }

    public boolean a() {
        return this.f6772z;
    }

    public int c(Format format) {
        int i2;
        if (!this.f6765s.c(format)) {
            return x.a(0);
        }
        if (format.K == 0) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        return x.a(i2);
    }

    public void f(long j2, long j3) {
        boolean z2 = true;
        while (z2) {
            h0();
            z2 = g0(j2);
        }
    }

    public String getName() {
        return "MetadataRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            f0((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isReady() {
        return true;
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        this(metadataOutput, looper, metadataDecoderFactory, false);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory, boolean z2) {
        super(5);
        Handler handler;
        this.f6766t = (MetadataOutput) Assertions.f(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.z(looper, this);
        }
        this.f6767u = handler;
        this.f6765s = (MetadataDecoderFactory) Assertions.f(metadataDecoderFactory);
        this.f6769w = z2;
        this.f6768v = new MetadataInputBuffer();
        this.C = -9223372036854775807L;
    }
}
