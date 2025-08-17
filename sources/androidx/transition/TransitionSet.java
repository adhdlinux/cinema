package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    private ArrayList<Transition> L = new ArrayList<>();
    private boolean M = true;
    int N;
    boolean O = false;
    private int P = 0;

    static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f11783a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f11783a = transitionSet;
        }

        public void b(Transition transition) {
            TransitionSet transitionSet = this.f11783a;
            if (!transitionSet.O) {
                transitionSet.Z();
                this.f11783a.O = true;
            }
        }

        public void d(Transition transition) {
            TransitionSet transitionSet = this.f11783a;
            int i2 = transitionSet.N - 1;
            transitionSet.N = i2;
            if (i2 == 0) {
                transitionSet.O = false;
                transitionSet.o();
            }
            transition.O(this);
        }
    }

    private void m0() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it2 = this.L.iterator();
        while (it2.hasNext()) {
            it2.next().a(transitionSetListener);
        }
        this.N = this.L.size();
    }

    public void M(View view) {
        super.M(view);
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L.get(i2).M(view);
        }
    }

    public void Q(View view) {
        super.Q(view);
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L.get(i2).Q(view);
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        if (this.L.isEmpty()) {
            Z();
            o();
            return;
        }
        m0();
        if (!this.M) {
            for (int i2 = 1; i2 < this.L.size(); i2++) {
                final Transition transition = this.L.get(i2);
                this.L.get(i2 - 1).a(new TransitionListenerAdapter() {
                    public void d(Transition transition) {
                        transition.S();
                        transition.O(this);
                    }
                });
            }
            Transition transition2 = this.L.get(0);
            if (transition2 != null) {
                transition2.S();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.L.iterator();
        while (it2.hasNext()) {
            it2.next().S();
        }
    }

    public void U(Transition.EpicenterCallback epicenterCallback) {
        super.U(epicenterCallback);
        this.P |= 8;
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L.get(i2).U(epicenterCallback);
        }
    }

    public void W(PathMotion pathMotion) {
        super.W(pathMotion);
        this.P |= 4;
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            this.L.get(i2).W(pathMotion);
        }
    }

    public void X(TransitionPropagation transitionPropagation) {
        super.X(transitionPropagation);
        this.P |= 2;
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L.get(i2).X(transitionPropagation);
        }
    }

    /* access modifiers changed from: package-private */
    public String a0(String str) {
        String a02 = super.a0(str);
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a02);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append(this.L.get(i2).a0(str + "  "));
            a02 = sb.toString();
        }
        return a02;
    }

    /* renamed from: b0 */
    public TransitionSet a(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.a(transitionListener);
    }

    /* renamed from: c0 */
    public TransitionSet b(View view) {
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            this.L.get(i2).b(view);
        }
        return (TransitionSet) super.b(view);
    }

    public TransitionSet d0(Transition transition) {
        this.L.add(transition);
        transition.f11756s = this;
        long j2 = this.f11741d;
        if (j2 >= 0) {
            transition.T(j2);
        }
        if ((this.P & 1) != 0) {
            transition.V(r());
        }
        if ((this.P & 2) != 0) {
            transition.X(v());
        }
        if ((this.P & 4) != 0) {
            transition.W(u());
        }
        if ((this.P & 8) != 0) {
            transition.U(q());
        }
        return this;
    }

    public Transition e0(int i2) {
        if (i2 < 0 || i2 >= this.L.size()) {
            return null;
        }
        return this.L.get(i2);
    }

    public void f(TransitionValues transitionValues) {
        if (F(transitionValues.f11788b)) {
            Iterator<Transition> it2 = this.L.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.F(transitionValues.f11788b)) {
                    next.f(transitionValues);
                    transitionValues.f11789c.add(next);
                }
            }
        }
    }

    public int f0() {
        return this.L.size();
    }

    /* renamed from: g0 */
    public TransitionSet O(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.O(transitionListener);
    }

    /* access modifiers changed from: package-private */
    public void h(TransitionValues transitionValues) {
        super.h(transitionValues);
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L.get(i2).h(transitionValues);
        }
    }

    /* renamed from: h0 */
    public TransitionSet P(View view) {
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            this.L.get(i2).P(view);
        }
        return (TransitionSet) super.P(view);
    }

    public void i(TransitionValues transitionValues) {
        if (F(transitionValues.f11788b)) {
            Iterator<Transition> it2 = this.L.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.F(transitionValues.f11788b)) {
                    next.i(transitionValues);
                    transitionValues.f11789c.add(next);
                }
            }
        }
    }

    /* renamed from: i0 */
    public TransitionSet T(long j2) {
        super.T(j2);
        if (this.f11741d >= 0) {
            int size = this.L.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.L.get(i2).T(j2);
            }
        }
        return this;
    }

    /* renamed from: j0 */
    public TransitionSet V(TimeInterpolator timeInterpolator) {
        this.P |= 1;
        ArrayList<Transition> arrayList = this.L;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.L.get(i2).V(timeInterpolator);
            }
        }
        return (TransitionSet) super.V(timeInterpolator);
    }

    public TransitionSet k0(int i2) {
        if (i2 == 0) {
            this.M = true;
        } else if (i2 == 1) {
            this.M = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    /* renamed from: l */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.L = new ArrayList<>();
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.d0(this.L.get(i2).clone());
        }
        return transitionSet;
    }

    /* renamed from: l0 */
    public TransitionSet Y(long j2) {
        return (TransitionSet) super.Y(j2);
    }

    /* access modifiers changed from: protected */
    public void n(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long x2 = x();
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.L.get(i2);
            if (x2 > 0 && (this.M || i2 == 0)) {
                long x3 = transition.x();
                if (x3 > 0) {
                    transition.Y(x3 + x2);
                } else {
                    transition.Y(x2);
                }
            }
            transition.n(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }
}
