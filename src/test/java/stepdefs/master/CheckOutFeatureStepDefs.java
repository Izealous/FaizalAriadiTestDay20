package stepdefs.master;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutFeatureStepDefs {
	WebDriver driver;
	String actual;
	
	@Given("User di halaman payment {string}")
	public void user_di_halaman_payment(String string) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.navigate().to(string);
	}

	@When("User memasukkan jumlah beli")
	public void user_memasukkan_jumlah_beli() {
		Select quantity		= new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		quantity.selectByIndex(1);
	}

	@When("User menekan tombol buy dan sistem memprosesnya")
	public void user_menekan_tombol_buy_dan_sistem_memprosesnya() {
		try {
			driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
			
		} catch (WebDriverException e) {}
		
	}

	@When("User berada di halaman {string}")
	public void user_berada_di_halaman(String string) {
	    actual = driver.findElement(By.xpath("//h2[normalize-space()='Payment Process']")).getText();
	    assertEquals(actual, string);
	}

	@When("User memasukkan nomer kartu {string}")
	public void user_memasukkan_nomer_kartu(String string) {
		driver.findElement(By.xpath("//*[@id=\"card_nmuber\"]")).sendKeys(string);
	}

	@When("User memilih bulan")
	public void user_memilih_bulan() {
		Select month = new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
		month.selectByIndex(1);
	}

	@When("User memilih tahun")
	public void user_memilih_tahun() {
		Select year = new Select(driver.findElement(By.xpath("//*[@id=\"year\"]")));
		year.selectByIndex(1);
	}

	@When("User memasukkan cvv code {string}")
	public void user_memasukkan_cvv_code(String string) {
		driver.findElement(By.xpath("//*[@id=\"cvv_code\"]")).sendKeys(string);
	}

	@When("User menekan tombol pay dan sistem memprosesnya")
	public void user_menekan_tombol_pay_dan_sistem_memprosesnya() {
		driver.findElement(By.xpath("//*[@name=\"submit\"]")).click();
	}

	@Then("User harus berada di halaman {string}")
	public void user_harus_berada_di_halaman(String string) {
	    actual = driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/h2")).getAttribute("innerHTML");
	    assertEquals(actual, string);
	}

}
