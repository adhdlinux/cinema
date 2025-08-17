package com.utils.Getlink.Provider;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.original.tase.Logger;
import com.original.tase.utils.Regex;
import kotlin.jvm.internal.Intrinsics;

public final class SmashyWebview$1$2 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SmashyWebview f37444a;

    SmashyWebview$1$2(SmashyWebview smashyWebview) {
        this.f37444a = smashyWebview;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str;
        Boolean bool;
        SmashyWebview smashyWebview = this.f37444a;
        Boolean bool2 = null;
        if (consoleMessage != null) {
            try {
                str = consoleMessage.message();
            } catch (Throwable th) {
                Log.e("safeCall", ExceptionsKt__ExceptionsKt.b(th));
            }
        } else {
            str = null;
        }
        if (str == null) {
            bool = Boolean.FALSE;
        } else if (StringsKt__StringsKt.L(str, "tokenRR", false, 2, (Object) null)) {
            Logger.b("Found tokenRR", str);
            String a2 = Regex.a(str, "['\"]tokenRR['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
            Intrinsics.e(a2, "m33107(...)");
            smashyWebview.V(a2);
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        bool2 = bool;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }
}
