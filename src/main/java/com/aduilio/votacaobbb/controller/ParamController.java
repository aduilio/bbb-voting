package com.aduilio.votacaobbb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aduilio.votacaobbb.exception.NotFoundException;
import com.aduilio.votacaobbb.model.Param;
import com.aduilio.votacaobbb.repository.ParamRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/params")
@RequiredArgsConstructor
public class ParamController {

	private final ParamRepository paramRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Param> save(@RequestBody Param param) {
		paramRepository.save(param);

		return ResponseEntity.ok(param);
	}

	@GetMapping
	public ResponseEntity<Param> read(@RequestParam String key) {
		Param param = paramRepository.findById(key)
				.orElseThrow(() -> new NotFoundException("Param " + key + " not found"));

		return ResponseEntity.ok(param);
	}
}
