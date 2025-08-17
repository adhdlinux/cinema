package androidx.media3.exoplayer.upstream;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.facebook.ads.internal.c.a;
import java.util.regex.Pattern;

public final class CmcdData {

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f7486a = Pattern.compile(".*-.*");

        public static String b(ExoTrackSelection exoTrackSelection) {
            boolean z2;
            if (exoTrackSelection != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            int k2 = MimeTypes.k(exoTrackSelection.l().f4015n);
            if (k2 == -1) {
                k2 = MimeTypes.k(exoTrackSelection.l().f4014m);
            }
            if (k2 == 1) {
                return a.f20042a;
            }
            if (k2 == 2) {
                return "v";
            }
            return null;
        }

        public CmcdData a() {
            throw null;
        }

        public Factory c(long j2) {
            throw null;
        }

        public Factory d(String str) {
            throw null;
        }

        public Factory e(String str) {
            throw null;
        }

        public Factory f(String str) {
            throw null;
        }
    }

    public DataSpec a(DataSpec dataSpec) {
        throw null;
    }
}
