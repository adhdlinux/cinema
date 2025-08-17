package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Vliver extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37487e = "https://www.cliver.to";

    public String A() {
        return "Vliver";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            J(observableEmitter, L);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            K(observableEmitter, L, movieInfo);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String str2;
        String str3;
        HashMap<String, String> c2 = Constants.c();
        c2.put("referer", str);
        String a2 = Regex.a(HttpHelper.i().m(str, new Map[0]), "Idpelicula\\s*=\\s*[\"']([^\"']+[^\"'])[\"']", 1);
        JsonElement a3 = new JsonParser().a(HttpHelper.i().l(this.f37487e + "/frm/obtener-enlaces-pelicula.php", "pelicula=" + a2, c2));
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        Iterator<JsonElement> it2 = a3.c().n("vose").iterator();
        while (it2.hasNext()) {
            String e2 = it2.next().c().m("token").e();
            String a4 = Regex.a(HttpHelper.i().l("https://directvideo.stream/getFile.php", "hash=" + e2, c2), "[\"']url[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
            if (!a4.isEmpty()) {
                String replace = a4.replace("\\/", "/");
                boolean n2 = GoogleVideoHelper.n(replace);
                String str4 = A() + " [ES]";
                if (n2) {
                    str2 = "GoogleVideo";
                } else {
                    str2 = "CDN-FastServer";
                }
                MediaSource mediaSource = new MediaSource(str4, str2, false);
                mediaSource.setStreamLink(replace);
                if (n2) {
                    mediaSource.setPlayHeader(hashMap);
                }
                if (n2) {
                    str3 = GoogleVideoHelper.h(replace);
                } else {
                    str3 = "HD";
                }
                mediaSource.setQuality(str3);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        String c2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).r0("div[data-numcap=\"" + movieInfo.eps + "\"][data-numtemp=\"" + movieInfo.session + "\"]").c("data-url-vose");
        if (!c2.isEmpty()) {
            String replace = c2.replace("\\/", "/");
            boolean n2 = GoogleVideoHelper.n(replace);
            String str4 = A() + " [ES]";
            if (n2) {
                str2 = "GoogleVideo";
            } else {
                str2 = "CDN-FastServer";
            }
            MediaSource mediaSource = new MediaSource(str4, str2, false);
            mediaSource.setStreamLink(replace);
            if (n2) {
                mediaSource.setPlayHeader(hashMap);
            }
            if (n2) {
                str3 = GoogleVideoHelper.h(replace);
            } else {
                str3 = "HD";
            }
            mediaSource.setQuality(str3);
            observableEmitter.onNext(mediaSource);
        }
    }

    public String L(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String replace = Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+");
        HashMap hashMap = new HashMap();
        hashMap.put("referer", this.f37487e);
        String str = this.f37487e + "/buscar/?txt=" + replace;
        if (z2) {
            HttpHelper.i().D(str, "tipo_contenido=peliculas;");
        } else {
            HttpHelper.i().D(str, "tipo_contenido=series;");
        }
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, hashMap)).q0("div.titulo-p").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0("h2").v0();
            String v03 = element.r0("span").v0();
            if (v02.equals(movieInfo.name) && v03.contains(movieInfo.year)) {
                String c2 = element.r0(a.f20042a).c("href");
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37487e + c2;
            }
        }
        return "";
    }
}
