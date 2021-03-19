package selenium_core;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String type) {

        DriverManager driverManager;

        switch (type){
            case "CHROME":
                driverManager = new ChromeDriverManager();
                break;
            case "FIREFOX":
                driverManager = new FirefoxDriverManager();
                break;
//          case "IE":
//              driverManager = new IEDriverManager();
//              break;
//          case "EDGE":
//              driverManager = new EDGEDriverManager();
//              break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
}