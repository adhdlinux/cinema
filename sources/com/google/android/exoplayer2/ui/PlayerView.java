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
import com.google.android.exoplayer2.ui.PlayerControlView;
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

@Deprecated
public class PlayerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final ComponentListener f27909b;

    /* renamed from: c  reason: collision with root package name */
    private final AspectRatioFrameLayout f27910c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f27911d;

    /* renamed from: e  reason: collision with root package name */
    private final View f27912e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f27913f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f27914g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SubtitleView f27915h;

    /* renamed from: i  reason: collision with root package name */
    private final View f27916i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f27917j;

    /* renamed from: k  reason: collision with root package name */
    private final PlayerControlView f27918k;

    /* renamed from: l  reason: collision with root package name */
    private final FrameLayout f27919l;

    /* renamed from: m  reason: collision with root package name */
    private final FrameLayout f27920m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Player f27921n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f27922o;

    /* renamed from: p  reason: collision with root package name */
    private PlayerControlView.VisibilityListener f27923p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f27924q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f27925r;

    /* renamed from: s  reason: collision with root package name */
    private int f27926s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f27927t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f27928u;

    /* renamed from: v  reason: collision with root package name */
    private int f27929v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f27930w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f27931x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f27932y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f27933z;

    private final class ComponentListener implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.VisibilityListener {

        /* renamed from: b  reason: collision with root package name */
        private final Timeline.Period f27934b = new Timeline.Period();

        /* renamed from: c  reason: collision with root package name */
        private Object f27935c;

        public ComponentListener() {
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            x1.c(this, commands);
        }

        public void onClick(View view) {
            PlayerView.this.F();
        }

        public void onCues(CueGroup cueGroup) {
            if (PlayerView.this.f27915h != null) {
                PlayerView.this.f27915h.setCues(cueGroup.f27240b);
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
            PlayerView.o((TextureView) view, PlayerView.this.f27933z);
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
            PlayerView.this.H();
            PlayerView.this.J();
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            x1.q(this, playbackParameters);
        }

        public void onPlaybackStateChanged(int i2) {
            PlayerView.this.H();
            PlayerView.this.K();
            PlayerView.this.J();
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
            if (PlayerView.this.w() && PlayerView.this.f27931x) {
                PlayerView.this.u();
            }
        }

        public void onRenderedFirstFrame() {
            if (PlayerView.this.f27911d != null) {
                PlayerView.this.f27911d.setVisibility(4);
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
            Player player = (Player) Assertions.e(PlayerView.this.f27921n);
            Timeline t2 = player.t();
            if (t2.u()) {
                this.f27935c = null;
            } else if (!player.m().c()) {
                this.f27935c = t2.k(player.E(), this.f27934b, true).f23493c;
            } else {
                Object obj = this.f27935c;
                if (obj != null) {
                    int f2 = t2.f(obj);
                    if (f2 == -1 || player.M() != t2.j(f2, this.f27934b).f23494d) {
                        this.f27935c = null;
                    } else {
                        return;
                    }
                }
            }
            PlayerView.this.L(false);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            PlayerView.this.G();
        }

        public void onVisibilityChange(int i2) {
            PlayerView.this.I();
        }

        public /* synthetic */ void onVolumeChanged(float f2) {
            x1.L(this, f2);
        }
    }

    public PlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    @RequiresNonNull({"artworkView"})
    private boolean A(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                y(this.f27910c, ((float) intrinsicWidth) / ((float) intrinsicHeight));
                this.f27914g.setImageDrawable(drawable);
                this.f27914g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void B(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean C() {
        Player player = this.f27921n;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (!this.f27930w || (playbackState != 1 && playbackState != 4 && this.f27921n.A())) {
            return false;
        }
        return true;
    }

    private void E(boolean z2) {
        int i2;
        if (N()) {
            PlayerControlView playerControlView = this.f27918k;
            if (z2) {
                i2 = 0;
            } else {
                i2 = this.f27929v;
            }
            playerControlView.setShowTimeoutMs(i2);
            this.f27918k.P();
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        if (N() && this.f27921n != null) {
            if (!this.f27918k.I()) {
                x(true);
            } else if (this.f27932y) {
                this.f27918k.F();
            }
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        VideoSize videoSize;
        float f2;
        Player player = this.f27921n;
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
        View view = this.f27912e;
        if (view instanceof TextureView) {
            if (f2 > 0.0f && (i4 == 90 || i4 == 270)) {
                f2 = 1.0f / f2;
            }
            if (this.f27933z != 0) {
                view.removeOnLayoutChangeListener(this.f27909b);
            }
            this.f27933z = i4;
            if (i4 != 0) {
                this.f27912e.addOnLayoutChangeListener(this.f27909b);
            }
            o((TextureView) this.f27912e, this.f27933z);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f27910c;
        if (!this.f27913f) {
            f3 = f2;
        }
        y(aspectRatioFrameLayout, f3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4.f27921n.A() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H() {
        /*
            r4 = this;
            android.view.View r0 = r4.f27916i
            if (r0 == 0) goto L_0x002b
            com.google.android.exoplayer2.Player r0 = r4.f27921n
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L_0x0020
            int r0 = r4.f27926s
            r3 = 1
            if (r0 == r2) goto L_0x0021
            if (r0 != r3) goto L_0x0020
            com.google.android.exoplayer2.Player r0 = r4.f27921n
            boolean r0 = r0.A()
            if (r0 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            android.view.View r0 = r4.f27916i
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 8
        L_0x0028:
            r0.setVisibility(r1)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.H():void");
    }

    /* access modifiers changed from: private */
    public void I() {
        PlayerControlView playerControlView = this.f27918k;
        String str = null;
        if (playerControlView == null || !this.f27922o) {
            setContentDescription((CharSequence) null);
        } else if (playerControlView.getVisibility() == 0) {
            if (this.f27932y) {
                str = getResources().getString(R$string.f28005e);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(R$string.f28012l));
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        if (!w() || !this.f27931x) {
            x(false);
        } else {
            u();
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        TextView textView = this.f27917j;
        if (textView != null) {
            CharSequence charSequence = this.f27928u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f27917j.setVisibility(0);
                return;
            }
            Player player = this.f27921n;
            if (player != null) {
                PlaybackException k2 = player.k();
            }
            this.f27917j.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void L(boolean z2) {
        Player player = this.f27921n;
        if (player != null && player.q(30) && !player.m().c()) {
            if (z2 && !this.f27927t) {
                p();
            }
            if (player.m().d(2)) {
                t();
                return;
            }
            p();
            if (!M() || (!z(player.S()) && !A(this.f27925r))) {
                t();
            }
        } else if (!this.f27927t) {
            t();
            p();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean M() {
        if (!this.f27924q) {
            return false;
        }
        Assertions.i(this.f27914g);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean N() {
        if (!this.f27922o) {
            return false;
        }
        Assertions.i(this.f27918k);
        return true;
    }

    /* access modifiers changed from: private */
    public static void o(TextureView textureView, int i2) {
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

    private void p() {
        View view = this.f27911d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void q(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.V(context, resources, R$drawable.f27948f));
        imageView.setBackgroundColor(resources.getColor(R$color.f27938a));
    }

    private static void r(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.V(context, resources, R$drawable.f27948f));
        imageView.setBackgroundColor(resources.getColor(R$color.f27938a, (Resources.Theme) null));
    }

    private void t() {
        ImageView imageView = this.f27914g;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f27914g.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean v(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    /* access modifiers changed from: private */
    public boolean w() {
        Player player = this.f27921n;
        return player != null && player.f() && this.f27921n.A();
    }

    private void x(boolean z2) {
        boolean z3;
        if ((!w() || !this.f27931x) && N()) {
            if (!this.f27918k.I() || this.f27918k.getShowTimeoutMs() > 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean C = C();
            if (z2 || z3 || C) {
                E(C);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    private boolean z(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.f23262k;
        if (bArr == null) {
            return false;
        }
        return A(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public void D() {
        E(C());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.f27921n;
        if (player != null && player.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean v2 = v(keyEvent.getKeyCode());
        if (v2 && N() && !this.f27918k.I()) {
            x(true);
            return true;
        } else if (s(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            x(true);
            return true;
        } else {
            if (v2 && N()) {
                x(true);
            }
            return false;
        }
    }

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f27920m;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f27918k;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo(playerControlView, 1));
        }
        return ImmutableList.n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.j(this.f27919l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f27930w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f27932y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f27929v;
    }

    public Drawable getDefaultArtwork() {
        return this.f27925r;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f27920m;
    }

    public Player getPlayer() {
        return this.f27921n;
    }

    public int getResizeMode() {
        Assertions.i(this.f27910c);
        return this.f27910c.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f27915h;
    }

    public boolean getUseArtwork() {
        return this.f27924q;
    }

    public boolean getUseController() {
        return this.f27922o;
    }

    public View getVideoSurfaceView() {
        return this.f27912e;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!N() || this.f27921n == null) {
            return false;
        }
        x(true);
        return true;
    }

    public boolean performClick() {
        F();
        return super.performClick();
    }

    public boolean s(KeyEvent keyEvent) {
        return N() && this.f27918k.A(keyEvent);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.i(this.f27910c);
        this.f27910c.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAutoShow(boolean z2) {
        this.f27930w = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.f27931x = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27932y = z2;
        I();
    }

    public void setControllerShowTimeoutMs(int i2) {
        Assertions.i(this.f27918k);
        this.f27929v = i2;
        if (this.f27918k.I()) {
            D();
        }
    }

    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.i(this.f27918k);
        PlayerControlView.VisibilityListener visibilityListener2 = this.f27923p;
        if (visibilityListener2 != visibilityListener) {
            if (visibilityListener2 != null) {
                this.f27918k.J(visibilityListener2);
            }
            this.f27923p = visibilityListener;
            if (visibilityListener != null) {
                this.f27918k.y(visibilityListener);
            }
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        boolean z2;
        if (this.f27917j != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27928u = charSequence;
        K();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f27925r != drawable) {
            this.f27925r = drawable;
            L(false);
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (errorMessageProvider != null) {
            K();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.f27927t != z2) {
            this.f27927t = z2;
            L(false);
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
        Player player2 = this.f27921n;
        if (player2 != player) {
            if (player2 != null) {
                player2.V(this.f27909b);
                if (player2.q(27)) {
                    View view = this.f27912e;
                    if (view instanceof TextureView) {
                        player2.F((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        player2.N((SurfaceView) view);
                    }
                }
            }
            SubtitleView subtitleView = this.f27915h;
            if (subtitleView != null) {
                subtitleView.setCues((List<Cue>) null);
            }
            this.f27921n = player;
            if (N()) {
                this.f27918k.setPlayer(player);
            }
            H();
            K();
            L(true);
            if (player != null) {
                if (player.q(27)) {
                    View view2 = this.f27912e;
                    if (view2 instanceof TextureView) {
                        player.x((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        player.i((SurfaceView) view2);
                    }
                    G();
                }
                if (this.f27915h != null && player.q(28)) {
                    this.f27915h.setCues(player.o().f27240b);
                }
                player.X(this.f27909b);
                x(false);
                return;
            }
            u();
        }
    }

    public void setRepeatToggleModes(int i2) {
        Assertions.i(this.f27918k);
        this.f27918k.setRepeatToggleModes(i2);
    }

    public void setResizeMode(int i2) {
        Assertions.i(this.f27910c);
        this.f27910c.setResizeMode(i2);
    }

    public void setShowBuffering(int i2) {
        if (this.f27926s != i2) {
            this.f27926s = i2;
            H();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        Assertions.i(this.f27918k);
        this.f27918k.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.f27911d;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setUseArtwork(boolean z2) {
        boolean z3;
        if (!z2 || this.f27914g != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.g(z3);
        if (this.f27924q != z2) {
            this.f27924q = z2;
            L(false);
        }
    }

    public void setUseController(boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (!z2 || this.f27918k != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.g(z3);
        if (z2 || hasOnClickListeners()) {
            z4 = true;
        }
        setClickable(z4);
        if (this.f27922o != z2) {
            this.f27922o = z2;
            if (N()) {
                this.f27918k.setPlayer(this.f27921n);
            } else {
                PlayerControlView playerControlView = this.f27918k;
                if (playerControlView != null) {
                    playerControlView.F();
                    this.f27918k.setPlayer((Player) null);
                }
            }
            I();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f27912e;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    public void u() {
        PlayerControlView playerControlView = this.f27918k;
        if (playerControlView != null) {
            playerControlView.F();
        }
    }

    /* access modifiers changed from: protected */
    public void y(AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i2) {
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
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        ComponentListener componentListener = new ComponentListener();
        this.f27909b = componentListener;
        if (isInEditMode()) {
            this.f27910c = null;
            this.f27911d = null;
            this.f27912e = null;
            this.f27913f = false;
            this.f27914g = null;
            this.f27915h = null;
            this.f27916i = null;
            this.f27917j = null;
            this.f27918k = null;
            this.f27919l = null;
            this.f27920m = null;
            ImageView imageView = new ImageView(context2);
            if (Util.f28808a >= 23) {
                r(context2, getResources(), imageView);
            } else {
                q(context2, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i9 = R$layout.f27993c;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.H, i2, 0);
            try {
                int i10 = R$styleable.R;
                boolean hasValue = obtainStyledAttributes.hasValue(i10);
                int color = obtainStyledAttributes.getColor(i10, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.N, i9);
                boolean z10 = obtainStyledAttributes.getBoolean(R$styleable.T, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.J, 0);
                boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.U, true);
                int i11 = obtainStyledAttributes.getInt(R$styleable.S, 1);
                int i12 = obtainStyledAttributes.getInt(R$styleable.O, 0);
                int i13 = obtainStyledAttributes.getInt(R$styleable.Q, 5000);
                boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.L, true);
                int i14 = resourceId;
                boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.I, true);
                i7 = obtainStyledAttributes.getInteger(R$styleable.P, 0);
                int i15 = i12;
                this.f27927t = obtainStyledAttributes.getBoolean(R$styleable.M, this.f27927t);
                boolean z14 = obtainStyledAttributes.getBoolean(R$styleable.K, true);
                obtainStyledAttributes.recycle();
                z5 = z12;
                z7 = z13;
                i8 = i15;
                z2 = z11;
                i4 = resourceId2;
                z3 = z10;
                z4 = hasValue;
                i5 = color;
                i6 = i11;
                boolean z15 = z14;
                i9 = i14;
                i3 = i13;
                z6 = z15;
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
        LayoutInflater.from(context).inflate(i9, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.f27971i);
        this.f27910c = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            B(aspectRatioFrameLayout, i8);
        }
        View findViewById = findViewById(R$id.O);
        this.f27911d = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i6 == 0) {
            this.f27912e = null;
            z8 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 != 2) {
                Class<Context> cls = Context.class;
                if (i6 == 3) {
                    Class<SphericalGLSurfaceView> cls2 = SphericalGLSurfaceView.class;
                    try {
                        int i16 = SphericalGLSurfaceView.f29022n;
                        this.f27912e = cls2.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                        z9 = true;
                        this.f27912e.setLayoutParams(layoutParams);
                        this.f27912e.setOnClickListener(componentListener);
                        this.f27912e.setClickable(false);
                        aspectRatioFrameLayout.addView(this.f27912e, 0);
                        z8 = z9;
                    } catch (Exception e2) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                } else if (i6 != 4) {
                    this.f27912e = new SurfaceView(context2);
                } else {
                    Class<VideoDecoderGLSurfaceView> cls3 = VideoDecoderGLSurfaceView.class;
                    try {
                        int i17 = VideoDecoderGLSurfaceView.f28911c;
                        this.f27912e = cls3.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                    } catch (Exception e3) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                    }
                }
            } else {
                this.f27912e = new TextureView(context2);
            }
            z9 = false;
            this.f27912e.setLayoutParams(layoutParams);
            this.f27912e.setOnClickListener(componentListener);
            this.f27912e.setClickable(false);
            aspectRatioFrameLayout.addView(this.f27912e, 0);
            z8 = z9;
        }
        this.f27913f = z8;
        this.f27919l = (FrameLayout) findViewById(R$id.f27963a);
        this.f27920m = (FrameLayout) findViewById(R$id.A);
        ImageView imageView2 = (ImageView) findViewById(R$id.f27964b);
        this.f27914g = imageView2;
        this.f27924q = z3 && imageView2 != null;
        if (i4 != 0) {
            this.f27925r = ContextCompat.getDrawable(getContext(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.R);
        this.f27915h = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View findViewById2 = findViewById(R$id.f27968f);
        this.f27916i = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f27926s = i7;
        TextView textView = (TextView) findViewById(R$id.f27976n);
        this.f27917j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i18 = R$id.f27972j;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i18);
        View findViewById3 = findViewById(R$id.f27973k);
        if (playerControlView != null) {
            this.f27918k = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.f27918k = playerControlView2;
            playerControlView2.setId(i18);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            this.f27918k = null;
        }
        PlayerControlView playerControlView3 = this.f27918k;
        this.f27929v = playerControlView3 != null ? i3 : 0;
        this.f27932y = z5;
        this.f27930w = z7;
        this.f27931x = z6;
        this.f27922o = z2 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.F();
            this.f27918k.y(componentListener);
        }
        if (z2) {
            setClickable(true);
        }
        I();
    }
}
