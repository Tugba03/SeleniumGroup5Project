package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario2 {
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

        WebElement addPromoCode = driver.findElement(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']"));
        addPromoCode.click();

        WebElement promoCodeBox =driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCodeBox.sendKeys("123456789");

        Thread.sleep(2000);

        WebElement applyBtn =driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        applyBtn.click();

        Thread.sleep(2000);

        WebElement invalidPromoCode = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));
        boolean isDisplayedAfterClick = invalidPromoCode.isDisplayed();

        System.out.println(isDisplayedAfterClick);
        System.out.println(invalidPromoCode.getText());

    }
}
