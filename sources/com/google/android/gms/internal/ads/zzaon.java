package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

public final class zzaon extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaon zzb;
    private long zzA;
    private long zzB;
    private String zzC = "";
    private String zzD = "D";
    private String zzE = "";
    private long zzF;
    private long zzG;
    private long zzH;
    private String zzI = "";
    private long zzJ;
    private long zzK = -1;
    private long zzL = -1;
    private zzaop zzM;
    private long zzN = -1;
    private long zzO = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private String zzT = "D";
    private String zzU = "D";
    private long zzV = -1;
    private int zzW = 1000;
    private int zzX = 1000;
    private long zzY = -1;
    private long zzZ = -1;
    private int zzaA = 1000;
    private zzgpv zzaB = zzgpm.zzaN();
    private zzaoi zzaC;
    private String zzaD = "";
    private long zzaE = -1;
    private long zzaF = -1;
    private long zzaG = -1;
    private long zzaH = -1;
    private long zzaI;
    private long zzaJ = -1;
    private String zzaK = "";
    private zzanz zzaL;
    private zzaob zzaM;
    private long zzaN = -1;
    private long zzaO = -1;
    private int zzaP;
    private long zzaQ;
    private String zzaR = "";
    private int zzaS = 2;
    private boolean zzaT;
    private String zzaU = "";
    private long zzaV;
    private zzaow zzaW;
    private long zzaX = -1;
    private String zzaY = "";
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private int zzad = 1000;
    private zzaok zzae;
    /* access modifiers changed from: private */
    public zzgpv zzaf = zzgpm.zzaN();
    private zzaom zzag;
    private long zzah = -1;
    private long zzai = -1;
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private String zzap = "D";
    private long zzaq = -1;
    private int zzar;
    private int zzas;
    private int zzat;
    private zzaoy zzau;
    private long zzav = -1;
    private int zzaw = 1000;
    private int zzax = 1000;
    private String zzay = "D";
    private zzgpv zzaz = zzgpm.zzaN();
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private String zzs = "";
    private long zzt;
    private long zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzaon zzaon = new zzaon();
        zzb = zzaon;
        zzgpm.zzaU(zzaon.class, zzaon);
    }

    private zzaon() {
    }

    static /* synthetic */ void zzA(zzaon zzaon, long j2) {
        zzaon.zzd |= 134217728;
        zzaon.zzH = j2;
    }

    static /* synthetic */ void zzB(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzd |= 268435456;
        zzaon.zzI = str;
    }

    static /* synthetic */ void zzC(zzaon zzaon, long j2) {
        zzaon.zzd |= 536870912;
        zzaon.zzJ = j2;
    }

    static /* synthetic */ void zzD(zzaon zzaon, long j2) {
        zzaon.zzd |= 1073741824;
        zzaon.zzK = j2;
    }

    static /* synthetic */ void zzE(zzaon zzaon, long j2) {
        zzaon.zzd |= Integer.MIN_VALUE;
        zzaon.zzL = j2;
    }

    static /* synthetic */ void zzF(zzaon zzaon, long j2) {
        zzaon.zze |= 2;
        zzaon.zzN = j2;
    }

    static /* synthetic */ void zzG(zzaon zzaon, long j2) {
        zzaon.zze |= 4;
        zzaon.zzO = j2;
    }

    static /* synthetic */ void zzH(zzaon zzaon, long j2) {
        zzaon.zze |= 8;
        zzaon.zzP = j2;
    }

    static /* synthetic */ void zzI(zzaon zzaon, long j2) {
        zzaon.zze |= 16;
        zzaon.zzQ = j2;
    }

    static /* synthetic */ void zzJ(zzaon zzaon, long j2) {
        zzaon.zze |= 32;
        zzaon.zzR = j2;
    }

    static /* synthetic */ void zzK(zzaon zzaon, long j2) {
        zzaon.zze |= 64;
        zzaon.zzS = j2;
    }

    static /* synthetic */ void zzL(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zze |= 128;
        zzaon.zzT = str;
    }

    static /* synthetic */ void zzM(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zze |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        zzaon.zzU = str;
    }

    static /* synthetic */ void zzN(zzaon zzaon, long j2) {
        zzaon.zze |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        zzaon.zzY = j2;
    }

    static /* synthetic */ void zzO(zzaon zzaon, long j2) {
        zzaon.zze |= 8192;
        zzaon.zzZ = j2;
    }

    static /* synthetic */ void zzP(zzaon zzaon, long j2) {
        zzaon.zze |= Http2.INITIAL_MAX_FRAME_SIZE;
        zzaon.zzaa = j2;
    }

    static /* synthetic */ void zzQ(zzaon zzaon, zzaok zzaok) {
        zzaok.getClass();
        zzaon.zzae = zzaok;
        zzaon.zze |= 262144;
    }

    static /* synthetic */ void zzR(zzaon zzaon, zzaok zzaok) {
        zzaok.getClass();
        zzgpv zzgpv = zzaon.zzaf;
        if (!zzgpv.zzc()) {
            zzaon.zzaf = zzgpm.zzaO(zzgpv);
        }
        zzaon.zzaf.add(zzaok);
    }

    static /* synthetic */ void zzT(zzaon zzaon, zzaom zzaom) {
        zzaom.getClass();
        zzaon.zzag = zzaom;
        zzaon.zze |= ImageMetadata.LENS_APERTURE;
    }

    static /* synthetic */ void zzU(zzaon zzaon, long j2) {
        zzaon.zze |= 2097152;
        zzaon.zzai = j2;
    }

    static /* synthetic */ void zzV(zzaon zzaon, long j2) {
        zzaon.zze |= 4194304;
        zzaon.zzaj = j2;
    }

    static /* synthetic */ void zzW(zzaon zzaon, long j2) {
        zzaon.zze |= 8388608;
        zzaon.zzak = j2;
    }

    static /* synthetic */ void zzX(zzaon zzaon, long j2) {
        zzaon.zze |= 67108864;
        zzaon.zzan = j2;
    }

    static /* synthetic */ void zzY(zzaon zzaon, long j2) {
        zzaon.zze |= 134217728;
        zzaon.zzao = j2;
    }

    static /* synthetic */ void zzZ(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zze |= 268435456;
        zzaon.zzap = str;
    }

    public static zzanq zza() {
        return (zzanq) zzb.zzaA();
    }

    static /* synthetic */ void zzaa(zzaon zzaon, long j2) {
        zzaon.zzf |= 512;
        zzaon.zzaE = j2;
    }

    static /* synthetic */ void zzab(zzaon zzaon, long j2) {
        zzaon.zzf |= 1024;
        zzaon.zzaF = j2;
    }

    static /* synthetic */ void zzac(zzaon zzaon, long j2) {
        zzaon.zzf |= 2048;
        zzaon.zzaG = j2;
    }

    static /* synthetic */ void zzad(zzaon zzaon, long j2) {
        zzaon.zzf |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        zzaon.zzaH = j2;
    }

    static /* synthetic */ void zzae(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzf |= 32768;
        zzaon.zzaK = str;
    }

    static /* synthetic */ void zzaf(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzf |= 4194304;
        zzaon.zzaR = str;
    }

    static /* synthetic */ void zzag(zzaon zzaon, boolean z2) {
        zzaon.zzf |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        zzaon.zzaT = z2;
    }

    static /* synthetic */ void zzah(zzaon zzaon, long j2) {
        zzaon.zzf |= 67108864;
        zzaon.zzaV = j2;
    }

    static /* synthetic */ void zzam(zzaon zzaon, int i2) {
        zzaon.zzW = i2 - 1;
        zzaon.zze |= 1024;
    }

    static /* synthetic */ void zzan(zzaon zzaon, int i2) {
        zzaon.zzX = i2 - 1;
        zzaon.zze |= 2048;
    }

    static /* synthetic */ void zzao(zzaon zzaon, int i2) {
        zzaon.zzad = i2 - 1;
        zzaon.zze |= 131072;
    }

    static /* synthetic */ void zzap(zzaon zzaon, int i2) {
        zzaon.zzaw = i2 - 1;
        zzaon.zzf |= 8;
    }

    static /* synthetic */ void zzaq(zzaon zzaon, int i2) {
        zzaon.zzax = i2 - 1;
        zzaon.zzf |= 16;
    }

    static /* synthetic */ void zzar(zzaon zzaon, int i2) {
        zzaon.zzaP = i2 - 1;
        zzaon.zzf |= 1048576;
    }

    static /* synthetic */ void zzas(zzaon zzaon, int i2) {
        zzaon.zzaS = 5;
        zzaon.zzf |= 8388608;
    }

    public static zzaon zzd() {
        return zzb;
    }

    public static zzaon zze(byte[] bArr, zzgoy zzgoy) throws zzgpy {
        return (zzaon) zzgpm.zzaI(zzb, bArr, zzgoy);
    }

    static /* synthetic */ void zzi(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzd |= 1;
        zzaon.zzg = str;
    }

    static /* synthetic */ void zzj(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzd |= 2;
        zzaon.zzh = str;
    }

    static /* synthetic */ void zzk(zzaon zzaon, long j2) {
        zzaon.zzd |= 4;
        zzaon.zzi = j2;
    }

    static /* synthetic */ void zzl(zzaon zzaon, long j2) {
        zzaon.zzd |= 16;
        zzaon.zzk = j2;
    }

    static /* synthetic */ void zzm(zzaon zzaon, long j2) {
        zzaon.zzd |= 32;
        zzaon.zzl = j2;
    }

    static /* synthetic */ void zzn(zzaon zzaon, long j2) {
        zzaon.zzd |= 1024;
        zzaon.zzq = j2;
    }

    static /* synthetic */ void zzo(zzaon zzaon, long j2) {
        zzaon.zzd |= 2048;
        zzaon.zzr = j2;
    }

    static /* synthetic */ void zzp(zzaon zzaon, long j2) {
        zzaon.zzd |= 8192;
        zzaon.zzt = j2;
    }

    static /* synthetic */ void zzq(zzaon zzaon, long j2) {
        zzaon.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        zzaon.zzu = j2;
    }

    static /* synthetic */ void zzr(zzaon zzaon, long j2) {
        zzaon.zzd |= 32768;
        zzaon.zzv = j2;
    }

    static /* synthetic */ void zzs(zzaon zzaon, long j2) {
        zzaon.zzd |= 65536;
        zzaon.zzw = j2;
    }

    static /* synthetic */ void zzt(zzaon zzaon, long j2) {
        zzaon.zzd |= ImageMetadata.LENS_APERTURE;
        zzaon.zzz = j2;
    }

    static /* synthetic */ void zzu(zzaon zzaon, long j2) {
        zzaon.zzd |= 1048576;
        zzaon.zzA = j2;
    }

    static /* synthetic */ void zzv(zzaon zzaon, long j2) {
        zzaon.zzd |= 2097152;
        zzaon.zzB = j2;
    }

    static /* synthetic */ void zzw(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzd |= 4194304;
        zzaon.zzC = str;
    }

    static /* synthetic */ void zzx(zzaon zzaon, String str) {
        str.getClass();
        zzaon.zzd |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        zzaon.zzE = str;
    }

    static /* synthetic */ void zzy(zzaon zzaon, long j2) {
        zzaon.zzd |= 33554432;
        zzaon.zzF = j2;
    }

    static /* synthetic */ void zzz(zzaon zzaon, long j2) {
        zzaon.zzd |= 67108864;
        zzaon.zzG = j2;
    }

    public final boolean zzai() {
        return this.zzaT;
    }

    public final boolean zzaj() {
        return (this.zzd & 4194304) != 0;
    }

    public final boolean zzak() {
        return (this.zzf & 134217728) != 0;
    }

    public final int zzal() {
        int zza = zzanw.zza(this.zzaS);
        if (zza == 0) {
            return 3;
        }
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaot.zza;
            return zzgpm.zzaR(zzb, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaQ", "zzA", "zzB", "zzaR", "zzaV", "zzaS", zzanv.zza, "zzC", "zzaT", "zzE", "zzaU", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzaf", zzaok.class, "zzR", "zzS", "zzT", "zzU", "zzW", zzgpq, "zzX", zzgpq, "zzae", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", zzgpq, "zzag", "zzah", "zzai", "zzaj", "zzak", "zzan", "zzao", "zzaq", "zzar", zzaos.zza, "zzas", zzaou.zza, "zzap", "zzat", zzanr.zza, "zzau", "zzav", "zzal", "zzam", "zzaw", zzgpq, "zzV", "zzD", "zzax", zzgpq, "zzay", "zzaz", zzaog.class, "zzaA", zzgpq, "zzaB", zzant.class, "zzaC", "zzaD", "zzaE", "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", zzaod.zza, "zzaW", "zzaX", "zzaY"});
        } else if (i3 == 3) {
            return new zzaon();
        } else {
            if (i3 == 4) {
                return new zzanq((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzaow zzf() {
        zzaow zzaow = this.zzaW;
        return zzaow == null ? zzaow.zzd() : zzaow;
    }

    public final String zzg() {
        return this.zzaR;
    }

    public final String zzh() {
        return this.zzC;
    }
}
