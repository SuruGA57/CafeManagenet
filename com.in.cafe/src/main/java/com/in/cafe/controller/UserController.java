package com.in.cafe.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user") // map user request to specific or particular method handler class or method
public interface UserController  {

	@PostMapping("/signUp") // provide more specific way or clarity on request.
	public ResponseEntity<String> signUp(@RequestBody(required=true)Map<String,String> requestMap);

}


//notes 
// ResponseEntity-provide more control over HTTPrequests,
//also represents HTTP response,including status code, headers,and body
// in status code like 200:ok;
//in headers have contentType,Location,Custom Headers
//in body have any java object in xml or JSON