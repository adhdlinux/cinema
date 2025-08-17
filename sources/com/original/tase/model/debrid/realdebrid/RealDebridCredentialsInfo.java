package com.original.tase.model.debrid.realdebrid;

public class RealDebridCredentialsInfo {
    private String accessToken;
    private String clientId;
    private String clientSecret;
    private String refreshToken;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = r1.clientSecret;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.refreshToken;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r1.clientId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r1 = this;
            java.lang.String r0 = r1.accessToken
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = r1.refreshToken
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = r1.clientId
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = r1.clientSecret
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r0 = 1
            return r0
        L_0x002b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo.isValid():boolean");
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientSecret(String str) {
        this.clientSecret = str;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public String toString() {
        return "RealDebridCredentialsInfo{accessToken='" + this.accessToken + '\'' + ", refreshToken='" + this.refreshToken + '\'' + ", clientId='" + this.clientId + '\'' + ", clientSecret='" + this.clientSecret + '\'' + '}';
    }
}
