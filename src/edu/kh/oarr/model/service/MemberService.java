package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;


public class MemberService {

	private Member loginMember = null;
	// 속성(필드)
	private Scanner sc = new Scanner(System.in);
	
	// Member 5칸짜리 객체배열 선언 및 할당
	
	private Member[] memberArr = new Member[5];
	
	public MemberService() {// 기본생성자
		// memberArr 배열 0,1,2 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "게보린", 25, "서울");
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원");
	}
	
	
	// 메뉴 화면 출력 기능
	public void displayMenu() {
		// 반환형
		
		
		int menuNum = 0; // 메뉴 선택용 변수
		// 무조건 한번은 반복
		do {
			System.out.println("========회원 정보 관리 프로그램========");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거용
			
			switch(menuNum) {
			case 1 : System.out.println(signUp()); break;
			case 2 : System.out.println(login()); break;
			case 3 : System.out.println(selectMember()); break;
			case 4 : 
				
				int result = updateMember();
				
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				} else if(result == 0) {
					System.out.println("회원 정보 수정 실패 (비밀번호 불일치)");
				} else { // result == 1
					System.out.println("회원 정보가 수정되었습니다.");
				} break;
			case 5: searchRegion(); break;
			case 0 : System.out.println("프로그램 종료.."); break;
			default : System.out.println("잘못 입력 하셨습니다.. 다시 입력해주세요");
			}
			
		} while(menuNum != 0); // menuNum 0이면 반복 종료
		
	}
	// memberArr의 비어있는 인덱스 번호 반환하는 메서드
	// 단, 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() {
		// memberArr 배열을 0 인덱스부터 끝까지 접근해서
		// 참조하는 값이 null일 경우의 인덱스를 반환
		for (int i = 0; i <= memberArr.length; i ++) {
			if (memberArr[i] == null) {
				return i; // 현재 메서드를 종료하고 호출한 곳으로 i 값 가지고 돌아감
			} 
				
			
		}
		// for 문을 수행했지만 return이 되지 않은 경우 해당 위치 코드 수행된다!
		// -> for 문에서 return되지 않았다 == 배열에 빈칸이 없다
		return -1;
		
		
	}
	//회원가입 매서드
	public String signUp() {
			// (반환형)
			// 해당 메소드가 끝나고 호출한 곳으로 돌아갈 때
			// String 자료형 값을 가지고 돌아간다.
			
			
		System.out.println("\n******* 회원 가입 *******");
		
		// 객체배열 memberArr 에 가입한 회원 정보를 저장할 예정
		// -> 새로운 회원 정보를 저장할 공간이 있는지 확인하고
		// 		빈 공간의 인덱스 번호를 얻어오기 --> 메서드 작성
		int index = emptyIndex(); // memberArr배열에서 비어있는 인덱스 반환받음.
		
		if(index == -1) { // 비어있는 인덱스가 없을 경우 -> 회원가입 불가
			return "회원가입이 불가능 합니다(인원 수 초과)";
			
		}
			
		System.out.print("아이디 : ");
		String memberId = sc.next();
			
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
			
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
			
		System.out.print("이름 : ");
		String memberName = sc.next();
			
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();	
		
		System.out.print("지역 : ");
		String memberRegion = sc.next();
		
			
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
			
		if (memberPw.equals(memberPw2)) { // 일치하는 경우
			
			// Member객체 생성해서 할당된 주소를 memberArr의 비어있는 인덱스에 대입
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, memberRegion);
				
				
			return "회원가입 성공!!";
			/* 출력구문 메소드를 호출한 곳에서 한번만 쓰고,
			 * return을 이용해 전달할 값을 작성
			 */
			// return : 현재 메소드를 종료하고 호출한 곳으로 돌아감
			// return 값; : 호출한 곳으로 돌아갈 때 값을 가지고 감.
		} else { // 일치하지 않는 경우
			
			return "회원가입 실패!!(비밀번호 불일치)";
		}
			

	}
		
		
	public String login() {
		
		System.out.println("\n**********로그인**********");
			
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		for (int i = 0; i < memberArr.length; i++) {
			
			if(memberArr[i] != null) {
			
		
			if (memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw)) {
				loginMember = memberArr[i];
				break;
		
			}
			}
		}
		
		if (loginMember == null) {
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
			
		} else { // 로그인 성공
			return loginMember.getMemberName() + " 님 환영합니다.";
					}
		}
		
		// 회원 정보 조회 기능
		public String selectMember() {
			System.out.println("\n***** 회원 정보 조회 *****");
			
			// 1) 로그인 여부 확인
			// 로그인 안했을때 "로그인 후 이용해주세요"
			// 2) 로그인이 되어있는 경우
			// 회원 정보를 출력할 문자열을 만들어서 반환
			// 단, 비밀번호는 제외
			
			if (loginMember==null) {
				// loginMember가 참조하는 개체가 없을 경우
				return "로그인 후 이용해 주세요";
			} else {
				
				String str = "이름 : " + loginMember.getMemberName();
				str += "\n아이디 : " + loginMember.getMemberId();
				str += "\n나이 : " + loginMember.getMemberAge();
				str += "\n지역 : " + loginMember.getRegion() + "\n";
				return str;
				// return loginMember.toString();
			}
			
		}
		// 회원 정보 수정 기능
		public int updateMember() {
			System.out.println("\n*****회원정보수정*****");
			// 1) 로그인 여부 판별
			// 로그인이 되어있지 않으면 -1 반환
			if (loginMember == null) {
				return -1;
			}
			// 2) 로그인이 되어있을때
			// 2-1) 수정할 회원 정보 입력 받기 (이름, 나이)
			else {
				System.out.println("수정할 정보를 입력하세요");
				System.out.print("이름 : ");
				String memberName = sc.next();
				System.out.print("나이 : ");
				int memberAge = sc.nextInt();
				System.out.print("지역 : ");
				String memberRigon = sc.next();
				System.out.print("비밀번호 : ");
				String memberPw = sc.next();
				
				// 2-2) 비밀번호를 입력받아서 로그인한 회원의 비밀번호와 일치하는지 확인
				// -> 비밀번호가 같을 경우 로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경후
				// 1반환
				if (memberPw.equals(loginMember.getMemberPw())) {
					loginMember.setMemberName(memberName);
					loginMember.setMemberAge(memberAge);
					loginMember.setRegion(memberRigon);
					return 1;
				} else { // 비밀번호가 다를 경우 0 반환
					return 0;
				}
			}
			
		}
		
		// 회원 검색(지역) 메서드
		public void searchRegion() { 
			 System.out.println("\n=============회원 검색(지역)=============");
			 
			 System.out.print("검색할 지역을 입력하세요 : ");
			 String inputRegion = sc.next();
			 
			 boolean flag = true; // 검색결과 신호용 변수
			 
			 // 1) memberArr 배열의 모든 요소 순차 접근
			 
			 for(int i = 0; i < memberArr.length; i++) {
				 
				 // 2) memberArr[i] 요소가 null인 경우 반복 종료
				 if (memberArr[i] == null) {
					 break;
				 }
				 
				 // 3) memberArr[i] 요소에 저장된 지역(region)이
				 // 입력받은 지역 (inputRegion)과 같을경우 회원의 아이디, 이름을 출력
				 if (memberArr[i].getRegion().equals(inputRegion)) {
					 
					 System.out.printf("아이디 : %s 이름 : %s\n",  memberArr[i].getMemberId(), memberArr[i].getMemberName());
					 flag = false;
				 }
			 }
			 
			 
			 if(flag) {
				 System.out.println("일치하는 검색 결과가 없습니다.");
			 }
			 
			 
			 
					 
			
		}
			
			
		
	
	


}
