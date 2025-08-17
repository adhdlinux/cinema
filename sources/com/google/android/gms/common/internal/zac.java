package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class zac {
    private static final SimpleArrayMap zaa = new SimpleArrayMap();
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i2) {
        Resources resources = context.getResources();
        if (i2 == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i2 == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i2 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    public static String zad(Context context, int i2) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i2 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zaa2});
        } else if (i2 != 2) {
            if (i2 == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zaa2});
            } else if (i2 == 5) {
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                if (i2 == 7) {
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                if (i2 == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zaa2});
                } else if (i2 == 20) {
                    return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                } else {
                    switch (i2) {
                        case 16:
                            return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                        case 17:
                            return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zaa2});
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[]{zaa2});
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zaa2});
        }
    }

    public static String zae(Context context, int i2) {
        if (i2 == 6 || i2 == 19) {
            return zah(context, "common_google_play_services_resolution_required_text", zaa(context));
        }
        return zad(context, i2);
    }

    public static String zaf(Context context, int i2) {
        String str;
        if (i2 == 6) {
            str = zai(context, "common_google_play_services_resolution_required_title");
        } else {
            str = zag(context, i2);
        }
        if (str == null) {
            return context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        }
        return str;
    }

    public static String zag(Context context, int i2) {
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zai(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i2);
                return null;
        }
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, new Object[]{str2});
    }

    private static String zai(Context context, String str) {
        SimpleArrayMap simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            Locale d2 = ConfigurationCompat.a(context.getResources().getConfiguration()).d(0);
            if (!d2.equals(zab)) {
                simpleArrayMap.clear();
                zab = d2;
            }
            String str2 = (String) simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }
}
