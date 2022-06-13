package com.niki.pers_lib.DAO.relic;

import com.niki.pers_lib.entities.relic.RelicPicture;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RelicPictureDao implements IRelicPictureDao{
    @Override
    public List<RelicPicture> findByRelicId(long relicId) {
        return null;
    }

    @Override
    public List<RelicPicture> findAll() {
        return null;
    }

    @Override
    public List<RelicPicture> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RelicPicture> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RelicPicture> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(RelicPicture entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RelicPicture> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RelicPicture> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RelicPicture> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RelicPicture> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends RelicPicture> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RelicPicture> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RelicPicture> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RelicPicture getOne(Long aLong) {
        return null;
    }

    @Override
    public RelicPicture getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends RelicPicture> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RelicPicture> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RelicPicture> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RelicPicture> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RelicPicture> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RelicPicture> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RelicPicture, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
