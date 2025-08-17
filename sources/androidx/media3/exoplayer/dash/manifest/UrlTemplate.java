package androidx.media3.exoplayer.dash.manifest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class UrlTemplate {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f6135a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Integer> f6136b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f6137c;

    private UrlTemplate(List<String> list, List<Integer> list2, List<String> list3) {
        this.f6135a = list;
        this.f6136b = list2;
        this.f6137c = list3;
    }

    public static UrlTemplate b(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c(str, arrayList, arrayList2, arrayList3);
        return new UrlTemplate(arrayList, arrayList2, arrayList3);
    }

    private static void c(String str, List<String> list, List<Integer> list2, List<String> list3) {
        String str2;
        list.add("");
        int i2 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            char c2 = 65535;
            if (indexOf == -1) {
                list.set(list2.size(), list.get(list2.size()) + str.substring(i2));
                i2 = str.length();
            } else if (indexOf != i2) {
                list.set(list2.size(), list.get(list2.size()) + str.substring(i2, indexOf));
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                list.set(list2.size(), list.get(list2.size()) + "$");
                i2 += 2;
            } else {
                list3.add("");
                int i3 = i2 + 1;
                int indexOf2 = str.indexOf("$", i3);
                String substring = str.substring(i3, indexOf2);
                if (substring.equals("RepresentationID")) {
                    list2.add(1);
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            list2.add(2);
                            break;
                        case 1:
                            list2.add(4);
                            break;
                        case 2:
                            list2.add(3);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    list3.set(list2.size() - 1, str2);
                }
                list.add("");
                i2 = indexOf2 + 1;
            }
        }
    }

    public String a(String str, long j2, int i2, long j3) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f6136b.size(); i3++) {
            sb.append(this.f6135a.get(i3));
            if (this.f6136b.get(i3).intValue() == 1) {
                sb.append(str);
            } else if (this.f6136b.get(i3).intValue() == 2) {
                sb.append(String.format(Locale.US, this.f6137c.get(i3), new Object[]{Long.valueOf(j2)}));
            } else if (this.f6136b.get(i3).intValue() == 3) {
                sb.append(String.format(Locale.US, this.f6137c.get(i3), new Object[]{Integer.valueOf(i2)}));
            } else if (this.f6136b.get(i3).intValue() == 4) {
                sb.append(String.format(Locale.US, this.f6137c.get(i3), new Object[]{Long.valueOf(j3)}));
            }
        }
        sb.append(this.f6135a.get(this.f6136b.size()));
        return sb.toString();
    }
}
