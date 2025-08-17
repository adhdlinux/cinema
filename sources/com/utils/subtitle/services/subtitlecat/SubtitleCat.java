package com.utils.subtitle.services.subtitlecat;

import com.movie.FreeMoviesApp;
import com.startapp.de;
import com.utils.subtitle.services.SubServiceBase;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

public final class SubtitleCat extends SubServiceBase {

    /* renamed from: d  reason: collision with root package name */
    private final String[][] f37764d = {new String[]{"Albanian", "29", "sq", "alb", "0", "30201"}, new String[]{"Arabic", "12", "ar", "ara", "1", "30202"}, new String[]{"Belarusian", "0", "hy", "arm", TraktV2.API_VERSION, "30203"}, new String[]{"Bosnian", "10", "bs", "bos", "3", "30204"}, new String[]{"Bulgarian", "33", "bg", "bul", "4", "30205"}, new String[]{"Catalan", "53", "ca", "cat", "5", "30206"}, new String[]{"Chinese", "17", "zh", "chi", "6", "30207"}, new String[]{"Croatian", "38", "hr", "hrv", "7", "30208"}, new String[]{"Czech", "7", "cs", "cze", "8", "30209"}, new String[]{"Danish", "24", "da", "dan", "9", "30210"}, new String[]{"Dutch", "23", "nl", "dut", "10", "30211"}, new String[]{"English", TraktV2.API_VERSION, "en", "eng", "11", "30212"}, new String[]{"Estonian", "20", "et", "est", "12", "30213"}, new String[]{"Persian", "52", "fa", "per", "13", "30247"}, new String[]{"Finnish", "31", "fi", "fin", "14", "30214"}, new String[]{"French", "8", "fr", "fre", "15", "30215"}, new String[]{"German", "5", de.f34377a, "ger", "16", "30216"}, new String[]{"Greek", "16", "el", "ell", "17", "30217"}, new String[]{"Hebrew", "22", "he", "heb", "18", "30218"}, new String[]{"Hindi", "42", "hi", "hin", "19", "30219"}, new String[]{"Hungarian", "15", "hu", "hun", "20", "30220"}, new String[]{"Icelandic", "6", "is", "ice", "21", "30221"}, new String[]{"Indonesian", "0", "id", "ind", "22", "30222"}, new String[]{"Italian", "9", "it", "ita", "23", "30224"}, new String[]{"Japanese", "11", "ja", "jpn", "24", "30225"}, new String[]{"Korean", "4", "ko", "kor", "25", "30226"}, new String[]{"Latvian", "21", "lv", "lav", "26", "30227"}, new String[]{"Lithuanian", "0", "lt", "lit", "27", "30228"}, new String[]{"Macedonian", "35", "mk", "mac", "28", "30229"}, new String[]{"Malay", "0", "ms", "may", "29", "30248"}, new String[]{"Norwegian", "3", "no", "nor", "30", "30230"}, new String[]{"Polish", "26", "pl", "pol", "31", "30232"}, new String[]{"Portuguese", "32", "pt", "por", "32", "30233"}, new String[]{"PortugueseBrazil", "48", "pb", "pob", "33", "30234"}, new String[]{"Romanian", "13", "ro", "rum", "34", "30235"}, new String[]{"Russian", "27", "ru", "rus", "35", "30236"}, new String[]{"Serbian", "36", "sr", "scc", "36", "30237"}, new String[]{"Slovak", "37", "sk", "slo", "37", "30238"}, new String[]{"Slovenian", "1", "sl", "slv", "38", "30239"}, new String[]{"Spanish", "28", "es", "spa", "39", "30240"}, new String[]{"Swedish", "25", "sv", "swe", "40", "30242"}, new String[]{"Thai", "0", "th", "tha", "41", "30243"}, new String[]{"Turkish", "30", "tr", "tur", "42", "30244"}, new String[]{"Ukrainian", "46", "uk", "ukr", "43", "30245"}, new String[]{"Vietnamese", "51", "vi", "vie", "44", "30246"}, new String[]{"BosnianLatin", "10", "bs", "bos", "100", "30204"}, new String[]{"Farsi", "52", "fa", "per", "13", "30247"}, new String[]{"English {US}", TraktV2.API_VERSION, "en", "eng", "100", "30212"}, new String[]{"English {UK}", TraktV2.API_VERSION, "en", "eng", "100", "30212"}, new String[]{"Portuguese {Brazilian}", "48", "pt-br", "pob", "100", "30234"}, new String[]{"Portuguese {Brazil}", "48", "pb", "pob", "33", "30234"}, new String[]{"Portuguese-BR", "48", "pb", "pob", "33", "30234"}, new String[]{"Brazilian", "48", "pb", "pob", "33", "30234"}, new String[]{"Español {Latinoamérica}", "28", "es", "spa", "100", "30240"}, new String[]{"Español {España}", "28", "es", "spa", "100", "30240"}, new String[]{"Spanish {Latin America}", "28", "es", "spa", "100", "30240"}, new String[]{"Español", "28", "es", "spa", "100", "30240"}, new String[]{"SerbianLatin", "36", "sr", "scc", "100", "30237"}, new String[]{"Spanish {Spain}", "28", "es", "spa", "100", "30240"}, new String[]{"Chinese {Traditional}", "17", "zh", "chi", "100", "30207"}, new String[]{"Chinese {Simplified}", "17", "zh", "chi", "100", "30207"}};

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f37765e = MapsKt__MapsKt.j(TuplesKt.a(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"), TuplesKt.a(TheTvdb.HEADER_ACCEPT_LANGUAGE, "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3"), TuplesKt.a("Upgrade-Insecure-Requests", "1"), TuplesKt.a(TraktV2.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded"), TuplesKt.a("Host", "www.subtitlecat.com"), TuplesKt.a("Referer", "https://www.subtitlecat.com/"), TuplesKt.a("Upgrade-Insecure-Requests", "1"));

    /* renamed from: f  reason: collision with root package name */
    private final String f37766f = "https://www.subtitlecat.com";

    public SubtitleCat() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b A[Catch:{ Exception -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ Exception -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ee A[SYNTHETIC, Splitter:B:17:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0138 A[Catch:{ Exception -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x019e A[Catch:{ Exception -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0242 A[Catch:{ Exception -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0196 A[EDGE_INSN: B:71:0x0196->B:35:0x0196 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0189 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(com.movie.data.model.MovieInfo r37, io.reactivex.ObservableEmitter<? super java.util.ArrayList<com.utils.subtitle.SubtitleInfo>> r38) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r38
            java.lang.String r3 = "iterator(...)"
            java.lang.String r4 = "+"
            java.lang.String r5 = "subscriber"
            kotlin.jvm.internal.Intrinsics.f(r2, r5)
            kotlin.jvm.internal.Intrinsics.c(r37)     // Catch:{ Exception -> 0x02d6 }
            java.lang.Integer r5 = r37.getType()     // Catch:{ Exception -> 0x02d6 }
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x02d6 }
            if (r5 != r6) goto L_0x0023
            r5 = 1
            goto L_0x0024
        L_0x0023:
            r5 = 0
        L_0x0024:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x02d6 }
            r8.<init>()     // Catch:{ Exception -> 0x02d6 }
            if (r5 == 0) goto L_0x0034
            java.lang.Integer r5 = r37.getYear()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x02d6 }
            goto L_0x006b
        L_0x0034:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r5.<init>()     // Catch:{ Exception -> 0x02d6 }
            r9 = 83
            r5.append(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = r1.session     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "session"
            kotlin.jvm.internal.Intrinsics.e(r9, r10)     // Catch:{ Exception -> 0x02d6 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = com.original.tase.utils.Utils.i(r9)     // Catch:{ Exception -> 0x02d6 }
            r5.append(r9)     // Catch:{ Exception -> 0x02d6 }
            r9 = 69
            r5.append(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = r1.eps     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "eps"
            kotlin.jvm.internal.Intrinsics.e(r9, r10)     // Catch:{ Exception -> 0x02d6 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = com.original.tase.utils.Utils.i(r9)     // Catch:{ Exception -> 0x02d6 }
            r5.append(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02d6 }
        L_0x006b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r9.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = r1.name     // Catch:{ Exception -> 0x02d6 }
            r9.append(r1)     // Catch:{ Exception -> 0x02d6 }
            r1 = 32
            r9.append(r1)     // Catch:{ Exception -> 0x02d6 }
            r9.append(r5)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = com.original.tase.helper.TitleHelper.h(r1, r4)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.f40434a     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = "%s/index.php?search=%s"
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r10[r7] = r11     // Catch:{ Exception -> 0x02d6 }
            r10[r6] = r1     // Catch:{ Exception -> 0x02d6 }
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = java.lang.String.format(r5, r10)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.e(r5, r10)     // Catch:{ Exception -> 0x02d6 }
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02d6 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r11.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r12 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r11.append(r12)     // Catch:{ Exception -> 0x02d6 }
            r12 = 47
            r11.append(r12)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = r10.o(r5, r11)     // Catch:{ Exception -> 0x02d6 }
            org.jsoup.nodes.Document r5 = org.jsoup.Jsoup.b(r5)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "table.sub-table"
            org.jsoup.select.Elements r5 = r5.q0(r10)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "tr"
            org.jsoup.select.Elements r5 = r5.g(r10)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = "a[href]"
            org.jsoup.select.Elements r5 = r5.g(r10)     // Catch:{ Exception -> 0x02d6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r5, r3)     // Catch:{ Exception -> 0x02d6 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x02d6 }
            r10.<init>()     // Catch:{ Exception -> 0x02d6 }
        L_0x00dc:
            boolean r11 = r5.hasNext()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r13 = "filename"
            java.lang.String r14 = "http"
            java.lang.String r15 = "/"
            java.lang.String r6 = "url"
            java.lang.String r12 = "href"
            java.lang.String r7 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            if (r11 == 0) goto L_0x0196
            java.lang.Object r11 = r5.next()     // Catch:{ Exception -> 0x02d6 }
            org.jsoup.nodes.Element r11 = (org.jsoup.nodes.Element) r11     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = r11.v0()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = r11.c(r12)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.c(r9)     // Catch:{ Exception -> 0x02d6 }
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x02d6 }
            r18 = r5
            java.lang.String r5 = r9.toLowerCase(r12)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r5, r7)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r5 = com.original.tase.helper.TitleHelper.h(r5, r4)     // Catch:{ Exception -> 0x02d6 }
            r19 = r4
            java.lang.String r4 = "replaceAllkeywithTarget(...)"
            kotlin.jvm.internal.Intrinsics.e(r5, r4)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r4 = r1.toLowerCase(r12)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r4, r7)     // Catch:{ Exception -> 0x02d6 }
            r20 = r1
            r1 = 0
            r7 = 0
            r12 = 2
            boolean r4 = kotlin.text.StringsKt__StringsKt.L(r5, r4, r1, r12, r7)     // Catch:{ Exception -> 0x02d6 }
            if (r4 == 0) goto L_0x0189
            if (r11 == 0) goto L_0x0135
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.v(r11)     // Catch:{ Exception -> 0x02d6 }
            if (r1 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r1 = 0
            goto L_0x0136
        L_0x0135:
            r1 = 1
        L_0x0136:
            if (r1 != 0) goto L_0x0189
            r1 = 0
            r4 = 2
            r5 = 0
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.G(r11, r15, r5, r4, r1)     // Catch:{ Exception -> 0x02d6 }
            if (r7 == 0) goto L_0x0152
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r1.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r4 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r1.append(r4)     // Catch:{ Exception -> 0x02d6 }
            r1.append(r11)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x02d6 }
        L_0x0152:
            r1 = 0
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.StringsKt__StringsKt.L(r11, r14, r5, r4, r1)     // Catch:{ Exception -> 0x02d6 }
            if (r1 != 0) goto L_0x0171
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r1.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r4 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r1.append(r4)     // Catch:{ Exception -> 0x02d6 }
            r4 = 47
            r1.append(r4)     // Catch:{ Exception -> 0x02d6 }
            r1.append(r11)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x02d6 }
        L_0x0171:
            r1 = 2
            kotlin.Pair[] r4 = new kotlin.Pair[r1]     // Catch:{ Exception -> 0x02d6 }
            kotlin.Pair r1 = kotlin.TuplesKt.a(r13, r9)     // Catch:{ Exception -> 0x02d6 }
            r5 = 0
            r4[r5] = r1     // Catch:{ Exception -> 0x02d6 }
            kotlin.Pair r1 = kotlin.TuplesKt.a(r6, r11)     // Catch:{ Exception -> 0x02d6 }
            r5 = 1
            r4[r5] = r1     // Catch:{ Exception -> 0x02d6 }
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.j(r4)     // Catch:{ Exception -> 0x02d6 }
            r10.add(r1)     // Catch:{ Exception -> 0x02d6 }
        L_0x0189:
            r5 = r18
            r4 = r19
            r1 = r20
            r6 = 1
            r7 = 0
            r9 = 2
            r12 = 47
            goto L_0x00dc
        L_0x0196:
            boolean r1 = r10.isEmpty()     // Catch:{ Exception -> 0x02d6 }
            r4 = 1
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x02d2
            java.util.ArrayList r1 = r36.n()     // Catch:{ Exception -> 0x02d6 }
            java.util.Iterator r4 = r10.iterator()     // Catch:{ Exception -> 0x02d6 }
        L_0x01a6:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x02d6 }
            if (r5 == 0) goto L_0x02d2
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x02d6 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x02d6 }
            com.original.tase.helper.http.HttpHelper r9 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02d6 }
            java.lang.Object r10 = r5.get(r6)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x02d6 }
            r18 = r4
            r11 = 1
            java.util.Map[] r4 = new java.util.Map[r11]     // Catch:{ Exception -> 0x02d6 }
            java.util.Map<java.lang.String, java.lang.String> r11 = r0.f37765e     // Catch:{ Exception -> 0x02d6 }
            r17 = 0
            r4[r17] = r11     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r4 = r9.m(r10, r4)     // Catch:{ Exception -> 0x02d6 }
            org.jsoup.nodes.Document r4 = org.jsoup.Jsoup.b(r4)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = "div.sub-single"
            org.jsoup.select.Elements r4 = r4.q0(r9)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r9 = "a[id][onclick][href]"
            org.jsoup.select.Elements r4 = r4.g(r9)     // Catch:{ Exception -> 0x02d6 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r4, r3)     // Catch:{ Exception -> 0x02d6 }
        L_0x01e2:
            boolean r9 = r4.hasNext()     // Catch:{ Exception -> 0x02d6 }
            if (r9 == 0) goto L_0x02ce
            java.lang.Object r9 = r4.next()     // Catch:{ Exception -> 0x02d6 }
            org.jsoup.nodes.Element r9 = (org.jsoup.nodes.Element) r9     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r11 = "download_(\\w+)"
            r19 = r3
            r3 = 1
            java.lang.String r10 = com.original.tase.utils.Regex.a(r10, r11, r3)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ Exception -> 0x02d6 }
            java.util.Iterator r11 = r1.iterator()     // Catch:{ Exception -> 0x02d6 }
        L_0x0202:
            boolean r16 = r11.hasNext()     // Catch:{ Exception -> 0x02d6 }
            if (r16 == 0) goto L_0x02ca
            java.lang.Object r16 = r11.next()     // Catch:{ Exception -> 0x02d6 }
            r3 = r16
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.c(r3)     // Catch:{ Exception -> 0x02d6 }
            r16 = r1
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x02d6 }
            r21 = r4
            java.lang.String r4 = r3.toLowerCase(r1)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r4, r7)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.c(r10)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = r10.toLowerCase(r1)     // Catch:{ Exception -> 0x02d6 }
            kotlin.jvm.internal.Intrinsics.e(r1, r7)     // Catch:{ Exception -> 0x02d6 }
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x02d6 }
            if (r1 == 0) goto L_0x02c3
            java.lang.String r1 = r9.c(r12)     // Catch:{ Exception -> 0x02d6 }
            if (r1 == 0) goto L_0x023f
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.v(r1)     // Catch:{ Exception -> 0x02d6 }
            if (r4 == 0) goto L_0x023d
            goto L_0x023f
        L_0x023d:
            r4 = 0
            goto L_0x0240
        L_0x023f:
            r4 = 1
        L_0x0240:
            if (r4 != 0) goto L_0x02c3
            r22 = r6
            r23 = r7
            r4 = 0
            r6 = 2
            r7 = 0
            boolean r24 = kotlin.text.StringsKt__StringsJVMKt.G(r1, r15, r7, r6, r4)     // Catch:{ Exception -> 0x02d6 }
            if (r24 == 0) goto L_0x0260
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r4.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r6 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r4.append(r6)     // Catch:{ Exception -> 0x02d6 }
            r4.append(r1)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x02d6 }
        L_0x0260:
            r4 = 0
            r6 = 2
            r7 = 0
            boolean r17 = kotlin.text.StringsKt__StringsKt.L(r1, r14, r7, r6, r4)     // Catch:{ Exception -> 0x02d6 }
            if (r17 != 0) goto L_0x0280
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d6 }
            r4.<init>()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r6 = r0.f37766f     // Catch:{ Exception -> 0x02d6 }
            r4.append(r6)     // Catch:{ Exception -> 0x02d6 }
            r6 = 47
            r4.append(r6)     // Catch:{ Exception -> 0x02d6 }
            r4.append(r1)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x02d6 }
            goto L_0x0282
        L_0x0280:
            r6 = 47
        L_0x0282:
            r24 = r1
            kotlin.jvm.internal.Intrinsics.c(r24)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r25 = " "
            java.lang.String r26 = "%20"
            r27 = 0
            r28 = 4
            r29 = 0
            java.lang.String r1 = kotlin.text.StringsKt__StringsJVMKt.C(r24, r25, r26, r27, r28, r29)     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r4 = "SubtitleCat"
            com.original.tase.Logger.b(r4, r1)     // Catch:{ Exception -> 0x02d6 }
            com.utils.subtitle.SubtitleInfo r4 = new com.utils.subtitle.SubtitleInfo     // Catch:{ Exception -> 0x02d6 }
            java.lang.Object r17 = r5.get(r13)     // Catch:{ Exception -> 0x02d6 }
            r31 = r17
            java.lang.String r31 = (java.lang.String) r31     // Catch:{ Exception -> 0x02d6 }
            com.utils.subtitle.services.LanguageId r6 = com.utils.subtitle.services.LanguageId.a()     // Catch:{ Exception -> 0x02d6 }
            java.lang.String r33 = r6.c(r3)     // Catch:{ Exception -> 0x02d6 }
            r34 = -1
            com.utils.subtitle.SubtitleInfo$Source r35 = com.utils.subtitle.SubtitleInfo.Source.Subtitlecat     // Catch:{ Exception -> 0x02d6 }
            r30 = r4
            r32 = r1
            r30.<init>(r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x02d6 }
            r8.add(r4)     // Catch:{ Exception -> 0x02d6 }
            r1 = r16
            r4 = r21
            r6 = r22
            r7 = r23
            goto L_0x02c7
        L_0x02c3:
            r1 = r16
            r4 = r21
        L_0x02c7:
            r3 = 1
            goto L_0x0202
        L_0x02ca:
            r3 = r19
            goto L_0x01e2
        L_0x02ce:
            r4 = r18
            goto L_0x01a6
        L_0x02d2:
            r2.onNext(r8)     // Catch:{ Exception -> 0x02d6 }
            goto L_0x02de
        L_0x02d6:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2.onNext(r1)
        L_0x02de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.services.subtitlecat.SubtitleCat.j(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    public final ArrayList<String> n() {
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})));
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.c(stringSet);
        for (String add : stringSet) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
