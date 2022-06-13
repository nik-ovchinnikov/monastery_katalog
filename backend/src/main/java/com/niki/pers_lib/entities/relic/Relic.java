package com.niki.pers_lib.entities.relic;

import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
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
@Table(name = "relic")
public class Relic {
    private String name;
    @Column(name = "publish_year")
    private String publishYear;
    private String seria;
    private String description;
    private String key;


    @JoinColumn(name = "type_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private RelicType type;

    @JoinColumn(name = "subtype_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private RelicSubType subType;

    @JoinColumn(name = "place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private RelicPlace place;

    @JoinColumn(name = "subplace_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private RelicSubPlace subPlace;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "relic",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<RelicPicture> pictureList;

    private Date creationDate;
    private Date lastChangeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @Override
    public String toString() {
        return "Relic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", lastChangeDate=" + lastChangeDate +
                ", Type=" + type +
                ", SubType=" + subType +
                ", Place=" + place +
                ", SubPlace=" + subPlace +
                ", PictureList=" + pictureList +
                ", id=" + id +
                '}';
    }
}
