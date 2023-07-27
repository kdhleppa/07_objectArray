package edu.kh.oarr.model.vo;

public class Member {

	
	// 필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;
	
	
	// 생성자
	// 기본생성자, 매개변수생성자
	// 생성자만드는 규칙
	// 1. 생성자 이름은 클래스명과 같다
	// 2. 반환형이 없다.
	// **기본생성자는 컴파일러가 자동으로 생성해주는데,
	// 생성자가 하나라도 있으면, 자동생성 안해줌
	// 0> 기본생성자 직접 작성 해야한다!**
	
	
	public Member() {}// 기본생성자
	
	// 오버로딩
	// 매개변수의 타입, 순서 갯수가 달라야한다!!
	public Member( String memberId, String memberPw, String memberName, int memberAge, String region) {
		
		// 매개변수로 전달받은 값을 필드로 대입시키기.
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}
	
	// 메서드
	// getter/setter
	
	// 다 접근 가능하도록 public / String 자료형 돌려보내겠다.
	public String getMemberId() {
		return memberId; // 매개변수가 없어서 중복된 이름의 memberId가 없기 때문에 memberId라고만써도 가능
	}

	public void setMemberId(String memberId) {
		// setter : 세팅하는애, 무엇을 세팅할지 전달받아온 아이가 매개변수다
		// 반환값이 없으므로 void
		this.memberId = memberId;
		// 모든 메서드는 종료시 호출한 곳으로 돌아가는
		// return 구문이 작성되어야만 하지만
		// 단, void일 경우 생략 가능
		// -> 생략시 컴파일러가 자동 추가해준다.
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String toString() {
		return "아이디 : "+ memberId + "\n이름 : " + memberName + "\n나이 : " + memberAge + "\n 지역 : " + region;
	}
	
	
	
	

}
