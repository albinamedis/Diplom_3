import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import stellarburgers.nomoreparties.nomoreparties.User;
import stellarburgers.nomoreparties.nomoreparties.createUser.CreateUser;

import static org.hamcrest.CoreMatchers.equalTo;
import static stellarburgers.nomoreparties.nomoreparties.utils.Utils.randomString;

public class CreateUserApiTest {
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);
    @Test
    public void test(){
        User user = new User(randomName,randomEmail,randomPassword);
        System.out.println(randomName+" "+randomEmail+" "+randomPassword);
        CreateUser createUser = new CreateUser();
        Response response = createUser.create(user);
        String authToken = response.path("accessToken");
      /*  if (response.statusCode() != 200) {
            System.err.println("HTTP Status Code: " + response.statusCode());
            System.err.println("Response Body: " + response.body().asString());
        }*/
       // response.then().assertThat().body("success", equalTo(true));
        Response responseDel = createUser.delete(authToken);
        response.then().assertThat().body("success", equalTo(true));
    }
}
