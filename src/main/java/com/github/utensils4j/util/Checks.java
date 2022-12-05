package com.github.utensils4j.util;

public class Checks {
    private static final String REQUIRE_NOT_NULL_MSG = "%1$s must be not-null";
    private static final String REQUIRE_POSITIVE_MSG = "%2$s must be positive, actual: %1$s";

    private static final Object[] EMPTY_ARGS = new Object[0];

    private Checks() {}

    //-----------------------------------------------------------------------
    // requireNotNull / requireNotNullWithMsg
    //-----------------------------------------------------------------------

    public static <T> T requireNotNull(T value, String valueName) {
        if (value == null) {
            throw npe(REQUIRE_NOT_NULL_MSG, valueName);
        }
        return value;
    }

    public static <T> T requireNotNullWithMsg(T value, String errorMessage) {
        if (value == null) {
            throw npe(errorMessage, EMPTY_ARGS);
        }
        return value;
    }

    public static <T> T requireNotNullWithMsg(T value, String errorMessage, Object... args) {
        if (value == null) {
            throw npe(errorMessage, args);
        }
        return value;
    }


    //-----------------------------------------------------------------------
    // requirePositive / requirePositiveWithMsg
    //-----------------------------------------------------------------------

    /**
     * Checks that a value of type {@code int} is "positive" (value &gt; 0).
     * If the check fails, the exception {@link IllegalArgumentException}
     * is thrown with the following detail message formatted using
     * {@link String#format}:
     *
     * <blockquote><code>%2$s must be positive, actual: %1$s</code></blockquote>
     *
     * where:<ul>
     *   <li>{@code %1$} is the <strong>{@code value}</strong> parameter</li>
     *   <li>{@code %2$} is the <strong>{@code valueName}</strong> parameter</li>
     * </ul>
     *
     * @param   value  the value to check
     * @param   valueName  the name of the value
     * @return  the value that was validated
     * @throws  IllegalArgumentException if the value is not positive
     */
    public static int requirePositive(int value, String valueName) {
        if (value <= 0) {
            throw iae(REQUIRE_POSITIVE_MSG, value, valueName);
        }
        return value;
    }

    /**
     * Checks that a value of type {@code int} is "positive" (value &gt; 0).
     * If the check fails, the exception {@link IllegalArgumentException}
     * is thrown with a <strong>custom</strong> detail message formatted
     * using {@link String#format} where:<ul>
     *   <li>{@code %1$} is the <strong>{@code value}</strong> parameter</li>
     * </ul>
     *
     * @param   value  the value to check
     * @param   errorMessage  the custom error message template
     * @return  the value that was validated
     * @throws  IllegalArgumentException if the value is not positive
     */
    public static int requirePositiveWithMsg(int value, String errorMessage) {
        if (value <= 0) {
            throw iae(errorMessage, value);
        }
        return value;
    }

    /**
     * Checks that a value of type {@code int} is "positive" (value &gt; 0).
     * If the check fails, the exception {@link IllegalArgumentException}
     * is thrown with a <strong>custom</strong> detail message formatted
     * using {@link String#format} where:<ul>
     *   <li>{@code %1$} is the <strong>{@code value}</strong> parameter</li>
     *   <li>{@code %2$} is the 1° argument in <strong>{@code otherArgs}</strong> parameter</li>
     *   <li>{@code %3$} is the 2° argument in <strong>{@code otherArgs}</strong> parameter</li>
     *   <li>etc...</li>
     * </ul>
     *
     * @param   value  the value to check
     * @param   errorMessage  the custom error message template
     * @param   otherArgs  other custom arguments
     * @return  the value that was validated
     * @throws  IllegalArgumentException if the value is not positive
     */
    public static int requirePositiveWithMsg(int value, String errorMessage, Object... otherArgs) {
        if (value <= 0) {
            throw iae(errorMessage, arrayOf(value, otherArgs));
        }
        return value;
    }


    private static Object[] arrayOf(Object arg1, Object[] otherArgs) {
        Object[] args = new Object[otherArgs.length+1];
        args[0] = arg1;
        System.arraycopy(otherArgs, 0, args, 1, otherArgs.length);
        return args;
    }

    private static IllegalArgumentException iae(String template, Object... args) {
        return new IllegalArgumentException(String.format(template, args));
    }

    private static NullPointerException npe(String template, Object... args) {
        return new NullPointerException(String.format(template, args));
    }
}
