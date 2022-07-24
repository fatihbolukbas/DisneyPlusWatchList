package DisneyPlusCreatingWatchList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

public class DisneyPlusWatchList {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.disneyplus.com/tr-tr");
        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Log in
        driver.findElement(By.xpath("//nav[@class='nav pre-sticky']//span[contains(text(),'OTURUM AÇ')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("******");
        driver.findElement(By.xpath("//button[normalize-space()='DEVAM ET']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='show-hide-password']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("*****");
        driver.findElement(By.xpath("//button[normalize-space()='OTURUM AÇ']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='']"))).click();

        //Creating watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='sc-drMfKT jcVTJv hidden item']//p[@class='page-nav page-nav--small text-color--primary margin--left-2 page-nav'][contains(text(),'FİLMLER')]"))).click();

        //Movie 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sc-jqIZGH coIeFH']//div[1]//a[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon icon--plus-watchlist icon--size-24']"))).click();
        driver.navigate().back();

        //Movie 2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[5]//a[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon icon--plus-watchlist icon--size-24']"))).click();
        driver.navigate().back();

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        //Movie 3
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[38]//a[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon icon--plus-watchlist icon--size-24']"))).click();
        driver.navigate().back();

        //Movie 4
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='ARAMA']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-input']"))).sendKeys("spiderman");
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Search results']//div[1]//a[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon icon--plus-watchlist icon--size-24']"))).click();
        Thread.sleep(1000);

        //Editing watch list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'İZLEME LİSTEM')]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/a[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon icon--checkmark-branded icon--size-36']"))).click();

    }
}
