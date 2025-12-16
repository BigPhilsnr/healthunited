package com.pm.stockmanagement.repository.item;

import com.pm.stockmanagement.entity.Item;
import com.pm.stockmanagement.service.dto.item.ItemFetchDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomItemRepositoryImp implements CustomItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> filterItem(ItemFetchDto filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);

        Predicate predicate = ItemSpecification.filter(filter).toPredicate(root, cq, cb);
        cq.where(predicate);

        List<Item> tuples = em.createQuery(cq).getResultList();
        return tuples;
    }
}
