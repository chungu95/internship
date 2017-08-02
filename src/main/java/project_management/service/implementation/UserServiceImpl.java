package project_management.service.implementation;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.repository.model.Users;
import project_management.repository.repository.UserRepository;
import project_management.service.service_interface.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        try{
            return (Users) userRepository.save(user);
        }catch(HibernateException he){
            return null;
        }
    }
}
