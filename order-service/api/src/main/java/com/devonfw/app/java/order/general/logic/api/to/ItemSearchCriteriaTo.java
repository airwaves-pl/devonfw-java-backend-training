package com.devonfw.app.java.order.general.logic.api.to;

import org.springframework.data.domain.Pageable;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import com.devonfw.module.basic.common.api.to.AbstractTo;

public class ItemSearchCriteriaTo extends AbstractTo {

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
	public StringSearchConfigTo getNameOption() {
		return nameOption;
	}
	public void setNameOption(StringSearchConfigTo nameOption) {
		this.nameOption = nameOption;
	}
	public StringSearchConfigTo getDescriptionOption() {
		return descriptionOption;
	}
	public void setDescriptionOption(StringSearchConfigTo descriptionOption) {
		this.descriptionOption = descriptionOption;
	}
	public Pageable getPageable() {
		return pageable;
	}
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	private String name;
	  private String description;
	  private Double price;
	  private StringSearchConfigTo nameOption;
	  private StringSearchConfigTo descriptionOption;
	  private Pageable pageable;

}