package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Util;
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
    private static final Format f25368h = new Format.Builder().g0("application/id3").G();

    /* renamed from: i  reason: collision with root package name */
    private static final Format f25369i = new Format.Builder().g0("application/x-scte35").G();

    /* renamed from: b  reason: collision with root package name */
    public final String f25370b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25371c;

    /* renamed from: d  reason: collision with root package name */
    public final long f25372d;

    /* renamed from: e  reason: collision with root package name */
    public final long f25373e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f25374f;

    /* renamed from: g  reason: collision with root package name */
    private int f25375g;

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.f25370b = str;
        this.f25371c = str2;
        this.f25372d = j2;
        this.f25373e = j3;
        this.f25374f = bArr;
    }

    public Format D() {
        String str = this.f25370b;
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
                return f25369i;
            case 1:
            case 2:
                return f25368h;
            default:
                return null;
        }
    }

    public byte[] E() {
        if (D() != null) {
            return this.f25374f;
        }
        return null;
    }

    public /* synthetic */ void a(MediaMetadata.Builder builder) {
        a.c(this, builder);
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
        if (this.f25372d != eventMessage.f25372d || this.f25373e != eventMessage.f25373e || !Util.c(this.f25370b, eventMessage.f25370b) || !Util.c(this.f25371c, eventMessage.f25371c) || !Arrays.equals(this.f25374f, eventMessage.f25374f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        if (this.f25375g == 0) {
            String str = this.f25370b;
            int i3 = 0;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i4 = (527 + i2) * 31;
            String str2 = this.f25371c;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            long j2 = this.f25372d;
            long j3 = this.f25373e;
            this.f25375g = ((((((i4 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f25374f);
        }
        return this.f25375g;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f25370b + ", id=" + this.f25373e + ", durationMs=" + this.f25372d + ", value=" + this.f25371c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25370b);
        parcel.writeString(this.f25371c);
        parcel.writeLong(this.f25372d);
        parcel.writeLong(this.f25373e);
        parcel.writeByteArray(this.f25374f);
    }

    EventMessage(Parcel parcel) {
        this.f25370b = (String) Util.j(parcel.readString());
        this.f25371c = (String) Util.j(parcel.readString());
        this.f25372d = parcel.readLong();
        this.f25373e = parcel.readLong();
        this.f25374f = (byte[]) Util.j(parcel.createByteArray());
    }
}
