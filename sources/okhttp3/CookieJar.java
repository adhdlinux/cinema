package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public interface CookieJar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private static final class NoCookies implements CookieJar {
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                Intrinsics.f(httpUrl, ImagesContract.URL);
                return CollectionsKt__CollectionsKt.f();
            }

            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                Intrinsics.f(httpUrl, ImagesContract.URL);
                Intrinsics.f(list, "cookies");
            }
        }

        private Companion() {
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
