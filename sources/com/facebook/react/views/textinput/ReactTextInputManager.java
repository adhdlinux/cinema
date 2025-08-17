package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextTransform;
import com.facebook.yoga.YogaConstants;
import com.google.android.gms.common.Scopes;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.http2.Http2;

@ReactModule(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;
    private static final String[] DRAWABLE_FIELDS = {"mCursorDrawable", "mSelectHandleLeft", "mSelectHandleRight", "mSelectHandleCenter"};
    private static final String[] DRAWABLE_RESOURCES = {"mCursorDrawableRes", "mTextSelectHandleLeftRes", "mTextSelectHandleRightRes", "mTextSelectHandleRes"};
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_URI = "url";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final Map<String, String> REACT_PROPS_AUTOFILL_HINTS_MAP = new HashMap<String, String>() {
        {
            put("birthdate-day", "birthDateDay");
            put("birthdate-full", "birthDateFull");
            put("birthdate-month", "birthDateMonth");
            put("birthdate-year", "birthDateYear");
            put("cc-csc", "creditCardSecurityCode");
            put("cc-exp", "creditCardExpirationDate");
            put("cc-exp-day", "creditCardExpirationDay");
            put("cc-exp-month", "creditCardExpirationMonth");
            put("cc-exp-year", "creditCardExpirationYear");
            put("cc-number", "creditCardNumber");
            put(Scopes.EMAIL, "emailAddress");
            put("gender", "gender");
            put("name", "personName");
            put("name-family", "personFamilyName");
            put("name-given", "personGivenName");
            put("name-middle", "personMiddleName");
            put("name-middle-initial", "personMiddleInitial");
            put("name-prefix", "personNamePrefix");
            put("name-suffix", "personNameSuffix");
            put("password", "password");
            put("password-new", "newPassword");
            put("postal-address", "postalAddress");
            put("postal-address-country", "addressCountry");
            put("postal-address-extended", "extendedAddress");
            put("postal-address-extended-postal-code", "extendedPostalCode");
            put("postal-address-locality", "addressLocality");
            put("postal-address-region", "addressRegion");
            put("postal-code", "postalCode");
            put("street-address", "streetAddress");
            put("sms-otp", "smsOTPCode");
            put("tel", "phoneNumber");
            put("tel-country-code", "phoneCountryCode");
            put("tel-national", "phoneNational");
            put("tel-device", "phoneNumberDevice");
            put(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
            put("username-new", "newUsername");
        }
    };
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    private static final int UNSET = -1;
    protected ReactTextViewManagerCallback mReactTextViewManagerCallback;

    private static class ReactContentSizeWatcher implements ContentSizeWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private int mPreviousContentHeight = 0;
        private int mPreviousContentWidth = 0;
        private int mSurfaceId;

        public ReactContentSizeWatcher(ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            ReactContext reactContext = UIManagerHelper.getReactContext(reactEditText);
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mSurfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        }

        public void onLayout() {
            if (this.mEventDispatcher != null) {
                int width = this.mEditText.getWidth();
                int height = this.mEditText.getHeight();
                if (this.mEditText.getLayout() != null) {
                    width = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
                    height = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
                }
                if (width != this.mPreviousContentWidth || height != this.mPreviousContentHeight) {
                    this.mPreviousContentHeight = height;
                    this.mPreviousContentWidth = width;
                    this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mSurfaceId, this.mEditText.getId(), PixelUtil.toDIPFromPixel((float) width), PixelUtil.toDIPFromPixel((float) height)));
                }
            }
        }
    }

    private static class ReactScrollWatcher implements ScrollWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousHoriz;
        private int mPreviousVert;
        private ReactEditText mReactEditText;
        private int mSurfaceId;

        public ReactScrollWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            ReactContext reactContext = UIManagerHelper.getReactContext(reactEditText);
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mSurfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        }

        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            if (this.mPreviousHoriz != i2 || this.mPreviousVert != i3) {
                this.mEventDispatcher.dispatchEvent(ScrollEvent.obtain(this.mSurfaceId, this.mReactEditText.getId(), ScrollEventType.SCROLL, (float) i2, (float) i3, 0.0f, 0.0f, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight()));
                this.mPreviousHoriz = i2;
                this.mPreviousVert = i3;
            }
        }
    }

    private class ReactSelectionWatcher implements SelectionWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousSelectionEnd;
        private int mPreviousSelectionStart;
        private ReactEditText mReactEditText;
        private int mSurfaceId;

        public ReactSelectionWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            ReactContext reactContext = UIManagerHelper.getReactContext(reactEditText);
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mSurfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        }

        public void onSelectionChanged(int i2, int i3) {
            int min = Math.min(i2, i3);
            int max = Math.max(i2, i3);
            if (this.mPreviousSelectionStart != min || this.mPreviousSelectionEnd != max) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mSurfaceId, this.mReactEditText.getId(), min, max));
                this.mPreviousSelectionStart = min;
                this.mPreviousSelectionEnd = max;
            }
        }
    }

    private class ReactTextInputTextWatcher implements TextWatcher {
        /* access modifiers changed from: private */
        public ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private String mPreviousText = null;
        private int mSurfaceId;

        public ReactTextInputTextWatcher(ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.mEditText = reactEditText;
            this.mSurfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (!this.mEditText.mDisableTextDiffing) {
                if (i4 != 0 || i3 != 0) {
                    Assertions.assertNotNull(this.mPreviousText);
                    String substring = charSequence.toString().substring(i2, i2 + i4);
                    int i5 = i2 + i3;
                    String substring2 = this.mPreviousText.substring(i2, i5);
                    if (i4 != i3 || !substring.equals(substring2)) {
                        if (this.mEditText.getFabricViewStateManager().hasStateWrapper()) {
                            this.mEditText.getFabricViewStateManager().setState(new FabricViewStateManager.StateUpdateCallback() {
                                public WritableMap getStateUpdate() {
                                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                                    writableNativeMap.putInt("mostRecentEventCount", ReactTextInputTextWatcher.this.mEditText.incrementAndGetEventCounter());
                                    writableNativeMap.putInt("opaqueCacheId", ReactTextInputTextWatcher.this.mEditText.getId());
                                    return writableNativeMap;
                                }
                            });
                        }
                        this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mSurfaceId, this.mEditText.getId(), charSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
                        this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mSurfaceId, this.mEditText.getId(), substring, substring2, i2, i5));
                    }
                }
            }
        }
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    /* access modifiers changed from: private */
    public static EventDispatcher getEventDispatcher(ReactContext reactContext, ReactEditText reactEditText) {
        return UIManagerHelper.getEventDispatcherForReactTag(reactContext, reactEditText.getId());
    }

    private ReactTextUpdate getReactTextUpdate(String str, int i2, int i3, int i4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = str;
        spannableStringBuilder.append(TextTransform.apply(str, TextTransform.UNSET));
        return new ReactTextUpdate(spannableStringBuilder, i2, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, i3, i4);
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    private static boolean shouldHideCursorForEmailTextInput() {
        String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
        if (Build.VERSION.SDK_INT != 29 || !lowerCase.contains("xiaomi")) {
            return false;
        }
        return true;
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i2, int i3) {
        reactEditText.setStagedInputType(((~i2) & reactEditText.getStagedInputType()) | i3);
    }

    /* access modifiers changed from: protected */
    public EditText createInternalEditText(ThemedReactContext themedReactContext) {
        return new EditText(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("focusTextInput", 1, "blurTextInput", 2);
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new HashMap<>();
        }
        exportedCustomBubblingEventTypeConstants.putAll(MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put(ReactTextInputEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).put(ReactTextInputKeyPressEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).build());
        return exportedCustomBubblingEventTypeConstants;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("AutoCapitalizationType", MapBuilder.of("none", 0, "characters", Integer.valueOf(CodedOutputStream.DEFAULT_BUFFER_SIZE), "words", 8192, "sentences", Integer.valueOf(Http2.INITIAL_MAX_FRAME_SIZE)));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z2) {
        reactEditText.setAllowFontScaling(z2);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, Dynamic dynamic) {
        int i2;
        if (dynamic.getType() == ReadableType.Number) {
            i2 = dynamic.asInt();
        } else {
            if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("none")) {
                    i2 = 0;
                } else if (asString.equals("characters")) {
                    i2 = CodedOutputStream.DEFAULT_BUFFER_SIZE;
                } else if (asString.equals("words")) {
                    i2 = 8192;
                } else {
                    boolean equals = asString.equals("sentences");
                }
            }
            i2 = Http2.INITIAL_MAX_FRAME_SIZE;
        }
        updateStagedInputTypeFlag(reactEditText, AUTOCAPITALIZE_FLAGS, i2);
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, Boolean bool) {
        int i2;
        if (bool == null) {
            i2 = 0;
        } else if (bool.booleanValue()) {
            i2 = 32768;
        } else {
            i2 = ImageMetadata.LENS_APERTURE;
        }
        updateStagedInputTypeFlag(reactEditText, 557056, i2);
    }

    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(ReactEditText reactEditText, boolean z2) {
        reactEditText.setAutoFocus(z2);
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i2, Integer num) {
        float f2;
        float f3 = Float.NaN;
        if (num == null) {
            f2 = Float.NaN;
        } else {
            f2 = (float) (num.intValue() & 16777215);
        }
        if (num != null) {
            f3 = (float) (num.intValue() >>> 24);
        }
        reactEditText.setBorderColor(SPACING_TYPES[i2], f2, f3);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i2 == 0) {
            reactEditText.setBorderRadius(f2);
        } else {
            reactEditText.setBorderRadius(f2, i2 - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        reactEditText.setBorderWidth(SPACING_TYPES[i2], f2);
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z2) {
        if (reactEditText.getStagedInputType() != 32 || !shouldHideCursorForEmailTextInput()) {
            reactEditText.setCursorVisible(!z2);
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, Integer num) {
        String str;
        if (num == null) {
            ColorStateList defaultTextColor = DefaultStyleValuesUtil.getDefaultTextColor(reactEditText.getContext());
            if (defaultTextColor != null) {
                reactEditText.setTextColor(defaultTextColor);
                return;
            }
            Context context = reactEditText.getContext();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get default text color from View Context: ");
            if (context != null) {
                str = context.getClass().getCanonicalName();
            } else {
                str = "null";
            }
            sb.append(str);
            ReactSoftExceptionLogger.logSoftException(str2, new IllegalStateException(sb.toString()));
            return;
        }
        reactEditText.setTextColor(num.intValue());
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z2) {
        reactEditText.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return z2;
            }
        });
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, Integer num) {
        Class<TextView> cls = TextView.class;
        if (num != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                Drawable textCursorDrawable = reactEditText.getTextCursorDrawable();
                if (textCursorDrawable != null) {
                    textCursorDrawable.setColorFilter(new BlendModeColorFilter(num.intValue(), BlendMode.SRC_IN));
                    reactEditText.setTextCursorDrawable(textCursorDrawable);
                }
            } else if (i2 != 28) {
                int i3 = 0;
                while (true) {
                    String[] strArr = DRAWABLE_RESOURCES;
                    if (i3 < strArr.length) {
                        try {
                            Field declaredField = cls.getDeclaredField(strArr[i3]);
                            declaredField.setAccessible(true);
                            int i4 = declaredField.getInt(reactEditText);
                            if (i4 != 0) {
                                Drawable mutate = ContextCompat.getDrawable(reactEditText.getContext(), i4).mutate();
                                mutate.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                                Field declaredField2 = cls.getDeclaredField("mEditor");
                                declaredField2.setAccessible(true);
                                Object obj = declaredField2.get(reactEditText);
                                Field declaredField3 = obj.getClass().getDeclaredField(DRAWABLE_FIELDS[i3]);
                                declaredField3.setAccessible(true);
                                if (strArr[i3] == "mCursorDrawableRes") {
                                    declaredField3.set(obj, new Drawable[]{mutate, mutate});
                                } else {
                                    declaredField3.set(obj, mutate);
                                }
                                i3++;
                            } else {
                                return;
                            }
                        } catch (IllegalAccessException | NoSuchFieldException unused) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z2) {
        reactEditText.setDisableFullscreenUI(z2);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z2) {
        reactEditText.setEnabled(z2);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f2) {
        reactEditText.setFontSize(f2);
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, String str) {
        reactEditText.setFontStyle(str);
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(ReactEditText reactEditText, ReadableArray readableArray) {
        reactEditText.setFontFeatureSettings(ReactTypefaceUtils.parseFontVariant(readableArray));
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, String str) {
        reactEditText.setFontWeight(str);
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, String str) {
        int i2;
        if ("no".equals(str)) {
            i2 = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i2 = 8;
        } else if ("yes".equals(str)) {
            i2 = 1;
        } else {
            i2 = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i2);
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z2) {
        reactEditText.setIncludeFontPadding(z2);
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i2) {
        reactEditText.setCompoundDrawablePadding(i2);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, String str) {
        int i2;
        if ("numeric".equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i2 = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            if (shouldHideCursorForEmailTextInput()) {
                reactEditText.setCursorVisible(false);
            }
            i2 = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i2 = 3;
        } else if (KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str)) {
            i2 = 144;
        } else if ("url".equalsIgnoreCase(str)) {
            i2 = 16;
        } else {
            i2 = 1;
        }
        updateStagedInputTypeFlag(reactEditText, 15, i2);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f2) {
        reactEditText.setLetterSpacingPt(f2);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f2) {
        reactEditText.setMaxFontSizeMultiplier(f2);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (InputFilter inputFilter : filters) {
                    if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                        linkedList.add(inputFilter);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z2 = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof InputFilter.LengthFilter) {
                    filters[i2] = new InputFilter.LengthFilter(num.intValue());
                    z2 = true;
                }
            }
            if (!z2) {
                InputFilter[] inputFilterArr2 = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z2) {
        int i2 = 0;
        int i3 = z2 ? 0 : 131072;
        if (z2) {
            i2 = 131072;
        }
        updateStagedInputTypeFlag(reactEditText, i3, i2);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i2) {
        reactEditText.setLines(i2);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z2) {
        if (z2) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher((ContentSizeWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z2) {
        reactEditText.setOnKeyPress(z2);
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z2) {
        if (z2) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(reactEditText));
        } else {
            reactEditText.setScrollWatcher((ScrollWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z2) {
        if (z2) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(reactEditText));
        } else {
            reactEditText.setSelectionWatcher((SelectionWatcher) null);
        }
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z2) {
        int i2;
        if (z2) {
            i2 = 128;
        } else {
            i2 = 0;
        }
        updateStagedInputTypeFlag(reactEditText, 144, i2);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z2) {
        reactEditText.setSelectAllOnFocus(z2);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if (ViewProps.LEFT.equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if (ViewProps.RIGHT.equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if (ViewProps.TOP.equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if (ViewProps.BOTTOM.equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
        }
    }

    @ReactProp(name = "autoComplete")
    public void setTextContentType(ReactEditText reactEditText, String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            Map<String, String> map = REACT_PROPS_AUTOFILL_HINTS_MAP;
            if (map.containsKey(str)) {
                setAutofillHints(reactEditText, map.get(str));
                return;
            }
            throw new JSApplicationIllegalArgumentException("Invalid autoComplete: " + str);
        }
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(ReactEditText reactEditText, String str) {
        reactEditText.setPaintFlags(reactEditText.getPaintFlags() & -25);
        for (String str2 : str.split(" ")) {
            if (str2.equals("underline")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 8);
            } else if (str2.equals("line-through")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 16);
            }
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e2) {
                FLog.e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", (Throwable) e2);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else if (Build.VERSION.SDK_INT == 21) {
            int borderColor = reactEditText.getBorderColor(3);
            setBorderColor(reactEditText, 4, num);
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            setBorderColor(reactEditText, 4, Integer.valueOf(borderColor));
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z2) {
        reactEditText.setShowSoftInputOnFocus(z2);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.setEventDispatcher(getEventDispatcher(themedReactContext, reactEditText));
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z2) {
                int surfaceId = themedReactContext.getSurfaceId();
                EventDispatcher access$000 = ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText);
                if (z2) {
                    access$000.dispatchEvent(new ReactTextInputFocusEvent(surfaceId, reactEditText.getId()));
                    return;
                }
                access$000.dispatchEvent(new ReactTextInputBlurEvent(surfaceId, reactEditText.getId()));
                access$000.dispatchEvent(new ReactTextInputEndEditingEvent(surfaceId, reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if ((i2 & JfifUtil.MARKER_FIRST_BYTE) == 0 && i2 != 0) {
                    return true;
                }
                boolean blurOnSubmit = reactEditText.getBlurOnSubmit();
                boolean isMultiline = reactEditText.isMultiline();
                ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText).dispatchEvent(new ReactTextInputSubmitEditingEvent(themedReactContext.getSurfaceId(), reactEditText.getId(), reactEditText.getText().toString()));
                if (blurOnSubmit) {
                    reactEditText.clearFocus();
                }
                if (blurOnSubmit || !isMultiline || i2 == 5 || i2 == 7) {
                    return true;
                }
                return false;
            }
        });
    }

    public ReactBaseTextShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode();
    }

    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        return reactEditText;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        reactEditText.maybeUpdateTypeface();
        reactEditText.commitStagedInputType();
    }

    public void setPadding(ReactEditText reactEditText, int i2, int i3, int i4, int i5) {
        reactEditText.setPadding(i2, i3, i4, i5);
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            int paddingLeft = (int) reactTextUpdate.getPaddingLeft();
            int paddingTop = (int) reactTextUpdate.getPaddingTop();
            int paddingRight = (int) reactTextUpdate.getPaddingRight();
            int paddingBottom = (int) reactTextUpdate.getPaddingBottom();
            if (!(paddingLeft == -1 && paddingTop == -1 && paddingRight == -1 && paddingBottom == -1)) {
                if (paddingLeft == -1) {
                    paddingLeft = reactEditText.getPaddingLeft();
                }
                if (paddingTop == -1) {
                    paddingTop = reactEditText.getPaddingTop();
                }
                if (paddingRight == -1) {
                    paddingRight = reactEditText.getPaddingRight();
                }
                if (paddingBottom == -1) {
                    paddingBottom = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            if (reactTextUpdate.containsImages()) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), reactEditText);
            }
            int i2 = 0;
            boolean z2 = reactEditText.getSelectionStart() == reactEditText.getSelectionEnd();
            int selectionStart = reactTextUpdate.getSelectionStart();
            int selectionEnd = reactTextUpdate.getSelectionEnd();
            if ((selectionStart == -1 || selectionEnd == -1) && z2) {
                if (reactEditText.getText() != null) {
                    i2 = reactEditText.getText().length();
                }
                selectionStart = reactTextUpdate.getText().length() - (i2 - reactEditText.getSelectionStart());
                selectionEnd = selectionStart;
            }
            reactEditText.maybeSetTextFromState(reactTextUpdate);
            reactEditText.maybeSetSelection(reactTextUpdate.getJsEventCounter(), selectionStart, selectionEnd);
        }
    }

    public Object updateState(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableNativeMap stateData;
        reactEditText.getFabricViewStateManager().setStateWrapper(stateWrapper);
        if (stateWrapper == null || (stateData = stateWrapper.getStateData()) == null || !stateData.hasKey("attributedString")) {
            return null;
        }
        ReadableNativeMap map = stateData.getMap("attributedString");
        ReadableNativeMap map2 = stateData.getMap("paragraphAttributes");
        if (map == null || map2 == null) {
            throw new IllegalArgumentException("Invalid TextInput State was received as a parameters");
        }
        return ReactTextUpdate.buildReactTextUpdateFromState(TextLayoutManager.getOrCreateSpannableForText(reactEditText.getContext(), map, this.mReactTextViewManagerCallback), stateData.getInt("mostRecentEventCount"), TextAttributeProps.getTextAlignment(reactStylesDiffMap, TextLayoutManager.isRTL(map)), TextAttributeProps.getTextBreakStrategy(map2.getString(ViewProps.TEXT_BREAK_STRATEGY)), TextAttributeProps.getJustificationMode(reactStylesDiffMap), map.getArray("fragments").toArrayList().size() > 1);
    }

    public ReactBaseTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextInputShadowNode(reactTextViewManagerCallback);
    }

    public void receiveCommand(ReactEditText reactEditText, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            receiveCommand(reactEditText, "focus", readableArray);
        } else if (i2 == 2) {
            receiveCommand(reactEditText, "blur", readableArray);
        } else if (i2 == 4) {
            receiveCommand(reactEditText, "setTextAndSelection", readableArray);
        }
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.textinput.ReactEditText r7, java.lang.String r8, com.facebook.react.bridge.ReadableArray r9) {
        /*
            r6 = this;
            r8.hashCode()
            int r0 = r8.hashCode()
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            r5 = -1
            switch(r0) {
                case -1699362314: goto L_0x003d;
                case 3027047: goto L_0x0032;
                case 97604824: goto L_0x0027;
                case 1427010500: goto L_0x001c;
                case 1690703013: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            r8 = -1
            goto L_0x0047
        L_0x0011:
            java.lang.String r0 = "focusTextInput"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r8 = 4
            goto L_0x0047
        L_0x001c:
            java.lang.String r0 = "setTextAndSelection"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0025
            goto L_0x000f
        L_0x0025:
            r8 = 3
            goto L_0x0047
        L_0x0027:
            java.lang.String r0 = "focus"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0030
            goto L_0x000f
        L_0x0030:
            r8 = 2
            goto L_0x0047
        L_0x0032:
            java.lang.String r0 = "blur"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x003b
            goto L_0x000f
        L_0x003b:
            r8 = 1
            goto L_0x0047
        L_0x003d:
            java.lang.String r0 = "blurTextInput"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0046
            goto L_0x000f
        L_0x0046:
            r8 = 0
        L_0x0047:
            switch(r8) {
                case 0: goto L_0x0076;
                case 1: goto L_0x0076;
                case 2: goto L_0x0072;
                case 3: goto L_0x004b;
                case 4: goto L_0x0072;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0079
        L_0x004b:
            int r8 = r9.getInt(r3)
            if (r8 != r5) goto L_0x0052
            return
        L_0x0052:
            int r0 = r9.getInt(r2)
            int r1 = r9.getInt(r1)
            if (r1 != r5) goto L_0x005d
            r1 = r0
        L_0x005d:
            boolean r2 = r9.isNull(r4)
            if (r2 != 0) goto L_0x006e
            java.lang.String r9 = r9.getString(r4)
            com.facebook.react.views.text.ReactTextUpdate r9 = r6.getReactTextUpdate(r9, r8, r0, r1)
            r7.maybeSetTextFromJS(r9)
        L_0x006e:
            r7.maybeSetSelection(r8, r0, r1)
            goto L_0x0079
        L_0x0072:
            r7.requestFocusFromJS()
            goto L_0x0079
        L_0x0076:
            r7.clearFocusFromJS()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.receiveCommand(com.facebook.react.views.textinput.ReactEditText, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
