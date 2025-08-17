package com.original.tase.model.debrid.alldebrid;

public class ADGetTokenResult {
    private DataBean data;
    private String status;

    public static class DataBean {
        private boolean activated;
        private String apikey;
        private int expires_in;

        public String getApikey() {
            return this.apikey;
        }

        public int getExpires_in() {
            return this.expires_in;
        }

        public boolean isActivated() {
            return this.activated;
        }

        public void setActivated(boolean z2) {
            this.activated = z2;
        }

        public void setApikey(String str) {
            this.apikey = str;
        }

        public void setExpires_in(int i2) {
            this.expires_in = i2;
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
