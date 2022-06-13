package com.niki.pers_lib.DAO.sacredItem;

import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import com.niki.pers_lib.entities.sacredItem.SacredItemPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemPictureDao extends JpaRepository<SacredItemPicture, Long> {
    List<SacredItemPicture> findBySacredItemId(long sacredItemId);
}
