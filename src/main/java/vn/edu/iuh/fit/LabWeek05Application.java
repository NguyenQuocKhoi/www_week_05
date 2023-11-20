package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backEnd.entities.Address;
import vn.edu.iuh.fit.backEnd.entities.Candidate;
import vn.edu.iuh.fit.backEnd.entities.Company;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.entities.Skill;
import vn.edu.iuh.fit.backEnd.enums.SkillType;
import vn.edu.iuh.fit.backEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.backEnd.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.Random;
import vn.edu.iuh.fit.backEnd.repositories.CompanyRepository;
import vn.edu.iuh.fit.backEnd.repositories.JobRepository;
import vn.edu.iuh.fit.backEnd.repositories.SkillRepository;

@SpringBootApplication
public class LabWeek05Application {

	public static void main(String[] args) {
		SpringApplication.run(LabWeek05Application.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
			private JobRepository jobRepository;
	@Autowired
			private SkillRepository skillRepository;
//		@Bean
	CommandLineRunner initData(){
		return args -> {
			Random rnd =new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
						rnd.nextInt(70000,80000)+"", CountryCode.VN );
				addressRepository.save(add);

				Candidate can=new Candidate("Name #"+i,
						LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
						add,
						rnd.nextLong(1111111111L,9999999999L)+"",
						"email_"+i+"@gmail.com");
				candidateRepository.save(can);
				System.out.println("Added: " +can);
			}
		};
	}
//@Bean
	CommandLineRunner initDataCompany(){
		return args -> {
			Random rnd =new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
						rnd.nextInt(70000,80000)+"", CountryCode.VN );
				addressRepository.save(add);
				Company company = new Company("company1"+i , add,"web url1"+i, rnd.nextLong(1111111111L,9999999999L)+"", "email_"+i+"@gmail.com", "about"+i);
				companyRepository.save(company);
				System.out.println("Added: " +company);
			}
		};
	}

//	@Bean
	CommandLineRunner initDataJob(){
		return args -> {
			Random rnd =new Random();
			for (int i = 1; i < 10; i++) {
				Job job = new Job("desc" + i, "name" +i, new Company(+i));
				jobRepository.save(job);
			}
		};
	}

//	@Bean
	CommandLineRunner initDataSkill(){
		return args -> {
//			Random rnd =new Random();
			for (int i = 1; i < 100; i++) {
				Skill skill = new Skill(SkillType.SOFT_SKILL,"skillName"+i, "skillDesc" +i);
				skillRepository.save(skill);
			}
		};
	}
}
