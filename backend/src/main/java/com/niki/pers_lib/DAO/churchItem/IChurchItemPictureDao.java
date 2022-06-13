package com.niki.pers_lib.DAO.churchItem;

import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemPictureDao extends JpaRepository<ChurchItemPicture, Long> {
    List<ChurchItemPicture> findByChurchItemId(long churchItemId);
}
