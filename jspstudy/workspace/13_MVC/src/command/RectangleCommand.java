package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RectangleCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int width = Integer.parseInt(request.getParameter("width"));
		int height = Integer.parseInt(request.getParameter("height"));
		request.setAttribute("area", width * height);
		// return "/view/output.jsp";  이것도 같은 경로로 이동합니다.
		return "view/output.jsp";
	}

}
