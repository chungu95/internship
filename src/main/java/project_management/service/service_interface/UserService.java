package project_management.service.service_interface;

import project_management.repository.model.Users;

public interface UserService {
    Users createUser(Users userDTO);
    Users getUserById(Integer id);
    
}
