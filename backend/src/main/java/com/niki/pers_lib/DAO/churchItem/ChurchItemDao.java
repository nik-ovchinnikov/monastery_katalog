package com.niki.pers_lib.DAO.churchItem;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemDao implements IChurchItemDao {
    @Override
    public List<ChurchItem> findByKey(String key) {
        return null;
    }

    @Override
    public List<ChurchItem> findBySubType(ChurchItemSubType iconSubType) {
        return null;
    }

    @Override
    public List<ChurchItem> findByType(ChurchItemType iconType) {
        return null;
    }

    @Override
    public List<ChurchItem> findByPlace(ChurchItemPlace iconPlace) {
        return null;
    }

    @Override
    public List<ChurchItem> findBySubPlace(ChurchItemSubPlace iconSubPlace) {
        return null;
    }


    @Override
    public List<ChurchItem> findAll() {
        return null;
    }

    @Override
    public List<ChurchItem> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItem> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItem entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItem> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItem> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItem> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItem> findById(Long integer) {
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
    public <S extends ChurchItem> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItem> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItem getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItem getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItem> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItem> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
