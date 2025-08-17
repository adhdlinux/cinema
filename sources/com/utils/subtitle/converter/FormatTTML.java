package com.utils.subtitle.converter;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import org.joda.time.DateTimeConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class FormatTTML implements TimedTextFileFormat {
    private String c(String str, TimedTextObject timedTextObject) {
        int i2;
        if (str.startsWith("#")) {
            if (str.length() == 7) {
                return str.substring(1) + "ff";
            } else if (str.length() == 9) {
                return str.substring(1);
            } else {
                timedTextObject.f37742j += "Unrecoginzed format: " + str + "\n\n";
                return "ffffffff";
            }
        } else if (str.startsWith("rgb")) {
            boolean startsWith = str.startsWith("rgba");
            try {
                String[] split = str.split("(")[1].split(",");
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int parseInt3 = Integer.parseInt(split[2].substring(0, 2));
                if (startsWith) {
                    i2 = Integer.parseInt(split[3].substring(0, 2));
                } else {
                    i2 = JfifUtil.MARKER_FIRST_BYTE;
                }
                split[0] = Integer.toHexString(parseInt);
                split[1] = Integer.toHexString(parseInt2);
                split[2] = Integer.toHexString(parseInt3);
                if (startsWith) {
                    split[2] = Integer.toHexString(i2);
                }
                String str2 = "";
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (split[i3].length() < 2) {
                        split[i3] = "0" + split[i3];
                    }
                    str2 = str2 + split[i3];
                }
                if (!startsWith) {
                    str2 = str2 + "ff";
                }
                return str2;
            } catch (Exception unused) {
                timedTextObject.f37742j += "Unrecoginzed color: " + str + "\n\n";
                return "ffffffff";
            }
        } else {
            String b2 = Style.b("name", str);
            if (b2 != null && !b2.isEmpty()) {
                return b2;
            }
            timedTextObject.f37742j += "Unrecoginzed color: " + str + "\n\n";
            return "ffffffff";
        }
    }

    private int d(String str, TimedTextObject timedTextObject, Document document) {
        Node item;
        double d2;
        int i2;
        if (str.contains(":")) {
            String[] split = str.split(":");
            if (split.length == 3) {
                return (Integer.parseInt(split[0]) * DateTimeConstants.MILLIS_PER_HOUR) + (Integer.parseInt(split[1]) * DateTimeConstants.MILLIS_PER_MINUTE) + ((int) (Float.parseFloat(split[2]) * 1000.0f));
            } else if (split.length != 4) {
                return 0;
            } else {
                Node item2 = document.getElementsByTagName("ttp:frameRate").item(0);
                if (item2 != null) {
                    try {
                        i2 = Integer.parseInt(item2.getNodeValue());
                    } catch (NumberFormatException unused) {
                    }
                    return (Integer.parseInt(split[0]) * DateTimeConstants.MILLIS_PER_HOUR) + (Integer.parseInt(split[1]) * DateTimeConstants.MILLIS_PER_MINUTE) + (Integer.parseInt(split[2]) * 1000) + ((int) ((Float.parseFloat(split[3]) * 1000.0f) / ((float) i2)));
                }
                i2 = 25;
                return (Integer.parseInt(split[0]) * DateTimeConstants.MILLIS_PER_HOUR) + (Integer.parseInt(split[1]) * DateTimeConstants.MILLIS_PER_MINUTE) + (Integer.parseInt(split[2]) * 1000) + ((int) ((Float.parseFloat(split[3]) * 1000.0f) / ((float) i2)));
            }
        } else {
            String substring = str.substring(str.length() - 1);
            try {
                double parseDouble = Double.parseDouble(str.substring(0, str.length() - 1).replace(',', '.').trim());
                if (substring.equalsIgnoreCase("h")) {
                    d2 = 3600000.0d;
                } else if (substring.equalsIgnoreCase("m")) {
                    d2 = 60000.0d;
                } else {
                    if (substring.equalsIgnoreCase("s")) {
                        parseDouble *= 1000.0d;
                    } else if (!substring.equalsIgnoreCase("ms")) {
                        if (substring.equalsIgnoreCase("f")) {
                            Node item3 = document.getElementsByTagName("ttp:frameRate").item(0);
                            if (item3 != null) {
                                return (int) ((parseDouble * 1000.0d) / ((double) Integer.parseInt(item3.getNodeValue())));
                            }
                            return 0;
                        } else if (!substring.equalsIgnoreCase("t") || (item = document.getElementsByTagName("ttp:tickRate").item(0)) == null) {
                            return 0;
                        } else {
                            parseDouble = (parseDouble * 1000.0d) / ((double) Integer.parseInt(item.getNodeValue()));
                        }
                    }
                    return (int) parseDouble;
                }
                parseDouble *= d2;
                return (int) parseDouble;
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ba A[Catch:{ Exception -> 0x0386 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02f9 A[SYNTHETIC, Splitter:B:122:0x02f9] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x035f A[Catch:{ Exception -> 0x0386 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0362 A[Catch:{ Exception -> 0x0386 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x037e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.utils.subtitle.converter.TimedTextObject a(java.lang.String r17, java.io.InputStream r18, java.lang.String r19) throws java.io.IOException, com.utils.subtitle.converter.FatalParsingException {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "style"
            java.lang.String r2 = ""
            com.utils.subtitle.converter.TimedTextObject r3 = new com.utils.subtitle.converter.TimedTextObject
            r3.<init>()
            r4 = r17
            r3.f37737e = r4
            javax.xml.parsers.DocumentBuilderFactory r4 = javax.xml.parsers.DocumentBuilderFactory.newInstance()
            javax.xml.parsers.DocumentBuilder r4 = r4.newDocumentBuilder()     // Catch:{ Exception -> 0x0386 }
            r5 = r18
            org.w3c.dom.Document r4 = r4.parse(r5)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Element r5 = r4.getDocumentElement()     // Catch:{ Exception -> 0x0386 }
            r5.normalize()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r5 = "ttm:title"
            org.w3c.dom.NodeList r5 = r4.getElementsByTagName(r5)     // Catch:{ Exception -> 0x0386 }
            r6 = 0
            org.w3c.dom.Node r5 = r5.item(r6)     // Catch:{ Exception -> 0x0386 }
            if (r5 == 0) goto L_0x0037
            java.lang.String r5 = r5.getTextContent()     // Catch:{ Exception -> 0x0386 }
            r3.f37733a = r5     // Catch:{ Exception -> 0x0386 }
        L_0x0037:
            java.lang.String r5 = "ttm:copyright"
            org.w3c.dom.NodeList r5 = r4.getElementsByTagName(r5)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Node r5 = r5.item(r6)     // Catch:{ Exception -> 0x0386 }
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = r5.getTextContent()     // Catch:{ Exception -> 0x0386 }
            r3.f37735c = r5     // Catch:{ Exception -> 0x0386 }
        L_0x0049:
            java.lang.String r5 = "ttm:desc"
            org.w3c.dom.NodeList r5 = r4.getElementsByTagName(r5)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Node r5 = r5.item(r6)     // Catch:{ Exception -> 0x0386 }
            if (r5 == 0) goto L_0x005b
            java.lang.String r5 = r5.getTextContent()     // Catch:{ Exception -> 0x0386 }
            r3.f37734b = r5     // Catch:{ Exception -> 0x0386 }
        L_0x005b:
            org.w3c.dom.NodeList r5 = r4.getElementsByTagName(r0)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r7 = "p"
            org.w3c.dom.NodeList r7 = r4.getElementsByTagName(r7)     // Catch:{ Exception -> 0x0386 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0386 }
            r8.<init>()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r9 = r3.f37742j     // Catch:{ Exception -> 0x0386 }
            r8.append(r9)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r9 = "Styling attributes are only recognized inside a style definition, to be referenced later in the captions.\n\n"
            r8.append(r9)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0386 }
            r3.f37742j = r8     // Catch:{ Exception -> 0x0386 }
            r8 = 0
        L_0x007b:
            int r9 = r5.getLength()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r10 = "end"
            if (r8 >= r9) goto L_0x024d
            com.utils.subtitle.converter.Style r9 = new com.utils.subtitle.converter.Style     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = com.utils.subtitle.converter.Style.a()     // Catch:{ Exception -> 0x0386 }
            r9.<init>(r12)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Node r12 = r5.item(r8)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.NamedNodeMap r12 = r12.getAttributes()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = "id"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x00a2
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            r9.f37723a = r13     // Catch:{ Exception -> 0x0386 }
        L_0x00a2:
            java.lang.String r13 = "xml:id"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x00b0
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            r9.f37723a = r13     // Catch:{ Exception -> 0x0386 }
        L_0x00b0:
            org.w3c.dom.Node r13 = r12.getNamedItem(r0)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x00d6
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r14 = r3.f37739g     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            boolean r14 = r14.containsKey(r15)     // Catch:{ Exception -> 0x0386 }
            if (r14 == 0) goto L_0x00d6
            com.utils.subtitle.converter.Style r14 = new com.utils.subtitle.converter.Style     // Catch:{ Exception -> 0x0386 }
            java.lang.String r9 = r9.f37723a     // Catch:{ Exception -> 0x0386 }
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r15 = r3.f37739g     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.Object r13 = r15.get(r13)     // Catch:{ Exception -> 0x0386 }
            com.utils.subtitle.converter.Style r13 = (com.utils.subtitle.converter.Style) r13     // Catch:{ Exception -> 0x0386 }
            r14.<init>(r9, r13)     // Catch:{ Exception -> 0x0386 }
            r9 = r14
        L_0x00d6:
            java.lang.String r13 = "tts:backgroundColor"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x00e8
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r1.c(r13, r3)     // Catch:{ Exception -> 0x0386 }
            r9.f37727e = r13     // Catch:{ Exception -> 0x0386 }
        L_0x00e8:
            java.lang.String r13 = "tts:color"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x00fa
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r1.c(r13, r3)     // Catch:{ Exception -> 0x0386 }
            r9.f37726d = r13     // Catch:{ Exception -> 0x0386 }
        L_0x00fa:
            java.lang.String r13 = "tts:fontFamily"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x0108
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            r9.f37724b = r13     // Catch:{ Exception -> 0x0386 }
        L_0x0108:
            java.lang.String r13 = "tts:fontSize"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x0116
            java.lang.String r13 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            r9.f37725c = r13     // Catch:{ Exception -> 0x0386 }
        L_0x0116:
            java.lang.String r13 = "tts:fontStyle"
            org.w3c.dom.Node r13 = r12.getNamedItem(r13)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "normal"
            if (r13 == 0) goto L_0x0149
            java.lang.String r15 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = "italic"
            boolean r11 = r15.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0386 }
            if (r11 != 0) goto L_0x0146
            java.lang.String r11 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = "oblique"
            boolean r11 = r11.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x0139
            goto L_0x0146
        L_0x0139:
            java.lang.String r11 = r13.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            boolean r11 = r11.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x0149
            r9.f37729g = r6     // Catch:{ Exception -> 0x0386 }
            goto L_0x0149
        L_0x0146:
            r11 = 1
            r9.f37729g = r11     // Catch:{ Exception -> 0x0386 }
        L_0x0149:
            java.lang.String r11 = "tts:fontWeight"
            org.w3c.dom.Node r11 = r12.getNamedItem(r11)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x016d
            java.lang.String r13 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = "bold"
            boolean r13 = r13.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x0161
            r13 = 1
            r9.f37730h = r13     // Catch:{ Exception -> 0x0386 }
            goto L_0x016d
        L_0x0161:
            java.lang.String r11 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            boolean r11 = r11.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x016d
            r9.f37730h = r6     // Catch:{ Exception -> 0x0386 }
        L_0x016d:
            java.lang.String r11 = "tts:opacity"
            org.w3c.dom.Node r11 = r12.getNamedItem(r11)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x01dc
            java.lang.String r11 = r11.getNodeValue()     // Catch:{ NumberFormatException -> 0x01dc }
            float r11 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x01dc }
            r13 = 1065353216(0x3f800000, float:1.0)
            int r14 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r14 <= 0) goto L_0x0186
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x018c
        L_0x0186:
            r13 = 0
            int r14 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r14 >= 0) goto L_0x018c
            r11 = 0
        L_0x018c:
            r13 = 1132396544(0x437f0000, float:255.0)
            float r11 = r11 * r13
            int r11 = (int) r11     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r11 = java.lang.Integer.toHexString(r11)     // Catch:{ NumberFormatException -> 0x01dc }
            int r13 = r11.length()     // Catch:{ NumberFormatException -> 0x01dc }
            r14 = 2
            if (r13 >= r14) goto L_0x01ad
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01dc }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r14 = "0"
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x01dc }
            r13.append(r11)     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r11 = r13.toString()     // Catch:{ NumberFormatException -> 0x01dc }
        L_0x01ad:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01dc }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r14 = r9.f37726d     // Catch:{ NumberFormatException -> 0x01dc }
            r15 = 6
            java.lang.String r14 = r14.substring(r6, r15)     // Catch:{ NumberFormatException -> 0x01dc }
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x01dc }
            r13.append(r11)     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r13 = r13.toString()     // Catch:{ NumberFormatException -> 0x01dc }
            r9.f37726d = r13     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01dc }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r14 = r9.f37727e     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r14 = r14.substring(r6, r15)     // Catch:{ NumberFormatException -> 0x01dc }
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x01dc }
            r13.append(r11)     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r11 = r13.toString()     // Catch:{ NumberFormatException -> 0x01dc }
            r9.f37727e = r11     // Catch:{ NumberFormatException -> 0x01dc }
        L_0x01dc:
            java.lang.String r11 = "tts:textAlign"
            org.w3c.dom.Node r11 = r12.getNamedItem(r11)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x021c
            java.lang.String r13 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "left"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0386 }
            if (r13 != 0) goto L_0x0218
            java.lang.String r13 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "start"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x01fd
            goto L_0x0218
        L_0x01fd:
            java.lang.String r13 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "right"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0386 }
            if (r13 != 0) goto L_0x0213
            java.lang.String r11 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            boolean r10 = r11.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0386 }
            if (r10 == 0) goto L_0x021c
        L_0x0213:
            java.lang.String r10 = "bottom-right"
            r9.f37728f = r10     // Catch:{ Exception -> 0x0386 }
            goto L_0x021c
        L_0x0218:
            java.lang.String r10 = "bottom-left"
            r9.f37728f = r10     // Catch:{ Exception -> 0x0386 }
        L_0x021c:
            java.lang.String r10 = "tts:textDecoration"
            org.w3c.dom.Node r10 = r12.getNamedItem(r10)     // Catch:{ Exception -> 0x0386 }
            if (r10 == 0) goto L_0x0242
            java.lang.String r11 = r10.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = "underline"
            boolean r11 = r11.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x0234
            r11 = 1
            r9.f37731i = r11     // Catch:{ Exception -> 0x0386 }
            goto L_0x0242
        L_0x0234:
            java.lang.String r10 = r10.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = "noUnderline"
            boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0386 }
            if (r10 == 0) goto L_0x0242
            r9.f37731i = r6     // Catch:{ Exception -> 0x0386 }
        L_0x0242:
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r10 = r3.f37739g     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = r9.f37723a     // Catch:{ Exception -> 0x0386 }
            r10.put(r11, r9)     // Catch:{ Exception -> 0x0386 }
            int r8 = r8 + 1
            goto L_0x007b
        L_0x024d:
            r5 = 0
        L_0x024e:
            int r8 = r7.getLength()     // Catch:{ Exception -> 0x0386 }
            if (r5 >= r8) goto L_0x0382
            com.utils.subtitle.converter.Caption r8 = new com.utils.subtitle.converter.Caption     // Catch:{ Exception -> 0x0386 }
            r8.<init>()     // Catch:{ Exception -> 0x0386 }
            r8.f37720d = r2     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Node r9 = r7.item(r5)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.NamedNodeMap r11 = r9.getAttributes()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = "begin"
            org.w3c.dom.Node r12 = r11.getNamedItem(r12)     // Catch:{ Exception -> 0x0386 }
            com.utils.subtitle.converter.Time r13 = new com.utils.subtitle.converter.Time     // Catch:{ Exception -> 0x0386 }
            r13.<init>(r2, r2)     // Catch:{ Exception -> 0x0386 }
            r8.f37718b = r13     // Catch:{ Exception -> 0x0386 }
            com.utils.subtitle.converter.Time r13 = new com.utils.subtitle.converter.Time     // Catch:{ Exception -> 0x0386 }
            r13.<init>(r2, r2)     // Catch:{ Exception -> 0x0386 }
            r8.f37719c = r13     // Catch:{ Exception -> 0x0386 }
            if (r12 == 0) goto L_0x0285
            com.utils.subtitle.converter.Time r13 = r8.f37718b     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = r12.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            int r12 = r1.d(r12, r3, r4)     // Catch:{ Exception -> 0x0386 }
            r13.f37732a = r12     // Catch:{ Exception -> 0x0386 }
        L_0x0285:
            org.w3c.dom.Node r12 = r11.getNamedItem(r10)     // Catch:{ Exception -> 0x0386 }
            if (r12 == 0) goto L_0x0298
            com.utils.subtitle.converter.Time r13 = r8.f37719c     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = r12.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            int r12 = r1.d(r12, r3, r4)     // Catch:{ Exception -> 0x0386 }
            r13.f37732a = r12     // Catch:{ Exception -> 0x0386 }
            goto L_0x02b1
        L_0x0298:
            java.lang.String r12 = "dur"
            org.w3c.dom.Node r12 = r11.getNamedItem(r12)     // Catch:{ Exception -> 0x0386 }
            if (r12 == 0) goto L_0x02b3
            com.utils.subtitle.converter.Time r13 = r8.f37719c     // Catch:{ Exception -> 0x0386 }
            com.utils.subtitle.converter.Time r14 = r8.f37718b     // Catch:{ Exception -> 0x0386 }
            int r14 = r14.f37732a     // Catch:{ Exception -> 0x0386 }
            java.lang.String r12 = r12.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            int r12 = r1.d(r12, r3, r4)     // Catch:{ Exception -> 0x0386 }
            int r14 = r14 + r12
            r13.f37732a = r14     // Catch:{ Exception -> 0x0386 }
        L_0x02b1:
            r12 = 1
            goto L_0x02b4
        L_0x02b3:
            r12 = 0
        L_0x02b4:
            org.w3c.dom.Node r11 = r11.getNamedItem(r0)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x02ec
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r13 = r3.f37739g     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ Exception -> 0x0386 }
            com.utils.subtitle.converter.Style r13 = (com.utils.subtitle.converter.Style) r13     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x02cb
            r8.f37717a = r13     // Catch:{ Exception -> 0x0386 }
            goto L_0x02ec
        L_0x02cb:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0386 }
            r13.<init>()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = r3.f37742j     // Catch:{ Exception -> 0x0386 }
            r13.append(r14)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "unrecoginzed style referenced: "
            r13.append(r14)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = r11.getNodeValue()     // Catch:{ Exception -> 0x0386 }
            r13.append(r11)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = "\n\n"
            r13.append(r11)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r11 = r13.toString()     // Catch:{ Exception -> 0x0386 }
            r3.f37742j = r11     // Catch:{ Exception -> 0x0386 }
        L_0x02ec:
            org.w3c.dom.NodeList r9 = r9.getChildNodes()     // Catch:{ Exception -> 0x0386 }
            r11 = 0
        L_0x02f1:
            int r13 = r9.getLength()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = "<br />"
            if (r11 >= r13) goto L_0x034f
            org.w3c.dom.Node r13 = r9.item(r11)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r13.getNodeName()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = "#text"
            boolean r13 = r13.equals(r15)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x0329
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0386 }
            r13.<init>()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = r8.f37720d     // Catch:{ Exception -> 0x0386 }
            r13.append(r14)     // Catch:{ Exception -> 0x0386 }
            org.w3c.dom.Node r14 = r9.item(r11)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = r14.getTextContent()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r14 = r14.trim()     // Catch:{ Exception -> 0x0386 }
            r13.append(r14)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0386 }
            r8.f37720d = r13     // Catch:{ Exception -> 0x0386 }
            goto L_0x034c
        L_0x0329:
            org.w3c.dom.Node r13 = r9.item(r11)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r13.getNodeName()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = "br"
            boolean r13 = r13.equals(r15)     // Catch:{ Exception -> 0x0386 }
            if (r13 == 0) goto L_0x034c
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0386 }
            r13.<init>()     // Catch:{ Exception -> 0x0386 }
            java.lang.String r15 = r8.f37720d     // Catch:{ Exception -> 0x0386 }
            r13.append(r15)     // Catch:{ Exception -> 0x0386 }
            r13.append(r14)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0386 }
            r8.f37720d = r13     // Catch:{ Exception -> 0x0386 }
        L_0x034c:
            int r11 = r11 + 1
            goto L_0x02f1
        L_0x034f:
            java.lang.String r9 = r8.f37720d     // Catch:{ Exception -> 0x0386 }
            java.lang.String r9 = r9.replaceAll(r14, r2)     // Catch:{ Exception -> 0x0386 }
            java.lang.String r9 = r9.trim()     // Catch:{ Exception -> 0x0386 }
            boolean r9 = r9.isEmpty()     // Catch:{ Exception -> 0x0386 }
            if (r9 == 0) goto L_0x0360
            r12 = 0
        L_0x0360:
            if (r12 == 0) goto L_0x037e
            com.utils.subtitle.converter.Time r9 = r8.f37718b     // Catch:{ Exception -> 0x0386 }
            int r9 = r9.f37732a     // Catch:{ Exception -> 0x0386 }
        L_0x0366:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r11 = r3.f37741i     // Catch:{ Exception -> 0x0386 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0386 }
            boolean r11 = r11.containsKey(r12)     // Catch:{ Exception -> 0x0386 }
            if (r11 == 0) goto L_0x0375
            int r9 = r9 + 1
            goto L_0x0366
        L_0x0375:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r11 = r3.f37741i     // Catch:{ Exception -> 0x0386 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0386 }
            r11.put(r9, r8)     // Catch:{ Exception -> 0x0386 }
        L_0x037e:
            int r5 = r5 + 1
            goto L_0x024e
        L_0x0382:
            r0 = 1
            r3.f37745m = r0
            return r3
        L_0x0386:
            r0 = move-exception
            r0.printStackTrace()
            com.utils.subtitle.converter.FatalParsingException r2 = new com.utils.subtitle.converter.FatalParsingException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error during parsing: "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.converter.FormatTTML.a(java.lang.String, java.io.InputStream, java.lang.String):com.utils.subtitle.converter.TimedTextObject");
    }

    /* renamed from: e */
    public String[] b(TimedTextObject timedTextObject) {
        String str;
        String str2;
        if (!timedTextObject.f37745m) {
            return null;
        }
        ArrayList arrayList = new ArrayList(timedTextObject.f37739g.size() + 30 + timedTextObject.f37741i.size());
        arrayList.add(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        arrayList.add(1, "<tt xml:lang=\"" + timedTextObject.f37738f + "\" xmlns=\"http://www.w3.org/ns/ttml\" xmlns:tts=\"http://www.w3.org/ns/ttml#styling\">");
        arrayList.add(2, "\t<head>");
        arrayList.add(3, "\t\t<metadata xmlns:ttm=\"http://www.w3.org/ns/ttml#metadata\">");
        String str3 = timedTextObject.f37733a;
        if (str3 == null || str3.isEmpty()) {
            str = timedTextObject.f37737e;
        } else {
            str = timedTextObject.f37733a;
        }
        arrayList.add(4, "\t\t\t<ttm:title>" + str + "</ttm:title>");
        String str4 = timedTextObject.f37735c;
        int i2 = 5;
        if (str4 != null && !str4.isEmpty()) {
            arrayList.add(5, "\t\t\t<ttm:copyright>" + timedTextObject.f37735c + "</ttm:copyright>");
            i2 = 6;
        }
        String str5 = timedTextObject.f37736d;
        String str6 = "Converted by the Online Subtitle Converter developed by J. David Requejo\n";
        if (str5 != null && !str5.isEmpty()) {
            str6 = str6 + "\n Original file by: " + timedTextObject.f37736d + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        String str7 = timedTextObject.f37734b;
        if (str7 != null && !str7.isEmpty()) {
            str6 = str6 + timedTextObject.f37734b + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        int i3 = i2 + 1;
        arrayList.add(i2, "\t\t\t<ttm:desc>" + str6 + "\t\t\t</ttm:desc>");
        int i4 = i3 + 1;
        arrayList.add(i3, "\t\t</metadata>");
        int i5 = i4 + 1;
        arrayList.add(i4, "\t\t<styling>");
        for (Style next : timedTextObject.f37739g.values()) {
            String str8 = "\t\t\t<style xml:id=\"" + next.f37723a + "\"";
            if (next.f37726d != null) {
                str8 = str8 + " tts:color=\"#" + next.f37726d + "\"";
            }
            if (next.f37727e != null) {
                str8 = str8 + " tts:backgroundColor=\"#" + next.f37727e + "\"";
            }
            if (next.f37724b != null) {
                str8 = str8 + " tts:fontFamily=\"" + next.f37724b + "\"";
            }
            if (next.f37725c != null) {
                str8 = str8 + " tts:fontSize=\"" + next.f37725c + "\"";
            }
            if (next.f37729g) {
                str8 = str8 + " tts:fontStyle=\"italic\"";
            }
            if (next.f37730h) {
                str8 = str8 + " tts:fontWeight=\"bold\"";
            }
            String str9 = str8 + " tts:textAlign=\"";
            if (next.f37728f.contains(ViewProps.LEFT)) {
                str2 = str9 + "left\"";
            } else if (next.f37728f.contains(ViewProps.RIGHT)) {
                str2 = str9 + "rigth\"";
            } else {
                str2 = str9 + "center\"";
            }
            if (next.f37731i) {
                str2 = str2 + " tts:textDecoration=\"underline\"";
            }
            arrayList.add(i5, str2 + " />");
            i5++;
        }
        int i6 = i5 + 1;
        arrayList.add(i5, "\t\t</styling>");
        int i7 = i6 + 1;
        arrayList.add(i6, "\t</head>");
        int i8 = i7 + 1;
        arrayList.add(i7, "\t<body>");
        int i9 = i8 + 1;
        arrayList.add(i8, "\t\t<div>");
        for (Caption next2 : timedTextObject.f37741i.values()) {
            String str10 = ("\t\t\t<p begin=\"" + next2.f37718b.a("hh:mm:ss,ms").replace(',', '.') + "\"") + " end=\"" + next2.f37719c.a("hh:mm:ss,ms").replace(',', '.') + "\"";
            if (next2.f37717a != null) {
                str10 = str10 + " style=\"" + next2.f37717a.f37723a + "\"";
            }
            arrayList.add(i9, str10 + " >" + next2.f37720d + "</p>\n");
            i9++;
        }
        int i10 = i9 + 1;
        arrayList.add(i9, "\t\t</div>");
        int i11 = i10 + 1;
        arrayList.add(i10, "\t</body>");
        arrayList.add(i11, "</tt>");
        arrayList.add(i11 + 1, "");
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i12 = 0; i12 < size; i12++) {
            strArr[i12] = (String) arrayList.get(i12);
        }
        return strArr;
    }
}
