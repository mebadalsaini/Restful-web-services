package com.badal.rest.webservices.restfulwebservices.Service;

import com.badal.rest.webservices.restfulwebservices.Entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    public static int userCount = 0;
    static {
        users.add(new User(++userCount, "John", LocalDate.now().minusYears(29)));
        users.add(new User(++userCount, "Tyler", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Rose", LocalDate.now().minusYears(22)));
    }
    public List<User> findAllUsers(){
        return users;
    }
    public User save(User user){
        users.add(user);
        user.setId(++userCount);
        return user;
    }
    public User findOne(int id){
        Predicate<? super User> Predicate = user -> user.getId().equals(id);
        return users.stream().filter(Predicate).findFirst().get();
    }
}
