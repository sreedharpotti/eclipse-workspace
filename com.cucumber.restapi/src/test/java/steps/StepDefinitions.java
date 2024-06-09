package steps;

import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinitions {
	
	private Response response;
	
	//@When("^I send a GET request to \"([^\"]*)\"$")
	@When("I send GET request to {string}")
	public void sendGetRequest(String RequestURL) {
        response = RestAssured.get(RequestURL);
	}

	@Then("^the response status code should be (\\d+)$")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
	
    @Then("the response region contains {string}")
    public void theResponseContains(String StringContains) {
       // assertEquals(response.jsonPath().getString("region"), StringContains);
        List<String> regions = response.jsonPath().getList("region");
        for (String region : regions) {
            assert region.equals(StringContains) : "Expected region: " + StringContains + ", Actual region: " + region;
        }
    }
    
    @Then("the failed response status code should be {int}")
    public void failedResCode(int Code) {
        Assert.assertEquals(response.getStatusCode(), Code);
    }
    
}