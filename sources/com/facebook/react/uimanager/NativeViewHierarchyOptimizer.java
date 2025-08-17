package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

public class NativeViewHierarchyOptimizer {
    private static final boolean ENABLED = true;
    private static final String TAG = "NativeViewHierarchyOptimizer";
    private final ShadowNodeRegistry mShadowNodeRegistry;
    private final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
    private final UIViewOperationQueue mUIViewOperationQueue;

    private static class NodeIndexPair {
        public final int index;
        public final ReactShadowNode node;

        NodeIndexPair(ReactShadowNode reactShadowNode, int i2) {
            this.node = reactShadowNode;
            this.index = i2;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.mUIViewOperationQueue = uIViewOperationQueue;
        this.mShadowNodeRegistry = shadowNodeRegistry;
    }

    private void addGrandchildren(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        boolean z2;
        boolean z3;
        if (reactShadowNode2.getNativeKind() != NativeKind.PARENT) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2);
        for (int i3 = 0; i3 < reactShadowNode2.getChildCount(); i3++) {
            ReactShadowNode childAt = reactShadowNode2.getChildAt(i3);
            if (childAt.getNativeParent() == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.assertCondition(z3);
            int nativeChildCount = reactShadowNode.getNativeChildCount();
            if (childAt.getNativeKind() == NativeKind.NONE) {
                addNonNativeChild(reactShadowNode, childAt, i2);
            } else {
                addNativeChild(reactShadowNode, childAt, i2);
            }
            i2 += reactShadowNode.getNativeChildCount() - nativeChildCount;
        }
    }

    private void addNativeChild(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        reactShadowNode.addNativeChildAt(reactShadowNode2, i2);
        this.mUIViewOperationQueue.enqueueManageChildren(reactShadowNode.getReactTag(), (int[]) null, new ViewAtIndex[]{new ViewAtIndex(reactShadowNode2.getReactTag(), i2)}, (int[]) null);
        if (reactShadowNode2.getNativeKind() != NativeKind.PARENT) {
            addGrandchildren(reactShadowNode, reactShadowNode2, i2 + 1);
        }
    }

    private void addNodeToNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        int nativeOffsetForChild = reactShadowNode.getNativeOffsetForChild(reactShadowNode.getChildAt(i2));
        if (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            NodeIndexPair walkUpUntilNativeKindIsParent = walkUpUntilNativeKindIsParent(reactShadowNode, nativeOffsetForChild);
            if (walkUpUntilNativeKindIsParent != null) {
                ReactShadowNode reactShadowNode3 = walkUpUntilNativeKindIsParent.node;
                nativeOffsetForChild = walkUpUntilNativeKindIsParent.index;
                reactShadowNode = reactShadowNode3;
            } else {
                return;
            }
        }
        if (reactShadowNode2.getNativeKind() != NativeKind.NONE) {
            addNativeChild(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        } else {
            addNonNativeChild(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        }
    }

    private void addNonNativeChild(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        addGrandchildren(reactShadowNode, reactShadowNode2, i2);
    }

    private void applyLayoutBase(ReactShadowNode reactShadowNode) {
        int reactTag = reactShadowNode.getReactTag();
        if (!this.mTagsWithLayoutVisited.get(reactTag)) {
            this.mTagsWithLayoutVisited.put(reactTag, true);
            ReactShadowNode parent = reactShadowNode.getParent();
            int screenX = reactShadowNode.getScreenX();
            int screenY = reactShadowNode.getScreenY();
            while (parent != null && parent.getNativeKind() != NativeKind.PARENT) {
                if (!parent.isVirtual()) {
                    screenX += Math.round(parent.getLayoutX());
                    screenY += Math.round(parent.getLayoutY());
                }
                parent = parent.getParent();
            }
            applyLayoutRecursive(reactShadowNode, screenX, screenY);
        }
    }

    private void applyLayoutRecursive(ReactShadowNode reactShadowNode, int i2, int i3) {
        if (reactShadowNode.getNativeKind() == NativeKind.NONE || reactShadowNode.getNativeParent() == null) {
            for (int i4 = 0; i4 < reactShadowNode.getChildCount(); i4++) {
                ReactShadowNode childAt = reactShadowNode.getChildAt(i4);
                int reactTag = childAt.getReactTag();
                if (!this.mTagsWithLayoutVisited.get(reactTag)) {
                    this.mTagsWithLayoutVisited.put(reactTag, true);
                    applyLayoutRecursive(childAt, childAt.getScreenX() + i2, childAt.getScreenY() + i3);
                }
            }
            return;
        }
        this.mUIViewOperationQueue.enqueueUpdateLayout(reactShadowNode.getLayoutParent().getReactTag(), reactShadowNode.getReactTag(), i2, i3, reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight());
    }

    public static void assertNodeSupportedWithoutOptimizer(ReactShadowNode reactShadowNode) {
        boolean z2;
        if (reactShadowNode.getNativeKind() != NativeKind.LEAF) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Nodes with NativeKind.LEAF are not supported when the optimizer is disabled");
    }

    public static void handleRemoveNode(ReactShadowNode reactShadowNode) {
        reactShadowNode.removeAllNativeChildren();
    }

    private static boolean isLayoutOnlyAndCollapsable(ReactStylesDiffMap reactStylesDiffMap) {
        if (reactStylesDiffMap == null) {
            return true;
        }
        if (reactStylesDiffMap.hasKey(ViewProps.COLLAPSABLE) && !reactStylesDiffMap.getBoolean(ViewProps.COLLAPSABLE, true)) {
            return false;
        }
        ReadableMapKeySetIterator keySetIterator = reactStylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            if (!ViewProps.isLayoutOnly(reactStylesDiffMap.mBackingMap, keySetIterator.nextKey())) {
                return false;
            }
        }
        return true;
    }

    private void removeNodeFromParent(ReactShadowNode reactShadowNode, boolean z2) {
        if (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
                removeNodeFromParent(reactShadowNode.getChildAt(childCount), z2);
            }
        }
        ReactShadowNode nativeParent = reactShadowNode.getNativeParent();
        if (nativeParent != null) {
            int indexOfNativeChild = nativeParent.indexOfNativeChild(reactShadowNode);
            nativeParent.removeNativeChildAt(indexOfNativeChild);
            this.mUIViewOperationQueue.enqueueManageChildren(nativeParent.getReactTag(), new int[]{indexOfNativeChild}, (ViewAtIndex[]) null, z2 ? new int[]{reactShadowNode.getReactTag()} : null);
        }
    }

    private void transitionLayoutOnlyViewToNativeView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        boolean z2;
        ReactShadowNode parent = reactShadowNode.getParent();
        if (parent == null) {
            reactShadowNode.setIsLayoutOnly(false);
            return;
        }
        int indexOf = parent.indexOf(reactShadowNode);
        parent.removeChildAt(indexOf);
        removeNodeFromParent(reactShadowNode, false);
        reactShadowNode.setIsLayoutOnly(false);
        this.mUIViewOperationQueue.enqueueCreateView(reactShadowNode.getThemedContext(), reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        parent.addChildAt(reactShadowNode, indexOf);
        addNodeToNode(parent, reactShadowNode, indexOf);
        for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
            addNodeToNode(reactShadowNode, reactShadowNode.getChildAt(i2), i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Transitioning LayoutOnlyView - tag: ");
        sb.append(reactShadowNode.getReactTag());
        sb.append(" - rootTag: ");
        sb.append(reactShadowNode.getRootTag());
        sb.append(" - hasProps: ");
        boolean z3 = true;
        if (reactStylesDiffMap != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        sb.append(" - tagsWithLayout.size: ");
        sb.append(this.mTagsWithLayoutVisited.size());
        FLog.i(TAG, sb.toString());
        if (this.mTagsWithLayoutVisited.size() != 0) {
            z3 = false;
        }
        Assertions.assertCondition(z3);
        applyLayoutBase(reactShadowNode);
        for (int i3 = 0; i3 < reactShadowNode.getChildCount(); i3++) {
            applyLayoutBase(reactShadowNode.getChildAt(i3));
        }
        this.mTagsWithLayoutVisited.clear();
    }

    private NodeIndexPair walkUpUntilNativeKindIsParent(ReactShadowNode reactShadowNode, int i2) {
        int i3;
        while (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            ReactShadowNode parent = reactShadowNode.getParent();
            if (parent == null) {
                return null;
            }
            if (reactShadowNode.getNativeKind() == NativeKind.LEAF) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i2 + i3 + parent.getNativeOffsetForChild(reactShadowNode);
            reactShadowNode = parent;
        }
        return new NodeIndexPair(reactShadowNode, i2);
    }

    public void handleCreateView(ReactShadowNode reactShadowNode, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap) {
        boolean z2;
        if (!reactShadowNode.getViewClass().equals("RCTView") || !isLayoutOnlyAndCollapsable(reactStylesDiffMap)) {
            z2 = false;
        } else {
            z2 = true;
        }
        reactShadowNode.setIsLayoutOnly(z2);
        if (reactShadowNode.getNativeKind() != NativeKind.NONE) {
            this.mUIViewOperationQueue.enqueueCreateView(themedReactContext, reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        }
    }

    public void handleForceViewToBeNonLayoutOnly(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.isLayoutOnly()) {
            transitionLayoutOnlyViewToNativeView(reactShadowNode, (ReactStylesDiffMap) null);
        }
    }

    public void handleManageChildren(ReactShadowNode reactShadowNode, int[] iArr, int[] iArr2, ViewAtIndex[] viewAtIndexArr, int[] iArr3) {
        boolean z2;
        for (int i2 : iArr2) {
            int i3 = 0;
            while (true) {
                if (i3 >= iArr3.length) {
                    z2 = false;
                    break;
                } else if (iArr3[i3] == i2) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            removeNodeFromParent(this.mShadowNodeRegistry.getNode(i2), z2);
        }
        for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(viewAtIndex.mTag), viewAtIndex.mIndex);
        }
    }

    public void handleSetChildren(ReactShadowNode reactShadowNode, ReadableArray readableArray) {
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(readableArray.getInt(i2)), i2);
        }
    }

    public void handleUpdateLayout(ReactShadowNode reactShadowNode) {
        applyLayoutBase(reactShadowNode);
    }

    public void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        boolean z2;
        if (!reactShadowNode.isLayoutOnly() || isLayoutOnlyAndCollapsable(reactStylesDiffMap)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            transitionLayoutOnlyViewToNativeView(reactShadowNode, reactStylesDiffMap);
        } else if (!reactShadowNode.isLayoutOnly()) {
            this.mUIViewOperationQueue.enqueueUpdateProperties(reactShadowNode.getReactTag(), str, reactStylesDiffMap);
        }
    }

    public void onBatchComplete() {
        this.mTagsWithLayoutVisited.clear();
    }

    /* access modifiers changed from: package-private */
    public void onViewUpdatesCompleted(ReactShadowNode reactShadowNode) {
        this.mTagsWithLayoutVisited.clear();
    }
}
