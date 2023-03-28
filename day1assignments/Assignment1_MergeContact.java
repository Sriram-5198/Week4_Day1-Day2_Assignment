package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1_MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("http://leaftaps.com/opentaps/control/login");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.findElement(By.xpath("//p[@class='top']/input")).sendKeys("DemoCSR");
		d.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("crmsfa");
		d.findElement(By.xpath("//input[@id='password']/following::input[@class='decorativeSubmit']")).click();
		d.findElement(By.xpath("//div[@id='label']/a")).click();
		d.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
		d.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		d.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Thread.sleep(2000);
		String pWindow = d.getWindowHandle();
		
		Set<String> wh = d.getWindowHandles();
	        List<String>l=new ArrayList<>(wh);
	        d.switchTo().window(l.get(1));
        Thread.sleep(2000);
		d.findElement(By.xpath("//a[@class='linktext']")).click();
		Thread.sleep(2000);
		d.switchTo().window(pWindow);
		
		d.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> ww = d.getWindowHandles();
        List<String>li=new ArrayList<>(ww);
        d.switchTo().window(li.get(1));
        Thread.sleep(2000);
		d.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		d.switchTo().window(pWindow);
		d.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(2000);
		d.switchTo().alert().accept();
		Thread.sleep(2000);
		String ttl = d.getTitle();
		System.out.println(ttl);
		
	}

}
