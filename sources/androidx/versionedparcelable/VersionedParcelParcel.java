package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f11930d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f11931e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11932f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11933g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11934h;

    /* renamed from: i  reason: collision with root package name */
    private int f11935i;

    /* renamed from: j  reason: collision with root package name */
    private int f11936j;

    /* renamed from: k  reason: collision with root package name */
    private int f11937k;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f11931e.writeInt(bArr.length);
            this.f11931e.writeByteArray(bArr);
            return;
        }
        this.f11931e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f11931e, 0);
    }

    public void E(int i2) {
        this.f11931e.writeInt(i2);
    }

    public void G(Parcelable parcelable) {
        this.f11931e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f11931e.writeString(str);
    }

    public void a() {
        int i2 = this.f11935i;
        if (i2 >= 0) {
            int i3 = this.f11930d.get(i2);
            int dataPosition = this.f11931e.dataPosition();
            this.f11931e.setDataPosition(i3);
            this.f11931e.writeInt(dataPosition - i3);
            this.f11931e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel b() {
        Parcel parcel = this.f11931e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f11936j;
        if (i2 == this.f11932f) {
            i2 = this.f11933g;
        }
        int i3 = i2;
        return new VersionedParcelParcel(parcel, dataPosition, i3, this.f11934h + "  ", this.f11927a, this.f11928b, this.f11929c);
    }

    public boolean g() {
        return this.f11931e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f11931e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f11931e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f11931e);
    }

    public boolean m(int i2) {
        while (this.f11936j < this.f11933g) {
            int i3 = this.f11937k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f11931e.setDataPosition(this.f11936j);
            int readInt = this.f11931e.readInt();
            this.f11937k = this.f11931e.readInt();
            this.f11936j += readInt;
        }
        if (this.f11937k == i2) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f11931e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f11931e.readParcelable(getClass().getClassLoader());
    }

    public String s() {
        return this.f11931e.readString();
    }

    public void w(int i2) {
        a();
        this.f11935i = i2;
        this.f11930d.put(i2, this.f11931e.dataPosition());
        E(0);
        E(i2);
    }

    public void y(boolean z2) {
        this.f11931e.writeInt(z2 ? 1 : 0);
    }

    private VersionedParcelParcel(Parcel parcel, int i2, int i3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f11930d = new SparseIntArray();
        this.f11935i = -1;
        this.f11937k = -1;
        this.f11931e = parcel;
        this.f11932f = i2;
        this.f11933g = i3;
        this.f11936j = i2;
        this.f11934h = str;
    }
}
