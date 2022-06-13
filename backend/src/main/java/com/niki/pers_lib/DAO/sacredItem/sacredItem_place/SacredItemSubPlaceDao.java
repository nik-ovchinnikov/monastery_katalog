package com.niki.pers_lib.DAO.sacredItem.sacredItem_place;

import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemSubPlaceDao implements ISacredItemSubPlaceDao {
    @Override
    public List<SacredItemSubPlace> findAllByPlaceName(String name) {
        return null;
    }

    @Override
    public void deleteSacredItemSubPlaceById(long id) {

    }

    @Override
    public List<SacredItemSubPlace> findAll() {
        return null;
    }

    @Override
    public List<SacredItemSubPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItemSubPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItemSubPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(SacredItemSubPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItemSubPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItemSubPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItemSubPlace> findById(Long integer) {
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
    public <S extends SacredItemSubPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItemSubPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItemSubPlace getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItemSubPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItemSubPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItemSubPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItemSubPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItemSubPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
