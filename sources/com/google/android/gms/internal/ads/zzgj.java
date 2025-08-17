package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzgj {
    public static final /* synthetic */ int zzj = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final String zzh;
    public final int zzi;

    static {
        zzbq.zzb("media3.datasource");
    }

    public zzgj(Uri uri) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), 0, -1, (String) null, 0, (Object) null);
    }

    /* synthetic */ zzgj(Uri uri, long j2, int i2, byte[] bArr, Map map, long j3, long j4, String str, int i3, Object obj, zzgi zzgi) {
        this(uri, 0, 1, (byte[]) null, map, j3, -1, (String) null, i3, (Object) null);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        long j2 = this.zzf;
        long j3 = this.zzg;
        int i2 = this.zzi;
        return "DataSpec[" + "GET" + " " + valueOf + ", " + j2 + ", " + j3 + ", null, " + i2 + "]";
    }

    public final boolean zza(int i2) {
        return (this.zzi & i2) == i2;
    }

    @Deprecated
    public zzgj(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        this(uri, j2 - j3, 1, (byte[]) null, Collections.emptyMap(), j3, j4, (String) null, i2, (Object) null);
    }

    private zzgj(Uri uri, long j2, int i2, byte[] bArr, Map map, long j3, long j4, String str, int i3, Object obj) {
        long j5 = j2 + j3;
        boolean z2 = false;
        zzdy.zzd(j5 >= 0);
        zzdy.zzd(j3 >= 0);
        if (j4 <= 0) {
            j4 = j4 == -1 ? -1 : j4;
            zzdy.zzd(z2);
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zzf = j3;
            this.zze = j5;
            this.zzg = j4;
            this.zzh = null;
            this.zzi = i3;
        }
        z2 = true;
        zzdy.zzd(z2);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j3;
        this.zze = j5;
        this.zzg = j4;
        this.zzh = null;
        this.zzi = i3;
    }
}
