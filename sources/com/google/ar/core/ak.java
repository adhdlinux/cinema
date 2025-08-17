package com.google.ar.core;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;

final class ak extends CameraDevice.StateCallback {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f30304d = 0;

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f30305a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CameraDevice.StateCallback f30306b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SharedCamera f30307c;

    ak(SharedCamera sharedCamera, Handler handler, CameraDevice.StateCallback stateCallback) {
        this.f30307c = sharedCamera;
        this.f30305a = handler;
        this.f30306b = stateCallback;
    }

    public final void onClosed(CameraDevice cameraDevice) {
        this.f30305a.post(new al((Object) this.f30306b, (Object) cameraDevice, 3));
        this.f30307c.e(cameraDevice);
    }

    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f30305a.post(new al((Object) this.f30306b, (Object) cameraDevice, 2));
        this.f30307c.f(cameraDevice);
    }

    public final void onError(CameraDevice cameraDevice, int i2) {
        this.f30305a.post(new am(this.f30306b, cameraDevice, i2));
        this.f30307c.b();
    }

    public final void onOpened(CameraDevice cameraDevice) {
        this.f30307c.n().b(cameraDevice);
        this.f30305a.post(new al((Object) this.f30306b, (Object) cameraDevice, 0));
        this.f30307c.d(cameraDevice);
        SharedCamera sharedCamera = this.f30307c;
        sharedCamera.n().e(sharedCamera.l());
        SharedCamera sharedCamera2 = this.f30307c;
        sharedCamera2.n().g(sharedCamera2.m());
    }
}
