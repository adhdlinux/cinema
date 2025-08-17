package com.original.tase.search;

import com.facebook.ads.internal.c.a;
import com.facebook.common.util.UriUtil;
import com.google.gson.Gson;
import com.original.tase.Logger;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.search.model.DuckduckResult;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import com.squareup.duktape.Duktape;
import com.utils.Getlink.Provider.BaseProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class SearchHelper {
    public static String a(String str, String str2, String str3, String str4, String str5) {
        if (str4.contains(UriUtil.HTTP_SCHEME)) {
            str4 = BaseProvider.i(str4);
        }
        if (!str3.isEmpty()) {
            str3 = " " + str3;
        }
        if (!str5.isEmpty()) {
            str5 = str5 + " ";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("referer", "https://www.bing.com" + "/");
        hashMap.put("cookie", "SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1");
        String format = String.format("https://www.bing.com" + "/search/?q=%s", new Object[]{Utils.k(String.format("site:%s %s%s%s", new Object[]{str4, str5, str, str3}), new boolean[0])});
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format + "##forceNoCache##", hashMap)).q0("ol#b_results").g("a[h][href]").iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String c2 = element.c("href");
                String lowerCase = TitleHelper.h(element.v0().replaceAll("<[^>]*>", ""), "").toLowerCase();
                String lowerCase2 = TitleHelper.h(str5 + str + str2 + str3, "").toLowerCase();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str);
                sb.append(str3);
                String lowerCase3 = TitleHelper.h(sb.toString(), "").toLowerCase();
                if ((lowerCase.startsWith(lowerCase2) && c2.contains(str4)) || (lowerCase.startsWith(lowerCase3) && c2.contains(str4))) {
                    return c2;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static List<String> b(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        if (str4.contains(UriUtil.HTTP_SCHEME)) {
            str4 = BaseProvider.i(str4);
        }
        if (!str3.isEmpty()) {
            str3 = " " + str3;
        }
        if (!str5.isEmpty()) {
            str5 = str5 + " ";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("cookie", "SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1");
        String format = String.format("https://www.bing.com" + "/search/?q=%s", new Object[]{Utils.k(String.format("site:%s %s%s%s", new Object[]{str4, str5, str, str3}), new boolean[0])});
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format + "##forceNoCache##", hashMap)).q0("ol#b_results").g("a[h][href]").iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String c2 = element.c("href");
                String lowerCase = TitleHelper.h(element.v0().replaceAll("<[^>]*>", ""), "").toLowerCase();
                String lowerCase2 = TitleHelper.h(str5 + str + str2 + str3, "").toLowerCase();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str);
                sb.append(str3);
                String lowerCase3 = TitleHelper.h(sb.toString(), "").toLowerCase();
                if ((lowerCase.startsWith(lowerCase2) && c2.contains(str4)) || (lowerCase.startsWith(lowerCase3) && c2.contains(str4))) {
                    arrayList.add(c2);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static List<String> c(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (str4.contains(UriUtil.HTTP_SCHEME)) {
            str4 = BaseProvider.i(str4);
        }
        if (!str3.isEmpty()) {
            str6 = " " + str3;
        } else {
            str6 = "";
        }
        if (!str5.isEmpty()) {
            str5 = str5 + " ";
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("cookie", "SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1;");
        String m2 = HttpHelper.i().m("https://duckduckgo.com/?q=" + Utils.k(String.format("site:%s inurl:%s%s%s", new Object[]{str4, str5, str, str6}), new boolean[0]) + "##forceNoCache##", hashMap);
        String a2 = Regex.a(m2, "nrj\\(['\"]([^'\"]+)['\"]\\)", 1);
        if (a2.startsWith("/")) {
            a2 = "https://duckduckgo.com" + a2;
        }
        String a3 = Regex.a(m2, "DDG.deep.initialize\\(['\"]([^'\"]+)['\"]\\)", 1);
        if (a3.startsWith("/")) {
            a3 = "https://links.duckduckgo.com" + a3;
        }
        hashMap.put("referer", "https://duckduckgo.com/");
        String a4 = Regex.a(HttpHelper.i().m(a2, hashMap), "DDG.pageLayout.load\\('d',(.+[\\]])\\);DDG", 1);
        if (a4.isEmpty()) {
            a4 = Regex.a(HttpHelper.i().m(a3, hashMap), "DDG.pageLayout.load\\('d',(.+[\\]])\\);DDG", 1);
        }
        if (!a4.isEmpty()) {
            try {
                DuckduckResult duckduckResult = (DuckduckResult) new Gson().l(String.format("{\"data\": %s}", new Object[]{a4}), DuckduckResult.class);
                if (duckduckResult != null) {
                    for (DuckduckResult.DataBean next : duckduckResult.a()) {
                        String lowerCase = TitleHelper.h(next.b().replaceAll("<[^>]*>", ""), "").toLowerCase();
                        String lowerCase2 = TitleHelper.h(str5 + str + str2 + str6, "").toLowerCase();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str5);
                        sb.append(str);
                        sb.append(str6);
                        String lowerCase3 = TitleHelper.h(sb.toString(), "").toLowerCase();
                        if ((lowerCase.startsWith(lowerCase2) && next.a().contains(str4)) || (lowerCase.startsWith(lowerCase3) && next.a().contains(str4))) {
                            arrayList.add(next.c());
                        }
                    }
                }
            } catch (Throwable unused) {
                Logger.b("SearchHelper exeption ", str4);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(b(str, str2, str3, str4, str5));
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(f(str, str2, str3, str4, str5));
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(d(str, str2, str3, str4, str5));
        }
        return arrayList;
    }

    public static List<String> d(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        String G = com.utils.Utils.G();
        if (str4.contains(UriUtil.HTTP_SCHEME)) {
            str4 = BaseProvider.i(str4);
        }
        if (!str3.isEmpty()) {
            str3 = " " + str3;
        }
        if (!str5.isEmpty()) {
            str5 = str5 + " ";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("accept-language", "en-US;q=0.9,en;q=0.8");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(String.format(G + "/search?q=%s", new Object[]{Utils.k(String.format("site:%s %s%s%s", new Object[]{str4, str5, str, str3}), new boolean[0])}), hashMap)).q0("div#search").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String c2 = element.c("href");
                String lowerCase = TitleHelper.h(element.r0("h3").v0().replaceAll("<[^>]*>", ""), "").toLowerCase();
                String lowerCase2 = TitleHelper.h(str5 + str + str2 + str3, "").toLowerCase();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str);
                sb.append(str3);
                String lowerCase3 = TitleHelper.h(sb.toString(), "").toLowerCase();
                if (((lowerCase.startsWith(lowerCase2) && c2.contains(str4)) || (lowerCase.startsWith(lowerCase3) && c2.contains(str4))) && !arrayList.contains(c2)) {
                    arrayList.add(c2);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static String e(String str, String str2, String str3, String str4, String str5) {
        new ArrayList();
        String G = com.utils.Utils.G();
        if (str4.contains(UriUtil.HTTP_SCHEME)) {
            str4 = BaseProvider.i(str4);
        }
        if (!str3.isEmpty()) {
            str3 = " " + str3;
        }
        if (!str5.isEmpty()) {
            str5 = str5 + " ";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("referer", G + "/");
        hashMap.put("cookie", "SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1");
        String format = String.format(G + "/search?q=%s", new Object[]{Utils.k(String.format("site:%s %s%s%s", new Object[]{str4, str5, str, str3}), new boolean[0])});
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format + "##forceNoCache##", hashMap)).q0("div[class=g]").iterator();
        while (it2.hasNext()) {
            try {
                Element r02 = ((Element) it2.next()).r0(a.f20042a);
                String c2 = r02.c("href");
                String lowerCase = TitleHelper.h(r02.r0("h3").v0().replaceAll("<[^>]*>", ""), "").toLowerCase();
                String lowerCase2 = TitleHelper.h(str5 + str + str2 + str3, "").toLowerCase();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str);
                sb.append(str3);
                String lowerCase3 = TitleHelper.h(sb.toString(), "").toLowerCase();
                if ((lowerCase.startsWith(lowerCase2) && c2.contains(str4)) || (lowerCase.startsWith(lowerCase3) && c2.contains(str4))) {
                    return c2;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    /* JADX INFO: finally extract failed */
    public static ArrayList f(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8;
        String str9 = str;
        String str10 = str4;
        if (str10.contains(UriUtil.HTTP_SCHEME)) {
            str6 = BaseProvider.i(str4);
        } else {
            str6 = str10;
        }
        if (!str3.isEmpty()) {
            str7 = " " + str3;
        } else {
            str7 = str3;
        }
        if (!str5.isEmpty()) {
            str8 = str5 + " ";
        } else {
            str8 = str5;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("referer", "https://yandex.com" + "/");
        String k2 = Utils.k(String.format("site:%s inurl:%s%s%s", new Object[]{str6, str8, str9, str7}), new boolean[0]);
        String m2 = HttpHelper.i().m("https://yandex.com" + "/", hashMap);
        Regex.a(m2, "['\"]reqid['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        String a2 = Regex.a(m2, "['\"]msid['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate("function _generateReqID(n){return(n=n||_random(9)+_random(9))+Date.now().toString().slice(-7)+_random(7)}function _random(n){return Math.random().toString().slice(2,Math.min(n,10)+2)}_generateReqID();");
            create.close();
            String format = String.format("https://yandex.com" + "/search/?msid=%s&text=%s&suggest_reqid=%s", new Object[]{a2, k2, evaluate.toString()});
            Iterator it2 = Jsoup.b(HttpHelper.i().m(format + "##forceNoCache##", hashMap)).q0("li.serp-item").g("a[data-bem][href]").iterator();
            while (it2.hasNext()) {
                try {
                    Element element = (Element) it2.next();
                    String c2 = element.c("href");
                    String lowerCase = TitleHelper.h(element.r0("div.organic__url-text").v0().replaceAll("<[^>]*>", ""), "").toLowerCase();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str8);
                    sb.append(str9);
                    try {
                        sb.append(str2);
                        sb.append(str7);
                        String lowerCase2 = TitleHelper.h(sb.toString(), "").toLowerCase();
                        String lowerCase3 = TitleHelper.h(str8 + str9 + str7, "").toLowerCase();
                        if (((lowerCase.startsWith(lowerCase2) && c2.contains(str6)) || (lowerCase.startsWith(lowerCase3) && c2.contains(str6))) && !arrayList.contains(c2)) {
                            arrayList.add(c2);
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    String str11 = str2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
