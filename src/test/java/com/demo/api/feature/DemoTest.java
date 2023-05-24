package com.demo.api.feature;

import com.demo.api.core.BaseTest;
import com.demo.api.dto.request.CreateUserRequest;
import com.demo.api.services.ResgristerService;
import com.demo.api.utils.DataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.demo.api.apipath.Response.*;

public class DemoTest extends BaseTest {

    ResgristerService resgristerService;
    String name, location, email;
    int id;

    @BeforeMethod
    public void setup() {
        resgristerService = new ResgristerService();
        name = DataUtils.getData().getFirstName();
        location = DataUtils.getData().getLocation();
        email = DataUtils.getData().getEmail();
    }

    @Test
    public void createUser() {
        // Create user
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail(email);
        createUserRequest.setName(name);
        createUserRequest.setLocation(location);
        resgristerService.createUser(createUserRequest, token);
        resgristerService.validateStatusCode(201)
                .verifyDataInResponse(NAME_RESPONSE, name)
                .verifyDataInResponse(EMAIL_RESPONSE, email)
                .verifyDataInResponse(LOCATION_RESPONSE, location);

        // Get user
        id = resgristerService.getID();
        resgristerService.getUserWithID(token, id);
        resgristerService
                .validateStatusCode(200)
                .verifyDataInResponse(NAME_RESPONSE, name)
                .verifyDataInResponse(EMAIL_RESPONSE, email)
                .verifyDataInResponse(LOCATION_RESPONSE, location);

        // Delete User
        resgristerService.deleteUserWithID(token, id);

    }
}
