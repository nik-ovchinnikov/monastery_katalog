package com.niki.pers_lib.entities.relic.relic_place;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niki.pers_lib.entities.relic.Relic;
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
@Table(name = "relic_subplace")
public class RelicSubPlace {


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    private Date creationDate;
    private Date lastChangeDate;
    private String placeName;

    @JoinColumn(name = "relic_place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,}
    )
    @JsonIgnore
    private RelicPlace place;

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
    private List<Relic> iconList;

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
