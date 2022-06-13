package com.niki.pers_lib.DAO.sacredItem.sacredItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemTypeDAO implements ISacredItemTypeDAO {

    @Override
    public List<SacredItemType> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<SacredItemType> findByName(String str) {
        return null;
    }


    @Override
    public List<SacredItemType> findAll() {
        return null;
    }

    @Override
    public List<SacredItemType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItemType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItemType> findAllById(Iterable<Long> integers) {
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
    public void delete(SacredItemType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItemType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItemType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItemType> findById(Long integer) {
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
    public <S extends SacredItemType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItemType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItemType getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItemType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItemType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItemType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItemType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItemType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItemType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItemType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItemType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
