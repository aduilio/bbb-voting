package com.aduilio.votacaobbb.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aduilio.votacaobbb.exception.InvalidValueException;
import com.aduilio.votacaobbb.model.Participant;
import com.aduilio.votacaobbb.repository.ParticipantRepository;
import com.aduilio.votacaobbb.service.VotingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voting")
@RequiredArgsConstructor
public class VotingController {

	private static final String ERROR_MESSAGE_INVALID_ID = "Invalid participant id";

	private final VotingService service;
	private final ParticipantRepository participantRepository;

	@PostMapping
	public ResponseEntity<String> vote(@RequestBody Participant participant) {
		validateId(participant);

		service.addEvent(participant.getId());

		return ResponseEntity.ok()
				.build();
	}

	private void validateId(Participant participant) {
		if (StringUtils.isBlank(participant.getId())) {
			throw new InvalidValueException(ERROR_MESSAGE_INVALID_ID);
		}

		participantRepository.findById(participant.getId())
				.orElseThrow(() -> new InvalidValueException(ERROR_MESSAGE_INVALID_ID));
	}
}
