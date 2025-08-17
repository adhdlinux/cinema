package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zaa;
    private final PendingResult[] zab;

    BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    public Status getStatus() {
        return this.zaa;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        boolean z2;
        if (batchResultToken.mId < this.zab.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "The result token does not belong to this batch");
        return this.zab[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
