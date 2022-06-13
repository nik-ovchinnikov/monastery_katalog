package com.niki.pers_lib.DAO.icon;

import com.niki.pers_lib.entities.icon.Icon;
import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class IconDao implements IIconDao {
    @Override
    public List<Icon> findByKey(String key) {
        return null;
    }

    @Override
    public List<Icon> findBySubType(IconSubType iconSubType) {
        return null;
    }

    @Override
    public List<Icon> findByType(IconType iconType) {
        return null;
    }

    @Override
    public List<Icon> findByPlace(IconPlace iconPlace) {
        return null;
    }

    @Override
    public List<Icon> findBySubPlace(IconSubPlace iconSubPlace) {
        return null;
    }


    @Override
    public List<Icon> findAll() {
        return null;
    }

    @Override
    public List<Icon> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Icon> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Icon> findAllById(Iterable<Long> integers) {
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
    public void delete(Icon entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Icon> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Icon> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Icon> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Icon> findById(Long integer) {
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
    public <S extends Icon> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Icon> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Icon> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Icon getOne(Long integer) {
        return null;
    }

    @Override
    public Icon getById(Long integer) {
        return null;
    }

    @Override
    public <S extends Icon> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Icon> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Icon> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Icon> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Icon> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Icon> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Icon, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
