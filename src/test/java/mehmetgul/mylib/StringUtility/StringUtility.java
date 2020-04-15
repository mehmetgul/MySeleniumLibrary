package mehmetgul.mylib.StringUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 *
 * Useful String Utility Methods.
 *
 * @author javaguides.net
 *
 */
public class StringUtility {

	/**
	 * The empty String {@code ""}.
	 *
	 * @since 2.0
	 */
	public static final String EMPTY = "";

	/**
	 * Represents a failed index search.
	 *
	 * @since 2.1
	 */
	public static final int INDEX_NOT_FOUND = -1;

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	public static String[] toStringArray(Collection collection) {
		if (collection == null) {
			return null;
		}
		return (String[]) collection.toArray(new String[collection.size()]);
	}

	/**
	 * Returns the input argument, but ensures the first character is
	 * capitalized (if possible).
	 *
	 * @param in
	 *            the string to uppercase the first character.
	 * @return the input argument, but with the first character capitalized (if
	 *         possible).
	 * @since 1.2
	 */
	public static String uppercaseFirstChar(String in ) {
		if ( in == null || in .length() == 0) {
			return in;
		}
		int length = in .length();
		StringBuilder sb = new StringBuilder(length);

		sb.append(Character.toUpperCase( in .charAt(0)));
		if (length > 1) {
			String remaining = in .substring(1);
			sb.append(remaining);
		}
		return sb.toString();
	}

	// Empty checks
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if a CharSequence is empty ("") or null.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since 3.0 Changed signature from isEmpty(String) to
	 *        isEmpty(CharSequence)
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty ("") and not null.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null
	 * @since 3.0 Changed signature from isNotEmpty(String) to
	 *        isNotEmpty(CharSequence)
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if any of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if any of the CharSequences are empty or null
	 * @since 3.2
	 */
	public static boolean isAnyEmpty(final CharSequence...css) {
		if (css != null && css.length == 0) {
			return false;
		}
		for (final CharSequence cs: css) {
			if (isEmpty(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Checks if none of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if none of the CharSequences are empty or null
	 * @since 3.2
	 */
	public static boolean isNoneEmpty(final CharSequence...css) {
		return !isAnyEmpty(css);
	}

	/**
	 * <p>
	 * Checks if all of the CharSequences are empty ("") or null.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if all of the CharSequences are empty or null
	 * @since 3.6
	 */
	public static boolean isAllEmpty(final CharSequence...css) {
		if (css != null && css.length == 0) {
			return true;
		}
		for (final CharSequence cs: css) {
			if (isNotEmpty(cs)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is empty (""), null or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 *         only
	 * @since 2.0
	 * @since 3.0 Changed signature from isBlank(String) to
	 *        isBlank(CharSequence)
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace
	 * only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and
	 *         not whitespace only
	 * @since 2.0
	 * @since 3.0 Changed signature from isNotBlank(String) to
	 *        isNotBlank(CharSequence)
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * <p>
	 * Checks if any of the CharSequences are empty ("") or null or whitespace
	 * only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if any of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 3.2
	 */
	public static boolean isAnyBlank(final CharSequence...css) {
		if (css != null && css.length == 0) {
			return false;
		}
		for (final CharSequence cs: css) {
			if (isBlank(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Checks if none of the CharSequences are empty (""), null or whitespace
	 * only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if none of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 3.2
	 */
	public static boolean isNoneBlank(final CharSequence...css) {
		return !isAnyBlank(css);
	}

	/**
	 * <p>
	 * Checks if all of the CharSequences are empty (""), null or whitespace
	 * only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param css
	 *            the CharSequences to check, may be null or empty
	 * @return {@code true} if all of the CharSequences are empty or null or
	 *         whitespace only
	 * @since 3.6
	 */
	public static boolean isAllBlank(final CharSequence...css) {
		if (css != null && css.length == 0) {
			return true;
		}
		for (final CharSequence cs: css) {
			if (isNotBlank(cs)) {
				return false;
			}
		}
		return true;
	}

	// Compare
	// -----------------------------------------------------------------------

	public static int compare(final String str1, final String str2) {
		return compare(str1, str2, true);
	}

	public static int compare(final String str1, final String str2, final boolean nullIsLess) {
		if (str1 == str2) {
			return 0;
		}
		if (str1 == null) {
			return nullIsLess ? -1 : 1;
		}
		if (str2 == null) {
			return nullIsLess ? 1 : -1;
		}
		return str1.compareTo(str2);
	}

	public static int compareIgnoreCase(final String str1, final String str2) {
		return compareIgnoreCase(str1, str2, true);
	}

	public static int compareIgnoreCase(final String str1, final String str2, final boolean nullIsLess) {
		if (str1 == str2) {
			return 0;
		}
		if (str1 == null) {
			return nullIsLess ? -1 : 1;
		}
		if (str2 == null) {
			return nullIsLess ? 1 : -1;
		}
		return str1.compareToIgnoreCase(str2);
	}

	/**
	 * <p>
	 * Check whether the given CharSequence contains any whitespace characters.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param seq
	 *            the CharSequence to check (may be {@code null})
	 * @return {@code true} if the CharSequence is not empty and contains at
	 *         least 1 (breaking) whitespace character
	 * @since 3.0
	 */
	public static boolean containsWhitespace(final CharSequence seq) {
		if (isEmpty(seq)) {
			return false;
		}
		final int strLen = seq.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(seq.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	// Case conversion
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Converts a String to upper case as per {@link String#toUpperCase()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * @param str
	 *            the String to upper case, may be null
	 * @return the upper cased String, {@code null} if null String input
	 */
	public static String upperCase(final String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	/**
	 * <p>
	 * Converts a String to upper case as per
	 * {@link String#toUpperCase(Locale)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * @param str
	 *            the String to upper case, may be null
	 * @param locale
	 *            the locale that defines the case transformation rules, must
	 *            not be null
	 * @return the upper cased String, {@code null} if null String input
	 * @since 2.5
	 */
	public static String upperCase(final String str, final Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase(locale);
	}

	/**
	 * <p>
	 * Converts a String to lower case as per {@link String#toLowerCase()}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * @param str
	 *            the String to lower case, may be null
	 * @return the lower cased String, {@code null} if null String input
	 */
	public static String lowerCase(final String str) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase();
	}

	/**
	 * <p>
	 * Converts a String to lower case as per
	 * {@link String#toLowerCase(Locale)}.
	 * </p>
	 *
	 * <p>
	 * A {@code null} input String returns {@code null}.
	 * </p>
	 *
	 * @param str
	 *            the String to lower case, may be null
	 * @param locale
	 *            the locale that defines the case transformation rules, must
	 *            not be null
	 * @return the lower cased String, {@code null} if null String input
	 * @since 2.5
	 */
	public static String lowerCase(final String str, final Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase(locale);
	}

	/**
	 * <p>
	 * Counts how many times the char appears in the given string.
	 * </p>
	 *
	 * <p>
	 * A {@code null} or empty ("") String input returns {@code 0}.
	 * </p>
	 *
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param ch
	 *            the char to count
	 * @return the number of occurrences, 0 if the CharSequence is {@code null}
	 * @since 3.4
	 */
	public static int countMatches(final CharSequence str, final char ch) {
		if (isEmpty(str)) {
			return 0;
		}
		int count = 0;
		// We could also call str.toCharArray() for faster look ups but that
		// would generate more garbage.
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	// Character Tests
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, and is non-null
	 * @since 3.0 Changed signature from isAlpha(String) to
	 *        isAlpha(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isAlpha(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters and space (' ').
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false} An empty CharSequence (length()=0)
	 * will return {@code true}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters and space, and is non-null
	 * @since 3.0 Changed signature from isAlphaSpace(String) to
	 *        isAlphaSpace(CharSequence)
	 */
	public static boolean isAlphaSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters or digits.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters or digits, and is non-null
	 * @since 3.0 Changed signature from isAlphanumeric(String) to
	 *        isAlphanumeric(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isAlphanumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode letters, digits or space
	 * ({@code ' '}).
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains letters, digits or space, and is
	 *         non-null
	 * @since 3.0 Changed signature from isAlphanumericSpace(String) to
	 *        isAlphanumericSpace(CharSequence)
	 */
	public static boolean isAlphanumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits. A decimal point
	 * is not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * <p>
	 * Note that the method does not allow for a leading sign, either positive
	 * or negative. Also, if a String passes the numeric test, it may still
	 * generate a NumberFormatException when parsed by Integer.parseInt or
	 * Long.parseLong, e.g. if the value is outside the range for int or long
	 * respectively.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains digits, and is non-null
	 * @since 3.0 Changed signature from isNumeric(String) to
	 *        isNumeric(CharSequence)
	 * @since 3.0 Changed "" to return false and not true
	 */
	public static boolean isNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only Unicode digits or space
	 * ({@code ' '}). A decimal point is not a Unicode digit and returns false.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains digits or space, and is non-null
	 * @since 3.0 Changed signature from isNumericSpace(String) to
	 *        isNumericSpace(CharSequence)
	 */
	public static boolean isNumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a String {@code str} contains Unicode digits, if yes then
	 * concatenate all the digits in {@code str} and return it as a String.
	 * </p>
	 *
	 * <p>
	 * An empty ("") String will be returned if no digits found in {@code str}.
	 * </p>
	 *
	 * @param str
	 *            the String to extract digits from, may be null
	 * @return String with only digits, or an empty ("") String if no digits
	 *         found, or {@code null} String if {@code str} is null
	 * @since 3.6
	 */
	public static String getDigits(final String str) {
		if (isEmpty(str)) {
			return str;
		}
		final int sz = str.length();
		final StringBuilder strDigits = new StringBuilder(sz);
		for (int i = 0; i < sz; i++) {
			final char tempChar = str.charAt(i);
			if (Character.isDigit(tempChar)) {
				strDigits.append(tempChar);
			}
		}
		return strDigits.toString();
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only whitespace.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code true}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains whitespace, and is non-null
	 * @since 2.0
	 * @since 3.0 Changed signature from isWhitespace(String) to
	 *        isWhitespace(CharSequence)
	 */
	public static boolean isWhitespace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only lowercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * (length()=0) will return {@code false}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains lowercase characters, and is
	 *         non-null
	 * @since 2.5
	 * @since 3.0 Changed signature from isAllLowerCase(String) to
	 *        isAllLowerCase(CharSequence)
	 */
	public static boolean isAllLowerCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLowerCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains only uppercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty String (length()=0) will
	 * return {@code false}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if only contains uppercase characters, and is
	 *         non-null
	 * @since 2.5
	 * @since 3.0 Changed signature from isAllUpperCase(String) to
	 *        isAllUpperCase(CharSequence)
	 */
	public static boolean isAllUpperCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isUpperCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if the CharSequence contains mixed casing of both uppercase and
	 * lowercase characters.
	 * </p>
	 *
	 * <p>
	 * {@code null} will return {@code false}. An empty CharSequence
	 * ({@code length()=0}) will return {@code false}.
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence contains both uppercase and
	 *         lowercase characters
	 * @since 3.5
	 */
	public static boolean isMixedCase(final CharSequence cs) {
		if (isEmpty(cs) || cs.length() == 1) {
			return false;
		}
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (containsUppercase && containsLowercase) {
				return true;
			} else if (Character.isUpperCase(cs.charAt(i))) {
				containsUppercase = true;
			} else if (Character.isLowerCase(cs.charAt(i))) {
				containsLowercase = true;
			}
		}
		return containsUppercase && containsLowercase;
	}

	// Defaults
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null}, an
	 * empty String ("").
	 * </p>
	 *
	 * @see ObjectUtils#toString(Object)
	 * @see String#valueOf(Object)
	 * @param str
	 *            the String to check, may be null
	 * @return the passed in String, or the empty String if it was {@code null}
	 */
	public static String defaultString(final String str) {
		return defaultString(str, EMPTY);
	}

	/**
	 * <p>
	 * Returns either the passed in String, or if the String is {@code null},
	 * the value of {@code defaultStr}.
	 * </p>
	 *
	 * @see ObjectUtils#toString(Object,String)
	 * @see String#valueOf(Object)
	 * @param str
	 *            the String to check, may be null
	 * @param defaultStr
	 *            the default String to return if the input is {@code null}, may
	 *            be null
	 * @return the passed in String, or the default if it was {@code null}
	 */
	public static String defaultString(final String str, final String defaultStr) {
		return str == null ? defaultStr : str;
	}

	/**
	 * <p>
	 * Returns the first value in the array which is not empty (""),
	 * {@code null} or whitespace only.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * <p>
	 * If all values are blank or the array is {@code null} or empty then
	 * {@code null} is returned.
	 * </p>
	 *
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param values
	 *            the values to test, may be {@code null} or empty
	 * @return the first value from {@code values} which is not blank, or
	 *         {@code null} if there are no non-blank values
	 * @since 3.8
	 */
	@SafeVarargs
	public static < T extends CharSequence > T firstNonBlank(final T...values) {
		if (values != null) {
			for (final T val: values) {
				if (isNotBlank(val)) {
					return val;
				}
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Returns the first value in the array which is not empty.
	 * </p>
	 *
	 * <p>
	 * If all values are empty or the array is {@code null} or empty then
	 * {@code null} is returned.
	 * </p>
	 *
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param values
	 *            the values to test, may be {@code null} or empty
	 * @return the first value from {@code values} which is not empty, or
	 *         {@code null} if there are no non-empty values
	 * @since 3.8
	 */
	@SafeVarargs
	public static < T extends CharSequence > T firstNonEmpty(final T...values) {
		if (values != null) {
			for (final T val: values) {
				if (isNotEmpty(val)) {
					return val;
				}
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is
	 * whitespace, empty ("") or {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * <p>
	 * Whitespace is defined by {@link Character#isWhitespace(char)}.
	 * </p>
	 *
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param defaultStr
	 *            the default CharSequence to return if the input is whitespace,
	 *            empty ("") or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static < T extends CharSequence > T defaultIfBlank(final T str, final T defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	/**
	 * <p>
	 * Returns either the passed in CharSequence, or if the CharSequence is
	 * empty or {@code null}, the value of {@code defaultStr}.
	 * </p>
	 *
	 * @param <T>
	 *            the specific kind of CharSequence
	 * @param str
	 *            the CharSequence to check, may be null
	 * @param defaultStr
	 *            the default CharSequence to return if the input is empty ("")
	 *            or {@code null}, may be null
	 * @return the passed in CharSequence, or the default
	 * @see StringUtils#defaultString(String, String)
	 */
	public static < T extends CharSequence > T defaultIfEmpty(final T str, final T defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	/**
	 * Trim leading and trailing whitespace from the given {@code String}.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @return the trimmed {@code String}
	 * @see java.lang.Character#isWhitespace
	 */
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		int beginIndex = 0;
		int endIndex = str.length() - 1;

		while (beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))) {
			beginIndex++;
		}

		while (endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))) {
			endIndex--;
		}

		return str.substring(beginIndex, endIndex + 1);
	}

	/**
	 * Trim <i>all</i> whitespace from the given {@code String}: leading,
	 * trailing, and in between characters.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @return the trimmed {@code String}
	 * @see java.lang.Character#isWhitespace
	 */
	public static String trimAllWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		int len = str.length();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Trim leading whitespace from the given {@code String}.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @return the trimmed {@code String}
	 * @see java.lang.Character#isWhitespace
	 */
	public static String trimLeadingWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	/**
	 * Trim trailing whitespace from the given {@code String}.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @return the trimmed {@code String}
	 * @see java.lang.Character#isWhitespace
	 */
	public static String trimTrailingWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * Trim all occurrences of the supplied leading character from the given
	 * {@code String}.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @param leadingCharacter
	 *            the leading character to be trimmed
	 * @return the trimmed {@code String}
	 */
	public static String trimLeadingCharacter(String str, char leadingCharacter) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	/**
	 * Trim all occurrences of the supplied trailing character from the given
	 * {@code String}.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @param trailingCharacter
	 *            the trailing character to be trimmed
	 * @return the trimmed {@code String}
	 */
	public static String trimTrailingCharacter(String str, char trailingCharacter) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * Test if the given {@code String} starts with the specified prefix,
	 * ignoring upper/lower case.
	 *
	 * @param str
	 *            the {@code String} to check
	 * @param prefix
	 *            the prefix to look for
	 * @see java.lang.String#startsWith
	 */
	public static boolean startsWithIgnoreCase(String str, String prefix) {
		return (str != null && prefix != null && str.length() >= prefix.length() &&
				str.regionMatches(true, 0, prefix, 0, prefix.length()));
	}

	/**
	 * Quote the given {@code String} with single quotes.
	 *
	 * @param str
	 *            the input {@code String} (e.g. "myString")
	 * @return the quoted {@code String} (e.g. "'myString'"), or {@code null} if
	 *         the input was {@code null}
	 */

	public static String quote(String str) {
		return (str != null ? "'" + str + "'" : null);
	}

	/**
	 * Turn the given Object into a {@code String} with single quotes if it is a
	 * {@code String}; keeping the Object as-is else.
	 *
	 * @param obj
	 *            the input Object (e.g. "myString")
	 * @return the quoted {@code String} (e.g. "'myString'"), or the input
	 *         object as-is if not a {@code String}
	 */

	public static Object quoteIfString(Object obj) {
		return (obj instanceof String ? quote((String) obj) : obj);
	}

	/**
	 * Converts an {@link InputStream} into a String.
	 *
	 * @param inputStream
	 *            The input stream to convert
	 * @return A String containing the contents of the {@link InputStream}
	 */
	public static String fromInputStream(InputStream inputStream) {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		return fromBufferedReader(bufferedReader);
	}

	/**
	 * Converts a {@link BufferedReader} into a String.
	 *
	 * @param bufferedReader
	 *            The {@link BufferedReader} to convert
	 * @return A String containing the contents of the {@link BufferedReader}
	 */
	public static String fromBufferedReader(BufferedReader bufferedReader) {
		StringBuffer sb = new StringBuffer();

		try {
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				line = bufferedReader.readLine();
				if (line != null) {
					sb.append("\n");
				}
			}
		} catch (IOException e) {
			// replace this with log.error
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static String getClasspath() {
		Properties prop = System.getProperties();
		return prop.getProperty("java.class.path", null);
	}

	public static String getAllFilesOnClasspath() {
		StringBuffer sb = new StringBuffer();
		for (final java.lang.String path: getClasspath().split(":")) {
			final java.io.File object = new java.io.File(path);
			if (object.isDirectory()) {
				for (File file: object.listFiles()) {
					sb.append(file.getAbsolutePath()).append("\n");
				}
			} else if (object.isFile()) {
				sb.append(object).append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Converts a 2 dimensional array into a map where the first dimension is 2
	 * cell String array containing key and value respectively. Any array with
	 * fewer than 2 elements is ignored.
	 *
	 * @param array
	 *            The array to convert into a map
	 * @return A {@link Map} of key value pairs extracted from the supplied
	 *         array.
	 */
	public static Map < String, String > arrayToMap(String[][] array) {
		Map < String, String > map = new HashMap < String, String > ();

		for (String[] pair: array) {
			if (pair.length > 1) {
				// got a pair, add to map
				map.put(pair[0], pair[1]);
			}
		}

		return map;
	}

	/**
	 * Searches through a given String array and returns an element that starts
	 * with the supplied startsWith string. This method ignores the case. If no
	 * match can be found then an empty String is returned.
	 *
	 * @param array
	 *            The array of Strings to search through
	 * @param startsWith
	 *            The String to match.
	 * @return A String that starts with startsWith (ignoring case) or an empty
	 *         String if one cannot be found. If multiple Strings match, then
	 *         the first one in the array will be returned.
	 */
	public static String startsWith(String[] array, String startsWith) {
		String lcStartsWith = startsWith.toLowerCase();
		for (String element: array) {
			if (element.toLowerCase().startsWith(lcStartsWith)) {
				return element;
			}
		}

		return "";
	}

	/**
	 * Iterates over the array looking for an element that, ignoring case starts
	 * with the startsWith string. If a match is found then the index of the
	 * matching element is returned. If no match is found then -1 is returned.
	 *
	 * @param array
	 *            The array of String to search through.
	 * @param startsWith
	 *            The String to match against
	 * @return Index of the matching element, or -1 if no match is found. If
	 *         there are multiple matches then the index of the first match is
	 *         returned.
	 */
	public static int indexThatStartsWith(String[] array, String startsWith) {
		String lcStartsWith = startsWith.toLowerCase();

		for (int i = 0; i < array.length; i++) {
			if (array[i].toLowerCase().startsWith(lcStartsWith)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Keeps prepending a given prependChar to an initialInt until it reaches
	 * the targetLength and returns the result. If initialInt is null then null
	 * is returned.
	 *
	 * @param prependChar
	 *            The char to prepend
	 * @param targetLength
	 *            The targetLength
	 * @param initialInt
	 *            The initial Integer
	 * @return The initialInt padded out with the prependChar at the beginning
	 *         of the string until it reaches the targetLength
	 */
	public static String prependToLength(char prependChar, int targetLength, Integer initialInt) {

		if (initialInt == null) {
			return null;
		}

		return prependToLength(prependChar, targetLength, initialInt.toString());
	}

	/**
	 * Keeps prepending a given prependChar to an initialString until it reaches
	 * the targetLength and returns the result. If initialString is null then
	 * null is returned.
	 *
	 * @param prependChar
	 *            The char to prepend
	 * @param targetLength
	 *            The targetLength
	 * @param initialString
	 *            The initiatlString
	 * @return The initialString padded out with the prependChar at the
	 *         beginning of the string until it reaches the targetLength
	 */
	public static String prependToLength(char prependChar, int targetLength, String initialString) {
		if (initialString == null) {
			return null;
		}

		StringBuffer result = new StringBuffer(initialString);

		while (result.length() < targetLength) {
			result.append(prependChar);
		}

		return result.reverse().toString();
	}

	/**
	 * If a given string is longer than maxLength then it is truncated. For
	 * example if str="hamburger" and maxLength=3 then "ham" will be returned.
	 *
	 * @param str
	 *            The str to be truncated. If this is null or equal to or
	 *            shorter than maxLength then it is returned whithout
	 *            modification.
	 * @param maxLength
	 *            Maximum length of the returned String. If this is less than 1,
	 *            then str is returned regardless.
	 * @return A string no more than maxLength characters in length.
	 */
	public static String truncate(String str, int maxLength) {
		if (str == null || str.length() <= maxLength || maxLength < 1) {
			return str;
		}

		return str.substring(0, maxLength);
	}

	/**
	 * This String utility or util method can be used to merge 2 arrays of
	 * string values. If the input arrays are like this array1 = {"a", "b" ,
	 * "c"} array2 = {"c", "d", "e"} Then the output array will have {"a", "b" ,
	 * "c", "d", "e"}
	 *
	 * This takes care of eliminating duplicates and checks null values.
	 *
	 * @param values
	 * @return
	 */
	public static String[] mergeStringArrays(String array1[], String array2[]) {

		if (array1 == null || array1.length == 0)
			return array2;
		if (array2 == null || array2.length == 0)
			return array1;
		List < String > array1List = Arrays.asList(array1);
		List < String > array2List = Arrays.asList(array2);
		List < String > result = new ArrayList < String > (array1List);
		List < String > tmp = new ArrayList < String > (array1List);
		tmp.retainAll(array2List);
		result.removeAll(tmp);
		result.addAll(array2List);
		return ((String[]) result.toArray(new String[result.size()]));
	}

	public static void main(String[] args) {
		String[] strArray = mergeStringArrays(new String[] {
				"abc",
				"xyz",
				"pqr"
		}, new String[] {
				"ABC",
				"PQR"
		});
		for (String string: strArray) {
			System.out.println(string);
		}
	}
}