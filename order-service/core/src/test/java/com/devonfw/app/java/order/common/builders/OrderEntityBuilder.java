package com.devonfw.app.java.order.common.builders;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.dataaccess.api.CustomerEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.OrderEntity;

/**
 * Test data builder for OrderEntity generated with cobigen.
 */
public class OrderEntityBuilder {

	private List<P<OrderEntity>> parameterToBeApplied;

	/**
	 * The constructor.
	 */
	public OrderEntityBuilder() {

		this.parameterToBeApplied = new LinkedList<>();
		fillMandatoryFields();
		fillMandatoryFields_custom();
	}

	/**
	 * @param price the price to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder price(final Double price) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setPrice(price);
			}
		});
		return this;
	}

	/**
	 * @param status the status to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder status(final OrderStatus status) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setStatus(status);
			}
		});
		return this;
	}

	/**
	 * @param creationDate the creationDate to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder creationDate(final LocalDate creationDate) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setCreationDate(creationDate);
			}
		});
		return this;
	}

	/**
	 * @param owner the owner to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder owner(final CustomerEntity owner) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setOwner(owner);
			}
		});
		return this;
	}

	/**
	 * @param orderPositions the orderPositions to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder orderPositions(final Set<ItemEntity> orderPositions) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setOrderPositions(orderPositions);
			}
		});
		return this;
	}

	/**
	 * @param ownerId the ownerId to add.
	 * @return the builder for fluent population of fields.
	 */
	public OrderEntityBuilder ownerId(final Long ownerId) {
		this.parameterToBeApplied.add(new P<OrderEntity>() {
			@Override
			public void apply(OrderEntity target) {
				target.setOwnerId(ownerId);
			}
		});
		return this;
	}

	/**
	 * @return the populated OrderEntity.
	 */
	public OrderEntity createNew() {
		OrderEntity orderentity = new OrderEntity();
		for (P<OrderEntity> parameter : parameterToBeApplied) {
			parameter.apply(orderentity);
		}
		return orderentity;
	}

	/**
	 * Might be enriched to users needs (will not be overwritten)
	 */
	private void fillMandatoryFields_custom() {

	}

	/**
	 * Fills all mandatory fields by default. (will be overwritten on re-generation)
	 */
	private void fillMandatoryFields() {
	}

}
