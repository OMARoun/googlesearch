package ma.pp.snippet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ma.omaroun.snippet.google.search.GoogleSearch;
import ma.omaroun.snippet.google.search.GoogleSearchResult;

/**
 * Unit test for simple App.
 */
public class GoogleSearchTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public GoogleSearchTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(GoogleSearchTest.class);
	}

	public void testSearch() {
		
		try {
			GoogleSearchResult result1 = GoogleSearch.search("omar el alaoui aboufaris", 10);
			GoogleSearchResult result2 = GoogleSearch.search("\"omar el alaoui aboufaris\"", 10);
			
			assertTrue(result1.getItems().size() <= 10);
			assertTrue(result1.getSize().longValue() > 10L);
			
			assertTrue(result1.getSize().longValue() > result2.getSize().longValue());
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
