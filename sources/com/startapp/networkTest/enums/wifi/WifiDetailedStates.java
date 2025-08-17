package com.startapp.networkTest.enums.wifi;

import android.net.NetworkInfo;

public enum WifiDetailedStates {
    Unknown,
    IDLE,
    SCANNING,
    CONNECTING,
    AUTHENTICATING,
    OBTAINING_IPADDR,
    CONNECTED,
    SUSPENDED,
    DISCONNECTING,
    DISCONNECTED,
    FAILED,
    BLOCKED,
    VERIFYING_POOR_LINK,
    CAPTIVE_PORTAL_CHECK;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35385a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.net.NetworkInfo$DetailedState[] r0 = android.net.NetworkInfo.DetailedState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35385a = r0
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.AUTHENTICATING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.BLOCKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.DISCONNECTING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.FAILED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0060 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.IDLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x006c }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.OBTAINING_IPADDR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.SCANNING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f35385a     // Catch:{ NoSuchFieldError -> 0x0084 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.SUSPENDED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.networkTest.enums.wifi.WifiDetailedStates.a.<clinit>():void");
        }
    }

    public static WifiDetailedStates a(NetworkInfo.DetailedState detailedState) {
        switch (a.f35385a[detailedState.ordinal()]) {
            case 1:
                return AUTHENTICATING;
            case 2:
                return BLOCKED;
            case 3:
                return CONNECTED;
            case 4:
                return CONNECTING;
            case 5:
                return DISCONNECTED;
            case 6:
                return DISCONNECTING;
            case 7:
                return FAILED;
            case 8:
                return IDLE;
            case 9:
                return OBTAINING_IPADDR;
            case 10:
                return SCANNING;
            case 11:
                return SUSPENDED;
            default:
                WifiDetailedStates wifiDetailedStates = VERIFYING_POOR_LINK;
                if (detailedState.equals(wifiDetailedStates)) {
                    return wifiDetailedStates;
                }
                WifiDetailedStates wifiDetailedStates2 = CAPTIVE_PORTAL_CHECK;
                if (detailedState.equals(wifiDetailedStates2)) {
                    return wifiDetailedStates2;
                }
                return Unknown;
        }
    }
}
