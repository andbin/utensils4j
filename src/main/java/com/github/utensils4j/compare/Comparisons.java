package com.github.utensils4j.compare;

import java.util.Comparator;

/**
 * Static utility methods related to values comparison.
 *
 * @author Andrea Binello
 */
public class Comparisons {
    private Comparisons() {}

    /**
     * Compares two <em>comparable</em> objects in a null-safe manner.
     * The comparison of two non-{@code null} objects is performed as
     * specified by {@link Comparable#compareTo}.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>less than</strong> a non-{@code null}.
     *
     * @param  <T>  the type of {@code left} and {@code right} objects
     * @param  left  the left object
     * @param  right  the right object
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     */
    public static <T extends Comparable<? super T>> int compareNullFirst(T left, T right) {
        return left == right ? 0
             : right == null ? 1   // 1 means: left (non-null) > right (null)
             : left == null ? -1   // -1 means: left (null) < right (non-null)
             : left.compareTo(right);
    }

    /**
     * Compares two <em>comparable</em> objects in a null-safe manner.
     * The comparison of two non-{@code null} objects is performed as
     * specified by {@link Comparable#compareTo}.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>greater than</strong> a non-{@code null}.
     *
     * @param  <T>  the type of {@code left} and {@code right} objects
     * @param  left  the left object
     * @param  right  the right object
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     */
    public static <T extends Comparable<? super T>> int compareNullLast(T left, T right) {
        return left == right ? 0
             : right == null ? -1   // -1 means: left (non-null) < right (null)
             : left == null ? 1     // 1 means: left (null) > right (non-null)
             : left.compareTo(right);
    }

    /**
     * Compares two objects in a null-safe manner using an explicit {@code Comparator}.
     * The comparison of two non-{@code null} objects is performed as
     * specified by {@link Comparator#compare}.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>less than</strong> a non-{@code null}.
     *
     * <p><strong>Note</strong>: the {@code Comparator} never receives a
     * {@code null} argument.
     *
     * @param  <T>  the type of {@code left} and {@code right} objects
     * @param  left  the left object
     * @param  right  the right object
     * @param  comparator  the explicit {@code Comparator} used to compare
     *         {@code left} and {@code right} objects
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     * @throws NullPointerException if {@code comparator} is {@code null} when
     *         {@code comparator.compare} is invoked
     */
    public static <T> int compareNullFirst(T left, T right, Comparator<? super T> comparator) {
        return left == right ? 0
             : right == null ? 1   // 1 means: left (non-null) > right (null)
             : left == null ? -1   // -1 means: left (null) < right (non-null)
             : comparator.compare(left, right);
    }

    /**
     * Compares two objects in a null-safe manner using an explicit {@code Comparator}.
     * The comparison of two non-{@code null} objects is performed as
     * specified by {@link Comparator#compare}.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>greater than</strong> a non-{@code null}.
     *
     * <p><strong>Note</strong>: the {@code Comparator} never receives a
     * {@code null} argument.
     *
     * @param  <T>  the type of {@code left} and {@code right} objects
     * @param  left  the left object
     * @param  right  the right object
     * @param  comparator  the explicit {@code Comparator} used to compare
     *         {@code left} and {@code right} objects
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     * @throws NullPointerException if {@code comparator} is {@code null} when
     *         {@code comparator.compare} is invoked
     */
    public static <T> int compareNullLast(T left, T right, Comparator<? super T> comparator) {
        return left == right ? 0
             : right == null ? -1   // -1 means: left (non-null) < right (null)
             : left == null ? 1     // 1 means: left (null) > right (non-null)
             : comparator.compare(left, right);
    }

    /**
     * Compares two strings in a null-safe and case-insensitive manner.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>less than</strong> a non-{@code null}.
     *
     * @param  left  the left string
     * @param  right  the right string
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     */
    public static int compareIgnoringCaseNullFirst(String left, String right) {
        return left == right ? 0
             : right == null ? 1   // 1 means: left (non-null) > right (null)
             : left == null ? -1   // -1 means: left (null) < right (non-null)
             : String.CASE_INSENSITIVE_ORDER.compare(left, right);
    }

    /**
     * Compares two strings in a null-safe and case-insensitive manner.
     *
     * <p>A {@code null} is considered <strong>equal to</strong> a
     * {@code null} and <strong>greater than</strong> a non-{@code null}.
     *
     * @param  left  the left string
     * @param  right  the right string
     * @return the result of the comparison as follows:
     *         <ul>
     *         <li>0 if {@code left} is equal to {@code right}</li>
     *         <li>&lt;0 if {@code left} is less than {@code right}</li>
     *         <li>&gt;0 if {@code left} is greater than {@code right}</li>
     *         </ul>
     */
    public static int compareIgnoringCaseNullLast(String left, String right) {
        return left == right ? 0
             : right == null ? -1   // -1 means: left (non-null) < right (null)
             : left == null ? 1     // 1 means: left (null) > right (non-null)
             : String.CASE_INSENSITIVE_ORDER.compare(left, right);
    }
}
