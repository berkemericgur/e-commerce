package com.bmg.ecommercedemo.business.abstracts;

import com.bmg.ecommercedemo.business.dtos.request.userRequests.CreateUserRequest;
import com.bmg.ecommercedemo.business.dtos.request.userRequests.UpdateUserRequest;
import com.bmg.ecommercedemo.business.dtos.response.userResponses.GetAllUserResponse;

import java.util.List;

public interface UserService {

    List<GetAllUserResponse> getAll();
    List<GetAllUserResponse> getUserById(long id);
    void addUser(CreateUserRequest createUserRequest);
    void updateUser(UpdateUserRequest updateUserRequest);
    void deleteUser(long id) throws Exception;

}
