package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {

    /* renamed from: c  reason: collision with root package name */
    private static Transition f11772c = new AutoTransition();

    /* renamed from: d  reason: collision with root package name */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f11773d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static ArrayList<ViewGroup> f11774e = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private ArrayMap<Scene, Transition> f11775a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> f11776b = new ArrayMap<>();

    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        Transition f11777b;

        /* renamed from: c  reason: collision with root package name */
        ViewGroup f11778c;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f11777b = transition;
            this.f11778c = viewGroup;
        }

        private void a() {
            this.f11778c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f11778c.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f11774e.remove(this.f11778c)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> b2 = TransitionManager.b();
            ArrayList arrayList = b2.get(this.f11778c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b2.put(this.f11778c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f11777b);
            this.f11777b.a(new TransitionListenerAdapter() {
                public void d(Transition transition) {
                    ((ArrayList) b2.get(MultiListener.this.f11778c)).remove(transition);
                }
            });
            this.f11777b.j(this.f11778c, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).Q(this.f11778c);
                }
            }
            this.f11777b.N(this.f11778c);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f11774e.remove(this.f11778c);
            ArrayList arrayList = TransitionManager.b().get(this.f11778c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).Q(this.f11778c);
                }
            }
            this.f11777b.k(true);
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f11774e.contains(viewGroup) && ViewCompat.V(viewGroup)) {
            f11774e.add(viewGroup);
            if (transition == null) {
                transition = f11772c;
            }
            Transition l2 = transition.clone();
            d(viewGroup, l2);
            Scene.c(viewGroup, (Scene) null);
            c(viewGroup, l2);
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> b() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference weakReference = f11773d.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f11773d.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void d(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).M(viewGroup);
            }
        }
        if (transition != null) {
            transition.j(viewGroup, true);
        }
        Scene b2 = Scene.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
