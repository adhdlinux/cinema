package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.device.MimeTypes;
import okhttp3.internal.http2.Http2;

public final class zzrs {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    zzrs(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z2;
        this.zze = z5;
        this.zzf = z7;
        this.zzh = zzcc.zzg(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r12) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ("Nexus 10".equals(r3) == false) goto L_0x003b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzrs zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zzrs r11 = new com.google.android.gms.internal.ads.zzrs
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L_0x003d
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x003d
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            r5 = 22
            if (r3 > r5) goto L_0x003b
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x002a
            java.lang.String r5 = "Nexus 10"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x003b
        L_0x002a:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x003d
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r8 = 1
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            r3 = 21
            if (r4 == 0) goto L_0x0050
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            if (r5 < r3) goto L_0x0050
            java.lang.String r5 = "tunneled-playback"
            boolean r5 = r15.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0050
            r9 = 1
            goto L_0x0051
        L_0x0050:
            r9 = 0
        L_0x0051:
            if (r20 != 0) goto L_0x0064
            if (r4 == 0) goto L_0x0062
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            if (r5 < r3) goto L_0x0062
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r10 = 0
            goto L_0x0065
        L_0x0064:
            r10 = 1
        L_0x0065:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrs.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzrs");
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i4 = zzfj.zza;
        return new Point((((i2 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i3 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = zzfj.zze;
        zzer.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + str2 + ", " + str3 + "] [" + str4 + "]");
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point zzi = zzi(videoCapabilities, i2, i3);
        int i4 = zzi.x;
        int i5 = zzi.y;
        if (d2 == -1.0d || d2 < 1.0d) {
            return videoCapabilities.isSizeSupported(i4, i5);
        }
        return videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    private final boolean zzl(zzam zzam, boolean z2) {
        int i2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair zzb2 = zzsl.zzb(zzam);
        if (zzb2 == null) {
            return true;
        }
        int intValue = ((Integer) zzb2.first).intValue();
        int intValue2 = ((Integer) zzb2.second).intValue();
        int i3 = 8;
        if ("video/dolby-vision".equals(zzam.zzm)) {
            if (MimeTypes.VIDEO_H264.equals(this.zzb)) {
                intValue2 = 0;
                intValue = 8;
            } else if (MimeTypes.VIDEO_H265.equals(this.zzb)) {
                intValue2 = 0;
                intValue = 2;
            }
        }
        if (!this.zzh && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] zzh2 = zzh();
        if (zzfj.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && zzh2.length == 0) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                i2 = 0;
            } else {
                i2 = videoCapabilities.getBitrateRange().getUpper().intValue();
            }
            if (i2 >= 180000000) {
                i3 = 1024;
            } else if (i2 >= 120000000) {
                i3 = 512;
            } else if (i2 >= 60000000) {
                i3 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
            } else if (i2 >= 30000000) {
                i3 = 128;
            } else if (i2 >= 18000000) {
                i3 = 64;
            } else if (i2 >= 12000000) {
                i3 = 32;
            } else if (i2 >= 7200000) {
                i3 = 16;
            } else if (i2 < 3600000) {
                if (i2 >= 1800000) {
                    i3 = 4;
                } else if (i2 >= 800000) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            }
            MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            codecProfileLevel.profile = 1;
            codecProfileLevel.level = i3;
            zzh2 = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : zzh2) {
            if (codecProfileLevel2.profile == intValue && (codecProfileLevel2.level >= intValue2 || !z2)) {
                if (MimeTypes.VIDEO_H265.equals(this.zzb) && intValue == 2) {
                    String str = zzfj.zzb;
                    if (!"sailfish".equals(str) && !"marlin".equals(str)) {
                    }
                }
                return true;
            }
        }
        zzj("codec.profileLevel, " + zzam.zzj + ", " + this.zzc);
        return false;
    }

    private final boolean zzm(zzam zzam) {
        if (this.zzb.equals(zzam.zzm) || this.zzb.equals(zzsl.zze(zzam))) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i2, i3);
    }

    public final zzia zzb(zzam zzam, zzam zzam2) {
        int i2;
        int i3;
        if (true != zzfj.zzC(zzam.zzm, zzam2.zzm)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        if (this.zzh) {
            if (zzam.zzu != zzam2.zzu) {
                i2 |= 1024;
            }
            if (!this.zze && !(zzam.zzr == zzam2.zzr && zzam.zzs == zzam2.zzs)) {
                i2 |= 512;
            }
            if (!zzfj.zzC(zzam.zzy, zzam2.zzy)) {
                i2 |= 2048;
            }
            String str = this.zza;
            if (zzfj.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzam.zzd(zzam2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                String str2 = this.zza;
                if (true != zzam.zzd(zzam2)) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                return new zzia(str2, zzam, zzam2, i3, 0);
            }
        } else {
            if (zzam.zzz != zzam2.zzz) {
                i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
            if (zzam.zzA != zzam2.zzA) {
                i2 |= 8192;
            }
            if (zzam.zzB != zzam2.zzB) {
                i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair zzb2 = zzsl.zzb(zzam);
                Pair zzb3 = zzsl.zzb(zzam2);
                if (!(zzb2 == null || zzb3 == null)) {
                    int intValue = ((Integer) zzb2.first).intValue();
                    int intValue2 = ((Integer) zzb3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzia(this.zza, zzam, zzam2, 3, 0);
                    }
                }
            }
            if (!zzam.zzd(zzam2)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new zzia(this.zza, zzam, zzam2, 1, 0);
            }
        }
        return new zzia(this.zza, zzam, zzam2, 0, i2);
    }

    public final boolean zzd(zzam zzam) {
        if (!zzm(zzam) || !zzl(zzam, false)) {
            return false;
        }
        return true;
    }

    public final boolean zze(zzam zzam) throws zzsf {
        int i2;
        int i3;
        boolean z2 = false;
        if (!zzm(zzam) || !zzl(zzam, true)) {
            return false;
        }
        if (this.zzh) {
            int i4 = zzam.zzr;
            if (i4 <= 0 || (i3 = zzam.zzs) <= 0) {
                return true;
            }
            if (zzfj.zza >= 21) {
                return zzg(i4, i3, (double) zzam.zzt);
            }
            if (i4 * i3 <= zzsl.zza()) {
                z2 = true;
            }
            if (!z2) {
                int i5 = zzam.zzr;
                int i6 = zzam.zzs;
                zzj("legacyFrameSize, " + i5 + "x" + i6);
            }
            return z2;
        }
        int i7 = zzfj.zza;
        if (i7 >= 21) {
            int i8 = zzam.zzA;
            if (i8 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                if (codecCapabilities == null) {
                    zzj("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    zzj("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i8)) {
                    zzj("sampleRate.support, " + i8);
                    return false;
                }
            }
            int i9 = zzam.zzz;
            if (i9 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
                if (codecCapabilities2 == null) {
                    zzj("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        zzj("channelCount.aCaps");
                    } else {
                        String str = this.zza;
                        String str2 = this.zzb;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i7 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                            if ("audio/ac3".equals(str2)) {
                                i2 = 6;
                            } else if ("audio/eac3".equals(str2)) {
                                i2 = 16;
                            } else {
                                i2 = 30;
                            }
                            zzer.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i2 + "]");
                            maxInputChannelCount = i2;
                        }
                        if (maxInputChannelCount < i9) {
                            zzj("channelCount.support, " + i9);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean zzf(zzam zzam) {
        if (this.zzh) {
            return this.zze;
        }
        Pair zzb2 = zzsl.zzb(zzam);
        if (zzb2 == null || ((Integer) zzb2.first).intValue() != 42) {
            return false;
        }
        return true;
    }

    public final boolean zzg(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzfj.zza >= 29) {
            int zza2 = zzrr.zza(videoCapabilities, i2, i3, d2);
            if (zza2 == 2) {
                return true;
            }
            if (zza2 == 1) {
                zzj("sizeAndRate.cover, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
        }
        if (!zzk(videoCapabilities, i2, i3, d2)) {
            if (i2 >= i3 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzfj.zzb)) || !zzk(videoCapabilities, i3, i2, d2))) {
                zzj("sizeAndRate.support, " + i2 + "x" + i3 + "@" + d2);
                return false;
            }
            zzer.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i2 + "x" + i3 + "@" + d2) + "] [" + this.zza + ", " + this.zzb + "] [" + zzfj.zze + "]");
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaCodecInfo.CodecProfileLevel[] zzh() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzd
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrs.zzh():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }
}
