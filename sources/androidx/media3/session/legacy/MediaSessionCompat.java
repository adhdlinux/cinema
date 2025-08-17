package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.media3.common.util.Assertions;
import androidx.media3.session.legacy.IMediaSession;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    @SuppressLint({"BanParcelableUsage"})
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        ResultReceiver f9723b;

        ResultReceiverWrapper(Parcel parcel) {
            this.f9723b = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f9723b.writeToParcel(parcel, i2);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(Assertions.f(parcel.readParcelable((ClassLoader) null)));
            }

            /* renamed from: b */
            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private final Object f9724b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f9725c;

        /* renamed from: d  reason: collision with root package name */
        private IMediaSession f9726d;

        /* renamed from: e  reason: collision with root package name */
        private VersionedParcelable f9727e;

        Token(Object obj) {
            this(obj, (IMediaSession) null, (VersionedParcelable) null);
        }

        public static Token b(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            MediaSessionCompat.a(bundle);
            IMediaSession G = IMediaSession.Stub.G(bundle.getBinder(android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable b2 = ParcelUtils.b(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) LegacyParcelableUtil.a(bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN), CREATOR);
            if (token == null) {
                return null;
            }
            return new Token(token.f9725c, G, b2);
        }

        /* access modifiers changed from: package-private */
        public IMediaSession c() {
            IMediaSession iMediaSession;
            synchronized (this.f9724b) {
                iMediaSession = this.f9726d;
            }
            return iMediaSession;
        }

        /* access modifiers changed from: package-private */
        public void d(IMediaSession iMediaSession) {
            synchronized (this.f9724b) {
                this.f9726d = iMediaSession;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void e(VersionedParcelable versionedParcelable) {
            synchronized (this.f9724b) {
                this.f9727e = versionedParcelable;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f9725c;
            if (obj2 != null) {
                Object obj3 = token.f9725c;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f9725c == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            Object obj = this.f9725c;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable((Parcelable) this.f9725c, i2);
        }

        Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.f9724b = new Object();
            this.f9725c = obj;
            this.f9726d = iMediaSession;
            this.f9727e = versionedParcelable;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Assertions.f(MediaSessionCompat.class.getClassLoader()));
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f9720b;

        /* renamed from: c  reason: collision with root package name */
        private final long f9721c;

        /* renamed from: d  reason: collision with root package name */
        private MediaSession.QueueItem f9722d;

        private static class Api21Impl {
            private Api21Impl() {
            }

            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j2) {
                return new MediaSession.QueueItem(mediaDescription, j2);
            }

            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            } else if (j2 != -1) {
                this.f9720b = mediaDescriptionCompat;
                this.f9721c = j2;
                this.f9722d = queueItem;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem b(Object obj) {
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.b(Api21Impl.b(queueItem)), Api21Impl.c(queueItem));
        }

        public static List<QueueItem> c(List<? extends Object> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object b2 : list) {
                arrayList.add(b(b2));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f9720b + ", Id=" + this.f9721c + " }";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f9720b.writeToParcel(parcel, i2);
            parcel.writeLong(this.f9721c);
        }

        QueueItem(Parcel parcel) {
            this.f9720b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f9721c = parcel.readLong();
        }
    }
}
