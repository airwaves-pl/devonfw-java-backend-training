package com.devonfw.app.java.order.common.builders;

import java.util.LinkedList;
import java.util.List;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;

/**
 * Test data builder for ItemEntity generated with cobigen.
 */
public class ItemEntityBuilder {

	private List<P<ItemEntity>> parameterToBeApplied;

	/**
	 * The constructor.
	 */
	public ItemEntityBuilder() {

		this.parameterToBeApplied = new LinkedList<>();
		fillMandatoryFields();
		fillMandatoryFields_custom();
	}

	/**
	 * @param name the name to add.
	 * @return the builder for fluent population of fields.
	 */
	public ItemEntityBuilder name(final String name) {
		this.parameterToBeApplied.add(new P<ItemEntity>() {
			@Override
			public void apply(ItemEntity target) {
				target.setName(name);
			}
		});
		return this;
	}

	/**
	 * @param description the description to add.
	 * @return the builder for fluent population of fields.
	 */
	public ItemEntityBuilder description(final String description) {
		this.parameterToBeApplied.add(new P<ItemEntity>() {
			@Override
			public void apply(ItemEntity target) {
				target.setDescription(description);
			}
		});
		return this;
	}

	/**
	 * @param price the price to add.
	 * @return the builder for fluent population of fields.
	 */
	public ItemEntityBuilder price(final Double price) {
		this.parameterToBeApplied.add(new P<ItemEntity>() {
			@Override
			public void apply(ItemEntity target) {
				target.setPrice(price);
			}
		});
		return this;
	}

	/**
	 * @return the populated ItemEntity.
	 */
	public ItemEntity createNew() {
		ItemEntity itementity = new ItemEntity();
		for (P<ItemEntity> parameter : parameterToBeApplied) {
			parameter.apply(itementity);
		}
		return itementity;
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
