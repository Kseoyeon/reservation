package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.Member;
import kr.or.connect.reservation.service.security.UserDbService;

public interface MemberService extends UserDbService {
	public void addMember(Member member, boolean admin);
	public Member getMemberByEmail(String email);
}
