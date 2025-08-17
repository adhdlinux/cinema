package org.jsoup.select;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector {

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector() {
    }

    public static Elements a(String str, Iterable<Element> iterable) {
        Validate.h(str);
        Validate.j(iterable);
        Evaluator t2 = QueryParser.t(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        for (Element c2 : iterable) {
            Iterator it2 = c(t2, c2).iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (!identityHashMap.containsKey(element)) {
                    arrayList.add(element);
                    identityHashMap.put(element, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<Element>) arrayList);
    }

    public static Elements b(String str, Element element) {
        Validate.h(str);
        return c(QueryParser.t(str), element);
    }

    public static Elements c(Evaluator evaluator, Element element) {
        Validate.j(evaluator);
        Validate.j(element);
        return Collector.a(evaluator, element);
    }

    public static Element d(String str, Element element) {
        Validate.h(str);
        return Collector.b(QueryParser.t(str), element);
    }
}
