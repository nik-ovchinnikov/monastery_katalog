package com.niki.pers_lib.DAO.churchItem.churchItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemSubPlaceDao implements IChurchItemSubPlaceDao {
    @Override
    public List<ChurchItemSubPlace> findAllByPlaceName(String name) {
        return null;
    }

    @Override
    public void deleteChurchItemSubPlaceById(long id) {

    }

    @Override
    public List<ChurchItemSubPlace> findAll() {
        return null;
    }

    @Override
    public List<ChurchItemSubPlace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItemSubPlace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItemSubPlace> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItemSubPlace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItemSubPlace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItemSubPlace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItemSubPlace> findById(Long integer) {
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
    public <S extends ChurchItemSubPlace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItemSubPlace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItemSubPlace getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItemSubPlace getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItemSubPlace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubPlace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItemSubPlace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItemSubPlace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
