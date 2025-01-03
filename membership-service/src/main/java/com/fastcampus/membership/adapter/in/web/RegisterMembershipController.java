package com.fastcampus.membership.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.common.WebAdapter;
import com.fastcampus.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampus.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampus.membership.domain.Membership;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

	private final RegisterMembershipUseCase registerMembershipUseCase;

	@PostMapping(path = "/membership/register")
	Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
			.name(request.getName())
			.address(request.getAddress())
			.email(request.getEmail())
			.isValid(true)
			.isCorp(request.isCorp())
			.build();

		return registerMembershipUseCase.registerMembership(command);
	}
}
