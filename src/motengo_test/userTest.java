package motengo_test;

import java.awt.Desktop.Action;
import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class userTest {

	WebDriver driver = new ChromeDriver();

	String websiteURL = "https://automationteststore.com/";
//	String WebsiteURL2 = "https://www.google.com";

	String[] firstNames = { "ahmad", "ali", "anas", "omar", "ayat", "alaa", "sawsan", "Rama" };
	String[] lastNames = { "Khaled", "mustafa", "Mohammad", "abdullah", "malek", "omar" };

	Random rand = new Random();

	String loginName;
	String password = "Soso@2024";
	String globelFirstName;

	@BeforeTest
	public void getWebsite() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(websiteURL);
		
//		

	}

	@Test(priority = 1 , enabled = false)
	public void signUpTest() throws InterruptedException {

		int randomIndexFirstName = rand.nextInt(firstNames.length);
		int randomIndexLastName = rand.nextInt(lastNames.length);
		int randomNumberForEmail = rand.nextInt(99999);

		String firstName = firstNames[randomIndexFirstName];
		globelFirstName=firstName;
		String lastName = lastNames[randomIndexLastName];

		loginName = firstName + lastName + randomNumberForEmail ; 
		String email = loginName + "@gmail.com";

		driver.findElement(By.linkText("Login or register")).click();

		Thread.sleep(3000);
		
		WebElement createAnAccountbutton = driver.findElement(By.xpath("//button[@title='Continue']"));

		createAnAccountbutton.click();
		

		WebElement firstNameField = driver.findElement(By.id("AccountFrm_firstname"));
		firstNameField.sendKeys(firstName);

		WebElement lastNameField = driver.findElement(By.id("AccountFrm_lastname"));
		lastNameField.sendKeys(lastName);

		WebElement emailField = driver.findElement(By.id("AccountFrm_email"));
		emailField.sendKeys(email);
		
		WebElement address1Field = driver.findElement(By.id("AccountFrm_address_1"));
		address1Field.sendKeys("Um Nuarah");
		
		WebElement cityField = driver.findElement(By.id("AccountFrm_city"));
		cityField.sendKeys("Capital Of");
		
		WebElement CountryField = driver.findElement(By.id("AccountFrm_country_id"));
		Select selector = new Select(CountryField);
		int randomCountry= rand.nextInt(1, 240);
		selector.selectByIndex(randomCountry);
		
		Thread.sleep(3000);
		
		WebElement stateField = driver.findElement(By.id("AccountFrm_zone_id"));
		Select selector2 = new Select(stateField);
		int randomState= rand.nextInt(1, 4);
		selector2.selectByIndex(randomState);
		
		WebElement zipCodeField = driver.findElement(By.id("AccountFrm_postcode"));
		zipCodeField.sendKeys("22222");
		
		WebElement loginNameField = driver.findElement(By.id("AccountFrm_loginname"));
		loginNameField.sendKeys(loginName);

		WebElement passwordField = driver.findElement(By.id("AccountFrm_password"));
		passwordField.sendKeys(password);

		WebElement confirPasswordField = driver.findElement(By.id("AccountFrm_confirm"));
		confirPasswordField.sendKeys(password);

		

		WebElement tearmsbutton = driver.findElement(By.id("AccountFrm_agree"));

		tearmsbutton.click();
		
		Thread.sleep(3000);

		createAnAccountbutton = driver.findElement(By.xpath("//button[@title='Continue']"));

		createAnAccountbutton.click();
	}

	@Test(priority = 2  , enabled = false)
	public void logOutTest() throws InterruptedException {
		Thread.sleep(5000);

		WebElement UserNav = driver.findElement(By.id("customernav"));
		Actions action = new Actions(driver);
		
		action.moveToElement(UserNav).perform();
		
		WebElement logOutButton = driver.findElement(By.linkText( "Not "+ globelFirstName + "? Logoff" ));
		logOutButton.click();
		
		

	}

	@Test(priority = 3 , enabled = false)
	public void signInTest() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Login or register")).click();
		
		WebElement loginNameField = driver.findElement(By.id("loginFrm_loginname"));
		loginNameField.sendKeys(loginName);

		WebElement passwordField = driver.findElement(By.id("loginFrm_password"));
		passwordField.sendKeys(password);
		
		Thread.sleep(5000);
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@title=\"Login\"]"));

		signInButton.click();

	}
	
	
	@Test(priority = 4 , invocationCount = 1)

	public void AddItemToThecart() throws InterruptedException {

		String[] WebSitesForTheItems = { "https://automationteststore.com/index.php?rt=product/category&path=68",
				"https://automationteststore.com/index.php?rt=product/category&path=36",
				"https://automationteststore.com/index.php?rt=product/category&path=43",
				"https://automationteststore.com/index.php?rt=product/category&path=49",
				"https://automationteststore.com/index.php?rt=product/category&path=58",
				"https://automationteststore.com/index.php?rt=product/category&path=52",
				"https://automationteststore.com/index.php?rt=product/category&path=65" };

		int randomIndex = rand.nextInt(WebSitesForTheItems.length);
		driver.get(WebSitesForTheItems[randomIndex]);

		// define for the webelement which is a UL tag
		WebElement ListOfITem = driver.findElement(By.cssSelector(".thumbnails.row"));
		
		
		int numOfItems = ListOfITem.findElements(By.tagName("li")).size();
		
		int randomItem = rand.nextInt(numOfItems);
		
		Thread.sleep(3000);
		
		ListOfITem.findElements(By.tagName("li")).get(randomItem).click();;

		// each UL tag has always a li items (list items ) here i am getting the total
		// number of li inside the ul
//		int totalNumberOfItems = ListOfITem.findElements(By.tagName("li")).size();
		// create a random index based on the total number of items that i got in the
		// previous line
//		int RandomIdexForTheItem = rand.nextInt(totalNumberOfItems);

		// sleep just to see the results before click on the sub category
//		Thread.sleep(3000);

		// inside the sub category i need selenium to click on a random sub category
//		ListOfITem.findElements(By.tagName("li")).get(RandomIdexForTheItem).click();

		// i defined the container of all items in a Container variable to loop over all
		// items inside using the css selector
		WebElement Container = driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
		// we need to see how many items that selenium found inside the container
		int numberOfPRoducts = Container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).size();
		// random index for the item to randomly select one item each time
		int randomIndexForTheproduct = rand.nextInt(numberOfPRoducts);

		// the randomly item that we generated using rand.nextInt we need to click on
		// that item
		Container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).get(randomIndexForTheproduct).click();
		Thread.sleep(5000);
		
		
		// here i have an UL tag which contains either the Add to cart or out of the stock 
		WebElement ULList = driver.findElement(By.className("productpagecart"));
		
		// inside the UL that i found in the previous line of code i am searching about the a tag noting:-
		//(a) tag if the item in the stock and span tag if the item out of the stock
		int LiItem = ULList.findElements(By.tagName("li")).get(0).findElements(By.tagName("span")).size(); 
		int callItem = ULList.findElements(By.tagName("li")).get(0).findElements(By.className("call_to_order")).size();
		
		// this liItem will give me either 0 or 1 ( 0 if the item out of the stock so it will go back to the home page and print a message says that the item out of the stock , if it gives 1 that means the item inside the stock and i can press on the add to cart button by using it's name which is cart 
		if(LiItem>0) {
			driver.get(websiteURL);
			
			System.out.println("sorry the item out of the stock ");
			String ExpectedResult = "https://automationteststore.com/";
			String ActualResult = driver.getCurrentUrl();
			Assert.assertEquals(ActualResult, ExpectedResult, "sosso");
			
		}else if(callItem>0) {
			driver.findElement(By.cssSelector(".fa.fa-phone.fa-fw")).click();;
		}else {
			
			driver.findElement(By.className("cart")).click();;
			
			String ActualResult = driver.findElement(By.className("heading1")).getText();
			String ExpectedResult = "Shopping Cart";
			Thread.sleep(2000);
			Assert.assertEquals(ActualResult, ExpectedResult.toUpperCase());
			boolean ExpectedValueForCheckOut = true;
			boolean ActualValueForCheckOut = driver.findElement(By.id("cart_checkout1")).isDisplayed();
			Assert.assertEquals(ActualValueForCheckOut, ExpectedValueForCheckOut, "soso hi");


		}
	}

	@AfterTest
	public void endTest() {
	}
}
