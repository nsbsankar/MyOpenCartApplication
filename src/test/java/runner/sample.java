package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        String placeholder = driver.findElement(By.id("input-email")).getAttribute("placeholder");
        System.out.println(placeholder);
        driver.close();
    }
}
