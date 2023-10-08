package net.ashokit.reports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ashokit.reports.entity.CitizenPlan;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Long>{

	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
}
