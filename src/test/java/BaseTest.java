import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void openBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
        Configuration.baseUrl="https://unsplash.com";
    }
}
