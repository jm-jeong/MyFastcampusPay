package com.fastcampus.money.application.port.in;

import com.fastcampus.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {
	MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
