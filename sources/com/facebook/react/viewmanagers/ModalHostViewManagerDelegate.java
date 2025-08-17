package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u2) {
        super(u2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1851617609: goto L_0x0069;
                case -1850124175: goto L_0x005e;
                case -1726194350: goto L_0x0053;
                case -1618432855: goto L_0x0048;
                case -1156137512: goto L_0x003d;
                case -795203165: goto L_0x0032;
                case 466743410: goto L_0x0027;
                case 1195991583: goto L_0x001c;
                case 2031205598: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0073
        L_0x000e:
            java.lang.String r0 = "animationType"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x0073
        L_0x0018:
            r2 = 8
            goto L_0x0073
        L_0x001c:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0025
            goto L_0x0073
        L_0x0025:
            r2 = 7
            goto L_0x0073
        L_0x0027:
            java.lang.String r0 = "visible"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0030
            goto L_0x0073
        L_0x0030:
            r2 = 6
            goto L_0x0073
        L_0x0032:
            java.lang.String r0 = "animated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x003b
            goto L_0x0073
        L_0x003b:
            r2 = 5
            goto L_0x0073
        L_0x003d:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0046
            goto L_0x0073
        L_0x0046:
            r2 = 4
            goto L_0x0073
        L_0x0048:
            java.lang.String r0 = "identifier"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0073
        L_0x0051:
            r2 = 3
            goto L_0x0073
        L_0x0053:
            java.lang.String r0 = "transparent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            r2 = 2
            goto L_0x0073
        L_0x005e:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x0073
        L_0x0067:
            r2 = 1
            goto L_0x0073
        L_0x0069:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            switch(r2) {
                case 0: goto L_0x00f7;
                case 1: goto L_0x00ed;
                case 2: goto L_0x00dc;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00a9;
                case 6: goto L_0x0098;
                case 7: goto L_0x0086;
                case 8: goto L_0x007b;
                default: goto L_0x0076;
            }
        L_0x0076:
            super.setProperty(r4, r5, r6)
            goto L_0x0100
        L_0x007b:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setAnimationType(r4, r6)
            goto L_0x0100
        L_0x0086:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x008d
            goto L_0x0093
        L_0x008d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0093:
            r5.setHardwareAccelerated(r4, r1)
            goto L_0x0100
        L_0x0098:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x009f
            goto L_0x00a5
        L_0x009f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00a5:
            r5.setVisible(r4, r1)
            goto L_0x0100
        L_0x00a9:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00b0
            goto L_0x00b6
        L_0x00b0:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00b6:
            r5.setAnimated(r4, r1)
            goto L_0x0100
        L_0x00ba:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00c1
            goto L_0x00c7
        L_0x00c1:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00c7:
            r5.setStatusBarTranslucent(r4, r1)
            goto L_0x0100
        L_0x00cb:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00d2
            goto L_0x00d8
        L_0x00d2:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00d8:
            r5.setIdentifier(r4, r1)
            goto L_0x0100
        L_0x00dc:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00e3
            goto L_0x00e9
        L_0x00e3:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00e9:
            r5.setTransparent(r4, r1)
            goto L_0x0100
        L_0x00ed:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setSupportedOrientations(r4, r6)
            goto L_0x0100
        L_0x00f7:
            U r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setPresentationStyle(r4, r6)
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
