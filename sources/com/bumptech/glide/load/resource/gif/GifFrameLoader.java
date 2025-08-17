package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {

    /* renamed from: a  reason: collision with root package name */
    private final GifDecoder f16929a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f16930b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FrameCallback> f16931c;

    /* renamed from: d  reason: collision with root package name */
    final RequestManager f16932d;

    /* renamed from: e  reason: collision with root package name */
    private final BitmapPool f16933e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16934f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16935g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16936h;

    /* renamed from: i  reason: collision with root package name */
    private RequestBuilder<Bitmap> f16937i;

    /* renamed from: j  reason: collision with root package name */
    private DelayTarget f16938j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16939k;

    /* renamed from: l  reason: collision with root package name */
    private DelayTarget f16940l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f16941m;

    /* renamed from: n  reason: collision with root package name */
    private Transformation<Bitmap> f16942n;

    /* renamed from: o  reason: collision with root package name */
    private DelayTarget f16943o;

    /* renamed from: p  reason: collision with root package name */
    private int f16944p;

    /* renamed from: q  reason: collision with root package name */
    private int f16945q;

    /* renamed from: r  reason: collision with root package name */
    private int f16946r;

    static class DelayTarget extends CustomTarget<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        private final Handler f16947e;

        /* renamed from: f  reason: collision with root package name */
        final int f16948f;

        /* renamed from: g  reason: collision with root package name */
        private final long f16949g;

        /* renamed from: h  reason: collision with root package name */
        private Bitmap f16950h;

        DelayTarget(Handler handler, int i2, long j2) {
            this.f16947e = handler;
            this.f16948f = i2;
            this.f16949g = j2;
        }

        /* access modifiers changed from: package-private */
        public Bitmap a() {
            return this.f16950h;
        }

        /* renamed from: b */
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.f16950h = bitmap;
            this.f16947e.sendMessageAtTime(this.f16947e.obtainMessage(1, this), this.f16949g);
        }

        public void onLoadCleared(Drawable drawable) {
            this.f16950h = null;
        }
    }

    public interface FrameCallback {
        void a();
    }

    private class FrameLoaderCallback implements Handler.Callback {
        FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                GifFrameLoader.this.m((DelayTarget) message.obj);
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                GifFrameLoader.this.f16932d.d((DelayTarget) message.obj);
                return false;
            }
        }
    }

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.f(), Glide.t(glide.h()), gifDecoder, (Handler) null, i(Glide.t(glide.h()), i2, i3), transformation, bitmap);
    }

    private static Key g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private static RequestBuilder<Bitmap> i(RequestManager requestManager, int i2, int i3) {
        return requestManager.b().a(((RequestOptions) ((RequestOptions) RequestOptions.g0(DiskCacheStrategy.f16455b).e0(true)).Z(true)).Q(i2, i3));
    }

    private void l() {
        boolean z2;
        if (this.f16934f && !this.f16935g) {
            if (this.f16936h) {
                if (this.f16943o == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.a(z2, "Pending target must be null when starting from the first frame");
                this.f16929a.f();
                this.f16936h = false;
            }
            DelayTarget delayTarget = this.f16943o;
            if (delayTarget != null) {
                this.f16943o = null;
                m(delayTarget);
                return;
            }
            this.f16935g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f16929a.e());
            this.f16929a.b();
            this.f16940l = new DelayTarget(this.f16930b, this.f16929a.g(), uptimeMillis);
            this.f16937i.a(RequestOptions.h0(g())).t0(this.f16929a).n0(this.f16940l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f16941m;
        if (bitmap != null) {
            this.f16933e.c(bitmap);
            this.f16941m = null;
        }
    }

    private void p() {
        if (!this.f16934f) {
            this.f16934f = true;
            this.f16939k = false;
            l();
        }
    }

    private void q() {
        this.f16934f = false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f16931c.clear();
        n();
        q();
        DelayTarget delayTarget = this.f16938j;
        if (delayTarget != null) {
            this.f16932d.d(delayTarget);
            this.f16938j = null;
        }
        DelayTarget delayTarget2 = this.f16940l;
        if (delayTarget2 != null) {
            this.f16932d.d(delayTarget2);
            this.f16940l = null;
        }
        DelayTarget delayTarget3 = this.f16943o;
        if (delayTarget3 != null) {
            this.f16932d.d(delayTarget3);
            this.f16943o = null;
        }
        this.f16929a.clear();
        this.f16939k = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f16929a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        DelayTarget delayTarget = this.f16938j;
        return delayTarget != null ? delayTarget.a() : this.f16941m;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        DelayTarget delayTarget = this.f16938j;
        if (delayTarget != null) {
            return delayTarget.f16948f;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f16941m;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f16929a.c();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f16946r;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f16929a.h() + this.f16944p;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f16945q;
    }

    /* access modifiers changed from: package-private */
    public void m(DelayTarget delayTarget) {
        this.f16935g = false;
        if (this.f16939k) {
            this.f16930b.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.f16934f) {
            this.f16943o = delayTarget;
        } else {
            if (delayTarget.a() != null) {
                n();
                DelayTarget delayTarget2 = this.f16938j;
                this.f16938j = delayTarget;
                for (int size = this.f16931c.size() - 1; size >= 0; size--) {
                    this.f16931c.get(size).a();
                }
                if (delayTarget2 != null) {
                    this.f16930b.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            l();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.d(r3)
            com.bumptech.glide.load.Transformation r0 = (com.bumptech.glide.load.Transformation) r0
            r2.f16942n = r0
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.d(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f16941m = r0
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> r0 = r2.f16937i
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            com.bumptech.glide.request.BaseRequestOptions r3 = r1.a0(r3)
            com.bumptech.glide.RequestBuilder r3 = r0.a(r3)
            r2.f16937i = r3
            int r3 = com.bumptech.glide.util.Util.g(r4)
            r2.f16944p = r3
            int r3 = r4.getWidth()
            r2.f16945q = r3
            int r3 = r4.getHeight()
            r2.f16946r = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifFrameLoader.o(com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public void r(FrameCallback frameCallback) {
        if (this.f16939k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f16931c.contains(frameCallback)) {
            boolean isEmpty = this.f16931c.isEmpty();
            this.f16931c.add(frameCallback);
            if (isEmpty) {
                p();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void s(FrameCallback frameCallback) {
        this.f16931c.remove(frameCallback);
        if (this.f16931c.isEmpty()) {
            q();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f16931c = new ArrayList();
        this.f16932d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.f16933e = bitmapPool;
        this.f16930b = handler;
        this.f16937i = requestBuilder;
        this.f16929a = gifDecoder;
        o(transformation, bitmap);
    }
}
