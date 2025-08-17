package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class YSMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37502e = "https://ymovies.se";

    /* renamed from: f  reason: collision with root package name */
    private String f37503f = "";

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r9v0 ?, r9v1 ?, r9v10 ?, r9v2 ?, r9v3 ?, r9v4 ?, r9v6 ?, r9v7 ?, r9v9 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r19, java.lang.String r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = com.original.Constants.C
            r3.put(r4, r5)
            java.lang.String r4 = "/"
            boolean r4 = r2.endsWith(r4)
            if (r4 == 0) goto L_0x002c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "watching/?playermode=#box"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x003d
        L_0x002c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "/watching/?playermode=#box"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x003d:
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r4 = r5.o(r4, r2)
            java.lang.String r5 = "(\\(function\\s*\\(\\)\\{\\s*var.*eval\\(\\w+\\.join\\(\\'\\'\\)\\)\\;\\}\\))\\(\\)<\\/script>\\s*<div\\s*class=\\\"videoPlayer\\s*row\\\">"
            r6 = 1
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r5, r6)
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r7 = "eval"
            java.lang.String r8 = "return "
            java.lang.String r4 = r4.replace(r7, r8)
            r9 = 0
            r5[r9] = r4
            java.lang.String r4 = "var encode = %s\n\nfunction acb()\n{\n    var result = eval(encode);\n    return result();\n}\n acb();"
            java.lang.String r4 = java.lang.String.format(r4, r5)
            com.squareup.duktape.Duktape r5 = com.squareup.duktape.Duktape.create()
            java.lang.Object r4 = r5.evaluate(r4)     // Catch:{ all -> 0x0260 }
            r5.close()
            if (r4 == 0) goto L_0x025f
            java.lang.String r10 = r4.toString()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x025f
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "window.parametros\\s*=\\s*[\"']([^\"']+[^\"'])[\"']"
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r10, r6)
            java.lang.String r10 = "&"
            java.lang.String[] r4 = r4.split(r10)
            int r10 = r4.length
            r11 = 0
        L_0x0088:
            if (r11 >= r10) goto L_0x025f
            r12 = r4[r11]
            java.lang.String r13 = "="
            java.lang.String[] r12 = r12.split(r13)
            r13 = r12[r9]
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x009f
        L_0x009a:
            r17 = r4
            r4 = 1
            goto L_0x0258
        L_0x009f:
            r13 = r12[r9]
            java.lang.String r14 = "lox"
            boolean r13 = r13.equals(r14)
            java.lang.String r14 = "HD"
            if (r13 == 0) goto L_0x00c2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://vidlox.tv/embed-"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
        L_0x00be:
            r17 = r4
            goto L_0x0246
        L_0x00c2:
            r13 = r12[r9]
            java.lang.String r15 = "jaw"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x00e0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://jawcloud.co/embed-"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            goto L_0x00be
        L_0x00e0:
            r13 = r12[r9]
            java.lang.String r15 = "vsh"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x00fe
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://vshare.eu/embed-"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            goto L_0x00be
        L_0x00fe:
            r13 = r12[r9]
            java.lang.String r15 = "rpt"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x011c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://www.bitporno.com/e/"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            goto L_0x00be
        L_0x011c:
            r13 = r12[r9]
            java.lang.String r15 = "vza"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x013a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://vidoza.net/embed-"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            goto L_0x00be
        L_0x013a:
            r13 = r12[r9]
            java.lang.String r15 = "rpd"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x0159
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "https://www.rapidvideo.com/embed/"
            r2.append(r13)
            r12 = r12[r6]
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            goto L_0x00be
        L_0x0159:
            r13 = r12[r9]
            java.lang.String r15 = "pic"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x00be
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = r1.f37502e
            r13.append(r15)
            java.lang.String r15 = "/playerlite/pk/pk/plugins/player_p2.php"
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]
            r16 = r12[r6]
            r15[r9] = r16
            r12 = r12[r9]
            r15[r6] = r12
            java.lang.String r12 = "top=1&fv=0&url=%s&sou=%s"
            java.lang.String r12 = java.lang.String.format(r12, r15)
            java.util.Map[] r15 = new java.util.Map[r9]
            java.lang.String r2 = r2.l(r13, r12, r15)
            java.lang.String r12 = "jscode[\"']\\s*:\\s*[\"'](.*)[\"']"
            java.lang.String r12 = com.original.tase.utils.Regex.a(r2, r12, r6)
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x0215
            java.lang.String r12 = "[\"']?url[\"']?\\s*:\\s*[\"']([^\"']+)"
            java.util.ArrayList r12 = com.original.tase.utils.Regex.f(r2, r12, r6, r6)
            java.lang.Object r12 = r12.get(r9)
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x01ad:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0211
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r15 = ".vtt"
            boolean r15 = r13.endsWith(r15)
            if (r15 != 0) goto L_0x01ad
            java.lang.String r15 = ".srt"
            boolean r15 = r13.endsWith(r15)
            if (r15 != 0) goto L_0x01ad
            java.lang.String r15 = ".png"
            boolean r15 = r13.endsWith(r15)
            if (r15 != 0) goto L_0x01ad
            java.lang.String r15 = ".jpg"
            boolean r15 = r13.endsWith(r15)
            if (r15 != 0) goto L_0x01ad
            boolean r15 = com.original.tase.helper.GoogleVideoHelper.n(r13)
            com.original.tase.model.media.MediaSource r6 = new com.original.tase.model.media.MediaSource
            java.lang.String r9 = r18.A()
            if (r15 == 0) goto L_0x01e8
            java.lang.String r17 = "GoogleVideo"
            goto L_0x01ea
        L_0x01e8:
            java.lang.String r17 = "CDN-FastServer"
        L_0x01ea:
            r20 = r2
            r2 = r17
            r17 = r4
            r4 = 0
            r6.<init>(r9, r2, r4)
            r6.setStreamLink(r13)
            if (r15 == 0) goto L_0x01fc
            r6.setPlayHeader(r3)
        L_0x01fc:
            if (r15 == 0) goto L_0x0203
            java.lang.String r2 = com.original.tase.helper.GoogleVideoHelper.h(r13)
            goto L_0x0204
        L_0x0203:
            r2 = r14
        L_0x0204:
            r6.setQuality((java.lang.String) r2)
            r0.onNext(r6)
            r2 = r20
            r4 = r17
            r6 = 1
            r9 = 0
            goto L_0x01ad
        L_0x0211:
            r20 = r2
            goto L_0x009a
        L_0x0215:
            r20 = r2
            r17 = r4
            java.lang.String r2 = "var encode = \"%s\"\n\nfunction acb()\n{\n    var result = eval(encode);\n    return result();\n}\n acb();"
            r4 = 1
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0243 }
            java.lang.String r4 = r12.replace(r7, r8)     // Catch:{ all -> 0x0243 }
            r9 = 0
            r6[r9] = r4     // Catch:{ all -> 0x0243 }
            java.lang.String r2 = java.lang.String.format(r2, r6)     // Catch:{ all -> 0x0243 }
            java.lang.Object r2 = r5.evaluate(r2)     // Catch:{ all -> 0x0243 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0243 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0243 }
            if (r4 != 0) goto L_0x0244
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0243 }
            java.lang.String r4 = "showiFrame\\([\"']([^\"']+[^\"'])[\"']"
            r6 = 1
            java.lang.String r2 = com.original.tase.utils.Regex.a(r2, r4, r6)     // Catch:{ all -> 0x0243 }
            goto L_0x0246
        L_0x0243:
        L_0x0244:
            r2 = r20
        L_0x0246:
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0256
            r4 = 1
            boolean[] r6 = new boolean[r4]
            r9 = 0
            r6[r9] = r9
            r1.z(r0, r2, r14, r6)
            goto L_0x0258
        L_0x0256:
            r4 = 1
            r9 = 0
        L_0x0258:
            int r11 = r11 + 1
            r4 = r17
            r6 = 1
            goto L_0x0088
        L_0x025f:
            return
        L_0x0260:
            r0 = move-exception
            r2 = r0
            r5.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.YSMovies.J(io.reactivex.ObservableEmitter, java.lang.String):void");
    }

    public String A() {
        return "YSMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }

    public String K(MovieInfo movieInfo) {
        int i2 = 0;
        String format = String.format(this.f37502e + "/?s=%s&genre=%s&years=%s", new Object[]{Utils.k(movieInfo.name, new boolean[0]).replace("%20", "+"), movieInfo.genres.get(0), movieInfo.year});
        String a2 = Regex.a(HttpHelper.i().o(format, this.f37502e + "/"), "[\"']?posts[\"']?\\s*:\\s*([\\[].*[\\]])", 1);
        try {
            JSONArray jSONArray = new JSONArray(a2);
            if (jSONArray.length() > 0) {
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("title");
                    String string2 = jSONObject.getString("year");
                    this.f37503f = jSONObject.getString("ID");
                    if (!movieInfo.name.equals(string) || string2.isEmpty() || !string2.contains(movieInfo.year)) {
                        i2++;
                    } else {
                        String string3 = jSONObject.getString("link");
                        if (string3.startsWith("/")) {
                            string3 = this.f37502e + string3;
                        }
                        return string3.replace("\\/", "/");
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Iterator it2 = Jsoup.b(a2).q0("div.tab-content").g("h2.title").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            String v02 = element.v0();
            String v03 = element.r0("span").v0();
            if (movieInfo.name.equals(v02) && !v03.isEmpty() && v03.contains(movieInfo.year)) {
                String c2 = element.c("href");
                if (!c2.startsWith("/")) {
                    return c2;
                }
                return this.f37502e + c2;
            }
        }
        return "";
    }
}
