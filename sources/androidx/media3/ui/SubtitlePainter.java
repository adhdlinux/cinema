package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class SubtitlePainter {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* renamed from: a  reason: collision with root package name */
    private final float f10118a;

    /* renamed from: b  reason: collision with root package name */
    private final float f10119b;

    /* renamed from: c  reason: collision with root package name */
    private final float f10120c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10121d;

    /* renamed from: e  reason: collision with root package name */
    private final float f10122e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f10123f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f10124g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f10125h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f10126i;

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f10127j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f10128k;

    /* renamed from: l  reason: collision with root package name */
    private float f10129l;

    /* renamed from: m  reason: collision with root package name */
    private int f10130m;

    /* renamed from: n  reason: collision with root package name */
    private int f10131n;

    /* renamed from: o  reason: collision with root package name */
    private float f10132o;

    /* renamed from: p  reason: collision with root package name */
    private int f10133p;

    /* renamed from: q  reason: collision with root package name */
    private float f10134q;

    /* renamed from: r  reason: collision with root package name */
    private float f10135r;

    /* renamed from: s  reason: collision with root package name */
    private int f10136s;

    /* renamed from: t  reason: collision with root package name */
    private int f10137t;

    /* renamed from: u  reason: collision with root package name */
    private int f10138u;

    /* renamed from: v  reason: collision with root package name */
    private int f10139v;

    /* renamed from: w  reason: collision with root package name */
    private int f10140w;

    /* renamed from: x  reason: collision with root package name */
    private float f10141x;

    /* renamed from: y  reason: collision with root package name */
    private float f10142y;

    /* renamed from: z  reason: collision with root package name */
    private float f10143z;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f10122e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f10121d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f10118a = round;
        this.f10119b = round;
        this.f10120c = round;
        TextPaint textPaint = new TextPaint();
        this.f10123f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f10124g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f10125h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f10128k, (Rect) null, this.J, this.f10125h);
    }

    private void d(Canvas canvas, boolean z2) {
        if (z2) {
            e(canvas);
            return;
        }
        Assertions.f(this.J);
        Assertions.f(this.f10128k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        int i2;
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.G, (float) this.H);
            if (Color.alpha(this.f10138u) > 0) {
                this.f10124g.setColor(this.f10138u);
                canvas.drawRect((float) (-this.I), 0.0f, (float) (staticLayout.getWidth() + this.I), (float) staticLayout.getHeight(), this.f10124g);
            }
            int i3 = this.f10140w;
            boolean z2 = true;
            if (i3 == 1) {
                this.f10123f.setStrokeJoin(Paint.Join.ROUND);
                this.f10123f.setStrokeWidth(this.f10118a);
                this.f10123f.setColor(this.f10139v);
                this.f10123f.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i3 == 2) {
                TextPaint textPaint = this.f10123f;
                float f2 = this.f10119b;
                float f3 = this.f10120c;
                textPaint.setShadowLayer(f2, f3, f3, this.f10139v);
            } else if (i3 == 3 || i3 == 4) {
                if (i3 != 3) {
                    z2 = false;
                }
                int i4 = -1;
                if (z2) {
                    i2 = -1;
                } else {
                    i2 = this.f10139v;
                }
                if (z2) {
                    i4 = this.f10139v;
                }
                float f4 = this.f10119b / 2.0f;
                this.f10123f.setColor(this.f10136s);
                this.f10123f.setStyle(Paint.Style.FILL);
                float f5 = -f4;
                this.f10123f.setShadowLayer(this.f10119b, f5, f5, i2);
                staticLayout2.draw(canvas);
                this.f10123f.setShadowLayer(this.f10119b, f4, f4, i4);
            }
            this.f10123f.setColor(this.f10136s);
            this.f10123f.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f10123f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f10128k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f10132o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f10129l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f10134q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f10135r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0032
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L_0x0044
        L_0x0032:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L_0x0044:
            int r3 = r7.f10133p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L_0x004d
            float r3 = (float) r1
        L_0x004b:
            float r2 = r2 - r3
            goto L_0x0053
        L_0x004d:
            if (r3 != r5) goto L_0x0053
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L_0x004b
        L_0x0053:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f10131n
            if (r3 != r6) goto L_0x005e
            float r3 = (float) r0
        L_0x005c:
            float r4 = r4 - r3
            goto L_0x0064
        L_0x005e:
            if (r3 != r5) goto L_0x0064
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L_0x005c
        L_0x0064:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.SubtitlePainter.f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a8  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r26 = this;
            r0 = r26
            java.lang.CharSequence r1 = r0.f10126i
            boolean r2 = r1 instanceof android.text.SpannableStringBuilder
            if (r2 == 0) goto L_0x000b
            android.text.SpannableStringBuilder r1 = (android.text.SpannableStringBuilder) r1
            goto L_0x0012
        L_0x000b:
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.CharSequence r2 = r0.f10126i
            r1.<init>(r2)
        L_0x0012:
            int r2 = r0.C
            int r3 = r0.A
            int r2 = r2 - r3
            int r3 = r0.D
            int r4 = r0.B
            int r11 = r3 - r4
            android.text.TextPaint r3 = r0.f10123f
            float r4 = r0.f10141x
            r3.setTextSize(r4)
            float r3 = r0.f10141x
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r12 = (int) r3
            int r13 = r12 * 2
            int r3 = r2 - r13
            float r4 = r0.f10134q
            r14 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = (int) r3
        L_0x003f:
            r15 = r3
            java.lang.String r10 = "SubtitlePainter"
            if (r15 > 0) goto L_0x004a
            java.lang.String r1 = "Skipped drawing subtitle cue (insufficient space)"
            androidx.media3.common.util.Log.h(r10, r1)
            return
        L_0x004a:
            float r3 = r0.f10142y
            r16 = 0
            r4 = 16711680(0xff0000, float:2.3418052E-38)
            r9 = 0
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0064
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r5 = r0.f10142y
            int r5 = (int) r5
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x0064:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r1)
            int r3 = r0.f10140w
            r7 = 1
            if (r3 != r7) goto L_0x0087
            int r3 = r8.length()
            java.lang.Class<android.text.style.ForegroundColorSpan> r5 = android.text.style.ForegroundColorSpan.class
            java.lang.Object[] r3 = r8.getSpans(r9, r3, r5)
            android.text.style.ForegroundColorSpan[] r3 = (android.text.style.ForegroundColorSpan[]) r3
            int r5 = r3.length
            r6 = 0
        L_0x007c:
            if (r6 >= r5) goto L_0x0087
            r7 = r3[r6]
            r8.removeSpan(r7)
            int r6 = r6 + 1
            r7 = 1
            goto L_0x007c
        L_0x0087:
            int r3 = r0.f10137t
            int r3 = android.graphics.Color.alpha(r3)
            r7 = 2
            if (r3 <= 0) goto L_0x00b4
            int r3 = r0.f10140w
            if (r3 == 0) goto L_0x00a6
            if (r3 != r7) goto L_0x0097
            goto L_0x00a6
        L_0x0097:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.f10137t
            r3.<init>(r5)
            int r5 = r8.length()
            r8.setSpan(r3, r9, r5, r4)
            goto L_0x00b4
        L_0x00a6:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.f10137t
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x00b4:
            android.text.Layout$Alignment r3 = r0.f10127j
            if (r3 != 0) goto L_0x00ba
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00ba:
            r21 = r3
            android.text.StaticLayout r6 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f10123f
            float r4 = r0.f10121d
            float r3 = r0.f10122e
            r18 = 1
            r19 = r3
            r3 = r6
            r20 = r4
            r4 = r1
            r14 = r6
            r6 = r15
            r7 = r21
            r23 = r8
            r8 = r20
            r25 = r12
            r12 = 0
            r9 = r19
            r12 = r10
            r10 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.E = r14
            int r3 = r14.getHeight()
            android.text.StaticLayout r4 = r0.E
            int r4 = r4.getLineCount()
            r5 = 0
            r9 = 0
        L_0x00ed:
            if (r9 >= r4) goto L_0x0102
            android.text.StaticLayout r6 = r0.E
            float r6 = r6.getLineWidth(r9)
            double r6 = (double) r6
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            int r5 = java.lang.Math.max(r6, r5)
            int r9 = r9 + 1
            goto L_0x00ed
        L_0x0102:
            float r4 = r0.f10134q
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x010e
            if (r5 >= r15) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r15 = r5
        L_0x010f:
            int r15 = r15 + r13
            float r4 = r0.f10132o
            int r5 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x013c
            float r2 = (float) r2
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            int r4 = r0.A
            int r2 = r2 + r4
            int r5 = r0.f10133p
            r6 = 1
            if (r5 == r6) goto L_0x012b
            r7 = 2
            if (r5 == r7) goto L_0x0129
            goto L_0x0130
        L_0x0129:
            int r2 = r2 - r15
            goto L_0x0130
        L_0x012b:
            r7 = 2
            int r2 = r2 * 2
            int r2 = r2 - r15
            int r2 = r2 / r7
        L_0x0130:
            int r2 = java.lang.Math.max(r2, r4)
            int r15 = r15 + r2
            int r4 = r0.C
            int r4 = java.lang.Math.min(r15, r4)
            goto L_0x0145
        L_0x013c:
            r6 = 1
            r7 = 2
            int r2 = r2 - r15
            int r2 = r2 / r7
            int r4 = r0.A
            int r2 = r2 + r4
            int r4 = r2 + r15
        L_0x0145:
            int r20 = r4 - r2
            if (r20 > 0) goto L_0x014f
            java.lang.String r1 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            androidx.media3.common.util.Log.h(r12, r1)
            return
        L_0x014f:
            float r4 = r0.f10129l
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x01ae
            int r5 = r0.f10130m
            if (r5 != 0) goto L_0x0172
            float r5 = (float) r11
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.B
            int r4 = r4 + r5
            int r5 = r0.f10131n
            if (r5 != r7) goto L_0x016b
            goto L_0x019e
        L_0x016b:
            if (r5 != r6) goto L_0x019f
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r4 = r4 / r7
            goto L_0x019f
        L_0x0172:
            android.text.StaticLayout r4 = r0.E
            r5 = 0
            int r4 = r4.getLineBottom(r5)
            android.text.StaticLayout r6 = r0.E
            int r5 = r6.getLineTop(r5)
            int r4 = r4 - r5
            float r5 = r0.f10129l
            int r6 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0191
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.B
            int r4 = r4 + r5
            goto L_0x019f
        L_0x0191:
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 + r6
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.D
            int r4 = r4 + r5
        L_0x019e:
            int r4 = r4 - r3
        L_0x019f:
            int r5 = r4 + r3
            int r6 = r0.D
            if (r5 <= r6) goto L_0x01a8
            int r4 = r6 - r3
            goto L_0x01b8
        L_0x01a8:
            int r3 = r0.B
            if (r4 >= r3) goto L_0x01b8
            r11 = r3
            goto L_0x01b9
        L_0x01ae:
            int r4 = r0.D
            int r4 = r4 - r3
            float r3 = (float) r11
            float r5 = r0.f10143z
            float r3 = r3 * r5
            int r3 = (int) r3
            int r4 = r4 - r3
        L_0x01b8:
            r11 = r4
        L_0x01b9:
            android.text.StaticLayout r12 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f10123f
            float r8 = r0.f10121d
            float r9 = r0.f10122e
            r10 = 1
            r3 = r12
            r4 = r1
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.E = r12
            android.text.StaticLayout r1 = new android.text.StaticLayout
            android.text.TextPaint r3 = r0.f10123f
            float r4 = r0.f10121d
            float r5 = r0.f10122e
            r24 = 1
            r17 = r1
            r18 = r23
            r19 = r3
            r22 = r4
            r23 = r5
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r0.F = r1
            r0.G = r2
            r0.H = r11
            r1 = r25
            r0.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.SubtitlePainter.g():void");
    }

    public void b(Cue cue, CaptionStyleCompat captionStyleCompat, float f2, float f3, float f4, Canvas canvas, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i6;
        if (cue.f4561d == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            i6 = -16777216;
        } else if (!TextUtils.isEmpty(cue.f4558a)) {
            if (cue.f4569l) {
                i6 = cue.f4570m;
            } else {
                i6 = captionStyleCompat.f9769c;
            }
        } else {
            return;
        }
        if (a(this.f10126i, cue.f4558a) && Util.c(this.f10127j, cue.f4559b) && this.f10128k == cue.f4561d && this.f10129l == cue.f4562e && this.f10130m == cue.f4563f && Util.c(Integer.valueOf(this.f10131n), Integer.valueOf(cue.f4564g)) && this.f10132o == cue.f4565h && Util.c(Integer.valueOf(this.f10133p), Integer.valueOf(cue.f4566i)) && this.f10134q == cue.f4567j && this.f10135r == cue.f4568k && this.f10136s == captionStyleCompat.f9767a && this.f10137t == captionStyleCompat.f9768b && this.f10138u == i6 && this.f10140w == captionStyleCompat.f9770d && this.f10139v == captionStyleCompat.f9771e && Util.c(this.f10123f.getTypeface(), captionStyleCompat.f9772f) && this.f10141x == f2 && this.f10142y == f3 && this.f10143z == f4 && this.A == i2 && this.B == i3 && this.C == i4 && this.D == i5) {
            d(canvas, z2);
            return;
        }
        this.f10126i = cue.f4558a;
        this.f10127j = cue.f4559b;
        this.f10128k = cue.f4561d;
        this.f10129l = cue.f4562e;
        this.f10130m = cue.f4563f;
        this.f10131n = cue.f4564g;
        this.f10132o = cue.f4565h;
        this.f10133p = cue.f4566i;
        this.f10134q = cue.f4567j;
        this.f10135r = cue.f4568k;
        this.f10136s = captionStyleCompat.f9767a;
        this.f10137t = captionStyleCompat.f9768b;
        this.f10138u = i6;
        this.f10140w = captionStyleCompat.f9770d;
        this.f10139v = captionStyleCompat.f9771e;
        this.f10123f.setTypeface(captionStyleCompat.f9772f);
        this.f10141x = f2;
        this.f10142y = f3;
        this.f10143z = f4;
        this.A = i2;
        this.B = i3;
        this.C = i4;
        this.D = i5;
        if (z2) {
            Assertions.f(this.f10126i);
            g();
        } else {
            Assertions.f(this.f10128k);
            f();
        }
        d(canvas, z2);
    }
}
