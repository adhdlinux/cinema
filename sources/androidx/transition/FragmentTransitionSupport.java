package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends FragmentTransitionImpl {
    private static boolean C(Transition transition) {
        if (!FragmentTransitionImpl.l(transition.y()) || !FragmentTransitionImpl.l(transition.z()) || !FragmentTransitionImpl.l(transition.A())) {
            return true;
        }
        return false;
    }

    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.B().clear();
            transitionSet.B().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.d0((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).b(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int f02 = transitionSet.f0();
                while (i2 < f02) {
                    b(transitionSet.e0(i2), arrayList);
                    i2++;
                }
            } else if (!C(transition) && FragmentTransitionImpl.l(transition.B())) {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.b(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.a(viewGroup, (Transition) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().d0(transition).d0(transition2).k0(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.d0(transition);
        }
        transitionSet.d0(transition3);
        return transitionSet;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.d0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.d0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.d0((Transition) obj3);
        }
        return transitionSet;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).P(view);
        }
    }

    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        Transition transition = (Transition) obj;
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int f02 = transitionSet.f0();
            while (i3 < f02) {
                q(transitionSet.e0(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!C(transition)) {
            List<View> B = transition.B();
            if (B.size() == arrayList.size() && B.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    transition.b(arrayList2.get(i3));
                    i3++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.P(arrayList.get(size));
                }
            }
        }
    }

    public void r(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a(new Transition.TransitionListener() {
            public void a(Transition transition) {
            }

            public void b(Transition transition) {
            }

            public void c(Transition transition) {
            }

            public void d(Transition transition) {
                transition.O(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }
        });
    }

    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).a(new Transition.TransitionListener() {
            public void a(Transition transition) {
            }

            public void b(Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    FragmentTransitionSupport.this.q(obj, arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    FragmentTransitionSupport.this.q(obj2, arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    FragmentTransitionSupport.this.q(obj3, arrayList6, (ArrayList<View>) null);
                }
            }

            public void c(Transition transition) {
            }

            public void d(Transition transition) {
            }
        });
    }

    public void u(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).U(new Transition.EpicenterCallback() {
            });
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).U(new Transition.EpicenterCallback() {
            });
        }
    }

    public void z(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> B = transitionSet.B();
        B.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransitionImpl.d(B, arrayList.get(i2));
        }
        B.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
