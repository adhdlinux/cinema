package com.uwetrottmann.trakt5.entities;

import org.threeten.bp.OffsetDateTime;

public class PlaybackResponse extends GenericProgress {
    public String action;
    public Long id;
    public OffsetDateTime paused_at;
    public ShareSettings sharing;
    public String type;
}
