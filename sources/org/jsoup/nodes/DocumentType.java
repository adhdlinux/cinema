package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class DocumentType extends LeafNode {
    public DocumentType(String str, String str2, String str3) {
        Validate.j(str);
        Validate.j(str2);
        Validate.j(str3);
        d("name", str);
        d("publicId", str2);
        if (Q("publicId")) {
            d("pubSysKey", "PUBLIC");
        }
        d("systemId", str3);
    }

    private boolean Q(String str) {
        return !StringUtil.e(c(str));
    }

    public void R(String str) {
        if (str != null) {
            d("pubSysKey", str);
        }
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ String c(String str) {
        return super.c(str);
    }

    public /* bridge */ /* synthetic */ Node d(String str, String str2) {
        return super.d(str, str2);
    }

    public /* bridge */ /* synthetic */ String f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ int i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ boolean p(String str) {
        return super.p(str);
    }

    public String u() {
        return "#doctype";
    }

    /* access modifiers changed from: package-private */
    public void y(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.j() != Document.OutputSettings.Syntax.html || Q("publicId") || Q("systemId")) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (Q("name")) {
            appendable.append(" ").append(c("name"));
        }
        if (Q("pubSysKey")) {
            appendable.append(" ").append(c("pubSysKey"));
        }
        if (Q("publicId")) {
            appendable.append(" \"").append(c("publicId")).append('\"');
        }
        if (Q("systemId")) {
            appendable.append(" \"").append(c("systemId")).append('\"');
        }
        appendable.append('>');
    }

    /* access modifiers changed from: package-private */
    public void z(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }
}
