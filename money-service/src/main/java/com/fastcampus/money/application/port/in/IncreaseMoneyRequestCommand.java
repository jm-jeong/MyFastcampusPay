package com.fastcampus.money.application.port.in;

import javax.validation.constraints.NotNull;

import com.fastcampus.common.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {
	@NotNull
	private final String targetMembershipId;

	@NotNull
	private final int amount;

	public IncreaseMoneyRequestCommand(@NotNull String targetMembershipId, @NotNull int amount) {
		this.targetMembershipId = targetMembershipId;
		this.amount = amount;
		this.validateSelf();
	}
}
