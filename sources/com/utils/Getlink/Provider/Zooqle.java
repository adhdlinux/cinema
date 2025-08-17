package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;

public class Zooqle extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f37511e = Utils.getProvider(14);

    public String A() {
        return "Zooqle";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, true);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (BaseProvider.v()) {
            J(movieInfo, observableEmitter, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x014d, code lost:
        if (r11.isEmpty() != false) goto L_0x014f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(com.movie.data.model.MovieInfo r17, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r18, boolean r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.original.tase.helper.DirectoryIndexHelper r2 = new com.original.tase.helper.DirectoryIndexHelper
            r2.<init>()
            java.lang.Integer r3 = r17.getType()
            int r3 = r3.intValue()
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            if (r3 == 0) goto L_0x002e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = " "
            r6.append(r7)
            java.lang.String r7 = r0.year
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x0077
        L_0x002e:
            java.lang.String r6 = " S"
            if (r19 == 0) goto L_0x004c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = r0.session
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r6 = com.original.tase.utils.Utils.i(r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L_0x0077
        L_0x004c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = r0.session
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r6 = com.original.tase.utils.Utils.i(r6)
            r7.append(r6)
            java.lang.String r6 = "E"
            r7.append(r6)
            java.lang.String r6 = r0.eps
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r6 = com.original.tase.utils.Utils.i(r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
        L_0x0077:
            java.lang.String r7 = r1.f37511e
            if (r3 == 0) goto L_0x0097
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = "/stream/movie/"
            r8.append(r7)
            java.lang.String r0 = r0.imdbIDStr
            r8.append(r0)
            java.lang.String r0 = ".json"
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            goto L_0x00e8
        L_0x0097:
            java.lang.String r8 = "/stream/series/"
            java.lang.String r9 = ":"
            if (r19 == 0) goto L_0x00bf
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r8)
            java.lang.String r7 = r0.imdbIDStr
            r10.append(r7)
            r10.append(r9)
            java.lang.String r0 = r0.session
            r10.append(r0)
            java.lang.String r0 = ":1.json?language=en"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            goto L_0x00e8
        L_0x00bf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r8)
            java.lang.String r7 = r0.imdbIDStr
            r10.append(r7)
            r10.append(r9)
            java.lang.String r7 = r0.session
            r10.append(r7)
            r10.append(r9)
            java.lang.String r0 = r0.eps
            r10.append(r0)
            java.lang.String r0 = ".json?language=en"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
        L_0x00e8:
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r8 = new java.util.Map[r4]
            java.lang.String r0 = r7.m(r0, r8)
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L_0x01ac
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01a5 }
            r8.<init>(r0)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r0 = "streams"
            org.json.JSONArray r0 = r8.getJSONArray(r0)     // Catch:{ JSONException -> 0x01a5 }
            r8 = 0
        L_0x0109:
            int r9 = r0.length()     // Catch:{ JSONException -> 0x01a5 }
            if (r8 >= r9) goto L_0x017a
            org.json.JSONObject r9 = r0.getJSONObject(r8)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r10 = "title"
            java.lang.String r10 = r9.getString(r10)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ JSONException -> 0x01a5 }
            timber.log.Timber.f(r10, r11)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r11 = "infoHash"
            java.lang.String r9 = r9.getString(r11)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r11 = r16.A()     // Catch:{ JSONException -> 0x01a5 }
            if (r3 == 0) goto L_0x012f
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r12 = r2.c(r10)     // Catch:{ JSONException -> 0x01a5 }
            goto L_0x0133
        L_0x012f:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r12 = r2.d(r10)     // Catch:{ JSONException -> 0x01a5 }
        L_0x0133:
            java.lang.String r13 = "HQ"
            if (r12 == 0) goto L_0x0157
            java.lang.String r11 = r12.c()     // Catch:{ JSONException -> 0x01a5 }
            boolean r14 = r11.equalsIgnoreCase(r13)     // Catch:{ JSONException -> 0x01a5 }
            if (r14 != 0) goto L_0x0143
        L_0x0141:
            r13 = r11
            goto L_0x014f
        L_0x0143:
            java.lang.String r11 = "(\\d{3,4}p)"
            java.lang.String r11 = com.original.tase.utils.Regex.a(r10, r11, r5)     // Catch:{ JSONException -> 0x01a5 }
            boolean r14 = r11.isEmpty()     // Catch:{ JSONException -> 0x01a5 }
            if (r14 == 0) goto L_0x0141
        L_0x014f:
            java.lang.String r11 = r12.b()     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r11 = r1.u(r11, r5)     // Catch:{ JSONException -> 0x01a5 }
        L_0x0157:
            com.movie.data.model.realdebrid.MagnetObject r12 = new com.movie.data.model.realdebrid.MagnetObject     // Catch:{ JSONException -> 0x01a5 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01a5 }
            r14.<init>()     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r15 = "magnet:?xt=urn:btih:"
            r14.append(r15)     // Catch:{ JSONException -> 0x01a5 }
            r14.append(r9)     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r9 = r14.toString()     // Catch:{ JSONException -> 0x01a5 }
            java.lang.String r14 = r16.A()     // Catch:{ JSONException -> 0x01a5 }
            r12.<init>(r11, r9, r13, r14)     // Catch:{ JSONException -> 0x01a5 }
            r12.setFileName(r10)     // Catch:{ JSONException -> 0x01a5 }
            r7.add(r12)     // Catch:{ JSONException -> 0x01a5 }
            int r8 = r8 + 1
            goto L_0x0109
        L_0x017a:
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x01ac
            com.original.tase.model.media.MediaSource r0 = new com.original.tase.model.media.MediaSource
            java.lang.String r2 = r16.A()
            java.lang.String r8 = ""
            r0.<init>(r2, r8, r4)
            r0.setTorrent(r5)
            if (r3 != 0) goto L_0x0197
            java.lang.String r2 = r6.trim()
            r0.setExtra(r2)
        L_0x0197:
            r0.setMagnetObjects(r7)
            java.lang.String r2 = "magnet:Zooqle"
            r0.setStreamLink(r2)
            r2 = r18
            r2.onNext(r0)
            goto L_0x01ac
        L_0x01a5:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0)
            throw r2
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Zooqle.J(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter, boolean):void");
    }

    public int m() {
        return this.f37249a;
    }
}
