package net.zmau.sepaarchive;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SepaReader {

    private final static String SITE_ADDRESS = "http://www.amskv.sepa.gov.rs/android/pregledpodataka.php?stanica=70&fbclid=IwAR2ezkHiUXsKCwPJAtzWZotzEPBsPjzh5HUw6HUuM5UkreVMbYUOx-eFEeY" ;
    private final static String FILE_PATH = "E:\\beleške\\latin_hidrologija_izvestajne_bezprognoza.php_hm_id=42040.html";
    private final static String TABLE_START = "<table id=\"pregledtabela\"";
    private final static String CHROME_DRIVER_PATH = "C:\\dev\\SepaArhivar\\chromedriver.exe";
    private final static String FIREFOX_DRIVER_PATH = "C:\\dev\\SepaArhivar\\geckodriver.exe"; //FF 80.0.1, Gecko 0.28.0, sel 2.8.0.
    private final static String GECKO26_DRIVER_PATH = "C:\\dev\\SepaArhivar\\lib\\geckodriver26.exe"; //FF 80.0.1, Gecko 0.28.0, sel 2.8.0.

    public String GetHtml() {
        /*System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        System.setProperty("webdriver.gecko.driver", GECKO26_DRIVER_PATH);
        System.setProperty("webdriver.firefox.marionette", FIREFOX_DRIVER_PATH);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("marionette", true);
        FirefoxOptions opt = new FirefoxOptions();
        opt.merge(dc);*/
        WebDriverManager.chromedriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriver driver= new InternetExplorerDriver();
        //WebDriver driver= new ChromeDriver();

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Launching the Site.
        driver.get("SITE_ADDRESS");
        js.executeScript("ucitajgrafikon('satni24h','TabTop1');");
        WebElement table = driver.findElement(By.id("pregledtabela"));
        return table.getText();
    }

    public List<DataItem> GetData() throws Exception{

        return null;
    }
}
