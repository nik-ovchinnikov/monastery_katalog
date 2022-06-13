package com.niki.pers_lib.entities.sacredItem.sacredItem_place;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niki.pers_lib.entities.sacredItem.SacredItem;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sacred_item_place")
public class SacredItemPlace {

    private String name;
    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "place",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<SacredItemSubPlace> subPlaceList;
    private Date creationDate;
    private Date lastChangeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "place",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}
//            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private List<SacredItem> sacredItemList;

    @Override
    public String toString() {
        return "BookPlace{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconSubPlaceList=" + subPlaceList +
                ", creationDate=" + creationDate +
                ", lastChangeDate=" + lastChangeDate +
                ", id=" + id +
//                ", bookList=" + bookList +
                '}';
    }
}
