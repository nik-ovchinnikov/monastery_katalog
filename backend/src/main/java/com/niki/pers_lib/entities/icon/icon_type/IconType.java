package com.niki.pers_lib.entities.icon.icon_type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niki.pers_lib.entities.icon.Icon;
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
@Table(name = "icon_type")
public class IconType {


    private String name;
    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "type",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}
//            cascade = {CascadeType.ALL}
    )
    private List<IconSubType> subTypeList;
    private Date creationDate;
    private Date lastChangeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "type"
//            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private List<Icon> iconList;

    @Override
    public String toString() {
        return "BookType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bookSubTypeList=" + subTypeList +
                ", creationDate=" + creationDate +
                ", lastChangeDate=" + lastChangeDate +
                ", id=" + id +
//                ", bookList=" + bookList +
                '}';
    }
}
