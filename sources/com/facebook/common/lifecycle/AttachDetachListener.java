package com.facebook.common.lifecycle;

import android.view.View;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface AttachDetachListener {
    void onAttachToView(View view);

    void onDetachFromView(View view);
}
