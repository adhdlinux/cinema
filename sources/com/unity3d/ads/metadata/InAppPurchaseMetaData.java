package com.unity3d.ads.metadata;

import android.content.Context;

public class InAppPurchaseMetaData extends MetaData {
    public static final String IAP_KEY = "iap";
    public static final String KEY_CURRENCY = "currency";
    public static final String KEY_PRICE = "price";
    public static final String KEY_PRODUCT_ID = "productId";
    public static final String KEY_RECEIPT_PURCHASE_DATA = "receiptPurchaseData";
    public static final String KEY_SIGNATURE = "signature";

    public InAppPurchaseMetaData(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void commit() {
        /*
            r7 = this;
            android.content.Context r0 = r7._context
            boolean r0 = com.unity3d.services.core.device.StorageManager.init(r0)
            if (r0 == 0) goto L_0x0054
            com.unity3d.services.core.device.StorageManager$StorageType r0 = com.unity3d.services.core.device.StorageManager.StorageType.PUBLIC
            com.unity3d.services.core.device.Storage r0 = com.unity3d.services.core.device.StorageManager.getStorage(r0)
            org.json.JSONObject r1 = r7.getData()
            if (r1 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x0059
            java.lang.String r1 = "iap.purchases"
            java.lang.Object r2 = r0.get(r1)
            if (r2 == 0) goto L_0x0026
            org.json.JSONArray r2 = (org.json.JSONArray) r2     // Catch:{ Exception -> 0x0021 }
            goto L_0x0027
        L_0x0021:
            java.lang.String r2 = "Invalid object type for purchases"
            com.unity3d.services.core.log.DeviceLog.error(r2)
        L_0x0026:
            r2 = 0
        L_0x0027:
            if (r2 != 0) goto L_0x002e
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
        L_0x002e:
            org.json.JSONObject r3 = r7.getData()
            java.lang.String r4 = "ts"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x004e }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x004e }
            r2.put(r3)
            r0.set(r1, r2)
            r0.writeStorage()
            com.unity3d.services.core.device.StorageEvent r2 = com.unity3d.services.core.device.StorageEvent.SET
            java.lang.Object r1 = r0.get(r1)
            r0.sendEvent(r2, r1)
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "Error constructing purchase object"
            com.unity3d.services.core.log.DeviceLog.error(r0)
            return
        L_0x0054:
            java.lang.String r0 = "Unity Ads could not commit metadata due to storage error or the data is null"
            com.unity3d.services.core.log.DeviceLog.error(r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.metadata.InAppPurchaseMetaData.commit():void");
    }

    public synchronized boolean set(String str, Object obj) {
        return setRaw(str, obj);
    }

    public void setCurrency(String str) {
        set("currency", str);
    }

    public void setPrice(Double d2) {
        set(KEY_PRICE, d2);
    }

    public void setProductId(String str) {
        set(KEY_PRODUCT_ID, str);
    }

    public void setReceiptPurchaseData(String str) {
        set(KEY_RECEIPT_PURCHASE_DATA, str);
    }

    public void setSignature(String str) {
        set(KEY_SIGNATURE, str);
    }
}
