package com.niki.pers_lib.entities.relic.relic_type;

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
@Table(name = "relic_subtype")
public class RelicSubType {


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    private Date creationDate;
    private Date lastChangeDate;
    private String typeName;

    @JoinColumn(name = "relic_type_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,}
    )
    @JsonIgnore
    private RelicType type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false, name = "id")
    private long id;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "subType"
//            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private List<Relic> relicList;

    @Override
    public String toString() {
        if ((id != -1) && (name.equals(""))) {
            return "BookSubType{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", creationDate=" + creationDate +
                    ", lastChangeDate=" + lastChangeDate +
                    ", iconTypeName='" + typeName + '\'' +
                    ", iconType=" + type.getId() +
                    ", id=" + id +
//                ", bookList=" + bookList +
                    '}';
        } else {
            return "Отсутствует";
        }
    }
}
