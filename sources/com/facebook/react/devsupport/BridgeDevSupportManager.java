package com.facebook.react.devsupport;

import android.content.Context;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSplitBundleCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.packagerconnection.RequestHandler;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BridgeDevSupportManager extends DevSupportManagerBase {
    private boolean mIsSamplingProfilerEnabled = false;

    public BridgeDevSupportManager(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z2, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i2, Map<String, RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory) {
        super(context, reactInstanceDevHelper, str, z2, redBoxHandler, devBundleDownloadListener, i2, map, surfaceDelegateFactory);
        String str2;
        String str3;
        if (getDevSettings().isStartSamplingProfilerOnInit()) {
            if (!this.mIsSamplingProfilerEnabled) {
                toggleJSSamplingProfiler();
            } else {
                Toast.makeText(context, "JS Sampling Profiler was already running, so did not start the sampling profiler", 1).show();
            }
        }
        if (this.mIsSamplingProfilerEnabled) {
            str2 = "Disable Sampling Profiler";
        } else {
            str2 = "Enable Sampling Profiler";
        }
        addCustomDevOption(str2, new DevOptionHandler() {
            public void onOptionSelected() {
                BridgeDevSupportManager.this.toggleJSSamplingProfiler();
            }
        });
        if (!getDevSettings().isDeviceDebugEnabled()) {
            if (getDevSettings().isRemoteJSDebugEnabled()) {
                str3 = context.getString(R.string.catalyst_debug_stop);
            } else {
                str3 = context.getString(R.string.catalyst_debug);
            }
            addCustomDevOption(str3, new DevOptionHandler() {
                public void onOptionSelected() {
                    BridgeDevSupportManager.this.getDevSettings().setRemoteJSDebugEnabled(!BridgeDevSupportManager.this.getDevSettings().isRemoteJSDebugEnabled());
                    BridgeDevSupportManager.this.handleReloadJS();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback() {
            public void onFailure(Throwable th) {
                BridgeDevSupportManager.this.hideDevLoadingView();
                FLog.e(ReactConstants.TAG, "Failed to connect to debugger!", th);
                simpleSettableFuture.setException(new IOException(BridgeDevSupportManager.this.getApplicationContext().getString(R.string.catalyst_debug_error), th));
            }

            public void onSuccess() {
                simpleSettableFuture.set(Boolean.TRUE);
                BridgeDevSupportManager.this.hideDevLoadingView();
            }
        };
    }

    private void reloadJSInProxyMode() {
        getDevServerHelper().launchJSDevtools();
        getReactInstanceDevHelper().onReloadWithJSDebugger(new JavaJSExecutor.Factory() {
            public JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(BridgeDevSupportManager.this.getDevServerHelper().getWebsocketProxyURL(), BridgeDevSupportManager.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e2) {
                    throw ((Exception) e2.getCause());
                } catch (InterruptedException | TimeoutException e3) {
                    throw new RuntimeException(e3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r1 = getApplicationContext();
        android.widget.Toast.makeText(r1, r0.toString() + " does not support Sampling Profiler", 1).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r7.mIsSamplingProfilerEnabled = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toggleJSSamplingProfiler() {
        /*
            r7 = this;
            com.facebook.react.devsupport.ReactInstanceDevHelper r0 = r7.getReactInstanceDevHelper()
            com.facebook.react.bridge.JavaScriptExecutorFactory r0 = r0.getJavaScriptExecutorFactory()
            boolean r1 = r7.mIsSamplingProfilerEnabled
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0048
            r0.startSamplingProfiler()     // Catch:{ UnsupportedOperationException -> 0x0024 }
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ UnsupportedOperationException -> 0x0024 }
            java.lang.String r4 = "Starting Sampling Profiler"
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r4, r2)     // Catch:{ UnsupportedOperationException -> 0x0024 }
            r1.show()     // Catch:{ UnsupportedOperationException -> 0x0024 }
        L_0x001e:
            r7.mIsSamplingProfilerEnabled = r3
            goto L_0x00a8
        L_0x0022:
            r0 = move-exception
            goto L_0x0045
        L_0x0024:
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r2.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0022 }
            r2.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = " does not support Sampling Profiler"
            r2.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0022 }
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)     // Catch:{ all -> 0x0022 }
            r0.show()     // Catch:{ all -> 0x0022 }
            goto L_0x001e
        L_0x0045:
            r7.mIsSamplingProfilerEnabled = r3
            throw r0
        L_0x0048:
            java.lang.String r1 = "sampling-profiler-trace"
            java.lang.String r4 = ".cpuprofile"
            android.content.Context r5 = r7.getApplicationContext()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.io.File r5 = r5.getCacheDir()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.io.File r1 = java.io.File.createTempFile(r1, r4, r5)     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.lang.String r1 = r1.getPath()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            r0.stopSamplingProfiler(r1)     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            android.content.Context r4 = r7.getApplicationContext()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            r5.<init>()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.lang.String r6 = "Saved results from Profiler to "
            r5.append(r6)     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            r5.append(r1)     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            android.widget.Toast r1 = android.widget.Toast.makeText(r4, r1, r3)     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            r1.show()     // Catch:{ IOException -> 0x009f, UnsupportedOperationException -> 0x007e }
            goto L_0x00a6
        L_0x007c:
            r0 = move-exception
            goto L_0x00a9
        L_0x007e:
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r4.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007c }
            r4.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = "does not support Sampling Profiler"
            r4.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x007c }
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)     // Catch:{ all -> 0x007c }
            r0.show()     // Catch:{ all -> 0x007c }
            goto L_0x00a6
        L_0x009f:
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Could not create temporary file for saving results from Sampling Profiler"
            com.facebook.common.logging.FLog.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x007c }
        L_0x00a6:
            r7.mIsSamplingProfilerEnabled = r2
        L_0x00a8:
            return
        L_0x00a9:
            r7.mIsSamplingProfilerEnabled = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BridgeDevSupportManager.toggleJSSamplingProfiler():void");
    }

    /* access modifiers changed from: protected */
    public String getUniqueTag() {
        return "Bridge";
    }

    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, getDevSettings().getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (getDevSettings().isRemoteJSDebugEnabled()) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
            showDevLoadingViewForRemoteJSEnabled();
            reloadJSInProxyMode();
            return;
        }
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
        reloadJSFromServer(getDevServerHelper().getDevServerBundleURL((String) Assertions.assertNotNull(getJSAppBundleName())));
    }

    public void loadSplitBundleFromServer(final String str, final DevSplitBundleCallback devSplitBundleCallback) {
        fetchSplitBundleAndCreateBundleLoader(str, new DevSupportManagerBase.CallbackWithBundleLoader() {
            public void onError(String str, Throwable th) {
                devSplitBundleCallback.onError(str, th);
            }

            public void onSuccess(JSBundleLoader jSBundleLoader) {
                jSBundleLoader.loadScript(BridgeDevSupportManager.this.getCurrentContext().getCatalystInstance());
                ((HMRClient) BridgeDevSupportManager.this.getCurrentContext().getJSModule(HMRClient.class)).registerBundle(BridgeDevSupportManager.this.getDevServerHelper().getDevServerSplitBundleURL(str));
                devSplitBundleCallback.onSuccess();
            }
        });
    }
}
