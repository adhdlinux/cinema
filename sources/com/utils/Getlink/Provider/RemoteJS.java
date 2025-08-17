package com.utils.Getlink.Provider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import com.movie.FreeMoviesApp;
import com.movie.data.model.MovieInfo;
import com.movie.data.remotejs.MyTaskService;
import com.movie.data.remotejs.RemoteJSModule;
import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class RemoteJS extends BaseProvider implements RemoteJSModule.ReactListener {

    /* renamed from: e  reason: collision with root package name */
    private ObservableEmitter<? super MediaSource> f37418e;

    /* renamed from: f  reason: collision with root package name */
    private CompositeDisposable f37419f;

    /* renamed from: g  reason: collision with root package name */
    private int f37420g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f37421h = -1;

    /* access modifiers changed from: private */
    public static /* synthetic */ void N(String str, MovieInfo movieInfo, String str2) throws Exception {
        long j2;
        Intent intent = new Intent(Utils.v().getApplicationContext(), MyTaskService.class);
        Bundle bundle = new Bundle();
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-241595918790852L), str);
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-241608803692740L), movieInfo.getName());
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-241583033888964L), movieInfo.getYear().toString());
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-241527199314116L), movieInfo.getSession().toString());
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-241497134543044L), movieInfo.getEps().toString());
        String a2 = Deobfuscator$app$ProductionRelease.a(-240088385269956L);
        if (movieInfo.getSession().intValue() > 0) {
            j2 = -240101270171844L;
        } else {
            j2 = -240054025531588L;
        }
        bundle.putString(a2, Deobfuscator$app$ProductionRelease.a(j2));
        bundle.putLong(Deobfuscator$app$ProductionRelease.a(-240062615466180L), movieInfo.tmdbID);
        bundle.putString(Deobfuscator$app$ProductionRelease.a(-240028255727812L), movieInfo.imdbIDStr);
        intent.putExtras(bundle);
        Utils.v().getApplicationContext().startService(intent);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void P() throws Exception {
    }

    private void Q(final String str, MovieInfo movieInfo) {
        Utils.E();
        FreeMoviesApp.m(Utils.v()).getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
        FreeMoviesApp.m(Utils.v()).g().c(this);
        this.f37420g = 0;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f37419f = compositeDisposable;
        compositeDisposable.b(Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext(str);
                observableEmitter.onComplete();
            }
        }).observeOn(AndroidSchedulers.a()).subscribe(new b(str, movieInfo), new c(), new d()));
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-241359695589572L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        this.f37418e = observableEmitter;
        Q(new String(Base64.decode(Utils.getProvider(117), 0), StandardCharsets.UTF_8), movieInfo);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) throws UnsupportedEncodingException {
        B(movieInfo, observableEmitter);
    }

    public Observable<MediaSource> F(final MovieInfo movieInfo) {
        this.f37421h = movieInfo.tmdbID;
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                if (!FreeMoviesApp.s()) {
                    try {
                        MovieInfo clone = movieInfo.clone();
                        if (clone.session.isEmpty()) {
                            RemoteJS.this.B(clone, observableEmitter);
                        } else {
                            RemoteJS.this.D(clone, observableEmitter);
                        }
                    } catch (Exception e2) {
                        Logger.b(Deobfuscator$app$ProductionRelease.a(-184726256824516L), e2.getMessage());
                    }
                } else {
                    observableEmitter.onComplete();
                }
            }
        });
    }

    public void M(String str) {
        FreeMoviesApp.p().edit().apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01fc A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fd A[Catch:{ Exception -> 0x0207 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r11 = 0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            timber.log.Timber.f(r10, r0)
            io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r0 = r9.f37418e
            boolean r0 = r0.isDisposed()
            if (r0 != 0) goto L_0x0212
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.Class<com.movie.data.model.providers.RemoteJSModel> r1 = com.movie.data.model.providers.RemoteJSModel.class
            java.lang.Object r10 = r0.l(r10, r1)
            com.movie.data.model.providers.RemoteJSModel r10 = (com.movie.data.model.providers.RemoteJSModel) r10
            java.lang.String r0 = r10.getHost()     // Catch:{ Exception -> 0x0207 }
            r1 = 1
            if (r0 == 0) goto L_0x0030
            int r2 = r0.length()     // Catch:{ Exception -> 0x0207 }
            if (r2 <= 0) goto L_0x0030
            java.lang.String r0 = r0.substring(r1)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r0 = org.apache.commons.lang3.StringUtils.a(r0)     // Catch:{ Exception -> 0x0207 }
        L_0x0030:
            java.util.List r2 = r10.getDirectQuality()     // Catch:{ Exception -> 0x0207 }
            if (r2 == 0) goto L_0x0113
            java.util.List r2 = r10.getDirectQuality()     // Catch:{ Exception -> 0x0207 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0207 }
            if (r2 <= 0) goto L_0x0113
            java.util.List r2 = r10.getDirectQuality()     // Catch:{ Exception -> 0x0207 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0207 }
        L_0x0048:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0207 }
            if (r3 == 0) goto L_0x022c
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0207 }
            com.movie.data.model.providers.DirectQualityItem r3 = (com.movie.data.model.providers.DirectQualityItem) r3     // Catch:{ Exception -> 0x0207 }
            java.lang.String r4 = r3.getFile()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r5 = com.original.tase.utils.Utils.b(r4)     // Catch:{ Exception -> 0x0207 }
            r6 = -241265206309060(0xffff24921114cf3c, double:NaN)
            java.lang.String r6 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r6)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r6, r1)     // Catch:{ Exception -> 0x0207 }
            com.original.tase.model.media.MediaSource r6 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0207 }
            r7 = -240917313958084(0xffff24e31114cf3c, double:NaN)
            java.lang.String r7 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r7)     // Catch:{ Exception -> 0x0207 }
            r6.<init>(r0, r7, r11)     // Catch:{ Exception -> 0x0207 }
            boolean r7 = r5.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r7 != 0) goto L_0x00ab
            java.lang.String r4 = com.original.tase.utils.Utils.e(r5)     // Catch:{ Exception -> 0x0207 }
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r7 != 0) goto L_0x00aa
            r7 = -240852889448644(0xffff24f21114cf3c, double:NaN)
            java.lang.String r7 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r7)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r5 = r5.replace(r4, r7)     // Catch:{ Exception -> 0x0207 }
            int r7 = r5.length()     // Catch:{ Exception -> 0x0207 }
            int r7 = r7 - r1
            java.lang.String r5 = r5.substring(r11, r7)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r4 = com.original.tase.utils.Utils.f(r4)     // Catch:{ Exception -> 0x0207 }
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r7 != 0) goto L_0x00aa
            r6.setPlayHeader(r4)     // Catch:{ Exception -> 0x0207 }
        L_0x00aa:
            r4 = r5
        L_0x00ab:
            r7 = -240848594481348(0xffff24f31114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r7)     // Catch:{ Exception -> 0x0207 }
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0207 }
            if (r5 == 0) goto L_0x00c7
            long r7 = r9.f37421h     // Catch:{ Exception -> 0x0207 }
            java.lang.String r5 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0207 }
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0207 }
            if (r5 != 0) goto L_0x00c7
            goto L_0x0048
        L_0x00c7:
            r7 = -241063342846148(0xffff24c11114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r7)     // Catch:{ Exception -> 0x0207 }
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0207 }
            r6.setHLS(r5)     // Catch:{ Exception -> 0x0207 }
            r6.setStreamLink(r4)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0207 }
            java.util.Map r5 = r10.getHeaders()     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0207 }
            r6.setPlayHeader(r4)     // Catch:{ Exception -> 0x0207 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0207 }
            r4.<init>()     // Catch:{ Exception -> 0x0207 }
            int r3 = r3.getQuality()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0207 }
            r4.append(r3)     // Catch:{ Exception -> 0x0207 }
            r7 = -241003213304004(0xffff24cf1114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r7)     // Catch:{ Exception -> 0x0207 }
            r4.append(r3)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0207 }
            r6.setQuality((java.lang.String) r3)     // Catch:{ Exception -> 0x0207 }
            r6.setResolved(r1)     // Catch:{ Exception -> 0x0207 }
            io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r3 = r9.f37418e     // Catch:{ Exception -> 0x0207 }
            r3.onNext(r6)     // Catch:{ Exception -> 0x0207 }
            goto L_0x0048
        L_0x0113:
            java.lang.String r2 = r10.getFile()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = com.original.tase.utils.Utils.b(r2)     // Catch:{ Exception -> 0x0207 }
            r4 = -241028983107780(0xffff24c91114cf3c, double:NaN)
            java.lang.String r4 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r4)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = com.original.tase.utils.Regex.a(r3, r4, r1)     // Catch:{ Exception -> 0x0207 }
            com.original.tase.model.media.MediaSource r4 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x0207 }
            r5 = -240955968663748(0xffff24da1114cf3c, double:NaN)
            java.lang.String r5 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r0, r5, r11)     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r0 != 0) goto L_0x016b
            java.lang.String r0 = com.original.tase.utils.Utils.e(r3)     // Catch:{ Exception -> 0x0207 }
            boolean r2 = r0.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r2 != 0) goto L_0x016a
            r5 = -241716177875140(0xffff24291114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r2 = r3.replace(r0, r2)     // Catch:{ Exception -> 0x0207 }
            int r3 = r2.length()     // Catch:{ Exception -> 0x0207 }
            int r3 = r3 - r1
            java.lang.String r2 = r2.substring(r11, r3)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r0 = com.original.tase.utils.Utils.f(r0)     // Catch:{ Exception -> 0x0207 }
            boolean r3 = r0.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r3 != 0) goto L_0x016b
            r4.setPlayHeader(r0)     // Catch:{ Exception -> 0x0207 }
            goto L_0x016b
        L_0x016a:
            r2 = r3
        L_0x016b:
            r5 = -241711882907844(0xffff242a1114cf3c, double:NaN)
            java.lang.String r0 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x0207 }
            if (r0 == 0) goto L_0x0187
            long r5 = r9.f37421h     // Catch:{ Exception -> 0x0207 }
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x0207 }
            if (r0 != 0) goto L_0x0187
            return
        L_0x0187:
            r5 = -241651753365700(0xffff24381114cf3c, double:NaN)
            java.lang.String r0 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x0207 }
            r5 = -241866501730500(0xffff24061114cf3c, double:NaN)
            java.lang.String r3 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = com.original.tase.utils.Regex.a(r2, r3, r1)     // Catch:{ Exception -> 0x0207 }
            r4.setHLS(r0)     // Catch:{ Exception -> 0x0207 }
            r4.setStreamLink(r2)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0207 }
            java.util.Map r2 = r10.getHeaders()     // Catch:{ Exception -> 0x0207 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0207 }
            r4.setPlayHeader(r0)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r0 = r10.getQuality()     // Catch:{ Exception -> 0x0207 }
            if (r0 == 0) goto L_0x01ea
            java.lang.String r0 = r10.getQuality()     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r0 == 0) goto L_0x01c4
            goto L_0x01ea
        L_0x01c4:
            java.lang.String r0 = r10.getQuality()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0207 }
            r5 = -241415530164420(0xffff246f1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0207 }
            if (r0 == 0) goto L_0x01e5
            r5 = -241432710033604(0xffff246b1114cf3c, double:NaN)
            java.lang.String r10 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
            goto L_0x01f3
        L_0x01e5:
            java.lang.String r10 = r10.getQuality()     // Catch:{ Exception -> 0x0207 }
            goto L_0x01f3
        L_0x01ea:
            r5 = -241428415066308(0xffff246c1114cf3c, double:NaN)
            java.lang.String r10 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)     // Catch:{ Exception -> 0x0207 }
        L_0x01f3:
            r4.setQuality((java.lang.String) r10)     // Catch:{ Exception -> 0x0207 }
            boolean r10 = r3.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r10 != 0) goto L_0x01fd
            goto L_0x01fe
        L_0x01fd:
            r1 = 0
        L_0x01fe:
            r4.setResolved(r1)     // Catch:{ Exception -> 0x0207 }
            io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r10 = r9.f37418e     // Catch:{ Exception -> 0x0207 }
            r10.onNext(r4)     // Catch:{ Exception -> 0x0207 }
            goto L_0x022c
        L_0x0207:
            r10 = move-exception
            java.lang.String r0 = r10.getMessage()
            java.lang.Object[] r11 = new java.lang.Object[r11]
            timber.log.Timber.e(r10, r0, r11)
            goto L_0x022c
        L_0x0212:
            android.content.Intent r10 = new android.content.Intent
            android.content.Context r11 = com.utils.Utils.v()
            android.content.Context r11 = r11.getApplicationContext()
            java.lang.Class<com.movie.data.remotejs.MyTaskService> r0 = com.movie.data.remotejs.MyTaskService.class
            r10.<init>(r11, r0)
            android.content.Context r11 = com.utils.Utils.v()
            android.content.Context r11 = r11.getApplicationContext()
            r11.stopService(r10)
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.RemoteJS.a(java.lang.String, java.lang.String):void");
    }

    public void b(String str) {
        this.f37418e.onComplete();
        this.f37418e.isDisposed();
        this.f37419f.dispose();
        if (this.f37418e.isDisposed()) {
            M(Deobfuscator$app$ProductionRelease.a(-241411235197124L));
        }
    }

    public void onError(String str) {
    }
}
