package com.unity3d.services.core.device;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@TargetApi(9)
public class OpenAdvertisingId {
    private static final String HW_DEVICE_NAME = "HUAWEI";
    private static final String HW_OPEN_ADVERTISING_ID_SERVICE_NAME = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static OpenAdvertisingId instance;
    private boolean limitedOpenAdTracking = false;
    private String openAdvertisingIdentifier = null;

    private interface HWAdvertisingInfo extends IInterface {

        public static abstract class HWAdvertisingInfoBinder extends Binder implements HWAdvertisingInfo {

            private static class HWAdvertisingInfoImplementation implements HWAdvertisingInfo {
                private final IBinder _binder;

                HWAdvertisingInfoImplementation(IBinder iBinder) {
                    this._binder = iBinder;
                }

                public IBinder asBinder() {
                    return this._binder;
                }

                public boolean getEnabled(boolean z2) throws RemoteException {
                    int i2;
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(OpenAdvertisingId.HW_OPEN_ADVERTISING_ID_SERVICE_NAME);
                        boolean z3 = true;
                        if (z2) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        obtain.writeInt(i2);
                        this._binder.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z3 = false;
                        }
                        return z3;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }

                public String getId() throws RemoteException {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(OpenAdvertisingId.HW_OPEN_ADVERTISING_ID_SERVICE_NAME);
                        this._binder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            public static HWAdvertisingInfo create(IBinder iBinder) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenAdvertisingId.HW_OPEN_ADVERTISING_ID_SERVICE_NAME);
                if (queryLocalInterface == null || !(queryLocalInterface instanceof HWAdvertisingInfo)) {
                    return new HWAdvertisingInfoImplementation(iBinder);
                }
                return (HWAdvertisingInfo) queryLocalInterface;
            }

            public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
                boolean z2;
                if (i2 == 1) {
                    parcel.enforceInterface(OpenAdvertisingId.HW_OPEN_ADVERTISING_ID_SERVICE_NAME);
                    String id = getId();
                    parcel2.writeNoException();
                    parcel2.writeString(id);
                    return true;
                } else if (i2 != 2) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                } else {
                    parcel.enforceInterface(OpenAdvertisingId.HW_OPEN_ADVERTISING_ID_SERVICE_NAME);
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean enabled = getEnabled(z2);
                    parcel2.writeNoException();
                    parcel2.writeInt(enabled ? 1 : 0);
                    return true;
                }
            }
        }

        boolean getEnabled(boolean z2) throws RemoteException;

        String getId() throws RemoteException;
    }

    private class HWAdvertisingServiceConnection implements ServiceConnection {
        private final BlockingQueue<IBinder> _binderQueue;
        boolean _consumed;

        private HWAdvertisingServiceConnection() {
            this._consumed = false;
            this._binderQueue = new LinkedBlockingQueue();
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this._consumed) {
                this._consumed = true;
                return this._binderQueue.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this._binderQueue.put(iBinder);
            } catch (InterruptedException unused) {
                DeviceLog.debug("Couldn't put service to binder que");
                Thread.currentThread().interrupt();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private void fetchOAId(Context context) {
        HWAdvertisingServiceConnection hWAdvertisingServiceConnection = new HWAdvertisingServiceConnection();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (context.bindService(intent, hWAdvertisingServiceConnection, 1)) {
                try {
                    HWAdvertisingInfo create = HWAdvertisingInfo.HWAdvertisingInfoBinder.create(hWAdvertisingServiceConnection.getBinder());
                    this.openAdvertisingIdentifier = create.getId();
                    this.limitedOpenAdTracking = create.getEnabled(true);
                } catch (Exception e2) {
                    DeviceLog.exception("Couldn't get openAdvertising info", e2);
                } catch (Throwable th) {
                    context.unbindService(hWAdvertisingServiceConnection);
                    throw th;
                }
                context.unbindService(hWAdvertisingServiceConnection);
            }
        } catch (Exception e3) {
            DeviceLog.exception("Couldn't bind to identifier service intent", e3);
        }
    }

    private static OpenAdvertisingId getInstance() {
        if (instance == null) {
            instance = new OpenAdvertisingId();
        }
        return instance;
    }

    public static boolean getLimitedOpenAdTracking() {
        return getInstance().limitedOpenAdTracking;
    }

    public static String getOpenAdvertisingTrackingId() {
        return getInstance().openAdvertisingIdentifier;
    }

    public static void init(Context context) {
        if (Build.MANUFACTURER.toUpperCase().equals(HW_DEVICE_NAME)) {
            getInstance().fetchOAId(context);
        }
    }
}
