package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import seleniummaven.xlsreader;

public class Parameterized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\SOFT\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		xlsreader reader = new xlsreader(
				"C:\\Users\\UE\\eclipse-workspace\\seleniummaven\\src\\test\\java\\TestData\\data.xlsx");
		int rowcount = reader.getRowCount("RegtestData");
		
		for (int rownum=2; rownum<=rowcount; rownum++ ) {
			String firstname = reader.getCellData("RegtestData", "Firstname", rownum);
			System.out.println(firstname);

			String lastname = reader.getCellData("RegtestData", "Lastname", rownum);
			System.out.println(lastname);

			String address1 = reader.getCellData("RegtestData", "Address1", rownum);
			System.out.println(address1);

			String address2 = reader.getCellData("RegtestData", "Address2", rownum);
			System.out.println(address2);

			String city = reader.getCellData("RegtestData", "City", rownum);
			System.out.println(city);

			String state = reader.getCellData("RegtestData", "State", rownum);
			System.out.println(state);

			String zipcode = reader.getCellData("RegtestData", "Zipcode", rownum);
			System.out.println(zipcode);

			String email = reader.getCellData("RegtestData", "Emailaddress", rownum);
			System.out.println(email);
			
			driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(firstname);
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			driver.findElement(By.name("address1")).clear();
			driver.findElement(By.name("address1")).sendKeys(address1);
			driver.findElement(By.name("address2")).clear();
			driver.findElement(By.name("address2")).sendKeys(address2);
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys(city);
			
			Select s = new Select(driver.findElement(By.name("state")));
			s.selectByVisibleText(state);
			driver.findElement(By.name("zip")).clear();
			driver.findElement(By.name("zip")).sendKeys(zipcode);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("retype_email")).clear();
			driver.findElement(By.name("retype_email")).sendKeys(email);
		}

	}

}
