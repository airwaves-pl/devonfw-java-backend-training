package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.devonfw.app.java.order.orderservice.dataaccess.api.CustomerEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CustomerRepositoryTest extends ComponentTest {

	@Inject
	private CustomerRepository customerRepository;

	@Test
	public void shouldFindAllCustomers() {
		// when
		List<CustomerEntity> foundCustomers = customerRepository.findAll();

		// then
		assertThat(foundCustomers).hasSize(1);
	}

	@Test
	@Transactional
	public void shouldRemoveCustomerById() {
		// when
		Long deletedCount = customerRepository.removeById(31L);

		// then
		assertThat(customerRepository.findById(31L)).isEmpty();
		assertThat(deletedCount).isEqualTo(1L);
	}

}
