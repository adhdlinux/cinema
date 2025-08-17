package com.original.tase.helper.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.facebook.react.uimanager.ViewProps;
import com.original.tase.helper.PlayerHelper;
import com.utils.subtitle.SubtitleInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class VLCPlayer extends BasePlayer {
    public String f() {
        return "VLC";
    }

    public String g(Context context) {
        Intrinsics.f(context, "context");
        return "org.videolan.vlc";
    }

    public long h(ActivityResult activityResult) {
        Object obj;
        Bundle extras;
        Bundle extras2;
        Intrinsics.f(activityResult, "result");
        Intent b2 = activityResult.b();
        Object obj2 = null;
        if (b2 == null || (extras2 = b2.getExtras()) == null) {
            obj = null;
        } else {
            obj = extras2.get("extra_position");
        }
        if (obj == null) {
            return 0;
        }
        Intent b3 = activityResult.b();
        if (!(b3 == null || (extras = b3.getExtras()) == null)) {
            obj2 = extras.get("extra_position");
        }
        return Long.parseLong(String.valueOf(obj2));
    }

    /* renamed from: l */
    public Intent a(Context context, PlayerHelper.PlayData playData) {
        boolean z2;
        Intrinsics.f(context, "context");
        Intrinsics.f(playData, "input");
        String g2 = g(context);
        if (g2 == null) {
            return new Intent();
        }
        String streamLink = playData.b().getStreamLink();
        long position = playData.d().getPosition();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setPackage(g2);
        intent.setDataAndType(Uri.parse(streamLink), "video/*");
        intent.setComponent(new ComponentName(g2, "org.videolan.vlc.gui.video.VideoPlayerActivity"));
        boolean z3 = true;
        intent.putExtra("PLAY_EXTRA_SUBTITLES_LOCATION", true);
        if (!Intrinsics.a(playData.d().getTV(), Boolean.TRUE) || playData.e().name == null) {
            String str = playData.e().name;
            if (str == null) {
                str = playData.d().getName();
            }
            intent.putExtra("title", str);
        } else {
            intent.putExtra("title", playData.e().name + "  [S" + playData.e().session + 'E' + playData.e().eps + ']');
        }
        int i2 = (position > 0 ? 1 : (position == 0 ? 0 : -1));
        if (i2 > 0) {
            intent.putExtra(ViewProps.POSITION, position);
        }
        if (i2 <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        intent.putExtra("from_start", z2);
        Collection f2 = playData.f();
        if (f2 != null && !f2.isEmpty()) {
            z3 = false;
        }
        if (!z3) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<SubtitleInfo> f3 = playData.f();
            if (f3 != null) {
                for (SubtitleInfo subtitleInfo : f3) {
                    arrayList.add(subtitleInfo.f37703c);
                    arrayList2.add(subtitleInfo.f37704d);
                }
            }
            intent.putExtra("subtitles_location", (String) arrayList.get(0));
        }
        return intent;
    }
}
