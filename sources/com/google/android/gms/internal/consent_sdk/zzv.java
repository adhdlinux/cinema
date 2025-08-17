package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;
import com.unity3d.ads.metadata.MediationMetaData;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;

final class zzv {
    private final Application zza;
    private final zzac zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzam zze;
    private final zzba zzf;
    private final zzn zzg;
    private final zzz zzh;
    private final zzh zzi;

    zzv(Application application, zzac zzac, Handler handler, Executor executor, zzam zzam, zzba zzba, zzn zzn, zzz zzz, zzh zzh2) {
        this.zza = application;
        this.zzb = zzac;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzam;
        this.zzf = zzba;
        this.zzg = zzn;
        this.zzh = zzz;
        this.zzi = zzh2;
    }

    private final zzbw zzd(zzbu zzbu) throws zzj {
        JsonWriter jsonWriter;
        JsonReader jsonReader;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection();
            httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(this.zza));
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(TraktV2.HEADER_CONTENT_TYPE, TraktV2.CONTENT_TYPE_JSON);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            try {
                jsonWriter = new JsonWriter(outputStreamWriter);
                jsonWriter.beginObject();
                String str = zzbu.zza;
                if (str != null) {
                    jsonWriter.name("admob_app_id");
                    jsonWriter.value(str);
                }
                Boolean bool = zzbu.zzb;
                if (bool != null) {
                    jsonWriter.name("is_lat");
                    jsonWriter.value(bool.booleanValue());
                }
                String str2 = zzbu.zzc;
                if (str2 != null) {
                    jsonWriter.name("adid");
                    jsonWriter.value(str2);
                }
                zzbq zzbq = zzbu.zzd;
                if (zzbq != null) {
                    jsonWriter.name("device_info");
                    jsonWriter.beginObject();
                    int i2 = zzbq.zzc;
                    if (i2 != 1) {
                        jsonWriter.name("os_type");
                        if (i2 != 0) {
                            zzbp zzbp = zzbp.DEBUG_PARAM_UNKNOWN;
                            if (i2 - 1 != 0) {
                                jsonWriter.value("ANDROID");
                            } else {
                                jsonWriter.value("UNKNOWN");
                            }
                        } else {
                            throw null;
                        }
                    }
                    String str3 = zzbq.zza;
                    if (str3 != null) {
                        jsonWriter.name("model");
                        jsonWriter.value(str3);
                    }
                    Integer num = zzbq.zzb;
                    if (num != null) {
                        jsonWriter.name("android_api_level");
                        jsonWriter.value(num);
                    }
                    jsonWriter.endObject();
                }
                String str4 = zzbu.zze;
                if (str4 != null) {
                    jsonWriter.name("language_code");
                    jsonWriter.value(str4);
                }
                Boolean bool2 = zzbu.zzf;
                if (bool2 != null) {
                    jsonWriter.name("tag_for_under_age_of_consent");
                    jsonWriter.value(bool2.booleanValue());
                }
                Map<String, String> map = zzbu.zzg;
                if (!map.isEmpty()) {
                    jsonWriter.name("stored_infos_map");
                    jsonWriter.beginObject();
                    for (Map.Entry next : map.entrySet()) {
                        jsonWriter.name((String) next.getKey());
                        jsonWriter.value((String) next.getValue());
                    }
                    jsonWriter.endObject();
                }
                zzbs zzbs = zzbu.zzh;
                if (zzbs != null) {
                    jsonWriter.name("screen_info");
                    jsonWriter.beginObject();
                    Integer num2 = zzbs.zza;
                    if (num2 != null) {
                        jsonWriter.name("width");
                        jsonWriter.value(num2);
                    }
                    Integer num3 = zzbs.zzb;
                    if (num3 != null) {
                        jsonWriter.name("height");
                        jsonWriter.value(num3);
                    }
                    Double d2 = zzbs.zzc;
                    if (d2 != null) {
                        jsonWriter.name("density");
                        jsonWriter.value(d2);
                    }
                    List<zzbr> list = zzbs.zzd;
                    if (!list.isEmpty()) {
                        jsonWriter.name("screen_insets");
                        jsonWriter.beginArray();
                        for (zzbr next2 : list) {
                            jsonWriter.beginObject();
                            Integer num4 = next2.zza;
                            if (num4 != null) {
                                jsonWriter.name(ViewProps.TOP);
                                jsonWriter.value(num4);
                            }
                            Integer num5 = next2.zzb;
                            if (num5 != null) {
                                jsonWriter.name(ViewProps.LEFT);
                                jsonWriter.value(num5);
                            }
                            Integer num6 = next2.zzc;
                            if (num6 != null) {
                                jsonWriter.name(ViewProps.RIGHT);
                                jsonWriter.value(num6);
                            }
                            Integer num7 = next2.zzd;
                            if (num7 != null) {
                                jsonWriter.name(ViewProps.BOTTOM);
                                jsonWriter.value(num7);
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endArray();
                    }
                    jsonWriter.endObject();
                }
                zzbo zzbo = zzbu.zzi;
                if (zzbo != null) {
                    jsonWriter.name("app_info");
                    jsonWriter.beginObject();
                    String str5 = zzbo.zza;
                    if (str5 != null) {
                        jsonWriter.name("package_name");
                        jsonWriter.value(str5);
                    }
                    String str6 = zzbo.zzb;
                    if (str6 != null) {
                        jsonWriter.name("publisher_display_name");
                        jsonWriter.value(str6);
                    }
                    String str7 = zzbo.zzc;
                    if (str7 != null) {
                        jsonWriter.name(MediationMetaData.KEY_VERSION);
                        jsonWriter.value(str7);
                    }
                    jsonWriter.endObject();
                }
                zzbt zzbt = zzbu.zzj;
                if (zzbt != null) {
                    jsonWriter.name("sdk_info");
                    jsonWriter.beginObject();
                    String str8 = zzbt.zza;
                    if (str8 != null) {
                        jsonWriter.name(MediationMetaData.KEY_VERSION);
                        jsonWriter.value(str8);
                    }
                    jsonWriter.endObject();
                }
                List<zzbp> list2 = zzbu.zzk;
                if (!list2.isEmpty()) {
                    jsonWriter.name("debug_params");
                    jsonWriter.beginArray();
                    for (zzbp ordinal : list2) {
                        zzbp zzbp2 = zzbp.DEBUG_PARAM_UNKNOWN;
                        int ordinal2 = ordinal.ordinal();
                        if (ordinal2 == 0) {
                            jsonWriter.value("DEBUG_PARAM_UNKNOWN");
                        } else if (ordinal2 == 1) {
                            jsonWriter.value("ALWAYS_SHOW");
                        } else if (ordinal2 == 2) {
                            jsonWriter.value("GEO_OVERRIDE_EEA");
                        } else if (ordinal2 == 3) {
                            jsonWriter.value("GEO_OVERRIDE_NON_EEA");
                        } else if (ordinal2 == 4) {
                            jsonWriter.value("PREVIEWING_DEBUG_MESSAGES");
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
                jsonWriter.close();
                outputStreamWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                    if (headerField != null) {
                        zzbw zza2 = zzbw.zza(new JsonReader(new StringReader(headerField)));
                        zza2.zza = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                        return zza2;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    try {
                        bufferedReader.readLine();
                        jsonReader = new JsonReader(bufferedReader);
                        zzbw zza3 = zzbw.zza(jsonReader);
                        jsonReader.close();
                        bufferedReader.close();
                        return zza3;
                    } catch (Throwable th) {
                        bufferedReader.close();
                        throw th;
                    }
                } else {
                    String next3 = new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next();
                    StringBuilder sb = new StringBuilder(String.valueOf(next3).length() + 31);
                    sb.append("Http error code - ");
                    sb.append(responseCode);
                    sb.append(".\n");
                    sb.append(next3);
                    throw new IOException(sb.toString());
                }
                throw th;
                throw th;
            } catch (Throwable th2) {
                outputStreamWriter.close();
                throw th2;
            }
        } catch (SocketTimeoutException e2) {
            throw new zzj(4, "The server timed out.", e2);
        } catch (IOException e3) {
            throw new zzj(2, "Error making request.", e3);
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final /* synthetic */ void zza(ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        consentInformation$OnConsentInfoUpdateSuccessListener.getClass();
        handler.post(new zzu(consentInformation$OnConsentInfoUpdateSuccessListener));
    }

    public final /* synthetic */ void zzb(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        String str;
        try {
            throw null;
        } catch (RuntimeException e2) {
            String valueOf = String.valueOf(Log.getStackTraceString(e2));
            if (valueOf.length() != 0) {
                str = "Caught exception when trying to request consent info update: ".concat(valueOf);
            } else {
                str = new String("Caught exception when trying to request consent info update: ");
            }
            this.zzc.post(new zzt(consentInformation$OnConsentInfoUpdateFailureListener, new zzj(1, str)));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zzd.execute(new zzq(this, activity, consentRequestParameters, consentInformation$OnConsentInfoUpdateSuccessListener, consentInformation$OnConsentInfoUpdateFailureListener));
    }
}
