package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;

public abstract class Evaluator {

    public static final class AllElements extends Evaluator {
        public boolean a(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class Attribute extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41812a;

        public Attribute(String str) {
            this.f41812a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41812a);
        }

        public String toString() {
            return String.format("[%s]", new Object[]{this.f41812a});
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        String f41813a;

        /* renamed from: b  reason: collision with root package name */
        String f41814b;

        public AttributeKeyPair(String str, String str2) {
            Validate.h(str);
            Validate.h(str2);
            this.f41813a = Normalizer.b(str);
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f41814b = Normalizer.b(str2);
        }
    }

    public static final class AttributeStarting extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41815a;

        public AttributeStarting(String str) {
            Validate.h(str);
            this.f41815a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.Attribute b2 : element2.e().e()) {
                if (Normalizer.a(b2.getKey()).startsWith(this.f41815a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", new Object[]{this.f41815a});
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41813a) && this.f41814b.equalsIgnoreCase(element2.c(this.f41813a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", new Object[]{this.f41813a, this.f41814b});
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41813a) && Normalizer.a(element2.c(this.f41813a)).contains(this.f41814b);
        }

        public String toString() {
            return String.format("[%s*=%s]", new Object[]{this.f41813a, this.f41814b});
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41813a) && Normalizer.a(element2.c(this.f41813a)).endsWith(this.f41814b);
        }

        public String toString() {
            return String.format("[%s$=%s]", new Object[]{this.f41813a, this.f41814b});
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        String f41816a;

        /* renamed from: b  reason: collision with root package name */
        Pattern f41817b;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.f41816a = Normalizer.b(str);
            this.f41817b = pattern;
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41816a) && this.f41817b.matcher(element2.c(this.f41816a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f41816a, this.f41817b.toString()});
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return !this.f41814b.equalsIgnoreCase(element2.c(this.f41813a));
        }

        public String toString() {
            return String.format("[%s!=%s]", new Object[]{this.f41813a, this.f41814b});
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.p(this.f41813a) && Normalizer.a(element2.c(this.f41813a)).startsWith(this.f41814b);
        }

        public String toString() {
            return String.format("[%s^=%s]", new Object[]{this.f41813a, this.f41814b});
        }
    }

    public static final class Class extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41818a;

        public Class(String str) {
            this.f41818a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.e0(this.f41818a);
        }

        public String toString() {
            return String.format(".%s", new Object[]{this.f41818a});
        }
    }

    public static final class ContainsData extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41819a;

        public ContainsData(String str) {
            this.f41819a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.Z()).contains(this.f41819a);
        }

        public String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f41819a});
        }
    }

    public static final class ContainsOwnText extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41820a;

        public ContainsOwnText(String str) {
            this.f41820a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.l0()).contains(this.f41820a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f41820a});
        }
    }

    public static final class ContainsText extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41821a;

        public ContainsText(String str) {
            this.f41821a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.v0()).contains(this.f41821a);
        }

        public String toString() {
            return String.format(":contains(%s)", new Object[]{this.f41821a});
        }
    }

    public static abstract class CssNthEvaluator extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        protected final int f41822a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f41823b;

        public CssNthEvaluator(int i2, int i3) {
            this.f41822a = i2;
            this.f41823b = i3;
        }

        public boolean a(Element element, Element element2) {
            Element n02 = element2.n0();
            if (n02 == null || (n02 instanceof Document)) {
                return false;
            }
            int b2 = b(element, element2);
            int i2 = this.f41822a;
            if (i2 != 0) {
                int i3 = this.f41823b;
                if ((b2 - i3) * i2 < 0 || (b2 - i3) % i2 != 0) {
                    return false;
                }
                return true;
            } else if (b2 == this.f41823b) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public abstract int b(Element element, Element element2);

        /* access modifiers changed from: protected */
        public abstract String c();

        public String toString() {
            if (this.f41822a == 0) {
                return String.format(":%s(%d)", new Object[]{c(), Integer.valueOf(this.f41823b)});
            } else if (this.f41823b == 0) {
                return String.format(":%s(%dn)", new Object[]{c(), Integer.valueOf(this.f41822a)});
            } else {
                return String.format(":%s(%dn%+d)", new Object[]{c(), Integer.valueOf(this.f41822a), Integer.valueOf(this.f41823b)});
            }
        }
    }

    public static final class Id extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41824a;

        public Id(String str) {
            this.f41824a = str;
        }

        public boolean a(Element element, Element element2) {
            return this.f41824a.equals(element2.i0());
        }

        public String toString() {
            return String.format("#%s", new Object[]{this.f41824a});
        }
    }

    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.b0() == this.f41825a;
        }

        public String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.f41825a)});
        }
    }

    public static abstract class IndexEvaluator extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        int f41825a;

        public IndexEvaluator(int i2) {
            this.f41825a = i2;
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.b0() > this.f41825a;
        }

        public String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.f41825a)});
        }
    }

    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element != element2 && element2.b0() < this.f41825a;
        }

        public String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.f41825a)});
        }
    }

    public static final class IsEmpty extends Evaluator {
        public boolean a(Element element, Element element2) {
            for (Node next : element2.j()) {
                if (!(next instanceof Comment) && !(next instanceof XmlDeclaration) && !(next instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class IsFirstChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element n02 = element2.n0();
            if (n02 == null || (n02 instanceof Document) || element2.b0() != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class IsLastChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element n02 = element2.n0();
            if (n02 == null || (n02 instanceof Document) || element2.b0() != n02.X().size() - 1) {
                return false;
            }
            return true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.b0() + 1;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-child";
        }
    }

    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.n0().X().size() - element2.b0();
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-last-child";
        }
    }

    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Elements X = element2.n0().X();
            int i2 = 0;
            for (int b02 = element2.b0(); b02 < X.size(); b02++) {
                if (((Element) X.get(b02)).t0().equals(element2.t0())) {
                    i2++;
                }
            }
            return i2;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-last-of-type";
        }
    }

    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Iterator it2 = element2.n0().X().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3.t0().equals(element2.t0())) {
                    i2++;
                    continue;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i2;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-of-type";
        }
    }

    public static final class IsOnlyChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element n02 = element2.n0();
            if (n02 == null || (n02 instanceof Document) || element2.s0().size() != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class IsOnlyOfType extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element n02 = element2.n0();
            if (n02 == null || (n02 instanceof Document)) {
                return false;
            }
            Iterator it2 = n02.X().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((Element) it2.next()).t0().equals(element2.t0())) {
                    i2++;
                }
            }
            if (i2 == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class IsRoot extends Evaluator {
        public boolean a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.V(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class Matches extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f41826a;

        public Matches(Pattern pattern) {
            this.f41826a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f41826a.matcher(element2.v0()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", new Object[]{this.f41826a});
        }
    }

    public static final class MatchesOwn extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f41827a;

        public MatchesOwn(Pattern pattern) {
            this.f41827a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f41827a.matcher(element2.l0()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f41827a});
        }
    }

    public static final class Tag extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41828a;

        public Tag(String str) {
            this.f41828a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.u0().equalsIgnoreCase(this.f41828a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f41828a});
        }
    }

    public static final class TagEndsWith extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f41829a;

        public TagEndsWith(String str) {
            this.f41829a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.u0().endsWith(this.f41829a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f41829a});
        }
    }

    protected Evaluator() {
    }

    public abstract boolean a(Element element, Element element2);
}
