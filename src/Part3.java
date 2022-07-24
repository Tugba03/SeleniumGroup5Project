import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tgbso\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();

        String searchText = "Teddy bear";
        WebElement searchTeddyBear = driver.findElement(By.cssSelector("input[class='col-xs-20 searchformInput keyword']"));
        searchTeddyBear.sendKeys(searchText);

        Thread.sleep(2000);

        WebElement clickSearch = driver.findElement(By.cssSelector("span[class='searchTextSpan']"));
        clickSearch.click();

        WebElement searchResult = driver.findElement(By.cssSelector("#searchMessageContainer>div>span"));

        String searchResultText = searchResult.getText();
        System.out.println(searchResultText);

        Thread.sleep(3000);

        String currentURL1 = driver.getCurrentUrl();
        System.out.println("URL 1 : " + currentURL1);

        WebElement snapLogo = driver.findElement(By.cssSelector("div>div[class='header_wrapper']>div>a:nth-of-type(1)>img"));
        snapLogo.click();

        Thread.sleep(3000);

        String currentURL2 = driver.getCurrentUrl();
        System.out.println("URL 2 : " + currentURL2);

        Thread.sleep(3000);

        driver.navigate().back();

        WebElement textElement = driver.findElement(By.id("inputValEnter"));
        String checkText = textElement.getAttribute("value");
        System.out.println(checkText);

        if (searchText.equals(checkText)){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }

        driver.quit();
        }
    }
