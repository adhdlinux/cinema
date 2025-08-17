package com.google.ar.core;

import android.media.Image;
import com.google.ar.core.exceptions.FatalException;

public class LightEstimate {
    long nativeHandle;
    private final long nativeSymbolTableHandle;
    private final Session session;

    public enum State {
        NOT_VALID(0),
        VALID(1);
        
        final int nativeCode;

        private State(int i2) {
            this.nativeCode = i2;
        }

        static State forNumber(int i2) {
            for (State state : values()) {
                if (state.nativeCode == i2) {
                    return state;
                }
            }
            throw new FatalException(p.b((byte) 55, i2, "Unexpected value for native LightEstimate.State, value="));
        }
    }

    protected LightEstimate() {
        this.nativeHandle = 0;
        this.session = null;
        this.nativeSymbolTableHandle = 0;
    }

    LightEstimate(Session session2) {
        this.nativeHandle = 0;
        this.session = session2;
        this.nativeHandle = nativeCreateLightEstimate(session2.nativeWrapperHandle);
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    private native long[] nativeAcquireEnvironmentalHdrCubeMap(long j2, long j3);

    private static native long nativeCreateLightEstimate(long j2);

    private static native void nativeDestroyLightEstimate(long j2, long j3);

    private native void nativeGetColorCorrection(long j2, long j3, float[] fArr, int i2);

    private native void nativeGetEnvironmentalHdrAmbientSphericalHarmonics(long j2, long j3, float[] fArr);

    private native void nativeGetEnvironmentalHdrMainLightDirection(long j2, long j3, float[] fArr);

    private native void nativeGetEnvironmentalHdrMainLightIntensity(long j2, long j3, float[] fArr);

    private native float nativeGetPixelIntensity(long j2, long j3);

    private native int nativeGetState(long j2, long j3);

    private native long nativeGetTimestamp(long j2, long j3);

    public Image[] acquireEnvironmentalHdrCubeMap() {
        long[] nativeAcquireEnvironmentalHdrCubeMap = nativeAcquireEnvironmentalHdrCubeMap(this.session.nativeWrapperHandle, this.nativeHandle);
        ArImage[] arImageArr = new ArImage[nativeAcquireEnvironmentalHdrCubeMap.length];
        for (int i2 = 0; i2 < nativeAcquireEnvironmentalHdrCubeMap.length; i2++) {
            arImageArr[i2] = new ArImage(this.session, nativeAcquireEnvironmentalHdrCubeMap[i2]);
        }
        return arImageArr;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeDestroyLightEstimate(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public void getColorCorrection(float[] fArr, int i2) {
        nativeGetColorCorrection(this.session.nativeWrapperHandle, this.nativeHandle, fArr, i2);
    }

    public float[] getEnvironmentalHdrAmbientSphericalHarmonics() {
        float[] fArr = new float[27];
        nativeGetEnvironmentalHdrAmbientSphericalHarmonics(this.session.nativeWrapperHandle, this.nativeHandle, fArr);
        return fArr;
    }

    public float[] getEnvironmentalHdrMainLightDirection() {
        float[] fArr = new float[3];
        nativeGetEnvironmentalHdrMainLightDirection(this.session.nativeWrapperHandle, this.nativeHandle, fArr);
        return fArr;
    }

    public float[] getEnvironmentalHdrMainLightIntensity() {
        float[] fArr = new float[3];
        nativeGetEnvironmentalHdrMainLightIntensity(this.session.nativeWrapperHandle, this.nativeHandle, fArr);
        return fArr;
    }

    public float getPixelIntensity() {
        return nativeGetPixelIntensity(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public State getState() {
        return State.forNumber(nativeGetState(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    public long getTimestamp() {
        return nativeGetTimestamp(this.session.nativeWrapperHandle, this.nativeHandle);
    }
}
