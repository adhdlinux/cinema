package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;

public class AccessibilityNodeInfoCompat {

    /* renamed from: d  reason: collision with root package name */
    private static int f2853d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f2854a;

    /* renamed from: b  reason: collision with root package name */
    public int f2855b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f2856c = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A;
        public static final AccessibilityActionCompat B;
        public static final AccessibilityActionCompat C;
        public static final AccessibilityActionCompat D;
        public static final AccessibilityActionCompat E;
        public static final AccessibilityActionCompat F;
        public static final AccessibilityActionCompat G;
        public static final AccessibilityActionCompat H;
        public static final AccessibilityActionCompat I;
        public static final AccessibilityActionCompat J;
        public static final AccessibilityActionCompat K;
        public static final AccessibilityActionCompat L;
        public static final AccessibilityActionCompat M;
        public static final AccessibilityActionCompat N;
        public static final AccessibilityActionCompat O;
        public static final AccessibilityActionCompat P;
        public static final AccessibilityActionCompat Q;
        public static final AccessibilityActionCompat R;
        public static final AccessibilityActionCompat S;
        public static final AccessibilityActionCompat T;
        public static final AccessibilityActionCompat U;

        /* renamed from: e  reason: collision with root package name */
        public static final AccessibilityActionCompat f2857e = new AccessibilityActionCompat(1, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final AccessibilityActionCompat f2858f = new AccessibilityActionCompat(2, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final AccessibilityActionCompat f2859g = new AccessibilityActionCompat(4, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final AccessibilityActionCompat f2860h = new AccessibilityActionCompat(8, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final AccessibilityActionCompat f2861i = new AccessibilityActionCompat(16, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final AccessibilityActionCompat f2862j = new AccessibilityActionCompat(32, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final AccessibilityActionCompat f2863k = new AccessibilityActionCompat(64, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final AccessibilityActionCompat f2864l = new AccessibilityActionCompat(128, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final AccessibilityActionCompat f2865m;

        /* renamed from: n  reason: collision with root package name */
        public static final AccessibilityActionCompat f2866n;

        /* renamed from: o  reason: collision with root package name */
        public static final AccessibilityActionCompat f2867o;

        /* renamed from: p  reason: collision with root package name */
        public static final AccessibilityActionCompat f2868p;

        /* renamed from: q  reason: collision with root package name */
        public static final AccessibilityActionCompat f2869q = new AccessibilityActionCompat(CodedOutputStream.DEFAULT_BUFFER_SIZE, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final AccessibilityActionCompat f2870r = new AccessibilityActionCompat(8192, (CharSequence) null);

        /* renamed from: s  reason: collision with root package name */
        public static final AccessibilityActionCompat f2871s = new AccessibilityActionCompat(Http2.INITIAL_MAX_FRAME_SIZE, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final AccessibilityActionCompat f2872t = new AccessibilityActionCompat(32768, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final AccessibilityActionCompat f2873u = new AccessibilityActionCompat(65536, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final AccessibilityActionCompat f2874v = new AccessibilityActionCompat(131072, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);

        /* renamed from: w  reason: collision with root package name */
        public static final AccessibilityActionCompat f2875w = new AccessibilityActionCompat(262144, (CharSequence) null);

        /* renamed from: x  reason: collision with root package name */
        public static final AccessibilityActionCompat f2876x = new AccessibilityActionCompat(ImageMetadata.LENS_APERTURE, (CharSequence) null);

        /* renamed from: y  reason: collision with root package name */
        public static final AccessibilityActionCompat f2877y = new AccessibilityActionCompat(1048576, (CharSequence) null);

        /* renamed from: z  reason: collision with root package name */
        public static final AccessibilityActionCompat f2878z = new AccessibilityActionCompat(2097152, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);

        /* renamed from: a  reason: collision with root package name */
        final Object f2879a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2880b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends AccessibilityViewCommand.CommandArguments> f2881c;

        /* renamed from: d  reason: collision with root package name */
        protected final AccessibilityViewCommand f2882d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21 = null;
            Class<AccessibilityViewCommand.MoveAtGranularityArguments> cls = AccessibilityViewCommand.MoveAtGranularityArguments.class;
            f2865m = new AccessibilityActionCompat(UserVerificationMethods.USER_VERIFY_HANDPRINT, (CharSequence) null, cls);
            f2866n = new AccessibilityActionCompat(512, (CharSequence) null, cls);
            Class<AccessibilityViewCommand.MoveHtmlArguments> cls2 = AccessibilityViewCommand.MoveHtmlArguments.class;
            f2867o = new AccessibilityActionCompat(1024, (CharSequence) null, cls2);
            f2868p = new AccessibilityActionCompat(2048, (CharSequence) null, cls2);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            A = new AccessibilityActionCompat(accessibilityAction, 16908342, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction2 = null;
            }
            B = new AccessibilityActionCompat(accessibilityAction2, 16908343, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (i2 >= 23) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                accessibilityAction3 = null;
            }
            C = new AccessibilityActionCompat(accessibilityAction3, 16908344, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 23) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                accessibilityAction4 = null;
            }
            D = new AccessibilityActionCompat(accessibilityAction4, 16908345, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 23) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                accessibilityAction5 = null;
            }
            E = new AccessibilityActionCompat(accessibilityAction5, 16908346, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 23) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                accessibilityAction6 = null;
            }
            F = new AccessibilityActionCompat(accessibilityAction6, 16908347, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 29) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction7 = null;
            }
            G = new AccessibilityActionCompat(accessibilityAction7, 16908358, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 29) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction8 = null;
            }
            H = new AccessibilityActionCompat(accessibilityAction8, 16908359, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 29) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction9 = null;
            }
            I = new AccessibilityActionCompat(accessibilityAction9, 16908360, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 29) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction10 = null;
            }
            J = new AccessibilityActionCompat(accessibilityAction10, 16908361, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 23) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction11 = null;
            }
            K = new AccessibilityActionCompat(accessibilityAction11, 16908348, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 24) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction12 = null;
            }
            L = new AccessibilityActionCompat(accessibilityAction12, 16908349, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i2 >= 26) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction13 = null;
            }
            M = new AccessibilityActionCompat(accessibilityAction13, 16908354, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i2 >= 28) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction14 = null;
            }
            N = new AccessibilityActionCompat(accessibilityAction14, 16908356, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 28) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction15 = null;
            }
            O = new AccessibilityActionCompat(accessibilityAction15, 16908357, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 30) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction16 = null;
            }
            P = new AccessibilityActionCompat(accessibilityAction16, 16908362, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            } else {
                accessibilityAction17 = null;
            }
            Q = new AccessibilityActionCompat(accessibilityAction17, 16908372, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 32) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction18 = null;
            }
            R = new AccessibilityActionCompat(accessibilityAction18, 16908373, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 32) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            } else {
                accessibilityAction19 = null;
            }
            S = new AccessibilityActionCompat(accessibilityAction19, 16908374, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 32) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            } else {
                accessibilityAction20 = null;
            }
            T = new AccessibilityActionCompat(accessibilityAction20, 16908375, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 33) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            U = new AccessibilityActionCompat(accessibilityAction21, 16908376, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public AccessibilityActionCompat a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat((Object) null, this.f2880b, charSequence, accessibilityViewCommand, this.f2881c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f2879a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f2879a).getLabel();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.AccessibilityViewCommand r0 = r4.f2882d
                r1 = 0
                if (r0 == 0) goto L_0x0049
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.f2881c
                r2 = 0
                if (r0 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r0 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r0     // Catch:{ Exception -> 0x0020 }
                r0.a(r6)     // Catch:{ Exception -> 0x001d }
                r2 = r0
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r2 = r0
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.f2881c
                if (r0 != 0) goto L_0x0028
                java.lang.String r0 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r0 = r0.getName()
            L_0x002c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r1.append(r3)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.String r1 = "A11yActionCompat"
                android.util.Log.e(r1, r0, r6)
            L_0x0042:
                androidx.core.view.accessibility.AccessibilityViewCommand r6 = r4.f2882d
                boolean r5 = r6.a(r5, r2)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f2879a;
            if (obj2 == null) {
                if (accessibilityActionCompat.f2879a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(accessibilityActionCompat.f2879a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f2879a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String j2 = AccessibilityNodeInfoCompat.j(this.f2880b);
            if (j2.equals("ACTION_UNKNOWN") && c() != null) {
                j2 = c().toString();
            }
            sb.append(j2);
            return sb.toString();
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        private AccessibilityActionCompat(int i2, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, cls);
        }

        AccessibilityActionCompat(Object obj, int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.f2880b = i2;
            this.f2882d = accessibilityViewCommand;
            if (obj == null) {
                this.f2879a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f2879a = obj;
            }
            this.f2881c = cls;
        }
    }

    private static class Api19Impl {
        private Api19Impl() {
        }

        public static Bundle a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    public static class CollectionInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f2883a;

        CollectionInfoCompat(Object obj) {
            this.f2883a = obj;
        }

        public static CollectionInfoCompat a(int i2, int i3, boolean z2, int i4) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2, i4));
        }
    }

    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f2884a;

        CollectionItemInfoCompat(Object obj) {
            this.f2884a = obj;
        }

        public static CollectionItemInfoCompat f(int i2, int i3, int i4, int i5, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2));
        }

        public static CollectionItemInfoCompat g(int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2, z3));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2884a).getColumnIndex();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2884a).getColumnSpan();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2884a).getRowIndex();
        }

        public int d() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2884a).getRowSpan();
        }

        public boolean e() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2884a).isSelected();
        }
    }

    public static class RangeInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f2885a;

        RangeInfoCompat(Object obj) {
            this.f2885a = obj;
        }

        public static RangeInfoCompat a(int i2, float f2, float f3, float f4) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4));
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2854a = accessibilityNodeInfo;
    }

    private boolean A() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int B(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f2853d;
        f2853d = i3 + 1;
        return i3;
    }

    public static AccessibilityNodeInfoCompat J0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static AccessibilityNodeInfoCompat O() {
        return J0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat P(View view) {
        return J0(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat Q(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return J0(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f2854a));
    }

    private void U(View view) {
        SparseArray<WeakReference<ClickableSpan>> w2 = w(view);
        if (w2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < w2.size(); i2++) {
                if (w2.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                w2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void W(int i2, boolean z2) {
        Bundle s2 = s();
        if (s2 != null) {
            int i3 = s2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z2) {
                i2 = 0;
            }
            s2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void g() {
        Api19Impl.a(this.f2854a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        Api19Impl.a(this.f2854a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        Api19Impl.a(this.f2854a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        Api19Impl.a(this.f2854a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> h(String str) {
        ArrayList<Integer> integerArrayList = Api19Impl.a(this.f2854a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        Api19Impl.a(this.f2854a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String j(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case UserVerificationMethods.USER_VERIFY_HANDPRINT /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case Http2.INITIAL_MAX_FRAME_SIZE /*16384*/:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case ImageMetadata.LENS_APERTURE /*524288*/:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        SparseArray<WeakReference<ClickableSpan>> w2 = w(view);
        if (w2 != null) {
            return w2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R$id.I, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> w(View view) {
        return (SparseArray) view.getTag(R$id.I);
    }

    public void A0(boolean z2) {
        this.f2854a.setSelected(z2);
    }

    public void B0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2854a.setShowingHintText(z2);
        } else {
            W(4, z2);
        }
    }

    public boolean C() {
        return this.f2854a.isAccessibilityFocused();
    }

    public void C0(View view) {
        this.f2856c = -1;
        this.f2854a.setSource(view);
    }

    public boolean D() {
        return this.f2854a.isCheckable();
    }

    public void D0(View view, int i2) {
        this.f2856c = i2;
        this.f2854a.setSource(view, i2);
    }

    public boolean E() {
        return this.f2854a.isChecked();
    }

    public void E0(CharSequence charSequence) {
        if (BuildCompat.b()) {
            this.f2854a.setStateDescription(charSequence);
        } else {
            Api19Impl.a(this.f2854a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean F() {
        return this.f2854a.isClickable();
    }

    public void F0(CharSequence charSequence) {
        this.f2854a.setText(charSequence);
    }

    public boolean G() {
        return this.f2854a.isEnabled();
    }

    public void G0(String str) {
        this.f2854a.setViewIdResourceName(str);
    }

    public boolean H() {
        return this.f2854a.isFocusable();
    }

    public void H0(boolean z2) {
        this.f2854a.setVisibleToUser(z2);
    }

    public boolean I() {
        return this.f2854a.isFocused();
    }

    public AccessibilityNodeInfo I0() {
        return this.f2854a;
    }

    public boolean J() {
        return this.f2854a.isLongClickable();
    }

    public boolean K() {
        return this.f2854a.isPassword();
    }

    public boolean L() {
        return this.f2854a.isScrollable();
    }

    public boolean M() {
        return this.f2854a.isSelected();
    }

    public boolean N() {
        return this.f2854a.isVisibleToUser();
    }

    public boolean R(int i2, Bundle bundle) {
        return this.f2854a.performAction(i2, bundle);
    }

    @Deprecated
    public void S() {
    }

    public boolean T(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f2854a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f2879a);
    }

    public void V(boolean z2) {
        this.f2854a.setAccessibilityFocused(z2);
    }

    @Deprecated
    public void X(Rect rect) {
        this.f2854a.setBoundsInParent(rect);
    }

    public void Y(Rect rect) {
        this.f2854a.setBoundsInScreen(rect);
    }

    public void Z(boolean z2) {
        this.f2854a.setCanOpenPopup(z2);
    }

    public void a(int i2) {
        this.f2854a.addAction(i2);
    }

    public void a0(boolean z2) {
        this.f2854a.setCheckable(z2);
    }

    public void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f2854a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f2879a);
    }

    public void b0(boolean z2) {
        this.f2854a.setChecked(z2);
    }

    public void c(View view) {
        this.f2854a.addChild(view);
    }

    public void c0(CharSequence charSequence) {
        this.f2854a.setClassName(charSequence);
    }

    public void d(View view, int i2) {
        this.f2854a.addChild(view, i2);
    }

    public void d0(boolean z2) {
        this.f2854a.setClickable(z2);
    }

    public void e0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2854a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f2883a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2854a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f2854a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f2854a)) {
            return false;
        }
        if (this.f2856c == accessibilityNodeInfoCompat.f2856c && this.f2855b == accessibilityNodeInfoCompat.f2855b) {
            return true;
        }
        return false;
    }

    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            g();
            U(view);
            ClickableSpan[] p2 = p(charSequence);
            if (p2 != null && p2.length > 0) {
                s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.f2270a);
                SparseArray<WeakReference<ClickableSpan>> u2 = u(view);
                for (int i2 = 0; i2 < p2.length; i2++) {
                    int B = B(p2[i2], u2);
                    u2.put(B, new WeakReference(p2[i2]));
                    e(p2[i2], (Spanned) charSequence, B);
                }
            }
        }
    }

    public void f0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2854a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f2884a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void g0(CharSequence charSequence) {
        this.f2854a.setContentDescription(charSequence);
    }

    public void h0(boolean z2) {
        this.f2854a.setContentInvalid(z2);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2854a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<AccessibilityActionCompat> i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f2854a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i2)));
        }
        return arrayList;
    }

    public void i0(boolean z2) {
        this.f2854a.setDismissable(z2);
    }

    public void j0(boolean z2) {
        this.f2854a.setEnabled(z2);
    }

    @Deprecated
    public int k() {
        return this.f2854a.getActions();
    }

    public void k0(CharSequence charSequence) {
        this.f2854a.setError(charSequence);
    }

    @Deprecated
    public void l(Rect rect) {
        this.f2854a.getBoundsInParent(rect);
    }

    public void l0(boolean z2) {
        this.f2854a.setFocusable(z2);
    }

    public void m(Rect rect) {
        this.f2854a.getBoundsInScreen(rect);
    }

    public void m0(boolean z2) {
        this.f2854a.setFocused(z2);
    }

    public int n() {
        return this.f2854a.getChildCount();
    }

    public void n0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2854a.setHeading(z2);
        } else {
            W(2, z2);
        }
    }

    public CharSequence o() {
        return this.f2854a.getClassName();
    }

    public void o0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2854a.setHintText(charSequence);
        } else {
            Api19Impl.a(this.f2854a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void p0(View view) {
        this.f2854a.setLabeledBy(view);
    }

    public CollectionItemInfoCompat q() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.f2854a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public void q0(boolean z2) {
        this.f2854a.setLongClickable(z2);
    }

    public CharSequence r() {
        return this.f2854a.getContentDescription();
    }

    public void r0(int i2) {
        this.f2854a.setMovementGranularities(i2);
    }

    public Bundle s() {
        return Api19Impl.a(this.f2854a);
    }

    public void s0(CharSequence charSequence) {
        this.f2854a.setPackageName(charSequence);
    }

    public int t() {
        return this.f2854a.getMovementGranularities();
    }

    public void t0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2854a.setPaneTitle(charSequence);
        } else {
            Api19Impl.a(this.f2854a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(v());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(x());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(z());
        sb.append("; uniqueId: ");
        sb.append(y());
        sb.append("; checkable: ");
        sb.append(D());
        sb.append("; checked: ");
        sb.append(E());
        sb.append("; focusable: ");
        sb.append(H());
        sb.append("; focused: ");
        sb.append(I());
        sb.append("; selected: ");
        sb.append(M());
        sb.append("; clickable: ");
        sb.append(F());
        sb.append("; longClickable: ");
        sb.append(J());
        sb.append("; enabled: ");
        sb.append(G());
        sb.append("; password: ");
        sb.append(K());
        sb.append("; scrollable: " + L());
        sb.append("; [");
        List<AccessibilityActionCompat> i2 = i();
        for (int i3 = 0; i3 < i2.size(); i3++) {
            AccessibilityActionCompat accessibilityActionCompat = i2.get(i3);
            String j2 = j(accessibilityActionCompat.b());
            if (j2.equals("ACTION_UNKNOWN") && accessibilityActionCompat.c() != null) {
                j2 = accessibilityActionCompat.c().toString();
            }
            sb.append(j2);
            if (i3 != i2.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u0(View view) {
        this.f2855b = -1;
        this.f2854a.setParent(view);
    }

    public CharSequence v() {
        return this.f2854a.getPackageName();
    }

    public void v0(View view, int i2) {
        this.f2855b = i2;
        this.f2854a.setParent(view, i2);
    }

    public void w0(RangeInfoCompat rangeInfoCompat) {
        this.f2854a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f2885a);
    }

    public CharSequence x() {
        if (!A()) {
            return this.f2854a.getText();
        }
        List<Integer> h2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> h3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> h4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> h5 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2854a.getText(), 0, this.f2854a.getText().length()));
        for (int i2 = 0; i2 < h2.size(); i2++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(h5.get(i2).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), h2.get(i2).intValue(), h3.get(i2).intValue(), h4.get(i2).intValue());
        }
        return spannableString;
    }

    public void x0(CharSequence charSequence) {
        Api19Impl.a(this.f2854a).putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public String y() {
        if (BuildCompat.d()) {
            return this.f2854a.getUniqueId();
        }
        return Api19Impl.a(this.f2854a).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void y0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2854a.setScreenReaderFocusable(z2);
        } else {
            W(1, z2);
        }
    }

    public String z() {
        return this.f2854a.getViewIdResourceName();
    }

    public void z0(boolean z2) {
        this.f2854a.setScrollable(z2);
    }
}
