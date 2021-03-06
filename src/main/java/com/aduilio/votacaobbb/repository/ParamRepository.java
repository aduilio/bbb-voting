package com.aduilio.votacaobbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aduilio.votacaobbb.model.Param;

/**
 * Provides access to the database table Param.
 */
public interface ParamRepository extends MongoRepository<Param, String> {

}
