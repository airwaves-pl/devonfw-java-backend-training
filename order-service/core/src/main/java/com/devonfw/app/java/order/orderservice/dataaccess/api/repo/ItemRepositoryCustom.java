package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import org.springframework.data.domain.Sort;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.querydsl.jpa.impl.JPAQuery;

public interface ItemRepositoryCustom {

	public void addOrderBy(JPAQuery<ItemEntity> query, ItemEntity alias, Sort sort);

}
