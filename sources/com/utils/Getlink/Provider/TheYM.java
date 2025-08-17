package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class TheYM extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37468e = Utils.getProvider(57);

    public String A() {
        return "TheYM";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo);
        if (!M.isEmpty()) {
            L(observableEmitter, movieInfo, M);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo);
        if (!M.isEmpty()) {
            L(observableEmitter, movieInfo, M);
        }
    }

    public String J(int i2, String str) {
        if (i2 == 10) {
            return "https://vidsrc.me/embed/" + str;
        } else if (i2 == 9) {
            return "https://gomostream.com/" + str;
        } else if (i2 == 8) {
            return "https://firesonic.sc/" + str;
        } else if (i2 == 7) {
            return "https://firesonic.sc/play_video1.php?" + str;
        } else if (i2 == 1) {
            return "https://series.databasegdriveplayer.co/player.php?type=series&imdb=" + str;
        } else if (i2 == 2) {
            return "https://database.gdriveplayer.us/player.php?imdb=" + str;
        } else if (i2 == 6) {
            return "https://firesonic.sc/multi.php?id=" + str;
        } else if (i2 == 11) {
            return "https://firesonic.sc/movie.php?imdb=" + str;
        } else if (i2 != 12) {
            return "";
        } else {
            return "https://firesonic.sc/serie.php?imdb=" + str;
        }
    }

    public void K(ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2) {
        if (HandleMore.a(str)) {
            for (String streamLink : HandleMore.c(str, str2)) {
                MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                mediaSource.setStreamLink(streamLink);
                mediaSource.setQuality("HD");
                observableEmitter.onNext(mediaSource);
            }
        } else if (HandleMore.b(str)) {
            for (String streamLink2 : HandleMore.d(str, str2)) {
                MediaSource mediaSource2 = new MediaSource(A(), "CDN-FastServer", false);
                mediaSource2.setStreamLink(streamLink2);
                mediaSource2.setQuality("HD");
                observableEmitter.onNext(mediaSource2);
            }
        } else {
            z(observableEmitter, str, "HD", false);
        }
    }

    public void L(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it2 = Jsoup.b(HttpHelper.i().m(str, new Map[0])).q0("div.bl-servers").g("a.btn-eps").iterator();
        HashMap hashMap = new HashMap();
        hashMap.put("referer", str);
        hashMap.put("user-agent", Constants.C);
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String c2 = element.c("data-drive");
            String a2 = Regex.a(element.toString(), "load_episode_iframe\\((\\d+)\\,(\\d+)\\)", 2);
            String a3 = Regex.a(element.toString(), "load_episode_iframe\\((\\d+)\\,(\\d+)\\)", 1);
            if ((z2 || a3 == movieInfo.eps) && !a2.isEmpty() && !c2.isEmpty()) {
                String J = J(Integer.parseInt(a2), c2);
                if (!J.isEmpty()) {
                    if (!J.contains("firesonic.") || (!J.contains("streaming.") && !J.contains("movie.php") && !J.contains("play_video"))) {
                        K(observableEmitter, J, str);
                    } else {
                        Iterator<String> it3 = Regex.g(HttpHelper.i().m(J, hashMap), "video\\d+\\s*=\\s*['\"]([^'\"]+)['\"]", 1, true).iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            if (J.contains("streaming.")) {
                                K(observableEmitter, next, str);
                            } else {
                                K(observableEmitter, next, str);
                                J = next;
                            }
                        }
                    }
                }
            }
        }
    }

    public String M(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), "%20");
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "application/json, text/plain, */*");
        hashMap.put("referer", this.f37468e + "/");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("user-agent", Constants.C);
        String str = this.f37468e + "/wp-json/mv/v2/movies/" + h2;
        try {
            JSONArray jSONArray = new JSONArray(HttpHelper.i().m(str + "##forceNoCache##", hashMap));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("post_title");
                String string2 = jSONObject.getString("year");
                if (!z2) {
                    if (TitleHelper.h(string.toLowerCase(Locale.ROOT), "").equals(movieInfo.name + "- season " + movieInfo.session)) {
                        String string3 = jSONObject.getString("post_name");
                        if (string3.startsWith("/")) {
                            return this.f37468e + string3;
                        }
                        return this.f37468e + "/movie/" + string3;
                    }
                } else if (movieInfo.name.equalsIgnoreCase(string) && movieInfo.year.equalsIgnoreCase(string2)) {
                    String string4 = jSONObject.getString("post_name");
                    if (string4.startsWith("/")) {
                        return this.f37468e + string4;
                    }
                    return this.f37468e + "/movie/" + string4;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
