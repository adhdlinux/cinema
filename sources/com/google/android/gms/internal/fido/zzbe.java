package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;

class zzbe extends zzbf {
    final zzbb zzb;
    final Character zzc;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzbe(com.google.android.gms.internal.fido.zzbb r4, java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0017
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzb(r2)
            if (r4 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = 1
        L_0x0018:
            if (r4 == 0) goto L_0x001d
            r3.zzc = r5
            return
        L_0x001d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.gms.internal.fido.zzan.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbe.<init>(com.google.android.gms.internal.fido.zzbb, java.lang.Character):void");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbe) {
            zzbe zzbe = (zzbe) obj;
            if (this.zzb.equals(zzbe.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzbe.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch == null || !ch.equals(ch2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        if (ch == null) {
            i2 = 0;
        } else {
            i2 = ch.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void zza(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        zzam.zze(0, i3, bArr.length);
        while (i4 < i3) {
            zzc(appendable, bArr, i4, Math.min(this.zzb.zzd, i3 - i4));
            i4 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(int i2) {
        zzbb zzbb = this.zzb;
        return zzbb.zzc * zzbh.zza(i2, zzbb.zzd, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
        boolean z2;
        zzam.zze(i2, i2 + i3, bArr.length);
        int i4 = 0;
        if (i3 <= this.zzb.zzd) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzam.zzc(z2);
        long j2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = (j2 | ((long) (bArr[i2 + i5] & 255))) << 8;
        }
        int i6 = ((i3 + 1) * 8) - this.zzb.zzb;
        while (i4 < i3 * 8) {
            zzbb zzbb = this.zzb;
            appendable.append(zzbb.zza(zzbb.zza & ((int) (j2 >>> (i6 - i4)))));
            i4 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i4 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i4 += this.zzb.zzb;
            }
        }
    }

    zzbe(String str, String str2, Character ch) {
        this(new zzbb(str, str2.toCharArray()), ch);
    }
}
