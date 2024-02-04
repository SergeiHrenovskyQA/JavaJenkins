package org.example;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test1 {

    @Test
    public void test1() {
        boolean r = getBoolTrue();
        Assert.assertTrue(r);
        boolean r2 = getBoolFalse();
        Assert.assertTrue(r2);
    }

    @Step(value = "Step 1")
    @Description(value = "Тест проверяет эквивалентность единицы единице")
    public boolean getBoolTrue() {

        return true;
    }

    @Step(value = "Step 2")
    public boolean getBoolFalse() {

        return false;
    }

    @Attachment(value = "image", type = "image/png")
    public byte[] attachImage(String imagePath) {
        try {
            Path path = Paths.get(imagePath);

            InputStream imageStream = new FileInputStream(imagePath);

            Allure.attachment("image", imageStream);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @AfterClass
    public void addImg() {
        attachImage("src/main/resources/image.png");
    }
}
