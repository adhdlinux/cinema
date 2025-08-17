package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;

class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {
    public static final String BACKSPACE_KEY_VALUE = "Backspace";
    public static final String ENTER_KEY_VALUE = "Enter";
    public static final String NEWLINE_RAW_VALUE = "\n";
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private boolean mIsBatchEdit;
    private String mKey = null;

    public ReactEditTextInputConnectionWrapper(InputConnection inputConnection, ReactContext reactContext, ReactEditText reactEditText, EventDispatcher eventDispatcher) {
        super(inputConnection, false);
        this.mEventDispatcher = eventDispatcher;
        this.mEditText = reactEditText;
    }

    private void dispatchKeyEvent(String str) {
        if (str.equals(NEWLINE_RAW_VALUE)) {
            str = ENTER_KEY_VALUE;
        }
        this.mEventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(this.mEditText.getId(), str));
    }

    private void dispatchKeyEventOrEnqueue(String str) {
        if (this.mIsBatchEdit) {
            this.mKey = str;
        } else {
            dispatchKeyEvent(str);
        }
    }

    public boolean beginBatchEdit() {
        this.mIsBatchEdit = true;
        return super.beginBatchEdit();
    }

    public boolean commitText(CharSequence charSequence, int i2) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 2) {
            if (charSequence2.equals("")) {
                charSequence2 = BACKSPACE_KEY_VALUE;
            }
            dispatchKeyEventOrEnqueue(charSequence2);
        }
        return super.commitText(charSequence, i2);
    }

    public boolean deleteSurroundingText(int i2, int i3) {
        dispatchKeyEvent(BACKSPACE_KEY_VALUE);
        return super.deleteSurroundingText(i2, i3);
    }

    public boolean endBatchEdit() {
        this.mIsBatchEdit = false;
        String str = this.mKey;
        if (str != null) {
            dispatchKeyEvent(str);
            this.mKey = null;
        }
        return super.endBatchEdit();
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z2;
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getUnicodeChar() >= 58 || keyEvent.getUnicodeChar() <= 47) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (keyEvent.getKeyCode() == 67) {
                dispatchKeyEvent(BACKSPACE_KEY_VALUE);
            } else if (keyEvent.getKeyCode() == 66) {
                dispatchKeyEvent(ENTER_KEY_VALUE);
            } else if (z2) {
                dispatchKeyEvent(String.valueOf(keyEvent.getNumber()));
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    public boolean setComposingText(CharSequence charSequence, int i2) {
        boolean z2;
        boolean z3;
        String str;
        int selectionStart = this.mEditText.getSelectionStart();
        int selectionEnd = this.mEditText.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i2);
        int selectionStart2 = this.mEditText.getSelectionStart();
        boolean z4 = false;
        if (selectionStart == selectionEnd) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (selectionStart2 == selectionStart) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (selectionStart2 < selectionStart || selectionStart2 <= 0) {
            z4 = true;
        }
        if (z4 || (!z2 && z3)) {
            str = BACKSPACE_KEY_VALUE;
        } else {
            str = String.valueOf(this.mEditText.getText().charAt(selectionStart2 - 1));
        }
        dispatchKeyEventOrEnqueue(str);
        return composingText;
    }
}
