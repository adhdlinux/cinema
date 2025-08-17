package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TextLayoutManager {
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING = false;
    private static final String HYPHENATION_FREQUENCY_KEY = "android_hyphenationFrequency";
    private static final String INCLUDE_FONT_PADDING_KEY = "includeFontPadding";
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    private static final String MAXIMUM_NUMBER_OF_LINES_KEY = "maximumNumberOfLines";
    private static final String TAG = "TextLayoutManager";
    private static final String TEXT_BREAK_STRATEGY_KEY = "textBreakStrategy";
    private static final LruCache<ReadableNativeMap, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache = new ConcurrentHashMap<>();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final int spannableCacheSize = 100;

    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        public SetSpanOperation(int i2, int i3, ReactSpan reactSpan) {
            this.start = i2;
            this.end = i3;
            this.what = reactSpan;
        }

        public void execute(Spannable spannable, int i2) {
            int i3;
            int i4 = this.start;
            if (i4 == 0) {
                i3 = 18;
            } else {
                i3 = 34;
            }
            spannable.setSpan(this.what, i4, this.end, ((i2 << 16) & 16711680) | (i3 & -16711681));
        }
    }

    private static void buildSpannableFromFragment(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int i2;
        int i3;
        List<SetSpanOperation> list2 = list;
        int i4 = 0;
        for (int size = readableArray.size(); i4 < size; size = i3) {
            ReadableMap map = readableArray.getMap(i4);
            int length = spannableStringBuilder.length();
            TextAttributeProps fromReadableMap = TextAttributeProps.fromReadableMap(new ReactStylesDiffMap(map.getMap("textAttributes")));
            spannableStringBuilder.append(TextTransform.apply(map.getString("string"), fromReadableMap.mTextTransform));
            int length2 = spannableStringBuilder.length();
            if (map.hasKey("reactTag")) {
                i2 = map.getInt("reactTag");
            } else {
                i2 = -1;
            }
            if (map.hasKey(ViewProps.IS_ATTACHMENT) && map.getBoolean(ViewProps.IS_ATTACHMENT)) {
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i2, (int) PixelUtil.toPixelFromSP(map.getDouble("width")), (int) PixelUtil.toPixelFromSP(map.getDouble("height")))));
            } else if (length2 >= length) {
                if (fromReadableMap.mIsAccessibilityLink) {
                    list2.add(new SetSpanOperation(length, length2, new ReactClickableSpan(i2)));
                }
                if (fromReadableMap.mIsColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(fromReadableMap.mColor)));
                }
                if (fromReadableMap.mIsBackgroundColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(fromReadableMap.mBackgroundColor)));
                }
                if (!Float.isNaN(fromReadableMap.getLetterSpacing())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(fromReadableMap.getLetterSpacing())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(fromReadableMap.mFontSize)));
                if (fromReadableMap.mFontStyle == -1 && fromReadableMap.mFontWeight == -1 && fromReadableMap.mFontFamily == null) {
                    i3 = size;
                } else {
                    i3 = size;
                    CustomStyleSpan customStyleSpan = r10;
                    CustomStyleSpan customStyleSpan2 = new CustomStyleSpan(fromReadableMap.mFontStyle, fromReadableMap.mFontWeight, fromReadableMap.mFontFeatureSettings, fromReadableMap.mFontFamily, context.getAssets());
                    list2.add(new SetSpanOperation(length, length2, customStyleSpan));
                }
                if (fromReadableMap.mIsUnderlineTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (fromReadableMap.mIsLineThroughTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!(fromReadableMap.mTextShadowOffsetDx == 0.0f && fromReadableMap.mTextShadowOffsetDy == 0.0f)) {
                    list2.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(fromReadableMap.mTextShadowOffsetDx, fromReadableMap.mTextShadowOffsetDy, fromReadableMap.mTextShadowRadius, fromReadableMap.mTextShadowColor)));
                }
                if (!Float.isNaN(fromReadableMap.getEffectiveLineHeight())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(fromReadableMap.getEffectiveLineHeight())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactTagSpan(i2)));
                i4++;
            }
            i3 = size;
            i4++;
        }
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f2, YogaMeasureMode yogaMeasureMode, boolean z2, int i2, int i3) {
        boolean z3;
        float f3;
        int i4;
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f4 = f2;
        boolean z4 = z2;
        int i5 = i2;
        int i6 = i3;
        int length = spannable.length();
        if (yogaMeasureMode == YogaMeasureMode.UNDEFINED || f4 < 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        TextPaint textPaint = sTextPaintInstance;
        if (metrics2 == null) {
            f3 = Layout.getDesiredWidth(spannable2, textPaint);
        } else {
            f3 = Float.NaN;
        }
        if (metrics2 == null && (z3 || (!YogaConstants.isUndefined(f3) && f3 <= f4))) {
            int ceil = (int) Math.ceil((double) f3);
            if (Build.VERSION.SDK_INT >= 23) {
                return StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z4).setBreakStrategy(i5).setHyphenationFrequency(i6).build();
            }
            return new StaticLayout(spannable, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z2);
        } else if (metrics2 == null || (!z3 && ((float) metrics2.width) > f4)) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 < 23) {
                return new StaticLayout(spannable, textPaint, (int) f4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z2);
            }
            StaticLayout.Builder a2 = StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, (int) f4).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z4).setBreakStrategy(i5).setHyphenationFrequency(i6);
            if (i7 >= 28) {
                StaticLayout.Builder unused = a2.setUseLineSpacingFromFallbacks(true);
            }
            return a2.build();
        } else {
            int i8 = metrics2.width;
            if (i8 < 0) {
                String str = TAG;
                ReactSoftExceptionLogger.logSoftException(str, new ReactNoCrashSoftException("Text width is invalid: " + metrics2.width));
                i4 = 0;
            } else {
                i4 = i8;
            }
            return BoringLayout.make(spannable, textPaint, i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, metrics, z2);
        }
    }

    private static Spannable createSpannableFromAttributedString(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        buildSpannableFromFragment(context, readableMap.getArray("fragments"), spannableStringBuilder, arrayList);
        int i2 = 0;
        for (SetSpanOperation execute : arrayList) {
            execute.execute(spannableStringBuilder, i2);
            i2++;
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public static void deleteCachedSpannableForTag(int i2) {
        sTagToSpannableCache.remove(Integer.valueOf(i2));
    }

    public static Spannable getOrCreateSpannableForText(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        if (!ReactFeatureFlags.enableSpannableCache) {
            return createSpannableFromAttributedString(context, readableMap, reactTextViewManagerCallback);
        }
        Object obj = sSpannableCacheLock;
        synchronized (obj) {
            LruCache<ReadableNativeMap, Spannable> lruCache = sSpannableCache;
            Spannable spannable = lruCache.get((ReadableNativeMap) readableMap);
            if (spannable != null) {
                return spannable;
            }
            Spannable createSpannableFromAttributedString = createSpannableFromAttributedString(context, readableMap, reactTextViewManagerCallback);
            synchronized (obj) {
                lruCache.put((ReadableNativeMap) readableMap, createSpannableFromAttributedString);
            }
            return createSpannableFromAttributedString;
        }
    }

    public static boolean isRTL(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("fragments");
        if (array.size() <= 0 || TextAttributeProps.getLayoutDirection(array.getMap(0).getMap("textAttributes").getString(ViewProps.LAYOUT_DIRECTION)) != 1) {
            return false;
        }
        return true;
    }

    public static WritableArray measureLines(Context context, ReadableMap readableMap, ReadableMap readableMap2, float f2) {
        boolean z2;
        TextPaint textPaint = sTextPaintInstance;
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, readableMap, (ReactTextViewManagerCallback) null);
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(orCreateSpannableForText, textPaint);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(readableMap2.getString("textBreakStrategy"));
        if (readableMap2.hasKey("includeFontPadding")) {
            z2 = readableMap2.getBoolean("includeFontPadding");
        } else {
            z2 = true;
        }
        return FontMetricsUtil.getFontMetrics(orCreateSpannableForText, createLayout(orCreateSpannableForText, isBoring, f2, YogaMeasureMode.EXACTLY, z2, textBreakStrategy, TextAttributeProps.getTextBreakStrategy(readableMap2.getString(HYPHENATION_FREQUENCY_KEY))), textPaint, context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        if (r3 > r21) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        if (r1 > r23) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r18, com.facebook.react.bridge.ReadableMap r19, com.facebook.react.bridge.ReadableMap r20, float r21, com.facebook.yoga.YogaMeasureMode r22, float r23, com.facebook.yoga.YogaMeasureMode r24, com.facebook.react.views.text.ReactTextViewManagerCallback r25, float[] r26) {
        /*
            r0 = r19
            r1 = r20
            r9 = r22
            r10 = r24
            android.text.TextPaint r2 = sTextPaintInstance
            java.lang.String r3 = "cacheId"
            boolean r4 = r0.hasKey(r3)
            if (r4 == 0) goto L_0x0030
            int r0 = r0.getInt(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r3 = sTagToSpannableCache
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x002d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r3.get(r0)
            android.text.Spannable r0 = (android.text.Spannable) r0
            goto L_0x0038
        L_0x002d:
            r0 = 0
            return r0
        L_0x0030:
            r3 = r18
            r4 = r25
            android.text.Spannable r0 = getOrCreateSpannableForText(r3, r0, r4)
        L_0x0038:
            java.lang.String r3 = "textBreakStrategy"
            java.lang.String r3 = r1.getString(r3)
            int r7 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r3)
            java.lang.String r3 = "includeFontPadding"
            boolean r4 = r1.hasKey(r3)
            r11 = 1
            if (r4 == 0) goto L_0x0051
            boolean r3 = r1.getBoolean(r3)
            r6 = r3
            goto L_0x0052
        L_0x0051:
            r6 = 1
        L_0x0052:
            java.lang.String r3 = "android_hyphenationFrequency"
            java.lang.String r3 = r1.getString(r3)
            int r8 = com.facebook.react.views.text.TextAttributeProps.getHyphenationFrequency(r3)
            if (r0 == 0) goto L_0x0185
            android.text.BoringLayout$Metrics r3 = android.text.BoringLayout.isBoring(r0, r2)
            r2 = r0
            r4 = r21
            r5 = r22
            android.text.Layout r2 = createLayout(r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r3 = "maximumNumberOfLines"
            boolean r4 = r1.hasKey(r3)
            r5 = -1
            if (r4 == 0) goto L_0x0079
            int r1 = r1.getInt(r3)
            goto L_0x007a
        L_0x0079:
            r1 = -1
        L_0x007a:
            if (r1 == r5) goto L_0x0088
            if (r1 != 0) goto L_0x007f
            goto L_0x0088
        L_0x007f:
            int r3 = r2.getLineCount()
            int r1 = java.lang.Math.min(r1, r3)
            goto L_0x008c
        L_0x0088:
            int r1 = r2.getLineCount()
        L_0x008c:
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r9 != r3) goto L_0x0091
            goto L_0x00a9
        L_0x0091:
            r3 = 0
            r6 = 0
        L_0x0093:
            if (r6 >= r1) goto L_0x00a1
            float r7 = r2.getLineWidth(r6)
            int r8 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x009e
            r3 = r7
        L_0x009e:
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00a1:
            com.facebook.yoga.YogaMeasureMode r6 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r9 != r6) goto L_0x00ab
            int r6 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ab
        L_0x00a9:
            r3 = r21
        L_0x00ab:
            com.facebook.yoga.YogaMeasureMode r6 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r10 == r6) goto L_0x00bd
            int r1 = r1 - r11
            int r1 = r2.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.YogaMeasureMode r6 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r10 != r6) goto L_0x00bf
            int r6 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bf
        L_0x00bd:
            r1 = r23
        L_0x00bf:
            r6 = 0
            r7 = 0
        L_0x00c1:
            int r8 = r0.length()
            if (r6 >= r8) goto L_0x0178
            int r8 = r0.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r9 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            int r8 = r0.nextSpanTransition(r6, r8, r9)
            java.lang.Object[] r6 = r0.getSpans(r6, r8, r9)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r6 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r6
            int r9 = r6.length
            r10 = 0
        L_0x00d9:
            if (r10 >= r9) goto L_0x0175
            r12 = r6[r10]
            int r13 = r0.getSpanStart(r12)
            int r14 = r2.getLineForOffset(r13)
            int r15 = r2.getEllipsisCount(r14)
            if (r15 <= 0) goto L_0x00ed
            r15 = 1
            goto L_0x00ee
        L_0x00ed:
            r15 = 0
        L_0x00ee:
            if (r15 == 0) goto L_0x0106
            int r15 = r2.getLineStart(r14)
            int r16 = r2.getEllipsisStart(r14)
            int r15 = r15 + r16
            if (r13 < r15) goto L_0x0106
            int r15 = r2.getLineEnd(r14)
            if (r13 < r15) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r5 = 1
            goto L_0x016f
        L_0x0106:
            int r15 = r12.getWidth()
            float r15 = (float) r15
            int r12 = r12.getHeight()
            float r12 = (float) r12
            boolean r4 = r2.isRtlCharAt(r13)
            int r11 = r2.getParagraphDirection(r14)
            if (r11 != r5) goto L_0x011c
            r11 = 1
            goto L_0x011d
        L_0x011c:
            r11 = 0
        L_0x011d:
            int r16 = r0.length()
            r17 = 1
            int r5 = r16 + -1
            if (r13 != r5) goto L_0x0136
            if (r11 == 0) goto L_0x0130
            float r4 = r2.getLineWidth(r14)
            float r4 = r3 - r4
            goto L_0x0157
        L_0x0130:
            float r4 = r2.getLineRight(r14)
            float r4 = r4 - r15
            goto L_0x0157
        L_0x0136:
            if (r11 != r4) goto L_0x013b
            r17 = 1
            goto L_0x013d
        L_0x013b:
            r17 = 0
        L_0x013d:
            if (r17 == 0) goto L_0x0144
            float r5 = r2.getPrimaryHorizontal(r13)
            goto L_0x0148
        L_0x0144:
            float r5 = r2.getSecondaryHorizontal(r13)
        L_0x0148:
            if (r11 == 0) goto L_0x0151
            float r11 = r2.getLineRight(r14)
            float r11 = r11 - r5
            float r5 = r3 - r11
        L_0x0151:
            if (r4 == 0) goto L_0x0156
            float r4 = r5 - r15
            goto L_0x0157
        L_0x0156:
            r4 = r5
        L_0x0157:
            int r5 = r2.getLineBaseline(r14)
            float r5 = (float) r5
            float r5 = r5 - r12
            int r11 = r7 * 2
            float r5 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5)
            r26[r11] = r5
            r5 = 1
            int r11 = r11 + r5
            float r4 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r4)
            r26[r11] = r4
            int r7 = r7 + 1
        L_0x016f:
            int r10 = r10 + 1
            r5 = -1
            r11 = 1
            goto L_0x00d9
        L_0x0175:
            r6 = r8
            goto L_0x00c1
        L_0x0178:
            float r0 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r3)
            float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
            long r0 = com.facebook.yoga.YogaMeasureOutput.make((float) r0, (float) r1)
            return r0
        L_0x0185:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Spannable element has not been prepared in onBeforeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.measureText(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, com.facebook.react.views.text.ReactTextViewManagerCallback, float[]):long");
    }

    public static void setCachedSpannabledForTag(int i2, Spannable spannable) {
        sTagToSpannableCache.put(Integer.valueOf(i2), spannable);
    }
}
