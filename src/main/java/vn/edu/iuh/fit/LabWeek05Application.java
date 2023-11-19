package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backEnd.entities.Address;
import vn.edu.iuh.fit.backEnd.entities.Candidate;
import vn.edu.iuh.fit.backEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.backEnd.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class LabWeek05Application {

	public static void main(String[] args) {
		SpringApplication.run(LabWeek05Application.class, args);
	}
}
