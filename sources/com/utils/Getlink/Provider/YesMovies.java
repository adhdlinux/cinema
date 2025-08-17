package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.original.tase.search.SearchHelper;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class YesMovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37507e = Utils.getProvider(82);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v15, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v24, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v37, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r24v36 */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03dc, code lost:
        if (java.lang.Integer.parseInt(r14.trim()) == r3) goto L_0x03e1;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x034d A[SYNTHETIC, Splitter:B:130:0x034d] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0370 A[Catch:{ Exception -> 0x0415 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0418 A[Catch:{ Exception -> 0x047c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String J(com.movie.data.model.MovieInfo r22, java.lang.String r23, boolean r24) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "img[alt]"
            java.lang.String r5 = "season"
            java.lang.String r6 = "span.mli-info"
            java.lang.String r7 = ".html"
            java.lang.String r8 = ""
            java.lang.Integer r0 = r22.getSession()
            int r0 = r0.intValue()
            if (r0 >= 0) goto L_0x001c
            r11 = 1
            goto L_0x001d
        L_0x001c:
            r11 = 0
        L_0x001d:
            if (r11 == 0) goto L_0x0022
            r0 = -1
            r12 = -1
            goto L_0x002b
        L_0x0022:
            java.lang.Integer r0 = r22.getSessionYear()
            int r0 = r0.intValue()
            r12 = r0
        L_0x002b:
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r13 = r1.f37507e
            java.lang.String r14 = "SL_G_WPT_TO=en; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1; srv=1; player_settings={%22auto_next%22:true}"
            r0.D(r13, r14)
            java.lang.String r0 = r2.name
            java.lang.String r13 = " "
            java.lang.String r14 = "+"
            java.lang.String r0 = r0.replace(r13, r14)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r10 = r1.f37507e
            r15.append(r10)
            java.lang.String r10 = "/searching?q="
            r15.append(r10)
            r15.append(r0)
            java.lang.String r10 = "&limit=40&offset=0"
            r15.append(r10)
            java.lang.String r10 = r15.toString()
            com.original.tase.helper.http.HttpHelper r15 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r18 = r12
            java.lang.String r12 = r1.f37507e
            r9.append(r12)
            java.lang.String r12 = "/search.html?q="
            r9.append(r12)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            java.lang.String r0 = r15.o(r10, r0)
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0155 }
            r9.<init>(r0)     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r0 = "data"
            org.json.JSONArray r0 = r9.getJSONArray(r0)     // Catch:{ JSONException -> 0x0155 }
            r9 = 0
        L_0x0087:
            int r10 = r0.length()     // Catch:{ JSONException -> 0x0155 }
            if (r9 >= r10) goto L_0x0152
            org.json.JSONObject r10 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r12 = "t"
            java.lang.String r12 = r10.getString(r12)     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r15 = "s"
            java.lang.String r10 = r10.getString(r15)     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r15 = "/movie/"
            if (r11 == 0) goto L_0x00fe
            r19 = r0
            java.lang.String r0 = r12.toLowerCase()     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r0 = com.original.tase.helper.TitleHelper.h(r0, r8)     // Catch:{ JSONException -> 0x0155 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0155 }
            r3.<init>()     // Catch:{ JSONException -> 0x0155 }
            r20 = r4
            java.lang.String r4 = r2.name     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ JSONException -> 0x0150 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = r2.year     // Catch:{ JSONException -> 0x0150 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.h(r3, r8)     // Catch:{ JSONException -> 0x0150 }
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0150 }
            if (r0 != 0) goto L_0x00e6
            java.lang.String r0 = r12.toLowerCase()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r0 = com.original.tase.helper.TitleHelper.h(r0, r8)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r2.name     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.h(r3, r8)     // Catch:{ JSONException -> 0x0150 }
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0150 }
            if (r0 == 0) goto L_0x0146
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0150 }
            r0.<init>()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r1.f37507e     // Catch:{ JSONException -> 0x0150 }
            r0.append(r3)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r15)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r10)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r7)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0150 }
            return r0
        L_0x00fe:
            r19 = r0
            r20 = r4
            java.lang.String r0 = r12.toLowerCase()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r0 = com.original.tase.helper.TitleHelper.h(r0, r8)     // Catch:{ JSONException -> 0x0150 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0150 }
            r3.<init>()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = r2.name     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ JSONException -> 0x0150 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0150 }
            r3.append(r5)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = r2.session     // Catch:{ JSONException -> 0x0150 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.h(r3, r8)     // Catch:{ JSONException -> 0x0150 }
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0150 }
            if (r0 == 0) goto L_0x0146
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0150 }
            r0.<init>()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r3 = r1.f37507e     // Catch:{ JSONException -> 0x0150 }
            r0.append(r3)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r15)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r10)     // Catch:{ JSONException -> 0x0150 }
            r0.append(r7)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0150 }
            return r0
        L_0x0146:
            int r9 = r9 + 1
            r3 = r23
            r0 = r19
            r4 = r20
            goto L_0x0087
        L_0x0150:
            r0 = move-exception
            goto L_0x0158
        L_0x0152:
            r20 = r4
            goto L_0x015b
        L_0x0155:
            r0 = move-exception
            r20 = r4
        L_0x0158:
            r0.printStackTrace()
        L_0x015b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r1.f37507e
            r0.append(r3)
            java.lang.String r3 = "/searching/"
            r0.append(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r22.getName()
            java.lang.String r9 = "Marvel's "
            java.lang.String r4 = r4.replace(r9, r8)
            java.lang.String r9 = "[^A-Za-z0-9 ]"
            java.lang.String r4 = r4.replaceAll(r9, r8)
            java.lang.String r9 = "  "
            java.lang.String r4 = r4.replace(r9, r13)
            java.lang.String r4 = com.original.tase.helper.TitleHelper.e(r4)
            r3.append(r4)
            if (r24 == 0) goto L_0x01a2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r13)
            java.lang.Integer r9 = r22.getYear()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            goto L_0x01a3
        L_0x01a2:
            r4 = r8
        L_0x01a3:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            boolean[] r9 = new boolean[r4]
            java.lang.String r3 = com.original.tase.utils.Utils.k(r3, r9)
            java.lang.String r4 = "%20"
            java.lang.String r3 = r3.replace(r4, r14)
            r0.append(r3)
            r0.append(r7)
            java.lang.String r3 = r0.toString()
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r1.f37507e
            r4.append(r7)
            java.lang.String r7 = "/"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = r0.o(r3, r4)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r4 = "div.ml-item"
            org.jsoup.select.Elements r0 = r0.q0(r4)
            java.util.Iterator r4 = r0.iterator()
        L_0x01ea:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x04bb
            java.lang.Object r0 = r4.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r9 = "a[href]"
            org.jsoup.nodes.Element r9 = r0.r0(r9)     // Catch:{ Exception -> 0x049c }
            if (r9 != 0) goto L_0x01ff
            goto L_0x01ea
        L_0x01ff:
            org.jsoup.select.Elements r10 = r0.q0(r6)     // Catch:{ Exception -> 0x049c }
            int r10 = r10.size()     // Catch:{ Exception -> 0x049c }
            if (r10 <= 0) goto L_0x0222
            org.jsoup.select.Elements r10 = r0.q0(r6)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r10 = r10.h()     // Catch:{ Exception -> 0x0212 }
            goto L_0x0223
        L_0x0212:
            r0 = move-exception
            r10 = r23
            r24 = r4
            r19 = r6
            r12 = r20
            r4 = 0
            r20 = r3
            r3 = r18
            goto L_0x04aa
        L_0x0222:
            r10 = r8
        L_0x0223:
            boolean r12 = r10.isEmpty()     // Catch:{ Exception -> 0x049c }
            if (r12 == 0) goto L_0x022f
            java.lang.String r10 = "title"
            java.lang.String r10 = r9.c(r10)     // Catch:{ Exception -> 0x0212 }
        L_0x022f:
            java.lang.String r12 = "href"
            java.lang.String r9 = r9.c(r12)     // Catch:{ Exception -> 0x049c }
            boolean r12 = r10.isEmpty()     // Catch:{ Exception -> 0x049c }
            if (r12 != 0) goto L_0x048e
            boolean r12 = r9.isEmpty()     // Catch:{ Exception -> 0x049c }
            if (r12 != 0) goto L_0x048e
            java.lang.String r12 = "span.mli-eps"
            org.jsoup.select.Elements r12 = r0.q0(r12)     // Catch:{ Exception -> 0x049c }
            int r12 = r12.size()     // Catch:{ Exception -> 0x049c }
            if (r12 <= 0) goto L_0x024f
            r12 = 1
            goto L_0x0250
        L_0x024f:
            r12 = 0
        L_0x0250:
            if (r11 == 0) goto L_0x0254
            if (r12 != 0) goto L_0x048e
        L_0x0254:
            if (r11 != 0) goto L_0x0258
            if (r12 == 0) goto L_0x048e
        L_0x0258:
            r12 = r20
            org.jsoup.select.Elements r13 = r0.q0(r12)     // Catch:{ Exception -> 0x0484 }
            int r13 = r13.size()     // Catch:{ Exception -> 0x0484 }
            if (r13 <= 0) goto L_0x026f
            org.jsoup.nodes.Element r13 = r0.r0(r12)     // Catch:{ Exception -> 0x0484 }
            java.lang.String r14 = "alt"
            java.lang.String r13 = r13.c(r14)     // Catch:{ Exception -> 0x0484 }
            goto L_0x0270
        L_0x026f:
            r13 = r8
        L_0x0270:
            java.lang.String r14 = "\\s*-\\s*(\\s*\\d{4})\\s*$"
            r15 = 1
            java.lang.String r14 = com.original.tase.utils.Regex.a(r13, r14, r15)     // Catch:{ Exception -> 0x0484 }
            boolean r16 = r14.isEmpty()     // Catch:{ Exception -> 0x0484 }
            if (r16 == 0) goto L_0x0283
            java.lang.String r14 = "\\s+\\(\\s*(\\d{4})\\s*\\)$"
            java.lang.String r14 = com.original.tase.utils.Regex.a(r13, r14, r15)     // Catch:{ Exception -> 0x0484 }
        L_0x0283:
            boolean r13 = r14.isEmpty()     // Catch:{ Exception -> 0x0484 }
            java.lang.String r15 = "http"
            if (r13 == 0) goto L_0x0302
            java.lang.String r13 = "a[data-url*=\"movie_info\"]"
            org.jsoup.nodes.Element r0 = r0.r0(r13)     // Catch:{ Exception -> 0x02fd }
            if (r0 == 0) goto L_0x0302
            java.lang.String r13 = "data-url"
            java.lang.String r0 = r0.c(r13)     // Catch:{ Exception -> 0x02fd }
            java.lang.String r13 = "movie_info"
            boolean r13 = r0.contains(r13)     // Catch:{ Exception -> 0x02fd }
            if (r13 == 0) goto L_0x0302
            boolean r13 = r0.startsWith(r7)     // Catch:{ Exception -> 0x02fd }
            if (r13 == 0) goto L_0x02b8
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0484 }
            r13.<init>()     // Catch:{ Exception -> 0x0484 }
            java.lang.String r14 = r1.f37507e     // Catch:{ Exception -> 0x0484 }
            r13.append(r14)     // Catch:{ Exception -> 0x0484 }
            r13.append(r0)     // Catch:{ Exception -> 0x0484 }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x0484 }
        L_0x02b8:
            boolean r13 = r0.startsWith(r15)     // Catch:{ Exception -> 0x02fd }
            if (r13 != 0) goto L_0x02d2
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0484 }
            r13.<init>()     // Catch:{ Exception -> 0x0484 }
            java.lang.String r14 = r1.f37507e     // Catch:{ Exception -> 0x0484 }
            r13.append(r14)     // Catch:{ Exception -> 0x0484 }
            r13.append(r7)     // Catch:{ Exception -> 0x0484 }
            r13.append(r0)     // Catch:{ Exception -> 0x0484 }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x0484 }
        L_0x02d2:
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x02fd }
            r24 = r4
            r14 = 1
            java.util.Map[] r4 = new java.util.Map[r14]     // Catch:{ Exception -> 0x047e }
            java.util.HashMap r14 = com.original.Constants.c()     // Catch:{ Exception -> 0x047e }
            r17 = 0
            r4[r17] = r14     // Catch:{ Exception -> 0x047e }
            java.lang.String r0 = r13.r(r0, r3, r4)     // Catch:{ Exception -> 0x047e }
            java.lang.String r4 = "\\\""
            java.lang.String r13 = "\""
            java.lang.String r0 = r0.replace(r4, r13)     // Catch:{ Exception -> 0x047e }
            java.lang.String r4 = "\\/"
            java.lang.String r0 = r0.replace(r4, r7)     // Catch:{ Exception -> 0x047e }
            java.lang.String r4 = "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>"
            r13 = 1
            java.lang.String r14 = com.original.tase.utils.Regex.c(r0, r4, r13, r13)     // Catch:{ Exception -> 0x047e }
            goto L_0x0304
        L_0x02fd:
            r0 = move-exception
            r24 = r4
            goto L_0x047f
        L_0x0302:
            r24 = r4
        L_0x0304:
            java.lang.String r0 = "</?h2>"
            java.lang.String r0 = r10.replaceAll(r0, r8)     // Catch:{ Exception -> 0x047e }
            java.lang.String r4 = "\\s+\\(?\\d{4}\\)?$"
            java.lang.String r4 = r0.replaceAll(r4, r8)     // Catch:{ Exception -> 0x047e }
            java.lang.String r0 = "\\s*(?:\\:|-)?\\s*(?:S|s)eason\\s*(\\d+)"
            r10 = 1
            java.lang.String r13 = com.original.tase.utils.Regex.a(r4, r0, r10)     // Catch:{ Exception -> 0x047e }
            if (r11 != 0) goto L_0x0345
            r10 = r23
            boolean r0 = r13.equals(r10)     // Catch:{ Exception -> 0x0339 }
            if (r0 != 0) goto L_0x0347
            int r0 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x0339 }
            java.lang.String r0 = com.original.tase.utils.Utils.i(r0)     // Catch:{ Exception -> 0x0339 }
            int r19 = java.lang.Integer.parseInt(r23)     // Catch:{ Exception -> 0x0339 }
            r20 = r3
            java.lang.String r3 = com.original.tase.utils.Utils.i(r19)     // Catch:{ Exception -> 0x0337 }
            r0.equals(r3)     // Catch:{ Exception -> 0x0337 }
            goto L_0x0349
        L_0x0337:
            r0 = move-exception
            goto L_0x033c
        L_0x0339:
            r0 = move-exception
            r20 = r3
        L_0x033c:
            r19 = r6
            r3 = 0
            boolean[] r6 = new boolean[r3]     // Catch:{ Exception -> 0x0415 }
            com.original.tase.Logger.d(r0, r6)     // Catch:{ Exception -> 0x0415 }
            goto L_0x034b
        L_0x0345:
            r10 = r23
        L_0x0347:
            r20 = r3
        L_0x0349:
            r19 = r6
        L_0x034b:
            if (r11 != 0) goto L_0x036e
            boolean r0 = r13.equals(r10)     // Catch:{ Exception -> 0x0367 }
            if (r0 != 0) goto L_0x036e
            int r0 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = com.original.tase.utils.Utils.i(r0)     // Catch:{ Exception -> 0x0367 }
            int r3 = java.lang.Integer.parseInt(r23)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = com.original.tase.utils.Utils.i(r3)     // Catch:{ Exception -> 0x0367 }
            r0.equals(r3)     // Catch:{ Exception -> 0x0367 }
            goto L_0x036e
        L_0x0367:
            r0 = move-exception
            r3 = 0
            boolean[] r6 = new boolean[r3]     // Catch:{ Exception -> 0x0415 }
            com.original.tase.Logger.d(r0, r6)     // Catch:{ Exception -> 0x0415 }
        L_0x036e:
            if (r11 == 0) goto L_0x0418
            java.lang.String r0 = r22.getName()     // Catch:{ Exception -> 0x0415 }
            java.lang.String r0 = com.original.tase.helper.TitleHelper.f(r0)     // Catch:{ Exception -> 0x0415 }
            java.lang.String r3 = "\\s*(?:\\:|-)?\\s*(?:S|s)eason\\s*\\d+"
            java.lang.String r3 = r4.replaceAll(r3, r8)     // Catch:{ Exception -> 0x0415 }
            java.lang.String r3 = com.original.tase.helper.TitleHelper.f(r3)     // Catch:{ Exception -> 0x0415 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0415 }
            if (r0 == 0) goto L_0x0498
            java.lang.String r0 = r14.trim()     // Catch:{ Exception -> 0x0415 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0415 }
            if (r0 != 0) goto L_0x03df
            java.lang.String r0 = r14.trim()     // Catch:{ Exception -> 0x0415 }
            boolean r0 = com.original.tase.utils.Utils.o(r0)     // Catch:{ Exception -> 0x0415 }
            if (r0 == 0) goto L_0x03df
            java.lang.Integer r0 = r22.getYear()     // Catch:{ Exception -> 0x0415 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0415 }
            if (r0 <= 0) goto L_0x03df
            if (r11 == 0) goto L_0x03ba
            java.lang.String r0 = r14.trim()     // Catch:{ Exception -> 0x0415 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0415 }
            java.lang.Integer r3 = r22.getYear()     // Catch:{ Exception -> 0x0415 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0415 }
            if (r0 == r3) goto L_0x03df
        L_0x03ba:
            if (r11 != 0) goto L_0x03d0
            if (r18 > 0) goto L_0x03d0
            java.lang.String r0 = r14.trim()     // Catch:{ Exception -> 0x0415 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0415 }
            java.lang.Integer r3 = r22.getYear()     // Catch:{ Exception -> 0x0415 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0415 }
            if (r0 == r3) goto L_0x03df
        L_0x03d0:
            if (r11 != 0) goto L_0x0498
            java.lang.String r0 = r14.trim()     // Catch:{ Exception -> 0x0415 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0415 }
            r3 = r18
            if (r0 != r3) goto L_0x049a
            goto L_0x03e1
        L_0x03df:
            r3 = r18
        L_0x03e1:
            boolean r0 = r9.startsWith(r7)     // Catch:{ Exception -> 0x047c }
            if (r0 == 0) goto L_0x03f9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047c }
            r0.<init>()     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = r1.f37507e     // Catch:{ Exception -> 0x047c }
            r0.append(r4)     // Catch:{ Exception -> 0x047c }
            r0.append(r9)     // Catch:{ Exception -> 0x047c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x047c }
            return r0
        L_0x03f9:
            boolean r0 = r9.startsWith(r15)     // Catch:{ Exception -> 0x047c }
            if (r0 == 0) goto L_0x0400
            return r9
        L_0x0400:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047c }
            r0.<init>()     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = r1.f37507e     // Catch:{ Exception -> 0x047c }
            r0.append(r4)     // Catch:{ Exception -> 0x047c }
            r0.append(r7)     // Catch:{ Exception -> 0x047c }
            r0.append(r9)     // Catch:{ Exception -> 0x047c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x047c }
            return r0
        L_0x0415:
            r0 = move-exception
            goto L_0x04a7
        L_0x0418:
            r3 = r18
            java.lang.String r0 = com.original.tase.helper.TitleHelper.f(r4)     // Catch:{ Exception -> 0x047c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047c }
            r4.<init>()     // Catch:{ Exception -> 0x047c }
            java.lang.String r6 = r22.getName()     // Catch:{ Exception -> 0x047c }
            r4.append(r6)     // Catch:{ Exception -> 0x047c }
            r4.append(r5)     // Catch:{ Exception -> 0x047c }
            java.lang.String r6 = r2.session     // Catch:{ Exception -> 0x047c }
            r4.append(r6)     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = com.original.tase.helper.TitleHelper.e(r4)     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = com.original.tase.helper.TitleHelper.f(r4)     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = com.original.tase.helper.TitleHelper.f(r4)     // Catch:{ Exception -> 0x047c }
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x047c }
            if (r0 == 0) goto L_0x049a
            boolean r0 = r9.startsWith(r7)     // Catch:{ Exception -> 0x047c }
            if (r0 == 0) goto L_0x0460
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047c }
            r0.<init>()     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = r1.f37507e     // Catch:{ Exception -> 0x047c }
            r0.append(r4)     // Catch:{ Exception -> 0x047c }
            r0.append(r9)     // Catch:{ Exception -> 0x047c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x047c }
            return r0
        L_0x0460:
            boolean r0 = r9.startsWith(r15)     // Catch:{ Exception -> 0x047c }
            if (r0 == 0) goto L_0x0467
            return r9
        L_0x0467:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047c }
            r0.<init>()     // Catch:{ Exception -> 0x047c }
            java.lang.String r4 = r1.f37507e     // Catch:{ Exception -> 0x047c }
            r0.append(r4)     // Catch:{ Exception -> 0x047c }
            r0.append(r7)     // Catch:{ Exception -> 0x047c }
            r0.append(r9)     // Catch:{ Exception -> 0x047c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x047c }
            return r0
        L_0x047c:
            r0 = move-exception
            goto L_0x04a9
        L_0x047e:
            r0 = move-exception
        L_0x047f:
            r10 = r23
            r20 = r3
            goto L_0x048b
        L_0x0484:
            r0 = move-exception
            r10 = r23
            r20 = r3
            r24 = r4
        L_0x048b:
            r19 = r6
            goto L_0x04a7
        L_0x048e:
            r10 = r23
            r24 = r4
            r19 = r6
            r12 = r20
            r20 = r3
        L_0x0498:
            r3 = r18
        L_0x049a:
            r4 = 0
            goto L_0x04af
        L_0x049c:
            r0 = move-exception
            r10 = r23
            r24 = r4
            r19 = r6
            r12 = r20
            r20 = r3
        L_0x04a7:
            r3 = r18
        L_0x04a9:
            r4 = 0
        L_0x04aa:
            boolean[] r6 = new boolean[r4]
            com.original.tase.Logger.d(r0, r6)
        L_0x04af:
            r4 = r24
            r18 = r3
            r6 = r19
            r3 = r20
            r20 = r12
            goto L_0x01ea
        L_0x04bb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.YesMovies.J(com.movie.data.model.MovieInfo, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r23, java.lang.String r24, com.movie.data.model.MovieInfo r25, java.lang.String r26) {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            java.lang.Integer r2 = r25.getSession()
            int r2 = r2.intValue()
            r3 = 0
            r4 = 1
            if (r2 >= 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            java.lang.String r5 = "-(\\d+)"
            java.util.ArrayList r5 = com.original.tase.utils.Regex.f(r0, r5, r4, r4)
            java.lang.Object r5 = r5.get(r3)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0031
            int r6 = r5.size()
            int r6 = r6 - r4
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            if (r5 == 0) goto L_0x026f
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r6 = r6.o(r0, r0)
            if (r2 == 0) goto L_0x0051
            java.lang.String r7 = ">\\s*(\\d{4})\\s*<"
            java.lang.String r7 = com.original.tase.utils.Regex.a(r6, r7, r4)
            java.lang.String r7 = r7.trim()
            java.lang.String r8 = r1.year
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0051
            return
        L_0x0051:
            org.jsoup.nodes.Document r7 = org.jsoup.Jsoup.b(r6)
            java.lang.String r8 = "span.quality"
            org.jsoup.nodes.Element r8 = r7.r0(r8)
            if (r8 == 0) goto L_0x007b
            java.lang.String r8 = r8.v0()
            java.lang.String r8 = r8.trim()
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r9 = "cam"
            boolean r9 = r8.contains(r9)
            if (r9 != 0) goto L_0x0079
            java.lang.String r9 = "ts"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x007b
        L_0x0079:
            r8 = 1
            goto L_0x007c
        L_0x007b:
            r8 = 0
        L_0x007c:
            java.util.HashMap r9 = com.original.Constants.c()
            java.lang.String r10 = "accept"
            java.lang.String r11 = "application/json, text/javascript, */*; q=0.01"
            r9.put(r10, r11)
            java.lang.String r10 = "content-type"
            java.lang.String r11 = "application/json"
            r9.put(r10, r11)
            java.lang.String r12 = "referer"
            r9.put(r12, r0)
            java.lang.String r0 = "user-agent"
            java.lang.String r13 = com.original.Constants.C
            r9.put(r0, r13)
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x026f
            java.lang.String r0 = "div.pas-list"
            org.jsoup.nodes.Element r0 = r7.r0(r0)
            if (r0 == 0) goto L_0x026f
            java.lang.String r6 = "li[data-id][data-server]"
            org.jsoup.select.Elements r0 = r0.q0(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x00b2:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x026f
            java.lang.Object r6 = r0.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r7 = "a[title]"
            org.jsoup.nodes.Element r7 = r6.r0(r7)
            if (r7 == 0) goto L_0x0253
            java.lang.String r13 = "data-id"
            java.lang.String r13 = r6.c(r13)
            java.lang.String r14 = "data-server"
            java.lang.String r6 = r6.c(r14)
            java.lang.String r14 = "title"
            java.lang.String r7 = r7.c(r14)
            java.lang.String r14 = "HD"
            if (r2 != 0) goto L_0x00dd
            r7 = r14
        L_0x00dd:
            if (r2 != 0) goto L_0x00e1
            java.lang.String r13 = r1.eps
        L_0x00e1:
            r15 = 3
            java.lang.Object[] r15 = new java.lang.Object[r15]
            r15[r3] = r5
            r15[r4] = r13
            r13 = 2
            r15[r13] = r6
            java.lang.String r6 = "{\"m\":\"%s\",\"e\":\"%s\",\"s\":\"%s\"}"
            java.lang.String r6 = java.lang.String.format(r6, r15)
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r3 = r22
            java.lang.String r4 = r3.f37507e
            r15.append(r4)
            java.lang.String r4 = "/datas"
            r15.append(r4)
            java.lang.String r4 = r15.toString()
            r24 = r0
            r15 = 1
            java.util.Map[] r0 = new java.util.Map[r15]
            r15 = 0
            r0[r15] = r9
            java.lang.String r0 = r13.q(r4, r6, r15, r0)
            java.lang.String r4 = "http 2 ------o "
            com.original.tase.Logger.b(r4, r0)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r6 = "User-Agent"
            java.lang.String r13 = com.original.Constants.C
            r4.put(r6, r13)
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0246
            java.lang.String r6 = "[\"'](?:url|src)[\"']?\\s*:\\s*[\"']([^\"']+)"
            r13 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r6, r13)
            java.lang.String r13 = "\\/"
            java.lang.String r15 = "/"
            java.lang.String r0 = r0.replace(r13, r15)
            java.lang.String r1 = "\\\\"
            r16 = r2
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            boolean r17 = r0.isEmpty()
            if (r17 != 0) goto L_0x0243
            java.lang.String r3 = "http"
            boolean r17 = r0.contains(r3)
            if (r17 != 0) goto L_0x01f4
            r17 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r18 = r9
            java.lang.String r9 = "https://vidcloud9.org/watch?v="
            r5.append(r9)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.put(r12, r5)
            com.original.tase.helper.http.HttpHelper r9 = com.original.tase.helper.http.HttpHelper.i()
            r20 = r7
            r19 = r14
            r14 = 0
            java.util.Map[] r7 = new java.util.Map[r14]
            java.lang.String r7 = r9.m(r5, r7)
            java.lang.String r9 = "[\"']([0-9a-zA-Z-_+]+\\.[0-9a-zA-Z-_+]+\\.[0-9a-zA-Z-_+]+)[\"']"
            r14 = 1
            java.lang.String r7 = com.original.tase.utils.Regex.a(r7, r9, r14)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r9.put(r10, r11)
            r9.put(r12, r5)
            java.lang.String r5 = "x-csrf-token"
            r9.put(r5, r7)
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.Object[] r7 = new java.lang.Object[r14]
            r14 = 0
            r7[r14] = r0
            java.lang.String r0 = "{\"doc\":\"%s\"}"
            java.lang.String r0 = java.lang.String.format(r0, r7)
            r21 = r10
            r7 = 1
            java.util.Map[] r10 = new java.util.Map[r7]
            r10[r14] = r9
            java.lang.String r9 = "https://vidcloud9.org/data"
            java.lang.String r0 = r5.q(r9, r0, r14, r10)
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r6, r7)
            java.lang.String r0 = r0.replace(r13, r15)
            java.lang.String r0 = r0.replace(r1, r2)
            boolean r1 = r0.contains(r3)
            if (r1 != 0) goto L_0x01db
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x01cf }
            r2 = 10
            byte[] r2 = android.util.Base64.decode(r0, r2)     // Catch:{ all -> 0x01cf }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x01cf }
            r0 = r1
            goto L_0x01db
        L_0x01cf:
            java.lang.String r1 = new java.lang.String
            r2 = 0
            byte[] r0 = android.util.Base64.decode(r0, r2)
            r1.<init>(r0)
            r0 = r1
            goto L_0x01dc
        L_0x01db:
            r2 = 0
        L_0x01dc:
            boolean r1 = r0.startsWith(r15)
            if (r1 == 0) goto L_0x01ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://vidcloud9.org"
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x01ff
        L_0x01f4:
            r17 = r5
            r20 = r7
            r18 = r9
            r21 = r10
            r19 = r14
            r2 = 0
        L_0x01ff:
            java.lang.String r1 = "http movie_episodes------ "
            com.original.tase.Logger.b(r1, r0)
            com.original.tase.Logger.a(r0)
            com.original.tase.model.media.MediaSource r1 = new com.original.tase.model.media.MediaSource
            java.lang.String r3 = r22.A()
            java.lang.String r5 = "CDN-FastServer"
            r1.<init>(r3, r5, r8)
            java.lang.String r3 = ".m3u8"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0224
            java.lang.String r3 = "Accept"
            java.lang.String r5 = "*/*"
            r4.put(r3, r5)
            r1.setPlayHeader(r4)
        L_0x0224:
            java.lang.String r3 = "(\\d{3,4})"
            r14 = r20
            r4 = 1
            java.lang.String r3 = com.original.tase.utils.Regex.a(r14, r3, r4)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0236
            r14 = r19
            goto L_0x0237
        L_0x0236:
            r14 = r3
        L_0x0237:
            r1.setStreamLink(r0)
            r1.setQuality((java.lang.String) r14)
            r0 = r23
            r0.onNext(r1)
            goto L_0x0260
        L_0x0243:
            r0 = r23
            goto L_0x024a
        L_0x0246:
            r0 = r23
            r16 = r2
        L_0x024a:
            r17 = r5
            r18 = r9
            r21 = r10
            r2 = 0
            r4 = 1
            goto L_0x0260
        L_0x0253:
            r24 = r0
            r16 = r2
            r17 = r5
            r18 = r9
            r21 = r10
            r2 = 0
            r0 = r23
        L_0x0260:
            r0 = r24
            r1 = r25
            r2 = r16
            r5 = r17
            r9 = r18
            r10 = r21
            r3 = 0
            goto L_0x00b2
        L_0x026f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.YesMovies.K(io.reactivex.ObservableEmitter, java.lang.String, com.movie.data.model.MovieInfo, java.lang.String):void");
    }

    public String A() {
        return "YesMovies";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String J = J(movieInfo, "-1", false);
        if (J.isEmpty()) {
            J = SearchHelper.e(movieInfo.name, movieInfo.year, "", this.f37507e, "");
            if (J.isEmpty()) {
                return;
            }
        }
        K(observableEmitter, J, movieInfo, "-1");
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}
