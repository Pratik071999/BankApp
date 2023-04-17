package com.monocept.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.dto.response.UserDetail;
import com.monocept.entities.Account;
import com.monocept.entities.User;
import com.monocept.repo.UserRepository;
import com.monocept.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepo;
	
	@Override
	public UserDetail getUserDetail(String email) {
		User user = userRepo.findByEmail(email).orElse(null);
		UserDetail data = new UserDetail();
		data.setEmail(user.getEmail());
		data.setFname(user.getFirstName());
		data.setLname(user.getLastName());
		data.setRole(user.getRole());
		data.setUserId(user.getUserId());
		data.setIsActive(user.getIsActive());
		data.setAccounts(user.getAccounts());
		Float total = 0.0f;
		for (Account acc: user.getAccounts()) {
			total += acc.getAmount();
		}
		data.setTotalBalance(total);
		return data;
	}

}
