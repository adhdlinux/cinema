package okhttp3;

import com.applovin.sdk.AppLovinEventParameters;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        Intrinsics.f(str, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
        Intrinsics.f(str2, "password");
        return basic$default(str, str2, (Charset) null, 4, (Object) null);
    }

    public static final String basic(String str, String str2, Charset charset) {
        Intrinsics.f(str, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
        Intrinsics.f(str2, "password");
        Intrinsics.f(charset, "charset");
        String a2 = ByteString.f41331e.c(str + ':' + str2, charset).a();
        return "Basic " + a2;
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            Intrinsics.e(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }
}
