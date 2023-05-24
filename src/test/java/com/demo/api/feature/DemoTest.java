package com.demo.api.feature;

import com.demo.api.core.BaseTest;
import com.demo.api.dto.request.CreateUserRequestObject;
import com.demo.api.services.CreateUserService;
import com.demo.api.utils.DataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.demo.api.constants.Response.*;

public class DemoTest extends BaseTest {

    CreateUserService createUserService;
    String name, location, email;
    int id;

    @BeforeMethod
    public void setup() {
        createUserService = new CreateUserService();
        name = DataUtils.getData().getFirstName();
        location = DataUtils.getData().getLocation();
        email = DataUtils.getData().getEmail();
    }

    @Test
    public void createUser() {
        // Create user
        CreateUserRequestObject createUserRequest = new CreateUserRequestObject();
        createUserRequest.setEmail(email);
        createUserRequest.setName(name);
        createUserRequest.setLocation(location);
        createUserService.createUser(createUserRequest, token);
        createUserService.validateStatusCode(201)
                .verifyDataInResponse(NAME_RESPONSE, name)
                .verifyDataInResponse(EMAIL_RESPONSE, email)
                .verifyDataInResponse(LOCATION_RESPONSE, location);

        // Get user
        id = createUserService.getID();
        createUserService.getUserWithID(token, id);
        createUserService
                .validateStatusCode(200)
                .verifyDataInResponse(ID_RESPONSE,id)
                .verifyDataInResponse(NAME_RESPONSE, name)
                .verifyDataInResponse(EMAIL_RESPONSE, email)
                .verifyDataInResponse(LOCATION_RESPONSE, location);

        // Delete User
        createUserService.deleteUserWithID(token, id);

    }
}
