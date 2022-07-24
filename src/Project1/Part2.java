package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");
        driver.manage().window().maximize();

        String userName = "ttechno@gmail.com";
        WebElement enterUserName = driver.findElement(By.cssSelector("#username"));
        enterUserName.sendKeys(userName);

        String password = "techno123.";
        WebElement enterPassword = driver.findElement(By.cssSelector("#password"));
        enterPassword.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("#log-in"));
        submitButton.click();

        WebElement headerText = driver.findElement(By.cssSelector("#time"));
        String str = headerText.getText();
        System.out.println(str);

        String url = driver.getCurrentUrl();
        System.out.println("url: " + url);

        Thread.sleep(3000);

        driver.quit();

    }
}
