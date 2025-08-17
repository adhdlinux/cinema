package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbzr;

@KeepForSdk
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbrt zza;

    private final void zza() {
        zzbrt zzbrt = this.zza;
        if (zzbrt != null) {
            try {
                zzbrt.zzx();
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzh(i2, i3, intent);
            }
        } catch (Exception e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void onBackPressed() {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null && !zzbrt.zzG()) {
                return;
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        super.onBackPressed();
        try {
            zzbrt zzbrt2 = this.zza;
            if (zzbrt2 != null) {
                zzbrt2.zzi();
            }
        } catch (RemoteException e3) {
            zzbzr.zzl("#007 Could not call remote method.", e3);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbrt zzo = zzay.zza().zzo(this);
        this.zza = zzo;
        if (zzo != null) {
            try {
                zzo.zzl(bundle);
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
                finish();
            }
        } else {
            zzbzr.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzm();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzo();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzp(i2, strArr, iArr);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzq();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzr();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzs(bundle);
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzt();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzu();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbrt zzbrt = this.zza;
            if (zzbrt != null) {
                zzbrt.zzv();
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void setContentView(int i2) {
        super.setContentView(i2);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
