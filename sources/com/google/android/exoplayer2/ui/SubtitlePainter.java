package com.google.android.exoplayer2.ui;

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
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
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
    private final float f28225a;

    /* renamed from: b  reason: collision with root package name */
    private final float f28226b;

    /* renamed from: c  reason: collision with root package name */
    private final float f28227c;

    /* renamed from: d  reason: collision with root package name */
    private final float f28228d;

    /* renamed from: e  reason: collision with root package name */
    private final float f28229e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f28230f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f28231g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f28232h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f28233i;

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f28234j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f28235k;

    /* renamed from: l  reason: collision with root package name */
    private float f28236l;

    /* renamed from: m  reason: collision with root package name */
    private int f28237m;

    /* renamed from: n  reason: collision with root package name */
    private int f28238n;

    /* renamed from: o  reason: collision with root package name */
    private float f28239o;

    /* renamed from: p  reason: collision with root package name */
    private int f28240p;

    /* renamed from: q  reason: collision with root package name */
    private float f28241q;

    /* renamed from: r  reason: collision with root package name */
    private float f28242r;

    /* renamed from: s  reason: collision with root package name */
    private int f28243s;

    /* renamed from: t  reason: collision with root package name */
    private int f28244t;

    /* renamed from: u  reason: collision with root package name */
    private int f28245u;

    /* renamed from: v  reason: collision with root package name */
    private int f28246v;

    /* renamed from: w  reason: collision with root package name */
    private int f28247w;

    /* renamed from: x  reason: collision with root package name */
    private float f28248x;

    /* renamed from: y  reason: collision with root package name */
    private float f28249y;

    /* renamed from: z  reason: collision with root package name */
    private float f28250z;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f28229e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f28228d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f28225a = round;
        this.f28226b = round;
        this.f28227c = round;
        TextPaint textPaint = new TextPaint();
        this.f28230f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f28231g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f28232h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f28235k, (Rect) null, this.J, this.f28232h);
    }

    private void d(Canvas canvas, boolean z2) {
        if (z2) {
            e(canvas);
            return;
        }
        Assertions.e(this.J);
        Assertions.e(this.f28235k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        int i2;
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.G, (float) this.H);
            if (Color.alpha(this.f28245u) > 0) {
                this.f28231g.setColor(this.f28245u);
                canvas.drawRect((float) (-this.I), 0.0f, (float) (staticLayout.getWidth() + this.I), (float) staticLayout.getHeight(), this.f28231g);
            }
            int i3 = this.f28247w;
            boolean z2 = true;
            if (i3 == 1) {
                this.f28230f.setStrokeJoin(Paint.Join.ROUND);
                this.f28230f.setStrokeWidth(this.f28225a);
                this.f28230f.setColor(this.f28246v);
                this.f28230f.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i3 == 2) {
                TextPaint textPaint = this.f28230f;
                float f2 = this.f28226b;
                float f3 = this.f28227c;
                textPaint.setShadowLayer(f2, f3, f3, this.f28246v);
            } else if (i3 == 3 || i3 == 4) {
                if (i3 != 3) {
                    z2 = false;
                }
                int i4 = -1;
                if (z2) {
                    i2 = -1;
                } else {
                    i2 = this.f28246v;
                }
                if (z2) {
                    i4 = this.f28246v;
                }
                float f4 = this.f28226b / 2.0f;
                this.f28230f.setColor(this.f28243s);
                this.f28230f.setStyle(Paint.Style.FILL);
                float f5 = -f4;
                this.f28230f.setShadowLayer(this.f28226b, f5, f5, i2);
                staticLayout2.draw(canvas);
                this.f28230f.setShadowLayer(this.f28226b, f4, f4, i4);
            }
            this.f28230f.setColor(this.f28243s);
            this.f28230f.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f28230f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
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
            android.graphics.Bitmap r0 = r7.f28235k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f28239o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f28236l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f28241q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f28242r
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
            int r3 = r7.f28240p
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
            int r3 = r7.f28238n
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitlePainter.f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a8  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r26 = this;
            r0 = r26
            java.lang.CharSequence r1 = r0.f28233i
            boolean r2 = r1 instanceof android.text.SpannableStringBuilder
            if (r2 == 0) goto L_0x000b
            android.text.SpannableStringBuilder r1 = (android.text.SpannableStringBuilder) r1
            goto L_0x0012
        L_0x000b:
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.CharSequence r2 = r0.f28233i
            r1.<init>(r2)
        L_0x0012:
            int r2 = r0.C
            int r3 = r0.A
            int r2 = r2 - r3
            int r3 = r0.D
            int r4 = r0.B
            int r11 = r3 - r4
            android.text.TextPaint r3 = r0.f28230f
            float r4 = r0.f28248x
            r3.setTextSize(r4)
            float r3 = r0.f28248x
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r12 = (int) r3
            int r13 = r12 * 2
            int r3 = r2 - r13
            float r4 = r0.f28241q
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
            com.google.android.exoplayer2.util.Log.i(r10, r1)
            return
        L_0x004a:
            float r3 = r0.f28249y
            r16 = 0
            r4 = 16711680(0xff0000, float:2.3418052E-38)
            r9 = 0
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0064
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r5 = r0.f28249y
            int r5 = (int) r5
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x0064:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r1)
            int r3 = r0.f28247w
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
            int r3 = r0.f28244t
            int r3 = android.graphics.Color.alpha(r3)
            r7 = 2
            if (r3 <= 0) goto L_0x00b4
            int r3 = r0.f28247w
            if (r3 == 0) goto L_0x00a6
            if (r3 != r7) goto L_0x0097
            goto L_0x00a6
        L_0x0097:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.f28244t
            r3.<init>(r5)
            int r5 = r8.length()
            r8.setSpan(r3, r9, r5, r4)
            goto L_0x00b4
        L_0x00a6:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.f28244t
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x00b4:
            android.text.Layout$Alignment r3 = r0.f28234j
            if (r3 != 0) goto L_0x00ba
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00ba:
            r21 = r3
            android.text.StaticLayout r6 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f28230f
            float r4 = r0.f28228d
            float r3 = r0.f28229e
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
            float r4 = r0.f28241q
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x010e
            if (r5 >= r15) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r15 = r5
        L_0x010f:
            int r15 = r15 + r13
            float r4 = r0.f28239o
            int r5 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x013c
            float r2 = (float) r2
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            int r4 = r0.A
            int r2 = r2 + r4
            int r5 = r0.f28240p
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
            com.google.android.exoplayer2.util.Log.i(r12, r1)
            return
        L_0x014f:
            float r4 = r0.f28236l
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x01ae
            int r5 = r0.f28237m
            if (r5 != 0) goto L_0x0172
            float r5 = (float) r11
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.B
            int r4 = r4 + r5
            int r5 = r0.f28238n
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
            float r5 = r0.f28236l
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
            float r5 = r0.f28250z
            float r3 = r3 * r5
            int r3 = (int) r3
            int r4 = r4 - r3
        L_0x01b8:
            r11 = r4
        L_0x01b9:
            android.text.StaticLayout r12 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f28230f
            float r8 = r0.f28228d
            float r9 = r0.f28229e
            r10 = 1
            r3 = r12
            r4 = r1
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.E = r12
            android.text.StaticLayout r1 = new android.text.StaticLayout
            android.text.TextPaint r3 = r0.f28230f
            float r4 = r0.f28228d
            float r5 = r0.f28229e
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitlePainter.g():void");
    }

    public void b(Cue cue, CaptionStyleCompat captionStyleCompat, float f2, float f3, float f4, Canvas canvas, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i6;
        if (cue.f27205e == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            i6 = -16777216;
        } else if (!TextUtils.isEmpty(cue.f27202b)) {
            if (cue.f27213m) {
                i6 = cue.f27214n;
            } else {
                i6 = captionStyleCompat.f27847c;
            }
        } else {
            return;
        }
        if (a(this.f28233i, cue.f27202b) && Util.c(this.f28234j, cue.f27203c) && this.f28235k == cue.f27205e && this.f28236l == cue.f27206f && this.f28237m == cue.f27207g && Util.c(Integer.valueOf(this.f28238n), Integer.valueOf(cue.f27208h)) && this.f28239o == cue.f27209i && Util.c(Integer.valueOf(this.f28240p), Integer.valueOf(cue.f27210j)) && this.f28241q == cue.f27211k && this.f28242r == cue.f27212l && this.f28243s == captionStyleCompat.f27845a && this.f28244t == captionStyleCompat.f27846b && this.f28245u == i6 && this.f28247w == captionStyleCompat.f27848d && this.f28246v == captionStyleCompat.f27849e && Util.c(this.f28230f.getTypeface(), captionStyleCompat.f27850f) && this.f28248x == f2 && this.f28249y == f3 && this.f28250z == f4 && this.A == i2 && this.B == i3 && this.C == i4 && this.D == i5) {
            d(canvas, z2);
            return;
        }
        this.f28233i = cue.f27202b;
        this.f28234j = cue.f27203c;
        this.f28235k = cue.f27205e;
        this.f28236l = cue.f27206f;
        this.f28237m = cue.f27207g;
        this.f28238n = cue.f27208h;
        this.f28239o = cue.f27209i;
        this.f28240p = cue.f27210j;
        this.f28241q = cue.f27211k;
        this.f28242r = cue.f27212l;
        this.f28243s = captionStyleCompat.f27845a;
        this.f28244t = captionStyleCompat.f27846b;
        this.f28245u = i6;
        this.f28247w = captionStyleCompat.f27848d;
        this.f28246v = captionStyleCompat.f27849e;
        this.f28230f.setTypeface(captionStyleCompat.f27850f);
        this.f28248x = f2;
        this.f28249y = f3;
        this.f28250z = f4;
        this.A = i2;
        this.B = i3;
        this.C = i4;
        this.D = i5;
        if (z2) {
            Assertions.e(this.f28233i);
            g();
        } else {
            Assertions.e(this.f28235k);
            f();
        }
        d(canvas, z2);
    }
}
