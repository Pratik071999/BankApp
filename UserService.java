package com.monocept.service;

import com.monocept.dto.response.UserDetail;

public interface UserService {
	UserDetail getUserDetail(String email);
}
