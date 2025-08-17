package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.react.common.SingleThreadAsserter;

public class ShadowNodeRegistry {
    private final SparseBooleanArray mRootTags = new SparseBooleanArray();
    private final SparseArray<ReactShadowNode> mTagsToCSSNodes = new SparseArray<>();
    private final SingleThreadAsserter mThreadAsserter = new SingleThreadAsserter();

    public void addNode(ReactShadowNode reactShadowNode) {
        this.mThreadAsserter.assertNow();
        this.mTagsToCSSNodes.put(reactShadowNode.getReactTag(), reactShadowNode);
    }

    public void addRootNode(ReactShadowNode reactShadowNode) {
        this.mThreadAsserter.assertNow();
        int reactTag = reactShadowNode.getReactTag();
        this.mTagsToCSSNodes.put(reactTag, reactShadowNode);
        this.mRootTags.put(reactTag, true);
    }

    public ReactShadowNode getNode(int i2) {
        this.mThreadAsserter.assertNow();
        return this.mTagsToCSSNodes.get(i2);
    }

    public int getRootNodeCount() {
        this.mThreadAsserter.assertNow();
        return this.mRootTags.size();
    }

    public int getRootTag(int i2) {
        this.mThreadAsserter.assertNow();
        return this.mRootTags.keyAt(i2);
    }

    public boolean isRootNode(int i2) {
        this.mThreadAsserter.assertNow();
        return this.mRootTags.get(i2);
    }

    public void removeNode(int i2) {
        this.mThreadAsserter.assertNow();
        if (!this.mRootTags.get(i2)) {
            this.mTagsToCSSNodes.remove(i2);
            return;
        }
        throw new IllegalViewOperationException("Trying to remove root node " + i2 + " without using removeRootNode!");
    }

    public void removeRootNode(int i2) {
        this.mThreadAsserter.assertNow();
        if (i2 != -1) {
            if (this.mRootTags.get(i2)) {
                this.mTagsToCSSNodes.remove(i2);
                this.mRootTags.delete(i2);
                return;
            }
            throw new IllegalViewOperationException("View with tag " + i2 + " is not registered as a root view");
        }
    }
}
