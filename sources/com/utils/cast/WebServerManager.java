package com.utils.cast;

import androidx.media3.exoplayer.mediacodec.f;
import com.original.tase.Logger;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class WebServerManager {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReference<WebServerManager> f37644b = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private NanoHTTPD f37645a;

    public static WebServerManager a() {
        AtomicReference<WebServerManager> atomicReference = f37644b;
        WebServerManager webServerManager = atomicReference.get();
        if (webServerManager != null) {
            return webServerManager;
        }
        f.a(atomicReference, (Object) null, new WebServerManager());
        return atomicReference.get();
    }

    public NanoHTTPD b() {
        return this.f37645a;
    }

    public void c(Map<String, Object> map) {
        NanoHTTPD nanoHTTPD = this.f37645a;
        if (nanoHTTPD != null && (nanoHTTPD instanceof CastSubtitlesWebServer)) {
            ((CastSubtitlesWebServer) nanoHTTPD).D(map);
        }
    }

    public void d(NanoHTTPD nanoHTTPD) {
        NanoHTTPD nanoHTTPD2 = this.f37645a;
        if (nanoHTTPD2 != null) {
            nanoHTTPD2.l();
        }
        this.f37645a = nanoHTTPD;
    }

    public boolean e() {
        NanoHTTPD nanoHTTPD = this.f37645a;
        if (nanoHTTPD != null) {
            try {
                if (nanoHTTPD.q()) {
                    return true;
                }
                this.f37645a.y(45000, true);
                return true;
            } catch (Exception e2) {
                Logger.d(e2, true);
            }
        }
        return false;
    }

    public void f() {
        NanoHTTPD nanoHTTPD = this.f37645a;
        if (nanoHTTPD != null && nanoHTTPD.q()) {
            this.f37645a.z();
        }
    }
}
