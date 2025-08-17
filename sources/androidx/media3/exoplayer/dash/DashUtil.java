package androidx.media3.exoplayer.dash;

import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import java.util.Map;

public final class DashUtil {
    private DashUtil() {
    }

    public static DataSpec a(Representation representation, String str, RangedUri rangedUri, int i2, Map<String, String> map) {
        return new DataSpec.Builder().i(rangedUri.b(str)).h(rangedUri.f6094a).g(rangedUri.f6095b).f(b(representation, rangedUri)).b(i2).e(map).a();
    }

    public static String b(Representation representation, RangedUri rangedUri) {
        String a2 = representation.a();
        if (a2 != null) {
            return a2;
        }
        return rangedUri.b(representation.f6100c.get(0).f6045a).toString();
    }
}
