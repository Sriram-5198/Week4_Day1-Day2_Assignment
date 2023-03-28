package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment1_Nykka {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		ChromeDriver d =new ChromeDriver(opt);
		d.get("https://www.nykaa.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brand = d.findElement(By.xpath("(//a[contains(@class,'css-1mavm7h')])[2]"));
		Actions builder=new Actions(d);
		builder.moveToElement(brand).perform();
		d.findElement(By.id("brandSearchBox")).click();
		Thread.sleep(2000);
		d.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='css-ov2o3v']/a")).click();
		Thread.sleep(2000);
		String title = d.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("The title is verified");
			
		} else {
			System.out.println("The title is not verified");
		}
		WebElement sortBy = d.findElement(By.xpath("//span[text()='Gender']"));
		builder.scrollToElement(sortBy).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[name()='svg' and @class='arrow-icon']")).click();
		d.findElement(By.xpath("(//label[@for='radio_customer top rated_undefined']//div)[2]")).click();
		String srt_By = d.findElement(By.xpath("//span[contains(text(),'Sort By : customer top rated')]")).getText();
		System.out.println(srt_By);
		d.findElement(By.xpath("//a[@id='category']")).click();
		WebElement hair = d.findElement(By.xpath("//li[@class='MegaDropdownHeadingbox']/a[text()='hair']"));
		builder.moveToElement(hair).perform();
		d.findElement(By.linkText("Shampoo")).click();
		
		//String pWindow = d.getWindowHandle();
		Set<String> cWindow = d.getWindowHandles();
		List<String>l=new ArrayList<>(cWindow);
		d.switchTo().window(l.get(1));
		Thread.sleep(2000);
		WebElement ing = d.findElement(By.xpath("//span[text()='Ingredient']"));
		builder.scrollToElement(ing).perform();
		d.findElement(By.xpath("(//*[name()='svg' and @class='arrow-icon'])[8]")).click();
		Thread.sleep(2000);
		WebElement ingr = d.findElement(By.xpath("//span[text()='Ingredient']"));
		builder.scrollToElement(ingr).perform();
		d.findElement(By.xpath("(//label[contains(@class,'control control-checkbox')])[7]//div[2]")).click();
		Thread.sleep(2000);
		String filter = d.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).getText();
		if (filter.contains("Color Protection")) {
			System.out.println("Filter is applied");
		}else {
			System.out.println("Filter is not applied");
		}
		WebElement col = d.findElement(By.xpath("(//div[contains(@class,'css-1rd7vky')])[18]"));
		builder.scrollToElement(col).perform();
		
		d.findElement(By.xpath("(//div[contains(@class,'css-1rd7vky')])[18]/div")).click();
		Set<String> c = d.getWindowHandles();
		for (String each : c) {
			System.out.println(each);
		List<String>li=new ArrayList<>(c);
		d.switchTo().window(li.get(2));	
		}
		d.findElement(By.xpath("//span[contains(text(),'180ml')]")).click();
		String mrp = d.findElement(By.xpath("//div[contains(@class,'css-1d0jf8e')]//span[2]")).getText();
		System.out.println("MRP:" + mrp);
		d.findElement(By.xpath("//button[contains(@class,' css-1qvy369')]")).click();
		d.findElement(By.xpath("//button[@type='button']//*[name()='svg']")).click();
		Thread.sleep(2000);
		d.switchTo().frame(0);
		String tot = d.findElement(By.xpath("//div[contains(@class,'css-15py5ir e25lf6d2')]/span")).getText();
		System.out.println("Grant Total(includes product price + shipping) :" + tot);
		d.findElement(By.xpath("//div[contains(@class,'css-ltzjhp e25lf6d7')]/button")).click();
		d.findElement(By.xpath("(//div[contains(@class,'css-1edwnq3 e9pts8a1')])[3]/button")).click();
		d.findElement(By.xpath("(//img[contains(@class,'css-16z7tzi ek8d9s80')])[2]")).click();
		Thread.sleep(2000);
		String finalPrice = d.findElement(By.xpath("(//div[contains(@class,'css-46b9vi efuv1qx0')])[3]/following-sibling::p")).getText();
		//System.out.println(finalPrice);
		if (tot.contains(finalPrice)) {
			System.out.println("Both Price is same and is verified");
		} else {
			System.out.println("Price is not same");
		}
		d.quit();
	}
	

}
