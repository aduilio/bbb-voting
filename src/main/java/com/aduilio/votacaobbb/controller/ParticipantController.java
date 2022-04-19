package com.aduilio.votacaobbb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aduilio.votacaobbb.model.Participant;
import com.aduilio.votacaobbb.repository.ParticipantRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

	private final ParticipantRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Participant> save(@RequestBody Participant participant) {
		Participant result = repository.save(participant);
		return ResponseEntity.ok(result);
	}

	@GetMapping
	public ResponseEntity<List<Participant>> list() {
		return ResponseEntity.ok(repository.findAll());
	}
}
