package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzgoe implements Iterable, Serializable {
    private static final Comparator zza = new zzgnv();
    public static final zzgoe zzb = new zzgoa(zzgpw.zzd);
    private static final zzgod zzd = new zzgod((zzgoc) null);
    private int zzc = 0;

    static {
        int i2 = zzgnp.zza;
    }

    zzgoe() {
    }

    private static zzgoe zzc(Iterator it2, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i2)}));
        } else if (i2 == 1) {
            return (zzgoe) it2.next();
        } else {
            int i3 = i2 >>> 1;
            zzgoe zzc2 = zzc(it2, i3);
            zzgoe zzc3 = zzc(it2, i2 - i3);
            if (Integer.MAX_VALUE - zzc2.zzd() >= zzc3.zzd()) {
                return zzgro.zzC(zzc2, zzc3);
            }
            int zzd2 = zzc2.zzd();
            int zzd3 = zzc3.zzd();
            throw new IllegalArgumentException("ByteString would be too long: " + zzd2 + "+" + zzd3);
        }
    }

    static int zzq(int i2, int i3, int i4) {
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

    public static zzgob zzt() {
        return new zzgob(128);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgoe zzu(java.lang.Iterable r3) {
        /*
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 != 0) goto L_0x0015
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            r0.next()
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0015:
            int r1 = r3.size()
        L_0x0019:
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzgoe r3 = zzb
            return r3
        L_0x001e:
            java.util.Iterator r3 = r3.iterator()
            com.google.android.gms.internal.ads.zzgoe r3 = zzc(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgoe.zzu(java.lang.Iterable):com.google.android.gms.internal.ads.zzgoe");
    }

    public static zzgoe zzv(byte[] bArr, int i2, int i3) {
        zzq(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzgoa(bArr2);
    }

    public static zzgoe zzw(String str) {
        return new zzgoa(str.getBytes(zzgpw.zzb));
    }

    static void zzy(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zzd2 = zzd();
            i2 = zzi(zzd2, 0, zzd2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzgse.zza(this);
        } else {
            str = zzgse.zza(zzk(0, 47)).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final byte[] zzA() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzgpw.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    public abstract byte zza(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i2);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int zzf();

    /* access modifiers changed from: protected */
    public abstract boolean zzh();

    /* access modifiers changed from: protected */
    public abstract int zzi(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int zzj(int i2, int i3, int i4);

    public abstract zzgoe zzk(int i2, int i3);

    public abstract zzgom zzl();

    /* access modifiers changed from: protected */
    public abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    /* access modifiers changed from: package-private */
    public abstract void zzo(zzgnt zzgnt) throws IOException;

    public abstract boolean zzp();

    /* access modifiers changed from: protected */
    public final int zzr() {
        return this.zzc;
    }

    /* renamed from: zzs */
    public zzgny iterator() {
        return new zzgnu(this);
    }

    public final String zzx(Charset charset) {
        return zzd() == 0 ? "" : zzm(charset);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i2, int i3, int i4) {
        zzq(0, i4, zzd());
        zzq(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            zze(bArr, 0, i3, i4);
        }
    }
}
