package com.uwetrottmann.trakt5;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.ProgressLastActivity;
import com.uwetrottmann.trakt5.enums.Rating;
import com.uwetrottmann.trakt5.enums.Resolution;
import com.uwetrottmann.trakt5.enums.Status;
import java.lang.reflect.Type;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

public class TraktV2Helper {
    public static GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Class<OffsetDateTime> cls = OffsetDateTime.class;
        gsonBuilder.d(cls, new a());
        gsonBuilder.d(cls, new p());
        gsonBuilder.d(LocalDate.class, new q());
        Class<Rating> cls2 = Rating.class;
        gsonBuilder.d(cls2, new b());
        gsonBuilder.d(cls2, new c());
        gsonBuilder.d(Status.class, new d());
        gsonBuilder.d(ProgressLastActivity.class, new e());
        Class<MediaType> cls3 = MediaType.class;
        gsonBuilder.d(cls3, new f());
        gsonBuilder.d(cls3, new g());
        Class<Resolution> cls4 = Resolution.class;
        gsonBuilder.d(cls4, new h());
        gsonBuilder.d(cls4, new i());
        Class<Hdr> cls5 = Hdr.class;
        gsonBuilder.d(cls5, new j());
        gsonBuilder.d(cls5, new k());
        Class<Audio> cls6 = Audio.class;
        gsonBuilder.d(cls6, new l());
        gsonBuilder.d(cls6, new m());
        Class<AudioChannels> cls7 = AudioChannels.class;
        gsonBuilder.d(cls7, new n());
        gsonBuilder.d(cls7, new o());
        return gsonBuilder;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$1(OffsetDateTime offsetDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(offsetDateTime.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$11(Hdr hdr, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(hdr.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$13(Audio audio, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(audio.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$15(AudioChannels audioChannels, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(audioChannels.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$4(Rating rating, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive((Number) Integer.valueOf(rating.value));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$7(MediaType mediaType, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(mediaType.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JsonElement lambda$getGsonBuilder$9(Resolution resolution, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(resolution.toString());
    }
}
