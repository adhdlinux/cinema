package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzrm implements Iterable, Serializable {
    private static final Comparator zza = new zzre();
    public static final zzrm zzb = new zzrj(zzsq.zzd);
    private static final zzrl zzd = new zzrl((zzrk) null);
    private int zzc = 0;

    static {
        int i2 = zzrb.zza;
    }

    zzrm() {
    }

    static int zzj(int i2, int i3, int i4) {
        if (((i4 - i3) | i3) >= 0) {
            return i3;
        }
        throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zzd2 = zzd();
            i2 = zze(zzd2, 0, zzd2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzrd(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzup.zza(this);
        } else {
            str = zzup.zza(zzf(0, 47)).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i2);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract int zze(int i2, int i3, int i4);

    public abstract zzrm zzf(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zzg(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzh(zzrc zzrc) throws IOException;

    public abstract boolean zzi();

    /* access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final String zzl(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
