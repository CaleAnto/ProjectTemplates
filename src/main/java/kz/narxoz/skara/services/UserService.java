package kz.narxoz.skara.services;

import kz.narxoz.skara.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Users getUserByEmail(String Email);

  Users createUser(Users user);
}
