package com.facebook.common.callercontext;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class ContextChain implements Parcelable {
    public static final Parcelable.Creator<ContextChain> CREATOR = new Parcelable.Creator<ContextChain>() {
        public ContextChain createFromParcel(Parcel parcel) {
            return new ContextChain(parcel);
        }

        public ContextChain[] newArray(int i2) {
            return new ContextChain[i2];
        }
    };
    private static final char PARENT_SEPARATOR = '/';
    public static final String TAG_INFRA = "i";
    public static final String TAG_PRODUCT = "p";
    public static final String TAG_PRODUCT_AND_INFRA = "pi";
    private static boolean sUseDeepEquals = false;
    private Map<String, Object> mExtraData;
    private final int mLevel;
    private final String mName;
    private final ContextChain mParent;
    private String mSerializedString;
    private final String mTag;

    public ContextChain(String str, String str2, Map<String, String> map, ContextChain contextChain) {
        this.mTag = str;
        this.mName = str2;
        this.mLevel = contextChain != null ? contextChain.mLevel + 1 : 0;
        this.mParent = contextChain;
        Map<String, Object> extraData = contextChain != null ? contextChain.getExtraData() : null;
        if (extraData != null) {
            this.mExtraData = new HashMap(extraData);
        }
        if (map != null) {
            if (this.mExtraData == null) {
                this.mExtraData = new HashMap();
            }
            this.mExtraData.putAll(map);
        }
    }

    public static void setUseDeepEquals(boolean z2) {
        sUseDeepEquals = z2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!sUseDeepEquals) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContextChain contextChain = (ContextChain) obj;
        if (Objects.equal(this.mTag, contextChain.mTag) && Objects.equal(this.mName, contextChain.mName) && this.mLevel == contextChain.mLevel) {
            ContextChain contextChain2 = this.mParent;
            ContextChain contextChain3 = contextChain.mParent;
            if (contextChain2 == contextChain3) {
                return true;
            }
            if (contextChain2 == null || !contextChain2.equals(contextChain3)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Map<String, Object> getExtraData() {
        return this.mExtraData;
    }

    public String getName() {
        return this.mName;
    }

    public ContextChain getParent() {
        return this.mParent;
    }

    public ContextChain getRootContextChain() {
        ContextChain contextChain = this.mParent;
        return contextChain == null ? this : contextChain.getRootContextChain();
    }

    public String getStringExtra(String str) {
        Object obj;
        Map<String, Object> map = this.mExtraData;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        int i2;
        int i3;
        if (!sUseDeepEquals) {
            return super.hashCode();
        }
        int hashCode = super.hashCode() * 31;
        String str = this.mTag;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (hashCode + i2) * 31;
        String str2 = this.mName;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (((i5 + i3) * 31) + this.mLevel) * 31;
        ContextChain contextChain = this.mParent;
        if (contextChain != null) {
            i4 = contextChain.hashCode();
        }
        return i6 + i4;
    }

    public void putObjectExtra(String str, Object obj) {
        if (this.mExtraData == null) {
            this.mExtraData = new HashMap();
        }
        this.mExtraData.put(str, obj);
    }

    public String toString() {
        if (this.mSerializedString == null) {
            this.mSerializedString = this.mTag + ":" + this.mName;
            if (this.mParent != null) {
                this.mSerializedString = this.mParent.toString() + PARENT_SEPARATOR + this.mSerializedString;
            }
        }
        return this.mSerializedString;
    }

    public String[] toStringArray() {
        int i2 = this.mLevel;
        String[] strArr = new String[(i2 + 1)];
        ContextChain contextChain = this;
        while (i2 >= 0) {
            Preconditions.checkNotNull(contextChain, "ContextChain level mismatch, this should not happen.");
            strArr[i2] = contextChain.mTag + ":" + contextChain.mName;
            contextChain = contextChain.mParent;
            i2 += -1;
        }
        return strArr;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mLevel);
        parcel.writeParcelable(this.mParent, i2);
    }

    public ContextChain(String str, String str2, ContextChain contextChain) {
        this(str, str2, (Map<String, String>) null, contextChain);
    }

    protected ContextChain(Parcel parcel) {
        this.mTag = parcel.readString();
        this.mName = parcel.readString();
        this.mLevel = parcel.readInt();
        this.mParent = (ContextChain) parcel.readParcelable(ContextChain.class.getClassLoader());
    }
}
