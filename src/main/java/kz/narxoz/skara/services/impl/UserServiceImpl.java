package kz.narxoz.skara.services.impl;

import kz.narxoz.skara.entity.Roles;
import kz.narxoz.skara.entity.Users;
import kz.narxoz.skara.repository.RoleRepository;
import kz.narxoz.skara.repository.UserRepository;
import kz.narxoz.skara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    Users myUser = userRepository.findByEmail(s);
    if(myUser!=null){
      User secUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
      return secUser;
    }

    throw new UsernameNotFoundException("User Name Not Found");
  }

  @Override
  public Users getUserByEmail(String Email) {
    return userRepository.findByEmail(Email);
  }

  @Override
  public Users createUser(Users user) {
    Users checkUser = userRepository.findByEmail(user.getEmail());
    if(checkUser==null){
      Roles role = roleRepository.findByRole("ROLE_USER");
      if(role!=null){
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
      }
    }
    return null;
  }
}
