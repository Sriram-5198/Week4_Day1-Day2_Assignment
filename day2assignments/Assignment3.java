package week4.day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("https://www.amazon.in/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).click();
		d.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("oneplus 9 pro");
		d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String price = d.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		Thread.sleep(2000);
		String customerRating = d.findElement(By.xpath("//span[@class='a-icon-alt']")).getText();
		System.out.println(customerRating);
		
		d.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();	
		Set<String> wh = d.getWindowHandles();
		//System.out.println(wh.size());
		List<String>l=new ArrayList<>(wh);
		d.switchTo().window(l.get(1));
		Thread.sleep(2000);
		File src = d.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/amazon.png");
		FileUtils.copyFile(src,dest);
		System.out.println("The screenshot is taken");
		d.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		String text = d.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']/span[2]")).getText();
		if (text.contains(price)) {
			System.out.println("The price is verified");
		} else {
			System.out.println("The price is not verified");
		}
		d.quit();

	}

}
