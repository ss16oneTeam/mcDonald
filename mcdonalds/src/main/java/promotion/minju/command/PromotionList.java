package promotion.minju.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import promotion.minju.domain.PromotionDTO;
import promotion.minju.service.PrmtService;

public class PromotionList implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("do_get호출 test 박민주");
		PrmtService prmtService = PrmtService.getInstance();
		ArrayList<PromotionDTO> Plist=prmtService.select();
		
		request.setAttribute("Plist", Plist);
		return "/mc_main/main_bottom.jsp";
	}

}//class
