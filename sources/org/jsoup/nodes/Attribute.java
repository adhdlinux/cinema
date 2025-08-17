package org.jsoup.nodes;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class Attribute implements Map.Entry<String, String>, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f41542e = {"allowfullscreen", BaseJavaModule.METHOD_TYPE_ASYNC, "autofocus", "checked", "compact", "declare", Constants.COLLATION_DEFAULT, "defer", "disabled", "formnovalidate", ViewProps.HIDDEN, "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", MRAIDPresenter.OPEN, "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* renamed from: b  reason: collision with root package name */
    private String f41543b;

    /* renamed from: c  reason: collision with root package name */
    private String f41544c;

    /* renamed from: d  reason: collision with root package name */
    Attributes f41545d;

    public Attribute(String str, String str2) {
        this(str, str2, (Attributes) null);
    }

    protected static void f(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (!i(str, str2, outputSettings)) {
            appendable.append("=\"");
            Entities.e(appendable, Attributes.h(str2), outputSettings, true, false, false);
            appendable.append('\"');
        }
    }

    protected static boolean g(String str) {
        return Arrays.binarySearch(f41542e, str) >= 0;
    }

    protected static boolean i(String str, String str2, Document.OutputSettings outputSettings) {
        if ((str2 == null || "".equals(str2) || str2.equalsIgnoreCase(str)) && outputSettings.j() == Document.OutputSettings.Syntax.html && g(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: b */
    public String getKey() {
        return this.f41543b;
    }

    /* renamed from: c */
    public String getValue() {
        return this.f41544c;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        try {
            e(sb, new Document("").z0());
            return sb.toString();
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void e(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        f(this.f41543b, this.f41544c, appendable, outputSettings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.f41543b;
        if (str == null ? attribute.f41543b != null : !str.equals(attribute.f41543b)) {
            return false;
        }
        String str2 = this.f41544c;
        String str3 = attribute.f41544c;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public String setValue(String str) {
        int q2;
        String k2 = this.f41545d.k(this.f41543b);
        Attributes attributes = this.f41545d;
        if (!(attributes == null || (q2 = attributes.q(this.f41543b)) == -1)) {
            this.f41545d.f41549d[q2] = str;
        }
        this.f41544c = str;
        return k2;
    }

    public int hashCode() {
        int i2;
        String str = this.f41543b;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 * 31;
        String str2 = this.f41544c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return d();
    }

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.j(str);
        this.f41543b = str.trim();
        Validate.h(str);
        this.f41544c = str2;
        this.f41545d = attributes;
    }
}
