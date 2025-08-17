package com.utils.Getlink.Resolver;

import com.utils.Getlink.Resolver.premium.PremiumResolver;

public class UpToBox extends PremiumResolver {

    /* renamed from: h  reason: collision with root package name */
    public static ResponcesData f37545h;

    class ResponcesData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f37546a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f37547b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f37548c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f37549d;
    }

    public String c() {
        return "UpToBox";
    }

    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r5v1, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02fa A[SYNTHETIC, Splitter:B:108:0x02fa] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01be A[Catch:{ all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x023d A[Catch:{ all -> 0x02e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(com.original.tase.model.media.MediaSource r27, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r28) {
        /*
            r26 = this;
            r1 = r27
            r2 = r28
            java.lang.String r3 = "%20"
            java.lang.String r4 = " "
            java.lang.String r5 = "['\"]?src['\"]\\s*:\\s*['\"]([^'\"]+)['\"].*?['\"]?label['\"]?\\s*:\\s*['\"]?(\\d{3,4})p?['\"]?"
            java.lang.String r6 = "2160"
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r0 = f37545h
            r7 = 0
            if (r0 != 0) goto L_0x0043
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = com.original.Constants.E
            r8.append(r9)
            java.lang.String r9 = "resolver/utb.js"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.util.Map[] r9 = new java.util.Map[r7]
            java.lang.String r0 = r0.m(r8, r9)
            boolean r8 = r0.isEmpty()
            if (r8 != 0) goto L_0x0043
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            java.lang.Class<com.utils.Getlink.Resolver.UpToBox$ResponcesData> r9 = com.utils.Getlink.Resolver.UpToBox.ResponcesData.class
            java.lang.Object r0 = r8.l(r0, r9)
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r0 = (com.utils.Getlink.Resolver.UpToBox.ResponcesData) r0
            f37545h = r0
        L_0x0043:
            java.lang.String r0 = r27.getStreamLink()
            super.l(r27, r28)
            boolean r8 = com.utils.Utils.f37611d
            if (r8 == 0) goto L_0x004f
            return
        L_0x004f:
            java.lang.String r8 = "/dl/"
            boolean r8 = r0.contains(r8)
            if (r8 == 0) goto L_0x006c
            com.original.tase.model.ResolveResult r3 = new com.original.tase.model.ResolveResult
            java.lang.String r4 = r26.c()
            java.lang.String r5 = r27.getQuality()
            r3.<init>((java.lang.String) r4, (java.lang.String) r0, (java.lang.String) r5)
            com.original.tase.model.media.MediaSource r0 = com.utils.Getlink.Resolver.BaseResolver.a(r1, r3)
            r2.onNext(r0)
            return
        L_0x006c:
            java.lang.String r8 = "(?://|\\.)(uptobox.com|uptostream.com)/(?:iframe/)?([0-9A-Za-z_]+)"
            r9 = 2
            java.lang.String r8 = com.original.tase.utils.Regex.a(r0, r8, r9)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x007a
            return
        L_0x007a:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "https://uptostream.com/iframe/"
            r0.append(r10)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.original.tase.helper.http.HttpHelper r10 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r11 = new java.util.Map[r7]
            java.lang.String r10 = r10.m(r0, r11)
            java.lang.String r11 = "\\s*(var\\s*_0x[0-9a-zA-Z]+=.*\\)\\);)\\s*window.sources"
            r14 = 1
            java.lang.String r11 = com.original.tase.utils.Regex.a(r10, r11, r14)
            boolean r12 = r11.isEmpty()
            java.lang.String r13 = ""
            java.lang.String r9 = "var "
            java.lang.String r7 = "let "
            java.lang.String r14 = "function()"
            r17 = r10
            java.lang.String r10 = "()=>"
            if (r12 == 0) goto L_0x0161
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r12 = f37545h
            if (r12 == 0) goto L_0x0157
            java.lang.String r11 = r12.f37547b
            java.lang.String r12 = "null"
            boolean r12 = r11.equalsIgnoreCase(r12)
            r17 = r11
            java.lang.String r11 = "https://uptostream.com"
            if (r12 != 0) goto L_0x00f9
            java.util.HashMap r12 = com.original.Constants.c()
            r22 = r6
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r23 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r17 = f37545h
            r24 = r4
            java.lang.String r4 = r17.f37548c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r25 = r5
            r4 = 1
            java.util.Map[] r5 = new java.util.Map[r4]
            r4 = 0
            r5[r4] = r12
            java.lang.String r3 = r6.m(r3, r5)
            r17 = r3
            goto L_0x0101
        L_0x00f9:
            r23 = r3
            r24 = r4
            r25 = r5
            r22 = r6
        L_0x0101:
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r5 = f37545h
            java.lang.String r5 = r5.f37546a
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r5 = 0
            r6[r5] = r17
            r12 = 1
            r6[r12] = r8
            java.lang.String r4 = java.lang.String.format(r4, r6)
            java.util.Map[] r6 = new java.util.Map[r5]
            java.lang.String r3 = r3.m(r4, r6)
            java.lang.String r4 = "sources['\"]\\s*:\\s*['\"]([^'\"].+[^'\"])['\"]"
            java.lang.String r4 = com.original.tase.utils.Regex.a(r3, r4, r12)
            java.lang.String r5 = "(\\(function\\(\\)\\s*\\{.+\\}\\(\\)\\)\\;)var"
            java.lang.String r5 = com.original.tase.utils.Regex.a(r4, r5, r12)
            java.lang.String r4 = r4.replace(r5, r13)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "function atob(r){if((r=r.replace(/[ \\t\\n\\f\\r]/g,\"\")).length%4==0&&(r=r.replace(/==?$/,\"\")),r.length%4==1||/[^+/0-9A-Za-z]/.test(r))return null;for(var t=\"\",o=0,e=0,a=0;a<r.length;a++)o<<=6,o|=atobLookup(r[a]),24===(e+=6)&&(t+=String.fromCharCode((16711680&o)>>16),t+=String.fromCharCode((65280&o)>>8),t+=String.fromCharCode(255&o),o=e=0);return 12===e?(o>>=4,t+=String.fromCharCode(o)):18===e&&(o>>=2,t+=String.fromCharCode((65280&o)>>8),t+=String.fromCharCode(255&o)),t}function atobLookup(r){return/[A-Z]/.test(r)?r.charCodeAt(0)-\"A\".charCodeAt(0):/[a-z]/.test(r)?r.charCodeAt(0)-\"a\".charCodeAt(0)+26:/[0-9]/.test(r)?r.charCodeAt(0)-\"0\".charCodeAt(0)+52:\"+\"===r?62:\"/\"===r?63:void 0}function acb(){return JSON.stringify(sources)}acb();"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r4 = r4.replace(r10, r14)
            java.lang.String r11 = r4.replace(r7, r9)
            goto L_0x0185
        L_0x0157:
            r23 = r3
            r24 = r4
            r25 = r5
            r22 = r6
            r12 = 1
            goto L_0x0183
        L_0x0161:
            r23 = r3
            r24 = r4
            r25 = r5
            r22 = r6
            r12 = 1
            java.lang.String r3 = r11.replace(r10, r14)
            java.lang.String r3 = r3.replace(r7, r9)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "function acb(){return JSON.stringify(sources)}acb();"
            r4.append(r3)
            java.lang.String r11 = r4.toString()
        L_0x0183:
            r3 = r17
        L_0x0185:
            com.squareup.duktape.Duktape r4 = com.squareup.duktape.Duktape.create()
            java.lang.Object r5 = r4.evaluate(r11)     // Catch:{ all -> 0x01fd }
            if (r5 == 0) goto L_0x01fd
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x01fd }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x01fd }
            if (r6 != 0) goto L_0x01fd
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01fd }
            r15.add(r5)     // Catch:{ all -> 0x01fd }
            r5 = 0
            r14 = 0
            java.lang.String r6 = r27.getQuality()     // Catch:{ all -> 0x01fd }
            r10 = r26
            r11 = r0
            r7 = 1
            r12 = r15
            r9 = r13
            r13 = r5
            r5 = 1
            r7 = r15
            r15 = r6
            java.util.ArrayList r6 = r10.k(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0200 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0200 }
        L_0x01b8:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0200 }
            if (r10 == 0) goto L_0x0200
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0200 }
            com.original.tase.model.ResolveResult r10 = (com.original.tase.model.ResolveResult) r10     // Catch:{ all -> 0x0200 }
            java.lang.String r11 = r10.getResolvedLink()     // Catch:{ all -> 0x0200 }
            com.utils.Getlink.Resolver.UpToBox$ResponcesData r12 = f37545h     // Catch:{ all -> 0x0200 }
            java.lang.String r12 = r12.f37549d     // Catch:{ all -> 0x0200 }
            boolean r11 = r11.contains(r12)     // Catch:{ all -> 0x0200 }
            if (r11 == 0) goto L_0x01b8
            java.lang.String r11 = r10.getResolvedQuality()     // Catch:{ all -> 0x0200 }
            if (r11 == 0) goto L_0x01f5
            java.lang.String r11 = r10.getResolvedQuality()     // Catch:{ all -> 0x0200 }
            java.lang.String r11 = r11.trim()     // Catch:{ all -> 0x0200 }
            java.lang.String r11 = r11.toLowerCase()     // Catch:{ all -> 0x0200 }
            java.lang.String r12 = "sd"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0200 }
            if (r11 == 0) goto L_0x01f5
            java.lang.String r11 = r27.getQuality()     // Catch:{ all -> 0x0200 }
            r10.setResolvedQuality(r11)     // Catch:{ all -> 0x0200 }
        L_0x01f5:
            com.original.tase.model.media.MediaSource r10 = com.utils.Getlink.Resolver.BaseResolver.a(r1, r10)     // Catch:{ all -> 0x0200 }
            r2.onNext(r10)     // Catch:{ all -> 0x0200 }
            goto L_0x01b8
        L_0x01fd:
            r9 = r13
            r7 = r15
            r5 = 1
        L_0x0200:
            r4.close()
            r19 = 0
            r20 = 0
            java.lang.String r21 = r27.getQuality()     // Catch:{ all -> 0x021a }
            r16 = r26
            r17 = r0
            r18 = r3
            java.util.ArrayList r0 = r16.j(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x021a }
            r7.addAll(r0)     // Catch:{ all -> 0x021a }
            r4 = 0
            goto L_0x0221
        L_0x021a:
            r0 = move-exception
            r4 = 0
            boolean[] r6 = new boolean[r4]
            com.original.tase.Logger.d(r0, r6)
        L_0x0221:
            java.lang.String r0 = "window.sources.*=.*(\\[.*?\\])"
            java.lang.String r0 = com.original.tase.utils.Regex.a(r3, r0, r4)     // Catch:{ all -> 0x02e7 }
            java.lang.String r3 = "\\/"
            java.lang.String r4 = "/"
            java.lang.String r0 = r0.replace(r3, r4)     // Catch:{ all -> 0x02e7 }
            java.lang.String r3 = "\\\""
            java.lang.String r4 = "\""
            java.lang.String r0 = r0.replace(r3, r4)     // Catch:{ all -> 0x02e7 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x02e7 }
            if (r3 != 0) goto L_0x02e0
            java.lang.String r3 = "\\{(.+?)\\}"
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r3, r5, r5)     // Catch:{ all -> 0x02e7 }
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x02d8 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x02e7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02e7 }
        L_0x024e:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x02e7 }
            if (r3 == 0) goto L_0x02e0
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x02e7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x02e7 }
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x02e7 }
            if (r4 != 0) goto L_0x024e
            java.lang.String r4 = "video/"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x02e7 }
            if (r4 != 0) goto L_0x0270
            java.lang.String r4 = "video."
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x02e7 }
            if (r4 == 0) goto L_0x024e
        L_0x0270:
            r4 = r25
            java.lang.String r6 = com.original.tase.utils.Regex.c(r3, r4, r5, r5)     // Catch:{ all -> 0x02e7 }
            r11 = r23
            r10 = r24
            java.lang.String r6 = r6.replace(r10, r11)     // Catch:{ all -> 0x02d4 }
            r12 = 2
            java.lang.String r3 = com.original.tase.utils.Regex.c(r3, r4, r12, r5)     // Catch:{ all -> 0x02d4 }
            boolean r13 = r3.isEmpty()     // Catch:{ all -> 0x02d4 }
            if (r13 == 0) goto L_0x02ba
            java.lang.String r3 = "/(\\d{3,4})/"
            java.lang.String r3 = com.original.tase.utils.Regex.a(r6, r3, r5)     // Catch:{ all -> 0x02d4 }
            r13 = r22
            boolean r14 = r3.equals(r13)     // Catch:{ all -> 0x02d2 }
            if (r14 != 0) goto L_0x02bc
            java.lang.String r14 = "1080"
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x02d2 }
            if (r14 != 0) goto L_0x02bc
            java.lang.String r14 = "720"
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x02d2 }
            if (r14 != 0) goto L_0x02bc
            java.lang.String r14 = "480"
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x02d2 }
            if (r14 != 0) goto L_0x02bc
            java.lang.String r14 = "360"
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x02d2 }
            if (r14 != 0) goto L_0x02bc
            java.lang.String r3 = "HD"
            goto L_0x02bc
        L_0x02ba:
            r13 = r22
        L_0x02bc:
            com.original.tase.model.ResolveResult r14 = new com.original.tase.model.ResolveResult     // Catch:{ all -> 0x02d2 }
            java.lang.String r15 = r26.c()     // Catch:{ all -> 0x02d2 }
            r14.<init>((java.lang.String) r15, (java.lang.String) r6, (java.lang.String) r3)     // Catch:{ all -> 0x02d2 }
            r7.add(r14)     // Catch:{ all -> 0x02d2 }
            r25 = r4
            r24 = r10
            r23 = r11
            r22 = r13
            goto L_0x024e
        L_0x02d2:
            r0 = move-exception
            goto L_0x02ee
        L_0x02d4:
            r0 = move-exception
            r13 = r22
            goto L_0x02ee
        L_0x02d8:
            r0 = move-exception
            r13 = r22
            r11 = r23
            r10 = r24
            goto L_0x02ef
        L_0x02e0:
            r13 = r22
            r11 = r23
            r10 = r24
            goto L_0x02f4
        L_0x02e7:
            r0 = move-exception
            r13 = r22
            r11 = r23
            r10 = r24
        L_0x02ee:
            r3 = 0
        L_0x02ef:
            boolean[] r4 = new boolean[r3]
            com.original.tase.Logger.d(r0, r4)
        L_0x02f4:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x03c9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c2 }
            r0.<init>()     // Catch:{ all -> 0x03c2 }
            java.lang.String r3 = "http://uptobox.com/"
            r0.append(r3)     // Catch:{ all -> 0x03c2 }
            r0.append(r8)     // Catch:{ all -> 0x03c2 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x03c2 }
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x03c2 }
            java.lang.String r0 = r0.o(r3, r3)     // Catch:{ all -> 0x03c2 }
            java.lang.String r4 = "not available in your country"
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            java.lang.String r4 = "You have to wait "
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            java.lang.String r4 = "or you can wait"
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            java.lang.String r4 = "the file you want is not available"
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            java.lang.String r4 = "the video you want to see is not available"
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            java.lang.String r4 = "This stream doesn"
            boolean r4 = r0.contains(r4)     // Catch:{ all -> 0x03c2 }
            if (r4 != 0) goto L_0x03c9
            r4 = 0
            java.util.HashMap r0 = com.utils.Getlink.Resolver.BaseResolver.i(r0, r4)     // Catch:{ all -> 0x03c2 }
            java.lang.String r4 = com.original.tase.utils.Utils.g(r0)     // Catch:{ all -> 0x03c2 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x03c2 }
            r6.<init>()     // Catch:{ all -> 0x03c2 }
            java.lang.String r0 = "Referer"
            r6.put(r0, r3)     // Catch:{ all -> 0x03c2 }
            r8 = 0
        L_0x0357:
            r0 = 3
            if (r8 >= r0) goto L_0x03c9
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x03ba }
            java.util.Map[] r12 = new java.util.Map[r5]     // Catch:{ all -> 0x03ba }
            r14 = 0
            r12[r14] = r6     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.q(r3, r4, r5, r12)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = "href\\s*=\\s*['\"]([^'\"]+)[^>]+>\\s*<span[^>]+class\\s*=\\s*['\"]button_upload green['\"]"
            java.lang.String r0 = com.original.tase.utils.Regex.a(r0, r12, r5)     // Catch:{ all -> 0x03ba }
            boolean r12 = r0.isEmpty()     // Catch:{ all -> 0x03ba }
            if (r12 != 0) goto L_0x03a9
            java.lang.String r12 = "[\\. ](\\d{3,4})p[\\. ]"
            java.lang.String r12 = com.original.tase.utils.Regex.a(r0, r12, r5)     // Catch:{ all -> 0x03ba }
            boolean r14 = r12.isEmpty()     // Catch:{ all -> 0x03ba }
            if (r14 == 0) goto L_0x0381
            r12 = r9
            goto L_0x0398
        L_0x0381:
            boolean r14 = com.original.tase.utils.Utils.o(r12)     // Catch:{ all -> 0x03ba }
            if (r14 == 0) goto L_0x0398
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r14.<init>()     // Catch:{ all -> 0x03ba }
            r14.append(r12)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = "p"
            r14.append(r12)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x03ba }
        L_0x0398:
            com.original.tase.model.ResolveResult r14 = new com.original.tase.model.ResolveResult     // Catch:{ all -> 0x03ba }
            java.lang.String r15 = r26.c()     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.replace(r10, r11)     // Catch:{ all -> 0x03ba }
            r14.<init>((java.lang.String) r15, (java.lang.String) r0, (java.lang.String) r12)     // Catch:{ all -> 0x03ba }
            r7.add(r14)     // Catch:{ all -> 0x03ba }
            goto L_0x03c9
        L_0x03a9:
            r14 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r14)     // Catch:{ all -> 0x03af }
            goto L_0x03b7
        L_0x03af:
            r0 = move-exception
            r12 = r0
            r14 = 0
            boolean[] r0 = new boolean[r14]     // Catch:{ all -> 0x03ba }
            com.original.tase.Logger.d(r12, r0)     // Catch:{ all -> 0x03ba }
        L_0x03b7:
            int r8 = r8 + 1
            goto L_0x0357
        L_0x03ba:
            r0 = move-exception
            r12 = 0
            boolean[] r14 = new boolean[r12]     // Catch:{ all -> 0x03c2 }
            com.original.tase.Logger.d(r0, r14)     // Catch:{ all -> 0x03c2 }
            goto L_0x0357
        L_0x03c2:
            r0 = move-exception
            r3 = 0
            boolean[] r3 = new boolean[r3]
            com.original.tase.Logger.d(r0, r3)
        L_0x03c9:
            java.util.ArrayList r0 = com.original.tase.utils.Utils.l(r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x03d1:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0400
            java.lang.Object r3 = r0.next()
            com.original.tase.model.ResolveResult r3 = (com.original.tase.model.ResolveResult) r3
            java.lang.String r4 = r3.getResolvedQuality()
            if (r4 == 0) goto L_0x03f8
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x03f8
            java.lang.String r4 = r4.trim()
            boolean r4 = r4.startsWith(r13)
            if (r4 == 0) goto L_0x03f8
            java.lang.String r4 = "4K"
            r3.setResolvedQuality(r4)
        L_0x03f8:
            com.original.tase.model.media.MediaSource r3 = com.utils.Getlink.Resolver.BaseResolver.a(r1, r3)
            r2.onNext(r3)
            goto L_0x03d1
        L_0x0400:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Resolver.UpToBox.l(com.original.tase.model.media.MediaSource, io.reactivex.ObservableEmitter):void");
    }
}
