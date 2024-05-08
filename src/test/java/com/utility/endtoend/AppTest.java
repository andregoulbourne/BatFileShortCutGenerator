package com.utility.endtoend;

import com.utility.selenium.SeleniumUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppTest extends SeleniumUtil {

    private static final String TEST_RESOURCES = "/src/test/resources/";

    private static final String TEST_EXE_FILE = "/src/test/resources/testFile.exe";

    @Test
    @Order(1)
    void testUrl_getPage() {
        assertEquals("Generate Short Cut Bat File",driver.getTitle());
    }

    @Test
    @Order(2)
    void testgetElementOnPage(){
        var writeOutPathLabal = driver.findElement(By.xpath("//label[contains(text(), 'Write Out Path:')]")).getText();

        assertEquals("Write Out Path:", writeOutPathLabal);
    }


    @Test
    @Order(3)
    void testgenerateBatFile() throws InterruptedException {
        var shortCutName = "ShortCutName";

        driver.findElement(By.xpath("//input[@name='pathWithEXEFile']")).sendKeys(getPathWithAbsolutePath(TEST_EXE_FILE));

        driver.findElement(By.xpath("//input[@name='writeOutPath']")).sendKeys(getPathWithAbsolutePath(TEST_RESOURCES));

        driver.findElement(By.xpath("//input[@name='shortCutName']")).sendKeys(shortCutName);


        driver.findElement(By.xpath("//button[text()='Generate']")).click();

        waitSeconds(3);


        File result = new File("."+File.separator+TEST_RESOURCES+shortCutName+".bat");

        assertTrue(result.exists());

        assertTrue(result.delete());
    }
}