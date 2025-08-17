package com.original.tase.model.debrid.premiumize;

import com.google.gson.annotations.SerializedName;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

public class PremiumizeUserInfo {
    private String customer_id;
    private float limit_used;
    @SerializedName("premium_until")
    private Object premium_until;
    private float space_used;
    private String status;

    public String getCustomer_id() {
        return this.customer_id;
    }

    public float getLimit_used() {
        return this.limit_used;
    }

    public long getLongPremium_until() {
        try {
            return (long) Double.parseDouble(this.premium_until.toString());
        } catch (Exception unused) {
            return 0;
        }
    }

    public Object getPremium_until() {
        return this.premium_until;
    }

    public float getSpace_used() {
        return this.space_used;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCustomer_id(String str) {
        this.customer_id = str;
    }

    public void setLimit_used(float f2) {
        this.limit_used = f2;
    }

    public void setPremium_until(Object obj) {
        this.premium_until = obj;
    }

    public void setSpace_used(float f2) {
        this.space_used = f2;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        OffsetDateTime offsetDateTime;
        String str;
        try {
            offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond((long) Double.parseDouble(this.premium_until.toString()), 0), ZoneId.systemDefault());
        } catch (Exception unused) {
            offsetDateTime = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Premiumize authorized \nCustomer id: ");
        sb.append(this.customer_id);
        sb.append("\nPremium until: ");
        if (offsetDateTime == null) {
            str = this.premium_until.toString();
        } else {
            str = offsetDateTime.toLocalDateTime().toString();
        }
        sb.append(str);
        sb.append("\nLimit used: ");
        sb.append(this.limit_used);
        sb.append("\nSpace used: ");
        sb.append(this.space_used);
        return sb.toString();
    }
}
