package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2886a;

    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityNodeProviderCompat f2887a;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f2887a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            AccessibilityNodeInfoCompat b2 = this.f2887a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.I0();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<AccessibilityNodeInfoCompat> c2 = this.f2887a.c(str, i2);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(c2.get(i3).I0());
            }
            return arrayList;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f2887a.f(i2, i3, bundle);
        }
    }

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            AccessibilityNodeInfoCompat d2 = this.f2887a.d(i2);
            if (d2 == null) {
                return null;
            }
            return d2.I0();
        }
    }

    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f2887a.a(i2, AccessibilityNodeInfoCompat.J0(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2886a = new AccessibilityNodeProviderApi26(this);
        } else {
            this.f2886a = new AccessibilityNodeProviderApi19(this);
        }
    }

    public void a(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat b(int i2) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> c(String str, int i2) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int i2) {
        return null;
    }

    public Object e() {
        return this.f2886a;
    }

    public boolean f(int i2, int i3, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f2886a = obj;
    }
}
