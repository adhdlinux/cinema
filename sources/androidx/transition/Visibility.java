package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

public abstract class Visibility extends Transition {
    private static final String[] M = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f11816a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11817b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f11818c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11819d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11820e;

        /* renamed from: f  reason: collision with root package name */
        boolean f11821f = false;

        DisappearListener(View view, int i2, boolean z2) {
            this.f11816a = view;
            this.f11817b = i2;
            this.f11818c = (ViewGroup) view.getParent();
            this.f11819d = z2;
            f(true);
        }

        private void e() {
            if (!this.f11821f) {
                ViewUtils.i(this.f11816a, this.f11817b);
                ViewGroup viewGroup = this.f11818c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
        }

        private void f(boolean z2) {
            ViewGroup viewGroup;
            if (this.f11819d && this.f11820e != z2 && (viewGroup = this.f11818c) != null) {
                this.f11820e = z2;
                ViewGroupUtils.b(viewGroup, z2);
            }
        }

        public void a(Transition transition) {
            f(true);
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
            f(false);
        }

        public void d(Transition transition) {
            e();
            transition.O(this);
        }

        public void onAnimationCancel(Animator animator) {
            this.f11821f = true;
        }

        public void onAnimationEnd(Animator animator) {
            e();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f11821f) {
                ViewUtils.i(this.f11816a, this.f11817b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f11821f) {
                ViewUtils.i(this.f11816a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        boolean f11822a;

        /* renamed from: b  reason: collision with root package name */
        boolean f11823b;

        /* renamed from: c  reason: collision with root package name */
        int f11824c;

        /* renamed from: d  reason: collision with root package name */
        int f11825d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f11826e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f11827f;

        VisibilityInfo() {
        }
    }

    private void b0(TransitionValues transitionValues) {
        transitionValues.f11787a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f11788b.getVisibility()));
        transitionValues.f11787a.put("android:visibility:parent", transitionValues.f11788b.getParent());
        int[] iArr = new int[2];
        transitionValues.f11788b.getLocationOnScreen(iArr);
        transitionValues.f11787a.put("android:visibility:screenLocation", iArr);
    }

    private VisibilityInfo c0(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f11822a = false;
        visibilityInfo.f11823b = false;
        if (transitionValues == null || !transitionValues.f11787a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f11824c = -1;
            visibilityInfo.f11826e = null;
        } else {
            visibilityInfo.f11824c = ((Integer) transitionValues.f11787a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f11826e = (ViewGroup) transitionValues.f11787a.get("android:visibility:parent");
        }
        if (transitionValues2 == null || !transitionValues2.f11787a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f11825d = -1;
            visibilityInfo.f11827f = null;
        } else {
            visibilityInfo.f11825d = ((Integer) transitionValues2.f11787a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f11827f = (ViewGroup) transitionValues2.f11787a.get("android:visibility:parent");
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i2 = visibilityInfo.f11824c;
            int i3 = visibilityInfo.f11825d;
            if (i2 == i3 && visibilityInfo.f11826e == visibilityInfo.f11827f) {
                return visibilityInfo;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    visibilityInfo.f11823b = false;
                    visibilityInfo.f11822a = true;
                } else if (i3 == 0) {
                    visibilityInfo.f11823b = true;
                    visibilityInfo.f11822a = true;
                }
            } else if (visibilityInfo.f11827f == null) {
                visibilityInfo.f11823b = false;
                visibilityInfo.f11822a = true;
            } else if (visibilityInfo.f11826e == null) {
                visibilityInfo.f11823b = true;
                visibilityInfo.f11822a = true;
            }
        } else if (transitionValues == null && visibilityInfo.f11825d == 0) {
            visibilityInfo.f11823b = true;
            visibilityInfo.f11822a = true;
        } else if (transitionValues2 == null && visibilityInfo.f11824c == 0) {
            visibilityInfo.f11823b = false;
            visibilityInfo.f11822a = true;
        }
        return visibilityInfo;
    }

    public String[] C() {
        return M;
    }

    public boolean E(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f11787a.containsKey("android:visibility:visibility") != transitionValues.f11787a.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo c02 = c0(transitionValues, transitionValues2);
        if (!c02.f11822a) {
            return false;
        }
        if (c02.f11824c == 0 || c02.f11825d == 0) {
            return true;
        }
        return false;
    }

    public Animator d0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator e0(ViewGroup viewGroup, TransitionValues transitionValues, int i2, TransitionValues transitionValues2, int i3) {
        if ((this.L & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f11788b.getParent();
            if (c0(s(view, false), D(view, false)).f11822a) {
                return null;
            }
        }
        return d0(viewGroup, transitionValues2.f11788b, transitionValues, transitionValues2);
    }

    public void f(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public Animator f0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator g0(android.view.ViewGroup r7, androidx.transition.TransitionValues r8, int r9, androidx.transition.TransitionValues r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.L
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.f11788b
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.f11788b
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0037
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0027
        L_0x0024:
            r9 = r1
            goto L_0x0084
        L_0x0027:
            boolean r2 = r6.f11761x
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.view.View r9 = androidx.transition.TransitionUtils.a(r7, r9, r2)
            goto L_0x003a
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r9 = r2
        L_0x003a:
            r2 = r1
            goto L_0x0084
        L_0x003c:
            if (r9 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            if (r2 != 0) goto L_0x0045
        L_0x0044:
            goto L_0x003a
        L_0x0045:
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.transition.TransitionValues r4 = r6.D(r2, r3)
            androidx.transition.TransitionValues r5 = r6.s(r2, r3)
            androidx.transition.Visibility$VisibilityInfo r4 = r6.c0(r4, r5)
            boolean r4 = r4.f11822a
            if (r4 != 0) goto L_0x0068
            android.view.View r9 = androidx.transition.TransitionUtils.a(r7, r9, r2)
            goto L_0x003a
        L_0x0068:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x0080
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x0080
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r6.f11761x
            if (r2 == 0) goto L_0x0080
            goto L_0x003a
        L_0x0080:
            r9 = r1
            goto L_0x003a
        L_0x0082:
            r9 = r1
            r2 = r9
        L_0x0084:
            r4 = 0
            if (r9 == 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.f11787a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            androidx.transition.ViewGroupOverlayImpl r11 = androidx.transition.ViewGroupUtils.a(r7)
            r11.c(r9)
            android.animation.Animator r7 = r6.f0(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00c3
            r11.d(r9)
            goto L_0x00cb
        L_0x00c3:
            androidx.transition.Visibility$1 r8 = new androidx.transition.Visibility$1
            r8.<init>(r11, r9)
            r7.addListener(r8)
        L_0x00cb:
            return r7
        L_0x00cc:
            if (r2 == 0) goto L_0x00ee
            int r9 = r2.getVisibility()
            androidx.transition.ViewUtils.i(r2, r4)
            android.animation.Animator r7 = r6.f0(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00ea
            androidx.transition.Visibility$DisappearListener r8 = new androidx.transition.Visibility$DisappearListener
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            androidx.transition.AnimatorUtils.a(r7, r8)
            r6.a(r8)
            goto L_0x00ed
        L_0x00ea:
            androidx.transition.ViewUtils.i(r2, r9)
        L_0x00ed:
            return r7
        L_0x00ee:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.g0(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void h0(int i2) {
        if ((i2 & -4) == 0) {
            this.L = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public void i(TransitionValues transitionValues) {
        b0(transitionValues);
    }

    public Animator m(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo c02 = c0(transitionValues, transitionValues2);
        if (!c02.f11822a) {
            return null;
        }
        if (c02.f11826e == null && c02.f11827f == null) {
            return null;
        }
        if (c02.f11823b) {
            return e0(viewGroup, transitionValues, c02.f11824c, transitionValues2, c02.f11825d);
        }
        return g0(viewGroup, transitionValues, c02.f11824c, transitionValues2, c02.f11825d);
    }
}
