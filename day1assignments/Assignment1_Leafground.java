package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1_Leafground {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        d.findElement(By.xpath("//span[text()='Open']")).click();    
        String pWindow = d.getWindowHandle(); 
        Set<String> wh = d.getWindowHandles();
		//System.out.println(wh.size());
		List<String>l=new ArrayList<>(wh);
		d.switchTo().window(l.get(1));
		Thread.sleep(2000);
		String title = d.getTitle();
		if (title.contains("Dashboard")) {
			System.out.println("New window is opened");
		}else {
			System.out.println("New window is not opened");
		}
		Thread.sleep(2000);
		d.close();
		d.switchTo().window(pWindow);
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[contains(text(),'Open Multiple')]")).click();
		Set<String> wi = d.getWindowHandles();
		System.out.println("The number of opened tabs: " + wi.size());
		List<String>la=new ArrayList<>(wi);
		d.switchTo().window(la.get(1));
		d.close();
		d.switchTo().window(la.get(2));
		d.close();
        d.switchTo().window(pWindow);
		d.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Set<String> wk = d.getWindowHandles();
		System.out.println(wk.size());
		List<String>li=new ArrayList<>(wk);
//		for (String ss : li) {
//			if (!ss.equals(li)) {
//				d.switchTo().window(ss);
//				Thread.sleep(2000);
//				d.close();
//			}
//		}
		d.switchTo().window(li.get(1));
		d.close();
		d.switchTo().window(li.get(2));
		d.close();
		d.switchTo().window(li.get(3));
		d.close();
		d.switchTo().window(pWindow);
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[contains(text(),'Open with delay')]")).click();
		Set<String> wl = d.getWindowHandles();
		System.out.println("The tabs opened " + wl.size());
	}

}
