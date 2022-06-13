package com.niki.pers_lib.entities.churchItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "church_item_picture")
public class ChurchItemPicture {

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "church_item_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JsonIgnore
    private ChurchItem churchItem;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Override
    public String toString() {
        return "BookPicture{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", book=" + icon.getId() +
                '}';
    }
}
