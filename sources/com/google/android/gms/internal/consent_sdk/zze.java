package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzg[] zzc;

    public /* synthetic */ zze(String str, String str2, zzg[] zzgArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzgArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        String str2 = this.zzb;
        zzg[] zzgArr = this.zzc;
        if (TextUtils.isEmpty(str)) {
            Log.d("UserMessagingPlatform", "Error on action: empty action name");
            return;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.isEmpty(str2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 32 + String.valueOf(str2).length());
                sb.append("Action[");
                sb.append(lowerCase);
                sb.append("]: failed to parse args: ");
                sb.append(str2);
                Log.d("UserMessagingPlatform", sb.toString());
                return;
            }
        }
        String valueOf = String.valueOf(jSONObject);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 10 + valueOf.length());
        sb2.append("Action[");
        sb2.append(lowerCase);
        sb2.append("]: ");
        sb2.append(valueOf);
        Log.d("UserMessagingPlatform", sb2.toString());
        int length = zzgArr.length;
        int i2 = 0;
        while (i2 < length) {
            zzg zzg = zzgArr[i2];
            FutureTask futureTask = new FutureTask(new zzf(zzg, lowerCase, jSONObject));
            zzg.zza().execute(futureTask);
            try {
                if (!((Boolean) futureTask.get()).booleanValue()) {
                    i2++;
                } else {
                    return;
                }
            } catch (ExecutionException e2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(lowerCase).length() + 24);
                sb3.append("Failed to run Action[");
                sb3.append(lowerCase);
                sb3.append("]: ");
                Log.d("UserMessagingPlatform", sb3.toString(), e2.getCause());
            } catch (InterruptedException e3) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(lowerCase).length() + 33);
                sb4.append("Thread interrupted for Action[");
                sb4.append(lowerCase);
                sb4.append("]: ");
                Log.d("UserMessagingPlatform", sb4.toString(), e3);
            }
        }
    }
}
