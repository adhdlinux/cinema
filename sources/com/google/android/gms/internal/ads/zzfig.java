package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzfig {
    private final HashMap zza = new HashMap();
    private final HashMap zzb = new HashMap();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final HashSet zze = new HashSet();
    private final HashSet zzf = new HashSet();
    private final HashMap zzg = new HashMap();
    private final Map zzh = new WeakHashMap();
    private boolean zzi;

    public final View zza(String str) {
        return (View) this.zzc.get(str);
    }

    public final zzfif zzb(View view) {
        zzfif zzfif = (zzfif) this.zzb.get(view);
        if (zzfif != null) {
            this.zzb.remove(view);
        }
        return zzfif;
    }

    public final String zzc(String str) {
        return (String) this.zzg.get(str);
    }

    public final String zzd(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = (String) this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final HashSet zze() {
        return this.zzf;
    }

    public final HashSet zzf() {
        return this.zze;
    }

    public final void zzg() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzi = false;
    }

    public final void zzh() {
        this.zzi = true;
    }

    public final void zzi() {
        String str;
        Boolean bool;
        zzfhl zza2 = zzfhl.zza();
        if (zza2 != null) {
            for (zzfha zzfha : zza2.zzb()) {
                View zzf2 = zzfha.zzf();
                if (zzfha.zzj()) {
                    String zzh2 = zzfha.zzh();
                    if (zzf2 != null) {
                        if (zzf2.isAttachedToWindow()) {
                            if (zzf2.hasWindowFocus()) {
                                this.zzh.remove(zzf2);
                                bool = Boolean.FALSE;
                            } else if (this.zzh.containsKey(zzf2)) {
                                bool = (Boolean) this.zzh.get(zzf2);
                            } else {
                                Map map = this.zzh;
                                Boolean bool2 = Boolean.FALSE;
                                map.put(zzf2, bool2);
                                bool = bool2;
                            }
                            if (!bool.booleanValue()) {
                                HashSet hashSet = new HashSet();
                                View view = zzf2;
                                while (true) {
                                    if (view == null) {
                                        this.zzd.addAll(hashSet);
                                        str = null;
                                        break;
                                    }
                                    String zzb2 = zzfie.zzb(view);
                                    if (zzb2 != null) {
                                        str = zzb2;
                                        break;
                                    }
                                    hashSet.add(view);
                                    ViewParent parent = view.getParent();
                                    if (parent instanceof View) {
                                        view = (View) parent;
                                    } else {
                                        view = null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.zze.add(zzh2);
                            this.zza.put(zzf2, zzh2);
                            for (zzfhn zzfhn : zzfha.zzi()) {
                                View view2 = (View) zzfhn.zzb().get();
                                if (view2 != null) {
                                    zzfif zzfif = (zzfif) this.zzb.get(view2);
                                    if (zzfif != null) {
                                        zzfif.zzc(zzfha.zzh());
                                    } else {
                                        this.zzb.put(view2, new zzfif(zzfhn, zzfha.zzh()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.zzf.add(zzh2);
                            this.zzc.put(zzh2, zzf2);
                            this.zzg.put(zzh2, str);
                        }
                    } else {
                        this.zzf.add(zzh2);
                        this.zzg.put(zzh2, "noAdView");
                    }
                }
            }
        }
    }

    public final boolean zzj(View view) {
        if (!this.zzh.containsKey(view)) {
            return true;
        }
        this.zzh.put(view, Boolean.TRUE);
        return false;
    }

    public final int zzk(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzi ? 2 : 3;
    }
}
