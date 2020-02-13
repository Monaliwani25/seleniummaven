package seleniummaven;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.Googlesearchpage;

public class BrowserTest {

	public static void main(String[] args) {
		
		googlesearch();
	}
	public static void googlesearch() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\SOFT\\chromedriver_win32 (3)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		Googlesearchpage.textboxsearch(driver).sendKeys("Automation step by step");
		Googlesearchpage.buttonsearch(driver).click();
		
		driver.close();
		System.out.println("TEst completeled");
	}

}
