import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScripter {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int count(String word, String script) {
        String[] splitScript = script.split(" ");
        int count = 0;
        for (int i = 0; i < splitScript.length; i++) {
            if (word.equals(splitScript[i]) || splitScript[i].contains("prince")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] unused) {
        String script = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String word = "prince";
        System.out.println(count(word, script));
    }
}