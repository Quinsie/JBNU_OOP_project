package map;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Map {
	private WebDriver driver;
	private WebElement element;
	
	//Properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "D:\\jbnu\\chromedriver.exe";
	
	public static void main(String[] args) {
		Map test = new Map();
		test.oper();
	}
	
	private String url;
	private String time;
	
	public Map() {
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
		
		url = "https://map.naver.com/v5/directions/-/-/-/transit?c=14151924.8249911,4278274.1622803,15,0,0,0,dh";
	}
	
	public void oper() {
		try {
			//get 방식으로 url 요청
			driver.get(url);
			Thread.sleep(300);
			
			//도보 길찾기 선택
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/div[1]/ul/li[3]"));
			element.click();
			
			//start 입력
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"directionStart0\"]")); 
			element.sendKeys("전북대학교 공과대학 1호관");
			
			//엔터 입력
			Thread.sleep(300);
			element.sendKeys(Keys.ENTER);
			
			//시작 지점 선택
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/directions-search-list/search-list/search-list-contents/perfect-scrollbar/div/div[1]/div/div/div/search-item-place"));
			element.click();
			
			//end 입력
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"directionGoal1\"]")); 
			element.sendKeys("전북대학교 공과대학 7호관");
			
			//엔터 입력
			Thread.sleep(300);
			element.sendKeys(Keys.ENTER);
			
			//도착 지점 선택
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/directions-search-list/search-list/search-list-contents/perfect-scrollbar/div/div[1]/div/div/div/search-item-place"));
			element.click();
			
			//길찾기 누르기
			Thread.sleep(300);
			element = driver.findElement(By.xpath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/div[1]/directions-search/div[2]/button[3]"));
			element.click();		
			
			//time = driver.findElement(By.cssSelector("#container > shrinkable-layout > div > directions-layout > directions-result > div.main > directions-summary-list > directions-hover-scroll > div > ul > li > directions-summary-item-walking > div.summary_box > strong > readable-duration > span.value.ng-star-inserted"));
			
			//List<WebElement> webElement = driver.findElements(By.xpath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/directions-summary-list/directions-hover-scroll/div/ul/li/directions-summary-item-walking/div[1]/strong/readable-duration/span[1]"));
			
			//WebElement list = (WebElement) driver.findElement(By.xpath("#container > shrinkable-layout > div > directions-layout > directions-result > div.main > directions-summary-list > directions-hover-scroll > div > ul > li > directions-summary-item-walking > div.summary_box > strong > readable-duration > span.value.ng-star-inserted"));
			
			
			//도보에 드는 시간 가져와서 출력하기
			Thread.sleep(1000);
			element = driver.findElement(By.cssSelector("span.value"));
			System.out.println(element.getText());
					
			Thread.sleep(15000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
	
//	public void data() {
//		//fast_time = driver.findElementByXPath("//*[@id=\"container\"]/shrinkable-layout/div/directions-layout/directions-result/div[1]/directions-summary-list/directions-hover-scroll/div/ul/li/directions-summary-item-walking/div[1]/strong/readable-duration/span[1]");
//		String time = driver.findElement(By.cssSelector(""));
//	}
}
