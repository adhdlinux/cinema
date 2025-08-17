package com.facebook.ads.internal.view.f.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import com.facebook.ads.internal.j.b;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;

@TargetApi(14)
public class a extends TextureView implements TextureView.SurfaceTextureListener, c, ExoPlayer.EventListener, SimpleExoPlayer.VideoListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21489a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Uri f21490b;

    /* renamed from: c  reason: collision with root package name */
    private String f21491c;

    /* renamed from: d  reason: collision with root package name */
    private e f21492d;

    /* renamed from: e  reason: collision with root package name */
    private Surface f21493e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SimpleExoPlayer f21494f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public MediaController f21495g;

    /* renamed from: h  reason: collision with root package name */
    private d f21496h;

    /* renamed from: i  reason: collision with root package name */
    private d f21497i;

    /* renamed from: j  reason: collision with root package name */
    private d f21498j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21499k = false;

    /* renamed from: l  reason: collision with root package name */
    private View f21500l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21501m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21502n = false;

    /* renamed from: o  reason: collision with root package name */
    private long f21503o;

    /* renamed from: p  reason: collision with root package name */
    private long f21504p;

    /* renamed from: q  reason: collision with root package name */
    private long f21505q;

    /* renamed from: r  reason: collision with root package name */
    private int f21506r;

    /* renamed from: s  reason: collision with root package name */
    private int f21507s;

    /* renamed from: t  reason: collision with root package name */
    private float f21508t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    private int f21509u = -1;

    /* renamed from: v  reason: collision with root package name */
    private boolean f21510v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f21511w = false;

    /* renamed from: x  reason: collision with root package name */
    private com.facebook.ads.internal.view.f.a.a f21512x = com.facebook.ads.internal.view.f.a.a.NOT_STARTED;

    /* renamed from: y  reason: collision with root package name */
    private boolean f21513y = false;

    public a(Context context) {
        super(context);
        d dVar = d.IDLE;
        this.f21496h = dVar;
        this.f21497i = dVar;
        this.f21498j = dVar;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVar = d.IDLE;
        this.f21496h = dVar;
        this.f21497i = dVar;
        this.f21498j = dVar;
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d dVar = d.IDLE;
        this.f21496h = dVar;
        this.f21497i = dVar;
        this.f21498j = dVar;
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        d dVar = d.IDLE;
        this.f21496h = dVar;
        this.f21497i = dVar;
        this.f21498j = dVar;
    }

    private void f() {
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        SimpleExoPlayer newSimpleInstance = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter)), new DefaultLoadControl());
        this.f21494f = newSimpleInstance;
        newSimpleInstance.setVideoListener(this);
        this.f21494f.addListener(this);
        this.f21494f.l(false);
        if (this.f21502n && !this.f21510v) {
            MediaController mediaController = new MediaController(getContext());
            this.f21495g = mediaController;
            View view = this.f21500l;
            if (view == null) {
                view = this;
            }
            mediaController.setAnchorView(view);
            this.f21495g.setMediaPlayer(new MediaController.MediaPlayerControl() {
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
                    if (a.this.f21494f != null) {
                        return a.this.f21494f.o0();
                    }
                    return 0;
                }

                public int getBufferPercentage() {
                    if (a.this.f21494f != null) {
                        return a.this.f21494f.b0();
                    }
                    return 0;
                }

                public int getCurrentPosition() {
                    return a.this.getCurrentPosition();
                }

                public int getDuration() {
                    return a.this.getDuration();
                }

                public boolean isPlaying() {
                    return a.this.f21494f != null && a.this.f21494f.A();
                }

                public void pause() {
                    a.this.a(true);
                }

                public void seekTo(int i2) {
                    a.this.a(i2);
                }

                public void start() {
                    a.this.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
                }
            });
            this.f21495g.setEnabled(true);
        }
        String str = this.f21491c;
        if (str == null || str.length() == 0 || this.f21513y) {
            this.f21494f.q0(new ExtractorMediaSource(this.f21490b, new DefaultDataSourceFactory(getContext(), Util.o0(getContext(), "ads"), (TransferListener) defaultBandwidthMeter), new DefaultExtractorsFactory(), (Handler) null, (ExtractorMediaSource.EventListener) null));
        }
        setVideoState(d.PREPARING);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    private void g() {
        Surface surface = this.f21493e;
        if (surface != null) {
            surface.release();
            this.f21493e = null;
        }
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.f21494f = null;
        }
        this.f21495g = null;
        this.f21501m = false;
        setVideoState(d.IDLE);
    }

    private void setVideoState(d dVar) {
        if (dVar != this.f21496h) {
            this.f21496h = dVar;
            if (dVar == d.STARTED) {
                this.f21501m = true;
            }
            e eVar = this.f21492d;
            if (eVar != null) {
                eVar.a(dVar);
            }
        }
    }

    public void a() {
        if (!this.f21511w) {
            a(false);
        }
    }

    public void a(int i2) {
        if (this.f21494f != null) {
            this.f21509u = getCurrentPosition();
            this.f21494f.seekTo((long) i2);
            return;
        }
        this.f21505q = (long) i2;
    }

    public void a(com.facebook.ads.internal.view.f.a.a aVar) {
        d dVar = d.STARTED;
        this.f21497i = dVar;
        this.f21512x = aVar;
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer == null) {
            setup(this.f21490b);
            return;
        }
        d dVar2 = this.f21496h;
        if (dVar2 == d.PREPARED || dVar2 == d.PAUSED || dVar2 == d.PLAYBACK_COMPLETED) {
            simpleExoPlayer.l(true);
            setVideoState(dVar);
        }
    }

    public void a(boolean z2) {
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.l(false);
        } else {
            setVideoState(d.IDLE);
        }
    }

    public void b() {
        setVideoState(d.PLAYBACK_COMPLETED);
        c();
        this.f21505q = 0;
    }

    public void c() {
        d dVar = d.IDLE;
        this.f21497i = dVar;
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.f21494f.release();
            this.f21494f = null;
        }
        setVideoState(dVar);
    }

    public boolean d() {
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        return (simpleExoPlayer == null || simpleExoPlayer.n0() == null) ? false : true;
    }

    public void e() {
        g();
    }

    public int getCurrentPosition() {
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null) {
            return (int) simpleExoPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer == null) {
            return 0;
        }
        return (int) simpleExoPlayer.getDuration();
    }

    public long getInitialBufferTime() {
        return this.f21504p;
    }

    public com.facebook.ads.internal.view.f.a.a getStartReason() {
        return this.f21512x;
    }

    public d getState() {
        return this.f21496h;
    }

    public d getTargetState() {
        return this.f21497i;
    }

    public int getVideoHeight() {
        return this.f21507s;
    }

    public int getVideoWidth() {
        return this.f21506r;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f21508t;
    }

    public void onLoadingChanged(boolean z2) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        setVideoState(d.ERROR);
        exoPlaybackException.printStackTrace();
        b.a(com.facebook.ads.internal.j.a.a(exoPlaybackException, "[ExoPlayer] Error during playback of ExoPlayer"));
    }

    public void onPlayerStateChanged(boolean z2, int i2) {
        d dVar;
        if (i2 == 1) {
            dVar = d.IDLE;
        } else if (i2 == 2) {
            int i3 = this.f21509u;
            if (i3 >= 0) {
                this.f21509u = -1;
                this.f21492d.a(i3, getCurrentPosition());
                return;
            }
            return;
        } else if (i2 == 3) {
            if (this.f21503o != 0) {
                this.f21504p = System.currentTimeMillis() - this.f21503o;
            }
            setRequestedVolume(this.f21508t);
            long j2 = this.f21505q;
            if (j2 > 0 && j2 < this.f21494f.getDuration()) {
                this.f21494f.seekTo(this.f21505q);
                this.f21505q = 0;
            }
            if (this.f21494f.getCurrentPosition() != 0 && !z2 && this.f21501m) {
                dVar = d.PAUSED;
            } else if (!z2 && this.f21496h != d.PLAYBACK_COMPLETED) {
                setVideoState(d.PREPARED);
                if (this.f21497i == d.STARTED) {
                    a(this.f21512x);
                    this.f21497i = d.IDLE;
                    return;
                }
                return;
            } else {
                return;
            }
        } else if (i2 == 4) {
            if (z2) {
                setVideoState(d.PLAYBACK_COMPLETED);
            }
            SimpleExoPlayer simpleExoPlayer = this.f21494f;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.l(false);
                if (!z2) {
                    this.f21494f.h();
                }
            }
            this.f21501m = false;
            return;
        } else {
            return;
        }
        setVideoState(dVar);
    }

    public void onPositionDiscontinuity() {
    }

    public void onRenderedFirstFrame() {
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Surface surface = this.f21493e;
        if (surface != null) {
            surface.release();
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.f21493e = surface2;
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.s0(surface2);
            this.f21499k = false;
            d dVar = this.f21496h;
            d dVar2 = d.PAUSED;
            if (dVar == dVar2 && this.f21498j != dVar2) {
                a(this.f21512x);
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.f21493e;
        if (surface != null) {
            surface.release();
            this.f21493e = null;
            SimpleExoPlayer simpleExoPlayer = this.f21494f;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.s0((Surface) null);
            }
        }
        if (!this.f21499k) {
            this.f21498j = this.f21502n ? d.STARTED : this.f21496h;
            this.f21499k = true;
        }
        if (this.f21496h != d.PAUSED) {
            a(false);
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onTimelineChanged(Timeline timeline, Object obj) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
        this.f21506r = i2;
        this.f21507s = i3;
        if (i2 != 0 && i3 != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.f21494f != null) {
            MediaController mediaController = this.f21495g;
            if (mediaController != null && mediaController.isShowing()) {
                return;
            }
            if (!z2) {
                if (!this.f21499k) {
                    this.f21498j = this.f21502n ? d.STARTED : this.f21496h;
                    this.f21499k = true;
                }
                if (this.f21496h != d.PAUSED) {
                    a();
                    return;
                }
                return;
            }
            this.f21499k = false;
            d dVar = this.f21496h;
            d dVar2 = d.PAUSED;
            if (dVar == dVar2 && this.f21498j != dVar2) {
                a(this.f21512x);
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f21489a, "Google always throw an exception with setBackgroundDrawable on Nougat above. so we silently ignore it.");
        }
    }

    public void setBackgroundPlaybackEnabled(boolean z2) {
        this.f21511w = z2;
    }

    public void setControlsAnchorView(View view) {
        this.f21500l = view;
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.f21495g != null && motionEvent.getAction() == 1) {
                    if (a.this.f21495g.isShowing()) {
                        a.this.f21495g.hide();
                    } else {
                        a.this.f21495g.show();
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
            Log.w(f21489a, "Google always throw an exception with setForeground on Nougat above. so we silently ignore it.");
        }
    }

    public void setFullScreen(boolean z2) {
        this.f21502n = z2;
        if (z2 && !this.f21510v) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (a.this.f21495g != null && motionEvent.getAction() == 1) {
                        if (a.this.f21495g.isShowing()) {
                            a.this.f21495g.hide();
                        } else {
                            a.this.f21495g.show();
                        }
                    }
                    return true;
                }
            });
        }
    }

    public void setRequestedVolume(float f2) {
        d dVar;
        this.f21508t = f2;
        SimpleExoPlayer simpleExoPlayer = this.f21494f;
        if (simpleExoPlayer != null && (dVar = this.f21496h) != d.PREPARING && dVar != d.IDLE) {
            simpleExoPlayer.d(f2);
        }
    }

    public void setTestMode(boolean z2) {
        this.f21513y = z2;
    }

    public void setVideoMPD(String str) {
        this.f21491c = str;
    }

    public void setVideoStateChangeListener(e eVar) {
        this.f21492d = eVar;
    }

    public void setup(Uri uri) {
        if (this.f21494f != null) {
            g();
        }
        this.f21490b = uri;
        setSurfaceTextureListener(this);
        f();
    }
}
