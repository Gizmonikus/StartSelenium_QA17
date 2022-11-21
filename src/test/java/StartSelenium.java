import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {

    WebDriver wd;//переменная (поле)

    @BeforeMethod
    public void preCondition() {

        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/");
    }

    @Test
    public void testName() {
        System.out.println("test started");
        WebElement element = wd.findElement(By.tagName("a"));//найдет метод(ссылку)
        List<WebElement> elements = wd.findElements(By.tagName("div"));
        System.out.println(elements.size());
        wd.findElement(By.linkText("HOME"));//найти элемент
        wd.findElement(By.partialLinkText("HO"));//найти что то с частью текста
        wd.findElement(By.id("root"));
    }

    @Test
    public void testLogin() {
        System.out.println("test completed");
    }

    @AfterMethod
    public void postCondition() {
//wd.close();//закрывает открытую вкладку
wd.quit();//выходит из браузера
    }

}
