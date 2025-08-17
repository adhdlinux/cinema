package com.utils.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import com.database.entitys.MovieEntity;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.ImageUtils;
import com.utils.subtitle.SubtitleInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class CastHelper {
    @SuppressLint({"VisibleForTests"})
    public static MediaInfo a(PlayerHelper.PlayData playData) throws JSONException {
        String str;
        playData.h((List<? extends MediaSource>) null);
        MediaMetadata b2 = b(playData.d(), playData.e(), playData.b());
        if (playData.f() != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            for (SubtitleInfo next : playData.f()) {
                arrayList.add(new MediaTrack.Builder((long) i2, 1).setLanguage(next.f37704d).setName(next.f37702b).setContentId(next.f37703c).setSubtype(1).setContentType("application/ttml+xml").build());
                i2++;
            }
            return c(b2, playData.b()).setMediaTracks(arrayList).build();
        }
        String u2 = new Gson().u(playData);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("playData", u2);
        MediaInfo.Builder streamDuration = new MediaInfo.Builder(playData.b().getStreamLink()).setStreamType(1).setContentType("videos/*").setMetadata(b2).setStreamDuration(playData.b().getDuration() * 1000);
        if (playData.b().isHLS()) {
            str = "application/x-mpegURL";
        } else {
            str = "video/mp4";
        }
        return streamDuration.setContentType(str).setCustomData(jSONObject).build();
    }

    public static MediaMetadata b(MovieEntity movieEntity, MovieInfo movieInfo, MediaSource mediaSource) {
        int i2;
        int i3;
        int i4;
        if (movieEntity.getTV().booleanValue()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        MediaMetadata mediaMetadata = new MediaMetadata(i2);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, movieInfo.getNameAndYear());
        mediaMetadata.addImage(new WebImage(Uri.parse(ImageUtils.a(movieEntity.getPoster_path(), 500))));
        mediaMetadata.addImage(new WebImage(Uri.parse(ImageUtils.a(movieEntity.getBackdrop_path(), 500))));
        String lowerCase = mediaSource.getQuality().toLowerCase();
        if (lowerCase.contains("hd")) {
            i3 = DateTimeConstants.MINUTES_PER_DAY;
            i4 = 2560;
        } else if (lowerCase.contains("1080") || lowerCase.contains("720")) {
            i3 = 1080;
            i4 = 1920;
        } else if (lowerCase.contains("2K")) {
            i3 = -1;
            i4 = -1;
        } else {
            i3 = 2160;
            i4 = 3840;
        }
        if (i3 > -1) {
            mediaMetadata.putInt(MediaMetadata.KEY_HEIGHT, i3);
        }
        if (i4 > -1) {
            mediaMetadata.putInt(MediaMetadata.KEY_WIDTH, i4);
        }
        if (movieEntity.getTV().booleanValue()) {
            mediaMetadata.putString(MediaMetadata.KEY_SERIES_TITLE, movieInfo.getNameAndYear());
            mediaMetadata.putInt(MediaMetadata.KEY_SEASON_NUMBER, movieInfo.getSession().intValue());
            mediaMetadata.putInt(MediaMetadata.KEY_EPISODE_NUMBER, movieInfo.getEps().intValue());
        }
        return mediaMetadata;
    }

    private static MediaInfo.Builder c(MediaMetadata mediaMetadata, MediaSource mediaSource) {
        int i2;
        int i3;
        String str;
        float floatValue = Float.valueOf(FreeMoviesApp.p().getString("pref_cc_subs_font_scale2", "1.00")).floatValue();
        try {
            i2 = Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_font_color", "#FFFFFFFF"));
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            i2 = Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_font_color", "#FFFFFFFF"));
        }
        try {
            i3 = Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_bg_color", "#00FFFFFF"));
        } catch (Exception e3) {
            Logger.d(e3, new boolean[0]);
            i3 = Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_bg_color", "#00FFFFFF"));
        }
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        textTrackStyle.setBackgroundColor(i3);
        textTrackStyle.setForegroundColor(i2);
        textTrackStyle.setFontScale(floatValue);
        textTrackStyle.setWindowColor(Color.parseColor("#00AA00FF"));
        textTrackStyle.setFontFamily("Droid Sans");
        textTrackStyle.setEdgeType(1);
        textTrackStyle.setFontGenericFamily(0);
        textTrackStyle.setWindowCornerRadius(10);
        textTrackStyle.setWindowType(0);
        textTrackStyle.setEdgeColor(Color.parseColor("#FF000000"));
        MediaInfo.Builder streamType = new MediaInfo.Builder(mediaSource.getStreamLink()).setStreamType(1);
        if (mediaSource.isHLS()) {
            str = "application/x-mpegURL";
        } else {
            str = "video/mp4";
        }
        return streamType.setContentType(str).setMetadata(mediaMetadata).setTextTrackStyle(textTrackStyle);
    }

    public static Long d(Context context) {
        RemoteMediaClient remoteMediaClient;
        try {
            SessionManager sessionManager = CastContext.getSharedInstance(context).getSessionManager();
            if (!(sessionManager.getCurrentCastSession() == null || (remoteMediaClient = sessionManager.getCurrentCastSession().getRemoteMediaClient()) == null)) {
                return Long.valueOf(remoteMediaClient.getApproximateStreamPosition());
            }
        } catch (Exception e2) {
            Timber.d(e2);
        }
        return 0L;
    }

    public static boolean e(Context context) {
        try {
            CastContext sharedInstance = CastContext.getSharedInstance();
            Objects.requireNonNull(sharedInstance);
            if (sharedInstance.getSessionManager().getCurrentCastSession() != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = com.google.android.gms.cast.framework.CastContext.getSharedInstance().getSessionManager().getCurrentCastSession().getRemoteMediaClient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(final android.content.Context r4, com.original.tase.helper.PlayerHelper.PlayData r5, java.lang.Long r6) throws java.lang.Exception {
        /*
            boolean r0 = e(r4)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.google.android.gms.cast.framework.CastContext r0 = com.google.android.gms.cast.framework.CastContext.getSharedInstance()
            com.google.android.gms.cast.framework.SessionManager r0 = r0.getSessionManager()
            com.google.android.gms.cast.framework.CastSession r0 = r0.getCurrentCastSession()
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r0.getRemoteMediaClient()
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            com.utils.cast.CastHelper$2 r1 = new com.utils.cast.CastHelper$2
            r1.<init>(r4, r0)
            r0.registerCallback(r1)
            com.google.android.gms.cast.MediaInfo r4 = a(r5)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.original.tase.model.media.MediaSource r2 = r5.b()
            java.util.HashMap r2 = r2.getPlayHeader()
            if (r2 == 0) goto L_0x0040
            com.original.tase.model.media.MediaSource r5 = r5.b()
            java.util.HashMap r5 = r5.getPlayHeader()
            r1.putAll(r5)
        L_0x0040:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x004d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            r5.put(r3, r2)
            goto L_0x004d
        L_0x0067:
            com.google.android.gms.cast.MediaLoadRequestData$Builder r1 = new com.google.android.gms.cast.MediaLoadRequestData$Builder
            r1.<init>()
            com.google.android.gms.cast.MediaLoadRequestData$Builder r4 = r1.setMediaInfo(r4)
            com.google.android.gms.cast.MediaLoadRequestData$Builder r4 = r4.setCustomData(r5)
            long r5 = r6.longValue()
            com.google.android.gms.cast.MediaLoadRequestData$Builder r4 = r4.setCurrentTime(r5)
            com.google.android.gms.cast.MediaLoadRequestData r4 = r4.build()
            r0.load((com.google.android.gms.cast.MediaLoadRequestData) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.cast.CastHelper.f(android.content.Context, com.original.tase.helper.PlayerHelper$PlayData, java.lang.Long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r1 = r1.getCurrentCastSession().getRemoteMediaClient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(android.content.Context r1, final long[] r2, long[] r3) {
        /*
            if (r2 == 0) goto L_0x0033
            if (r3 == 0) goto L_0x0033
            int r0 = r2.length
            if (r0 <= 0) goto L_0x0033
            int r0 = r3.length
            if (r0 <= 0) goto L_0x0033
            com.google.android.gms.cast.framework.CastContext r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r1)     // Catch:{ Exception -> 0x002f }
            com.google.android.gms.cast.framework.SessionManager r1 = r1.getSessionManager()     // Catch:{ Exception -> 0x002f }
            com.google.android.gms.cast.framework.CastSession r0 = r1.getCurrentCastSession()     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.cast.framework.CastSession r1 = r1.getCurrentCastSession()     // Catch:{ Exception -> 0x002f }
            com.google.android.gms.cast.framework.media.RemoteMediaClient r1 = r1.getRemoteMediaClient()     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x0033
            com.google.android.gms.common.api.PendingResult r3 = r1.setActiveMediaTracks(r3)     // Catch:{ Exception -> 0x002f }
            com.utils.cast.CastHelper$1 r0 = new com.utils.cast.CastHelper$1     // Catch:{ Exception -> 0x002f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x002f }
            r3.setResultCallback(r0)     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r1 = move-exception
            timber.log.Timber.d(r1)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.cast.CastHelper.g(android.content.Context, long[], long[]):void");
    }
}
