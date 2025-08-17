package com.startapp;

import android.content.Context;

public class gd extends dd<fd> {
    public gd(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f34373a
            java.lang.String r1 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r1)
            boolean r1 = r0 instanceof android.view.inputmethod.InputMethodManager
            r2 = 0
            if (r1 != 0) goto L_0x000f
            goto L_0x009e
        L_0x000f:
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            android.view.inputmethod.InputMethodSubtype r1 = r0.getCurrentInputMethodSubtype()
            r3 = 10
            java.lang.String r4 = "keyboard"
            if (r1 == 0) goto L_0x003e
            java.lang.String r5 = r1.getMode()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x003e
            java.lang.String r1 = r1.getLocale()
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x003e
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
            int r6 = r5.size()
            if (r6 >= r3) goto L_0x003f
            r5.add(r1)
            goto L_0x003f
        L_0x003e:
            r5 = r2
        L_0x003f:
            java.util.List r1 = r0.getInputMethodList()
            if (r1 == 0) goto L_0x0097
            java.util.Iterator r1 = r1.iterator()
        L_0x0049:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0097
            java.lang.Object r6 = r1.next()
            android.view.inputmethod.InputMethodInfo r6 = (android.view.inputmethod.InputMethodInfo) r6
            if (r6 != 0) goto L_0x0058
            goto L_0x0049
        L_0x0058:
            r7 = 1
            java.util.List r6 = r0.getEnabledInputMethodSubtypeList(r6, r7)
            if (r6 != 0) goto L_0x0060
            goto L_0x0049
        L_0x0060:
            java.util.Iterator r6 = r6.iterator()
        L_0x0064:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0049
            java.lang.Object r7 = r6.next()
            android.view.inputmethod.InputMethodSubtype r7 = (android.view.inputmethod.InputMethodSubtype) r7
            if (r7 == 0) goto L_0x0064
            java.lang.String r8 = r7.getMode()
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L_0x0064
            java.lang.String r7 = r7.getLocale()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x0064
            if (r5 != 0) goto L_0x008d
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
        L_0x008d:
            int r8 = r5.size()
            if (r8 >= r3) goto L_0x0064
            r5.add(r7)
            goto L_0x0064
        L_0x0097:
            if (r5 == 0) goto L_0x009e
            com.startapp.fd r2 = new com.startapp.fd
            r2.<init>(r5)
        L_0x009e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.gd.a():java.lang.Object");
    }

    public /* bridge */ /* synthetic */ Object c() {
        return fd.f34536a;
    }
}
