package com.google.ar.core;

import android.app.Activity;
import android.content.Context;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.function.Consumer;

public class ArCoreApk {

    public enum Availability {
        ;
        
        final int nativeCode;

        private Availability(int i2) {
            this.nativeCode = i2;
        }

        static Availability forNumber(int i2) {
            for (Availability availability : values()) {
                if (availability.nativeCode == i2) {
                    return availability;
                }
            }
            throw new FatalException(p.b((byte) 48, i2, "Unexpected value for native Availability, value="));
        }

        public boolean isSupported() {
            return false;
        }

        public boolean isTransient() {
            return false;
        }

        public boolean isUnknown() {
            return false;
        }

        public boolean isUnsupported() {
            return false;
        }
    }

    public enum InstallBehavior {
        REQUIRED(0),
        OPTIONAL(1);
        
        final int nativeCode;

        private InstallBehavior(int i2) {
            this.nativeCode = i2;
        }

        static InstallBehavior forNumber(int i2) {
            for (InstallBehavior installBehavior : values()) {
                if (installBehavior.nativeCode == i2) {
                    return installBehavior;
                }
            }
            throw new FatalException(p.b((byte) 51, i2, "Unexpected value for native InstallBehavior, value="));
        }
    }

    public enum InstallStatus {
        INSTALLED(0),
        INSTALL_REQUESTED(1);
        
        final int nativeCode;

        private InstallStatus(int i2) {
            this.nativeCode = i2;
        }

        static InstallStatus forNumber(int i2) {
            for (InstallStatus installStatus : values()) {
                if (installStatus.nativeCode == i2) {
                    return installStatus;
                }
            }
            throw new FatalException(p.b((byte) 49, i2, "Unexpected value for native InstallStatus, value="));
        }
    }

    public enum UserMessageType {
        APPLICATION(0),
        FEATURE(1),
        USER_ALREADY_INFORMED(2);
        
        final int nativeCode;

        private UserMessageType(int i2) {
            this.nativeCode = i2;
        }

        static UserMessageType forNumber(int i2) {
            for (UserMessageType userMessageType : values()) {
                if (userMessageType.nativeCode == i2) {
                    return userMessageType;
                }
            }
            throw new FatalException(p.b((byte) 51, i2, "Unexpected value for native UserMessageType, value="));
        }
    }

    protected ArCoreApk() {
    }

    public static ArCoreApk getInstance() {
        return k.a();
    }

    public Availability checkAvailability(Context context) {
        throw new UnsupportedOperationException("Stub");
    }

    public void checkAvailabilityAsync(Context context, Consumer<Availability> consumer) {
        throw new UnsupportedOperationException("Stub");
    }

    public InstallStatus requestInstall(Activity activity, boolean z2) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        throw new UnsupportedOperationException("Stub");
    }

    public InstallStatus requestInstall(Activity activity, boolean z2, InstallBehavior installBehavior, UserMessageType userMessageType) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        throw new UnsupportedOperationException("Stub");
    }
}
