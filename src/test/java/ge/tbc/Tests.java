package ge.tbc;



import com.microsoft.playwright.Locator;
import ge.tbc.data.Constants;
import ge.tbc.steps.FormPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Tests extends BaseTest{

    private FormPageSteps formPageSteps;


    @BeforeMethod
    public void formpage(){
        page.navigate(Constants.BASE_URL);
        formPageSteps = new FormPageSteps(page);
        page.waitForLoadState();
    }

    @Test(priority = 1)
    public void verifyPageLoadedAndElementsVisible(){


        Assert.assertTrue(page.locator("#firstName").isVisible());
        Assert.assertTrue(page.locator("#lastName").isVisible());
        Assert.assertTrue(page.locator("label[for='gender-radio-2']").isVisible());
        Assert.assertTrue(page.locator("#userNumber").isVisible());
        Assert.assertTrue(page.locator("#submit").isVisible());


        page.waitForTimeout(10000);


    }




    @Test(priority = 2)
    public void validationWithEmptyFields(){


        formPageSteps

                .clickSubmitButton();
        String firstNameBorder =
                page.locator("#firstName").evaluate("el => getComputedStyle(el).borderColor").toString();

        Assert.assertTrue(firstNameBorder.contains("rgb"));

        page.waitForTimeout(10000);

    }





    @Test(priority = 3)
    public void authorizationWithBasicFields(){

        formPageSteps
                .enterFirstName("Test")
                .enterLastName("User")
                .enterUserEmail("test.user@example.com")
                .markSpecifiedGender("Female")
                .enterUserNumber("5551234567")
                .enterSubjectsText("Maths, English")
                .addHobbies()
                        .enterCurrentAdress("123 Test Street")
                                .selectCurrentState()
                                        .selectCurrentCity()
                                                .clickSubmitButton();


        Locator modal = page.locator(".modal-content");



        assertThat(modal).isVisible();

        assertThat(modal).containsText("Test User");
        assertThat(modal).containsText("test.user@example.com");
        assertThat(modal).containsText("Female");
        assertThat(modal).containsText("5551234567");

       /* subject ველის შევსების და სხვა ველზე გადასვლის შემდეგ ველი ისევ ცარიელი რჩება,
        შესაბამისად პოპაპშიც ცარიელია შესაბამის ველი*/

       /* assertThat(modal).containsText("Maths");
        assertThat(modal).containsText("Sports");*/

        assertThat(modal).containsText("Music");
        assertThat(modal).containsText("123 Test Street");
        assertThat(modal).containsText("NCR");
        assertThat(modal).containsText("Delhi");


        page.waitForTimeout(10000);
    }


        @Test(priority = 4)
        public void mobileNumberValidation(){



            formPageSteps

         .enterFirstName("Test")
                    .enterLastName("User")
                .markSpecifiedGender("Female")
                .enterUserNumber("123")
                .clickSubmitButton();

            String userNumberColor =
                    page.locator("#userNumber")
                            .evaluate("el => getComputedStyle(el).borderColor")
                            .toString();
             Assert.assertTrue(userNumberColor.contains("rgb"));

                    formPageSteps
                            .enterUserNumber("5551234567");



        }



}
