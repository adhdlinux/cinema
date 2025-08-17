package com.google.ar.core;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Handler;

final class an extends CameraCaptureSession.StateCallback {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f30314d = 0;

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f30315a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CameraCaptureSession.StateCallback f30316b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SharedCamera f30317c;

    an(SharedCamera sharedCamera, Handler handler, CameraCaptureSession.StateCallback stateCallback) {
        this.f30317c = sharedCamera;
        this.f30315a = handler;
        this.f30316b = stateCallback;
    }

    public final void onActive(CameraCaptureSession cameraCaptureSession) {
        this.f30315a.post(new al((Object) this.f30316b, (Object) cameraCaptureSession, 7));
        this.f30317c.g(cameraCaptureSession);
    }

    public final void onClosed(CameraCaptureSession cameraCaptureSession) {
        this.f30315a.post(new al((Object) this.f30316b, (Object) cameraCaptureSession, 8));
        this.f30317c.h(cameraCaptureSession);
    }

    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.f30315a.post(new al((Object) this.f30316b, (Object) cameraCaptureSession, 5));
        this.f30317c.i(cameraCaptureSession);
    }

    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        this.f30315a.post(new al((Object) this.f30316b, (Object) cameraCaptureSession, 4));
        this.f30317c.j(cameraCaptureSession);
        if (this.f30317c.n().a() != null) {
            this.f30317c.c();
        }
    }

    public final void onReady(CameraCaptureSession cameraCaptureSession) {
        this.f30315a.post(new al((Object) this.f30316b, (Object) cameraCaptureSession, 6));
        this.f30317c.k(cameraCaptureSession);
    }
}
