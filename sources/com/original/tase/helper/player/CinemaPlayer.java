package com.original.tase.helper.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import com.facebook.react.uimanager.ViewProps;
import com.movie.ui.activity.player.PlayerActivity;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.subtitle.SubtitleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class CinemaPlayer extends BasePlayer {
    public String f() {
        return "Built-in Player";
    }

    public String g(Context context) {
        Intrinsics.f(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.e(packageName, "getPackageName(...)");
        return packageName;
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

    /* renamed from: l */
    public Intent a(Context context, PlayerHelper.PlayData playData) {
        SubtitleInfo[] subtitleInfoArr;
        String str;
        Intrinsics.f(context, "context");
        Intrinsics.f(playData, "input");
        List<MediaSource> c2 = playData.c();
        if (c2 == null) {
            return new Intent();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = c2.iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            MediaSource mediaSource = (MediaSource) next;
            if (mediaSource.isResolved() || Intrinsics.a(mediaSource.getOriginalLink(), playData.b().getOriginalLink())) {
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        long position = playData.d().getPosition();
        List<SubtitleInfo> f2 = playData.f();
        Intent intent = new Intent(context, PlayerActivity.class);
        if (!Intrinsics.a(playData.d().getTV(), Boolean.TRUE) || playData.e().name == null) {
            String str2 = playData.e().name;
            if (str2 == null) {
                str2 = playData.d().getName();
            }
            intent.putExtra("title", str2);
        } else {
            if (!playData.g()) {
                str = playData.e().name + "  [Season " + playData.e().session + ']';
            } else {
                str = playData.e().name + "  [S" + playData.e().session + 'E' + playData.e().eps + ']';
            }
            intent.putExtra("title", str);
        }
        intent.putExtra(ViewProps.POSITION, position);
        intent.putExtra("mediasources", (Parcelable[]) arrayList.toArray(new MediaSource[0]));
        Iterator it3 = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.a(((MediaSource) it3.next()).getStreamLink(), playData.b().getStreamLink())) {
                break;
            } else {
                i2++;
            }
        }
        intent.putExtra("mediasources_start_index", RangesKt___RangesKt.b(0, i2));
        if (f2 != null) {
            subtitleInfoArr = (SubtitleInfo[]) f2.toArray(new SubtitleInfo[0]);
        } else {
            subtitleInfoArr = null;
        }
        intent.putExtra("subtitles", (Parcelable[]) subtitleInfoArr);
        intent.putExtra("subtitle_start_index", 0);
        return intent;
    }
}
