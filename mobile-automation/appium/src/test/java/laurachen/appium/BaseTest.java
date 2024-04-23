package laurachen.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeMethod
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Laura Phone");
//		options.setApp("//Users//laurachen//eclipse-workspace//appium//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp("//Users//laurachen//eclipse-workspace//appium//src//test//java//resources//TikTok_34.2.2_Apkpure.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
//		service.stop();
	}
}
