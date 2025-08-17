package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

public class Collector {

    private static class Accumulator implements NodeVisitor {

        /* renamed from: a  reason: collision with root package name */
        private final Element f41804a;

        /* renamed from: b  reason: collision with root package name */
        private final Elements f41805b;

        /* renamed from: c  reason: collision with root package name */
        private final Evaluator f41806c;

        Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.f41804a = element;
            this.f41805b = elements;
            this.f41806c = evaluator;
        }

        public void a(Node node, int i2) {
        }

        public void b(Node node, int i2) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.f41806c.a(this.f41804a, element)) {
                    this.f41805b.add(element);
                }
            }
        }
    }

    private static class FirstFinder implements NodeFilter {

        /* renamed from: a  reason: collision with root package name */
        private final Element f41807a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Element f41808b = null;

        /* renamed from: c  reason: collision with root package name */
        private final Evaluator f41809c;

        FirstFinder(Element element, Evaluator evaluator) {
            this.f41807a = element;
            this.f41809c = evaluator;
        }

        public NodeFilter.FilterResult a(Node node, int i2) {
            return NodeFilter.FilterResult.CONTINUE;
        }

        public NodeFilter.FilterResult b(Node node, int i2) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.f41809c.a(this.f41807a, element)) {
                    this.f41808b = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    private Collector() {
    }

    public static Elements a(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        NodeTraversor.b(new Accumulator(element, elements, evaluator), element);
        return elements;
    }

    public static Element b(Evaluator evaluator, Element element) {
        FirstFinder firstFinder = new FirstFinder(element, evaluator);
        NodeTraversor.a(firstFinder, element);
        return firstFinder.f41808b;
    }
}
