package com.erp.repositories.implement;

import com.erp.model.Users;
import com.erp.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DANG on 22-Feb-17.
 */
@Repository("UserRepositoryHibernate")
@Transactional
public class UserRepositoryImplement implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Users> getAll() {
        return (List<Users>) getSession().createQuery("from Users where status = true ");
    }

     @Override
    public boolean saveUser(Users user) {
        String hqlSelect = "SELECT Users from Users user where user.email = :email";
        Users usr = (Users) getSession().createQuery(hqlSelect).setString("email", user.getEmail()).uniqueResult();
        if (usr !=null){
            return false;
        }else {
            if (getSession().save(user) !=null){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        String hqlUpdate = "update Users s set s.status = :status where s.user_id = :id";
        int updateEntities = getSession().createQuery(hqlUpdate)
                .setBoolean("status", false)
                .setLong("id", id)
                .executeUpdate();
        if (updateEntities == 0){
            return false;
        }
        return true;
    }

    @Override
    public void updateUser(Users user) {
        getSession().update(user);
    }

    @Override
    public Users getUserById(Long id) {

        return getSession().get(Users.class, id);
    }

    @Override
    public Users getUserByEmail(String email) {
        String[] splitMail = email.split("%40");
        String newEmail = splitMail[0] + ".com";
        String hqlSelect = "SELECT user from Users user where user.email = :email";
        return (Users) getSession().createQuery(hqlSelect).setString("email", newEmail).uniqueResult();
    }

    @Override
    public Users loging(String email) {
        String hqSelect = "Select user from Users user where user.email = :email";
        return (Users) getSession().createQuery(hqSelect).setString("email", email).uniqueResult();
    }
}
