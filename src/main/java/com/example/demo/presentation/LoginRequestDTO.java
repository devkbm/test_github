package com.example.demo.presentation;

import javax.validation.constraints.NotEmpty;

public class LoginRequestDTO {

	 /*
     * @Valid 어노테이션을 이용해서 model의 값을 지정하는 경우 아래의 방식으로 통해서 데이터 유효성 검증을 진행 할 수 있습니다.
     * 
     * @AssertFalse : false 값만 통과 가능
     * @AssertTrue : true 값만 통과 가능
     * @DecimalMax(value=) : 지정된 값 이하의 실수만 통과 가능
     * @DecimalMin(value=) : 지정된 값 이상의 실수만 통과 가능
     * @Digits(integer=,fraction=) : 대상 수가 지정된 정수와 소수 자리수보다 적을 경우 통과 가능
     * @Future : 대상 날짜가 현재보다 미래일 경우만 통과 가능
     * @Past : 대상 날짜가 현재보다 과거일 경우만 통과 가능
     * @Max(value) : 지정된 값보다 아래일 경우만 통과 가능
     * @Min(value) : 지정된 값보다 이상일 경우만 통과 가능
     * @NotNull : null 값이 아닐 경우만 통과 가능
     * @Null : null일 겨우만 통과 가능
     * @Pattern(regex=, flag=) : 해당 정규식을 만족할 경우만 통과 가능
     * @Size(min=, max=) : 문자열 또는 배열이 지정된 값 사이일 경우 통과 가능
     * @Valid : 대상 객체의 확인 조건을 만족할 경우 통과 가능
     * */
	
	@NotEmpty(message="아이디는 필수 값입니다.")
	String id;
	
	String pwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "LoginRequestDTO [id=" + id + ", pwd=" + pwd + "]";
	}	
	
}
