package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

final class zzgro extends zzgoe {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzgoe zzd;
    /* access modifiers changed from: private */
    public final zzgoe zze;
    private final int zzf;
    private final int zzg;

    private zzgro(zzgoe zzgoe, zzgoe zzgoe2) {
        this.zzd = zzgoe;
        this.zze = zzgoe2;
        int zzd2 = zzgoe.zzd();
        this.zzf = zzd2;
        this.zzc = zzd2 + zzgoe2.zzd();
        this.zzg = Math.max(zzgoe.zzf(), zzgoe2.zzf()) + 1;
    }

    static zzgoe zzC(zzgoe zzgoe, zzgoe zzgoe2) {
        if (zzgoe2.zzd() == 0) {
            return zzgoe;
        }
        if (zzgoe.zzd() == 0) {
            return zzgoe2;
        }
        int zzd2 = zzgoe.zzd() + zzgoe2.zzd();
        if (zzd2 < 128) {
            return zzD(zzgoe, zzgoe2);
        }
        if (zzgoe instanceof zzgro) {
            zzgro zzgro = (zzgro) zzgoe;
            if (zzgro.zze.zzd() + zzgoe2.zzd() < 128) {
                return new zzgro(zzgro.zzd, zzD(zzgro.zze, zzgoe2));
            } else if (zzgro.zzd.zzf() > zzgro.zze.zzf() && zzgro.zzg > zzgoe2.zzf()) {
                return new zzgro(zzgro.zzd, new zzgro(zzgro.zze, zzgoe2));
            }
        }
        if (zzd2 >= zzc(Math.max(zzgoe.zzf(), zzgoe2.zzf()) + 1)) {
            return new zzgro(zzgoe, zzgoe2);
        }
        return zzgrk.zza(new zzgrk((zzgrj) null), zzgoe, zzgoe2);
    }

    private static zzgoe zzD(zzgoe zzgoe, zzgoe zzgoe2) {
        int zzd2 = zzgoe.zzd();
        int zzd3 = zzgoe2.zzd();
        byte[] bArr = new byte[(zzd2 + zzd3)];
        zzgoe.zzz(bArr, 0, 0, zzd2);
        zzgoe2.zzz(bArr, 0, zzd2, zzd3);
        return new zzgoa(bArr);
    }

    static int zzc(int i2) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i2 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    public final boolean equals(Object obj) {
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoe)) {
            return false;
        }
        zzgoe zzgoe = (zzgoe) obj;
        if (this.zzc != zzgoe.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzr = zzr();
        int zzr2 = zzgoe.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        zzgrm zzgrm = new zzgrm(this, (zzgrl) null);
        zzgnz zza2 = zzgrm.next();
        zzgrm zzgrm2 = new zzgrm(zzgoe, (zzgrl) null);
        zzgnz zza3 = zzgrm2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int zzd2 = zza2.zzd() - i2;
            int zzd3 = zza3.zzd() - i3;
            int min = Math.min(zzd2, zzd3);
            if (i2 == 0) {
                z2 = zza2.zzg(zza3, i3, min);
            } else {
                z2 = zza3.zzg(zza2, i2, min);
            }
            if (!z2) {
                return false;
            }
            i4 += min;
            int i5 = this.zzc;
            if (i4 < i5) {
                if (min == zzd2) {
                    zza2 = zzgrm.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == zzd3) {
                    zza3 = zzgrm2.next();
                    i3 = 0;
                } else {
                    i3 += min;
                }
            } else if (i4 == i5) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzgri(this);
    }

    public final byte zza(int i2) {
        zzgoe.zzy(i2, this.zzc);
        return zzb(i2);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i2) {
        int i3 = this.zzf;
        if (i2 < i3) {
            return this.zzd.zzb(i2);
        }
        return this.zze.zzb(i2 - i3);
    }

    public final int zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            this.zzd.zze(bArr, i2, i3, i4);
        } else if (i2 >= i6) {
            this.zze.zze(bArr, i2 - i6, i3, i4);
        } else {
            int i7 = i6 - i2;
            this.zzd.zze(bArr, i2, i3, i7);
            this.zze.zze(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            return this.zzd.zzi(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zze.zzi(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zze.zzi(this.zzd.zzi(i2, i3, i7), 0, i4 - i7);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            return this.zzd.zzj(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zze.zzj(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zze.zzj(this.zzd.zzj(i2, i3, i7), 0, i4 - i7);
    }

    public final zzgoe zzk(int i2, int i3) {
        int zzq = zzgoe.zzq(i2, i3, this.zzc);
        if (zzq == 0) {
            return zzgoe.zzb;
        }
        if (zzq == this.zzc) {
            return this;
        }
        int i4 = this.zzf;
        if (i3 <= i4) {
            return this.zzd.zzk(i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzk(i2 - i4, i3 - i4);
        }
        zzgoe zzgoe = this.zzd;
        return new zzgro(zzgoe.zzk(i2, zzgoe.zzd()), this.zze.zzk(0, i3 - this.zzf));
    }

    public final zzgom zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList<>();
        zzgrm zzgrm = new zzgrm(this, (zzgrl) null);
        while (zzgrm.hasNext()) {
            arrayList.add(zzgrm.next().zzn());
        }
        int i2 = zzgom.zzd;
        boolean z2 = false;
        int i3 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i3 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z2 |= true;
            } else if (byteBuffer.isDirect()) {
                z2 |= true;
            } else {
                z2 |= true;
            }
        }
        if (z2) {
            return new zzgoi(arrayList, i3, true, (zzgoh) null);
        }
        return zzgom.zzH(new zzgpz(arrayList), CodedOutputStream.DEFAULT_BUFFER_SIZE);
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    public final ByteBuffer zzn() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(zzgnt zzgnt) throws IOException {
        this.zzd.zzo(zzgnt);
        this.zze.zzo(zzgnt);
    }

    public final boolean zzp() {
        int zzj = this.zzd.zzj(0, 0, this.zzf);
        zzgoe zzgoe = this.zze;
        if (zzgoe.zzj(zzj, 0, zzgoe.zzd()) == 0) {
            return true;
        }
        return false;
    }

    public final zzgny zzs() {
        return new zzgri(this);
    }
}
