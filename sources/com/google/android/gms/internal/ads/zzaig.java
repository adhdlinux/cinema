package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzaig implements zzaju {
    private final List zza;

    public zzaig() {
        this(0);
    }

    public zzaig(int i2, List list) {
        this.zza = list;
    }

    private final zzajk zzb(zzajt zzajt) {
        return new zzajk(zzd(zzajt));
    }

    private final zzajy zzc(zzajt zzajt) {
        return new zzajy(zzd(zzajt));
    }

    private final List zzd(zzajt zzajt) {
        boolean z2;
        String str;
        int i2;
        List list;
        zzfa zzfa = new zzfa(zzajt.zzd);
        List list2 = this.zza;
        while (zzfa.zza() > 0) {
            int zzk = zzfa.zzk();
            int zzc = zzfa.zzc() + zzfa.zzk();
            if (zzk == 134) {
                list2 = new ArrayList();
                int zzk2 = zzfa.zzk() & 31;
                for (int i3 = 0; i3 < zzk2; i3++) {
                    String zzx = zzfa.zzx(3, zzfot.zzc);
                    int zzk3 = zzfa.zzk();
                    if ((zzk3 & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i2 = zzk3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte zzk4 = (byte) zzfa.zzk();
                    zzfa.zzG(1);
                    if (z2) {
                        byte b2 = zzk4 & 64;
                        int i4 = zzea.zza;
                        list = Collections.singletonList(b2 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzak zzak = new zzak();
                    zzak.zzS(str);
                    zzak.zzK(zzx);
                    zzak.zzu(i2);
                    zzak.zzI(list);
                    list2.add(zzak.zzY());
                }
            }
            zzfa.zzF(zzc);
        }
        return list2;
    }

    public final zzajw zza(int i2, zzajt zzajt) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return new zzaja(new zzaix(zzajt.zzb));
            }
            if (i2 == 21) {
                return new zzaja(new zzaiv());
            }
            if (i2 == 27) {
                return new zzaja(new zzais(zzb(zzajt), false, false));
            }
            if (i2 == 36) {
                return new zzaja(new zzaiu(zzb(zzajt)));
            }
            if (i2 == 89) {
                return new zzaja(new zzaii(zzajt.zzc));
            }
            if (i2 == 138) {
                return new zzaja(new zzaih(zzajt.zzb));
            }
            if (i2 == 172) {
                return new zzaja(new zzaic(zzajt.zzb));
            }
            if (i2 == 257) {
                return new zzajj(new zzaiz("application/vnd.dvb.ait"));
            }
            if (i2 != 128) {
                if (i2 != 129) {
                    if (i2 == 134) {
                        return new zzajj(new zzaiz("application/x-scte35"));
                    }
                    if (i2 != 135) {
                        switch (i2) {
                            case 15:
                                return new zzaja(new zzaif(false, zzajt.zzb));
                            case 16:
                                return new zzaja(new zzaio(zzc(zzajt)));
                            case 17:
                                return new zzaja(new zzaiw(zzajt.zzb));
                            default:
                                return null;
                        }
                    }
                }
                return new zzaja(new zzahz(zzajt.zzb));
            }
        }
        return new zzaja(new zzail(zzc(zzajt)));
    }

    public zzaig(int i2) {
        this.zza = zzfsc.zzl();
    }
}
