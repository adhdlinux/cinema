package com.google.ar.core;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import com.google.ar.core.ArCoreApk;
import java.util.function.Consumer;

final /* synthetic */ class al implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f30308b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f30309c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Object f30310d;

    /* synthetic */ al(Object obj, Object obj2, int i2) {
        this.f30308b = i2;
        this.f30309c = obj;
        this.f30310d = obj2;
    }

    /* synthetic */ al(Consumer consumer, ArCoreApk.Availability availability, int i2) {
        this.f30308b = i2;
        this.f30310d = consumer;
        this.f30309c = availability;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.util.function.Consumer, java.lang.Object] */
    public final /* synthetic */ void run() {
        switch (this.f30308b) {
            case 0:
                Object obj = this.f30309c;
                Object obj2 = this.f30310d;
                int i2 = ak.f30304d;
                ((CameraDevice.StateCallback) obj).onOpened((CameraDevice) obj2);
                return;
            case 1:
                this.f30310d.accept(this.f30309c);
                return;
            case 2:
                Object obj3 = this.f30309c;
                Object obj4 = this.f30310d;
                int i3 = ak.f30304d;
                ((CameraDevice.StateCallback) obj3).onDisconnected((CameraDevice) obj4);
                return;
            case 3:
                Object obj5 = this.f30309c;
                Object obj6 = this.f30310d;
                int i4 = ak.f30304d;
                ((CameraDevice.StateCallback) obj5).onClosed((CameraDevice) obj6);
                return;
            case 4:
                Object obj7 = this.f30309c;
                Object obj8 = this.f30310d;
                int i5 = an.f30314d;
                ((CameraCaptureSession.StateCallback) obj7).onConfigured((CameraCaptureSession) obj8);
                return;
            case 5:
                Object obj9 = this.f30309c;
                Object obj10 = this.f30310d;
                int i6 = an.f30314d;
                ((CameraCaptureSession.StateCallback) obj9).onConfigureFailed((CameraCaptureSession) obj10);
                return;
            case 6:
                Object obj11 = this.f30309c;
                Object obj12 = this.f30310d;
                int i7 = an.f30314d;
                ((CameraCaptureSession.StateCallback) obj11).onReady((CameraCaptureSession) obj12);
                return;
            case 7:
                Object obj13 = this.f30309c;
                Object obj14 = this.f30310d;
                int i8 = an.f30314d;
                ((CameraCaptureSession.StateCallback) obj13).onActive((CameraCaptureSession) obj14);
                return;
            default:
                Object obj15 = this.f30309c;
                Object obj16 = this.f30310d;
                int i9 = an.f30314d;
                ((CameraCaptureSession.StateCallback) obj15).onClosed((CameraCaptureSession) obj16);
                return;
        }
    }
}
