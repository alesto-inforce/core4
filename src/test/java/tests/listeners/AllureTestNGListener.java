package tests.listeners;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.Base;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllureTestNGListener extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String screenshotName = iTestResult.getMethod().getMethodName()+System.currentTimeMillis();
        takeScreenshot(screenshotName);
        Path content = Paths.get("src/test/screenshots/"+screenshotName+".png");
        try(InputStream is = Files.newInputStream(content)){
            Allure.addAttachment("Screenshot on failure",is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO screenshot on failure is not working !
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}