package com.devonfw.app.java.order.orderservice.logic.api.to;

import java.util.Objects;

import com.devonfw.app.java.order.orderservice.common.api.Item;
import com.devonfw.module.basic.common.api.to.AbstractEto;

public class ItemEto extends AbstractEto implements Item {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ItemEto)) {
			return false;
		}
		ItemEto other = (ItemEto) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}

}
