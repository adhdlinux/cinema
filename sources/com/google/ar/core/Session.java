package com.google.ar.core;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.google.ar.core.Anchor;
import com.google.ar.core.Config;
import com.google.ar.core.HostCloudAnchorFuture;
import com.google.ar.core.ResolveCloudAnchorFuture;
import com.google.ar.core.VpsAvailabilityFuture;
import com.google.ar.core.annotations.UsedByNative;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.PlaybackFailedException;
import com.google.ar.core.exceptions.RecordingFailedException;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Session {
    private static final String TAG = "ARCore-Session";
    final p faceCache;
    final long nativeSymbolTableHandle;
    long nativeWrapperHandle;
    private SharedCamera sharedCamera;

    public enum Feature {
        FRONT_CAMERA(1),
        SHARED_CAMERA(1000);
        
        final int nativeCode;

        private Feature(int i2) {
            this.nativeCode = i2;
        }
    }

    public enum FeatureMapQuality {
        INSUFFICIENT(0),
        SUFFICIENT(1),
        GOOD(2);
        
        final int nativeCode;

        private FeatureMapQuality(int i2) {
            this.nativeCode = i2;
        }

        static FeatureMapQuality forNumber(int i2) {
            for (FeatureMapQuality featureMapQuality : values()) {
                if (featureMapQuality.nativeCode == i2) {
                    return featureMapQuality;
                }
            }
            throw new FatalException(p.b((byte) 53, i2, "Unexpected value for native FeatureMapQuality, value="));
        }
    }

    protected Session() {
        this.faceCache = new p();
        this.sharedCamera = null;
        this.nativeWrapperHandle = 0;
        this.nativeSymbolTableHandle = 0;
    }

    @Deprecated
    public static Session createForSharedCamera(Context context) throws UnavailableArcoreNotInstalledException, UnavailableApkTooOldException, UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException {
        return new Session(context, EnumSet.of(Feature.SHARED_CAMERA));
    }

    static ByteBuffer directByteBufferOrDefault(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
        }
        return byteBuffer.order(ByteOrder.nativeOrder());
    }

    static void loadDynamicSymbolsAfterSessionCreate() {
        if (Build.VERSION.SDK_INT >= 24) {
            ArImage.nativeLoadSymbols();
            ImageMetadata.nativeLoadSymbols();
        }
    }

    private native long[] nativeAcquireAllAnchors(long j2);

    private native long nativeAcquireEarth(long j2);

    private native int nativeCheckModuleAvailability(long j2, int i2);

    private native void nativeCloseSession(long j2);

    private native void nativeConfigure(long j2, long j3);

    private native long nativeCreateAnchor(long j2, Pose pose);

    private static native long nativeCreateSessionAndWrapperWithFeatures(Context context, int[] iArr) throws UnavailableArcoreNotInstalledException, UnavailableApkTooOldException, UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException;

    static native long nativeCreateSessionWrapperFromHandle(long j2, long j3);

    private native int nativeEstimateFeatureMapQualityForHosting(long j2, Pose pose);

    private native long nativeGetCameraConfig(long j2);

    private native void nativeGetConfig(long j2, long j3);

    private native int nativeGetPlaybackStatus(long j2);

    private native void nativeGetRandomAccessStats(long j2, long j3);

    private native int nativeGetRecordingStatus(long j2);

    private native long[] nativeGetSupportedCameraConfigs(long j2);

    private native long[] nativeGetSupportedCameraConfigsWithFilter(long j2, long j3);

    private native long nativeGetSymbolTable(long j2);

    private native long nativeHostCloudAnchor(long j2, long j3);

    private native long[] nativeHostCloudAnchorAsync(long j2, long j3, int i2, HostCloudAnchorFuture.CallbackWrapper callbackWrapper);

    private native long nativeHostCloudAnchorWithTtl(long j2, long j3, int i2);

    private native boolean nativeIsSupported(long j2, long j3);

    private native void nativePause(long j2);

    private native void nativeRequestModuleInstallDeferred(long j2, int[] iArr);

    private native void nativeRequestModuleInstallImmediate(long j2, int[] iArr);

    private native long nativeResolveCloudAnchor(long j2, String str);

    private native long[] nativeResolveCloudAnchorAsync(long j2, String str, ResolveCloudAnchorFuture.CallbackWrapper callbackWrapper);

    private native void nativeResume(long j2);

    private native int nativeSetCameraConfig(long j2, long j3);

    private native void nativeSetCameraTextureName(long j2, int i2);

    private native void nativeSetCameraTextureNames(long j2, int[] iArr);

    private native void nativeSetDisplayGeometry(long j2, int i2, int i3, int i4);

    private native void nativeSetPlaybackDataset(long j2, String str);

    private native void nativeSetPlaybackDatasetUri(long j2, String str);

    private native void nativeStartRecording(long j2, long j3);

    private native void nativeStopRecording(long j2);

    private native void nativeUpdate(long j2, long j3);

    private void pauseSharedCameraIfInUse() {
        SharedCamera sharedCamera2 = this.sharedCamera;
        if (sharedCamera2 != null) {
            sharedCamera2.pause();
        }
    }

    static void throwExceptionFromArStatus(int i2) throws Exception {
        throwExceptionFromArStatus((String) null, i2, (String[]) null, (int[]) null);
    }

    public VpsAvailabilityFuture checkVpsAvailabilityAsync(double d2, double d3, Consumer<VpsAvailability> consumer) {
        VpsAvailabilityFuture.CallbackWrapper callbackWrapper;
        if (consumer != null) {
            callbackWrapper = new VpsAvailabilityFuture.CallbackWrapper(consumer);
        } else {
            callbackWrapper = null;
        }
        long[] nativeCheckVpsAvailabilityAsync = nativeCheckVpsAvailabilityAsync(this.nativeWrapperHandle, d2, d3, callbackWrapper);
        return new VpsAvailabilityFuture(this, nativeCheckVpsAvailabilityAsync[0], nativeCheckVpsAvailabilityAsync[1]);
    }

    public void close() {
        nativeCloseSession(this.nativeWrapperHandle);
    }

    public void configure(Config config) {
        nativeConfigure(this.nativeWrapperHandle, config.nativeHandle);
    }

    /* access modifiers changed from: package-private */
    public Collection<Anchor> convertNativeAnchorsToCollection(long[] jArr) {
        ArrayList arrayList = new ArrayList(r1);
        for (long anchor : jArr) {
            arrayList.add(new Anchor(anchor, this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public List<CameraConfig> convertNativeCameraConfigsToCollection(long[] jArr) {
        ArrayList arrayList = new ArrayList(r1);
        for (long cameraConfig : jArr) {
            arrayList.add(new CameraConfig(this, cameraConfig));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public Collection<TrackData> convertNativeTrackDataToCollection(long[] jArr) {
        ArrayList arrayList = new ArrayList(r1);
        for (long trackData : jArr) {
            arrayList.add(new TrackData(trackData, this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public <T extends Trackable> Collection<T> convertNativeTrackablesToCollection(Class<T> cls, long[] jArr) {
        ArrayList arrayList = new ArrayList(r1);
        for (long createTrackable : jArr) {
            Trackable createTrackable2 = createTrackable(createTrackable);
            if (createTrackable2 != null) {
                arrayList.add((Trackable) cls.cast(createTrackable2));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Anchor createAnchor(Pose pose) {
        return new Anchor(nativeCreateAnchor(this.nativeWrapperHandle, pose), this);
    }

    /* access modifiers changed from: package-private */
    public Trackable createTrackable(long j2) {
        ai aiVar;
        int internalGetType = TrackableBase.internalGetType(this.nativeWrapperHandle, j2);
        ai[] values = ai.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                aiVar = null;
                break;
            }
            aiVar = values[i2];
            if (aiVar.f30302b == internalGetType) {
                break;
            }
            i2++;
        }
        if (aiVar == null) {
            TrackableBase.internalReleaseNativeHandle(this.nativeSymbolTableHandle, j2);
            return null;
        }
        switch (aiVar.ordinal()) {
            case 0:
            case 1:
                return null;
            case 2:
                return new Plane(j2, this);
            case 3:
                return new Point(j2, this);
            case 4:
                return new AugmentedImage(j2, this);
            case 5:
                return this.faceCache.a(j2, this);
            case 6:
                return new StreetscapeGeometry(j2, this);
            case 7:
                return getEarth();
            case 8:
                return new DepthPoint(j2, this);
            case 9:
                return new InstantPlacementPoint(j2, this);
            default:
                throw null;
        }
    }

    public FeatureMapQuality estimateFeatureMapQualityForHosting(Pose pose) {
        return FeatureMapQuality.forNumber(nativeEstimateFeatureMapQualityForHosting(this.nativeWrapperHandle, pose));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeWrapperHandle;
        if (j2 != 0) {
            nativeDestroySessionWrapper(j2);
            this.nativeWrapperHandle = 0;
        }
        super.finalize();
    }

    public Collection<Anchor> getAllAnchors() {
        return convertNativeAnchorsToCollection(nativeAcquireAllAnchors(this.nativeWrapperHandle));
    }

    public <T extends Trackable> Collection<T> getAllTrackables(Class<T> cls) {
        ai a2 = ai.a(cls);
        if (a2 == ai.UNKNOWN_TO_JAVA) {
            return Collections.emptyList();
        }
        return convertNativeTrackablesToCollection(cls, nativeAcquireAllTrackables(this.nativeWrapperHandle, a2.f30302b));
    }

    public CameraConfig getCameraConfig() {
        return new CameraConfig(this, nativeGetCameraConfig(this.nativeWrapperHandle));
    }

    public Config getConfig() {
        Config config = new Config(this);
        getConfig(config);
        return config;
    }

    public Earth getEarth() {
        long nativeAcquireEarth = nativeAcquireEarth(this.nativeWrapperHandle);
        if (nativeAcquireEarth != 0) {
            return new Earth(nativeAcquireEarth, this);
        }
        return null;
    }

    public PlaybackStatus getPlaybackStatus() {
        return PlaybackStatus.forNumber(nativeGetPlaybackStatus(this.nativeWrapperHandle));
    }

    public RecordingStatus getRecordingStatus() {
        return RecordingStatus.forNumber(nativeGetRecordingStatus(this.nativeWrapperHandle));
    }

    public SharedCamera getSharedCamera() {
        SharedCamera sharedCamera2 = this.sharedCamera;
        if (sharedCamera2 != null) {
            return sharedCamera2;
        }
        throw new IllegalStateException("Shared camera is not in use, please create session using new Session(context, EnumSet.of(Session.Feature.SHARED_CAMERA)).");
    }

    @Deprecated
    public List<CameraConfig> getSupportedCameraConfigs() {
        return convertNativeCameraConfigsToCollection(nativeGetSupportedCameraConfigs(this.nativeWrapperHandle));
    }

    @Deprecated
    public Anchor hostCloudAnchor(Anchor anchor) {
        return new Anchor(nativeHostCloudAnchor(this.nativeWrapperHandle, anchor.nativeHandle), this);
    }

    public HostCloudAnchorFuture hostCloudAnchorAsync(Anchor anchor, int i2, BiConsumer<String, Anchor.CloudAnchorState> biConsumer) {
        HostCloudAnchorFuture.CallbackWrapper callbackWrapper;
        if (biConsumer != null) {
            callbackWrapper = new HostCloudAnchorFuture.CallbackWrapper(biConsumer);
        } else {
            callbackWrapper = null;
        }
        long[] nativeHostCloudAnchorAsync = nativeHostCloudAnchorAsync(this.nativeWrapperHandle, anchor.nativeHandle, i2, callbackWrapper);
        return new HostCloudAnchorFuture(this, nativeHostCloudAnchorAsync[0], nativeHostCloudAnchorAsync[1]);
    }

    @Deprecated
    public Anchor hostCloudAnchorWithTtl(Anchor anchor, int i2) {
        return new Anchor(nativeHostCloudAnchorWithTtl(this.nativeWrapperHandle, anchor.nativeHandle, i2), this);
    }

    public boolean isDepthModeSupported(Config.DepthMode depthMode) {
        return nativeIsDepthModeSupported(this.nativeWrapperHandle, depthMode.nativeCode);
    }

    public boolean isGeospatialModeSupported(Config.GeospatialMode geospatialMode) {
        return nativeIsGeospatialModeSupported(this.nativeWrapperHandle, geospatialMode.nativeCode);
    }

    public boolean isImageStabilizationModeSupported(Config.ImageStabilizationMode imageStabilizationMode) {
        return nativeIsImageStabilizationModeSupported(this.nativeWrapperHandle, imageStabilizationMode.nativeCode);
    }

    public boolean isSemanticModeSupported(Config.SemanticMode semanticMode) {
        return nativeIsSemanticModeSupported(this.nativeWrapperHandle, semanticMode.nativeCode);
    }

    /* access modifiers changed from: package-private */
    public boolean isSharedCameraUsed() {
        return this.sharedCamera != null;
    }

    @Deprecated
    public boolean isSupported(Config config) {
        return nativeIsSupported(this.nativeWrapperHandle, config.nativeHandle);
    }

    /* access modifiers changed from: package-private */
    public native long[] nativeAcquireAllTrackables(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native long[] nativeCheckVpsAvailabilityAsync(long j2, double d2, double d3, VpsAvailabilityFuture.CallbackWrapper callbackWrapper);

    /* access modifiers changed from: package-private */
    public native void nativeDestroySessionWrapper(long j2);

    /* access modifiers changed from: package-private */
    public native long nativeGetSessionNativeHandle(long j2);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsDepthModeSupported(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsGeospatialModeSupported(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsImageStabilizationModeSupported(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsSemanticModeSupported(long j2, int i2);

    /* access modifiers changed from: package-private */
    public native long nativeReleaseSessionOwnership(long j2);

    public void pause() {
        pauseSharedCameraIfInUse();
        nativePause(this.nativeWrapperHandle);
    }

    @Deprecated
    public Anchor resolveCloudAnchor(String str) {
        return new Anchor(nativeResolveCloudAnchor(this.nativeWrapperHandle, str), this);
    }

    public ResolveCloudAnchorFuture resolveCloudAnchorAsync(String str, BiConsumer<Anchor, Anchor.CloudAnchorState> biConsumer) {
        ResolveCloudAnchorFuture.CallbackWrapper callbackWrapper;
        if (biConsumer != null) {
            callbackWrapper = new ResolveCloudAnchorFuture.CallbackWrapper(this, biConsumer);
        } else {
            callbackWrapper = null;
        }
        long[] nativeResolveCloudAnchorAsync = nativeResolveCloudAnchorAsync(this.nativeWrapperHandle, str, callbackWrapper);
        return new ResolveCloudAnchorFuture(this, nativeResolveCloudAnchorAsync[0], nativeResolveCloudAnchorAsync[1]);
    }

    public void resume() throws CameraNotAvailableException {
        nativeResume(this.nativeWrapperHandle);
    }

    public void setCameraConfig(CameraConfig cameraConfig) {
        nativeSetCameraConfig(this.nativeWrapperHandle, cameraConfig.nativeHandle);
    }

    public void setCameraTextureName(int i2) {
        nativeSetCameraTextureName(this.nativeWrapperHandle, i2);
    }

    public void setCameraTextureNames(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("textureIds must be an array with at least 1 entry.");
        }
        nativeSetCameraTextureNames(this.nativeWrapperHandle, iArr);
    }

    public void setDisplayGeometry(int i2, int i3, int i4) {
        nativeSetDisplayGeometry(this.nativeWrapperHandle, i2, i3, i4);
    }

    @Deprecated
    public void setPlaybackDataset(String str) throws PlaybackFailedException {
        nativeSetPlaybackDataset(this.nativeWrapperHandle, str);
    }

    public void setPlaybackDatasetUri(Uri uri) throws PlaybackFailedException {
        nativeSetPlaybackDatasetUri(this.nativeWrapperHandle, uri.toString());
    }

    public void startRecording(RecordingConfig recordingConfig) throws RecordingFailedException {
        if (recordingConfig != null) {
            nativeStartRecording(this.nativeWrapperHandle, recordingConfig.nativeHandle);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void stopRecording() throws RecordingFailedException {
        nativeStopRecording(this.nativeWrapperHandle);
    }

    public Frame update() throws CameraNotAvailableException {
        Frame frame = new Frame(this);
        nativeUpdate(this.nativeWrapperHandle, frame.nativeHandle);
        return frame;
    }

    Session(long j2) {
        this.faceCache = new p();
        this.sharedCamera = null;
        this.nativeWrapperHandle = j2;
        this.nativeSymbolTableHandle = nativeGetSymbolTable(j2);
    }

    @UsedByNative("session_jni.cc")
    static void throwExceptionFromArStatus(String str, int i2, String[] strArr, int[] iArr) throws Exception {
        int i3;
        for (ah ahVar : ah.values()) {
            if (ahVar.f30288b == i2) {
                Class cls = ahVar.f30289c;
                if (cls != null) {
                    if (strArr == null || iArr == null || (i3 = strArr.length) != iArr.length) {
                        i3 = 0;
                    }
                    String str2 = ahVar.f30290d;
                    if (str2 == null && str == null) {
                        throw ((Exception) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    if (str2 != null) {
                        if (str == null) {
                            str = str2;
                        } else {
                            str = str2.concat(str);
                        }
                    }
                    Exception exc = (Exception) ahVar.f30289c.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
                    StackTraceElement[] stackTrace = exc.getStackTrace();
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length + i3)];
                    int i4 = 0;
                    while (i4 < i3) {
                        stackTraceElementArr[i4] = new StackTraceElement("ARCore", "native", strArr[i4], iArr[i4]);
                        i4++;
                    }
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        stackTraceElementArr[i4] = stackTraceElement;
                        i4++;
                    }
                    exc.setStackTrace(stackTraceElementArr);
                    throw exc;
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 23);
        sb.append("Unexpected error code: ");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }

    public void getConfig(Config config) {
        nativeGetConfig(this.nativeWrapperHandle, config.nativeHandle);
    }

    public List<CameraConfig> getSupportedCameraConfigs(CameraConfigFilter cameraConfigFilter) {
        if (cameraConfigFilter != null) {
            ArrayList arrayList = new ArrayList(r1);
            for (long cameraConfig : nativeGetSupportedCameraConfigsWithFilter(this.nativeWrapperHandle, cameraConfigFilter.nativeHandle)) {
                arrayList.add(new CameraConfig(this, cameraConfig));
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public Session(Context context) throws UnavailableArcoreNotInstalledException, UnavailableApkTooOldException, UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException {
        this(context, EnumSet.noneOf(Feature.class));
    }

    public Session(Context context, Set<Feature> set) throws UnavailableArcoreNotInstalledException, UnavailableApkTooOldException, UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException, IllegalArgumentException {
        this.faceCache = new p();
        this.sharedCamera = null;
        System.loadLibrary("arcore_sdk_jni");
        int[] iArr = new int[(set.size() + 1)];
        int i2 = 0;
        for (Feature feature : set) {
            iArr[i2] = feature.nativeCode;
            i2++;
        }
        iArr[i2] = 0;
        long nativeCreateSessionAndWrapperWithFeatures = nativeCreateSessionAndWrapperWithFeatures(context, iArr);
        this.nativeWrapperHandle = nativeCreateSessionAndWrapperWithFeatures;
        this.nativeSymbolTableHandle = nativeGetSymbolTable(nativeCreateSessionAndWrapperWithFeatures);
        if (set.contains(Feature.SHARED_CAMERA)) {
            this.sharedCamera = new SharedCamera(this);
        }
        loadDynamicSymbolsAfterSessionCreate();
    }
}
