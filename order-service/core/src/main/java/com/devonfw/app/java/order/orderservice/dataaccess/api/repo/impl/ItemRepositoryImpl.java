package com.devonfw.app.java.order.orderservice.dataaccess.api.repo.impl;

import java.util.Iterator;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.repo.ItemRepositoryCustom;
import com.querydsl.core.alias.Alias;
import com.querydsl.jpa.impl.JPAQuery;

public class ItemRepositoryImpl implements ItemRepositoryCustom {

	public void addOrderBy(JPAQuery<ItemEntity> query, ItemEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "name":
					if (next.isAscending()) {
						query.orderBy(Alias.$(alias.getName()).asc());
					} else {
						query.orderBy(Alias.$(alias.getName()).desc());
					}
					break;
				case "description":
					if (next.isAscending()) {
						query.orderBy(Alias.$(alias.getDescription()).asc());
					} else {
						query.orderBy(Alias.$(alias.getDescription()).desc());
					}
					break;
				case "price":
					if (next.isAscending()) {
						query.orderBy(Alias.$(alias.getPrice()).asc());
					} else {
						query.orderBy(Alias.$(alias.getPrice()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}
