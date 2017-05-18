package ma.omaroun.snippet;

import java.io.IOException;

import ma.omaroun.snippet.google.search.GoogleSearch;
import ma.omaroun.snippet.google.search.GoogleSearchResult;

/**
 * @author aboufaris
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		
		GoogleSearchResult result = GoogleSearch.search("\"elazizi.elalaoui@gmail.com\"", 5);

		System.out.println(result);

	}

}
