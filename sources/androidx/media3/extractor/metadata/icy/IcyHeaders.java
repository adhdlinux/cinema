package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        /* renamed from: a */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        /* renamed from: b */
        public IcyHeaders[] newArray(int i2) {
            return new IcyHeaders[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f8291b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8292c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8293d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8294e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8295f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8296g;

    public IcyHeaders(int i2, String str, String str2, String str3, boolean z2, int i3) {
        Assertions.a(i3 == -1 || i3 > 0);
        this.f8291b = i2;
        this.f8292c = str;
        this.f8293d = str2;
        this.f8294e = str3;
        this.f8295f = z2;
        this.f8296g = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.extractor.metadata.icy.IcyHeaders b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "icy-br"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.lang.String r2 = "IcyHeaders"
            r3 = 1
            r4 = 0
            r5 = -1
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0039 }
            int r6 = r6 * 1000
            if (r6 <= 0) goto L_0x0021
            r1 = 1
            goto L_0x0037
        L_0x0021:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x003a }
            r7.<init>()     // Catch:{ NumberFormatException -> 0x003a }
            java.lang.String r8 = "Invalid bitrate: "
            r7.append(r8)     // Catch:{ NumberFormatException -> 0x003a }
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x003a }
            java.lang.String r7 = r7.toString()     // Catch:{ NumberFormatException -> 0x003a }
            androidx.media3.common.util.Log.h(r2, r7)     // Catch:{ NumberFormatException -> 0x003a }
            r1 = 0
            r6 = -1
        L_0x0037:
            r7 = r6
            goto L_0x0053
        L_0x0039:
            r6 = -1
        L_0x003a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Invalid bitrate header: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            androidx.media3.common.util.Log.h(r2, r1)
            r7 = r6
            r1 = 0
            goto L_0x0053
        L_0x0051:
            r1 = 0
            r7 = -1
        L_0x0053:
            java.lang.String r6 = "icy-genre"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            r8 = 0
            if (r6 == 0) goto L_0x0067
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            r1 = 1
            goto L_0x0068
        L_0x0067:
            r9 = r8
        L_0x0068:
            java.lang.String r6 = "icy-name"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x007b
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = 1
            goto L_0x007c
        L_0x007b:
            r10 = r8
        L_0x007c:
            java.lang.String r6 = "icy-url"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x008f
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = 1
            goto L_0x0090
        L_0x008f:
            r11 = r8
        L_0x0090:
            java.lang.String r6 = "icy-pub"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x00a9
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r6 = "1"
            boolean r1 = r1.equals(r6)
            r12 = r1
            r1 = 1
            goto L_0x00aa
        L_0x00a9:
            r12 = 0
        L_0x00aa:
            java.lang.String r6 = "icy-metaint"
            java.lang.Object r13 = r13.get(r6)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x00ea
            java.lang.Object r13 = r13.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            int r4 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x00d8 }
            if (r4 <= 0) goto L_0x00c2
            r5 = r4
            goto L_0x00d5
        L_0x00c2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.append(r0)     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.append(r13)     // Catch:{ NumberFormatException -> 0x00d7 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x00d7 }
            androidx.media3.common.util.Log.h(r2, r3)     // Catch:{ NumberFormatException -> 0x00d7 }
            r3 = r1
        L_0x00d5:
            r1 = r3
            goto L_0x00ea
        L_0x00d7:
            r5 = r4
        L_0x00d8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            androidx.media3.common.util.Log.h(r2, r13)
        L_0x00ea:
            if (r1 == 0) goto L_0x00f8
            androidx.media3.extractor.metadata.icy.IcyHeaders r13 = new androidx.media3.extractor.metadata.icy.IcyHeaders
            r6 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r8 = r13
        L_0x00f8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.icy.IcyHeaders.b(java.util.Map):androidx.media3.extractor.metadata.icy.IcyHeaders");
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public void H(MediaMetadata.Builder builder) {
        String str = this.f8293d;
        if (str != null) {
            builder.m0(str);
        }
        String str2 = this.f8292c;
        if (str2 != null) {
            builder.b0(str2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        if (this.f8291b != icyHeaders.f8291b || !Util.c(this.f8292c, icyHeaders.f8292c) || !Util.c(this.f8293d, icyHeaders.f8293d) || !Util.c(this.f8294e, icyHeaders.f8294e) || this.f8295f != icyHeaders.f8295f || this.f8296g != icyHeaders.f8296g) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4 = (527 + this.f8291b) * 31;
        String str = this.f8292c;
        int i5 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i4 + i2) * 31;
        String str2 = this.f8293d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        String str3 = this.f8294e;
        if (str3 != null) {
            i5 = str3.hashCode();
        }
        return ((((i7 + i5) * 31) + (this.f8295f ? 1 : 0)) * 31) + this.f8296g;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f8293d + "\", genre=\"" + this.f8292c + "\", bitrate=" + this.f8291b + ", metadataInterval=" + this.f8296g;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8291b);
        parcel.writeString(this.f8292c);
        parcel.writeString(this.f8293d);
        parcel.writeString(this.f8294e);
        Util.u1(parcel, this.f8295f);
        parcel.writeInt(this.f8296g);
    }

    IcyHeaders(Parcel parcel) {
        this.f8291b = parcel.readInt();
        this.f8292c = parcel.readString();
        this.f8293d = parcel.readString();
        this.f8294e = parcel.readString();
        this.f8295f = Util.Z0(parcel);
        this.f8296g = parcel.readInt();
    }
}
