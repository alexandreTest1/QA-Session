package ge.tbc.steps;

import com.microsoft.playwright.Page;
import ge.tbc.pages.FormPage;

public class FormPageSteps extends FormPage {
    private final Page page;

    public FormPageSteps(Page page){
        super(page);
        this.page = page;
    }



    public FormPageSteps enterFirstName(String firstName){
        enterFirstName.fill(firstName);
        return this;
    }

    public FormPageSteps enterLastName(String lastName){
        enterLastName.fill(lastName);
        return this;
    }

    public FormPageSteps enterUserEmail(String email){
        enterUserEmail.fill(email);
        return this;
    }

    public FormPageSteps markSpecifiedGender(String gender){
        markGender.click();
        return this;
    }


    public FormPageSteps enterUserNumber(String number){
        enterUserNumber.fill(number);
        return this;
    }


    public FormPageSteps enterSubjectsText(String subjectTexs){
        enterSubjectsText.fill(subjectTexs);

        return this;

    }

    public FormPageSteps addHobbies() {
        hobbieMusic.click();
        hobbieSports.click();
        return this;

    }

    public FormPageSteps enterCurrentAdress(String currentAdress){
        enterCurrentAdress.fill(currentAdress);
        return this;
    }


    public FormPageSteps selectCurrentState() {
        selectState.click();
        selectSingleState.click();

        return this;

    }


    public FormPageSteps selectCurrentCity(){
        selectCity.click();
        selectSingleCity.click();
        return this;

    }


    public FormPageSteps clickSubmitButton(){
        page.locator("#submit").scrollIntoViewIfNeeded();
        submitButton.click();
        return this;
    }



}
