package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {

    /* renamed from: b  reason: collision with root package name */
    private final CanvasSubtitleOutput f28277b;

    /* renamed from: c  reason: collision with root package name */
    private final WebView f28278c;

    /* renamed from: d  reason: collision with root package name */
    private List<Cue> f28279d;

    /* renamed from: e  reason: collision with root package name */
    private CaptionStyleCompat f28280e;

    /* renamed from: f  reason: collision with root package name */
    private float f28281f;

    /* renamed from: g  reason: collision with root package name */
    private int f28282g;

    /* renamed from: h  reason: collision with root package name */
    private float f28283h;

    /* renamed from: com.google.android.exoplayer2.ui.WebViewSubtitleOutput$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28284a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28284a = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28284a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28284a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.AnonymousClass2.<clinit>():void");
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int b(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i2 = AnonymousClass2.f28284a[alignment.ordinal()];
        if (i2 == 1) {
            return ViewProps.START;
        }
        if (i2 != 2) {
            return "center";
        }
        return ViewProps.END;
    }

    private static String d(CaptionStyleCompat captionStyleCompat) {
        int i2 = captionStyleCompat.f27848d;
        if (i2 == 1) {
            return Util.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.b(captionStyleCompat.f27849e));
        } else if (i2 == 2) {
            return Util.C("0.1em 0.12em 0.15em %s", HtmlUtils.b(captionStyleCompat.f27849e));
        } else if (i2 == 3) {
            return Util.C("0.06em 0.08em 0.15em %s", HtmlUtils.b(captionStyleCompat.f27849e));
        } else if (i2 != 4) {
            return "unset";
        } else {
            return Util.C("-0.05em -0.05em 0.15em %s", HtmlUtils.b(captionStyleCompat.f27849e));
        }
    }

    private String e(int i2, float f2) {
        float h2 = SubtitleViewUtils.h(i2, f2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (h2 == -3.4028235E38f) {
            return "unset";
        }
        return Util.C("%.2fpx", Float.valueOf(h2 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i2) {
        return i2 != 1 ? i2 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static String h(Cue cue) {
        String str;
        float f2 = cue.f27218r;
        if (f2 == 0.0f) {
            return "";
        }
        int i2 = cue.f27217q;
        if (i2 == 2 || i2 == 1) {
            str = "skewY";
        } else {
            str = "skewX";
        }
        return Util.C("%s(%.2fdeg)", str, Float.valueOf(f2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0148, code lost:
        if (r13 != false) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014b, code lost:
        if (r13 != false) goto L_0x014d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x023f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r26 = this;
            r0 = r26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 4
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.google.android.exoplayer2.ui.CaptionStyleCompat r4 = r0.f28280e
            int r4 = r4.f27845a
            java.lang.String r4 = com.google.android.exoplayer2.ui.HtmlUtils.b(r4)
            r5 = 0
            r3[r5] = r4
            int r4 = r0.f28282g
            float r6 = r0.f28281f
            java.lang.String r4 = r0.e(r4, r6)
            r6 = 1
            r3[r6] = r4
            r4 = 1067030938(0x3f99999a, float:1.2)
            java.lang.Float r7 = java.lang.Float.valueOf(r4)
            r8 = 2
            r3[r8] = r7
            com.google.android.exoplayer2.ui.CaptionStyleCompat r7 = r0.f28280e
            java.lang.String r7 = d(r7)
            r9 = 3
            r3[r9] = r7
            java.lang.String r7 = "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>"
            java.lang.String r3 = com.google.android.exoplayer2.util.Util.C(r7, r3)
            r1.append(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r7 = "default_bg"
            java.lang.String r10 = com.google.android.exoplayer2.ui.HtmlUtils.a(r7)
            java.lang.Object[] r11 = new java.lang.Object[r6]
            com.google.android.exoplayer2.ui.CaptionStyleCompat r12 = r0.f28280e
            int r12 = r12.f27846b
            java.lang.String r12 = com.google.android.exoplayer2.ui.HtmlUtils.b(r12)
            r11[r5] = r12
            java.lang.String r12 = "background-color:%s;"
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.C(r12, r11)
            r3.put(r10, r11)
            r10 = 0
        L_0x005d:
            java.util.List<com.google.android.exoplayer2.text.Cue> r11 = r0.f28279d
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x025c
            java.util.List<com.google.android.exoplayer2.text.Cue> r11 = r0.f28279d
            java.lang.Object r11 = r11.get(r10)
            com.google.android.exoplayer2.text.Cue r11 = (com.google.android.exoplayer2.text.Cue) r11
            float r12 = r11.f27209i
            r13 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r14 = 1120403456(0x42c80000, float:100.0)
            int r15 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x007b
            float r12 = r12 * r14
            goto L_0x007d
        L_0x007b:
            r12 = 1112014848(0x42480000, float:50.0)
        L_0x007d:
            int r15 = r11.f27210j
            int r15 = b(r15)
            float r2 = r11.f27206f
            r17 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r9 = "%.2f%%"
            int r18 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r18 == 0) goto L_0x00dd
            int r8 = r11.f27207g
            if (r8 == r6) goto L_0x00b2
            java.lang.Object[] r8 = new java.lang.Object[r6]
            float r2 = r2 * r14
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r8[r5] = r2
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.C(r9, r8)
            int r8 = r11.f27217q
            if (r8 != r6) goto L_0x00ab
            int r8 = r11.f27208h
            int r8 = b(r8)
            int r8 = -r8
            goto L_0x00f1
        L_0x00ab:
            int r8 = r11.f27208h
            int r8 = b(r8)
            goto L_0x00f1
        L_0x00b2:
            r8 = 0
            java.lang.String r13 = "%.2fem"
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x00c9
            java.lang.Object[] r8 = new java.lang.Object[r6]
            float r2 = r2 * r4
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r8[r5] = r2
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.C(r13, r8)
            r8 = 0
            goto L_0x00f1
        L_0x00c9:
            java.lang.Object[] r8 = new java.lang.Object[r6]
            float r2 = -r2
            float r2 = r2 - r17
            float r2 = r2 * r4
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r8[r5] = r2
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.C(r13, r8)
            r8 = 0
            r13 = 1
            goto L_0x00f2
        L_0x00dd:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r0.f28283h
            float r17 = r17 - r8
            float r17 = r17 * r14
            java.lang.Float r8 = java.lang.Float.valueOf(r17)
            r2[r5] = r8
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.C(r9, r2)
            r8 = -100
        L_0x00f1:
            r13 = 0
        L_0x00f2:
            float r4 = r11.f27211k
            r19 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r19 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r19 == 0) goto L_0x010b
            java.lang.Object[] r5 = new java.lang.Object[r6]
            float r4 = r4 * r14
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r14 = 0
            r5[r14] = r4
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.C(r9, r5)
            goto L_0x010d
        L_0x010b:
            java.lang.String r4 = "fit-content"
        L_0x010d:
            android.text.Layout$Alignment r5 = r11.f27203c
            java.lang.String r5 = c(r5)
            int r9 = r11.f27217q
            java.lang.String r9 = f(r9)
            int r14 = r11.f27215o
            float r6 = r11.f27216p
            java.lang.String r6 = r0.e(r14, r6)
            boolean r14 = r11.f27213m
            if (r14 == 0) goto L_0x0128
            int r14 = r11.f27214n
            goto L_0x012c
        L_0x0128:
            com.google.android.exoplayer2.ui.CaptionStyleCompat r14 = r0.f28280e
            int r14 = r14.f27847c
        L_0x012c:
            java.lang.String r14 = com.google.android.exoplayer2.ui.HtmlUtils.b(r14)
            r20 = r8
            int r8 = r11.f27217q
            java.lang.String r21 = "right"
            java.lang.String r22 = "left"
            java.lang.String r23 = "top"
            r24 = r15
            r15 = 1
            if (r8 == r15) goto L_0x014b
            r15 = 2
            if (r8 == r15) goto L_0x0148
            if (r13 == 0) goto L_0x0146
            java.lang.String r23 = "bottom"
        L_0x0146:
            r13 = 2
            goto L_0x0154
        L_0x0148:
            if (r13 == 0) goto L_0x014d
            goto L_0x014f
        L_0x014b:
            if (r13 == 0) goto L_0x014f
        L_0x014d:
            r21 = r22
        L_0x014f:
            r22 = r23
            r13 = 2
            r23 = r21
        L_0x0154:
            if (r8 == r13) goto L_0x015f
            r13 = 1
            if (r8 != r13) goto L_0x015a
            goto L_0x015f
        L_0x015a:
            java.lang.String r8 = "width"
            r15 = r24
            goto L_0x0165
        L_0x015f:
            java.lang.String r8 = "height"
            r15 = r20
            r20 = r24
        L_0x0165:
            java.lang.CharSequence r13 = r11.f27202b
            android.content.Context r21 = r26.getContext()
            android.content.res.Resources r21 = r21.getResources()
            android.util.DisplayMetrics r0 = r21.getDisplayMetrics()
            float r0 = r0.density
            com.google.android.exoplayer2.ui.SpannedToHtmlConverter$HtmlAndCss r0 = com.google.android.exoplayer2.ui.SpannedToHtmlConverter.a(r13, r0)
            java.util.Set r13 = r3.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0181:
            boolean r21 = r13.hasNext()
            if (r21 == 0) goto L_0x01b9
            java.lang.Object r21 = r13.next()
            r24 = r13
            r13 = r21
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r21 = r3.get(r13)
            r25 = r0
            r0 = r21
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r3.put(r13, r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x01b0
            java.lang.Object r13 = r3.get(r13)
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r0 = 0
            goto L_0x01b1
        L_0x01b0:
            r0 = 1
        L_0x01b1:
            com.google.android.exoplayer2.util.Assertions.g(r0)
            r13 = r24
            r0 = r25
            goto L_0x0181
        L_0x01b9:
            r25 = r0
            r0 = 14
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r19 = 0
            r0[r19] = r13
            r13 = 1
            r0[r13] = r22
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r13 = 2
            r0[r13] = r12
            r12 = 3
            r0[r12] = r23
            r16 = 4
            r0[r16] = r2
            r2 = 5
            r0[r2] = r8
            r2 = 6
            r0[r2] = r4
            r2 = 7
            r0[r2] = r5
            r2 = 8
            r0[r2] = r9
            r2 = 9
            r0[r2] = r6
            r2 = 10
            r0[r2] = r14
            r2 = 11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0[r2] = r4
            r2 = 12
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)
            r0[r2] = r4
            r2 = 13
            java.lang.String r4 = h(r11)
            r0[r2] = r4
            java.lang.String r2 = "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>"
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.C(r2, r0)
            r1.append(r0)
            r0 = 1
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r4 = 0
            r2[r4] = r7
            java.lang.String r5 = "<span class='%s'>"
            java.lang.String r2 = com.google.android.exoplayer2.util.Util.C(r5, r2)
            r1.append(r2)
            android.text.Layout$Alignment r2 = r11.f27204d
            java.lang.String r5 = "</span>"
            if (r2 == 0) goto L_0x023f
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.String r0 = c(r2)
            r6[r4] = r0
            java.lang.String r0 = "<span style='display:inline-block; text-align:%s;'>"
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.C(r0, r6)
            r1.append(r0)
            r0 = r25
            java.lang.String r0 = r0.f28078a
            r1.append(r0)
            r1.append(r5)
            goto L_0x0246
        L_0x023f:
            r0 = r25
            java.lang.String r0 = r0.f28078a
            r1.append(r0)
        L_0x0246:
            r1.append(r5)
            java.lang.String r0 = "</div>"
            r1.append(r0)
            int r10 = r10 + 1
            r2 = 4
            r4 = 1067030938(0x3f99999a, float:1.2)
            r5 = 0
            r8 = 2
            r9 = 3
            r0 = r26
            r6 = 1
            goto L_0x005d
        L_0x025c:
            java.lang.String r0 = "</div></body></html>"
            r1.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "<html><head><style>"
            r0.append(r2)
            java.util.Set r2 = r3.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0273:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0296
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            java.lang.String r5 = "{"
            r0.append(r5)
            java.lang.Object r4 = r3.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            java.lang.String r4 = "}"
            r0.append(r4)
            goto L_0x0273
        L_0x0296:
            java.lang.String r2 = "</style></head>"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            r1.insert(r2, r0)
            r0 = r26
            android.webkit.WebView r2 = r0.f28278c
            java.lang.String r1 = r1.toString()
            java.nio.charset.Charset r3 = com.google.common.base.Charsets.UTF_8
            byte[] r1 = r1.getBytes(r3)
            r3 = 1
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "base64"
            r2.loadData(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.WebViewSubtitleOutput.i():void");
    }

    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.f28280e = captionStyleCompat;
        this.f28281f = f2;
        this.f28282g = i2;
        this.f28283h = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Cue cue = list.get(i3);
            if (cue.f27205e != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.f28279d.isEmpty() || !arrayList2.isEmpty()) {
            this.f28279d = arrayList2;
            i();
        }
        this.f28277b.a(arrayList, captionStyleCompat, f2, i2, f3);
        invalidate();
    }

    public void g() {
        this.f28278c.destroy();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2 && !this.f28279d.isEmpty()) {
            i();
        }
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28279d = Collections.emptyList();
        this.f28280e = CaptionStyleCompat.f27844g;
        this.f28281f = 0.0533f;
        this.f28282g = 0;
        this.f28283h = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f28277b = canvasSubtitleOutput;
        AnonymousClass1 r2 = new WebView(this, context, attributeSet) {
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.f28278c = r2;
        r2.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(r2);
    }
}
