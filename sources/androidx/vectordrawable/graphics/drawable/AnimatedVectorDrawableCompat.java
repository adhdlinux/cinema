package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    private AnimatedVectorDrawableCompatState f11841c;

    /* renamed from: d  reason: collision with root package name */
    private Context f11842d;

    /* renamed from: e  reason: collision with root package name */
    private ArgbEvaluator f11843e;

    /* renamed from: f  reason: collision with root package name */
    private Animator.AnimatorListener f11844f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Animatable2Compat$AnimationCallback> f11845g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable.Callback f11846h;

    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f11848a;

        /* renamed from: b  reason: collision with root package name */
        VectorDrawableCompat f11849b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f11850c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f11851d;

        /* renamed from: e  reason: collision with root package name */
        ArrayMap<Animator, String> f11852e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f11848a = animatedVectorDrawableCompatState.f11848a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.f11849b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f11849b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f11849b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f11849b.mutate();
                    this.f11849b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f11849b.setBounds(animatedVectorDrawableCompatState.f11849b.getBounds());
                    this.f11849b.h(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.f11851d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f11851d = new ArrayList<>(size);
                    this.f11852e = new ArrayMap<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = animatedVectorDrawableCompatState.f11851d.get(i2);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.f11852e.get(animator);
                        clone.setTarget(this.f11849b.d(str));
                        this.f11851d.add(clone);
                        this.f11852e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f11850c == null) {
                this.f11850c = new AnimatorSet();
            }
            this.f11850c.playTogether(this.f11851d);
        }

        public int getChangingConfigurations() {
            return this.f11848a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this((Context) null, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public static AnimatedVectorDrawableCompat a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f11841c.f11849b.d(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.f11841c;
        if (animatedVectorDrawableCompatState.f11851d == null) {
            animatedVectorDrawableCompatState.f11851d = new ArrayList<>();
            this.f11841c.f11852e = new ArrayMap<>();
        }
        this.f11841c.f11851d.add(animator);
        this.f11841c.f11852e.put(animator, str);
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f11841c.f11849b.draw(canvas);
        if (this.f11841c.f11850c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.d(drawable);
        }
        return this.f11841c.f11849b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11841c.f11848a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.e(drawable);
        }
        return this.f11841c.f11849b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f11856b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.f11856b.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f11841c.f11849b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f11841c.f11849b.getIntrinsicWidth();
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
        return this.f11841c.f11849b.getOpacity();
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

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f11833e);
                    int resourceId = s2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat b2 = VectorDrawableCompat.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.f11846h);
                        VectorDrawableCompat vectorDrawableCompat = this.f11841c.f11849b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.f11841c.f11849b = b2;
                    }
                    s2.recycle();
                } else if (TouchesHelper.TARGET_KEY.equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f11834f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f11842d;
                        if (context != null) {
                            b(string, AnimatorInflaterCompat.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f11841c.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return DrawableCompat.h(drawable);
        }
        return this.f11841c.f11849b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f11841c.f11850c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f11841c.f11849b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f11841c.f11849b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        return this.f11841c.f11849b.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f11841c.f11849b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f11841c.f11849b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.j(drawable, z2);
        } else {
            this.f11841c.f11849b.setAutoMirrored(z2);
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
            this.f11841c.f11849b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        } else {
            this.f11841c.f11849b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        } else {
            this.f11841c.f11849b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f11841c.f11849b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    public void start() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f11841c.f11850c.isStarted()) {
            this.f11841c.f11850c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f11841c.f11850c.end();
        }
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f11856b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f11841c.f11849b.setColorFilter(colorFilter);
        }
    }

    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f11853a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f11853a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f11853a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f11853a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f11853a.newDrawable();
            animatedVectorDrawableCompat.f11856b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f11846h);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f11853a.newDrawable(resources);
            animatedVectorDrawableCompat.f11856b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f11846h);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f11853a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f11856b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f11846h);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.f11843e = null;
        this.f11844f = null;
        this.f11845g = null;
        AnonymousClass1 r02 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f11846h = r02;
        this.f11842d = context;
        if (animatedVectorDrawableCompatState != null) {
            this.f11841c = animatedVectorDrawableCompatState;
        } else {
            this.f11841c = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, r02, resources);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
