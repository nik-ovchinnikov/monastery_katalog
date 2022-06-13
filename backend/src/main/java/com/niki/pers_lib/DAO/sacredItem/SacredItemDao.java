package com.niki.pers_lib.DAO.sacredItem;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.SacredItem;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemDao implements ISacredItemDao {
    @Override
    public List<SacredItem> findByKey(String key) {
        return null;
    }

    @Override
    public List<SacredItem> findBySubType(SacredItemSubType iconSubType) {
        return null;
    }

    @Override
    public List<SacredItem> findByType(SacredItemType iconType) {
        return null;
    }

    @Override
    public List<SacredItem> findByPlace(SacredItemPlace iconPlace) {
        return null;
    }

    @Override
    public List<SacredItem> findBySubPlace(SacredItemSubPlace iconSubPlace) {
        return null;
    }


    @Override
    public List<SacredItem> findAll() {
        return null;
    }

    @Override
    public List<SacredItem> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItem> findAllById(Iterable<Long> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long integer) {

    }

    @Override
    public void delete(SacredItem entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItem> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItem> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItem> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItem> findById(Long integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends SacredItem> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItem> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItem getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItem getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItem> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItem> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
