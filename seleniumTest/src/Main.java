import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver driver;

    public void invokeDriver(){

        try {
            System.setProperty("webdriver.chrome.driver", "/home/rajon/Downloads/Rajon/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("https://www.gmail.com/");

            searchHtmlTemplate();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void searchHtmlTemplate(){
        try {
            driver.findElement(By.id("identifierId")).sendKeys("rajon.seu.cse@gmail.com");
            driver.findElement(By.className("ZFr60d CeoRYc")).click();

            String actualTitle = driver.getTitle();
            String expectedTitle = "gmail";

            if (actualTitle.equals(expectedTitle)){
                System.out.println("Test Success");
            }
            else {
                System.out.println("Test Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main selenium = new Main();
        selenium.invokeDriver();
    }
}
