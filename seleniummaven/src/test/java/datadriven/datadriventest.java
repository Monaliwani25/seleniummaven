package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import seleniummaven.xlsreader;

public class datadriventest {

	public static void main(String[] args) throws Exception {

		xlsreader reader = new xlsreader(
				"C:\\Users\\UE\\eclipse-workspace\\seleniummaven\\src\\test\\java\\TestData\\data.xlsx");
		Thread.sleep(5000);
		String firstname = reader.getCellData("RegtestData", "Firstname", 2);
		System.out.println(firstname);

		String lastname = reader.getCellData("RegtestData", "Lastname", 2);
		System.out.println(lastname);

		String address1 = reader.getCellData("RegtestData", "Address1", 2);
		System.out.println(address1);

		String address2 = reader.getCellData("RegtestData", "Address2", 2);
		System.out.println(address2);

		String city = reader.getCellData("RegtestData", "City", 2);
		System.out.println(city);

		String state = reader.getCellData("RegtestData", "State", 2);
		System.out.println(state);

		String zipcode = reader.getCellData("RegtestData", "Zipcode", 2);
		System.out.println(zipcode);

		String email = reader.getCellData("RegtestData", "Emailaddress", 2);
		System.out.println(email);

		System.setProperty("webdriver.chrome.driver", "D:\\SOFT\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		
		Select s = new Select(driver.findElement(By.name("state")));
		s.selectByVisibleText(state);
		driver.findElement(By.name("zip")).sendKeys(zipcode);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("retype_email")).sendKeys(email);

	}

}
