package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;
import java.util.UUID;
import org.checkerframework.dataflow.qual.Pure;

@ShowFirstParty
public final class zzf {
    @VisibleForTesting
    Transport zza;
    private final Context zzb;
    private final zzn zzc;
    private final SessionManager zzd;
    private final zzbm zze;
    private final zzae zzf;
    private final String zzg = UUID.randomUUID().toString();
    private int zzh = 1;

    private zzf(Context context, zzn zzn, SessionManager sessionManager, zzbm zzbm, zzae zzae) {
        this.zzb = context;
        this.zzc = zzn;
        this.zzd = sessionManager;
        this.zze = zzbm;
        this.zzf = zzae;
    }

    public static zzf zza(Context context, zzn zzn, SessionManager sessionManager, zzbm zzbm, zzae zzae) {
        return new zzf(context, zzn, sessionManager, zzbm, zzae);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, SharedPreferences sharedPreferences, Bundle bundle) {
        Preconditions.checkNotNull(this.zzd);
        SessionManager sessionManager = this.zzd;
        zzbm zzbm = this.zze;
        zzk zzk = new zzk(sharedPreferences, this, bundle, str);
        this.zzf.zze(zzk.zzc());
        sessionManager.addSessionManagerListener(new zzi(zzk), CastSession.class);
        if (zzbm != null) {
            zzbm.zzm(new zzj(zzk));
        }
    }

    public final void zzc(Bundle bundle) {
        boolean z2 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED");
        boolean z3 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED");
        if (z2 || z3) {
            String packageName = this.zzb.getPackageName();
            int i2 = 2;
            String format = String.format(Locale.ROOT, "%s.%s", new Object[]{packageName, "client_cast_analytics_data"});
            if (bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0) {
                i2 = 1;
            }
            this.zzh = i2;
            TransportRuntime.f(this.zzb);
            this.zza = TransportRuntime.c().g(CCTDestination.f22270g).a("CAST_SENDER_SDK", zzmq.class, Encoding.b("proto"), zze.zza);
            SharedPreferences sharedPreferences = this.zzb.getApplicationContext().getSharedPreferences(format, 0);
            if (z2) {
                zzn zzn = this.zzc;
                zzn.doRead(TaskApiCall.builder().run(new com.google.android.gms.cast.internal.zzf(zzn, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"})).setFeatures(zzax.zzg).setAutoResolveMissingFeatures(false).setMethodKey(8426).build()).addOnSuccessListener(new zzd(this, packageName, sharedPreferences));
            }
            if (z3) {
                Preconditions.checkNotNull(sharedPreferences);
                zzr.zza(sharedPreferences, this, packageName).zze();
                zzr.zzd(zzln.CAST_CONTEXT);
            }
            zzp.zzg(this, packageName);
        }
    }

    @Pure
    public final void zzd(zzmq zzmq, int i2) {
        zzmp zzd2 = zzmq.zzd(zzmq);
        zzd2.zzk(this.zzg);
        zzd2.zzf(this.zzg);
        zzmq zzmq2 = (zzmq) zzd2.zzp();
        int i3 = this.zzh;
        int i4 = i3 - 1;
        Event event = null;
        if (i3 != 0) {
            if (i4 == 0) {
                event = Event.e(i2 - 1, zzmq2);
            } else if (i4 == 1) {
                event = Event.d(i2 - 1, zzmq2);
            }
            Preconditions.checkNotNull(event);
            Transport transport = this.zza;
            if (transport != null) {
                transport.a(event);
                return;
            }
            return;
        }
        throw null;
    }
}
