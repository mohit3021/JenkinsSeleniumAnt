package Pack;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;
import com.sun.jna.platform.win32.Version;

public class BMP100Upload {
String var1="MohitFileRoom12";


WebDriver driver;
	@BeforeMethod
	public void mtBet() throws InterruptedException, MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ankit\\Desktop\\WorkData\\chromedriver.exe");
		 driver=new ChromeDriver();
		  
		 driver.manage().window().maximize();
		 
		 /*DesiredCapabilities dc=DesiredCapabilities.firefox();
			dc.setCapability("version", "47.0");
			dc.setCapability("platform", "Windows 7");
			driver=new RemoteWebDriver(new URL("http://mohitkumarsharma1:a972ccf9-23e8-43e2-83a1-42c8f518dc92@ondemand.saucelabs.com:80/wd/hub"), dc);
			
			//driver=new RemoteWebDriver(new URL("http://mohitkumarsharma1:a972ccf9-23e8-43e2-83a1-42c8f518dc92@ondemand.saucelabs.com:80/wd/hub"), dc);
			*/
		 
		 System.out.println("****************Hitting URL on Browser***************");
		 driver.get("https://stage-web.core.merrillcorp.com");
		  
		 //Thread.sleep(4000);
		 
	}
	
	@Test
	public void applicationLogin() throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("username"))));
		
		System.out.println("****************Login Application***************");
		driver.findElement(By.id("username")).sendKeys("sanity24@gmail.com");
		driver.findElement(By.id("password")).sendKeys("test@123");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		
		
		//WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//span[text()='DOCUMENTS']"))));
		
		System.out.println("****************clicing on doucment***************");
		
		driver.findElement(By.xpath(".//span[text()='DOCUMENTS']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[@class='text-uppercase ng-binding']"))));
		//Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@class='text-uppercase ng-binding']")).click();
		
		System.out.println("****************Adding Fileroom***************");
		
		driver.findElement(By.xpath(".//*[@name='fileRoomName']")).sendKeys(var1);
		
		driver.findElement(By.xpath(".//*[text()='ADD']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[text()='"+var1+"']"))));
		
		//Thread.sleep(3000);
		
		System.out.println("****************Clicking on Fileroom***************");
		
		driver.findElement(By.xpath(".//*[text()='"+var1+"']")).click();
		
		System.out.println("****************Upload***************");
		
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[text()='UPLOAD']"))));
		
		driver.findElement(By.xpath(".//*[text()='UPLOAD']")).click();
		
		System.out.println("****************Browsing files from desktop***************");
		
		
		
    //Thread.sleep(3000);
    wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[text()='Browse']"))));
		driver.findElement(By.xpath(".//*[text()='Browse']")).click();
		
		Thread.sleep(3000);
		
		
		Runtime.getRuntime().exec("C:\\Users\\Ankit\\Desktop\\upload100.exe");
		
		System.out.println("****************Continue***************");
		
		//Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[text()='Continue']"))));
		driver.findElement(By.xpath(".//*[text()='Continue']")).click();
		Thread.sleep(3000);
		//driver.switchTo().activeElement();
		//System.out.println(driver.findElement(By.xpath(".//*[text()='Cancel']/button[1]")).getText());
		
		System.out.println("****************Upload***************");
		
		driver.findElement(By.xpath(".//*[text()='Upload']")).click();
		//Thread.sleep(9000);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[text()='Finish']"))));
		System.out.println("****************Finish***************");
		
		driver.findElement(By.xpath(".//*[text()='Finish']")).click();
		
		System.out.println("****************Processing time calculation***************");
		String failedtext=driver.findElement(By.xpath(".//span[text()='Failed Files']//preceding::span[1]")).getText();
		System.out.println("privouse failed files: "+failedtext);
		//wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//*[@ng-if='grid.options.enableSelectAll']"))));
		Thread.sleep(3000);
		long startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(".//*[@ng-if='grid.options.enableSelectAll']")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//button[contains(text(),'Mark Read')]"))));
		String successfiletext=driver.findElement(By.xpath(".//button[contains(text(),'Mark Read')]")).getText();
		
		//System.out.println("successprocess "+successfiletext);
		
		Support support=new Support();
		String text=support.test(successfiletext);
		int d= Integer.parseInt(text);
		System.out.println("Total no of file uploaded "+d);
		//System.out.println("text "+text);
		
		int c=0;
		while(d+c!= 100)
		{
	        //System.out.println(d);
			driver.findElement(By.xpath(".//*[text()='"+var1+"']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@ng-if='grid.options.enableSelectAll']")).click();
			Thread.sleep(4000);
			successfiletext=driver.findElement(By.xpath(".//button[contains(text(),'Mark Read')]")).getText();
			text=support.test(successfiletext);
			d= Integer.parseInt(text);
			System.out.println("Total no of file uploaded "+d);
			//System.out.println("text in whilwloop "+text);
		  
			String failedtext1=driver.findElement(By.xpath(".//span[text()='Failed Files']//preceding::span[1]")).getText();
			int a,b;

			a= Integer.parseInt(failedtext);
			b= Integer.parseInt(failedtext1);
			c=b-a;
			System.out.println("Total failed file during this upload: "+c);
		}

		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("Total Processing time is: "+totalTime);

	
		
	}

			
}