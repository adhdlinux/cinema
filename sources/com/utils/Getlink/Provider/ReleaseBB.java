package com.utils.Getlink.Provider;

import com.facebook.ads.internal.c.a;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReleaseBB extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private static String f37415e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f37416f;

    /* renamed from: g  reason: collision with root package name */
    public static String f37417g = null;

    static {
        String provider = Utils.getProvider(95);
        f37415e = provider;
        f37416f = provider.replace("http://", "").replace("https://", "").replace("/", "");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0334, code lost:
        if (r1.toLowerCase().equals(r29.toLowerCase()) == false) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a0, code lost:
        if (com.original.tase.helper.TitleHelper.f(r11.replaceAll("(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)", "$1$3$4")).startsWith(com.original.tase.helper.TitleHelper.f(r27.getName() + r29.toLowerCase())) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r9v1, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0117 A[ADDED_TO_REGION, Catch:{ all -> 0x017d, all -> 0x03f4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean J(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r24, java.lang.String r25, java.lang.Object r26, com.movie.data.model.MovieInfo r27, java.lang.String r28, java.lang.String r29, com.original.tase.helper.DirectoryIndexHelper r30) {
        /*
            r23 = this;
            r1 = r27
            r2 = r30
            java.lang.String r3 = "1080p"
            java.lang.String r4 = "http://"
            java.lang.String r5 = "/"
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r9 = 0
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ all -> 0x03f4 }
            r0.<init>()     // Catch:{ all -> 0x03f4 }
            r10 = r25
            com.google.gson.JsonElement r0 = r0.a(r10)     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ all -> 0x03f4 }
            java.lang.String r10 = "results"
            com.google.gson.JsonElement r0 = r0.m(r10)     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonArray r0 = r0.b()     // Catch:{ all -> 0x03f4 }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ all -> 0x03f4 }
        L_0x0032:
            boolean r0 = r10.hasNext()     // Catch:{ all -> 0x03f4 }
            if (r0 == 0) goto L_0x03fb
            java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonElement r0 = (com.google.gson.JsonElement) r0     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonObject r11 = r0.c()     // Catch:{ all -> 0x03f4 }
            java.lang.String r12 = "post_title"
            com.google.gson.JsonElement r11 = r11.m(r12)     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = r11.e()     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonObject r12 = r0.c()     // Catch:{ all -> 0x03f4 }
            java.lang.String r13 = "post_name"
            com.google.gson.JsonElement r12 = r12.m(r13)     // Catch:{ all -> 0x03f4 }
            java.lang.String r12 = r12.e()     // Catch:{ all -> 0x03f4 }
            com.google.gson.JsonObject r0 = r0.c()     // Catch:{ all -> 0x03f4 }
            java.lang.String r13 = "domain"
            com.google.gson.JsonElement r0 = r0.m(r13)     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x03f4 }
            boolean r13 = r6.contains(r12)     // Catch:{ all -> 0x03f4 }
            if (r13 != 0) goto L_0x03eb
            r6.add(r12)     // Catch:{ all -> 0x03f4 }
            java.lang.String r13 = ""
            if (r26 == 0) goto L_0x00a4
            java.lang.String r14 = "(?i)(.*)([2-9]0\\d{2}|1[5-9]\\d{2})\\s+(S\\d+\\s*E\\d+)(.*)"
            java.lang.String r15 = "$1$3$4"
            java.lang.String r11 = r11.replaceAll(r14, r15)     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.f(r11)     // Catch:{ all -> 0x03f4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r14.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r15 = r27.getName()     // Catch:{ all -> 0x03f4 }
            r14.append(r15)     // Catch:{ all -> 0x03f4 }
            java.lang.String r15 = r29.toLowerCase()     // Catch:{ all -> 0x03f4 }
            r14.append(r15)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = com.original.tase.helper.TitleHelper.f(r14)     // Catch:{ all -> 0x03f4 }
            boolean r11 = r11.startsWith(r14)     // Catch:{ all -> 0x03f4 }
            if (r11 == 0) goto L_0x0113
        L_0x00a2:
            r8 = 1
            goto L_0x0114
        L_0x00a4:
            java.lang.String r14 = r11.toLowerCase()     // Catch:{ all -> 0x03f4 }
            java.lang.String r15 = r1.year     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r14.replace(r15, r13)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = com.original.tase.helper.TitleHelper.h(r14, r13)     // Catch:{ all -> 0x03f4 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r15.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r16 = r27.getName()     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = r16.toLowerCase()     // Catch:{ all -> 0x03f4 }
            r15.append(r8)     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = r29.toLowerCase()     // Catch:{ all -> 0x03f4 }
            r15.append(r8)     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = r15.toString()     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = com.original.tase.helper.TitleHelper.h(r8, r13)     // Catch:{ all -> 0x03f4 }
            boolean r8 = r14.startsWith(r8)     // Catch:{ all -> 0x03f4 }
            if (r8 == 0) goto L_0x00d8
            goto L_0x00a2
        L_0x00d8:
            java.lang.String r8 = r11.toLowerCase()     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = com.original.tase.helper.TitleHelper.h(r8, r13)     // Catch:{ all -> 0x03f4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r11.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r27.getName()     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x03f4 }
            r11.append(r14)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = "s"
            r11.append(r14)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r1.session     // Catch:{ all -> 0x03f4 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = com.original.tase.utils.Utils.i(r14)     // Catch:{ all -> 0x03f4 }
            r11.append(r14)     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = com.original.tase.helper.TitleHelper.h(r11, r13)     // Catch:{ all -> 0x03f4 }
            boolean r8 = r8.startsWith(r11)     // Catch:{ all -> 0x03f4 }
            if (r8 == 0) goto L_0x0113
            r8 = 1
            r11 = 1
            goto L_0x0115
        L_0x0113:
            r8 = 0
        L_0x0114:
            r11 = 0
        L_0x0115:
            if (r8 == 0) goto L_0x03eb
            if (r0 == 0) goto L_0x0127
            boolean r8 = r0.isEmpty()     // Catch:{ all -> 0x03f4 }
            if (r8 != 0) goto L_0x0127
            java.lang.String r8 = ".unblockit."
            boolean r8 = r0.contains(r8)     // Catch:{ all -> 0x03f4 }
            if (r8 == 0) goto L_0x0129
        L_0x0127:
            java.lang.String r0 = "rlsbb.ru"
        L_0x0129:
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()     // Catch:{ all -> 0x03f4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r14.<init>()     // Catch:{ all -> 0x03f4 }
            r14.append(r4)     // Catch:{ all -> 0x03f4 }
            r14.append(r0)     // Catch:{ all -> 0x03f4 }
            r14.append(r5)     // Catch:{ all -> 0x03f4 }
            r14.append(r12)     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = r14.toString()     // Catch:{ all -> 0x03f4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f4 }
            r14.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r15 = "http://search.rlsbb.ru/search/"
            r14.append(r15)     // Catch:{ all -> 0x03f4 }
            r15 = r28
            r14.append(r15)     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03f4 }
            java.util.Map[] r1 = new java.util.Map[r9]     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = r8.r(r0, r14, r1)     // Catch:{ all -> 0x03f4 }
            java.lang.String r1 = "Checking your browser before accessin"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03f4 }
            if (r1 == 0) goto L_0x0164
            return r9
        L_0x0164:
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r0)     // Catch:{ all -> 0x03f4 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x03f4 }
            r8.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = "div.post[id]"
            org.jsoup.nodes.Element r0 = r1.r0(r0)     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x0183
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017d }
            r8.add(r0)     // Catch:{ all -> 0x017d }
            goto L_0x0183
        L_0x017d:
            r0 = move-exception
            boolean[] r14 = new boolean[r9]     // Catch:{ all -> 0x03f4 }
            com.original.tase.Logger.d(r0, r14)     // Catch:{ all -> 0x03f4 }
        L_0x0183:
            java.lang.String r0 = "div.messageBox"
            org.jsoup.select.Elements r0 = r1.q0(r0)     // Catch:{ all -> 0x03f4 }
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x03f4 }
        L_0x018d:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x03f4 }
            if (r0 == 0) goto L_0x01a8
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x01a1 }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ all -> 0x01a1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01a1 }
            r8.add(r0)     // Catch:{ all -> 0x01a1 }
            goto L_0x018d
        L_0x01a1:
            r0 = move-exception
            boolean[] r14 = new boolean[r9]     // Catch:{ all -> 0x03f4 }
            com.original.tase.Logger.d(r0, r14)     // Catch:{ all -> 0x03f4 }
            goto L_0x018d
        L_0x01a8:
            java.util.Iterator r1 = r8.iterator()     // Catch:{ all -> 0x03f4 }
        L_0x01ac:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x03f4 }
            if (r0 == 0) goto L_0x03ed
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = "\\/"
            java.lang.String r0 = r0.replace(r8, r5)     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = "\\\""
            java.lang.String r14 = "\""
            java.lang.String r0 = r0.replace(r8, r14)     // Catch:{ all -> 0x03f4 }
            java.lang.String r8 = "<a[^<]*href=['\"](.*?)['\"].*?</a>"
            r14 = 1
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r8, r14, r14)     // Catch:{ all -> 0x03f4 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x03f4 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x03f4 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x03f4 }
        L_0x01d7:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x03f4 }
            if (r0 == 0) goto L_0x03e7
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x03f4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03f4 }
            java.lang.String r14 = r0.replace(r4, r13)     // Catch:{ all -> 0x03ce }
            java.lang.String r9 = "https://"
            java.lang.String r9 = r14.replace(r9, r13)     // Catch:{ all -> 0x03ce }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ce }
            r14.<init>()     // Catch:{ all -> 0x03ce }
            r25 = r1
            java.lang.String r1 = f37416f     // Catch:{ all -> 0x03cc }
            r14.append(r1)     // Catch:{ all -> 0x03cc }
            r14.append(r5)     // Catch:{ all -> 0x03cc }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03cc }
            boolean r14 = r9.contains(r14)     // Catch:{ all -> 0x03cc }
            if (r14 != 0) goto L_0x03de
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cc }
            r14.<init>()     // Catch:{ all -> 0x03cc }
            r14.append(r5)     // Catch:{ all -> 0x03cc }
            r14.append(r1)     // Catch:{ all -> 0x03cc }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x03cc }
            boolean r1 = r9.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "#"
            boolean r1 = r0.startsWith(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "thepiratebay.org"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "protected.to"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "histats.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "opensubtitles.org"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "facebook.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "twitter.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "amazon.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "youtube.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "youtu.be"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "imgaa.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "imdb.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "tvguide.com"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".7z"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".png"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".rar"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".zip"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".iso"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".part"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".avi"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".flv"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".pdf"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "file-upload."
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = ".mp3"
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            java.lang.String r1 = "imdb."
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            boolean r1 = r7.contains(r0)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03de
            if (r11 == 0) goto L_0x0319
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ all -> 0x03cc }
            java.lang.String r1 = com.original.tase.helper.TitleHelper.h(r1, r13)     // Catch:{ all -> 0x03cc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cc }
            r9.<init>()     // Catch:{ all -> 0x03cc }
            java.lang.String r14 = r27.getName()     // Catch:{ all -> 0x03cc }
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x03cc }
            r9.append(r14)     // Catch:{ all -> 0x03cc }
            java.lang.String r14 = r29.toLowerCase()     // Catch:{ all -> 0x03cc }
            r9.append(r14)     // Catch:{ all -> 0x03cc }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x03cc }
            java.lang.String r9 = com.original.tase.helper.TitleHelper.h(r9, r13)     // Catch:{ all -> 0x03cc }
            boolean r1 = r1.contains(r9)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x0319
            goto L_0x0336
        L_0x0319:
            if (r26 != 0) goto L_0x033a
            java.lang.String r1 = "([s|S]\\d+[e|E]\\d+)"
            r9 = 1
            java.lang.String r1 = com.original.tase.utils.Regex.a(r0, r1, r9)     // Catch:{ all -> 0x03cc }
            boolean r9 = r1.isEmpty()     // Catch:{ all -> 0x03cc }
            if (r9 != 0) goto L_0x033a
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x03cc }
            java.lang.String r9 = r29.toLowerCase()     // Catch:{ all -> 0x03cc }
            boolean r1 = r1.equals(r9)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x033a
        L_0x0336:
            r1 = r25
            goto L_0x03e2
        L_0x033a:
            r7.add(r0)     // Catch:{ all -> 0x03cc }
            java.lang.String r1 = r23.A()     // Catch:{ all -> 0x03cc }
            if (r26 == 0) goto L_0x0348
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r9 = r2.c(r0)     // Catch:{ all -> 0x03cc }
            goto L_0x034c
        L_0x0348:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r9 = r2.d(r0)     // Catch:{ all -> 0x03cc }
        L_0x034c:
            java.lang.String r14 = "HQ"
            if (r9 == 0) goto L_0x036a
            java.lang.String r1 = r9.c()     // Catch:{ all -> 0x0365 }
            java.lang.String r9 = r9.b()     // Catch:{ all -> 0x0365 }
            r17 = r1
            r1 = r23
            java.lang.String r9 = r1.t(r9)     // Catch:{ all -> 0x03cc }
            r21 = r9
            r9 = r17
            goto L_0x0370
        L_0x0365:
            r0 = move-exception
            r1 = r23
            goto L_0x03d1
        L_0x036a:
            r9 = r1
            r1 = r23
            r21 = r9
            r9 = r14
        L_0x0370:
            boolean r17 = r9.equalsIgnoreCase(r14)     // Catch:{ all -> 0x03cc }
            if (r17 == 0) goto L_0x0393
            if (r26 == 0) goto L_0x037b
            r17 = r12
            goto L_0x037d
        L_0x037b:
            r17 = r0
        L_0x037d:
            java.lang.String r1 = r17.toLowerCase()     // Catch:{ all -> 0x03cc }
            boolean r17 = r1.contains(r3)     // Catch:{ all -> 0x03cc }
            if (r17 == 0) goto L_0x0389
            r9 = r3
            goto L_0x0393
        L_0x0389:
            java.lang.String r2 = "720p"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x03cc }
            if (r1 == 0) goto L_0x0393
            java.lang.String r9 = "HD"
        L_0x0393:
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ all -> 0x03cc }
            java.lang.String r2 = "vidzi."
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03bb
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ all -> 0x03cc }
            java.lang.String r2 = "estream."
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x03cc }
            if (r1 != 0) goto L_0x03bb
            java.lang.String r1 = r0.toLowerCase()     // Catch:{ all -> 0x03cc }
            java.lang.String r2 = ".m3u8"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x03cc }
            if (r1 == 0) goto L_0x03b8
            goto L_0x03bb
        L_0x03b8:
            r20 = r9
            goto L_0x03bd
        L_0x03bb:
            r20 = r14
        L_0x03bd:
            r1 = 0
            boolean[] r2 = new boolean[r1]     // Catch:{ all -> 0x03cc }
            r17 = r23
            r18 = r24
            r19 = r0
            r22 = r2
            r17.x(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x03cc }
            goto L_0x03de
        L_0x03cc:
            r0 = move-exception
            goto L_0x03d1
        L_0x03ce:
            r0 = move-exception
            r25 = r1
        L_0x03d1:
            r1 = 0
            boolean[] r2 = new boolean[r1]     // Catch:{ all -> 0x03d8 }
            com.original.tase.Logger.d(r0, r2)     // Catch:{ all -> 0x03d8 }
            goto L_0x03de
        L_0x03d8:
            r0 = move-exception
            boolean[] r2 = new boolean[r1]     // Catch:{ all -> 0x03e5 }
            com.original.tase.Logger.d(r0, r2)     // Catch:{ all -> 0x03f4 }
        L_0x03de:
            r1 = r25
            r2 = r30
        L_0x03e2:
            r9 = 0
            goto L_0x01d7
        L_0x03e5:
            r0 = move-exception
            goto L_0x03f6
        L_0x03e7:
            r2 = r30
            goto L_0x01ac
        L_0x03eb:
            r15 = r28
        L_0x03ed:
            r1 = r27
            r2 = r30
            r9 = 0
            goto L_0x0032
        L_0x03f4:
            r0 = move-exception
            r1 = 0
        L_0x03f6:
            boolean[] r1 = new boolean[r1]
            com.original.tase.Logger.d(r0, r1)
        L_0x03fb:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.ReleaseBB.J(io.reactivex.ObservableEmitter, java.lang.String, java.lang.Object, com.movie.data.model.MovieInfo, java.lang.String, java.lang.String, com.original.tase.helper.DirectoryIndexHelper):boolean");
    }

    private boolean K(ObservableEmitter<? super MediaSource> observableEmitter, Map<String, String> map, DirectoryIndexHelper directoryIndexHelper, String str, boolean z2) {
        DirectoryIndexHelper.ParsedLinkModel parsedLinkModel;
        DirectoryIndexHelper directoryIndexHelper2 = directoryIndexHelper;
        if (!map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    String str2 = (String) next.getKey();
                    HttpHelper i2 = HttpHelper.i();
                    String o2 = i2.o((String) next.getKey(), f37415e + "/");
                    if (o2.contains("Checking your browser before accessin")) {
                        return false;
                    }
                    Document b2 = Jsoup.b(o2);
                    ArrayList<String> arrayList = new ArrayList<>();
                    try {
                        Element r02 = b2.r0("div.post[id]");
                        if (r02 != null) {
                            arrayList.add(r02.toString());
                        }
                    } catch (Throwable th) {
                        Logger.d(th, new boolean[0]);
                    }
                    Iterator it2 = b2.q0("div.messageBox").iterator();
                    while (it2.hasNext()) {
                        try {
                            arrayList.add(((Element) it2.next()).toString());
                        } catch (Throwable th2) {
                            Logger.d(th2, new boolean[0]);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String replace : arrayList) {
                        Iterator it3 = Regex.f(replace.replace("\\/", "/").replace("\\\"", "\""), "<a[^<]*href=['\"](.*?)['\"].*?</a>", 1, true).get(0).iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                String str3 = (String) it3.next();
                                String replace2 = str3.replace("http://", "").replace("https://", "");
                                StringBuilder sb = new StringBuilder();
                                String str4 = f37416f;
                                sb.append(str4);
                                sb.append("/");
                                if (!replace2.contains(sb.toString())) {
                                    if (!replace2.contains("/" + str4) && !str3.startsWith("#") && !str3.contains("thepiratebay.org") && !str3.contains("protected.to") && !str3.contains("histats.com") && !str3.contains("opensubtitles.org") && !str3.contains("facebook.com") && !str3.contains("twitter.com") && !str3.contains("amazon.com") && !str3.contains("youtube.com") && !str3.contains("youtu.be") && !str3.contains("imgaa.com") && !str3.contains("imdb.com") && !str3.contains("tvguide.com") && !str3.contains(".7z") && !str3.contains(".png") && !str3.contains(".rar") && !str3.contains(".zip") && !str3.contains(".iso") && !str3.contains(".part") && !str3.contains(".avi") && !str3.contains(".flv") && !str3.contains(".pdf") && !str3.contains("file-upload.") && !str3.contains(".mp3") && !str3.contains("imdb.") && !arrayList2.contains(str3)) {
                                        if (!z2) {
                                            String a2 = Regex.a(str3, "([s|S]\\d+[e|E]\\d+)", 1);
                                            if (!a2.isEmpty() && !a2.toLowerCase().equals(str.toLowerCase())) {
                                            }
                                        }
                                        if (observableEmitter.isDisposed()) {
                                            return true;
                                        }
                                        arrayList2.add(str3);
                                        String A = A();
                                        if (z2) {
                                            parsedLinkModel = directoryIndexHelper2.c(str3);
                                        } else {
                                            parsedLinkModel = directoryIndexHelper2.d(str3);
                                        }
                                        String str5 = "HQ";
                                        if (parsedLinkModel != null) {
                                            try {
                                                String c2 = parsedLinkModel.c();
                                                if (!c2.equalsIgnoreCase(str5)) {
                                                    str5 = c2;
                                                }
                                                A = t(parsedLinkModel.b());
                                            } catch (Exception e2) {
                                                e = e2;
                                                Logger.d(e, new boolean[0]);
                                            }
                                        }
                                        String str6 = str5;
                                        x(observableEmitter, str3, str6, A, new boolean[0]);
                                    }
                                }
                            }
                        }
                    }
                    continue;
                } catch (Exception e3) {
                    e = e3;
                    Logger.d(e, new boolean[0]);
                }
            }
        }
        return true;
    }

    public static void L() {
        HttpHelper i2 = HttpHelper.i();
        String m2 = i2.m(Constants.E + "provider/rls##forceNoCache##", new Map[0]);
        String a2 = Regex.a(m2, "['\"]Key['\"]:['\"]([^'\"]+)['\"]", 1);
        String a3 = Regex.a(m2, "['\"]search['\"]:['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            f37415e = a2;
        }
        if (!a3.isEmpty()) {
            f37417g = a3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M(io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r25, com.movie.data.model.MovieInfo r26, java.lang.String r27, java.lang.String r28) {
        /*
            r24 = this;
            r9 = r24
            r0 = r26
            r10 = r27
            r11 = r28
            java.lang.String r12 = "1080p"
            L()
            java.lang.Integer r1 = r26.getType()
            int r1 = r1.intValue()
            r13 = 1
            if (r1 != r13) goto L_0x001d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            r14 = r1
            com.original.tase.helper.DirectoryIndexHelper r15 = new com.original.tase.helper.DirectoryIndexHelper
            r15.<init>()
            java.lang.String r7 = r26.getName()
            if (r14 == 0) goto L_0x0033
            java.lang.Integer r1 = r26.getYear()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x005c
        L_0x0033:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "S"
            r1.append(r2)
            int r2 = java.lang.Integer.parseInt(r27)
            java.lang.String r2 = com.original.tase.utils.Utils.i(r2)
            r1.append(r2)
            java.lang.String r2 = "E"
            r1.append(r2)
            int r2 = java.lang.Integer.parseInt(r28)
            java.lang.String r2 = com.original.tase.utils.Utils.i(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x005c:
            r8 = r1
            java.lang.String r1 = f37415e
            java.util.Map r3 = r9.N(r0, r10, r11, r1)
            r6 = 0
            if (r3 == 0) goto L_0x0083
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x0083
            if (r14 == 0) goto L_0x0071
            r16 = 1
            goto L_0x0073
        L_0x0071:
            r16 = 0
        L_0x0073:
            r1 = r24
            r2 = r25
            r4 = r15
            r5 = r8
            r13 = 0
            r6 = r16
            boolean r1 = r1.K(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0084
            return
        L_0x0083:
            r13 = 0
        L_0x0084:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ": "
            java.lang.String r3 = " "
            java.lang.String r2 = r7.replace(r2, r3)
            r1.append(r2)
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            boolean[] r2 = new boolean[r13]
            java.lang.String r7 = com.original.tase.utils.Utils.k(r1, r2)
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            double r1 = r1.nextDouble()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean[] r2 = new boolean[r13]
            java.lang.String r1 = com.original.tase.utils.Utils.k(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "http://search.rlsbb.ru"
            r2.append(r3)
            r6 = 2
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r13] = r7
            r4 = 1
            r3[r4] = r1
            java.lang.String r5 = "/Home/GetPost?phrase=%s&pindex=1&type=Simple&rand=%s"
            java.lang.String r1 = java.lang.String.format(r5, r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.util.HashMap r2 = com.original.Constants.c()
            java.lang.String r4 = "Accept"
            java.lang.String r3 = "application/json, text/javascript, */*; q=0.01"
            r2.put(r4, r3)
            java.lang.String r6 = "Host"
            java.lang.String r13 = "search.rlsbb.ru"
            r2.put(r6, r13)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r13 = "http://search.rlsbb.ru/?s="
            r6.append(r13)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r13 = "Referer"
            r2.put(r13, r6)
            com.original.tase.helper.http.HttpHelper r6 = com.original.tase.helper.http.HttpHelper.i()
            r18 = r3
            r19 = r4
            r3 = 1
            java.util.Map[] r4 = new java.util.Map[r3]
            r17 = 0
            r4[r17] = r2
            java.lang.String r1 = r6.m(r1, r4)
            java.lang.String r6 = "(\\{.*?\\})$"
            java.lang.String r4 = com.original.tase.utils.Regex.c(r1, r6, r3, r3)
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x0495
            r1 = r24
            r2 = r25
            r20 = r12
            r12 = r18
            r3 = r4
            r18 = r13
            r13 = r19
            r4 = r14
            r19 = r12
            r12 = r5
            r5 = r26
            r21 = r6
            r16 = r13
            r13 = 2
            r6 = r7
            r22 = r7
            r7 = r8
            r13 = r8
            r8 = r15
            boolean r1 = r1.J(r2, r3, r4, r5, r6, r7, r8)
            if (r1 != 0) goto L_0x0495
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r8 = ""
            if (r14 == 0) goto L_0x0155
            java.lang.String r1 = r0.name
            java.lang.String r2 = r0.year
            java.lang.String r3 = f37415e
            java.util.List r1 = com.original.tase.search.SearchHelper.c(r1, r2, r2, r3, r8)
            goto L_0x015f
        L_0x0155:
            java.lang.String r1 = r0.name
            java.lang.String r2 = r0.year
            java.lang.String r3 = f37415e
            java.util.List r1 = com.original.tase.search.SearchHelper.c(r1, r2, r13, r3, r8)
        L_0x015f:
            r23 = r1
            boolean r1 = r23.isEmpty()
            if (r1 == 0) goto L_0x0203
            java.lang.String r1 = "http://proxybb.com"
            java.util.Map r3 = r9.N(r0, r10, r11, r1)
            if (r3 == 0) goto L_0x0187
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x0187
            if (r14 == 0) goto L_0x0179
            r6 = 1
            goto L_0x017a
        L_0x0179:
            r6 = 0
        L_0x017a:
            r1 = r24
            r2 = r25
            r4 = r15
            r5 = r13
            boolean r1 = r1.K(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0187
            return
        L_0x0187:
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            double r1 = r1.nextDouble()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2 = 0
            boolean[] r3 = new boolean[r2]
            java.lang.String r1 = com.original.tase.utils.Utils.k(r1, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "http://search.proxybb.com"
            r3.append(r4)
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r6 = r22
            r4[r2] = r6
            r2 = 1
            r4[r2] = r1
            java.lang.String r1 = java.lang.String.format(r12, r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.util.HashMap r2 = com.original.Constants.c()
            r4 = r16
            r3 = r19
            r2.put(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "http://search.proxybb.com/?s="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r4 = r18
            r2.put(r4, r3)
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            r4 = 1
            java.util.Map[] r5 = new java.util.Map[r4]
            r7 = 0
            r5[r7] = r2
            java.lang.String r1 = r3.m(r1, r5)
            r2 = r21
            java.lang.String r3 = com.original.tase.utils.Regex.c(r1, r2, r4, r4)
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x0203
            r1 = r24
            r2 = r25
            r4 = r14
            r5 = r26
            r7 = r13
            r10 = r8
            r8 = r15
            r1.J(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0204
        L_0x0203:
            r10 = r8
        L_0x0204:
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x0495
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r23.iterator()
        L_0x0213:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0495
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            com.original.tase.helper.http.HttpHelper r1 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = f37415e
            r2.append(r3)
            java.lang.String r11 = "/"
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r1.o(r0, r2)
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.b(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r0 = "div.post[id]"
            org.jsoup.nodes.Element r0 = r1.r0(r0)     // Catch:{ all -> 0x0253 }
            if (r0 == 0) goto L_0x025a
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0253 }
            r2.add(r0)     // Catch:{ all -> 0x0253 }
            goto L_0x025a
        L_0x0253:
            r0 = move-exception
            r3 = 0
            boolean[] r4 = new boolean[r3]
            com.original.tase.Logger.d(r0, r4)
        L_0x025a:
            java.lang.String r0 = "div.messageBox"
            org.jsoup.select.Elements r0 = r1.q0(r0)
            java.util.Iterator r1 = r0.iterator()
        L_0x0264:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0280
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x0278 }
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0     // Catch:{ all -> 0x0278 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0278 }
            r2.add(r0)     // Catch:{ all -> 0x0278 }
            goto L_0x0264
        L_0x0278:
            r0 = move-exception
            r3 = 0
            boolean[] r4 = new boolean[r3]
            com.original.tase.Logger.d(r0, r4)
            goto L_0x0264
        L_0x0280:
            java.util.Iterator r12 = r2.iterator()
        L_0x0284:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0491
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "\\/"
            java.lang.String r0 = r0.replace(r1, r11)
            java.lang.String r1 = "\\\""
            java.lang.String r2 = "\""
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "<a[^<]*href=['\"](.*?)['\"].*?</a>"
            r2 = 1
            java.util.ArrayList r0 = com.original.tase.utils.Regex.f(r0, r1, r2, r2)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r16 = r0.iterator()
        L_0x02b0:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x048d
            java.lang.Object r0 = r16.next()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r0 = "http://"
            java.lang.String r0 = r3.replace(r0, r10)     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = "https://"
            java.lang.String r0 = r0.replace(r1, r10)     // Catch:{ all -> 0x0477 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0477 }
            r1.<init>()     // Catch:{ all -> 0x0477 }
            java.lang.String r2 = f37416f     // Catch:{ all -> 0x0477 }
            r1.append(r2)     // Catch:{ all -> 0x0477 }
            r1.append(r11)     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0477 }
            boolean r1 = r0.contains(r1)     // Catch:{ all -> 0x0477 }
            if (r1 != 0) goto L_0x0472
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0477 }
            r1.<init>()     // Catch:{ all -> 0x0477 }
            r1.append(r11)     // Catch:{ all -> 0x0477 }
            r1.append(r2)     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0477 }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "#"
            boolean r0 = r3.startsWith(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "thepiratebay.org"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "protected.to"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "histats.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "opensubtitles.org"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "facebook.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "twitter.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "amazon.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "youtube.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "youtu.be"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "imgaa.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "imdb.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "tvguide.com"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".7z"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".png"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".rar"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".zip"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".iso"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".part"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".avi"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".flv"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".pdf"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "file-upload."
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".jpg"
            boolean r0 = r3.endsWith(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = ".mp3"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "imdb."
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            boolean r0 = r7.contains(r3)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x0472
            if (r14 != 0) goto L_0x03ea
            java.lang.String r0 = "([s|S]\\d+[e|E]\\d+)"
            r6 = 1
            java.lang.String r0 = com.original.tase.utils.Regex.a(r3, r0, r6)     // Catch:{ all -> 0x0477 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0477 }
            if (r1 != 0) goto L_0x03eb
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = r13.toLowerCase()     // Catch:{ all -> 0x0477 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0477 }
            if (r0 != 0) goto L_0x03eb
            goto L_0x02b0
        L_0x03ea:
            r6 = 1
        L_0x03eb:
            r7.add(r3)     // Catch:{ all -> 0x0477 }
            java.lang.String r0 = r24.A()     // Catch:{ all -> 0x0477 }
            if (r14 == 0) goto L_0x03f9
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r1 = r15.c(r3)     // Catch:{ all -> 0x0477 }
            goto L_0x03fd
        L_0x03f9:
            com.original.tase.helper.DirectoryIndexHelper$ParsedLinkModel r1 = r15.d(r3)     // Catch:{ all -> 0x0477 }
        L_0x03fd:
            java.lang.String r2 = "HQ"
            if (r1 == 0) goto L_0x040f
            java.lang.String r0 = r1.c()     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0477 }
            java.lang.String r1 = r9.t(r1)     // Catch:{ all -> 0x0477 }
            r5 = r1
            goto L_0x0411
        L_0x040f:
            r5 = r0
            r0 = r2
        L_0x0411:
            boolean r1 = r0.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0477 }
            if (r1 == 0) goto L_0x0435
            if (r14 == 0) goto L_0x041b
            r1 = r2
            goto L_0x041c
        L_0x041b:
            r1 = r3
        L_0x041c:
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x0477 }
            r4 = r20
            boolean r17 = r1.contains(r4)     // Catch:{ all -> 0x046e }
            if (r17 == 0) goto L_0x042a
            r0 = r4
            goto L_0x0437
        L_0x042a:
            java.lang.String r6 = "720p"
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x046e }
            if (r1 == 0) goto L_0x0437
            java.lang.String r0 = "HD"
            goto L_0x0437
        L_0x0435:
            r4 = r20
        L_0x0437:
            java.lang.String r1 = r3.toLowerCase()     // Catch:{ all -> 0x046e }
            java.lang.String r6 = "vidzi."
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x046e }
            if (r1 != 0) goto L_0x045b
            java.lang.String r1 = r3.toLowerCase()     // Catch:{ all -> 0x046e }
            java.lang.String r6 = "estream."
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x046e }
            if (r1 != 0) goto L_0x045b
            java.lang.String r1 = r3.toLowerCase()     // Catch:{ all -> 0x046e }
            java.lang.String r6 = ".m3u8"
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x046e }
            if (r1 == 0) goto L_0x045c
        L_0x045b:
            r0 = r2
        L_0x045c:
            r1 = 0
            boolean[] r6 = new boolean[r1]     // Catch:{ all -> 0x046e }
            r1 = r24
            r2 = r25
            r18 = r4
            r4 = r0
            r17 = 1
            r1.x(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x046c }
            goto L_0x0489
        L_0x046c:
            r0 = move-exception
            goto L_0x047c
        L_0x046e:
            r0 = move-exception
            r18 = r4
            goto L_0x047a
        L_0x0472:
            r18 = r20
            r17 = 1
            goto L_0x0489
        L_0x0477:
            r0 = move-exception
            r18 = r20
        L_0x047a:
            r17 = 1
        L_0x047c:
            r1 = 0
            boolean[] r2 = new boolean[r1]     // Catch:{ all -> 0x0483 }
            com.original.tase.Logger.d(r0, r2)     // Catch:{ all -> 0x0483 }
            goto L_0x0489
        L_0x0483:
            r0 = move-exception
            boolean[] r2 = new boolean[r1]
            com.original.tase.Logger.d(r0, r2)
        L_0x0489:
            r20 = r18
            goto L_0x02b0
        L_0x048d:
            r17 = 1
            goto L_0x0284
        L_0x0491:
            r17 = 1
            goto L_0x0213
        L_0x0495:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.ReleaseBB.M(io.reactivex.ObservableEmitter, com.movie.data.model.MovieInfo, java.lang.String, java.lang.String):void");
    }

    public String A() {
        return "ReleaseBB";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!f37415e.isEmpty() && BaseProvider.v()) {
            M(observableEmitter, movieInfo, "-1", "-1");
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!f37415e.isEmpty() && BaseProvider.v()) {
            M(observableEmitter, movieInfo, movieInfo.session, movieInfo.eps);
        }
    }

    public Map<String, String> N(MovieInfo movieInfo, String str, String str2, String str3) {
        boolean z2;
        String str4;
        HashMap hashMap = new HashMap();
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        new DirectoryIndexHelper();
        String name = movieInfo.getName();
        if (z2) {
            str4 = String.valueOf(movieInfo.getYear());
        } else {
            str4 = "S" + com.original.tase.utils.Utils.i(Integer.parseInt(str)) + "E" + com.original.tase.utils.Utils.i(Integer.parseInt(str2));
        }
        String i2 = BaseProvider.i(str3);
        HashMap<String, String> c2 = Constants.c();
        c2.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        c2.put("referer", str3 + "/");
        c2.put("Host", "search." + i2);
        c2.put("Cookie", "serach_mode=light;");
        Iterator it2 = Jsoup.b(HttpHelper.i().m("http://search." + i2 + "/?s=" + com.original.tase.utils.Utils.k(name.replace(": ", " ") + " " + str4, new boolean[0]), c2)).q0("tbody#resultdiv").g(a.f20042a).iterator();
        while (it2.hasNext()) {
            try {
                Element element = (Element) it2.next();
                String trim = element.v0().trim();
                if (z2) {
                    if (TitleHelper.h(trim.toLowerCase(), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase(), "") + movieInfo.year)) {
                        String c3 = element.c("href");
                        if (c3.startsWith("/")) {
                            c3 = str3 + c3;
                        }
                        hashMap.put(c3, trim);
                    }
                } else {
                    if (TitleHelper.h(trim.toLowerCase().replace(movieInfo.year, ""), "").startsWith(TitleHelper.h(movieInfo.getName().toLowerCase() + str4.toLowerCase(), ""))) {
                        String c4 = element.c("href");
                        if (c4.startsWith("/")) {
                            c4 = str3 + c4;
                        }
                        hashMap.put(c4, trim);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }
}
