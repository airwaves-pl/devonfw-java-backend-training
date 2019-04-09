package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.devonfw.app.java.order.general.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest {

	public static String ITALY = "Italy";
	public static String SPAGHETTI_BOLOGNESE = "spaghetti bolognese";
	public static String SPAGHETTI_CARBONARA = "spaghetti carbonara";
	public static Double PRICE_250 = 250.0;

	@Inject
	private ItemRepository itemRepository;

	@Test
	public void shouldFindAllItems() {
		// when
		List<ItemEntity> foundItems = itemRepository.findAll();

		// then
		assertThat(foundItems).hasSize(1);
	}

	@Test
	public void shouldFindByAllCriteria() {
		// given
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setDescription(ITALY);
		criteria.setName(SPAGHETTI_BOLOGNESE);
		criteria.setPrice(PRICE_250);
		criteria.setPageable(PageRequest.of(0, 3));

		// when
		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems.getContent()).hasSize(1);
		assertThat(foundItems.getContent()).extracting("name").containsExactly(SPAGHETTI_BOLOGNESE);
//		assertThat(foundItems.getContent().iterator()).anyMatch(a -> a.getName().equals(SPAGHETTI_BOLOGNESE)
//				&& a.getDescription().equals(ITALY) && a.getPrice().equals(PRICE_250));
	}

	@Test
	public void shouldNotFindByName() {
		// given
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setName(SPAGHETTI_CARBONARA);
		criteria.setPageable(PageRequest.of(0, 3));

		// when
		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems.getContent()).hasSize(0);
	}

	@Test
	public void shouldFindByNameAndDescription() {
		// given
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setDescription(ITALY);
		criteria.setName(SPAGHETTI_BOLOGNESE);
		criteria.setPageable(PageRequest.of(0, 3));

		// when
		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems.getContent()).hasSize(1);
		assertThat(foundItems.getContent()).extracting("description").containsExactly(ITALY);
//		assertThat(foundItems.getContent().iterator())
//				.anyMatch(a -> a.getName().equals(SPAGHETTI_BOLOGNESE) && a.getDescription().equals(ITALY));
	}

	@Test
	public void shouldFindByPrice() {
		// given
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setPrice(PRICE_250);
		criteria.setPageable(PageRequest.of(0, 3));

		// when
		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems.getContent()).hasSize(1);
		assertThat(foundItems.getContent()).extracting("price").containsExactly(PRICE_250);
//		assertThat(foundItems.getContent().iterator()).anyMatch(a -> a.getPrice().equals(PRICE_250));
	}

	@Test
	public void shouldFindByNameAsc() {
		// when
		Page<ItemEntity> foundItems = itemRepository.findAllByNameIgnoreCaseOrderByNameAsc(SPAGHETTI_BOLOGNESE.toUpperCase(),
				PageRequest.of(0, 3));

		// then
		assertThat(foundItems.getContent()).hasSize(1);
		assertThat(foundItems.getContent()).extracting("name").containsExactly(SPAGHETTI_BOLOGNESE);
//		assertThat(foundItems.getContent().iterator()).anyMatch(a -> a.getName().equals(SPAGHETTI_BOLOGNESE));
	}

}
