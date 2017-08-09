package project_management.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_management.repository.model.Users;
import project_management.repository.model.UsersPermission;
import project_management.repository.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUsersByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Người dùng không tồn tại");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<UsersPermission> permissions = user.getUsersPermissionsByUserId();
        for (UsersPermission usersPermission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(usersPermission.getPermissionByPermissionId().getPermissionName()));
        }
        System.out.println(user.getUsername() + " | " + permissions.get(0).getPermissionByPermissionId().getPermissionName());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
