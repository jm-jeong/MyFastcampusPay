package com.fastcampus.banking.adpater.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampus.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampus.banking.domain.RegisteredBankAccount;
import com.fastcampus.common.WebAdapter;

import lombok.RequiredArgsConstructor;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registeredBankAccountUseCase;
    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        return registeredBankAccountUseCase.registerBankAccount(command);
    }
}
