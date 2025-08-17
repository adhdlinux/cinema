package com.utils.Getlink.Provider;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FliXanityBased extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public static String f37320e = "";

    static class LOGG implements console {
        LOGG() {
        }
    }

    interface console {
    }

    private ArrayList<HashMap<String, String>> J(boolean z2) {
        JsonParser jsonParser = new JsonParser();
        HttpHelper i2 = HttpHelper.i();
        Iterator<JsonElement> it2 = jsonParser.a(i2.m(Constants.E + "provider/flixanityProviderUrlsv2.json", new Map[0])).c().m("bases").b().iterator();
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        if (f37320e.isEmpty()) {
            HttpHelper i3 = HttpHelper.i();
            f37320e = i3.m(Constants.E + "provider/flixanityProviderEnc.txt", new Map[0]);
        }
        while (it2.hasNext()) {
            HashMap hashMap = new HashMap();
            JsonObject c2 = it2.next().c();
            String e2 = c2.m(ImagesContract.URL).e();
            String e3 = c2.m("embedsPath").e();
            String e4 = c2.m("bdcCookie").e();
            hashMap.put("embedsPath", c2.m("embedsPath").e());
            hashMap.put(ImagesContract.URL, e2);
            if (z2) {
                hashMap.put("urlLink", c2.m("urlMovies").e());
            } else {
                hashMap.put("urlLink", c2.m("urlSeries").e());
            }
            if (e3 != null && !e3.isEmpty() && e4 != null && !e4.isEmpty()) {
                HttpHelper.i().D(e2, e4);
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public String A() {
        return "FliXanityBased";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String g2 = TitleHelper.g(movieInfo.getName().replace("'", ""));
        String name = movieInfo.getName();
        name.hashCode();
        char c2 = 65535;
        switch (name.hashCode()) {
            case -1438572772:
                if (name.equals("Star Wars: The Last Jedi")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1296695595:
                if (name.equals("Mission: Impossible - Ghost Protocol")) {
                    c2 = 1;
                    break;
                }
                break;
            case -616025719:
                if (name.equals("Fast & Furious")) {
                    c2 = 2;
                    break;
                }
                break;
            case -519161968:
                if (name.equals("Justice League")) {
                    c2 = 3;
                    break;
                }
                break;
            case -95314585:
                if (name.equals("Star Wars: The Force Awakens")) {
                    c2 = 4;
                    break;
                }
                break;
            case 268366428:
                if (name.equals("Self/less")) {
                    c2 = 5;
                    break;
                }
                break;
            case 607165378:
                if (name.equals("Now You See Me 2")) {
                    c2 = 6;
                    break;
                }
                break;
            case 704771935:
                if (name.equals("Fast & Furious 6")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                g2 = "star-wars-episode-viii";
                break;
            case 1:
                return;
            case 2:
                g2 = "fast-furious";
                break;
            case 3:
                g2 = "the-justice-league-part-one";
                break;
            case 4:
                g2 = "star-wars-episode-vii-the-force-awakens";
                break;
            case 5:
                g2 = "self-less";
                break;
            case 6:
                g2 = "now-you-see-me-the-second-act";
                break;
            case 7:
                g2 = "fast-furious-6";
                break;
        }
        String h2 = TitleHelper.h(g2, "-");
        Iterator<HashMap<String, String>> it2 = J(true).iterator();
        while (it2.hasNext()) {
            HashMap next = it2.next();
            if (K(observableEmitter, (String) next.get(ImagesContract.URL), ((String) next.get("urlLink")) + h2, movieInfo, true, "-1", "-1", (String) next.get("embedsPath"), new boolean[0])) {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        MovieInfo movieInfo2 = movieInfo;
        String g2 = TitleHelper.g(movieInfo.getName().replace("DC's ", "").replace("'", ""));
        String name = movieInfo.getName();
        name.hashCode();
        char c2 = 65535;
        switch (name.hashCode()) {
            case -1989436052:
                if (name.equals("Marvel's The Defenders")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1753753522:
                if (name.equals("Marvel's Jessica Jones")) {
                    c2 = 1;
                    break;
                }
                break;
            case -517469293:
                if (name.equals("Marvel's Daredevil")) {
                    c2 = 2;
                    break;
                }
                break;
            case 91465286:
                if (name.equals("Marvel's The Punisher")) {
                    c2 = 3;
                    break;
                }
                break;
            case 424581095:
                if (name.equals("Marvel's Iron Fist")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1544707312:
                if (name.equals("Will & Grace")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1728305255:
                if (name.equals("Marvel's Agents of S.H.I.E.L.D.")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                g2 = "the-defenders";
                break;
            case 1:
                g2 = "jessica-jones";
                break;
            case 2:
                g2 = "marvels-daredevil";
                break;
            case 3:
                g2 = "the-punisher";
                break;
            case 4:
                g2 = "iron-fist";
                break;
            case 5:
                g2 = "will-and-grace";
                break;
            case 6:
                g2 = "agents-of-shield";
                break;
        }
        String h2 = TitleHelper.h(g2, "-");
        Iterator<HashMap<String, String>> it2 = J(false).iterator();
        while (it2.hasNext()) {
            HashMap next = it2.next();
            if (K(observableEmitter, (String) next.get(ImagesContract.URL), ((String) next.get("urlLink")) + h2 + "/season/" + movieInfo2.session + "/episode/" + movieInfo2.eps, movieInfo, false, movieInfo2.session, movieInfo2.eps, (String) next.get("embedsPath"), new boolean[0])) {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public boolean K(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2, MovieInfo movieInfo, boolean z2, String str3, String str4, String str5, boolean... zArr) {
        String str6;
        String str7;
        String str8;
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        hashMap.put("accept-language", "en-US;q=0.9,en;q=0.8");
        String m2 = HttpHelper.i().m(str2, hashMap);
        String a2 = Regex.a(m2, "var\\s*tok\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        String a3 = Regex.a(m2, "elid\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        if (a2.isEmpty()) {
            return false;
        }
        Duktape create = Duktape.create();
        try {
            create.set("console", console.class, new LOGG());
            String obj = create.evaluate(f37320e).toString();
            create.close();
            HttpHelper i2 = HttpHelper.i();
            i2.D(str2, a3 + "=" + obj);
            if (!z2) {
                str6 = "action=getEpisodeEmb&idEl=%s&token=%s&nopop=&elid=%s";
            } else {
                str6 = "action=getMovieEmb&idEl=%s&token=%s&nopop=&elid=%s";
            }
            hashMap.put("origin", str);
            hashMap.put("accept", "application/x-www-form-urlencoded; charset=UTF-8");
            hashMap.put("referer", str2);
            hashMap.put("cookie", HttpHelper.i().g(str2));
            hashMap.put("x-requested-with", "XMLHttpRequest");
            HttpHelper i3 = HttpHelper.i();
            Iterator it2 = Regex.f(i3.l(str + "/ajax/" + str5, String.format(str6, new Object[]{a3, a2, obj}), hashMap).replace("\\\"", "\"").replace("\\/", "/"), "src\\s*=\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0).iterator();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("user-agent", Constants.C);
            boolean z3 = false;
            while (it2.hasNext()) {
                String str9 = (String) it2.next();
                boolean n2 = GoogleVideoHelper.n(str9);
                String A = A();
                if (n2) {
                    str7 = "GoogleVideo";
                } else {
                    str7 = "CDN-FastServer";
                }
                MediaSource mediaSource = new MediaSource(A, str7, false);
                mediaSource.setStreamLink(str9);
                if (n2) {
                    mediaSource.setPlayHeader(hashMap2);
                }
                if (n2) {
                    str8 = GoogleVideoHelper.h(str9);
                } else {
                    str8 = "HD";
                }
                mediaSource.setQuality(str8);
                observableEmitter.onNext(mediaSource);
                z3 = true;
            }
            return z3;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
