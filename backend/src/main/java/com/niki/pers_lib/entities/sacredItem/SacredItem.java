package com.niki.pers_lib.entities.sacredItem;

import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
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
@Table(name = "sacred_item")
public class SacredItem {
    private String name;
    @Column(name = "publish_year")
    private String publishYear;
    private String publisher;
    private String seria;
    private String weight;
    private String size;
    private String description;
    private String key;
    private String material;


    @JoinColumn(name = "type_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private SacredItemType type;

    @JoinColumn(name = "subtype_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private SacredItemSubType subType;

    @JoinColumn(name = "place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private SacredItemPlace place;

    @JoinColumn(name = "subplace_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private SacredItemSubPlace subPlace;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "sacredItem",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<SacredItemPicture> pictureList;

    private Date creationDate;
    private Date lastChangeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", lastChangeDate=" + lastChangeDate +
                ", bookType=" + type +
                ", bookSubType=" + subType +
                ", bookPlace=" + place +
                ", bookSubPlace=" + subPlace +
                ", bookPictureList=" + pictureList +
                ", id=" + id +
                '}';
    }
}
