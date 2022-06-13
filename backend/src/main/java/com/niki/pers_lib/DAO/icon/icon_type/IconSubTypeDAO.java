package com.niki.pers_lib.DAO.icon.icon_type;

import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconSubTypeDAO implements IIconSubTypeDAO {
    @Override
    public List<IconSubType> findAllByTypeName(String name) {
        return null;
    }

    @Override
    public void deleteIconSubTypeById(long id) {

    }

    //стандартные методы, наследованные от JpaRepository
    @Override
    public List<IconSubType> findAll() {
        return null;
    }

    @Override
    public List<IconSubType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<IconSubType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<IconSubType> findAllById(Iterable<Long> integers) {
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
    public void delete(IconSubType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends IconSubType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends IconSubType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IconSubType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IconSubType> findById(Long integer) {
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
    public <S extends IconSubType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends IconSubType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<IconSubType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public IconSubType getOne(Long integer) {
        return null;
    }

    @Override
    public IconSubType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends IconSubType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends IconSubType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends IconSubType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends IconSubType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends IconSubType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends IconSubType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends IconSubType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
