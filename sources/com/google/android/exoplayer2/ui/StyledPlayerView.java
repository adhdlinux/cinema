package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.x1;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class StyledPlayerView extends FrameLayout {
    /* access modifiers changed from: private */
    public int A;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentListener f28197b;

    /* renamed from: c  reason: collision with root package name */
    private final AspectRatioFrameLayout f28198c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f28199d;

    /* renamed from: e  reason: collision with root package name */
    private final View f28200e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f28201f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f28202g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SubtitleView f28203h;

    /* renamed from: i  reason: collision with root package name */
    private final View f28204i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f28205j;

    /* renamed from: k  reason: collision with root package name */
    private final StyledPlayerControlView f28206k;

    /* renamed from: l  reason: collision with root package name */
    private final FrameLayout f28207l;

    /* renamed from: m  reason: collision with root package name */
    private final FrameLayout f28208m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Player f28209n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f28210o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ControllerVisibilityListener f28211p;

    /* renamed from: q  reason: collision with root package name */
    private StyledPlayerControlView.VisibilityListener f28212q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28213r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f28214s;

    /* renamed from: t  reason: collision with root package name */
    private int f28215t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f28216u;

    /* renamed from: v  reason: collision with root package name */
    private CharSequence f28217v;

    /* renamed from: w  reason: collision with root package name */
    private int f28218w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f28219x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f28220y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f28221z;

    private final class ComponentListener implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.VisibilityListener, StyledPlayerControlView.OnFullScreenModeChangedListener {

        /* renamed from: b  reason: collision with root package name */
        private final Timeline.Period f28222b = new Timeline.Period();

        /* renamed from: c  reason: collision with root package name */
        private Object f28223c;

        public ComponentListener() {
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            x1.c(this, commands);
        }

        public void onClick(View view) {
            StyledPlayerView.this.H();
        }

        public void onCues(CueGroup cueGroup) {
            if (StyledPlayerView.this.f28203h != null) {
                StyledPlayerView.this.f28203h.setCues(cueGroup.f27240b);
            }
        }

        public /* synthetic */ void onCues(List list) {
            x1.e(this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            x1.f(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            x1.g(this, i2, z2);
        }

        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            x1.h(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            x1.i(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            x1.j(this, z2);
        }

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            StyledPlayerView.q((TextureView) view, StyledPlayerView.this.A);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            x1.k(this, z2);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i2) {
            x1.m(this, mediaItem, i2);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            x1.n(this, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(Metadata metadata) {
            x1.o(this, metadata);
        }

        public void onPlayWhenReadyChanged(boolean z2, int i2) {
            StyledPlayerView.this.J();
            StyledPlayerView.this.L();
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            x1.q(this, playbackParameters);
        }

        public void onPlaybackStateChanged(int i2) {
            StyledPlayerView.this.J();
            StyledPlayerView.this.M();
            StyledPlayerView.this.L();
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            x1.s(this, i2);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            x1.t(this, playbackException);
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            x1.u(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            x1.v(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            x1.x(this, i2);
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            if (StyledPlayerView.this.y() && StyledPlayerView.this.f28220y) {
                StyledPlayerView.this.w();
            }
        }

        public void onRenderedFirstFrame() {
            if (StyledPlayerView.this.f28199d != null) {
                StyledPlayerView.this.f28199d.setVisibility(4);
            }
        }

        public /* synthetic */ void onRepeatModeChanged(int i2) {
            x1.A(this, i2);
        }

        public /* synthetic */ void onSeekProcessed() {
            x1.D(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            x1.E(this, z2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            x1.F(this, z2);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
            x1.G(this, i2, i3);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i2) {
            x1.H(this, timeline, i2);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            x1.I(this, trackSelectionParameters);
        }

        public void onTracksChanged(Tracks tracks) {
            Timeline timeline;
            Player player = (Player) Assertions.e(StyledPlayerView.this.f28209n);
            if (player.q(17)) {
                timeline = player.t();
            } else {
                timeline = Timeline.f23481b;
            }
            if (timeline.u()) {
                this.f28223c = null;
            } else if (!player.q(30) || player.m().c()) {
                Object obj = this.f28223c;
                if (obj != null) {
                    int f2 = timeline.f(obj);
                    if (f2 == -1 || player.M() != timeline.j(f2, this.f28222b).f23494d) {
                        this.f28223c = null;
                    } else {
                        return;
                    }
                }
            } else {
                this.f28223c = timeline.k(player.E(), this.f28222b, true).f23493c;
            }
            StyledPlayerView.this.N(false);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            StyledPlayerView.this.I();
        }

        public void onVisibilityChange(int i2) {
            StyledPlayerView.this.K();
            if (StyledPlayerView.this.f28211p != null) {
                StyledPlayerView.this.f28211p.a(i2);
            }
        }

        public /* synthetic */ void onVolumeChanged(float f2) {
            x1.L(this, f2);
        }

        public void p(boolean z2) {
            FullscreenButtonClickListener unused = StyledPlayerView.this.getClass();
        }
    }

    public interface ControllerVisibilityListener {
        void a(int i2);
    }

    public interface FullscreenButtonClickListener {
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StyledPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        int i6;
        boolean z5;
        boolean z6;
        int i7;
        int i8;
        boolean z7;
        boolean z8;
        boolean z9;
        int i9;
        boolean z10;
        boolean z11;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        ComponentListener componentListener = new ComponentListener();
        this.f28197b = componentListener;
        if (isInEditMode()) {
            this.f28198c = null;
            this.f28199d = null;
            this.f28200e = null;
            this.f28201f = false;
            this.f28202g = null;
            this.f28203h = null;
            this.f28204i = null;
            this.f28205j = null;
            this.f28206k = null;
            this.f28207l = null;
            this.f28208m = null;
            ImageView imageView = new ImageView(context2);
            if (Util.f28808a >= 23) {
                t(context2, getResources(), imageView);
            } else {
                s(context2, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i10 = R$layout.f27995e;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f28047j0, i2, 0);
            try {
                int i11 = R$styleable.f28067t0;
                boolean hasValue = obtainStyledAttributes.hasValue(i11);
                int color = obtainStyledAttributes.getColor(i11, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f28059p0, i10);
                boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.f28071v0, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.f28051l0, 0);
                boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.f28073w0, true);
                int i12 = obtainStyledAttributes.getInt(R$styleable.f28069u0, 1);
                int i13 = obtainStyledAttributes.getInt(R$styleable.f28061q0, 0);
                int i14 = obtainStyledAttributes.getInt(R$styleable.f28065s0, 5000);
                boolean z14 = obtainStyledAttributes.getBoolean(R$styleable.f28055n0, true);
                int i15 = resourceId;
                boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.f28049k0, true);
                i7 = obtainStyledAttributes.getInteger(R$styleable.f28063r0, 0);
                int i16 = i13;
                this.f28216u = obtainStyledAttributes.getBoolean(R$styleable.f28057o0, this.f28216u);
                boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.f28053m0, true);
                obtainStyledAttributes.recycle();
                z5 = z14;
                z7 = z15;
                i8 = i16;
                z2 = z13;
                i4 = resourceId2;
                z3 = z12;
                z4 = hasValue;
                i5 = color;
                i6 = i12;
                boolean z17 = z16;
                i10 = i15;
                i3 = i14;
                z6 = z17;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i3 = 5000;
            z7 = true;
            i8 = 0;
            i7 = 0;
            z6 = true;
            z5 = true;
            i6 = 1;
            i5 = 0;
            z4 = false;
            z3 = true;
            i4 = 0;
            z2 = true;
        }
        LayoutInflater.from(context).inflate(i10, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.f27971i);
        this.f28198c = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            D(aspectRatioFrameLayout, i8);
        }
        View findViewById = findViewById(R$id.O);
        this.f28199d = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i6 == 0) {
            this.f28200e = null;
            z8 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 != 2) {
                Class<Context> cls = Context.class;
                if (i6 == 3) {
                    Class<SphericalGLSurfaceView> cls2 = SphericalGLSurfaceView.class;
                    try {
                        int i17 = SphericalGLSurfaceView.f29022n;
                        this.f28200e = cls2.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                        z11 = true;
                        this.f28200e.setLayoutParams(layoutParams);
                        this.f28200e.setOnClickListener(componentListener);
                        this.f28200e.setClickable(false);
                        aspectRatioFrameLayout.addView(this.f28200e, 0);
                        z8 = z11;
                    } catch (Exception e2) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                } else if (i6 != 4) {
                    this.f28200e = new SurfaceView(context2);
                } else {
                    Class<VideoDecoderGLSurfaceView> cls3 = VideoDecoderGLSurfaceView.class;
                    try {
                        int i18 = VideoDecoderGLSurfaceView.f28911c;
                        this.f28200e = cls3.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                    } catch (Exception e3) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                    }
                }
            } else {
                this.f28200e = new TextureView(context2);
            }
            z11 = false;
            this.f28200e.setLayoutParams(layoutParams);
            this.f28200e.setOnClickListener(componentListener);
            this.f28200e.setClickable(false);
            aspectRatioFrameLayout.addView(this.f28200e, 0);
            z8 = z11;
        }
        this.f28201f = z8;
        this.f28207l = (FrameLayout) findViewById(R$id.f27963a);
        this.f28208m = (FrameLayout) findViewById(R$id.A);
        ImageView imageView2 = (ImageView) findViewById(R$id.f27964b);
        this.f28202g = imageView2;
        if (!z3 || imageView2 == null) {
            z9 = false;
        } else {
            z9 = true;
        }
        this.f28213r = z9;
        if (i4 != 0) {
            this.f28214s = ContextCompat.getDrawable(getContext(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.R);
        this.f28203h = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View findViewById2 = findViewById(R$id.f27968f);
        this.f28204i = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f28215t = i7;
        TextView textView = (TextView) findViewById(R$id.f27976n);
        this.f28205j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i19 = R$id.f27972j;
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(i19);
        View findViewById3 = findViewById(R$id.f27973k);
        if (styledPlayerControlView != null) {
            this.f28206k = styledPlayerControlView;
        } else if (findViewById3 != null) {
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.f28206k = styledPlayerControlView2;
            styledPlayerControlView2.setId(i19);
            styledPlayerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(styledPlayerControlView2, indexOfChild);
        } else {
            this.f28206k = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.f28206k;
        if (styledPlayerControlView3 != null) {
            i9 = i3;
        } else {
            i9 = 0;
        }
        this.f28218w = i9;
        this.f28221z = z5;
        this.f28219x = z7;
        this.f28220y = z6;
        if (!z2 || styledPlayerControlView3 == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f28210o = z10;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.c0();
            this.f28206k.S(componentListener);
        }
        if (z2) {
            setClickable(true);
        }
        K();
    }

    @RequiresNonNull({"artworkView"})
    private boolean B(Player player) {
        byte[] bArr;
        if (!player.q(18) || (bArr = player.S().f23262k) == null) {
            return false;
        }
        return C(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    @RequiresNonNull({"artworkView"})
    private boolean C(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                A(this.f28198c, ((float) intrinsicWidth) / ((float) intrinsicHeight));
                this.f28202g.setImageDrawable(drawable);
                this.f28202g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void D(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean E() {
        Player player = this.f28209n;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (!this.f28219x || ((this.f28209n.q(17) && this.f28209n.t().u()) || (playbackState != 1 && playbackState != 4 && ((Player) Assertions.e(this.f28209n)).A()))) {
            return false;
        }
        return true;
    }

    private void G(boolean z2) {
        int i2;
        if (P()) {
            StyledPlayerControlView styledPlayerControlView = this.f28206k;
            if (z2) {
                i2 = 0;
            } else {
                i2 = this.f28218w;
            }
            styledPlayerControlView.setShowTimeoutMs(i2);
            this.f28206k.r0();
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        if (P() && this.f28209n != null) {
            if (!this.f28206k.f0()) {
                z(true);
            } else if (this.f28221z) {
                this.f28206k.b0();
            }
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        VideoSize videoSize;
        float f2;
        Player player = this.f28209n;
        if (player != null) {
            videoSize = player.G();
        } else {
            videoSize = VideoSize.f28956f;
        }
        int i2 = videoSize.f28962b;
        int i3 = videoSize.f28963c;
        int i4 = videoSize.f28964d;
        float f3 = 0.0f;
        if (i3 == 0 || i2 == 0) {
            f2 = 0.0f;
        } else {
            f2 = (((float) i2) * videoSize.f28965e) / ((float) i3);
        }
        View view = this.f28200e;
        if (view instanceof TextureView) {
            if (f2 > 0.0f && (i4 == 90 || i4 == 270)) {
                f2 = 1.0f / f2;
            }
            if (this.A != 0) {
                view.removeOnLayoutChangeListener(this.f28197b);
            }
            this.A = i4;
            if (i4 != 0) {
                this.f28200e.addOnLayoutChangeListener(this.f28197b);
            }
            q((TextureView) this.f28200e, this.A);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f28198c;
        if (!this.f28201f) {
            f3 = f2;
        }
        A(aspectRatioFrameLayout, f3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4.f28209n.A() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J() {
        /*
            r4 = this;
            android.view.View r0 = r4.f28204i
            if (r0 == 0) goto L_0x002b
            com.google.android.exoplayer2.Player r0 = r4.f28209n
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L_0x0020
            int r0 = r4.f28215t
            r3 = 1
            if (r0 == r2) goto L_0x0021
            if (r0 != r3) goto L_0x0020
            com.google.android.exoplayer2.Player r0 = r4.f28209n
            boolean r0 = r0.A()
            if (r0 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            android.view.View r0 = r4.f28204i
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 8
        L_0x0028:
            r0.setVisibility(r1)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerView.J():void");
    }

    /* access modifiers changed from: private */
    public void K() {
        StyledPlayerControlView styledPlayerControlView = this.f28206k;
        String str = null;
        if (styledPlayerControlView == null || !this.f28210o) {
            setContentDescription((CharSequence) null);
        } else if (styledPlayerControlView.f0()) {
            if (this.f28221z) {
                str = getResources().getString(R$string.f28005e);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(R$string.f28012l));
        }
    }

    /* access modifiers changed from: private */
    public void L() {
        if (!y() || !this.f28220y) {
            z(false);
        } else {
            w();
        }
    }

    /* access modifiers changed from: private */
    public void M() {
        TextView textView = this.f28205j;
        if (textView != null) {
            CharSequence charSequence = this.f28217v;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f28205j.setVisibility(0);
                return;
            }
            Player player = this.f28209n;
            if (player != null) {
                PlaybackException k2 = player.k();
            }
            this.f28205j.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void N(boolean z2) {
        Player player = this.f28209n;
        if (player != null && player.q(30) && !player.m().c()) {
            if (z2 && !this.f28216u) {
                r();
            }
            if (player.m().d(2)) {
                v();
                return;
            }
            r();
            if (!O() || (!B(player) && !C(this.f28214s))) {
                v();
            }
        } else if (!this.f28216u) {
            v();
            r();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean O() {
        if (!this.f28213r) {
            return false;
        }
        Assertions.i(this.f28202g);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean P() {
        if (!this.f28210o) {
            return false;
        }
        Assertions.i(this.f28206k);
        return true;
    }

    /* access modifiers changed from: private */
    public static void q(TextureView textureView, int i2) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i2 == 0)) {
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.postRotate((float) i2, f2, f3);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        }
        textureView.setTransform(matrix);
    }

    private void r() {
        View view = this.f28199d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.V(context, resources, R$drawable.f27948f));
        imageView.setBackgroundColor(resources.getColor(R$color.f27938a));
    }

    private static void t(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.V(context, resources, R$drawable.f27948f));
        imageView.setBackgroundColor(resources.getColor(R$color.f27938a, (Resources.Theme) null));
    }

    private void v() {
        ImageView imageView = this.f28202g;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f28202g.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean x(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    /* access modifiers changed from: private */
    public boolean y() {
        Player player = this.f28209n;
        if (player == null || !player.q(16) || !this.f28209n.f() || !this.f28209n.A()) {
            return false;
        }
        return true;
    }

    private void z(boolean z2) {
        boolean z3;
        if ((!y() || !this.f28220y) && P()) {
            if (!this.f28206k.f0() || this.f28206k.getShowTimeoutMs() > 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean E = E();
            if (z2 || z3 || E) {
                G(E);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void A(AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public void F() {
        G(E());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.f28209n;
        if (player != null && player.q(16) && this.f28209n.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean x2 = x(keyEvent.getKeyCode());
        if (x2 && P() && !this.f28206k.f0()) {
            z(true);
            return true;
        } else if (u(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            z(true);
            return true;
        } else {
            if (x2 && P()) {
                z(true);
            }
            return false;
        }
    }

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f28208m;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.f28206k;
        if (styledPlayerControlView != null) {
            arrayList.add(new AdOverlayInfo(styledPlayerControlView, 1));
        }
        return ImmutableList.n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.j(this.f28207l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f28219x;
    }

    public boolean getControllerHideOnTouch() {
        return this.f28221z;
    }

    public int getControllerShowTimeoutMs() {
        return this.f28218w;
    }

    public Drawable getDefaultArtwork() {
        return this.f28214s;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f28208m;
    }

    public Player getPlayer() {
        return this.f28209n;
    }

    public int getResizeMode() {
        Assertions.i(this.f28198c);
        return this.f28198c.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f28203h;
    }

    public boolean getUseArtwork() {
        return this.f28213r;
    }

    public boolean getUseController() {
        return this.f28210o;
    }

    public View getVideoSurfaceView() {
        return this.f28200e;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!P() || this.f28209n == null) {
            return false;
        }
        z(true);
        return true;
    }

    public boolean performClick() {
        H();
        return super.performClick();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.i(this.f28198c);
        this.f28198c.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAutoShow(boolean z2) {
        this.f28219x = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.f28220y = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28221z = z2;
        K();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        Assertions.i(this.f28206k);
        this.f28206k.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    public void setControllerShowTimeoutMs(int i2) {
        Assertions.i(this.f28206k);
        this.f28218w = i2;
        if (this.f28206k.f0()) {
            F();
        }
    }

    public void setControllerVisibilityListener(ControllerVisibilityListener controllerVisibilityListener) {
        this.f28211p = controllerVisibilityListener;
        if (controllerVisibilityListener != null) {
            setControllerVisibilityListener((StyledPlayerControlView.VisibilityListener) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        boolean z2;
        if (this.f28205j != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f28217v = charSequence;
        M();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f28214s != drawable) {
            this.f28214s = drawable;
            N(false);
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (errorMessageProvider != null) {
            M();
        }
    }

    public void setFullscreenButtonClickListener(FullscreenButtonClickListener fullscreenButtonClickListener) {
        Assertions.i(this.f28206k);
        this.f28206k.setOnFullScreenModeChangedListener(this.f28197b);
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.f28216u != z2) {
            this.f28216u = z2;
            N(false);
        }
    }

    public void setPlayer(Player player) {
        boolean z2;
        boolean z3;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (player == null || player.u() == Looper.getMainLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.f28209n;
        if (player2 != player) {
            if (player2 != null) {
                player2.V(this.f28197b);
                if (player2.q(27)) {
                    View view = this.f28200e;
                    if (view instanceof TextureView) {
                        player2.F((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        player2.N((SurfaceView) view);
                    }
                }
            }
            SubtitleView subtitleView = this.f28203h;
            if (subtitleView != null) {
                subtitleView.setCues((List<Cue>) null);
            }
            this.f28209n = player;
            if (P()) {
                this.f28206k.setPlayer(player);
            }
            J();
            M();
            N(true);
            if (player != null) {
                if (player.q(27)) {
                    View view2 = this.f28200e;
                    if (view2 instanceof TextureView) {
                        player.x((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        player.i((SurfaceView) view2);
                    }
                    I();
                }
                if (this.f28203h != null && player.q(28)) {
                    this.f28203h.setCues(player.o().f27240b);
                }
                player.X(this.f28197b);
                z(false);
                return;
            }
            w();
        }
    }

    public void setRepeatToggleModes(int i2) {
        Assertions.i(this.f28206k);
        this.f28206k.setRepeatToggleModes(i2);
    }

    public void setResizeMode(int i2) {
        Assertions.i(this.f28198c);
        this.f28198c.setResizeMode(i2);
    }

    public void setShowBuffering(int i2) {
        if (this.f28215t != i2) {
            this.f28215t = i2;
            J();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowShuffleButton(z2);
    }

    public void setShowSubtitleButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowSubtitleButton(z2);
    }

    public void setShowVrButton(boolean z2) {
        Assertions.i(this.f28206k);
        this.f28206k.setShowVrButton(z2);
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.f28199d;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setUseArtwork(boolean z2) {
        boolean z3;
        if (!z2 || this.f28202g != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.g(z3);
        if (this.f28213r != z2) {
            this.f28213r = z2;
            N(false);
        }
    }

    public void setUseController(boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (!z2 || this.f28206k != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.g(z3);
        if (z2 || hasOnClickListeners()) {
            z4 = true;
        }
        setClickable(z4);
        if (this.f28210o != z2) {
            this.f28210o = z2;
            if (P()) {
                this.f28206k.setPlayer(this.f28209n);
            } else {
                StyledPlayerControlView styledPlayerControlView = this.f28206k;
                if (styledPlayerControlView != null) {
                    styledPlayerControlView.b0();
                    this.f28206k.setPlayer((Player) null);
                }
            }
            K();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f28200e;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    public boolean u(KeyEvent keyEvent) {
        return P() && this.f28206k.U(keyEvent);
    }

    public void w() {
        StyledPlayerControlView styledPlayerControlView = this.f28206k;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.b0();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(StyledPlayerControlView.VisibilityListener visibilityListener) {
        Assertions.i(this.f28206k);
        StyledPlayerControlView.VisibilityListener visibilityListener2 = this.f28212q;
        if (visibilityListener2 != visibilityListener) {
            if (visibilityListener2 != null) {
                this.f28206k.m0(visibilityListener2);
            }
            this.f28212q = visibilityListener;
            if (visibilityListener != null) {
                this.f28206k.S(visibilityListener);
                setControllerVisibilityListener((ControllerVisibilityListener) null);
            }
        }
    }
}
