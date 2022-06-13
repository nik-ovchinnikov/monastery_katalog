package com.niki.pers_lib.entities.churchItem;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
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
@Table(name = "church_item")
public class ChurchItem {
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
    private ChurchItemType type;

    @JoinColumn(name = "subtype_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private ChurchItemSubType subType;

    @JoinColumn(name = "place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private ChurchItemPlace place;

    @JoinColumn(name = "subplace_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private ChurchItemSubPlace subPlace;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "churchItem",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<ChurchItemPicture> pictureList;

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
