package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3284a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3284a = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3284a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3284a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3284a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.<clinit>():void");
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {

        /* renamed from: c  reason: collision with root package name */
        private boolean f3315c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3316d = false;

        /* renamed from: e  reason: collision with root package name */
        private FragmentAnim.AnimationOrAnimator f3317e;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z2) {
            super(operation, cancellationSignal);
            this.f3315c = z2;
        }

        /* access modifiers changed from: package-private */
        public FragmentAnim.AnimationOrAnimator e(Context context) {
            boolean z2;
            if (this.f3316d) {
                return this.f3317e;
            }
            Fragment f2 = b().f();
            if (b().e() == SpecialEffectsController.Operation.State.VISIBLE) {
                z2 = true;
            } else {
                z2 = false;
            }
            FragmentAnim.AnimationOrAnimator c2 = FragmentAnim.c(context, f2, z2, this.f3315c);
            this.f3317e = c2;
            this.f3316d = true;
            return c2;
        }
    }

    private static class SpecialEffectsInfo {

        /* renamed from: a  reason: collision with root package name */
        private final SpecialEffectsController.Operation f3318a;

        /* renamed from: b  reason: collision with root package name */
        private final CancellationSignal f3319b;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.f3318a = operation;
            this.f3319b = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3318a.d(this.f3319b);
        }

        /* access modifiers changed from: package-private */
        public SpecialEffectsController.Operation b() {
            return this.f3318a;
        }

        /* access modifiers changed from: package-private */
        public CancellationSignal c() {
            return this.f3319b;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State c2 = SpecialEffectsController.Operation.State.c(this.f3318a.f().mView);
            SpecialEffectsController.Operation.State e2 = this.f3318a.e();
            if (c2 == e2 || (c2 != (state = SpecialEffectsController.Operation.State.VISIBLE) && e2 != state)) {
                return true;
            }
            return false;
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {

        /* renamed from: c  reason: collision with root package name */
        private final Object f3320c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3321d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f3322e;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z2, boolean z3) {
            super(operation, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z4;
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z2) {
                    obj2 = operation.f().getReenterTransition();
                } else {
                    obj2 = operation.f().getEnterTransition();
                }
                this.f3320c = obj2;
                if (z2) {
                    z4 = operation.f().getAllowReturnTransitionOverlap();
                } else {
                    z4 = operation.f().getAllowEnterTransitionOverlap();
                }
                this.f3321d = z4;
            } else {
                if (z2) {
                    obj = operation.f().getReturnTransition();
                } else {
                    obj = operation.f().getExitTransition();
                }
                this.f3320c = obj;
                this.f3321d = true;
            }
            if (!z3) {
                this.f3322e = null;
            } else if (z2) {
                this.f3322e = operation.f().getSharedElementReturnTransition();
            } else {
                this.f3322e = operation.f().getSharedElementEnterTransition();
            }
        }

        private FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.f3539b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.f3540c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public FragmentTransitionImpl e() {
            FragmentTransitionImpl f2 = f(this.f3320c);
            FragmentTransitionImpl f3 = f(this.f3322e);
            if (f2 != null && f3 != null && f2 != f3) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f3320c + " which uses a different Transition  type than its shared element transition " + this.f3322e);
            } else if (f2 != null) {
                return f2;
            } else {
                return f3;
            }
        }

        public Object g() {
            return this.f3322e;
        }

        /* access modifiers changed from: package-private */
        public Object h() {
            return this.f3320c;
        }

        public boolean i() {
            return this.f3322e != null;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f3321d;
        }
    }

    DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z2, Map<SpecialEffectsController.Operation, Boolean> map) {
        final boolean z3;
        final ViewGroup m2 = m();
        Context context = m2.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z4 = false;
        for (AnimationInfo next : list) {
            if (next.d()) {
                next.a();
            } else {
                FragmentAnim.AnimationOrAnimator e2 = next.e(context);
                if (e2 == null) {
                    next.a();
                } else {
                    final Animator animator = e2.f3387b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final SpecialEffectsController.Operation b2 = next.b();
                        Fragment f2 = b2.f();
                        if (Boolean.TRUE.equals(map.get(b2))) {
                            if (FragmentManager.G0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f2 + " as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            if (b2.e() == SpecialEffectsController.Operation.State.GONE) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z3) {
                                list3.remove(b2);
                            }
                            final View view = f2.mView;
                            m2.startViewTransition(view);
                            AnonymousClass2 r12 = r0;
                            final ViewGroup viewGroup = m2;
                            final AnimationInfo animationInfo = next;
                            AnonymousClass2 r02 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view);
                                    if (z3) {
                                        b2.e().a(view);
                                    }
                                    animationInfo.a();
                                }
                            };
                            animator.addListener(r12);
                            animator.setTarget(view);
                            animator.start();
                            next.c().c(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z4 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it2.next();
            SpecialEffectsController.Operation b3 = animationInfo2.b();
            Fragment f3 = b3.f();
            if (z2) {
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f3 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.a();
            } else if (z4) {
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f3 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.a();
            } else {
                final View view2 = f3.mView;
                Animation animation = (Animation) Preconditions.g(((FragmentAnim.AnimationOrAnimator) Preconditions.g(animationInfo2.e(context))).f3386a);
                if (b3.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    animationInfo2.a();
                } else {
                    m2.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, m2, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            m2.post(new Runnable() {
                                public void run() {
                                    AnonymousClass4 r02 = AnonymousClass4.this;
                                    m2.endViewTransition(view2);
                                    animationInfo2.a();
                                }
                            });
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.c().c(new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        view2.clearAnimation();
                        m2.endViewTransition(view2);
                        animationInfo2.a();
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x029f, code lost:
        r0 = (android.view.View) r9.get(r11.get(0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> x(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r32, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r33, boolean r34, androidx.fragment.app.SpecialEffectsController.Operation r35, androidx.fragment.app.SpecialEffectsController.Operation r36) {
        /*
            r31 = this;
            r6 = r31
            r7 = r34
            r8 = r35
            r9 = r36
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Iterator r0 = r32.iterator()
            r15 = 0
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r2 = r1.d()
            if (r2 == 0) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            androidx.fragment.app.FragmentTransitionImpl r2 = r1.e()
            if (r15 != 0) goto L_0x002d
            r15 = r2
            goto L_0x0012
        L_0x002d:
            if (r2 == 0) goto L_0x0012
            if (r15 != r2) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r2.append(r3)
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r1.b()
            androidx.fragment.app.Fragment r3 = r3.f()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r1 = r1.h()
            r2.append(r1)
            java.lang.String r1 = " which uses a different Transition  type than other Fragments."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0062:
            if (r15 != 0) goto L_0x0082
            java.util.Iterator r0 = r32.iterator()
        L_0x0068:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r1.b()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r10.put(r2, r3)
            r1.a()
            goto L_0x0068
        L_0x0081:
            return r10
        L_0x0082:
            android.view.View r14 = new android.view.View
            android.view.ViewGroup r0 = r31.m()
            android.content.Context r0 = r0.getContext()
            r14.<init>(r0)
            android.graphics.Rect r13 = new android.graphics.Rect
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r20 = r32.iterator()
            r0 = 0
            r2 = 0
            r21 = 0
        L_0x00ab:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x0308
            java.lang.Object r1 = r20.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r16 = r1.i()
            if (r16 == 0) goto L_0x02eb
            if (r8 == 0) goto L_0x02eb
            if (r9 == 0) goto L_0x02eb
            java.lang.Object r0 = r1.g()
            java.lang.Object r0 = r15.g(r0)
            java.lang.Object r1 = r15.B(r0)
            androidx.fragment.app.Fragment r0 = r36.f()
            java.util.ArrayList r0 = r0.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r16 = r35.f()
            java.util.ArrayList r3 = r16.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r16 = r35.f()
            java.util.ArrayList r11 = r16.getSharedElementTargetNames()
            r16 = r1
            r18 = r2
            r1 = 0
        L_0x00ea:
            int r2 = r11.size()
            if (r1 >= r2) goto L_0x0109
            java.lang.Object r2 = r11.get(r1)
            int r2 = r0.indexOf(r2)
            r19 = r11
            r11 = -1
            if (r2 == r11) goto L_0x0104
            java.lang.Object r11 = r3.get(r1)
            r0.set(r2, r11)
        L_0x0104:
            int r1 = r1 + 1
            r11 = r19
            goto L_0x00ea
        L_0x0109:
            androidx.fragment.app.Fragment r1 = r36.f()
            java.util.ArrayList r11 = r1.getSharedElementTargetNames()
            if (r7 != 0) goto L_0x0124
            androidx.fragment.app.Fragment r1 = r35.f()
            androidx.core.app.SharedElementCallback r1 = r1.getExitTransitionCallback()
            androidx.fragment.app.Fragment r2 = r36.f()
            androidx.core.app.SharedElementCallback r2 = r2.getEnterTransitionCallback()
            goto L_0x0134
        L_0x0124:
            androidx.fragment.app.Fragment r1 = r35.f()
            androidx.core.app.SharedElementCallback r1 = r1.getEnterTransitionCallback()
            androidx.fragment.app.Fragment r2 = r36.f()
            androidx.core.app.SharedElementCallback r2 = r2.getExitTransitionCallback()
        L_0x0134:
            int r3 = r0.size()
            r9 = 0
        L_0x0139:
            if (r9 >= r3) goto L_0x0157
            java.lang.Object r19 = r0.get(r9)
            r23 = r3
            r3 = r19
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r19 = r11.get(r9)
            r8 = r19
            java.lang.String r8 = (java.lang.String) r8
            r4.put(r3, r8)
            int r9 = r9 + 1
            r8 = r35
            r3 = r23
            goto L_0x0139
        L_0x0157:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            androidx.fragment.app.Fragment r3 = r35.f()
            android.view.View r3 = r3.mView
            r6.u(r8, r3)
            r8.r(r0)
            if (r1 == 0) goto L_0x01aa
            r1.d(r0, r8)
            int r1 = r0.size()
            r3 = 1
            int r1 = r1 - r3
        L_0x0173:
            if (r1 < 0) goto L_0x01a7
            java.lang.Object r3 = r0.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r9 = r8.get(r3)
            android.view.View r9 = (android.view.View) r9
            if (r9 != 0) goto L_0x0189
            r4.remove(r3)
            r19 = r0
            goto L_0x01a2
        L_0x0189:
            r19 = r0
            java.lang.String r0 = androidx.core.view.ViewCompat.M(r9)
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x01a2
            java.lang.Object r0 = r4.remove(r3)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = androidx.core.view.ViewCompat.M(r9)
            r4.put(r3, r0)
        L_0x01a2:
            int r1 = r1 + -1
            r0 = r19
            goto L_0x0173
        L_0x01a7:
            r19 = r0
            goto L_0x01b3
        L_0x01aa:
            r19 = r0
            java.util.Set r0 = r8.keySet()
            r4.r(r0)
        L_0x01b3:
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            androidx.fragment.app.Fragment r0 = r36.f()
            android.view.View r0 = r0.mView
            r6.u(r9, r0)
            r9.r(r11)
            java.util.Collection r0 = r4.values()
            r9.r(r0)
            if (r2 == 0) goto L_0x020a
            r2.d(r11, r9)
            int r0 = r11.size()
            r1 = 1
            int r0 = r0 - r1
        L_0x01d6:
            if (r0 < 0) goto L_0x020d
            java.lang.Object r1 = r11.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r9.get(r1)
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x01f0
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.q(r4, r1)
            if (r1 == 0) goto L_0x0207
            r4.remove(r1)
            goto L_0x0207
        L_0x01f0:
            java.lang.String r3 = androidx.core.view.ViewCompat.M(r2)
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0207
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.q(r4, r1)
            if (r1 == 0) goto L_0x0207
            java.lang.String r2 = androidx.core.view.ViewCompat.M(r2)
            r4.put(r1, r2)
        L_0x0207:
            int r0 = r0 + -1
            goto L_0x01d6
        L_0x020a:
            androidx.fragment.app.FragmentTransition.y(r4, r9)
        L_0x020d:
            java.util.Set r0 = r4.keySet()
            r6.v(r8, r0)
            java.util.Collection r0 = r4.values()
            r6.v(r9, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0239
            r12.clear()
            r5.clear()
            r3 = r35
            r26 = r4
            r1 = r5
            r5 = r6
            r4 = r12
            r8 = r13
            r9 = r14
            r11 = r15
            r2 = r18
            r0 = 0
            r6 = 0
            r15 = r36
            goto L_0x02fa
        L_0x0239:
            androidx.fragment.app.Fragment r0 = r36.f()
            androidx.fragment.app.Fragment r1 = r35.f()
            r3 = 1
            androidx.fragment.app.FragmentTransition.f(r0, r1, r7, r8, r3)
            android.view.ViewGroup r2 = r31.m()
            androidx.fragment.app.DefaultSpecialEffectsController$6 r1 = new androidx.fragment.app.DefaultSpecialEffectsController$6
            r22 = r19
            r0 = r1
            r23 = r10
            r7 = r16
            r10 = r1
            r1 = r31
            r16 = r14
            r24 = r18
            r14 = r2
            r2 = r36
            r6 = 0
            r25 = 1
            r3 = r35
            r26 = r4
            r4 = r34
            r27 = r5
            r5 = r9
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.a(r14, r10)
            java.util.Collection r0 = r8.values()
            r12.addAll(r0)
            boolean r0 = r22.isEmpty()
            if (r0 != 0) goto L_0x028e
            r0 = r22
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r8.get(r0)
            android.view.View r0 = (android.view.View) r0
            r15.v(r7, r0)
            r2 = r0
            goto L_0x0290
        L_0x028e:
            r2 = r24
        L_0x0290:
            java.util.Collection r0 = r9.values()
            r1 = r27
            r1.addAll(r0)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x02c0
            java.lang.Object r0 = r11.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.get(r0)
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x02c0
            android.view.ViewGroup r3 = r31.m()
            androidx.fragment.app.DefaultSpecialEffectsController$7 r4 = new androidx.fragment.app.DefaultSpecialEffectsController$7
            r5 = r31
            r4.<init>(r15, r0, r13)
            androidx.core.view.OneShotPreDrawListener.a(r3, r4)
            r0 = r16
            r21 = 1
            goto L_0x02c4
        L_0x02c0:
            r5 = r31
            r0 = r16
        L_0x02c4:
            r15.z(r7, r0, r12)
            r14 = 0
            r3 = 0
            r16 = 0
            r17 = 0
            r4 = r12
            r12 = r15
            r8 = r13
            r13 = r7
            r9 = r0
            r11 = r15
            r15 = r3
            r18 = r7
            r19 = r1
            r12.t(r13, r14, r15, r16, r17, r18, r19)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3 = r35
            r10 = r23
            r10.put(r3, r0)
            r15 = r36
            r10.put(r15, r0)
            r0 = r7
            goto L_0x02fa
        L_0x02eb:
            r24 = r2
            r26 = r4
            r1 = r5
            r5 = r6
            r3 = r8
            r4 = r12
            r8 = r13
            r11 = r15
            r6 = 0
            r15 = r9
            r9 = r14
            r2 = r24
        L_0x02fa:
            r7 = r34
            r12 = r4
            r6 = r5
            r13 = r8
            r14 = r9
            r9 = r15
            r4 = r26
            r5 = r1
            r8 = r3
            r15 = r11
            goto L_0x00ab
        L_0x0308:
            r24 = r2
            r26 = r4
            r1 = r5
            r5 = r6
            r3 = r8
            r4 = r12
            r8 = r13
            r11 = r15
            r6 = 0
            r25 = 1
            r15 = r9
            r9 = r14
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r7 = r32.iterator()
            r13 = 0
            r14 = 0
        L_0x0322:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0448
            java.lang.Object r12 = r7.next()
            r20 = r12
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r20 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r20
            boolean r12 = r20.d()
            if (r12 == 0) goto L_0x0344
            androidx.fragment.app.SpecialEffectsController$Operation r12 = r20.b()
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r10.put(r12, r6)
            r20.a()
            r6 = 0
            goto L_0x0322
        L_0x0344:
            java.lang.Object r6 = r20.h()
            java.lang.Object r6 = r11.g(r6)
            androidx.fragment.app.SpecialEffectsController$Operation r12 = r20.b()
            if (r0 == 0) goto L_0x0359
            if (r12 == r3) goto L_0x0356
            if (r12 != r15) goto L_0x0359
        L_0x0356:
            r16 = 1
            goto L_0x035b
        L_0x0359:
            r16 = 0
        L_0x035b:
            if (r6 != 0) goto L_0x0378
            if (r16 != 0) goto L_0x0367
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r10.put(r12, r6)
            r20.a()
        L_0x0367:
            r12 = r33
            r30 = r1
            r29 = r4
            r34 = r7
            r27 = r9
            r6 = r13
            r1 = r15
            r7 = r24
            r13 = 0
            goto L_0x0439
        L_0x0378:
            r34 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r17 = r13
            androidx.fragment.app.Fragment r13 = r12.f()
            android.view.View r13 = r13.mView
            r5.t(r7, r13)
            if (r16 == 0) goto L_0x0395
            if (r12 != r3) goto L_0x0392
            r7.removeAll(r4)
            goto L_0x0395
        L_0x0392:
            r7.removeAll(r1)
        L_0x0395:
            boolean r13 = r7.isEmpty()
            if (r13 == 0) goto L_0x03ac
            r11.a(r6, r9)
            r30 = r1
            r29 = r4
            r27 = r9
            r13 = r12
            r4 = r14
            r1 = r15
            r9 = r17
            r12 = r33
            goto L_0x0408
        L_0x03ac:
            r11.b(r6, r7)
            r16 = 0
            r18 = 0
            r19 = 0
            r23 = 0
            r13 = r12
            r12 = r11
            r27 = r9
            r28 = r13
            r9 = r17
            r13 = r6
            r29 = r4
            r4 = r14
            r14 = r6
            r30 = r1
            r1 = r15
            r15 = r7
            r17 = r18
            r18 = r19
            r19 = r23
            r12.t(r13, r14, r15, r16, r17, r18, r19)
            androidx.fragment.app.SpecialEffectsController$Operation$State r12 = r28.e()
            androidx.fragment.app.SpecialEffectsController$Operation$State r13 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r12 != r13) goto L_0x0404
            r12 = r33
            r13 = r28
            r12.remove(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r7)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.mView
            r14.remove(r15)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.mView
            r11.r(r6, r15, r14)
            android.view.ViewGroup r14 = r31.m()
            androidx.fragment.app.DefaultSpecialEffectsController$8 r15 = new androidx.fragment.app.DefaultSpecialEffectsController$8
            r15.<init>(r7)
            androidx.core.view.OneShotPreDrawListener.a(r14, r15)
            goto L_0x0408
        L_0x0404:
            r12 = r33
            r13 = r28
        L_0x0408:
            androidx.fragment.app.SpecialEffectsController$Operation$State r14 = r13.e()
            androidx.fragment.app.SpecialEffectsController$Operation$State r15 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r14 != r15) goto L_0x041b
            r2.addAll(r7)
            if (r21 == 0) goto L_0x0418
            r11.u(r6, r8)
        L_0x0418:
            r7 = r24
            goto L_0x0420
        L_0x041b:
            r7 = r24
            r11.v(r6, r7)
        L_0x0420:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r10.put(r13, r14)
            boolean r13 = r20.j()
            if (r13 == 0) goto L_0x0433
            r13 = 0
            java.lang.Object r4 = r11.n(r4, r6, r13)
            r14 = r4
            r6 = r9
            goto L_0x0439
        L_0x0433:
            r13 = 0
            java.lang.Object r6 = r11.n(r9, r6, r13)
            r14 = r4
        L_0x0439:
            r15 = r1
            r13 = r6
            r24 = r7
            r9 = r27
            r4 = r29
            r1 = r30
            r6 = 0
            r7 = r34
            goto L_0x0322
        L_0x0448:
            r30 = r1
            r29 = r4
            r9 = r13
            r4 = r14
            r1 = r15
            java.lang.Object r4 = r11.m(r4, r9, r0)
            java.util.Iterator r6 = r32.iterator()
        L_0x0457:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x04cb
            java.lang.Object r7 = r6.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r7 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r7
            boolean r8 = r7.d()
            if (r8 == 0) goto L_0x046a
            goto L_0x0457
        L_0x046a:
            java.lang.Object r8 = r7.h()
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r7.b()
            if (r0 == 0) goto L_0x047a
            if (r9 == r3) goto L_0x0478
            if (r9 != r1) goto L_0x047a
        L_0x0478:
            r12 = 1
            goto L_0x047b
        L_0x047a:
            r12 = 0
        L_0x047b:
            if (r8 != 0) goto L_0x047f
            if (r12 == 0) goto L_0x0457
        L_0x047f:
            android.view.ViewGroup r8 = r31.m()
            boolean r8 = androidx.core.view.ViewCompat.V(r8)
            if (r8 != 0) goto L_0x04b6
            r8 = 2
            boolean r8 = androidx.fragment.app.FragmentManager.G0(r8)
            if (r8 == 0) goto L_0x04b2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r12 = "SpecialEffectsController: Container "
            r8.append(r12)
            android.view.ViewGroup r12 = r31.m()
            r8.append(r12)
            java.lang.String r12 = " has not been laid out. Completing operation "
            r8.append(r12)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "FragmentManager"
            android.util.Log.v(r9, r8)
        L_0x04b2:
            r7.a()
            goto L_0x0457
        L_0x04b6:
            androidx.fragment.app.SpecialEffectsController$Operation r8 = r7.b()
            androidx.fragment.app.Fragment r8 = r8.f()
            androidx.core.os.CancellationSignal r9 = r7.c()
            androidx.fragment.app.DefaultSpecialEffectsController$9 r12 = new androidx.fragment.app.DefaultSpecialEffectsController$9
            r12.<init>(r7)
            r11.w(r8, r4, r9, r12)
            goto L_0x0457
        L_0x04cb:
            android.view.ViewGroup r1 = r31.m()
            boolean r1 = androidx.core.view.ViewCompat.V(r1)
            if (r1 != 0) goto L_0x04d6
            return r10
        L_0x04d6:
            r1 = 4
            androidx.fragment.app.FragmentTransition.B(r2, r1)
            r1 = r30
            java.util.ArrayList r16 = r11.o(r1)
            android.view.ViewGroup r3 = r31.m()
            r11.c(r3, r4)
            android.view.ViewGroup r13 = r31.m()
            r12 = r11
            r14 = r29
            r15 = r1
            r17 = r26
            r12.y(r13, r14, r15, r16, r17)
            r3 = 0
            androidx.fragment.app.FragmentTransition.B(r2, r3)
            r2 = r29
            r11.A(r0, r2, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.x(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    public void f(List<SpecialEffectsController.Operation> list, boolean z2) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State c2 = SpecialEffectsController.Operation.State.c(next.f().mView);
            int i2 = AnonymousClass10.f3284a[next.e().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (c2 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = next;
                }
            } else if (i2 == 4 && c2 != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList<>(list);
        for (final SpecialEffectsController.Operation next2 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            next2.j(cancellationSignal);
            arrayList.add(new AnimationInfo(next2, cancellationSignal, z2));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next2.j(cancellationSignal2);
            boolean z3 = false;
            if (z2) {
                if (next2 != operation) {
                    arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z2, z3));
                    next2.a(new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                DefaultSpecialEffectsController.this.s(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z2, z3));
                next2.a(new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            DefaultSpecialEffectsController.this.s(next2);
                        }
                    }
                });
            }
            z3 = true;
            arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z2, z3));
            next2.a(new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        DefaultSpecialEffectsController.this.s(next2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> x2 = x(arrayList2, arrayList3, z2, operation, operation2);
        w(arrayList, arrayList3, x2.containsValue(Boolean.TRUE), x2);
        for (SpecialEffectsController.Operation s2 : arrayList3) {
            s(s2);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void s(SpecialEffectsController.Operation operation) {
        operation.e().a(operation.f().mView);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map<String, View> map, View view) {
        String M = ViewCompat.M(view);
        if (M != null) {
            map.put(M, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it2 = arrayMap.entrySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(ViewCompat.M((View) it2.next().getValue()))) {
                it2.remove();
            }
        }
    }
}
