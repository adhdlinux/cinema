package org.jsoup.parser;

import com.facebook.ads.internal.c.a;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaTrack;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.model.AdPayload;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag {

    /* renamed from: j  reason: collision with root package name */
    private static final Map<String, Tag> f41684j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f41685k;

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f41686l = {"object", Constants.SENSITIVITY_BASE, "font", "tt", ContextChain.TAG_INFRA, "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", a.f20042a, "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f41687m = {"meta", "link", Constants.SENSITIVITY_BASE, "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f41688n = {"title", a.f20042a, ContextChain.TAG_PRODUCT, "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};

    /* renamed from: o  reason: collision with root package name */
    private static final String[] f41689o = {"pre", "plaintext", "title", "textarea"};

    /* renamed from: p  reason: collision with root package name */
    private static final String[] f41690p = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};

    /* renamed from: q  reason: collision with root package name */
    private static final String[] f41691q = {"input", "keygen", "object", "select", "textarea"};

    /* renamed from: a  reason: collision with root package name */
    private String f41692a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41693b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41694c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41695d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41696e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41697f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f41698g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f41699h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41700i = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", ContextChain.TAG_PRODUCT, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", MediaTrack.ROLE_CAPTION, "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", MimeTypes.BASE_TYPE_VIDEO, MimeTypes.BASE_TYPE_AUDIO, "canvas", "details", "menu", "plaintext", AdPayload.KEY_TEMPLATE, "article", MediaTrack.ROLE_MAIN, "svg", "math"};
        f41685k = strArr;
        for (String tag : strArr) {
            i(new Tag(tag));
        }
        for (String tag2 : f41686l) {
            Tag tag3 = new Tag(tag2);
            tag3.f41693b = false;
            tag3.f41694c = false;
            i(tag3);
        }
        for (String str : f41687m) {
            Tag tag4 = f41684j.get(str);
            Validate.j(tag4);
            tag4.f41695d = false;
            tag4.f41696e = true;
        }
        for (String str2 : f41688n) {
            Tag tag5 = f41684j.get(str2);
            Validate.j(tag5);
            tag5.f41694c = false;
        }
        for (String str3 : f41689o) {
            Tag tag6 = f41684j.get(str3);
            Validate.j(tag6);
            tag6.f41698g = true;
        }
        for (String str4 : f41690p) {
            Tag tag7 = f41684j.get(str4);
            Validate.j(tag7);
            tag7.f41699h = true;
        }
        for (String str5 : f41691q) {
            Tag tag8 = f41684j.get(str5);
            Validate.j(tag8);
            tag8.f41700i = true;
        }
    }

    private Tag(String str) {
        this.f41692a = str;
    }

    private static void i(Tag tag) {
        f41684j.put(tag.f41692a, tag);
    }

    public static Tag k(String str, ParseSettings parseSettings) {
        Validate.j(str);
        Map<String, Tag> map = f41684j;
        Tag tag = map.get(str);
        if (tag != null) {
            return tag;
        }
        String b2 = parseSettings.b(str);
        Validate.h(b2);
        Tag tag2 = map.get(b2);
        if (tag2 != null) {
            return tag2;
        }
        Tag tag3 = new Tag(b2);
        tag3.f41693b = false;
        return tag3;
    }

    public boolean a() {
        return this.f41694c;
    }

    public String b() {
        return this.f41692a;
    }

    public boolean c() {
        return this.f41693b;
    }

    public boolean d() {
        return this.f41696e;
    }

    public boolean e() {
        return this.f41699h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (this.f41692a.equals(tag.f41692a) && this.f41695d == tag.f41695d && this.f41696e == tag.f41696e && this.f41694c == tag.f41694c && this.f41693b == tag.f41693b && this.f41698g == tag.f41698g && this.f41697f == tag.f41697f && this.f41699h == tag.f41699h && this.f41700i == tag.f41700i) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return f41684j.containsKey(this.f41692a);
    }

    public boolean g() {
        return this.f41696e || this.f41697f;
    }

    public boolean h() {
        return this.f41698g;
    }

    public int hashCode() {
        return (((((((((((((((this.f41692a.hashCode() * 31) + (this.f41693b ? 1 : 0)) * 31) + (this.f41694c ? 1 : 0)) * 31) + (this.f41695d ? 1 : 0)) * 31) + (this.f41696e ? 1 : 0)) * 31) + (this.f41697f ? 1 : 0)) * 31) + (this.f41698g ? 1 : 0)) * 31) + (this.f41699h ? 1 : 0)) * 31) + (this.f41700i ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public Tag j() {
        this.f41697f = true;
        return this;
    }

    public String toString() {
        return this.f41692a;
    }
}
