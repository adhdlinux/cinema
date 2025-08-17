package org.jsoup.nodes;

import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class FormElement extends Element {

    /* renamed from: k  reason: collision with root package name */
    private final Elements f41597k = new Elements();

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    public FormElement w0(Element element) {
        this.f41597k.add(element);
        return this;
    }
}
