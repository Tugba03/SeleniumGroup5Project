package Project2;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scenario5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement clickAddToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        clickAddToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));

        wait.until(ExpectedConditions.visibilityOf(iFrame1));

        driver.switchTo().frame(iFrame1);

        WebElement clickPayUsingDebitCard = driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        clickPayUsingDebitCard.click();



        WebElement enterEmail = driver.findElement(By.cssSelector("[placeholder='Email']"));
        enterEmail.sendKeys("ttt@gmail.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("ttt@gmail.com");


        WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        nameOnCard.sendKeys("Daniel");

        WebElement phoneNumber = driver.findElement(By.cssSelector("[placeholder='Optional']"));
        phoneNumber.sendKeys("123456789");

        WebElement companyName = driver.findElement(By.cssSelector("input[autocomplete='company']"));
        companyName.sendKeys("Techno Study");

        WebElement iFrameCard = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));

        wait.until(ExpectedConditions.visibilityOf(iFrameCard));
        driver.switchTo().frame(iFrameCard);

        WebElement cardNumber = driver.findElement(By.cssSelector("input[class='InputElement is-empty Input Input--empty']"));
        cardNumber.sendKeys("4242 4242 4242 4242");


        WebElement cardExpiration = driver.findElement(By.cssSelector("input[placeholder='MM / YY']"));
        cardExpiration.sendKeys("12/22");

        WebElement CvcInput = driver.findElement(By.name("cvc"));
        CvcInput.sendKeys("000");

        driver.switchTo().parentFrame();

      WebElement payButton = driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
      payButton.click();


        driver.get("https://www.fatfreecartpro.com/ecom/rp.php?rdffc=true&txn_id=st-ch_3LTq24FWSmRjvnlt1YIpgKfL&payer_email=ttt%40gmail.com&client_id=341695&c_id=158230641&c_enc=9a37bb92e69e6e1ec57e4bc6acf33b4e&cart_metadata=%7B%22gtag%22%3A%7B%22gtag%22%3A%22UA-273877-2%22%2C%22_ga%22%3A%222.77342101.1669165154.1659803958-1999009756.1659803958%22%7D%2C%22fbp%22%3A%7B%22fbp%22%3A%221714673711932838%22%7D%2C%22cart_source%22%3A%22https%3A%2F%2Fshopdemo.e-junkie.com%2F%22%2C%22em_updates%22%3Atrue%7D&&pending_reason=&_ga=2.77342101.1669165154.1659803958-1999009756.1659803958&&gajs=&auser=&abeacon=&");


      WebElement thankYouMessage = driver.findElement(By.xpath("//span[text()=' your order is confirmed. Thank you!']"));
        System.out.println(thankYouMessage.getText());

        if (thankYouMessage.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }





    }
}