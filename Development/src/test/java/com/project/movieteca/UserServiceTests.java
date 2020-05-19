package com.project.movieteca;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.application.MovietecaApplication;
import com.project.module.Admin;
import com.project.module.Customer;
import com.project.module.Provider;
import com.project.module.User;
import com.project.repository.AdminRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.ProviderRepository;
import com.project.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovietecaApplication.class })
class UserServiceTests {

	@Autowired
	private UserService userSerivce;

	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private ProviderRepository providerRepository;
	@MockBean
	private AdminRepository adminRepository;

	private int globalId = 2;

	@BeforeEach
	public void setUp() {
		Admin admin = new Admin(0, null,
				new User(1, "Admin", "Popescu", "Cristian", "admin@email.com", "Admin", "M", "Admin12345", "23.05.1995",
						"Romania", "Dolj", "Craiova", "Str. Trandafirului nr. 5", "0746969696", null, true, null));
		Provider provider = new Provider(new User(globalId, "Provider", "Popescu", "Maria", "provider@email.com",
				"Provider", "F", "Provider12345", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Facultatii nr. 32",
				"0712345678", null, true, null), 0, 0, 0, 0, 0, 0, true, null, null, null, null, null);
		Customer customer = new Customer(new User(3, "Customer", "Ion", "Marius", "customer@email.com", "Customer", "M",
				"Customer12345", "01.10.2000", "Romania", "Cluj", "Cluj-Napoca", "Str. Fabricii nr. 125", "0787654321",
				null, true, null), 0, 0, 0, 0, null, null, null, null, null, null);

		when(customerRepository.getOne(3)).thenReturn(customer);
		when(providerRepository.getOne(globalId)).thenReturn(provider);
		when(adminRepository.getOne(1)).thenReturn(admin);

		when(customerRepository.existsById(3)).thenReturn(true);
		when(providerRepository.existsById(globalId)).thenReturn(true);
		when(adminRepository.existsById(1)).thenReturn(true);
	}
	
	@Test
	public void getUserById_expectUserType() {
		String role= "Customer";
		
		assertEquals(role, userSerivce.getUserById(3).getUserType());
	}
}
