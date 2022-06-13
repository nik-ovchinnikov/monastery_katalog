package com.niki.pers_lib.DAO.churchItem.churchItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemPlaceDao implements IChurchItemPlaceDao {
    @Override
    public List<ChurchItemPlace> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<ChurchItemPlace> findByName(String str) {
        return null;
    }


    @Override
    public List<ChurchItemPlace> findAll() {
        return null;
    }

    @Override
    public List<ChurchItemPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItemPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItemPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItemPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItemPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItemPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItemPlace> findById(Long integer) {
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
    public <S extends ChurchItemPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItemPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItemPlace getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItemPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItemPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItemPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItemPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItemPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
