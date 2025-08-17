package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.protobuf.CodedOutputStream;

final class zzg extends View.AccessibilityDelegate {
    final /* synthetic */ CastSeekBar zza;

    /* synthetic */ zzg(CastSeekBar castSeekBar, zzf zzf) {
        this.zza = castSeekBar;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
        accessibilityEvent.setItemCount(this.zza.zza.zzb);
        accessibilityEvent.setCurrentItemIndex(this.zza.getProgress());
    }

    @TargetApi(16)
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
        if (PlatformVersion.isAtLeastJellyBean() && view.isEnabled()) {
            accessibilityNodeInfo.addAction(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @TargetApi(16)
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (!view.isEnabled()) {
            return false;
        }
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (PlatformVersion.isAtLeastJellyBean() && (i2 == 4096 || i2 == 8192)) {
            this.zza.zzi();
            CastSeekBar castSeekBar = this.zza;
            int i3 = castSeekBar.zza.zzb / 20;
            if (i2 == 8192) {
                i3 = -i3;
            }
            castSeekBar.zzh(castSeekBar.getProgress() + i3);
            this.zza.zzj();
        }
        return false;
    }
}
