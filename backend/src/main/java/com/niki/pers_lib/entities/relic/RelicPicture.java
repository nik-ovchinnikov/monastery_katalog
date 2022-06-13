package com.niki.pers_lib.entities.relic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "relic_picture")
public class RelicPicture {

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "relic_id")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JsonIgnore
    private Relic relic;

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
