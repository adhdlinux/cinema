package com.unity3d.services.store;

import android.annotation.TargetApi;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.store.core.StoreExceptionHandler;
import com.unity3d.services.store.core.StoreLifecycleListener;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.IBillingClientStateListener;
import com.unity3d.services.store.gpbl.StoreBilling;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import com.unity3d.services.store.listeners.IPurchaseHistoryResponseListener;
import com.unity3d.services.store.listeners.IPurchaseUpdatedResponseListener;
import com.unity3d.services.store.listeners.ISkuDetailsResponseListener;
import com.unity3d.services.store.listeners.PurchasesResponseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

@TargetApi(14)
public class StoreMonitor {
    /* access modifiers changed from: private */
    public static AtomicBoolean _isInitialized = new AtomicBoolean(false);
    private static StoreLifecycleListener _lifecycleListener;
    private static StoreBilling _storeBilling;
    private static StoreExceptionHandler _storeExceptionHandler;

    public static void getPurchaseHistory(final int i2, String str, int i3) {
        try {
            _storeBilling.getPurchaseHistory(str, i3, new IPurchaseHistoryResponseListener() {
                public void onBillingResponse(BillingResultBridge billingResultBridge, List<PurchaseHistoryRecordBridge> list) {
                    JSONArray jSONArray = new JSONArray();
                    if (list != null) {
                        for (PurchaseHistoryRecordBridge originalJson : list) {
                            jSONArray.put(originalJson.getOriginalJson());
                        }
                    }
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_HISTORY_LIST_REQUEST_RESULT, Integer.valueOf(i2), jSONArray);
                }
            });
        } catch (Exception e2) {
            _storeExceptionHandler.handleStoreException(StoreEvent.PURCHASE_HISTORY_LIST_REQUEST_ERROR, i2, e2);
        }
    }

    public static void getPurchases(int i2, String str) {
        try {
            _storeBilling.getPurchases(str, new PurchasesResponseListener(Integer.valueOf(i2), StoreEvent.PURCHASES_REQUEST_RESULT, StoreEvent.PURCHASES_REQUEST_ERROR));
        } catch (Exception e2) {
            _storeExceptionHandler.handleStoreException(StoreEvent.PURCHASES_REQUEST_ERROR, i2, e2);
        }
    }

    public static void getSkuDetails(final int i2, String str, ArrayList<String> arrayList) {
        try {
            _storeBilling.getSkuDetails(str, arrayList, new ISkuDetailsResponseListener() {
                public void onBillingResponse(BillingResultBridge billingResultBridge, List<SkuDetailsBridge> list) {
                    JSONArray jSONArray = new JSONArray();
                    if (list != null) {
                        for (SkuDetailsBridge originalJson : list) {
                            jSONArray.put(originalJson.getOriginalJson());
                        }
                    }
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.SKU_DETAILS_LIST_REQUEST_RESULT, Integer.valueOf(i2), jSONArray);
                }
            });
        } catch (Exception e2) {
            _storeExceptionHandler.handleStoreException(StoreEvent.SKU_DETAILS_LIST_REQUEST_ERROR, i2, e2);
        }
    }

    public static void initialize(StoreExceptionHandler storeExceptionHandler) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (_isInitialized.get()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZATION_REQUEST_RESULT, Integer.valueOf(BillingResultResponseCode.OK.getResponseCode()));
            return;
        }
        _storeExceptionHandler = storeExceptionHandler;
        StoreBilling storeBilling = new StoreBilling(ClientProperties.getApplicationContext(), new IPurchaseUpdatedResponseListener() {
            public void onBillingResponse(BillingResultBridge billingResultBridge, List<PurchaseBridge> list) {
                if (billingResultBridge.getResponseCode() == BillingResultResponseCode.OK) {
                    JSONArray jSONArray = new JSONArray();
                    if (list != null) {
                        for (PurchaseBridge json : list) {
                            jSONArray.put(json.toJson());
                        }
                    }
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASES_UPDATED_RESULT, jSONArray);
                    return;
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASES_UPDATED_ERROR, billingResultBridge.getResponseCode());
            }
        });
        _storeBilling = storeBilling;
        storeBilling.initialize(new IBillingClientStateListener() {
            public void onBillingServiceDisconnected() {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.DISCONNECTED_RESULT, new Object[0]);
            }

            public void onBillingSetupFinished(BillingResultBridge billingResultBridge) {
                if (billingResultBridge.getResponseCode() == BillingResultResponseCode.OK) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZATION_REQUEST_RESULT, billingResultBridge.getResponseCode());
                    StoreMonitor._isInitialized.set(true);
                    return;
                }
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZATION_REQUEST_FAILED, billingResultBridge.getResponseCode());
            }
        });
    }

    public static int isFeatureSupported(int i2, String str) {
        int i3 = -1;
        try {
            i3 = _storeBilling.isFeatureSupported(str);
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.IS_FEATURE_SUPPORTED_REQUEST_RESULT, Integer.valueOf(i2), Integer.valueOf(i3));
            return i3;
        } catch (Exception e2) {
            _storeExceptionHandler.handleStoreException(StoreEvent.IS_FEATURE_SUPPORTED_REQUEST_ERROR, i2, e2);
            return i3;
        }
    }

    public static boolean isInitialized() {
        return _isInitialized.get();
    }

    public static void startPurchaseTracking(ArrayList<String> arrayList) {
        if (_lifecycleListener != null) {
            stopPurchaseTracking();
        }
        _lifecycleListener = new StoreLifecycleListener(arrayList, _storeBilling);
        ClientProperties.getApplication().registerActivityLifecycleCallbacks(_lifecycleListener);
    }

    public static void stopPurchaseTracking() {
        if (_lifecycleListener != null) {
            ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(_lifecycleListener);
            _lifecycleListener = null;
        }
    }
}
