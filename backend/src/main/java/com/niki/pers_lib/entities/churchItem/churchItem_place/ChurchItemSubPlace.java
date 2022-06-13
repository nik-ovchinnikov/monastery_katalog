package com.niki.pers_lib.entities.churchItem.churchItem_place;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niki.pers_lib.entities.churchItem.ChurchItem;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "church_item_subplace")
public class ChurchItemSubPlace {


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    private Date creationDate;
    private Date lastChangeDate;
    private String placeName;

    @JoinColumn(name = "church_item_place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,}
    )
    @JsonIgnore
    private ChurchItemPlace place;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "subPlace",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}
//            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private List<ChurchItem> churchItemList;

    @Override
    public String toString() {
            return "BookSubPlace{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", creationDate=" + creationDate +
                    ", lastChangeDate=" + lastChangeDate +
                    ", iconPlaceName='" + placeName + '\'' +
//                    ", iconPlace=" + place.getId() +
                    ", id=" + id +
//                ", bookList=" + bookList +
                    '}';
    }
}
