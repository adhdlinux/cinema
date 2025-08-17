package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzgl implements zzge {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzge zzc;
    private zzge zzd;
    private zzge zze;
    private zzge zzf;
    private zzge zzg;
    private zzge zzh;
    private zzge zzi;
    private zzge zzj;
    private zzge zzk;

    public zzgl(Context context, zzge zzge) {
        this.zza = context.getApplicationContext();
        this.zzc = zzge;
    }

    private final zzge zzg() {
        if (this.zze == null) {
            zzfx zzfx = new zzfx(this.zza);
            this.zze = zzfx;
            zzh(zzfx);
        }
        return this.zze;
    }

    private final void zzh(zzge zzge) {
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzge.zzf((zzhg) this.zzb.get(i2));
        }
    }

    private static final void zzi(zzge zzge, zzhg zzhg) {
        if (zzge != null) {
            zzge.zzf(zzhg);
        }
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        zzge zzge = this.zzk;
        zzge.getClass();
        return zzge.zza(bArr, i2, i3);
    }

    public final long zzb(zzgj zzgj) throws IOException {
        boolean z2;
        zzge zzge;
        if (this.zzk == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        String scheme = zzgj.zza.getScheme();
        Uri uri = zzgj.zza;
        int i2 = zzfj.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzgj.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgu zzgu = new zzgu();
                    this.zzd = zzgu;
                    zzh(zzgu);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzgb zzgb = new zzgb(this.zza);
                this.zzf = zzgb;
                zzh(zzgb);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzge zzge2 = (zzge) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzge2;
                    zzh(zzge2);
                } catch (ClassNotFoundException unused) {
                    zzer.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating RTMP extension", e2);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzhi zzhi = new zzhi(2000);
                this.zzh = zzhi;
                zzh(zzhi);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzgc zzgc = new zzgc();
                this.zzi = zzgc;
                zzh(zzgc);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
                if (this.zzj == null) {
                    zzhe zzhe = new zzhe(this.zza);
                    this.zzj = zzhe;
                    zzh(zzhe);
                }
                zzge = this.zzj;
            } else {
                zzge = this.zzc;
            }
            this.zzk = zzge;
        }
        return this.zzk.zzb(zzgj);
    }

    public final Uri zzc() {
        zzge zzge = this.zzk;
        if (zzge == null) {
            return null;
        }
        return zzge.zzc();
    }

    public final void zzd() throws IOException {
        zzge zzge = this.zzk;
        if (zzge != null) {
            try {
                zzge.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzge zzge = this.zzk;
        return zzge == null ? Collections.emptyMap() : zzge.zze();
    }

    public final void zzf(zzhg zzhg) {
        zzhg.getClass();
        this.zzc.zzf(zzhg);
        this.zzb.add(zzhg);
        zzi(this.zzd, zzhg);
        zzi(this.zze, zzhg);
        zzi(this.zzf, zzhg);
        zzi(this.zzg, zzhg);
        zzi(this.zzh, zzhg);
        zzi(this.zzi, zzhg);
        zzi(this.zzj, zzhg);
    }
}
