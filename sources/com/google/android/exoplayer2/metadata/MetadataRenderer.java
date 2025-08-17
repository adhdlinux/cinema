package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {

    /* renamed from: o  reason: collision with root package name */
    private final MetadataDecoderFactory f25355o;

    /* renamed from: p  reason: collision with root package name */
    private final MetadataOutput f25356p;

    /* renamed from: q  reason: collision with root package name */
    private final Handler f25357q;

    /* renamed from: r  reason: collision with root package name */
    private final MetadataInputBuffer f25358r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f25359s;

    /* renamed from: t  reason: collision with root package name */
    private MetadataDecoder f25360t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f25361u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f25362v;

    /* renamed from: w  reason: collision with root package name */
    private long f25363w;

    /* renamed from: x  reason: collision with root package name */
    private Metadata f25364x;

    /* renamed from: y  reason: collision with root package name */
    private long f25365y;

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.f25353a);
    }

    private void N(Metadata metadata, List<Metadata.Entry> list) {
        for (int i2 = 0; i2 < metadata.f(); i2++) {
            Format D = metadata.e(i2).D();
            if (D == null || !this.f25355o.c(D)) {
                list.add(metadata.e(i2));
            } else {
                MetadataDecoder a2 = this.f25355o.a(D);
                byte[] bArr = (byte[]) Assertions.e(metadata.e(i2).E());
                this.f25358r.f();
                this.f25358r.q(bArr.length);
                ((ByteBuffer) Util.j(this.f25358r.f23961d)).put(bArr);
                this.f25358r.r();
                Metadata a3 = a2.a(this.f25358r);
                if (a3 != null) {
                    N(a3, list);
                }
            }
        }
    }

    @SideEffectFree
    private long O(long j2) {
        boolean z2;
        boolean z3 = true;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (this.f25365y == -9223372036854775807L) {
            z3 = false;
        }
        Assertions.g(z3);
        return j2 - this.f25365y;
    }

    private void P(Metadata metadata) {
        Handler handler = this.f25357q;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            Q(metadata);
        }
    }

    private void Q(Metadata metadata) {
        this.f25356p.onMetadata(metadata);
    }

    private boolean R(long j2) {
        boolean z2;
        Metadata metadata = this.f25364x;
        if (metadata == null || (!this.f25359s && metadata.f25352c > O(j2))) {
            z2 = false;
        } else {
            P(this.f25364x);
            this.f25364x = null;
            z2 = true;
        }
        if (this.f25361u && this.f25364x == null) {
            this.f25362v = true;
        }
        return z2;
    }

    private void S() {
        if (!this.f25361u && this.f25364x == null) {
            this.f25358r.f();
            FormatHolder y2 = y();
            int K = K(y2, this.f25358r, 0);
            if (K == -4) {
                if (this.f25358r.k()) {
                    this.f25361u = true;
                    return;
                }
                MetadataInputBuffer metadataInputBuffer = this.f25358r;
                metadataInputBuffer.f25354j = this.f25363w;
                metadataInputBuffer.r();
                Metadata a2 = ((MetadataDecoder) Util.j(this.f25360t)).a(this.f25358r);
                if (a2 != null) {
                    ArrayList arrayList = new ArrayList(a2.f());
                    N(a2, arrayList);
                    if (!arrayList.isEmpty()) {
                        this.f25364x = new Metadata(O(this.f25358r.f23963f), (List<? extends Metadata.Entry>) arrayList);
                    }
                }
            } else if (K == -5) {
                this.f25363w = ((Format) Assertions.e(y2.f23112b)).f23075q;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        this.f25364x = null;
        this.f25360t = null;
        this.f25365y = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public void F(long j2, boolean z2) {
        this.f25364x = null;
        this.f25361u = false;
        this.f25362v = false;
    }

    /* access modifiers changed from: protected */
    public void J(Format[] formatArr, long j2, long j3) {
        this.f25360t = this.f25355o.a(formatArr[0]);
        Metadata metadata = this.f25364x;
        if (metadata != null) {
            this.f25364x = metadata.d((metadata.f25352c + this.f25365y) - j3);
        }
        this.f25365y = j3;
    }

    public boolean a() {
        return this.f25362v;
    }

    public int c(Format format) {
        int i2;
        if (!this.f25355o.c(format)) {
            return b2.a(0);
        }
        if (format.H == 0) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        return b2.a(i2);
    }

    public void f(long j2, long j3) {
        boolean z2 = true;
        while (z2) {
            S();
            z2 = R(j2);
        }
    }

    public String getName() {
        return "MetadataRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            Q((Metadata) message.obj);
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
        this.f25356p = (MetadataOutput) Assertions.e(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.v(looper, this);
        }
        this.f25357q = handler;
        this.f25355o = (MetadataDecoderFactory) Assertions.e(metadataDecoderFactory);
        this.f25359s = z2;
        this.f25358r = new MetadataInputBuffer();
        this.f25365y = -9223372036854775807L;
    }
}
