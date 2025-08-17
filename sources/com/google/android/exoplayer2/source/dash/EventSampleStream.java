package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class EventSampleStream implements SampleStream {

    /* renamed from: b  reason: collision with root package name */
    private final Format f26241b;

    /* renamed from: c  reason: collision with root package name */
    private final EventMessageEncoder f26242c = new EventMessageEncoder();

    /* renamed from: d  reason: collision with root package name */
    private long[] f26243d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26244e;

    /* renamed from: f  reason: collision with root package name */
    private EventStream f26245f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26246g;

    /* renamed from: h  reason: collision with root package name */
    private int f26247h;

    /* renamed from: i  reason: collision with root package name */
    private long f26248i = -9223372036854775807L;

    public EventSampleStream(EventStream eventStream, Format format, boolean z2) {
        this.f26241b = format;
        this.f26245f = eventStream;
        this.f26243d = eventStream.f26309b;
        e(eventStream, z2);
    }

    public void a() throws IOException {
    }

    public String b() {
        return this.f26245f.a();
    }

    public void c(long j2) {
        boolean z2 = true;
        int e2 = Util.e(this.f26243d, j2, true, false);
        this.f26247h = e2;
        if (!this.f26244e || e2 != this.f26243d.length) {
            z2 = false;
        }
        if (!z2) {
            j2 = -9223372036854775807L;
        }
        this.f26248i = j2;
    }

    public int d(long j2) {
        int max = Math.max(this.f26247h, Util.e(this.f26243d, j2, true, false));
        int i2 = max - this.f26247h;
        this.f26247h = max;
        return i2;
    }

    public void e(EventStream eventStream, boolean z2) {
        long j2;
        int i2 = this.f26247h;
        if (i2 == 0) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.f26243d[i2 - 1];
        }
        this.f26244e = z2;
        this.f26245f = eventStream;
        long[] jArr = eventStream.f26309b;
        this.f26243d = jArr;
        long j3 = this.f26248i;
        if (j3 != -9223372036854775807L) {
            c(j3);
        } else if (j2 != -9223372036854775807L) {
            this.f26247h = Util.e(jArr, j2, false, false);
        }
    }

    public boolean isReady() {
        return true;
    }

    public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        boolean z2;
        int i3 = this.f26247h;
        if (i3 == this.f26243d.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !this.f26244e) {
            decoderInputBuffer.o(4);
            return -4;
        } else if ((i2 & 2) != 0 || !this.f26246g) {
            formatHolder.f23112b = this.f26241b;
            this.f26246g = true;
            return -5;
        } else if (z2) {
            return -3;
        } else {
            if ((i2 & 1) == 0) {
                this.f26247h = i3 + 1;
            }
            if ((i2 & 4) == 0) {
                byte[] a2 = this.f26242c.a(this.f26245f.f26308a[i3]);
                decoderInputBuffer.q(a2.length);
                decoderInputBuffer.f23961d.put(a2);
            }
            decoderInputBuffer.f23963f = this.f26243d[i3];
            decoderInputBuffer.o(1);
            return -4;
        }
    }
}
