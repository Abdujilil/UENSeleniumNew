package com.libraryCT.pages;

import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Student_BasePage {

    public Student_BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[contains(@href,'#books')]")
    public WebElement booksLink;

    @FindBy(xpath = "//a[contains(@href,'borrowing-books')]")
    public WebElement borrowingBooksLink;

    @FindBy(id = "navbarDropdown")
    public WebElement navBarDropdown;
}
