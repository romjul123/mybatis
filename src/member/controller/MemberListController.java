package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import member.model.vo.Member;
import member.model.vo.PageData;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberServiceImpl();
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		try {
			PageData pd = mService.selectAllMembers(currentPage);
			List<Member> mList = pd.getMemberList();
			String PageNavi = pd.getPageNavigator();
			request.setAttribute("mList", mList);
			request.setAttribute("pageNavi", PageNavi);
			request.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
