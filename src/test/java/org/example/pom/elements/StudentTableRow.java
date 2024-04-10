package org.example.pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StudentTableRow {

    private final WebElement root;

    public StudentTableRow(WebElement root) {
        this.root = root;
    }

    public String getName(){
        return root.findElement(By.cssSelector("td:nth-child(2)")).getText();
    }
    public String getStatus(){
        return root.findElement(By.cssSelector("td:nth-child(4)")).getText();
    }
}
