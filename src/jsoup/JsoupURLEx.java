package jsoup;
/*
 * http://jsoup.org/  官方網站 (含jar檔下載)
 * http://www.open-open.com/jsoup/ (中文教學網站，簡體字請慎入...)
 */

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupURLEx {
	private static final String URL = "http://www.appledaily.com.tw";

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect(URL).get();
		if (doc != null) {
			Elements urls = doc.select(".mrt > li > a");
			for (Element e : urls) {
				String url = URL + e.attr("href");
				String title = e.text();
				System.out.println(url);
				System.out.println(title);
			}
		}

	}
}
