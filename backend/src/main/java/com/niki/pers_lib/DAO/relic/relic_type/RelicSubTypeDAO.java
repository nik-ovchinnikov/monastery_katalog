package com.niki.pers_lib.DAO.relic.relic_type;

import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicSubTypeDAO implements IRelicSubTypeDAO {
    @Override
    public List<RelicSubType> findAllByTypeName(String name) {
        return null;
    }

    @Override
    public void deleteRelicSubTypeById(long id) {

    }

    //стандартные методы, наследованные от JpaRepository
    @Override
    public List<RelicSubType> findAll() {
        return null;
    }

    @Override
    public List<RelicSubType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RelicSubType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RelicSubType> findAllById(Iterable<Long> integers) {
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
    public void delete(RelicSubType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends RelicSubType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RelicSubType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RelicSubType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RelicSubType> findById(Long integer) {
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
    public <S extends RelicSubType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RelicSubType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RelicSubType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RelicSubType getOne(Long integer) {
        return null;
    }

    @Override
    public RelicSubType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends RelicSubType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RelicSubType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RelicSubType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RelicSubType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RelicSubType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RelicSubType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RelicSubType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
