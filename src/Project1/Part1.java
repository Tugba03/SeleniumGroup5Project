package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        String name = "Automation";
        WebElement enterName = driver.findElement(By.id("userName"));
        enterName.sendKeys(name);

        String email = "Testing@gmail.com";
        WebElement enterEmail = driver.findElement(By.id("userEmail"));
        enterEmail.sendKeys(email);

        String currentAddress = "Testing Current Address";
        WebElement enterCurrentAddress = driver.findElement(By.id("currentAddress"));
        enterCurrentAddress.sendKeys(currentAddress);

        String permanentAddress = "Testing Permanent Address";
        WebElement enterPermanentAddress = driver.findElement(By.id("permanentAddress"));
        enterPermanentAddress.sendKeys(permanentAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(3000);

        WebElement textElement = driver.findElement(By.id("name"));
        String text =textElement.getText();
        System.out.println(text);

        WebElement textElement1 = driver.findElement(By.id("email"));
        String text1 =textElement1.getText();
        System.out.println(text1);


        WebElement textElement2 = driver.findElement(By.cssSelector("p#currentAddress"));
        String text2 =textElement2.getText();
        System.out.println(text2);

        WebElement textElement3 = driver.findElement(By.cssSelector("p#permanentAddress"));
        String text3 =textElement3.getText();
        System.out.println(text3);

        driver.quit();
    }
}
