package com.original.tase.model.debrid.alldebrid;

public class ADUserInfor {
    private DataBean data;
    private String status;

    public static class DataBean {
        private UserBean user;

        public static class UserBean {
            private String email;
            private int fidelityPoints;
            private boolean isPremium;
            private boolean isTrial;
            private String lang;
            private LimitedHostersQuotasBean limitedHostersQuotas;
            private String preferedDomain;
            private String premiumUntil;
            private String username;

            public static class LimitedHostersQuotasBean {
                private int oneLast;
                private int otherHost;
                private int someHost;

                public int getOneLast() {
                    return this.oneLast;
                }

                public int getOtherHost() {
                    return this.otherHost;
                }

                public int getSomeHost() {
                    return this.someHost;
                }

                public void setOneLast(int i2) {
                    this.oneLast = i2;
                }

                public void setOtherHost(int i2) {
                    this.otherHost = i2;
                }

                public void setSomeHost(int i2) {
                    this.someHost = i2;
                }
            }

            public String getEmail() {
                return this.email;
            }

            public int getFidelityPoints() {
                return this.fidelityPoints;
            }

            public String getLang() {
                return this.lang;
            }

            public LimitedHostersQuotasBean getLimitedHostersQuotas() {
                return this.limitedHostersQuotas;
            }

            public String getPreferedDomain() {
                return this.preferedDomain;
            }

            public String getPremiumUntil() {
                return this.premiumUntil;
            }

            public String getUsername() {
                return this.username;
            }

            public boolean isIsPremium() {
                return this.isPremium;
            }

            public boolean isIsTrial() {
                return this.isTrial;
            }

            public void setEmail(String str) {
                this.email = str;
            }

            public void setFidelityPoints(int i2) {
                this.fidelityPoints = i2;
            }

            public void setIsPremium(boolean z2) {
                this.isPremium = z2;
            }

            public void setIsTrial(boolean z2) {
                this.isTrial = z2;
            }

            public void setLang(String str) {
                this.lang = str;
            }

            public void setLimitedHostersQuotas(LimitedHostersQuotasBean limitedHostersQuotasBean) {
                this.limitedHostersQuotas = limitedHostersQuotasBean;
            }

            public void setPreferedDomain(String str) {
                this.preferedDomain = str;
            }

            public void setPremiumUntil(String str) {
                this.premiumUntil = str;
            }

            public void setUsername(String str) {
                this.username = str;
            }
        }

        public UserBean getUser() {
            return this.user;
        }

        public void setUser(UserBean userBean) {
            this.user = userBean;
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
