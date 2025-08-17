package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;

public final class DecoderReuseEvaluation {

    /* renamed from: a  reason: collision with root package name */
    public final String f23971a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f23972b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f23973c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23974d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23975e;

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i2, int i3) {
        boolean z2;
        if (i2 == 0 || i3 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f23971a = Assertions.d(str);
        this.f23972b = (Format) Assertions.e(format);
        this.f23973c = (Format) Assertions.e(format2);
        this.f23974d = i2;
        this.f23975e = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        if (this.f23974d != decoderReuseEvaluation.f23974d || this.f23975e != decoderReuseEvaluation.f23975e || !this.f23971a.equals(decoderReuseEvaluation.f23971a) || !this.f23972b.equals(decoderReuseEvaluation.f23972b) || !this.f23973c.equals(decoderReuseEvaluation.f23973c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.f23974d) * 31) + this.f23975e) * 31) + this.f23971a.hashCode()) * 31) + this.f23972b.hashCode()) * 31) + this.f23973c.hashCode();
    }
}
