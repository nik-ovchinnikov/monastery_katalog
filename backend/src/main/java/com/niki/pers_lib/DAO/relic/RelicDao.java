package com.niki.pers_lib.DAO.relic;

import com.niki.pers_lib.entities.relic.Relic;
import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicDao implements IRelicDao {
    @Override
    public List<Relic> findByKey(String key) {
        return null;
    }

    @Override
    public List<Relic> findBySubType(RelicSubType iconSubType) {
        return null;
    }

    @Override
    public List<Relic> findByType(RelicType iconType) {
        return null;
    }

    @Override
    public List<Relic> findByPlace(RelicPlace iconPlace) {
        return null;
    }

    @Override
    public List<Relic> findBySubPlace(RelicSubPlace iconSubPlace) {
        return null;
    }


    @Override
    public List<Relic> findAll() {
        return null;
    }

    @Override
    public List<Relic> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Relic> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Relic> findAllById(Iterable<Long> integers) {
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
    public void delete(Relic entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Relic> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Relic> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Relic> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Relic> findById(Long integer) {
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
    public <S extends Relic> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Relic> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Relic> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Relic getOne(Long integer) {
        return null;
    }

    @Override
    public Relic getById(Long integer) {
        return null;
    }

    @Override
    public <S extends Relic> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Relic> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Relic> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Relic> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Relic> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Relic> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Relic, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
