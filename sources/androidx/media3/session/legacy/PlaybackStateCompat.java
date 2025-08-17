package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final int f9733b;

    /* renamed from: c  reason: collision with root package name */
    final long f9734c;

    /* renamed from: d  reason: collision with root package name */
    final long f9735d;

    /* renamed from: e  reason: collision with root package name */
    final float f9736e;

    /* renamed from: f  reason: collision with root package name */
    final long f9737f;

    /* renamed from: g  reason: collision with root package name */
    final int f9738g;

    /* renamed from: h  reason: collision with root package name */
    final CharSequence f9739h;

    /* renamed from: i  reason: collision with root package name */
    final long f9740i;

    /* renamed from: j  reason: collision with root package name */
    List<CustomAction> f9741j;

    /* renamed from: k  reason: collision with root package name */
    final long f9742k;

    /* renamed from: l  reason: collision with root package name */
    final Bundle f9743l;

    /* renamed from: m  reason: collision with root package name */
    private PlaybackState f9744m;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i2) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i2);
        }

        static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        static void s(PlaybackState.Builder builder, long j2) {
            builder.setActions(j2);
        }

        static void t(PlaybackState.Builder builder, long j2) {
            builder.setActiveQueueItemId(j2);
        }

        static void u(PlaybackState.Builder builder, long j2) {
            builder.setBufferedPosition(j2);
        }

        static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        static void x(PlaybackState.Builder builder, int i2, long j2, float f2, long j3) {
            builder.setState(i2, j2, f2, j3);
        }
    }

    private static class Api22Impl {
        private Api22Impl() {
        }

        static Bundle a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        static void b(PlaybackState.Builder builder, Bundle bundle) {
            PlaybackState.Builder unused = builder.setExtras(bundle);
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        List<CustomAction> list2 = list;
        this.f9733b = i2;
        this.f9734c = j2;
        this.f9735d = j3;
        this.f9736e = f2;
        this.f9737f = j4;
        this.f9738g = i3;
        this.f9739h = charSequence;
        this.f9740i = j5;
        this.f9741j = list2 == null ? ImmutableList.r() : new ArrayList<>(list2);
        this.f9742k = j6;
        this.f9743l = bundle;
    }

    public static PlaybackStateCompat b(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> j2 = Api21Impl.j(playbackState);
        if (j2 != null) {
            ArrayList arrayList2 = new ArrayList(j2.size());
            for (PlaybackState.CustomAction next : j2) {
                if (next != null) {
                    arrayList2.add(CustomAction.b(next));
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = Api22Impl.a(playbackState);
            MediaSessionCompat.a(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(Api21Impl.r(playbackState), Api21Impl.q(playbackState), Api21Impl.i(playbackState), Api21Impl.p(playbackState), Api21Impl.g(playbackState), 0, Api21Impl.k(playbackState), Api21Impl.n(playbackState), arrayList, Api21Impl.h(playbackState), bundle);
        playbackStateCompat.f9744m = playbackState;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f9733b + ", position=" + this.f9734c + ", buffered position=" + this.f9735d + ", speed=" + this.f9736e + ", updated=" + this.f9740i + ", actions=" + this.f9737f + ", error code=" + this.f9738g + ", error message=" + this.f9739h + ", custom actions=" + this.f9741j + ", active item id=" + this.f9742k + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f9733b);
        parcel.writeLong(this.f9734c);
        parcel.writeFloat(this.f9736e);
        parcel.writeLong(this.f9740i);
        parcel.writeLong(this.f9735d);
        parcel.writeLong(this.f9737f);
        TextUtils.writeToParcel(this.f9739h, parcel, i2);
        parcel.writeTypedList(this.f9741j);
        parcel.writeLong(this.f9742k);
        parcel.writeBundle(this.f9743l);
        parcel.writeInt(this.f9738g);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private final String f9745b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f9746c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9747d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f9748e;

        /* renamed from: f  reason: collision with root package name */
        private PlaybackState.CustomAction f9749f;

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f9745b = str;
            this.f9746c = charSequence;
            this.f9747d = i2;
            this.f9748e = bundle;
        }

        public static CustomAction b(Object obj) {
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            Bundle l2 = Api21Impl.l(customAction);
            MediaSessionCompat.a(l2);
            CustomAction customAction2 = new CustomAction(Api21Impl.f(customAction), Api21Impl.o(customAction), Api21Impl.m(customAction), l2);
            customAction2.f9749f = customAction;
            return customAction2;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f9746c + ", mIcon=" + this.f9747d + ", mExtras=" + this.f9748e;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f9745b);
            TextUtils.writeToParcel(this.f9746c, parcel, i2);
            parcel.writeInt(this.f9747d);
            parcel.writeBundle(this.f9748e);
        }

        CustomAction(Parcel parcel) {
            this.f9745b = (String) Assertions.f(parcel.readString());
            this.f9746c = (CharSequence) Assertions.f((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            this.f9747d = parcel.readInt();
            this.f9748e = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f9733b = parcel.readInt();
        this.f9734c = parcel.readLong();
        this.f9736e = parcel.readFloat();
        this.f9740i = parcel.readLong();
        this.f9735d = parcel.readLong();
        this.f9737f = parcel.readLong();
        this.f9739h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        List<CustomAction> createTypedArrayList = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f9741j = createTypedArrayList == null ? ImmutableList.r() : createTypedArrayList;
        this.f9742k = parcel.readLong();
        this.f9743l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f9738g = parcel.readInt();
    }
}
