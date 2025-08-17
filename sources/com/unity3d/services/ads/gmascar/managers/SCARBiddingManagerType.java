package com.unity3d.services.ads.gmascar.managers;

public enum SCARBiddingManagerType {
    DISABLED("dis"),
    EAGER("eag"),
    LAZY("laz"),
    HYBRID("hyb");
    
    private final String name;

    private static class Constants {
        private static final String DIS = "dis";
        private static final String EAG = "eag";
        private static final String HYB = "hyb";
        private static final String LAZ = "laz";

        private Constants() {
        }
    }

    private SCARBiddingManagerType(String str) {
        this.name = str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType fromName(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case 99470: goto L_0x0028;
                case 100171: goto L_0x001e;
                case 103793: goto L_0x0014;
                case 106917: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0032
        L_0x000a:
            java.lang.String r0 = "laz"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "hyb"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 2
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "eag"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 0
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "dis"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 3
            goto L_0x0033
        L_0x0032:
            r3 = -1
        L_0x0033:
            if (r3 == 0) goto L_0x0042
            if (r3 == r2) goto L_0x003f
            if (r3 == r1) goto L_0x003c
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = DISABLED
            return r3
        L_0x003c:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = HYBRID
            return r3
        L_0x003f:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = LAZY
            return r3
        L_0x0042:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = EAGER
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.fromName(java.lang.String):com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType");
    }

    public String getName() {
        return this.name;
    }
}
