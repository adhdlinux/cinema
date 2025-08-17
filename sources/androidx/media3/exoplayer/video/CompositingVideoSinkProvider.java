package androidx.media3.exoplayer.video;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoFrameRenderControl;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class CompositingVideoSinkProvider implements VideoSinkProvider, VideoGraph.Listener {
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final Executor f7587p = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Context f7588a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoSinkImpl f7589b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final VideoFrameReleaseControl f7590c;

    /* renamed from: d  reason: collision with root package name */
    private final VideoFrameRenderControl f7591d;

    /* renamed from: e  reason: collision with root package name */
    private final PreviewingVideoGraph.Factory f7592e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Clock f7593f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final CopyOnWriteArraySet<Listener> f7594g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Format f7595h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public VideoFrameMetadataListener f7596i;

    /* renamed from: j  reason: collision with root package name */
    private HandlerWrapper f7597j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public PreviewingVideoGraph f7598k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Pair<Surface, Size> f7599l;

    /* renamed from: m  reason: collision with root package name */
    private int f7600m;

    /* renamed from: n  reason: collision with root package name */
    private int f7601n;

    /* renamed from: o  reason: collision with root package name */
    private long f7602o;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f7603a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final VideoFrameReleaseControl f7604b;

        /* renamed from: c  reason: collision with root package name */
        private VideoFrameProcessor.Factory f7605c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public PreviewingVideoGraph.Factory f7606d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Clock f7607e = Clock.f4616a;

        /* renamed from: f  reason: collision with root package name */
        private boolean f7608f;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.f7603a = context.getApplicationContext();
            this.f7604b = videoFrameReleaseControl;
        }

        public CompositingVideoSinkProvider e() {
            Assertions.h(!this.f7608f);
            if (this.f7606d == null) {
                if (this.f7605c == null) {
                    this.f7605c = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.f7606d = new ReflectivePreviewingSingleInputVideoGraphFactory(this.f7605c);
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = new CompositingVideoSinkProvider(this);
            this.f7608f = true;
            return compositingVideoSinkProvider;
        }

        public Builder f(Clock clock) {
            this.f7607e = clock;
            return this;
        }
    }

    private final class FrameRendererImpl implements VideoFrameRenderControl.FrameRenderer {
        private FrameRendererImpl() {
        }

        public void a() {
            Iterator it2 = CompositingVideoSinkProvider.this.f7594g.iterator();
            while (it2.hasNext()) {
                ((Listener) it2.next()).q(CompositingVideoSinkProvider.this);
            }
            ((PreviewingVideoGraph) Assertions.j(CompositingVideoSinkProvider.this.f7598k)).b(-2);
        }

        public void b(long j2, long j3, long j4, boolean z2) {
            Format format;
            if (z2 && CompositingVideoSinkProvider.this.f7599l != null) {
                Iterator it2 = CompositingVideoSinkProvider.this.f7594g.iterator();
                while (it2.hasNext()) {
                    ((Listener) it2.next()).t(CompositingVideoSinkProvider.this);
                }
            }
            if (CompositingVideoSinkProvider.this.f7596i != null) {
                if (CompositingVideoSinkProvider.this.f7595h == null) {
                    format = new Format.Builder().K();
                } else {
                    format = CompositingVideoSinkProvider.this.f7595h;
                }
                long j5 = j3;
                CompositingVideoSinkProvider.this.f7596i.e(j5, CompositingVideoSinkProvider.this.f7593f.nanoTime(), format, (MediaFormat) null);
            }
            ((PreviewingVideoGraph) Assertions.j(CompositingVideoSinkProvider.this.f7598k)).b(j2);
        }

        public void n(VideoSize videoSize) {
            Format unused = CompositingVideoSinkProvider.this.f7595h = new Format.Builder().v0(videoSize.f4488a).Y(videoSize.f4489b).o0("video/raw").K();
            Iterator it2 = CompositingVideoSinkProvider.this.f7594g.iterator();
            while (it2.hasNext()) {
                ((Listener) it2.next()).c(CompositingVideoSinkProvider.this, videoSize);
            }
        }
    }

    public interface Listener {
        void c(CompositingVideoSinkProvider compositingVideoSinkProvider, VideoSize videoSize);

        void q(CompositingVideoSinkProvider compositingVideoSinkProvider);

        void t(CompositingVideoSinkProvider compositingVideoSinkProvider);
    }

    private static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {

        /* renamed from: a  reason: collision with root package name */
        private static final Supplier<VideoFrameProcessor.Factory> f7610a = Suppliers.a(new d());

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ VideoFrameProcessor.Factory b() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (VideoFrameProcessor.Factory) Assertions.f(cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]));
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final VideoFrameProcessor.Factory f7611a;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.f7611a = factory;
        }

        public PreviewingVideoGraph a(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j2) throws VideoFrameProcessingException {
            try {
                Constructor<?> constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(new Class[]{VideoFrameProcessor.Factory.class});
                Object[] objArr = new Object[1];
                try {
                    objArr[0] = this.f7611a;
                    return ((PreviewingVideoGraph.Factory) constructor.newInstance(objArr)).a(context, colorInfo, debugViewProvider, listener, executor, list, j2);
                } catch (Exception e2) {
                    e = e2;
                    throw VideoFrameProcessingException.a(e);
                }
            } catch (Exception e3) {
                e = e3;
                throw VideoFrameProcessingException.a(e);
            }
        }
    }

    private static final class ScaleAndRotateAccessor {

        /* renamed from: a  reason: collision with root package name */
        private static Constructor<?> f7612a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f7613b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f7614c;

        private ScaleAndRotateAccessor() {
        }

        public static Effect a(float f2) {
            try {
                b();
                Object newInstance = f7612a.newInstance(new Object[0]);
                f7613b.invoke(newInstance, new Object[]{Float.valueOf(f2)});
                return (Effect) Assertions.f(f7614c.invoke(newInstance, new Object[0]));
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }

        @EnsuresNonNull({"scaleAndRotateTransformationBuilderConstructor", "setRotationMethod", "buildScaleAndRotateTransformationMethod"})
        private static void b() throws NoSuchMethodException, ClassNotFoundException {
            if (f7612a == null || f7613b == null || f7614c == null) {
                Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                f7612a = cls.getConstructor(new Class[0]);
                f7613b = cls.getMethod("setRotationDegrees", new Class[]{Float.TYPE});
                f7614c = cls.getMethod("build", new Class[0]);
            }
        }
    }

    private final class VideoSinkImpl implements VideoSink, Listener {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7615a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7616b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<Effect> f7617c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private Effect f7618d;

        /* renamed from: e  reason: collision with root package name */
        private VideoFrameProcessor f7619e;

        /* renamed from: f  reason: collision with root package name */
        private Format f7620f;

        /* renamed from: g  reason: collision with root package name */
        private int f7621g;

        /* renamed from: h  reason: collision with root package name */
        private long f7622h;

        /* renamed from: i  reason: collision with root package name */
        private long f7623i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f7624j;

        /* renamed from: k  reason: collision with root package name */
        private long f7625k = -9223372036854775807L;

        /* renamed from: l  reason: collision with root package name */
        private long f7626l = -9223372036854775807L;

        /* renamed from: m  reason: collision with root package name */
        private boolean f7627m;

        /* renamed from: n  reason: collision with root package name */
        private long f7628n;

        /* renamed from: o  reason: collision with root package name */
        private VideoSink.Listener f7629o = VideoSink.Listener.f7759a;

        /* renamed from: p  reason: collision with root package name */
        private Executor f7630p = CompositingVideoSinkProvider.f7587p;

        public VideoSinkImpl(Context context) {
            this.f7615a = context;
            this.f7616b = Util.d0(context);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(VideoSink.Listener listener) {
            listener.c((VideoSink) Assertions.j(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void B(VideoSink.Listener listener, VideoSize videoSize) {
            listener.b(this, videoSize);
        }

        private void C() {
            if (this.f7620f != null) {
                ArrayList arrayList = new ArrayList();
                Effect effect = this.f7618d;
                if (effect != null) {
                    arrayList.add(effect);
                }
                arrayList.addAll(this.f7617c);
                Format format = (Format) Assertions.f(this.f7620f);
                ((VideoFrameProcessor) Assertions.j(this.f7619e)).c(this.f7621g, arrayList, new FrameInfo.Builder(CompositingVideoSinkProvider.z(format.A), format.f4021t, format.f4022u).b(format.f4025x).a());
                this.f7625k = -9223372036854775807L;
            }
        }

        private void D(long j2) {
            if (this.f7624j) {
                CompositingVideoSinkProvider.this.G(this.f7623i, j2, this.f7622h);
                this.f7624j = false;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(VideoSink.Listener listener) {
            listener.a(this);
        }

        public void E(List<Effect> list) {
            this.f7617c.clear();
            this.f7617c.addAll(list);
        }

        public boolean a() {
            if (isInitialized()) {
                long j2 = this.f7625k;
                if (j2 == -9223372036854775807L || !CompositingVideoSinkProvider.this.A(j2)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public Surface b() {
            Assertions.h(isInitialized());
            return ((VideoFrameProcessor) Assertions.j(this.f7619e)).b();
        }

        public void c(CompositingVideoSinkProvider compositingVideoSinkProvider, VideoSize videoSize) {
            this.f7630p.execute(new f(this, this.f7629o, videoSize));
        }

        public void d(VideoFrameMetadataListener videoFrameMetadataListener) {
            CompositingVideoSinkProvider.this.L(videoFrameMetadataListener);
        }

        public long e(long j2, boolean z2) {
            boolean z3;
            Assertions.h(isInitialized());
            if (this.f7616b != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.h(z3);
            long j3 = this.f7628n;
            if (j3 != -9223372036854775807L) {
                if (!CompositingVideoSinkProvider.this.A(j3)) {
                    return -9223372036854775807L;
                }
                C();
                this.f7628n = -9223372036854775807L;
            }
            if (((VideoFrameProcessor) Assertions.j(this.f7619e)).e() >= this.f7616b || !((VideoFrameProcessor) Assertions.j(this.f7619e)).d()) {
                return -9223372036854775807L;
            }
            long j4 = j2 - this.f7623i;
            D(j4);
            this.f7626l = j4;
            if (z2) {
                this.f7625k = j4;
            }
            return j2 * 1000;
        }

        public void f(long j2, long j3) throws VideoSink.VideoSinkException {
            try {
                CompositingVideoSinkProvider.this.I(j2, j3);
            } catch (ExoPlaybackException e2) {
                Format format = this.f7620f;
                if (format == null) {
                    format = new Format.Builder().K();
                }
                throw new VideoSink.VideoSinkException(e2, format);
            }
        }

        public void g() {
            CompositingVideoSinkProvider.this.f7590c.l();
        }

        public void h() {
            CompositingVideoSinkProvider.this.f7590c.a();
        }

        public void i(List<Effect> list) {
            if (!this.f7617c.equals(list)) {
                E(list);
                C();
            }
        }

        @EnsuresNonNullIf(expression = {"videoFrameProcessor"}, result = true)
        public boolean isInitialized() {
            return this.f7619e != null;
        }

        public boolean isReady() {
            return isInitialized() && CompositingVideoSinkProvider.this.D();
        }

        public void j(int i2, Format format) {
            int i3;
            Format format2;
            Assertions.h(isInitialized());
            boolean z2 = true;
            if (i2 == 1 || i2 == 2) {
                CompositingVideoSinkProvider.this.f7590c.p(format.f4023v);
                if (i2 != 1 || Util.f4714a >= 21 || (i3 = format.f4024w) == -1 || i3 == 0) {
                    this.f7618d = null;
                } else if (this.f7618d == null || (format2 = this.f7620f) == null || format2.f4024w != i3) {
                    this.f7618d = ScaleAndRotateAccessor.a((float) i3);
                }
                this.f7621g = i2;
                this.f7620f = format;
                if (!this.f7627m) {
                    C();
                    this.f7627m = true;
                    this.f7628n = -9223372036854775807L;
                    return;
                }
                if (this.f7626l == -9223372036854775807L) {
                    z2 = false;
                }
                Assertions.h(z2);
                this.f7628n = this.f7626l;
                return;
            }
            throw new UnsupportedOperationException("Unsupported input type " + i2);
        }

        public void k(long j2, long j3) {
            boolean z2;
            boolean z3 = this.f7624j;
            if (this.f7622h == j2 && this.f7623i == j3) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f7624j = z3 | z2;
            this.f7622h = j2;
            this.f7623i = j3;
        }

        public boolean l() {
            return Util.G0(this.f7615a);
        }

        public void m(Format format) throws VideoSink.VideoSinkException {
            Assertions.h(!isInitialized());
            this.f7619e = CompositingVideoSinkProvider.this.B(format);
        }

        public void n(boolean z2) {
            CompositingVideoSinkProvider.this.f7590c.h(z2);
        }

        public void o() {
            CompositingVideoSinkProvider.this.f7590c.k();
        }

        public void p(Surface surface, Size size) {
            CompositingVideoSinkProvider.this.J(surface, size);
        }

        public void q(CompositingVideoSinkProvider compositingVideoSinkProvider) {
            this.f7630p.execute(new e(this, this.f7629o));
        }

        public void r() {
            CompositingVideoSinkProvider.this.f7590c.g();
        }

        public void release() {
            CompositingVideoSinkProvider.this.H();
        }

        public void s() {
            CompositingVideoSinkProvider.this.w();
        }

        public void setPlaybackSpeed(float f2) {
            CompositingVideoSinkProvider.this.K(f2);
        }

        public void t(CompositingVideoSinkProvider compositingVideoSinkProvider) {
            this.f7630p.execute(new g(this, this.f7629o));
        }

        public void u(boolean z2) {
            if (isInitialized()) {
                this.f7619e.flush();
            }
            this.f7627m = false;
            this.f7625k = -9223372036854775807L;
            this.f7626l = -9223372036854775807L;
            CompositingVideoSinkProvider.this.x();
            if (z2) {
                CompositingVideoSinkProvider.this.f7590c.m();
            }
        }

        public void v(VideoSink.Listener listener, Executor executor) {
            this.f7629o = listener;
            this.f7630p = executor;
        }
    }

    /* access modifiers changed from: private */
    public boolean A(long j2) {
        return this.f7600m == 0 && this.f7591d.d(j2);
    }

    /* access modifiers changed from: private */
    public VideoFrameProcessor B(Format format) throws VideoSink.VideoSinkException {
        boolean z2;
        if (this.f7601n == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        ColorInfo z3 = z(format.A);
        if (z3.f3945c == 7 && Util.f4714a < 34) {
            z3 = z3.a().e(6).a();
        }
        ColorInfo colorInfo = z3;
        HandlerWrapper b2 = this.f7593f.b((Looper) Assertions.j(Looper.myLooper()), (Handler.Callback) null);
        this.f7597j = b2;
        try {
            PreviewingVideoGraph.Factory factory = this.f7592e;
            Context context = this.f7588a;
            DebugViewProvider debugViewProvider = DebugViewProvider.f3956a;
            Objects.requireNonNull(b2);
            this.f7598k = factory.a(context, colorInfo, debugViewProvider, this, new a(b2), ImmutableList.r(), 0);
            Pair<Surface, Size> pair = this.f7599l;
            if (pair != null) {
                Size size = (Size) pair.second;
                F((Surface) pair.first, size.b(), size.a());
            }
            this.f7598k.c(0);
            this.f7601n = 1;
            return this.f7598k.a(0);
        } catch (VideoFrameProcessingException e2) {
            throw new VideoSink.VideoSinkException(e2, format);
        }
    }

    private boolean C() {
        return this.f7601n == 1;
    }

    /* access modifiers changed from: private */
    public boolean D() {
        return this.f7600m == 0 && this.f7591d.e();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void E(Runnable runnable) {
    }

    private void F(Surface surface, int i2, int i3) {
        SurfaceInfo surfaceInfo;
        if (this.f7598k != null) {
            if (surface != null) {
                surfaceInfo = new SurfaceInfo(surface, i2, i3);
            } else {
                surfaceInfo = null;
            }
            this.f7598k.d(surfaceInfo);
            this.f7590c.q(surface);
        }
    }

    /* access modifiers changed from: private */
    public void G(long j2, long j3, long j4) {
        this.f7602o = j2;
        this.f7591d.h(j3, j4);
    }

    /* access modifiers changed from: private */
    public void K(float f2) {
        this.f7591d.k(f2);
    }

    /* access modifiers changed from: private */
    public void L(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.f7596i = videoFrameMetadataListener;
    }

    /* access modifiers changed from: private */
    public void x() {
        if (C()) {
            this.f7600m++;
            this.f7591d.b();
            ((HandlerWrapper) Assertions.j(this.f7597j)).g(new b(this));
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        int i2 = this.f7600m - 1;
        this.f7600m = i2;
        if (i2 <= 0) {
            if (i2 >= 0) {
                this.f7591d.b();
                return;
            }
            throw new IllegalStateException(String.valueOf(this.f7600m));
        }
    }

    /* access modifiers changed from: private */
    public static ColorInfo z(ColorInfo colorInfo) {
        if (colorInfo == null || !colorInfo.g()) {
            return ColorInfo.f3935h;
        }
        return colorInfo;
    }

    public void H() {
        if (this.f7601n != 2) {
            HandlerWrapper handlerWrapper = this.f7597j;
            if (handlerWrapper != null) {
                handlerWrapper.d((Object) null);
            }
            PreviewingVideoGraph previewingVideoGraph = this.f7598k;
            if (previewingVideoGraph != null) {
                previewingVideoGraph.release();
            }
            this.f7599l = null;
            this.f7601n = 2;
        }
    }

    public void I(long j2, long j3) throws ExoPlaybackException {
        if (this.f7600m == 0) {
            this.f7591d.i(j2, j3);
        }
    }

    public void J(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.f7599l;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((Size) this.f7599l.second).equals(size)) {
            this.f7599l = Pair.create(surface, size);
            F(surface, size.b(), size.a());
        }
    }

    public VideoFrameReleaseControl a() {
        return this.f7590c;
    }

    public VideoSink b() {
        return this.f7589b;
    }

    public void v(Listener listener) {
        this.f7594g.add(listener);
    }

    public void w() {
        Size size = Size.f4698c;
        F((Surface) null, size.b(), size.a());
        this.f7599l = null;
    }

    private CompositingVideoSinkProvider(Builder builder) {
        Context a2 = builder.f7603a;
        this.f7588a = a2;
        VideoSinkImpl videoSinkImpl = new VideoSinkImpl(a2);
        this.f7589b = videoSinkImpl;
        Clock b2 = builder.f7607e;
        this.f7593f = b2;
        VideoFrameReleaseControl c2 = builder.f7604b;
        this.f7590c = c2;
        c2.o(b2);
        this.f7591d = new VideoFrameRenderControl(new FrameRendererImpl(), c2);
        this.f7592e = (PreviewingVideoGraph.Factory) Assertions.j(builder.f7606d);
        this.f7594g = new CopyOnWriteArraySet<>();
        this.f7601n = 0;
        v(videoSinkImpl);
    }
}
