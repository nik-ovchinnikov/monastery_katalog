package com.niki.pers_lib.DAO.sacredItem.sacredItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SacredItemSubTypeDAO implements ISacredItemSubTypeDAO {
    @Override
    public List<SacredItemSubType> findAllByTypeName(String name) {
        return null;
    }

    @Override
    public void deleteSacredItemSubTypeById(long id) {

    }

    //стандартные методы, наследованные от JpaRepository
    @Override
    public List<SacredItemSubType> findAll() {
        return null;
    }

    @Override
    public List<SacredItemSubType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SacredItemSubType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SacredItemSubType> findAllById(Iterable<Long> integers) {
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
    public void delete(SacredItemSubType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends SacredItemSubType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SacredItemSubType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SacredItemSubType> findById(Long integer) {
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
    public <S extends SacredItemSubType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<SacredItemSubType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SacredItemSubType getOne(Long integer) {
        return null;
    }

    @Override
    public SacredItemSubType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SacredItemSubType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SacredItemSubType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SacredItemSubType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends SacredItemSubType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
