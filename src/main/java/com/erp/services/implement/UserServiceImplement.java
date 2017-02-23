package com.erp.services.implement;

import com.erp.model.Users;
import com.erp.repositories.UserRepository;
import com.erp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DANG on 22-Feb-17.
 */
@Service
public class UserServiceImplement implements UserService{

    @Autowired
    @Qualifier(value = "UserRepositoryHibernate")// for fect bean name
    private UserRepository userRepo;

    @Override
    public List<Users> getAll() {
        return userRepo.getAll();
    }

    @Override
    public boolean saveUser(Users user) {
        return userRepo.saveUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepo.deleteUser(id);
    }

    @Override
    public boolean updateUser(Users user) {
       userRepo.updateUser(user);
       return true;
    }
    @Override
    public Users getUserById(Long id) {
        return userRepo.getUserById(id);
    }

    @Override
    public Users getUserByEmail(String email) {
        return userRepo.getUserByEmail(email);
    }

    @Override
    public Users loging(String email) {
        return userRepo.loging(email);
    }
}
