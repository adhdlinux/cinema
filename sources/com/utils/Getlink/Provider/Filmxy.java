package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;

public class Filmxy extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String[] f37314e = {"DownAce", "UsersCloud", "opendload", "streamango"};

    /* renamed from: f  reason: collision with root package name */
    private String[] f37315f = {"l", "1", "m", "1", "s", "1", "l", TraktV2.API_VERSION, "m", TraktV2.API_VERSION, "s", TraktV2.API_VERSION, "l", "3", "m", "3", "s", "3", "l", "4", "m", "4", "s", "4"};

    /* renamed from: g  reason: collision with root package name */
    private String[] f37316g = {"l", "m", "s"};

    /* renamed from: h  reason: collision with root package name */
    private String f37317h = Utils.getProvider(72);

    public Filmxy() {
    }

    public String A() {
        return "Filmxy";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J();
        K(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J();
        K(movieInfo, observableEmitter);
    }

    public void J() {
        HttpHelper.i().D(this.f37317h, "G_ENABLED_IDPS=google");
        HttpHelper.i().D(this.f37317h, "true_checker=1");
        HttpHelper.i().D(this.f37317h, "XID=1");
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
        HttpHelper.i().m(this.f37317h, hashMap);
        hashMap.put("cookie", HttpHelper.i().g(this.f37317h));
        HttpHelper i2 = HttpHelper.i();
        String a2 = Regex.a(i2.m(this.f37317h + "/login/?redirect_to=" + this.f37317h, hashMap), "var\\suserNonce.*?\"(\\S+?)\";", 1);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37317h);
        sb.append("/wp-admin/admin-ajax.php");
        String sb2 = sb.toString();
        hashMap.put("X-Requested-With", "XMLHttpRequest");
        HttpHelper i3 = HttpHelper.i();
        i3.l(sb2, "action=guest_login&nonce=" + a2, hashMap);
        HttpHelper.i().D(this.f37317h, HttpHelper.i().g(this.f37317h));
    }

    public void K(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        String str;
        String str2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str = this.f37317h + "/movie/" + movieInfo.imdbIDStr;
        } else {
            str = this.f37317h + "/tv/" + movieInfo.imdbIDStr;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
        String g2 = HttpHelper.i().g(this.f37317h);
        hashMap.put("cookie", g2);
        String m2 = HttpHelper.i().m(str, hashMap);
        String a2 = Regex.a(m2, "listSE\\s*=\\s?(.*?),[\\n|\\s]", 1);
        Regex.a(m2, "linkDetails\\s*=\\s?(.*?),[\\n|\\s]", 1);
        Regex.a(m2, "dSubtitles\\s*=\\s?(.*?),[\\n|\\s]", 1);
        if (!z2) {
            a2 = Regex.a(Regex.a(a2, String.format("s%s['\"]\\s*:\\s*[{]([^{]+[^}])[}]", new Object[]{com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.session))}), 1), String.format("e%s['\"]\\s*:\\s*[\\[]([^\\[]+[^\\[])[\\]]", new Object[]{com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps))}), 1);
        }
        String a3 = Regex.a(m2, "userNonce\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        String a4 = Regex.a(m2, "user_id\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
        Iterator<String> it2 = Regex.g(a2, "(\\d+)", 1, true).iterator();
        String str3 = "";
        while (it2.hasNext()) {
            String next = it2.next();
            if (str3.isEmpty()) {
                str3 = str3 + "linkIDs%5B%5D=" + next;
            } else {
                str3 = str3 + "&linkIDs%5B%5D=" + next;
            }
        }
        if (!str3.isEmpty()) {
            String format = String.format("action=get_vid_links&%s&user_id=%s&nonce=%s", new Object[]{str3, a4, a3});
            HashMap<String, String> c2 = Constants.c();
            c2.put(TheTvdb.HEADER_ACCEPT, "*/*");
            c2.put("DNT", "1");
            c2.put("Origin", this.f37317h);
            c2.put("cookie", g2);
            Iterator<String> it3 = Regex.g(HttpHelper.i().l(this.f37317h + "/wp-admin/admin-ajax.php", format, c2).replace("\\/", "/"), "\\d+['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1, true).iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                boolean n2 = GoogleVideoHelper.n(next2);
                Regex.a(next2, "(http(?:s|)\\:\\/\\/(?:dl).*(?:mkv|mp4))", 1);
                boolean contains = next2.contains(".m3u8");
                String A = A();
                if (n2) {
                    str2 = "GoogleVideo";
                } else {
                    str2 = "CDN-FastServer";
                }
                MediaSource mediaSource = new MediaSource(A, str2, false);
                mediaSource.setStreamLink(next2);
                mediaSource.setQuality("HD");
                if (n2 || contains) {
                    HashMap hashMap2 = new HashMap();
                    hashMap.put("User-Agent", Constants.C);
                    mediaSource.setPlayHeader(hashMap2);
                }
                mediaSource.setProviderName(A());
                observableEmitter.onNext(mediaSource);
            }
        }
    }
}
