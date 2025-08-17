package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzdt {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzdt(int i2, int i3, float f2, float f3, int i4) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = f2;
        this.zzd = f3;
        this.zze = ((float) i2) / ((float) i4);
        this.zzf = i2 / 400;
        int i5 = i2 / 65;
        this.zzg = i5;
        int i6 = i5 + i5;
        this.zzh = i6;
        this.zzi = new short[i6];
        int i7 = i6 * i3;
        this.zzj = new short[i7];
        this.zzl = new short[i7];
        this.zzn = new short[i7];
    }

    private final int zzg(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.zzb;
        int i6 = 1;
        int i7 = JfifUtil.MARKER_FIRST_BYTE;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            int i12 = i10 * i8;
            int i13 = i6 * i3;
            if (i12 < i13) {
                i6 = i10;
            }
            if (i12 < i13) {
                i8 = i3;
            }
            int i14 = i10 * i7;
            int i15 = i9 * i3;
            if (i14 > i15) {
                i9 = i10;
            }
            if (i14 > i15) {
                i7 = i3;
            }
            i3++;
        }
        this.zzu = i6 / i8;
        this.zzv = i9 / i7;
        return i8;
    }

    private final void zzh(short[] sArr, int i2, int i3) {
        short[] zzl2 = zzl(this.zzl, this.zzm, i3);
        this.zzl = zzl2;
        int i4 = this.zzb;
        System.arraycopy(sArr, i2 * i4, zzl2, this.zzm * i4, i4 * i3);
        this.zzm += i3;
    }

    private final void zzi(short[] sArr, int i2, int i3) {
        int i4 = this.zzh / i3;
        int i5 = this.zzb;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.zzi[i8] = (short) (i9 / i6);
        }
    }

    private static void zzj(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i10] = (short) (((sArr2[i8] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }

    private final void zzk() {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = this.zzm;
        float f2 = this.zzc;
        float f3 = this.zzd;
        float f4 = f2 / f3;
        float f5 = this.zze * f3;
        double d2 = (double) f4;
        float f6 = 1.0f;
        int i13 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i14 = this.zzk;
            if (i14 >= this.zzh) {
                int i15 = 0;
                while (true) {
                    int i16 = this.zzr;
                    if (i16 > 0) {
                        int min = Math.min(this.zzh, i16);
                        zzh(this.zzj, i15, min);
                        this.zzr -= min;
                        i15 += min;
                    } else {
                        short[] sArr = this.zzj;
                        int i17 = this.zza;
                        if (i17 > 4000) {
                            i6 = i17 / 4000;
                        } else {
                            i6 = 1;
                        }
                        if (this.zzb == i13 && i6 == i13) {
                            i7 = zzg(sArr, i15, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i15, i6);
                            int zzg2 = zzg(this.zzi, 0, this.zzf / i6, this.zzg / i6);
                            if (i6 != i13) {
                                int i18 = zzg2 * i6;
                                int i19 = i6 * 4;
                                int i20 = this.zzf;
                                int i21 = i18 - i19;
                                if (i21 >= i20) {
                                    i20 = i21;
                                }
                                int i22 = i18 + i19;
                                int i23 = this.zzg;
                                if (i22 > i23) {
                                    i22 = i23;
                                }
                                if (this.zzb == i13) {
                                    i7 = zzg(sArr, i15, i20, i22);
                                } else {
                                    zzi(sArr, i15, i13);
                                    i7 = zzg(this.zzi, 0, i20, i22);
                                }
                            } else {
                                i7 = zzg2;
                            }
                        }
                        int i24 = this.zzu;
                        int i25 = this.zzv;
                        if (i24 == 0 || (i11 = this.zzs) == 0 || i25 > i24 * 3 || i24 + i24 <= this.zzt * 3) {
                            i8 = i7;
                        } else {
                            i8 = i11;
                        }
                        this.zzt = i24;
                        this.zzs = i7;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.zzj;
                            if (f4 >= 2.0f) {
                                i10 = (int) (((float) i8) / (-1.0f + f4));
                            } else {
                                this.zzr = (int) ((((float) i8) * (2.0f - f4)) / (-1.0f + f4));
                                i10 = i8;
                            }
                            short[] zzl2 = zzl(this.zzl, this.zzm, i10);
                            this.zzl = zzl2;
                            int i26 = i10;
                            short[] sArr3 = sArr2;
                            zzj(i10, this.zzb, zzl2, this.zzm, sArr3, i15, sArr3, i15 + i8);
                            this.zzm += i26;
                            i15 += i8 + i26;
                        } else {
                            int i27 = i8;
                            short[] sArr4 = this.zzj;
                            if (f4 < 0.5f) {
                                i9 = (int) ((((float) i27) * f4) / (f6 - f4));
                            } else {
                                this.zzr = (int) ((((float) i27) * ((f4 + f4) - 4.0f)) / (f6 - f4));
                                i9 = i27;
                            }
                            int i28 = i27 + i9;
                            short[] zzl3 = zzl(this.zzl, this.zzm, i28);
                            this.zzl = zzl3;
                            int i29 = this.zzb;
                            System.arraycopy(sArr4, i15 * i29, zzl3, this.zzm * i29, i29 * i27);
                            zzj(i9, this.zzb, this.zzl, this.zzm + i27, sArr4, i15 + i27, sArr4, i15);
                            this.zzm += i28;
                            i15 += i9;
                        }
                    }
                    if (this.zzh + i15 > i14) {
                        break;
                    }
                    f6 = 1.0f;
                    i13 = 1;
                }
                int i30 = this.zzk - i15;
                short[] sArr5 = this.zzj;
                int i31 = this.zzb;
                System.arraycopy(sArr5, i15 * i31, sArr5, 0, i31 * i30);
                this.zzk = i30;
                f6 = 1.0f;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        if (f5 != f6 && this.zzm != i12) {
            int i32 = this.zza;
            int i33 = (int) (((float) i32) / f5);
            while (true) {
                if (i33 <= 16384 && i32 <= 16384) {
                    break;
                }
                i33 /= 2;
                i32 /= 2;
            }
            int i34 = this.zzm - i12;
            short[] zzl4 = zzl(this.zzn, this.zzo, i34);
            this.zzn = zzl4;
            short[] sArr6 = this.zzl;
            int i35 = this.zzb;
            System.arraycopy(sArr6, i12 * i35, zzl4, this.zzo * i35, i35 * i34);
            this.zzm = i12;
            this.zzo += i34;
            int i36 = 0;
            while (true) {
                i2 = this.zzo;
                i3 = i2 - 1;
                if (i36 >= i3) {
                    break;
                }
                while (true) {
                    i4 = this.zzp + 1;
                    int i37 = i4 * i33;
                    i5 = this.zzq;
                    if (i37 <= i5 * i32) {
                        break;
                    }
                    this.zzl = zzl(this.zzl, this.zzm, 1);
                    int i38 = 0;
                    while (true) {
                        int i39 = this.zzb;
                        if (i38 >= i39) {
                            break;
                        }
                        short[] sArr7 = this.zzl;
                        int i40 = this.zzm * i39;
                        short[] sArr8 = this.zzn;
                        int i41 = (i36 * i39) + i38;
                        short s2 = sArr8[i41];
                        short s3 = sArr8[i41 + i39];
                        int i42 = this.zzp;
                        int i43 = i42 * i33;
                        int i44 = (i42 + 1) * i33;
                        int i45 = i44 - (this.zzq * i32);
                        int i46 = i44 - i43;
                        sArr7[i40 + i38] = (short) (((s2 * i45) + ((i46 - i45) * s3)) / i46);
                        i38++;
                    }
                    this.zzq++;
                    this.zzm++;
                }
                this.zzp = i4;
                if (i4 == i32) {
                    this.zzp = 0;
                    if (i5 == i33) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzdy.zzf(z2);
                    this.zzq = 0;
                }
                i36++;
            }
            if (i3 != 0) {
                short[] sArr9 = this.zzn;
                int i47 = this.zzb;
                System.arraycopy(sArr9, i3 * i47, sArr9, 0, (i2 - i3) * i47);
                this.zzo -= i3;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.zzb;
        int i5 = length / i4;
        if (i2 + i3 <= i5) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    public final int zza() {
        int i2 = this.zzm * this.zzb;
        return i2 + i2;
    }

    public final int zzb() {
        int i2 = this.zzk * this.zzb;
        return i2 + i2;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i2 = this.zzm - min;
        this.zzm = i2;
        short[] sArr = this.zzl;
        int i3 = this.zzb;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public final void zze() {
        int i2;
        int i3 = this.zzk;
        float f2 = this.zzc;
        float f3 = this.zzd;
        int i4 = this.zzm + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.zzo)) / (this.zze * f3)) + 0.5f));
        short[] sArr = this.zzj;
        int i5 = this.zzh;
        this.zzj = zzl(sArr, i3, i5 + i5 + i3);
        int i6 = 0;
        while (true) {
            int i7 = this.zzh;
            i2 = i7 + i7;
            int i8 = this.zzb;
            if (i6 >= i2 * i8) {
                break;
            }
            this.zzj[(i8 * i3) + i6] = 0;
            i6++;
        }
        this.zzk += i2;
        zzk();
        if (this.zzm > i4) {
            this.zzm = i4;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.zzb;
        int i3 = remaining / i2;
        int i4 = i2 * i3;
        short[] zzl2 = zzl(this.zzj, this.zzk, i3);
        this.zzj = zzl2;
        shortBuffer.get(zzl2, this.zzk * this.zzb, (i4 + i4) / 2);
        this.zzk += i3;
        zzk();
    }
}
