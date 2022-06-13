package com.niki.pers_lib.DAO.icon.icon_type;

import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconTypeDAO implements IIconTypeDAO {

    @Override
    public List<IconType> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<IconType> findByName(String str) {
        return null;
    }


    @Override
    public List<IconType> findAll() {
        return null;
    }

    @Override
    public List<IconType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<IconType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<IconType> findAllById(Iterable<Long> integers) {
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
    public void delete(IconType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends IconType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends IconType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IconType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IconType> findById(Long integer) {
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
    public <S extends IconType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends IconType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<IconType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public IconType getOne(Long integer) {
        return null;
    }

    @Override
    public IconType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends IconType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends IconType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends IconType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends IconType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends IconType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends IconType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends IconType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
