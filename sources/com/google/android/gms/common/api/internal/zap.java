package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.mediacodec.f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference zab = new AtomicReference((Object) null);
    protected final GoogleApiAvailability zac;
    private final Handler zad = new zau(Looper.getMainLooper());

    @VisibleForTesting
    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zac = googleApiAvailability;
    }

    /* access modifiers changed from: private */
    public final void zaa(ConnectionResult connectionResult, int i2) {
        this.zab.set((Object) null);
        zab(connectionResult, i2);
    }

    /* access modifiers changed from: private */
    public final void zad() {
        this.zab.set((Object) null);
        zac();
    }

    private static final int zae(zam zam) {
        if (zam == null) {
            return -1;
        }
        return zam.zaa();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        zam zam = (zam) this.zab.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    zad();
                    return;
                } else if (zam != null) {
                    if (zam.zab().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i3 == -1) {
            zad();
            return;
        } else if (i3 == 0) {
            if (zam != null) {
                int i4 = 13;
                if (intent != null) {
                    i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                zaa(new ConnectionResult(i4, (PendingIntent) null, zam.zab().toString()), zae(zam));
                return;
            }
            return;
        }
        if (zam != null) {
            zaa(zam.zab(), zam.zaa());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, (PendingIntent) null), zae((zam) this.zab.get()));
    }

    public final void onCreate(Bundle bundle) {
        zam zam;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.zab;
            if (bundle.getBoolean("resolving_error", false)) {
                zam = new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                zam = null;
            }
            atomicReference.set(zam);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam = (zam) this.zab.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.zaa());
            bundle.putInt("failed_status", zam.zab().getErrorCode());
            bundle.putParcelable("failed_resolution", zam.zab().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zab(ConnectionResult connectionResult, int i2);

    /* access modifiers changed from: protected */
    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i2) {
        zam zam = new zam(connectionResult, i2);
        AtomicReference atomicReference = this.zab;
        while (!f.a(atomicReference, (Object) null, zam)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.zad.post(new zao(this, zam));
    }
}
