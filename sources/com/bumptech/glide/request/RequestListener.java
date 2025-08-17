package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener<R> {
    boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z2);

    boolean onResourceReady(R r2, Object obj, Target<R> target, DataSource dataSource, boolean z2);
}
