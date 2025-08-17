package com.movie.ui.activity.settings.subfragment;

import com.google.gson.Gson;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import dagger.MembersInjector;

public final class SubtitleFragment_MembersInjector implements MembersInjector<SubtitleFragment> {
    public static void a(SubtitleFragment subtitleFragment, Gson gson) {
        subtitleFragment.gson = gson;
    }

    public static void b(SubtitleFragment subtitleFragment, OpenSubtitleV1Api openSubtitleV1Api) {
        subtitleFragment.openSubtitleV1Api = openSubtitleV1Api;
    }
}
