package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.AttachedSurfaceControl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import androidx.core.content.ContextCompat;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ErrorMessageProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.e;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerControlView;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p.h;
import p.i;
import p.j;

public class PlayerView extends FrameLayout {
    private int A;
    private boolean B;
    private CharSequence C;
    private int D;
    private boolean E;
    /* access modifiers changed from: private */
    public boolean F;
    private boolean G;
    /* access modifiers changed from: private */
    public int H;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentListener f9940b;

    /* renamed from: c  reason: collision with root package name */
    private final AspectRatioFrameLayout f9941c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f9942d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f9943e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9944f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SurfaceSyncGroupCompatV34 f9945g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f9946h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f9947i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final SubtitleView f9948j;

    /* renamed from: k  reason: collision with root package name */
    private final View f9949k;

    /* renamed from: l  reason: collision with root package name */
    private final TextView f9950l;

    /* renamed from: m  reason: collision with root package name */
    private final PlayerControlView f9951m;

    /* renamed from: n  reason: collision with root package name */
    private final FrameLayout f9952n;

    /* renamed from: o  reason: collision with root package name */
    private final FrameLayout f9953o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Handler f9954p;

    /* renamed from: q  reason: collision with root package name */
    private final Class<?> f9955q;

    /* renamed from: r  reason: collision with root package name */
    private final Method f9956r;

    /* renamed from: s  reason: collision with root package name */
    private final Object f9957s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Player f9958t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9959u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public ControllerVisibilityListener f9960v;

    /* renamed from: w  reason: collision with root package name */
    private PlayerControlView.VisibilityListener f9961w;

    /* renamed from: x  reason: collision with root package name */
    private int f9962x;

    /* renamed from: y  reason: collision with root package name */
    private int f9963y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f9964z;

    private static class Api34 {
        private Api34() {
        }

        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    private final class ComponentListener implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.VisibilityListener, PlayerControlView.OnFullScreenModeChangedListener {

        /* renamed from: b  reason: collision with root package name */
        private final Timeline.Period f9965b = new Timeline.Period();

        /* renamed from: c  reason: collision with root package name */
        private Object f9966c;

        public ComponentListener() {
        }

        public void A(CueGroup cueGroup) {
            if (PlayerView.this.f9948j != null) {
                PlayerView.this.f9948j.setCues(cueGroup.f4595a);
            }
        }

        public /* synthetic */ void B(Metadata metadata) {
            e.l(this, metadata);
        }

        public /* synthetic */ void F(MediaMetadata mediaMetadata) {
            e.k(this, mediaMetadata);
        }

        public /* synthetic */ void G(TrackSelectionParameters trackSelectionParameters) {
            e.B(this, trackSelectionParameters);
        }

        public /* synthetic */ void H(MediaItem mediaItem, int i2) {
            e.j(this, mediaItem, i2);
        }

        public /* synthetic */ void I(PlaybackException playbackException) {
            e.q(this, playbackException);
        }

        public /* synthetic */ void L(Player.Commands commands) {
            e.a(this, commands);
        }

        public /* synthetic */ void P(Player player, Player.Events events) {
            e.f(this, player, events);
        }

        public /* synthetic */ void U(Timeline timeline, int i2) {
            e.A(this, timeline, i2);
        }

        public void V(Tracks tracks) {
            Timeline timeline;
            Player player = (Player) Assertions.f(PlayerView.this.f9958t);
            if (player.q(17)) {
                timeline = player.t();
            } else {
                timeline = Timeline.f4346a;
            }
            if (timeline.q()) {
                this.f9966c = null;
            } else if (!player.q(30) || player.m().b()) {
                Object obj = this.f9966c;
                if (obj != null) {
                    int b2 = timeline.b(obj);
                    if (b2 == -1 || player.M() != timeline.f(b2, this.f9965b).f4357c) {
                        this.f9966c = null;
                    } else {
                        return;
                    }
                }
            } else {
                this.f9966c = timeline.g(player.E(), this.f9965b, true).f4356b;
            }
            PlayerView.this.f0(false);
        }

        public /* synthetic */ void W(DeviceInfo deviceInfo) {
            e.d(this, deviceInfo);
        }

        public /* synthetic */ void X(PlaybackException playbackException) {
            e.r(this, playbackException);
        }

        public void a0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            if (PlayerView.this.M() && PlayerView.this.F) {
                PlayerView.this.I();
            }
        }

        public void n(VideoSize videoSize) {
            if (!videoSize.equals(VideoSize.f4483e) && PlayerView.this.f9958t != null && PlayerView.this.f9958t.getPlaybackState() != 1) {
                PlayerView.this.a0();
            }
        }

        public void onClick(View view) {
            PlayerView.this.Z();
        }

        public /* synthetic */ void onCues(List list) {
            e.c(this, list);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            e.e(this, i2, z2);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            e.g(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            e.h(this, z2);
        }

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.y((TextureView) view, PlayerView.this.H);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            e.i(this, z2);
        }

        public void onPlayWhenReadyChanged(boolean z2, int i2) {
            PlayerView.this.b0();
            PlayerView.this.d0();
        }

        public void onPlaybackStateChanged(int i2) {
            PlayerView.this.b0();
            PlayerView.this.e0();
            PlayerView.this.d0();
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            e.p(this, i2);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            e.s(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            e.t(this, i2);
        }

        public void onRenderedFirstFrame() {
            if (PlayerView.this.f9942d != null) {
                PlayerView.this.f9942d.setVisibility(4);
                if (PlayerView.this.E()) {
                    PlayerView.this.J();
                } else {
                    PlayerView.this.G();
                }
            }
        }

        public /* synthetic */ void onRepeatModeChanged(int i2) {
            e.w(this, i2);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            e.x(this, z2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            e.y(this, z2);
        }

        public void onSurfaceSizeChanged(int i2, int i3) {
            if (Util.f4714a == 34 && (PlayerView.this.f9943e instanceof SurfaceView)) {
                ((SurfaceSyncGroupCompatV34) Assertions.f(PlayerView.this.f9945g)).f(PlayerView.this.f9954p, (SurfaceView) PlayerView.this.f9943e, new j(PlayerView.this));
            }
        }

        public void onVisibilityChange(int i2) {
            PlayerView.this.c0();
            if (PlayerView.this.f9960v != null) {
                PlayerView.this.f9960v.a(i2);
            }
        }

        public void p(boolean z2) {
            FullscreenButtonClickListener unused = PlayerView.this.getClass();
        }

        public /* synthetic */ void r(PlaybackParameters playbackParameters) {
            e.n(this, playbackParameters);
        }
    }

    public interface ControllerVisibilityListener {
        void a(int i2);
    }

    public interface FullscreenButtonClickListener {
    }

    private static final class SurfaceSyncGroupCompatV34 {

        /* renamed from: a  reason: collision with root package name */
        SurfaceSyncGroup f9968a;

        private SurfaceSyncGroupCompatV34() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(SurfaceView surfaceView, Runnable runnable) {
            AttachedSurfaceControl a2 = surfaceView.getRootSurfaceControl();
            if (a2 != null) {
                SurfaceSyncGroup surfaceSyncGroup = new SurfaceSyncGroup("exo-sync-b-334901521");
                this.f9968a = surfaceSyncGroup;
                Assertions.h(surfaceSyncGroup.add(a2, new t()));
                runnable.run();
                boolean unused = a2.applyTransactionOnDraw(new SurfaceControl.Transaction());
            }
        }

        public void e() {
            SurfaceSyncGroup surfaceSyncGroup = this.f9968a;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.f9968a = null;
            }
        }

        public void f(Handler handler, SurfaceView surfaceView, Runnable runnable) {
            handler.post(new s(this, surfaceView, runnable));
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        View view = this.f9942d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void B(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.X(context, resources, R$drawable.f9975a));
        imageView.setBackgroundColor(resources.getColor(R$color.f9970a));
    }

    private static void C(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.X(context, resources, R$drawable.f9975a));
        imageView.setBackgroundColor(resources.getColor(R$color.f9970a, (Resources.Theme) null));
    }

    /* access modifiers changed from: private */
    public boolean E() {
        Player player = this.f9958t;
        if (player == null || this.f9957s == null || !player.q(30) || !player.m().c(4)) {
            return false;
        }
        return true;
    }

    private boolean F() {
        Player player = this.f9958t;
        if (player == null || !player.q(30) || !player.m().c(2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void G() {
        J();
        ImageView imageView = this.f9946h;
        if (imageView != null) {
            imageView.setImageResource(17170445);
        }
    }

    private void H() {
        ImageView imageView = this.f9947i;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f9947i.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        ImageView imageView = this.f9946h;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean K(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    private boolean L() {
        Drawable drawable;
        ImageView imageView = this.f9946h;
        if (imageView == null || (drawable = imageView.getDrawable()) == null || drawable.getAlpha() == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean M() {
        Player player = this.f9958t;
        if (player == null || !player.q(16) || !this.f9958t.f() || !this.f9958t.A()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object N(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals("onImageAvailable")) {
            return null;
        }
        R(objArr[1]);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Bitmap bitmap) {
        setImage(new BitmapDrawable(getResources(), bitmap));
        if (!F()) {
            Y();
            A();
        }
    }

    private void P(boolean z2) {
        boolean z3;
        if ((!M() || !this.F) && i0()) {
            if (!this.f9951m.c0() || this.f9951m.getShowTimeoutMs() > 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean V = V();
            if (z2 || z3 || V) {
                X(V);
            }
        }
    }

    private void R(Bitmap bitmap) {
        this.f9954p.post(new i(this, bitmap));
    }

    private boolean S(Player player) {
        byte[] bArr;
        if (player == null || !player.q(18) || (bArr = player.S().f4241k) == null) {
            return false;
        }
        return T(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private boolean T(Drawable drawable) {
        if (!(this.f9947i == null || drawable == null)) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f2 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.f9962x == 2) {
                    f2 = ((float) getWidth()) / ((float) getHeight());
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                Q(this.f9941c, f2);
                this.f9947i.setScaleType(scaleType);
                this.f9947i.setImageDrawable(drawable);
                this.f9947i.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void U(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean V() {
        Player player = this.f9958t;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (!this.E || ((this.f9958t.q(17) && this.f9958t.t().q()) || (playbackState != 1 && playbackState != 4 && ((Player) Assertions.f(this.f9958t)).A()))) {
            return false;
        }
        return true;
    }

    private void X(boolean z2) {
        int i2;
        if (i0()) {
            PlayerControlView playerControlView = this.f9951m;
            if (z2) {
                i2 = 0;
            } else {
                i2 = this.D;
            }
            playerControlView.setShowTimeoutMs(i2);
            this.f9951m.n0();
        }
    }

    private void Y() {
        ImageView imageView = this.f9946h;
        if (imageView != null) {
            imageView.setVisibility(0);
            g0();
        }
    }

    /* access modifiers changed from: private */
    public void Z() {
        if (i0() && this.f9958t != null) {
            if (!this.f9951m.c0()) {
                P(true);
            } else if (this.G) {
                this.f9951m.Y();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a0() {
        VideoSize videoSize;
        float f2;
        Player player = this.f9958t;
        if (player != null) {
            videoSize = player.G();
        } else {
            videoSize = VideoSize.f4483e;
        }
        int i2 = videoSize.f4488a;
        int i3 = videoSize.f4489b;
        int i4 = videoSize.f4490c;
        float f3 = 0.0f;
        if (i3 == 0 || i2 == 0) {
            f2 = 0.0f;
        } else {
            f2 = (((float) i2) * videoSize.f4491d) / ((float) i3);
        }
        View view = this.f9943e;
        if (view instanceof TextureView) {
            if (f2 > 0.0f && (i4 == 90 || i4 == 270)) {
                f2 = 1.0f / f2;
            }
            if (this.H != 0) {
                view.removeOnLayoutChangeListener(this.f9940b);
            }
            this.H = i4;
            if (i4 != 0) {
                this.f9943e.addOnLayoutChangeListener(this.f9940b);
            }
            y((TextureView) this.f9943e, this.H);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f9941c;
        if (!this.f9944f) {
            f3 = f2;
        }
        Q(aspectRatioFrameLayout, f3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4.f9958t.A() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b0() {
        /*
            r4 = this;
            android.view.View r0 = r4.f9949k
            if (r0 == 0) goto L_0x002b
            androidx.media3.common.Player r0 = r4.f9958t
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L_0x0020
            int r0 = r4.A
            r3 = 1
            if (r0 == r2) goto L_0x0021
            if (r0 != r3) goto L_0x0020
            androidx.media3.common.Player r0 = r4.f9958t
            boolean r0 = r0.A()
            if (r0 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            android.view.View r0 = r4.f9949k
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 8
        L_0x0028:
            r0.setVisibility(r1)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.b0():void");
    }

    /* access modifiers changed from: private */
    public void c0() {
        PlayerControlView playerControlView = this.f9951m;
        String str = null;
        if (playerControlView == null || !this.f9959u) {
            setContentDescription((CharSequence) null);
        } else if (playerControlView.c0()) {
            if (this.G) {
                str = getResources().getString(R$string.f10032e);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(R$string.f10039l));
        }
    }

    /* access modifiers changed from: private */
    public void d0() {
        if (!M() || !this.F) {
            P(false);
        } else {
            I();
        }
    }

    /* access modifiers changed from: private */
    public void e0() {
        TextView textView = this.f9950l;
        if (textView != null) {
            CharSequence charSequence = this.C;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f9950l.setVisibility(0);
                return;
            }
            Player player = this.f9958t;
            if (player != null) {
                PlaybackException k2 = player.k();
            }
            this.f9950l.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void f0(boolean z2) {
        boolean z3;
        boolean z4;
        Player player = this.f9958t;
        boolean z5 = true;
        if (player == null || !player.q(30) || player.m().b()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!this.B && (!z3 || z2)) {
            H();
            A();
            G();
        }
        if (z3) {
            boolean F2 = F();
            boolean E2 = E();
            if (!F2 && !E2) {
                A();
                G();
            }
            View view = this.f9942d;
            if (view == null || view.getVisibility() != 4 || !L()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (E2 && !F2 && z4) {
                A();
                Y();
            } else if (F2 && !E2 && z4) {
                G();
            }
            if (F2 || E2 || !h0()) {
                z5 = false;
            }
            if (!z5 || (!S(player) && !T(this.f9964z))) {
                H();
            }
        }
    }

    private void g0() {
        Drawable drawable;
        ImageView imageView = this.f9946h;
        if (imageView != null && (drawable = imageView.getDrawable()) != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f2 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.f9963y == 1) {
                    f2 = ((float) getWidth()) / ((float) getHeight());
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                if (this.f9946h.getVisibility() == 0) {
                    Q(this.f9941c, f2);
                }
                this.f9946h.setScaleType(scaleType);
            }
        }
    }

    private boolean h0() {
        if (this.f9962x == 0) {
            return false;
        }
        Assertions.j(this.f9947i);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean i0() {
        if (!this.f9959u) {
            return false;
        }
        Assertions.j(this.f9951m);
        return true;
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.f9946h;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            g0();
        }
    }

    private void setImageOutput(Player player) {
        Class<?> cls = this.f9955q;
        if (cls != null && cls.isAssignableFrom(player.getClass())) {
            try {
                ((Method) Assertions.f(this.f9956r)).invoke(player, new Object[]{Assertions.f(this.f9957s)});
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void y(TextureView textureView, int i2) {
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

    private void z(Player player) {
        Class<?> cls = this.f9955q;
        if (cls != null && cls.isAssignableFrom(player.getClass())) {
            try {
                ((Method) Assertions.f(this.f9956r)).invoke(player, new Object[]{null});
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public boolean D(KeyEvent keyEvent) {
        return i0() && this.f9951m.U(keyEvent);
    }

    public void I() {
        PlayerControlView playerControlView = this.f9951m;
        if (playerControlView != null) {
            playerControlView.Y();
        }
    }

    /* access modifiers changed from: protected */
    public void Q(AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public void W() {
        X(V());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34;
        super.dispatchDraw(canvas);
        if (Util.f4714a == 34 && (surfaceSyncGroupCompatV34 = this.f9945g) != null) {
            surfaceSyncGroupCompatV34.e();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.f9958t;
        if (player != null && player.q(16) && this.f9958t.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean K = K(keyEvent.getKeyCode());
        if (K && i0() && !this.f9951m.c0()) {
            P(true);
            return true;
        } else if (D(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            P(true);
            return true;
        } else {
            if (K && i0()) {
                P(true);
            }
            return false;
        }
    }

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f9953o;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo.Builder(frameLayout, 4).b("Transparent overlay does not impact viewability").a());
        }
        PlayerControlView playerControlView = this.f9951m;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo.Builder(playerControlView, 1).a());
        }
        return ImmutableList.n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.k(this.f9952n, "exo_ad_overlay must be present for ad playback");
    }

    public int getArtworkDisplayMode() {
        return this.f9962x;
    }

    public boolean getControllerAutoShow() {
        return this.E;
    }

    public boolean getControllerHideOnTouch() {
        return this.G;
    }

    public int getControllerShowTimeoutMs() {
        return this.D;
    }

    public Drawable getDefaultArtwork() {
        return this.f9964z;
    }

    public int getImageDisplayMode() {
        return this.f9963y;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f9953o;
    }

    public Player getPlayer() {
        return this.f9958t;
    }

    public int getResizeMode() {
        Assertions.j(this.f9941c);
        return this.f9941c.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f9948j;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.f9962x != 0;
    }

    public boolean getUseController() {
        return this.f9959u;
    }

    public View getVideoSurfaceView() {
        return this.f9943e;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!i0() || this.f9958t == null) {
            return false;
        }
        P(true);
        return true;
    }

    public boolean performClick() {
        Z();
        return super.performClick();
    }

    public void setArtworkDisplayMode(int i2) {
        boolean z2;
        if (i2 == 0 || this.f9947i != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.f9962x != i2) {
            this.f9962x = i2;
            f0(false);
        }
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.j(this.f9941c);
        this.f9941c.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAnimationEnabled(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setAnimationEnabled(z2);
    }

    public void setControllerAutoShow(boolean z2) {
        this.E = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.F = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        Assertions.j(this.f9951m);
        this.G = z2;
        c0();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(PlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        Assertions.j(this.f9951m);
        this.f9951m.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    public void setControllerShowTimeoutMs(int i2) {
        Assertions.j(this.f9951m);
        this.D = i2;
        if (this.f9951m.c0()) {
            W();
        }
    }

    public void setControllerVisibilityListener(ControllerVisibilityListener controllerVisibilityListener) {
        this.f9960v = controllerVisibilityListener;
        if (controllerVisibilityListener != null) {
            setControllerVisibilityListener((PlayerControlView.VisibilityListener) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        boolean z2;
        if (this.f9950l != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.C = charSequence;
        e0();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f9964z != drawable) {
            this.f9964z = drawable;
            f0(false);
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (errorMessageProvider != null) {
            e0();
        }
    }

    public void setFullscreenButtonClickListener(FullscreenButtonClickListener fullscreenButtonClickListener) {
        Assertions.j(this.f9951m);
        this.f9951m.setOnFullScreenModeChangedListener(this.f9940b);
    }

    public void setImageDisplayMode(int i2) {
        boolean z2;
        if (this.f9946h != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.f9963y != i2) {
            this.f9963y = i2;
            g0();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            f0(false);
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
        Assertions.h(z2);
        if (player == null || player.u() == Looper.getMainLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.f9958t;
        if (player2 != player) {
            if (player2 != null) {
                player2.W(this.f9940b);
                if (player2.q(27)) {
                    View view = this.f9943e;
                    if (view instanceof TextureView) {
                        player2.F((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        player2.N((SurfaceView) view);
                    }
                }
                z(player2);
            }
            SubtitleView subtitleView = this.f9948j;
            if (subtitleView != null) {
                subtitleView.setCues((List<Cue>) null);
            }
            this.f9958t = player;
            if (i0()) {
                this.f9951m.setPlayer(player);
            }
            b0();
            e0();
            f0(true);
            if (player != null) {
                if (player.q(27)) {
                    View view2 = this.f9943e;
                    if (view2 instanceof TextureView) {
                        player.x((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        player.i((SurfaceView) view2);
                    }
                    if (!player.q(30) || player.m().d(2)) {
                        a0();
                    }
                }
                if (this.f9948j != null && player.q(28)) {
                    this.f9948j.setCues(player.o().f4595a);
                }
                player.Y(this.f9940b);
                setImageOutput(player);
                P(false);
                return;
            }
            I();
        }
    }

    public void setRepeatToggleModes(int i2) {
        Assertions.j(this.f9951m);
        this.f9951m.setRepeatToggleModes(i2);
    }

    public void setResizeMode(int i2) {
        Assertions.j(this.f9941c);
        this.f9941c.setResizeMode(i2);
    }

    public void setShowBuffering(int i2) {
        if (this.A != i2) {
            this.A = i2;
            b0();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowFastForwardButton(z2);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowNextButton(z2);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowPlayButtonIfPlaybackIsSuppressed(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowShuffleButton(z2);
    }

    public void setShowSubtitleButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowSubtitleButton(z2);
    }

    public void setShowVrButton(boolean z2) {
        Assertions.j(this.f9951m);
        this.f9951m.setShowVrButton(z2);
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.f9942d;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z2) {
        setArtworkDisplayMode(z2 ^ true ? 1 : 0);
    }

    public void setUseController(boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (!z2 || this.f9951m != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.h(z3);
        if (z2 || hasOnClickListeners()) {
            z4 = true;
        }
        setClickable(z4);
        if (this.f9959u != z2) {
            this.f9959u = z2;
            if (i0()) {
                this.f9951m.setPlayer(this.f9958t);
            } else {
                PlayerControlView playerControlView = this.f9951m;
                if (playerControlView != null) {
                    playerControlView.Y();
                    this.f9951m.setPlayer((Player) null);
                }
            }
            c0();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f9943e;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z7;
        int i11;
        boolean z8;
        AnonymousClass1 r3;
        Method method;
        Object obj;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        ComponentListener componentListener = new ComponentListener();
        this.f9940b = componentListener;
        this.f9954p = new Handler(Looper.getMainLooper());
        if (isInEditMode()) {
            this.f9941c = null;
            this.f9942d = null;
            this.f9943e = null;
            this.f9944f = false;
            this.f9945g = null;
            this.f9946h = null;
            this.f9947i = null;
            this.f9948j = null;
            this.f9949k = null;
            this.f9950l = null;
            this.f9951m = null;
            this.f9952n = null;
            this.f9953o = null;
            this.f9955q = null;
            this.f9956r = null;
            this.f9957s = null;
            ImageView imageView = new ImageView(context2);
            if (Util.f4714a >= 23) {
                C(context2, getResources(), imageView);
            } else {
                B(context2, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i12 = R$layout.f10022d;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f10076k0, i2, 0);
            try {
                int i13 = R$styleable.f10100w0;
                boolean hasValue = obtainStyledAttributes.hasValue(i13);
                int color = obtainStyledAttributes.getColor(i13, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f10092s0, i12);
                boolean z9 = obtainStyledAttributes.getBoolean(R$styleable.f10104y0, true);
                int i14 = obtainStyledAttributes.getInt(R$styleable.f10078l0, 1);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.f10082n0, 0);
                int i15 = obtainStyledAttributes.getInt(R$styleable.f10088q0, 0);
                boolean z10 = obtainStyledAttributes.getBoolean(R$styleable.f10106z0, true);
                int i16 = obtainStyledAttributes.getInt(R$styleable.f10102x0, 1);
                int i17 = obtainStyledAttributes.getInt(R$styleable.f10094t0, 0);
                int i18 = resourceId;
                i3 = obtainStyledAttributes.getInt(R$styleable.f10098v0, 5000);
                boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.f10086p0, true);
                z3 = obtainStyledAttributes.getBoolean(R$styleable.f10080m0, true);
                int integer = obtainStyledAttributes.getInteger(R$styleable.f10096u0, 0);
                this.B = obtainStyledAttributes.getBoolean(R$styleable.f10090r0, this.B);
                boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.f10084o0, true);
                obtainStyledAttributes.recycle();
                i8 = resourceId2;
                z7 = z11;
                z4 = z12;
                z5 = z9;
                i11 = i18;
                z2 = z10;
                i5 = color;
                i7 = i17;
                i10 = i15;
                i4 = i14;
                z6 = hasValue;
                i6 = i16;
                i9 = integer;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i11 = i12;
            z2 = true;
            z7 = true;
            i10 = 0;
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 1;
            i5 = 0;
            z6 = false;
            z5 = true;
            i4 = 1;
            i3 = 5000;
            z4 = true;
            z3 = true;
        }
        LayoutInflater.from(context).inflate(i11, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.f10001i);
        this.f9941c = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            U(aspectRatioFrameLayout, i7);
        }
        View findViewById = findViewById(R$id.P);
        this.f9942d = findViewById;
        if (findViewById != null && z6) {
            findViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i6 == 0) {
            r3 = null;
            this.f9943e = null;
            z8 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i6 != 2) {
                Class<Context> cls = Context.class;
                if (i6 == 3) {
                    Class<SphericalGLSurfaceView> cls2 = SphericalGLSurfaceView.class;
                    try {
                        int i19 = SphericalGLSurfaceView.f7848n;
                        this.f9943e = cls2.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                        z8 = true;
                        this.f9943e.setLayoutParams(layoutParams);
                        this.f9943e.setOnClickListener(componentListener);
                        this.f9943e.setClickable(false);
                        aspectRatioFrameLayout.addView(this.f9943e, 0);
                        r3 = null;
                    } catch (Exception e2) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                } else if (i6 != 4) {
                    SurfaceView surfaceView = new SurfaceView(context2);
                    if (Util.f4714a >= 34) {
                        Api34.a(surfaceView);
                    }
                    this.f9943e = surfaceView;
                } else {
                    Class<VideoDecoderGLSurfaceView> cls3 = VideoDecoderGLSurfaceView.class;
                    try {
                        int i20 = VideoDecoderGLSurfaceView.f7691c;
                        this.f9943e = cls3.getConstructor(new Class[]{cls}).newInstance(new Object[]{context2});
                    } catch (Exception e3) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                    }
                }
            } else {
                this.f9943e = new TextureView(context2);
            }
            z8 = false;
            this.f9943e.setLayoutParams(layoutParams);
            this.f9943e.setOnClickListener(componentListener);
            this.f9943e.setClickable(false);
            aspectRatioFrameLayout.addView(this.f9943e, 0);
            r3 = null;
        }
        this.f9944f = z8;
        this.f9945g = Util.f4714a == 34 ? new SurfaceSyncGroupCompatV34() : null;
        this.f9952n = (FrameLayout) findViewById(R$id.f9993a);
        this.f9953o = (FrameLayout) findViewById(R$id.B);
        this.f9946h = (ImageView) findViewById(R$id.exo_image);
        this.f9963y = i10;
        Class<ExoPlayer> cls4 = ExoPlayer.class;
        Class<ImageOutput> cls5 = ImageOutput.class;
        try {
            ImageOutput imageOutput = ImageOutput.f6606a;
            method = cls4.getMethod("setImageOutput", new Class[]{cls5});
            obj = Proxy.newProxyInstance(cls5.getClassLoader(), new Class[]{cls5}, new h(this));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls4 = null;
            obj = null;
            method = null;
        }
        this.f9955q = cls4;
        this.f9956r = method;
        this.f9957s = obj;
        ImageView imageView2 = (ImageView) findViewById(R$id.f9994b);
        this.f9947i = imageView2;
        this.f9962x = !(z5 && i4 != 0 && imageView2 != null) ? 0 : i4;
        if (i8 != 0) {
            this.f9964z = ContextCompat.getDrawable(getContext(), i8);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.S);
        this.f9948j = subtitleView;
        if (subtitleView != null) {
            subtitleView.e();
            subtitleView.f();
        }
        View findViewById2 = findViewById(R$id.f9998f);
        this.f9949k = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.A = i9;
        TextView textView = (TextView) findViewById(R$id.f10006n);
        this.f9950l = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i21 = R$id.f10002j;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i21);
        View findViewById3 = findViewById(R$id.f10003k);
        if (playerControlView != null) {
            this.f9951m = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.f9951m = playerControlView2;
            playerControlView2.setId(i21);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            this.f9951m = null;
        }
        PlayerControlView playerControlView3 = this.f9951m;
        this.D = playerControlView3 != null ? i3 : 0;
        this.G = z7;
        this.E = z3;
        this.F = z4;
        this.f9959u = z2 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.Z();
            this.f9951m.S(this.f9940b);
        }
        if (z2) {
            setClickable(true);
        }
        c0();
    }

    @Deprecated
    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.j(this.f9951m);
        PlayerControlView.VisibilityListener visibilityListener2 = this.f9961w;
        if (visibilityListener2 != visibilityListener) {
            if (visibilityListener2 != null) {
                this.f9951m.j0(visibilityListener2);
            }
            this.f9961w = visibilityListener;
            if (visibilityListener != null) {
                this.f9951m.S(visibilityListener);
                setControllerVisibilityListener((ControllerVisibilityListener) null);
            }
        }
    }
}
