package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.view.Display;
import android.view.Window;
import okhttp3.internal.http2.Http2Connection;

@TargetApi(19)
@Deprecated
public abstract class CastPresentation extends Presentation {
    public CastPresentation(Context context, Display display) {
        super(context, display);
        zza();
    }

    private final void zza() {
        Window window = getWindow();
        if (window != null) {
            window.setType(2030);
            window.addFlags(268435456);
            window.addFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            window.addFlags(1024);
        }
    }

    public CastPresentation(Context context, Display display, int i2) {
        super(context, display, i2);
        zza();
    }
}
