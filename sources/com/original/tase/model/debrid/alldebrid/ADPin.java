package com.original.tase.model.debrid.alldebrid;

public class ADPin {
    private DataBean data;
    private String status;

    public static class DataBean {
        private String base_url;
        private String check;
        private String check_url;
        private int expires_in;
        private String pin;
        private String user_url;

        public String getBase_url() {
            return this.base_url;
        }

        public String getCheck() {
            return this.check;
        }

        public String getCheck_url() {
            return this.check_url;
        }

        public int getExpires_in() {
            return this.expires_in;
        }

        public String getPin() {
            return this.pin;
        }

        public String getUser_url() {
            return this.user_url;
        }

        public void setBase_url(String str) {
            this.base_url = str;
        }

        public void setCheck(String str) {
            this.check = str;
        }

        public void setCheck_url(String str) {
            this.check_url = str;
        }

        public void setExpires_in(int i2) {
            this.expires_in = i2;
        }

        public void setPin(String str) {
            this.pin = str;
        }

        public void setUser_url(String str) {
            this.user_url = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
