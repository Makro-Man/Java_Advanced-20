package ua.lviv.lgs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.repository.UserRolesRepository;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository){

        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);
        if (null == user){
            throw new UsernameNotFoundException("No user present with username:" + s);
        }else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(s);
            return new CustomUserDetails(user,userRoles);
        }
    }
}
