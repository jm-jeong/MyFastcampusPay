package com.fastcampus.membership.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampus.membership.adapter.out.persistence.MembershipMapper;
import com.fastcampus.membership.application.port.in.FindMembershipCommand;
import com.fastcampus.membership.application.port.in.FindMembershipUseCase;
import com.fastcampus.membership.application.port.out.FindMembershipPort;
import com.fastcampus.membership.domain.Membership;

import common.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {
	private final FindMembershipPort findMembershipPort;

	private final MembershipMapper membershipMapper;
	@Override
	public Membership findMembership(FindMembershipCommand command) {
		MembershipJpaEntity entity = findMembershipPort.findMembership(
			new Membership.MembershipId(command.getMembershipId()));
		return membershipMapper.mapToDomainEntity(entity);
	}
}
