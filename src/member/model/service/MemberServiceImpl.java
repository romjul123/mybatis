package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.store.MemberStore;
import member.model.store.MemberStoreLogic;
import member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberStore mStore;
	
	public MemberServiceImpl() {
		mStore = new MemberStoreLogic();
	}

	@Override
	public int registerMember(Member mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.insertMember(session, mOne);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Member checkMemberLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}

}
