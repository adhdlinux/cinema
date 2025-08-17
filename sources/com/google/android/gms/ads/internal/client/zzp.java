package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzbzk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class zzp {
    public static final zzp zza = new zzp();

    protected zzp() {
    }

    public final zzl zza(Context context, zzdx zzdx) {
        long j2;
        List list;
        Context context2;
        zzfh zzfh;
        String str;
        zzdx zzdx2 = zzdx;
        Date zzn = zzdx.zzn();
        if (zzn != null) {
            j2 = zzn.getTime();
        } else {
            j2 = -1;
        }
        long j3 = j2;
        String zzk = zzdx.zzk();
        int zza2 = zzdx.zza();
        Set zzq = zzdx.zzq();
        if (!zzq.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zzq));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzs = zzdx2.zzs(context2);
        Bundle zzf = zzdx2.zzf(AdMobAdapter.class);
        String zzl = zzdx.zzl();
        SearchAdRequest zzi = zzdx.zzi();
        if (zzi != null) {
            zzfh = new zzfh(zzi);
        } else {
            zzfh = null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            str = zzbzk.zzq(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzr = zzdx.zzr();
        RequestConfiguration zzc = zzej.zzf().zzc();
        int max = Math.max(zzdx.zzc(), zzc.getTagForChildDirectedTreatment());
        String[] strArr = {null, zzc.getMaxAdContentRating()};
        return new zzl(8, j3, zzf, zza2, list, zzs, max, false, zzl, zzfh, (Location) null, zzk, zzdx.zzg(), zzdx.zze(), Collections.unmodifiableList(new ArrayList(zzdx.zzp())), zzdx.zzm(), str, zzr, (zzc) null, zzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(strArr), zzo.zza), zzdx.zzo(), zzdx.zzb(), zzdx.zzj());
    }
}
