package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public BaseViewManagerDelegate(U u2) {
        this.mViewManager = u2;
    }

    public void receiveCommand(T t2, String str, ReadableArray readableArray) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1721943862: goto L_0x0165;
                case -1721943861: goto L_0x015a;
                case -1589741021: goto L_0x014f;
                case -1267206133: goto L_0x0144;
                case -1228066334: goto L_0x0139;
                case -908189618: goto L_0x012e;
                case -908189617: goto L_0x0123;
                case -877170387: goto L_0x0118;
                case -731417480: goto L_0x010a;
                case -101663499: goto L_0x00fc;
                case -101359900: goto L_0x00ee;
                case -80891667: goto L_0x00e0;
                case -40300674: goto L_0x00d2;
                case -4379043: goto L_0x00c4;
                case 36255470: goto L_0x00b6;
                case 333432965: goto L_0x00a8;
                case 581268560: goto L_0x009a;
                case 588239831: goto L_0x008c;
                case 746986311: goto L_0x007e;
                case 1052666732: goto L_0x0070;
                case 1146842694: goto L_0x0062;
                case 1153872867: goto L_0x0054;
                case 1287124693: goto L_0x0046;
                case 1349188574: goto L_0x0038;
                case 1505602511: goto L_0x002a;
                case 1865277756: goto L_0x001c;
                case 2045685618: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x016f
        L_0x000e:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0018
            goto L_0x016f
        L_0x0018:
            r2 = 26
            goto L_0x016f
        L_0x001c:
            java.lang.String r0 = "accessibilityLabelledBy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0026
            goto L_0x016f
        L_0x0026:
            r2 = 25
            goto L_0x016f
        L_0x002a:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x016f
        L_0x0034:
            r2 = 24
            goto L_0x016f
        L_0x0038:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x016f
        L_0x0042:
            r2 = 23
            goto L_0x016f
        L_0x0046:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x016f
        L_0x0050:
            r2 = 22
            goto L_0x016f
        L_0x0054:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x016f
        L_0x005e:
            r2 = 21
            goto L_0x016f
        L_0x0062:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x006c
            goto L_0x016f
        L_0x006c:
            r2 = 20
            goto L_0x016f
        L_0x0070:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x007a
            goto L_0x016f
        L_0x007a:
            r2 = 19
            goto L_0x016f
        L_0x007e:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0088
            goto L_0x016f
        L_0x0088:
            r2 = 18
            goto L_0x016f
        L_0x008c:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0096
            goto L_0x016f
        L_0x0096:
            r2 = 17
            goto L_0x016f
        L_0x009a:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a4
            goto L_0x016f
        L_0x00a4:
            r2 = 16
            goto L_0x016f
        L_0x00a8:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00b2
            goto L_0x016f
        L_0x00b2:
            r2 = 15
            goto L_0x016f
        L_0x00b6:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00c0
            goto L_0x016f
        L_0x00c0:
            r2 = 14
            goto L_0x016f
        L_0x00c4:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ce
            goto L_0x016f
        L_0x00ce:
            r2 = 13
            goto L_0x016f
        L_0x00d2:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00dc
            goto L_0x016f
        L_0x00dc:
            r2 = 12
            goto L_0x016f
        L_0x00e0:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ea
            goto L_0x016f
        L_0x00ea:
            r2 = 11
            goto L_0x016f
        L_0x00ee:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00f8
            goto L_0x016f
        L_0x00f8:
            r2 = 10
            goto L_0x016f
        L_0x00fc:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0106
            goto L_0x016f
        L_0x0106:
            r2 = 9
            goto L_0x016f
        L_0x010a:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0114
            goto L_0x016f
        L_0x0114:
            r2 = 8
            goto L_0x016f
        L_0x0118:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0121
            goto L_0x016f
        L_0x0121:
            r2 = 7
            goto L_0x016f
        L_0x0123:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x012c
            goto L_0x016f
        L_0x012c:
            r2 = 6
            goto L_0x016f
        L_0x012e:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0137
            goto L_0x016f
        L_0x0137:
            r2 = 5
            goto L_0x016f
        L_0x0139:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0142
            goto L_0x016f
        L_0x0142:
            r2 = 4
            goto L_0x016f
        L_0x0144:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x014d
            goto L_0x016f
        L_0x014d:
            r2 = 3
            goto L_0x016f
        L_0x014f:
            java.lang.String r0 = "shadowColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0158
            goto L_0x016f
        L_0x0158:
            r2 = 2
            goto L_0x016f
        L_0x015a:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0163
            goto L_0x016f
        L_0x0163:
            r2 = 1
            goto L_0x016f
        L_0x0165:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r2 = 0
        L_0x016f:
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r2) {
                case 0: goto L_0x02d2;
                case 1: goto L_0x02c3;
                case 2: goto L_0x02ae;
                case 3: goto L_0x029f;
                case 4: goto L_0x0290;
                case 5: goto L_0x0281;
                case 6: goto L_0x0272;
                case 7: goto L_0x0269;
                case 8: goto L_0x0259;
                case 9: goto L_0x0250;
                case 10: goto L_0x0247;
                case 11: goto L_0x0237;
                case 12: goto L_0x0227;
                case 13: goto L_0x0217;
                case 14: goto L_0x020e;
                case 15: goto L_0x01fe;
                case 16: goto L_0x01ee;
                case 17: goto L_0x01de;
                case 18: goto L_0x01d5;
                case 19: goto L_0x01cc;
                case 20: goto L_0x01c3;
                case 21: goto L_0x01ba;
                case 22: goto L_0x01a4;
                case 23: goto L_0x0194;
                case 24: goto L_0x018b;
                case 25: goto L_0x0182;
                case 26: goto L_0x0179;
                default: goto L_0x0177;
            }
        L_0x0177:
            goto L_0x02e0
        L_0x0179:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x02e0
        L_0x0182:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.Dynamic r7 = (com.facebook.react.bridge.Dynamic) r7
            r6.setAccessibilityLabelledBy(r5, r7)
            goto L_0x02e0
        L_0x018b:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
            goto L_0x02e0
        L_0x0194:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0199
            goto L_0x019f
        L_0x0199:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x019f:
            r6.setBorderRadius(r5, r3)
            goto L_0x02e0
        L_0x01a4:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01a9
            goto L_0x01b5
        L_0x01a9:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x01b5:
            r6.setBackgroundColor(r5, r1)
            goto L_0x02e0
        L_0x01ba:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x02e0
        L_0x01c3:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x02e0
        L_0x01cc:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x02e0
        L_0x01d5:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x02e0
        L_0x01de:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01e3
            goto L_0x01e9
        L_0x01e3:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01e9:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x02e0
        L_0x01ee:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01f3
            goto L_0x01f9
        L_0x01f3:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01f9:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x02e0
        L_0x01fe:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0203
            goto L_0x0209
        L_0x0203:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0209:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x02e0
        L_0x020e:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x02e0
        L_0x0217:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0222:
            r6.setElevation(r5, r0)
            goto L_0x02e0
        L_0x0227:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x022c
            goto L_0x0232
        L_0x022c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0232:
            r6.setRotation(r5, r0)
            goto L_0x02e0
        L_0x0237:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x023c
            goto L_0x0242
        L_0x023c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0242:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x02e0
        L_0x0247:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x02e0
        L_0x0250:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x02e0
        L_0x0259:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x025e
            goto L_0x0264
        L_0x025e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0264:
            r6.setZIndex(r5, r0)
            goto L_0x02e0
        L_0x0269:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x02e0
        L_0x0272:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0277
            goto L_0x027d
        L_0x0277:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x027d:
            r0.setScaleY(r5, r6)
            goto L_0x02e0
        L_0x0281:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0286
            goto L_0x028c
        L_0x0286:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x028c:
            r0.setScaleX(r5, r6)
            goto L_0x02e0
        L_0x0290:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0295
            goto L_0x029b
        L_0x0295:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x029b:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x02e0
        L_0x029f:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02a4
            goto L_0x02aa
        L_0x02a4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02aa:
            r0.setOpacity(r5, r6)
            goto L_0x02e0
        L_0x02ae:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02b3
            goto L_0x02bf
        L_0x02b3:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x02bf:
            r6.setShadowColor(r5, r1)
            goto L_0x02e0
        L_0x02c3:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02c8
            goto L_0x02ce
        L_0x02c8:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02ce:
            r6.setTranslateY(r5, r0)
            goto L_0x02e0
        L_0x02d2:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02d7
            goto L_0x02dd
        L_0x02d7:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02dd:
            r6.setTranslateX(r5, r0)
        L_0x02e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
