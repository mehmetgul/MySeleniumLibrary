package mehmetgul.mylib.StringUtility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 *  JUnit test cases for StringUtility Methods
 * @author javaguides.net
 *
 */

public class StringUtilityTest {

	@Test
	public void hasLengthTest() {
		assertFalse(StringUtility.hasLength(null));
		assertFalse(StringUtility.hasLength(""));
		assertTrue(StringUtility.hasLength(" "));
		assertTrue(StringUtility.hasLength("javaguides"));
	}

	@Test
	public void toStringArrayTest() {
		String[] strArray = StringUtility.toStringArray(Arrays.asList("a", "b", "c"));
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
			assertNotNull(strArray[i]);
		}
	}

	@Test
	public void uppercaseFirstCharTest() {
		assertEquals("Javaguides", StringUtility.uppercaseFirstChar("javaguides"));
		assertEquals("Java", StringUtility.uppercaseFirstChar("java"));
		System.out.println(StringUtility.uppercaseFirstChar("javaguides"));
	}

	@Test
	public void isNotBlankTest() {
		assertFalse(StringUtility.isNotBlank(null));
		assertFalse(StringUtility.isNotBlank(""));
		assertFalse(StringUtility.isNotBlank(" "));
		assertTrue(StringUtility.isNotBlank("bob"));
		assertTrue(StringUtility.isNotBlank("  bob  "));
	}

	@Test
	public void isEmptyTest() {
		assertTrue(StringUtility.isEmpty(null));
		assertTrue(StringUtility.isEmpty(""));
		assertFalse(StringUtility.isEmpty(" "));
		assertFalse(StringUtility.isEmpty("bob"));
		assertFalse(StringUtility.isEmpty("  bob  "));
	}

	@Test
	public void isBlankTest() {
		assertTrue(StringUtility.isBlank(null));
		assertTrue(StringUtility.isBlank(""));
		assertTrue(StringUtility.isBlank(" "));
		assertFalse(StringUtility.isBlank("bob"));
		assertFalse(StringUtility.isBlank("  bob  "));
	}

	@Test
	public void isAnyEmptyTest() {
		assertTrue(StringUtility.isAnyEmpty((String) null));
		assertFalse(StringUtility.isAnyEmpty((String[]) null));
		assertTrue(StringUtility.isAnyEmpty(null, "foo"));
		assertTrue(StringUtility.isAnyEmpty("", "bar"));
		assertTrue(StringUtility.isAnyEmpty("bob", ""));
		assertTrue(StringUtility.isAnyEmpty("  bob  ", null));
		assertFalse(StringUtility.isAnyEmpty(" ", "bar"));
		assertFalse(StringUtility.isAnyEmpty("foo", "bar"));
		assertFalse(StringUtility.isAnyEmpty(new String[] {}));
		assertTrue(StringUtility.isAnyEmpty(new String[] {
				""
		}));
	}

	@Test
	public void isAnyBlankTest() {
		assertFalse(StringUtility.isAnyBlank((String[]) null));
		assertTrue(StringUtility.isAnyBlank((String) null));
		assertTrue(StringUtility.isAnyBlank(null, "foo"));
		assertTrue(StringUtility.isAnyBlank(null, null));
		assertTrue(StringUtility.isAnyBlank("", "bar"));
		assertTrue(StringUtility.isAnyBlank("bob", ""));
		assertTrue(StringUtility.isAnyBlank("  bob  ", null));
		assertTrue(StringUtility.isAnyBlank(" ", "bar"));
		assertFalse(StringUtility.isAnyBlank(new String[] {}));
		assertTrue(StringUtility.isAnyBlank(new String[] {
				""
		}));
		assertFalse(StringUtility.isAnyBlank("foo", "bar"));
	}

	@Test
	public void testContainsWhitespace() {
		assertFalse(StringUtility.containsWhitespace(null));
		assertFalse(StringUtility.containsWhitespace(""));
		assertFalse(StringUtility.containsWhitespace("a"));
		assertFalse(StringUtility.containsWhitespace("abc"));
		assertTrue(StringUtility.containsWhitespace(" "));
		assertTrue(StringUtility.containsWhitespace(" a"));
		assertTrue(StringUtility.containsWhitespace("abc "));
		assertTrue(StringUtility.containsWhitespace("a b"));
		assertTrue(StringUtility.containsWhitespace("a  b"));
	}

	@Test
	public void testTrimWhitespace() {
		assertEquals(null, StringUtility.trimWhitespace(null));
		assertEquals("", StringUtility.trimWhitespace(""));
		assertEquals("", StringUtility.trimWhitespace(" "));
		assertEquals("", StringUtility.trimWhitespace("\t"));
		assertEquals("a", StringUtility.trimWhitespace(" a"));
		assertEquals("a", StringUtility.trimWhitespace("a "));
		assertEquals("a", StringUtility.trimWhitespace(" a "));
		assertEquals("a b", StringUtility.trimWhitespace(" a b "));
		assertEquals("a b  c", StringUtility.trimWhitespace(" a b  c "));
	}

	@Test
	public void testTrimAllWhitespace() {
		assertEquals("", StringUtility.trimAllWhitespace(""));
		assertEquals("", StringUtility.trimAllWhitespace(" "));
		assertEquals("", StringUtility.trimAllWhitespace("\t"));
		assertEquals("a", StringUtility.trimAllWhitespace(" a"));
		assertEquals("a", StringUtility.trimAllWhitespace("a "));
		assertEquals("a", StringUtility.trimAllWhitespace(" a "));
		assertEquals("ab", StringUtility.trimAllWhitespace(" a b "));
		assertEquals("abc", StringUtility.trimAllWhitespace(" a b  c "));
	}

	@Test
	public void testTrimLeadingWhitespace() {
		assertEquals(null, StringUtility.trimLeadingWhitespace(null));
		assertEquals("", StringUtility.trimLeadingWhitespace(""));
		assertEquals("", StringUtility.trimLeadingWhitespace(" "));
		assertEquals("", StringUtility.trimLeadingWhitespace("\t"));
		assertEquals("a", StringUtility.trimLeadingWhitespace(" a"));
		assertEquals("a ", StringUtility.trimLeadingWhitespace("a "));
		assertEquals("a ", StringUtility.trimLeadingWhitespace(" a "));
		assertEquals("a b ", StringUtility.trimLeadingWhitespace(" a b "));
		assertEquals("a b  c ", StringUtility.trimLeadingWhitespace(" a b  c "));
	}

	@Test
	public void testTrimLeadingCharacter() {
		assertEquals(null, StringUtility.trimLeadingCharacter(null, ' '));
		assertEquals("", StringUtility.trimLeadingCharacter("", ' '));
		assertEquals("", StringUtility.trimLeadingCharacter(" ", ' '));
		assertEquals("\t", StringUtility.trimLeadingCharacter("\t", ' '));
		assertEquals("a", StringUtility.trimLeadingCharacter(" a", ' '));
		assertEquals("a ", StringUtility.trimLeadingCharacter("a ", ' '));
		assertEquals("a ", StringUtility.trimLeadingCharacter(" a ", ' '));
		assertEquals("a b ", StringUtility.trimLeadingCharacter(" a b ", ' '));
		assertEquals("a b  c ", StringUtility.trimLeadingCharacter(" a b  c ", ' '));
	}

	@Test
	public void testTrimTrailingCharacter() {
		assertEquals(null, StringUtility.trimTrailingCharacter(null, ' '));
		assertEquals("", StringUtility.trimTrailingCharacter("", ' '));
		assertEquals("", StringUtility.trimTrailingCharacter(" ", ' '));
		assertEquals("\t", StringUtility.trimTrailingCharacter("\t", ' '));
		assertEquals("a", StringUtility.trimTrailingCharacter("a ", ' '));
		assertEquals(" a", StringUtility.trimTrailingCharacter(" a", ' '));
		assertEquals(" a", StringUtility.trimTrailingCharacter(" a ", ' '));
		assertEquals(" a b", StringUtility.trimTrailingCharacter(" a b ", ' '));
		assertEquals(" a b  c", StringUtility.trimTrailingCharacter(" a b  c ", ' '));
	}

	@Test
	public void testStartsWithIgnoreCase() {
		String prefix = "fOo";
		assertTrue(StringUtility.startsWithIgnoreCase("foo", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("Foo", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("foobar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("foobarbar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("Foobar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("FoobarBar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("foObar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("FOObar", prefix));
		assertTrue(StringUtility.startsWithIgnoreCase("fOobar", prefix));
		assertFalse(StringUtility.startsWithIgnoreCase(null, prefix));
		assertFalse(StringUtility.startsWithIgnoreCase("fOobar", null));
		assertFalse(StringUtility.startsWithIgnoreCase("b", prefix));
		assertFalse(StringUtility.startsWithIgnoreCase("barfoo", prefix));
		assertFalse(StringUtility.startsWithIgnoreCase("barfoobar", prefix));
	}

	@Test
	public void testQuote() {
		assertEquals("'myString'", StringUtility.quote("myString"));
		assertEquals("''", StringUtility.quote(""));
		assertNull(StringUtility.quote(null));
	}

	@Test
	public void testQuoteIfString() {
		assertEquals("'myString'", StringUtility.quoteIfString("myString"));
		assertEquals("''", StringUtility.quoteIfString(""));
		assertEquals(Integer.valueOf(5), StringUtility.quoteIfString(5));
		assertNull(StringUtility.quoteIfString(null));
	}

	@Test
	public void testIsAlpha() {
		assertFalse(StringUtility.isAlpha(null));
		assertFalse(StringUtility.isAlpha(""));
		assertFalse(StringUtility.isAlpha(" "));
		assertTrue(StringUtility.isAlpha("a"));
		assertTrue(StringUtility.isAlpha("A"));
		assertTrue(StringUtility.isAlpha("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertFalse(StringUtility.isAlpha("ham kso"));
		assertFalse(StringUtility.isAlpha("1"));
		assertFalse(StringUtility.isAlpha("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isAlpha("_"));
		assertFalse(StringUtility.isAlpha("hkHKHik*khbkuh"));
	}

	@Test
	public void testIsAlphanumeric() {
		assertFalse(StringUtility.isAlphanumeric(null));
		assertFalse(StringUtility.isAlphanumeric(""));
		assertFalse(StringUtility.isAlphanumeric(" "));
		assertTrue(StringUtility.isAlphanumeric("a"));
		assertTrue(StringUtility.isAlphanumeric("A"));
		assertTrue(StringUtility.isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertFalse(StringUtility.isAlphanumeric("ham kso"));
		assertTrue(StringUtility.isAlphanumeric("1"));
		assertTrue(StringUtility.isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isAlphanumeric("_"));
		assertFalse(StringUtility.isAlphanumeric("hkHKHik*khbkuh"));
	}

	@Test
	public void testIsWhitespace() {
		assertFalse(StringUtility.isWhitespace(null));
		assertTrue(StringUtility.isWhitespace(""));
		assertTrue(StringUtility.isWhitespace(" "));
		assertTrue(StringUtility.isWhitespace("\t \n \t"));
		assertFalse(StringUtility.isWhitespace("\t aa\n \t"));
		assertTrue(StringUtility.isWhitespace(" "));
		assertFalse(StringUtility.isWhitespace(" a "));
		assertFalse(StringUtility.isWhitespace("a  "));
		assertFalse(StringUtility.isWhitespace("  a"));
		assertFalse(StringUtility.isWhitespace("aba"));
		assertTrue(StringUtility.isWhitespace(" "));
	}

	@Test
	public void testIsAlphaspace() {
		assertFalse(StringUtility.isAlphaSpace(null));
		assertTrue(StringUtility.isAlphaSpace(""));
		assertTrue(StringUtility.isAlphaSpace(" "));
		assertTrue(StringUtility.isAlphaSpace("a"));
		assertTrue(StringUtility.isAlphaSpace("A"));
		assertTrue(StringUtility.isAlphaSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertTrue(StringUtility.isAlphaSpace("ham kso"));
		assertFalse(StringUtility.isAlphaSpace("1"));
		assertFalse(StringUtility.isAlphaSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isAlphaSpace("_"));
		assertFalse(StringUtility.isAlphaSpace("hkHKHik*khbkuh"));
	}

	@Test
	public void testIsAlphanumericSpace() {
		assertFalse(StringUtility.isAlphanumericSpace(null));
		assertTrue(StringUtility.isAlphanumericSpace(""));
		assertTrue(StringUtility.isAlphanumericSpace(" "));
		assertTrue(StringUtility.isAlphanumericSpace("a"));
		assertTrue(StringUtility.isAlphanumericSpace("A"));
		assertTrue(StringUtility.isAlphanumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertTrue(StringUtility.isAlphanumericSpace("ham kso"));
		assertTrue(StringUtility.isAlphanumericSpace("1"));
		assertTrue(StringUtility.isAlphanumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isAlphanumericSpace("_"));
		assertFalse(StringUtility.isAlphanumericSpace("hkHKHik*khbkuh"));
	}

	@Test
	public void testIsNumeric() {
		assertFalse(StringUtility.isNumeric(null));
		assertFalse(StringUtility.isNumeric(""));
		assertFalse(StringUtility.isNumeric(" "));
		assertFalse(StringUtility.isNumeric("a"));
		assertFalse(StringUtility.isNumeric("A"));
		assertFalse(StringUtility.isNumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertFalse(StringUtility.isNumeric("ham kso"));
		assertTrue(StringUtility.isNumeric("1"));
		assertTrue(StringUtility.isNumeric("1000"));
		assertTrue(StringUtility.isNumeric("\u0967\u0968\u0969"));
		assertFalse(StringUtility.isNumeric("\u0967\u0968 \u0969"));
		assertFalse(StringUtility.isNumeric("2.3"));
		assertFalse(StringUtility.isNumeric("10 00"));
		assertFalse(StringUtility.isNumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isNumeric("_"));
		assertFalse(StringUtility.isNumeric("hkHKHik*khbkuh"));
		assertFalse(StringUtility.isNumeric("+123"));
		assertFalse(StringUtility.isNumeric("-123"));
	}

	@Test
	public void testIsNumericSpace() {
		assertFalse(StringUtility.isNumericSpace(null));
		assertTrue(StringUtility.isNumericSpace(""));
		assertTrue(StringUtility.isNumericSpace(" "));
		assertFalse(StringUtility.isNumericSpace("a"));
		assertFalse(StringUtility.isNumericSpace("A"));
		assertFalse(StringUtility.isNumericSpace("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"));
		assertFalse(StringUtility.isNumericSpace("ham kso"));
		assertTrue(StringUtility.isNumericSpace("1"));
		assertTrue(StringUtility.isNumericSpace("1000"));
		assertFalse(StringUtility.isNumericSpace("2.3"));
		assertTrue(StringUtility.isNumericSpace("10 00"));
		assertTrue(StringUtility.isNumericSpace("\u0967\u0968\u0969"));
		assertTrue(StringUtility.isNumericSpace("\u0967\u0968 \u0969"));
		assertFalse(StringUtility.isNumericSpace("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"));
		assertFalse(StringUtility.isNumericSpace("_"));
		assertFalse(StringUtility.isNumericSpace("hkHKHik*khbkuh"));
	}
}