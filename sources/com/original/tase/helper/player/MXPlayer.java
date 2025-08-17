package com.original.tase.helper.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.facebook.react.uimanager.ViewProps;
import com.movie.FreeMoviesApp;
import com.original.tase.utils.Utils;
import kotlin.jvm.internal.Intrinsics;

public final class MXPlayer extends BasePlayer {
    public String f() {
        return "MX";
    }

    public String g(Context context) {
        Intrinsics.f(context, "context");
        if (Utils.n(context, "com.mxtech.videoplayer.pro")) {
            return "com.mxtech.videoplayer.pro";
        }
        return "com.mxtech.videoplayer.ad";
    }

    public long h(ActivityResult activityResult) {
        String str;
        Object obj;
        Bundle extras;
        Bundle extras2;
        Intrinsics.f(activityResult, "result");
        Intent b2 = activityResult.b();
        Object obj2 = null;
        if (b2 != null) {
            str = b2.getStringExtra("end_by");
        } else {
            str = null;
        }
        boolean z2 = false;
        if (str != null && StringsKt__StringsKt.L(str, "playback_completion", false, 2, (Object) null)) {
            z2 = true;
        }
        if (z2) {
            return ((long) (FreeMoviesApp.p().getInt("pref_mark_saving_percent", 1) * 60 * 1000)) + 1;
        }
        Intent b3 = activityResult.b();
        if (b3 == null || (extras2 = b3.getExtras()) == null) {
            obj = null;
        } else {
            obj = extras2.get(ViewProps.POSITION);
        }
        if (obj == null) {
            return 0;
        }
        Intent b4 = activityResult.b();
        if (!(b4 == null || (extras = b4.getExtras()) == null)) {
            obj2 = extras.get(ViewProps.POSITION);
        }
        return Long.parseLong(String.valueOf(obj2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x016b A[LOOP:1: B:41:0x0165->B:43:0x016b, LOOP_END] */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.Intent a(android.content.Context r11, com.original.tase.helper.PlayerHelper.PlayData r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r11 = r10.g(r11)
            int r0 = r11.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x0021
            android.content.Intent r11 = new android.content.Intent
            r11.<init>()
            return r11
        L_0x0021:
            com.original.tase.model.media.MediaSource r0 = r12.b()
            com.database.entitys.MovieEntity r3 = r12.d()
            long r3 = r3.getPosition()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r7 = r12.f()
            if (r7 == 0) goto L_0x005e
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0043:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x005e
            java.lang.Object r8 = r7.next()
            com.utils.subtitle.SubtitleInfo r8 = (com.utils.subtitle.SubtitleInfo) r8
            java.lang.String r9 = r8.f37703c
            android.net.Uri r9 = android.net.Uri.parse(r9)
            r5.add(r9)
            java.lang.String r8 = r8.f37704d
            r6.add(r8)
            goto L_0x0043
        L_0x005e:
            java.lang.String r7 = r0.getStreamLink()
            java.lang.String r8 = "getStreamLink(...)"
            kotlin.jvm.internal.Intrinsics.e(r7, r8)
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            java.lang.String r9 = "android.intent.action.VIEW"
            r8.setAction(r9)
            r8.setPackage(r11)
            android.net.Uri r7 = android.net.Uri.parse(r7)
            java.lang.String r9 = "parse(this)"
            kotlin.jvm.internal.Intrinsics.e(r7, r9)
            java.lang.String r9 = "video/*"
            r8.setDataAndType(r7, r9)
            java.lang.String r7 = "com.mxtech.videoplayer.ad"
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r11, r7)
            if (r7 == 0) goto L_0x0090
            java.lang.String r7 = "com.mxtech.videoplayer.ad.ActivityScreen"
            r8.setClassName(r11, r7)
            goto L_0x009d
        L_0x0090:
            java.lang.String r7 = "com.mxtech.videoplayer.pro"
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r11, r7)
            if (r7 == 0) goto L_0x009d
            java.lang.String r7 = "com.mxtech.videoplayer.ActivityScreen"
            r8.setClassName(r11, r7)
        L_0x009d:
            java.lang.String r11 = "return_result"
            r8.putExtra(r11, r1)
            java.lang.String r11 = "end_by"
            java.lang.String r7 = "user"
            r8.putExtra(r11, r7)
            java.lang.String r11 = "suppress_error_message"
            r8.putExtra(r11, r2)
            java.lang.String r11 = "secure_uri"
            r8.putExtra(r11, r1)
            java.lang.String r11 = "subs.enable"
            r8.putExtra(r11, r1)
            com.database.entitys.MovieEntity r11 = r12.d()
            java.lang.Boolean r11 = r11.getTV()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r11 = kotlin.jvm.internal.Intrinsics.a(r11, r1)
            java.lang.String r1 = "title"
            if (r11 == 0) goto L_0x010d
            com.movie.data.model.MovieInfo r11 = r12.e()
            if (r11 == 0) goto L_0x00d3
            java.lang.String r11 = r11.name
            goto L_0x00d4
        L_0x00d3:
            r11 = 0
        L_0x00d4:
            if (r11 == 0) goto L_0x010d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            com.movie.data.model.MovieInfo r7 = r12.e()
            java.lang.String r7 = r7.name
            r11.append(r7)
            java.lang.String r7 = "  [S"
            r11.append(r7)
            com.movie.data.model.MovieInfo r7 = r12.e()
            java.lang.String r7 = r7.session
            r11.append(r7)
            r7 = 69
            r11.append(r7)
            com.movie.data.model.MovieInfo r12 = r12.e()
            java.lang.String r12 = r12.eps
            r11.append(r12)
            r12 = 93
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r8.putExtra(r1, r11)
            goto L_0x0122
        L_0x010d:
            com.movie.data.model.MovieInfo r11 = r12.e()
            if (r11 == 0) goto L_0x0117
            java.lang.String r11 = r11.name
            if (r11 != 0) goto L_0x011f
        L_0x0117:
            com.database.entitys.MovieEntity r11 = r12.d()
            java.lang.String r11 = r11.getName()
        L_0x011f:
            r8.putExtra(r1, r11)
        L_0x0122:
            android.net.Uri[] r11 = new android.net.Uri[r2]
            java.lang.Object[] r11 = r5.toArray(r11)
            android.os.Parcelable[] r11 = (android.os.Parcelable[]) r11
            java.lang.String r12 = "subs"
            r8.putExtra(r12, r11)
            java.lang.String[] r11 = new java.lang.String[r2]
            java.lang.Object[] r11 = r6.toArray(r11)
            java.lang.String[] r11 = (java.lang.String[]) r11
            java.lang.String r12 = "subs.name"
            r8.putExtra(r12, r11)
            r11 = 0
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0148
            java.lang.String r11 = "position"
            int r12 = (int) r3
            r8.putExtra(r11, r12)
        L_0x0148:
            java.util.HashMap r11 = r0.getPlayHeader()
            if (r11 == 0) goto L_0x018d
            int r12 = r11.size()
            if (r12 <= 0) goto L_0x018d
            java.util.HashMap r11 = com.original.tase.utils.SourceUtils.a(r11)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0165:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0180
            java.lang.Object r0 = r11.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            r12.add(r1)
            java.lang.Object r0 = r0.getValue()
            r12.add(r0)
            goto L_0x0165
        L_0x0180:
            java.lang.String[] r11 = new java.lang.String[r2]
            java.lang.Object[] r11 = r12.toArray(r11)
            java.lang.String[] r11 = (java.lang.String[]) r11
            java.lang.String r12 = "headers"
            r8.putExtra(r12, r11)
        L_0x018d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.player.MXPlayer.a(android.content.Context, com.original.tase.helper.PlayerHelper$PlayData):android.content.Intent");
    }
}
