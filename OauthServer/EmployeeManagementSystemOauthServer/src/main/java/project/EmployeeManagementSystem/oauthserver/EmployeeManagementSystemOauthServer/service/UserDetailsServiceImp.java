package project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.service;

import project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.model.AuthUserDetail;
import project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.model.User;
import project.EmployeeManagementSystem.oauthserver.EmployeeManagementSystemOauthServer.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser=userDetailsRepository.findByUsername(name);
        optionalUser.orElseThrow(()->new UsernameNotFoundException("Username or Password wrong"));

        UserDetails userDetails=new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
