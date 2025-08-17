package org.jsoup.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public String a(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.p(str)) {
                return element.c(str);
            }
        }
        return "";
    }

    /* renamed from: b */
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            elements.add(((Element) it2.next()).k());
        }
        return elements;
    }

    public Element c() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(0);
    }

    public Element d() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(size() - 1);
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (sb.length() != 0) {
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            sb.append(element.w());
        }
        return sb.toString();
    }

    public Elements g(String str) {
        return Selector.a(str, this);
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(element.v0());
        }
        return sb.toString();
    }

    public String toString() {
        return e();
    }

    public Elements(int i2) {
        super(i2);
    }

    public Elements(List<Element> list) {
        super(list);
    }
}
