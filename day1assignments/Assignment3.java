package week4.day1assignments;

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
		
		d.get("https://www.irctc.co.in/nget/train-search");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        d.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
        Thread.sleep(2000);
        Set<String> wh = d.getWindowHandles();
        //System.out.println(wh.size());
        for (String s : wh) {
        	System.out.println(s);	
		}
        List<String>l=new ArrayList<>(wh);
        d.switchTo().window(l.get(1));
        String title = d.getTitle();
        System.out.println(title);
        
        File src = d.getScreenshotAs(OutputType.FILE);
        File dest= new File("./snaps/flight.png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot is taken");
        
	}

}
