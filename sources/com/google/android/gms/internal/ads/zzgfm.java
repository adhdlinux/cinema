package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

public final class zzgfm {
    public static final Charset zza = Charset.forName("UTF-8");

    public static final zzgnk zza(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt < '!' || charAt > '~') {
                throw new zzgfl("Not a printable ASCII character: " + charAt);
            }
            bArr[i2] = (byte) charAt;
        }
        return zzgnk.zzb(bArr);
    }
}
