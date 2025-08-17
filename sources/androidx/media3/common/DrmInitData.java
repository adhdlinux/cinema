package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
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
    private final SchemeData[] f3970b;

    /* renamed from: c  reason: collision with root package name */
    private int f3971c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3972d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3973e;

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
        private int f3974b;

        /* renamed from: c  reason: collision with root package name */
        public final UUID f3975c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3976d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3977e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f3978f;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, (String) null, str, bArr);
        }

        public boolean b(SchemeData schemeData) {
            return d() && !schemeData.d() && e(schemeData.f3975c);
        }

        public SchemeData c(byte[] bArr) {
            return new SchemeData(this.f3975c, this.f3976d, this.f3977e, bArr);
        }

        public boolean d() {
            return this.f3978f != null;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e(UUID uuid) {
            return C.f3930a.equals(this.f3975c) || uuid.equals(this.f3975c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!Util.c(this.f3976d, schemeData.f3976d) || !Util.c(this.f3977e, schemeData.f3977e) || !Util.c(this.f3975c, schemeData.f3975c) || !Arrays.equals(this.f3978f, schemeData.f3978f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            if (this.f3974b == 0) {
                int hashCode = this.f3975c.hashCode() * 31;
                String str = this.f3976d;
                if (str == null) {
                    i2 = 0;
                } else {
                    i2 = str.hashCode();
                }
                this.f3974b = ((((hashCode + i2) * 31) + this.f3977e.hashCode()) * 31) + Arrays.hashCode(this.f3978f);
            }
            return this.f3974b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f3975c.getMostSignificantBits());
            parcel.writeLong(this.f3975c.getLeastSignificantBits());
            parcel.writeString(this.f3976d);
            parcel.writeString(this.f3977e);
            parcel.writeByteArray(this.f3978f);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this.f3975c = (UUID) Assertions.f(uuid);
            this.f3976d = str;
            this.f3977e = MimeTypes.t((String) Assertions.f(str2));
            this.f3978f = bArr;
        }

        SchemeData(Parcel parcel) {
            this.f3975c = new UUID(parcel.readLong(), parcel.readLong());
            this.f3976d = parcel.readString();
            this.f3977e = (String) Util.i(parcel.readString());
            this.f3978f = parcel.createByteArray();
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    private static boolean c(ArrayList<SchemeData> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f3975c.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static DrmInitData e(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f3972d;
            for (SchemeData schemeData : drmInitData.f3970b) {
                if (schemeData.d()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f3972d;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f3970b) {
                if (schemeData2.d() && !c(arrayList, size, schemeData2.f3975c)) {
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
        UUID uuid = C.f3930a;
        if (!uuid.equals(schemeData.f3975c)) {
            return schemeData.f3975c.compareTo(schemeData2.f3975c);
        }
        if (uuid.equals(schemeData2.f3975c)) {
            return 0;
        }
        return 1;
    }

    public DrmInitData d(String str) {
        if (Util.c(this.f3972d, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.f3970b);
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
        if (!Util.c(this.f3972d, drmInitData.f3972d) || !Arrays.equals(this.f3970b, drmInitData.f3970b)) {
            return false;
        }
        return true;
    }

    public SchemeData f(int i2) {
        return this.f3970b[i2];
    }

    public DrmInitData g(DrmInitData drmInitData) {
        boolean z2;
        String str;
        String str2 = this.f3972d;
        if (str2 == null || (str = drmInitData.f3972d) == null || TextUtils.equals(str2, str)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        String str3 = this.f3972d;
        if (str3 == null) {
            str3 = drmInitData.f3972d;
        }
        return new DrmInitData(str3, (SchemeData[]) Util.T0(this.f3970b, drmInitData.f3970b));
    }

    public int hashCode() {
        int i2;
        if (this.f3971c == 0) {
            String str = this.f3972d;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            this.f3971c = (i2 * 31) + Arrays.hashCode(this.f3970b);
        }
        return this.f3971c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3972d);
        parcel.writeTypedArray(this.f3970b, 0);
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: androidx.media3.common.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(java.lang.String r1, boolean r2, androidx.media3.common.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f3972d = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            androidx.media3.common.DrmInitData$SchemeData[] r3 = (androidx.media3.common.DrmInitData.SchemeData[]) r3
        L_0x000e:
            r0.f3970b = r3
            int r1 = r3.length
            r0.f3973e = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.DrmInitData.<init>(java.lang.String, boolean, androidx.media3.common.DrmInitData$SchemeData[]):void");
    }

    DrmInitData(Parcel parcel) {
        this.f3972d = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) Util.i((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f3970b = schemeDataArr;
        this.f3973e = schemeDataArr.length;
    }
}
