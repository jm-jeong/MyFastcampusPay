package com.fastcampus.banking.application.port.in;

import com.fastcampus.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
	RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
