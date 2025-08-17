package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.PropagatesNullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface ControllerListener2<INFO> {

    public static class Extras {
        public Object callerContext;
        public Map<String, Object> componentExtras;
        public Map<String, Object> datasourceExtras;
        public float focusX = -1.0f;
        public float focusY = -1.0f;
        public Map<String, Object> imageExtras;
        public Uri mainUri;
        public Object scaleType;
        public Map<String, Object> shortcutExtras;
        public int viewportHeight = -1;
        public int viewportWidth = -1;

        private static Map<String, Object> copyMap(@PropagatesNullable Map<String, Object> map) {
            if (map == null) {
                return null;
            }
            return new ConcurrentHashMap(map);
        }

        public static Extras of(Map<String, Object> map) {
            Extras extras = new Extras();
            extras.componentExtras = map;
            return extras;
        }

        public Extras makeExtrasCopy() {
            Extras extras = new Extras();
            extras.componentExtras = copyMap(this.componentExtras);
            extras.shortcutExtras = copyMap(this.shortcutExtras);
            extras.datasourceExtras = copyMap(this.datasourceExtras);
            extras.imageExtras = copyMap(this.imageExtras);
            extras.callerContext = this.callerContext;
            extras.mainUri = this.mainUri;
            extras.viewportWidth = this.viewportWidth;
            extras.viewportHeight = this.viewportHeight;
            extras.scaleType = this.scaleType;
            extras.focusX = this.focusX;
            extras.focusY = this.focusY;
            return extras;
        }
    }

    void onFailure(String str, Throwable th, Extras extras);

    void onFinalImageSet(String str, INFO info, Extras extras);

    void onIntermediateImageFailed(String str);

    void onIntermediateImageSet(String str, INFO info);

    void onRelease(String str, Extras extras);

    void onSubmit(String str, Object obj, Extras extras);
}
