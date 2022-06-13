package com.niki.pers_lib.DAO.sacredItem;

import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import com.niki.pers_lib.entities.sacredItem.SacredItemPicture;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemPictureDao implements ISacredItemPictureDao {

    @Override
    public List<SacredItemPicture> findBySacredItemId(long bookId) {
        return null;
    }

    @Override
    public List<SacredItemPicture> findAll() {
        return null;
    }

    @Override
    public List<SacredItemPicture> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItemPicture> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItemPicture> findAllById(Iterable<Long> integers) {
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
    public void delete(SacredItemPicture entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItemPicture> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItemPicture> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItemPicture> findById(Long integer) {
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
    public <S extends SacredItemPicture> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItemPicture> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItemPicture getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItemPicture getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItemPicture> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItemPicture> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItemPicture> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItemPicture, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
