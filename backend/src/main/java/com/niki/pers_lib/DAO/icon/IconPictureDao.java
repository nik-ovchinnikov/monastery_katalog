package com.niki.pers_lib.DAO.icon;

import com.niki.pers_lib.entities.icon.IconPicture;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconPictureDao implements IIconPictureDao {

    @Override
    public List<IconPicture> findByIconId(long bookId) {
        return null;
    }

    @Override
    public List<IconPicture> findAll() {
        return null;
    }

    @Override
    public List<IconPicture> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<IconPicture> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<IconPicture> findAllById(Iterable<Long> integers) {
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
    public void delete(IconPicture entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends IconPicture> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends IconPicture> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IconPicture> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IconPicture> findById(Long integer) {
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
    public <S extends IconPicture> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends IconPicture> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<IconPicture> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public IconPicture getOne(Long integer) {
        return null;
    }

    @Override
    public IconPicture getById(Long integer) {
        return null;
    }

    @Override
    public <S extends IconPicture> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends IconPicture> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends IconPicture> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends IconPicture> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends IconPicture> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends IconPicture> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends IconPicture, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
