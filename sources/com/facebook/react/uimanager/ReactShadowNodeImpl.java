package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import java.util.ArrayList;
import java.util.Arrays;

@ReactPropertyHolder
public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    private static final YogaConfig sYogaConfig = ReactYogaConfigProvider.get();
    private ArrayList<ReactShadowNodeImpl> mChildren;
    private final Spacing mDefaultPadding;
    private Integer mHeightMeasureSpec;
    private boolean mIsLayoutOnly;
    private ReactShadowNodeImpl mLayoutParent;
    private ArrayList<ReactShadowNodeImpl> mNativeChildren;
    private ReactShadowNodeImpl mNativeParent;
    private boolean mNodeUpdated = true;
    private final float[] mPadding;
    private final boolean[] mPaddingIsPercent;
    private ReactShadowNodeImpl mParent;
    private int mReactTag;
    private int mRootTag;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScreenX;
    private int mScreenY;
    private boolean mShouldNotifyOnLayout;
    private ThemedReactContext mThemedContext;
    private int mTotalNativeChildren = 0;
    private String mViewClassName;
    private Integer mWidthMeasureSpec;
    private YogaNode mYogaNode;

    public ReactShadowNodeImpl() {
        float[] fArr = new float[9];
        this.mPadding = fArr;
        this.mPaddingIsPercent = new boolean[9];
        this.mDefaultPadding = new Spacing(0.0f);
        if (!isVirtual()) {
            YogaNode acquire = YogaNodePool.get().acquire();
            acquire = acquire == null ? YogaNodeFactory.create(sYogaConfig) : acquire;
            this.mYogaNode = acquire;
            acquire.setData(this);
            Arrays.fill(fArr, Float.NaN);
            return;
        }
        this.mYogaNode = null;
    }

    private void getHierarchyInfoWithIndentation(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" view='");
        sb.append(getViewClass());
        sb.append("' tag=");
        sb.append(getReactTag());
        if (this.mYogaNode != null) {
            sb.append(" layout='x:");
            sb.append(getScreenX());
            sb.append(" y:");
            sb.append(getScreenY());
            sb.append(" w:");
            sb.append(getLayoutWidth());
            sb.append(" h:");
            sb.append(getLayoutHeight());
            sb.append("'");
        } else {
            sb.append("(virtual node)");
        }
        sb.append(">\n");
        if (getChildCount() != 0) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                getChildAt(i4).getHierarchyInfoWithIndentation(sb, i2 + 1);
            }
        }
    }

    private int getTotalNativeNodeContributionToParent() {
        NativeKind nativeKind = getNativeKind();
        if (nativeKind == NativeKind.NONE) {
            return this.mTotalNativeChildren;
        }
        if (nativeKind == NativeKind.LEAF) {
            return this.mTotalNativeChildren + 1;
        }
        return 1;
    }

    private void updateNativeChildrenCountInParent(int i2) {
        if (getNativeKind() != NativeKind.PARENT) {
            ReactShadowNodeImpl parent = getParent();
            while (parent != null) {
                parent.mTotalNativeChildren += i2;
                if (parent.getNativeKind() != NativeKind.PARENT) {
                    parent = parent.getParent();
                } else {
                    return;
                }
            }
        }
    }

    private void updatePadding() {
        for (int i2 = 0; i2 <= 8; i2++) {
            if (i2 == 0 || i2 == 2 || i2 == 4 || i2 == 5) {
                if (YogaConstants.isUndefined(this.mPadding[i2]) && YogaConstants.isUndefined(this.mPadding[6]) && YogaConstants.isUndefined(this.mPadding[8])) {
                    this.mYogaNode.setPadding(YogaEdge.fromInt(i2), this.mDefaultPadding.getRaw(i2));
                }
            } else if (i2 == 1 || i2 == 3) {
                if (YogaConstants.isUndefined(this.mPadding[i2]) && YogaConstants.isUndefined(this.mPadding[7]) && YogaConstants.isUndefined(this.mPadding[8])) {
                    this.mYogaNode.setPadding(YogaEdge.fromInt(i2), this.mDefaultPadding.getRaw(i2));
                }
            } else if (YogaConstants.isUndefined(this.mPadding[i2])) {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i2), this.mDefaultPadding.getRaw(i2));
            }
            if (this.mPaddingIsPercent[i2]) {
                this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i2), this.mPadding[i2]);
            } else {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i2), this.mPadding[i2]);
            }
        }
    }

    public void calculateLayout() {
        calculateLayout(Float.NaN, Float.NaN);
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (isVirtualAnchor()) {
            return null;
        }
        return this.mChildren;
    }

    public void dirty() {
        if (!isVirtual()) {
            this.mYogaNode.dirty();
        } else if (getParent() != null) {
            getParent().dirty();
        }
    }

    public boolean dispatchUpdates(float f2, float f3, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNodeUpdated) {
            onCollectExtraUpdates(uIViewOperationQueue);
        }
        boolean z2 = false;
        if (hasNewLayout()) {
            float layoutX = getLayoutX();
            float layoutY = getLayoutY();
            float f4 = f2 + layoutX;
            int round = Math.round(f4);
            float f5 = f3 + layoutY;
            int round2 = Math.round(f5);
            int round3 = Math.round(f4 + getLayoutWidth());
            int round4 = Math.round(f5 + getLayoutHeight());
            int round5 = Math.round(layoutX);
            int round6 = Math.round(layoutY);
            int i2 = round3 - round;
            int i3 = round4 - round2;
            if (!(round5 == this.mScreenX && round6 == this.mScreenY && i2 == this.mScreenWidth && i3 == this.mScreenHeight)) {
                z2 = true;
            }
            this.mScreenX = round5;
            this.mScreenY = round6;
            this.mScreenWidth = i2;
            this.mScreenHeight = i3;
            if (z2) {
                if (nativeViewHierarchyOptimizer != null) {
                    nativeViewHierarchyOptimizer.handleUpdateLayout(this);
                } else {
                    uIViewOperationQueue.enqueueUpdateLayout(getParent().getReactTag(), getReactTag(), getScreenX(), getScreenY(), getScreenWidth(), getScreenHeight());
                }
            }
        }
        return z2;
    }

    public void dispose() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            yogaNode.reset();
            YogaNodePool.get().release(this.mYogaNode);
        }
    }

    public final int getChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public float getFlex() {
        return this.mYogaNode.getFlex();
    }

    public Integer getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public String getHierarchyInfo() {
        StringBuilder sb = new StringBuilder();
        getHierarchyInfoWithIndentation(sb, 0);
        return sb.toString();
    }

    public final YogaDirection getLayoutDirection() {
        return this.mYogaNode.getLayoutDirection();
    }

    public final float getLayoutHeight() {
        return this.mYogaNode.getLayoutHeight();
    }

    public final float getLayoutWidth() {
        return this.mYogaNode.getLayoutWidth();
    }

    public final float getLayoutX() {
        return this.mYogaNode.getLayoutX();
    }

    public final float getLayoutY() {
        return this.mYogaNode.getLayoutY();
    }

    public final int getNativeChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public NativeKind getNativeKind() {
        if (isVirtual() || isLayoutOnly()) {
            return NativeKind.NONE;
        }
        if (hoistNativeChildren()) {
            return NativeKind.LEAF;
        }
        return NativeKind.PARENT;
    }

    public final float getPadding(int i2) {
        return this.mYogaNode.getLayoutPadding(YogaEdge.fromInt(i2));
    }

    public final int getReactTag() {
        return this.mReactTag;
    }

    public final int getRootTag() {
        boolean z2;
        if (this.mRootTag != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2);
        return this.mRootTag;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScreenX() {
        return this.mScreenX;
    }

    public int getScreenY() {
        return this.mScreenY;
    }

    public final YogaValue getStyleHeight() {
        return this.mYogaNode.getHeight();
    }

    public final YogaValue getStylePadding(int i2) {
        return this.mYogaNode.getPadding(YogaEdge.fromInt(i2));
    }

    public final YogaValue getStyleWidth() {
        return this.mYogaNode.getWidth();
    }

    public final ThemedReactContext getThemedContext() {
        return (ThemedReactContext) Assertions.assertNotNull(this.mThemedContext);
    }

    public final int getTotalNativeChildren() {
        return this.mTotalNativeChildren;
    }

    public final String getViewClass() {
        return (String) Assertions.assertNotNull(this.mViewClassName);
    }

    public Integer getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public final boolean hasNewLayout() {
        YogaNode yogaNode = this.mYogaNode;
        return yogaNode != null && yogaNode.hasNewLayout();
    }

    public final boolean hasUnseenUpdates() {
        return this.mNodeUpdated;
    }

    public final boolean hasUpdates() {
        return this.mNodeUpdated || hasNewLayout() || isDirty();
    }

    public boolean hoistNativeChildren() {
        return false;
    }

    public final boolean isDirty() {
        YogaNode yogaNode = this.mYogaNode;
        return yogaNode != null && yogaNode.isDirty();
    }

    public final boolean isLayoutOnly() {
        return this.mIsLayoutOnly;
    }

    public boolean isMeasureDefined() {
        return this.mYogaNode.isMeasureDefined();
    }

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public boolean isYogaLeafNode() {
        return isMeasureDefined();
    }

    public final void markLayoutSeen() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            yogaNode.markLayoutSeen();
        }
    }

    public final void markUpdateSeen() {
        this.mNodeUpdated = false;
        if (hasNewLayout()) {
            markLayoutSeen();
        }
    }

    public void markUpdated() {
        if (!this.mNodeUpdated) {
            this.mNodeUpdated = true;
            ReactShadowNodeImpl parent = getParent();
            if (parent != null) {
                parent.markUpdated();
            }
        }
    }

    public void onAfterUpdateTransaction() {
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
    }

    public final void removeAllNativeChildren() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mNativeChildren.get(size).mNativeParent = null;
            }
            this.mNativeChildren.clear();
        }
    }

    public void removeAndDisposeAllChildren() {
        if (getChildCount() != 0) {
            int i2 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (this.mYogaNode != null && !isYogaLeafNode()) {
                    this.mYogaNode.removeChildAt(childCount);
                }
                ReactShadowNodeImpl childAt = getChildAt(childCount);
                childAt.mParent = null;
                i2 += childAt.getTotalNativeNodeContributionToParent();
                childAt.dispose();
            }
            ((ArrayList) Assertions.assertNotNull(this.mChildren)).clear();
            markUpdated();
            this.mTotalNativeChildren -= i2;
            updateNativeChildrenCountInParent(-i2);
        }
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignContent(yogaAlign);
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignItems(yogaAlign);
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignSelf(yogaAlign);
    }

    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.mYogaNode.setBaselineFunction(yogaBaselineFunction);
    }

    public void setBorder(int i2, float f2) {
        this.mYogaNode.setBorder(YogaEdge.fromInt(i2), f2);
    }

    public void setDefaultPadding(int i2, float f2) {
        this.mDefaultPadding.set(i2, f2);
        updatePadding();
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        this.mYogaNode.setDisplay(yogaDisplay);
    }

    public void setFlex(float f2) {
        this.mYogaNode.setFlex(f2);
    }

    public void setFlexBasis(float f2) {
        this.mYogaNode.setFlexBasis(f2);
    }

    public void setFlexBasisAuto() {
        this.mYogaNode.setFlexBasisAuto();
    }

    public void setFlexBasisPercent(float f2) {
        this.mYogaNode.setFlexBasisPercent(f2);
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        this.mYogaNode.setFlexDirection(yogaFlexDirection);
    }

    public void setFlexGrow(float f2) {
        this.mYogaNode.setFlexGrow(f2);
    }

    public void setFlexShrink(float f2) {
        this.mYogaNode.setFlexShrink(f2);
    }

    public void setFlexWrap(YogaWrap yogaWrap) {
        this.mYogaNode.setWrap(yogaWrap);
    }

    public final void setIsLayoutOnly(boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (getParent() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.assertCondition(z3, "Must remove from no opt parent first");
        if (this.mNativeParent == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.assertCondition(z4, "Must remove from native parent first");
        if (getNativeChildCount() != 0) {
            z5 = false;
        }
        Assertions.assertCondition(z5, "Must remove all native children first");
        this.mIsLayoutOnly = z2;
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        this.mYogaNode.setJustifyContent(yogaJustify);
    }

    public void setLayoutDirection(YogaDirection yogaDirection) {
        this.mYogaNode.setDirection(yogaDirection);
    }

    public void setLocalData(Object obj) {
    }

    public void setMargin(int i2, float f2) {
        this.mYogaNode.setMargin(YogaEdge.fromInt(i2), f2);
    }

    public void setMarginAuto(int i2) {
        this.mYogaNode.setMarginAuto(YogaEdge.fromInt(i2));
    }

    public void setMarginPercent(int i2, float f2) {
        this.mYogaNode.setMarginPercent(YogaEdge.fromInt(i2), f2);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        this.mYogaNode.setMeasureFunction(yogaMeasureFunction);
    }

    public void setMeasureSpecs(int i2, int i3) {
        this.mWidthMeasureSpec = Integer.valueOf(i2);
        this.mHeightMeasureSpec = Integer.valueOf(i3);
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        this.mYogaNode.setOverflow(yogaOverflow);
    }

    public void setPadding(int i2, float f2) {
        this.mPadding[i2] = f2;
        this.mPaddingIsPercent[i2] = false;
        updatePadding();
    }

    public void setPaddingPercent(int i2, float f2) {
        this.mPadding[i2] = f2;
        this.mPaddingIsPercent[i2] = !YogaConstants.isUndefined(f2);
        updatePadding();
    }

    public void setPosition(int i2, float f2) {
        this.mYogaNode.setPosition(YogaEdge.fromInt(i2), f2);
    }

    public void setPositionPercent(int i2, float f2) {
        this.mYogaNode.setPositionPercent(YogaEdge.fromInt(i2), f2);
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        this.mYogaNode.setPositionType(yogaPositionType);
    }

    public void setReactTag(int i2) {
        this.mReactTag = i2;
    }

    public final void setRootTag(int i2) {
        this.mRootTag = i2;
    }

    public void setShouldNotifyOnLayout(boolean z2) {
        this.mShouldNotifyOnLayout = z2;
    }

    public void setStyleAspectRatio(float f2) {
        this.mYogaNode.setAspectRatio(f2);
    }

    public void setStyleHeight(float f2) {
        this.mYogaNode.setHeight(f2);
    }

    public void setStyleHeightAuto() {
        this.mYogaNode.setHeightAuto();
    }

    public void setStyleHeightPercent(float f2) {
        this.mYogaNode.setHeightPercent(f2);
    }

    public void setStyleMaxHeight(float f2) {
        this.mYogaNode.setMaxHeight(f2);
    }

    public void setStyleMaxHeightPercent(float f2) {
        this.mYogaNode.setMaxHeightPercent(f2);
    }

    public void setStyleMaxWidth(float f2) {
        this.mYogaNode.setMaxWidth(f2);
    }

    public void setStyleMaxWidthPercent(float f2) {
        this.mYogaNode.setMaxWidthPercent(f2);
    }

    public void setStyleMinHeight(float f2) {
        this.mYogaNode.setMinHeight(f2);
    }

    public void setStyleMinHeightPercent(float f2) {
        this.mYogaNode.setMinHeightPercent(f2);
    }

    public void setStyleMinWidth(float f2) {
        this.mYogaNode.setMinWidth(f2);
    }

    public void setStyleMinWidthPercent(float f2) {
        this.mYogaNode.setMinWidthPercent(f2);
    }

    public void setStyleWidth(float f2) {
        this.mYogaNode.setWidth(f2);
    }

    public void setStyleWidthAuto() {
        this.mYogaNode.setWidthAuto();
    }

    public void setStyleWidthPercent(float f2) {
        this.mYogaNode.setWidthPercent(f2);
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
    }

    public final void setViewClassName(String str) {
        this.mViewClassName = str;
    }

    public final boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnLayout;
    }

    public String toString() {
        return "[" + this.mViewClassName + " " + getReactTag() + "]";
    }

    public final void updateProperties(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, reactStylesDiffMap);
        onAfterUpdateTransaction();
    }

    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i2) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList<>(4);
        }
        this.mChildren.add(i2, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
        if (this.mYogaNode != null && !isYogaLeafNode()) {
            YogaNode yogaNode = reactShadowNodeImpl.mYogaNode;
            if (yogaNode != null) {
                this.mYogaNode.addChildAt(yogaNode, i2);
            } else {
                throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + reactShadowNodeImpl.toString() + "' to a '" + toString() + "')");
            }
        }
        markUpdated();
        int totalNativeNodeContributionToParent = reactShadowNodeImpl.getTotalNativeNodeContributionToParent();
        this.mTotalNativeChildren += totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(totalNativeNodeContributionToParent);
    }

    public final void addNativeChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i2) {
        boolean z2 = true;
        Assertions.assertCondition(getNativeKind() == NativeKind.PARENT);
        if (reactShadowNodeImpl.getNativeKind() == NativeKind.NONE) {
            z2 = false;
        }
        Assertions.assertCondition(z2);
        if (this.mNativeChildren == null) {
            this.mNativeChildren = new ArrayList<>(4);
        }
        this.mNativeChildren.add(i2, reactShadowNodeImpl);
        reactShadowNodeImpl.mNativeParent = this;
    }

    public void calculateLayout(float f2, float f3) {
        this.mYogaNode.calculateLayout(f2, f3);
    }

    public final ReactShadowNodeImpl getChildAt(int i2) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i2 + " out of bounds: node has no children");
    }

    public final ReactShadowNodeImpl getLayoutParent() {
        ReactShadowNodeImpl reactShadowNodeImpl = this.mLayoutParent;
        return reactShadowNodeImpl != null ? reactShadowNodeImpl : getNativeParent();
    }

    public final int getNativeOffsetForChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= getChildCount()) {
                break;
            }
            ReactShadowNodeImpl childAt = getChildAt(i2);
            if (reactShadowNodeImpl == childAt) {
                z2 = true;
                break;
            }
            i3 += childAt.getTotalNativeNodeContributionToParent();
            i2++;
        }
        if (z2) {
            return i3;
        }
        throw new RuntimeException("Child " + reactShadowNodeImpl.getReactTag() + " was not a child of " + this.mReactTag);
    }

    public final ReactShadowNodeImpl getNativeParent() {
        return this.mNativeParent;
    }

    public final ReactShadowNodeImpl getParent() {
        return this.mParent;
    }

    public final int indexOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(reactShadowNodeImpl);
    }

    public final int indexOfNativeChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        Assertions.assertNotNull(this.mNativeChildren);
        return this.mNativeChildren.indexOf(reactShadowNodeImpl);
    }

    public boolean isDescendantOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        for (ReactShadowNodeImpl parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent == reactShadowNodeImpl) {
                return true;
            }
        }
        return false;
    }

    public ReactShadowNodeImpl removeChildAt(int i2) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            ReactShadowNodeImpl remove = arrayList.remove(i2);
            remove.mParent = null;
            if (this.mYogaNode != null && !isYogaLeafNode()) {
                this.mYogaNode.removeChildAt(i2);
            }
            markUpdated();
            int totalNativeNodeContributionToParent = remove.getTotalNativeNodeContributionToParent();
            this.mTotalNativeChildren -= totalNativeNodeContributionToParent;
            updateNativeChildrenCountInParent(-totalNativeNodeContributionToParent);
            return remove;
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i2 + " out of bounds: node has no children");
    }

    public final ReactShadowNodeImpl removeNativeChildAt(int i2) {
        Assertions.assertNotNull(this.mNativeChildren);
        ReactShadowNodeImpl remove = this.mNativeChildren.remove(i2);
        remove.mNativeParent = null;
        return remove;
    }

    public final void setLayoutParent(ReactShadowNodeImpl reactShadowNodeImpl) {
        this.mLayoutParent = reactShadowNodeImpl;
    }
}
