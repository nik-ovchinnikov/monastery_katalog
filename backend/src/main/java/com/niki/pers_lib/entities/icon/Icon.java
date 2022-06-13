package com.niki.pers_lib.entities.icon;

import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
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
@Table(name = "icon")
public class Icon {
    private String name;
    private String author;
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
    private IconType type;

    @JoinColumn(name = "subtype_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private IconSubType subType;

    @JoinColumn(name = "place_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private IconPlace place;

    @JoinColumn(name = "subplace_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private IconSubPlace subPlace;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "icon",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<IconPicture> pictureList;

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
