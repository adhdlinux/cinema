package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    @VisibleForTesting
    protected int zaa = 0;

    public static Intent zaa(Context context, PendingIntent pendingIntent, int i2, boolean z2) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z2);
        return intent;
    }

    private final void zab() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                this.zaa = 1;
            } catch (ActivityNotFoundException e2) {
                if (extras.getBoolean("notify_manager", true)) {
                    GoogleApiManager.zam(this).zaz(new ConnectionResult(22, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String str = "Activity not found while launching " + pendingIntent.toString() + ".";
                    if (Build.FINGERPRINT.contains("generic")) {
                        str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", str, e2);
                }
                this.zaa = 1;
                finish();
            } catch (IntentSender.SendIntentException e3) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e3);
                finish();
            }
        } else {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer) Preconditions.checkNotNull(num)).intValue(), 2, this);
            this.zaa = 1;
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                GoogleApiManager zam = GoogleApiManager.zam(this);
                if (i3 == -1) {
                    zam.zaA();
                } else if (i3 == 0) {
                    zam.zaz(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.zaa = 0;
            setResult(i3, intent);
        }
        finish();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            zab();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
