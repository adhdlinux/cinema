package com.utils.subtitle.services.opensubtitlesIo;

import com.movie.FreeMoviesApp;
import com.startapp.de;
import com.utils.subtitle.services.LanguageId;
import com.utils.subtitle.services.SubServiceBase;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class opensubtitlesIO extends SubServiceBase {

    /* renamed from: d  reason: collision with root package name */
    private final String[][] f37759d = {new String[]{"Albanian", "29", "sq", "alb", "0", "30201"}, new String[]{"Arabic", "12", "ar", "ara", "1", "30202"}, new String[]{"Belarusian", "0", "hy", "arm", TraktV2.API_VERSION, "30203"}, new String[]{"Bosnian", "10", "bs", "bos", "3", "30204"}, new String[]{"Bulgarian", "33", "bg", "bul", "4", "30205"}, new String[]{"Catalan", "53", "ca", "cat", "5", "30206"}, new String[]{"Chinese", "17", "zh", "chi", "6", "30207"}, new String[]{"Croatian", "38", "hr", "hrv", "7", "30208"}, new String[]{"Czech", "7", "cs", "cze", "8", "30209"}, new String[]{"Danish", "24", "da", "dan", "9", "30210"}, new String[]{"Dutch", "23", "nl", "dut", "10", "30211"}, new String[]{"English", TraktV2.API_VERSION, "en", "eng", "11", "30212"}, new String[]{"Estonian", "20", "et", "est", "12", "30213"}, new String[]{"Persian", "52", "fa", "per", "13", "30247"}, new String[]{"Finnish", "31", "fi", "fin", "14", "30214"}, new String[]{"French", "8", "fr", "fre", "15", "30215"}, new String[]{"German", "5", de.f34377a, "ger", "16", "30216"}, new String[]{"Greek", "16", "el", "ell", "17", "30217"}, new String[]{"Hebrew", "22", "he", "heb", "18", "30218"}, new String[]{"Hindi", "42", "hi", "hin", "19", "30219"}, new String[]{"Hungarian", "15", "hu", "hun", "20", "30220"}, new String[]{"Icelandic", "6", "is", "ice", "21", "30221"}, new String[]{"Indonesian", "0", "id", "ind", "22", "30222"}, new String[]{"Italian", "9", "it", "ita", "23", "30224"}, new String[]{"Japanese", "11", "ja", "jpn", "24", "30225"}, new String[]{"Korean", "4", "ko", "kor", "25", "30226"}, new String[]{"Latvian", "21", "lv", "lav", "26", "30227"}, new String[]{"Lithuanian", "0", "lt", "lit", "27", "30228"}, new String[]{"Macedonian", "35", "mk", "mac", "28", "30229"}, new String[]{"Malay", "0", "ms", "may", "29", "30248"}, new String[]{"Norwegian", "3", "no", "nor", "30", "30230"}, new String[]{"Polish", "26", "pl", "pol", "31", "30232"}, new String[]{"Portuguese", "32", "pt", "por", "32", "30233"}, new String[]{"PortugueseBrazil", "48", "pb", "pob", "33", "30234"}, new String[]{"Romanian", "13", "ro", "rum", "34", "30235"}, new String[]{"Russian", "27", "ru", "rus", "35", "30236"}, new String[]{"Serbian", "36", "sr", "scc", "36", "30237"}, new String[]{"Slovak", "37", "sk", "slo", "37", "30238"}, new String[]{"Slovenian", "1", "sl", "slv", "38", "30239"}, new String[]{"Spanish", "28", "es", "spa", "39", "30240"}, new String[]{"Swedish", "25", "sv", "swe", "40", "30242"}, new String[]{"Thai", "0", "th", "tha", "41", "30243"}, new String[]{"Turkish", "30", "tr", "tur", "42", "30244"}, new String[]{"Ukrainian", "46", "uk", "ukr", "43", "30245"}, new String[]{"Vietnamese", "51", "vi", "vie", "44", "30246"}, new String[]{"BosnianLatin", "10", "bs", "bos", "100", "30204"}, new String[]{"Farsi", "52", "fa", "per", "13", "30247"}, new String[]{"English {US}", TraktV2.API_VERSION, "en", "eng", "100", "30212"}, new String[]{"English {UK}", TraktV2.API_VERSION, "en", "eng", "100", "30212"}, new String[]{"Portuguese {Brazilian}", "48", "pt-br", "pob", "100", "30234"}, new String[]{"Portuguese {Brazil}", "48", "pb", "pob", "33", "30234"}, new String[]{"Portuguese-BR", "48", "pb", "pob", "33", "30234"}, new String[]{"Brazilian", "48", "pb", "pob", "33", "30234"}, new String[]{"Español {Latinoamérica}", "28", "es", "spa", "100", "30240"}, new String[]{"Español {España}", "28", "es", "spa", "100", "30240"}, new String[]{"Spanish {Latin America}", "28", "es", "spa", "100", "30240"}, new String[]{"Español", "28", "es", "spa", "100", "30240"}, new String[]{"SerbianLatin", "36", "sr", "scc", "100", "30237"}, new String[]{"Spanish {Spain}", "28", "es", "spa", "100", "30240"}, new String[]{"Chinese {Traditional}", "17", "zh", "chi", "100", "30207"}, new String[]{"Chinese {Simplified}", "17", "zh", "chi", "100", "30207"}};

    /* renamed from: e  reason: collision with root package name */
    private final String f37760e = "https://opensubtitles-v3.strem.io";

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b A[Catch:{ Exception -> 0x013a }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053 A[Catch:{ Exception -> 0x013a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ef A[Catch:{ Exception -> 0x013a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(com.movie.data.model.MovieInfo r18, io.reactivex.ObservableEmitter<? super java.util.ArrayList<com.utils.subtitle.SubtitleInfo>> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "subscriber"
            kotlin.jvm.internal.Intrinsics.f(r2, r3)
            kotlin.jvm.internal.Intrinsics.c(r18)     // Catch:{ Exception -> 0x013a }
            java.lang.Integer r3 = r18.getType()     // Catch:{ Exception -> 0x013a }
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x013a }
            if (r3 != r5) goto L_0x001f
            r3 = 1
            goto L_0x0020
        L_0x001f:
            r3 = 0
        L_0x0020:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x013a }
            r6.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r1.name     // Catch:{ Exception -> 0x013a }
            r8 = 32
            if (r3 == 0) goto L_0x0053
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r3.<init>()     // Catch:{ Exception -> 0x013a }
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            r3.append(r8)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r1.year     // Catch:{ Exception -> 0x013a }
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x013a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r7.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = "/movie/"
            r7.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = r1.imdbIDStr     // Catch:{ Exception -> 0x013a }
            r7.append(r1)     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x013a }
            goto L_0x00b6
        L_0x0053:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r3.<init>()     // Catch:{ Exception -> 0x013a }
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = " S"
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r1.session     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = "session"
            kotlin.jvm.internal.Intrinsics.e(r7, r9)     // Catch:{ Exception -> 0x013a }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = com.original.tase.utils.Utils.i(r7)     // Catch:{ Exception -> 0x013a }
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            r7 = 69
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r1.eps     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = "eps"
            kotlin.jvm.internal.Intrinsics.e(r7, r9)     // Catch:{ Exception -> 0x013a }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = com.original.tase.utils.Utils.i(r7)     // Catch:{ Exception -> 0x013a }
            r3.append(r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x013a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r7.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = "/series/"
            r7.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = r1.imdbIDStr     // Catch:{ Exception -> 0x013a }
            r7.append(r9)     // Catch:{ Exception -> 0x013a }
            r9 = 58
            r7.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.Integer r10 = r18.getSession()     // Catch:{ Exception -> 0x013a }
            r7.append(r10)     // Catch:{ Exception -> 0x013a }
            r7.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.Integer r1 = r18.getEps()     // Catch:{ Exception -> 0x013a }
            r7.append(r1)     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x013a }
        L_0x00b6:
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.f40434a     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = "%s/subtitles%s.json"
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x013a }
            java.lang.String r11 = r0.f37760e     // Catch:{ Exception -> 0x013a }
            r10[r4] = r11     // Catch:{ Exception -> 0x013a }
            r10[r5] = r1     // Catch:{ Exception -> 0x013a }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r10, r9)     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = java.lang.String.format(r7, r1)     // Catch:{ Exception -> 0x013a }
            java.lang.String r5 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.e(r1, r5)     // Catch:{ Exception -> 0x013a }
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r0.f37760e     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = r5.o(r1, r7)     // Catch:{ Exception -> 0x013a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x013a }
            r5.<init>(r1)     // Catch:{ Exception -> 0x013a }
            java.lang.String r1 = "subtitles"
            org.json.JSONArray r1 = r5.getJSONArray(r1)     // Catch:{ Exception -> 0x013a }
            java.util.ArrayList r5 = r17.n()     // Catch:{ Exception -> 0x013a }
            int r7 = r1.length()     // Catch:{ Exception -> 0x013a }
        L_0x00ed:
            if (r4 >= r7) goto L_0x0136
            org.json.JSONObject r9 = r1.getJSONObject(r4)     // Catch:{ Exception -> 0x013a }
            java.lang.String r10 = "url"
            java.lang.String r13 = r9.getString(r10)     // Catch:{ Exception -> 0x013a }
            java.lang.String r10 = "id"
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x013a }
            java.lang.String r11 = "lang"
            java.lang.String r9 = r9.getString(r11)     // Catch:{ Exception -> 0x013a }
            boolean r11 = r5.contains(r9)     // Catch:{ Exception -> 0x013a }
            if (r11 == 0) goto L_0x0133
            com.utils.subtitle.SubtitleInfo r15 = new com.utils.subtitle.SubtitleInfo     // Catch:{ Exception -> 0x013a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            r11.<init>()     // Catch:{ Exception -> 0x013a }
            r11.append(r3)     // Catch:{ Exception -> 0x013a }
            r11.append(r8)     // Catch:{ Exception -> 0x013a }
            r11.append(r10)     // Catch:{ Exception -> 0x013a }
            java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x013a }
            com.utils.subtitle.services.LanguageId r10 = com.utils.subtitle.services.LanguageId.a()     // Catch:{ Exception -> 0x013a }
            java.lang.String r14 = r10.b(r9)     // Catch:{ Exception -> 0x013a }
            r9 = -1
            com.utils.subtitle.SubtitleInfo$Source r16 = com.utils.subtitle.SubtitleInfo.Source.opensubtitlesIO     // Catch:{ Exception -> 0x013a }
            r11 = r15
            r10 = r15
            r15 = r9
            r11.<init>(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x013a }
            r6.add(r10)     // Catch:{ Exception -> 0x013a }
        L_0x0133:
            int r4 = r4 + 1
            goto L_0x00ed
        L_0x0136:
            r2.onNext(r6)     // Catch:{ Exception -> 0x013a }
            goto L_0x0142
        L_0x013a:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2.onNext(r1)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.services.opensubtitlesIo.opensubtitlesIO.j(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    public final ArrayList<String> n() {
        boolean z2;
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})));
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.c(stringSet);
        for (String next : stringSet) {
            String d2 = LanguageId.a().d(next);
            Intrinsics.e(d2, "getOpenLangIDByIsoLang(...)");
            if (d2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                arrayList.add(LanguageId.a().d(next));
            }
        }
        return arrayList;
    }
}
