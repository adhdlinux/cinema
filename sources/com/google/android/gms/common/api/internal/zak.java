package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class zak extends zap {
    private final SparseArray zad = new SparseArray();

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zak = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zak != null) {
            return zak;
        }
        return new zak(fragment);
    }

    private final zaj zai(int i2) {
        if (this.zad.size() <= i2) {
            return null;
        }
        SparseArray sparseArray = this.zad;
        return (zaj) sparseArray.get(sparseArray.keyAt(i2));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(":");
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z2 = this.zaa;
        String valueOf = String.valueOf(this.zad);
        Log.d("AutoManageHelper", "onStart " + z2 + " " + valueOf);
        if (this.zab.get() == null) {
            for (int i2 = 0; i2 < this.zad.size(); i2++) {
                zaj zai = zai(i2);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zab(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zaj = (zaj) this.zad.get(i2);
        if (zaj != null) {
            zae(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaj.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zac() {
        for (int i2 = 0; i2 < this.zad.size(); i2++) {
            zaj zai = zai(i2);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }

    public final void zad(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z2;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        if (this.zad.indexOfKey(i2) < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "Already managing a GoogleApiClient with id " + i2);
        zam zam = (zam) this.zab.get();
        boolean z3 = this.zaa;
        String valueOf = String.valueOf(zam);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i2 + " " + z3 + " " + valueOf);
        zaj zaj = new zaj(this, i2, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zaj);
        this.zad.put(i2, zaj);
        if (this.zaa && zam == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.connect();
        }
    }

    public final void zae(int i2) {
        zaj zaj = (zaj) this.zad.get(i2);
        this.zad.remove(i2);
        if (zaj != null) {
            zaj.zab.unregisterConnectionFailedListener(zaj);
            zaj.zab.disconnect();
        }
    }
}
