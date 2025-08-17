package com.utils.Getlink.Provider;

import com.google.gson.JsonParser;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SwatchSeries extends BaseProvider {

    /* renamed from: g  reason: collision with root package name */
    static SecureRandom f37458g = new SecureRandom();

    /* renamed from: e  reason: collision with root package name */
    private String f37459e = Utils.getProvider(105);

    /* renamed from: f  reason: collision with root package name */
    String f37460f = "var s=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\",qq=function(r,n){return r==n},cc=function(r,n){return r+n},qc=function(r,n){return r&n},vv=function(r,n){return r<n},af=\"\",u=function(r){var n=3600;if((r=(r=af.concat(r)).replace(\"/[ \\t\\n\\f\\r]/g\",af)).length%4==0&&(r=r.replace(\"/==?$/\",af)),qq(r.length%4,1))return null;for(var t,o=af,n=0,e=0,f=0;f<r.length;f++)n<<=6,n|=(t=r[f],(t=s.indexOf(t))<0?void 0:t),24===(e+=6)&&(o+=String.fromCharCode((16711680&n)>>16),o+=String.fromCharCode((65280&n)>>8),o+=String.fromCharCode(qc(255,n)),n=e=0);return 12===e?(n>>=4,o+=String.fromCharCode(n)):18===e&&(n>>=2,o+=String.fromCharCode(qc(65280,n)>>8),o+=String.fromCharCode(qc(255,n))),o},Zi=function(r,n){for(var t,o=[],e=0,f=af,a=256,c=0;c<a;c+=1)o[c]=c;for(c=0;vv(c,a);c+=1)e=(e+o[c]+r.charCodeAt(c%r.length))%a,t=o[c],o[c]=o[e],o[e]=t;for(var u=e=c=0;u<n.length;u+=1)e=(e+o[c=(c+1)%a])%a,t=o[c],o[c]=o[e],o[e]=t,f+=String.fromCharCode(n.charCodeAt(u)^o[(o[c]+o[e])%a]);return f};function acb(){var r=\"####\",n=r.substr(0,9);return Zi(n,u(r.substr(9)))}acb();";

    public String A() {
        return "SwatchSeries";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            J(observableEmitter, L, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String L = L(movieInfo);
        if (!L.isEmpty()) {
            J(observableEmitter, L, movieInfo);
        }
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, String str, MovieInfo movieInfo) {
        boolean z2;
        String str2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = Regex.a(HttpHelper.i().m(str, new Map[0]), "data-id\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(String.format(this.f37459e + "/ajax/film/servers?id=%s&token=%s", new Object[]{a2, "03" + K(460)}), new Map[0]);
            String format = String.format("a[data-kname=%s:%s]", new Object[]{movieInfo.session, movieInfo.eps});
            if (z2) {
                format = "a[data-id][href]";
            }
            try {
                str2 = new JsonParser().a(m2).c().m("html").e();
            } catch (Exception unused) {
                str2 = "";
            }
            Document b2 = Jsoup.b(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("referer", this.f37459e + "/");
            Element r02 = b2.r0(format);
            if (r02 != null) {
                String c2 = r02.c("data-id");
                String replace = Regex.a(HttpHelper.i().m(String.format(this.f37459e + "/ajax/episode/info?id=%s", new Object[]{c2}), new Map[0]), "url['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1).replace("==", "");
                Duktape create = Duktape.create();
                try {
                    Object evaluate = create.evaluate(this.f37460f.replace("####", replace));
                    if (evaluate != null) {
                        String obj = evaluate.toString();
                        MediaSource mediaSource = new MediaSource(A(), "HD", false);
                        mediaSource.setStreamLink(obj);
                        mediaSource.setPlayHeader(hashMap);
                        mediaSource.setQuality("HD");
                        observableEmitter.onNext(mediaSource);
                    }
                } catch (Throwable unused2) {
                }
                create.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String K(int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-+_".charAt(f37458g.nextInt(65)));
        }
        return sb.toString();
    }

    public String L(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        String str = this.f37459e + "/search?keyword=" + com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]);
        hashMap.put("referer", str);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, hashMap)).q0("div.filmlist").g("div.item").iterator();
        while (true) {
            String str2 = "";
            if (!it2.hasNext()) {
                return str2;
            }
            Element element = (Element) it2.next();
            Element r02 = element.r0("a[href][title]");
            String c2 = r02.c("href");
            String c3 = r02.c("title");
            if (z2) {
                Element r03 = element.r0("div.meta");
                if (r03 != null) {
                    str2 = Regex.a(r03.toString(), "\\d{4}", 0);
                }
                if (movieInfo.name.equalsIgnoreCase(c3) && movieInfo.year.equalsIgnoreCase(str2)) {
                    if (!c2.startsWith("/")) {
                        return c2;
                    }
                    return this.f37459e + c2;
                }
            } else {
                Element r04 = element.r0("div.meta");
                if (r04 != null) {
                    String a2 = Regex.a(r04.toString(), "\\s*SS\\s*(\\d+)", 1);
                    if (!a2.isEmpty() && Integer.parseInt(a2) >= Integer.parseInt(movieInfo.session) && TitleHelper.f(c3).equalsIgnoreCase(TitleHelper.f(TitleHelper.e(movieInfo.getName())))) {
                        if (!c2.startsWith("/")) {
                            return c2;
                        }
                        return this.f37459e + c2;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
