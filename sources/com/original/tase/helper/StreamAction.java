package com.original.tase.helper;

import com.movie.FreeMoviesApp;
import com.utils.Utils;
import com.utils.cast.CastHelper;
import java.util.LinkedHashMap;
import kotlin.enums.EnumEntriesKt;

public final class StreamAction {

    /* renamed from: a  reason: collision with root package name */
    public static final StreamAction f33864a = new StreamAction();

    public enum ActionID {
        AlwaysAsk(-1),
        PLAY(0),
        PLAY_WITH_SUBTITLES(1),
        OPEN_WITH(2),
        DOWNLOAD(3),
        COPY_TO_CLIPBOARD(4),
        CAST(5),
        CAST_WITH_SUBTITLES(6),
        OPEN_WITH_PLAYER_PLUGIN(7);
        

        /* renamed from: b  reason: collision with root package name */
        private final int f33876b;

        static {
            ActionID[] a2;
            f33875m = EnumEntriesKt.a(a2);
        }

        private ActionID(int i2) {
            this.f33876b = i2;
        }
    }

    private StreamAction() {
    }

    public static final LinkedHashMap<String, ActionID> a() {
        return b(false);
    }

    public static final LinkedHashMap<String, ActionID> b(boolean z2) {
        String string = FreeMoviesApp.p().getString("pref_choose_default_player", PlayerHelper.f33837i.a().f());
        LinkedHashMap<String, ActionID> linkedHashMap = new LinkedHashMap<>();
        if (z2) {
            linkedHashMap.put("Always ask", ActionID.AlwaysAsk);
            linkedHashMap.put("Play", ActionID.PLAY);
            if (!StringsKt__StringsJVMKt.t(string, "cinema", true)) {
                linkedHashMap.put("Play with subtitles", ActionID.PLAY_WITH_SUBTITLES);
            }
        } else if (!CastHelper.e(Utils.v())) {
            linkedHashMap.put("Play", ActionID.PLAY);
            if (!StringsKt__StringsJVMKt.t(string, "cinema", true)) {
                linkedHashMap.put("Play with subtitles", ActionID.PLAY_WITH_SUBTITLES);
            }
        } else {
            linkedHashMap.put("Cast", ActionID.CAST);
            linkedHashMap.put("Cast with subtitles", ActionID.CAST_WITH_SUBTITLES);
        }
        linkedHashMap.put("Open with...", ActionID.OPEN_WITH);
        linkedHashMap.put("Download", ActionID.DOWNLOAD);
        linkedHashMap.put("Copy to Clipboard", ActionID.COPY_TO_CLIPBOARD);
        if (FreeMoviesApp.p().getBoolean("use_player_plugin", false)) {
            linkedHashMap.put("Open with Player Plugin", ActionID.OPEN_WITH_PLAYER_PLUGIN);
        }
        return linkedHashMap;
    }
}
