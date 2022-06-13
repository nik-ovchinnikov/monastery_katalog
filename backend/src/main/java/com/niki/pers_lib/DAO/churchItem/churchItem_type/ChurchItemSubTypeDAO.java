package com.niki.pers_lib.DAO.churchItem.churchItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemSubTypeDAO implements IChurchItemSubTypeDAO {
    @Override
    public List<ChurchItemSubType> findAllByTypeName(String name) {
        return null;
    }

    @Override
    public void deleteChurchItemSubTypeById(long id) {

    }

    //стандартные методы, наследованные от JpaRepository
    @Override
    public List<ChurchItemSubType> findAll() {
        return null;
    }

    @Override
    public List<ChurchItemSubType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItemSubType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItemSubType> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItemSubType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItemSubType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItemSubType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItemSubType> findById(Long integer) {
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
    public <S extends ChurchItemSubType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItemSubType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItemSubType getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItemSubType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItemSubType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItemSubType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItemSubType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItemSubType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
