package com.github.rubensousa.previewseekbar.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.github.rubensousa.previewseekbar.PreviewBar;
import com.github.rubensousa.previewseekbar.R$drawable;
import com.github.rubensousa.previewseekbar.R$id;

public class PreviewMorphAnimator implements PreviewAnimator {

    /* renamed from: a  reason: collision with root package name */
    private long f22212a;

    /* renamed from: b  reason: collision with root package name */
    private long f22213b;

    /* renamed from: c  reason: collision with root package name */
    private long f22214c;

    /* renamed from: d  reason: collision with root package name */
    private long f22215d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f22216e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f22217f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f22218g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f22219h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f22220i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f22221j;

    /* renamed from: k  reason: collision with root package name */
    private Animator f22222k;

    /* renamed from: l  reason: collision with root package name */
    private ValueAnimator f22223l;

    public PreviewMorphAnimator() {
        this(100, 125, 125, 100);
    }

    /* access modifiers changed from: private */
    public void A(FrameLayout frameLayout, PreviewBar previewBar, View view, final View view2) {
        this.f22219h = true;
        view.setVisibility(4);
        frameLayout.setVisibility(4);
        view2.setVisibility(0);
        m(view2, t(previewBar, v(previewBar)), this.f22214c);
        view2.animate().y(u(previewBar)).scaleY(0.0f).scaleX(0.0f).setDuration(this.f22214c).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = PreviewMorphAnimator.this.f22219h = false;
                boolean unused2 = PreviewMorphAnimator.this.f22217f = false;
                view2.setVisibility(4);
            }
        }).start();
    }

    private void B(FrameLayout frameLayout, PreviewBar previewBar, View view, View view2) {
        this.f22221j = true;
        long j2 = this.f22215d;
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(frameLayout, o(frameLayout), p(frameLayout), y(frameLayout), ((float) frameLayout.getHeight()) / 2.0f);
        this.f22222k = createCircularReveal;
        createCircularReveal.setDuration(j2);
        this.f22222k.setInterpolator(new AccelerateInterpolator());
        this.f22222k.setTarget(frameLayout);
        final FrameLayout frameLayout2 = frameLayout;
        final PreviewBar previewBar2 = previewBar;
        final View view3 = view;
        final View view4 = view2;
        this.f22222k.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = PreviewMorphAnimator.this.f22221j = false;
                PreviewMorphAnimator.this.A(frameLayout2, previewBar2, view3, view4);
            }
        });
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(this.f22215d / 2).setInterpolator(new AccelerateInterpolator()).start();
        this.f22222k.start();
    }

    private void C(final FrameLayout frameLayout, PreviewBar previewBar, final View view, final View view2) {
        this.f22218g = true;
        float s2 = s(frameLayout, view2);
        view.setVisibility(4);
        frameLayout.setVisibility(4);
        view2.setVisibility(0);
        m(view2, q(frameLayout, previewBar), this.f22212a);
        view2.animate().y(r(frameLayout, view2)).scaleY(s2).scaleX(s2).setDuration(this.f22212a).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = PreviewMorphAnimator.this.f22218g = false;
                view.setAlpha(1.0f);
                if (frameLayout.isAttachedToWindow()) {
                    PreviewMorphAnimator.this.z(frameLayout, view, view2);
                }
            }
        }).start();
    }

    private void D(PreviewBar previewBar, View view, View view2) {
        int scrubberColor = previewBar.getScrubberColor();
        if (view.getBackgroundTintList() == null || view.getBackgroundTintList().getDefaultColor() != scrubberColor) {
            Drawable r2 = DrawableCompat.r(view.getBackground());
            DrawableCompat.n(r2, scrubberColor);
            view.setBackground(r2);
            view2.setBackgroundColor(scrubberColor);
        }
    }

    private void m(final View view, float f2, long j2) {
        ValueAnimator valueAnimator = this.f22223l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f22223l.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{view.getX(), f2});
        this.f22223l = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f22223l.setDuration(j2);
        this.f22223l.setInterpolator(new AccelerateInterpolator());
        this.f22223l.start();
    }

    private void n(FrameLayout frameLayout, View view, View view2) {
        Animator animator = this.f22222k;
        if (animator != null) {
            animator.removeAllListeners();
            this.f22222k.cancel();
            this.f22222k = null;
        }
        ValueAnimator valueAnimator = this.f22223l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f22223l.cancel();
            this.f22223l = null;
        }
        frameLayout.animate().setListener((Animator.AnimatorListener) null);
        frameLayout.animate().cancel();
        view.animate().setListener((Animator.AnimatorListener) null);
        view.animate().cancel();
        view2.animate().setListener((Animator.AnimatorListener) null);
        view2.animate().cancel();
    }

    private int o(View view) {
        return view.getWidth() / 2;
    }

    private int p(View view) {
        return view.getHeight() / 2;
    }

    private float q(FrameLayout frameLayout, PreviewBar previewBar) {
        return (frameLayout.getX() + (((float) frameLayout.getWidth()) / 2.0f)) - (((float) previewBar.getThumbOffset()) / 2.0f);
    }

    private float r(FrameLayout frameLayout, View view) {
        return ((float) ((int) (frameLayout.getY() + (((float) frameLayout.getHeight()) / 2.0f)))) - (((float) view.getHeight()) / 2.0f);
    }

    private float s(FrameLayout frameLayout, View view) {
        return (float) (frameLayout.getHeight() / view.getLayoutParams().height);
    }

    private float t(PreviewBar previewBar, float f2) {
        float thumbOffset = (float) previewBar.getThumbOffset();
        View view = (View) previewBar;
        float left = ((float) view.getLeft()) + thumbOffset;
        return (left + (((((float) view.getRight()) - thumbOffset) - left) * f2)) - (thumbOffset / 2.0f);
    }

    private float u(PreviewBar previewBar) {
        return ((View) previewBar).getY() + ((float) previewBar.getThumbOffset());
    }

    private float v(PreviewBar previewBar) {
        if (previewBar.getMax() == 0) {
            return 0.0f;
        }
        return ((float) previewBar.getProgress()) / ((float) previewBar.getMax());
    }

    private View w(FrameLayout frameLayout, PreviewBar previewBar) {
        ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
        int i2 = R$id.previewSeekBarMorphViewId;
        View findViewById = viewGroup.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        View view = new View(frameLayout.getContext());
        view.setVisibility(4);
        view.setBackgroundResource(R$drawable.previewseekbar_morph);
        view.setId(i2);
        viewGroup.addView(view, new ViewGroup.LayoutParams(previewBar.getThumbOffset(), previewBar.getThumbOffset()));
        return view;
    }

    private View x(FrameLayout frameLayout) {
        int i2 = R$id.previewSeekBarOverlayViewId;
        View findViewById = frameLayout.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        View view = new View(frameLayout.getContext());
        view.setVisibility(4);
        view.setId(i2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return view;
    }

    private float y(View view) {
        return (float) Math.hypot((double) (((float) view.getWidth()) / 2.0f), (double) (((float) view.getHeight()) / 2.0f));
    }

    /* access modifiers changed from: private */
    public void z(FrameLayout frameLayout, final View view, View view2) {
        this.f22220i = true;
        float y2 = y(frameLayout);
        long j2 = this.f22213b;
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(frameLayout, o(frameLayout), p(frameLayout), ((float) frameLayout.getHeight()) / 2.0f, y2);
        this.f22222k = createCircularReveal;
        createCircularReveal.setTarget(frameLayout);
        this.f22222k.setInterpolator(new AccelerateInterpolator());
        this.f22222k.setDuration(j2);
        this.f22222k.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = PreviewMorphAnimator.this.f22220i = false;
                boolean unused2 = PreviewMorphAnimator.this.f22216e = false;
                view.setAlpha(0.0f);
                view.setVisibility(4);
            }
        });
        this.f22222k.start();
        frameLayout.setVisibility(0);
        view.setVisibility(0);
        view2.setVisibility(4);
        view.animate().alpha(0.0f).setDuration(this.f22213b / 2);
    }

    public void a(FrameLayout frameLayout, PreviewBar previewBar) {
        if (!this.f22217f) {
            this.f22216e = false;
            this.f22217f = true;
            View w2 = w(frameLayout, previewBar);
            View x2 = x(frameLayout);
            n(frameLayout, x2, w2);
            if (this.f22218g) {
                this.f22218g = false;
                A(frameLayout, previewBar, x2, w2);
            } else if (this.f22220i) {
                this.f22220i = false;
                A(frameLayout, previewBar, x2, w2);
            } else {
                D(previewBar, w2, x2);
                x2.setVisibility(0);
                frameLayout.setVisibility(0);
                float s2 = s(frameLayout, w2);
                w2.setX(q(frameLayout, previewBar));
                w2.setY(r(frameLayout, w2));
                w2.setScaleX(s2);
                w2.setScaleY(s2);
                w2.setVisibility(4);
                if (frameLayout.isAttachedToWindow()) {
                    B(frameLayout, previewBar, x2, w2);
                }
            }
        }
    }

    public void b(FrameLayout frameLayout, PreviewBar previewBar) {
        View x2 = x(frameLayout);
        View w2 = w(frameLayout, previewBar);
        x2.setVisibility(4);
        w2.setVisibility(4);
        n(frameLayout, x2, w2);
    }

    public void c(FrameLayout frameLayout, PreviewBar previewBar) {
        float f2;
        if (this.f22219h || this.f22218g) {
            View w2 = w(frameLayout, previewBar);
            if (this.f22218g) {
                f2 = q(frameLayout, previewBar);
            } else {
                f2 = t(previewBar, v(previewBar));
            }
            ValueAnimator valueAnimator = this.f22223l;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f22223l.cancel();
            }
            w2.setX(f2);
        }
    }

    public void d(FrameLayout frameLayout, PreviewBar previewBar) {
        if (previewBar.getMax() != 0 && !this.f22216e) {
            this.f22217f = false;
            this.f22216e = true;
            View x2 = x(frameLayout);
            View w2 = w(frameLayout, previewBar);
            n(frameLayout, x2, w2);
            if (this.f22219h || this.f22221j) {
                this.f22219h = false;
                this.f22221j = false;
                z(frameLayout, x2, w2);
                return;
            }
            D(previewBar, w2, x2);
            w2.setY(u(previewBar));
            w2.setX(t(previewBar, v(previewBar)));
            w2.setScaleX(0.0f);
            w2.setScaleY(0.0f);
            w2.setAlpha(1.0f);
            C(frameLayout, previewBar, x2, w2);
        }
    }

    public PreviewMorphAnimator(long j2, long j3, long j4, long j5) {
        this.f22212a = j2;
        this.f22213b = j3;
        this.f22215d = j4;
        this.f22214c = j5;
    }
}
