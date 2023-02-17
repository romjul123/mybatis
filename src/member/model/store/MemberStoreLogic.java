package member.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.Pagination;

public class MemberStoreLogic implements MemberStore{

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
	
	
	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}


	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}


	@Override
	public List<Member> selectAllMembers(SqlSession session, Pagination pn) {
		List<Member> mList = session.selectList("MemberMapper.selectAllMembers", pn);
		return mList;
	}


	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}


	@Override
	public Member checkMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.checkMemberLogin", member);
		return mOne;
	}


	@Override
	public String generateNavi(SqlSession session, int currentPage) {
		int recordTotalCount = 35;
		int recordCountPerPage = 10;
		int naviTotalCount;
		if(recordTotalCount % recordCountPerPage != 0) {
			naviTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			naviTotalCount = recordTotalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5;
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		StringBuilder sb = new StringBuilder();
		if(currentPage != 1) {
			   sb.append("<a href='/member/list.do?page="+(currentPage-1)+"'>[이전]</a>");
			  }
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/member/list.do?page="+i+"'>"+i+" </a>");
		}
		if(currentPage != naviTotalCount ) {
			   sb.append("<a href='/member/list.do?page="+(currentPage+1)+"'>[다음]</a>");
			  }
		
		return sb.toString();
	}

	

}
