package com.facebook.react.animated;

import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.List;

abstract class AnimatedNode {
    private static final int DEFAULT_ANIMATED_NODE_CHILD_COUNT = 1;
    public static final int INITIAL_BFS_COLOR = 0;
    int mActiveIncomingNodes = 0;
    int mBFSColor = 0;
    List<AnimatedNode> mChildren;
    int mTag = -1;

    AnimatedNode() {
    }

    public final void addChild(AnimatedNode animatedNode) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(1);
        }
        ((List) Assertions.assertNotNull(this.mChildren)).add(animatedNode);
        animatedNode.onAttachedToNode(this);
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
    }

    public abstract String prettyPrint();

    public String prettyPrintWithChildren() {
        String str;
        List<AnimatedNode> list = this.mChildren;
        String str2 = "";
        if (list == null || list.size() <= 0) {
            str = str2;
        } else {
            str = str2;
            for (AnimatedNode animatedNode : this.mChildren) {
                str = str + " " + animatedNode.mTag;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prettyPrint());
        if (str.length() > 0) {
            str2 = " children: " + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    public final void removeChild(AnimatedNode animatedNode) {
        if (this.mChildren != null) {
            animatedNode.onDetachedFromNode(this);
            this.mChildren.remove(animatedNode);
        }
    }

    public void update() {
    }
}
