package com.niki.pers_lib.entities.sacredItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sacred_item_picture")
public class SacredItemPicture {

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "sacred_item_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JsonIgnore
    private SacredItem sacredItem;

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
