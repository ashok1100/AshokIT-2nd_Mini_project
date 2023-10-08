package net.ashokit.reports.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String name;
	private String email;
	private Long phno;
	private Long ssn;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;

	public CitizenPlan(String name, String email, Long phno, Long ssn, String gender, String planName,
			String planStatus, LocalDate planStartDate, LocalDate planEndDate) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.ssn = ssn;
		this.gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
	}

	public CitizenPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

}
