package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class SpaceMov extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37456e;

    /* renamed from: f  reason: collision with root package name */
    private String f37457f;

    public SpaceMov() {
        String str = Utils.getProvider(101) + "/";
        this.f37456e = str;
        this.f37457f = str;
    }

    public String A() {
        return "SpaceMov";
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

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x029e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r21, java.lang.String r22, com.movie.data.model.MovieInfo r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            java.lang.Integer r3 = r23.getType()
            int r3 = r3.intValue()
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            java.lang.String r6 = "\\/"
            java.lang.String r7 = "/"
            r8 = r22
            java.lang.String r6 = r8.replace(r6, r7)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r9 = "user-agent"
            java.lang.String r10 = com.original.Constants.C
            r8.put(r9, r10)
            java.lang.String r9 = "referer"
            r8.put(r9, r6)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            r10.D(r6, r6)
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            java.lang.String r6 = "watching/"
            r11.append(r6)
            java.lang.String r6 = r11.toString()
            java.util.Map[] r11 = new java.util.Map[r5]
            r11[r4] = r8
            java.lang.String r6 = r10.m(r6, r11)
            org.jsoup.nodes.Document r10 = org.jsoup.Jsoup.b(r6)
            java.lang.String r11 = "div[class=mvici-right]"
            org.jsoup.nodes.Element r11 = r10.r0(r11)
            if (r11 == 0) goto L_0x007d
            java.lang.String r12 = "span[class=quality]"
            org.jsoup.nodes.Element r12 = r11.r0(r12)
            java.lang.String r12 = r12.v0()
            java.lang.String r13 = "a[rel=tag]"
            org.jsoup.nodes.Element r11 = r11.r0(r13)
            java.lang.String r11 = r11.v0()
            java.lang.String r13 = r2.year
            boolean r11 = r13.equals(r11)
            if (r11 == 0) goto L_0x007f
            return
        L_0x007d:
            java.lang.String r12 = "HQ"
        L_0x007f:
            java.lang.String r11 = r12.toLowerCase()
            java.lang.String r13 = "cam"
            boolean r11 = r11.contains(r13)
            if (r11 != 0) goto L_0x009a
            java.lang.String r11 = r12.toLowerCase()
            java.lang.String r13 = "ts"
            boolean r11 = r11.contains(r13)
            if (r11 == 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r11 = 0
            goto L_0x009d
        L_0x009a:
            java.lang.String r12 = "CAM"
            r11 = 1
        L_0x009d:
            java.lang.String r13 = "<iframe[^>]+src=\"([^\"]+)\"[^>]*>"
            java.lang.String r14 = "/loadsource.php?server=%s&id=%s&token=%s"
            java.lang.String r15 = "multistream."
            java.lang.String r4 = "http"
            java.lang.String r5 = "data-svv[0-9]=['\"](.+?)['\"]"
            java.lang.String r2 = "vs\\s*=\\s*[\"']([^\"']+)[\"']"
            java.lang.String r1 = "a"
            r22 = r12
            java.lang.String r12 = "div[class=les-content]"
            r17 = r11
            java.lang.String r11 = "loadsource\\((\\d+)\\s*,\\s*(\\d+)\\s*,\\s*['\"]([^'\"]+)['\"]"
            if (r3 == 0) goto L_0x019f
            org.jsoup.select.Elements r3 = r10.q0(r12)
            org.jsoup.select.Elements r1 = r3.g(r1)
            java.lang.String r1 = r1.toString()
            r3 = 1
            java.util.ArrayList r1 = com.original.tase.utils.Regex.f(r1, r5, r3, r3)
            r5 = 0
            java.lang.Object r1 = r1.get(r5)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.String r2 = com.original.tase.utils.Regex.a(r6, r2, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x00d5:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x02b3
            java.lang.Object r3 = r1.next()
            java.lang.String r5 = r3.toString()
            boolean r6 = r5.contains(r4)
            if (r6 != 0) goto L_0x017f
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x00f0
            goto L_0x00d5
        L_0x00f0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = r0.f37456e
            r6.append(r10)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r8.put(r9, r6)
            java.lang.String r5 = com.original.tase.helper.http.HttpHelper.d(r5, r8)
            java.lang.String r3 = r3.toString()
            boolean r3 = r5.contains(r3)
            if (r3 == 0) goto L_0x0126
            java.lang.String r3 = com.original.tase.helper.http.HttpHelper.d(r5, r8)
            r5 = r3
        L_0x0126:
            boolean r3 = r5.contains(r15)
            if (r3 == 0) goto L_0x017f
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            r6 = 1
            java.util.Map[] r10 = new java.util.Map[r6]
            r12 = 0
            r10[r12] = r8
            java.lang.String r3 = r3.m(r5, r10)
            java.lang.String r10 = com.original.tase.utils.Regex.a(r3, r11, r6)
            r6 = 2
            java.lang.String r16 = com.original.tase.utils.Regex.a(r3, r11, r6)
            r6 = 3
            java.lang.String r3 = com.original.tase.utils.Regex.a(r3, r11, r6)
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r5 = com.utils.Getlink.Provider.BaseProvider.j(r5)
            r6.append(r5)
            r19 = r1
            r5 = 3
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r5 = 0
            r1[r5] = r10
            r10 = 1
            r1[r10] = r16
            r16 = 2
            r1[r16] = r3
            java.lang.String r1 = java.lang.String.format(r14, r1)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.util.Map[] r3 = new java.util.Map[r5]
            java.lang.String r1 = r12.m(r1, r3)
            java.lang.String r1 = com.original.tase.utils.Regex.a(r1, r13, r10)
            r5 = r1
            r1 = 0
            goto L_0x0183
        L_0x017f:
            r19 = r1
            r1 = 0
            r10 = 1
        L_0x0183:
            boolean r3 = r5.isEmpty()
            if (r3 != 0) goto L_0x0195
            boolean[] r3 = new boolean[r10]
            r3[r1] = r17
            r1 = r21
            r6 = r22
            r0.z(r1, r5, r6, r3)
            goto L_0x0199
        L_0x0195:
            r1 = r21
            r6 = r22
        L_0x0199:
            r22 = r6
            r1 = r19
            goto L_0x00d5
        L_0x019f:
            r3 = r22
            r7 = r1
            r9 = 1
            r1 = r21
            org.jsoup.select.Elements r10 = r10.q0(r12)
            org.jsoup.select.Elements r7 = r10.g(r7)
            java.util.Iterator r7 = r7.iterator()
            java.lang.String r2 = com.original.tase.utils.Regex.a(r6, r2, r9)
        L_0x01b5:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L_0x02b3
            java.lang.Object r6 = r7.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r9 = r6.v0()
            java.lang.String r9 = r9.toLowerCase()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "episode "
            r10.append(r12)
            r12 = r23
            r22 = r7
            java.lang.String r7 = r12.eps
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            boolean r7 = r9.contains(r7)
            if (r7 == 0) goto L_0x02a9
            java.lang.String r6 = r6.toString()
            r7 = 1
            java.util.ArrayList r5 = com.original.tase.utils.Regex.f(r6, r5, r7, r7)
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x01fa:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02b3
            java.lang.Object r6 = r5.next()
            java.lang.String r7 = r6.toString()
            boolean r9 = r7.contains(r4)
            if (r9 == 0) goto L_0x0290
            boolean r9 = r2.isEmpty()
            if (r9 == 0) goto L_0x0215
            goto L_0x01fa
        L_0x0215:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r7 = com.original.tase.helper.http.HttpHelper.d(r7, r8)
            java.lang.String r6 = r6.toString()
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x0237
            java.lang.String r6 = com.original.tase.helper.http.HttpHelper.d(r7, r8)
            r7 = r6
        L_0x0237:
            boolean r6 = r7.contains(r15)
            if (r6 == 0) goto L_0x0290
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r9 = 1
            java.util.Map[] r10 = new java.util.Map[r9]
            r12 = 0
            r10[r12] = r8
            java.lang.String r6 = r6.m(r7, r10)
            java.lang.String r10 = com.original.tase.utils.Regex.a(r6, r11, r9)
            r9 = 2
            java.lang.String r16 = com.original.tase.utils.Regex.a(r6, r11, r9)
            r9 = 3
            java.lang.String r6 = com.original.tase.utils.Regex.a(r6, r11, r9)
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r7 = com.utils.Getlink.Provider.BaseProvider.j(r7)
            r9.append(r7)
            r18 = r2
            r7 = 3
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r7 = 0
            r2[r7] = r10
            r10 = 1
            r2[r10] = r16
            r16 = 2
            r2[r16] = r6
            java.lang.String r2 = java.lang.String.format(r14, r2)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            java.util.Map[] r6 = new java.util.Map[r7]
            java.lang.String r2 = r12.m(r2, r6)
            java.lang.String r2 = com.original.tase.utils.Regex.a(r2, r13, r10)
            r6 = r2
            r2 = 3
            goto L_0x0298
        L_0x0290:
            r18 = r2
            r6 = r7
            r2 = 3
            r7 = 0
            r10 = 1
            r16 = 2
        L_0x0298:
            boolean r9 = r6.isEmpty()
            if (r9 != 0) goto L_0x02a5
            boolean[] r9 = new boolean[r10]
            r9[r7] = r17
            r0.z(r1, r6, r3, r9)
        L_0x02a5:
            r2 = r18
            goto L_0x01fa
        L_0x02a9:
            r18 = r2
            r2 = 3
            r6 = 0
            r7 = r22
            r2 = r18
            goto L_0x01b5
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.SpaceMov.J(io.reactivex.ObservableEmitter, java.lang.String, com.movie.data.model.MovieInfo):void");
    }

    public String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap<String, String> c2 = Constants.c();
        c2.put("referer", this.f37456e);
        c2.put("user-agent", Constants.C);
        String e2 = TitleHelper.e(TitleHelper.g(movieInfo.getName()).replace("'", "-").replace("-", "+"));
        Iterator it2 = Jsoup.b(HttpHelper.i().m(this.f37456e + "search-query/" + e2.toLowerCase() + "/", c2)).q0("div.movies-list.movies-list-full").g("div.ml-item").iterator();
        while (it2.hasNext()) {
            Element r02 = ((Element) it2.next()).r0("a[title]");
            if (r02 != null || r02.f0()) {
                String c3 = r02.c("href");
                String replaceAll = r02.c("title").replaceAll("\\<[^>]*>", "");
                if (!z2) {
                    if (replaceAll.toLowerCase().equals(movieInfo.name.toLowerCase() + " - season " + movieInfo.session)) {
                        return c3;
                    }
                } else if (movieInfo.name.toLowerCase().equals(replaceAll.toLowerCase())) {
                    return c3;
                }
            }
        }
        return "";
    }
}
