package com.facebook.ads.internal.view.f.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.f.a.a;

@TargetApi(14)
public class b extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, c {

    /* renamed from: t  reason: collision with root package name */
    private static final String f21517t = "b";

    /* renamed from: a  reason: collision with root package name */
    private Uri f21518a;

    /* renamed from: b  reason: collision with root package name */
    private e f21519b;

    /* renamed from: c  reason: collision with root package name */
    private Surface f21520c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MediaPlayer f21521d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MediaController f21522e;

    /* renamed from: f  reason: collision with root package name */
    private d f21523f;

    /* renamed from: g  reason: collision with root package name */
    private d f21524g;

    /* renamed from: h  reason: collision with root package name */
    private d f21525h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21526i = false;

    /* renamed from: j  reason: collision with root package name */
    private View f21527j;

    /* renamed from: k  reason: collision with root package name */
    private int f21528k = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f21529l;

    /* renamed from: m  reason: collision with root package name */
    private int f21530m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f21531n = 0;

    /* renamed from: o  reason: collision with root package name */
    private float f21532o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21533p = false;

    /* renamed from: q  reason: collision with root package name */
    private int f21534q = 3;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21535r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f21536s = false;

    /* renamed from: u  reason: collision with root package name */
    private int f21537u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f21538v = false;

    /* renamed from: w  reason: collision with root package name */
    private a f21539w = a.NOT_STARTED;

    /* renamed from: x  reason: collision with root package name */
    private final MediaController.MediaPlayerControl f21540x = new MediaController.MediaPlayerControl() {
        public boolean canPause() {
            return true;
        }

        public boolean canSeekBackward() {
            return true;
        }

        public boolean canSeekForward() {
            return true;
        }

        public int getAudioSessionId() {
            if (b.this.f21521d != null) {
                return b.this.f21521d.getAudioSessionId();
            }
            return 0;
        }

        public int getBufferPercentage() {
            return 0;
        }

        public int getCurrentPosition() {
            return b.this.getCurrentPosition();
        }

        public int getDuration() {
            return b.this.getDuration();
        }

        public boolean isPlaying() {
            return b.this.f21521d != null && b.this.f21521d.isPlaying();
        }

        public void pause() {
            b.this.a(true);
        }

        public void seekTo(int i2) {
            b.this.a(i2);
        }

        public void start() {
            b.this.a(a.USER_STARTED);
        }
    };

    public b(Context context) {
        super(context);
        d dVar = d.IDLE;
        this.f21523f = dVar;
        this.f21524g = dVar;
        this.f21525h = dVar;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVar = d.IDLE;
        this.f21523f = dVar;
        this.f21524g = dVar;
        this.f21525h = dVar;
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d dVar = d.IDLE;
        this.f21523f = dVar;
        this.f21524g = dVar;
        this.f21525h = dVar;
    }

    @TargetApi(21)
    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        d dVar = d.IDLE;
        this.f21523f = dVar;
        this.f21524g = dVar;
        this.f21525h = dVar;
    }

    private boolean a(Surface surface) {
        MediaPlayer mediaPlayer = this.f21521d;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.setSurface(surface);
            return true;
        } catch (IllegalStateException e2) {
            com.facebook.ads.internal.q.d.a.a(getContext(), "player", com.facebook.ads.internal.q.d.b.f20759s, (Exception) e2);
            Log.d(f21517t, "The MediaPlayer failed", e2);
            return false;
        }
    }

    private boolean f() {
        d dVar = this.f21523f;
        return dVar == d.PREPARED || dVar == d.STARTED || dVar == d.PAUSED || dVar == d.PLAYBACK_COMPLETED;
    }

    private boolean g() {
        MediaPlayer mediaPlayer = this.f21521d;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.reset();
            return true;
        } catch (IllegalStateException e2) {
            com.facebook.ads.internal.q.d.a.a(getContext(), "player", com.facebook.ads.internal.q.d.b.f20760t, (Exception) e2);
            Log.d(f21517t, "The MediaPlayer failed", e2);
            return false;
        }
    }

    private boolean h() {
        d dVar = this.f21523f;
        return (dVar == d.PREPARING || dVar == d.PREPARED) ? false : true;
    }

    private boolean i() {
        d dVar = this.f21523f;
        return (dVar == d.PREPARING || dVar == d.PREPARED) ? false : true;
    }

    private void setVideoState(d dVar) {
        if (dVar != this.f21523f) {
            this.f21523f = dVar;
            e eVar = this.f21519b;
            if (eVar != null) {
                eVar.a(dVar);
            }
        }
    }

    public void a() {
        if (!this.f21535r) {
            a(false);
        }
    }

    public void a(int i2) {
        if (this.f21521d == null || !f()) {
            this.f21528k = i2;
        } else if (i2 < getDuration() && i2 > 0) {
            this.f21537u = getCurrentPosition();
            this.f21528k = i2;
            this.f21521d.seekTo(i2);
        }
    }

    public void a(a aVar) {
        d dVar = d.STARTED;
        this.f21524g = dVar;
        this.f21539w = aVar;
        d dVar2 = this.f21523f;
        if (dVar2 == dVar || dVar2 == d.PREPARED || dVar2 == d.IDLE || dVar2 == d.PAUSED || dVar2 == d.PLAYBACK_COMPLETED) {
            MediaPlayer mediaPlayer = this.f21521d;
            if (mediaPlayer == null) {
                setup(this.f21518a);
            } else {
                int i2 = this.f21528k;
                if (i2 > 0) {
                    mediaPlayer.seekTo(i2);
                }
                this.f21521d.start();
                if (this.f21523f != d.PREPARED || this.f21536s) {
                    setVideoState(dVar);
                }
            }
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    public void a(boolean z2) {
        d dVar = d.PAUSED;
        this.f21524g = dVar;
        if (this.f21521d == null) {
            setVideoState(d.IDLE);
        } else if (i()) {
            if (z2) {
                this.f21525h = dVar;
                this.f21526i = true;
            }
            this.f21521d.pause();
            if (this.f21523f != d.PLAYBACK_COMPLETED) {
                setVideoState(dVar);
            }
        }
    }

    public void b() {
        setVideoState(d.PLAYBACK_COMPLETED);
        c();
        this.f21528k = 0;
    }

    public void c() {
        d dVar = d.IDLE;
        this.f21524g = dVar;
        MediaPlayer mediaPlayer = this.f21521d;
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition > 0) {
                this.f21528k = currentPosition;
            }
            this.f21521d.stop();
            g();
            this.f21521d.release();
            this.f21521d = null;
            MediaController mediaController = this.f21522e;
            if (mediaController != null) {
                mediaController.hide();
                this.f21522e.setEnabled(false);
            }
        }
        setVideoState(dVar);
    }

    @SuppressLint({"NewApi"})
    public boolean d() {
        MediaPlayer mediaPlayer = this.f21521d;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            for (MediaPlayer.TrackInfo trackType : mediaPlayer.getTrackInfo()) {
                if (trackType.getTrackType() == 2) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e2) {
            Log.e(f21517t, "Couldn't retrieve video information", e2);
            return true;
        }
    }

    public void e() {
        if (this.f21521d != null) {
            a((Surface) null);
            this.f21521d.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener) null);
            this.f21521d.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
            this.f21521d.setOnErrorListener((MediaPlayer.OnErrorListener) null);
            this.f21521d.setOnInfoListener((MediaPlayer.OnInfoListener) null);
            this.f21521d.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
            this.f21521d.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener) null);
            this.f21521d.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener) null);
            g();
            this.f21521d = null;
            setVideoState(d.IDLE);
        }
    }

    public int getCurrentPosition() {
        if (this.f21521d == null || !f()) {
            return 0;
        }
        return this.f21521d.getCurrentPosition();
    }

    public int getDuration() {
        if (this.f21521d == null || !f()) {
            return 0;
        }
        return this.f21521d.getDuration();
    }

    public long getInitialBufferTime() {
        return this.f21529l;
    }

    public a getStartReason() {
        return this.f21539w;
    }

    public d getState() {
        return this.f21523f;
    }

    public d getTargetState() {
        return this.f21524g;
    }

    public int getVideoHeight() {
        return this.f21531n;
    }

    public int getVideoWidth() {
        return this.f21530m;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f21532o;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = this.f21521d;
        if (mediaPlayer2 != null) {
            mediaPlayer2.pause();
        }
        setVideoState(d.PLAYBACK_COMPLETED);
        a(0);
        this.f21528k = 0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        if (this.f21534q <= 0 || getState() != d.STARTED) {
            setVideoState(d.ERROR);
            c();
        } else {
            this.f21534q--;
            c();
            a(this.f21539w);
        }
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        d dVar;
        if (i2 != 3) {
            if (i2 == 701) {
                dVar = d.BUFFERING;
            } else if (i2 != 702 || !h()) {
                return false;
            } else {
                dVar = d.STARTED;
            }
            setVideoState(dVar);
            return false;
        }
        this.f21536s = true;
        d dVar2 = this.f21524g;
        d dVar3 = d.STARTED;
        if (dVar2 == dVar3) {
            setVideoState(dVar3);
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(d.PREPARED);
        if (this.f21533p && !this.f21538v) {
            MediaController mediaController = new MediaController(getContext());
            this.f21522e = mediaController;
            View view = this.f21527j;
            if (view == null) {
                view = this;
            }
            mediaController.setAnchorView(view);
            this.f21522e.setMediaPlayer(this.f21540x);
            this.f21522e.setEnabled(true);
        }
        setRequestedVolume(this.f21532o);
        this.f21530m = mediaPlayer.getVideoWidth();
        this.f21531n = mediaPlayer.getVideoHeight();
        int i2 = this.f21528k;
        if (i2 > 0) {
            if (i2 >= this.f21521d.getDuration()) {
                this.f21528k = 0;
            }
            this.f21521d.seekTo(this.f21528k);
            this.f21528k = 0;
        }
        if (this.f21524g == d.STARTED) {
            a(this.f21539w);
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        e eVar = this.f21519b;
        if (eVar != null) {
            eVar.a(this.f21537u, this.f21528k);
            this.f21528k = 0;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (this.f21520c == null) {
            this.f21520c = new Surface(surfaceTexture);
        }
        if (!a(this.f21520c)) {
            setVideoState(d.ERROR);
            e();
            return;
        }
        this.f21526i = false;
        d dVar = this.f21523f;
        d dVar2 = d.PAUSED;
        if (dVar == dVar2 && this.f21525h != dVar2) {
            a(this.f21539w);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a((Surface) null);
        Surface surface = this.f21520c;
        if (surface != null) {
            surface.release();
            this.f21520c = null;
        }
        if (!this.f21526i) {
            this.f21525h = this.f21533p ? d.STARTED : this.f21523f;
            this.f21526i = true;
        }
        if (this.f21523f != d.PAUSED) {
            a(false);
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        this.f21530m = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f21531n = videoHeight;
        if (this.f21530m != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.f21521d != null) {
            MediaController mediaController = this.f21522e;
            if (mediaController != null && mediaController.isShowing()) {
                return;
            }
            if (!z2) {
                if (!this.f21526i) {
                    this.f21525h = this.f21533p ? d.STARTED : this.f21523f;
                    this.f21526i = true;
                }
                if (this.f21523f != d.PAUSED) {
                    a();
                    return;
                }
                return;
            }
            this.f21526i = false;
            d dVar = this.f21523f;
            d dVar2 = d.PAUSED;
            if (dVar == dVar2 && this.f21525h != dVar2) {
                a(this.f21539w);
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f21517t, "Google always throw an exception with setBackgroundDrawable on Nougat above. so we silently ignore it.");
        }
    }

    public void setBackgroundPlaybackEnabled(boolean z2) {
        this.f21535r = z2;
    }

    public void setControlsAnchorView(View view) {
        this.f21527j = view;
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!b.this.f21538v && b.this.f21522e != null && motionEvent.getAction() == 1) {
                    if (b.this.f21522e.isShowing()) {
                        b.this.f21522e.hide();
                    } else {
                        b.this.f21522e.show();
                    }
                }
                return true;
            }
        });
    }

    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f21517t, "Google always throw an exception with setForeground on Nougat above. so we silently ignore it.");
        }
    }

    public void setFullScreen(boolean z2) {
        this.f21533p = z2;
        if (z2 && !this.f21538v) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!b.this.f21538v && b.this.f21522e != null && motionEvent.getAction() == 1) {
                        if (b.this.f21522e.isShowing()) {
                            b.this.f21522e.hide();
                        } else {
                            b.this.f21522e.show();
                        }
                    }
                    return true;
                }
            });
        }
    }

    public void setRequestedVolume(float f2) {
        d dVar;
        this.f21532o = f2;
        MediaPlayer mediaPlayer = this.f21521d;
        if (mediaPlayer != null && (dVar = this.f21523f) != d.PREPARING && dVar != d.IDLE) {
            mediaPlayer.setVolume(f2, f2);
        }
    }

    public void setVideoMPD(String str) {
    }

    public void setVideoStateChangeListener(e eVar) {
        this.f21519b = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(android.net.Uri r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Unable to close"
            r1 = 0
            r10.f21536s = r1
            r10.f21518a = r11
            android.media.MediaPlayer r2 = r10.f21521d
            r3 = 0
            if (r2 == 0) goto L_0x001a
            r10.g()
            r10.a((android.view.Surface) r3)
            android.media.MediaPlayer r2 = r10.f21521d
            com.facebook.ads.internal.view.f.d.d r4 = com.facebook.ads.internal.view.f.d.d.IDLE
            r10.setVideoState(r4)
            goto L_0x001f
        L_0x001a:
            android.media.MediaPlayer r2 = new android.media.MediaPlayer
            r2.<init>()
        L_0x001f:
            java.lang.String r4 = r11.getScheme()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "asset"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00ea }
            if (r4 == 0) goto L_0x00c0
            android.content.Context r4 = r10.getContext()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            java.lang.String r11 = r11.getPath()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            r5 = 1
            java.lang.String r11 = r11.substring(r5)     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            android.content.res.AssetFileDescriptor r3 = r4.openFd(r11)     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            long r6 = r3.getStartOffset()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            long r8 = r3.getLength()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            java.io.FileDescriptor r5 = r3.getFileDescriptor()     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            r4 = r2
            r4.setDataSource(r5, r6, r8)     // Catch:{ SecurityException -> 0x006f, IOException -> 0x006d }
            r3.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x00c7
        L_0x0055:
            r11 = move-exception
            java.lang.String r3 = f21517t     // Catch:{ Exception -> 0x00ea }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r4.<init>()     // Catch:{ Exception -> 0x00ea }
            r4.append(r0)     // Catch:{ Exception -> 0x00ea }
            r4.append(r11)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r11 = r4.toString()     // Catch:{ Exception -> 0x00ea }
        L_0x0067:
            android.util.Log.w(r3, r11)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00c7
        L_0x006b:
            r11 = move-exception
            goto L_0x00a4
        L_0x006d:
            r11 = move-exception
            goto L_0x0070
        L_0x006f:
            r11 = move-exception
        L_0x0070:
            java.lang.String r4 = f21517t     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r5.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r6 = "Failed to open assets "
            r5.append(r6)     // Catch:{ all -> 0x006b }
            r5.append(r11)     // Catch:{ all -> 0x006b }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x006b }
            android.util.Log.w(r4, r11)     // Catch:{ all -> 0x006b }
            com.facebook.ads.internal.view.f.d.d r11 = com.facebook.ads.internal.view.f.d.d.ERROR     // Catch:{ all -> 0x006b }
            r10.setVideoState(r11)     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x00c7
            r3.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x00c7
        L_0x0091:
            r11 = move-exception
            java.lang.String r3 = f21517t     // Catch:{ Exception -> 0x00ea }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r4.<init>()     // Catch:{ Exception -> 0x00ea }
            r4.append(r0)     // Catch:{ Exception -> 0x00ea }
            r4.append(r11)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r11 = r4.toString()     // Catch:{ Exception -> 0x00ea }
            goto L_0x0067
        L_0x00a4:
            if (r3 == 0) goto L_0x00bf
            r3.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00bf
        L_0x00aa:
            r3 = move-exception
            java.lang.String r4 = f21517t     // Catch:{ Exception -> 0x00ea }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r5.<init>()     // Catch:{ Exception -> 0x00ea }
            r5.append(r0)     // Catch:{ Exception -> 0x00ea }
            r5.append(r3)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00ea }
            android.util.Log.w(r4, r0)     // Catch:{ Exception -> 0x00ea }
        L_0x00bf:
            throw r11     // Catch:{ Exception -> 0x00ea }
        L_0x00c0:
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00ea }
            r2.setDataSource(r11)     // Catch:{ Exception -> 0x00ea }
        L_0x00c7:
            r2.setLooping(r1)     // Catch:{ Exception -> 0x00ea }
            r2.setOnBufferingUpdateListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnCompletionListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnErrorListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnInfoListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnPreparedListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnVideoSizeChangedListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.setOnSeekCompleteListener(r10)     // Catch:{ Exception -> 0x00ea }
            r2.prepareAsync()     // Catch:{ Exception -> 0x00ea }
            r10.f21521d = r2     // Catch:{ Exception -> 0x00ea }
            com.facebook.ads.internal.view.f.d.d r11 = com.facebook.ads.internal.view.f.d.d.PREPARING     // Catch:{ Exception -> 0x00ea }
            r10.setVideoState(r11)     // Catch:{ Exception -> 0x00ea }
            goto L_0x0109
        L_0x00ea:
            r11 = move-exception
            com.facebook.ads.internal.view.f.d.d r0 = com.facebook.ads.internal.view.f.d.d.ERROR
            r10.setVideoState(r0)
            r2.release()
            java.lang.String r0 = f21517t
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot prepare media player with SurfaceTexture: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r0, r11)
        L_0x0109:
            r10.setSurfaceTextureListener(r10)
            boolean r11 = r10.isAvailable()
            if (r11 == 0) goto L_0x0119
            android.graphics.SurfaceTexture r11 = r10.getSurfaceTexture()
            r10.onSurfaceTextureAvailable(r11, r1, r1)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.f.d.b.setup(android.net.Uri):void");
    }
}
