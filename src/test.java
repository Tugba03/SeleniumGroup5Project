import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedInput = "teddy bear";

        driver.get("https://www.snapdeal.com/");
                driver.manage().window().maximize();

        WebElement textElement = driver.findElement(By.id("#inputValEntered"));
        String checkText = textElement.getText();
        System.out.println(checkText);
    }
}
