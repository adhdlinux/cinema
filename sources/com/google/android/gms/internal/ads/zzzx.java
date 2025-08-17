package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;

public final class zzzx {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, UserVerificationMethods.USER_VERIFY_HANDPRINT, Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i2 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i2] * UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i2 = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i2 + i2;
        }
        byte b2 = bArr[4];
        return zzf((b2 & 192) >> 6, b2 & 63);
    }

    public static zzam zzc(zzfa zzfa, String str, String str2, zzad zzad) {
        zzez zzez = new zzez();
        zzez.zzh(zzfa);
        int i2 = zzc[zzez.zzd(2)];
        zzez.zzl(8);
        int i3 = zze[zzez.zzd(3)];
        if (zzez.zzd(1) != 0) {
            i3++;
        }
        int i4 = zzf[zzez.zzd(5)] * 1000;
        zzez.zze();
        zzfa.zzF(zzez.zzb());
        zzak zzak = new zzak();
        zzak.zzH(str);
        zzak.zzS("audio/ac3");
        zzak.zzw(i3);
        zzak.zzT(i2);
        zzak.zzB(zzad);
        zzak.zzK(str2);
        zzak.zzv(i4);
        zzak.zzO(i4);
        return zzak.zzY();
    }

    public static zzam zzd(zzfa zzfa, String str, String str2, zzad zzad) {
        String str3;
        zzez zzez = new zzez();
        zzez.zzh(zzfa);
        int zzd2 = zzez.zzd(13) * 1000;
        zzez.zzl(3);
        int i2 = zzc[zzez.zzd(2)];
        zzez.zzl(10);
        int i3 = zze[zzez.zzd(3)];
        if (zzez.zzd(1) != 0) {
            i3++;
        }
        zzez.zzl(3);
        int zzd3 = zzez.zzd(4);
        zzez.zzl(1);
        if (zzd3 > 0) {
            zzez.zzm(6);
            if (zzez.zzd(1) != 0) {
                i3 += 2;
            }
            zzez.zzl(1);
        }
        if (zzez.zza() > 7) {
            zzez.zzl(7);
            if (zzez.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzez.zze();
                zzfa.zzF(zzez.zzb());
                zzak zzak = new zzak();
                zzak.zzH(str);
                zzak.zzS(str3);
                zzak.zzw(i3);
                zzak.zzT(i2);
                zzak.zzB(zzad);
                zzak.zzK(str2);
                zzak.zzO(zzd2);
                return zzak.zzY();
            }
        }
        str3 = "audio/eac3";
        zzez.zze();
        zzfa.zzF(zzez.zzb());
        zzak zzak2 = new zzak();
        zzak2.zzH(str);
        zzak2.zzS(str3);
        zzak2.zzw(i3);
        zzak2.zzT(i2);
        zzak2.zzB(zzad);
        zzak2.zzK(str2);
        zzak2.zzO(zzd2);
        return zzak2.zzY();
    }

    public static zzzw zze(zzez zzez) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        String str3;
        zzez zzez2 = zzez;
        int zzc2 = zzez.zzc();
        zzez2.zzl(40);
        int zzd2 = zzez2.zzd(5);
        zzez2.zzj(zzc2);
        int i14 = -1;
        if (zzd2 > 10) {
            zzez2.zzl(16);
            int zzd3 = zzez2.zzd(2);
            if (zzd3 == 0) {
                i14 = 0;
            } else if (zzd3 == 1) {
                i14 = 1;
            } else if (zzd3 == 2) {
                i14 = 2;
            }
            zzez2.zzl(3);
            int zzd4 = zzez2.zzd(11) + 1;
            int zzd5 = zzez2.zzd(2);
            if (zzd5 == 3) {
                i11 = zzd[zzez2.zzd(2)];
                i10 = 3;
                i9 = 6;
            } else {
                int zzd6 = zzez2.zzd(2);
                int i15 = zzb[zzd6];
                i10 = zzd6;
                i11 = zzc[zzd5];
                i9 = i15;
            }
            int i16 = zzd4 + zzd4;
            int i17 = (i16 * i11) / (i9 * 32);
            int zzd7 = zzez2.zzd(3);
            boolean zzn = zzez.zzn();
            int i18 = zze[zzd7] + (zzn ? 1 : 0);
            zzez2.zzl(10);
            if (zzez.zzn()) {
                zzez2.zzl(8);
            }
            if (zzd7 == 0) {
                zzez2.zzl(5);
                if (zzez.zzn()) {
                    zzez2.zzl(8);
                }
                i12 = 0;
                zzd7 = 0;
            } else {
                i12 = zzd7;
            }
            if (i14 == 1) {
                if (zzez.zzn()) {
                    zzez2.zzl(16);
                }
                i13 = 1;
            } else {
                i13 = i14;
            }
            if (zzez.zzn()) {
                if (i12 > 2) {
                    zzez2.zzl(2);
                }
                if ((i12 & 1) != 0 && i12 > 2) {
                    zzez2.zzl(6);
                }
                if ((i12 & 4) != 0) {
                    zzez2.zzl(6);
                }
                if (zzn && zzez.zzn()) {
                    zzez2.zzl(5);
                }
                if (i13 == 0) {
                    if (zzez.zzn()) {
                        zzez2.zzl(6);
                    }
                    if (i12 == 0 && zzez.zzn()) {
                        zzez2.zzl(6);
                    }
                    if (zzez.zzn()) {
                        zzez2.zzl(6);
                    }
                    int zzd8 = zzez2.zzd(2);
                    if (zzd8 == 1) {
                        zzez2.zzl(5);
                    } else if (zzd8 == 2) {
                        zzez2.zzl(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzez2.zzd(5);
                        if (zzez.zzn()) {
                            zzez2.zzl(5);
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                zzez2.zzl(4);
                            }
                            if (zzez.zzn()) {
                                if (zzez.zzn()) {
                                    zzez2.zzl(4);
                                }
                                if (zzez.zzn()) {
                                    zzez2.zzl(4);
                                }
                            }
                        }
                        if (zzez.zzn()) {
                            zzez2.zzl(5);
                            if (zzez.zzn()) {
                                zzez2.zzl(7);
                                if (zzez.zzn()) {
                                    zzez2.zzl(8);
                                }
                            }
                        }
                        zzez2.zzl((zzd9 + 2) * 8);
                        zzez.zze();
                    }
                    if (i12 < 2) {
                        if (zzez.zzn()) {
                            zzez2.zzl(14);
                        }
                        if (zzd7 == 0 && zzez.zzn()) {
                            zzez2.zzl(14);
                        }
                    }
                    if (zzez.zzn()) {
                        if (i10 == 0) {
                            zzez2.zzl(5);
                            i13 = 0;
                            i10 = 0;
                        } else {
                            for (int i19 = 0; i19 < i9; i19++) {
                                if (zzez.zzn()) {
                                    zzez2.zzl(5);
                                }
                            }
                        }
                    }
                    i13 = 0;
                }
            }
            if (zzez.zzn()) {
                zzez2.zzl(5);
                if (i12 == 2) {
                    zzez2.zzl(4);
                    i12 = 2;
                }
                if (i12 >= 6) {
                    zzez2.zzl(2);
                }
                if (zzez.zzn()) {
                    zzez2.zzl(8);
                }
                if (i12 == 0 && zzez.zzn()) {
                    zzez2.zzl(8);
                }
                if (zzd5 < 3) {
                    zzez.zzk();
                }
            }
            if (i13 == 0 && i10 != 3) {
                zzez.zzk();
            }
            if (i13 == 2 && (i10 == 3 || zzez.zzn())) {
                zzez2.zzl(6);
            }
            if (zzez.zzn() && zzez2.zzd(6) == 1 && zzez2.zzd(8) == 1) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
            str = str3;
            i7 = i14;
            i4 = i16;
            i5 = i11;
            i3 = i9 * UserVerificationMethods.USER_VERIFY_HANDPRINT;
            i2 = i17;
            i6 = i18;
        } else {
            zzez2.zzl(32);
            int zzd10 = zzez2.zzd(2);
            if (zzd10 == 3) {
                str2 = null;
            } else {
                str2 = "audio/ac3";
            }
            int zzd11 = zzez2.zzd(6);
            int i20 = zzf[zzd11 / 2] * 1000;
            int zzf2 = zzf(zzd10, zzd11);
            zzez2.zzl(8);
            int zzd12 = zzez2.zzd(3);
            if (!((zzd12 & 1) == 0 || zzd12 == 1)) {
                zzez2.zzl(2);
            }
            if ((zzd12 & 4) != 0) {
                zzez2.zzl(2);
            }
            if (zzd12 == 2) {
                zzez2.zzl(2);
            }
            if (zzd10 < 3) {
                i8 = zzc[zzd10];
            } else {
                i8 = -1;
            }
            str = str2;
            i2 = i20;
            i4 = zzf2;
            i5 = i8;
            i6 = zze[zzd12] + (zzez.zzn() ? 1 : 0);
            i7 = -1;
            i3 = 1536;
        }
        return new zzzw(str, i7, i6, i5, i4, i3, i2, (zzzv) null);
    }

    private static int zzf(int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 >= 3 || i3 < 0 || (i4 = i3 >> 1) >= 19) {
            return -1;
        }
        int i5 = zzc[i2];
        if (i5 == 44100) {
            int i6 = zzg[i4] + (i3 & 1);
            return i6 + i6;
        }
        int i7 = zzf[i4];
        return i5 == 32000 ? i7 * 6 : i7 * 4;
    }
}
