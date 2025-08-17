package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "CastMediaOptionsCreator")
@SafeParcelable.Reserved({1})
public class CastMediaOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new zza();
    private static final Logger zza = new Logger("CastMediaOptions");
    @SafeParcelable.Field(getter = "getMediaIntentReceiverClassName", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getExpandedControllerActivityClassName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getImagePickerAsBinder", id = 4, type = "android.os.IBinder")
    private final zzd zzd;
    @SafeParcelable.Field(getter = "getNotificationOptions", id = 5)
    private final NotificationOptions zze;
    @SafeParcelable.Field(getter = "getDisableRemoteControlNotification", id = 6)
    private final boolean zzf;
    @SafeParcelable.Field(getter = "getMediaSessionEnabled", id = 7)
    private final boolean zzg;

    public static final class Builder {
        private String zza = "com.google.android.gms.cast.framework.media.MediaIntentReceiver";
        private String zzb;
        private ImagePicker zzc;
        private NotificationOptions zzd = new NotificationOptions.Builder().build();
        private boolean zze = true;

        /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.cast.framework.media.zzd] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.cast.framework.media.CastMediaOptions build() {
            /*
                r8 = this;
                com.google.android.gms.cast.framework.media.ImagePicker r0 = r8.zzc
                if (r0 != 0) goto L_0x0006
                r0 = 0
                goto L_0x000a
            L_0x0006:
                com.google.android.gms.cast.framework.media.zzd r0 = r0.zza()
            L_0x000a:
                r4 = r0
                com.google.android.gms.cast.framework.media.CastMediaOptions r0 = new com.google.android.gms.cast.framework.media.CastMediaOptions
                java.lang.String r2 = r8.zza
                java.lang.String r3 = r8.zzb
                com.google.android.gms.cast.framework.media.NotificationOptions r5 = r8.zzd
                r6 = 0
                boolean r7 = r8.zze
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.CastMediaOptions.Builder.build():com.google.android.gms.cast.framework.media.CastMediaOptions");
        }

        public Builder setExpandedControllerActivityClassName(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setImagePicker(ImagePicker imagePicker) {
            this.zzc = imagePicker;
            return this;
        }

        public Builder setMediaIntentReceiverClassName(String str) {
            this.zza = str;
            return this;
        }

        public Builder setMediaSessionEnabled(boolean z2) {
            this.zze = z2;
            return this;
        }

        public Builder setNotificationOptions(NotificationOptions notificationOptions) {
            this.zzd = notificationOptions;
            return this;
        }
    }

    @SafeParcelable.Constructor
    CastMediaOptions(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) NotificationOptions notificationOptions, @SafeParcelable.Param(id = 6) boolean z2, @SafeParcelable.Param(id = 7) boolean z3) {
        zzd zzd2;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            zzd2 = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            if (queryLocalInterface instanceof zzd) {
                zzd2 = (zzd) queryLocalInterface;
            } else {
                zzd2 = new zzb(iBinder);
            }
        }
        this.zzd = zzd2;
        this.zze = notificationOptions;
        this.zzf = z2;
        this.zzg = z3;
    }

    public String getExpandedControllerActivityClassName() {
        return this.zzc;
    }

    public ImagePicker getImagePicker() {
        zzd zzd2 = this.zzd;
        if (zzd2 == null) {
            return null;
        }
        try {
            return (ImagePicker) ObjectWrapper.unwrap(zzd2.zzg());
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "getWrappedClientObject", zzd.class.getSimpleName());
            return null;
        }
    }

    public String getMediaIntentReceiverClassName() {
        return this.zzb;
    }

    public boolean getMediaSessionEnabled() {
        return this.zzg;
    }

    public NotificationOptions getNotificationOptions() {
        return this.zze;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getMediaIntentReceiverClassName(), false);
        SafeParcelWriter.writeString(parcel, 3, getExpandedControllerActivityClassName(), false);
        zzd zzd2 = this.zzd;
        if (zzd2 == null) {
            iBinder = null;
        } else {
            iBinder = zzd2.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getNotificationOptions(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 7, getMediaSessionEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final boolean zza() {
        return this.zzf;
    }
}
