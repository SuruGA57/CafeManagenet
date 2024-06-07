package com.in.cafe.controllerImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.constants.CafeConstant;
import com.in.cafe.controller.UserController;
import com.in.cafe.service.UserService;
import com.in.cafe.utils.CafeUtils;

@RestController //used to we developing Restfull webservices we use ,specialize over @Controller and response body,
               //also responsible to handle incoming clients request to particular service method 
public class UserControllerImpl implements UserController{

	@Autowired //used to inject object dependency implicitly 
				// @Autowired helps to automatically inject beans like service ,components,repository.
	UserService userService;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {

		try {
			return userService.signUp(requestMap);
		}catch(Exception e) {
			e.printStackTrace();

		}
//		return null;
		return CafeUtils.errorResponse(CafeConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
