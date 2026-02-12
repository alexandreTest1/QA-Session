package ge.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FormPage {

    public Locator enterFirstName, enterLastName, enterUserEmail, markGender, enterUserNumber, enterSubjectsText,
            hobbieSports,hobbieMusic, enterCurrentAdress, selectState,selectSingleState, selectCity,selectSingleCity, submitButton;


    public FormPage(Page page){

        this.enterFirstName = page.locator("#firstName");
        this.enterLastName = page.locator("#lastName");
        this.enterUserEmail = page.locator("#userEmail");
        this.markGender = page.locator("label[for='gender-radio-2']");
        this.enterUserNumber = page.locator("#userNumber");
        this.enterSubjectsText = page.locator("#subjectsInput");
        this.hobbieSports = page.locator("label[for='hobbies-checkbox-1']");
        this.hobbieMusic = page.locator("label[for='hobbies-checkbox-3']");
        this.enterCurrentAdress = page.locator("#currentAddress");
        this.selectState = page.locator("#state");
        this.selectSingleState = page.locator("#react-select-3-option-0");
        this.selectCity = page.locator("#city");
        this.selectSingleCity = page.locator("#react-select-4-option-0");
        this.submitButton = page.locator("#submit");


    }
}
