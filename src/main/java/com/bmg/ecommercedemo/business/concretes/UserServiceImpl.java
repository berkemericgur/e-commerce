package com.bmg.ecommercedemo.business.concretes;

import com.bmg.ecommercedemo.business.abstracts.UserService;
import com.bmg.ecommercedemo.business.dtos.request.userRequests.CreateUserRequest;
import com.bmg.ecommercedemo.business.dtos.request.userRequests.UpdateUserRequest;
import com.bmg.ecommercedemo.business.dtos.response.userResponses.GetAllUserResponse;
import com.bmg.ecommercedemo.business.mappers.ModelMapperService;
import com.bmg.ecommercedemo.dataaccess.abstracts.UserDao;
import com.bmg.ecommercedemo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ModelMapperService modelMapperService;
    private UserDao userDao;


    @Override
    public List<GetAllUserResponse> getAll() {

        List<User> users = this.userDao.findAll();

        List<GetAllUserResponse> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());

        return getAllUserResponses;
    }

    @Override
    public List<GetAllUserResponse> getUserById(long id) {

        Optional<User> users = this.userDao.findById(id);

        List<GetAllUserResponse> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());

        return getAllUserResponses;
    }

    @Override
    public void addUser(CreateUserRequest createUserRequest) {

        User user = this.modelMapperService.forRequest()
                .map(createUserRequest, User.class);

        this.userDao.save(user);
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {

        User user = this.modelMapperService.forRequest()
                .map(updateUserRequest, User.class);

        this.userDao.save(user);
    }

    @Override
    public void deleteUser(long id) throws Exception{

        Optional<User> user = this.userDao.findById(id);

        if (user == null){
            throw new Exception("User not found with id: " + id);
        }

        this.userDao.deleteById(id);

    }
}
