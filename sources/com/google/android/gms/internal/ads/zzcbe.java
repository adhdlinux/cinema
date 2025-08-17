package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.cast.MediaError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class zzcbe extends zzcbg implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final Map zzc;
    private final zzcca zzd;
    private final zzccb zze;
    private final boolean zzf;
    private int zzg = 0;
    private int zzh = 0;
    private MediaPlayer zzi;
    private Uri zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzcby zzn;
    private final boolean zzo;
    private int zzp;
    /* access modifiers changed from: private */
    public zzcbf zzq;
    /* access modifiers changed from: private */
    public boolean zzr = false;
    private Integer zzs = null;

    static {
        HashMap hashMap = new HashMap();
        zzc = hashMap;
        hashMap.put(-1004, "MEDIA_ERROR_IO");
        hashMap.put(-1007, "MEDIA_ERROR_MALFORMED");
        hashMap.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        hashMap.put(-110, "MEDIA_ERROR_TIMED_OUT");
        hashMap.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        hashMap.put(100, "MEDIA_ERROR_SERVER_DIED");
        hashMap.put(1, "MEDIA_ERROR_UNKNOWN");
        hashMap.put(1, "MEDIA_INFO_UNKNOWN");
        hashMap.put(Integer.valueOf(TypefaceStyle.BOLD), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        hashMap.put(701, "MEDIA_INFO_BUFFERING_START");
        hashMap.put(702, "MEDIA_INFO_BUFFERING_END");
        hashMap.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        hashMap.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        hashMap.put(802, "MEDIA_INFO_METADATA_UPDATE");
        hashMap.put(Integer.valueOf(MediaError.DetailedErrorCode.BREAK_CLIP_LOADING_ERROR), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        hashMap.put(Integer.valueOf(MediaError.DetailedErrorCode.BREAK_SEEK_INTERCEPTOR_ERROR), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcbe(Context context, zzcca zzcca, boolean z2, boolean z3, zzcbz zzcbz, zzccb zzccb) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzd = zzcca;
        this.zze = zzccb;
        this.zzo = z2;
        this.zzf = z3;
        zzccb.zza(this);
    }

    private final void zzD() {
        zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzj != null && surfaceTexture != null) {
            zzE(false);
            try {
                zzt.zzk();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzi = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzi.setOnCompletionListener(this);
                this.zzi.setOnErrorListener(this);
                this.zzi.setOnInfoListener(this);
                this.zzi.setOnPreparedListener(this);
                this.zzi.setOnVideoSizeChangedListener(this);
                this.zzm = 0;
                if (this.zzo) {
                    zzcby zzcby = new zzcby(getContext());
                    this.zzn = zzcby;
                    zzcby.zzd(surfaceTexture, getWidth(), getHeight());
                    this.zzn.start();
                    SurfaceTexture zzb = this.zzn.zzb();
                    if (zzb != null) {
                        surfaceTexture = zzb;
                    } else {
                        this.zzn.zze();
                        this.zzn = null;
                    }
                }
                this.zzi.setDataSource(getContext(), this.zzj);
                zzt.zzl();
                this.zzi.setSurface(new Surface(surfaceTexture));
                this.zzi.setAudioStreamType(3);
                this.zzi.setScreenOnWhilePlaying(true);
                this.zzi.prepareAsync();
                zzF(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
                zzbzr.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzj)), e2);
                onError(this.zzi, 1, 0);
            }
        }
    }

    private final void zzE(boolean z2) {
        zze.zza("AdMediaPlayerView release");
        zzcby zzcby = this.zzn;
        if (zzcby != null) {
            zzcby.zze();
            this.zzn = null;
        }
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            if (z2) {
                this.zzh = 0;
            }
        }
    }

    private final void zzF(int i2) {
        if (i2 == 3) {
            this.zze.zzc();
            this.zzb.zzb();
        } else if (this.zzg == 3) {
            this.zze.zze();
            this.zzb.zzc();
        }
        this.zzg = i2;
    }

    private final void zzG(float f2) {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f2, f2);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzbzr.zzj("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzH() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzi
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzg
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbe.zzH():boolean");
    }

    static /* bridge */ /* synthetic */ void zzl(zzcbe zzcbe, MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzcbe.zzd != null && mediaPlayer != null && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey("bitrate")) {
                                Integer valueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                zzcbe.zzs = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                hashMap.put("resolution", format2.getInteger("width") + "x" + format2.getInteger("height"));
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                zzcbe.zzd.zzd("onMetadataEvent", hashMap);
            }
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.zzm = i2;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView completion");
        zzF(5);
        this.zzh = 5;
        zzs.zza.post(new zzcax(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        Map map = zzc;
        String str = (String) map.get(Integer.valueOf(i2));
        String str2 = (String) map.get(Integer.valueOf(i3));
        zzbzr.zzj("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzF(-1);
        this.zzh = -1;
        zzs.zza.post(new zzcay(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        Map map = zzc;
        zze.zza("AdMediaPlayerView MediaPlayer info: " + ((String) map.get(Integer.valueOf(i2))) + ":" + ((String) map.get(Integer.valueOf(i3))));
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 > r6) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzk
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.zzl
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.zzk
            if (r2 <= 0) goto L_0x007e
            int r2 = r5.zzl
            if (r2 <= 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzcby r2 = r5.zzn
            if (r2 != 0) goto L_0x007e
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0043
            if (r1 != r2) goto L_0x0041
            int r0 = r5.zzk
            int r1 = r0 * r7
            int r2 = r5.zzl
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r1 / r2
        L_0x003a:
            r1 = r7
            goto L_0x007e
        L_0x003c:
            if (r1 <= r3) goto L_0x0063
            int r1 = r3 / r0
            goto L_0x0054
        L_0x0041:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0043:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0056
            int r0 = r5.zzl
            int r0 = r0 * r6
            int r2 = r5.zzk
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0053
            if (r0 <= r7) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            r1 = r0
        L_0x0054:
            r0 = r6
            goto L_0x007e
        L_0x0056:
            if (r1 != r2) goto L_0x0067
            int r1 = r5.zzk
            int r1 = r1 * r7
            int r2 = r5.zzl
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
        L_0x0063:
            r0 = r6
            goto L_0x003a
        L_0x0065:
            r0 = r1
            goto L_0x003a
        L_0x0067:
            int r2 = r5.zzk
            int r4 = r5.zzl
            if (r1 != r3) goto L_0x0073
            if (r4 <= r7) goto L_0x0073
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x0075
        L_0x0073:
            r1 = r2
            r7 = r4
        L_0x0075:
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0054
        L_0x007e:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzcby r6 = r5.zzn
            if (r6 == 0) goto L_0x0088
            r6.zzc(r0, r1)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbe.onMeasure(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f A[LOOP:0: B:12:0x005f->B:17:0x007a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPrepared(android.media.MediaPlayer r9) {
        /*
            r8 = this;
            java.lang.String r0 = "AdMediaPlayerView prepared"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            r0 = 2
            r8.zzF(r0)
            com.google.android.gms.internal.ads.zzccb r0 = r8.zze
            r0.zzb()
            com.google.android.gms.internal.ads.zzfmd r0 = com.google.android.gms.ads.internal.util.zzs.zza
            com.google.android.gms.internal.ads.zzcaw r1 = new com.google.android.gms.internal.ads.zzcaw
            r1.<init>(r8, r9)
            r0.post(r1)
            int r0 = r9.getVideoWidth()
            r8.zzk = r0
            int r9 = r9.getVideoHeight()
            r8.zzl = r9
            int r9 = r8.zzp
            if (r9 == 0) goto L_0x002b
            r8.zzq(r9)
        L_0x002b:
            boolean r9 = r8.zzf
            r0 = 3
            if (r9 != 0) goto L_0x0031
            goto L_0x0084
        L_0x0031:
            boolean r9 = r8.zzH()
            if (r9 == 0) goto L_0x0084
            android.media.MediaPlayer r9 = r8.zzi
            int r9 = r9.getCurrentPosition()
            if (r9 <= 0) goto L_0x0084
            int r9 = r8.zzh
            if (r9 == r0) goto L_0x0084
            java.lang.String r9 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zze.zza(r9)
            r9 = 0
            r8.zzG(r9)
            android.media.MediaPlayer r9 = r8.zzi
            r9.start()
            android.media.MediaPlayer r9 = r8.zzi
            int r9 = r9.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzB()
            long r1 = r1.currentTimeMillis()
        L_0x005f:
            boolean r3 = r8.zzH()
            if (r3 == 0) goto L_0x007c
            android.media.MediaPlayer r3 = r8.zzi
            int r3 = r3.getCurrentPosition()
            if (r3 != r9) goto L_0x007c
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzB()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005f
        L_0x007c:
            android.media.MediaPlayer r9 = r8.zzi
            r9.pause()
            r8.zzn()
        L_0x0084:
            int r9 = r8.zzk
            int r1 = r8.zzl
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AdMediaPlayerView stream dimensions: "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = " x "
            r2.append(r9)
            r2.append(r1)
            java.lang.String r9 = r2.toString()
            com.google.android.gms.internal.ads.zzbzr.zzi(r9)
            int r9 = r8.zzh
            if (r9 != r0) goto L_0x00ab
            r8.zzp()
        L_0x00ab:
            r8.zzn()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbe.onPrepared(android.media.MediaPlayer):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        zze.zza("AdMediaPlayerView surface created");
        zzD();
        zzs.zza.post(new zzcaz(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null && this.zzp == 0) {
            this.zzp = mediaPlayer.getCurrentPosition();
        }
        zzcby zzcby = this.zzn;
        if (zzcby != null) {
            zzcby.zze();
        }
        zzs.zza.post(new zzcbb(this));
        zzE(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        zze.zza("AdMediaPlayerView surface changed");
        int i4 = this.zzh;
        boolean z2 = false;
        if (this.zzk == i2 && this.zzl == i3) {
            z2 = true;
        }
        if (this.zzi != null && i4 == 3 && z2) {
            int i5 = this.zzp;
            if (i5 != 0) {
                zzq(i5);
            }
            zzp();
        }
        zzcby zzcby = this.zzn;
        if (zzcby != null) {
            zzcby.zzc(i2, i3);
        }
        zzs.zza.post(new zzcba(this, i2, i3));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzf(this);
        this.zza.zza(surfaceTexture, this.zzq);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        zze.zza("AdMediaPlayerView size changed: " + i2 + " x " + i3);
        this.zzk = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzl = videoHeight;
        if (this.zzk != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i2) {
        zze.zza("AdMediaPlayerView window visibility changed to " + i2);
        zzs.zza.post(new zzcav(this, i2));
        super.onWindowVisibilityChanged(i2);
    }

    public final String toString() {
        String name = zzcbe.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return name + "@" + hexString;
    }

    public final int zza() {
        if (zzH()) {
            return this.zzi.getCurrentPosition();
        }
        return 0;
    }

    public final int zzb() {
        if (Build.VERSION.SDK_INT < 26 || !zzH()) {
            return -1;
        }
        return this.zzi.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final int zzc() {
        if (zzH()) {
            return this.zzi.getDuration();
        }
        return -1;
    }

    public final int zzd() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int zze() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final long zzf() {
        return 0;
    }

    public final long zzg() {
        if (this.zzs != null) {
            return (zzh() * ((long) this.zzm)) / 100;
        }
        return -1;
    }

    public final long zzh() {
        if (this.zzs != null) {
            return ((long) zzc()) * ((long) this.zzs.intValue());
        }
        return -1;
    }

    public final String zzj() {
        return "MediaPlayer".concat(true != this.zzo ? "" : " spherical");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(int i2) {
        zzcbf zzcbf = this.zzq;
        if (zzcbf != null) {
            zzcbf.onWindowVisibilityChanged(i2);
        }
    }

    public final void zzn() {
        zzG(this.zzb.zza());
    }

    public final void zzo() {
        zze.zza("AdMediaPlayerView pause");
        if (zzH() && this.zzi.isPlaying()) {
            this.zzi.pause();
            zzF(4);
            zzs.zza.post(new zzcbd(this));
        }
        this.zzh = 4;
    }

    public final void zzp() {
        zze.zza("AdMediaPlayerView play");
        if (zzH()) {
            this.zzi.start();
            zzF(3);
            this.zza.zzb();
            zzs.zza.post(new zzcbc(this));
        }
        this.zzh = 3;
    }

    public final void zzq(int i2) {
        zze.zza("AdMediaPlayerView seek " + i2);
        if (zzH()) {
            this.zzi.seekTo(i2);
            this.zzp = 0;
            return;
        }
        this.zzp = i2;
    }

    public final void zzr(zzcbf zzcbf) {
        this.zzq = zzcbf;
    }

    public final void zzs(String str) {
        Uri parse = Uri.parse(str);
        zzawl zza = zzawl.zza(parse);
        if (zza == null || zza.zza != null) {
            if (zza != null) {
                parse = Uri.parse(zza.zza);
            }
            this.zzj = parse;
            this.zzp = 0;
            zzD();
            requestLayout();
            invalidate();
        }
    }

    public final void zzt() {
        zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            this.zzh = 0;
        }
        this.zze.zzd();
    }

    public final void zzu(float f2, float f3) {
        zzcby zzcby = this.zzn;
        if (zzcby != null) {
            zzcby.zzf(f2, f3);
        }
    }
}
