package com.utils.Getlink.Provider;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class AZMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37237e = Utils.getProvider(113);

    public String A() {
        return "AZMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (HttpHelper.i().m(this.f37237e, new Map[0]).contains("Best source for watching movies online, dont forget to bookmark")) {
            HashMap<String, String> c2 = Constants.c();
            HttpHelper i2 = HttpHelper.i();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f37237e);
            sb.append("/src/captcha-request.php");
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            hashMap.put("Referer", this.f37237e + "/check/" + this.f37237e + "/");
            hashMap.put("Host", this.f37237e.replace("https://", ""));
            Iterator it2 = Regex.f(i2.l(sb.toString(), "cID=0&rT=1&tM=light", c2), "[\"']([^\"']+[^\"'])[\"']", 1, true).get(0).iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                HttpHelper i3 = HttpHelper.i();
                arrayList.add(new Captchar(str, i3.f(String.format(this.f37237e + "/src/captcha-request.php?cid=0&hash=%s", new Object[]{str}), hashMap), 0));
            }
            Captchar captchar = (Captchar) arrayList.get(0);
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Captchar captchar2 = (Captchar) it3.next();
                Iterator it4 = arrayList.iterator();
                int i4 = 0;
                while (it4.hasNext()) {
                    if (captchar2.f37276b == ((Captchar) it4.next()).f37276b) {
                        i4++;
                    }
                }
                if (i4 == 1) {
                    captchar = captchar2;
                    break;
                }
            }
            hashMap.put("X-Requested-With", "XMLHttpRequest");
            HttpHelper i5 = HttpHelper.i();
            i5.l(this.f37237e + "/src/captcha-request.php", String.format("cID=0&pC=%s&rT=2", new Object[]{captchar.f37275a}), hashMap);
            HttpHelper i6 = HttpHelper.i();
            i6.l(this.f37237e + "/ajax/captcha.php", String.format("captcha-hf=%s&captcha-idhf=0", new Object[]{captchar.f37275a}), hashMap);
        }
        String K = K(movieInfo);
        if (K.isEmpty()) {
            K = L(movieInfo);
        }
        if (!K.isEmpty()) {
            J(K, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    public void J(String str, ObservableEmitter<? super MediaSource> observableEmitter) {
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("div.player__server-wrapper").g("a[value]").iterator();
        while (it2.hasNext()) {
            String c2 = ((Element) it2.next()).c(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (!c2.isEmpty()) {
                if (c2.startsWith("/")) {
                    c2 = this.f37237e + c2;
                }
                if (c2.startsWith(this.f37237e)) {
                    String a2 = Regex.a(HttpHelper.i().o(c2, str + "/"), "source\\s*src\\s*=\\s*[\"']([^\"']+)[\"']", 1);
                    if (!a2.isEmpty()) {
                        MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                        mediaSource.setStreamLink(a2);
                        mediaSource.setQuality("HD");
                        observableEmitter.onNext(mediaSource);
                    }
                } else {
                    z(observableEmitter, c2, "HD", false);
                }
            }
        }
    }

    public String K(MovieInfo movieInfo) {
        String replace = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("%20", "+");
        Iterator it2 = Jsoup.b(HttpHelper.i().l(this.f37237e + "/livesearch.php", "searchVal=" + replace, Constants.c())).q0("a[href]").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.v0();
            String c2 = element.c("href");
            if (TitleHelper.h(v02, "").toLowerCase().startsWith(TitleHelper.h(movieInfo.name.toLowerCase() + " " + movieInfo.year, "").toLowerCase())) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37237e + c2;
            }
        }
        return "";
    }

    public String L(MovieInfo movieInfo) {
        String replace = com.original.tase.utils.Utils.k(movieInfo.getName(), new boolean[0]).replace("+", "%20");
        Iterator it2 = Jsoup.b(HttpHelper.i().o(this.f37237e + "/search/" + replace, this.f37237e + "/")).q0("a.poster").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.r0("span.poster__title").v0();
            String c2 = element.c("href");
            if (TitleHelper.h(v02 + " " + Regex.a(element.v0(), "(\\d{4})", 1), "").toLowerCase().startsWith(TitleHelper.h(movieInfo.name.toLowerCase() + " " + movieInfo.year, "").toLowerCase())) {
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37237e + c2;
            }
        }
        return "";
    }
}
