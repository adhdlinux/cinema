package com.utils;

import com.yoku.marumovie.R;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public enum NavIds {
    NAV_LATEST(-1),
    NAV_TV_SHOW(R.id.nav_tv_show),
    NAV_MOVIE(R.id.nav_movie),
    NAV_LISTS(R.id.nav_lists),
    NAV_MY_LIST(R.id.nav_my_list),
    NAV_FAVORITE(R.id.nav_favorite),
    NAV_HISTORY(R.id.nav_history),
    NAV_CALENDAR(R.id.nav_calendar),
    NAV_DOWNLOAD(R.id.nav_download),
    NAV_SETTING(R.id.nav_setting),
    NAV_TORRENT_MANAGER(R.id.nav_torrent_manager),
    NAV_DONATE(R.id.nav_donate),
    NAV_SHARE(R.id.nav_share),
    NAV_RATE(R.id.nav_rate),
    NAV_CHECK_LASTEST(R.id.nav_checkLastest),
    NAV_ACTIVATE(R.id.nav_activate);
    

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f37572c = null;

    /* renamed from: b  reason: collision with root package name */
    private final int f37591b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavIds a(String str) {
            Intrinsics.f(str, "name");
            for (NavIds navIds : NavIds.values()) {
                if (StringsKt__StringsJVMKt.t(navIds.name(), str, true)) {
                    return navIds;
                }
            }
            return null;
        }

        public final String b(int i2) {
            NavIds navIds;
            String name;
            NavIds[] values = NavIds.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    navIds = null;
                    break;
                }
                navIds = values[i3];
                if (navIds.b() == i2) {
                    break;
                }
                i3++;
            }
            return (navIds == null || (name = navIds.name()) == null) ? "NAV_LATEST" : name;
        }
    }

    static {
        NavIds[] a2;
        f37590u = EnumEntriesKt.a(a2);
        f37572c = new Companion((DefaultConstructorMarker) null);
    }

    private NavIds(int i2) {
        this.f37591b = i2;
    }

    public final int b() {
        return this.f37591b;
    }
}
