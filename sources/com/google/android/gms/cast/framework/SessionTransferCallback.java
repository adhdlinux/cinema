package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.SessionState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class SessionTransferCallback {
    public static final int TRANSFER_FAILED_REASON_STORE_SESSION_STATE = 100;
    public static final int TRANSFER_FAILED_REASON_TRANSFER_TIMEOUT = 101;
    public static final int TRANSFER_TYPE_FROM_REMOTE_TO_LOCAL = 1;
    public static final int TRANSFER_TYPE_UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferFailedReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferType {
    }

    public void onTransferFailed(int i2, int i3) {
    }

    public void onTransferred(int i2, SessionState sessionState) {
    }

    public void onTransferring(int i2) {
    }
}
