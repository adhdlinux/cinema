package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.CustomLetterSpacingSpan;
import com.facebook.react.views.text.CustomLineHeightSpan;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.ReactBackgroundColorSpan;
import com.facebook.react.views.text.ReactForegroundColorSpan;
import com.facebook.react.views.text.ReactSpan;
import com.facebook.react.views.text.ReactStrikethroughSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.ReactUnderlineSpan;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ReactEditText extends AppCompatEditText implements FabricViewStateManager.HasFabricViewStateManager {
    public static final boolean DEBUG_MODE = false;
    private static final int UNSET = -1;
    /* access modifiers changed from: private */
    public static final KeyListener sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();
    private final String TAG = ReactEditText.class.getSimpleName();
    private boolean mAutoFocus = false;
    private Boolean mBlurOnSubmit;
    protected boolean mContainsImages;
    private ContentSizeWatcher mContentSizeWatcher;
    private int mDefaultGravityHorizontal;
    private int mDefaultGravityVertical;
    private boolean mDetectScrollMovement = false;
    private boolean mDidAttachToWindow = false;
    private boolean mDisableFullscreen;
    protected boolean mDisableTextDiffing = false;
    private EventDispatcher mEventDispatcher;
    private final FabricViewStateManager mFabricViewStateManager = new FabricViewStateManager();
    /* access modifiers changed from: private */
    public String mFontFamily = null;
    /* access modifiers changed from: private */
    public int mFontStyle = -1;
    /* access modifiers changed from: private */
    public int mFontWeight = -1;
    private final InputMethodManager mInputMethodManager;
    protected boolean mIsSettingTextFromCacheUpdate = false;
    protected boolean mIsSettingTextFromJS;
    protected boolean mIsSettingTextFromState = false;
    private final InternalKeyListener mKeyListener;
    /* access modifiers changed from: private */
    public ArrayList<TextWatcher> mListeners;
    protected int mNativeEventCount;
    private boolean mOnKeyPress = false;
    /* access modifiers changed from: private */
    public ReactViewBackgroundManager mReactBackgroundManager;
    private String mReturnKeyType;
    private ScrollWatcher mScrollWatcher;
    private SelectionWatcher mSelectionWatcher;
    private int mStagedInputType;
    /* access modifiers changed from: private */
    public TextAttributes mTextAttributes;
    private TextWatcherDelegator mTextWatcherDelegator;
    private boolean mTypefaceDirty = false;

    private static class InternalKeyListener implements KeyListener {
        private int mInputType = 0;

        public void clearMetaKeyState(View view, Editable editable, int i2) {
            ReactEditText.sKeyListener.clearMetaKeyState(view, editable, i2);
        }

        public int getInputType() {
            return this.mInputType;
        }

        public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyDown(view, editable, i2, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyOther(view, editable, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyUp(view, editable, i2, keyEvent);
        }

        public void setInputType(int i2) {
            this.mInputType = i2;
        }
    }

    interface SpanPredicate<T> {
        boolean test(T t2);
    }

    private class TextWatcherDelegator implements TextWatcher {
        private TextWatcherDelegator() {
        }

        public void afterTextChanged(Editable editable) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromCacheUpdate && !reactEditText.mIsSettingTextFromJS && reactEditText.mListeners != null) {
                Iterator it2 = ReactEditText.this.mListeners.iterator();
                while (it2.hasNext()) {
                    ((TextWatcher) it2.next()).afterTextChanged(editable);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromCacheUpdate && !reactEditText.mIsSettingTextFromJS && reactEditText.mListeners != null) {
                Iterator it2 = ReactEditText.this.mListeners.iterator();
                while (it2.hasNext()) {
                    ((TextWatcher) it2.next()).beforeTextChanged(charSequence, i2, i3, i4);
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean z2;
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.mIsSettingTextFromCacheUpdate) {
                if (!reactEditText.mIsSettingTextFromJS && reactEditText.mListeners != null) {
                    Iterator it2 = ReactEditText.this.mListeners.iterator();
                    while (it2.hasNext()) {
                        ((TextWatcher) it2.next()).onTextChanged(charSequence, i2, i3, i4);
                    }
                }
                ReactEditText reactEditText2 = ReactEditText.this;
                if (reactEditText2.mIsSettingTextFromJS || reactEditText2.mIsSettingTextFromState || i2 != 0 || i3 != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                reactEditText2.updateCachedSpannable(z2);
            }
            ReactEditText.this.onContentSizeChange();
        }
    }

    public ReactEditText(Context context) {
        super(context);
        setFocusableInTouchMode(false);
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mInputMethodManager = (InputMethodManager) Assertions.assertNotNull(context.getSystemService("input_method"));
        this.mDefaultGravityHorizontal = getGravity() & 8388615;
        this.mDefaultGravityVertical = getGravity() & 112;
        this.mNativeEventCount = 0;
        this.mIsSettingTextFromJS = false;
        this.mBlurOnSubmit = null;
        this.mDisableFullscreen = false;
        this.mListeners = null;
        this.mTextWatcherDelegator = null;
        this.mStagedInputType = getInputType();
        this.mKeyListener = new InternalKeyListener();
        this.mScrollWatcher = null;
        this.mTextAttributes = new TextAttributes();
        applyTextAttributes();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && i2 <= 27) {
            setLayerType(1, (Paint) null);
        }
        ViewCompat.r0(this, new ReactAccessibilityDelegate(this, isFocusable(), getImportantForAccessibility()) {
            public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 16) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                int length = ReactEditText.this.getText().length();
                if (length > 0) {
                    ReactEditText.this.setSelection(length);
                }
                return ReactEditText.this.requestFocusInternal();
            }
        });
    }

    private void addSpansForMeasurement(Spannable spannable) {
        boolean z2;
        if (this.mFabricViewStateManager.hasStateWrapper()) {
            boolean z3 = this.mDisableTextDiffing;
            this.mDisableTextDiffing = true;
            int length = spannable.length();
            int i2 = 0;
            for (Object obj : spannable.getSpans(0, length(), Object.class)) {
                int spanFlags = spannable.getSpanFlags(obj);
                if ((spanFlags & 18) == 18 || (spanFlags & 17) == 17) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (obj instanceof ReactSpan) && spannable.getSpanStart(obj) == 0 && spannable.getSpanEnd(obj) == length) {
                    spannable.removeSpan(obj);
                }
            }
            ArrayList<TextLayoutManager.SetSpanOperation> arrayList = new ArrayList<>();
            if (!Float.isNaN(this.mTextAttributes.getLetterSpacing())) {
                arrayList.add(new TextLayoutManager.SetSpanOperation(0, length, new CustomLetterSpacingSpan(this.mTextAttributes.getLetterSpacing())));
            }
            arrayList.add(new TextLayoutManager.SetSpanOperation(0, length, new ReactAbsoluteSizeSpan(this.mTextAttributes.getEffectiveFontSize())));
            if (!(this.mFontStyle == -1 && this.mFontWeight == -1 && this.mFontFamily == null)) {
                arrayList.add(new TextLayoutManager.SetSpanOperation(0, length, new CustomStyleSpan(this.mFontStyle, this.mFontWeight, (String) null, this.mFontFamily, UIManagerHelper.getReactContext(this).getAssets())));
            }
            if (!Float.isNaN(this.mTextAttributes.getEffectiveLineHeight())) {
                arrayList.add(new TextLayoutManager.SetSpanOperation(0, length, new CustomLineHeightSpan(this.mTextAttributes.getEffectiveLineHeight())));
            }
            for (TextLayoutManager.SetSpanOperation execute : arrayList) {
                execute.execute(spannable, i2);
                i2++;
            }
            this.mDisableTextDiffing = z3;
        }
    }

    private int clampToTextLength(int i2) {
        int i3;
        if (getText() == null) {
            i3 = 0;
        } else {
            i3 = getText().length();
        }
        return Math.max(0, Math.min(i2, i3));
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.mTextWatcherDelegator == null) {
            this.mTextWatcherDelegator = new TextWatcherDelegator();
        }
        return this.mTextWatcherDelegator;
    }

    private boolean isSecureText() {
        return (getInputType() & 144) != 0;
    }

    private void manageSpans(SpannableStringBuilder spannableStringBuilder, boolean z2) {
        boolean z3;
        Object[] spans = getText().getSpans(0, length(), Object.class);
        for (Object obj : spans) {
            int spanFlags = getText().getSpanFlags(obj);
            if ((spanFlags & 33) == 33) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (obj instanceof ReactSpan) {
                getText().removeSpan(obj);
            }
            if (z3) {
                int spanStart = getText().getSpanStart(obj);
                int spanEnd = getText().getSpanEnd(obj);
                getText().removeSpan(obj);
                if (sameTextForSpan(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
        if (!z2) {
            addSpansForMeasurement(getText());
        }
    }

    /* access modifiers changed from: private */
    public void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.mContentSizeWatcher;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    /* access modifiers changed from: private */
    public boolean requestFocusInternal() {
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, (Rect) null);
        if (getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
        return requestFocus;
    }

    private void restoreStyleEquivalentSpans(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(this.mTextAttributes.getEffectiveFontSize()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        int backgroundColor = this.mReactBackgroundManager.getBackgroundColor();
        if (backgroundColor != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(backgroundColor), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            spannableStringBuilder.setSpan(new CustomLetterSpacingSpan(effectiveLetterSpacing), 0, spannableStringBuilder.length(), 16711698);
        }
        if (this.mFontStyle != -1 || this.mFontWeight != -1 || this.mFontFamily != null || getFontFeatureSettings() != null) {
            spannableStringBuilder.setSpan(new CustomStyleSpan(this.mFontStyle, this.mFontWeight, getFontFeatureSettings(), this.mFontFamily, getContext().getAssets()), 0, spannableStringBuilder.length(), 16711698);
        }
    }

    private static boolean sameTextForSpan(Editable editable, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (i2 > spannableStringBuilder.length() || i3 > spannableStringBuilder.length()) {
            return false;
        }
        while (i2 < i3) {
            if (editable.charAt(i2) != spannableStringBuilder.charAt(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private void setIntrinsicContentSize() {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        FabricViewStateManager fabricViewStateManager = this.mFabricViewStateManager;
        if (fabricViewStateManager != null && !fabricViewStateManager.hasStateWrapper() && !reactContext.isBridgeless()) {
            ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
            UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
            }
        }
    }

    private <T> void stripSpansOfKind(SpannableStringBuilder spannableStringBuilder, Class<T> cls, SpanPredicate<T> spanPredicate) {
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cls)) {
            if (spanPredicate.test(obj)) {
                spannableStringBuilder.removeSpan(obj);
            }
        }
    }

    private void stripStyleEquivalentSpans(SpannableStringBuilder spannableStringBuilder) {
        stripSpansOfKind(spannableStringBuilder, ReactAbsoluteSizeSpan.class, new SpanPredicate<ReactAbsoluteSizeSpan>() {
            public boolean test(ReactAbsoluteSizeSpan reactAbsoluteSizeSpan) {
                return reactAbsoluteSizeSpan.getSize() == ReactEditText.this.mTextAttributes.getEffectiveFontSize();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactBackgroundColorSpan.class, new SpanPredicate<ReactBackgroundColorSpan>() {
            public boolean test(ReactBackgroundColorSpan reactBackgroundColorSpan) {
                return reactBackgroundColorSpan.getBackgroundColor() == ReactEditText.this.mReactBackgroundManager.getBackgroundColor();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactForegroundColorSpan.class, new SpanPredicate<ReactForegroundColorSpan>() {
            public boolean test(ReactForegroundColorSpan reactForegroundColorSpan) {
                return reactForegroundColorSpan.getForegroundColor() == ReactEditText.this.getCurrentTextColor();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactStrikethroughSpan.class, new SpanPredicate<ReactStrikethroughSpan>() {
            public boolean test(ReactStrikethroughSpan reactStrikethroughSpan) {
                return (ReactEditText.this.getPaintFlags() & 16) != 0;
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactUnderlineSpan.class, new SpanPredicate<ReactUnderlineSpan>() {
            public boolean test(ReactUnderlineSpan reactUnderlineSpan) {
                return (ReactEditText.this.getPaintFlags() & 8) != 0;
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomLetterSpacingSpan.class, new SpanPredicate<CustomLetterSpacingSpan>() {
            public boolean test(CustomLetterSpacingSpan customLetterSpacingSpan) {
                return customLetterSpacingSpan.getSpacing() == ReactEditText.this.mTextAttributes.getEffectiveLetterSpacing();
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomStyleSpan.class, new SpanPredicate<CustomStyleSpan>() {
            public boolean test(CustomStyleSpan customStyleSpan) {
                return customStyleSpan.getStyle() == ReactEditText.this.mFontStyle && Objects.equals(customStyleSpan.getFontFamily(), ReactEditText.this.mFontFamily) && customStyleSpan.getWeight() == ReactEditText.this.mFontWeight && Objects.equals(customStyleSpan.getFontFeatureSettings(), ReactEditText.this.getFontFeatureSettings());
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateCachedSpannable(boolean z2) {
        FabricViewStateManager fabricViewStateManager = this.mFabricViewStateManager;
        if ((fabricViewStateManager == null || fabricViewStateManager.hasStateWrapper()) && getId() != -1) {
            boolean z3 = true;
            if (z2) {
                this.mIsSettingTextFromCacheUpdate = true;
                addSpansForMeasurement(getText());
                this.mIsSettingTextFromCacheUpdate = false;
            }
            Editable text = getText();
            if (text == null || text.length() <= 0) {
                z3 = false;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z3) {
                try {
                    spannableStringBuilder.append(text.subSequence(0, text.length()));
                    restoreStyleEquivalentSpans(spannableStringBuilder);
                } catch (IndexOutOfBoundsException e2) {
                    ReactSoftExceptionLogger.logSoftException(this.TAG, e2);
                }
            }
            if (!z3) {
                if (getHint() == null || getHint().length() <= 0) {
                    spannableStringBuilder.append("I");
                } else {
                    spannableStringBuilder.append(getHint());
                }
                addSpansForMeasurement(spannableStringBuilder);
            }
            TextLayoutManager.setCachedSpannabledForTag(getId(), spannableStringBuilder);
        }
    }

    private void updateImeOptions() {
        String str = this.mReturnKeyType;
        int i2 = 6;
        if (str != null) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = 7;
                    break;
                case 1:
                    i2 = 3;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 1;
                    break;
                case 6:
                    i2 = 4;
                    break;
            }
        }
        if (this.mDisableFullscreen) {
            setImeOptions(33554432 | i2);
        } else {
            setImeOptions(i2);
        }
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.mListeners.add(textWatcher);
    }

    /* access modifiers changed from: protected */
    public void applyTextAttributes() {
        setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            setLetterSpacing(effectiveLetterSpacing);
        }
    }

    public boolean canUpdateWithEventCount(int i2) {
        return i2 >= this.mNativeEventCount;
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        hideSoftKeyboard();
    }

    /* access modifiers changed from: package-private */
    public void clearFocusFromJS() {
        clearFocus();
    }

    /* access modifiers changed from: package-private */
    public void commitStagedInputType() {
        if (getInputType() != this.mStagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.mStagedInputType);
            setSelection(selectionStart, selectionEnd);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        TextLayoutManager.deleteCachedSpannableForTag(getId());
    }

    public boolean getBlurOnSubmit() {
        Boolean bool = this.mBlurOnSubmit;
        if (bool == null) {
            return !isMultiline();
        }
        return bool.booleanValue();
    }

    public int getBorderColor(int i2) {
        return this.mReactBackgroundManager.getBorderColor(i2);
    }

    public boolean getDisableFullscreenUI() {
        return this.mDisableFullscreen;
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mFabricViewStateManager;
    }

    public String getReturnKeyType() {
        return this.mReturnKeyType;
    }

    /* access modifiers changed from: package-private */
    public int getStagedInputType() {
        return this.mStagedInputType;
    }

    /* access modifiers changed from: protected */
    public void hideSoftKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public int incrementAndGetEventCounter() {
        int i2 = this.mNativeEventCount + 1;
        this.mNativeEventCount = i2;
        return i2;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public boolean isLayoutRequested() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isMultiline() {
        return (getInputType() & 131072) != 0;
    }

    public void maybeSetSelection(int i2, int i3, int i4) {
        if (canUpdateWithEventCount(i2) && i3 != -1 && i4 != -1) {
            setSelection(clampToTextLength(i3), clampToTextLength(i4));
        }
    }

    public void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if ((!isSecureText() || !TextUtils.equals(getText(), reactTextUpdate.getText())) && canUpdateWithEventCount(reactTextUpdate.getJsEventCounter())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
            manageSpans(spannableStringBuilder, reactTextUpdate.mContainsMultipleFragments);
            stripStyleEquivalentSpans(spannableStringBuilder);
            this.mContainsImages = reactTextUpdate.containsImages();
            this.mDisableTextDiffing = true;
            if (reactTextUpdate.getText().length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.mDisableTextDiffing = false;
            if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            updateCachedSpannable(false);
        }
    }

    public void maybeSetTextFromJS(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromJS = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromJS = false;
    }

    public void maybeSetTextFromState(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromState = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromState = false;
    }

    public void maybeUpdateTypeface() {
        if (this.mTypefaceDirty) {
            this.mTypefaceDirty = false;
            setTypeface(ReactTypefaceUtils.applyStyles(getTypeface(), this.mFontStyle, this.mFontWeight, this.mFontFamily, getContext().getAssets()));
            if (this.mFontStyle == -1 && this.mFontWeight == -1 && this.mFontFamily == null && getFontFeatureSettings() == null) {
                setPaintFlags(getPaintFlags() & -129);
            } else {
                setPaintFlags(getPaintFlags() | 128);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.setTextIsSelectable(true);
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
        if (this.mAutoFocus && !this.mDidAttachToWindow) {
            requestFocusInternal();
        }
        this.mDidAttachToWindow = true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.mOnKeyPress) {
            onCreateInputConnection = new ReactEditTextInputConnectionWrapper(onCreateInputConnection, reactContext, this, this.mEventDispatcher);
        }
        if (isMultiline() && getBlurOnSubmit()) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(z2, i2, rect);
        if (z2 && (selectionWatcher = this.mSelectionWatcher) != null) {
            selectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 66 || isMultiline()) {
            return super.onKeyUp(i2, keyEvent);
        }
        hideSoftKeyboard();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        onContentSizeChange();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollWatcher scrollWatcher = this.mScrollWatcher;
        if (scrollWatcher != null) {
            scrollWatcher.onScrollChanged(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        if (!this.mIsSettingTextFromCacheUpdate && this.mSelectionWatcher != null && hasFocus()) {
            this.mSelectionWatcher.onSelectionChanged(i2, i3);
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDetectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.mDetectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.mDetectScrollMovement = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public boolean requestFocus(int i2, Rect rect) {
        return isFocused();
    }

    public void requestFocusFromJS() {
        requestFocusInternal();
    }

    public void setAllowFontScaling(boolean z2) {
        if (this.mTextAttributes.getAllowFontScaling() != z2) {
            this.mTextAttributes.setAllowFontScaling(z2);
            applyTextAttributes();
        }
    }

    public void setAutoFocus(boolean z2) {
        this.mAutoFocus = z2;
    }

    public void setBackgroundColor(int i2) {
        this.mReactBackgroundManager.setBackgroundColor(i2);
    }

    public void setBlurOnSubmit(Boolean bool) {
        this.mBlurOnSubmit = bool;
    }

    public void setBorderColor(int i2, float f2, float f3) {
        this.mReactBackgroundManager.setBorderColor(i2, f2, f3);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setBorderWidth(int i2, float f2) {
        this.mReactBackgroundManager.setBorderWidth(i2, f2);
    }

    public void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.mContentSizeWatcher = contentSizeWatcher;
    }

    public void setDisableFullscreenUI(boolean z2) {
        this.mDisableFullscreen = z2;
        updateImeOptions();
    }

    /* access modifiers changed from: package-private */
    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.mEventDispatcher = eventDispatcher;
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
        this.mTypefaceDirty = true;
    }

    public void setFontFeatureSettings(String str) {
        if (!Objects.equals(str, getFontFeatureSettings())) {
            super.setFontFeatureSettings(str);
            this.mTypefaceDirty = true;
        }
    }

    public void setFontSize(float f2) {
        this.mTextAttributes.setFontSize(f2);
        applyTextAttributes();
    }

    public void setFontStyle(String str) {
        int parseFontStyle = ReactTypefaceUtils.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            this.mTypefaceDirty = true;
        }
    }

    public void setFontWeight(String str) {
        int parseFontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            this.mTypefaceDirty = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = this.mDefaultGravityHorizontal;
        }
        setGravity(i2 | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = this.mDefaultGravityVertical;
        }
        setGravity(i2 | (getGravity() & -113));
    }

    public void setInputType(int i2) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i2);
        this.mStagedInputType = i2;
        super.setTypeface(typeface);
        if (isMultiline()) {
            setSingleLine(false);
        }
        this.mKeyListener.setInputType(i2);
        setKeyListener(this.mKeyListener);
    }

    public void setLetterSpacingPt(float f2) {
        this.mTextAttributes.setLetterSpacing(f2);
        applyTextAttributes();
    }

    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 != this.mTextAttributes.getMaxFontSizeMultiplier()) {
            this.mTextAttributes.setMaxFontSizeMultiplier(f2);
            applyTextAttributes();
        }
    }

    public void setOnKeyPress(boolean z2) {
        this.mOnKeyPress = z2;
    }

    public void setReturnKeyType(String str) {
        this.mReturnKeyType = str;
        updateImeOptions();
    }

    public void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.mScrollWatcher = scrollWatcher;
    }

    public void setSelection(int i2, int i3) {
        super.setSelection(i2, i3);
    }

    public void setSelectionWatcher(SelectionWatcher selectionWatcher) {
        this.mSelectionWatcher = selectionWatcher;
    }

    /* access modifiers changed from: package-private */
    public void setStagedInputType(int i2) {
        this.mStagedInputType = i2;
    }

    /* access modifiers changed from: protected */
    public boolean showSoftKeyboard() {
        return this.mInputMethodManager.showSoftInput(this, 0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void setBorderRadius(float f2, int i2) {
        this.mReactBackgroundManager.setBorderRadius(f2, i2);
    }
}
