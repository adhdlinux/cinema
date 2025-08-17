package com.google.ar.core;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.view.Surface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ao {

    /* renamed from: a  reason: collision with root package name */
    private CameraDevice f30318a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map f30319b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private SurfaceTexture f30320c = null;

    /* renamed from: d  reason: collision with root package name */
    private Surface f30321d = null;

    private ao() {
    }

    public final CameraDevice a() {
        return this.f30318a;
    }

    public final void b(CameraDevice cameraDevice) {
        this.f30318a = cameraDevice;
    }

    public final void c(String str, List list) {
        this.f30319b.put(str, list);
    }

    public final SurfaceTexture d() {
        return this.f30320c;
    }

    public final void e(SurfaceTexture surfaceTexture) {
        this.f30320c = surfaceTexture;
    }

    public final Surface f() {
        return this.f30321d;
    }

    public final void g(Surface surface) {
        this.f30321d = surface;
    }

    /* synthetic */ ao(byte[] bArr) {
    }
}
