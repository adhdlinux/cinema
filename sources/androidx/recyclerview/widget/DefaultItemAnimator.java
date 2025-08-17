package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: s  reason: collision with root package name */
    private static TimeInterpolator f11032s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f11033h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f11034i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<MoveInfo> f11035j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<ChangeInfo> f11036k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f11037l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    ArrayList<ArrayList<MoveInfo>> f11038m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    ArrayList<ArrayList<ChangeInfo>> f11039n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f11040o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f11041p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f11042q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f11043r = new ArrayList<>();

    private static class MoveInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f11078a;

        /* renamed from: b  reason: collision with root package name */
        public int f11079b;

        /* renamed from: c  reason: collision with root package name */
        public int f11080c;

        /* renamed from: d  reason: collision with root package name */
        public int f11081d;

        /* renamed from: e  reason: collision with root package name */
        public int f11082e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            this.f11078a = viewHolder;
            this.f11079b = i2;
            this.f11080c = i3;
            this.f11081d = i4;
            this.f11082e = i5;
        }
    }

    private void T(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f11042q.add(viewHolder);
        animate.setDuration(o()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.G(viewHolder);
                DefaultItemAnimator.this.f11042q.remove(viewHolder);
                DefaultItemAnimator.this.V();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.H(viewHolder);
            }
        }).start();
    }

    private void W(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (Y(changeInfo, viewHolder) && changeInfo.f11072a == null && changeInfo.f11073b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void X(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f11072a;
        if (viewHolder != null) {
            Y(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f11073b;
        if (viewHolder2 != null) {
            Y(changeInfo, viewHolder2);
        }
    }

    private boolean Y(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z2 = false;
        if (changeInfo.f11073b == viewHolder) {
            changeInfo.f11073b = null;
        } else if (changeInfo.f11072a != viewHolder) {
            return false;
        } else {
            changeInfo.f11072a = null;
            z2 = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        C(viewHolder, z2);
        return true;
    }

    private void Z(RecyclerView.ViewHolder viewHolder) {
        if (f11032s == null) {
            f11032s = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f11032s);
        j(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void Q(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f11040o.add(viewHolder);
        animate.alpha(1.0f).setDuration(l()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                DefaultItemAnimator.this.A(viewHolder);
                DefaultItemAnimator.this.f11040o.remove(viewHolder);
                DefaultItemAnimator.this.V();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.B(viewHolder);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void R(final ChangeInfo changeInfo) {
        final View view;
        RecyclerView.ViewHolder viewHolder = changeInfo.f11072a;
        final View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f11073b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f11043r.add(changeInfo.f11072a);
            duration.translationX((float) (changeInfo.f11076e - changeInfo.f11074c));
            duration.translationY((float) (changeInfo.f11077f - changeInfo.f11075d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.C(changeInfo.f11072a, true);
                    DefaultItemAnimator.this.f11043r.remove(changeInfo.f11072a);
                    DefaultItemAnimator.this.V();
                }

                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.D(changeInfo.f11072a, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f11043r.add(changeInfo.f11073b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.C(changeInfo.f11073b, false);
                    DefaultItemAnimator.this.f11043r.remove(changeInfo.f11073b);
                    DefaultItemAnimator.this.V();
                }

                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.D(changeInfo.f11073b, false);
                }
            }).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void S(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        final View view = viewHolder.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f11041p.add(viewHolder);
        final RecyclerView.ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(n()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                DefaultItemAnimator.this.E(viewHolder2);
                DefaultItemAnimator.this.f11041p.remove(viewHolder2);
                DefaultItemAnimator.this.V();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.F(viewHolder2);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void U(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void V() {
        if (!p()) {
            i();
        }
    }

    public boolean g(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.g(viewHolder, list);
    }

    @SuppressLint({"UnknownNullness"})
    public void j(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f11035j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f11035j.get(size).f11078a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(viewHolder);
                this.f11035j.remove(size);
            }
        }
        W(this.f11036k, viewHolder);
        if (this.f11033h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            G(viewHolder);
        }
        if (this.f11034i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            A(viewHolder);
        }
        for (int size2 = this.f11039n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f11039n.get(size2);
            W(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f11039n.remove(size2);
            }
        }
        for (int size3 = this.f11038m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f11038m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).f11078a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f11038m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f11037l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f11037l.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                A(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f11037l.remove(size5);
                }
            }
        }
        this.f11042q.remove(viewHolder);
        this.f11040o.remove(viewHolder);
        this.f11043r.remove(viewHolder);
        this.f11041p.remove(viewHolder);
        V();
    }

    public void k() {
        int size = this.f11035j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.f11035j.get(size);
            View view = moveInfo.f11078a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(moveInfo.f11078a);
            this.f11035j.remove(size);
        }
        for (int size2 = this.f11033h.size() - 1; size2 >= 0; size2--) {
            G(this.f11033h.get(size2));
            this.f11033h.remove(size2);
        }
        int size3 = this.f11034i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f11034i.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            A(viewHolder);
            this.f11034i.remove(size3);
        }
        for (int size4 = this.f11036k.size() - 1; size4 >= 0; size4--) {
            X(this.f11036k.get(size4));
        }
        this.f11036k.clear();
        if (p()) {
            for (int size5 = this.f11038m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f11038m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.f11078a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(moveInfo2.f11078a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f11038m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f11037l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f11037l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    A(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f11037l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f11039n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f11039n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f11039n.remove(arrayList3);
                    }
                }
            }
            U(this.f11042q);
            U(this.f11041p);
            U(this.f11040o);
            U(this.f11043r);
            i();
        }
    }

    public boolean p() {
        if (!this.f11034i.isEmpty() || !this.f11036k.isEmpty() || !this.f11035j.isEmpty() || !this.f11033h.isEmpty() || !this.f11041p.isEmpty() || !this.f11042q.isEmpty() || !this.f11040o.isEmpty() || !this.f11043r.isEmpty() || !this.f11038m.isEmpty() || !this.f11037l.isEmpty() || !this.f11039n.isEmpty()) {
            return true;
        }
        return false;
    }

    public void u() {
        long j2;
        long j3;
        boolean z2 = !this.f11033h.isEmpty();
        boolean z3 = !this.f11035j.isEmpty();
        boolean z4 = !this.f11036k.isEmpty();
        boolean z5 = !this.f11034i.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.ViewHolder> it2 = this.f11033h.iterator();
            while (it2.hasNext()) {
                T(it2.next());
            }
            this.f11033h.clear();
            if (z3) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f11035j);
                this.f11038m.add(arrayList);
                this.f11035j.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            DefaultItemAnimator.this.S(moveInfo.f11078a, moveInfo.f11079b, moveInfo.f11080c, moveInfo.f11081d, moveInfo.f11082e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.f11038m.remove(arrayList);
                    }
                };
                if (z2) {
                    ViewCompat.k0(((MoveInfo) arrayList.get(0)).f11078a.itemView, r6, o());
                } else {
                    r6.run();
                }
            }
            if (z4) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f11036k);
                this.f11039n.add(arrayList2);
                this.f11036k.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.R((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.f11039n.remove(arrayList2);
                    }
                };
                if (z2) {
                    ViewCompat.k0(((ChangeInfo) arrayList2.get(0)).f11072a.itemView, r62, o());
                } else {
                    r62.run();
                }
            }
            if (z5) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f11034i);
                this.f11037l.add(arrayList3);
                this.f11034i.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.Q((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.f11037l.remove(arrayList3);
                    }
                };
                if (z2 || z3 || z4) {
                    long j4 = 0;
                    if (z2) {
                        j2 = o();
                    } else {
                        j2 = 0;
                    }
                    if (z3) {
                        j3 = n();
                    } else {
                        j3 = 0;
                    }
                    if (z4) {
                        j4 = m();
                    }
                    ViewCompat.k0(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, r5, j2 + Math.max(j3, j4));
                    return;
                }
                r5.run();
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean w(RecyclerView.ViewHolder viewHolder) {
        Z(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f11034i.add(viewHolder);
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean x(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return y(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        Z(viewHolder);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            Z(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i6));
            viewHolder2.itemView.setTranslationY((float) (-i7));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.f11036k.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean y(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        Z(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            E(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.f11035j.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean z(RecyclerView.ViewHolder viewHolder) {
        Z(viewHolder);
        this.f11033h.add(viewHolder);
        return true;
    }

    private static class ChangeInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f11072a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ViewHolder f11073b;

        /* renamed from: c  reason: collision with root package name */
        public int f11074c;

        /* renamed from: d  reason: collision with root package name */
        public int f11075d;

        /* renamed from: e  reason: collision with root package name */
        public int f11076e;

        /* renamed from: f  reason: collision with root package name */
        public int f11077f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f11072a = viewHolder;
            this.f11073b = viewHolder2;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f11072a + ", newHolder=" + this.f11073b + ", fromX=" + this.f11074c + ", fromY=" + this.f11075d + ", toX=" + this.f11076e + ", toY=" + this.f11077f + '}';
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            this(viewHolder, viewHolder2);
            this.f11074c = i2;
            this.f11075d = i3;
            this.f11076e = i4;
            this.f11077f = i5;
        }
    }
}
