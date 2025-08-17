package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso;

abstract class RemoteViewsAction extends Action<RemoteViewsTarget> {
    Callback callback;
    final RemoteViews remoteViews;
    private RemoteViewsTarget target;
    final int viewId;

    static class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;

        AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteViews, int i2, int[] iArr, int i3, int i4, String str, Object obj, int i5, Callback callback) {
            super(picasso, request, remoteViews, i2, i5, i3, i4, obj, str, callback);
            this.appWidgetIds = iArr;
        }

        /* access modifiers changed from: package-private */
        public /* bridge */ /* synthetic */ Object getTarget() {
            return RemoteViewsAction.super.getTarget();
        }

        /* access modifiers changed from: package-private */
        public void update() {
            AppWidgetManager.getInstance(this.picasso.context).updateAppWidget(this.appWidgetIds, this.remoteViews);
        }
    }

    static class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;
        private final String notificationTag;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        NotificationAction(Picasso picasso, Request request, RemoteViews remoteViews, int i2, int i3, Notification notification2, String str, int i4, int i5, String str2, Object obj, int i6, Callback callback) {
            super(picasso, request, remoteViews, i2, i6, i4, i5, obj, str2, callback);
            this.notificationId = i3;
            this.notificationTag = str;
            this.notification = notification2;
        }

        /* access modifiers changed from: package-private */
        public /* bridge */ /* synthetic */ Object getTarget() {
            return RemoteViewsAction.super.getTarget();
        }

        /* access modifiers changed from: package-private */
        public void update() {
            ((NotificationManager) Utils.getService(this.picasso.context, "notification")).notify(this.notificationTag, this.notificationId, this.notification);
        }
    }

    static class RemoteViewsTarget {
        final RemoteViews remoteViews;
        final int viewId;

        RemoteViewsTarget(RemoteViews remoteViews2, int i2) {
            this.remoteViews = remoteViews2;
            this.viewId = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RemoteViewsTarget remoteViewsTarget = (RemoteViewsTarget) obj;
            if (this.viewId != remoteViewsTarget.viewId || !this.remoteViews.equals(remoteViewsTarget.remoteViews)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.remoteViews.hashCode() * 31) + this.viewId;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteViews2, int i2, int i3, int i4, int i5, Object obj, String str, Callback callback2) {
        super(picasso, null, request, i4, i5, i3, (Drawable) null, str, obj, false);
        this.remoteViews = remoteViews2;
        this.viewId = i2;
        this.callback = callback2;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        super.cancel();
        if (this.callback != null) {
            this.callback = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSuccess();
        }
    }

    public void error(Exception exc) {
        int i2 = this.errorResId;
        if (i2 != 0) {
            setImageResource(i2);
        }
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onError(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public void setImageResource(int i2) {
        this.remoteViews.setImageViewResource(this.viewId, i2);
        update();
    }

    /* access modifiers changed from: package-private */
    public abstract void update();

    /* access modifiers changed from: package-private */
    public RemoteViewsTarget getTarget() {
        if (this.target == null) {
            this.target = new RemoteViewsTarget(this.remoteViews, this.viewId);
        }
        return this.target;
    }
}
