package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.util.Map;
import okhttp3.internal.http2.Http2;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    private int f17023b;

    /* renamed from: c  reason: collision with root package name */
    private float f17024c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private DiskCacheStrategy f17025d = DiskCacheStrategy.f16458e;

    /* renamed from: e  reason: collision with root package name */
    private Priority f17026e = Priority.NORMAL;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f17027f;

    /* renamed from: g  reason: collision with root package name */
    private int f17028g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f17029h;

    /* renamed from: i  reason: collision with root package name */
    private int f17030i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17031j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f17032k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f17033l = -1;

    /* renamed from: m  reason: collision with root package name */
    private Key f17034m = EmptySignature.c();

    /* renamed from: n  reason: collision with root package name */
    private boolean f17035n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17036o = true;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f17037p;

    /* renamed from: q  reason: collision with root package name */
    private int f17038q;

    /* renamed from: r  reason: collision with root package name */
    private Options f17039r = new Options();

    /* renamed from: s  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f17040s = new CachedHashCodeArrayMap();

    /* renamed from: t  reason: collision with root package name */
    private Class<?> f17041t = Object.class;

    /* renamed from: u  reason: collision with root package name */
    private boolean f17042u;

    /* renamed from: v  reason: collision with root package name */
    private Resources.Theme f17043v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f17044w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f17045x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f17046y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f17047z = true;

    private boolean E(int i2) {
        return F(this.f17023b, i2);
    }

    private static boolean F(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T O(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.T(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.O(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T T(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.c0(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.P(r1, r2)
        L_0x000b:
            r2 = 1
            r1.f17047z = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.T(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    private T U() {
        return this;
    }

    private T V() {
        if (!this.f17042u) {
            return U();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final boolean A() {
        return this.f17045x;
    }

    public final boolean B() {
        return this.f17031j;
    }

    public final boolean C() {
        return E(8);
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.f17047z;
    }

    public final boolean G() {
        return this.f17036o;
    }

    public final boolean H() {
        return this.f17035n;
    }

    public final boolean I() {
        return E(2048);
    }

    public final boolean J() {
        return Util.r(this.f17033l, this.f17032k);
    }

    public T K() {
        this.f17042u = true;
        return U();
    }

    public T L() {
        return P(DownsampleStrategy.f16830e, new CenterCrop());
    }

    public T M() {
        return O(DownsampleStrategy.f16829d, new CenterInside());
    }

    public T N() {
        return O(DownsampleStrategy.f16828c, new FitCenter());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T P(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f17044w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.P(r2, r3)
            return r2
        L_0x000d:
            r1.g(r2)
            r2 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.b0(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.P(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T Q(int i2, int i3) {
        if (this.f17044w) {
            return clone().Q(i2, i3);
        }
        this.f17033l = i2;
        this.f17032k = i3;
        this.f17023b |= 512;
        return V();
    }

    public T R(int i2) {
        if (this.f17044w) {
            return clone().R(i2);
        }
        this.f17030i = i2;
        this.f17029h = null;
        this.f17023b = (this.f17023b | 128) & -65;
        return V();
    }

    public T S(Priority priority) {
        if (this.f17044w) {
            return clone().S(priority);
        }
        this.f17026e = (Priority) Preconditions.d(priority);
        this.f17023b |= 8;
        return V();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Option, java.lang.Object, com.bumptech.glide.load.Option<Y>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T W(com.bumptech.glide.load.Option<Y> r2, Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.f17044w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.W(r2, r3)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.d(r2)
            com.bumptech.glide.util.Preconditions.d(r3)
            com.bumptech.glide.load.Options r0 = r1.f17039r
            r0.e(r2, r3)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.V()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.W(com.bumptech.glide.load.Option, java.lang.Object):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T X(Key key) {
        if (this.f17044w) {
            return clone().X(key);
        }
        this.f17034m = (Key) Preconditions.d(key);
        this.f17023b |= 1024;
        return V();
    }

    public T Y(float f2) {
        if (this.f17044w) {
            return clone().Y(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f17024c = f2;
        this.f17023b |= 2;
        return V();
    }

    public T Z(boolean z2) {
        if (this.f17044w) {
            return clone().Z(true);
        }
        this.f17031j = !z2;
        this.f17023b |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        return V();
    }

    public T a(BaseRequestOptions<?> baseRequestOptions) {
        if (this.f17044w) {
            return clone().a(baseRequestOptions);
        }
        if (F(baseRequestOptions.f17023b, 2)) {
            this.f17024c = baseRequestOptions.f17024c;
        }
        if (F(baseRequestOptions.f17023b, 262144)) {
            this.f17045x = baseRequestOptions.f17045x;
        }
        if (F(baseRequestOptions.f17023b, 1048576)) {
            this.A = baseRequestOptions.A;
        }
        if (F(baseRequestOptions.f17023b, 4)) {
            this.f17025d = baseRequestOptions.f17025d;
        }
        if (F(baseRequestOptions.f17023b, 8)) {
            this.f17026e = baseRequestOptions.f17026e;
        }
        if (F(baseRequestOptions.f17023b, 16)) {
            this.f17027f = baseRequestOptions.f17027f;
            this.f17028g = 0;
            this.f17023b &= -33;
        }
        if (F(baseRequestOptions.f17023b, 32)) {
            this.f17028g = baseRequestOptions.f17028g;
            this.f17027f = null;
            this.f17023b &= -17;
        }
        if (F(baseRequestOptions.f17023b, 64)) {
            this.f17029h = baseRequestOptions.f17029h;
            this.f17030i = 0;
            this.f17023b &= -129;
        }
        if (F(baseRequestOptions.f17023b, 128)) {
            this.f17030i = baseRequestOptions.f17030i;
            this.f17029h = null;
            this.f17023b &= -65;
        }
        if (F(baseRequestOptions.f17023b, UserVerificationMethods.USER_VERIFY_HANDPRINT)) {
            this.f17031j = baseRequestOptions.f17031j;
        }
        if (F(baseRequestOptions.f17023b, 512)) {
            this.f17033l = baseRequestOptions.f17033l;
            this.f17032k = baseRequestOptions.f17032k;
        }
        if (F(baseRequestOptions.f17023b, 1024)) {
            this.f17034m = baseRequestOptions.f17034m;
        }
        if (F(baseRequestOptions.f17023b, CodedOutputStream.DEFAULT_BUFFER_SIZE)) {
            this.f17041t = baseRequestOptions.f17041t;
        }
        if (F(baseRequestOptions.f17023b, 8192)) {
            this.f17037p = baseRequestOptions.f17037p;
            this.f17038q = 0;
            this.f17023b &= -16385;
        }
        if (F(baseRequestOptions.f17023b, Http2.INITIAL_MAX_FRAME_SIZE)) {
            this.f17038q = baseRequestOptions.f17038q;
            this.f17037p = null;
            this.f17023b &= -8193;
        }
        if (F(baseRequestOptions.f17023b, 32768)) {
            this.f17043v = baseRequestOptions.f17043v;
        }
        if (F(baseRequestOptions.f17023b, 65536)) {
            this.f17036o = baseRequestOptions.f17036o;
        }
        if (F(baseRequestOptions.f17023b, 131072)) {
            this.f17035n = baseRequestOptions.f17035n;
        }
        if (F(baseRequestOptions.f17023b, 2048)) {
            this.f17040s.putAll(baseRequestOptions.f17040s);
            this.f17047z = baseRequestOptions.f17047z;
        }
        if (F(baseRequestOptions.f17023b, ImageMetadata.LENS_APERTURE)) {
            this.f17046y = baseRequestOptions.f17046y;
        }
        if (!this.f17036o) {
            this.f17040s.clear();
            this.f17035n = false;
            this.f17023b = this.f17023b & -2049 & -131073;
            this.f17047z = true;
        }
        this.f17023b |= baseRequestOptions.f17023b;
        this.f17039r.d(baseRequestOptions.f17039r);
        return V();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a0(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.b0(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.a0(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T b() {
        if (!this.f17042u || this.f17044w) {
            this.f17044w = true;
            return K();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T b0(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.f17044w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r2.clone()
            com.bumptech.glide.request.BaseRequestOptions r3 = r0.b0(r3, r4)
            return r3
        L_0x000d:
            com.bumptech.glide.load.resource.bitmap.DrawableTransformation r0 = new com.bumptech.glide.load.resource.bitmap.DrawableTransformation
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.d0(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.d0(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.Transformation r0 = r0.c()
            r2.d0(r1, r0, r4)
            com.bumptech.glide.load.resource.gif.GifDrawableTransformation r0 = new com.bumptech.glide.load.resource.gif.GifDrawableTransformation
            r0.<init>(r3)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r3 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            r2.d0(r3, r0, r4)
            com.bumptech.glide.request.BaseRequestOptions r3 = r2.V()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.b0(com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T c() {
        return c0(DownsampleStrategy.f16830e, new CenterCrop());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T c0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f17044w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.c0(r2, r3)
            return r2
        L_0x000d:
            r1.g(r2)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.a0(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.c0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* renamed from: d */
    public T clone() {
        try {
            T t2 = (BaseRequestOptions) super.clone();
            Options options = new Options();
            t2.f17039r = options;
            options.d(this.f17039r);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t2.f17040s = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f17040s);
            t2.f17042u = false;
            t2.f17044w = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T d0(java.lang.Class<Y> r2, com.bumptech.glide.load.Transformation<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.f17044w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.d0(r2, r3, r4)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.d(r2)
            com.bumptech.glide.util.Preconditions.d(r3)
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r0 = r1.f17040s
            r0.put(r2, r3)
            int r2 = r1.f17023b
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r3 = 1
            r1.f17036o = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f17023b = r2
            r0 = 0
            r1.f17047z = r0
            if (r4 == 0) goto L_0x0030
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f17023b = r2
            r1.f17035n = r3
        L_0x0030:
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.V()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.d0(java.lang.Class, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T e(Class<?> cls) {
        if (this.f17044w) {
            return clone().e(cls);
        }
        this.f17041t = (Class) Preconditions.d(cls);
        this.f17023b |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        return V();
    }

    public T e0(boolean z2) {
        if (this.f17044w) {
            return clone().e0(z2);
        }
        this.A = z2;
        this.f17023b |= 1048576;
        return V();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f17024c, this.f17024c) == 0 && this.f17028g == baseRequestOptions.f17028g && Util.c(this.f17027f, baseRequestOptions.f17027f) && this.f17030i == baseRequestOptions.f17030i && Util.c(this.f17029h, baseRequestOptions.f17029h) && this.f17038q == baseRequestOptions.f17038q && Util.c(this.f17037p, baseRequestOptions.f17037p) && this.f17031j == baseRequestOptions.f17031j && this.f17032k == baseRequestOptions.f17032k && this.f17033l == baseRequestOptions.f17033l && this.f17035n == baseRequestOptions.f17035n && this.f17036o == baseRequestOptions.f17036o && this.f17045x == baseRequestOptions.f17045x && this.f17046y == baseRequestOptions.f17046y && this.f17025d.equals(baseRequestOptions.f17025d) && this.f17026e == baseRequestOptions.f17026e && this.f17039r.equals(baseRequestOptions.f17039r) && this.f17040s.equals(baseRequestOptions.f17040s) && this.f17041t.equals(baseRequestOptions.f17041t) && Util.c(this.f17034m, baseRequestOptions.f17034m) && Util.c(this.f17043v, baseRequestOptions.f17043v)) {
            return true;
        }
        return false;
    }

    public T f(DiskCacheStrategy diskCacheStrategy) {
        if (this.f17044w) {
            return clone().f(diskCacheStrategy);
        }
        this.f17025d = (DiskCacheStrategy) Preconditions.d(diskCacheStrategy);
        this.f17023b |= 4;
        return V();
    }

    public T g(DownsampleStrategy downsampleStrategy) {
        return W(DownsampleStrategy.f16833h, Preconditions.d(downsampleStrategy));
    }

    public T h(int i2) {
        if (this.f17044w) {
            return clone().h(i2);
        }
        this.f17028g = i2;
        this.f17027f = null;
        this.f17023b = (this.f17023b | 32) & -17;
        return V();
    }

    public int hashCode() {
        return Util.m(this.f17043v, Util.m(this.f17034m, Util.m(this.f17041t, Util.m(this.f17040s, Util.m(this.f17039r, Util.m(this.f17026e, Util.m(this.f17025d, Util.n(this.f17046y, Util.n(this.f17045x, Util.n(this.f17036o, Util.n(this.f17035n, Util.l(this.f17033l, Util.l(this.f17032k, Util.n(this.f17031j, Util.m(this.f17037p, Util.l(this.f17038q, Util.m(this.f17029h, Util.l(this.f17030i, Util.m(this.f17027f, Util.l(this.f17028g, Util.j(this.f17024c)))))))))))))))))))));
    }

    public final DiskCacheStrategy i() {
        return this.f17025d;
    }

    public final int j() {
        return this.f17028g;
    }

    public final Drawable k() {
        return this.f17027f;
    }

    public final Drawable l() {
        return this.f17037p;
    }

    public final int m() {
        return this.f17038q;
    }

    public final boolean n() {
        return this.f17046y;
    }

    public final Options o() {
        return this.f17039r;
    }

    public final int p() {
        return this.f17032k;
    }

    public final int q() {
        return this.f17033l;
    }

    public final Drawable r() {
        return this.f17029h;
    }

    public final int s() {
        return this.f17030i;
    }

    public final Priority t() {
        return this.f17026e;
    }

    public final Class<?> u() {
        return this.f17041t;
    }

    public final Key v() {
        return this.f17034m;
    }

    public final float w() {
        return this.f17024c;
    }

    public final Resources.Theme x() {
        return this.f17043v;
    }

    public final Map<Class<?>, Transformation<?>> y() {
        return this.f17040s;
    }

    public final boolean z() {
        return this.A;
    }
}
