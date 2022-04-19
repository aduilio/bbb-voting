package com.aduilio.votacaobbb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aduilio.votacaobbb.model.Participant;
import com.aduilio.votacaobbb.service.VotingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voting")
@RequiredArgsConstructor
public class VotingController {

	private final VotingService service;

	@PostMapping
	public ResponseEntity<String> vote(@RequestBody Participant participant) {
		service.addEvent(participant.getId());

		return ResponseEntity.ok()
				.build();
	}
}
