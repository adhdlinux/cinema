package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class SolarMoviez extends BaseProvider {

    /* renamed from: f  reason: collision with root package name */
    public static String f37454f = Deobfuscator$app$ProductionRelease.a(-192929644359876L);

    /* renamed from: e  reason: collision with root package name */
    private String f37455e = Utils.getProvider(32);

    private static String J() {
        String str = f37454f;
        if (str == null || str.isEmpty()) {
            f37454f = Constants.E + Deobfuscator$app$ProductionRelease.a(-192813680242884L);
        }
        return f37454f;
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-192946824229060L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String h2 = TitleHelper.h(movieInfo.name.toLowerCase(), Deobfuscator$app$ProductionRelease.a(-231464090939588L));
        HashMap<String, String> c2 = Constants.c();
        c2.put(Deobfuscator$app$ProductionRelease.a(-231455501004996L), this.f37455e);
        c2.put(Deobfuscator$app$ProductionRelease.a(-231700314140868L), this.f37455e + Deobfuscator$app$ProductionRelease.a(-231665954402500L));
        c2.put(Deobfuscator$app$ProductionRelease.a(-231657364467908L), Deobfuscator$app$ProductionRelease.a(-231627299696836L));
        String l2 = HttpHelper.i().l(this.f37455e + Deobfuscator$app$ProductionRelease.a(-230325924606148L), String.format(Deobfuscator$app$ProductionRelease.a(-230252910162116L), new Object[]{h2, DateTimeHelper.g()}), c2);
        String a2 = Deobfuscator$app$ProductionRelease.a(-229801938596036L);
        try {
            JSONArray jSONArray = new JSONArray(l2);
            if (jSONArray.length() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-229832003367108L));
                    String string2 = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-230063931601092L));
                    int i3 = jSONObject.getInt(Deobfuscator$app$ProductionRelease.a(-230038161797316L));
                    if (!string2.isEmpty() && TitleHelper.h(string2.toLowerCase(), Deobfuscator$app$ProductionRelease.a(-229982327222468L)).startsWith(TitleHelper.h(movieInfo.name.toLowerCase(), Deobfuscator$app$ProductionRelease.a(-229978032255172L))) && i3 == movieInfo.getYear().intValue()) {
                        a2 = string;
                        break;
                    }
                    i2++;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (a2.isEmpty()) {
            a2 = SearchHelper.e(movieInfo.name, movieInfo.year, Deobfuscator$app$ProductionRelease.a(-229973737287876L), this.f37455e, Deobfuscator$app$ProductionRelease.a(-230003802058948L));
        }
        if (!a2.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-229999507091652L), Deobfuscator$app$ProductionRelease.a(-229969442320580L));
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-230497723297988L), this.f37455e + Deobfuscator$app$ProductionRelease.a(-229088974024900L));
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-229080384090308L), Deobfuscator$app$ProductionRelease.a(-229011664613572L));
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-229196348207300L), Deobfuscator$app$ProductionRelease.a(-228809801150660L));
            HttpHelper.i().D(this.f37455e, Deobfuscator$app$ProductionRelease.a(-228835570954436L));
            String a3 = Regex.a(HttpHelper.i().m(a2, hashMap), Deobfuscator$app$ProductionRelease.a(-228899995463876L) + (Deobfuscator$app$ProductionRelease.a(-228882815594692L) + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.session)) + Deobfuscator$app$ProductionRelease.a(-228874225660100L) + com.original.tase.utils.Utils.i(Integer.parseInt(movieInfo.eps))) + Deobfuscator$app$ProductionRelease.a(-229621549969604L), 1);
            if (!a3.isEmpty()) {
                String o2 = HttpHelper.i().o(a3, a2);
                String m2 = HttpHelper.i().m(J(), new Map[0]);
                if (!m2.isEmpty()) {
                    Iterator it2 = Jsoup.b(o2).q0(Deobfuscator$app$ProductionRelease.a(-229780463759556L)).g(Deobfuscator$app$ProductionRelease.a(-229758988923076L)).iterator();
                    while (it2.hasNext()) {
                        try {
                            String K = K(m2, Regex.a(((Element) it2.next()).c(Deobfuscator$app$ProductionRelease.a(-229677384544452L)), Deobfuscator$app$ProductionRelease.a(-229368146899140L), 1));
                            if (!K.isEmpty()) {
                                z(observableEmitter, K, Deobfuscator$app$ProductionRelease.a(-229273657618628L), false);
                            }
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public String K(String str, String str2) {
        Duktape create = Duktape.create();
        try {
            Object evaluate = create.evaluate(String.format(Deobfuscator$app$ProductionRelease.a(-229501290885316L), new Object[]{str, str2}));
            if (evaluate != null) {
                String obj = evaluate.toString();
                create.close();
                return obj;
            }
        } catch (Throwable unused) {
        }
        create.close();
        return Deobfuscator$app$ProductionRelease.a(-192817975210180L);
    }
}
