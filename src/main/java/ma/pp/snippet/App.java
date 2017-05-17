package ma.omaroun.snippet;

import java.io.IOException;

import ma.omaroun.snippet.google.search.GoogleSearch;

/**
 * @author aboufaris
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		System.out.println(GoogleSearch.search("omar el alaoui aboufaris", 5));
	}

}
