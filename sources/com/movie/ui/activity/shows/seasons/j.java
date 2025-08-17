package com.movie.ui.activity.shows.seasons;

import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class j implements Function {
    public final Object apply(Object obj) {
        return Observable.fromArray((EpisodesResponse) obj);
    }
}
