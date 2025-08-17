package com.utils.Getlink.Provider;

import com.movie.data.api.caching.CacheManager;
import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class ZeroTV extends BaseProvider {

    /* renamed from: g  reason: collision with root package name */
    public static OkHttpClient f37508g;

    /* renamed from: e  reason: collision with root package name */
    private String f37509e;

    /* renamed from: f  reason: collision with root package name */
    private int f37510f;

    public ZeroTV() {
        this.f37509e = Deobfuscator$app$ProductionRelease.a(-187174388183236L);
        this.f37510f = 0;
        this.f37509e = Utils.Y() + Utils.getProvider(4);
        if (f37508g == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient.Builder addNetworkInterceptor = builder.addNetworkInterceptor(CacheManager.a());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            addNetworkInterceptor.connectTimeout(30, timeUnit).writeTimeout(30, timeUnit).readTimeout(30, timeUnit);
            f37508g = builder.build();
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-186908100210884L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(this.f37509e, Long.valueOf(movieInfo.tmdbID), -1, -1, Utils.b(), observableEmitter);
    }

    public void C(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        J(Utils.Y() + Deobfuscator$app$ProductionRelease.a(-187170093215940L), Long.valueOf(movieInfo.tmdbID), movieInfo.getSession(), movieInfo.getEps(), Utils.b(), observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(this.f37509e, Long.valueOf(movieInfo.tmdbID), movieInfo.getSession(), movieInfo.getEps(), Utils.b(), observableEmitter);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03a3 A[Catch:{ Exception -> 0x03a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(java.lang.String r24, java.lang.Long r25, java.lang.Integer r26, java.lang.Integer r27, java.lang.String r28, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r29) {
        /*
            r23 = this;
            r10 = r23
            r0 = r29
            com.movie.data.api.GlobalVariable r1 = com.movie.data.api.GlobalVariable.c()
            com.movie.data.model.AppConfig r1 = r1.b()
            com.movie.data.model.AppConfig$AdsBean r1 = r1.getAds()
            if (r1 != 0) goto L_0x0025
            com.movie.data.api.GlobalVariable r1 = com.movie.data.api.GlobalVariable.c()
            com.movie.data.model.AppConfig r1 = r1.b()
            com.movie.data.model.AppConfig$SyncBean r1 = r1.getSync()
            boolean r1 = r1.isFor_member_only()
            if (r1 == 0) goto L_0x0025
            return
        L_0x0025:
            com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo r1 = com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper.d()
            boolean r1 = r1.isValid()
            r11 = 1
            if (r1 != 0) goto L_0x0047
            com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo r1 = com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper.b()
            boolean r1 = r1.isValid()
            if (r1 != 0) goto L_0x0047
            com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo r1 = com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper.b()
            boolean r1 = r1.isValid()
            if (r1 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r13 = 0
            goto L_0x0048
        L_0x0047:
            r13 = 1
        L_0x0048:
            com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo r1 = com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper.d()
            boolean r1 = r1.isValid()
            com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo r2 = com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper.b()
            boolean r2 = r2.isValid()
            if (r2 == 0) goto L_0x005c
            r2 = 2
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo r3 = com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper.b()
            boolean r3 = r3.isValid()
            if (r3 == 0) goto L_0x0069
            r3 = 4
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            r1 = r1 | r2
            r1 = r1 | r3
            r10.f37510f = r1
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            r2 = -187122848575684(0xffff55d01114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = java.lang.String.valueOf(r25)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187114258641092(0xffff55d21114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = java.lang.String.valueOf(r26)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187071308968132(0xffff55dc1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = java.lang.String.valueOf(r27)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187062719033540(0xffff55de1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = com.utils.Utils.b()
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187088488837316(0xffff55d81114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            int r3 = com.utils.Utils.b0()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187079898902724(0xffff55da1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = com.utils.Utils.u()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187861582950596(0xffff55241114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            java.lang.String r3 = com.utils.Utils.t()
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187818633277636(0xffff552e1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            int r3 = r10.f37510f
            java.lang.String r3 = java.lang.String.valueOf(r3)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = -187844403081412(0xffff55281114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            r3 = -187754208768196(0xffff553d1114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)
            okhttp3.Request$Builder r1 = r1.header(r2, r3)
            r2 = r24
            okhttp3.Request$Builder r1 = r1.url((java.lang.String) r2)
            okhttp3.Request r1 = r1.build()
            okhttp3.OkHttpClient r2 = f37508g     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            okhttp3.Call r1 = r2.newCall(r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            okhttp3.Response r15 = r1.execute()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            if (r15 == 0) goto L_0x03f5
            int r1 = r15.code()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x03f5
            okhttp3.ResponseBody r1 = r15.body()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            java.lang.String r1 = r1.string()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r9.<init>(r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r8.<init>()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            android.content.SharedPreferences r1 = com.movie.FreeMoviesApp.p()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r2 = -187956072231108(0xffff550e1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            boolean r16 = r1.getBoolean(r2, r11)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            java.util.Set r7 = com.utils.Utils.E()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r6 = 0
        L_0x0161:
            int r1 = r9.length()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            if (r6 >= r1) goto L_0x03b3
            java.lang.String r1 = r9.getString(r6)     // Catch:{ Exception -> 0x0254 }
            r2 = -187904532623556(0xffff551a1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)     // Catch:{ Exception -> 0x0254 }
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x0190
            r2 = -187578115109060(0xffff55661114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)     // Catch:{ Exception -> 0x0254 }
            r3 = -187595294978244(0xffff55621114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ Exception -> 0x0254 }
        L_0x0190:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0254 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0254 }
            r3 = -187552345305284(0xffff556c1114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ Exception -> 0x0254 }
            r2.getLong(r1)     // Catch:{ Exception -> 0x0254 }
            r3 = -187543755370692(0xffff556e1114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r3 = r2.getString(r1)     // Catch:{ Exception -> 0x0254 }
            r4 = -187569525174468(0xffff55681114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ Exception -> 0x0254 }
            r2.getLong(r1)     // Catch:{ Exception -> 0x0254 }
            r4 = -187560935239876(0xffff556a1114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ Exception -> 0x0254 }
            long r4 = r2.getLong(r1)     // Catch:{ Exception -> 0x0254 }
            r17 = -187517985566916(0xffff55741114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Exception -> 0x0254 }
            r17 = -187509395632324(0xffff55761114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            r2.getString(r12)     // Catch:{ Exception -> 0x0254 }
            r17 = -187535165436100(0xffff55701114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            r17 = -187530870468804(0xffff55711114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            com.original.tase.Logger.b(r14, r3)     // Catch:{ Exception -> 0x0254 }
            r17 = -187500805697732(0xffff55781114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            boolean r14 = r2.has(r14)     // Catch:{ Exception -> 0x0254 }
            if (r14 == 0) goto L_0x023d
            r17 = -187492215763140(0xffff557a1114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r2 = r2.getString(r14)     // Catch:{ Exception -> 0x0254 }
            r17 = -187724143997124(0xffff55441114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            boolean r14 = r2.contains(r14)     // Catch:{ Exception -> 0x0254 }
            if (r14 != 0) goto L_0x023d
            r17 = -187728438964420(0xffff55431114cf3c, double:NaN)
            java.lang.String r12 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            r17 = -187685489291460(0xffff554d1114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r12 = r2.replace(r12, r14)     // Catch:{ Exception -> 0x0254 }
            boolean r2 = com.utils.Utils.k(r12, r7)     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x023d
            goto L_0x0254
        L_0x023d:
            if (r16 != 0) goto L_0x025e
            r17 = -187676899356868(0xffff554f1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            boolean r2 = r12.contains(r2)     // Catch:{ Exception -> 0x0254 }
            if (r2 != 0) goto L_0x0254
            boolean r2 = r12.isEmpty()     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x025e
        L_0x0254:
            r14 = r6
            r21 = r7
            r1 = r8
            r22 = r9
            r20 = 2
            goto L_0x03a9
        L_0x025e:
            boolean r2 = r12.isEmpty()     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x0268
            java.lang.String r12 = r23.A()     // Catch:{ Exception -> 0x0254 }
        L_0x0268:
            r17 = -187646834585796(0xffff55561114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            boolean r2 = r3.contains(r2)     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x0282
            java.lang.String r2 = r25.toString()     // Catch:{ Exception -> 0x0254 }
            boolean r2 = r3.contains(r2)     // Catch:{ Exception -> 0x0254 }
            if (r2 != 0) goto L_0x0282
            goto L_0x0254
        L_0x0282:
            r17 = -186212315508932(0xffff56a41114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            boolean r2 = r3.contains(r2)     // Catch:{ Exception -> 0x0254 }
            if (r2 == 0) goto L_0x02b4
            r4 = -186177955770564(0xffff56ac1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r2 = com.original.tase.utils.Regex.a(r3, r2, r11)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x0254 }
            com.movie.data.model.realdebrid.MagnetObject r3 = new com.movie.data.model.realdebrid.MagnetObject     // Catch:{ Exception -> 0x0254 }
            r4 = -186358344396996(0xffff56821114cf3c, double:NaN)
            java.lang.String r4 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ Exception -> 0x0254 }
            r3.<init>(r4, r2, r1, r12)     // Catch:{ Exception -> 0x0254 }
            r8.add(r3)     // Catch:{ Exception -> 0x0254 }
            goto L_0x0254
        L_0x02b4:
            r17 = -186298214854852(0xffff56901114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            r17 = -186289624920260(0xffff56921114cf3c, double:NaN)
            java.lang.String r14 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r17)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r2 = r3.replace(r2, r14)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r2 = com.utils.Utils.H(r2)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r14 = r23.A()     // Catch:{ Exception -> 0x0254 }
            boolean r17 = r12.isEmpty()     // Catch:{ Exception -> 0x0254 }
            if (r17 != 0) goto L_0x02d9
            r14 = r12
        L_0x02d9:
            boolean r17 = com.original.tase.helper.GoogleVideoHelper.n(r3)     // Catch:{ Exception -> 0x0254 }
            r20 = -186285329952964(0xffff56931114cf3c, double:NaN)
            r24 = r1
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r20)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r1 = com.original.tase.utils.Regex.a(r3, r1, r11)     // Catch:{ Exception -> 0x0254 }
            r20 = -185847243288772(0xffff56f91114cf3c, double:NaN)
            java.lang.String r11 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r20)     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r3.contains(r11)     // Catch:{ Exception -> 0x0254 }
            if (r17 != 0) goto L_0x034f
            if (r11 != 0) goto L_0x034f
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0346 }
            if (r1 != 0) goto L_0x0304
            goto L_0x034f
        L_0x0304:
            java.lang.String r11 = com.utils.Getlink.Provider.BaseProvider.i(r3)     // Catch:{ Exception -> 0x0346 }
            com.utils.HashRefHelpper r1 = com.utils.HashRefHelpper.f37561a     // Catch:{ Exception -> 0x0346 }
            java.lang.String r12 = r1.a(r11)     // Catch:{ Exception -> 0x0346 }
            r1 = -185963207405764(0xffff56de1114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r1)     // Catch:{ Exception -> 0x0346 }
            com.original.tase.Logger.b(r1, r3)     // Catch:{ Exception -> 0x0346 }
            r17 = 0
            r5 = 2
            boolean[] r4 = new boolean[r5]     // Catch:{ Exception -> 0x0346 }
            r1 = 0
            r4[r1] = r1     // Catch:{ Exception -> 0x0346 }
            r2 = 1
            r4[r2] = r1     // Catch:{ Exception -> 0x0346 }
            r2 = r24
            r1 = r23
            r24 = r2
            r2 = r29
            r19 = r4
            r4 = r24
            r20 = 2
            r5 = r14
            r14 = r6
            r6 = r11
            r21 = r7
            r7 = r17
            r11 = r8
            r8 = r12
            r22 = r9
            r9 = r19
            r1.h(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0343 }
        L_0x0343:
            r1 = r11
            goto L_0x03a9
        L_0x0346:
            r14 = r6
            r21 = r7
            r22 = r9
            r20 = 2
            r1 = r8
            goto L_0x03a9
        L_0x034f:
            r14 = r6
            r21 = r7
            r1 = r8
            r22 = r9
            r20 = 2
            com.original.tase.model.media.MediaSource r6 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x03a9 }
            java.lang.String r7 = r23.A()     // Catch:{ Exception -> 0x03a9 }
            if (r17 == 0) goto L_0x0369
            r8 = -186061991653572(0xffff56c71114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r8)     // Catch:{ Exception -> 0x03a9 }
            goto L_0x036d
        L_0x0369:
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ Exception -> 0x03a9 }
        L_0x036d:
            r8 = 0
            r6.<init>(r7, r2, r8)     // Catch:{ Exception -> 0x03a9 }
            r6.setStreamLink(r3)     // Catch:{ Exception -> 0x03a9 }
            r2 = r24
            r6.setQuality((java.lang.String) r2)     // Catch:{ Exception -> 0x03a9 }
            r6.setFileSize(r4)     // Catch:{ Exception -> 0x03a9 }
            if (r17 != 0) goto L_0x0383
            if (r11 == 0) goto L_0x0381
            goto L_0x0383
        L_0x0381:
            r2 = 1
            goto L_0x039a
        L_0x0383:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x03a9 }
            r2.<init>()     // Catch:{ Exception -> 0x03a9 }
            r3 = -186044811784388(0xffff56cb1114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ Exception -> 0x03a9 }
            java.lang.String r4 = com.original.Constants.C     // Catch:{ Exception -> 0x03a9 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x03a9 }
            r6.setPlayHeader(r2)     // Catch:{ Exception -> 0x03a9 }
            goto L_0x0381
        L_0x039a:
            r6.setCachedLink(r2)     // Catch:{ Exception -> 0x03a9 }
            boolean r2 = r12.isEmpty()     // Catch:{ Exception -> 0x03a9 }
            if (r2 != 0) goto L_0x03a6
            r6.setProviderName(r12)     // Catch:{ Exception -> 0x03a9 }
        L_0x03a6:
            r0.onNext(r6)     // Catch:{ Exception -> 0x03a9 }
        L_0x03a9:
            int r6 = r14 + 1
            r8 = r1
            r7 = r21
            r9 = r22
            r11 = 1
            goto L_0x0161
        L_0x03b3:
            r1 = r8
            int r2 = r1.size()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            if (r2 <= 0) goto L_0x03f5
            if (r13 == 0) goto L_0x03f5
            com.original.tase.model.media.MediaSource r2 = new com.original.tase.model.media.MediaSource     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            java.lang.String r3 = r23.A()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r4 = -186749186420932(0xffff56271114cf3c, double:NaN)
            java.lang.String r4 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r5 = 0
            r2.<init>(r3, r4, r5)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r3 = 1
            r2.setTorrent(r3)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r2.setMagnetObjects(r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r3 = -186689056878788(0xffff56351114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r2.setQuality((java.lang.String) r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r3 = -186710531715268(0xffff56301114cf3c, double:NaN)
            java.lang.String r1 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r3)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r2.setStreamLink(r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r1 = 0
            r2.setNeedToSync(r1)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r0.onNext(r2)     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
        L_0x03f5:
            if (r15 == 0) goto L_0x0411
            okhttp3.ResponseBody r0 = r15.body()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            if (r0 == 0) goto L_0x0404
            okhttp3.ResponseBody r0 = r15.body()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            r0.close()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
        L_0x0404:
            r15.close()     // Catch:{ IOException -> 0x040d, JSONException -> 0x0408 }
            goto L_0x0411
        L_0x0408:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0411
        L_0x040d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0411:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.ZeroTV.J(java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.String, io.reactivex.ObservableEmitter):void");
    }

    public int m() {
        return this.f37249a;
    }
}
