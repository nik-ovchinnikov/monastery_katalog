package com.niki.pers_lib.DAO.relic.relic_place;

import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicSubPlaceDao implements IRelicSubPlaceDao {
    @Override
    public List<RelicSubPlace> findAllByPlaceName(String name) {
        return null;
    }

    @Override
    public void deleteRelicSubPlaceById(long id) {

    }

    @Override
    public List<RelicSubPlace> findAll() {
        return null;
    }

    @Override
    public List<RelicSubPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RelicSubPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RelicSubPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(RelicSubPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends RelicSubPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RelicSubPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RelicSubPlace> findById(Long integer) {
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
    public <S extends RelicSubPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RelicSubPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RelicSubPlace getOne(Long integer) {
        return null;
    }

    @Override
    public RelicSubPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RelicSubPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RelicSubPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RelicSubPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RelicSubPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
