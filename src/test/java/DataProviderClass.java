import org.testng.annotations.DataProvider;

public class DataProviderClass
{
    @DataProvider(name="BaselineTest")
    public Object[][] getData() {
        return new Object[][]{{"Baseline"}};
    }

}