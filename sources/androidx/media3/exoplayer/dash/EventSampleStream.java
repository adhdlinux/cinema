package androidx.media3.exoplayer.dash;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import java.io.IOException;

final class EventSampleStream implements SampleStream {

    /* renamed from: b  reason: collision with root package name */
    private final Format f6012b;

    /* renamed from: c  reason: collision with root package name */
    private final EventMessageEncoder f6013c = new EventMessageEncoder();

    /* renamed from: d  reason: collision with root package name */
    private long[] f6014d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6015e;

    /* renamed from: f  reason: collision with root package name */
    private EventStream f6016f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6017g;

    /* renamed from: h  reason: collision with root package name */
    private int f6018h;

    /* renamed from: i  reason: collision with root package name */
    private long f6019i = -9223372036854775807L;

    public EventSampleStream(EventStream eventStream, Format format, boolean z2) {
        this.f6012b = format;
        this.f6016f = eventStream;
        this.f6014d = eventStream.f6080b;
        e(eventStream, z2);
    }

    public void a() throws IOException {
    }

    public String b() {
        return this.f6016f.a();
    }

    public void c(long j2) {
        boolean z2 = true;
        int d2 = Util.d(this.f6014d, j2, true, false);
        this.f6018h = d2;
        if (!this.f6015e || d2 != this.f6014d.length) {
            z2 = false;
        }
        if (!z2) {
            j2 = -9223372036854775807L;
        }
        this.f6019i = j2;
    }

    public int d(long j2) {
        int max = Math.max(this.f6018h, Util.d(this.f6014d, j2, true, false));
        int i2 = max - this.f6018h;
        this.f6018h = max;
        return i2;
    }

    public void e(EventStream eventStream, boolean z2) {
        long j2;
        int i2 = this.f6018h;
        if (i2 == 0) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.f6014d[i2 - 1];
        }
        this.f6015e = z2;
        this.f6016f = eventStream;
        long[] jArr = eventStream.f6080b;
        this.f6014d = jArr;
        long j3 = this.f6019i;
        if (j3 != -9223372036854775807L) {
            c(j3);
        } else if (j2 != -9223372036854775807L) {
            this.f6018h = Util.d(jArr, j2, false, false);
        }
    }

    public boolean isReady() {
        return true;
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        boolean z2;
        int i3 = this.f6018h;
        if (i3 == this.f6014d.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !this.f6015e) {
            decoderInputBuffer.setFlags(4);
            return -4;
        } else if ((i2 & 2) != 0 || !this.f6017g) {
            formatHolder.f5385b = this.f6012b;
            this.f6017g = true;
            return -5;
        } else if (z2) {
            return -3;
        } else {
            if ((i2 & 1) == 0) {
                this.f6018h = i3 + 1;
            }
            if ((i2 & 4) == 0) {
                byte[] a2 = this.f6013c.a(this.f6016f.f6079a[i3]);
                decoderInputBuffer.f(a2.length);
                decoderInputBuffer.f5067d.put(a2);
            }
            decoderInputBuffer.f5069f = this.f6014d[i3];
            decoderInputBuffer.setFlags(1);
            return -4;
        }
    }
}
