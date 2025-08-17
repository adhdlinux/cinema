package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzny implements zzlv, zznz {
    private final Context zza;
    private final zzoa zzb;
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzcv zze = new zzcv();
    private final zzct zzf = new zzct();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzcf zzn;
    private zznx zzo;
    private zznx zzp;
    private zznx zzq;
    private zzam zzr;
    private zzam zzs;
    private zzam zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzny(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zznw zznw = new zznw(zznw.zza);
        this.zzb = zznw;
        zznw.zzg(this);
    }

    public static zzny zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzny(context, mediaMetricsManager.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    private static int zzr(int i2) {
        switch (zzfj.zzh(i2)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j2;
        long j3;
        int i2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.zzy);
            PlaybackMetrics.Builder unused2 = this.zzj.setVideoFramesDropped(this.zzw);
            PlaybackMetrics.Builder unused3 = this.zzj.setVideoFramesPlayed(this.zzx);
            Long l2 = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            PlaybackMetrics.Builder unused4 = builder2.setNetworkTransferDurationMillis(j2);
            Long l3 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l3 == null) {
                j3 = 0;
            } else {
                j3 = l3.longValue();
            }
            PlaybackMetrics.Builder unused5 = builder3.setNetworkBytesRead(j3);
            PlaybackMetrics.Builder builder4 = this.zzj;
            if (l3 == null || l3.longValue() <= 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused6 = builder4.setStreamSource(i2);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j2, zzam zzam, int i2) {
        int i3;
        if (!zzfj.zzC(this.zzs, zzam)) {
            if (this.zzs == null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.zzs = zzam;
            zzx(0, j2, zzam, i3);
        }
    }

    private final void zzu(long j2, zzam zzam, int i2) {
        int i3;
        if (!zzfj.zzC(this.zzt, zzam)) {
            if (this.zzt == null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.zzt = zzam;
            zzx(2, j2, zzam, i3);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcw zzcw, zzto zzto) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzto != null && (zza2 = zzcw.zza(zzto.zza)) != -1) {
            int i2 = 0;
            zzcw.zzd(zza2, this.zzf, false);
            zzcw.zze(this.zzf.zzd, this.zze, 0);
            zzbi zzbi = this.zze.zzd.zzd;
            int i3 = 2;
            if (zzbi != null) {
                int zzl2 = zzfj.zzl(zzbi.zzb);
                if (zzl2 == 0) {
                    i2 = 3;
                } else if (zzl2 == 1) {
                    i2 = 5;
                } else if (zzl2 != 2) {
                    i2 = 1;
                } else {
                    i2 = 4;
                }
            }
            PlaybackMetrics.Builder unused = builder.setStreamType(i2);
            zzcv zzcv = this.zze;
            if (zzcv.zzn != -9223372036854775807L && !zzcv.zzl && !zzcv.zzi && !zzcv.zzb()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(zzfj.zzq(this.zze.zzn));
            }
            if (true != this.zze.zzb()) {
                i3 = 1;
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(i3);
            this.zzz = true;
        }
    }

    private final void zzw(long j2, zzam zzam, int i2) {
        int i3;
        if (!zzfj.zzC(this.zzr, zzam)) {
            if (this.zzr == null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.zzr = zzam;
            zzx(1, j2, zzam, i3);
        }
    }

    private final void zzx(int i2, long j2, zzam zzam, int i3) {
        int i4;
        String str;
        TrackChangeEvent.Builder a2 = new TrackChangeEvent.Builder(i2).setTimeSinceCreatedMillis(j2 - this.zzd);
        if (zzam != null) {
            TrackChangeEvent.Builder unused = a2.setTrackState(1);
            if (i3 != 1) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            TrackChangeEvent.Builder unused2 = a2.setTrackChangeReason(i4);
            String str2 = zzam.zzl;
            if (str2 != null) {
                TrackChangeEvent.Builder unused3 = a2.setContainerMimeType(str2);
            }
            String str3 = zzam.zzm;
            if (str3 != null) {
                TrackChangeEvent.Builder unused4 = a2.setSampleMimeType(str3);
            }
            String str4 = zzam.zzj;
            if (str4 != null) {
                TrackChangeEvent.Builder unused5 = a2.setCodecName(str4);
            }
            int i5 = zzam.zzi;
            if (i5 != -1) {
                TrackChangeEvent.Builder unused6 = a2.setBitrate(i5);
            }
            int i6 = zzam.zzr;
            if (i6 != -1) {
                TrackChangeEvent.Builder unused7 = a2.setWidth(i6);
            }
            int i7 = zzam.zzs;
            if (i7 != -1) {
                TrackChangeEvent.Builder unused8 = a2.setHeight(i7);
            }
            int i8 = zzam.zzz;
            if (i8 != -1) {
                TrackChangeEvent.Builder unused9 = a2.setChannelCount(i8);
            }
            int i9 = zzam.zzA;
            if (i9 != -1) {
                TrackChangeEvent.Builder unused10 = a2.setAudioSampleRate(i9);
            }
            String str5 = zzam.zzd;
            if (str5 != null) {
                int i10 = zzfj.zza;
                String[] split = str5.split("-", -1);
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                TrackChangeEvent.Builder unused11 = a2.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    TrackChangeEvent.Builder unused12 = a2.setLanguageRegion((String) obj);
                }
            }
            float f2 = zzam.zzt;
            if (f2 != -1.0f) {
                TrackChangeEvent.Builder unused13 = a2.setVideoFrameRate(f2);
            }
        } else {
            TrackChangeEvent.Builder unused14 = a2.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(a2.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zznx zznx) {
        return zznx != null && zznx.zzc.equals(this.zzb.zzd());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzlt zzlt, String str) {
        zzto zzto = zzlt.zzd;
        if (zzto == null || !zzto.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.1.0-beta01");
            zzv(zzlt.zzb, zzlt.zzd);
        }
    }

    public final void zzd(zzlt zzlt, String str, boolean z2) {
        zzto zzto = zzlt.zzd;
        if ((zzto == null || !zzto.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzlt zzlt, zzam zzam, zzia zzia) {
    }

    public final void zzf(zzlt zzlt, int i2, long j2, long j3) {
        long j4;
        zzto zzto = zzlt.zzd;
        if (zzto != null) {
            String zze2 = this.zzb.zze(zzlt.zzb, zzto);
            Long l2 = (Long) this.zzh.get(zze2);
            Long l3 = (Long) this.zzg.get(zze2);
            HashMap hashMap = this.zzh;
            long j5 = 0;
            if (l2 == null) {
                j4 = 0;
            } else {
                j4 = l2.longValue();
            }
            hashMap.put(zze2, Long.valueOf(j4 + j2));
            HashMap hashMap2 = this.zzg;
            if (l3 != null) {
                j5 = l3.longValue();
            }
            hashMap2.put(zze2, Long.valueOf(j5 + ((long) i2)));
        }
    }

    public final void zzg(zzlt zzlt, zztk zztk) {
        zzto zzto = zzlt.zzd;
        if (zzto != null) {
            zzam zzam = zztk.zzb;
            zzam.getClass();
            zznx zznx = new zznx(zzam, 0, this.zzb.zze(zzlt.zzb, zzto));
            int i2 = zztk.zza;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.zzp = zznx;
                    return;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.zzq = zznx;
                        return;
                    }
                    return;
                }
            }
            this.zzo = zznx;
        }
    }

    public final /* synthetic */ void zzh(zzlt zzlt, int i2, long j2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e6, code lost:
        if (r8 != 1) goto L_0x01ea;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzcp r19, com.google.android.gms.internal.ads.zzlu r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 == 0) goto L_0x03cd
            r2 = 0
            r3 = 0
        L_0x000c:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0036
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzlt r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzoa r4 = r0.zzb
            r4.zzj(r6)
            goto L_0x0033
        L_0x0024:
            if (r4 != r5) goto L_0x002e
            com.google.android.gms.internal.ads.zzoa r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzi(r6, r5)
            goto L_0x0033
        L_0x002e:
            com.google.android.gms.internal.ads.zzoa r4 = r0.zzb
            r4.zzh(r6)
        L_0x0033:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0036:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzlt r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzcw r7 = r6.zzb
            com.google.android.gms.internal.ads.zzto r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x004f:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00c6
            com.google.android.gms.internal.ads.zzdh r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzfsc r7 = r7.zza()
            int r12 = r7.size()
            r13 = 0
        L_0x006a:
            if (r13 >= r12) goto L_0x008f
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzdg r14 = (com.google.android.gms.internal.ads.zzdg) r14
            r15 = 0
        L_0x0073:
            int r5 = r14.zzb
            int r5 = r13 + 1
            if (r15 > 0) goto L_0x008b
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzam r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzad r5 = r5.zzp
            if (r5 == 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            int r15 = r15 + 1
            goto L_0x0073
        L_0x008b:
            r13 = r5
            r5 = 11
            goto L_0x006a
        L_0x008f:
            r5 = r10
        L_0x0090:
            if (r5 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzfj.zza
            r12 = 0
        L_0x0097:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c2
            com.google.android.gms.internal.ads.zzac r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00ab
            r5 = 3
            goto L_0x00c3
        L_0x00ab:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b5
            r5 = 2
            goto L_0x00c3
        L_0x00b5:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00bf
            r5 = 6
            goto L_0x00c3
        L_0x00bf:
            int r12 = r12 + 1
            goto L_0x0097
        L_0x00c2:
            r5 = 1
        L_0x00c3:
            android.media.metrics.PlaybackMetrics.Builder unused = r7.setDrmType(r5)
        L_0x00c6:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d3
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d3:
            com.google.android.gms.internal.ads.zzcf r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00db
            goto L_0x0280
        L_0x00db:
            android.content.Context r7 = r0.zza
            int r8 = r5.zzb
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00e8
            r7 = 20
        L_0x00e5:
            r8 = 0
            goto L_0x025a
        L_0x00e8:
            r8 = r5
            com.google.android.gms.internal.ads.zzih r8 = (com.google.android.gms.internal.ads.zzih) r8
            int r12 = r8.zze
            if (r12 != r11) goto L_0x00f1
            r12 = 1
            goto L_0x00f2
        L_0x00f1:
            r12 = 0
        L_0x00f2:
            int r8 = r8.zzi
            java.lang.Throwable r13 = r5.getCause()
            r13.getClass()
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01e0
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgz
            if (r8 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzgz r13 = (com.google.android.gms.internal.ads.zzgz) r13
            int r7 = r13.zzd
            r8 = r7
            r7 = 5
            goto L_0x025a
        L_0x010d:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgy
            if (r8 != 0) goto L_0x01dc
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzcd
            if (r8 == 0) goto L_0x0117
            goto L_0x01dc
        L_0x0117:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgx
            if (r8 != 0) goto L_0x01ae
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzhh
            if (r12 == 0) goto L_0x0121
            goto L_0x01ae
        L_0x0121:
            int r7 = r5.zzb
            r8 = 1002(0x3ea, float:1.404E-42)
            r12 = 21
            if (r7 != r8) goto L_0x012c
            r7 = 21
            goto L_0x00e5
        L_0x012c:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqm
            if (r7 == 0) goto L_0x0179
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            int r8 = com.google.android.gms.internal.ads.zzfj.zza
            if (r8 < r12) goto L_0x014f
            boolean r12 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r12 == 0) goto L_0x014f
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzfj.zzi(r7)
            int r8 = zzr(r7)
            goto L_0x0250
        L_0x014f:
            if (r8 < r15) goto L_0x0158
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0158
            r7 = 27
            goto L_0x00e5
        L_0x0158:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x015f
            r7 = 24
            goto L_0x00e5
        L_0x015f:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0167
            r7 = 29
            goto L_0x00e5
        L_0x0167:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzqx
            if (r8 == 0) goto L_0x016d
            goto L_0x01f6
        L_0x016d:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzqk
            if (r7 == 0) goto L_0x0175
            r7 = 28
            goto L_0x00e5
        L_0x0175:
            r7 = 30
            goto L_0x00e5
        L_0x0179:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzgt
            if (r7 == 0) goto L_0x01aa
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01aa
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            java.lang.Throwable r7 = r7.getCause()
            int r8 = com.google.android.gms.internal.ads.zzfj.zza
            r13 = 31
            if (r8 < r12) goto L_0x01a6
            boolean r8 = r7 instanceof android.system.ErrnoException
            if (r8 == 0) goto L_0x01a6
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01a6
            r7 = 32
            goto L_0x00e5
        L_0x01a6:
            r7 = 31
            goto L_0x00e5
        L_0x01aa:
            r7 = 9
            goto L_0x00e5
        L_0x01ae:
            com.google.android.gms.internal.ads.zzey r7 = com.google.android.gms.internal.ads.zzey.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01bb
            r7 = 3
            goto L_0x00e5
        L_0x01bb:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01c6
            r7 = 6
            goto L_0x00e5
        L_0x01c6:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01cd
            r7 = 7
            goto L_0x00e5
        L_0x01cd:
            if (r8 == 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzgx r13 = (com.google.android.gms.internal.ads.zzgx) r13
            int r7 = r13.zzc
            if (r7 != r11) goto L_0x01d8
            r7 = 4
            goto L_0x00e5
        L_0x01d8:
            r7 = 8
            goto L_0x00e5
        L_0x01dc:
            r7 = 11
            goto L_0x00e5
        L_0x01e0:
            if (r12 == 0) goto L_0x01ea
            r7 = 35
            if (r8 == 0) goto L_0x00e5
            if (r8 != r11) goto L_0x01ea
            goto L_0x00e5
        L_0x01ea:
            if (r12 == 0) goto L_0x01f2
            if (r8 != r9) goto L_0x01f2
            r7 = 15
            goto L_0x00e5
        L_0x01f2:
            if (r12 == 0) goto L_0x01fa
            if (r8 != r6) goto L_0x01fa
        L_0x01f6:
            r7 = 23
            goto L_0x00e5
        L_0x01fa:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzru
            if (r7 == 0) goto L_0x020a
            com.google.android.gms.internal.ads.zzru r13 = (com.google.android.gms.internal.ads.zzru) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzfj.zzi(r7)
            r8 = r7
            r7 = 13
            goto L_0x025a
        L_0x020a:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzrq
            r8 = 14
            if (r7 == 0) goto L_0x021c
            com.google.android.gms.internal.ads.zzrq r13 = (com.google.android.gms.internal.ads.zzrq) r13
            java.lang.String r7 = r13.zzb
            int r7 = com.google.android.gms.internal.ads.zzfj.zzi(r7)
            r8 = r7
            r7 = 14
            goto L_0x025a
        L_0x021c:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x0224
            r7 = 14
            goto L_0x00e5
        L_0x0224:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzov
            if (r7 == 0) goto L_0x0232
            com.google.android.gms.internal.ads.zzov r13 = (com.google.android.gms.internal.ads.zzov) r13
            int r7 = r13.zza
            r8 = 17
            r8 = r7
            r7 = 17
            goto L_0x025a
        L_0x0232:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzoy
            if (r7 == 0) goto L_0x0240
            com.google.android.gms.internal.ads.zzoy r13 = (com.google.android.gms.internal.ads.zzoy) r13
            int r7 = r13.zza
            r8 = 18
            r8 = r7
            r7 = 18
            goto L_0x025a
        L_0x0240:
            int r7 = com.google.android.gms.internal.ads.zzfj.zza
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x0256
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
        L_0x0250:
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x025a
        L_0x0256:
            r7 = 22
            goto L_0x00e5
        L_0x025a:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = new android.media.metrics.PlaybackErrorEvent$Builder
            r13.<init>()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x0280:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02ac
            com.google.android.gms.internal.ads.zzdh r5 = r19.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x029d
            if (r8 != 0) goto L_0x029d
            if (r5 == 0) goto L_0x02ac
            r5 = 1
        L_0x029d:
            if (r7 != 0) goto L_0x02a2
            r0.zzw(r3, r10, r2)
        L_0x02a2:
            if (r8 != 0) goto L_0x02a7
            r0.zzt(r3, r10, r2)
        L_0x02a7:
            if (r5 != 0) goto L_0x02ac
            r0.zzu(r3, r10, r2)
        L_0x02ac:
            com.google.android.gms.internal.ads.zznx r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02c2
            com.google.android.gms.internal.ads.zznx r5 = r0.zzo
            com.google.android.gms.internal.ads.zzam r5 = r5.zza
            int r7 = r5.zzs
            r8 = -1
            if (r7 == r8) goto L_0x02c2
            r0.zzw(r3, r5, r2)
            r0.zzo = r10
        L_0x02c2:
            com.google.android.gms.internal.ads.zznx r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02d3
            com.google.android.gms.internal.ads.zznx r5 = r0.zzp
            com.google.android.gms.internal.ads.zzam r5 = r5.zza
            r0.zzt(r3, r5, r2)
            r0.zzp = r10
        L_0x02d3:
            com.google.android.gms.internal.ads.zznx r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02e4
            com.google.android.gms.internal.ads.zznx r5 = r0.zzq
            com.google.android.gms.internal.ads.zzam r5 = r5.zza
            r0.zzu(r3, r5, r2)
            r0.zzq = r10
        L_0x02e4:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzey r5 = com.google.android.gms.internal.ads.zzey.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0305;
                case 1: goto L_0x0302;
                case 2: goto L_0x0300;
                case 3: goto L_0x02fe;
                case 4: goto L_0x02fc;
                case 5: goto L_0x02fa;
                case 6: goto L_0x02f1;
                case 7: goto L_0x02f8;
                case 8: goto L_0x02f1;
                case 9: goto L_0x02f5;
                case 10: goto L_0x02f3;
                default: goto L_0x02f1;
            }
        L_0x02f1:
            r13 = 1
            goto L_0x0306
        L_0x02f3:
            r13 = 7
            goto L_0x0306
        L_0x02f5:
            r13 = 8
            goto L_0x0306
        L_0x02f8:
            r13 = 3
            goto L_0x0306
        L_0x02fa:
            r13 = 6
            goto L_0x0306
        L_0x02fc:
            r13 = 5
            goto L_0x0306
        L_0x02fe:
            r13 = 4
            goto L_0x0306
        L_0x0300:
            r13 = 2
            goto L_0x0306
        L_0x0302:
            r13 = 9
            goto L_0x0306
        L_0x0305:
            r13 = 0
        L_0x0306:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x0326
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x0326:
            int r5 = r19.zzf()
            if (r5 == r6) goto L_0x032e
            r0.zzu = r2
        L_0x032e:
            r5 = r19
            com.google.android.gms.internal.ads.zzlo r5 = (com.google.android.gms.internal.ads.zzlo) r5
            com.google.android.gms.internal.ads.zzih r5 = r5.zzC()
            r7 = 10
            if (r5 != 0) goto L_0x033d
            r0.zzv = r2
            goto L_0x0345
        L_0x033d:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0345
            r0.zzv = r11
        L_0x0345:
            int r2 = r19.zzf()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x034f
            r5 = 5
            goto L_0x0399
        L_0x034f:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x0356
            r5 = 13
            goto L_0x0399
        L_0x0356:
            r5 = 4
            if (r2 != r5) goto L_0x035c
            r5 = 11
            goto L_0x0399
        L_0x035c:
            if (r2 != r6) goto L_0x037a
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x0378
            if (r2 != r6) goto L_0x0365
            goto L_0x0378
        L_0x0365:
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x036d
            r5 = 7
            goto L_0x0399
        L_0x036d:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x0376
            r5 = 10
            goto L_0x0399
        L_0x0376:
            r5 = 6
            goto L_0x0399
        L_0x0378:
            r5 = 2
            goto L_0x0399
        L_0x037a:
            if (r2 != r9) goto L_0x038e
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x0383
            goto L_0x0399
        L_0x0383:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x038c
            r5 = 9
            goto L_0x0399
        L_0x038c:
            r5 = 3
            goto L_0x0399
        L_0x038e:
            if (r2 != r11) goto L_0x0397
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x0397
            r5 = 12
            goto L_0x0399
        L_0x0397:
            int r5 = r0.zzl
        L_0x0399:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03bc
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03bc:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03cd
            com.google.android.gms.internal.ads.zzoa r3 = r0.zzb
            com.google.android.gms.internal.ads.zzlt r1 = r1.zzc(r2)
            r3.zzf(r1)
        L_0x03cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzny.zzi(com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzlu):void");
    }

    public final void zzj(zzlt zzlt, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
    }

    public final /* synthetic */ void zzk(zzlt zzlt, int i2) {
    }

    public final void zzl(zzlt zzlt, zzcf zzcf) {
        this.zzn = zzcf;
    }

    public final void zzm(zzlt zzlt, zzco zzco, zzco zzco2, int i2) {
        if (i2 == 1) {
            this.zzu = true;
            i2 = 1;
        }
        this.zzk = i2;
    }

    public final /* synthetic */ void zzn(zzlt zzlt, Object obj, long j2) {
    }

    public final void zzo(zzlt zzlt, zzhz zzhz) {
        this.zzw += zzhz.zzg;
        this.zzx += zzhz.zze;
    }

    public final /* synthetic */ void zzp(zzlt zzlt, zzam zzam, zzia zzia) {
    }

    public final void zzq(zzlt zzlt, zzdn zzdn) {
        zznx zznx = this.zzo;
        if (zznx != null) {
            zzam zzam = zznx.zza;
            if (zzam.zzs == -1) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzX(zzdn.zzc);
                zzb2.zzF(zzdn.zzd);
                this.zzo = new zznx(zzb2.zzY(), 0, zznx.zzc);
            }
        }
    }
}
