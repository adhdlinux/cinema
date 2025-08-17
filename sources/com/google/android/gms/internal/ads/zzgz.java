package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

public final class zzgz extends zzgx {
    public final int zzd;
    public final String zze;
    public final Map zzf;
    public final byte[] zzg;

    public zzgz(int i2, String str, IOException iOException, Map map, zzgj zzgj, byte[] bArr) {
        super("Response code: " + i2, iOException, zzgj, 2004, 1);
        this.zzd = i2;
        this.zze = str;
        this.zzf = map;
        this.zzg = bArr;
    }
}
