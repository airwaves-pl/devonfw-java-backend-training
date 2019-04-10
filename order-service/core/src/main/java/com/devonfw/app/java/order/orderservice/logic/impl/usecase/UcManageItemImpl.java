package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Set;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.general.logic.base.AbstractItemUc;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;

@Named
@Validated
@Transactional
public class UcManageItemImpl  extends AbstractItemUc implements UcManageItem {

	private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

	@Override
	public boolean deleteItem(long itemId) {
		LOG.debug("Delete Item with id {} from database.", itemId);
		try {
			getItemRepository().deleteById(itemId);
			return true;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		LOG.debug("Save Item with to database.");
		ItemEntity itemEntity = getBeanMapper().map(item, ItemEntity.class);
		return getBeanMapper().map(getItemRepository().save(itemEntity), ItemEto.class);

	}

	@Override
	public boolean increasePriceOfItemWithName(String name, Double price) {
		LOG.debug("Increase price to {} of item with name {}.", price, name);
		Set<ItemEntity> itemEntities = getItemRepository().findByName(name);
		if (itemEntities.isEmpty()) {
			return false;
		}
		for (ItemEntity item : itemEntities) {
			item.setPrice(price);
		}
		getItemRepository().saveAll(itemEntities);
		return true;
	}

}
