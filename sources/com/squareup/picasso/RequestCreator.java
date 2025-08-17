package com.squareup.picasso;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RemoteViewsAction;
import com.squareup.picasso.Request;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final Request.Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private int memoryPolicy;
    private int networkPolicy;
    private boolean noFade;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean setPlaceholder;
    private Object tag;

    RequestCreator(Picasso picasso2, Uri uri, int i2) {
        this.setPlaceholder = true;
        if (!picasso2.shutdown) {
            this.picasso = picasso2;
            this.data = new Request.Builder(uri, i2, picasso2.defaultBitmapConfig);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private Request createRequest(long j2) {
        int andIncrement = nextId.getAndIncrement();
        Request build = this.data.build();
        build.id = andIncrement;
        build.started = j2;
        boolean z2 = this.picasso.loggingEnabled;
        if (z2) {
            Utils.log("Main", "created", build.plainId(), build.toString());
        }
        Request transformRequest = this.picasso.transformRequest(build);
        if (transformRequest != build) {
            transformRequest.id = andIncrement;
            transformRequest.started = j2;
            if (z2) {
                String logId = transformRequest.logId();
                Utils.log("Main", "changed", logId, "into " + transformRequest);
            }
        }
        return transformRequest;
    }

    private Drawable getPlaceholderDrawable() {
        int i2 = this.placeholderResId;
        if (i2 != 0) {
            return this.picasso.context.getDrawable(i2);
        }
        return this.placeholderDrawable;
    }

    private void performRemoteViewInto(RemoteViewsAction remoteViewsAction) {
        Bitmap quickMemoryCacheCheck;
        if (!MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy) || (quickMemoryCacheCheck = this.picasso.quickMemoryCacheCheck(remoteViewsAction.getKey())) == null) {
            int i2 = this.placeholderResId;
            if (i2 != 0) {
                remoteViewsAction.setImageResource(i2);
            }
            this.picasso.enqueueAndSubmit(remoteViewsAction);
            return;
        }
        remoteViewsAction.complete(quickMemoryCacheCheck, Picasso.LoadedFrom.MEMORY);
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop(17);
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    /* access modifiers changed from: package-private */
    public RequestCreator clearTag() {
        this.tag = null;
        return this;
    }

    public RequestCreator config(Bitmap.Config config) {
        this.data.config(config);
        return this;
    }

    public RequestCreator error(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.errorDrawable == null) {
            this.errorResId = i2;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public void fetch() {
        fetch((Callback) null);
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    public Bitmap get() throws IOException {
        long nanoTime = System.nanoTime();
        Utils.checkNotMain();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.data.hasImage()) {
            return null;
        } else {
            Request createRequest = createRequest(nanoTime);
            GetAction getAction = new GetAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, Utils.createKey(createRequest, new StringBuilder()));
            Picasso picasso2 = this.picasso;
            return BitmapHunter.forRequest(picasso2, picasso2.dispatcher, picasso2.cache, picasso2.stats, getAction).hunt();
        }
    }

    /* access modifiers changed from: package-private */
    public Object getTag() {
        return this.tag;
    }

    public void into(Target target) {
        Bitmap quickMemoryCacheCheck;
        long nanoTime = System.nanoTime();
        Utils.checkMain();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.deferred) {
            Drawable drawable = null;
            if (!this.data.hasImage()) {
                this.picasso.cancelRequest(target);
                if (this.setPlaceholder) {
                    drawable = getPlaceholderDrawable();
                }
                target.onPrepareLoad(drawable);
                return;
            }
            Request createRequest = createRequest(nanoTime);
            String createKey = Utils.createKey(createRequest);
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy) || (quickMemoryCacheCheck = this.picasso.quickMemoryCacheCheck(createKey)) == null) {
                if (this.setPlaceholder) {
                    drawable = getPlaceholderDrawable();
                }
                target.onPrepareLoad(drawable);
                this.picasso.enqueueAndSubmit(new TargetAction(this.picasso, target, createRequest, this.memoryPolicy, this.networkPolicy, this.errorDrawable, createKey, this.tag, this.errorResId));
                return;
            }
            this.picasso.cancelRequest(target);
            target.onBitmapLoaded(quickMemoryCacheCheck, Picasso.LoadedFrom.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public RequestCreator memoryPolicy(MemoryPolicy memoryPolicy2, MemoryPolicy... memoryPolicyArr) {
        if (memoryPolicy2 != null) {
            this.memoryPolicy = memoryPolicy2.index | this.memoryPolicy;
            if (memoryPolicyArr != null) {
                if (memoryPolicyArr.length > 0) {
                    int length = memoryPolicyArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        MemoryPolicy memoryPolicy3 = memoryPolicyArr[i2];
                        if (memoryPolicy3 != null) {
                            this.memoryPolicy = memoryPolicy3.index | this.memoryPolicy;
                            i2++;
                        } else {
                            throw new IllegalArgumentException("Memory policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public RequestCreator networkPolicy(NetworkPolicy networkPolicy2, NetworkPolicy... networkPolicyArr) {
        if (networkPolicy2 != null) {
            this.networkPolicy = networkPolicy2.index | this.networkPolicy;
            if (networkPolicyArr != null) {
                if (networkPolicyArr.length > 0) {
                    int length = networkPolicyArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        NetworkPolicy networkPolicy3 = networkPolicyArr[i2];
                        if (networkPolicy3 != null) {
                            this.networkPolicy = networkPolicy3.index | this.networkPolicy;
                            i2++;
                        } else {
                            throw new IllegalArgumentException("Network policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public RequestCreator noPlaceholder() {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.placeholderDrawable == null) {
            this.setPlaceholder = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator onlyScaleDown() {
        this.data.onlyScaleDown();
        return this;
    }

    public RequestCreator placeholder(int i2) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.placeholderDrawable == null) {
            this.placeholderResId = i2;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator priority(Picasso.Priority priority) {
        this.data.priority(priority);
        return this;
    }

    public RequestCreator purgeable() {
        this.data.purgeable();
        return this;
    }

    public RequestCreator resize(int i2, int i3) {
        this.data.resize(i2, i3);
        return this;
    }

    public RequestCreator resizeDimen(int i2, int i3) {
        Resources resources = this.picasso.context.getResources();
        return resize(resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i3));
    }

    public RequestCreator rotate(float f2) {
        this.data.rotate(f2);
        return this;
    }

    public RequestCreator stableKey(String str) {
        this.data.stableKey(str);
        return this;
    }

    public RequestCreator tag(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        } else if (this.tag == null) {
            this.tag = obj;
            return this;
        } else {
            throw new IllegalStateException("Tag already set.");
        }
    }

    public RequestCreator transform(Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    /* access modifiers changed from: package-private */
    public RequestCreator unfit() {
        this.deferred = false;
        return this;
    }

    public RequestCreator centerCrop(int i2) {
        this.data.centerCrop(i2);
        return this;
    }

    public void fetch(Callback callback) {
        long nanoTime = System.nanoTime();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.data.hasImage()) {
            if (!this.data.hasPriority()) {
                this.data.priority(Picasso.Priority.LOW);
            }
            Request createRequest = createRequest(nanoTime);
            String createKey = Utils.createKey(createRequest, new StringBuilder());
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy) || this.picasso.quickMemoryCacheCheck(createKey) == null) {
                this.picasso.submit(new FetchAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, createKey, callback));
                return;
            }
            if (this.picasso.loggingEnabled) {
                String plainId = createRequest.plainId();
                Utils.log("Main", "completed", plainId, "from " + Picasso.LoadedFrom.MEMORY);
            }
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    public RequestCreator rotate(float f2, float f3, float f4) {
        this.data.rotate(f2, f3, f4);
        return this;
    }

    public RequestCreator transform(List<? extends Transformation> list) {
        this.data.transform(list);
        return this;
    }

    public RequestCreator error(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.errorResId == 0) {
            this.errorDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    RequestCreator() {
        this.setPlaceholder = true;
        this.picasso = null;
        this.data = new Request.Builder((Uri) null, 0, (Bitmap.Config) null);
    }

    public RequestCreator placeholder(Drawable drawable) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.placeholderResId == 0) {
            this.placeholderDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public void into(RemoteViews remoteViews, int i2, int i3, Notification notification) {
        into(remoteViews, i2, i3, notification, (String) null);
    }

    public void into(RemoteViews remoteViews, int i2, int i3, Notification notification, String str) {
        into(remoteViews, i2, i3, notification, str, (Callback) null);
    }

    public void into(RemoteViews remoteViews, int i2, int i3, Notification notification, String str, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        } else if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        } else if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i4 = i2;
            int i5 = i3;
            Notification notification2 = notification;
            String str2 = str;
            performRemoteViewInto(new RemoteViewsAction.NotificationAction(this.picasso, createRequest, remoteViews2, i4, i5, notification2, str2, this.memoryPolicy, this.networkPolicy, Utils.createKey(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(RemoteViews remoteViews, int i2, int[] iArr) {
        into(remoteViews, i2, iArr, (Callback) null);
    }

    public void into(RemoteViews remoteViews, int i2, int[] iArr, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews must not be null.");
        } else if (iArr == null) {
            throw new IllegalArgumentException("appWidgetIds must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with remote views.");
        } else if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i3 = i2;
            int[] iArr2 = iArr;
            performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(this.picasso, createRequest, remoteViews2, i3, iArr2, this.memoryPolicy, this.networkPolicy, Utils.createKey(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(ImageView imageView) {
        into(imageView, (Callback) null);
    }

    public void into(ImageView imageView, Callback callback) {
        Bitmap quickMemoryCacheCheck;
        ImageView imageView2 = imageView;
        Callback callback2 = callback;
        long nanoTime = System.nanoTime();
        Utils.checkMain();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.data.hasImage()) {
            this.picasso.cancelRequest(imageView2);
            if (this.setPlaceholder) {
                PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
            }
        } else {
            if (this.deferred) {
                if (!this.data.hasSize()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.setPlaceholder) {
                            PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
                        }
                        this.picasso.defer(imageView2, new DeferredRequestCreator(this, imageView2, callback2));
                        return;
                    }
                    this.data.resize(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            Request createRequest = createRequest(nanoTime);
            String createKey = Utils.createKey(createRequest);
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy) || (quickMemoryCacheCheck = this.picasso.quickMemoryCacheCheck(createKey)) == null) {
                if (this.setPlaceholder) {
                    PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
                }
                this.picasso.enqueueAndSubmit(new ImageViewAction(this.picasso, imageView, createRequest, this.memoryPolicy, this.networkPolicy, this.errorResId, this.errorDrawable, createKey, this.tag, callback, this.noFade));
                return;
            }
            this.picasso.cancelRequest(imageView2);
            Picasso picasso2 = this.picasso;
            Context context = picasso2.context;
            Picasso.LoadedFrom loadedFrom = Picasso.LoadedFrom.MEMORY;
            PicassoDrawable.setBitmap(imageView, context, quickMemoryCacheCheck, loadedFrom, this.noFade, picasso2.indicatorsEnabled);
            if (this.picasso.loggingEnabled) {
                String plainId = createRequest.plainId();
                Utils.log("Main", "completed", plainId, "from " + loadedFrom);
            }
            if (callback2 != null) {
                callback.onSuccess();
            }
        }
    }
}
