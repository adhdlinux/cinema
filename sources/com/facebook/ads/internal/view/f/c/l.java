package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.a.a;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;

public class l extends c {

    /* renamed from: a  reason: collision with root package name */
    private final i f21448a;

    /* renamed from: b  reason: collision with root package name */
    private final k f21449b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b.c f21450c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final m f21451d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f21452e;

    /* renamed from: com.facebook.ads.internal.view.f.c.l$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21457a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.ads.internal.view.f.d.d[] r0 = com.facebook.ads.internal.view.f.d.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21457a = r0
                com.facebook.ads.internal.view.f.d.d r1 = com.facebook.ads.internal.view.f.d.d.PREPARED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21457a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.view.f.d.d r1 = com.facebook.ads.internal.view.f.d.d.IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21457a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.view.f.d.d r1 = com.facebook.ads.internal.view.f.d.d.PAUSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21457a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.view.f.d.d r1 = com.facebook.ads.internal.view.f.d.d.PLAYBACK_COMPLETED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21457a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.ads.internal.view.f.d.d r1 = com.facebook.ads.internal.view.f.d.d.STARTED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.f.c.l.AnonymousClass5.<clinit>():void");
        }
    }

    public l(Context context) {
        this(context, false);
    }

    public l(Context context, boolean z2) {
        super(context);
        this.f21448a = new i() {
            public void a(h hVar) {
                l.this.f21451d.setChecked(true);
            }
        };
        this.f21449b = new k() {
            public void a(j jVar) {
                l.this.f21451d.setChecked(false);
            }
        };
        this.f21450c = new com.facebook.ads.internal.view.f.b.c() {
            public void a(b bVar) {
                l.this.f21451d.setChecked(true);
            }
        };
        m mVar = new m(context, z2);
        this.f21451d = mVar;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) f2) * 23.76d), (int) (((double) f2) * 23.76d));
        layoutParams.addRule(13);
        mVar.setLayoutParams(layoutParams);
        mVar.setChecked(true);
        Paint paint = new Paint();
        this.f21452e = paint;
        paint.setStyle(Paint.Style.FILL);
        if (z2) {
            paint.setColor(-1728053248);
        } else {
            paint.setColor(-1);
            paint.setAlpha(204);
        }
        x.a((View) this, 0);
        addView(mVar);
        setGravity(17);
        float f3 = displayMetrics.density;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) f3) * 72.0d), (int) (((double) f3) * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().a((T[]) new f[]{this.f21448a, this.f21449b, this.f21450c});
        }
        AnonymousClass4 r02 = new View.OnClickListener() {
            public void onClick(View view) {
                if (l.this.getVideoView() != null) {
                    int i2 = AnonymousClass5.f21457a[l.this.getVideoView().getState().ordinal()];
                    if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                        l.this.getVideoView().a(a.USER_STARTED);
                    } else if (i2 == 5) {
                        l.this.getVideoView().a(true);
                    }
                }
            }
        };
        this.f21451d.setClickable(false);
        setOnClickListener(r02);
    }

    /* access modifiers changed from: protected */
    public void b() {
        setOnClickListener((View.OnClickListener) null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().b((T[]) new f[]{this.f21450c, this.f21449b, this.f21448a});
        }
        super.b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
        canvas.drawCircle((float) (getPaddingLeft() + min), (float) (getPaddingTop() + min), (float) min, this.f21452e);
        super.onDraw(canvas);
    }
}
