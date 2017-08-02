package project_management.repository.repository;

import org.springframework.data.repository.CrudRepository;
import project_management.repository.model.Users;

public interface UserRepository extends CrudRepository<Users,Integer> {
}
