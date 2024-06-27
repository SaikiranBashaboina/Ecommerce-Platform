package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


	@Override
	public User findById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User getbyId(Long id) {

		Optional<User> opt= this.userRepository.findById(id);
		return opt.get();
	}
}

