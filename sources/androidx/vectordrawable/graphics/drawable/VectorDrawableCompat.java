package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: l  reason: collision with root package name */
    static final PorterDuff.Mode f11857l = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private VectorDrawableCompatState f11858c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f11859d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f11860e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11861f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11862g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable.ConstantState f11863h;

    /* renamed from: i  reason: collision with root package name */
    private final float[] f11864i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f11865j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f11866k;

    private static class VClipPath extends VPath {
        VClipPath() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11893b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f11892a = PathParser.d(string2);
            }
            this.f11894c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.r(xmlPullParser, "pathData")) {
                TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f11832d);
                f(s2, xmlPullParser);
                s2.recycle();
            }
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    private static abstract class VObject {
        private VObject() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f11913a;

        /* renamed from: b  reason: collision with root package name */
        VPathRenderer f11914b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f11915c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f11916d;

        /* renamed from: e  reason: collision with root package name */
        boolean f11917e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f11918f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f11919g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f11920h;

        /* renamed from: i  reason: collision with root package name */
        int f11921i;

        /* renamed from: j  reason: collision with root package name */
        boolean f11922j;

        /* renamed from: k  reason: collision with root package name */
        boolean f11923k;

        /* renamed from: l  reason: collision with root package name */
        Paint f11924l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f11915c = null;
            this.f11916d = VectorDrawableCompat.f11857l;
            if (vectorDrawableCompatState != null) {
                this.f11913a = vectorDrawableCompatState.f11913a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f11914b);
                this.f11914b = vPathRenderer;
                if (vectorDrawableCompatState.f11914b.f11901e != null) {
                    vPathRenderer.f11901e = new Paint(vectorDrawableCompatState.f11914b.f11901e);
                }
                if (vectorDrawableCompatState.f11914b.f11900d != null) {
                    this.f11914b.f11900d = new Paint(vectorDrawableCompatState.f11914b.f11900d);
                }
                this.f11915c = vectorDrawableCompatState.f11915c;
                this.f11916d = vectorDrawableCompatState.f11916d;
                this.f11917e = vectorDrawableCompatState.f11917e;
            }
        }

        public boolean a(int i2, int i3) {
            if (i2 == this.f11918f.getWidth() && i3 == this.f11918f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f11923k && this.f11919g == this.f11915c && this.f11920h == this.f11916d && this.f11922j == this.f11917e && this.f11921i == this.f11914b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i2, int i3) {
            if (this.f11918f == null || !a(i2, i3)) {
                this.f11918f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f11923k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f11918f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f11924l == null) {
                Paint paint = new Paint();
                this.f11924l = paint;
                paint.setFilterBitmap(true);
            }
            this.f11924l.setAlpha(this.f11914b.getRootAlpha());
            this.f11924l.setColorFilter(colorFilter);
            return this.f11924l;
        }

        public boolean f() {
            return this.f11914b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f11914b.f();
        }

        public int getChangingConfigurations() {
            return this.f11913a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f11914b.g(iArr);
            this.f11923k |= g2;
            return g2;
        }

        public void i() {
            this.f11919g = this.f11915c;
            this.f11920h = this.f11916d;
            this.f11921i = this.f11914b.getRootAlpha();
            this.f11922j = this.f11917e;
            this.f11923k = false;
        }

        public void j(int i2, int i3) {
            this.f11918f.eraseColor(0);
            this.f11914b.b(new Canvas(this.f11918f), i2, i3, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f11915c = null;
            this.f11916d = VectorDrawableCompat.f11857l;
            this.f11914b = new VPathRenderer();
        }
    }

    VectorDrawableCompat() {
        this.f11862g = true;
        this.f11864i = new float[9];
        this.f11865j = new Matrix();
        this.f11866k = new Rect();
        this.f11858c = new VectorDrawableCompatState();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.e(r6, r7, r8)
            r0.f11856b = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
            android.graphics.drawable.Drawable r7 = r0.f11856b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f11863h = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f11914b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f11904h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.g(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11880b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f11912p.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f11913a = vFullPath.f11895d | vectorDrawableCompatState.f11913a;
                    z2 = false;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.e(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11880b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f11912p.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f11913a = vClipPath.f11895d | vectorDrawableCompatState.f11913a;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f11880b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f11912p.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f11913a = vGroup2.f11889k | vectorDrawableCompatState.f11913a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        if (!isAutoMirrored() || DrawableCompat.f(this) != 1) {
            return false;
        }
        return true;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f11914b;
        vectorDrawableCompatState.f11916d = g(TypedArrayUtils.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g2 = TypedArrayUtils.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g2 != null) {
            vectorDrawableCompatState.f11915c = g2;
        }
        vectorDrawableCompatState.f11917e = TypedArrayUtils.e(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f11917e);
        vPathRenderer.f11907k = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f11907k);
        float j2 = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f11908l);
        vPathRenderer.f11908l = j2;
        if (vPathRenderer.f11907k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (j2 > 0.0f) {
            vPathRenderer.f11905i = typedArray.getDimension(3, vPathRenderer.f11905i);
            float dimension = typedArray.getDimension(2, vPathRenderer.f11906j);
            vPathRenderer.f11906j = dimension;
            if (vPathRenderer.f11905i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.j(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.f11910n = string;
                    vPathRenderer.f11912p.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f11856b;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f11858c.f11914b.f11912p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f11866k);
        if (this.f11866k.width() > 0 && this.f11866k.height() > 0) {
            ColorFilter colorFilter = this.f11860e;
            if (colorFilter == null) {
                colorFilter = this.f11859d;
            }
            canvas.getMatrix(this.f11865j);
            this.f11865j.getValues(this.f11864i);
            float abs = Math.abs(this.f11864i[0]);
            float abs2 = Math.abs(this.f11864i[4]);
            float abs3 = Math.abs(this.f11864i[1]);
            float abs4 = Math.abs(this.f11864i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f11866k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f11866k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f11866k;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f11866k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f11866k.offsetTo(0, 0);
                this.f11858c.c(min, min2);
                if (!this.f11862g) {
                    this.f11858c.j(min, min2);
                } else if (!this.f11858c.b()) {
                    this.f11858c.j(min, min2);
                    this.f11858c.i();
                }
                this.f11858c.d(canvas, colorFilter, this.f11866k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.d(drawable);
        }
        return this.f11858c.f11914b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11858c.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.e(drawable);
        }
        return this.f11860e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f11856b != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.f11856b.getConstantState());
        }
        this.f11858c.f11913a = getChangingConfigurations();
        return this.f11858c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f11858c.f11914b.f11906j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f11858c.f11914b.f11905i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z2) {
        this.f11862g = z2;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.h(drawable);
        }
        return this.f11858c.f11917e;
    }

    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful() || ((vectorDrawableCompatState = this.f11858c) != null && (vectorDrawableCompatState.g() || ((colorStateList = this.f11858c.f11915c) != null && colorStateList.isStateful())))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f11861f && super.mutate() == this) {
            this.f11858c = new VectorDrawableCompatState(this.f11858c);
            this.f11861f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        ColorStateList colorStateList = vectorDrawableCompatState.f11915c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.f11916d) == null) {
            z2 = false;
        } else {
            this.f11859d = j(this.f11859d, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!vectorDrawableCompatState.g() || !vectorDrawableCompatState.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f11858c.f11914b.getRootAlpha() != i2) {
            this.f11858c.f11914b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.j(drawable, z2);
        } else {
            this.f11858c.f11917e = z2;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        if (vectorDrawableCompatState.f11915c != colorStateList) {
            vectorDrawableCompatState.f11915c = colorStateList;
            this.f11859d = j(this.f11859d, colorStateList, vectorDrawableCompatState.f11916d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        if (vectorDrawableCompatState.f11916d != mode) {
            vectorDrawableCompatState.f11916d = mode;
            this.f11859d = j(this.f11859d, vectorDrawableCompatState.f11915c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        return super.setVisible(z2, z3);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f11925a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f11925a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f11925a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f11925a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f11856b = (VectorDrawable) this.f11925a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f11856b = (VectorDrawable) this.f11925a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f11856b = (VectorDrawable) this.f11925a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f11860e = colorFilter;
        invalidateSelf();
    }

    private static abstract class VPath extends VObject {

        /* renamed from: a  reason: collision with root package name */
        protected PathParser.PathDataNode[] f11892a = null;

        /* renamed from: b  reason: collision with root package name */
        String f11893b;

        /* renamed from: c  reason: collision with root package name */
        int f11894c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f11895d;

        public VPath() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f11892a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.e(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f11892a;
        }

        public String getPathName() {
            return this.f11893b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.b(this.f11892a, pathDataNodeArr)) {
                this.f11892a = PathParser.f(pathDataNodeArr);
            } else {
                PathParser.j(this.f11892a, pathDataNodeArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f11893b = vPath.f11893b;
            this.f11895d = vPath.f11895d;
            this.f11892a = PathParser.f(vPath.f11892a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f11858c;
        vectorDrawableCompatState.f11914b = new VPathRenderer();
        TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f11829a);
        i(s2, xmlPullParser, theme);
        s2.recycle();
        vectorDrawableCompatState.f11913a = getChangingConfigurations();
        vectorDrawableCompatState.f11923k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f11859d = j(this.f11859d, vectorDrawableCompatState.f11915c, vectorDrawableCompatState.f11916d);
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f11862g = true;
        this.f11864i = new float[9];
        this.f11865j = new Matrix();
        this.f11866k = new Rect();
        this.f11858c = vectorDrawableCompatState;
        this.f11859d = j(this.f11859d, vectorDrawableCompatState.f11915c, vectorDrawableCompatState.f11916d);
    }

    private static class VFullPath extends VPath {

        /* renamed from: e  reason: collision with root package name */
        private int[] f11867e;

        /* renamed from: f  reason: collision with root package name */
        ComplexColorCompat f11868f;

        /* renamed from: g  reason: collision with root package name */
        float f11869g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        ComplexColorCompat f11870h;

        /* renamed from: i  reason: collision with root package name */
        float f11871i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f11872j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f11873k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        float f11874l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        float f11875m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f11876n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f11877o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        float f11878p = 4.0f;

        VFullPath() {
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 == 1) {
                return Paint.Cap.ROUND;
            }
            if (i2 != 2) {
                return cap;
            }
            return Paint.Cap.SQUARE;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 == 1) {
                return Paint.Join.ROUND;
            }
            if (i2 != 2) {
                return join;
            }
            return Paint.Join.BEVEL;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f11867e = null;
            if (TypedArrayUtils.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f11893b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f11892a = PathParser.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f11870h = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f11872j = TypedArrayUtils.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f11872j);
                this.f11876n = e(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f11876n);
                this.f11877o = f(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f11877o);
                this.f11878p = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f11878p);
                this.f11868f = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f11871i = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f11871i);
                this.f11869g = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f11869g);
                this.f11874l = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f11874l);
                this.f11875m = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f11875m);
                this.f11873k = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f11873k);
                this.f11894c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 13, this.f11894c);
            }
        }

        public boolean a() {
            return this.f11870h.i() || this.f11868f.i();
        }

        public boolean b(int[] iArr) {
            return this.f11868f.j(iArr) | this.f11870h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f11831c);
            h(s2, xmlPullParser, theme);
            s2.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f11872j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f11870h.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f11871i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f11868f.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f11869g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f11874l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f11875m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f11873k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.f11872j = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.f11870h.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.f11871i = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f11868f.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f11869g = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.f11874l = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.f11875m = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f11873k = f2;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f11867e = vFullPath.f11867e;
            this.f11868f = vFullPath.f11868f;
            this.f11869g = vFullPath.f11869g;
            this.f11871i = vFullPath.f11871i;
            this.f11870h = vFullPath.f11870h;
            this.f11894c = vFullPath.f11894c;
            this.f11872j = vFullPath.f11872j;
            this.f11873k = vFullPath.f11873k;
            this.f11874l = vFullPath.f11874l;
            this.f11875m = vFullPath.f11875m;
            this.f11876n = vFullPath.f11876n;
            this.f11877o = vFullPath.f11877o;
            this.f11878p = vFullPath.f11878p;
        }
    }

    private static class VPathRenderer {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f11896q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f11897a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f11898b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f11899c;

        /* renamed from: d  reason: collision with root package name */
        Paint f11900d;

        /* renamed from: e  reason: collision with root package name */
        Paint f11901e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f11902f;

        /* renamed from: g  reason: collision with root package name */
        private int f11903g;

        /* renamed from: h  reason: collision with root package name */
        final VGroup f11904h;

        /* renamed from: i  reason: collision with root package name */
        float f11905i;

        /* renamed from: j  reason: collision with root package name */
        float f11906j;

        /* renamed from: k  reason: collision with root package name */
        float f11907k;

        /* renamed from: l  reason: collision with root package name */
        float f11908l;

        /* renamed from: m  reason: collision with root package name */
        int f11909m;

        /* renamed from: n  reason: collision with root package name */
        String f11910n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f11911o;

        /* renamed from: p  reason: collision with root package name */
        final ArrayMap<String, Object> f11912p;

        public VPathRenderer() {
            this.f11899c = new Matrix();
            this.f11905i = 0.0f;
            this.f11906j = 0.0f;
            this.f11907k = 0.0f;
            this.f11908l = 0.0f;
            this.f11909m = JfifUtil.MARKER_FIRST_BYTE;
            this.f11910n = null;
            this.f11911o = null;
            this.f11912p = new ArrayMap<>();
            this.f11904h = new VGroup();
            this.f11897a = new Path();
            this.f11898b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            vGroup.f11879a.set(matrix);
            vGroup.f11879a.preConcat(vGroup.f11888j);
            canvas.save();
            for (int i4 = 0; i4 < vGroup.f11880b.size(); i4++) {
                VObject vObject = vGroup.f11880b.get(i4);
                if (vObject instanceof VGroup) {
                    c((VGroup) vObject, vGroup.f11879a, canvas, i2, i3, colorFilter);
                } else if (vObject instanceof VPath) {
                    d(vGroup, (VPath) vObject, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(VGroup vGroup, VPath vPath, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f2 = ((float) i2) / this.f11907k;
            float f3 = ((float) i3) / this.f11908l;
            float min = Math.min(f2, f3);
            Matrix matrix = vGroup.f11879a;
            this.f11899c.set(matrix);
            this.f11899c.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 != 0.0f) {
                vPath.d(this.f11897a);
                Path path = this.f11897a;
                this.f11898b.reset();
                if (vPath.c()) {
                    Path path2 = this.f11898b;
                    if (vPath.f11894c == 0) {
                        fillType2 = Path.FillType.WINDING;
                    } else {
                        fillType2 = Path.FillType.EVEN_ODD;
                    }
                    path2.setFillType(fillType2);
                    this.f11898b.addPath(path, this.f11899c);
                    canvas.clipPath(this.f11898b);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                float f4 = vFullPath.f11873k;
                if (!(f4 == 0.0f && vFullPath.f11874l == 1.0f)) {
                    float f5 = vFullPath.f11875m;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (vFullPath.f11874l + f5) % 1.0f;
                    if (this.f11902f == null) {
                        this.f11902f = new PathMeasure();
                    }
                    this.f11902f.setPath(this.f11897a, false);
                    float length = this.f11902f.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.f11902f.getSegment(f8, length, path, true);
                        this.f11902f.getSegment(0.0f, f9, path, true);
                    } else {
                        this.f11902f.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f11898b.addPath(path, this.f11899c);
                if (vFullPath.f11870h.l()) {
                    ComplexColorCompat complexColorCompat = vFullPath.f11870h;
                    if (this.f11901e == null) {
                        Paint paint = new Paint(1);
                        this.f11901e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f11901e;
                    if (complexColorCompat.h()) {
                        Shader f10 = complexColorCompat.f();
                        f10.setLocalMatrix(this.f11899c);
                        paint2.setShader(f10);
                        paint2.setAlpha(Math.round(vFullPath.f11872j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
                        paint2.setColor(VectorDrawableCompat.a(complexColorCompat.e(), vFullPath.f11872j));
                    }
                    paint2.setColorFilter(colorFilter);
                    Path path3 = this.f11898b;
                    if (vFullPath.f11894c == 0) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    path3.setFillType(fillType);
                    canvas.drawPath(this.f11898b, paint2);
                }
                if (vFullPath.f11868f.l()) {
                    ComplexColorCompat complexColorCompat2 = vFullPath.f11868f;
                    if (this.f11900d == null) {
                        Paint paint3 = new Paint(1);
                        this.f11900d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f11900d;
                    Paint.Join join = vFullPath.f11877o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = vFullPath.f11876n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(vFullPath.f11878p);
                    if (complexColorCompat2.h()) {
                        Shader f11 = complexColorCompat2.f();
                        f11.setLocalMatrix(this.f11899c);
                        paint4.setShader(f11);
                        paint4.setAlpha(Math.round(vFullPath.f11871i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
                        paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.e(), vFullPath.f11871i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(vFullPath.f11869g * min * e2);
                    canvas.drawPath(this.f11898b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f11904h, f11896q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.f11911o == null) {
                this.f11911o = Boolean.valueOf(this.f11904h.a());
            }
            return this.f11911o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f11904h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f11909m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f11909m = i2;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f11899c = new Matrix();
            this.f11905i = 0.0f;
            this.f11906j = 0.0f;
            this.f11907k = 0.0f;
            this.f11908l = 0.0f;
            this.f11909m = JfifUtil.MARKER_FIRST_BYTE;
            this.f11910n = null;
            this.f11911o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f11912p = arrayMap;
            this.f11904h = new VGroup(vPathRenderer.f11904h, arrayMap);
            this.f11897a = new Path(vPathRenderer.f11897a);
            this.f11898b = new Path(vPathRenderer.f11898b);
            this.f11905i = vPathRenderer.f11905i;
            this.f11906j = vPathRenderer.f11906j;
            this.f11907k = vPathRenderer.f11907k;
            this.f11908l = vPathRenderer.f11908l;
            this.f11903g = vPathRenderer.f11903g;
            this.f11909m = vPathRenderer.f11909m;
            this.f11910n = vPathRenderer.f11910n;
            String str = vPathRenderer.f11910n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f11911o = vPathRenderer.f11911o;
        }
    }

    private static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f11879a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<VObject> f11880b;

        /* renamed from: c  reason: collision with root package name */
        float f11881c;

        /* renamed from: d  reason: collision with root package name */
        private float f11882d;

        /* renamed from: e  reason: collision with root package name */
        private float f11883e;

        /* renamed from: f  reason: collision with root package name */
        private float f11884f;

        /* renamed from: g  reason: collision with root package name */
        private float f11885g;

        /* renamed from: h  reason: collision with root package name */
        private float f11886h;

        /* renamed from: i  reason: collision with root package name */
        private float f11887i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f11888j;

        /* renamed from: k  reason: collision with root package name */
        int f11889k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f11890l;

        /* renamed from: m  reason: collision with root package name */
        private String f11891m;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vPath;
            this.f11879a = new Matrix();
            this.f11880b = new ArrayList<>();
            this.f11881c = 0.0f;
            this.f11882d = 0.0f;
            this.f11883e = 0.0f;
            this.f11884f = 1.0f;
            this.f11885g = 1.0f;
            this.f11886h = 0.0f;
            this.f11887i = 0.0f;
            Matrix matrix = new Matrix();
            this.f11888j = matrix;
            this.f11891m = null;
            this.f11881c = vGroup.f11881c;
            this.f11882d = vGroup.f11882d;
            this.f11883e = vGroup.f11883e;
            this.f11884f = vGroup.f11884f;
            this.f11885g = vGroup.f11885g;
            this.f11886h = vGroup.f11886h;
            this.f11887i = vGroup.f11887i;
            this.f11890l = vGroup.f11890l;
            String str = vGroup.f11891m;
            this.f11891m = str;
            this.f11889k = vGroup.f11889k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f11888j);
            ArrayList<VObject> arrayList = vGroup.f11880b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                VObject vObject = arrayList.get(i2);
                if (vObject instanceof VGroup) {
                    this.f11880b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f11880b.add(vPath);
                    String str2 = vPath.f11893b;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        private void d() {
            this.f11888j.reset();
            this.f11888j.postTranslate(-this.f11882d, -this.f11883e);
            this.f11888j.postScale(this.f11884f, this.f11885g);
            this.f11888j.postRotate(this.f11881c, 0.0f, 0.0f);
            this.f11888j.postTranslate(this.f11886h + this.f11882d, this.f11887i + this.f11883e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f11890l = null;
            this.f11881c = TypedArrayUtils.j(typedArray, xmlPullParser, ViewProps.ROTATION, 5, this.f11881c);
            this.f11882d = typedArray.getFloat(1, this.f11882d);
            this.f11883e = typedArray.getFloat(2, this.f11883e);
            this.f11884f = TypedArrayUtils.j(typedArray, xmlPullParser, ViewProps.SCALE_X, 3, this.f11884f);
            this.f11885g = TypedArrayUtils.j(typedArray, xmlPullParser, ViewProps.SCALE_Y, 4, this.f11885g);
            this.f11886h = TypedArrayUtils.j(typedArray, xmlPullParser, ViewProps.TRANSLATE_X, 6, this.f11886h);
            this.f11887i = TypedArrayUtils.j(typedArray, xmlPullParser, ViewProps.TRANSLATE_Y, 7, this.f11887i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11891m = string;
            }
            d();
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f11880b.size(); i2++) {
                if (this.f11880b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f11880b.size(); i2++) {
                z2 |= this.f11880b.get(i2).b(iArr);
            }
            return z2;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f11830b);
            e(s2, xmlPullParser);
            s2.recycle();
        }

        public String getGroupName() {
            return this.f11891m;
        }

        public Matrix getLocalMatrix() {
            return this.f11888j;
        }

        public float getPivotX() {
            return this.f11882d;
        }

        public float getPivotY() {
            return this.f11883e;
        }

        public float getRotation() {
            return this.f11881c;
        }

        public float getScaleX() {
            return this.f11884f;
        }

        public float getScaleY() {
            return this.f11885g;
        }

        public float getTranslateX() {
            return this.f11886h;
        }

        public float getTranslateY() {
            return this.f11887i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f11882d) {
                this.f11882d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f11883e) {
                this.f11883e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f11881c) {
                this.f11881c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f11884f) {
                this.f11884f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f11885g) {
                this.f11885g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f11886h) {
                this.f11886h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f11887i) {
                this.f11887i = f2;
                d();
            }
        }

        public VGroup() {
            super();
            this.f11879a = new Matrix();
            this.f11880b = new ArrayList<>();
            this.f11881c = 0.0f;
            this.f11882d = 0.0f;
            this.f11883e = 0.0f;
            this.f11884f = 1.0f;
            this.f11885g = 1.0f;
            this.f11886h = 0.0f;
            this.f11887i = 0.0f;
            this.f11888j = new Matrix();
            this.f11891m = null;
        }
    }
}
