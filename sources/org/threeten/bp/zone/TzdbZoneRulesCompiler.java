package org.threeten.bp.zone;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import org.joda.time.DateTimeConstants;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;

final class TzdbZoneRulesCompiler {
    private static final DateTimeFormatter TIME_PARSER = new DateTimeFormatterBuilder().appendValue((TemporalField) ChronoField.HOUR_OF_DAY).optionalStart().appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
    private final SortedMap<String, ZoneRules> builtZones = new TreeMap();
    private Map<Object, Object> deduplicateMap = new HashMap();
    private final SortedMap<LocalDate, Byte> leapSeconds = new TreeMap();
    private final File leapSecondsFile;
    private final Map<String, String> links = new HashMap();
    private final Map<String, List<TZDBRule>> rules = new HashMap();
    private final List<File> sourceFiles;
    private final boolean verbose;
    private final String version;
    private final Map<String, List<TZDBZone>> zones = new HashMap();

    static final class LeapSecondRule {
        final LocalDate leapDate;
        byte secondAdjustment;

        public LeapSecondRule(LocalDate localDate, byte b2) {
            this.leapDate = localDate;
            this.secondAdjustment = b2;
        }
    }

    abstract class TZDBMonthDayTime {
        int adjustDays;
        boolean adjustForwards = true;
        int dayOfMonth = 1;
        DayOfWeek dayOfWeek;
        Month month = Month.JANUARY;
        LocalTime time = LocalTime.MIDNIGHT;
        ZoneOffsetTransitionRule.TimeDefinition timeDefinition = ZoneOffsetTransitionRule.TimeDefinition.WALL;

        TZDBMonthDayTime() {
        }

        /* access modifiers changed from: package-private */
        public void adjustToFowards(int i2) {
            int i3;
            if (!this.adjustForwards && (i3 = this.dayOfMonth) > 0) {
                LocalDate minusDays = LocalDate.of(i2, this.month, i3).minusDays(6);
                this.dayOfMonth = minusDays.getDayOfMonth();
                this.month = minusDays.getMonth();
                this.adjustForwards = true;
            }
        }
    }

    final class TZDBRule extends TZDBMonthDayTime {
        int endYear;
        int savingsAmount;
        int startYear;
        String text;

        TZDBRule() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void addToBuilder(ZoneRulesBuilder zoneRulesBuilder) {
            adjustToFowards(2004);
            zoneRulesBuilder.addRuleToWindow(this.startYear, this.endYear, this.month, this.dayOfMonth, this.dayOfWeek, this.time, this.adjustDays, this.timeDefinition, this.savingsAmount);
        }
    }

    final class TZDBZone extends TZDBMonthDayTime {
        Integer fixedSavingsSecs;
        String savingsRule;
        ZoneOffset standardOffset;
        String text;
        Year year;

        TZDBZone() {
            super();
        }

        private LocalDateTime toDateTime(int i2) {
            LocalDate localDate;
            adjustToFowards(i2);
            int i3 = this.dayOfMonth;
            if (i3 == -1) {
                int length = this.month.length(Year.isLeap((long) i2));
                this.dayOfMonth = length;
                localDate = LocalDate.of(i2, this.month, length);
                DayOfWeek dayOfWeek = this.dayOfWeek;
                if (dayOfWeek != null) {
                    localDate = localDate.with(TemporalAdjusters.previousOrSame(dayOfWeek));
                }
            } else {
                localDate = LocalDate.of(i2, this.month, i3);
                DayOfWeek dayOfWeek2 = this.dayOfWeek;
                if (dayOfWeek2 != null) {
                    localDate = localDate.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
                }
            }
            return LocalDateTime.of((LocalDate) TzdbZoneRulesCompiler.this.deduplicate(localDate.plusDays((long) this.adjustDays)), this.time);
        }

        /* access modifiers changed from: package-private */
        public ZoneRulesBuilder addToBuilder(ZoneRulesBuilder zoneRulesBuilder, Map<String, List<TZDBRule>> map) {
            Year year2 = this.year;
            if (year2 != null) {
                zoneRulesBuilder.addWindow(this.standardOffset, toDateTime(year2.getValue()), this.timeDefinition);
            } else {
                zoneRulesBuilder.addWindowForever(this.standardOffset);
            }
            Integer num = this.fixedSavingsSecs;
            if (num != null) {
                zoneRulesBuilder.setFixedSavingsToWindow(num.intValue());
            } else {
                List<TZDBRule> list = map.get(this.savingsRule);
                if (list != null) {
                    for (TZDBRule addToBuilder : list) {
                        addToBuilder.addToBuilder(zoneRulesBuilder);
                    }
                } else {
                    throw new IllegalArgumentException("Rule not found: " + this.savingsRule);
                }
            }
            return zoneRulesBuilder;
        }
    }

    public TzdbZoneRulesCompiler(String str, List<File> list, File file, boolean z2) {
        this.version = str;
        this.sourceFiles = list;
        this.leapSecondsFile = file;
        this.verbose = z2;
    }

    private void buildZoneRules() throws Exception {
        for (String next : this.zones.keySet()) {
            printVerbose("Building zone " + next);
            String str = (String) deduplicate(next);
            ZoneRulesBuilder zoneRulesBuilder = new ZoneRulesBuilder();
            for (TZDBZone addToBuilder : this.zones.get(str)) {
                zoneRulesBuilder = addToBuilder.addToBuilder(zoneRulesBuilder, this.rules);
            }
            this.builtZones.put(str, deduplicate(zoneRulesBuilder.toRules(str, this.deduplicateMap)));
        }
        for (String deduplicate : this.links.keySet()) {
            String str2 = (String) deduplicate(deduplicate);
            String str3 = this.links.get(str2);
            printVerbose("Linking alias " + str2 + " to " + str3);
            ZoneRules zoneRules = this.builtZones.get(str3);
            if (zoneRules == null) {
                String str4 = this.links.get(str3);
                printVerbose("Relinking alias " + str2 + " to " + str4);
                zoneRules = this.builtZones.get(str4);
                if (zoneRules == null) {
                    throw new IllegalArgumentException("Alias '" + str2 + "' links to invalid zone '" + str4 + "' for '" + this.version + "'");
                }
            }
            this.builtZones.put(str2, zoneRules);
        }
        this.builtZones.remove("UTC");
        this.builtZones.remove("GMT");
        this.builtZones.remove("GMT0");
        this.builtZones.remove("GMT+0");
        this.builtZones.remove("GMT-0");
    }

    private LocalDate getMostRecentLeapSecond() {
        if (this.leapSeconds.isEmpty()) {
            return null;
        }
        return this.leapSeconds.lastKey();
    }

    public static void main(String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2.length < 2) {
            outputHelp();
            return;
        }
        File file = null;
        File file2 = null;
        String str = null;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < strArr2.length) {
            String str2 = strArr2[i2];
            if (!str2.startsWith("-")) {
                break;
            }
            if ("-srcdir".equals(str2)) {
                if (file == null && (i2 = i2 + 1) < strArr2.length) {
                    file = new File(strArr2[i2]);
                }
                outputHelp();
                return;
            } else if ("-dstdir".equals(str2)) {
                if (file2 == null && (i2 = i2 + 1) < strArr2.length) {
                    file2 = new File(strArr2[i2]);
                }
                outputHelp();
                return;
            } else if ("-version".equals(str2)) {
                if (str == null && (i2 = i2 + 1) < strArr2.length) {
                    str = strArr2[i2];
                }
                outputHelp();
                return;
            } else if (!"-unpacked".equals(str2)) {
                if ("-verbose".equals(str2)) {
                    if (!z3) {
                        z3 = true;
                    }
                } else if (!"-help".equals(str2)) {
                    System.out.println("Unrecognised option: " + str2);
                }
                outputHelp();
                return;
            } else if (!z2) {
                z2 = true;
            } else {
                outputHelp();
                return;
            }
            i2++;
        }
        if (file == null) {
            System.out.println("Source directory must be specified using -srcdir: " + file);
        } else if (!file.isDirectory()) {
            System.out.println("Source does not exist or is not a directory: " + file);
        } else {
            if (file2 == null) {
                file2 = file;
            }
            List asList = Arrays.asList(Arrays.copyOfRange(strArr2, i2, strArr2.length));
            if (asList.isEmpty()) {
                System.out.println("Source filenames not specified, using default set");
                System.out.println("(africa antarctica asia australasia backward etcetera europe northamerica southamerica)");
                asList = Arrays.asList(new String[]{"africa", "antarctica", "asia", "australasia", "backward", "etcetera", "europe", "northamerica", "southamerica"});
            }
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                File file3 = new File(file, str);
                if (!file3.isDirectory()) {
                    System.out.println("Version does not represent a valid source directory : " + file3);
                    return;
                }
                arrayList.add(file3);
            } else {
                for (File file4 : file.listFiles()) {
                    if (file4.isDirectory() && file4.getName().matches("[12][0-9][0-9][0-9][A-Za-z0-9._-]+")) {
                        arrayList.add(file4);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                System.out.println("Source directory contains no valid source folders: " + file);
            } else if (!file2.exists() && !file2.mkdirs()) {
                System.out.println("Destination directory could not be created: " + file2);
            } else if (!file2.isDirectory()) {
                System.out.println("Destination is not a directory: " + file2);
            } else {
                process(arrayList, asList, file2, z2, z3);
            }
        }
    }

    private boolean matches(String str, String str2) {
        return str.startsWith(str2.substring(0, 3)) && str2.startsWith(str) && str.length() <= str2.length();
    }

    private static void outputFile(File file, String str, SortedMap<String, ZoneRules> sortedMap, SortedMap<LocalDate, Byte> sortedMap2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(str, sortedMap);
        outputFile(file, treeMap, new TreeSet(sortedMap.keySet()), new HashSet(sortedMap.values()), sortedMap2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[Catch:{ Exception -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void outputFilesDat(java.io.File r1, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> r2, java.util.Set<java.lang.String> r3, java.util.Set<org.threeten.bp.zone.ZoneRules> r4, java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> r5) {
        /*
            java.io.File r5 = new java.io.File
            java.lang.String r0 = "TZDB.dat"
            r5.<init>(r1, r0)
            r5.delete()
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0019 }
            r0.<init>(r5)     // Catch:{ all -> 0x0019 }
            outputTzdbDat(r0, r2, r3, r4)     // Catch:{ all -> 0x0017 }
            r0.close()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0044
        L_0x0017:
            r1 = move-exception
            goto L_0x001c
        L_0x0019:
            r2 = move-exception
            r0 = r1
            r1 = r2
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0021:
            throw r1     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed: "
            r3.append(r4)
            java.lang.String r4 = r1.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            r1.printStackTrace()
            r1 = 1
            java.lang.System.exit(r1)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFilesDat(java.io.File, java.util.Map, java.util.Set, java.util.Set, java.util.SortedMap):void");
    }

    private static void outputHelp() {
        System.out.println("Usage: TzdbZoneRulesCompiler <options> <tzdb source filenames>");
        System.out.println("where options include:");
        System.out.println("   -srcdir <directory>   Where to find source directories (required)");
        System.out.println("   -dstdir <directory>   Where to output generated files (default srcdir)");
        System.out.println("   -version <version>    Specify the version, such as 2009a (optional)");
        System.out.println("   -unpacked             Generate dat files without jar files");
        System.out.println("   -help                 Print this usage message");
        System.out.println("   -verbose              Output verbose information during compilation");
        System.out.println(" There must be one directory for each version in srcdir");
        System.out.println(" Each directory must have the name of the version, such as 2009a");
        System.out.println(" Each directory must contain the unpacked tzdb files, such as asia or europe");
        System.out.println(" Directories must match the regex [12][0-9][0-9][0-9][A-Za-z0-9._-]+");
        System.out.println(" There will be one jar file for each version and one combined jar in dstdir");
        System.out.println(" If the version is specified, only that version is processed");
    }

    private static void outputTzdbDat(OutputStream outputStream, Map<String, SortedMap<String, ZoneRules>> map, Set<String> set, Set<ZoneRules> set2) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(1);
        dataOutputStream.writeUTF("TZDB");
        String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
        dataOutputStream.writeShort(strArr.length);
        for (String writeUTF : strArr) {
            dataOutputStream.writeUTF(writeUTF);
        }
        String[] strArr2 = (String[]) set.toArray(new String[set.size()]);
        dataOutputStream.writeShort(strArr2.length);
        for (String writeUTF2 : strArr2) {
            dataOutputStream.writeUTF(writeUTF2);
        }
        ArrayList<ZoneRules> arrayList = new ArrayList<>(set2);
        dataOutputStream.writeShort(arrayList.size());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        for (ZoneRules write : arrayList) {
            byteArrayOutputStream.reset();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            Ser.write(write, dataOutputStream2);
            dataOutputStream2.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.writeShort(byteArray.length);
            dataOutputStream.write(byteArray);
        }
        for (String next : map.keySet()) {
            dataOutputStream.writeShort(map.get(next).size());
            for (Map.Entry entry : map.get(next).entrySet()) {
                int binarySearch = Arrays.binarySearch(strArr2, entry.getKey());
                int indexOf = arrayList.indexOf(entry.getValue());
                dataOutputStream.writeShort(binarySearch);
                dataOutputStream.writeShort(indexOf);
            }
        }
        dataOutputStream.flush();
    }

    private static void outputTzdbEntry(JarOutputStream jarOutputStream, Map<String, SortedMap<String, ZoneRules>> map, Set<String> set, Set<ZoneRules> set2) {
        try {
            jarOutputStream.putNextEntry(new ZipEntry("org/threeten/bp/TZDB.dat"));
            outputTzdbDat(jarOutputStream, map, set, set2);
            jarOutputStream.closeEntry();
        } catch (Exception e2) {
            PrintStream printStream = System.out;
            printStream.println("Failed: " + e2.toString());
            e2.printStackTrace();
            System.exit(1);
        }
    }

    private DayOfWeek parseDayOfWeek(String str) {
        String lowerCase = str.toLowerCase();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (matches(lowerCase, dayOfWeek.name().toLowerCase())) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException("Unknown day-of-week: " + lowerCase);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseFile(java.io.File r9) throws java.lang.Exception {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x012b, all -> 0x0129 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x012b, all -> 0x0129 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x012b, all -> 0x0129 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x012b, all -> 0x0129 }
            r3 = r1
            r4 = r3
        L_0x000e:
            java.lang.String r4 = r2.readLine()     // Catch:{ Exception -> 0x0127 }
            if (r4 == 0) goto L_0x0123
            r5 = 35
            int r5 = r4.indexOf(r5)     // Catch:{ Exception -> 0x0127 }
            r6 = 0
            if (r5 < 0) goto L_0x0021
            java.lang.String r4 = r4.substring(r6, r5)     // Catch:{ Exception -> 0x0127 }
        L_0x0021:
            java.lang.String r5 = r4.trim()     // Catch:{ Exception -> 0x0127 }
            int r5 = r5.length()     // Catch:{ Exception -> 0x0127 }
            if (r5 != 0) goto L_0x002d
            goto L_0x011f
        L_0x002d:
            java.util.StringTokenizer r5 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x0127 }
            java.lang.String r7 = " \t"
            r5.<init>(r4, r7)     // Catch:{ Exception -> 0x0127 }
            if (r3 == 0) goto L_0x004f
            char r6 = r4.charAt(r6)     // Catch:{ Exception -> 0x0127 }
            boolean r6 = java.lang.Character.isWhitespace(r6)     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x004f
            boolean r6 = r5.hasMoreTokens()     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x004f
            boolean r5 = r8.parseZoneLine(r5, r3)     // Catch:{ Exception -> 0x0127 }
            if (r5 == 0) goto L_0x011f
        L_0x004c:
            r3 = r1
            goto L_0x011f
        L_0x004f:
            boolean r6 = r5.hasMoreTokens()     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x011f
            java.lang.String r3 = r5.nextToken()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "Zone"
            boolean r6 = r3.equals(r6)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r7 = ", line: "
            if (r6 == 0) goto L_0x00a1
            int r3 = r5.countTokens()     // Catch:{ Exception -> 0x0127 }
            r6 = 3
            if (r3 < r6) goto L_0x007f
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0127 }
            r3.<init>()     // Catch:{ Exception -> 0x0127 }
            java.util.Map<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler$TZDBZone>> r6 = r8.zones     // Catch:{ Exception -> 0x0127 }
            java.lang.String r7 = r5.nextToken()     // Catch:{ Exception -> 0x0127 }
            r6.put(r7, r3)     // Catch:{ Exception -> 0x0127 }
            boolean r5 = r8.parseZoneLine(r5, r3)     // Catch:{ Exception -> 0x0127 }
            if (r5 == 0) goto L_0x011f
            goto L_0x004c
        L_0x007f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0127 }
            r1.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Zone line in file: "
            r1.append(r3)     // Catch:{ Exception -> 0x0127 }
            r1.append(r9)     // Catch:{ Exception -> 0x0127 }
            r1.append(r7)     // Catch:{ Exception -> 0x0127 }
            r1.append(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0127 }
            r8.printVerbose(r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Zone line"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0127 }
            throw r1     // Catch:{ Exception -> 0x0127 }
        L_0x00a1:
            java.lang.String r6 = "Rule"
            boolean r6 = r3.equals(r6)     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x00d7
            int r3 = r5.countTokens()     // Catch:{ Exception -> 0x0127 }
            r6 = 9
            if (r3 < r6) goto L_0x00b5
            r8.parseRuleLine(r5)     // Catch:{ Exception -> 0x0127 }
            goto L_0x004c
        L_0x00b5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0127 }
            r1.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Rule line in file: "
            r1.append(r3)     // Catch:{ Exception -> 0x0127 }
            r1.append(r9)     // Catch:{ Exception -> 0x0127 }
            r1.append(r7)     // Catch:{ Exception -> 0x0127 }
            r1.append(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0127 }
            r8.printVerbose(r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Rule line"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0127 }
            throw r1     // Catch:{ Exception -> 0x0127 }
        L_0x00d7:
            java.lang.String r6 = "Link"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0127 }
            if (r3 == 0) goto L_0x0117
            int r3 = r5.countTokens()     // Catch:{ Exception -> 0x0127 }
            r6 = 2
            if (r3 < r6) goto L_0x00f5
            java.lang.String r3 = r5.nextToken()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = r5.nextToken()     // Catch:{ Exception -> 0x0127 }
            java.util.Map<java.lang.String, java.lang.String> r6 = r8.links     // Catch:{ Exception -> 0x0127 }
            r6.put(r5, r3)     // Catch:{ Exception -> 0x0127 }
            goto L_0x004c
        L_0x00f5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0127 }
            r1.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Link line in file: "
            r1.append(r3)     // Catch:{ Exception -> 0x0127 }
            r1.append(r9)     // Catch:{ Exception -> 0x0127 }
            r1.append(r7)     // Catch:{ Exception -> 0x0127 }
            r1.append(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0127 }
            r8.printVerbose(r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Invalid Link line"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0127 }
            throw r1     // Catch:{ Exception -> 0x0127 }
        L_0x0117:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "Unknown line"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0127 }
            throw r1     // Catch:{ Exception -> 0x0127 }
        L_0x011f:
            int r0 = r0 + 1
            goto L_0x000e
        L_0x0123:
            r2.close()
            return
        L_0x0127:
            r1 = move-exception
            goto L_0x012f
        L_0x0129:
            r9 = move-exception
            goto L_0x015d
        L_0x012b:
            r2 = move-exception
            r4 = r1
            r1 = r2
            r2 = r4
        L_0x012f:
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            r5.<init>()     // Catch:{ all -> 0x015b }
            java.lang.String r6 = "Failed while processing file '"
            r5.append(r6)     // Catch:{ all -> 0x015b }
            r5.append(r9)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "' on line "
            r5.append(r9)     // Catch:{ all -> 0x015b }
            r5.append(r0)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = " '"
            r5.append(r9)     // Catch:{ all -> 0x015b }
            r5.append(r4)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "'"
            r5.append(r9)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x015b }
            r3.<init>(r9, r1)     // Catch:{ all -> 0x015b }
            throw r3     // Catch:{ all -> 0x015b }
        L_0x015b:
            r9 = move-exception
            r1 = r2
        L_0x015d:
            if (r1 == 0) goto L_0x0162
            r1.close()
        L_0x0162:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesCompiler.parseFile(java.io.File):void");
    }

    private void parseFiles() throws Exception {
        for (File next : this.sourceFiles) {
            printVerbose("Parsing file: " + next);
            parseFile(next);
        }
    }

    private LeapSecondRule parseLeapSecondRule(String str) {
        byte b2;
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t");
        if (!stringTokenizer.nextToken().equals("Leap")) {
            throw new IllegalArgumentException("Unknown line");
        } else if (stringTokenizer.countTokens() >= 6) {
            LocalDate of = LocalDate.of(Integer.parseInt(stringTokenizer.nextToken()), parseMonth(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            String nextToken = stringTokenizer.nextToken();
            String nextToken2 = stringTokenizer.nextToken();
            if (nextToken2.equals("+")) {
                if ("23:59:60".equals(nextToken)) {
                    b2 = 1;
                } else {
                    throw new IllegalArgumentException("Leap seconds can only be inserted at 23:59:60 - Date:" + of);
                }
            } else if (!nextToken2.equals("-")) {
                throw new IllegalArgumentException("Invalid adjustment '" + nextToken2 + "' in leap second rule for " + of);
            } else if ("23:59:59".equals(nextToken)) {
                b2 = -1;
            } else {
                throw new IllegalArgumentException("Leap seconds can only be removed at 23:59:59 - Date:" + of);
            }
            String nextToken3 = stringTokenizer.nextToken();
            if ("S".equalsIgnoreCase(nextToken3)) {
                return new LeapSecondRule(of, b2);
            }
            throw new IllegalArgumentException("Only stationary ('S') leap seconds are supported, not '" + nextToken3 + "'");
        } else {
            printVerbose("Invalid leap second line in file: " + this.leapSecondsFile + ", line: " + str);
            throw new IllegalArgumentException("Invalid leap second line");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[SYNTHETIC, Splitter:B:27:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseLeapSecondsFile() throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Parsing leap second file: "
            r0.append(r1)
            java.io.File r1 = r7.leapSecondsFile
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.printVerbose(r0)
            r0 = 1
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.io.File r4 = r7.leapSecondsFile     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r3.<init>(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
        L_0x0024:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x005a }
            if (r1 == 0) goto L_0x0056
            r3 = 35
            int r3 = r1.indexOf(r3)     // Catch:{ Exception -> 0x005a }
            if (r3 < 0) goto L_0x0037
            r4 = 0
            java.lang.String r1 = r1.substring(r4, r3)     // Catch:{ Exception -> 0x005a }
        L_0x0037:
            java.lang.String r3 = r1.trim()     // Catch:{ Exception -> 0x005a }
            int r3 = r3.length()     // Catch:{ Exception -> 0x005a }
            if (r3 != 0) goto L_0x0042
            goto L_0x0053
        L_0x0042:
            org.threeten.bp.zone.TzdbZoneRulesCompiler$LeapSecondRule r3 = r7.parseLeapSecondRule(r1)     // Catch:{ Exception -> 0x005a }
            java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> r4 = r7.leapSeconds     // Catch:{ Exception -> 0x005a }
            org.threeten.bp.LocalDate r5 = r3.leapDate     // Catch:{ Exception -> 0x005a }
            byte r3 = r3.secondAdjustment     // Catch:{ Exception -> 0x005a }
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)     // Catch:{ Exception -> 0x005a }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x005a }
        L_0x0053:
            int r0 = r0 + 1
            goto L_0x0024
        L_0x0056:
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            return
        L_0x005a:
            r3 = move-exception
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            goto L_0x0090
        L_0x005e:
            r3 = move-exception
            r2 = r1
        L_0x0060:
            java.lang.Exception r4 = new java.lang.Exception     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r5.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "Failed while processing file '"
            r5.append(r6)     // Catch:{ all -> 0x008e }
            java.io.File r6 = r7.leapSecondsFile     // Catch:{ all -> 0x008e }
            r5.append(r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "' on line "
            r5.append(r6)     // Catch:{ all -> 0x008e }
            r5.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = " '"
            r5.append(r0)     // Catch:{ all -> 0x008e }
            r5.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "'"
            r5.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x008e }
            r4.<init>(r0, r3)     // Catch:{ all -> 0x008e }
            throw r4     // Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception
            r1 = r2
        L_0x0090:
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesCompiler.parseLeapSecondsFile():void");
    }

    private Month parseMonth(String str) {
        String lowerCase = str.toLowerCase();
        for (Month month : Month.values()) {
            if (matches(lowerCase, month.name().toLowerCase())) {
                return month;
            }
        }
        throw new IllegalArgumentException("Unknown month: " + lowerCase);
    }

    private void parseMonthDayTime(StringTokenizer stringTokenizer, TZDBMonthDayTime tZDBMonthDayTime) {
        tZDBMonthDayTime.month = parseMonth(stringTokenizer.nextToken());
        if (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.startsWith("last")) {
                tZDBMonthDayTime.dayOfMonth = -1;
                tZDBMonthDayTime.dayOfWeek = parseDayOfWeek(nextToken.substring(4));
                tZDBMonthDayTime.adjustForwards = false;
            } else {
                int indexOf = nextToken.indexOf(">=");
                if (indexOf > 0) {
                    tZDBMonthDayTime.dayOfWeek = parseDayOfWeek(nextToken.substring(0, indexOf));
                    nextToken = nextToken.substring(indexOf + 2);
                } else {
                    int indexOf2 = nextToken.indexOf("<=");
                    if (indexOf2 > 0) {
                        tZDBMonthDayTime.dayOfWeek = parseDayOfWeek(nextToken.substring(0, indexOf2));
                        tZDBMonthDayTime.adjustForwards = false;
                        nextToken = nextToken.substring(indexOf2 + 2);
                    }
                }
                tZDBMonthDayTime.dayOfMonth = Integer.parseInt(nextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                String nextToken2 = stringTokenizer.nextToken();
                int parseSecs = parseSecs(nextToken2);
                tZDBMonthDayTime.time = (LocalTime) deduplicate(LocalTime.ofSecondOfDay((long) Jdk8Methods.floorMod(parseSecs, (int) DateTimeConstants.SECONDS_PER_DAY)));
                tZDBMonthDayTime.adjustDays = Jdk8Methods.floorDiv(parseSecs, (int) DateTimeConstants.SECONDS_PER_DAY);
                tZDBMonthDayTime.timeDefinition = parseTimeDefinition(nextToken2.charAt(nextToken2.length() - 1));
            }
        }
    }

    private ZoneOffset parseOffset(String str) {
        return ZoneOffset.ofTotalSeconds(parseSecs(str));
    }

    private String parseOptional(String str) {
        if (str.equals("-")) {
            return null;
        }
        return str;
    }

    private int parsePeriod(String str) {
        return parseSecs(str);
    }

    private void parseRuleLine(StringTokenizer stringTokenizer) {
        TZDBRule tZDBRule = new TZDBRule();
        String nextToken = stringTokenizer.nextToken();
        if (!this.rules.containsKey(nextToken)) {
            this.rules.put(nextToken, new ArrayList());
        }
        this.rules.get(nextToken).add(tZDBRule);
        tZDBRule.startYear = parseYear(stringTokenizer.nextToken(), 0);
        int parseYear = parseYear(stringTokenizer.nextToken(), tZDBRule.startYear);
        tZDBRule.endYear = parseYear;
        if (tZDBRule.startYear <= parseYear) {
            parseOptional(stringTokenizer.nextToken());
            parseMonthDayTime(stringTokenizer, tZDBRule);
            tZDBRule.savingsAmount = parsePeriod(stringTokenizer.nextToken());
            tZDBRule.text = parseOptional(stringTokenizer.nextToken());
            return;
        }
        throw new IllegalArgumentException("Year order invalid: " + tZDBRule.startYear + " > " + tZDBRule.endYear);
    }

    private int parseSecs(String str) {
        Long l2;
        long j2;
        if (str.equals("-")) {
            return 0;
        }
        boolean startsWith = str.startsWith("-");
        ParsePosition parsePosition = new ParsePosition(startsWith ? 1 : 0);
        TemporalAccessor parseUnresolved = TIME_PARSER.parseUnresolved(str, parsePosition);
        if (parseUnresolved == null || parsePosition.getErrorIndex() >= 0) {
            throw new IllegalArgumentException(str);
        }
        long j3 = parseUnresolved.getLong(ChronoField.HOUR_OF_DAY);
        ChronoField chronoField = ChronoField.MINUTE_OF_HOUR;
        Long l3 = null;
        if (parseUnresolved.isSupported(chronoField)) {
            l2 = Long.valueOf(parseUnresolved.getLong(chronoField));
        } else {
            l2 = null;
        }
        ChronoField chronoField2 = ChronoField.SECOND_OF_MINUTE;
        if (parseUnresolved.isSupported(chronoField2)) {
            l3 = Long.valueOf(parseUnresolved.getLong(chronoField2));
        }
        long j4 = j3 * 60 * 60;
        long j5 = 0;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = 0;
        }
        Long.signum(j2);
        long j6 = j4 + (j2 * 60);
        if (l3 != null) {
            j5 = l3.longValue();
        }
        int i2 = (int) (j6 + j5);
        if (startsWith) {
            return -i2;
        }
        return i2;
    }

    private ZoneOffsetTransitionRule.TimeDefinition parseTimeDefinition(char c2) {
        if (c2 != 'G') {
            if (c2 != 'S') {
                if (!(c2 == 'U' || c2 == 'Z' || c2 == 'g')) {
                    if (c2 != 's') {
                        if (!(c2 == 'u' || c2 == 'z')) {
                            return ZoneOffsetTransitionRule.TimeDefinition.WALL;
                        }
                    }
                }
            }
            return ZoneOffsetTransitionRule.TimeDefinition.STANDARD;
        }
        return ZoneOffsetTransitionRule.TimeDefinition.UTC;
    }

    private int parseYear(String str, int i2) {
        String lowerCase = str.toLowerCase();
        if (matches(lowerCase, "minimum")) {
            return Year.MIN_VALUE;
        }
        if (matches(lowerCase, "maximum")) {
            return Year.MAX_VALUE;
        }
        if (lowerCase.equals("only")) {
            return i2;
        }
        return Integer.parseInt(lowerCase);
    }

    private boolean parseZoneLine(StringTokenizer stringTokenizer, List<TZDBZone> list) {
        TZDBZone tZDBZone = new TZDBZone();
        list.add(tZDBZone);
        tZDBZone.standardOffset = parseOffset(stringTokenizer.nextToken());
        String parseOptional = parseOptional(stringTokenizer.nextToken());
        if (parseOptional == null) {
            tZDBZone.fixedSavingsSecs = 0;
            tZDBZone.savingsRule = null;
        } else {
            try {
                tZDBZone.fixedSavingsSecs = Integer.valueOf(parsePeriod(parseOptional));
                tZDBZone.savingsRule = null;
            } catch (Exception unused) {
                tZDBZone.fixedSavingsSecs = null;
                tZDBZone.savingsRule = parseOptional;
            }
        }
        tZDBZone.text = stringTokenizer.nextToken();
        if (!stringTokenizer.hasMoreTokens()) {
            return true;
        }
        tZDBZone.year = Year.of(Integer.parseInt(stringTokenizer.nextToken()));
        if (stringTokenizer.hasMoreTokens()) {
            parseMonthDayTime(stringTokenizer, tZDBZone);
        }
        return false;
    }

    private void printVerbose(String str) {
        if (this.verbose) {
            System.out.println(str);
        }
    }

    private static void process(List<File> list, List<String> list2, File file, boolean z2, boolean z3) {
        File file2 = file;
        boolean z4 = z3;
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        TreeSet treeSet = new TreeSet();
        HashSet hashSet = new HashSet();
        SortedMap<LocalDate, Byte> sortedMap = null;
        for (File next : list) {
            ArrayList arrayList = new ArrayList();
            for (String file3 : list2) {
                File file4 = new File(next, file3);
                if (file4.exists()) {
                    arrayList.add(file4);
                }
            }
            if (!arrayList.isEmpty()) {
                File file5 = new File(next, "leapseconds");
                if (!file5.exists()) {
                    PrintStream printStream = System.out;
                    printStream.println("Version " + next.getName() + " does not include leap seconds information.");
                    file5 = null;
                }
                String name = next.getName();
                TzdbZoneRulesCompiler tzdbZoneRulesCompiler = new TzdbZoneRulesCompiler(name, arrayList, file5, z4);
                tzdbZoneRulesCompiler.setDeduplicateMap(hashMap);
                try {
                    tzdbZoneRulesCompiler.compile();
                    SortedMap<String, ZoneRules> zones2 = tzdbZoneRulesCompiler.getZones();
                    SortedMap<LocalDate, Byte> leapSeconds2 = tzdbZoneRulesCompiler.getLeapSeconds();
                    if (!z2) {
                        File file6 = new File(file2, "threeten-TZDB-" + name + ".jar");
                        if (z4) {
                            PrintStream printStream2 = System.out;
                            printStream2.println("Outputting file: " + file6);
                        }
                        outputFile(file6, name, zones2, leapSeconds2);
                    }
                    treeMap.put(name, zones2);
                    treeSet.addAll(zones2.keySet());
                    hashSet.addAll(zones2.values());
                    if (tzdbZoneRulesCompiler.getMostRecentLeapSecond() != null && (sortedMap == null || tzdbZoneRulesCompiler.getMostRecentLeapSecond().compareTo((ChronoLocalDate) sortedMap.lastKey()) > 0)) {
                        sortedMap = leapSeconds2;
                    }
                } catch (Exception e2) {
                    PrintStream printStream3 = System.out;
                    printStream3.println("Failed: " + e2.toString());
                    e2.printStackTrace();
                    System.exit(1);
                }
            }
        }
        if (z2) {
            if (z4) {
                PrintStream printStream4 = System.out;
                printStream4.println("Outputting combined files: " + file2);
            }
            outputFilesDat(file2, treeMap, treeSet, hashSet, sortedMap);
            return;
        }
        File file7 = new File(file2, "threeten-TZDB-all.jar");
        if (z4) {
            PrintStream printStream5 = System.out;
            printStream5.println("Outputting combined file: " + file7);
        }
        outputFile(file7, treeMap, treeSet, hashSet, sortedMap);
    }

    public void compile() throws Exception {
        printVerbose("Compiling TZDB version " + this.version);
        parseFiles();
        parseLeapSecondsFile();
        buildZoneRules();
        printVerbose("Compiled TZDB version " + this.version);
    }

    /* access modifiers changed from: package-private */
    public <T> T deduplicate(T t2) {
        if (!this.deduplicateMap.containsKey(t2)) {
            this.deduplicateMap.put(t2, t2);
        }
        return this.deduplicateMap.get(t2);
    }

    public SortedMap<LocalDate, Byte> getLeapSeconds() {
        return this.leapSeconds;
    }

    public SortedMap<String, ZoneRules> getZones() {
        return this.builtZones;
    }

    /* access modifiers changed from: package-private */
    public void setDeduplicateMap(Map<Object, Object> map) {
        this.deduplicateMap = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A[SYNTHETIC, Splitter:B:16:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC, Splitter:B:20:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void outputFile(java.io.File r2, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> r3, java.util.Set<java.lang.String> r4, java.util.Set<org.threeten.bp.zone.ZoneRules> r5, java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> r6) {
        /*
            r6 = 0
            java.util.jar.JarOutputStream r0 = new java.util.jar.JarOutputStream     // Catch:{ Exception -> 0x001a }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001a }
            r0.<init>(r1)     // Catch:{ Exception -> 0x001a }
            outputTzdbEntry(r0, r3, r4, r5)     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0041
        L_0x0012:
            r2 = move-exception
            r6 = r0
            goto L_0x0042
        L_0x0015:
            r2 = move-exception
            r6 = r0
            goto L_0x001b
        L_0x0018:
            r2 = move-exception
            goto L_0x0042
        L_0x001a:
            r2 = move-exception
        L_0x001b:
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0018 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0018 }
            r4.<init>()     // Catch:{ all -> 0x0018 }
            java.lang.String r5 = "Failed: "
            r4.append(r5)     // Catch:{ all -> 0x0018 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0018 }
            r4.append(r5)     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0018 }
            r3.println(r4)     // Catch:{ all -> 0x0018 }
            r2.printStackTrace()     // Catch:{ all -> 0x0018 }
            r2 = 1
            java.lang.System.exit(r2)     // Catch:{ all -> 0x0018 }
            if (r6 == 0) goto L_0x0041
            r6.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            return
        L_0x0042:
            if (r6 == 0) goto L_0x0047
            r6.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFile(java.io.File, java.util.Map, java.util.Set, java.util.Set, java.util.SortedMap):void");
    }
}
