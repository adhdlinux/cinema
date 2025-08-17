package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

public class QueryParser {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f41836d = {",", ">", "+", "~", " "};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f41837e = {"=", "!=", "^=", "$=", "*=", "~="};

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f41838f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f41839g = Pattern.compile("([+-])?(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private TokenQueue f41840a;

    /* renamed from: b  reason: collision with root package name */
    private String f41841b;

    /* renamed from: c  reason: collision with root package name */
    private List<Evaluator> f41842c = new ArrayList();

    private QueryParser(String str) {
        this.f41841b = str;
        this.f41840a = new TokenQueue(str);
    }

    private void a() {
        this.f41842c.add(new Evaluator.AllElements());
    }

    private void b() {
        TokenQueue tokenQueue = new TokenQueue(this.f41840a.a('[', ']'));
        String h2 = tokenQueue.h(f41837e);
        Validate.h(h2);
        tokenQueue.i();
        if (tokenQueue.j()) {
            if (h2.startsWith("^")) {
                this.f41842c.add(new Evaluator.AttributeStarting(h2.substring(1)));
            } else {
                this.f41842c.add(new Evaluator.Attribute(h2));
            }
        } else if (tokenQueue.k("=")) {
            this.f41842c.add(new Evaluator.AttributeWithValue(h2, tokenQueue.q()));
        } else if (tokenQueue.k("!=")) {
            this.f41842c.add(new Evaluator.AttributeWithValueNot(h2, tokenQueue.q()));
        } else if (tokenQueue.k("^=")) {
            this.f41842c.add(new Evaluator.AttributeWithValueStarting(h2, tokenQueue.q()));
        } else if (tokenQueue.k("$=")) {
            this.f41842c.add(new Evaluator.AttributeWithValueEnding(h2, tokenQueue.q()));
        } else if (tokenQueue.k("*=")) {
            this.f41842c.add(new Evaluator.AttributeWithValueContaining(h2, tokenQueue.q()));
        } else if (tokenQueue.k("~=")) {
            this.f41842c.add(new Evaluator.AttributeWithValueMatching(h2, Pattern.compile(tokenQueue.q())));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f41841b, tokenQueue.q());
        }
    }

    private void c() {
        String e2 = this.f41840a.e();
        Validate.h(e2);
        this.f41842c.add(new Evaluator.Class(e2.trim()));
    }

    private void d() {
        String e2 = this.f41840a.e();
        Validate.h(e2);
        this.f41842c.add(new Evaluator.Id(e2));
    }

    private void e() {
        String f2 = this.f41840a.f();
        Validate.h(f2);
        if (f2.startsWith("*|")) {
            this.f41842c.add(new CombiningEvaluator.Or(new Evaluator.Tag(Normalizer.b(f2)), new Evaluator.TagEndsWith(Normalizer.b(f2.replace("*|", ":")))));
            return;
        }
        if (f2.contains("|")) {
            f2 = f2.replace("|", ":");
        }
        this.f41842c.add(new Evaluator.Tag(f2.trim()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(char r11) {
        /*
            r10 = this;
            org.jsoup.parser.TokenQueue r0 = r10.f41840a
            r0.i()
            java.lang.String r0 = r10.h()
            org.jsoup.select.Evaluator r0 = t(r0)
            java.util.List<org.jsoup.select.Evaluator> r1 = r10.f41842c
            int r1 = r1.size()
            r2 = 44
            r3 = 0
            r4 = 1
            if (r1 != r4) goto L_0x0033
            java.util.List<org.jsoup.select.Evaluator> r1 = r10.f41842c
            java.lang.Object r1 = r1.get(r3)
            org.jsoup.select.Evaluator r1 = (org.jsoup.select.Evaluator) r1
            boolean r5 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r5 == 0) goto L_0x003a
            if (r11 == r2) goto L_0x003a
            r5 = r1
            org.jsoup.select.CombiningEvaluator$Or r5 = (org.jsoup.select.CombiningEvaluator.Or) r5
            org.jsoup.select.Evaluator r5 = r5.c()
            r6 = 1
            r9 = r5
            r5 = r1
            r1 = r9
            goto L_0x003c
        L_0x0033:
            org.jsoup.select.CombiningEvaluator$And r1 = new org.jsoup.select.CombiningEvaluator$And
            java.util.List<org.jsoup.select.Evaluator> r5 = r10.f41842c
            r1.<init>((java.util.Collection<org.jsoup.select.Evaluator>) r5)
        L_0x003a:
            r5 = r1
            r6 = 0
        L_0x003c:
            java.util.List<org.jsoup.select.Evaluator> r7 = r10.f41842c
            r7.clear()
            r7 = 62
            r8 = 2
            if (r11 != r7) goto L_0x0057
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            r2[r3] = r0
            org.jsoup.select.StructuralEvaluator$ImmediateParent r0 = new org.jsoup.select.StructuralEvaluator$ImmediateParent
            r0.<init>(r1)
            r2[r4] = r0
            r11.<init>((org.jsoup.select.Evaluator[]) r2)
            goto L_0x00ae
        L_0x0057:
            r7 = 32
            if (r11 != r7) goto L_0x006c
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            r2[r3] = r0
            org.jsoup.select.StructuralEvaluator$Parent r0 = new org.jsoup.select.StructuralEvaluator$Parent
            r0.<init>(r1)
            r2[r4] = r0
            r11.<init>((org.jsoup.select.Evaluator[]) r2)
            goto L_0x00ae
        L_0x006c:
            r7 = 43
            if (r11 != r7) goto L_0x0081
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            r2[r3] = r0
            org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling r0 = new org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling
            r0.<init>(r1)
            r2[r4] = r0
            r11.<init>((org.jsoup.select.Evaluator[]) r2)
            goto L_0x00ae
        L_0x0081:
            r7 = 126(0x7e, float:1.77E-43)
            if (r11 != r7) goto L_0x0096
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.Evaluator[] r2 = new org.jsoup.select.Evaluator[r8]
            r2[r3] = r0
            org.jsoup.select.StructuralEvaluator$PreviousSibling r0 = new org.jsoup.select.StructuralEvaluator$PreviousSibling
            r0.<init>(r1)
            r2[r4] = r0
            r11.<init>((org.jsoup.select.Evaluator[]) r2)
            goto L_0x00ae
        L_0x0096:
            if (r11 != r2) goto L_0x00be
            boolean r11 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r11 == 0) goto L_0x00a3
            org.jsoup.select.CombiningEvaluator$Or r1 = (org.jsoup.select.CombiningEvaluator.Or) r1
            r1.e(r0)
            r11 = r1
            goto L_0x00ae
        L_0x00a3:
            org.jsoup.select.CombiningEvaluator$Or r11 = new org.jsoup.select.CombiningEvaluator$Or
            r11.<init>()
            r11.e(r1)
            r11.e(r0)
        L_0x00ae:
            if (r6 == 0) goto L_0x00b7
            r0 = r5
            org.jsoup.select.CombiningEvaluator$Or r0 = (org.jsoup.select.CombiningEvaluator.Or) r0
            r0.b(r11)
            goto L_0x00b8
        L_0x00b7:
            r5 = r11
        L_0x00b8:
            java.util.List<org.jsoup.select.Evaluator> r11 = r10.f41842c
            r11.add(r5)
            return
        L_0x00be:
            org.jsoup.select.Selector$SelectorParseException r0 = new org.jsoup.select.Selector$SelectorParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown combinator: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r0.<init>(r11, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.f(char):void");
    }

    private int g() {
        String trim = this.f41840a.b(")").trim();
        Validate.e(StringUtil.f(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String h() {
        StringBuilder sb = new StringBuilder();
        while (!this.f41840a.j()) {
            if (this.f41840a.l("(")) {
                sb.append("(");
                sb.append(this.f41840a.a('(', ')'));
                sb.append(")");
            } else if (this.f41840a.l("[")) {
                sb.append("[");
                sb.append(this.f41840a.a('[', ']'));
                sb.append("]");
            } else if (this.f41840a.n(f41836d)) {
                break;
            } else {
                sb.append(this.f41840a.c());
            }
        }
        return sb.toString();
    }

    private void i(boolean z2) {
        String str;
        TokenQueue tokenQueue = this.f41840a;
        if (z2) {
            str = ":containsOwn";
        } else {
            str = ":contains";
        }
        tokenQueue.d(str);
        String s2 = TokenQueue.s(this.f41840a.a('(', ')'));
        Validate.i(s2, ":contains(text) query must not be empty");
        if (z2) {
            this.f41842c.add(new Evaluator.ContainsOwnText(s2));
        } else {
            this.f41842c.add(new Evaluator.ContainsText(s2));
        }
    }

    private void j() {
        this.f41840a.d(":containsData");
        String s2 = TokenQueue.s(this.f41840a.a('(', ')'));
        Validate.i(s2, ":containsData(text) query must not be empty");
        this.f41842c.add(new Evaluator.ContainsData(s2));
    }

    private void k(boolean z2, boolean z3) {
        int i2;
        String b2 = Normalizer.b(this.f41840a.b(")"));
        Matcher matcher = f41838f.matcher(b2);
        Matcher matcher2 = f41839g.matcher(b2);
        int i3 = 2;
        int i4 = 1;
        if (!"odd".equals(b2)) {
            if ("even".equals(b2)) {
                i4 = 0;
            } else if (matcher.matches()) {
                if (matcher.group(3) != null) {
                    i2 = Integer.parseInt(matcher.group(1).replaceFirst("^\\+", ""));
                } else {
                    i2 = 1;
                }
                if (matcher.group(4) != null) {
                    i4 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                } else {
                    i4 = 0;
                }
                i3 = i2;
            } else if (matcher2.matches()) {
                i4 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i3 = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", b2);
            }
        }
        if (z3) {
            if (z2) {
                this.f41842c.add(new Evaluator.IsNthLastOfType(i3, i4));
            } else {
                this.f41842c.add(new Evaluator.IsNthOfType(i3, i4));
            }
        } else if (z2) {
            this.f41842c.add(new Evaluator.IsNthLastChild(i3, i4));
        } else {
            this.f41842c.add(new Evaluator.IsNthChild(i3, i4));
        }
    }

    private void l() {
        if (this.f41840a.k("#")) {
            d();
        } else if (this.f41840a.k(".")) {
            c();
        } else if (this.f41840a.p() || this.f41840a.l("*|")) {
            e();
        } else if (this.f41840a.l("[")) {
            b();
        } else if (this.f41840a.k("*")) {
            a();
        } else if (this.f41840a.k(":lt(")) {
            p();
        } else if (this.f41840a.k(":gt(")) {
            o();
        } else if (this.f41840a.k(":eq(")) {
            n();
        } else if (this.f41840a.l(":has(")) {
            m();
        } else if (this.f41840a.l(":contains(")) {
            i(false);
        } else if (this.f41840a.l(":containsOwn(")) {
            i(true);
        } else if (this.f41840a.l(":containsData(")) {
            j();
        } else if (this.f41840a.l(":matches(")) {
            q(false);
        } else if (this.f41840a.l(":matchesOwn(")) {
            q(true);
        } else if (this.f41840a.l(":not(")) {
            r();
        } else if (this.f41840a.k(":nth-child(")) {
            k(false, false);
        } else if (this.f41840a.k(":nth-last-child(")) {
            k(true, false);
        } else if (this.f41840a.k(":nth-of-type(")) {
            k(false, true);
        } else if (this.f41840a.k(":nth-last-of-type(")) {
            k(true, true);
        } else if (this.f41840a.k(":first-child")) {
            this.f41842c.add(new Evaluator.IsFirstChild());
        } else if (this.f41840a.k(":last-child")) {
            this.f41842c.add(new Evaluator.IsLastChild());
        } else if (this.f41840a.k(":first-of-type")) {
            this.f41842c.add(new Evaluator.IsFirstOfType());
        } else if (this.f41840a.k(":last-of-type")) {
            this.f41842c.add(new Evaluator.IsLastOfType());
        } else if (this.f41840a.k(":only-child")) {
            this.f41842c.add(new Evaluator.IsOnlyChild());
        } else if (this.f41840a.k(":only-of-type")) {
            this.f41842c.add(new Evaluator.IsOnlyOfType());
        } else if (this.f41840a.k(":empty")) {
            this.f41842c.add(new Evaluator.IsEmpty());
        } else if (this.f41840a.k(":root")) {
            this.f41842c.add(new Evaluator.IsRoot());
        } else {
            throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f41841b, this.f41840a.q());
        }
    }

    private void m() {
        this.f41840a.d(":has");
        String a2 = this.f41840a.a('(', ')');
        Validate.i(a2, ":has(el) subselect must not be empty");
        this.f41842c.add(new StructuralEvaluator.Has(t(a2)));
    }

    private void n() {
        this.f41842c.add(new Evaluator.IndexEquals(g()));
    }

    private void o() {
        this.f41842c.add(new Evaluator.IndexGreaterThan(g()));
    }

    private void p() {
        this.f41842c.add(new Evaluator.IndexLessThan(g()));
    }

    private void q(boolean z2) {
        String str;
        TokenQueue tokenQueue = this.f41840a;
        if (z2) {
            str = ":matchesOwn";
        } else {
            str = ":matches";
        }
        tokenQueue.d(str);
        String a2 = this.f41840a.a('(', ')');
        Validate.i(a2, ":matches(regex) query must not be empty");
        if (z2) {
            this.f41842c.add(new Evaluator.MatchesOwn(Pattern.compile(a2)));
        } else {
            this.f41842c.add(new Evaluator.Matches(Pattern.compile(a2)));
        }
    }

    private void r() {
        this.f41840a.d(":not");
        String a2 = this.f41840a.a('(', ')');
        Validate.i(a2, ":not(selector) subselect must not be empty");
        this.f41842c.add(new StructuralEvaluator.Not(t(a2)));
    }

    public static Evaluator t(String str) {
        try {
            return new QueryParser(str).s();
        } catch (IllegalArgumentException e2) {
            throw new Selector.SelectorParseException(e2.getMessage(), new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public Evaluator s() {
        this.f41840a.i();
        if (this.f41840a.n(f41836d)) {
            this.f41842c.add(new StructuralEvaluator.Root());
            f(this.f41840a.c());
        } else {
            l();
        }
        while (!this.f41840a.j()) {
            boolean i2 = this.f41840a.i();
            if (this.f41840a.n(f41836d)) {
                f(this.f41840a.c());
            } else if (i2) {
                f(' ');
            } else {
                l();
            }
        }
        if (this.f41842c.size() == 1) {
            return this.f41842c.get(0);
        }
        return new CombiningEvaluator.And((Collection<Evaluator>) this.f41842c);
    }
}
