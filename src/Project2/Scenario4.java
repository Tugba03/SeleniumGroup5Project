package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario4 {
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

        Thread.sleep(2000);

        WebElement enterEmail = driver.findElement(By.cssSelector("[placeholder='Email']"));
        enterEmail.sendKeys("ttt@gmail.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("ttt@gmail.com");

        Thread.sleep(3000);
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
        cardNumber.sendKeys("1111 1111 1111 1111");


        WebElement cardExpiration = driver.findElement(By.cssSelector("input[placeholder='MM / YY']"));
        cardExpiration.sendKeys("01/23");

        WebElement CvcInput = driver.findElement(By.name("cvc"));
        CvcInput.sendKeys("123");

        driver.switchTo().parentFrame();

        WebElement invalidCardText = driver.findElement(By.xpath("//span[text()='Your card number is invalid.']"));
        System.out.println(invalidCardText.getText());

        if (invalidCardText.isDisplayed()){

            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

       // driver.quit();





    }
}
