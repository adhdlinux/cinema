package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzjb implements Iterable, Serializable {
    private static final Comparator zza = new zzit();
    public static final zzjb zzb = new zziy(zzkk.zzd);
    private static final zzja zzd = new zzja((zziz) null);
    private int zzc = 0;

    static {
        int i2 = zzin.zza;
    }

    zzjb() {
    }

    static int zzj(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    public static zzjb zzl(byte[] bArr, int i2, int i3) {
        zzj(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zziy(bArr2);
    }

    public static zzjb zzm(String str) {
        return new zziy(str.getBytes(zzkk.zzb));
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
        return new zzis(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzmj.zza(this);
        } else {
            str = zzmj.zza(zzf(0, 47)).concat("...");
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

    public abstract zzjb zzf(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zzg(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzh(zzir zzir) throws IOException;

    public abstract boolean zzi();

    /* access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
