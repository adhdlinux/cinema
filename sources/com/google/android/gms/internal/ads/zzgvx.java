package com.google.android.gms.internal.ads;

public final class zzgvx {
    public static final zzgvx zza = new zzgvx(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgvx zzb = new zzgvx(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgvx zzc = new zzgvx(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgvx zzd = new zzgvx(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public final double zze;
    public final double zzf;
    public final double zzg;
    public final double zzh;
    public final double zzi;
    public final double zzj;
    public final double zzk;
    public final double zzl;
    public final double zzm;

    public zzgvx(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zze = d6;
        this.zzf = d7;
        this.zzg = d8;
        this.zzh = d2;
        this.zzi = d3;
        this.zzj = d4;
        this.zzk = d5;
        this.zzl = d9;
        this.zzm = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzgvx.class != obj.getClass()) {
            return false;
        }
        zzgvx zzgvx = (zzgvx) obj;
        if (Double.compare(zzgvx.zzh, this.zzh) == 0 && Double.compare(zzgvx.zzi, this.zzi) == 0 && Double.compare(zzgvx.zzj, this.zzj) == 0 && Double.compare(zzgvx.zzk, this.zzk) == 0 && Double.compare(zzgvx.zzl, this.zzl) == 0 && Double.compare(zzgvx.zzm, this.zzm) == 0 && Double.compare(zzgvx.zze, this.zze) == 0 && Double.compare(zzgvx.zzf, this.zzf) == 0 && Double.compare(zzgvx.zzg, this.zzg) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zze);
        long j2 = doubleToLongBits ^ (doubleToLongBits >>> 32);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzf);
        long j3 = doubleToLongBits2 ^ (doubleToLongBits2 >>> 32);
        long doubleToLongBits3 = Double.doubleToLongBits(this.zzg);
        long j4 = doubleToLongBits3 ^ (doubleToLongBits3 >>> 32);
        long doubleToLongBits4 = Double.doubleToLongBits(this.zzh);
        long j5 = doubleToLongBits4 ^ (doubleToLongBits4 >>> 32);
        long doubleToLongBits5 = Double.doubleToLongBits(this.zzi);
        long j6 = doubleToLongBits5 ^ (doubleToLongBits5 >>> 32);
        long doubleToLongBits6 = Double.doubleToLongBits(this.zzj);
        long j7 = doubleToLongBits6 ^ (doubleToLongBits6 >>> 32);
        long doubleToLongBits7 = Double.doubleToLongBits(this.zzk);
        long j8 = doubleToLongBits7 ^ (doubleToLongBits7 >>> 32);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzl);
        long j9 = doubleToLongBits8 ^ (doubleToLongBits8 >>> 32);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzm);
        return (((((((((((((((((int) j2) * 31) + ((int) j3)) * 31) + ((int) j4)) * 31) + ((int) j5)) * 31) + ((int) j6)) * 31) + ((int) j7)) * 31) + ((int) j8)) * 31) + ((int) j9)) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zza)) {
            return "Rotate 0°";
        }
        if (equals(zzb)) {
            return "Rotate 90°";
        }
        if (equals(zzc)) {
            return "Rotate 180°";
        }
        if (equals(zzd)) {
            return "Rotate 270°";
        }
        double d2 = this.zze;
        double d3 = this.zzf;
        double d4 = this.zzg;
        double d5 = this.zzh;
        double d6 = this.zzi;
        double d7 = this.zzj;
        double d8 = this.zzk;
        double d9 = this.zzl;
        double d10 = this.zzm;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
