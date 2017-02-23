package com.erp.controller;

import com.erp.model.UserLogin;
import com.erp.model.Users;
import com.erp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DANG on 22-Feb-17.
 */
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity <Map<String, Object>>findUserByEmail(@RequestBody UserLogin login){
        Map <String, Object> map = new HashMap<String, Object>();
        try{
            map.put("STATUS", true);
            map.put("MESSAGE", "Success");
            map.put("DATA", userService.loging(login.getEmail()));
            System.out.print(map);
        }catch (Exception e){
            map.put("STATUS", false);
            map.put("MESSAGE", "Fail");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity <Map <String, Object>> getUsers() {
        Map <String, Object> map = new HashMap<String, Object>();
        ArrayList <Users> user = (ArrayList<Users>) userService.getAll();
        try {
            if (!user.isEmpty()){
                map.put("DATA", user);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND");
            }else {
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA NOT FOUND");
            }
        }catch (Exception e){
            map.put("STATUS", false);
            map.put("MESSAGE", "ERROR");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity <Map <String, Object>> getUserById(@PathVariable("id") Long id) {
        Map <String, Object> map = new HashMap<String, Object>();
        try{
            Users user = userService.getUserById(id);
            if (user!=null){
                map.put("DATA", user);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND");
            }else {
                map.put("STATUS", false);
                map.put("MESSAGE", "DATA NOT FOUND");
            }
        }catch (Exception e){
            map.put("STATUS", false);
            map.put("MESSAGE", "DATA NOT FOUND");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
    @ResponseBody
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity <Map<String, Object>> getUsersByEmail(@PathVariable("email") String email) {
        Map <String, Object> map = new HashMap<String, Object>();
        try{
            Users user = userService.getUserByEmail(email);
            if (user != null){
                map.put("DATA", user);
                map.put("STATUS", true);
                map.put("MESSAGE", "DATA FOUND");
            }else{
                map.put("STATUS", false);
                map.put("MESSAGE", "DATA NOT FOUNDS");
            }
        }catch (Exception e){
            map.put("STATUS", false);
            map.put("MESSAGE", "DATA NOT FOUND");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity <Map<String, Object>> addUsers(@RequestBody Users user) {
        Map <String, Object> map = new HashMap<String, Object>();
        try {
            if (userService.saveUser(user)){
                map.put("MESSAGE", "User has been create.");
                map.put("USERS", user);
                map.put("STATUS", true);
            }else {
                map.put("MESSAGE", "User hasn't been create");
                map.put("STATUS", false);
            }
        }catch (Exception e){
            map.put("MESSAGE", "Error");
            map.put("STATUS", false);
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity <Map<String, Object>> updateUsers(@RequestBody Users user) {
        Map <String, Object> map = new HashMap<String, Object>();
        try{
            if (userService.updateUser(user)){
                map.put("MESSAGE", "Users has been update.");
                map.put("STATUS", true);
            }else{
                map.put("MESSAGE", "Users hasn't been update.");
                map.put("STATUS", false);
            }

        }catch (Exception e){
            map.put("MESSAGE", "Error");
            map.put("STATUS", false);
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity <Map<String, Object>> deleteUsers (@PathVariable("id")Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            if (userService.deleteUser(id)){
                map.put("MESSAGE", "Users has been deleted.");
                map.put("STATUS", true);
            }else{
                map.put("MESSAGE", "Users hasn't been deleted yet.");
                map.put("STATUS", false);
            }
        }catch (Exception e){
            map.put("MESSAGE", "Error");
            map.put("STATUS", false);
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
