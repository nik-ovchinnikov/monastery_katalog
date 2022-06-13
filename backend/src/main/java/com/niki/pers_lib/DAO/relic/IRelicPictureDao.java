package com.niki.pers_lib.DAO.relic;

import com.niki.pers_lib.entities.relic.RelicPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicPictureDao extends JpaRepository<RelicPicture, Long> {
    List<RelicPicture> findByRelicId(long relicId);
}
