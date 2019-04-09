package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.dataaccess.api.OrderEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class OrderRepositoryTest extends ComponentTest {

	public static LocalDate SUCCESS_DATE = LocalDate.of(2019, Month.MARCH, 15);
	public static LocalDate FAILURE_DATE = LocalDate.of(2019, Month.MAY, 1);

	@Inject
	private OrderRepository orderRepository;

	@Test
	public void shouldFindAllOrders() {
		// when
		List<OrderEntity> foundOrders = orderRepository.findAll();

		// then
		assertThat(foundOrders).hasSize(1);
	}

	@Test
	public void shouldFindAllByCreationDateAndStatus() {
		// when
		Page<OrderEntity> foundOrders = orderRepository.findAllByCreationDateAndStatus(
				SUCCESS_DATE, OrderStatus.SERVED, PageRequest.of(0, 3));

		// then
		assertThat(foundOrders.getContent()).hasSize(1);
		assertThat(foundOrders.getContent()).extracting("creationDate").containsExactly(SUCCESS_DATE);
	}

	@Test
	public void shouldNotFindAllByCreationDateAndStatus() {
		// when
		Page<OrderEntity> foundOrders = orderRepository.findAllByCreationDateAndStatus(
				FAILURE_DATE, OrderStatus.SERVED, PageRequest.of(0, 3));

		// then
		assertThat(foundOrders.getContent()).hasSize(0);
	}

}
