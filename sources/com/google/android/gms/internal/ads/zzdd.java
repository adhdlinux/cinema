package com.google.android.gms.internal.ads;

public class zzdd {
    private static final String zzE = Integer.toString(1, 36);
    private static final String zzF = Integer.toString(2, 36);
    private static final String zzG = Integer.toString(3, 36);
    private static final String zzH = Integer.toString(4, 36);
    private static final String zzI = Integer.toString(5, 36);
    private static final String zzJ = Integer.toString(6, 36);
    private static final String zzK = Integer.toString(7, 36);
    private static final String zzL = Integer.toString(8, 36);
    private static final String zzM = Integer.toString(9, 36);
    private static final String zzN = Integer.toString(10, 36);
    private static final String zzO = Integer.toString(11, 36);
    private static final String zzP = Integer.toString(12, 36);
    private static final String zzQ = Integer.toString(13, 36);
    private static final String zzR = Integer.toString(14, 36);
    private static final String zzS = Integer.toString(15, 36);
    private static final String zzT = Integer.toString(16, 36);
    private static final String zzU = Integer.toString(17, 36);
    private static final String zzV = Integer.toString(18, 36);
    private static final String zzW = Integer.toString(19, 36);
    private static final String zzX = Integer.toString(20, 36);
    private static final String zzY = Integer.toString(21, 36);
    private static final String zzZ = Integer.toString(22, 36);
    public static final zzdd zza;
    private static final String zzaa = Integer.toString(23, 36);
    private static final String zzab = Integer.toString(24, 36);
    private static final String zzac = Integer.toString(25, 36);
    private static final String zzad = Integer.toString(26, 36);
    private static final String zzae = Integer.toString(27, 36);
    private static final String zzaf = Integer.toString(28, 36);
    private static final String zzag = Integer.toString(29, 36);
    @Deprecated
    public static final zzdd zzb;
    @Deprecated
    public static final zzn zzc = zzdb.zza;
    public final boolean zzA;
    public final boolean zzB;
    public final zzfsf zzC;
    public final zzfsh zzD;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzfsc zzo;
    public final int zzp;
    public final zzfsc zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final zzfsc zzu;
    public final int zzv;
    public final zzfsc zzw;
    public final int zzx;
    public final int zzy;
    public final boolean zzz;

    static {
        zzdd zzdd = new zzdd(new zzdc());
        zza = zzdd;
        zzb = zzdd;
    }

    protected zzdd(zzdc zzdc) {
        this.zzl = zzdc.zze;
        this.zzm = zzdc.zzf;
        this.zzn = zzdc.zzg;
        this.zzo = zzdc.zzh;
        this.zzp = 0;
        this.zzq = zzdc.zzi;
        this.zzr = 0;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        this.zzu = zzdc.zzl;
        this.zzv = 0;
        this.zzw = zzdc.zzm;
        this.zzx = zzdc.zzn;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        this.zzC = zzfsf.zzc(zzdc.zzo);
        this.zzD = zzfsh.zzl(zzdc.zzp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzdd zzdd = (zzdd) obj;
            if (this.zzn != zzdd.zzn || this.zzl != zzdd.zzl || this.zzm != zzdd.zzm || !this.zzo.equals(zzdd.zzo) || !this.zzq.equals(zzdd.zzq) || !this.zzu.equals(zzdd.zzu) || !this.zzw.equals(zzdd.zzw) || this.zzx != zzdd.zzx || !this.zzC.equals(zzdd.zzC) || !this.zzD.equals(zzdd.zzD)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.zzn ? 1 : 0) - true) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 961) + this.zzq.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzu.hashCode()) * 923521) + this.zzw.hashCode()) * 31) + this.zzx) * 28629151) + this.zzC.hashCode()) * 31) + this.zzD.hashCode();
    }
}
