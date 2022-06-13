package com.niki.pers_lib.DAO.icon.icon_place;

import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconPlaceDao implements IIconPlaceDao {
    @Override
    public List<IconPlace> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<IconPlace> findByName(String str) {
        return null;
    }


    @Override
    public List<IconPlace> findAll() {
        return null;
    }

    @Override
    public List<IconPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<IconPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<IconPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(IconPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends IconPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends IconPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IconPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IconPlace> findById(Long integer) {
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
    public <S extends IconPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends IconPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<IconPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public IconPlace getOne(Long integer) {
        return null;
    }

    @Override
    public IconPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends IconPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends IconPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends IconPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends IconPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends IconPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends IconPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends IconPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
