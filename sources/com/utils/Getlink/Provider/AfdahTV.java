package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class AfdahTV extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37239e = Utils.getProvider(37);

    private String J(String str) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 26; i2++) {
                char charAt = "abcdefghijklmnopqrstuvwxyz".charAt(i2);
                char charAt2 = "abcdefghijklmnopqrstuvwxyz".charAt((i2 + 13) % 26);
                hashMap.put(String.valueOf(charAt), String.valueOf(charAt2));
                hashMap.put(String.valueOf(charAt).toUpperCase(), String.valueOf(charAt2).toUpperCase());
            }
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt3 = str.charAt(i3);
                if (charAt3 < 'A' || charAt3 > 'Z') {
                    if (charAt3 >= 'a') {
                        if (charAt3 > 'z') {
                        }
                    }
                    sb.append(charAt3);
                }
                sb.append((String) hashMap.get(String.valueOf(charAt3)));
            }
            return sb.toString();
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            return "";
        }
    }

    public String A() {
        return "AfdahTV";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03b5 A[Catch:{ Exception -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02da A[Catch:{ all -> 0x02e3, all -> 0x0416 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B(com.movie.data.model.MovieInfo r23, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r24) {
        /*
            r22 = this;
            r1 = r22
            r2 = r24
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = ""
            r7 = r4
            r6 = 0
        L_0x000a:
            java.lang.String r8 = "a[href]"
            java.lang.String r9 = " en-US,en;q=0.9,vi;q=0.8"
            java.lang.String r10 = "accept-language"
            java.lang.String r11 = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"
            java.lang.String r12 = "Accept"
            java.lang.String r13 = "Origin"
            java.lang.String r14 = "href"
            r15 = 2
            java.lang.String r5 = "/"
            r17 = r7
            r7 = 1
            if (r6 >= r15) goto L_0x016a
            java.lang.String r0 = r23.getName()
            java.lang.String r15 = ":"
            boolean r0 = r0.contains(r15)
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r23.getName()
            java.lang.String[] r0 = r0.split(r15)
            r15 = 0
            r0 = r0[r15]
            java.lang.String r0 = com.original.tase.helper.TitleHelper.e(r0)
            goto L_0x0044
        L_0x003c:
            java.lang.String r0 = r23.getName()
            java.lang.String r0 = com.original.tase.helper.TitleHelper.e(r0)
        L_0x0044:
            if (r6 != r7) goto L_0x005e
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r0)
            java.lang.String r0 = " "
            r15.append(r0)
            java.lang.Integer r0 = r23.getYear()
            r15.append(r0)
            java.lang.String r0 = r15.toString()
        L_0x005e:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r15.<init>()     // Catch:{ Exception -> 0x007c }
            r15.append(r0)     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = "|||title"
            r15.append(r0)     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x007c }
            java.lang.String r15 = "COVID-19"
            java.lang.String r0 = com.original.tase.helper.crypto.AES256Cryptor.d(r0, r15)     // Catch:{ Exception -> 0x007c }
            java.lang.String r15 = "\n"
            java.lang.String r0 = r0.replace(r15, r4)     // Catch:{ Exception -> 0x007c }
            goto L_0x0081
        L_0x007c:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
        L_0x0081:
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            java.lang.String r7 = "accept"
            java.lang.String r2 = "*/*"
            r15.put(r7, r2)
            java.lang.String r2 = r1.f37239e
            r15.put(r13, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = r1.f37239e
            r2.append(r7)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String r7 = "referer"
            r15.put(r7, r2)
            r15.put(r12, r11)
            r15.put(r10, r9)
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r18 = r3
            java.lang.String r3 = "process="
            r7.append(r3)
            r19 = r4
            r3 = 0
            boolean[] r4 = new boolean[r3]
            java.lang.String r0 = com.original.tase.utils.Utils.k(r0, r4)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r4 = 1
            java.util.Map[] r7 = new java.util.Map[r4]
            r7[r3] = r15
            java.lang.String r3 = "https://search.afdah.info/"
            java.lang.String r0 = r2.l(r3, r0, r7)
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r0)
            java.lang.String r2 = "li"
            org.jsoup.select.Elements r0 = r0.q0(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x00e7:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x015a
            java.lang.Object r2 = r0.next()
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            org.jsoup.nodes.Element r2 = r2.r0(r8)
            if (r2 == 0) goto L_0x00e7
            java.lang.String r3 = r2.c(r14)
            java.lang.String r2 = r2.v0()
            java.lang.String r4 = "(.+?)\\s+\\((\\d{4})\\)"
            r7 = 1
            java.lang.String r15 = com.original.tase.utils.Regex.a(r2, r4, r7)
            r7 = 2
            java.lang.String r4 = com.original.tase.utils.Regex.a(r2, r4, r7)
            boolean r7 = r15.isEmpty()
            if (r7 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r2 = r15
        L_0x0115:
            java.lang.String r7 = r23.getName()
            java.lang.String r7 = com.original.tase.helper.TitleHelper.f(r7)
            java.lang.String r2 = com.original.tase.helper.TitleHelper.f(r2)
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x00e7
            java.lang.String r2 = r4.trim()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0157
            java.lang.String r2 = r4.trim()
            boolean r2 = com.original.tase.utils.Utils.o(r2)
            if (r2 == 0) goto L_0x0157
            java.lang.Integer r2 = r23.getYear()
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x0157
            java.lang.String r2 = r4.trim()
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r4 = r23.getYear()
            int r4 = r4.intValue()
            if (r2 != r4) goto L_0x00e7
        L_0x0157:
            r7 = r3
            r0 = 1
            goto L_0x015d
        L_0x015a:
            r7 = r17
            r0 = 0
        L_0x015d:
            if (r0 == 0) goto L_0x0160
            goto L_0x0170
        L_0x0160:
            int r6 = r6 + 1
            r2 = r24
            r3 = r18
            r4 = r19
            goto L_0x000a
        L_0x016a:
            r18 = r3
            r19 = r4
            r7 = r17
        L_0x0170:
            r7.isEmpty()
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x017a
            return
        L_0x017a:
            boolean r0 = r7.startsWith(r5)
            if (r0 == 0) goto L_0x0191
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.f37239e
            r0.append(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x0191:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r0 = r1.f37239e
            r2.put(r13, r0)
            r2.put(r12, r11)
            r2.put(r10, r9)
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r3 = 0
            java.util.Map[] r4 = new java.util.Map[r3]
            java.lang.String r3 = r0.m(r7, r4)
            java.lang.String r0 = "(This movie is of poor quality)"
            r4 = 34
            r6 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.b(r3, r0, r6, r4)
            boolean r0 = r0.isEmpty()
            r7 = r0 ^ 1
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r3)
            java.lang.String r6 = "div.tabContent[id*=cont_]"
            org.jsoup.select.Elements r0 = r0.q0(r6)
            org.jsoup.select.Elements r0 = r0.g(r8)
            java.util.Iterator r6 = r0.iterator()
        L_0x01cd:
            boolean r0 = r6.hasNext()
            java.lang.String r8 = "HQ"
            if (r0 == 0) goto L_0x043d
            java.lang.Object r0 = r6.next()
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r0 = r0.c(r14)
            java.lang.String r9 = "trailer"
            boolean r9 = r0.contains(r9)
            if (r9 != 0) goto L_0x0433
            java.lang.String r9 = "embed"
            boolean r9 = r0.contains(r9)
            if (r9 != 0) goto L_0x01f0
            goto L_0x01cd
        L_0x01f0:
            boolean r9 = r0.startsWith(r5)
            if (r9 == 0) goto L_0x0207
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r1.f37239e
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
        L_0x0207:
            r9 = r0
            java.lang.String r0 = "Referer"
            r2.put(r0, r9)
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            r10 = 1
            java.util.Map[] r11 = new java.util.Map[r10]
            r12 = 0
            r11[r12] = r2
            java.lang.String r13 = "play=continue&x=0&y=0"
            java.lang.String r0 = r0.q(r9, r13, r10, r11)
            java.lang.String r11 = "Image Verification"
            boolean r11 = r0.contains(r11)
            if (r11 == 0) goto L_0x0233
            com.original.tase.helper.http.HttpHelper r0 = com.original.tase.helper.http.HttpHelper.i()
            java.util.Map[] r11 = new java.util.Map[r10]
            r11[r12] = r2
            java.lang.String r13 = "play=continue&x=352&y=188"
            java.lang.String r0 = r0.q(r9, r13, r10, r11)
        L_0x0233:
            java.lang.String r11 = "ajax\\s*\\(\\s*\\{\\s*url\\s*:\\s*['\"](.*?)['\"]"
            java.util.ArrayList r11 = com.original.tase.utils.Regex.f(r0, r11, r10, r10)
            java.lang.Object r10 = r11.get(r12)
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0243:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x025a
            com.original.tase.helper.http.HttpHelper r11 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            java.util.Map[] r15 = new java.util.Map[r12]
            r11.m(r13, r15)
            r12 = 0
            goto L_0x0243
        L_0x025a:
            java.lang.String r10 = "salt\\(\"([^\"]+)"
            r11 = 1
            java.lang.String r10 = com.original.tase.utils.Regex.b(r0, r10, r11, r4)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x026d
            java.lang.String r10 = "tlas\\(\"([^\"]+)"
            java.lang.String r10 = com.original.tase.utils.Regex.b(r0, r10, r11, r4)
        L_0x026d:
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x0279
            java.lang.String r10 = "decrypt\\(\"([^\"]+)"
            java.lang.String r10 = com.original.tase.utils.Regex.b(r0, r10, r11, r4)
        L_0x0279:
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L_0x041b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b4 }
            r0.<init>()     // Catch:{ Exception -> 0x02b4 }
            r11 = r19
            r0.append(r11)     // Catch:{ Exception -> 0x02b1 }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x02b1 }
            java.lang.String r13 = new java.lang.String     // Catch:{ Exception -> 0x02b1 }
            r15 = 0
            byte[] r4 = android.util.Base64.decode(r10, r15)     // Catch:{ Exception -> 0x02b1 }
            r15 = r18
            r13.<init>(r4, r15)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r4 = r1.J(r13)     // Catch:{ Exception -> 0x02b8 }
            r13 = 0
            byte[] r4 = android.util.Base64.decode(r4, r13)     // Catch:{ Exception -> 0x02b8 }
            r12.<init>(r4, r15)     // Catch:{ Exception -> 0x02b8 }
            r0.append(r12)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r4 = "\n\n"
            r0.append(r4)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02b8 }
            r4 = r0
            goto L_0x02ba
        L_0x02b1:
            r15 = r18
            goto L_0x02b8
        L_0x02b4:
            r15 = r18
            r11 = r19
        L_0x02b8:
            r4 = r11
        L_0x02ba:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x02c8
            java.lang.String r0 = "player"
            boolean r0 = r4.contains(r0)
            if (r0 != 0) goto L_0x02e1
        L_0x02c8:
            java.lang.String r0 = "for(var getFStr,getFCount,END_OF_INPUT=-1,arrChrs=new Array(\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\",\"H\",\"I\",\"J\",\"K\",\"L\",\"M\",\"N\",\"O\",\"P\",\"Q\",\"R\",\"S\",\"T\",\"U\",\"V\",\"W\",\"X\",\"Y\",\"Z\",\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\",\"k\",\"l\",\"m\",\"n\",\"o\",\"p\",\"q\",\"r\",\"s\",\"t\",\"u\",\"v\",\"w\",\"x\",\"y\",\"z\",\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"+\",\"/\"),reversegetFChars=new Array,i=0;i<arrChrs.length;i++)reversegetFChars[arrChrs[i]]=i;function ntos(r){return 1==(r=r.toString(16)).length&&(r=\"0\"+r),r=\"%\"+r,unescape(r)}function readReversegetF(){if(!getFStr)return END_OF_INPUT;for(;;){if(getFCount>=getFStr.length)return END_OF_INPUT;var r=getFStr.charAt(getFCount);if(getFCount++,reversegetFChars[r])return reversegetFChars[r];if(\"A\"==r)return 0}return END_OF_INPUT}function readgetF(){if(!getFStr)return END_OF_INPUT;if(getFCount>=getFStr.length)return END_OF_INPUT;var r=255&getFStr.charCodeAt(getFCount);return getFCount++,r}function setgetFStr(r){getFStr=r,getFCount=0}function getF(r){setgetFStr(r);for(var e=\"\",t=new Array(4),n=!1;!n&&(t[0]=readReversegetF())!=END_OF_INPUT&&(t[1]=readReversegetF())!=END_OF_INPUT;)t[2]=readReversegetF(),t[3]=readReversegetF(),e+=ntos(t[0]<<2&255|t[1]>>4),t[2]!=END_OF_INPUT?(e+=ntos(t[1]<<4&255|t[2]>>2),t[3]!=END_OF_INPUT?e+=ntos(t[2]<<6&255|t[3]):n=!0):n=!0;return e}function tor(r){var e=[],t=\"abcdefghijklmnopqrstuvwxyz\",n=\"\";for(j=0;j<t.length;j++){var F=t.charAt(j),g=t.charAt((j+13)%26);e[F]=g,e[F.toUpperCase()]=g.toUpperCase()}for(j=0;j<r.length;j++){var a=r.charAt(j);n+=\"A\"<=a&&a<=\"Z\"||\"a\"<=a&&a<=\"z\"?e[a]:a}return n}function acb(){return tor(getF(tor(\"####\")))}acb();"
            java.lang.String r12 = "####"
            java.lang.String r0 = r0.replace(r12, r10)
            com.squareup.duktape.Duktape r10 = com.squareup.duktape.Duktape.create()
            java.lang.Object r0 = r10.evaluate(r0)     // Catch:{ all -> 0x02e3 }
            if (r0 == 0) goto L_0x02de
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x02e3 }
        L_0x02de:
            r10.close()
        L_0x02e1:
            r12 = 0
            goto L_0x02ed
        L_0x02e3:
            r0 = move-exception
            r12 = 0
            boolean[] r13 = new boolean[r12]     // Catch:{ all -> 0x0416 }
            com.original.tase.Logger.d(r0, r13)     // Catch:{ all -> 0x0416 }
            r10.close()
        L_0x02ed:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x040b
            java.lang.String r0 = "\\{\\s*['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]\\s*,\\s*.*?['\"]?label['\"]?\\s*:\\s*['\"]?(\\d{3,4})p"
            r10 = 34
            r13 = 2
            java.util.ArrayList r0 = com.original.tase.utils.Regex.e(r4, r0, r13, r10)
            java.lang.Object r16 = r0.get(r12)
            r13 = r16
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            r12 = 1
            java.lang.Object r0 = r0.get(r12)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r23 = r2
            java.lang.String r2 = "\\{\\s*['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+\\.m3u8[^'\"]*)['\"]\\s*"
            java.util.ArrayList r2 = com.original.tase.utils.Regex.e(r4, r2, r12, r10)
            r10 = 0
            java.lang.Object r2 = r2.get(r10)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.String r10 = "src\\s*=\\s*[\"']([^\"']+)"
            java.lang.String r4 = com.original.tase.utils.Regex.a(r4, r10, r12)
            r10 = 0
        L_0x0321:
            int r12 = r2.size()
            r18 = r6
            java.lang.String r6 = "HD"
            if (r10 >= r12) goto L_0x033c
            java.lang.Object r12 = r2.get(r10)
            java.lang.String r12 = (java.lang.String) r12
            r13.add(r12)
            r0.add(r6)
            int r10 = r10 + 1
            r6 = r18
            goto L_0x0321
        L_0x033c:
            boolean r2 = r4.isEmpty()
            if (r2 != 0) goto L_0x034e
            r2 = 1
            boolean[] r10 = new boolean[r2]
            r2 = 0
            r10[r2] = r7
            r2 = r24
            r1.z(r2, r4, r8, r10)
            goto L_0x0350
        L_0x034e:
            r2 = r24
        L_0x0350:
            r4 = 0
        L_0x0351:
            int r8 = r13.size()
            if (r4 >= r8) goto L_0x0408
            java.lang.Object r8 = r13.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            boolean r10 = r8.startsWith(r5)
            if (r10 == 0) goto L_0x0374
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r1.f37239e
            r10.append(r12)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
        L_0x0374:
            java.lang.Object r10 = r0.get(r4)     // Catch:{ Exception -> 0x03f9 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x03f9 }
            boolean r12 = r10.isEmpty()     // Catch:{ Exception -> 0x03f9 }
            if (r12 != 0) goto L_0x0381
            goto L_0x0382
        L_0x0381:
            r10 = r6
        L_0x0382:
            java.lang.String r12 = "hsl"
            boolean r12 = r8.contains(r12)     // Catch:{ Exception -> 0x03f9 }
            if (r12 != 0) goto L_0x03a2
            java.lang.String r12 = "m3u8"
            boolean r12 = r8.contains(r12)     // Catch:{ Exception -> 0x039f }
            if (r12 == 0) goto L_0x0393
            goto L_0x03a2
        L_0x0393:
            com.original.tase.helper.http.HttpHelper r12 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ Exception -> 0x039f }
            r19 = r5
            r5 = 0
            java.lang.String r12 = r12.s(r8, r5, r9)     // Catch:{ Exception -> 0x03f4 }
            goto L_0x03a5
        L_0x039f:
            r19 = r5
            goto L_0x03f4
        L_0x03a2:
            r19 = r5
            r12 = r8
        L_0x03a5:
            java.lang.String r5 = "http 111"
            com.original.tase.Logger.b(r5, r8)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r5 = "http 222"
            com.original.tase.Logger.b(r5, r12)     // Catch:{ Exception -> 0x03f4 }
            boolean r5 = r12.isEmpty()     // Catch:{ Exception -> 0x03f4 }
            if (r5 != 0) goto L_0x03f4
            boolean r5 = com.original.tase.helper.GoogleVideoHelper.n(r12)     // Catch:{ Exception -> 0x03f4 }
            com.original.tase.model.media.MediaSource r8 = new com.original.tase.model.media.MediaSource     // Catch:{ Exception -> 0x03f4 }
            if (r7 == 0) goto L_0x03d7
            r20 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03f6 }
            r0.<init>()     // Catch:{ Exception -> 0x03f6 }
            r21 = r6
            java.lang.String r6 = r22.A()     // Catch:{ Exception -> 0x03fe }
            r0.append(r6)     // Catch:{ Exception -> 0x03fe }
            java.lang.String r6 = " (CAM)"
            r0.append(r6)     // Catch:{ Exception -> 0x03fe }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03fe }
            goto L_0x03df
        L_0x03d7:
            r20 = r0
            r21 = r6
            java.lang.String r0 = r22.A()     // Catch:{ Exception -> 0x03fe }
        L_0x03df:
            if (r5 == 0) goto L_0x03e4
            java.lang.String r5 = "GoogleVideo"
            goto L_0x03e6
        L_0x03e4:
            java.lang.String r5 = "CDN-FastServer"
        L_0x03e6:
            r6 = 0
            r8.<init>(r0, r5, r6)     // Catch:{ Exception -> 0x03fe }
            r8.setStreamLink(r12)     // Catch:{ Exception -> 0x03fe }
            r8.setQuality((java.lang.String) r10)     // Catch:{ Exception -> 0x03fe }
            r2.onNext(r8)     // Catch:{ Exception -> 0x03fe }
            goto L_0x03fe
        L_0x03f4:
            r20 = r0
        L_0x03f6:
            r21 = r6
            goto L_0x03fe
        L_0x03f9:
            r20 = r0
            r19 = r5
            goto L_0x03f6
        L_0x03fe:
            int r4 = r4 + 1
            r5 = r19
            r0 = r20
            r6 = r21
            goto L_0x0351
        L_0x0408:
            r19 = r5
            goto L_0x0413
        L_0x040b:
            r23 = r2
            r19 = r5
            r18 = r6
            r2 = r24
        L_0x0413:
            r4 = 34
            goto L_0x0427
        L_0x0416:
            r0 = move-exception
            r10.close()
            throw r0
        L_0x041b:
            r23 = r2
            r15 = r18
            r11 = r19
            r2 = r24
            r19 = r5
            r18 = r6
        L_0x0427:
            r2 = r23
            r6 = r18
            r5 = r19
            r19 = r11
            r18 = r15
            goto L_0x01cd
        L_0x0433:
            r23 = r2
            r15 = r18
            r2 = r24
            r2 = r23
            goto L_0x01cd
        L_0x043d:
            r2 = r24
            org.jsoup.nodes.Document r0 = org.jsoup.Jsoup.b(r3)
            java.lang.String r3 = "table"
            org.jsoup.select.Elements r0 = r0.q0(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x044d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x049a
            java.lang.Object r3 = r0.next()
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r4 = "a[href][target=\"_blank\"]"
            org.jsoup.select.Elements r3 = r3.q0(r4)
            java.util.Iterator r3 = r3.iterator()
        L_0x0463:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x044d
            java.lang.Object r4 = r3.next()
            org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
            java.lang.String r4 = r4.c(r14)
            java.lang.String r5 = "http"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0497
            java.lang.String r5 = "((?:http|https)://)"
            r6 = 1
            java.util.ArrayList r5 = com.original.tase.utils.Regex.f(r4, r5, r6, r6)
            r9 = 0
            java.lang.Object r5 = r5.get(r9)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
            if (r5 > r6) goto L_0x0463
            boolean[] r5 = new boolean[r6]
            r5[r9] = r7
            r1.z(r2, r4, r8, r5)
            goto L_0x0463
        L_0x0497:
            r6 = 1
            r9 = 0
            goto L_0x0463
        L_0x049a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.AfdahTV.B(com.movie.data.model.MovieInfo, io.reactivex.ObservableEmitter):void");
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}
