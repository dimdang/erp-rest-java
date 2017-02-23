package com.erp.services;

import com.erp.model.Users;

import java.util.List;

/**
 * Created by DANG on 22-Feb-17.
 */

public interface UserService {
    List<Users> getAll();
    boolean saveUser(Users user);
    boolean deleteUser(Long id);
    boolean updateUser(Users user);
    Users getUserById(Long id);
    Users getUserByEmail(String email);
    Users loging(String email);
}
