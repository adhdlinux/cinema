package com.original.tase.model.trakt;

public class TraktCredentialsInfo {
    private String accessToken;
    private String refreshToken;
    private String user;

    public TraktCredentialsInfo() {
        this.user = "";
        this.accessToken = "";
        this.refreshToken = "";
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getUserName() {
        return this.user;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.refreshToken;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r1 = this;
            java.lang.String r0 = r1.accessToken
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = r1.refreshToken
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.model.trakt.TraktCredentialsInfo.isValid():boolean");
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String toString() {
        return "TraktCredentialsInfo{user='" + this.user + '\'' + ", accessToken='" + this.accessToken + '\'' + ", refreshToken='" + this.refreshToken + '\'' + '}';
    }

    public TraktCredentialsInfo(String str, String str2, String str3) {
        this.user = str;
        this.accessToken = str2;
        this.refreshToken = str3;
    }
}
