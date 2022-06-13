package com.niki.pers_lib.DAO.icon.icon_place;

import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconSubPlaceDao implements IIconSubPlaceDao {
    @Override
    public List<IconSubPlace> findAllByPlaceName(String name) {
        return null;
    }

    @Override
    public void deleteIconSubPlaceById(long id) {

    }

    @Override
    public List<IconSubPlace> findAll() {
        return null;
    }

    @Override
    public List<IconSubPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<IconSubPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<IconSubPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(IconSubPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends IconSubPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends IconSubPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IconSubPlace> findById(Long integer) {
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
    public <S extends IconSubPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<IconSubPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public IconSubPlace getOne(Long integer) {
        return null;
    }

    @Override
    public IconSubPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends IconSubPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends IconSubPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends IconSubPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends IconSubPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
