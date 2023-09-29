package stellarburgers.nomoreparties.nomoreparties.createUser;

import io.restassured.response.Response;
import stellarburgers.nomoreparties.nomoreparties.User;

import static io.restassured.RestAssured.given;

public class CreateUser {
    String apiUrl = "https://stellarburgers.nomoreparties.site/";
    private static final String CREATE_URL = "api/auth/register";
    private static final String DELETE_URL = "api/auth/user";


    public Response create(User user) {
        return given()
                .baseUri(apiUrl)
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(CREATE_URL);
    }

    public Response delete(String authToken) {
        return given()
                .baseUri(apiUrl)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .delete(DELETE_URL);
    }
}
