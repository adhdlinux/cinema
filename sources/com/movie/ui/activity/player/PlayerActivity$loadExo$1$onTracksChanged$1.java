package com.movie.ui.activity.player;

import androidx.media3.common.Tracks;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PlayerActivity$loadExo$1$onTracksChanged$1 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Tracks f32404f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ PlayerActivity f32405g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerActivity$loadExo$1$onTracksChanged$1(Tracks tracks, PlayerActivity playerActivity) {
        super(0);
        this.f32404f = tracks;
        this.f32405g = playerActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r17 = this;
            r0 = r17
            androidx.media3.common.Tracks r1 = r0.f32404f
            com.google.common.collect.ImmutableList r1 = r1.a()
            java.lang.String r2 = "getGroups(...)"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0016:
            boolean r4 = r1.hasNext()
            r5 = 3
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r1.next()
            r8 = r4
            androidx.media3.common.Tracks$Group r8 = (androidx.media3.common.Tracks.Group) r8
            int r8 = r8.c()
            if (r8 != r5) goto L_0x002d
            r6 = 1
        L_0x002d:
            if (r6 == 0) goto L_0x0016
            r3.add(r4)
            goto L_0x0016
        L_0x0033:
            com.movie.ui.activity.player.PlayerActivity r1 = r0.f32405g
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.p(r3, r8)
            r4.<init>(r8)
            java.util.Iterator r3 = r3.iterator()
        L_0x0044:
            boolean r8 = r3.hasNext()
            r9 = 0
            if (r8 == 0) goto L_0x0091
            java.lang.Object r8 = r3.next()
            androidx.media3.common.Tracks$Group r8 = (androidx.media3.common.Tracks.Group) r8
            kotlin.jvm.internal.Intrinsics.c(r8)
            java.util.List r10 = r1.K0(r8)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x0063:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x008d
            java.lang.Object r12 = r10.next()
            kotlin.Pair r12 = (kotlin.Pair) r12
            java.lang.Object r12 = r12.a()
            androidx.media3.common.Format r12 = (androidx.media3.common.Format) r12
            java.lang.String r12 = r12.f4002a
            if (r12 != 0) goto L_0x007b
            r12 = r9
            goto L_0x0087
        L_0x007b:
            boolean r13 = r8.e()
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            kotlin.Pair r12 = kotlin.TuplesKt.a(r12, r13)
        L_0x0087:
            if (r12 == 0) goto L_0x0063
            r11.add(r12)
            goto L_0x0063
        L_0x008d:
            r4.add(r11)
            goto L_0x0044
        L_0x0091:
            java.util.List r3 = kotlin.collections.CollectionsKt__IterablesKt.r(r4)
            r1.E = r3
            com.movie.ui.activity.player.PlayerActivity r1 = r0.f32405g
            androidx.media3.common.Tracks r3 = r0.f32404f
            com.google.common.collect.ImmutableList r3 = r3.a()
            kotlin.jvm.internal.Intrinsics.e(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x00ac:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00c8
            java.lang.Object r4 = r3.next()
            r8 = r4
            androidx.media3.common.Tracks$Group r8 = (androidx.media3.common.Tracks.Group) r8
            int r8 = r8.c()
            if (r8 != r5) goto L_0x00c1
            r8 = 1
            goto L_0x00c2
        L_0x00c1:
            r8 = 0
        L_0x00c2:
            if (r8 == 0) goto L_0x00ac
            r2.add(r4)
            goto L_0x00ac
        L_0x00c8:
            java.util.List r1 = r1.L0(r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.movie.ui.activity.player.PlayerActivity r2 = r0.f32405g
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00d9:
            boolean r4 = r1.hasNext()
            r5 = 2
            if (r4 == 0) goto L_0x014a
            java.lang.Object r4 = r1.next()
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r4 = r4.a()
            androidx.media3.common.Format r4 = (androidx.media3.common.Format) r4
            java.lang.String r8 = r4.f4002a
            if (r8 == 0) goto L_0x0143
            java.lang.String r8 = r4.f4005d
            if (r8 == 0) goto L_0x0143
            if (r8 == 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.c(r8)
            java.lang.String r10 = "-"
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r10, r6, r5, r9)
            if (r5 != r7) goto L_0x0103
            r5 = 1
            goto L_0x0104
        L_0x0103:
            r5 = 0
        L_0x0104:
            if (r5 == 0) goto L_0x0107
            goto L_0x0143
        L_0x0107:
            com.movie.ui.activity.player.utils.SubtitleData r5 = new com.movie.ui.activity.player.utils.SubtitleData
            java.lang.String r8 = r4.f4003b
            if (r8 != 0) goto L_0x0121
            com.movie.ui.activity.player.utils.SubtitleHelper r8 = r2.B
            java.lang.String r10 = r4.f4005d
            kotlin.jvm.internal.Intrinsics.c(r10)
            java.lang.String r8 = r8.a(r10)
            if (r8 != 0) goto L_0x0121
            java.lang.String r8 = r4.f4005d
            kotlin.jvm.internal.Intrinsics.c(r8)
        L_0x0121:
            r11 = r8
            kotlin.jvm.internal.Intrinsics.c(r11)
            java.lang.String r12 = r4.f4002a
            kotlin.jvm.internal.Intrinsics.c(r12)
            com.movie.ui.activity.player.utils.SubtitleOrigin r13 = com.movie.ui.activity.player.utils.SubtitleOrigin.EMBEDDED_IN_VIDEO
            java.lang.String r8 = r4.f4015n
            if (r8 != 0) goto L_0x0132
            java.lang.String r8 = "application/x-subrip"
        L_0x0132:
            r14 = r8
            kotlin.jvm.internal.Intrinsics.c(r14)
            java.util.Map r15 = kotlin.collections.MapsKt__MapsKt.g()
            java.lang.String r4 = r4.f4005d
            r10 = r5
            r16 = r4
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L_0x0144
        L_0x0143:
            r5 = r9
        L_0x0144:
            if (r5 == 0) goto L_0x00d9
            r3.add(r5)
            goto L_0x00d9
        L_0x014a:
            com.movie.ui.activity.player.PlayerActivity r1 = r0.f32405g
            com.movie.ui.activity.player.event.EmbeddedSubtitlesFetchedEvent r2 = new com.movie.ui.activity.player.event.EmbeddedSubtitlesFetchedEvent
            r2.<init>(r3, r9, r5, r9)
            r1.V0(r2)
            com.movie.ui.activity.player.PlayerActivity r1 = r0.f32405g
            com.movie.ui.activity.player.event.TracksChangedEvent r2 = new com.movie.ui.activity.player.event.TracksChangedEvent
            r2.<init>(r9, r7, r9)
            r1.V0(r2)
            com.movie.ui.activity.player.PlayerActivity r1 = r0.f32405g
            com.movie.ui.activity.player.event.SubtitlesUpdatedEvent r2 = new com.movie.ui.activity.player.event.SubtitlesUpdatedEvent
            r2.<init>(r9, r7, r9)
            r1.V0(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.PlayerActivity$loadExo$1$onTracksChanged$1.invoke():void");
    }
}
