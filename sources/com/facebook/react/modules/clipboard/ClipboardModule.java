package com.facebook.react.modules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.facebook.fbreact.specs.NativeClipboardSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Clipboard")
public class ClipboardModule extends NativeClipboardSpec {
    public static final String NAME = "Clipboard";

    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private ClipboardManager getClipboardService() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        getReactApplicationContext();
        return (ClipboardManager) reactApplicationContext.getSystemService("clipboard");
    }

    public String getName() {
        return NAME;
    }

    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip != null) {
                if (primaryClip.getItemCount() >= 1) {
                    ClipData.Item itemAt = clipboardService.getPrimaryClip().getItemAt(0);
                    promise.resolve("" + itemAt.getText());
                    return;
                }
            }
            promise.resolve("");
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    public void setString(String str) {
        getClipboardService().setPrimaryClip(ClipData.newPlainText((CharSequence) null, str));
    }
}
