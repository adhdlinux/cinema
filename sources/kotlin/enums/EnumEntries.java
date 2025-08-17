package kotlin.enums;

import java.lang.Enum;
import java.util.List;
import kotlin.jvm.internal.markers.KMappedMarker;

public interface EnumEntries<E extends Enum<E>> extends List<E>, KMappedMarker {
}
