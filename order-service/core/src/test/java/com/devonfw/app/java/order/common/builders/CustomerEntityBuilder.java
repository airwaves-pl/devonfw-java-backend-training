package com.devonfw.app.java.order.common.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.devonfw.app.java.order.orderservice.dataaccess.api.CustomerEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.OrderEntity;

/**
 * Test data builder for CustomerEntity generated with cobigen.
 */
public class CustomerEntityBuilder {

	private List<P<CustomerEntity>> parameterToBeApplied;

	/**
	 * The constructor.
	 */
	public CustomerEntityBuilder() {

		this.parameterToBeApplied = new LinkedList<>();
		fillMandatoryFields();
		fillMandatoryFields_custom();
	}

	/**
	 * @param firstname the firstname to add.
	 * @return the builder for fluent population of fields.
	 */
	public CustomerEntityBuilder firstname(final String firstname) {
		this.parameterToBeApplied.add(new P<CustomerEntity>() {
			@Override
			public void apply(CustomerEntity target) {
				target.setFirstname(firstname);
			}
		});
		return this;
	}

	/**
	 * @param lastname the lastname to add.
	 * @return the builder for fluent population of fields.
	 */
	public CustomerEntityBuilder lastname(final String lastname) {
		this.parameterToBeApplied.add(new P<CustomerEntity>() {
			@Override
			public void apply(CustomerEntity target) {
				target.setLastname(lastname);
			}
		});
		return this;
	}

	/**
	 * @param orders the orders to add.
	 * @return the builder for fluent population of fields.
	 */
	public CustomerEntityBuilder orders(final Set<OrderEntity> orders) {
		this.parameterToBeApplied.add(new P<CustomerEntity>() {
			@Override
			public void apply(CustomerEntity target) {
				target.setOrders(orders);
			}
		});
		return this;
	}

	/**
	 * @return the populated CustomerEntity.
	 */
	public CustomerEntity createNew() {
		CustomerEntity customerentity = new CustomerEntity();
		for (P<CustomerEntity> parameter : parameterToBeApplied) {
			parameter.apply(customerentity);
		}
		return customerentity;
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
