package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: b  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f29628b;

    /* renamed from: c  reason: collision with root package name */
    boolean f29629c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29630d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29631e;

    /* renamed from: f  reason: collision with root package name */
    private BottomSheetBehavior.BottomSheetCallback f29632f = new BottomSheetBehavior.BottomSheetCallback() {
        public void a(View view, float f2) {
        }

        public void b(View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    };

    public BottomSheetDialog(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        supportRequestWindowFeature(1);
    }

    private View c(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, (ViewGroup) null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R$id.design_bottom_sheet);
        BottomSheetBehavior<FrameLayout> I = BottomSheetBehavior.I(frameLayout2);
        this.f29628b = I;
        I.N(this.f29632f);
        this.f29628b.P(this.f29629c);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f29629c && bottomSheetDialog.isShowing() && BottomSheetDialog.this.b()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.r0(frameLayout2, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.f29629c) {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.i0(true);
                    return;
                }
                accessibilityNodeInfoCompat.i0(false);
            }

            public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.f29629c) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i2, bundle);
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R$style.Theme_Design_Light_BottomSheetDialog;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (!this.f29631e) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f29630d = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f29631e = true;
        }
        return this.f29630d;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f29628b;
        if (bottomSheetBehavior != null && bottomSheetBehavior.K() == 5) {
            this.f29628b.S(4);
        }
    }

    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f29629c != z2) {
            this.f29629c = z2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f29628b;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.P(z2);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f29629c) {
            this.f29629c = true;
        }
        this.f29630d = z2;
        this.f29631e = true;
    }

    public void setContentView(int i2) {
        super.setContentView(c(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view) {
        super.setContentView(c(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(c(0, view, layoutParams));
    }
}
