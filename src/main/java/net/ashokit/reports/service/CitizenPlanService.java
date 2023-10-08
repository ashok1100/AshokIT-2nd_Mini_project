package net.ashokit.reports.service;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import net.ashokit.reports.binding.SearchCriteria;
import net.ashokit.reports.entity.CitizenPlan;

public interface CitizenPlanService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CitizenPlan> searchCitizens(SearchCriteria criteria);

	public void generateExcel(HttpServletResponse response) throws Exception;

	public void generatePdf(HttpServletResponse response) throws Exception;
}
