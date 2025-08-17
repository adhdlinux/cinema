package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.fabric.FabricComponents;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;

@DoNotStrip
public class IntBufferBatchMountItem implements MountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    public IntBufferBatchMountItem(int i2, int[] iArr, Object[] objArr, int i3) {
        int i4;
        this.mSurfaceId = i2;
        this.mCommitNumber = i3;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        int i5 = 0;
        if (iArr != null) {
            i4 = iArr.length;
        } else {
            i4 = 0;
        }
        this.mIntBufferLen = i4;
        this.mObjBufferLen = objArr != null ? objArr.length : i5;
    }

    private void beginMarkers(String str) {
        Systrace.beginSection(0, "FabricUIManager::" + str + " - " + this.mIntBufferLen + " intBufSize  - " + this.mObjBufferLen + " objBufSize");
        int i2 = this.mCommitNumber;
        if (i2 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, (String) null, i2);
        }
    }

    private static EventEmitterWrapper castToEventEmitter(Object obj) {
        if (obj != null) {
            return (EventEmitterWrapper) obj;
        }
        return null;
    }

    private static StateWrapper castToState(Object obj) {
        if (obj != null) {
            return (StateWrapper) obj;
        }
        return null;
    }

    private void endMarkers() {
        int i2 = this.mCommitNumber;
        if (i2 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, (String) null, i2);
        }
        Systrace.endSection(0);
    }

    public void execute(MountingManager mountingManager) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.e(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
        } else if (surfaceManager.isStopped()) {
            FLog.e(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
        } else {
            if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                FLog.d(TAG, "Executing IntBufferBatchMountItem on surface [%d]", (Object) Integer.valueOf(this.mSurfaceId));
            }
            beginMarkers("mountViews");
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i11 & -2;
                if ((i11 & 1) != 0) {
                    int i13 = iArr[i10];
                    i10++;
                    i2 = i13;
                } else {
                    i2 = 1;
                }
                int i14 = i9;
                i8 = i10;
                for (int i15 = 0; i15 < i2; i15++) {
                    if (i12 == 2) {
                        int i16 = i14 + 1;
                        String fabricComponentName = FabricComponents.getFabricComponentName((String) this.mObjBuffer[i14]);
                        int i17 = i8 + 1;
                        int i18 = this.mIntBuffer[i8];
                        Object[] objArr = this.mObjBuffer;
                        int i19 = i16 + 1;
                        Object obj = objArr[i16];
                        int i20 = i19 + 1;
                        StateWrapper castToState = castToState(objArr[i19]);
                        i14 = i20 + 1;
                        EventEmitterWrapper castToEventEmitter = castToEventEmitter(this.mObjBuffer[i20]);
                        i6 = i17 + 1;
                        if (this.mIntBuffer[i17] == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        surfaceManager.createView(fabricComponentName, i18, obj, castToState, castToEventEmitter, z2);
                    } else {
                        if (i12 == 4) {
                            surfaceManager.deleteView(this.mIntBuffer[i8]);
                            i8++;
                        } else {
                            if (i12 == 8) {
                                int[] iArr2 = this.mIntBuffer;
                                int i21 = i8 + 1;
                                int i22 = i21 + 1;
                                i7 = i22 + 1;
                                surfaceManager.addViewAt(iArr2[i21], iArr2[i8], iArr2[i22]);
                            } else if (i12 == 16) {
                                int[] iArr3 = this.mIntBuffer;
                                int i23 = i8 + 1;
                                int i24 = i23 + 1;
                                i7 = i24 + 1;
                                surfaceManager.removeViewAt(iArr3[i8], iArr3[i23], iArr3[i24]);
                            } else {
                                if (i12 == 32) {
                                    i3 = i8 + 1;
                                    i4 = i14 + 1;
                                    surfaceManager.updateProps(this.mIntBuffer[i8], this.mObjBuffer[i14]);
                                } else if (i12 == 64) {
                                    i3 = i8 + 1;
                                    i4 = i14 + 1;
                                    surfaceManager.updateState(this.mIntBuffer[i8], castToState(this.mObjBuffer[i14]));
                                } else if (i12 == 128) {
                                    int[] iArr4 = this.mIntBuffer;
                                    int i25 = i8 + 1;
                                    int i26 = iArr4[i8];
                                    int i27 = i25 + 1;
                                    int i28 = iArr4[i25];
                                    int i29 = i27 + 1;
                                    int i30 = iArr4[i27];
                                    int i31 = i29 + 1;
                                    int i32 = i31 + 1;
                                    i6 = i32 + 1;
                                    surfaceManager.updateLayout(i26, i28, i30, iArr4[i29], iArr4[i31], iArr4[i32]);
                                } else {
                                    if (i12 == 512) {
                                        int[] iArr5 = this.mIntBuffer;
                                        int i33 = i8 + 1;
                                        int i34 = iArr5[i8];
                                        int i35 = i33 + 1;
                                        int i36 = iArr5[i33];
                                        int i37 = i35 + 1;
                                        int i38 = iArr5[i35];
                                        int i39 = i37 + 1;
                                        i5 = i39 + 1;
                                        surfaceManager.updatePadding(i34, i36, i38, iArr5[i37], iArr5[i39]);
                                    } else if (i12 == 1024) {
                                        int[] iArr6 = this.mIntBuffer;
                                        int i40 = i8 + 1;
                                        int i41 = iArr6[i8];
                                        int i42 = i40 + 1;
                                        int i43 = iArr6[i40];
                                        int i44 = i42 + 1;
                                        int i45 = iArr6[i42];
                                        int i46 = i44 + 1;
                                        i5 = i46 + 1;
                                        surfaceManager.updateOverflowInset(i41, i43, i45, iArr6[i44], iArr6[i46]);
                                    } else if (i12 == 256) {
                                        i3 = i8 + 1;
                                        i4 = i14 + 1;
                                        surfaceManager.updateEventEmitter(this.mIntBuffer[i8], castToEventEmitter(this.mObjBuffer[i14]));
                                    } else {
                                        throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i12 + " at index: " + i8);
                                    }
                                    i8 = i5;
                                }
                                i8 = i3;
                                i14 = i4;
                            }
                            i8 = i7;
                        }
                    }
                    i8 = i6;
                }
                i9 = i14;
            }
            surfaceManager.didUpdateViews();
            endMarkers();
        }
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean shouldSchedule() {
        return this.mIntBufferLen != 0;
    }

    public String toString() {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", new Object[]{Integer.valueOf(this.mSurfaceId)}));
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i9 = i7 + 1;
                int i10 = iArr[i7];
                int i11 = i10 & -2;
                if ((i10 & 1) != 0) {
                    i2 = iArr[i9];
                    i9++;
                } else {
                    i2 = 1;
                }
                i7 = i9;
                int i12 = 0;
                while (true) {
                    if (i12 < i2) {
                        if (i11 == 2) {
                            int i13 = i8 + 1;
                            int i14 = i7 + 1;
                            i6 = i14 + 1;
                            sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i14]), FabricComponents.getFabricComponentName((String) this.mObjBuffer[i8])}));
                            i8 = i13 + 3;
                        } else {
                            if (i11 == 4) {
                                i3 = i7 + 1;
                                sb.append(String.format("DELETE [%d]\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7])}));
                            } else if (i11 == 8) {
                                int i15 = i7 + 1;
                                int i16 = i15 + 1;
                                i6 = i16 + 1;
                                sb.append(String.format("INSERT [%d]->[%d] @%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i15]), Integer.valueOf(this.mIntBuffer[i16])}));
                            } else if (i11 == 16) {
                                int i17 = i7 + 1;
                                int i18 = i17 + 1;
                                i6 = i18 + 1;
                                sb.append(String.format("REMOVE [%d]->[%d] @%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i17]), Integer.valueOf(this.mIntBuffer[i18])}));
                            } else {
                                if (i11 == 32) {
                                    i5 = i8 + 1;
                                    Object obj = this.mObjBuffer[i8];
                                    i3 = i7 + 1;
                                    sb.append(String.format("UPDATE PROPS [%d]: %s\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), "<hidden>"}));
                                } else if (i11 == 64) {
                                    i5 = i8 + 1;
                                    castToState(this.mObjBuffer[i8]);
                                    i3 = i7 + 1;
                                    sb.append(String.format("UPDATE STATE [%d]: %s\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), "<hidden>"}));
                                } else {
                                    if (i11 == 128) {
                                        int i19 = i7 + 1;
                                        int i20 = i19 + 1;
                                        int i21 = i20 + 1;
                                        int i22 = i21 + 1;
                                        int i23 = i22 + 1;
                                        sb.append(String.format("UPDATE LAYOUT [%d]: x:%d y:%d w:%d h:%d displayType:%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i19]), Integer.valueOf(this.mIntBuffer[i20]), Integer.valueOf(this.mIntBuffer[i21]), Integer.valueOf(this.mIntBuffer[i22]), Integer.valueOf(this.mIntBuffer[i23])}));
                                        i7 = i23 + 1;
                                    } else {
                                        if (i11 == 512) {
                                            int i24 = i7 + 1;
                                            int i25 = i24 + 1;
                                            int i26 = i25 + 1;
                                            int i27 = i26 + 1;
                                            i4 = i27 + 1;
                                            sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i24]), Integer.valueOf(this.mIntBuffer[i25]), Integer.valueOf(this.mIntBuffer[i26]), Integer.valueOf(this.mIntBuffer[i27])}));
                                        } else if (i11 == 1024) {
                                            int i28 = i7 + 1;
                                            int i29 = i28 + 1;
                                            int i30 = i29 + 1;
                                            int i31 = i30 + 1;
                                            i4 = i31 + 1;
                                            sb.append(String.format("UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7]), Integer.valueOf(this.mIntBuffer[i28]), Integer.valueOf(this.mIntBuffer[i29]), Integer.valueOf(this.mIntBuffer[i30]), Integer.valueOf(this.mIntBuffer[i31])}));
                                        } else if (i11 == 256) {
                                            i8++;
                                            i3 = i7 + 1;
                                            sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", new Object[]{Integer.valueOf(this.mIntBuffer[i7])}));
                                        } else {
                                            String str2 = TAG;
                                            FLog.e(str2, "String so far: " + sb.toString());
                                            throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i11 + " at index: " + i7);
                                        }
                                        i7 = i4;
                                    }
                                    i12++;
                                }
                                i8 = i5;
                            }
                            i7 = i3;
                            i12++;
                        }
                        i7 = i6;
                        i12++;
                    }
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            FLog.e(TAG, "Caught exception trying to print", (Throwable) e2);
            StringBuilder sb2 = new StringBuilder();
            for (int i32 = 0; i32 < this.mIntBufferLen; i32++) {
                sb2.append(this.mIntBuffer[i32]);
                sb2.append(", ");
            }
            FLog.e(TAG, sb2.toString());
            for (int i33 = 0; i33 < this.mObjBufferLen; i33++) {
                String str3 = TAG;
                Object obj2 = this.mObjBuffer[i33];
                if (obj2 != null) {
                    str = obj2.toString();
                } else {
                    str = "null";
                }
                FLog.e(str3, str);
            }
            return "";
        }
    }
}
