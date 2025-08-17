package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

abstract class StructuralEvaluator extends Evaluator {

    /* renamed from: a  reason: collision with root package name */
    Evaluator f41843a;

    static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            Iterator it2 = element2.c0().iterator();
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3 != element2 && this.f41843a.a(element, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.f41843a});
        }
    }

    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            Element n02;
            if (element == element2 || (n02 = element2.n0()) == null || !this.f41843a.a(element, n02)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", new Object[]{this.f41843a});
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            Element p02;
            if (element == element2 || (p02 = element2.p0()) == null || !this.f41843a.a(element, p02)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":prev%s", new Object[]{this.f41843a});
        }
    }

    static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            return !this.f41843a.a(element, element2);
        }

        public String toString() {
            return String.format(":not%s", new Object[]{this.f41843a});
        }
    }

    static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element n02 = element2.n0(); !this.f41843a.a(element, n02); n02 = n02.n0()) {
                if (n02 == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", new Object[]{this.f41843a});
        }
    }

    static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.f41843a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element p02 = element2.p0(); p02 != null; p02 = p02.p0()) {
                if (this.f41843a.a(element, p02)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", new Object[]{this.f41843a});
        }
    }

    static class Root extends Evaluator {
        Root() {
        }

        public boolean a(Element element, Element element2) {
            return element == element2;
        }
    }

    StructuralEvaluator() {
    }
}
