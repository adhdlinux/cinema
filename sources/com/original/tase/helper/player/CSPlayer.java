package com.original.tase.helper.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.facebook.react.uimanager.ViewProps;
import com.movie.data.api.GlobalVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class CSPlayer extends BasePlayer {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f34007c = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String d() {
        return GlobalVariable.c().b().getCleaf_download_url();
    }

    public String f() {
        return "CSPlayer";
    }

    public String g(Context context) {
        Intrinsics.f(context, "context");
        return "cloud.app.csplayer";
    }

    public long h(ActivityResult activityResult) {
        Intent b2;
        Bundle extras;
        Bundle extras2;
        Intrinsics.f(activityResult, "result");
        long j2 = 0;
        if (activityResult.c() == -1) {
            Intent b3 = activityResult.b();
            if (!(b3 == null || (extras2 = b3.getExtras()) == null)) {
                long j3 = extras2.getLong(ViewProps.POSITION, -1);
                extras2.getInt("season", -1);
                extras2.getInt("episode", -1);
                String string = extras2.getString("end_by");
                Byte b4 = extras2.getByte("decode_mode", (byte) 0);
                Timber.Forest forest = Timber.f42178a;
                forest.h("Exo result with position= " + j3 + " end_by= " + string + " decode_mode= " + b4, new Object[0]);
                if (j3 <= 0) {
                    forest.h("too short to marked watched", new Object[0]);
                }
                j2 = j3;
            }
        } else if (!(activityResult.c() != 0 || (b2 = activityResult.b()) == null || (extras = b2.getExtras()) == null)) {
            extras.getString("end_by", "").equals("video_codecs_not_support");
        }
        Timber.Forest forest2 = Timber.f42178a;
        forest2.h("ExoContract return code = " + activityResult.c(), new Object[0]);
        return j2;
    }

    public List<Pair<Integer, Long>> i(ActivityResult activityResult) {
        Intent b2;
        Bundle extras;
        boolean z2;
        String str;
        List v02;
        Bundle extras2;
        Bundle extras3;
        Intrinsics.f(activityResult, "result");
        ArrayList arrayList = new ArrayList();
        if (activityResult.c() == -1) {
            Intent b3 = activityResult.b();
            if (b3 == null || (extras3 = b3.getExtras()) == null || !extras3.getBoolean("playlist")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                Intent b4 = activityResult.b();
                ArrayList arrayList2 = null;
                if (b4 == null || (extras2 = b4.getExtras()) == null) {
                    str = null;
                } else {
                    str = extras2.getString("positions", "");
                }
                if (!(str == null || (v02 = StringsKt__StringsKt.v0(str, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
                    Iterable<String> iterable = v02;
                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
                    for (String v03 : iterable) {
                        List v04 = StringsKt__StringsKt.v0(v03, new String[]{":"}, false, 0, 6, (Object) null);
                        arrayList2.add(TuplesKt.a(Integer.valueOf(Integer.parseInt((String) v04.get(0))), Long.valueOf(Long.parseLong((String) v04.get(1)))));
                    }
                }
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
            }
        } else if (!(activityResult.c() != 0 || (b2 = activityResult.b()) == null || (extras = b2.getExtras()) == null)) {
            extras.getString("end_by", "").equals("video_codecs_not_support");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a0  */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.Intent a(android.content.Context r21, com.original.tase.helper.PlayerHelper.PlayData r22) {
        /*
            r20 = this;
            java.lang.String r0 = "context"
            r1 = r21
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "input"
            r2 = r22
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.util.List r0 = r22.c()
            if (r0 == 0) goto L_0x0289
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r4 = r0.hasNext()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r0.next()
            r7 = r4
            com.original.tase.model.media.MediaSource r7 = (com.original.tase.model.media.MediaSource) r7
            boolean r8 = r7.isResolved()
            if (r8 != 0) goto L_0x0048
            java.lang.String r7 = r7.getOriginalLink()
            com.original.tase.model.media.MediaSource r8 = r22.b()
            java.lang.String r8 = r8.getOriginalLink()
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r8)
            if (r7 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            if (r5 == 0) goto L_0x001f
            r3.add(r4)
            goto L_0x001f
        L_0x004e:
            com.database.entitys.MovieEntity r0 = r22.d()
            long r7 = r0.getPosition()
            java.util.List r0 = r22.f()
            java.lang.String r1 = r20.g(r21)
            com.original.tase.model.media.MediaSource r4 = r22.b()
            java.lang.String r4 = r4.getStreamLink()
            android.content.Intent r9 = new android.content.Intent
            r9.<init>()
            java.lang.String r10 = "android.intent.action.VIEW"
            r9.setAction(r10)
            r9.setPackage(r1)
            kotlin.jvm.internal.Intrinsics.c(r4)
            android.net.Uri r1 = android.net.Uri.parse(r4)
            java.lang.String r4 = "parse(this)"
            kotlin.jvm.internal.Intrinsics.e(r1, r4)
            java.lang.String r4 = "video/*"
            r9.setDataAndType(r1, r4)
            com.database.entitys.MovieEntity r1 = r22.d()
            java.lang.Boolean r1 = r1.getTV()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r4)
            java.lang.String r4 = "title"
            if (r1 == 0) goto L_0x00ff
            com.movie.data.model.MovieInfo r1 = r22.e()
            java.lang.String r1 = r1.name
            if (r1 == 0) goto L_0x00ff
            boolean r1 = r22.g()
            r10 = 93
            if (r1 != 0) goto L_0x00ca
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.movie.data.model.MovieInfo r11 = r22.e()
            java.lang.String r11 = r11.name
            r1.append(r11)
            java.lang.String r11 = "  [Season "
            r1.append(r11)
            com.movie.data.model.MovieInfo r11 = r22.e()
            java.lang.String r11 = r11.session
            r1.append(r11)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            goto L_0x00fb
        L_0x00ca:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.movie.data.model.MovieInfo r11 = r22.e()
            java.lang.String r11 = r11.name
            r1.append(r11)
            java.lang.String r11 = "  [S"
            r1.append(r11)
            com.movie.data.model.MovieInfo r11 = r22.e()
            java.lang.String r11 = r11.session
            r1.append(r11)
            r11 = 69
            r1.append(r11)
            com.movie.data.model.MovieInfo r11 = r22.e()
            java.lang.String r11 = r11.eps
            r1.append(r11)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
        L_0x00fb:
            r9.putExtra(r4, r1)
            goto L_0x0112
        L_0x00ff:
            com.movie.data.model.MovieInfo r1 = r22.e()
            java.lang.String r1 = r1.name
            if (r1 != 0) goto L_0x010f
            com.database.entitys.MovieEntity r1 = r22.d()
            java.lang.String r1 = r1.getName()
        L_0x010f:
            r9.putExtra(r4, r1)
        L_0x0112:
            java.lang.String r1 = "position"
            r9.putExtra(r1, r7)
            com.movie.data.api.GlobalVariable r1 = com.movie.data.api.GlobalVariable.c()
            com.movie.data.model.AppConfig r1 = r1.b()
            com.movie.data.model.AppConfig$AdsBean r1 = r1.getAds()
            if (r1 == 0) goto L_0x0127
            r1 = 1
            goto L_0x0128
        L_0x0127:
            r1 = 0
        L_0x0128:
            java.lang.String r4 = "has_ad"
            r9.putExtra(r4, r1)
            java.lang.String r1 = "is_same_episode"
            boolean r4 = r22.g()
            r9.putExtra(r1, r4)
            java.lang.String r1 = "app_version_code"
            r4 = 341(0x155, float:4.78E-43)
            r9.putExtra(r1, r4)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r4 = r3.iterator()
        L_0x0146:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x01f7
            java.lang.Object r7 = r4.next()
            com.original.tase.model.media.MediaSource r7 = (com.original.tase.model.media.MediaSource) r7
            java.lang.String r8 = r7.getStreamLink()
            if (r8 == 0) goto L_0x0146
            kotlin.jvm.internal.Intrinsics.c(r8)
            r1.add(r8)
            boolean r8 = r7.isDebrid()
            if (r8 == 0) goto L_0x0189
            java.lang.String r8 = r7.getFilename()
            if (r8 == 0) goto L_0x0189
            java.lang.String r8 = r7.getFilename()
            java.lang.String r10 = "getFilename(...)"
            kotlin.jvm.internal.Intrinsics.e(r8, r10)
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x017b
            r8 = 1
            goto L_0x017c
        L_0x017b:
            r8 = 0
        L_0x017c:
            if (r8 == 0) goto L_0x0189
            java.lang.String r8 = r7.getFilename()
            kotlin.jvm.internal.Intrinsics.e(r8, r10)
            r1.add(r8)
            goto L_0x0195
        L_0x0189:
            java.lang.String r8 = r7.toString()
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.e(r8, r10)
            r1.add(r8)
        L_0x0195:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.HashMap r7 = r7.getPlayHeader()
            if (r7 == 0) goto L_0x01e1
            kotlin.jvm.internal.Intrinsics.c(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r10 = r7.size()
            r8.<init>(r10)
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x01b4:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x01e1
            java.lang.Object r10 = r7.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r12 = r10.getKey()
            java.lang.String r13 = "<get-key>(...)"
            kotlin.jvm.internal.Intrinsics.e(r12, r13)
            r11.add(r12)
            java.lang.Object r10 = r10.getValue()
            java.lang.String r12 = "<get-value>(...)"
            kotlin.jvm.internal.Intrinsics.e(r10, r12)
            boolean r10 = r11.add(r10)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r8.add(r10)
            goto L_0x01b4
        L_0x01e1:
            java.lang.String r12 = ".|."
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 62
            r19 = 0
            java.lang.String r7 = kotlin.collections.CollectionsKt___CollectionsKt.J(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1.add(r7)
            goto L_0x0146
        L_0x01f7:
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L_0x01fc:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x021e
            java.lang.Object r5 = r3.next()
            com.original.tase.model.media.MediaSource r5 = (com.original.tase.model.media.MediaSource) r5
            java.lang.String r5 = r5.getStreamLink()
            com.original.tase.model.media.MediaSource r7 = r22.b()
            java.lang.String r7 = r7.getStreamLink()
            boolean r5 = kotlin.jvm.internal.Intrinsics.a(r5, r7)
            if (r5 == 0) goto L_0x021b
            goto L_0x021f
        L_0x021b:
            int r4 = r4 + 1
            goto L_0x01fc
        L_0x021e:
            r4 = -1
        L_0x021f:
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.String r2 = "video_url_headers"
            r9.putExtra(r2, r1)
            java.lang.String r1 = "video_start_index"
            int r2 = kotlin.ranges.RangesKt___RangesKt.b(r6, r4)
            r9.putExtra(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r0 == 0) goto L_0x0276
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.p(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x024d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0276
            java.lang.Object r3 = r0.next()
            com.utils.subtitle.SubtitleInfo r3 = (com.utils.subtitle.SubtitleInfo) r3
            java.lang.String r4 = r3.f37704d
            java.lang.String r5 = "language"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            r1.add(r4)
            java.lang.String r3 = r3.f37703c
            java.lang.String r4 = "dataLink"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
            boolean r3 = r1.add(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.add(r3)
            goto L_0x024d
        L_0x0276:
            java.lang.String[] r0 = new java.lang.String[r6]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String r1 = "subtitles"
            r9.putExtra(r1, r0)
            java.lang.String r0 = "subtitle_start_index"
            r9.putExtra(r0, r6)
            return r9
        L_0x0289:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.player.CSPlayer.a(android.content.Context, com.original.tase.helper.PlayerHelper$PlayData):android.content.Intent");
    }
}
