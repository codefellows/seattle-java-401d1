package com.example.AuthDemo;

import com.example.AuthDemo.mock.MockUserDB;
import com.example.AuthDemo.models.User;
import com.example.AuthDemo.pojos.UserPojo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    /*
    RESTful Resources Routing
    INDEX	GET	products#index	/products
    SHOW	GET	products#show	/products/{id}
    NEW	GET	products#new	/products/new
    CREATE	POST	products#create	/products
    EDIT	GET	products#edit	/products/{id}/edit
    UPDATE	PUT	products#update	/products/{id}
    DESTROY	DELETE	products#destroy	/products/{id}
    */

    @GetMapping
    @ResponseBody
    public List<User> index() {
        return MockUserDB.getUsers();
    }

    @GetMapping("{id}")
    @ResponseBody
    public User getUser(@PathVariable String id) {
        return MockUserDB.getUser(id);
    }

    @GetMapping("new")
    @ResponseBody
    public User newUserForm() {
        User user = new User();
        return user;
    }

    //@PostMapping
    @PostMapping(consumes="application/json")
    @ResponseBody
    public User createNewUser(@RequestBody UserPojo userPojo) {
    //public User createNewUser() {
        User user = new User(userPojo);

        String password = "password";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println(user.username);
        System.out.println(userPojo.password);
        System.out.println(user.bio);
        System.out.println(hashed);

        return user;
    }

    @GetMapping(value="{id}/edit", consumes="application/json")
    @ResponseBody
    public User editUserForm(@PathVariable String username) {
        User user = new User();
        return user;
    }

    @PutMapping(value="{id}", consumes="application/json")
    @ResponseBody
    public User editUser(@RequestBody UserPojo userPojo) {
        // TODO: protect with auth.
        User user = MockUserDB.getUserByName(userPojo.username);
        user.bio = userPojo.bio;
        return user;
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public boolean deleteUser(@PathVariable String id) {
        return MockUserDB.deleteUser(id);
    }
}
