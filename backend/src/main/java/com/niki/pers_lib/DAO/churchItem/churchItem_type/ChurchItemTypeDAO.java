package com.niki.pers_lib.DAO.churchItem.churchItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ChurchItemTypeDAO implements IChurchItemTypeDAO {

    @Override
    public List<ChurchItemType> findAllByOrderByIdDesc() {
        return null;
    }

    @Override
    public List<ChurchItemType> findByName(String str) {
        return null;
    }


    @Override
    public List<ChurchItemType> findAll() {
        return null;
    }

    @Override
    public List<ChurchItemType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ChurchItemType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ChurchItemType> findAllById(Iterable<Long> integers) {
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
    public void delete(ChurchItemType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChurchItemType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ChurchItemType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChurchItemType> findById(Long integer) {
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
    public <S extends ChurchItemType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ChurchItemType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ChurchItemType getOne(Long integer) {
        return null;
    }

    @Override
    public ChurchItemType getById(Long integer) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ChurchItemType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ChurchItemType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ChurchItemType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ChurchItemType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
