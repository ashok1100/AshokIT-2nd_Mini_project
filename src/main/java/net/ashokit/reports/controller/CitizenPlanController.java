package net.ashokit.reports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import net.ashokit.reports.binding.SearchCriteria;
import net.ashokit.reports.entity.CitizenPlan;
import net.ashokit.reports.service.CitizenPlanService;

@Controller
public class CitizenPlanController {

	@Autowired
	private CitizenPlanService service;

	private void formInit(Model model) {
		
		List<String> planNames = service.getPlanNames();
		List<String> planStatus = service.getPlanStatus();

		model.addAttribute("planNames", planNames);
		model.addAttribute("planStatus", planStatus);
	}

	@GetMapping("/")
	public String indexPage(Model model) {

		formInit(model);

		model.addAttribute("search", new SearchCriteria());

		return "index";
	}

	@PostMapping("/filter-data")
	public String handleSearchButton(@ModelAttribute("search") SearchCriteria criteria, Model model) {
		System.out.println(criteria);

		List<CitizenPlan> citizensInfo = service.searchCitizens(criteria);
		model.addAttribute("citizens", citizensInfo);
		
		formInit(model);

		return "index";
	}

	
	@GetMapping("/excel")
	public void downloadExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=CitizensData.xls";
		
		response.addHeader(headerKey, headerValue);
		
		service.generateExcel(response);
	}
	
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=CitizensData.pdf";
		
		response.addHeader(headerKey, headerValue);
		
		service.generatePdf(response);
	}
	
	
	
	
	
	
	
	
	
	
}
