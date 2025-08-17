package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;

public final class DecoderReuseEvaluation {

    /* renamed from: a  reason: collision with root package name */
    public final String f5162a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f5163b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f5164c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5165d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5166e;

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i2, int i3) {
        boolean z2;
        if (i2 == 0 || i3 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f5162a = Assertions.d(str);
        this.f5163b = (Format) Assertions.f(format);
        this.f5164c = (Format) Assertions.f(format2);
        this.f5165d = i2;
        this.f5166e = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        if (this.f5165d != decoderReuseEvaluation.f5165d || this.f5166e != decoderReuseEvaluation.f5166e || !this.f5162a.equals(decoderReuseEvaluation.f5162a) || !this.f5163b.equals(decoderReuseEvaluation.f5163b) || !this.f5164c.equals(decoderReuseEvaluation.f5164c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.f5165d) * 31) + this.f5166e) * 31) + this.f5162a.hashCode()) * 31) + this.f5163b.hashCode()) * 31) + this.f5164c.hashCode();
    }
}
