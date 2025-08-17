package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> P;
    private static final Property<ViewBounds, PointF> Q;
    private static final Property<ViewBounds, PointF> R;
    private static final Property<View, PointF> S;
    private static final Property<View, PointF> T;
    private static final Property<View, PointF> U;
    private static RectEvaluator V = new RectEvaluator();
    private int[] L = new int[2];
    private boolean M = false;
    private boolean N = false;

    private static class ViewBounds {

        /* renamed from: a  reason: collision with root package name */
        private int f11711a;

        /* renamed from: b  reason: collision with root package name */
        private int f11712b;

        /* renamed from: c  reason: collision with root package name */
        private int f11713c;

        /* renamed from: d  reason: collision with root package name */
        private int f11714d;

        /* renamed from: e  reason: collision with root package name */
        private View f11715e;

        /* renamed from: f  reason: collision with root package name */
        private int f11716f;

        /* renamed from: g  reason: collision with root package name */
        private int f11717g;

        ViewBounds(View view) {
            this.f11715e = view;
        }

        private void b() {
            ViewUtils.g(this.f11715e, this.f11711a, this.f11712b, this.f11713c, this.f11714d);
            this.f11716f = 0;
            this.f11717g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f11713c = Math.round(pointF.x);
            this.f11714d = Math.round(pointF.y);
            int i2 = this.f11717g + 1;
            this.f11717g = i2;
            if (this.f11716f == i2) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f11711a = Math.round(pointF.x);
            this.f11712b = Math.round(pointF.y);
            int i2 = this.f11716f + 1;
            this.f11716f = i2;
            if (i2 == this.f11717g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        P = new Property<Drawable, PointF>(cls, "boundsOrigin") {

            /* renamed from: a  reason: collision with root package name */
            private Rect f11692a = new Rect();

            /* renamed from: a */
            public PointF get(Drawable drawable) {
                drawable.copyBounds(this.f11692a);
                Rect rect = this.f11692a;
                return new PointF((float) rect.left, (float) rect.top);
            }

            /* renamed from: b */
            public void set(Drawable drawable, PointF pointF) {
                drawable.copyBounds(this.f11692a);
                this.f11692a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.f11692a);
            }
        };
        Q = new Property<ViewBounds, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.c(pointF);
            }
        };
        R = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            /* renamed from: b */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.a(pointF);
            }
        };
        S = new Property<View, PointF>(cls, "bottomRight") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        T = new Property<View, PointF>(cls, "topLeft") {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                ViewUtils.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        U = new Property<View, PointF>(cls, ViewProps.POSITION) {
            /* renamed from: a */
            public PointF get(View view) {
                return null;
            }

            /* renamed from: b */
            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    private void b0(TransitionValues transitionValues) {
        View view = transitionValues.f11788b;
        if (ViewCompat.V(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f11787a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f11787a.put("android:changeBounds:parent", transitionValues.f11788b.getParent());
            if (this.N) {
                transitionValues.f11788b.getLocationInWindow(this.L);
                transitionValues.f11787a.put("android:changeBounds:windowX", Integer.valueOf(this.L[0]));
                transitionValues.f11787a.put("android:changeBounds:windowY", Integer.valueOf(this.L[1]));
            }
            if (this.M) {
                transitionValues.f11787a.put("android:changeBounds:clip", ViewCompat.v(view));
            }
        }
    }

    private boolean c0(View view, View view2) {
        if (!this.N) {
            return true;
        }
        TransitionValues s2 = s(view, true);
        if (s2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == s2.f11788b) {
            return true;
        }
        return false;
    }

    public String[] C() {
        return O;
    }

    public void f(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public void i(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public Animator m(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i2;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.f11787a;
        Map<String, Object> map2 = transitionValues4.f11787a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.f11788b;
        if (c0(viewGroup2, viewGroup3)) {
            Rect rect3 = (Rect) transitionValues3.f11787a.get("android:changeBounds:bounds");
            Rect rect4 = (Rect) transitionValues4.f11787a.get("android:changeBounds:bounds");
            int i4 = rect3.left;
            int i5 = rect4.left;
            int i6 = rect3.top;
            int i7 = rect4.top;
            int i8 = rect3.right;
            int i9 = rect4.right;
            int i10 = rect3.bottom;
            int i11 = rect4.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect5 = (Rect) transitionValues3.f11787a.get("android:changeBounds:clip");
            Rect rect6 = (Rect) transitionValues4.f11787a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                if (i4 == i5 && i6 == i7) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect7 = rect6;
            Rect rect8 = rect5;
            if (!this.M) {
                view = view3;
                ViewUtils.g(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animator = ObjectAnimatorUtils.a(view, U, u().a((float) i4, (float) i6, (float) i5, (float) i7));
                    } else {
                        ViewBounds viewBounds = new ViewBounds(view);
                        ObjectAnimator a2 = ObjectAnimatorUtils.a(viewBounds, Q, u().a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = ObjectAnimatorUtils.a(viewBounds, R, u().a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ ViewBounds f11698a;
                            private ViewBounds mViewBounds;

                            {
                                this.f11698a = r2;
                                this.mViewBounds = r2;
                            }
                        });
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    animator = ObjectAnimatorUtils.a(view, S, u().a((float) i8, (float) i10, (float) i9, (float) i11));
                } else {
                    animator = ObjectAnimatorUtils.a(view, T, u().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
            } else {
                view = view3;
                ViewUtils.g(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = ObjectAnimatorUtils.a(view, U, u().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect8 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect8;
                }
                if (rect7 == null) {
                    rect2 = new Rect(i3, i3, i14, i15);
                } else {
                    rect2 = rect7;
                }
                if (!rect.equals(rect2)) {
                    ViewCompat.y0(view, rect);
                    RectEvaluator rectEvaluator = V;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect2;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect7;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i9;
                    final int i19 = i11;
                    ofObject.addListener(new AnimatorListenerAdapter() {

                        /* renamed from: a  reason: collision with root package name */
                        private boolean f11700a;

                        public void onAnimationCancel(Animator animator) {
                            this.f11700a = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.f11700a) {
                                ViewCompat.y0(view4, rect9);
                                ViewUtils.g(view4, i16, i17, i18, i19);
                            }
                        }
                    });
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = TransitionUtils.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.b(viewGroup4, true);
                a(new TransitionListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f11708a = false;

                    public void a(Transition transition) {
                        ViewGroupUtils.b(viewGroup4, true);
                    }

                    public void c(Transition transition) {
                        ViewGroupUtils.b(viewGroup4, false);
                    }

                    public void d(Transition transition) {
                        if (!this.f11708a) {
                            ViewGroupUtils.b(viewGroup4, false);
                        }
                        transition.O(this);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.f11787a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues3.f11787a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues4.f11787a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues4.f11787a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.L);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float d2 = ViewUtils.d(view2);
        ViewUtils.h(view2, 0.0f);
        ViewUtils.c(viewGroup).a(bitmapDrawable);
        PathMotion u2 = u();
        int[] iArr = this.L;
        int i20 = iArr[0];
        int i21 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{PropertyValuesHolderUtils.a(P, u2.a((float) (intValue - i20), (float) (intValue2 - i21), (float) (intValue3 - i20), (float) (intValue4 - i21)))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = d2;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewUtils.c(viewGroup5).b(bitmapDrawable2);
                ViewUtils.h(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }
}
