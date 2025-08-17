package com.original.tase.model.CloudFlare;

import com.google.gson.annotations.SerializedName;

public class CfChlOpt {
    private String cHash;
    private CRqBean cRq;
    private int chC = 0;
    private int chCAS = 0;
    private ChLogBean chLog = new ChLogBean();
    private String chReq;
    private String cvId;
    private int oV = 1;

    public static class CRqBean {

        /* renamed from: d  reason: collision with root package name */
        private String f34042d;

        /* renamed from: i1  reason: collision with root package name */
        private String f34043i1;
        private String i2;

        /* renamed from: m  reason: collision with root package name */
        private String f34044m;

        /* renamed from: t  reason: collision with root package name */
        private String f34045t;

        public String getD() {
            return this.f34042d;
        }

        public String getI1() {
            return this.f34043i1;
        }

        public String getI2() {
            return this.i2;
        }

        public String getM() {
            return this.f34044m;
        }

        public String getT() {
            return this.f34045t;
        }

        public void setD(String str) {
            this.f34042d = str;
        }

        public void setI1(String str) {
            this.f34043i1 = str;
        }

        public void setI2(String str) {
            this.i2 = str;
        }

        public void setM(String str) {
            this.f34044m = str;
        }

        public void setT(String str) {
            this.f34045t = str;
        }
    }

    public static class ChLogBean {
        @SerializedName("0")
        private CfChlOpt$ChLogBean$_$0Bean _$0 = new CfChlOpt$ChLogBean$_$0Bean();

        /* renamed from: c  reason: collision with root package name */
        private int f34046c = 1;

        public int getC() {
            return this.f34046c;
        }

        public CfChlOpt$ChLogBean$_$0Bean get_$0() {
            return this._$0;
        }

        public void setC(int i2) {
            this.f34046c = i2;
        }

        public void set_$0(CfChlOpt$ChLogBean$_$0Bean cfChlOpt$ChLogBean$_$0Bean) {
            this._$0 = cfChlOpt$ChLogBean$_$0Bean;
        }
    }

    public String getCHash() {
        return this.cHash;
    }

    public CRqBean getCRq() {
        return this.cRq;
    }

    public int getChC() {
        return this.chC;
    }

    public int getChCAS() {
        return this.chCAS;
    }

    public ChLogBean getChLog() {
        return this.chLog;
    }

    public String getChReq() {
        return this.chReq;
    }

    public String getCvId() {
        return this.cvId;
    }

    public int getOV() {
        return this.oV;
    }

    public void setCHash(String str) {
        this.cHash = str;
    }

    public void setCRq(CRqBean cRqBean) {
        this.cRq = cRqBean;
    }

    public void setChC(int i2) {
        this.chC = i2;
    }

    public void setChCAS(int i2) {
        this.chCAS = i2;
    }

    public void setChLog(ChLogBean chLogBean) {
        this.chLog = chLogBean;
    }

    public void setChReq(String str) {
        this.chReq = str;
    }

    public void setCvId(String str) {
        this.cvId = str;
    }

    public void setOV(int i2) {
        this.oV = i2;
    }
}
