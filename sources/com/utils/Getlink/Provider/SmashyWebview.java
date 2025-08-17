package com.utils.Getlink.Provider;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.google.gson.internal.LinkedTreeMap;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.AppDispatchers;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.webview.WebViewDriver;
import com.original.tase.helper.webview.WebViewHelperKt;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class SmashyWebview extends ProviderWebView {

    /* renamed from: f  reason: collision with root package name */
    private String f37436f = "\n try{var b=fetch;fetch=(t,r)=>{var o=(o=t.match(/[\\&|\\?]token\\=(.+)/i))?o[1]:\"\";return console.log(JSON.stringify({tokenRR:o})),b(t,r)}}catch(t){console.log(JSON.stringify({error:string(t)}))} \n";

    /* renamed from: g  reason: collision with root package name */
    private String f37437g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f37438h = "";

    public SmashyWebview() {
        Context v2 = Utils.v();
        if (v2 != null) {
            M(new WebViewDriver(v2));
            WebViewDriver L = L();
            if (L != null) {
                WebViewHelperKt.b(L, new SmashyWebview$1$1(this), new SmashyWebview$1$2(this));
            }
        }
    }

    private final String O(String str) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (this.f37438h.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(Constants.E + "resolver/smm.js", new Map[0]);
            Intrinsics.e(m2, "m13048(...)");
            this.f37438h = m2;
        }
        String C = StringsKt__StringsJVMKt.C(this.f37438h, "####", str, false, 4, (Object) null);
        Duktape create = Duktape.create();
        Intrinsics.e(create, "create(...)");
        try {
            Object evaluate = create.evaluate(C);
            if (evaluate != null) {
                if (evaluate.toString().length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    String obj = evaluate.toString();
                    Logger.b(A(), obj);
                    String a2 = Regex.a(com.original.tase.utils.Utils.b(obj), "[/|\\?|=](http.+)", 1);
                    Intrinsics.c(a2);
                    if (a2.length() != 0) {
                        z4 = false;
                    }
                    if (!z4) {
                        obj = a2;
                    }
                    create.close();
                    return obj;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
        create.close();
        return "";
    }

    private final void P(String str, String str2, ObservableEmitter<? super MediaSource> observableEmitter, String str3) {
        boolean z2;
        boolean z3;
        boolean z4;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        ArrayList<ArrayList<String>> e2 = Regex.e(str, "\\[(?:(\\w{3,4}|4K|4k|2K)(?:p|P|))\\](http[0-9a-zA-Z;~&.:/\\_-]+)", 2, 32);
        Object obj = null;
        int i2 = 1;
        if (e2.size() != 2 || e2.get(0).isEmpty()) {
            String str4 = str2;
            String C = StringsKt__StringsJVMKt.C(str, "\\", "", false, 4, (Object) null);
            String e3 = com.original.tase.utils.Utils.e(C);
            MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
            HashMap<String, String> hashMap = new HashMap<>();
            Intrinsics.c(e3);
            if (e3.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                String C2 = StringsKt__StringsJVMKt.C(C, e3, "", false, 4, (Object) null);
                String substring = C2.substring(0, C2.length() - 1);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String a2 = Regex.a(com.original.tase.utils.Utils.b(substring), "[/|\\?|=]((?:http|aHR).+)", 1);
                Intrinsics.c(a2);
                if (a2.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    Intrinsics.c(a2);
                    if (!StringsKt__StringsJVMKt.G(a2, UriUtil.HTTP_SCHEME, false, 2, (Object) null)) {
                        a2 = BaseProvider.d(a2);
                    }
                    Intrinsics.c(a2);
                    C = a2;
                } else {
                    C = substring;
                }
                hashMap = com.original.tase.utils.Utils.f(e3);
                Intrinsics.e(hashMap, "jsonToHashMap(...)");
                if (!hashMap.isEmpty()) {
                    mediaSource.setPlayHeader(hashMap);
                }
            }
            String str5 = C;
            if (hashMap.isEmpty()) {
                String j2 = BaseProvider.j(str2);
                Intrinsics.e(j2, "getBaseurl(...)");
                hashMap.put("Origin", j2);
            }
            mediaSource.setStreamLink(str5);
            mediaSource.setQuality("Auto");
            mediaSource.setPlayHeader(hashMap);
            observableEmitter2.onNext(mediaSource);
            return;
        }
        ArrayList arrayList = e2.get(0);
        ArrayList arrayList2 = e2.get(1);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size && i3 < arrayList2.size()) {
            String str6 = (String) arrayList.get(i3);
            Object obj2 = arrayList2.get(i3);
            Intrinsics.e(obj2, "get(...)");
            String C3 = StringsKt__StringsJVMKt.C((String) obj2, "\\", "", false, 4, (Object) null);
            String a3 = Regex.a(com.original.tase.utils.Utils.b(C3), "[/|\\?|=]((?:http|aHR).+)", i2);
            Intrinsics.c(a3);
            if (a3.length() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                Intrinsics.c(a3);
                if (!StringsKt__StringsJVMKt.G(a3, UriUtil.HTTP_SCHEME, false, 2, obj)) {
                    C3 = BaseProvider.d(a3);
                } else {
                    C3 = a3;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Referer", str2);
            String j3 = BaseProvider.j(str2);
            Intrinsics.e(j3, "getBaseurl(...)");
            hashMap2.put("Origin", j3);
            MediaSource mediaSource2 = new MediaSource(A(), "CDN-FastServer", false);
            mediaSource2.setStreamLink(C3);
            mediaSource2.setQuality(str6);
            mediaSource2.setPlayHeader(hashMap2);
            observableEmitter2.onNext(mediaSource2);
            i3++;
            arrayList2 = arrayList2;
            i2 = 1;
            obj = null;
        }
    }

    private final void Q(ArrayList<?> arrayList, String str, ObservableEmitter<? super MediaSource> observableEmitter, String str2) {
        boolean z2;
        boolean z3;
        String str3 = str;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        Iterator<?> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            boolean z4 = true;
            if (next instanceof String) {
                String obj = next.toString();
                if (!StringsKt__StringsKt.L(obj, UriUtil.HTTP_SCHEME, false, 2, (Object) null)) {
                    obj = O(obj);
                }
                if (StringsKt__StringsJVMKt.s(obj, ",", false, 2, (Object) null)) {
                    obj = obj.substring(0, obj.length() - 1);
                    Intrinsics.e(obj, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                if (obj.length() != 0) {
                    z4 = false;
                }
                String str4 = str2;
                if (!z4) {
                    P(obj, str3, observableEmitter2, str4);
                }
            } else {
                String str5 = str2;
                Intrinsics.d(next, "null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) next;
                String valueOf = String.valueOf(linkedTreeMap.get("file"));
                MediaSource mediaSource = new MediaSource(A(), String.valueOf(linkedTreeMap.get("title")), false);
                HashMap<String, String> hashMap = new HashMap<>();
                if (valueOf.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!StringsKt__StringsKt.L(valueOf, UriUtil.HTTP_SCHEME, false, 2, (Object) null)) {
                        String O = O(valueOf);
                        String e2 = com.original.tase.utils.Utils.e(O);
                        Intrinsics.c(e2);
                        if (e2.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            String C = StringsKt__StringsJVMKt.C(O, e2, "", false, 4, (Object) null);
                            valueOf = C.substring(0, C.length() - 1);
                            Intrinsics.e(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
                            hashMap = com.original.tase.utils.Utils.f(e2);
                            Intrinsics.e(hashMap, "jsonToHashMap(...)");
                            if (!hashMap.isEmpty()) {
                                mediaSource.setPlayHeader(hashMap);
                            }
                        } else {
                            valueOf = O;
                        }
                    }
                    if (StringsKt__StringsJVMKt.s(valueOf, ",", false, 2, (Object) null)) {
                        valueOf = valueOf.substring(0, valueOf.length() - 1);
                        Intrinsics.e(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    String str6 = valueOf;
                    if (hashMap.isEmpty()) {
                        hashMap.put("Referer", str3);
                        String j2 = BaseProvider.j(str);
                        Intrinsics.e(j2, "getBaseurl(...)");
                        hashMap.put("Origin", j2);
                    }
                    mediaSource.setStreamLink(StringsKt__StringsJVMKt.C(str6, "\\", "", false, 4, (Object) null));
                    mediaSource.setQuality("Auto");
                    mediaSource.setPlayHeader(hashMap);
                    observableEmitter2.onNext(mediaSource);
                }
            }
        }
    }

    private final void S() {
        HttpHelper i2 = HttpHelper.i();
        boolean z2 = false;
        String m2 = i2.m(Constants.E + "provider/smhinject", new Map[0]);
        Intrinsics.c(m2);
        if (m2.length() == 0) {
            z2 = true;
        }
        if (!z2) {
            Intrinsics.c(m2);
            this.f37436f = m2;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object W(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.utils.Getlink.Provider.SmashyWebview$waitForKeyToBeAttached$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.utils.Getlink.Provider.SmashyWebview$waitForKeyToBeAttached$1 r0 = (com.utils.Getlink.Provider.SmashyWebview$waitForKeyToBeAttached$1) r0
            int r1 = r0.f37450n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37450n = r1
            goto L_0x0018
        L_0x0013:
            com.utils.Getlink.Provider.SmashyWebview$waitForKeyToBeAttached$1 r0 = new com.utils.Getlink.Provider.SmashyWebview$waitForKeyToBeAttached$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f37448l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f37450n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            int r2 = r0.f37447k
            int r5 = r0.f37446j
            java.lang.Object r6 = r0.f37445i
            com.utils.Getlink.Provider.SmashyWebview r6 = (com.utils.Getlink.Provider.SmashyWebview) r6
            kotlin.ResultKt.b(r10)
            goto L_0x0063
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003a:
            kotlin.ResultKt.b(r10)
            r10 = 40
            r2 = 40
            r5 = 0
            r6 = r9
        L_0x0043:
            java.lang.String r10 = r6.f37437g
            int r10 = r10.length()
            if (r10 != 0) goto L_0x004d
            r10 = 1
            goto L_0x004e
        L_0x004d:
            r10 = 0
        L_0x004e:
            if (r10 == 0) goto L_0x0065
            if (r5 >= r2) goto L_0x0065
            r0.f37445i = r6
            r0.f37446j = r5
            r0.f37447k = r2
            r0.f37450n = r4
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.a(r7, r0)
            if (r10 != r1) goto L_0x0063
            return r1
        L_0x0063:
            int r5 = r5 + r4
            goto L_0x0043
        L_0x0065:
            java.lang.String r10 = r6.f37437g
            int r10 = r10.length()
            if (r10 != 0) goto L_0x006e
            r3 = 1
        L_0x006e:
            if (r3 != 0) goto L_0x0073
            kotlin.Unit r10 = kotlin.Unit.f40298a
            return r10
        L_0x0073:
            java.lang.Exception r10 = new java.lang.Exception
            java.lang.String r0 = "Can't find decryption key!"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.SmashyWebview.W(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String A() {
        return "SS2tream";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Long l2;
        Intrinsics.f(observableEmitter, "subscriber");
        S();
        if (movieInfo != null) {
            l2 = Long.valueOf(movieInfo.tmdbID);
        } else {
            l2 = null;
        }
        String str = "https://embed.smashystream.com/playere.php?tmdb=" + l2;
        WebViewDriver L = L();
        if (L != null) {
            L.loadUrl(str);
        }
        BuildersKt.c(AppDispatchers.IO.b(), new SmashyWebview$onCallMovie$$inlined$runOnIO$1((Continuation) null, this));
        U(String.valueOf(l2), observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Intrinsics.f(observableEmitter, "subscriber");
        S();
        StringBuilder sb = new StringBuilder();
        Intrinsics.c(movieInfo);
        sb.append(movieInfo.tmdbID);
        sb.append("&season=");
        sb.append(movieInfo.session);
        sb.append("&episode=");
        sb.append(movieInfo.eps);
        String sb2 = sb.toString();
        String str = "https://embed.smashystream.com/playere.php?tmdb=" + sb2;
        WebViewDriver L = L();
        if (L != null) {
            L.loadUrl(str);
        }
        BuildersKt.c(AppDispatchers.IO.b(), new SmashyWebview$onCallTVShow$$inlined$runOnIO$1((Continuation) null, this));
        U(sb2.toString(), observableEmitter);
    }

    public final String R() {
        return this.f37436f;
    }

    public final String T() {
        return this.f37437g;
    }

    public final void U(String str, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str2 = str;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        Intrinsics.f(str2, "keycode");
        Intrinsics.f(observableEmitter2, "subscriber");
        for (String str3 : CollectionsKt__CollectionsKt.i("https://api.smashystream.top/api/v1/videophan/", "https://api.smashystream.top/api/v1/videoflxt/", "https://api.smashystream.top/api/v1/sdayflxcloe/", "https://api.smashystream.top/api/v1/videoophim/", "https://api.smashystream.top/api/v1/videoinserv/", "https://api.smashystream.top/api/v1/videostc/", "https://api.smashystream.top/api/v1/videoup/", " https://api.smashystream.top/api/v1/videoemov/", "https://api.smashystream.top/api/v1/shortsotv/", "https://api.smashystream.top/api/v1/shortjara/", "https://api.smashystream.top/api/v1/shortfeb/", "https://api.smashystream.top/api/v1/videodream/", "https://api.smashystream.top/api/v1/shortrido/", "https://api.smashystream.top/api/v1/shortmoviesc/", "https://api.smashystream.top/api/v1/videocat/", "https://api.smashystream.top/api/v1/videomirror/", "https://api.smashystream.top/api/v1/shortfumov/", "https://api.smashystream.top/api/v1/shortkino/", "https://api.smashystream.top/api/v1/shortgdp/", "https://api.smashystream.top/api/v1/videoflxt/", "https://api.smashystream.top/api/v1/sdayflxcloe/", "https://api.smashystream.top/api/v1/shortrido/", "https://api.smashystream.top/api/v1/videoinserv/", "https://api.smashystream.top/api/v1/videoemov/", "https://api.smashystream.top/api/v1/videostc/", "https://api.smashystream.top/api/v1/videoup/", "https://api.smashystream.top/api/v1/videoophim/", "https://api.smashystream.top/api/v1/shortsotv/", "https://api.smashystream.top/api/v1/shortjara/", "https://api.smashystream.top/api/v1/shortfeb/", "https://api.smashystream.top/api/v1/videodream/", "https://api.smashystream.top/api/v1/videocat/", "https://api.smashystream.top/api/v1/short2embed/", "https://api.smashystream.top/api/v1/videomirror/", "https://api.smashystream.top/api/v1/shortmoviesc/", "https://api.smashystream.top/api/v1/videofsh/", "https://api.smashystream.top/api/v1/short3ee/", "https://api.smashystream.top/api/v1/shortfumov/", "https://api.smashystream.top/api/v1/shortkino/", "https://api.smashystream.top/api/v1/shortgdp/")) {
            try {
                String str4 = str3 + str2 + "?token=" + this.f37437g;
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", "https://player.smashy.stream/");
                boolean z2 = true;
                String m2 = HttpHelper.i().m(str4, hashMap);
                Intrinsics.e(m2, "m13048(...)");
                String a2 = Regex.a(StringsKt__StringsJVMKt.C(m2, "\\/", "/", false, 4, (Object) null), "['\"]file['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
                Intrinsics.c(a2);
                if (a2.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    Intrinsics.c(a2);
                    if (!StringsKt__StringsKt.L(a2, com.facebook.hermes.intl.Constants.CASEFIRST_FALSE, false, 2, (Object) null)) {
                        Q(new ArrayList(CollectionsKt__CollectionsJVMKt.b(a2)), str4, observableEmitter2, "");
                    }
                }
                Logger.a("smashystream im here!!!");
                Thread.sleep(3000);
            } catch (Exception unused) {
            }
        }
    }

    public final void V(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f37437g = str;
    }
}
