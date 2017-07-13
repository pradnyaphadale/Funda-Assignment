import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.lang.String;


/**
 * @author Pradnya
 * In this class, the selected price ranges from From and To dropdown are verified against the prices of result(house details) from result page.
 */
public class Scenario2 {

	WebDriver driver;
	String baseurl = "https://www.funda.nl";
	String priceelement;
	String fromString;
	String toString;
	
	public Scenario2(String fromPrice,String toPrice){
		this.fromString = fromPrice;
		this.toString= toPrice;
		driver = new FirefoxDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	void Searchresult(){
		driver.findElement(By.xpath("//footer[@class='app-footer']//a[@title='View funda in English']")).click();
		driver.findElement(By.xpath(".//*[@id='autocomplete-input']")).sendKeys("voorburg");
		
		Select objselfrom = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundakoopprijsvan")));
		objselfrom.selectByValue(this.fromString);
		int i = Integer.parseInt(this.fromString);
		System.out.println(i);
			
		Select objselto = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundakoopprijstot")));
		objselto.selectByValue(this.toString); 
		int j = Integer.parseInt(this.toString);
		System.out.println(j);
		
		driver.findElement(By.xpath(".//*[@id='content']//div[@class='search-block__submit']/button")).click();
	}
	
	void Verifyprice(){
		String finalpriceelement;
		List<WebElement> allelement = driver.findElements(By.xpath(".//*[@id='content']/form/div[2]//span[@class='search-result-price']"));
		for (WebElement element: allelement) {
			priceelement = element.getText();
			finalpriceelement = this.Onlyprice(priceelement);
			
			if (Integer.parseInt(this.fromString) < Integer.parseInt(finalpriceelement) && Integer.parseInt(this.toString) > Integer.parseInt(finalpriceelement))
				System.out.println("The price is within range - " +finalpriceelement);
			else
				System.out.println("The price is out of range - " +finalpriceelement);
		}
	
	}
	
	private String Onlyprice (String price){
		String[] splitprice = price.split("\\s");
		String finalprice = splitprice[1];
		String finalPrice = finalprice.replaceAll(",", "");
		return finalPrice;
	}
	

}
