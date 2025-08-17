package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions P = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().f(DiskCacheStrategy.f16456c)).S(Priority.LOW)).Z(true));
    private final Context B;
    private final RequestManager C;
    private final Class<TranscodeType> D;
    private final Glide E;
    private final GlideContext F;
    private TransitionOptions<?, ? super TranscodeType> G;
    private Object H;
    private List<RequestListener<TranscodeType>> I;
    private RequestBuilder<TranscodeType> J;
    private RequestBuilder<TranscodeType> K;
    private Float L;
    private boolean M = true;
    private boolean N;
    private boolean O;

    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16162a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16163b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16163b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f16163b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f16163b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f16163b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f16162a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f16162a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f16162a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    @SuppressLint({"CheckResult"})
    protected RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.E = glide;
        this.C = requestManager;
        this.D = cls;
        this.B = context;
        this.G = requestManager.g(cls);
        this.F = glide.i();
        m0(requestManager.e());
        a(requestManager.f());
    }

    private Request h0(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return i0(new Object(), target, requestListener, (RequestCoordinator) null, this.G, baseRequestOptions.t(), baseRequestOptions.q(), baseRequestOptions.p(), baseRequestOptions, executor);
    }

    private Request i0(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.K != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            Object obj2 = obj;
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request j02 = j0(obj, target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i2, i3, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return j02;
        }
        int q2 = this.K.q();
        int p2 = this.K.p();
        if (Util.r(i2, i3) && !this.K.J()) {
            q2 = baseRequestOptions.q();
            p2 = baseRequestOptions.p();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.K;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.e(j02, requestBuilder.i0(obj, target, requestListener, errorRequestCoordinator3, requestBuilder.G, requestBuilder.t(), q2, p2, this.K, executor));
        return errorRequestCoordinator3;
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [com.bumptech.glide.request.BaseRequestOptions<?>, com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.request.Request j0(java.lang.Object r19, com.bumptech.glide.request.target.Target<TranscodeType> r20, com.bumptech.glide.request.RequestListener<TranscodeType> r21, com.bumptech.glide.request.RequestCoordinator r22, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r23, com.bumptech.glide.Priority r24, int r25, int r26, com.bumptech.glide.request.BaseRequestOptions<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.J
            if (r0 == 0) goto L_0x0094
            boolean r1 = r11.O
            if (r1 != 0) goto L_0x008c
            com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r1 = r0.G
            boolean r2 = r0.M
            if (r2 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            boolean r0 = r0.C()
            if (r0 == 0) goto L_0x0027
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.J
            com.bumptech.glide.Priority r0 = r0.t()
            goto L_0x002b
        L_0x0027:
            com.bumptech.glide.Priority r0 = r11.l0(r13)
        L_0x002b:
            r15 = r0
            com.bumptech.glide.RequestBuilder<TranscodeType> r0 = r11.J
            int r0 = r0.q()
            com.bumptech.glide.RequestBuilder<TranscodeType> r1 = r11.J
            int r1 = r1.p()
            boolean r2 = com.bumptech.glide.util.Util.r(r25, r26)
            if (r2 == 0) goto L_0x004e
            com.bumptech.glide.RequestBuilder<TranscodeType> r2 = r11.J
            boolean r2 = r2.J()
            if (r2 != 0) goto L_0x004e
            int r0 = r27.q()
            int r1 = r27.p()
        L_0x004e:
            r16 = r0
            r17 = r1
            com.bumptech.glide.request.ThumbnailRequestCoordinator r10 = new com.bumptech.glide.request.ThumbnailRequestCoordinator
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            com.bumptech.glide.request.Request r10 = r0.w0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1
            r11.O = r0
            com.bumptech.glide.RequestBuilder<TranscodeType> r9 = r11.J
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            com.bumptech.glide.request.Request r0 = r0.i0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            r11.O = r1
            r13.d(r12, r0)
            return r13
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            java.lang.Float r0 = r11.L
            if (r0 == 0) goto L_0x00d4
            com.bumptech.glide.request.ThumbnailRequestCoordinator r14 = new com.bumptech.glide.request.ThumbnailRequestCoordinator
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.Request r15 = r0.w0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.bumptech.glide.request.BaseRequestOptions r0 = r27.clone()
            java.lang.Float r1 = r11.L
            float r1 = r1.floatValue()
            com.bumptech.glide.request.BaseRequestOptions r4 = r0.Y(r1)
            com.bumptech.glide.Priority r7 = r11.l0(r13)
            r0 = r18
            r1 = r19
            com.bumptech.glide.request.Request r0 = r0.w0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.d(r15, r0)
            return r14
        L_0x00d4:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.Request r0 = r0.w0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.j0(java.lang.Object, com.bumptech.glide.request.target.Target, com.bumptech.glide.request.RequestListener, com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.TransitionOptions, com.bumptech.glide.Priority, int, int, com.bumptech.glide.request.BaseRequestOptions, java.util.concurrent.Executor):com.bumptech.glide.request.Request");
    }

    private Priority l0(Priority priority) {
        int i2 = AnonymousClass1.f16163b[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + t());
    }

    @SuppressLint({"CheckResult"})
    private void m0(List<RequestListener<Object>> list) {
        for (RequestListener<Object> f02 : list) {
            f0(f02);
        }
    }

    private <Y extends Target<TranscodeType>> Y o0(Y y2, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.d(y2);
        if (this.N) {
            Request h02 = h0(y2, requestListener, baseRequestOptions, executor);
            Request request = y2.getRequest();
            if (!h02.isEquivalentTo(request) || r0(baseRequestOptions, request)) {
                this.C.d(y2);
                y2.setRequest(h02);
                this.C.n(y2, h02);
                return y2;
            }
            if (!((Request) Preconditions.d(request)).isRunning()) {
                request.begin();
            }
            return y2;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean r0(BaseRequestOptions<?> baseRequestOptions, Request request) {
        return !baseRequestOptions.B() && request.isComplete();
    }

    private RequestBuilder<TranscodeType> v0(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    private Request w0(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.B;
        GlideContext glideContext = this.F;
        return SingleRequest.o(context, glideContext, obj, this.H, this.D, baseRequestOptions, i2, i3, priority, target, requestListener, this.I, requestCoordinator, glideContext.f(), transitionOptions.b(), executor);
    }

    public RequestBuilder<TranscodeType> f0(RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.add(requestListener);
        }
        return this;
    }

    /* renamed from: g0 */
    public RequestBuilder<TranscodeType> a(BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.d(baseRequestOptions);
        return (RequestBuilder) super.a(baseRequestOptions);
    }

    /* renamed from: k0 */
    public RequestBuilder<TranscodeType> d() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.G = requestBuilder.G.clone();
        return requestBuilder;
    }

    public <Y extends Target<TranscodeType>> Y n0(Y y2) {
        return p0(y2, (RequestListener) null, Executors.b());
    }

    /* access modifiers changed from: package-private */
    public <Y extends Target<TranscodeType>> Y p0(Y y2, RequestListener<TranscodeType> requestListener, Executor executor) {
        return o0(y2, requestListener, this, executor);
    }

    public ViewTarget<ImageView, TranscodeType> q0(ImageView imageView) {
        BaseRequestOptions baseRequestOptions;
        Util.a();
        Preconditions.d(imageView);
        if (!I() && G() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f16162a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = clone().L();
                    break;
                case 2:
                    baseRequestOptions = clone().M();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = clone().N();
                    break;
                case 6:
                    baseRequestOptions = clone().M();
                    break;
            }
        }
        baseRequestOptions = this;
        return (ViewTarget) o0(this.F.a(imageView, this.D), (RequestListener) null, baseRequestOptions, Executors.b());
    }

    public RequestBuilder<TranscodeType> s0(RequestListener<TranscodeType> requestListener) {
        this.I = null;
        return f0(requestListener);
    }

    public RequestBuilder<TranscodeType> t0(Object obj) {
        return v0(obj);
    }

    public RequestBuilder<TranscodeType> u0(String str) {
        return v0(str);
    }

    public RequestBuilder<TranscodeType> x0(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.G = (TransitionOptions) Preconditions.d(transitionOptions);
        this.M = false;
        return this;
    }
}
