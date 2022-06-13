package com.niki.pers_lib.DAO.churchItem;

import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemPictureDao implements IChurchItemPictureDao {

    @Override
    public List<ChurchItemPicture> findByChurchItemId(long bookId) {
        return null;
    }

    @Override
    public List<ChurchItemPicture> findAll() {
        return null;
    }

    @Override
    public List<ChurchItemPicture> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItemPicture> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItemPicture> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItemPicture entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItemPicture> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItemPicture> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItemPicture> findById(Long integer) {
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
    public <S extends ChurchItemPicture> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItemPicture> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItemPicture getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItemPicture getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItemPicture> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItemPicture> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItemPicture> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItemPicture, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
