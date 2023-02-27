package jsoup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupXMLEx {

	// TaoYuan City WIFI hot spots
	public final static String URL = "http://data.tycg.gov.tw/api/v1/rest/datastore/ee54e090-7a79-4c56-a24a-5f1a7c426454?format=xml";

	public static void main(String[] args) throws IOException {
		Document doc = null;
		List<Hotspot> hotspotList = null;
		doc = Jsoup.connect(URL).get();
		if (doc != null) {
			hotspotList = new ArrayList<Hotspot>();
			Elements rows = doc.select("records");
			for (Element row : rows) {
				Hotspot hotspot = getHotspot(row);
				hotspotList.add(hotspot);
			}
		}

		for (Hotspot hotspot : hotspotList) {
			System.out.println(hotspot);
		}
	}

	private static Hotspot getHotspot(Element element) {
		String id = element.select("項次").text();
		String spot_name = element.select("熱點名稱").text();
		String type = element.select("熱點類別").text();
		String district = element.select("鄉鎮市區").text();
		String address = element.select("地址").text();
		Hotspot hotspot = new Hotspot(id, spot_name, type, district,
				address);
		return hotspot;
	}
}
