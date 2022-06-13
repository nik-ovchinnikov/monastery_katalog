package com.niki.pers_lib.entities.icon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "icon_picture")
public class IconPicture {

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "icon_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JsonIgnore
    private Icon icon;

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
