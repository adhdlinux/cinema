package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.crypto.AES256Cipher;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Kidomovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37357e = Utils.getProvider(2);

    /* renamed from: f  reason: collision with root package name */
    HashMap f37358f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public String f37359g = Deobfuscator$app$ProductionRelease.a(-192925349392580L);

    /* renamed from: h  reason: collision with root package name */
    public String f37360h = Deobfuscator$app$ProductionRelease.a(-192508737564868L);

    /* renamed from: i  reason: collision with root package name */
    public String f37361i = Deobfuscator$app$ProductionRelease.a(-192689126191300L);

    /* renamed from: j  reason: collision with root package name */
    public String f37362j = Deobfuscator$app$ProductionRelease.a(-192628996649156L);

    /* renamed from: k  reason: collision with root package name */
    public String f37363k = Deobfuscator$app$ProductionRelease.a(-192598931878084L);

    /* renamed from: l  reason: collision with root package name */
    public String f37364l = Deobfuscator$app$ProductionRelease.a(-192568867107012L);

    /* renamed from: m  reason: collision with root package name */
    public String f37365m = Deobfuscator$app$ProductionRelease.a(-193354846122180L);

    /* renamed from: n  reason: collision with root package name */
    public String f37366n = Deobfuscator$app$ProductionRelease.a(-193333371285700L);

    /* renamed from: o  reason: collision with root package name */
    public String f37367o = Deobfuscator$app$ProductionRelease.a(-193436450500804L);

    /* renamed from: p  reason: collision with root package name */
    public String f37368p = Deobfuscator$app$ProductionRelease.a(-193101443051716L);

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r6v4, types: [boolean] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r8v1, types: [int, boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void L(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r21, com.movie.data.model.MovieInfo r22, java.lang.String r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = -192156550246596(0xffff513c1114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            r5[r6] = r23
            java.lang.String r7 = r20.J()
            r8 = 1
            r5[r8] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r9 = -192324053971140(0xffff51151114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.String r9 = r1.f37357e
            r7[r6] = r9
            java.lang.String r5 = java.lang.String.format(r5, r7)
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r9 = new java.util.Map[r8]
            java.util.HashMap r10 = r1.f37358f
            r9[r6] = r10
            java.lang.String r3 = r7.l(r5, r3, r9)
            java.lang.String r5 = r1.f37359g
            java.lang.String r5 = com.original.tase.helper.crypto.AES256Cipher.a(r3, r5)
            r9 = -191924622012612(0xffff51721114cf3c, double:NaN)
            java.lang.String r7 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)
            java.lang.Integer r9 = r22.getType()
            int r9 = r9.intValue()
            if (r9 != r8) goto L_0x005c
            r9 = 1
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            if (r9 != 0) goto L_0x009a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r9 = -191920327045316(0xffff51731114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)
            r7.append(r9)
            java.lang.String r9 = r2.session
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.String r9 = com.original.tase.utils.Utils.i(r9)
            r7.append(r9)
            r9 = -191877377372356(0xffff517d1114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)
            r7.append(r9)
            java.lang.String r2 = r2.eps
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.String r2 = com.original.tase.utils.Utils.i(r2)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
        L_0x009a:
            boolean r2 = r5.isEmpty()
            if (r2 != 0) goto L_0x02a6
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x029f }
            r2.<init>(r5)     // Catch:{ JSONException -> 0x029f }
            r9 = -191868787437764(0xffff517f1114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r2 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x029f }
            r9 = -192122190508228(0xffff51441114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)     // Catch:{ JSONException -> 0x029f }
            org.json.JSONArray r2 = r2.getJSONArray(r5)     // Catch:{ JSONException -> 0x029f }
            r5 = 0
        L_0x00c0:
            int r9 = r2.length()     // Catch:{ JSONException -> 0x029f }
            if (r5 >= r9) goto L_0x02a6
            org.json.JSONObject r9 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x029f }
            r10 = -192083535802564(0xffff514d1114cf3c, double:NaN)
            java.lang.String r10 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r10)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ JSONException -> 0x029f }
            r11 = -192105010639044(0xffff51481114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = r9.getString(r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ JSONException -> 0x029f }
            java.lang.String r11 = r7.toLowerCase()     // Catch:{ JSONException -> 0x029f }
            boolean r9 = r9.contains(r11)     // Catch:{ JSONException -> 0x029f }
            if (r9 != 0) goto L_0x00f4
            goto L_0x0298
        L_0x00f4:
            r11 = -192044881096900(0xffff51561114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ JSONException -> 0x029f }
            r9[r6] = r10     // Catch:{ JSONException -> 0x029f }
            java.lang.String r10 = r20.J()     // Catch:{ JSONException -> 0x029f }
            r9[r8] = r10     // Catch:{ JSONException -> 0x029f }
            java.lang.String r3 = java.lang.String.format(r3, r9)     // Catch:{ JSONException -> 0x029f }
            r9 = -190533052608708(0xffff52b61114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r9)     // Catch:{ JSONException -> 0x029f }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ JSONException -> 0x029f }
            java.lang.String r11 = r1.f37357e     // Catch:{ JSONException -> 0x029f }
            r10[r6] = r11     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ JSONException -> 0x029f }
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ JSONException -> 0x029f }
            java.util.Map[] r11 = new java.util.Map[r8]     // Catch:{ JSONException -> 0x029f }
            java.util.HashMap r12 = r1.f37358f     // Catch:{ JSONException -> 0x029f }
            r11[r6] = r12     // Catch:{ JSONException -> 0x029f }
            java.lang.String r3 = r10.l(r9, r3, r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = r1.f37359g     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = com.original.tase.helper.crypto.AES256Cipher.a(r3, r9)     // Catch:{ JSONException -> 0x029f }
            boolean r10 = r9.isEmpty()     // Catch:{ JSONException -> 0x029f }
            if (r10 != 0) goto L_0x0298
            r10 = -190683376464068(0xffff52931114cf3c, double:NaN)
            java.lang.String r10 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r10)     // Catch:{ JSONException -> 0x029f }
            r11 = -190636131823812(0xffff529e1114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r10 = r9.replace(r10, r11)     // Catch:{ JSONException -> 0x029f }
            r11 = -190661901627588(0xffff52981114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.util.ArrayList r10 = com.original.tase.utils.Regex.g(r10, r11, r8, r8)     // Catch:{ JSONException -> 0x029f }
            r11 = -190223814963396(0xffff52fe1114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            r12 = -190245289799876(0xffff52f91114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r12)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r9 = r9.replace(r11, r12)     // Catch:{ JSONException -> 0x029f }
            r11 = -190236699865284(0xffff52fb1114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.util.ArrayList r9 = com.original.tase.utils.Regex.g(r9, r11, r8, r8)     // Catch:{ JSONException -> 0x029f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ JSONException -> 0x029f }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JSONException -> 0x029f }
        L_0x0186:
            boolean r11 = r10.hasNext()     // Catch:{ JSONException -> 0x029f }
            if (r11 == 0) goto L_0x0298
            java.lang.Object r11 = r10.next()     // Catch:{ JSONException -> 0x029f }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x029f }
            java.lang.Object r12 = r9.next()     // Catch:{ JSONException -> 0x029f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x029f }
            r13 = -190382728753348(0xffff52d91114cf3c, double:NaN)
            java.lang.String r13 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r13)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r12 = com.original.tase.utils.Regex.a(r12, r13, r8)     // Catch:{ JSONException -> 0x029f }
            boolean r13 = r12.isEmpty()     // Catch:{ JSONException -> 0x029f }
            if (r13 == 0) goto L_0x01b4
            r12 = -191125758095556(0xffff522c1114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r12)     // Catch:{ JSONException -> 0x029f }
        L_0x01b4:
            java.lang.String r11 = com.original.tase.utils.Utils.b(r11)     // Catch:{ JSONException -> 0x029f }
            boolean r13 = com.original.tase.helper.GoogleVideoHelper.n(r11)     // Catch:{ JSONException -> 0x029f }
            r14 = -191112873193668(0xffff522f1114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r14)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r14 = com.original.tase.utils.Regex.a(r11, r14, r8)     // Catch:{ JSONException -> 0x029f }
            r15 = -191224542343364(0xffff52151114cf3c, double:NaN)
            java.lang.String r15 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r15)     // Catch:{ JSONException -> 0x029f }
            boolean r15 = r11.contains(r15)     // Catch:{ JSONException -> 0x029f }
            if (r13 != 0) goto L_0x01ea
            if (r15 != 0) goto L_0x01ea
            boolean r14 = r14.isEmpty()     // Catch:{ JSONException -> 0x029f }
            if (r14 != 0) goto L_0x01e1
            goto L_0x01ea
        L_0x01e1:
            boolean[] r13 = new boolean[r8]     // Catch:{ JSONException -> 0x029f }
            r13[r6] = r6     // Catch:{ JSONException -> 0x029f }
            r1.z(r0, r11, r12, r13)     // Catch:{ JSONException -> 0x029f }
            goto L_0x0293
        L_0x01ea:
            com.original.tase.model.media.MediaSource r14 = new com.original.tase.model.media.MediaSource     // Catch:{ JSONException -> 0x029f }
            java.lang.String r4 = r20.A()     // Catch:{ JSONException -> 0x029f }
            if (r13 == 0) goto L_0x01fc
            r17 = -191233132277956(0xffff52131114cf3c, double:NaN)
            java.lang.String r17 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ JSONException -> 0x029f }
            goto L_0x0200
        L_0x01fc:
            java.lang.String r17 = r20.A()     // Catch:{ JSONException -> 0x029f }
        L_0x0200:
            r8 = r17
            r14.<init>(r4, r8, r6)     // Catch:{ JSONException -> 0x029f }
            r14.setStreamLink(r11)     // Catch:{ JSONException -> 0x029f }
            r14.setQuality((java.lang.String) r12)     // Catch:{ JSONException -> 0x029f }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ JSONException -> 0x029f }
            r4.<init>()     // Catch:{ JSONException -> 0x029f }
            r17 = -190872355025092(0xffff52671114cf3c, double:NaN)
            java.lang.String r8 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ JSONException -> 0x029f }
            r12 = 1
            java.lang.String r8 = com.original.tase.utils.Regex.a(r11, r8, r12)     // Catch:{ JSONException -> 0x029f }
            boolean r12 = r8.isEmpty()     // Catch:{ JSONException -> 0x029f }
            if (r12 != 0) goto L_0x024c
            r17 = -190795045613764(0xffff52791114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ JSONException -> 0x029f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x029f }
            r6.<init>()     // Catch:{ JSONException -> 0x029f }
            java.lang.String r8 = com.original.tase.utils.Utils.b(r8)     // Catch:{ JSONException -> 0x029f }
            r6.append(r8)     // Catch:{ JSONException -> 0x029f }
            r18 = -191039858749636(0xffff52401114cf3c, double:NaN)
            java.lang.String r8 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r18)     // Catch:{ JSONException -> 0x029f }
            r6.append(r8)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x029f }
            r4.put(r12, r6)     // Catch:{ JSONException -> 0x029f }
        L_0x024c:
            r18 = -191031268815044(0xffff52421114cf3c, double:NaN)
            java.lang.String r6 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r18)     // Catch:{ JSONException -> 0x029f }
            r8 = 1
            java.lang.String r6 = com.original.tase.utils.Regex.a(r11, r6, r8)     // Catch:{ JSONException -> 0x029f }
            boolean r8 = r6.isEmpty()     // Catch:{ JSONException -> 0x029f }
            if (r8 == 0) goto L_0x0263
            java.lang.String r6 = com.original.Constants.C     // Catch:{ JSONException -> 0x029f }
            goto L_0x027d
        L_0x0263:
            java.lang.String r6 = com.original.tase.utils.Utils.b(r6)     // Catch:{ JSONException -> 0x029f }
            r11 = -190932484567236(0xffff52591114cf3c, double:NaN)
            java.lang.String r8 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            r11 = -190923894632644(0xffff525b1114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = r6.replace(r8, r11)     // Catch:{ JSONException -> 0x029f }
        L_0x027d:
            if (r13 != 0) goto L_0x0281
            if (r15 == 0) goto L_0x0290
        L_0x0281:
            r11 = -189510850392260(0xffff53a41114cf3c, double:NaN)
            java.lang.String r8 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r11)     // Catch:{ JSONException -> 0x029f }
            r4.put(r8, r6)     // Catch:{ JSONException -> 0x029f }
            r14.setPlayHeader(r4)     // Catch:{ JSONException -> 0x029f }
        L_0x0290:
            r0.onNext(r14)     // Catch:{ JSONException -> 0x029f }
        L_0x0293:
            r4 = 2
            r6 = 0
            r8 = 1
            goto L_0x0186
        L_0x0298:
            int r5 = r5 + 1
            r4 = 2
            r6 = 0
            r8 = 1
            goto L_0x00c0
        L_0x029f:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0)
            throw r2
        L_0x02a6:
            r4 = -189463605752004(0xffff53af1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)
            r4 = 1
            java.lang.String r2 = com.original.tase.utils.Regex.a(r3, r2, r4)
            r3 = -189570979934404(0xffff53961114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)
            r4 = -189592454770884(0xffff53911114cf3c, double:NaN)
            java.lang.String r4 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)
            java.lang.String r2 = r2.replace(r3, r4)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x02f5
            com.original.tase.model.media.MediaSource r3 = new com.original.tase.model.media.MediaSource
            java.lang.String r4 = r20.A()
            r5 = -189583864836292(0xffff53931114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)
            r6 = 0
            r3.<init>(r4, r5, r6)
            r3.setStreamLink(r2)
            r4 = -189244562419908(0xffff53e21114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)
            r3.setQuality((java.lang.String) r2)
            r0.onNext(r3)
        L_0x02f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.Kidomovies.L(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.lang.String):void");
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-186981114654916L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo, Deobfuscator$app$ProductionRelease.a(-192186615017668L));
        if (!M.isEmpty()) {
            L(observableEmitter, movieInfo, M);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String M = M(movieInfo, Deobfuscator$app$ProductionRelease.a(-189197317779652L));
        if (!M.isEmpty()) {
            L(observableEmitter, movieInfo, M);
        }
    }

    public String J() {
        String substring = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        String md5 = Utils.md5(this.f37360h + substring);
        this.f37364l = K();
        try {
            return Deobfuscator$app$ProductionRelease.a(-187303237202116L) + this.f37361i + Deobfuscator$app$ProductionRelease.a(-187251697594564L) + md5.toUpperCase() + Deobfuscator$app$ProductionRelease.a(-187217337856196L) + this.f37363k + Deobfuscator$app$ProductionRelease.a(-187432086220996L) + this.f37364l + Deobfuscator$app$ProductionRelease.a(-187363366744260L) + substring + Deobfuscator$app$ProductionRelease.a(-187024064327876L) + this.f37365m;
        } catch (Exception e2) {
            e2.printStackTrace();
            return Deobfuscator$app$ProductionRelease.a(-186985409622212L);
        }
    }

    public String K() {
        HttpHelper i2 = HttpHelper.i();
        String a2 = Regex.a(i2.l(Deobfuscator$app$ProductionRelease.a(-188286784712900L) + this.f37366n, Deobfuscator$app$ProductionRelease.a(-189016929153220L), new Map[0]), Deobfuscator$app$ProductionRelease.a(-188608907260100L), 1);
        if (a2.isEmpty()) {
            return Deobfuscator$app$ProductionRelease.a(-188716281442500L);
        }
        return a2;
    }

    public String M(MovieInfo movieInfo, String str) {
        boolean z2;
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-189167253008580L), Deobfuscator$app$ProductionRelease.a(-189171547975876L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-189120008368324L), BaseProvider.i(this.f37357e));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-189373411438788L), Deobfuscator$app$ProductionRelease.a(-189326166798532L));
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String lowerCase = movieInfo.name.toLowerCase();
        String a2 = Deobfuscator$app$ProductionRelease.a(-189777138364612L);
        if (!z2) {
            a2 = Deobfuscator$app$ProductionRelease.a(-189905987383492L);
        }
        String format = String.format(a2, new Object[]{lowerCase, J()});
        String format2 = String.format(Deobfuscator$app$ProductionRelease.a(-188548777717956L) + str, new Object[]{this.f37357e});
        String l2 = HttpHelper.i().l(format2, format, hashMap);
        if (!l2.isEmpty()) {
            String a3 = AES256Cipher.a(l2, this.f37359g);
            if (!a3.isEmpty()) {
                try {
                    JSONArray jSONArray = new JSONObject(a3).getJSONObject(Deobfuscator$app$ProductionRelease.a(-188449993470148L)).getJSONArray(Deobfuscator$app$ProductionRelease.a(-188153640726724L));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String string = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-188093511184580L));
                        String string2 = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-188114986021060L));
                        String string3 = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-188059151446212L));
                        if (!string3.isEmpty()) {
                            String replace = string3.replace(Deobfuscator$app$ProductionRelease.a(-188033381642436L), Deobfuscator$app$ProductionRelease.a(-188037676609732L));
                            String h2 = TitleHelper.h(replace.toLowerCase(), Deobfuscator$app$ProductionRelease.a(-188273899811012L));
                            if (!h2.equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, Deobfuscator$app$ProductionRelease.a(-188269604843716L)))) {
                                String h3 = TitleHelper.h(replace.toLowerCase() + string2, Deobfuscator$app$ProductionRelease.a(-188265309876420L));
                                if (h3.equals(TitleHelper.h(movieInfo.name.toLowerCase() + movieInfo.year, Deobfuscator$app$ProductionRelease.a(-188261014909124L)))) {
                                }
                            }
                            return string;
                        }
                    }
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return Deobfuscator$app$ProductionRelease.a(-188291079680196L);
    }
}
