package com.unity3d.services.ads.token;

import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONException;

public interface TokenStorage {
    void appendTokens(JSONArray jSONArray) throws JSONException;

    void createTokens(JSONArray jSONArray) throws JSONException;

    void deleteTokens();

    Unit getNativeGeneratedToken();

    String getToken();

    void setInitToken(String str);
}
