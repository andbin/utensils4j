package com.github.utensils4j.compare;

import static com.github.utensils4j.compare.Comparison.chain;
import static com.github.utensils4j.compare.Comparison.comparisonChain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Comparator;
import java.util.function.Consumer;

import org.assertj.core.api.AbstractIntegerAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ComparisonTest {
    private static final Asserter equal = new Asserter("=", a -> a.isEqualTo(0));
    private static final Asserter less = new Asserter("<", a -> a.isLessThan(0));
    private static final Asserter greater = new Asserter(">", a -> a.isGreaterThan(0));

    private static final byte B1 = 10;
    private static final byte B2 = 60;

    private static final char C1 = 'A';
    private static final char C2 = 'F';

    private static final short S1 = 10;
    private static final short S2 = 60;

    private static final int I1 = 10;
    private static final int I2 = 60;

    private static final long L1 = 10;
    private static final long L2 = 60;

    private static final float F1 = 10;
    private static final float F2 = 60;

    private static final double D1 = 10;
    private static final double D2 = 60;

    private static final Comparator<String> LEN_COMPARATOR = (a, b) ->
            Integer.compare(a.length(), b.length());

    @Test
    @DisplayName("comparisonChain")
    public void testComparisonChain() {
        assertThat(chain()).isSameAs(comparisonChain());
    }

    //-----------------------------------------------------------------------
    // accept
    //-----------------------------------------------------------------------
    static Arguments[] testAcceptProvider() {
        return new Arguments[] {
                arguments(0, equal),
                arguments(-1, less),
                arguments(1, greater),
        };
    }

    @DisplayName("accept")
    @ParameterizedTest(name = "{0} is {1}")
    @MethodSource("testAcceptProvider")
    public void testAccept(int result, Asserter asserter) {
        asserter.assertResult(chain().accept(result).accept(0));
    }


    //***********************************************************************


    //-----------------------------------------------------------------------
    // ascending (boolean)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingBooleanProvider() {
        return new Arguments[] {
                arguments(false, equal, false),
                arguments(true, equal, true),
                arguments(false, less, true),
                arguments(true, greater, false),
        };
    }

    @DisplayName("ascending(boolean, boolean)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingBooleanProvider")
    public void testAscendingBoolean(boolean left, Asserter asserter, boolean right) {
        asserter.assertResult(chain().ascending(left, right).ascending(true, true));
    }


    //-----------------------------------------------------------------------
    // ascending (byte)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingByteProvider() {
        return new Arguments[] {
                arguments(B1, equal, B1),
                arguments(B1, less, B2),
                arguments(B2, greater, B1),
        };
    }

    @DisplayName("ascending(byte, byte)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingByteProvider")
    public void testAscendingByte(byte left, Asserter asserter, byte right) {
        asserter.assertResult(chain().ascending(left, right).ascending(B1, B1));
    }


    //-----------------------------------------------------------------------
    // ascending (char)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingCharProvider() {
        return new Arguments[] {
                arguments(C1, equal, C1),
                arguments(C1, less, C2),
                arguments(C2, greater, C1),
        };
    }

    @DisplayName("ascending(char, char)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingCharProvider")
    public void testAscendingChar(char left, Asserter asserter, char right) {
        asserter.assertResult(chain().ascending(left, right).ascending(C1, C1));
    }


    //-----------------------------------------------------------------------
    // ascending (short)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingShortProvider() {
        return new Arguments[] {
                arguments(S1, equal, S1),
                arguments(S1, less, S2),
                arguments(S2, greater, S1),
        };
    }

    @DisplayName("ascending(short, short)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingShortProvider")
    public void testAscendingShort(short left, Asserter asserter, short right) {
        asserter.assertResult(chain().ascending(left, right).ascending(S1, S1));
    }


    //-----------------------------------------------------------------------
    // ascending (int)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingIntProvider() {
        return new Arguments[] {
                arguments(I1, equal, I1),
                arguments(I1, less, I2),
                arguments(I2, greater, I1),
        };
    }

    @DisplayName("ascending(int, int)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingIntProvider")
    public void testAscendingInt(int left, Asserter asserter, int right) {
        asserter.assertResult(chain().ascending(left, right).ascending(I1, I1));
    }


    //-----------------------------------------------------------------------
    // ascending (long)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingLongProvider() {
        return new Arguments[] {
                arguments(L1, equal, L1),
                arguments(L1, less, L2),
                arguments(L2, greater, L1),
        };
    }

    @DisplayName("ascending(long, long)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingLongProvider")
    public void testAscendingLong(long left, Asserter asserter, long right) {
        asserter.assertResult(chain().ascending(left, right).ascending(L1, L1));
    }


    //-----------------------------------------------------------------------
    // ascending (float)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingFloatProvider() {
        return new Arguments[] {
                arguments(F1, equal, F1),
                arguments(F1, less, F2),
                arguments(F2, greater, F1),
        };
    }

    @DisplayName("ascending(float, float)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingFloatProvider")
    public void testAscendingFloat(float left, Asserter asserter, float right) {
        asserter.assertResult(chain().ascending(left, right).ascending(F1, F1));
    }


    //-----------------------------------------------------------------------
    // ascending (double)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingDoubleProvider() {
        return new Arguments[] {
                arguments(D1, equal, D1),
                arguments(D1, less, D2),
                arguments(D2, greater, D1),
        };
    }

    @DisplayName("ascending(double, double)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingDoubleProvider")
    public void testAscendingDouble(double left, Asserter asserter, double right) {
        asserter.assertResult(chain().ascending(left, right).ascending(D1, D1));
    }


    //-----------------------------------------------------------------------
    // ascendingNullFirst
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingNullFirstProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, s("flag")),
                arguments("flag", less, "flash"),
                arguments("flash", greater, "flag"),
        };
    }

    @DisplayName("ascendingNullFirst(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingNullFirstProvider")
    public void testAscendingNullFirst(String left, Asserter asserter, String right) {
        asserter.assertResult(chain().ascendingNullFirst(left, right).ascendingNullFirst("", ""));
    }


    //-----------------------------------------------------------------------
    // ascendingNullLast
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingNullLastProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, s("flag")),
                arguments("flag", less, "flash"),
                arguments("flash", greater, "flag"),
        };
    }

    @DisplayName("ascendingNullLast(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingNullLastProvider")
    public void testAscendingNullLast(String left, Asserter asserter, String right) {
        asserter.assertResult(chain().ascendingNullLast(left, right).ascendingNullLast("", ""));
    }


    //-----------------------------------------------------------------------
    // ascendingNullFirst (with Comparator)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingNullFirstCompProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flat"),
                arguments("flash", less, "flagged"),
                arguments("flagged", greater, "flash"),
        };
    }

    @DisplayName("ascendingNullFirst(T, T, Comparator)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingNullFirstCompProvider")
    public void testAscendingNullFirstComp(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .ascendingNullFirst(left, right, LEN_COMPARATOR)
                .ascendingNullFirst("", "", LEN_COMPARATOR));
    }


    //-----------------------------------------------------------------------
    // ascendingNullLast (with Comparator)
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingNullLastCompProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flat"),
                arguments("flash", less, "flagged"),
                arguments("flagged", greater, "flash"),
        };
    }

    @DisplayName("ascendingNullLast(T, T, Comparator)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingNullLastCompProvider")
    public void testAscendingNullLastComp(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .ascendingNullLast(left, right, LEN_COMPARATOR)
                .ascendingNullLast("", "", LEN_COMPARATOR));
    }


    //-----------------------------------------------------------------------
    // ascendingIgnoringCaseNullFirst
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingIgnoringCaseNullFirstProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, "FLAG"),
                arguments("FLAG", less, "flash"),
                arguments("flash", greater, "FLAG"),
        };
    }

    @DisplayName("ascendingIgnoringCaseNullFirst(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingIgnoringCaseNullFirstProvider")
    public void testAscendingIgnoringCaseNullFirst(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .ascendingIgnoringCaseNullFirst(left, right)
                .ascendingIgnoringCaseNullFirst("", ""));
    }


    //-----------------------------------------------------------------------
    // ascendingIgnoringCaseNullLast
    //-----------------------------------------------------------------------
    static Arguments[] testAscendingIgnoringCaseNullLastProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, "FLAG"),
                arguments("FLAG", less, "flash"),
                arguments("flash", greater, "FLAG"),
        };
    }

    @DisplayName("ascendingIgnoringCaseNullLast(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testAscendingIgnoringCaseNullLastProvider")
    public void testAscendingIgnoringCaseNullLast(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .ascendingIgnoringCaseNullLast(left, right)
                .ascendingIgnoringCaseNullLast("", ""));
    }


    //***********************************************************************


    //-----------------------------------------------------------------------
    // descending (boolean)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingBooleanProvider() {
        return new Arguments[] {
                arguments(false, equal, false),
                arguments(true, equal, true),
                arguments(false, greater, true),
                arguments(true, less, false),
        };
    }

    @DisplayName("descending(boolean, boolean)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingBooleanProvider")
    public void testDescendingBoolean(boolean left, Asserter asserter, boolean right) {
        asserter.assertResult(chain().descending(left, right).descending(true, true));
    }


    //-----------------------------------------------------------------------
    // descending (byte)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingByteProvider() {
        return new Arguments[] {
                arguments(B1, equal, B1),
                arguments(B1, greater, B2),
                arguments(B2, less, B1),
        };
    }

    @DisplayName("descending(byte, byte)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingByteProvider")
    public void testDescendingByte(byte left, Asserter asserter, byte right) {
        asserter.assertResult(chain().descending(left, right).descending(B1, B1));
    }


    //-----------------------------------------------------------------------
    // descending (char)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingCharProvider() {
        return new Arguments[] {
                arguments(C1, equal, C1),
                arguments(C1, greater, C2),
                arguments(C2, less, C1),
        };
    }

    @DisplayName("descending(char, char)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingCharProvider")
    public void testDescendingChar(char left, Asserter asserter, char right) {
        asserter.assertResult(chain().descending(left, right).descending(C1, C1));
    }


    //-----------------------------------------------------------------------
    // descending (short)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingShortProvider() {
        return new Arguments[] {
                arguments(S1, equal, S1),
                arguments(S1, greater, S2),
                arguments(S2, less, S1),
        };
    }

    @DisplayName("descending(short, short)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingShortProvider")
    public void testDescendingShort(short left, Asserter asserter, short right) {
        asserter.assertResult(chain().descending(left, right).descending(S1, S1));
    }


    //-----------------------------------------------------------------------
    // descending (int)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingIntProvider() {
        return new Arguments[] {
                arguments(I1, equal, I1),
                arguments(I1, greater, I2),
                arguments(I2, less, I1),
        };
    }

    @DisplayName("descending(int, int)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingIntProvider")
    public void testDescendingInt(int left, Asserter asserter, int right) {
        asserter.assertResult(chain().descending(left, right).descending(I1, I1));
    }


    //-----------------------------------------------------------------------
    // descending (long)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingLongProvider() {
        return new Arguments[] {
                arguments(L1, equal, L1),
                arguments(L1, greater, L2),
                arguments(L2, less, L1),
        };
    }

    @DisplayName("descending(long, long)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingLongProvider")
    public void testDescendingLong(long left, Asserter asserter, long right) {
        asserter.assertResult(chain().descending(left, right).descending(L1, L1));
    }


    //-----------------------------------------------------------------------
    // descending (float)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingFloatProvider() {
        return new Arguments[] {
                arguments(F1, equal, F1),
                arguments(F1, greater, F2),
                arguments(F2, less, F1),
        };
    }

    @DisplayName("descending(float, float)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingFloatProvider")
    public void testDescendingFloat(float left, Asserter asserter, float right) {
        asserter.assertResult(chain().descending(left, right).descending(F1, F1));
    }


    //-----------------------------------------------------------------------
    // descending (double)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingDoubleProvider() {
        return new Arguments[] {
                arguments(D1, equal, D1),
                arguments(D1, greater, D2),
                arguments(D2, less, D1),
        };
    }

    @DisplayName("descending(double, double)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingDoubleProvider")
    public void testDescendingDouble(double left, Asserter asserter, double right) {
        asserter.assertResult(chain().descending(left, right).descending(D1, D1));
    }


    //-----------------------------------------------------------------------
    // descendingNullFirst
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingNullFirstProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, s("flag")),
                arguments("flag", greater, "flash"),
                arguments("flash", less, "flag"),
        };
    }

    @DisplayName("descendingNullFirst(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingNullFirstProvider")
    public void testDescendingNullFirst(String left, Asserter asserter, String right) {
        asserter.assertResult(chain().descendingNullFirst(left, right).descendingNullFirst("", ""));
    }


    //-----------------------------------------------------------------------
    // descendingNullLast
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingNullLastProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, s("flag")),
                arguments("flag", greater, "flash"),
                arguments("flash", less, "flag"),
        };
    }

    @DisplayName("descendingNullLast(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingNullLastProvider")
    public void testDescendingNullLast(String left, Asserter asserter, String right) {
        asserter.assertResult(chain().descendingNullLast(left, right).descendingNullLast("", ""));
    }


    //-----------------------------------------------------------------------
    // descendingNullFirst (with Comparator)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingNullFirstCompProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flat"),
                arguments("flash", greater, "flagged"),
                arguments("flagged", less, "flash"),
        };
    }

    @DisplayName("descendingNullFirst(T, T, Comparator)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingNullFirstCompProvider")
    public void testDescendingNullFirstComp(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .descendingNullFirst(left, right, LEN_COMPARATOR)
                .descendingNullFirst("", "", LEN_COMPARATOR));
    }


    //-----------------------------------------------------------------------
    // descendingNullLast (with Comparator)
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingNullLastCompProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flat"),
                arguments("flash", greater, "flagged"),
                arguments("flagged", less, "flash"),
        };
    }

    @DisplayName("descendingNullLast(T, T, Comparator)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingNullLastCompProvider")
    public void testDescendingNullLastComp(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .descendingNullLast(left, right, LEN_COMPARATOR)
                .descendingNullLast("", "", LEN_COMPARATOR));
    }


    //-----------------------------------------------------------------------
    // descendingIgnoringCaseNullFirst
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingIgnoringCaseNullFirstProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, greater, "flag"),
                arguments("flag", less, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, "FLAG"),
                arguments("FLAG", greater, "flash"),
                arguments("flash", less, "FLAG"),
        };
    }

    @DisplayName("descendingIgnoringCaseNullFirst(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingIgnoringCaseNullFirstProvider")
    public void testDescendingIgnoringCaseNullFirst(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .descendingIgnoringCaseNullFirst(left, right)
                .descendingIgnoringCaseNullFirst("", ""));
    }


    //-----------------------------------------------------------------------
    // descendingIgnoringCaseNullLast
    //-----------------------------------------------------------------------
    static Arguments[] testDescendingIgnoringCaseNullLastProvider() {
        return new Arguments[] {
                arguments(null, equal, null),
                arguments(null, less, "flag"),
                arguments("flag", greater, null),
                arguments("flag", equal, "flag"),
                arguments("flag", equal, "FLAG"),
                arguments("FLAG", greater, "flash"),
                arguments("flash", less, "FLAG"),
        };
    }

    @DisplayName("descendingIgnoringCaseNullLast(T, T)")
    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("testDescendingIgnoringCaseNullLastProvider")
    public void testDescendingIgnoringCaseNullLast(String left, Asserter asserter, String right) {
        asserter.assertResult(chain()
                .descendingIgnoringCaseNullLast(left, right)
                .descendingIgnoringCaseNullLast("", ""));
    }


    private static String s(String str) {
        return new String(str);
    }


    private static class Asserter {
        private final String op;
        private final Consumer<AbstractIntegerAssert<?>> assertConsumer;

        public Asserter(String op, Consumer<AbstractIntegerAssert<?>> assertConsumer) {
            this.op = op;
            this.assertConsumer = assertConsumer;
        }

        public void assertResult(Comparison comparison) {
            assertConsumer.accept(assertThat(comparison.result()));
            assertConsumer.accept(assertThat(-comparison.resultInverted()));
        }

        @Override
        public String toString() {
            return op;
        }
    }
}
