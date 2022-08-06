package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario1 {
    public static void main(String[] args) throws InterruptedException {

        String cartItemAdd="1";
        String cartItemRemove="0";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickAddToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));

        clickAddToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));

        wait.until(ExpectedConditions.visibilityOf(iFrame1));

        driver.switchTo().frame(iFrame1);

        WebElement afterClickMyCart = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[2]/div[1]/span"));
        String verifyCartItem = afterClickMyCart.getText();
        System.out.println("After add item : " + verifyCartItem);

        if (verifyCartItem.equals(cartItemAdd)){

            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

       // Assert.assertFalse(afterClickMyCart.equals(cartItemAdd));

        WebElement removeBtn = driver.findElement(By.xpath("//button[@class='Product-Remove']"));
        removeBtn.click();

        Thread.sleep(3000);

        WebElement continueShopping = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        continueShopping.click();


        driver.switchTo().parentFrame();

        Thread.sleep(2000);

        WebElement verifyAfterRemoving = driver.findElement(By.xpath("(//span[@id='cart_item_nos'])[2]"));
        String ItemCartTextAfterRemoving = verifyAfterRemoving.getText();
        System.out.println("Remove Validation = "+ ItemCartTextAfterRemoving);

       // Assert.assertFalse(verifyAfterRemoving.equals(cartItemRemove));

      if (ItemCartTextAfterRemoving.equals(cartItemRemove)){

            System.out.println("Pass");
      }else {
            System.out.println("Fail");
       }



    }
}
