package laurachen.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseTest {
	
//	@Test
//	public void wifiSettingsName() {
//		
//	// Code to start server
//		// Android Driver , IOSDriver
//		// Appium code - > Appium Server -> Mobile
//		
//		// Actual automation
//		// xpath, id, accessibilityId v, classname, androidUIAutomator v
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//		driver.findElement(By.id("android:id/checkbox")).click();
//		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//		
//		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
//		String expectedTitle = "WiFi settings";
//		Assert.assertEquals(alertTitle, expectedTitle);
//		
//		driver.findElement(By.id("android:id/edit")).sendKeys("Laura Wifi");
//		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
//		
//		// Set wifi name
//		
//		// Stop server
//	}
	
	@Test
	public void loginWithValidCredential() {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(AppiumBy.accessibilityId("Use phone / email / username")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Email / Username']")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fka")).sendKeys("tester042024@gmail.com");
		driver.findElement(By.id("com.zhiliaoapp.musically:id/h8_")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fjp")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fka")).sendKeys("te$ter123");
		driver.findElement(By.id("com.zhiliaoapp.musically:id/h8_")).click();
		
	}
	
	@Test
	public void loginWithInvalidCredential() {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(AppiumBy.accessibilityId("Use phone / email / username")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Email / Username']")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fka")).sendKeys("laurachen@kmail.com");
		driver.findElement(By.id("com.zhiliaoapp.musically:id/h8_")).click();
		String actualText = driver.findElement(By.id("com.zhiliaoapp.musically:id/kb2")).getText();
		String expectedText = "Incorrect account or password";
		Assert.assertEquals(actualText, expectedText);
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fka")).sendKeys("tester042024@gmail.com");
		driver.findElement(By.id("com.zhiliaoapp.musically:id/h8_")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fjp")).click();
		driver.findElement(By.id("com.zhiliaoapp.musically:id/fka")).sendKeys("tester123");
		driver.findElement(By.id("com.zhiliaoapp.musically:id/h8_")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String actualText2 = driver.findElement(By.id("com.zhiliaoapp.musically:id/kb2")).getText();
		String expectedText2 = "Incorrect account or password. 5 attempts remaining. Try again.";
		Assert.assertEquals(actualText2, expectedText2);
		
	}
	
	
	
}
