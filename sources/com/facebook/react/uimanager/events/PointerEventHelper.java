package com.facebook.react.uimanager.events;

public class PointerEventHelper {
    public static final String POINTER_CANCEL = "topPointerCancel";
    public static final String POINTER_DOWN = "topPointerDown";
    public static final String POINTER_ENTER = "topPointerEnter2";
    public static final String POINTER_LEAVE = "topPointerLeave2";
    public static final String POINTER_MOVE = "topPointerMove2";
    public static final String POINTER_TYPE_MOUSE = "mouse";
    public static final String POINTER_TYPE_PEN = "pen";
    public static final String POINTER_TYPE_TOUCH = "touch";
    public static final String POINTER_TYPE_UNKNOWN = "";
    public static final String POINTER_UP = "topPointerUp";

    public static int getEventCategory(String str) {
        if (str == null) {
            return 2;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1779094471:
                if (str.equals(POINTER_MOVE)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1304584214:
                if (str.equals(POINTER_DOWN)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1065042973:
                if (str.equals(POINTER_UP)) {
                    c2 = 2;
                    break;
                }
                break;
            case 383186882:
                if (str.equals(POINTER_CANCEL)) {
                    c2 = 3;
                    break;
                }
                break;
            case 452631970:
                if (str.equals(POINTER_ENTER)) {
                    c2 = 4;
                    break;
                }
                break;
            case 644174243:
                if (str.equals(POINTER_LEAVE)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 4:
            case 5:
                return 4;
            case 1:
            case 2:
            case 3:
                return 3;
            default:
                return 2;
        }
    }

    public static String getW3CPointerType(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : POINTER_TYPE_MOUSE : POINTER_TYPE_PEN : POINTER_TYPE_TOUCH;
    }

    public static boolean supportsHover(int i2) {
        String w3CPointerType = getW3CPointerType(i2);
        if (!w3CPointerType.equals(POINTER_TYPE_MOUSE) && !w3CPointerType.equals(POINTER_TYPE_PEN)) {
            return false;
        }
        return true;
    }
}
