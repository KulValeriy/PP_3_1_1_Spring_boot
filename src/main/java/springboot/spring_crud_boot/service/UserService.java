package springboot.spring_crud_boot.service;


import springboot.spring_crud_boot.model.User;

import java.util.List;


public interface UserService {
    List<User> findAll();

    User getById(int id);

    void save(User user);

    void deleteById(int id);
}
