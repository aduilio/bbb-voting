package com.aduilio.votacaobbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aduilio.votacaobbb.model.Participant;

/**
 * Provides access to the database table Participant.
 */
public interface ParticipantRepository extends MongoRepository<Participant, String> {

}
