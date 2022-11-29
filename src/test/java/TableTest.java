import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");//переходит по ссылке и сохраняет
    }

    @Test
    public void tableTestCSS(){
        WebElement canada = wd.findElement(By.cssSelector("#customers tr:nth-child(8) td:last-child"));
        String text = canada.getText();
        System.out.println(text);
        Assert.assertEquals(text,"Canada");

        //====================================HW=======================================
        List<WebElement> row4 = wd.findElements(By.cssSelector("#customers tr:nth-child(4) td"));
        text = "";
        for(WebElement e : row4){
            System.out.println(e.getText());
            text = e.getText();
            if(text.contains("Mexico")) System.out.println("Yes!");
        }
        System.out.println(text.contains("Mexico"));

        //-------------------HW------------------
        List<WebElement> lastCol = wd.findElements(By.cssSelector("#customers td.last-child"));
        for (WebElement e: lastCol){
            System.out.println(e.getText());//sout
        }

        List<WebElement> tr = wd.findElements(By.cssSelector("#customers tr"));
        for (int i = 0; i < tr.size(); i++){

            if(tr.get(i).getText().contains("Philip Cramer")){
                System.out.println(i+1);
               // return;
            }

        }
        List<WebElement> th = wd.findElements(By.cssSelector("#customers th"));
        System.out.println(th.size());
        Assert.assertEquals(th.size(),3);
    }



    @AfterMethod
    public void tearDown(){
        wd.quit();
    }





}
