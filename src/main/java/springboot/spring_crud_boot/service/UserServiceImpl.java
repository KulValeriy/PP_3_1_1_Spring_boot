package springboot.spring_crud_boot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import springboot.spring_crud_boot.DAO.UserDAO;
import springboot.spring_crud_boot.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }
}