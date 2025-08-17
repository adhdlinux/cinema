package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;

public class Hdpopcorns extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37351e = Utils.getProvider(90);

    /* renamed from: f  reason: collision with root package name */
    String[] f37352f = new String[0];

    public String A() {
        return "Hdpopcorns";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37352f = new String[]{"animeout", "fzmovies", "takanimelist", "besthdmovies", "netnaija", "kdramahood"};
        J(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        this.f37352f = new String[]{"tvseries"};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00db, code lost:
        if (r6.startsWith(com.original.tase.helper.TitleHelper.h(r1.name.toLowerCase(r13) + r1.year, "")) != false) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String J(com.movie.data.model.MovieInfo r17, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "Accept"
            java.lang.String r4 = "application/json, text/plain, */*"
            r2.put(r3, r4)
            java.lang.String r3 = "Origin"
            java.lang.String r4 = r0.f37351e
            r2.put(r3, r4)
            java.lang.String r3 = r0.f37351e
            java.lang.String r4 = "Referer"
            r2.put(r4, r3)
            java.lang.String[] r3 = r0.f37352f
            int r5 = r3.length
            r6 = 0
            r7 = 0
        L_0x0023:
            java.lang.String r8 = ""
            if (r7 >= r5) goto L_0x013e
            r9 = r3[r7]
            java.lang.String r10 = r1.name
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = " "
            java.lang.String r12 = "%20"
            java.lang.String r10 = r10.replace(r11, r12)
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r12 = r0.f37351e
            java.lang.String r12 = com.utils.Getlink.Provider.BaseProvider.i(r12)
            r11[r6] = r12
            r12 = 1
            r11[r12] = r10
            r10 = 2
            r11[r10] = r9
            java.lang.String r9 = "https://ocena.%s/search/?query=%s&engine=%s&page=1"
            java.lang.String r9 = java.lang.String.format(r9, r11)
            java.lang.String r10 = "Host"
            java.lang.String r11 = com.utils.Getlink.Provider.BaseProvider.i(r9)
            r2.put(r10, r11)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r11 = new java.util.Map[r12]
            r11[r6] = r2
            java.lang.String r9 = r10.m(r9, r11)
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0136 }
            r10.<init>(r9)     // Catch:{ JSONException -> 0x0136 }
            r9 = 0
        L_0x006b:
            int r11 = r10.length()     // Catch:{ JSONException -> 0x0136 }
            if (r9 >= r11) goto L_0x0136
            org.json.JSONObject r11 = r10.getJSONObject(r9)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r12 = "name"
            java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x0136 }
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r14 = r12.toLowerCase(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r15 = "trailer"
            boolean r14 = r14.contains(r15)     // Catch:{ JSONException -> 0x0136 }
            if (r14 == 0) goto L_0x008e
        L_0x0089:
            r6 = r18
            r15 = 0
            goto L_0x0131
        L_0x008e:
            java.lang.String r14 = "upload_date"
            java.lang.String r14 = r11.getString(r14)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r15 = r1.name     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r15 = r15.toLowerCase(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r15 = com.original.tase.helper.TitleHelper.h(r15, r8)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = r12.toLowerCase(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = com.original.tase.helper.TitleHelper.h(r6, r8)     // Catch:{ JSONException -> 0x0136 }
            boolean r6 = r15.equals(r6)     // Catch:{ JSONException -> 0x0136 }
            if (r6 == 0) goto L_0x00b4
            java.lang.String r6 = r1.year     // Catch:{ JSONException -> 0x0136 }
            boolean r6 = r14.contains(r6)     // Catch:{ JSONException -> 0x0136 }
            if (r6 != 0) goto L_0x00dd
        L_0x00b4:
            java.lang.String r6 = r12.toLowerCase(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = com.original.tase.helper.TitleHelper.h(r6, r8)     // Catch:{ JSONException -> 0x0136 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0136 }
            r14.<init>()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r15 = r1.name     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = r15.toLowerCase(r13)     // Catch:{ JSONException -> 0x0136 }
            r14.append(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = r1.year     // Catch:{ JSONException -> 0x0136 }
            r14.append(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = r14.toString()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = com.original.tase.helper.TitleHelper.h(r13, r8)     // Catch:{ JSONException -> 0x0136 }
            boolean r6 = r6.startsWith(r13)     // Catch:{ JSONException -> 0x0136 }
            if (r6 == 0) goto L_0x0089
        L_0x00dd:
            java.lang.String r6 = r16.A()     // Catch:{ JSONException -> 0x0136 }
            com.original.tase.Logger.b(r6, r12)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = "download_link"
            java.lang.String r6 = r11.getString(r6)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r12 = "s_download_link"
            r11.getString(r12)     // Catch:{ JSONException -> 0x0136 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ JSONException -> 0x0136 }
            r11.<init>()     // Catch:{ JSONException -> 0x0136 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0136 }
            r12.<init>()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = r0.f37351e     // Catch:{ JSONException -> 0x0136 }
            r12.append(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = "/search"
            r12.append(r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r12 = r12.toString()     // Catch:{ JSONException -> 0x0136 }
            r11.put(r4, r12)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r12 = "User-agent"
            java.lang.String r13 = com.original.Constants.C     // Catch:{ JSONException -> 0x0136 }
            r11.put(r12, r13)     // Catch:{ JSONException -> 0x0136 }
            com.original.tase.model.media.MediaSource r12 = new com.original.tase.model.media.MediaSource     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r13 = r16.A()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r14 = "CDN"
            r15 = 0
            r12.<init>(r13, r14, r15)     // Catch:{ JSONException -> 0x012e }
            r12.setPlayHeader(r11)     // Catch:{ JSONException -> 0x012e }
            r12.setStreamLink(r6)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r6 = "HD"
            r12.setQuality((java.lang.String) r6)     // Catch:{ JSONException -> 0x012e }
            r6 = r18
            r6.onNext(r12)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x0131
        L_0x012e:
            r6 = r18
            goto L_0x0139
        L_0x0131:
            int r9 = r9 + 1
            r6 = 0
            goto L_0x006b
        L_0x0136:
            r6 = r18
            r15 = 0
        L_0x0139:
            int r7 = r7 + 1
            r6 = 0
            goto L_0x0023
        L_0x013e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Hdpopcorns.J(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):java.lang.String");
    }
}
