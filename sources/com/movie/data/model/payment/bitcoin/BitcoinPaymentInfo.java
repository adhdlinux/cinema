package com.movie.data.model.payment.bitcoin;

import android.os.Parcel;
import android.os.Parcelable;

public class BitcoinPaymentInfo implements Parcelable {
    public static final Parcelable.Creator<BitcoinPaymentInfo> CREATOR = new Parcelable.Creator<BitcoinPaymentInfo>() {
        public BitcoinPaymentInfo createFromParcel(Parcel parcel) {
            return new BitcoinPaymentInfo(parcel);
        }

        public BitcoinPaymentInfo[] newArray(int i2) {
            return new BitcoinPaymentInfo[i2];
        }
    };
    private String key;
    private ProductBean product;
    private Integer status;

    public static class ProductBean {
        private String description;
        private int id;
        private int limitdevices;
        private int price;
        private long ttl;

        public String getDescription() {
            return this.description;
        }

        public int getId() {
            return this.id;
        }

        public int getLimitdevices() {
            return this.limitdevices;
        }

        public int getPrice() {
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

        public void setPrice(int i2) {
            this.price = i2;
        }

        public void setTtl(long j2) {
            this.ttl = j2;
        }
    }

    protected BitcoinPaymentInfo(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.status = null;
        } else {
            this.status = Integer.valueOf(parcel.readInt());
        }
        this.key = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.key;
    }

    public ProductBean getProduct() {
        return this.product;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setProduct(ProductBean productBean) {
        this.product = productBean;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (this.status == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.status.intValue());
        }
        parcel.writeString(this.key);
    }
}
