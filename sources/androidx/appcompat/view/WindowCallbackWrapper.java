package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f728b;

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i2) {
            return callback.onWindowStartingActionMode(callback2, i2);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            callback.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(Window.Callback callback, boolean z2) {
            callback.onPointerCaptureChanged(z2);
        }
    }

    public WindowCallbackWrapper(Window.Callback callback) {
        if (callback != null) {
            this.f728b = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f728b;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f728b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f728b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f728b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f728b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f728b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f728b.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f728b.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f728b.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f728b.onAttachedToWindow();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f728b.onCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return this.f728b.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f728b.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f728b.onMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f728b.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f728b.onPanelClosed(i2, menu);
    }

    public void onPointerCaptureChanged(boolean z2) {
        Api26Impl.a(this.f728b, z2);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f728b.onPreparePanel(i2, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        Api24Impl.a(this.f728b, list, menu, i2);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return Api23Impl.a(this.f728b, searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f728b.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z2) {
        this.f728b.onWindowFocusChanged(z2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f728b.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f728b.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return Api23Impl.b(this.f728b, callback, i2);
    }
}
