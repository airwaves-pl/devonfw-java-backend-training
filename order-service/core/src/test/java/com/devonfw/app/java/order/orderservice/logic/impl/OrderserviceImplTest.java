package com.devonfw.app.java.order.orderservice.logic.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.module.test.common.base.ComponentTest;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OrderserviceImplTest extends ComponentTest {

	@Inject
	private Orderservice orderService;

	private Long itemId1;
	private Long itemId2;
	private Long customerId;
	private Long orderId;

	@Before
	public void init() {
		ItemEto item1 = new ItemEto();
		item1.setName("spaghetti bolognese");
		item1.setDescription("Italy");
		item1.setPrice(250.0);
		itemId1 = orderService.saveItem(item1).getId();
		ItemEto item2 = new ItemEto();
		item2.setName("spaghetti carbonara");
		item2.setDescription("Italy");
		item2.setPrice(200.0);
		itemId2 = orderService.saveItem(item2).getId();
		CustomerEto customer = new CustomerEto();
		customer.setFirstname("John");
		customer.setLastname("Smith");
		customerId = orderService.saveCustomer(customer).getId();
/*		OrderEto order = new OrderEto();
		order.setCreationDate(LocalDate.parse("2019-04-10"));
		order.setOwnerId(customerId);
		order.setStatus(OrderStatus.NEW);
		order.setPrice(450.0);
		orderId = orderService.saveOrder(order).getId();*/
	}

	@Test
	public void shouldFindItems() {
		// given
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setPrice(250.0);
		Sort sort = Sort.by("price");
		criteria.setPageable(PageRequest.of(0, 20, sort));

		// when
		Page<ItemEto> foundItems = orderService.findItems(criteria);

		// then
		assertThat(foundItems.getContent()).hasSize(1);
	}

	@Test
	public void shouldCreateOrderWithTwoPositionsAndOwner() {
		// given
		ArrayList<ItemEto> orderPositions = new ArrayList<>();
		orderPositions.add(orderService.findItem(itemId1));
		orderPositions.add(orderService.findItem(itemId2));

		// when
		OrderEto savedOrder = orderService.createOrderWithTwoPositionsAndOwner(orderPositions, orderService.findCustomer(customerId));

		// then
		assertThat(savedOrder.getId()).isNotNull();
	}

	@Test
	public void shouldFindOrdersFromDayWithStatus() {
		// when
		Set<OrderEto> foundOrders = orderService.findOrdersFromDayWithStatus(LocalDate.of(2019, 04, 10), OrderStatus.NEW);

		// then
		assertThat(foundOrders).hasSize(1);
		assertThat(foundOrders).extracting("id").containsExactly(orderId);
	}

}
