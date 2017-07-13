import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author Pradnya
 * In this class, captured the total number of result from autosuggestion block while typing the location and verified against the total found result 
 * from result page. 
 */
public class Scenario1 {

	WebDriver driver;
	String baseurl = "https://www.funda.nl";
	Scenario1 sobj;
	String value2;
	
	public Scenario1(){
		driver = new FirefoxDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	void Searchresult(){
		driver.findElement(By.xpath("//footer[@class='app-footer']//a[@title='View funda in English']")).click();
		driver.findElement(By.xpath(".//*[@id='autocomplete-input']")).sendKeys("den haag");
	}
	
	void Verifyresult() throws InterruptedException{
		Thread.sleep(200);
		WebElement resultcount1 = driver.findElement(By.xpath(".//*[@id='autocomplete-list']//div[@class='autocomplete-count']"));
		String result1 = resultcount1.getText();
		System.out.println("The result from autocomplete - " +result1);
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='content']//div[@class='search-block__submit']/button")).click();
		Thread.sleep(400);
		
		WebElement resultcount2 = driver.findElement(By.xpath(".//*[@id='content']//div[@class='search-output-result-count']/span"));
		String result2 = resultcount2.getText();
		
		String result3 = this.getValue(result2);
		System.out.println("The result from result page - " +result3);
		
		if (result1 == result3)
		  System.out.println("Results are matched");
		else
		  System.out.println("Results are mismatched");
	}

	String getValue (String val){
		String[] sepval = val.split("\\s");
		String num = sepval[0];
		return num;
		
	}
}
