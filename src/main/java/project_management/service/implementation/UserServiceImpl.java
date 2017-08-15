package project_management.service.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.repository.model.Users;
import project_management.repository.repository.UserRepository;
import project_management.service.service_interface.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users createUser(Users user) {
        LOGGER.info("UserService -> Add new user");
        try {
            return userRepository.save(user);
        } catch (HibernateException he) {
            return null;
        }
    }

    @Override
    public Users getUserById(Integer id) {
        LOGGER.info("UserService -> Get user by user id");
        try {
            return userRepository.findOne(id);
        } catch (HibernateException he) {
            return null;
        }
    }

    @Override
    public Users getUserByUserName(String username) {
        LOGGER.info("UserService -> Get user by username");
        try {
            return userRepository.findUsersByUsername(username);
        } catch (HibernateException he) {
            return null;
        }
    }


}
