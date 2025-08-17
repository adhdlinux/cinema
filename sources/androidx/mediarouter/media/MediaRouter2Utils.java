package androidx.mediarouter.media;

import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import android.net.Uri;
import android.os.Bundle;
import androidx.mediarouter.media.MediaRouteDescriptor;
import java.util.ArrayList;
import java.util.List;

class MediaRouter2Utils {
    private MediaRouter2Utils() {
    }

    static List<String> a(List<MediaRoute2Info> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (MediaRoute2Info next : list) {
            if (next != null) {
                arrayList.add(next.getId());
            }
        }
        return arrayList;
    }

    static RouteDiscoveryPreference b(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        if (mediaRouteDiscoveryRequest == null || !mediaRouteDiscoveryRequest.e()) {
            return new RouteDiscoveryPreference.Builder(new ArrayList(), false).build();
        }
        boolean d2 = mediaRouteDiscoveryRequest.d();
        ArrayList arrayList = new ArrayList();
        for (String d3 : mediaRouteDiscoveryRequest.c().e()) {
            arrayList.add(d(d3));
        }
        return new RouteDiscoveryPreference.Builder(arrayList, d2).build();
    }

    public static MediaRouteDescriptor c(MediaRoute2Info mediaRoute2Info) {
        if (mediaRoute2Info == null) {
            return null;
        }
        MediaRouteDescriptor.Builder f2 = new MediaRouteDescriptor.Builder(mediaRoute2Info.getId(), mediaRoute2Info.getName().toString()).g(mediaRoute2Info.getConnectionState()).s(mediaRoute2Info.getVolumeHandling()).t(mediaRoute2Info.getVolumeMax()).r(mediaRoute2Info.getVolume()).k(mediaRoute2Info.getExtras()).j(true).f(false);
        CharSequence a2 = mediaRoute2Info.getDescription();
        if (a2 != null) {
            f2.h(a2.toString());
        }
        Uri a3 = mediaRoute2Info.getIconUri();
        if (a3 != null) {
            f2.l(a3);
        }
        Bundle a4 = mediaRoute2Info.getExtras();
        if (a4 == null || !a4.containsKey("androidx.mediarouter.media.KEY_EXTRAS") || !a4.containsKey("androidx.mediarouter.media.KEY_DEVICE_TYPE") || !a4.containsKey("androidx.mediarouter.media.KEY_CONTROL_FILTERS")) {
            return null;
        }
        f2.k(a4.getBundle("androidx.mediarouter.media.KEY_EXTRAS"));
        f2.i(a4.getInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", 0));
        f2.p(a4.getInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", 1));
        ArrayList parcelableArrayList = a4.getParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS");
        if (parcelableArrayList != null) {
            f2.b(parcelableArrayList);
        }
        return f2.e();
    }

    static String d(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2065577523:
                if (str.equals("android.media.intent.category.REMOTE_PLAYBACK")) {
                    c2 = 0;
                    break;
                }
                break;
            case 956939050:
                if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                    c2 = 1;
                    break;
                }
                break;
            case 975975375:
                if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "android.media.route.feature.REMOTE_PLAYBACK";
            case 1:
                return "android.media.route.feature.LIVE_AUDIO";
            case 2:
                return "android.media.route.feature.LIVE_VIDEO";
            default:
                return str;
        }
    }
}
