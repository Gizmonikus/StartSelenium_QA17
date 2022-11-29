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

        //============================CW===============================
        wd.findElement(By.cssSelector("[href='/login']"));
        wd.findElement(By.cssSelector("[href^='/lo']"));//начинается с текста
        wd.findElement(By.cssSelector("[href*='og']"));//все элементы содержащие "og"
        wd.findElement(By.cssSelector("[href$='gin']"));//элемент заканчивающийся на "gin" /no xPath for that

        List<WebElement> buttons = wd.findElements(By.tagName("button"));

        //=============================HW22.11.2022====================
        wd.findElement(By.cssSelector("[href='/about']"));
        wd.findElement(By.cssSelector("[href^='/abo']"));//начинается на "abo"
        wd.findElement(By.cssSelector("[href$='ut']"));
        wd.findElement(By.cssSelector("[href*='bou']"));
        wd.findElement(By.cssSelector("[href='/home']"));
        wd.findElement(By.cssSelector("[href^='/ho']"));
        wd.findElement(By.cssSelector("[href*='ome']"));
        wd.findElement(By.cssSelector("[class='container']"));
        wd.findElement(By.cssSelector("#root"));
        //======================================25.11.2022_Xpath=============
        wd.findElement((By.cssSelector("a")));
        wd.findElement(By.xpath("//a"));
        wd.findElement(By.xpath("//*[@id='root']"));//найти все элементы с таким атрибутом
        wd.findElement(By.xpath("//*[@href='/login']"));
        wd.findElement(By.xpath("//*[starts-with(@href,'/lo')]"));//начинается на "lo"
        wd.findElement(By.xpath("//*[contains(@href,'og')]"));//элемент содержащий "og"
        wd.findElement(By.xpath("//*[text()='HOME']"));
        wd.findElement(By.xpath("//*[.='HOME']"));

        //=====================================HW25.11.2022=================
        wd.findElement(By.cssSelector("[href='/about']"));
        wd.findElement(By.xpath("//*[@href='/about']"));
        wd.findElement(By.cssSelector("[href^='/abo']"));
        wd.findElement(By.xpath("//*[starts-with(@href,'/abo')]"));
        wd.findElement(By.cssSelector("[href$='ut']"));
        wd.findElement(By.xpath("//*[contains(@href,'ut')]"));
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
