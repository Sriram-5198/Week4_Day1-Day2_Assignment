package week4.day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment2_Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		ChromeDriver d =new ChromeDriver(opt);
		d.get("https://www.snapdeal.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement mensFashion = d.findElement(By.xpath("//span[@class='catText']"));
		Actions builder= new Actions(d);
		builder.moveToElement(mensFashion).perform();
		d.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]")).click();
		String totalCount = d.findElement(By.xpath("//span[contains(@class,'category-name category-count')]")).getText();
		System.out.println("The total count of sports shoes: " + totalCount);
		Thread.sleep(2000);
		d.findElement(By.xpath("(//a[contains(@class,'child-cat-node dp-widget-link hashAdded')])[3]")).click();
		WebElement scrol = d.findElement(By.xpath("(//div[contains(@class,'clearfix rating av-rating')])[3]"));
		builder.scrollToElement(scrol).perform();
		String beforeSort = d.findElement(By.xpath("//span[contains(@class,'lfloat product-price')]")).getText();
		System.out.println(beforeSort);
		Thread.sleep(3000);
		d.findElement(By.xpath("//i[contains(@class,'sd-icon sd-icon-expand-arrow sort-arrow')]")).click();
		d.findElement(By.xpath("//ul[contains(@class,'sort-value')]/li[2]")).click();
		WebElement scroll = d.findElement(By.xpath("(//div[contains(@class,'clearfix rating av-rating')])[3]"));
        builder.scrollToElement(scroll).perform();
       String afterSort = d.findElement(By.xpath("//span[contains(@class,'lfloat product-price')]")).getText();
       System.out.println(afterSort);
       
        if (beforeSort.equals(afterSort)) {
			System.out.println("Shoes are not sorted");
		} else {
			System.out.println("Shoes are sorted by Price low to high");
		}
        Thread.sleep(2000);
        d.findElement(By.name("fromVal")).click();
        d.findElement(By.name("fromVal")).sendKeys("900");
        d.findElement(By.name("toVal")).click();
        d.findElement(By.name("toVal")).sendKeys("1200");
        d.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line btn-theme-secondary')]")).click();
        d.findElement(By.xpath("(//div[contains(@class,'sdCheckbox filters-list ')])/label")).click();
        Thread.sleep(2000);
        String Filters = d.findElement(By.xpath("//div[@class='filters']")).getText();
        System.out.println("Filters are applied: " + Filters);
        WebElement hover = d.findElement(By.xpath("//a[contains(@class,'dp-widget-link noUdLine hashAdded')]"));
         builder.moveToElement(hover).perform();
         d.findElement(By.xpath("//div[contains(text(),'View')]")).click();
         String Price = d.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l clearfix')]")).getText();
	     System.out.println("Cost and discount percentage: " + Price);
	     
	     File src = d.getScreenshotAs(OutputType.FILE);
	     File dest=new File("./snaps/snapdeal.png");
	     FileUtils.copyFile(src, dest);
	     d.findElement(By.xpath("(//i[contains(@class,'sd-icon sd-icon-delete-sign')])[4]")).click();
	     d.close();
	}
	

}
