package com.devonfw.app.java.order.orderservice.logic.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.general.logic.base.AbstractComponentFacade;
import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindCustomer;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindItem;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindOrder;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageCustomer;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageOrder;

@Named
public class OrderserviceImpl extends AbstractComponentFacade implements Orderservice {

	@Inject
	private UcFindItem ucFindItem;

	@Inject
	private UcManageItem ucManageItem;

	@Inject
	private UcFindCustomer ucFindCustomer;

	@Inject
	private UcManageCustomer ucManageCustomer;

	@Inject
	private UcFindOrder ucFindOrder;

	@Inject
	private UcManageOrder ucManageOrder;

	@Override
	public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {
		return this.ucFindItem.findItems(criteria);
	}

	@Override
	public ItemEto findItem(long id) {
		return this.ucFindItem.findItem(id);
	}

	@Override
	public boolean deleteItem(long itemId) {
		return this.ucManageItem.deleteItem(itemId);
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		return this.ucManageItem.saveItem(item);
	}

	@Override
	public CustomerEto findCustomer(long id) {

		return this.ucFindCustomer.findCustomer(id);
	}

	@Override
	public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {
		return this.ucFindCustomer.findCustomers(criteria);
	}

	@Override
	public CustomerEto saveCustomer(CustomerEto customer) {

		return this.ucManageCustomer.saveCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(long id) {

		return this.ucManageCustomer.deleteCustomer(id);
	}

	@Override
	public OrderEto findOrder(long id) {

		return this.ucFindOrder.findOrder(id);
	}

	@Override
	public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {
		return this.ucFindOrder.findOrders(criteria);
	}

	@Override
	public OrderEto saveOrder(OrderEto order) {

		return this.ucManageOrder.saveOrder(order);
	}

	@Override
	public boolean deleteOrder(long id) {

		return this.ucManageOrder.deleteOrder(id);
	}

	@Override
	public boolean increasePriceOfItemWithName(String name, Double price) {
		return this.ucManageItem.increasePriceOfItemWithName(name, price);
	}

	@Override
	public OrderEto createOrderWithTwoPositionsAndOwner(List<ItemEto> orderPositions, CustomerEto owner) {
		return this.ucManageOrder.createOrderWithTwoPositionsAndOwner(orderPositions, owner);
	}

	@Override
	public Set<OrderEto> findOrdersFromDayWithStatus(LocalDate creationDate, OrderStatus status) {
		return this.ucFindOrder.findOrdersFromDayWithStatus(creationDate, status);
	}

	@Override
	public Page<ItemEto> findItemsWithNameLike(String name) {
		return this.ucFindItem.findItemsWithNameLike(name);
	}

}
