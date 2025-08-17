package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.startapp.ma;
import com.startapp.p;

public class CloseableLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f35926a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f35927b;

    /* renamed from: c  reason: collision with root package name */
    public a f35928c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f35929d;

    /* renamed from: e  reason: collision with root package name */
    public ClosePosition f35930e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35931f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35932g;

    /* renamed from: h  reason: collision with root package name */
    public final int f35933h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35934i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f35935j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f35936k;

    /* renamed from: l  reason: collision with root package name */
    public final Rect f35937l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f35938m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f35939n;

    /* renamed from: o  reason: collision with root package name */
    public b f35940o;

    public interface a {
        void onClose();
    }

    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            CloseableLayout closeableLayout = CloseableLayout.this;
            int i2 = CloseableLayout.f35926a;
            closeableLayout.a(false);
        }
    }

    public CloseableLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public final void a(boolean z2) {
        int[] state = this.f35929d.getState();
        int[] iArr = FrameLayout.SELECTED_STATE_SET;
        if (z2 != (state == iArr)) {
            Drawable drawable = this.f35929d;
            if (!z2) {
                iArr = FrameLayout.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
            invalidate(this.f35936k);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f35934i) {
            this.f35934i = false;
            this.f35935j.set(0, 0, getWidth(), getHeight());
            ClosePosition closePosition = this.f35930e;
            Rect rect = this.f35935j;
            Rect rect2 = this.f35936k;
            int i2 = this.f35931f;
            Gravity.apply(closePosition.a(), i2, i2, rect, rect2);
            this.f35938m.set(this.f35936k);
            Rect rect3 = this.f35938m;
            int i3 = this.f35933h;
            rect3.inset(i3, i3);
            ClosePosition closePosition2 = this.f35930e;
            Rect rect4 = this.f35938m;
            Rect rect5 = this.f35937l;
            int i4 = this.f35932g;
            Gravity.apply(closePosition2.a(), i4, i4, rect4, rect5);
            this.f35929d.setBounds(this.f35937l);
        }
        if (this.f35929d.isVisible()) {
            this.f35929d.draw(canvas);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f35934i = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        if (a((int) motionEvent.getX(), (int) motionEvent.getY(), this.f35927b)) {
            if (this.f35939n || this.f35929d.isVisible()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    a(true);
                } else if (action == 1) {
                    if (this.f35929d.getState() == FrameLayout.SELECTED_STATE_SET) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (this.f35940o == null) {
                            this.f35940o = new b();
                        }
                        postDelayed(this.f35940o, (long) ViewConfiguration.getPressedStateDuration());
                        playSoundEffect(0);
                        a aVar = this.f35928c;
                        if (aVar != null) {
                            aVar.onClose();
                        }
                    }
                } else if (action == 3) {
                    a(false);
                }
                return true;
            }
        }
        a(false);
        super.onTouchEvent(motionEvent);
        return false;
    }

    public void setCloseAlwaysInteractable(boolean z2) {
        this.f35939n = z2;
    }

    public void setCloseBoundChanged(boolean z2) {
        this.f35934i = z2;
    }

    public void setCloseBounds(Rect rect) {
        this.f35936k.set(rect);
    }

    public void setClosePosition(ClosePosition closePosition) {
        this.f35930e = closePosition;
        this.f35934i = true;
        invalidate();
    }

    public void setCloseVisible(boolean z2) {
        if (this.f35929d.setVisible(z2, false)) {
            invalidate(this.f35936k);
        }
    }

    public void setOnCloseListener(a aVar) {
        this.f35928c = aVar;
    }

    public CloseableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35935j = new Rect();
        this.f35936k = new Rect();
        this.f35937l = new Rect();
        this.f35938m = new Rect();
        Drawable a2 = ma.a(context.getResources(), "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC");
        this.f35929d = a2;
        this.f35930e = ClosePosition.TOP_RIGHT;
        a2.setState(FrameLayout.EMPTY_STATE_SET);
        a2.setCallback(this);
        this.f35927b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f35931f = p.a(context, 50);
        this.f35932g = p.a(context, 30);
        this.f35933h = p.a(context, 8);
        setWillNotDraw(false);
        this.f35939n = true;
    }

    public boolean a(int i2, int i3, int i4) {
        Rect rect = this.f35936k;
        return i2 >= rect.left - i4 && i3 >= rect.top - i4 && i2 < rect.right + i4 && i3 < rect.bottom + i4;
    }

    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        private final int mGravity;

        /* access modifiers changed from: public */
        ClosePosition(int i2) {
            this.mGravity = i2;
        }

        public static ClosePosition a(String str, ClosePosition closePosition) throws Exception {
            if (TextUtils.isEmpty(str)) {
                return closePosition;
            }
            if (str.equals("top-left")) {
                return TOP_LEFT;
            }
            if (str.equals("top-right")) {
                return TOP_RIGHT;
            }
            if (str.equals("center")) {
                return CENTER;
            }
            if (str.equals("bottom-left")) {
                return BOTTOM_LEFT;
            }
            if (str.equals("bottom-right")) {
                return BOTTOM_RIGHT;
            }
            if (str.equals("top-center")) {
                return TOP_CENTER;
            }
            if (str.equals("bottom-center")) {
                return BOTTOM_CENTER;
            }
            throw new Exception("Invalid close position: " + str);
        }

        public int a() {
            return this.mGravity;
        }
    }
}
