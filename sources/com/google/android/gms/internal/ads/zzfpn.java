package com.google.android.gms.internal.ads;

final class zzfpn extends zzfps {
    final /* synthetic */ zzfpo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfpn(zzfpo zzfpo, zzfpu zzfpu, CharSequence charSequence) {
        super(zzfpu, charSequence);
        this.zza = zzfpo;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i2) {
        return i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i2) {
        zzfos zzfos = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfph.zzb(i2, length, "index");
        while (i2 < length) {
            if (zzfos.zzb(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
