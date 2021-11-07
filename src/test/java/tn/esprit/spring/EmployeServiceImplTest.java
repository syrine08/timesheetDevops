/*package tn.esprit.spring;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import java.util.Optional;
import java.util.List;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService iEmployeService;
	@Autowired
	IEntrepriseService iEntrepriseService;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private DepartementRepository departementRepository;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testAjouterEmploye() throws ParseException {

		Employe employe = new Employe( "Ghada", "Khedri", "ghada.khedri1@esprit.tn", true, Role.INGENIEUR);
		iEmployeService.ajouterEmploye(employe);
        
	}

	@Test
	public void testMettreAjourEmailByEmployeIdJPQL() throws ParseException {
		String email = "ghadakhedrib@gmail.com";
	    int employeId = 2;
		employeService.mettreAjourEmailByEmployeIdJPQL(email, employeId);
		assertEquals(employeRepository.findById(employeId).get().getEmail(), email);
	}
	
@Test
	public void testAffectEmployeDepartment() throws ParseException {
		int employeId = 2;
	    int departementId = 1;
	    employeService.affecterEmployeADepartement(employeId, departementId);
	    assertTrue(employeRepository.findById(employeId).isPresent() && departementRepository.findById(departementId).isPresent());
	   
		
		
	}
	

	@Test
	public void testDesaffecterEmployeDuDepartement() throws ParseException {
		int employeId = 2;
	    int departementId = 1;
		employeService.desaffecterEmployeDuDepartement(employeId, departementId);
		assertThat(employeRepository.findById(employeId).get()).isNotNull();
		assertThat(departementRepository.findById(departementId).get()).isNotNull();
	}

	@Test
	public void testAjouterContrat() throws ParseException {
		   Contrat contrat = new Contrat(new Date(), "CDI", 3500);
	        int id = employeService.ajouterContrat(contrat);
	        assertTrue(contratRepository.findById(id).isPresent());
		
	}

	@Test
	public void testAffecterContratAEmploye() throws ParseException {
		 int contratId = 1;
	     int employeId = 82;
	     assertTrue(employeRepository.findById(employeId).isPresent());
	        employeService.affecterContratAEmploye(contratId, employeId);
	        Contrat contrat = contratRepository.findById(contratId).get();
	        assertEquals(contrat.getEmploye().getId(),employeId);
	}

	@Test
	public void testGetEmployePrenomById() throws ParseException {
		 int employeId = 2;
		String prenom =employeService.getEmployePrenomById(employeId);
	        Employe employe = employeRepository.findById(employeId).get();
	        assertEquals(employe.getPrenom(), prenom);
	} 
	
	@Test
	public void testDeleteEmployeById() throws ParseException {
		int employeId = 2;
		employeService.deleteEmployeById(employeId);
	    assertFalse(employeRepository.findById(employeId).isPresent());
		
	} 
	
	@Test
	public void testGetNombreEmployeJPQL() throws ParseException {
	   List<Employe> employeList = employeService.getAllEmployes();
		int nombre =employeService.getNombreEmployeJPQL();
		assertEquals(employeList.size(), nombre);
	}

	@Test
	public void testGetEmployesByEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise("Trame","photographe");
		iEntrepriseService.ajouterEntreprise(entreprise);
		List<Employe> employes = employeService.getAllEmployeByEntreprise(entreprise);
		assertNotNull(employeService.getAllEmployeByEntreprise(entreprise));
	}

	@Test
	public void testDeleteAllContratJPQL() throws ParseException {
		
		employeService.deleteAllContratJPQL();
		assertTrue(contratRepository.count() < 0);
	}

	@Test
	public void testGetSalaireMoyenByDepartementId() throws ParseException {
		 int departementId = 1;
		Double salaireMoyen=employeService.getSalaireMoyenByDepartementId(departementId);
		assertNotEquals(salaireMoyen, 0.0);
	}
	@Test
	public void testGetAllEmployeNamesJPQL() throws ParseException {
		List<String> names = employeService.getAllEmployeNamesJPQL();
		assertThat(names.get(0)).isEqualTo("Ghada");
	}
	
}
*/