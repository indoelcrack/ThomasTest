package PackThomas;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Thomas {
	
	private WebDriver driver;
	
	public Thomas(WebDriver driver){
		this.driver = driver;
	} 

	public boolean Thomass() {
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		String url = "";
		List<String> BrokenLinks = new ArrayList<String>();
		List<String> OkLinks = new ArrayList<String>();
		
		HttpURLConnection httpConnection = null;
		int responseCode = 200;
		Iterator<WebElement> it = Links.iterator();
		
		while(it.hasNext()){
			url = it.next().getAttribute("href");
			if (url==null || url.isEmpty()){
				System.out.println(url + " url no esta configurada o vacia");
				continue;
			}
			try {
				httpConnection = (HttpURLConnection)(new URL(url).openConnection());
				httpConnection.setRequestMethod("HEAD");
				httpConnection.connect();
				responseCode = httpConnection.getResponseCode();
				
				if(responseCode>400) {
					System.out.println("Error Link Caido -- " + url);
					BrokenLinks.add(url);
				}
				else {
					System.out.println("Link Valido -- " + url);
					OkLinks.add(url);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println("Links Validos: " + OkLinks.size());
		System.out.println("Links Invalidos: " + BrokenLinks.size());
		
		if (BrokenLinks.size()>0) {
			System.out.println("===== ERROR --------------------- LINKS CAIDOS");
			for (int i = 0; i < BrokenLinks.size(); i++) {
				System.out.println(BrokenLinks.get(i));
			}
			return false;
		} else 
		{
			return true;
		}
		
	}
}
