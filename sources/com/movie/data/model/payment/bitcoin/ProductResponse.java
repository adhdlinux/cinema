package com.movie.data.model.payment.bitcoin;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ProductResponse implements Parcelable {
    public static final Parcelable.Creator<ProductResponse> CREATOR = new Parcelable.Creator<ProductResponse>() {
        public ProductResponse createFromParcel(Parcel parcel) {
            return new ProductResponse(parcel);
        }

        public ProductResponse[] newArray(int i2) {
            return new ProductResponse[i2];
        }
    };
    private String message;
    private List<ResultsBean> results;

    protected ProductResponse(Parcel parcel) {
        this.message = parcel.readString();
        this.results = parcel.createTypedArrayList(ResultsBean.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.message;
    }

    public List<ResultsBean> getResults() {
        return this.results;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResults(List<ResultsBean> list) {
        this.results = list;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.message);
        parcel.writeTypedList(this.results);
    }

    public static class ResultsBean implements Parcelable {
        public static final Parcelable.Creator<ResultsBean> CREATOR = new Parcelable.Creator<ResultsBean>() {
            public ResultsBean createFromParcel(Parcel parcel) {
                return new ResultsBean(parcel);
            }

            public ResultsBean[] newArray(int i2) {
                return new ResultsBean[i2];
            }
        };
        private String description;
        private int id;
        private int limitdevices;
        private float price;
        private long ttl;

        public ResultsBean() {
            this.id = 0;
        }

        public int describeContents() {
            return 0;
        }

        public String getDescription() {
            return this.description;
        }

        public int getId() {
            return this.id;
        }

        public int getLimitdevices() {
            return this.limitdevices;
        }

        public float getPrice() {
            return this.price;
        }

        public long getTtl() {
            return this.ttl;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setLimitdevices(int i2) {
            this.limitdevices = i2;
        }

        public void setPrice(float f2) {
            this.price = f2;
        }

        public void setTtl(long j2) {
            this.ttl = j2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.id);
            parcel.writeString(this.description);
            parcel.writeLong(this.ttl);
            parcel.writeInt(this.limitdevices);
            parcel.writeFloat(this.price);
        }

        protected ResultsBean(Parcel parcel) {
            this.id = parcel.readInt();
            this.description = parcel.readString();
            this.ttl = parcel.readLong();
            this.limitdevices = parcel.readInt();
            this.price = parcel.readFloat();
        }
    }
}
