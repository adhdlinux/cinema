package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* renamed from: b */
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final SchemeData[] f24075b;

    /* renamed from: c  reason: collision with root package name */
    private int f24076c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24077d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24078e;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* renamed from: b */
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private int f24079b;

        /* renamed from: c  reason: collision with root package name */
        public final UUID f24080c;

        /* renamed from: d  reason: collision with root package name */
        public final String f24081d;

        /* renamed from: e  reason: collision with root package name */
        public final String f24082e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f24083f;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, (String) null, str, bArr);
        }

        public boolean b(SchemeData schemeData) {
            return d() && !schemeData.d() && e(schemeData.f24080c);
        }

        public SchemeData c(byte[] bArr) {
            return new SchemeData(this.f24080c, this.f24081d, this.f24082e, bArr);
        }

        public boolean d() {
            return this.f24083f != null;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e(UUID uuid) {
            return C.f22816a.equals(this.f24080c) || uuid.equals(this.f24080c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!Util.c(this.f24081d, schemeData.f24081d) || !Util.c(this.f24082e, schemeData.f24082e) || !Util.c(this.f24080c, schemeData.f24080c) || !Arrays.equals(this.f24083f, schemeData.f24083f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            if (this.f24079b == 0) {
                int hashCode = this.f24080c.hashCode() * 31;
                String str = this.f24081d;
                if (str == null) {
                    i2 = 0;
                } else {
                    i2 = str.hashCode();
                }
                this.f24079b = ((((hashCode + i2) * 31) + this.f24082e.hashCode()) * 31) + Arrays.hashCode(this.f24083f);
            }
            return this.f24079b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f24080c.getMostSignificantBits());
            parcel.writeLong(this.f24080c.getLeastSignificantBits());
            parcel.writeString(this.f24081d);
            parcel.writeString(this.f24082e);
            parcel.writeByteArray(this.f24083f);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this.f24080c = (UUID) Assertions.e(uuid);
            this.f24081d = str;
            this.f24082e = (String) Assertions.e(str2);
            this.f24083f = bArr;
        }

        SchemeData(Parcel parcel) {
            this.f24080c = new UUID(parcel.readLong(), parcel.readLong());
            this.f24081d = parcel.readString();
            this.f24082e = (String) Util.j(parcel.readString());
            this.f24083f = parcel.createByteArray();
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    private static boolean c(ArrayList<SchemeData> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f24080c.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static DrmInitData e(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f24077d;
            for (SchemeData schemeData : drmInitData.f24075b) {
                if (schemeData.d()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f24077d;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f24075b) {
                if (schemeData2.d() && !c(arrayList, size, schemeData2.f24080c)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, (List<SchemeData>) arrayList);
    }

    /* renamed from: b */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C.f22816a;
        if (!uuid.equals(schemeData.f24080c)) {
            return schemeData.f24080c.compareTo(schemeData2.f24080c);
        }
        if (uuid.equals(schemeData2.f24080c)) {
            return 0;
        }
        return 1;
    }

    public DrmInitData d(String str) {
        if (Util.c(this.f24077d, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.f24075b);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (!Util.c(this.f24077d, drmInitData.f24077d) || !Arrays.equals(this.f24075b, drmInitData.f24075b)) {
            return false;
        }
        return true;
    }

    public SchemeData f(int i2) {
        return this.f24075b[i2];
    }

    public DrmInitData g(DrmInitData drmInitData) {
        boolean z2;
        String str;
        String str2 = this.f24077d;
        if (str2 == null || (str = drmInitData.f24077d) == null || TextUtils.equals(str2, str)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        String str3 = this.f24077d;
        if (str3 == null) {
            str3 = drmInitData.f24077d;
        }
        return new DrmInitData(str3, (SchemeData[]) Util.J0(this.f24075b, drmInitData.f24075b));
    }

    public int hashCode() {
        int i2;
        if (this.f24076c == 0) {
            String str = this.f24077d;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            this.f24076c = (i2 * 31) + Arrays.hashCode(this.f24075b);
        }
        return this.f24076c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f24077d);
        parcel.writeTypedArray(this.f24075b, 0);
    }

    public DrmInitData(String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(java.lang.String r1, boolean r2, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f24077d = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r3
        L_0x000e:
            r0.f24075b = r3
            int r1 = r3.length
            r0.f24078e = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DrmInitData.<init>(java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]):void");
    }

    DrmInitData(Parcel parcel) {
        this.f24077d = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) Util.j((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f24075b = schemeDataArr;
        this.f24078e = schemeDataArr.length;
    }
}
