package com.google.android.gms.internal.fido;

import java.io.IOException;

final class zzbd extends zzbe {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzbd(java.lang.String r2, java.lang.String r3, java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.fido.zzbb r0 = new com.google.android.gms.internal.fido.zzbb
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = r0.zzf
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            com.google.android.gms.internal.fido.zzam.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbd.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        zzam.zze(0, i3, bArr.length);
        for (int i5 = i3; i5 >= 3; i5 -= 3) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            byte b2 = ((bArr[i4] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            appendable.append(this.zzb.zza(b2 >>> 18));
            appendable.append(this.zzb.zza((b2 >>> 12) & 63));
            appendable.append(this.zzb.zza((b2 >>> 6) & 63));
            appendable.append(this.zzb.zza(b2 & 63));
            i4 = i7 + 1;
        }
        if (i4 < i3) {
            zzc(appendable, bArr, i4, i3 - i4);
        }
    }
}
