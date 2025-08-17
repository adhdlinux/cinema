package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api18Impl;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {

    /* renamed from: p  reason: collision with root package name */
    private AnimatedStateListState f575p;

    /* renamed from: q  reason: collision with root package name */
    private Transition f576q;

    /* renamed from: r  reason: collision with root package name */
    private int f577r;

    /* renamed from: s  reason: collision with root package name */
    private int f578s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f579t;

    private static class AnimatableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f580a;

        AnimatableTransition(Animatable animatable) {
            super();
            this.f580a = animatable;
        }

        public void c() {
            this.f580a.start();
        }

        public void d() {
            this.f580a.stop();
        }
    }

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        LongSparseArray<Long> K;
        SparseArrayCompat<Integer> L;

        AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                this.L = animatedStateListState.L;
                return;
            }
            this.K = new LongSparseArray<>();
            this.L = new SparseArrayCompat<>();
        }

        private static long E(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        /* access modifiers changed from: package-private */
        public int C(int[] iArr, Drawable drawable, int i2) {
            int A = super.A(iArr, drawable);
            this.L.i(A, Integer.valueOf(i2));
            return A;
        }

        /* access modifiers changed from: package-private */
        public int D(int i2, int i3, Drawable drawable, boolean z2) {
            long j2;
            int a2 = super.a(drawable);
            long E = E(i2, i3);
            if (z2) {
                j2 = 8589934592L;
            } else {
                j2 = 0;
            }
            long j3 = (long) a2;
            this.K.a(E, Long.valueOf(j3 | j2));
            if (z2) {
                this.K.a(E(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int F(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.f(i2, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int G(int[] iArr) {
            int B = super.B(iArr);
            if (B >= 0) {
                return B;
            }
            return super.B(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int H(int i2, int i3) {
            return (int) this.K.g(E(i2, i3), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean I(int i2, int i3) {
            if ((this.K.g(E(i2, i3), -1L).longValue() & 4294967296L) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean J(int i2, int i3) {
            if ((this.K.g(E(i2, i3), -1L).longValue() & 8589934592L) != 0) {
                return true;
            }
            return false;
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        public void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f581a;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f581a = animatedVectorDrawableCompat;
        }

        public void c() {
            this.f581a.start();
        }

        public void d() {
            this.f581a.stop();
        }
    }

    private static class AnimationDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f582a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f583b;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int i2;
            int i3;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (z2) {
                i2 = numberOfFrames - 1;
            } else {
                i2 = 0;
            }
            if (z2) {
                i3 = 0;
            } else {
                i3 = numberOfFrames - 1;
            }
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z2);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i2, i3});
            Compatibility$Api18Impl.a(ofInt, true);
            ofInt.setDuration((long) frameInterpolator.a());
            ofInt.setInterpolator(frameInterpolator);
            this.f583b = z3;
            this.f582a = ofInt;
        }

        public boolean a() {
            return this.f583b;
        }

        public void b() {
            this.f582a.reverse();
        }

        public void c() {
            this.f582a.start();
        }

        public void d() {
            this.f582a.cancel();
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f584a;

        /* renamed from: b  reason: collision with root package name */
        private int f585b;

        /* renamed from: c  reason: collision with root package name */
        private int f586c;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z2) {
            b(animationDrawable, z2);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f586c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z2) {
            int i2;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f585b = numberOfFrames;
            int[] iArr = this.f584a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f584a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f584a;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames; i4++) {
                if (z2) {
                    i2 = (numberOfFrames - i4) - 1;
                } else {
                    i2 = i4;
                }
                int duration = animationDrawable.getDuration(i2);
                iArr2[i4] = duration;
                i3 += duration;
            }
            this.f586c = i3;
            return i3;
        }

        public float getInterpolation(float f2) {
            float f3;
            int i2 = (int) ((f2 * ((float) this.f586c)) + 0.5f);
            int i3 = this.f585b;
            int[] iArr = this.f584a;
            int i4 = 0;
            while (i4 < i3) {
                int i5 = iArr[i4];
                if (i2 < i5) {
                    break;
                }
                i2 -= i5;
                i4++;
            }
            if (i4 < i3) {
                f3 = ((float) i2) / ((float) this.f586c);
            } else {
                f3 = 0.0f;
            }
            return (((float) i4) / ((float) i3)) + f3;
        }
    }

    private static abstract class Transition {
        private Transition() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this((AnimatedStateListState) null, (Resources) null);
    }

    public static AnimatedStateListDrawableCompat m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.n(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, R$styleable.f651h);
        int resourceId = s2.getResourceId(R$styleable.f652i, 0);
        int resourceId2 = s2.getResourceId(R$styleable.f653j, -1);
        if (resourceId2 > 0) {
            drawable = ResourceManagerInternal.h().j(context, resourceId2);
        } else {
            drawable = null;
        }
        s2.recycle();
        int[] k2 = k(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = VectorDrawableCompat.c(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility$Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            return this.f575p.C(k2, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, R$styleable.f654k);
        int resourceId = s2.getResourceId(R$styleable.f657n, -1);
        int resourceId2 = s2.getResourceId(R$styleable.f656m, -1);
        int resourceId3 = s2.getResourceId(R$styleable.f655l, -1);
        if (resourceId3 > 0) {
            drawable = ResourceManagerInternal.h().j(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z2 = s2.getBoolean(R$styleable.f658o, false);
        s2.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = AnimatedVectorDrawableCompat.a(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility$Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f575p.D(resourceId, resourceId2, drawable, z2);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i2) {
        int i3;
        int H;
        Transition transition;
        Transition transition2 = this.f576q;
        if (transition2 == null) {
            i3 = c();
        } else if (i2 == this.f577r) {
            return true;
        } else {
            if (i2 != this.f578s || !transition2.a()) {
                i3 = this.f577r;
                transition2.d();
            } else {
                transition2.b();
                this.f577r = this.f578s;
                this.f578s = i2;
                return true;
            }
        }
        this.f576q = null;
        this.f578s = -1;
        this.f577r = -1;
        AnimatedStateListState animatedStateListState = this.f575p;
        int F = animatedStateListState.F(i3);
        int F2 = animatedStateListState.F(i2);
        if (F2 == 0 || F == 0 || (H = animatedStateListState.H(F, F2)) < 0) {
            return false;
        }
        boolean J = animatedStateListState.J(F, F2);
        g(H);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            transition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.I(F, F2), J);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                transition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        transition.c();
        this.f576q = transition;
        this.f578s = i3;
        this.f577r = i2;
        return true;
    }

    private void t(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.f575p;
        animatedStateListState.f604d |= Compatibility$Api21Impl.b(typedArray);
        animatedStateListState.y(typedArray.getBoolean(R$styleable.f647d, animatedStateListState.f609i));
        animatedStateListState.u(typedArray.getBoolean(R$styleable.f648e, animatedStateListState.f612l));
        animatedStateListState.v(typedArray.getInt(R$styleable.f649f, animatedStateListState.A));
        animatedStateListState.w(typedArray.getInt(R$styleable.f650g, animatedStateListState.B));
        setDither(typedArray.getBoolean(R$styleable.f645b, animatedStateListState.f624x));
    }

    /* access modifiers changed from: package-private */
    public void h(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.f575p = (AnimatedStateListState) drawableContainerState;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.f576q;
        if (transition != null) {
            transition.d();
            this.f576q = null;
            g(this.f577r);
            this.f577r = -1;
            this.f578s = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public AnimatedStateListState j() {
        return new AnimatedStateListState(this.f575p, this, (Resources) null);
    }

    public Drawable mutate() {
        if (!this.f579t && super.mutate() == this) {
            this.f575p.s();
            this.f579t = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray s2 = TypedArrayUtils.s(resources, theme, attributeSet, R$styleable.f644a);
        setVisible(s2.getBoolean(R$styleable.f646c, true), true);
        t(s2);
        i(resources);
        s2.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        int G = this.f575p.G(iArr);
        if (G == c() || (!s(G) && !g(G))) {
            z2 = false;
        } else {
            z2 = true;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z2 | current.setState(iArr);
        }
        return z2;
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Transition transition = this.f576q;
        if (transition != null && (visible || z3)) {
            if (z2) {
                transition.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super((StateListDrawableCompat.StateListState) null);
        this.f577r = -1;
        this.f578s = -1;
        h(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
