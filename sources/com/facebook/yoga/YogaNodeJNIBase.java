package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private static final byte BORDER = 4;
    private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;
    @DoNotStrip
    private float[] arr;
    private YogaBaselineFunction mBaselineFunction;
    private List<YogaNodeJNIBase> mChildren;
    private Object mData;
    private boolean mHasNewLayout;
    @DoNotStrip
    private int mLayoutDirection;
    private YogaMeasureFunction mMeasureFunction;
    protected long mNativePointer;
    private YogaNodeJNIBase mOwner;

    /* renamed from: com.facebook.yoga.YogaNodeJNIBase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.yoga.YogaEdge[] r0 = com.facebook.yoga.YogaEdge.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$yoga$YogaEdge = r0
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.yoga.YogaNodeJNIBase.AnonymousClass1.<clinit>():void");
        }
    }

    private YogaNodeJNIBase(long j2) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j2 != 0) {
            this.mNativePointer = j2;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeClearChildrenJNI(this.mNativePointer);
    }

    private void freeze(YogaNode yogaNode) {
        Object data = getData();
        if (data instanceof YogaNode.Inputs) {
            ((YogaNode.Inputs) data).freeze(this, yogaNode);
        }
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            list.remove(i2);
            this.mChildren.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            return yogaNodeJNIBase.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    private static YogaValue valueFromLong(long j2) {
        return new YogaValue(Float.intBitsToFloat((int) j2), (int) (j2 >> 32));
    }

    public void addChildAt(YogaNode yogaNode, int i2) {
        if (yogaNode instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            if (yogaNodeJNIBase.mOwner == null) {
                if (this.mChildren == null) {
                    this.mChildren = new ArrayList(4);
                }
                this.mChildren.add(i2, yogaNodeJNIBase);
                yogaNodeJNIBase.mOwner = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i2);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @DoNotStrip
    public final float baseline(float f2, float f3) {
        return this.mBaselineFunction.baseline(this, f2, f3);
    }

    public void calculateLayout(float f2, float f3) {
        freeze((YogaNode) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i2);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.mChildren;
            if (list != null) {
                for (YogaNodeJNIBase next : list) {
                    next.freeze(yogaNodeJNIBase);
                    arrayList.add(next);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i3 = 0; i3 < yogaNodeJNIBaseArr.length; i3++) {
            jArr[i3] = yogaNodeJNIBaseArr[i3].mNativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, f2, f3, jArr, yogaNodeJNIBaseArr);
    }

    public void copyStyle(YogaNode yogaNode) {
        if (yogaNode instanceof YogaNodeJNIBase) {
            YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase) yogaNode).mNativePointer);
        }
    }

    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
    }

    public void dirtyAllDescendants() {
        YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(this.mNativePointer);
    }

    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
    }

    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
    }

    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
    }

    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
    }

    public float getBorder(YogaEdge yogaEdge) {
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, yogaEdge.intValue());
    }

    public int getChildCount() {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getData() {
        return this.mData;
    }

    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        float[] fArr = this.arr;
        return fArr != null && (((int) fArr[0]) & 8) == 8;
    }

    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
    }

    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
    }

    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
    }

    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
    }

    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
    }

    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
    }

    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
    }

    public float getLayoutBorder(YogaEdge yogaEdge) {
        int i2;
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        int i3 = 0;
        float f2 = fArr[0];
        if ((((int) f2) & 4) != 4) {
            return 0.0f;
        }
        if ((((int) f2) & 1) == 1) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        int i4 = 14 - i2;
        if ((((int) f2) & 2) != 2) {
            i3 = 4;
        }
        int i5 = i4 - i3;
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
            case 1:
                return this.arr[i5];
            case 2:
                return this.arr[i5 + 1];
            case 3:
                return this.arr[i5 + 2];
            case 4:
                return this.arr[i5 + 3];
            case 5:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[i5 + 2];
                }
                return this.arr[i5];
            case 6:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[i5];
                }
                return this.arr[i5 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public YogaDirection getLayoutDirection() {
        int i2;
        float[] fArr = this.arr;
        if (fArr != null) {
            i2 = (int) fArr[5];
        } else {
            i2 = this.mLayoutDirection;
        }
        return YogaDirection.fromInt(i2);
    }

    public float getLayoutHeight() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    public float getLayoutMargin(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 1) != 1) {
            return 0.0f;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
            case 1:
                return this.arr[6];
            case 2:
                return this.arr[7];
            case 3:
                return this.arr[8];
            case 4:
                return this.arr[9];
            case 5:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[8];
                }
                return this.arr[6];
            case 6:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[6];
                }
                return this.arr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        int i2 = 0;
        float f2 = fArr[0];
        if ((((int) f2) & 2) != 2) {
            return 0.0f;
        }
        if ((((int) f2) & 1) != 1) {
            i2 = 4;
        }
        int i3 = 10 - i2;
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
            case 1:
                return this.arr[i3];
            case 2:
                return this.arr[i3 + 1];
            case 3:
                return this.arr[i3 + 2];
            case 4:
                return this.arr[i3 + 3];
            case 5:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[i3 + 2];
                }
                return this.arr[i3];
            case 6:
                if (getLayoutDirection() == YogaDirection.RTL) {
                    return this.arr[i3];
                }
                return this.arr[i3 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutWidth() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    public float getLayoutX() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    public float getLayoutY() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    public YogaValue getMargin(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
    }

    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
    }

    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
    }

    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
    }

    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
    }

    public YogaValue getPadding(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    public YogaValue getPosition(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
    }

    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
    }

    public YogaWrap getWrap() {
        return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
    }

    public boolean hasNewLayout() {
        float[] fArr = this.arr;
        if (fArr == null) {
            return this.mHasNewLayout;
        }
        if ((((int) fArr[0]) & 16) == 16) {
            return true;
        }
        return false;
    }

    public int indexOf(YogaNode yogaNode) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return -1;
        }
        return list.indexOf(yogaNode);
    }

    public boolean isBaselineDefined() {
        return this.mBaselineFunction != null;
    }

    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
    }

    public boolean isMeasureDefined() {
        return this.mMeasureFunction != null;
    }

    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
    }

    public void markLayoutSeen() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = (float) (((int) fArr[0]) & -17);
        }
        this.mHasNewLayout = false;
    }

    @DoNotStrip
    public final long measure(float f2, int i2, float f3, int i3) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f2, YogaMeasureMode.fromInt(i2), f3, YogaMeasureMode.fromInt(i3));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public void print() {
        YogaNative.jni_YGNodePrintJNI(this.mNativePointer);
    }

    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, yogaAlign.intValue());
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, yogaAlign.intValue());
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, yogaAlign.intValue());
    }

    public void setAspectRatio(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, f2);
    }

    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        boolean z2;
        this.mBaselineFunction = yogaBaselineFunction;
        long j2 = this.mNativePointer;
        if (yogaBaselineFunction != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(j2, z2);
    }

    public void setBorder(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setDirection(YogaDirection yogaDirection) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, yogaDirection.intValue());
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, yogaDisplay.intValue());
    }

    public void setFlex(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, f2);
    }

    public void setFlexBasis(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, f2);
    }

    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
    }

    public void setFlexBasisPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, f2);
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, yogaFlexDirection.intValue());
    }

    public void setFlexGrow(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, f2);
    }

    public void setFlexShrink(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, f2);
    }

    public void setHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, f2);
    }

    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
    }

    public void setHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, f2);
    }

    public void setIsReferenceBaseline(boolean z2) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, z2);
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, yogaJustify.intValue());
    }

    public void setMargin(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setMarginAuto(YogaEdge yogaEdge) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, yogaEdge.intValue());
    }

    public void setMarginPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setMaxHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, f2);
    }

    public void setMaxHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, f2);
    }

    public void setMaxWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, f2);
    }

    public void setMaxWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, f2);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        boolean z2;
        this.mMeasureFunction = yogaMeasureFunction;
        long j2 = this.mNativePointer;
        if (yogaMeasureFunction != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(j2, z2);
    }

    public void setMinHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, f2);
    }

    public void setMinHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, f2);
    }

    public void setMinWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, f2);
    }

    public void setMinWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, f2);
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, yogaOverflow.intValue());
    }

    public void setPadding(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPaddingPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPosition(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPositionPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, yogaPositionType.intValue());
    }

    public void setWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, f2);
    }

    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
    }

    public void setWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, f2);
    }

    public void setWrap(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, yogaWrap.intValue());
    }

    public void swapChildAt(YogaNode yogaNode, int i2) {
        if (yogaNode instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            this.mChildren.remove(i2);
            this.mChildren.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i2);
        }
    }

    public YogaNodeJNIBase cloneWithChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            if (yogaNodeJNIBase.mChildren != null) {
                yogaNodeJNIBase.mChildren = new ArrayList(yogaNodeJNIBase.mChildren);
            }
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            for (int i2 = 0; i2 < yogaNodeJNIBase.getChildCount(); i2++) {
                yogaNodeJNIBase.swapChildAt(yogaNodeJNIBase.getChildAt(i2).cloneWithChildren(), i2);
            }
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public YogaNodeJNIBase getChildAt(int i2) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            return list.get(i2);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Deprecated
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    public YogaNodeJNIBase removeChildAt(int i2) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i2);
            remove.mOwner = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    YogaNodeJNIBase(YogaConfig yogaConfig) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) yogaConfig).mNativePointer));
    }
}
