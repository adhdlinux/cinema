package androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Util;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* renamed from: b */
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final Format f8268h = new Format.Builder().o0("application/id3").K();

    /* renamed from: i  reason: collision with root package name */
    private static final Format f8269i = new Format.Builder().o0("application/x-scte35").K();

    /* renamed from: b  reason: collision with root package name */
    public final String f8270b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8271c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8272d;

    /* renamed from: e  reason: collision with root package name */
    public final long f8273e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f8274f;

    /* renamed from: g  reason: collision with root package name */
    private int f8275g;

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.f8270b = str;
        this.f8271c = str2;
        this.f8272d = j2;
        this.f8273e = j3;
        this.f8274f = bArr;
    }

    public Format D() {
        String str = this.f8270b;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c2 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f8269i;
            case 1:
            case 2:
                return f8268h;
            default:
                return null;
        }
    }

    public byte[] E() {
        if (D() != null) {
            return this.f8274f;
        }
        return null;
    }

    public /* synthetic */ void H(MediaMetadata.Builder builder) {
        d.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.f8272d != eventMessage.f8272d || this.f8273e != eventMessage.f8273e || !Util.c(this.f8270b, eventMessage.f8270b) || !Util.c(this.f8271c, eventMessage.f8271c) || !Arrays.equals(this.f8274f, eventMessage.f8274f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        if (this.f8275g == 0) {
            String str = this.f8270b;
            int i3 = 0;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i4 = (527 + i2) * 31;
            String str2 = this.f8271c;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            long j2 = this.f8272d;
            long j3 = this.f8273e;
            this.f8275g = ((((((i4 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f8274f);
        }
        return this.f8275g;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f8270b + ", id=" + this.f8273e + ", durationMs=" + this.f8272d + ", value=" + this.f8271c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8270b);
        parcel.writeString(this.f8271c);
        parcel.writeLong(this.f8272d);
        parcel.writeLong(this.f8273e);
        parcel.writeByteArray(this.f8274f);
    }

    EventMessage(Parcel parcel) {
        this.f8270b = (String) Util.i(parcel.readString());
        this.f8271c = (String) Util.i(parcel.readString());
        this.f8272d = parcel.readLong();
        this.f8273e = parcel.readLong();
        this.f8274f = (byte[]) Util.i(parcel.createByteArray());
    }
}
