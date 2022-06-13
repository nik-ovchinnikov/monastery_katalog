package com.niki.pers_lib.DAO.sacredItem.sacredItem_place;

import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemPlaceDao implements ISacredItemPlaceDao {
    @Override
    public List<SacredItemPlace> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<SacredItemPlace> findByName(String str) {
        return null;
    }


    @Override
    public List<SacredItemPlace> findAll() {
        return null;
    }

    @Override
    public List<SacredItemPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItemPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItemPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(SacredItemPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItemPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItemPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItemPlace> findById(Long integer) {
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
    public <S extends SacredItemPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItemPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItemPlace getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItemPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItemPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItemPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItemPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItemPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
