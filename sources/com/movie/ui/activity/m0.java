package com.movie.ui.activity;

import android.util.Log;
import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m0 implements Consumer {
    public final void accept(Object obj) {
        Log.d("MEDIASOURCE", ((MediaSource) obj).toStringAllObjs());
    }
}
