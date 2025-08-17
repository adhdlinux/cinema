package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
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
    public final String f25572b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f25573c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25574d;

    /* renamed from: e  reason: collision with root package name */
    public final List<StreamKey> f25575e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f25576f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25577g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f25578h;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f25579a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f25580b;

        /* renamed from: c  reason: collision with root package name */
        private String f25581c;

        /* renamed from: d  reason: collision with root package name */
        private List<StreamKey> f25582d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f25583e;

        /* renamed from: f  reason: collision with root package name */
        private String f25584f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f25585g;

        public Builder(String str, Uri uri) {
            this.f25579a = str;
            this.f25580b = uri;
        }

        public DownloadRequest a() {
            String str = this.f25579a;
            Uri uri = this.f25580b;
            String str2 = this.f25581c;
            List list = this.f25582d;
            if (list == null) {
                list = ImmutableList.r();
            }
            return new DownloadRequest(str, uri, str2, list, this.f25583e, this.f25584f, this.f25585g);
        }

        public Builder b(String str) {
            this.f25584f = str;
            return this;
        }

        public Builder c(byte[] bArr) {
            this.f25585g = bArr;
            return this;
        }

        public Builder d(byte[] bArr) {
            this.f25583e = bArr;
            return this;
        }

        public Builder e(String str) {
            this.f25581c = str;
            return this;
        }

        public Builder f(List<StreamKey> list) {
            this.f25582d = list;
            return this;
        }
    }

    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest b(DownloadRequest downloadRequest) {
        List list;
        Assertions.a(this.f25572b.equals(downloadRequest.f25572b));
        if (this.f25575e.isEmpty() || downloadRequest.f25575e.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(this.f25575e);
            for (int i2 = 0; i2 < downloadRequest.f25575e.size(); i2++) {
                StreamKey streamKey = downloadRequest.f25575e.get(i2);
                if (!list.contains(streamKey)) {
                    list.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f25572b, downloadRequest.f25573c, downloadRequest.f25574d, list, downloadRequest.f25576f, downloadRequest.f25577g, downloadRequest.f25578h);
    }

    public MediaItem c() {
        return new MediaItem.Builder().d(this.f25572b).i(this.f25573c).b(this.f25577g).e(this.f25574d).f(this.f25575e).a();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f25572b.equals(downloadRequest.f25572b) || !this.f25573c.equals(downloadRequest.f25573c) || !Util.c(this.f25574d, downloadRequest.f25574d) || !this.f25575e.equals(downloadRequest.f25575e) || !Arrays.equals(this.f25576f, downloadRequest.f25576f) || !Util.c(this.f25577g, downloadRequest.f25577g) || !Arrays.equals(this.f25578h, downloadRequest.f25578h)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int hashCode = ((this.f25572b.hashCode() * 31 * 31) + this.f25573c.hashCode()) * 31;
        String str = this.f25574d;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int hashCode2 = (((((hashCode + i2) * 31) + this.f25575e.hashCode()) * 31) + Arrays.hashCode(this.f25576f)) * 31;
        String str2 = this.f25577g;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode2 + i3) * 31) + Arrays.hashCode(this.f25578h);
    }

    public String toString() {
        return this.f25574d + ":" + this.f25572b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25572b);
        parcel.writeString(this.f25573c.toString());
        parcel.writeString(this.f25574d);
        parcel.writeInt(this.f25575e.size());
        for (int i3 = 0; i3 < this.f25575e.size(); i3++) {
            parcel.writeParcelable(this.f25575e.get(i3), 0);
        }
        parcel.writeByteArray(this.f25576f);
        parcel.writeString(this.f25577g);
        parcel.writeByteArray(this.f25578h);
    }

    private DownloadRequest(String str, Uri uri, String str2, List<StreamKey> list, byte[] bArr, String str3, byte[] bArr2) {
        int s02 = Util.s0(uri, str2);
        boolean z2 = true;
        if (s02 == 0 || s02 == 2 || s02 == 1) {
            z2 = str3 != null ? false : z2;
            Assertions.b(z2, "customCacheKey must be null for type: " + s02);
        }
        this.f25572b = str;
        this.f25573c = uri;
        this.f25574d = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.f25575e = Collections.unmodifiableList(arrayList);
        this.f25576f = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.f25577g = str3;
        this.f25578h = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.f28813f;
    }

    DownloadRequest(Parcel parcel) {
        this.f25572b = (String) Util.j(parcel.readString());
        this.f25573c = Uri.parse((String) Util.j(parcel.readString()));
        this.f25574d = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f25575e = Collections.unmodifiableList(arrayList);
        this.f25576f = parcel.createByteArray();
        this.f25577g = parcel.readString();
        this.f25578h = (byte[]) Util.j(parcel.createByteArray());
    }
}
