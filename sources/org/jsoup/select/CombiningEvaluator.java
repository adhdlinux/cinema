package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

abstract class CombiningEvaluator extends Evaluator {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Evaluator> f41810a;

    /* renamed from: b  reason: collision with root package name */
    int f41811b;

    static final class And extends CombiningEvaluator {
        And(Collection<Evaluator> collection) {
            super(collection);
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f41811b; i2++) {
                if (!this.f41810a.get(i2).a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.h(this.f41810a, " ");
        }

        And(Evaluator... evaluatorArr) {
            this((Collection<Evaluator>) Arrays.asList(evaluatorArr));
        }
    }

    CombiningEvaluator() {
        this.f41811b = 0;
        this.f41810a = new ArrayList<>();
    }

    /* access modifiers changed from: package-private */
    public void b(Evaluator evaluator) {
        this.f41810a.set(this.f41811b - 1, evaluator);
    }

    /* access modifiers changed from: package-private */
    public Evaluator c() {
        int i2 = this.f41811b;
        if (i2 > 0) {
            return this.f41810a.get(i2 - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f41811b = this.f41810a.size();
    }

    CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.f41810a.addAll(collection);
        d();
    }

    static final class Or extends CombiningEvaluator {
        Or(Collection<Evaluator> collection) {
            if (this.f41811b > 1) {
                this.f41810a.add(new And(collection));
            } else {
                this.f41810a.addAll(collection);
            }
            d();
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f41811b; i2++) {
                if (this.f41810a.get(i2).a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void e(Evaluator evaluator) {
            this.f41810a.add(evaluator);
            d();
        }

        public String toString() {
            return StringUtil.h(this.f41810a, ", ");
        }

        Or(Evaluator... evaluatorArr) {
            this((Collection<Evaluator>) Arrays.asList(evaluatorArr));
        }

        Or() {
        }
    }
}
