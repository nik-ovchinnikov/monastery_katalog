package com.niki.pers_lib.DAO.relic.relic_type;

import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicTypeDAO implements IRelicTypeDAO {

    @Override
    public List<RelicType> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<RelicType> findByName(String str) {
        return null;
    }


    @Override
    public List<RelicType> findAll() {
        return null;
    }

    @Override
    public List<RelicType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RelicType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RelicType> findAllById(Iterable<Long> integers) {
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
    public void delete(RelicType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends RelicType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RelicType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RelicType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RelicType> findById(Long integer) {
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
    public <S extends RelicType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RelicType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RelicType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RelicType getOne(Long integer) {
        return null;
    }

    @Override
    public RelicType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends RelicType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RelicType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RelicType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RelicType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RelicType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RelicType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RelicType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
