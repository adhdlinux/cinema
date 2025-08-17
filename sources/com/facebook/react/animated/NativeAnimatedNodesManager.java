package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String TAG = "NativeAnimatedNodesManager";
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    /* access modifiers changed from: private */
    public boolean mEventListenerInitializedForFabric = false;
    /* access modifiers changed from: private */
    public boolean mEventListenerInitializedForNonFabric = false;
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactApplicationContext;
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();
    private boolean mWarnedAboutGraphTraversal = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    public void handleEvent(Event event) {
        ReactApplicationContext reactApplicationContext;
        UIManager uIManager;
        if (!this.mEventDrivers.isEmpty() && (reactApplicationContext = this.mReactApplicationContext) != null && (uIManager = UIManagerHelper.getUIManager(reactApplicationContext, event.getUIManagerType())) != null) {
            String resolveCustomDirectEventName = uIManager.resolveCustomDirectEventName(event.getEventName());
            if (resolveCustomDirectEventName == null) {
                resolveCustomDirectEventName = "";
            }
            Map<String, List<EventAnimationDriver>> map = this.mEventDrivers;
            List<EventAnimationDriver> list = map.get(event.getViewTag() + resolveCustomDirectEventName);
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i2 = 0;
        while (i2 < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        String str;
        int i2;
        int i3 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i3;
        if (i3 == 0) {
            this.mAnimatedGraphBFSColor = i3 + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i4 = 0;
        for (AnimatedNode next : list) {
            int i5 = next.mBFSColor;
            int i6 = this.mAnimatedGraphBFSColor;
            if (i5 != i6) {
                next.mBFSColor = i6;
                i4++;
                arrayDeque.add(next);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode = (AnimatedNode) arrayDeque.poll();
            if (animatedNode.mChildren != null) {
                for (int i7 = 0; i7 < animatedNode.mChildren.size(); i7++) {
                    AnimatedNode animatedNode2 = animatedNode.mChildren.get(i7);
                    animatedNode2.mActiveIncomingNodes++;
                    int i8 = animatedNode2.mBFSColor;
                    int i9 = this.mAnimatedGraphBFSColor;
                    if (i8 != i9) {
                        animatedNode2.mBFSColor = i9;
                        i4++;
                        arrayDeque.add(animatedNode2);
                    }
                }
            }
        }
        int i10 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i10;
        if (i10 == 0) {
            this.mAnimatedGraphBFSColor = i10 + 1;
        }
        int i11 = 0;
        for (AnimatedNode next2 : list) {
            if (next2.mActiveIncomingNodes == 0 && next2.mBFSColor != (i2 = this.mAnimatedGraphBFSColor)) {
                next2.mBFSColor = i2;
                i11++;
                arrayDeque.add(next2);
            }
        }
        int i12 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode3.update();
                if (animatedNode3 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode3).updateView();
                }
            } catch (JSApplicationCausedNativeException e2) {
                FLog.e(TAG, "Native animation workaround, frame lost as result of race condition", (Throwable) e2);
            }
            if (animatedNode3 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode3).onValueUpdate();
            }
            if (animatedNode3.mChildren != null) {
                for (int i13 = 0; i13 < animatedNode3.mChildren.size(); i13++) {
                    AnimatedNode animatedNode4 = animatedNode3.mChildren.get(i13);
                    int i14 = animatedNode4.mActiveIncomingNodes - 1;
                    animatedNode4.mActiveIncomingNodes = i14;
                    int i15 = animatedNode4.mBFSColor;
                    int i16 = this.mAnimatedGraphBFSColor;
                    if (i15 != i16 && i14 == 0) {
                        animatedNode4.mBFSColor = i16;
                        i11++;
                        arrayDeque.add(animatedNode4);
                    } else if (i15 == i16) {
                        i12++;
                    }
                }
            }
        }
        if (i4 == i11) {
            this.mWarnedAboutGraphTraversal = false;
        } else if (!this.mWarnedAboutGraphTraversal) {
            this.mWarnedAboutGraphTraversal = true;
            FLog.e(TAG, "Detected animation cycle or disconnected graph. ");
            for (AnimatedNode prettyPrintWithChildren : list) {
                FLog.e(TAG, prettyPrintWithChildren.prettyPrintWithChildren());
            }
            if (i12 > 0) {
                str = "cycles (" + i12 + ")";
            } else {
                str = "disconnected regions";
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + str + ", there are " + i4 + " but toposort visited only " + i11);
            boolean z2 = this.mEventListenerInitializedForFabric;
            if (z2 && i12 == 0) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else if (z2) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else {
                throw illegalStateException;
            }
        }
    }

    public void addAnimatedEventToView(int i2, String str, ReadableMap readableMap) {
        int i3 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i3);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node with tag [" + i3 + "] does not exist");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i4 = 0; i4 < array.size(); i4++) {
                arrayList.add(array.getString(i4));
            }
            EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
            String str2 = i2 + str;
            if (this.mEventDrivers.containsKey(str2)) {
                this.mEventDrivers.get(str2).add(eventAnimationDriver);
                return;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(eventAnimationDriver);
            this.mEventDrivers.put(str2, arrayList2);
        } else {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node on view [" + i2 + "] connected to event (" + str + ") should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    public void connectAnimatedNodeToView(int i2, int i3) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node with tag [" + i2 + "] does not exist");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
            if (reactApplicationContext != null) {
                UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i3);
                if (uIManagerForReactTag == null) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i3));
                    return;
                }
                ((PropsAnimatedNode) animatedNode).connectToView(i3, uIManagerForReactTag);
                this.mUpdatedNodes.put(i2, animatedNode);
                return;
            }
            throw new IllegalStateException("connectAnimatedNodeToView: Animated node could not be connected, no ReactApplicationContext: " + i3);
        } else {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node connected to view [" + i3 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void connectAnimatedNodes(int i2, int i3) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i3);
            if (animatedNode2 != null) {
                animatedNode.addChild(animatedNode2);
                this.mUpdatedNodes.put(i3, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (child) [" + i3 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (parent) [" + i2 + "] does not exist");
    }

    public void createAnimatedNode(int i2, ReadableMap readableMap) {
        AnimatedNode animatedNode;
        if (this.mAnimatedNodes.get(i2) == null) {
            String string = readableMap.getString("type");
            if ("style".equals(string)) {
                animatedNode = new StyleAnimatedNode(readableMap, this);
            } else if (AppMeasurementSdk.ConditionalUserProperty.VALUE.equals(string)) {
                animatedNode = new ValueAnimatedNode(readableMap);
            } else if (ViewProps.COLOR.equals(string)) {
                animatedNode = new ColorAnimatedNode(readableMap, this, this.mReactApplicationContext);
            } else if ("props".equals(string)) {
                animatedNode = new PropsAnimatedNode(readableMap, this);
            } else if ("interpolation".equals(string)) {
                animatedNode = new InterpolationAnimatedNode(readableMap);
            } else if ("addition".equals(string)) {
                animatedNode = new AdditionAnimatedNode(readableMap, this);
            } else if ("subtraction".equals(string)) {
                animatedNode = new SubtractionAnimatedNode(readableMap, this);
            } else if ("division".equals(string)) {
                animatedNode = new DivisionAnimatedNode(readableMap, this);
            } else if ("multiplication".equals(string)) {
                animatedNode = new MultiplicationAnimatedNode(readableMap, this);
            } else if ("modulus".equals(string)) {
                animatedNode = new ModulusAnimatedNode(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                animatedNode = new DiffClampAnimatedNode(readableMap, this);
            } else if (ViewProps.TRANSFORM.equals(string)) {
                animatedNode = new TransformAnimatedNode(readableMap, this);
            } else if ("tracking".equals(string)) {
                animatedNode = new TrackingAnimatedNode(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            animatedNode.mTag = i2;
            this.mAnimatedNodes.put(i2, animatedNode);
            this.mUpdatedNodes.put(i2, animatedNode);
            return;
        }
        throw new JSApplicationIllegalArgumentException("createAnimatedNode: Animated node [" + i2 + "] already exists");
    }

    public void disconnectAnimatedNodeFromView(int i2, int i3) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node with tag [" + i2 + "] does not exist");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ((PropsAnimatedNode) animatedNode).disconnectFromView(i3);
        } else {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node connected to view [" + i3 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void disconnectAnimatedNodes(int i2, int i3) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i3);
            if (animatedNode2 != null) {
                animatedNode.removeChild(animatedNode2);
                this.mUpdatedNodes.put(i3, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (child) [" + i3 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (parent) [" + i2 + "] does not exist");
    }

    public void dropAnimatedNode(int i2) {
        this.mAnimatedNodes.remove(i2);
        this.mUpdatedNodes.remove(i2);
    }

    public void extractAnimatedNodeOffset(int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("extractAnimatedNodeOffset: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void flattenAnimatedNodeOffset(int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("flattenAnimatedNodeOffset: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    /* access modifiers changed from: package-private */
    public AnimatedNode getNodeById(int i2) {
        return this.mAnimatedNodes.get(i2);
    }

    public void getValue(int i2, Callback callback) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("getValue: Animated node with tag [" + i2 + "] does not exist or is not a 'value' node");
        }
        callback.invoke(Double.valueOf(((ValueAnimatedNode) animatedNode).getValue()));
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void initializeEventListenerForUIManagerType(final int i2) {
        if (i2 == 2 && this.mEventListenerInitializedForFabric) {
            return;
        }
        if (i2 != 1 || !this.mEventListenerInitializedForNonFabric) {
            this.mReactApplicationContext.runOnUiQueueThread(new Runnable() {
                public void run() {
                    UIManager uIManager = UIManagerHelper.getUIManager(NativeAnimatedNodesManager.this.mReactApplicationContext, i2);
                    if (uIManager != null) {
                        ((EventDispatcher) uIManager.getEventDispatcher()).addListener(this);
                        if (i2 == 2) {
                            boolean unused = NativeAnimatedNodesManager.this.mEventListenerInitializedForFabric = true;
                        } else {
                            boolean unused2 = NativeAnimatedNodesManager.this.mEventListenerInitializedForNonFabric = true;
                        }
                    }
                }
            });
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    public void removeAnimatedEventFromView(int i2, String str, int i3) {
        String str2 = i2 + str;
        if (this.mEventDrivers.containsKey(str2)) {
            List list = this.mEventDrivers.get(str2);
            if (list.size() == 1) {
                this.mEventDrivers.remove(i2 + str);
                return;
            }
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (((EventAnimationDriver) listIterator.next()).mValueNode.mTag == i3) {
                    listIterator.remove();
                    return;
                }
            }
        }
    }

    public void restoreDefaultValues(int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view [?] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void runUpdates(long j2) {
        UiThreadUtil.assertOnUiThread();
        for (int i2 = 0; i2 < this.mUpdatedNodes.size(); i2++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i2));
        }
        this.mUpdatedNodes.clear();
        boolean z2 = false;
        for (int i3 = 0; i3 < this.mActiveAnimations.size(); i3++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i3);
            valueAt.runAnimationStep(j2);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z2 = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z2) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    public void setAnimatedNodeOffset(int i2, double d2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeOffset: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).mOffset = d2;
        this.mUpdatedNodes.put(i2, animatedNode);
    }

    public void setAnimatedNodeValue(int i2, double d2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeValue: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).mValue = d2;
        this.mUpdatedNodes.put(i2, animatedNode);
    }

    public void startAnimatingNode(int i2, int i3, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i3);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i3 + "] does not exist");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            AnimationDriver animationDriver2 = this.mActiveAnimations.get(i2);
            if (animationDriver2 != null) {
                animationDriver2.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if ("frames".equals(string)) {
                animationDriver = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                animationDriver = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                animationDriver = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException("startAnimatingNode: Unsupported animation type [" + i3 + "]: " + string);
            }
            animationDriver.mId = i2;
            animationDriver.mEndCallback = callback;
            animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i2, animationDriver);
        } else {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i3 + "] should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    public void startListeningToAnimatedNodeValue(int i2, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopAnimation(int i2) {
        for (int i3 = 0; i3 < this.mActiveAnimations.size(); i3++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i3);
            if (valueAt.mId == i2) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i3);
                return;
            }
        }
    }

    public void stopListeningToAnimatedNodeValue(int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i2 + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener((AnimatedNodeValueListener) null);
    }

    public void updateAnimatedNodeConfig(int i2, ReadableMap readableMap) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("updateAnimatedNode: Animated node [" + i2 + "] does not exist");
        } else if (animatedNode instanceof AnimatedNodeWithUpdateableConfig) {
            stopAnimationsForNode(animatedNode);
            ((AnimatedNodeWithUpdateableConfig) animatedNode).onUpdateConfig(readableMap);
            this.mUpdatedNodes.put(i2, animatedNode);
        }
    }
}
