package com.google.android.gms.internal.ads;

final class zzfop extends zzfoo {
    private final char zza;

    zzfop(char c2) {
        this.zza = c2;
    }

    public final String toString() {
        int i2 = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(i2 & 15);
            i2 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    public final boolean zzb(char c2) {
        return c2 == this.zza;
    }
}
