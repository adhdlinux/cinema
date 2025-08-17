package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.applovin.sdk.AppLovinMediationProvider;
import com.facebook.react.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReactAccessibilityDelegate extends ExploreByTouchHelper {
    private static final int SEND_EVENT = 1;
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_DISABLED = "disabled";
    private static final String STATE_SELECTED = "selected";
    private static final String TAG = "ReactAccessibilityDelegate";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final String TOP_ACCESSIBILITY_ACTION_EVENT = "topAccessibilityAction";
    public static final HashMap<String, Integer> sActionIdMap;
    private static int sCounter = 1056964608;
    private final HashMap<Integer, String> mAccessibilityActionsMap = new HashMap<>();
    View mAccessibilityLabelledBy;
    private final AccessibilityLinks mAccessibilityLinks;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            ((View) message.obj).sendAccessibilityEvent(4);
        }
    };
    private final View mView;

    /* renamed from: com.facebook.react.uimanager.ReactAccessibilityDelegate$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole;

        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole[] r0 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole = r0
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.BUTTON     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TOGGLEBUTTON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.SEARCH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.IMAGE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.IMAGEBUTTON     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.KEYBOARDKEY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TEXT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.ADJUSTABLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x006c }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.CHECKBOX     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.RADIO     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.SPINBUTTON     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.SWITCH     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.LIST     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.NONE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.LINK     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.SUMMARY     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.HEADER     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.ALERT     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.COMBOBOX     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.MENU     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.MENUBAR     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.MENUITEM     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.PROGRESSBAR     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.RADIOGROUP     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x012c }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.SCROLLBAR     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TAB     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TABLIST     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TIMER     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole     // Catch:{ NoSuchFieldError -> 0x015c }
                com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityRole r1 = com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole.TOOLBAR     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactAccessibilityDelegate.AnonymousClass3.<clinit>():void");
        }
    }

    public static class AccessibilityLinks {
        private final List<AccessibleLink> mLinks;

        private static class AccessibleLink {
            public String description;
            public int end;
            public int id;
            public int start;

            private AccessibleLink() {
            }
        }

        public AccessibilityLinks(ClickableSpan[] clickableSpanArr, Spannable spannable) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < clickableSpanArr.length; i2++) {
                ClickableSpan clickableSpan = clickableSpanArr[i2];
                int spanStart = spannable.getSpanStart(clickableSpan);
                int spanEnd = spannable.getSpanEnd(clickableSpan);
                if (spanStart != spanEnd && spanStart >= 0 && spanEnd >= 0 && spanStart <= spannable.length() && spanEnd <= spannable.length()) {
                    AccessibleLink accessibleLink = new AccessibleLink();
                    accessibleLink.description = spannable.subSequence(spanStart, spanEnd).toString();
                    accessibleLink.start = spanStart;
                    accessibleLink.end = spanEnd;
                    accessibleLink.id = (clickableSpanArr.length - 1) - i2;
                    arrayList.add(accessibleLink);
                }
            }
            this.mLinks = arrayList;
        }

        public AccessibleLink getLinkById(int i2) {
            for (AccessibleLink next : this.mLinks) {
                if (next.id == i2) {
                    return next;
                }
            }
            return null;
        }

        public AccessibleLink getLinkBySpanPos(int i2, int i3) {
            for (AccessibleLink next : this.mLinks) {
                if (next.start == i2 && next.end == i3) {
                    return next;
                }
            }
            return null;
        }

        public int size() {
            return this.mLinks.size();
        }
    }

    public enum AccessibilityRole {
        NONE,
        BUTTON,
        TOGGLEBUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        LIST,
        TOOLBAR;

        public static AccessibilityRole fromValue(String str) {
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    return accessibilityRole;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: " + str);
        }

        public static String getValue(AccessibilityRole accessibilityRole) {
            switch (AnonymousClass3.$SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[accessibilityRole.ordinal()]) {
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.ToggleButton";
                case 3:
                    return "android.widget.EditText";
                case 4:
                    return "android.widget.ImageView";
                case 5:
                    return "android.widget.ImageButon";
                case 6:
                    return "android.inputmethodservice.Keyboard$Key";
                case 7:
                    return "android.widget.TextView";
                case 8:
                    return "android.widget.SeekBar";
                case 9:
                    return "android.widget.CheckBox";
                case 10:
                    return "android.widget.RadioButton";
                case 11:
                    return "android.widget.SpinButton";
                case 12:
                    return "android.widget.Switch";
                case 13:
                    return "android.widget.AbsListView";
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    return "android.view.View";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + accessibilityRole);
            }
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        sActionIdMap = hashMap;
        hashMap.put("activate", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2861i.b()));
        hashMap.put("longpress", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2862j.b()));
        hashMap.put("increment", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2869q.b()));
        hashMap.put("decrement", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2870r.b()));
    }

    public ReactAccessibilityDelegate(View view, boolean z2, int i2) {
        super(view);
        this.mView = view;
        view.setFocusable(z2);
        ViewCompat.C0(view, i2);
        this.mAccessibilityLinks = (AccessibilityLinks) view.getTag(R.id.accessibility_links);
    }

    private Rect getBoundsInParent(AccessibilityLinks.AccessibleLink accessibleLink) {
        float f2;
        View view = this.mView;
        boolean z2 = false;
        if (!(view instanceof TextView)) {
            return new Rect(0, 0, this.mView.getWidth(), this.mView.getHeight());
        }
        TextView textView = (TextView) view;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return new Rect(0, 0, textView.getWidth(), textView.getHeight());
        }
        Rect rect = new Rect();
        double d2 = (double) accessibleLink.end;
        int i2 = (int) ((double) accessibleLink.start);
        double primaryHorizontal = (double) layout.getPrimaryHorizontal(i2);
        Paint paint = new Paint();
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) getFirstSpan(accessibleLink.start, accessibleLink.end, AbsoluteSizeSpan.class);
        if (absoluteSizeSpan != null) {
            f2 = (float) absoluteSizeSpan.getSize();
        } else {
            f2 = textView.getTextSize();
        }
        paint.setTextSize(f2);
        int ceil = (int) Math.ceil((double) paint.measureText(accessibleLink.description));
        int lineForOffset = layout.getLineForOffset(i2);
        if (lineForOffset != layout.getLineForOffset((int) d2)) {
            z2 = true;
        }
        layout.getLineBounds(lineForOffset, rect);
        int scrollY = textView.getScrollY() + textView.getTotalPaddingTop();
        rect.top += scrollY;
        rect.bottom += scrollY;
        rect.left = (int) (((double) rect.left) + ((primaryHorizontal + ((double) textView.getTotalPaddingLeft())) - ((double) textView.getScrollX())));
        if (z2) {
            return new Rect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int i3 = rect.left;
        return new Rect(i3, rect.top, ceil + i3, rect.bottom);
    }

    public static void resetDelegate(View view, boolean z2, int i2) {
        ViewCompat.r0(view, new ReactAccessibilityDelegate(view, z2, i2));
    }

    private void scheduleAccessibilityEventSender(View view) {
        if (this.mHandler.hasMessages(1, view)) {
            this.mHandler.removeMessages(1, view);
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, view), 200);
    }

    public static void setDelegate(View view, boolean z2, int i2) {
        if (ViewCompat.P(view)) {
            return;
        }
        if (view.getTag(R.id.accessibility_role) != null || view.getTag(R.id.accessibility_state) != null || view.getTag(R.id.accessibility_actions) != null || view.getTag(R.id.react_test_id) != null || view.getTag(R.id.accessibility_links) != null) {
            ViewCompat.r0(view, new ReactAccessibilityDelegate(view, z2, i2));
        }
    }

    public static void setRole(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityRole accessibilityRole, Context context) {
        if (accessibilityRole == null) {
            accessibilityRole = AccessibilityRole.NONE;
        }
        accessibilityNodeInfoCompat.c0(AccessibilityRole.getValue(accessibilityRole));
        if (accessibilityRole.equals(AccessibilityRole.LINK)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.link_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGE)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.image_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.imagebutton_description));
            accessibilityNodeInfoCompat.d0(true);
        } else if (accessibilityRole.equals(AccessibilityRole.BUTTON)) {
            accessibilityNodeInfoCompat.d0(true);
        } else if (accessibilityRole.equals(AccessibilityRole.TOGGLEBUTTON)) {
            accessibilityNodeInfoCompat.d0(true);
            accessibilityNodeInfoCompat.a0(true);
        } else if (accessibilityRole.equals(AccessibilityRole.SUMMARY)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.summary_description));
        } else if (accessibilityRole.equals(AccessibilityRole.HEADER)) {
            accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.f(0, 1, 0, 1, true));
        } else if (accessibilityRole.equals(AccessibilityRole.ALERT)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.alert_description));
        } else if (accessibilityRole.equals(AccessibilityRole.COMBOBOX)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.combobox_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENU)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.menu_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUBAR)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.menubar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUITEM)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.menuitem_description));
        } else if (accessibilityRole.equals(AccessibilityRole.PROGRESSBAR)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.progressbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.RADIOGROUP)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.radiogroup_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SCROLLBAR)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.scrollbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SPINBUTTON)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.spinbutton_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TAB)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.rn_tab_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TABLIST)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.tablist_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TIMER)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.timer_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TOOLBAR)) {
            accessibilityNodeInfoCompat.x0(context.getString(R.string.toolbar_description));
        }
    }

    private static void setState(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ReadableMap readableMap, Context context) {
        int i2;
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Dynamic dynamic = readableMap.getDynamic(nextKey);
            if (nextKey.equals(STATE_SELECTED) && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.A0(dynamic.asBoolean());
            } else if (nextKey.equals(STATE_DISABLED) && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.j0(!dynamic.asBoolean());
            } else if (nextKey.equals(STATE_CHECKED) && dynamic.getType() == ReadableType.Boolean) {
                boolean asBoolean = dynamic.asBoolean();
                accessibilityNodeInfoCompat.a0(true);
                accessibilityNodeInfoCompat.b0(asBoolean);
                if (accessibilityNodeInfoCompat.o().equals(AccessibilityRole.getValue(AccessibilityRole.SWITCH))) {
                    if (asBoolean) {
                        i2 = R.string.state_on_description;
                    } else {
                        i2 = R.string.state_off_description;
                    }
                    accessibilityNodeInfoCompat.F0(context.getString(i2));
                }
            }
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mAccessibilityLinks != null) {
            return super.getAccessibilityNodeProvider(view);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public <T> T getFirstSpan(int i2, int i3, Class<T> cls) {
        View view = this.mView;
        if (!(view instanceof TextView) || !(((TextView) view).getText() instanceof Spanned)) {
            return null;
        }
        T[] spans = ((Spanned) ((TextView) this.mView).getText()).getSpans(i2, i3, cls);
        if (spans.length > 0) {
            return spans[0];
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r6 = (android.text.Spanned) r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getVirtualViewAt(float r5, float r6) {
        /*
            r4 = this;
            com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityLinks r0 = r4.mAccessibilityLinks
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x0069
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0069
            android.view.View r0 = r4.mView
            boolean r2 = r0 instanceof android.widget.TextView
            if (r2 != 0) goto L_0x0013
            goto L_0x0069
        L_0x0013:
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r2 = r0.getText()
            boolean r2 = r2 instanceof android.text.Spanned
            if (r2 != 0) goto L_0x001e
            return r1
        L_0x001e:
            android.text.Layout r2 = r0.getLayout()
            if (r2 != 0) goto L_0x0025
            return r1
        L_0x0025:
            int r3 = r0.getTotalPaddingLeft()
            float r3 = (float) r3
            float r5 = r5 - r3
            int r3 = r0.getTotalPaddingTop()
            float r3 = (float) r3
            float r6 = r6 - r3
            int r3 = r0.getScrollX()
            float r3 = (float) r3
            float r5 = r5 + r3
            int r3 = r0.getScrollY()
            float r3 = (float) r3
            float r6 = r6 + r3
            int r6 = (int) r6
            int r6 = r2.getLineForVertical(r6)
            int r5 = r2.getOffsetForHorizontal(r6, r5)
            java.lang.Class<android.text.style.ClickableSpan> r6 = android.text.style.ClickableSpan.class
            java.lang.Object r5 = r4.getFirstSpan(r5, r5, r6)
            android.text.style.ClickableSpan r5 = (android.text.style.ClickableSpan) r5
            if (r5 != 0) goto L_0x0051
            return r1
        L_0x0051:
            java.lang.CharSequence r6 = r0.getText()
            android.text.Spanned r6 = (android.text.Spanned) r6
            int r0 = r6.getSpanStart(r5)
            int r5 = r6.getSpanEnd(r5)
            com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityLinks r6 = r4.mAccessibilityLinks
            com.facebook.react.uimanager.ReactAccessibilityDelegate$AccessibilityLinks$AccessibleLink r5 = r6.getLinkBySpanPos(r0, r5)
            if (r5 == 0) goto L_0x0069
            int r1 = r5.id
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactAccessibilityDelegate.getVirtualViewAt(float, float):int");
    }

    /* access modifiers changed from: protected */
    public void getVisibleVirtualViews(List<Integer> list) {
        if (this.mAccessibilityLinks != null) {
            for (int i2 = 0; i2 < this.mAccessibilityLinks.size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ReadableType readableType;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap != null && readableMap.hasKey("min") && readableMap.hasKey("now") && readableMap.hasKey(AppLovinMediationProvider.MAX)) {
            Dynamic dynamic = readableMap.getDynamic("min");
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic(AppLovinMediationProvider.MAX);
            if (dynamic != null && dynamic.getType() == (readableType = ReadableType.Number) && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                int asInt = dynamic.asInt();
                int asInt2 = dynamic2.asInt();
                int asInt3 = dynamic3.asInt();
                if (asInt3 > asInt && asInt2 >= asInt && asInt3 >= asInt2) {
                    accessibilityEvent.setItemCount(asInt3 - asInt);
                    accessibilityEvent.setCurrentItemIndex(asInt2);
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ReadableType readableType;
        String str;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
        if (accessibilityRole != null) {
            setRole(accessibilityNodeInfoCompat, accessibilityRole, view.getContext());
        }
        Object tag = view.getTag(R.id.labelled_by);
        if (tag != null) {
            View findView = ReactFindViewUtil.findView(view.getRootView(), (String) tag);
            this.mAccessibilityLabelledBy = findView;
            if (findView != null) {
                accessibilityNodeInfoCompat.p0(findView);
            }
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_state);
        if (readableMap != null) {
            setState(accessibilityNodeInfoCompat, readableMap, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.accessibility_actions);
        if (readableArray != null) {
            int i2 = 0;
            while (i2 < readableArray.size()) {
                ReadableMap map = readableArray.getMap(i2);
                if (map.hasKey("name")) {
                    int i3 = sCounter;
                    if (map.hasKey("label")) {
                        str = map.getString("label");
                    } else {
                        str = null;
                    }
                    HashMap<String, Integer> hashMap = sActionIdMap;
                    if (hashMap.containsKey(map.getString("name"))) {
                        i3 = hashMap.get(map.getString("name")).intValue();
                    } else {
                        sCounter++;
                    }
                    this.mAccessibilityActionsMap.put(Integer.valueOf(i3), map.getString("name"));
                    accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, str));
                    i2++;
                } else {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
            }
        }
        ReadableMap readableMap2 = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap2 != null && readableMap2.hasKey("min") && readableMap2.hasKey("now") && readableMap2.hasKey(AppLovinMediationProvider.MAX)) {
            Dynamic dynamic = readableMap2.getDynamic("min");
            Dynamic dynamic2 = readableMap2.getDynamic("now");
            Dynamic dynamic3 = readableMap2.getDynamic(AppLovinMediationProvider.MAX);
            if (dynamic != null && dynamic.getType() == (readableType = ReadableType.Number) && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                int asInt = dynamic.asInt();
                int asInt2 = dynamic2.asInt();
                int asInt3 = dynamic3.asInt();
                if (asInt3 > asInt && asInt2 >= asInt && asInt3 >= asInt2) {
                    accessibilityNodeInfoCompat.w0(AccessibilityNodeInfoCompat.RangeInfoCompat.a(0, (float) asInt, (float) asInt3, (float) asInt2));
                }
            }
        }
        String str2 = (String) view.getTag(R.id.react_test_id);
        if (str2 != null) {
            accessibilityNodeInfoCompat.G0(str2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityLinks accessibilityLinks = this.mAccessibilityLinks;
        if (accessibilityLinks == null) {
            accessibilityNodeInfoCompat.g0("");
            accessibilityNodeInfoCompat.X(new Rect(0, 0, 1, 1));
            return;
        }
        AccessibilityLinks.AccessibleLink linkById = accessibilityLinks.getLinkById(i2);
        if (linkById == null) {
            accessibilityNodeInfoCompat.g0("");
            accessibilityNodeInfoCompat.X(new Rect(0, 0, 1, 1));
            return;
        }
        accessibilityNodeInfoCompat.g0(linkById.description);
        accessibilityNodeInfoCompat.a(16);
        accessibilityNodeInfoCompat.X(getBoundsInParent(linkById));
        accessibilityNodeInfoCompat.x0(this.mView.getResources().getString(R.string.link_description));
        accessibilityNodeInfoCompat.c0(AccessibilityRole.getValue(AccessibilityRole.BUTTON));
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (!this.mAccessibilityActionsMap.containsKey(Integer.valueOf(i2))) {
            return super.performAccessibilityAction(view, i2, bundle);
        }
        final WritableMap createMap = Arguments.createMap();
        createMap.putString("actionName", this.mAccessibilityActionsMap.get(Integer.valueOf(i2)));
        ReactContext reactContext = (ReactContext) view.getContext();
        if (reactContext.hasActiveReactInstance()) {
            int id = view.getId();
            int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
            UIManager uIManager = UIManagerHelper.getUIManager(reactContext, id);
            if (uIManager != null) {
                ((EventDispatcher) uIManager.getEventDispatcher()).dispatchEvent(new Event(surfaceId, id) {
                    /* access modifiers changed from: protected */
                    public WritableMap getEventData() {
                        return createMap;
                    }

                    public String getEventName() {
                        return ReactAccessibilityDelegate.TOP_ACCESSIBILITY_ACTION_EVENT;
                    }
                });
            }
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
        }
        AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (accessibilityRole != AccessibilityRole.ADJUSTABLE) {
            return true;
        }
        if (i2 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2869q.b() && i2 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2870r.b()) {
            return true;
        }
        if (readableMap != null && !readableMap.hasKey("text")) {
            scheduleAccessibilityEventSender(view);
        }
        return super.performAccessibilityAction(view, i2, bundle);
    }
}
