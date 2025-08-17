package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.systrace.SystraceMessage;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;

@DoNotStrip
public class ModuleHolder {
    private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);
    private boolean mInitializable;
    private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();
    private boolean mIsCreating;
    private boolean mIsInitializing;
    private NativeModule mModule;
    private final String mName;
    private Provider<? extends NativeModule> mProvider;
    private final ReactModuleInfo mReactModuleInfo;

    public ModuleHolder(ReactModuleInfo reactModuleInfo, Provider<? extends NativeModule> provider) {
        this.mName = reactModuleInfo.name();
        this.mProvider = provider;
        this.mReactModuleInfo = reactModuleInfo;
        if (reactModuleInfo.needsEagerInit()) {
            this.mModule = create();
        }
    }

    private NativeModule create() {
        boolean z2;
        boolean z3 = true;
        if (this.mModule == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        SoftAssertions.assertCondition(z2, "Creating an already created module.");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
        SystraceMessage.beginSection(0, "ModuleHolder.createModule").arg("name", (Object) this.mName).flush();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", this.mName);
        try {
            NativeModule nativeModule = (NativeModule) ((Provider) Assertions.assertNotNull(this.mProvider)).get();
            this.mProvider = null;
            synchronized (this) {
                this.mModule = nativeModule;
                if (!this.mInitializable || this.mIsInitializing) {
                    z3 = false;
                }
            }
            if (z3) {
                doInitialize(nativeModule);
            }
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mName, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
            return nativeModule;
        } catch (Throwable th) {
            try {
                FLog.e("NativeModuleInitError", "Failed to create NativeModule \"" + getName() + "\"", th);
                throw th;
            } catch (Throwable th2) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mName, this.mInstanceKey);
                SystraceMessage.endSection(0).flush();
                throw th2;
            }
        }
    }

    private void doInitialize(NativeModule nativeModule) {
        boolean z2;
        SystraceMessage.beginSection(0, "ModuleHolder.initialize").arg("name", (Object) this.mName).flush();
        ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_START, this.mName, this.mInstanceKey);
        try {
            synchronized (this) {
                if (!this.mInitializable || this.mIsInitializing) {
                    z2 = false;
                } else {
                    z2 = true;
                    this.mIsInitializing = true;
                }
            }
            if (z2) {
                nativeModule.initialize();
                synchronized (this) {
                    this.mIsInitializing = false;
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
        } catch (Throwable th) {
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            SystraceMessage.endSection(0).flush();
            throw th;
        }
    }

    public synchronized void destroy() {
        NativeModule nativeModule = this.mModule;
        if (nativeModule != null) {
            nativeModule.invalidate();
        }
    }

    public boolean getCanOverrideExistingModule() {
        return this.mReactModuleInfo.canOverrideExistingModule();
    }

    public String getClassName() {
        return this.mReactModuleInfo.className();
    }

    public boolean getHasConstants() {
        return this.mReactModuleInfo.hasConstants();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        r0 = create();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.mIsCreating = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0023, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = r2.mModule;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = (com.facebook.react.bridge.NativeModule) com.facebook.infer.annotation.Assertions.assertNotNull(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0036, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0024 */
    @com.facebook.proguard.annotations.DoNotStrip
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.react.bridge.NativeModule r0 = r2.mModule     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return r0
        L_0x0007:
            boolean r0 = r2.mIsCreating     // Catch:{ all -> 0x003b }
            r1 = 0
            if (r0 != 0) goto L_0x0010
            r0 = 1
            r2.mIsCreating = r0     // Catch:{ all -> 0x003b }
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0023
            com.facebook.react.bridge.NativeModule r0 = r2.create()
            monitor-enter(r2)
            r2.mIsCreating = r1     // Catch:{ all -> 0x0020 }
            r2.notifyAll()     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r0
        L_0x0023:
            monitor-enter(r2)
        L_0x0024:
            com.facebook.react.bridge.NativeModule r0 = r2.mModule     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0030
            boolean r1 = r2.mIsCreating     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0030
            r2.wait()     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x0024
        L_0x0030:
            java.lang.Object r0 = com.facebook.infer.annotation.Assertions.assertNotNull(r0)     // Catch:{ all -> 0x0038 }
            com.facebook.react.bridge.NativeModule r0 = (com.facebook.react.bridge.NativeModule) r0     // Catch:{ all -> 0x0038 }
            monitor-exit(r2)     // Catch:{ all -> 0x0038 }
            return r0
        L_0x0038:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0038 }
            throw r0
        L_0x003b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ModuleHolder.getModule():com.facebook.react.bridge.NativeModule");
    }

    @DoNotStrip
    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasInstance() {
        boolean z2;
        if (this.mModule != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public boolean isCxxModule() {
        return this.mReactModuleInfo.isCxxModule();
    }

    public boolean isTurboModule() {
        return this.mReactModuleInfo.isTurboModule();
    }

    /* access modifiers changed from: package-private */
    public void markInitializable() {
        boolean z2;
        NativeModule nativeModule;
        synchronized (this) {
            z2 = true;
            this.mInitializable = true;
            boolean z3 = false;
            if (this.mModule != null) {
                if (!this.mIsInitializing) {
                    z3 = true;
                }
                Assertions.assertCondition(z3);
                nativeModule = this.mModule;
            } else {
                nativeModule = null;
                z2 = false;
            }
        }
        if (z2) {
            doInitialize(nativeModule);
        }
    }

    public ModuleHolder(NativeModule nativeModule) {
        String name = nativeModule.getName();
        this.mName = name;
        this.mReactModuleInfo = new ReactModuleInfo(nativeModule.getName(), nativeModule.getClass().getSimpleName(), nativeModule.canOverrideExistingModule(), true, true, CxxModuleWrapper.class.isAssignableFrom(nativeModule.getClass()), TurboModule.class.isAssignableFrom(nativeModule.getClass()));
        this.mModule = nativeModule;
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.NATIVE_MODULE, "NativeModule init: %s", name);
    }
}
