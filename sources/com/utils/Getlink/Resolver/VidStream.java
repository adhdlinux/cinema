package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class VidStream extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    private final String f37552e = Deobfuscator$app$ProductionRelease.a(-255301159432388L);

    /* renamed from: f  reason: collision with root package name */
    private final String f37553f = Deobfuscator$app$ProductionRelease.a(-255253914792132L);

    /* renamed from: g  reason: collision with root package name */
    private String f37554g = Deobfuscator$app$ProductionRelease.a(-255949699494084L);

    private final String n(String str) {
        String obj = StringsKt___StringsKt.T0(str).toString();
        String a2 = Deobfuscator$app$ProductionRelease.a(-252822963302596L);
        Iterable<String> Q0 = StringsKt___StringsKt.Q0(obj, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(Q0, 10));
        for (String parseInt : Q0) {
            arrayList.add(Character.valueOf((char) Integer.parseInt(parseInt, CharsKt__CharJVMKt.a(16))));
        }
        String J = CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-252410646442180L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String a3 = Deobfuscator$app$ProductionRelease.a(-252440711213252L);
        for (int i2 = 0; i2 < J.length(); i2++) {
            a3 = a3 + ((char) (J.charAt(i2) ^ a2.charAt(i2 % a2.length())));
        }
        return a3;
    }

    private final String o(String str) {
        boolean z2;
        String obj = StringsKt___StringsKt.T0(str).toString();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < obj.length()) {
            char charAt = obj.charAt(i2);
            int i4 = i3 + 1;
            if (i3 % 2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                sb.append(charAt);
            }
            i2++;
            i3 = i4;
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, Deobfuscator$app$ProductionRelease.a(-252054164156612L));
        String d2 = BaseProvider.d(sb2);
        Intrinsics.e(d2, Deobfuscator$app$ProductionRelease.a(-252625394806980L));
        return d2;
    }

    private final String p(String str) {
        String d2 = BaseProvider.d(StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(StringsKt___StringsKt.T0(str).toString(), Deobfuscator$app$ProductionRelease.a(-250941767626948L), Deobfuscator$app$ProductionRelease.a(-250933177692356L), false, 4, (Object) null), Deobfuscator$app$ProductionRelease.a(-250958947496132L), Deobfuscator$app$ProductionRelease.a(-250950357561540L), false, 4, (Object) null));
        String a2 = Deobfuscator$app$ProductionRelease.a(-250907407888580L);
        Intrinsics.c(d2);
        int length = d2.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = d2.charAt(i2);
            a2 = a2 + ((char) (charAt - 7));
        }
        return a2;
    }

    private final String q(String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        String obj = StringsKt___StringsKt.T0(str).toString();
        ArrayList arrayList = new ArrayList(obj.length());
        for (int i3 = 0; i3 < obj.length(); i3++) {
            char charAt = obj.charAt(i3);
            boolean z5 = true;
            if ('a' > charAt || charAt >= 'n') {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && ('A' > charAt || charAt >= 'N')) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                i2 = charAt + 13;
            } else {
                if ('n' > charAt || charAt >= '{') {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!z4 && ('N' > charAt || charAt >= '[')) {
                    z5 = false;
                }
                if (z5) {
                    i2 = charAt - 13;
                } else {
                    arrayList.add(Character.valueOf(charAt));
                }
            }
            charAt = (char) i2;
            arrayList.add(Character.valueOf(charAt));
        }
        String d2 = BaseProvider.d(StringsKt___StringsKt.T0(CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-251826530889924L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
        Intrinsics.e(d2, Deobfuscator$app$ProductionRelease.a(-251856595660996L));
        return d2;
    }

    private final String r(String str) {
        String a2 = Deobfuscator$app$ProductionRelease.a(-252092818862276L);
        Iterable<String> Q0 = StringsKt___StringsKt.Q0(str, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(Q0, 10));
        for (String parseInt : Q0) {
            arrayList.add(Character.valueOf((char) Integer.parseInt(parseInt, CharsKt__CharJVMKt.a(16))));
        }
        String J = CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-252225962848452L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String a3 = Deobfuscator$app$ProductionRelease.a(-252221667881156L);
        for (int i2 = 0; i2 < J.length(); i2++) {
            a3 = a3 + ((char) (J.charAt(i2) ^ a2.charAt(i2 % a2.length())));
        }
        String a4 = Deobfuscator$app$ProductionRelease.a(-251908135268548L);
        int length = a3.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = a3.charAt(i3);
            a4 = a4 + ((char) (charAt - 3));
        }
        String d2 = BaseProvider.d(a4);
        Intrinsics.e(d2, Deobfuscator$app$ProductionRelease.a(-251903840301252L));
        return d2;
    }

    private final String s(String str) {
        String d2 = BaseProvider.d(StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(StringsKt___StringsKt.T0(str).toString(), Deobfuscator$app$ProductionRelease.a(-250903112921284L), Deobfuscator$app$ProductionRelease.a(-250928882725060L), false, 4, (Object) null), Deobfuscator$app$ProductionRelease.a(-250920292790468L), Deobfuscator$app$ProductionRelease.a(-250877343117508L), false, 4, (Object) null));
        String a2 = Deobfuscator$app$ProductionRelease.a(-250868753182916L);
        Intrinsics.c(d2);
        int length = d2.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = d2.charAt(i2);
            a2 = a2 + ((char) (charAt - 3));
        }
        return a2;
    }

    private final String t(String str) {
        String obj = StringsKt___StringsKt.T0(str).toString();
        ArrayList arrayList = new ArrayList(obj.length());
        for (int i2 = 0; i2 < obj.length(); i2++) {
            arrayList.add(Character.valueOf((char) (obj.charAt(i2) - 1)));
        }
        Iterable<String> Q0 = StringsKt___StringsKt.Q0(CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-252436416245956L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), 2);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(Q0, 10));
        for (String parseInt : Q0) {
            arrayList2.add(Character.valueOf((char) Integer.parseInt(parseInt, CharsKt__CharJVMKt.a(16))));
        }
        return CollectionsKt___CollectionsKt.J(arrayList2, Deobfuscator$app$ProductionRelease.a(-252432121278660L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String u(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 3;
            String substring = str.substring(i2, Math.min(i3, str.length()));
            Intrinsics.e(substring, Deobfuscator$app$ProductionRelease.a(-253656186958020L));
            arrayList.add(substring);
            i2 = i3;
        }
        return CollectionsKt___CollectionsKt.J(CollectionsKt___CollectionsKt.P(arrayList), Deobfuscator$app$ProductionRelease.a(-252097113829572L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String v(String str, String str2) {
        switch (str.hashCode()) {
            case -2067013265:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253785035976900L))) {
                    return y(str2);
                }
                break;
            case -1611365689:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253089251274948L))) {
                    return x(str2);
                }
                break;
            case -1222770887:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253832280617156L))) {
                    return o(str2);
                }
                break;
            case -1176510395:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253952539701444L))) {
                    return u(str2);
                }
                break;
            case -1120108789:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253965424603332L))) {
                    return s(str2);
                }
                break;
            case -235832515:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253879525257412L))) {
                    return n(str2);
                }
                break;
            case -67178318:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253475798331588L))) {
                    return p(str2);
                }
                break;
            case 128189634:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253772151075012L))) {
                    return w(str2);
                }
                break;
            case 258656854:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253523042971844L))) {
                    return t(str2);
                }
                break;
            case 1132519359:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253462913429700L))) {
                    return q(str2);
                }
                break;
            case 1900419062:
                if (str.equals(Deobfuscator$app$ProductionRelease.a(-253102136176836L))) {
                    return r(str2);
                }
                break;
        }
        return null;
    }

    private final String w(String str) {
        String substring = str.substring(10, str.length() - 16);
        Intrinsics.e(substring, Deobfuscator$app$ProductionRelease.a(-252427826311364L));
        String a2 = Deobfuscator$app$ProductionRelease.a(-251074911613124L);
        String d2 = BaseProvider.d(substring);
        String substring2 = StringsKt__StringsJVMKt.y(a2, ((d2.length() + a2.length()) - 1) / a2.length()).substring(0, d2.length());
        Intrinsics.e(substring2, Deobfuscator$app$ProductionRelease.a(-251208055599300L));
        String a3 = Deobfuscator$app$ProductionRelease.a(-250748494098628L);
        for (int i2 = 0; i2 < d2.length(); i2++) {
            a3 = a3 + ((char) (d2.charAt(i2) ^ substring2.charAt(i2)));
        }
        return a3;
    }

    private final String x(String str) {
        String d2 = BaseProvider.d(StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(StringsKt___StringsKt.T0(str).toString(), Deobfuscator$app$ProductionRelease.a(-250705544425668L), Deobfuscator$app$ProductionRelease.a(-250696954491076L), false, 4, (Object) null), Deobfuscator$app$ProductionRelease.a(-250722724294852L), Deobfuscator$app$ProductionRelease.a(-250714134360260L), false, 4, (Object) null));
        String a2 = Deobfuscator$app$ProductionRelease.a(-250946062594244L);
        Intrinsics.c(d2);
        int length = d2.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = d2.charAt(i2);
            a2 = a2 + ((char) (charAt - 5));
        }
        return a2;
    }

    private final String y(String str) {
        Map j2 = MapsKt__MapsKt.j(TuplesKt.a('x', 'a'), TuplesKt.a('y', 'b'), TuplesKt.a('z', 'c'), TuplesKt.a('a', 'd'), TuplesKt.a('b', 'e'), TuplesKt.a('c', 'f'), TuplesKt.a('d', 'g'), TuplesKt.a('e', 'h'), TuplesKt.a('f', 'i'), TuplesKt.a('g', 'j'), TuplesKt.a('h', 'k'), TuplesKt.a('i', 'l'), TuplesKt.a('j', 'm'), TuplesKt.a('k', 'n'), TuplesKt.a('l', 'o'), TuplesKt.a('m', 'p'), TuplesKt.a('n', 'q'), TuplesKt.a('o', 'r'), TuplesKt.a('p', 's'), TuplesKt.a('q', 't'), TuplesKt.a('r', 'u'), TuplesKt.a('s', 'v'), TuplesKt.a('t', 'w'), TuplesKt.a('u', 'x'), TuplesKt.a('v', 'y'), TuplesKt.a('w', 'z'), TuplesKt.a('X', 'A'), TuplesKt.a('Y', 'B'), TuplesKt.a('Z', 'C'), TuplesKt.a('A', 'D'), TuplesKt.a('B', 'E'), TuplesKt.a('C', 'F'), TuplesKt.a('D', 'G'), TuplesKt.a('E', 'H'), TuplesKt.a('F', 'I'), TuplesKt.a('G', 'J'), TuplesKt.a('H', 'K'), TuplesKt.a('I', 'L'), TuplesKt.a('J', 'M'), TuplesKt.a('K', 'N'), TuplesKt.a('L', 'O'), TuplesKt.a('M', 'P'), TuplesKt.a('N', 'Q'), TuplesKt.a('O', 'R'), TuplesKt.a('P', 'S'), TuplesKt.a('Q', 'T'), TuplesKt.a('R', 'U'), TuplesKt.a('S', 'V'), TuplesKt.a('T', 'W'), TuplesKt.a('U', 'X'), TuplesKt.a('V', 'Y'), TuplesKt.a('W', 'Z'));
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            Character ch = (Character) j2.get(Character.valueOf(charAt));
            if (ch != null) {
                charAt = ch.charValue();
            }
            arrayList.add(Character.valueOf(charAt));
        }
        return CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-250744199131332L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public String c() {
        return Deobfuscator$app$ProductionRelease.a(-256142973022404L);
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        boolean z3;
        Intrinsics.c(mediaSource);
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, Deobfuscator$app$ProductionRelease.a(-256078548512964L), 2, 2);
        Intrinsics.c(b2);
        if (b2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            HashMap<String, String> c2 = Constants.c();
            c2.put(Deobfuscator$app$ProductionRelease.a(-255777900802244L), Deobfuscator$app$ProductionRelease.a(-254373446496452L));
            c2.put(Deobfuscator$app$ProductionRelease.a(-254446460940484L), streamLink);
            c2.put(Deobfuscator$app$ProductionRelease.a(-254412101202116L), Constants.C);
            String m2 = HttpHelper.i().m(streamLink, c2);
            Iterator it2 = Jsoup.b(m2).q0(Deobfuscator$app$ProductionRelease.a(-254124338393284L)).g(Deobfuscator$app$ProductionRelease.a(-254055618916548L)).iterator();
            Intrinsics.e(it2, Deobfuscator$app$ProductionRelease.a(-254008374276292L));
            ArrayList arrayList = new ArrayList();
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            String a2 = Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-254223122641092L), 1);
            HashMap hashMap = new HashMap();
            Intrinsics.c(a2);
            if (StringsKt__StringsJVMKt.G(a2, Deobfuscator$app$ProductionRelease.a(-254910317408452L), false, 2, (Object) null)) {
                a2 = Deobfuscator$app$ProductionRelease.a(-254863072768196L) + a2;
            }
            String j2 = BaseProvider.j(a2);
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-254867367735492L), j2 + '/');
            while (it2.hasNext()) {
                try {
                    Object next = it2.next();
                    Intrinsics.d(next, Deobfuscator$app$ProductionRelease.a(-254833007997124L));
                    String c3 = ((Element) next).c(Deobfuscator$app$ProductionRelease.a(-254571014992068L));
                    String a3 = Regex.a(HttpHelper.i().o(j2 + Deobfuscator$app$ProductionRelease.a(-254802943226052L) + c3, streamLink), Deobfuscator$app$ProductionRelease.a(-254777173422276L), 1);
                    Intrinsics.c(a3);
                    if (StringsKt__StringsJVMKt.G(a3, Deobfuscator$app$ProductionRelease.a(-253209510359236L), false, 2, (Object) null)) {
                        try {
                            a3 = Deobfuscator$app$ProductionRelease.a(-253230985195716L) + a3;
                        } catch (Throwable unused) {
                        }
                    } else {
                        Intrinsics.c(a3);
                        if (StringsKt__StringsJVMKt.G(a3, Deobfuscator$app$ProductionRelease.a(-253166560686276L), false, 2, (Object) null)) {
                            a3 = j2 + a3;
                        }
                    }
                    Element r02 = Jsoup.b(HttpHelper.i().o(a3, j2 + Deobfuscator$app$ProductionRelease.a(-253192330490052L) + c3)).r0(Deobfuscator$app$ProductionRelease.a(-253407078854852L));
                    if (r02 != null) {
                        String c4 = r02.c(Deobfuscator$app$ProductionRelease.a(-253329769443524L));
                        String v02 = r02.v0();
                        Intrinsics.c(c4);
                        Intrinsics.c(v02);
                        try {
                            streamLink = v(c4, v02);
                            Intrinsics.c(streamLink);
                            if (streamLink.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                ResolveResult resolveResult = new ResolveResult(c(), streamLink, Deobfuscator$app$ProductionRelease.a(-253007646896324L));
                                resolveResult.setPlayHeader(hashMap);
                                Intrinsics.c(observableEmitter);
                                MediaSource mediaSource2 = mediaSource;
                                try {
                                    MediaSource a4 = BaseResolver.a(mediaSource, resolveResult);
                                    Intrinsics.e(a4, Deobfuscator$app$ProductionRelease.a(-252994761994436L));
                                    try {
                                        observableEmitter.onNext(a4);
                                    } catch (Throwable unused2) {
                                    }
                                } catch (Throwable unused3) {
                                    ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                                }
                            }
                            MediaSource mediaSource3 = mediaSource;
                            ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
                        } catch (Throwable unused4) {
                            MediaSource mediaSource4 = mediaSource;
                            ObservableEmitter<? super MediaSource> observableEmitter22 = observableEmitter;
                        }
                    }
                    MediaSource mediaSource32 = mediaSource;
                    ObservableEmitter<? super MediaSource> observableEmitter32 = observableEmitter;
                } catch (Throwable unused5) {
                    MediaSource mediaSource42 = mediaSource;
                    ObservableEmitter<? super MediaSource> observableEmitter222 = observableEmitter;
                }
            }
        }
    }
}
