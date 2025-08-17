package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag extends zac {
    private final TaskApiCall zaa;
    private final TaskCompletionSource zab;
    private final StatusExceptionMapper zad;

    public zag(int i2, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i2);
        this.zab = taskCompletionSource;
        this.zaa = taskApiCall;
        this.zad = statusExceptionMapper;
        if (i2 == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final boolean zaa(zabq zabq) {
        return this.zaa.shouldAutoResolveMissingFeatures();
    }

    public final Feature[] zab(zabq zabq) {
        return this.zaa.zab();
    }

    public final void zad(Status status) {
        this.zab.trySetException(this.zad.getException(status));
    }

    public final void zae(Exception exc) {
        this.zab.trySetException(exc);
    }

    public final void zaf(zabq zabq) throws DeadObjectException {
        try {
            this.zaa.doExecute(zabq.zaf(), this.zab);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            zad(zai.zah(e3));
        } catch (RuntimeException e4) {
            this.zab.trySetException(e4);
        }
    }

    public final void zag(zaad zaad, boolean z2) {
        zaad.zad(this.zab, z2);
    }
}
