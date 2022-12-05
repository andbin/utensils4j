package com.github.utensils4j.compare;

import java.util.Comparator;

/**
 * An utility class to create a comparison "chain", typically used in
 * {@code Comparable} or {@code Comparator} implementations.
 *
 * @author Andrea Binello
 */
public abstract class Comparison {
    private static final Comparison ACTIVE = new Active();
    private static final Comparison LESS = new Inactive(-1);
    private static final Comparison GREATER = new Inactive(1);

    public static Comparison chain() {
        return ACTIVE;
    }

    public static Comparison comparisonChain() {
        return ACTIVE;
    }

    public abstract Comparison accept(int result);

    /**
     * Compares two {@code boolean} values. The predefined "active" implementation
     * uses {@link Boolean#compare} to compare {@code left} with {@code right}.
     *
     * @param left   the left value
     * @param right  the right value
     */
    public abstract Comparison ascending(boolean left, boolean right);

    public abstract Comparison ascending(byte left, byte right);

    public abstract Comparison ascending(char left, char right);

    public abstract Comparison ascending(short left, short right);

    public abstract Comparison ascending(int left, int right);

    public abstract Comparison ascending(long left, long right);

    public abstract Comparison ascending(float left, float right);

    public abstract Comparison ascending(double left, double right);

    public abstract <T extends Comparable<? super T>> Comparison ascendingNullFirst(T left, T right);

    public abstract <T extends Comparable<? super T>> Comparison ascendingNullLast(T left, T right);

    public abstract <T> Comparison ascendingNullFirst(T left, T right, Comparator<? super T> comparator);

    public abstract <T> Comparison ascendingNullLast(T left, T right, Comparator<? super T> comparator);

    public abstract Comparison ascendingIgnoringCaseNullFirst(String left, String right);

    public abstract Comparison ascendingIgnoringCaseNullLast(String left, String right);

    public abstract Comparison descending(boolean left, boolean right);

    public abstract Comparison descending(byte left, byte right);

    public abstract Comparison descending(char left, char right);

    public abstract Comparison descending(short left, short right);

    public abstract Comparison descending(int left, int right);

    public abstract Comparison descending(long left, long right);

    public abstract Comparison descending(float left, float right);

    public abstract Comparison descending(double left, double right);

    public abstract <T extends Comparable<? super T>> Comparison descendingNullFirst(T left, T right);

    public abstract <T extends Comparable<? super T>> Comparison descendingNullLast(T left, T right);

    public abstract <T> Comparison descendingNullFirst(T left, T right, Comparator<? super T> comparator);

    public abstract <T> Comparison descendingNullLast(T left, T right, Comparator<? super T> comparator);

    public abstract Comparison descendingIgnoringCaseNullFirst(String left, String right);

    public abstract Comparison descendingIgnoringCaseNullLast(String left, String right);

    /**
     * Returns the result of this comparison chain.
     *
     * @return  the result of the comparison
     */
    public abstract int result();

    /**
     * Returns the inverted result of this comparison chain.
     *
     * @return  the result of the comparison
     */
    public abstract int resultInverted();


    private static class Active extends Comparison {
        @Override
        public Comparison accept(int result) {
            return comp(result);
        }

        @Override
        public Comparison ascending(boolean left, boolean right) {
            return comp(Boolean.compare(left, right));
        }

        @Override
        public Comparison ascending(byte left, byte right) {
            return comp(Byte.compare(left, right));
        }

        @Override
        public Comparison ascending(char left, char right) {
            return comp(Character.compare(left, right));
        }

        @Override
        public Comparison ascending(short left, short right) {
            return comp(Short.compare(left, right));
        }

        @Override
        public Comparison ascending(int left, int right) {
            return comp(Integer.compare(left, right));
        }

        @Override
        public Comparison ascending(long left, long right) {
            return comp(Long.compare(left, right));
        }

        @Override
        public Comparison ascending(float left, float right) {
            return comp(Float.compare(left, right));
        }

        @Override
        public Comparison ascending(double left, double right) {
            return comp(Double.compare(left, right));
        }

        @Override
        public <T extends Comparable<? super T>> Comparison ascendingNullFirst(T left, T right) {
            return comp(Comparisons.compareNullFirst(left, right));
        }

        @Override
        public <T extends Comparable<? super T>> Comparison ascendingNullLast(T left, T right) {
            return comp(Comparisons.compareNullLast(left, right));
        }

        @Override
        public <T> Comparison ascendingNullFirst(T left, T right, Comparator<? super T> comparator) {
            return comp(Comparisons.compareNullFirst(left, right, comparator));
        }

        @Override
        public <T> Comparison ascendingNullLast(T left, T right, Comparator<? super T> comparator) {
            return comp(Comparisons.compareNullLast(left, right, comparator));
        }

        @Override
        public Comparison ascendingIgnoringCaseNullFirst(String left, String right) {
            return comp(Comparisons.compareIgnoringCaseNullFirst(left, right));
        }

        @Override
        public Comparison ascendingIgnoringCaseNullLast(String left, String right) {
            return comp(Comparisons.compareIgnoringCaseNullLast(left, right));
        }

        @Override
        public Comparison descending(boolean left, boolean right) {
            return comp(Boolean.compare(right, left));
        }

        @Override
        public Comparison descending(byte left, byte right) {
            return comp(Byte.compare(right, left));
        }

        @Override
        public Comparison descending(char left, char right) {
            return comp(Character.compare(right, left));
        }

        @Override
        public Comparison descending(short left, short right) {
            return comp(Short.compare(right, left));
        }

        @Override
        public Comparison descending(int left, int right) {
            return comp(Integer.compare(right, left));
        }

        @Override
        public Comparison descending(long left, long right) {
            return comp(Long.compare(right, left));
        }

        @Override
        public Comparison descending(float left, float right) {
            return comp(Float.compare(right, left));
        }

        @Override
        public Comparison descending(double left, double right) {
            return comp(Double.compare(right, left));
        }

        @Override
        public <T extends Comparable<? super T>> Comparison descendingNullFirst(T left, T right) {
            return comp(Comparisons.compareNullFirst(right, left));
        }

        @Override
        public <T extends Comparable<? super T>> Comparison descendingNullLast(T left, T right) {
            return comp(Comparisons.compareNullLast(right, left));
        }

        @Override
        public <T> Comparison descendingNullFirst(T left, T right, Comparator<? super T> comparator) {
            return comp(Comparisons.compareNullFirst(right, left, comparator));
        }

        @Override
        public <T> Comparison descendingNullLast(T left, T right, Comparator<? super T> comparator) {
            return comp(Comparisons.compareNullLast(right, left, comparator));
        }

        @Override
        public Comparison descendingIgnoringCaseNullFirst(String left, String right) {
            return comp(Comparisons.compareIgnoringCaseNullFirst(right, left));
        }

        @Override
        public Comparison descendingIgnoringCaseNullLast(String left, String right) {
            return comp(Comparisons.compareIgnoringCaseNullLast(right, left));
        }

        @Override
        public int result() {
            return 0;
        }

        @Override
        public int resultInverted() {
            return 0;
        }

        private Comparison comp(int result) {
            return result == 0 ? this : result < 0 ? LESS : GREATER;
        }
    }


    private static class Inactive extends Comparison {
        private final int fixedResult;

        public Inactive(int fixedResult) {
            this.fixedResult = fixedResult;
        }

        @Override
        public Comparison accept(int result) {
            return this;
        }

        @Override
        public Comparison ascending(boolean left, boolean right) {
            return this;
        }

        @Override
        public Comparison ascending(byte left, byte right) {
            return this;
        }

        @Override
        public Comparison ascending(char left, char right) {
            return this;
        }

        @Override
        public Comparison ascending(short left, short right) {
            return this;
        }

        @Override
        public Comparison ascending(int left, int right) {
            return this;
        }

        @Override
        public Comparison ascending(long left, long right) {
            return this;
        }

        @Override
        public Comparison ascending(float left, float right) {
            return this;
        }

        @Override
        public Comparison ascending(double left, double right) {
            return this;
        }

        @Override
        public <T extends Comparable<? super T>> Comparison ascendingNullFirst(T left, T right) {
            return this;
        }

        @Override
        public <T extends Comparable<? super T>> Comparison ascendingNullLast(T left, T right) {
            return this;
        }

        @Override
        public <T> Comparison ascendingNullFirst(T left, T right, Comparator<? super T> comparator) {
            return this;
        }

        @Override
        public <T> Comparison ascendingNullLast(T left, T right, Comparator<? super T> comparator) {
            return this;
        }

        @Override
        public Comparison ascendingIgnoringCaseNullFirst(String left, String right) {
            return this;
        }

        @Override
        public Comparison ascendingIgnoringCaseNullLast(String left, String right) {
            return this;
        }

        @Override
        public Comparison descending(boolean left, boolean right) {
            return this;
        }

        @Override
        public Comparison descending(byte left, byte right) {
            return this;
        }

        @Override
        public Comparison descending(char left, char right) {
            return this;
        }

        @Override
        public Comparison descending(short left, short right) {
            return this;
        }

        @Override
        public Comparison descending(int left, int right) {
            return this;
        }

        @Override
        public Comparison descending(long left, long right) {
            return this;
        }

        @Override
        public Comparison descending(float left, float right) {
            return this;
        }

        @Override
        public Comparison descending(double left, double right) {
            return this;
        }

        @Override
        public <T extends Comparable<? super T>> Comparison descendingNullFirst(T left, T right) {
            return this;
        }

        @Override
        public <T extends Comparable<? super T>> Comparison descendingNullLast(T left, T right) {
            return this;
        }

        @Override
        public <T> Comparison descendingNullFirst(T left, T right, Comparator<? super T> comparator) {
            return this;
        }

        @Override
        public <T> Comparison descendingNullLast(T left, T right, Comparator<? super T> comparator) {
            return this;
        }

        @Override
        public Comparison descendingIgnoringCaseNullFirst(String left, String right) {
            return this;
        }

        @Override
        public Comparison descendingIgnoringCaseNullLast(String left, String right) {
            return this;
        }

        @Override
        public int result() {
            return fixedResult;
        }

        @Override
        public int resultInverted() {
            return -fixedResult;
        }
    }
}
