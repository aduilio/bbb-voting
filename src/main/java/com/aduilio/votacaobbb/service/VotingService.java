package com.aduilio.votacaobbb.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VotingService {

	private final static String VOTING_TOPIC = "voting";

	private final KafkaTemplate<Object, Object> template;

	/**
	 * Add an event to the Kafka topic 'voting'.
	 *
	 * @param participantId the identification of the participant that receives a
	 *                      vote
	 */
	public void addEvent(String participantId) {
		template.send(VOTING_TOPIC, participantId);
	}
}
