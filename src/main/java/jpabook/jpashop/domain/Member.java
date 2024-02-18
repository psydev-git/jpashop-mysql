package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    /**
     * 내장타입은 Embedded 어노테이션을 넣어준다.
     */
    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //mappedBy 나는 연관관계의 주인이 아니에요.
    //Order.java 의 member 필드에 의해서 나는 맵핑된거야 . 즉, Member에서 orders에 수정을 해도 Order.nember애 영향을 주지 않는다.(거울)

}
