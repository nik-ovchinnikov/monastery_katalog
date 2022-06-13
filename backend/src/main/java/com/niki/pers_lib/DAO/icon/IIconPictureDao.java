package com.niki.pers_lib.DAO.icon;

import com.niki.pers_lib.entities.icon.IconPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIconPictureDao extends JpaRepository<IconPicture, Long> {
    List<IconPicture> findByIconId(long iconId);
}
