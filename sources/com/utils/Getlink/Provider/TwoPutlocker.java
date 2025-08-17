package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class TwoPutlocker extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37477e = (Utils.getProvider(106) + "/");

    /* renamed from: f  reason: collision with root package name */
    private String f37478f = "HD";

    private String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", Constants.C);
        String replace = movieInfo.name.replace("'", "").replaceAll("(\\\\\\|/| -|:|;|\\*|\\?|\"|\\'|<|>|\\|)", " ").replace("  ", " ").replace(" ", "+");
        hashMap.put("referer", this.f37477e);
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37477e + "search?keyword=" + replace.toLowerCase(), hashMap)).q0("div[data-movie-id][class=ml-item]").iterator();
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0(a.f20042a);
            String c2 = r02.c("href");
            String c3 = r02.c("oldtitle");
            if (c3.isEmpty()) {
                c3 = r02.c("title");
            }
            if (c3.isEmpty()) {
                c3 = r02.r0("img").c("title");
            }
            if (c3.toLowerCase().startsWith("watch ")) {
                c3 = c3.replace("Watch ", "").replace("watch ", "");
            }
            if (!z2) {
                if (c3.equalsIgnoreCase(movieInfo.name + " - Season " + movieInfo.session + " (" + movieInfo.sessionYear + ")")) {
                    this.f37478f = "HD";
                    return c2;
                }
            } else if (c3.equalsIgnoreCase(movieInfo.name)) {
                String c4 = r02.c("data-url");
                if (!c4.isEmpty()) {
                    String m2 = HttpHelper.i().m(c4, new Map[0]);
                    String c5 = Regex.c(m2, "<div\\s+[^>]*class=\"jt-info\"[^>]*>\\s*(\\d{4})\\s*</div>", 1, true);
                    this.f37478f = Regex.c(m2, "<div\\s+[^>]*class=\"jtip-quality\"[^>]*>\\s*(\\d{4})\\s*</div>", 1, true);
                    if (movieInfo.year.equals(c5)) {
                    }
                }
                return c2;
            } else {
                continue;
            }
        }
        return "";
    }

    public String A() {
        return "TwoPutlocker";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, K, movieInfo);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r19, java.lang.String r20, com.movie.data.model.MovieInfo r21) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            r3 = r21
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = "Referer"
            r4.put(r5, r0)
            java.lang.String r5 = com.original.Constants.C
            java.lang.String r6 = "user-agent"
            r4.put(r6, r5)
            com.original.tase.helper.http.HttpHelper r5 = com.original.tase.helper.http.HttpHelper.i()
            r7 = 1
            java.util.Map[] r8 = new java.util.Map[r7]
            r9 = 0
            r8[r9] = r4
            java.lang.String r5 = r5.m(r0, r8)
            java.lang.String r8 = r1.f37478f
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0033
            java.lang.String r8 = "HQ"
            r1.f37478f = r8
        L_0x0033:
            java.lang.String r8 = r1.f37478f
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r10 = "cam"
            boolean r8 = r8.contains(r10)
            java.lang.Integer r10 = r21.getType()
            int r10 = r10.intValue()
            if (r10 != r7) goto L_0x004b
            r10 = 1
            goto L_0x004c
        L_0x004b:
            r10 = 0
        L_0x004c:
            java.lang.String r11 = "HD"
            if (r10 != 0) goto L_0x00aa
            r1.f37478f = r11
            org.jsoup.nodes.Document r10 = org.jsoup.Jsoup.b(r5)
            java.lang.String r12 = "div[class=les-content]"
            org.jsoup.select.Elements r10 = r10.q0(r12)
            java.lang.String r12 = "a"
            org.jsoup.select.Elements r10 = r10.g(r12)
            java.util.Iterator r10 = r10.iterator()
        L_0x0066:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x00a5
            java.lang.Object r12 = r10.next()
            org.jsoup.nodes.Element r12 = (org.jsoup.nodes.Element) r12
            java.lang.String r13 = "href"
            java.lang.String r12 = r12.c(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r3.session
            r13.append(r14)
            java.lang.String r14 = "-e"
            r13.append(r14)
            java.lang.String r14 = r3.eps
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            boolean r13 = r12.contains(r13)
            if (r13 == 0) goto L_0x0066
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r3 = new java.util.Map[r7]
            r3[r9] = r4
            java.lang.String r0 = r0.m(r12, r3)
            r5 = r0
            r0 = 1
            goto L_0x00a7
        L_0x00a5:
            r12 = r0
            r0 = 0
        L_0x00a7:
            if (r0 != 0) goto L_0x00ab
            return
        L_0x00aa:
            r12 = r0
        L_0x00ab:
            java.lang.String r0 = "var?.id\\s*=\\s*['\"]([^'\"]+)['\"]"
            java.lang.String r3 = com.original.tase.utils.Regex.a(r5, r0, r7)
            java.lang.String r0 = "var?.e\\s*=\\s*['\"]([^'\"]+)['\"]"
            java.lang.String r10 = com.original.tase.utils.Regex.a(r5, r0, r7)
            java.lang.String r0 = "var?.links\\s*=\\s*['\"]([^'\"]+)['\"]"
            java.lang.String r5 = com.original.tase.utils.Regex.a(r5, r0, r7)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            boolean r0 = r5.isEmpty()
            java.lang.String r15 = "['\"]?src['\"]?\\s*:\\s*['\"]?([^'\"]+)"
            java.lang.String r7 = "/"
            java.lang.String r14 = "\\/"
            if (r0 != 0) goto L_0x013e
            r9 = 10
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x00e1 }
            r16 = r11
            byte[] r11 = android.util.Base64.decode(r5, r9)     // Catch:{ Exception -> 0x00df }
            java.lang.String r9 = "UTF-8"
            r0.<init>(r11, r9)     // Catch:{ Exception -> 0x00df }
        L_0x00dd:
            r5 = 0
            goto L_0x00ff
        L_0x00df:
            r0 = move-exception
            goto L_0x00e4
        L_0x00e1:
            r0 = move-exception
            r16 = r11
        L_0x00e4:
            r9 = 0
            boolean[] r11 = new boolean[r9]
            com.original.tase.Logger.d(r0, r11)
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x00f6 }
            r9 = 10
            byte[] r5 = android.util.Base64.decode(r5, r9)     // Catch:{ Exception -> 0x00f6 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dd
        L_0x00f6:
            r0 = move-exception
            r5 = 0
            boolean[] r9 = new boolean[r5]
            com.original.tase.Logger.d(r0, r9)
            java.lang.String r0 = ""
        L_0x00ff:
            java.lang.String r0 = r0.replace(r14, r7)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r17 = r4
            r4 = 1
            r11 = 2
            java.util.ArrayList r0 = com.original.tase.utils.Regex.e(r0, r15, r4, r11)
            java.lang.Object r0 = r0.get(r5)
            java.util.Collection r0 = (java.util.Collection) r0
            r9.addAll(r0)
            java.util.Iterator r0 = r9.iterator()
        L_0x011d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0142
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r13.contains(r4)
            if (r5 != 0) goto L_0x011d
            r13.add(r4)
            java.lang.String r5 = r1.f37478f
            r9 = 1
            boolean[] r11 = new boolean[r9]
            r9 = 0
            r11[r9] = r8
            r1.z(r2, r4, r5, r11)
            goto L_0x011d
        L_0x013e:
            r17 = r4
            r16 = r11
        L_0x0142:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "id="
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = "&e="
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.util.HashMap r3 = com.original.Constants.c()
            java.lang.String r4 = "origin"
            java.lang.String r5 = r1.f37477e
            r3.put(r4, r5)
            java.lang.String r4 = "referer"
            r3.put(r4, r12)
            java.lang.String r4 = com.original.Constants.C
            r3.put(r6, r4)
            java.lang.String r4 = "x-requested-with"
            java.lang.String r5 = "XMLHttpRequest"
            r3.put(r4, r5)
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r1.f37477e
            r5.append(r6)
            java.lang.String r6 = "get-links/"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 1
            java.util.Map[] r9 = new java.util.Map[r6]
            r10 = 0
            r9[r10] = r3
            java.lang.String r0 = r4.q(r5, r0, r10, r9)
            java.lang.String r0 = r0.replace(r14, r7)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 2
            java.util.ArrayList r0 = com.original.tase.utils.Regex.e(r0, r15, r6, r5)
            java.lang.Object r0 = r0.get(r10)
            java.util.Collection r0 = (java.util.Collection) r0
            r4.addAll(r0)
            java.util.Iterator r0 = r4.iterator()
        L_0x01b3:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x02a5
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r13.contains(r4)
            if (r5 != 0) goto L_0x029e
            boolean r5 = com.original.tase.helper.GoogleVideoHelper.l(r4)
            java.lang.String r6 = " (CAM)"
            if (r5 == 0) goto L_0x0257
            java.util.HashMap r5 = com.original.tase.helper.GoogleVideoHelper.g(r4)
            if (r5 == 0) goto L_0x029e
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L_0x029e
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x01e1:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x029e
            java.lang.Object r7 = r5.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            com.original.tase.model.media.MediaSource r10 = new com.original.tase.model.media.MediaSource
            if (r8 == 0) goto L_0x020b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r18.A()
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            goto L_0x020f
        L_0x020b:
            java.lang.String r11 = r18.A()
        L_0x020f:
            java.lang.String r12 = "GoogleVideo"
            r14 = 0
            r10.<init>(r11, r12, r14)
            r10.setOriginalLink(r4)
            r10.setStreamLink(r9)
            java.lang.Object r9 = r7.getValue()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x022a
            r9 = r16
            goto L_0x0230
        L_0x022a:
            java.lang.Object r9 = r7.getValue()
            java.lang.String r9 = (java.lang.String) r9
        L_0x0230:
            r10.setQuality((java.lang.String) r9)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r11 = "User-Agent"
            java.lang.String r12 = com.original.Constants.C
            r14 = r17
            r14.put(r11, r12)
            java.lang.Object r7 = r7.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = com.original.tase.helper.GoogleVideoHelper.m(r4, r7)
            java.lang.String r11 = "Cookie"
            r14.put(r11, r7)
            r10.setPlayHeader(r9)
            r2.onNext(r10)
            goto L_0x01e1
        L_0x0257:
            r14 = r17
            com.original.tase.helper.GoogleVideoHelper.n(r4)
            java.lang.String r5 = ".fbcdn."
            boolean r7 = r4.contains(r5)
            com.original.tase.model.media.MediaSource r9 = new com.original.tase.model.media.MediaSource
            if (r8 == 0) goto L_0x027a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r18.A()
            r10.append(r11)
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            goto L_0x027e
        L_0x027a:
            java.lang.String r6 = r18.A()
        L_0x027e:
            if (r7 == 0) goto L_0x0283
            java.lang.String r7 = "FB-CDN"
            goto L_0x0285
        L_0x0283:
            java.lang.String r7 = "CDN"
        L_0x0285:
            r10 = 0
            r9.<init>(r6, r7, r10)
            r9.setStreamLink(r4)
            java.lang.String r6 = r1.f37478f
            r9.setQuality((java.lang.String) r6)
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x029a
            r9.setPlayHeader(r3)
        L_0x029a:
            r2.onNext(r9)
            goto L_0x02a1
        L_0x029e:
            r14 = r17
            r10 = 0
        L_0x02a1:
            r17 = r14
            goto L_0x01b3
        L_0x02a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.TwoPutlocker.J(io.reactivex.ObservableEmitter, java.lang.String, com.movie.data.model.MovieInfo):void");
    }
}
