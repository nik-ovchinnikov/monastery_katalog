package com.niki.pers_lib.DAO.relic.relic_place;

import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicPlaceDao implements IRelicPlaceDao {
    @Override
    public List<RelicPlace> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<RelicPlace> findByName(String str) {
        return null;
    }


    @Override
    public List<RelicPlace> findAll() {
        return null;
    }

    @Override
    public List<RelicPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RelicPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RelicPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(RelicPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends RelicPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RelicPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RelicPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RelicPlace> findById(Long integer) {
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
    public <S extends RelicPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RelicPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RelicPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RelicPlace getOne(Long integer) {
        return null;
    }

    @Override
    public RelicPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends RelicPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RelicPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RelicPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RelicPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RelicPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RelicPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RelicPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
