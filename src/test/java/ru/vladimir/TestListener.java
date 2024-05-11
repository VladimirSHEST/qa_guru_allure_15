//package ru.vladimir;
//
//import io.qameta.allure.Allure;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class TestListener implements TestWatcher {
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        Allure.getLifecycle().addAttachment(
//                "screenshot", "imge/png", "png",
//                ((TakesScreenshot) cause).getScreenshotAs(OutputType.BYTES)
//        );
//    }
//    public void testSuccessful(ExtensionContext context) {
//        Allure.getLifecycle().addAttachment(
//                "screenshot", "imge/png", "png",
//                ((TakesScreenshot) context).getScreenshotAs(OutputType.BYTES)
//        );
//    }
//
//}
