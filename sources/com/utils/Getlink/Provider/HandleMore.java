package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class HandleMore {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f37340a = new HashMap();

    public static boolean a(String str) {
        if (str.contains("2embed.")) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        if (str.contains("gomo.") || str.contains("gomostream.")) {
            return true;
        }
        return false;
    }

    public static List<String> c(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            String m2 = HttpHelper.i().m(str, new Map[0]);
            Regex.a(m2, "data-movie-id\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
            Iterator it2 = Jsoup.b(m2).q0("a[href][onClick]").iterator();
            Constants.c().put("referer", str);
            while (it2.hasNext()) {
                String a2 = Regex.a(((Element) it2.next()).toString(), "go\\s*\\(['\"]([^'\"]+)['\"]\\)", 1);
                if (!a2.isEmpty()) {
                    String replace = a2.replace("&amp;", "&");
                    String a3 = Regex.a(a2, "\\?\\w+=([0-9a-zA-Z-]+)", 1);
                    if (!a3.isEmpty()) {
                        String f2 = f(replace, a3);
                        if (!f2.isEmpty()) {
                            arrayList.add(f2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static ArrayList<String> d(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str2);
        hashMap.put("user-agent", Constants.C);
        String d2 = HttpHelper.d(str, hashMap);
        String o2 = HttpHelper.i().o(d2, str2);
        new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList.add(o2);
        Iterator it2 = Regex.f(o2, "['\"]changeSource\\([\\\\]['\"]([^'\"]+)[\\\\]", 1, true).get(0).iterator();
        while (it2.hasNext()) {
            String str4 = (String) it2.next();
            try {
                if (d2.endsWith("?")) {
                    str3 = d2 + "&src=" + str4;
                } else {
                    str3 = d2 + "?src=" + str4;
                }
                String o3 = HttpHelper.i().o(str3, str2);
                String a2 = Regex.a(o3, "x-token['\"]\\s*:\\s*([0-9a-zA-Z-_]+)", 1);
                String a3 = Regex.a(o3, "tc\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
                String a4 = Regex.a(o3, "(function\\s*" + a2 + "[^>]+[^>])<", 1);
                StringBuilder sb = new StringBuilder();
                sb.append(a4);
                sb.append(String.format(a2 + "(\"%s\");", new Object[]{a3}));
                String e2 = e(sb.toString());
                HashMap<String, String> c2 = Constants.c();
                c2.put("x-token", e2);
                String a5 = Regex.a(o3, "_token['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
                JSONArray jSONArray = new JSONArray(HttpHelper.i().l(Regex.a(o3, "url\\s*:\\s*['\"]([^'\"]+)['\"]", 1), String.format("tokenCode=%s&_token=%s", new Object[]{a3, a5}), c2));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    if (!arrayList2.contains(string) && string.contains(UriUtil.HTTP_SCHEME)) {
                        arrayList2.add(string);
                    }
                }
            } catch (Exception e3) {
                Logger.d(e3, new boolean[0]);
            }
        }
        return arrayList2;
    }

    private static String e(String str) {
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate(str);
            if (evaluate != null) {
                String obj = evaluate.toString();
                create.close();
                return obj;
            }
        } catch (Throwable unused) {
        }
        create.close();
        return "";
    }

    public static String f(String str, String str2) {
        if (str.contains("vsrc")) {
            return "https://vidsrc.me/embed/" + str2;
        } else if (str.contains("smstrm")) {
            return "https://embed.smashystream.com/playere.php?imdb=" + str2;
        } else if (str.contains("movapi")) {
            return "https://moviesapi.club/movie/" + str2;
        } else if (str.contains("gdrive")) {
            return "https://databasegdriveplayer.xyz/player.php?imdb=" + str2;
        } else if (!str.contains("swish")) {
            return "";
        } else {
            return "https://embedwish.com/e/" + str2;
        }
    }
}
