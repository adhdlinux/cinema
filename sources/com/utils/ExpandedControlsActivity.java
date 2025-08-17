package com.utils;

import android.os.Bundle;
import android.view.Menu;
import com.ads.videoreward.AdsManager;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.original.tase.helper.PlayerHelper;
import com.utils.cast.CastHelper;
import com.yoku.marumovie.R;
import javax.inject.Inject;
import javax.inject.Named;
import org.json.JSONObject;
import timber.log.Timber;

public class ExpandedControlsActivity extends ExpandedControllerActivity {
    @Inject
    @Named("ExpandedControlsActivity")

    /* renamed from: b  reason: collision with root package name */
    PlayerHelper f37233b;

    /* renamed from: c  reason: collision with root package name */
    private SessionManagerListener f37234c = null;

    /* renamed from: d  reason: collision with root package name */
    private CastContext f37235d = null;

    /* access modifiers changed from: private */
    public void A(long j2) {
        try {
            JSONObject customData = CastContext.getSharedInstance().getSessionManager().getCurrentCastSession().getRemoteMediaClient().getMediaInfo().getCustomData();
            if (customData != null) {
                PlayerHelper.PlayData playData = (PlayerHelper.PlayData) new Gson().l(customData.getString("playData"), PlayerHelper.PlayData.class);
                if (playData != null) {
                    this.f37233b.M(j2, false, playData);
                }
            }
        } catch (Exception e2) {
            Timber.d(e2);
        }
    }

    private void B() {
        this.f37234c = new SessionManagerListener<CastSession>() {
            /* renamed from: a */
            public void onSessionEnded(CastSession castSession, int i2) {
                Timber.f("onSessionEnded", new Object[0]);
            }

            /* renamed from: b */
            public void onSessionEnding(CastSession castSession) {
                ExpandedControlsActivity expandedControlsActivity = ExpandedControlsActivity.this;
                expandedControlsActivity.A(CastHelper.d(expandedControlsActivity).longValue());
                Timber.f("onSessionEnding", new Object[0]);
            }

            /* renamed from: c */
            public void onSessionResumeFailed(CastSession castSession, int i2) {
                Timber.f("onSessionResumeFailed", new Object[0]);
            }

            /* renamed from: d */
            public void onSessionResumed(CastSession castSession, boolean z2) {
                Timber.f("onSessionResumed", new Object[0]);
            }

            /* renamed from: e */
            public void onSessionResuming(CastSession castSession, String str) {
                Timber.f("onSessionResuming", new Object[0]);
            }

            /* renamed from: f */
            public void onSessionStartFailed(CastSession castSession, int i2) {
                Timber.f("onSessionStartFailed", new Object[0]);
            }

            /* renamed from: g */
            public void onSessionStarted(CastSession castSession, String str) {
                Timber.f("onSessionStarted", new Object[0]);
            }

            /* renamed from: h */
            public void onSessionStarting(CastSession castSession) {
                Timber.f("onSessionStarting", new Object[0]);
            }

            /* renamed from: i */
            public void onSessionSuspended(CastSession castSession, int i2) {
                Timber.f("onSessionSuspended", new Object[0]);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DaggerBaseActivityComponent.a().a(FreeMoviesApp.m(this).l()).b().d(this);
        this.f37233b.H(this);
        if (Utils.f0()) {
            try {
                CastContext sharedInstance = CastContext.getSharedInstance();
                this.f37235d = sharedInstance;
                if (sharedInstance != null) {
                    B();
                }
            } catch (Exception e2) {
                Timber.d(e2);
                this.f37234c = null;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.expand_controller, menu);
        CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        long longValue = CastHelper.d(this).longValue();
        A(longValue);
        if (longValue > 0 && Utils.A() != null) {
            AdsManager.d().p(Utils.A());
        }
        super.onDestroy();
        this.f37233b.z();
        this.f37234c = null;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        CastContext castContext;
        if (Utils.f0() && (castContext = this.f37235d) != null) {
            castContext.getSessionManager().removeSessionManagerListener(this.f37234c, CastSession.class);
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CastContext castContext;
        if (Utils.f0() && (castContext = this.f37235d) != null) {
            castContext.getSessionManager().addSessionManagerListener(this.f37234c, CastSession.class);
        }
        super.onResume();
    }
}
