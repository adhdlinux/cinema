package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LocationReceiverCreator")
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();
    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getOldBinderReceiver", id = 2)
    private final IBinder zzb;
    @SafeParcelable.Field(getter = "getBinderReceiver", id = 3)
    private final IBinder zzc;
    @SafeParcelable.Field(getter = "getPendingIntentReceiver", id = 4)
    private final PendingIntent zzd;
    @SafeParcelable.Field(getter = "getModuleId", id = 5)
    private final String zze;
    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    private final String zzf;

    @SafeParcelable.Constructor
    zzdb(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2, @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) String str2) {
        this.zza = i2;
        this.zzb = iBinder;
        this.zzc = iBinder2;
        this.zzd = pendingIntent;
        this.zze = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.zzf = str2;
    }

    public static zzdb zza(PendingIntent pendingIntent, String str, String str2) {
        return new zzdb(3, (IBinder) null, (IBinder) null, pendingIntent, (String) null, (String) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzdb zzb(android.os.IInterface r7, com.google.android.gms.location.zzr r8, java.lang.String r9, java.lang.String r10) {
        /*
            com.google.android.gms.internal.location.zzdb r9 = new com.google.android.gms.internal.location.zzdb
            if (r7 != 0) goto L_0x0005
            r7 = 0
        L_0x0005:
            r2 = r7
            r1 = 2
            r4 = 0
            r5 = 0
            r0 = r9
            r3 = r8
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdb.zzb(android.os.IInterface, com.google.android.gms.location.zzr, java.lang.String, java.lang.String):com.google.android.gms.internal.location.zzdb");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzdb zzc(android.os.IInterface r7, com.google.android.gms.location.zzu r8, java.lang.String r9, java.lang.String r10) {
        /*
            com.google.android.gms.internal.location.zzdb r9 = new com.google.android.gms.internal.location.zzdb
            if (r7 != 0) goto L_0x0005
            r7 = 0
        L_0x0005:
            r2 = r7
            r1 = 1
            r4 = 0
            r5 = 0
            r0 = r9
            r3 = r8
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdb.zzc(android.os.IInterface, com.google.android.gms.location.zzu, java.lang.String, java.lang.String):com.google.android.gms.internal.location.zzdb");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i2, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
