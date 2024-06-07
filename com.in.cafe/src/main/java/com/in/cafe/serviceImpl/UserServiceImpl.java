package com.in.cafe.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.POJO.User;
import com.in.cafe.constants.CafeConstant;
import com.in.cafe.repository.UserRepository;
import com.in.cafe.service.UserService;
import com.in.cafe.utils.CafeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service  //service holds business logic like decision making, calculations ,validations
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		log.info("Inside signup",requestMap);
		try {
			if(validateSignUpMap(requestMap)) {
				
				User user =userRepository.findByEmail(requestMap.get("email"));
				
				if(Objects.isNull(user)) {
					userRepository.save(getUserFromMap(requestMap));
					log.info("check null or not");
					return CafeUtils. successResponse("Successfully User Resistered1");
				}
				else {
					return CafeUtils.badRequestResponse("Email already Exist");
				}
			}else {
	            return CafeUtils.badRequestResponse(CafeConstant.INVALID_DATA);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			
            return CafeUtils.errorResponse("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

		}
//		return null;
	}
	
	private boolean validateSignUpMap(Map<String,String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")&& requestMap.containsKey("email")&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}
	
	private User getUserFromMap(Map<String,String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus(requestMap.get(true));
		user.setRole(requestMap.get(user));
		
		return user;
	}

}
