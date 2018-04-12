package com.example.demo.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/helloworld")
	public ResponseEntity<?> helloWolrd() {
		
		Map<String, String> body = new HashMap<String, String>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
		body.put("이름", "김병민");
		body.put("부서", "개발3팀");
				
		return new ResponseEntity<Map<String,String>>(body, headers, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * http://localhost:8090/get/id/pwd
	 */
	@GetMapping("/get/{id}/{pwd}")
	public String request(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		return id + " " + pwd;
	}
	
	
	/**
	 * http://localhost:8090/get2?id=id
	 * http://localhost:8090/get2?id=id&pwd=3
	 * 
	 * required의 디폴트는 true
	 */
	@GetMapping("/get2")
	public String request2(@RequestParam("id") String id, 			
			@RequestParam(value="pwd", required=false, defaultValue="1") String pwd) {
		return id + " " + pwd;
	}
	
	/**
	 * 특정 객체로 맾핑
	 * x-www-form-urlencoded 방식 
	 */
	@PostMapping("/post")
	public String post(LoginRequestDTO dto) {
		return dto.toString();
	}
	
	/**
	 * 특정 객체로 맾핑, 검증 수행
	 * x-www-form-urlencoded 방식
	 */
	@PostMapping("/post2")
	public String post2(@Valid LoginRequestDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			FieldError err = bindingResult.getFieldError();
			return err.getDefaultMessage();
		}
		
		return dto.toString();
	}
	
	/**
	 * 특정 객체로 맾핑
	 * application/json
	 */
	@PostMapping("/post3")	
	public String post3(@RequestBody LoginRequestDTO dto) {
		return dto.toString();
	}
	
	/**
	 * 특정 객체로 맾핑, 검증 수행
	 * application/json
	 */
	@PostMapping("/post4")
	public String post4(@RequestBody @Valid LoginRequestDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			FieldError err = bindingResult.getFieldError();
			return err.getDefaultMessage();
		}
		
		return dto.toString();
	}
	
}
