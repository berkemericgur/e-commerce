package com.bmg.ecommercedemo.dataaccess.abstracts;

import com.bmg.ecommercedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

//    @Query("select u from User u left join fetch u.orders where u.id = :userId")
//    GetAllUserResponse getUserWithOrders(@Param("userId") Long userId);
    List<User> findByUsername(String username);
    User findByOrdersId (long orderId);
}
