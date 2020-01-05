package org.JavaP.com;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.FluentWait;
// import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// import com.google.common.base.Function;

import org.openqa.selenium.WebElement;

public class COAOriginAndDestination extends BaseClass {
	private String today;
	@Test
	public void fillWidgetAndSearchOnCOA() throws Exception{
		driver.get("http://www.cheapoair.com");
		
	 // Enter Origin
	 // Enter CityName - LAS
	  String origin = "LAS";
	  typeKeyword(By.cssSelector("input[class= 'form-control pr-4']"), origin);
	  
	 //Wait for element present - Auto suggestion box 
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "ul[class='suggestion-box__list']")));
		 */
	  
		//driver.wind
		  WebDriverWait wait = new WebDriverWait(driver, 10);   //polling time is 500 ms by default
		  wait.until(ExpectedConditions.attributeContains(By.cssSelector("div[class*='suggestion-box__content']"), "class", "visible"));
		 
		  //WebDriverWait abc = new WebDriverWait(driver, 15);
		  
		  //Wait<WebDriver> abcd = new FluentWait<WebDriver>(driver)
	  
	  //you can use fluent wait
		/*
		 * Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver) //1.
		 * .withTimeout(java.time.Duration.ofSeconds(10))
		 * .pollingEvery(java.time.Duration.ofMillis(100));
		 * 
		 * //fluentWait.until(ExpectedConditions.attributeContains(By.cssSelector(
		 * "div[class*='suggestion-box__content']"), "class", "visible"));
		 * fluentWait.until(
		 * 
		 * new Function<WebDriver, Boolean>() { public Boolean apply(WebDriver driver) {
		 * try {
		 * if(driver.findElement(By.cssSelector("div[class*='suggestion-box__content']")
		 * ).getAttribute("class").contains("visible")) return true; } catch(Exception
		 * ex) {} return false; } //2. this function will be import from
		 * com.google.common.base.Function } //3. remove ; );
		 */
	  
	  
	 // Select Value from auto suggestion
	 driver.findElement(By.cssSelector("div[class='position-relative mt-1']>div>div>div>input']")).sendKeys(Keys.TAB); 
	 driver.findElement(By.cssSelector("span[text()= 'Vegas Mccarran intl. airport, Nevada, United States']")).click();
	
	 // Enter Destination
	 // Enter CityName - lAX
	  String destination = "LAX";
	  typeKeyword(By.xpath("//div > div:nth-child(1) > div:nth-child(2) > input]"), destination);
	  
		
	  //Wait for element present - Auto suggestion box 
	  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='suggestion-box__list'](2)")));
		  
	  // Select Value from auto suggestion 
	  driver.findElement(By.cssSelector("div[class='position-relative mt-1']>div>div>div>input']")).sendKeys(Keys.TAB); 
	  //driver.findElement(By.cssSelector("span[text()= ' - Los Angeles, California, United States']")).click();
	  }

	public void datePickerTest() {
		
        //Get Today's number
        today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");
 
        //Click and open the datepickers
        driver.findElement(By.cssSelector("#app > main > section.banner > div > div > div.col-12.col-md-12.col-lg-7.col-xl-6.p-0.px-lg-3 > div > div > div > section > div > div.form-row.calendarDepart > div:nth-child(1) > div > input")).click();
 
        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.cssSelector("#app > main > section.banner > div > div > div.col-12.col-md-12.col-lg-7.col-xl-6.p-0.px-lg-3 > div > div > div > section > div > div.form-row.calendarDepart > div:nth-child(1) > div > div.calendar > div.calendar__wrapper.clearfix > div:nth-child(1) > div:nth-child(3) > div:nth-child(27) > div"));
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
      //Wait for 4 Seconds to see Today's date selected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
        private String getCurrentDay (){
            //Create a Calendar Object
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
     
            //Get Current Day as a number
            int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println("Today Int: " + todayInt +"\n");
     
            //Integer to String Conversion
            String todayStr = Integer.toString(todayInt);
            System.out.println("Today Str: " + todayStr + "\n");
     
            return todayStr;
        }
    }
	
	

