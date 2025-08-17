package com.google.ar.core;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

@SuppressLint({"LongLogTag"})
final class aj {
    static PendingIntent a(Context context) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        RuntimeException runtimeException;
        try {
            Bundle call = context.getContentResolver().call(new Uri.Builder().scheme("content").authority("com.google.ar.core.services.arcorecontentprovider").path("").build(), "getSetupIntent", context.getPackageName(), (Bundle) null);
            if (call == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) call.getParcelable("intent");
            if (pendingIntent != null) {
                return pendingIntent;
            }
            String string = call.getString("exceptionType", "");
            if (string.isEmpty()) {
                return null;
            }
            if (string.equals(UnavailableDeviceNotCompatibleException.class.getName())) {
                throw new UnavailableDeviceNotCompatibleException();
            } else if (!string.equals(UnavailableUserDeclinedInstallationException.class.getName())) {
                Class<? extends U> asSubclass = Class.forName(string).asSubclass(RuntimeException.class);
                String string2 = call.getString("exceptionText", (String) null);
                if (string2 != null) {
                    runtimeException = (RuntimeException) asSubclass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{string2});
                } else {
                    runtimeException = (RuntimeException) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                throw runtimeException;
            } else {
                throw new UnavailableUserDeclinedInstallationException();
            }
        } catch (ReflectiveOperationException | RuntimeException e2) {
            Log.i("ARCore-SetupContentResolver", "Post-install failed", e2);
            return null;
        }
    }
}
