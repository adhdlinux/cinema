package com.google.android.gms.internal.ads;

public final class zzvn {
    public static final zzvn zza = new zzvn(new zzcy[0]);
    public static final zzn zzb = zzvm.zza;
    private static final String zzd = Integer.toString(0, 36);
    public final int zzc;
    private final zzfsc zze;
    private int zzf;

    public zzvn(zzcy... zzcyArr) {
        this.zze = zzfsc.zzk(zzcyArr);
        this.zzc = zzcyArr.length;
        int i2 = 0;
        while (i2 < this.zze.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.zze.size(); i4++) {
                if (((zzcy) this.zze.get(i2)).equals(this.zze.get(i4))) {
                    zzer.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvn.class == obj.getClass()) {
            zzvn zzvn = (zzvn) obj;
            if (this.zzc != zzvn.zzc || !this.zze.equals(zzvn.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzf;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.zze.hashCode();
        this.zzf = hashCode;
        return hashCode;
    }

    public final int zza(zzcy zzcy) {
        int indexOf = this.zze.indexOf(zzcy);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzcy zzb(int i2) {
        return (zzcy) this.zze.get(i2);
    }
}
