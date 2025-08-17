package com.google.ar.core;

import android.hardware.camera2.CameraDevice;

final /* synthetic */ class am implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ CameraDevice.StateCallback f30311b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ CameraDevice f30312c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ int f30313d;

    /* synthetic */ am(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice, int i2) {
        this.f30311b = stateCallback;
        this.f30312c = cameraDevice;
        this.f30313d = i2;
    }

    public final /* synthetic */ void run() {
        CameraDevice.StateCallback stateCallback = this.f30311b;
        CameraDevice cameraDevice = this.f30312c;
        int i2 = this.f30313d;
        int i3 = ak.f30304d;
        stateCallback.onError(cameraDevice, i2);
    }
}
