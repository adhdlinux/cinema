package com.google.android.gms.common.api.internal;

final class zabn implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabq zab;

    zabn(zabq zabq, int i2) {
        this.zab = zabq;
        this.zaa = i2;
    }

    public final void run() {
        this.zab.zaH(this.zaa);
    }
}
