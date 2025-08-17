package com.utils;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ImdbSearchSuggestionModel {

    /* renamed from: d  reason: collision with root package name */
    private List<DBean> f37563d;

    /* renamed from: q  reason: collision with root package name */
    private String f37564q;

    /* renamed from: v  reason: collision with root package name */
    private int f37565v;

    public static class DBean implements Parcelable {
        public static final Parcelable.Creator<DBean> CREATOR = new Parcelable.Creator<DBean>() {
            /* renamed from: a */
            public DBean createFromParcel(Parcel parcel) {
                return new DBean(parcel);
            }

            /* renamed from: b */
            public DBean[] newArray(int i2) {
                return new DBean[i2];
            }
        };

        /* renamed from: i  reason: collision with root package name */
        private List<String> f37566i;
        private String id;

        /* renamed from: l  reason: collision with root package name */
        private String f37567l;

        /* renamed from: q  reason: collision with root package name */
        private String f37568q;

        /* renamed from: s  reason: collision with root package name */
        private String f37569s;

        /* renamed from: y  reason: collision with root package name */
        private int f37570y;

        public DBean() {
        }

        public int describeContents() {
            return 0;
        }

        public List<String> getI() {
            return this.f37566i;
        }

        public String getId() {
            return this.id;
        }

        public String getL() {
            return this.f37567l;
        }

        public String getQ() {
            return this.f37568q;
        }

        public String getS() {
            return this.f37569s;
        }

        public int getY() {
            return this.f37570y;
        }

        public void setI(List<String> list) {
            this.f37566i = list;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setL(String str) {
            this.f37567l = str;
        }

        public void setQ(String str) {
            this.f37568q = str;
        }

        public void setS(String str) {
            this.f37569s = str;
        }

        public void setY(int i2) {
            this.f37570y = i2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeStringList(this.f37566i);
            parcel.writeString(this.id);
            parcel.writeString(this.f37567l);
            parcel.writeString(this.f37568q);
            parcel.writeString(this.f37569s);
            parcel.writeInt(this.f37570y);
        }

        protected DBean(Parcel parcel) {
            this.f37566i = parcel.createStringArrayList();
            this.id = parcel.readString();
            this.f37567l = parcel.readString();
            this.f37568q = parcel.readString();
            this.f37569s = parcel.readString();
            this.f37570y = parcel.readInt();
        }
    }

    public List<DBean> getD() {
        return this.f37563d;
    }

    public String getQ() {
        return this.f37564q;
    }

    public int getV() {
        return this.f37565v;
    }

    public void setD(List<DBean> list) {
        this.f37563d = list;
    }

    public void setQ(String str) {
        this.f37564q = str;
    }

    public void setV(int i2) {
        this.f37565v = i2;
    }
}
