package com.koreait.mybatis2.command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.common.Paging;
import com.koreait.mybatis2.dao.SimpleDao;
import com.koreait.mybatis2.dto.SimpleDto;

public class SimpleListCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		SimpleDao simpleDao = sqlSession.getMapper(SimpleDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int page = 1;  // 항상 똑같습니다.
		if (request.getParameter("page") != null) {  // 항상 똑같습니다.
			page = Integer.parseInt(request.getParameter("page"));  // 항상 똑같습니다.
		}  // 항상 똑같습니다.
		
		int totalRecord = simpleDao.totalRecord();  // 항상 똑같습니다.
		
		// SimpleList는 한 페이지에 몇 개의 레코드를 표시할 것인지 여기서 결정합니다.
		int recordPerPage = 5;  // 각 ListCommand마다 다르게 설정해도 됩니다.
		
		int beginRecord = (page - 1) * recordPerPage + 1;  // 항상 똑같습니다.
		int endRecord = beginRecord + recordPerPage - 1;  // 항상 똑같습니다.
		endRecord = endRecord < totalRecord ? endRecord : totalRecord;  // 항상 똑같습니다.
		
		// beginRecord + endRecord를 list를 가져오는 simpleList()에 전달합니다.
		List<SimpleDto> list = simpleDao.simpleList(beginRecord, endRecord);
		
		// Paging을 만듭니다. ( 이전 1 2 3 4 5 다음 )
		// 아래 paging의 path는 List마다 다릅니다.
		// SimpleListCommand  :  simpleListPage.do
		// BoardListCommand   :  boardListPage.do
		// 검색결과의 페이징  :  boardListPage.do?query=검색
		String paging = Paging.getPaging("simpleListPage.do", totalRecord, recordPerPage, page);
		
		model.addAttribute("list", list);
		
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("page", page);
		model.addAttribute("recordPerPage", recordPerPage);

	}

}