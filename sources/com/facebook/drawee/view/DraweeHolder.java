package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;

public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    private DraweeController mController = null;
    private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
    private DH mHierarchy;
    private boolean mIsControllerAttached = false;
    private boolean mIsHolderAttached = false;
    private boolean mIsVisible = true;

    public DraweeHolder(DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    private void attachController() {
        if (!this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mIsControllerAttached = true;
            DraweeController draweeController = this.mController;
            if (draweeController != null && draweeController.getHierarchy() != null) {
                this.mController.onAttach();
            }
        }
    }

    private void attachOrDetachController() {
        if (!this.mIsHolderAttached || !this.mIsVisible) {
            detachController();
        } else {
            attachController();
        }
    }

    public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(DH dh, Context context) {
        DraweeHolder<DH> draweeHolder = new DraweeHolder<>(dh);
        draweeHolder.registerWithContext(context);
        return draweeHolder;
    }

    private void detachController() {
        if (this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mIsControllerAttached = false;
            if (isControllerValid()) {
                this.mController.onDetach();
            }
        }
    }

    private void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) topLevelDrawable).setVisibilityCallback(visibilityCallback);
        }
    }

    public DraweeController getController() {
        return this.mController;
    }

    /* access modifiers changed from: protected */
    public DraweeEventTracker getDraweeEventTracker() {
        return this.mEventTracker;
    }

    public DH getHierarchy() {
        return (DraweeHierarchy) Preconditions.checkNotNull(this.mHierarchy);
    }

    public Drawable getTopLevelDrawable() {
        DH dh = this.mHierarchy;
        if (dh == null) {
            return null;
        }
        return dh.getTopLevelDrawable();
    }

    public boolean hasHierarchy() {
        return this.mHierarchy != null;
    }

    public boolean isAttached() {
        return this.mIsHolderAttached;
    }

    public boolean isControllerValid() {
        DraweeController draweeController = this.mController;
        return draweeController != null && draweeController.getHierarchy() == this.mHierarchy;
    }

    public void onAttach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mIsHolderAttached = true;
        attachOrDetachController();
    }

    public void onDetach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mIsHolderAttached = false;
        attachOrDetachController();
    }

    public void onDraw() {
        if (!this.mIsControllerAttached) {
            FLog.w((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString());
            this.mIsHolderAttached = true;
            this.mIsVisible = true;
            attachOrDetachController();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isControllerValid()) {
            return false;
        }
        return this.mController.onTouchEvent(motionEvent);
    }

    public void onVisibilityChange(boolean z2) {
        DraweeEventTracker.Event event;
        if (this.mIsVisible != z2) {
            DraweeEventTracker draweeEventTracker = this.mEventTracker;
            if (z2) {
                event = DraweeEventTracker.Event.ON_DRAWABLE_SHOW;
            } else {
                event = DraweeEventTracker.Event.ON_DRAWABLE_HIDE;
            }
            draweeEventTracker.recordEvent(event);
            this.mIsVisible = z2;
            attachOrDetachController();
        }
    }

    public void registerWithContext(Context context) {
    }

    public void setController(DraweeController draweeController) {
        boolean z2 = this.mIsControllerAttached;
        if (z2) {
            detachController();
        }
        if (isControllerValid()) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mController.setHierarchy((DraweeHierarchy) null);
        }
        this.mController = draweeController;
        if (draweeController != null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mController.setHierarchy(this.mHierarchy);
        } else {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z2) {
            attachController();
        }
    }

    public void setHierarchy(DH dh) {
        boolean z2;
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean isControllerValid = isControllerValid();
        setVisibilityCallback((VisibilityCallback) null);
        DH dh2 = (DraweeHierarchy) Preconditions.checkNotNull(dh);
        this.mHierarchy = dh2;
        Drawable topLevelDrawable = dh2.getTopLevelDrawable();
        if (topLevelDrawable == null || topLevelDrawable.isVisible()) {
            z2 = true;
        } else {
            z2 = false;
        }
        onVisibilityChange(z2);
        setVisibilityCallback(this);
        if (isControllerValid) {
            this.mController.setHierarchy(dh);
        }
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", (Object) this.mEventTracker.toString()).toString();
    }
}
