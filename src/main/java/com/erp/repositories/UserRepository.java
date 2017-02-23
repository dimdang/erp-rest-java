package com.erp.repositories;

import com.erp.model.Users;

import java.util.List;

/**
 * Created by DANG on 22-Feb-17.
 */
public interface UserRepository {
    List<Users> getAll();
    boolean saveUser(Users user);
    boolean deleteUser(Long id);
    void updateUser(Users user);
    Users getUserById(Long id);
    Users getUserByEmail(String email);
    Users loging(String email);

}
