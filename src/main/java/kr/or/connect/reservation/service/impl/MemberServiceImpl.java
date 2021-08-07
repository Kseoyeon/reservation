package kr.or.connect.reservation.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.MemberDao;
import kr.or.connect.reservation.dao.MemberRoleDao;
import kr.or.connect.reservation.dto.Member;
import kr.or.connect.reservation.dto.MemberRole;
import kr.or.connect.reservation.service.MemberService;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

@Service
public class MemberServiceImpl implements MemberService {
	private final MemberDao memberDao;
    private final MemberRoleDao memberRoleDao;
    
    public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao) {
        this.memberDao = memberDao;
        this.memberRoleDao = memberRoleDao;
    }

    @Override
    @Transactional
    public UserEntity getUser(String loginUserId) {
        Member member = memberDao.getMemberByEmail(loginUserId);
        return new UserEntity(member.getEmail(), member.getPassword());
    }

    @Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        List<MemberRole> memberRoles = memberRoleDao.getRolesByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();

        for(MemberRole memberRole : memberRoles) {
            list.add(new UserRoleEntity(loginUserId, memberRole.getRoleName()));
        }
        return list;
    }
    
    @Override
    @Transactional(readOnly = false)
    public void addMember(Member member, boolean admin) {
    	memberDao.addMember(member);
    	
		Member selectedMember = memberDao.getMemberByEmail(member.getEmail());
		Long memberId = selectedMember.getId();
		if(admin) {
			memberRoleDao.addAdminRole(memberId);
		}
		memberRoleDao.addUserRole(memberId);    	
    }
	@Override
	@Transactional
	public Member getMemberByEmail(String email) {
        return memberDao.getMemberByEmail(email);
	}
}
