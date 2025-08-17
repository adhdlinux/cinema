package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;

public class Attributes implements Iterable<Attribute>, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f41546e = new String[0];
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f41547b = 0;

    /* renamed from: c  reason: collision with root package name */
    String[] f41548c;

    /* renamed from: d  reason: collision with root package name */
    String[] f41549d;

    public Attributes() {
        String[] strArr = f41546e;
        this.f41548c = strArr;
        this.f41549d = strArr;
    }

    private void c(String str, String str2) {
        g(this.f41547b + 1);
        String[] strArr = this.f41548c;
        int i2 = this.f41547b;
        strArr[i2] = str;
        this.f41549d[i2] = str2;
        this.f41547b = i2 + 1;
    }

    private void g(int i2) {
        boolean z2;
        if (i2 >= this.f41547b) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.d(z2);
        String[] strArr = this.f41548c;
        int length = strArr.length;
        if (length < i2) {
            int i3 = 4;
            if (length >= 4) {
                i3 = this.f41547b * 2;
            }
            if (i2 <= i3) {
                i2 = i3;
            }
            this.f41548c = j(strArr, i2);
            this.f41549d = j(this.f41549d, i2);
        }
    }

    static String h(String str) {
        return str == null ? "" : str;
    }

    private static String[] j(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i2));
        return strArr2;
    }

    private int r(String str) {
        Validate.j(str);
        for (int i2 = 0; i2 < this.f41547b; i2++) {
            if (str.equalsIgnoreCase(this.f41548c[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void w(int i2) {
        boolean z2;
        if (i2 >= this.f41547b) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.b(z2);
        int i3 = (this.f41547b - i2) - 1;
        if (i3 > 0) {
            String[] strArr = this.f41548c;
            int i4 = i2 + 1;
            System.arraycopy(strArr, i4, strArr, i2, i3);
            String[] strArr2 = this.f41549d;
            System.arraycopy(strArr2, i4, strArr2, i2, i3);
        }
        int i5 = this.f41547b - 1;
        this.f41547b = i5;
        this.f41548c[i5] = null;
        this.f41549d[i5] = null;
    }

    public void d(Attributes attributes) {
        if (attributes.size() != 0) {
            g(this.f41547b + attributes.f41547b);
            Iterator<Attribute> it2 = attributes.iterator();
            while (it2.hasNext()) {
                u(it2.next());
            }
        }
    }

    public List<Attribute> e() {
        Object obj;
        ArrayList arrayList = new ArrayList(this.f41547b);
        for (int i2 = 0; i2 < this.f41547b; i2++) {
            if (this.f41549d[i2] == null) {
                obj = new BooleanAttribute(this.f41548c[i2]);
            } else {
                obj = new Attribute(this.f41548c[i2], this.f41549d[i2], this);
            }
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.f41547b == attributes.f41547b && Arrays.equals(this.f41548c, attributes.f41548c)) {
            return Arrays.equals(this.f41549d, attributes.f41549d);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41547b * 31) + Arrays.hashCode(this.f41548c)) * 31) + Arrays.hashCode(this.f41549d);
    }

    /* renamed from: i */
    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.f41547b = this.f41547b;
            this.f41548c = j(this.f41548c, this.f41547b);
            this.f41549d = j(this.f41549d, this.f41547b);
            return attributes;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Iterator<Attribute> iterator() {
        return new Iterator<Attribute>() {

            /* renamed from: b  reason: collision with root package name */
            int f41550b = 0;

            /* renamed from: a */
            public Attribute next() {
                Attributes attributes = Attributes.this;
                String[] strArr = attributes.f41548c;
                int i2 = this.f41550b;
                Attribute attribute = new Attribute(strArr[i2], attributes.f41549d[i2], attributes);
                this.f41550b++;
                return attribute;
            }

            public boolean hasNext() {
                return this.f41550b < Attributes.this.f41547b;
            }

            public void remove() {
                Attributes attributes = Attributes.this;
                int i2 = this.f41550b - 1;
                this.f41550b = i2;
                attributes.w(i2);
            }
        };
    }

    public String k(String str) {
        int q2 = q(str);
        if (q2 == -1) {
            return "";
        }
        return h(this.f41549d[q2]);
    }

    public String l(String str) {
        int r2 = r(str);
        if (r2 == -1) {
            return "";
        }
        return h(this.f41549d[r2]);
    }

    public boolean m(String str) {
        return q(str) != -1;
    }

    public boolean n(String str) {
        return r(str) != -1;
    }

    public String o() {
        StringBuilder sb = new StringBuilder();
        try {
            p(sb, new Document("").z0());
            return sb.toString();
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void p(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i2 = this.f41547b;
        for (int i3 = 0; i3 < i2; i3++) {
            String str = this.f41548c[i3];
            String str2 = this.f41549d[i3];
            appendable.append(' ').append(str);
            if (outputSettings.j() != Document.OutputSettings.Syntax.html || (str2 != null && (!str2.equals(str) || !Attribute.g(str)))) {
                appendable.append("=\"");
                if (str2 == null) {
                    str2 = "";
                }
                Entities.e(appendable, str2, outputSettings, true, false, false);
                appendable.append('\"');
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int q(String str) {
        Validate.j(str);
        for (int i2 = 0; i2 < this.f41547b; i2++) {
            if (str.equals(this.f41548c[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public void s() {
        for (int i2 = 0; i2 < this.f41547b; i2++) {
            String[] strArr = this.f41548c;
            strArr[i2] = Normalizer.a(strArr[i2]);
        }
    }

    public int size() {
        return this.f41547b;
    }

    public Attributes t(String str, String str2) {
        int q2 = q(str);
        if (q2 != -1) {
            this.f41549d[q2] = str2;
        } else {
            c(str, str2);
        }
        return this;
    }

    public String toString() {
        return o();
    }

    public Attributes u(Attribute attribute) {
        Validate.j(attribute);
        t(attribute.getKey(), attribute.getValue());
        attribute.f41545d = this;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void v(String str, String str2) {
        int r2 = r(str);
        if (r2 != -1) {
            this.f41549d[r2] = str2;
            if (!this.f41548c[r2].equals(str)) {
                this.f41548c[r2] = str;
                return;
            }
            return;
        }
        c(str, str2);
    }
}
