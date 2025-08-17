package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

public class ReactScrollViewCommandHelper {
    public static final int COMMAND_FLASH_SCROLL_INDICATORS = 3;
    public static final int COMMAND_SCROLL_TO = 1;
    public static final int COMMAND_SCROLL_TO_END = 2;

    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(T t2);

        void scrollTo(T t2, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(T t2, ScrollToEndCommandData scrollToEndCommandData);
    }

    public static class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        ScrollToCommandData(int i2, int i3, boolean z2) {
            this.mDestX = i2;
            this.mDestY = i3;
            this.mAnimated = z2;
        }
    }

    public static class ScrollToEndCommandData {
        public final boolean mAnimated;

        ScrollToEndCommandData(boolean z2) {
            this.mAnimated = z2;
        }
    }

    public static Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static <T> void receiveCommand(ScrollCommandHandler<T> scrollCommandHandler, T t2, int i2, ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(t2);
        Assertions.assertNotNull(readableArray);
        if (i2 == 1) {
            scrollTo(scrollCommandHandler, t2, readableArray);
        } else if (i2 == 2) {
            scrollToEnd(scrollCommandHandler, t2, readableArray);
        } else if (i2 == 3) {
            scrollCommandHandler.flashScrollIndicators(t2);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i2), scrollCommandHandler.getClass().getSimpleName()}));
        }
    }

    private static <T> void scrollTo(ScrollCommandHandler<T> scrollCommandHandler, T t2, ReadableArray readableArray) {
        scrollCommandHandler.scrollTo(t2, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static <T> void scrollToEnd(ScrollCommandHandler<T> scrollCommandHandler, T t2, ReadableArray readableArray) {
        scrollCommandHandler.scrollToEnd(t2, new ScrollToEndCommandData(readableArray.getBoolean(0)));
    }

    public static <T> void receiveCommand(ScrollCommandHandler<T> scrollCommandHandler, T t2, String str, ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(t2);
        Assertions.assertNotNull(readableArray);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -402165208:
                if (str.equals("scrollTo")) {
                    c2 = 0;
                    break;
                }
                break;
            case 28425985:
                if (str.equals("flashScrollIndicators")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2055114131:
                if (str.equals("scrollToEnd")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                scrollTo(scrollCommandHandler, t2, readableArray);
                return;
            case 1:
                scrollCommandHandler.flashScrollIndicators(t2);
                return;
            case 2:
                scrollToEnd(scrollCommandHandler, t2, readableArray);
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", new Object[]{str, scrollCommandHandler.getClass().getSimpleName()}));
        }
    }
}
