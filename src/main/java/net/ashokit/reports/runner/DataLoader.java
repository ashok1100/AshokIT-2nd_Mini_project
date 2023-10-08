package net.ashokit.reports.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import net.ashokit.reports.entity.CitizenPlan;
import net.ashokit.reports.repository.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenPlan p1 = new CitizenPlan("Ashok", "ashok@gmail.com", 7987l, 748592l, "Male", "Cash", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p2 = new CitizenPlan("Raja", "raja12@gmail.com", 2564l, 65412l, "Male", "Cash", "Denied", null,
				null);

		CitizenPlan p3 = new CitizenPlan("Cathy", "cathyheaven@gmail.com", 4568l, 85214l, "Fe-Male", "Food", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p4 = new CitizenPlan("Laraa", "laraa2233@gmail.com", 8546l, 65412l, "Fe-Male", "Food", "Denied",
				null, null);

		CitizenPlan p5 = new CitizenPlan("Johny", "johnykills@in.com", 8456l, 7845l, "Male", "Medical", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p6 = new CitizenPlan("Kasandra", "kasan.brill@gmail.com", 2748l, 98564l, "Male", "Medical",
				"Denied", null, null);

		List<CitizenPlan> records = Arrays.asList(p1, p2, p3, p4, p5, p6);
		repo.saveAll(records);
	}

}
