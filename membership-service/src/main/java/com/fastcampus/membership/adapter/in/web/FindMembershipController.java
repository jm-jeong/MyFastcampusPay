package com.fastcampus.membership.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.membership.application.port.in.FindMembershipCommand;
import com.fastcampus.membership.application.port.in.FindMembershipUseCase;
import com.fastcampus.membership.domain.Membership;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {
	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {
		FindMembershipCommand command = FindMembershipCommand.builder()
			.membershipId(membershipId)
			.build();

		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
}
