package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {

            //insert Item은 JPA에서 저장할때 까지 id 가 없기 때문에 persist() 처리 (완전히 새로 생성된 객체)
            em.persist(item);
        } else {
            //update 와 비슷한것으로 우선 이해
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        //Item 한개만 조회 하는것 find() :: 단건조회 (기본적으로 제공)
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery(
                "select i from Item i", Item.class)
                .getResultList();
    }
}
