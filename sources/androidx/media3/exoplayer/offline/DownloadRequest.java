package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        /* renamed from: a */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        /* renamed from: b */
        public DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f6781b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f6782c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6783d;

    /* renamed from: e  reason: collision with root package name */
    public final List<StreamKey> f6784e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f6785f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6786g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f6787h;

    public static class UnsupportedRequestException extends IOException {
    }

    DownloadRequest(Parcel parcel) {
        this.f6781b = (String) Util.i(parcel.readString());
        this.f6782c = Uri.parse((String) Util.i(parcel.readString()));
        this.f6783d = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f6784e = Collections.unmodifiableList(arrayList);
        this.f6785f = parcel.createByteArray();
        this.f6786g = parcel.readString();
        this.f6787h = (byte[]) Util.i(parcel.createByteArray());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f6781b.equals(downloadRequest.f6781b) || !this.f6782c.equals(downloadRequest.f6782c) || !Util.c(this.f6783d, downloadRequest.f6783d) || !this.f6784e.equals(downloadRequest.f6784e) || !Arrays.equals(this.f6785f, downloadRequest.f6785f) || !Util.c(this.f6786g, downloadRequest.f6786g) || !Arrays.equals(this.f6787h, downloadRequest.f6787h)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int hashCode = ((this.f6781b.hashCode() * 31 * 31) + this.f6782c.hashCode()) * 31;
        String str = this.f6783d;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int hashCode2 = (((((hashCode + i2) * 31) + this.f6784e.hashCode()) * 31) + Arrays.hashCode(this.f6785f)) * 31;
        String str2 = this.f6786g;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode2 + i3) * 31) + Arrays.hashCode(this.f6787h);
    }

    public String toString() {
        return this.f6783d + ":" + this.f6781b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6781b);
        parcel.writeString(this.f6782c.toString());
        parcel.writeString(this.f6783d);
        parcel.writeInt(this.f6784e.size());
        for (int i3 = 0; i3 < this.f6784e.size(); i3++) {
            parcel.writeParcelable(this.f6784e.get(i3), 0);
        }
        parcel.writeByteArray(this.f6785f);
        parcel.writeString(this.f6786g);
        parcel.writeByteArray(this.f6787h);
    }
}
