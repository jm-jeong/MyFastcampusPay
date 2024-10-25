package com.fastcampus.banking.adpater.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.banking.application.port.in.RequestFirmbankingCommand;
import com.fastcampus.banking.application.port.in.RequestFirmbankingUseCase;
import com.fastcampus.banking.domain.FirmbankingRequest;
import com.fastcampus.common.WebAdapter;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {
	private final RequestFirmbankingUseCase requestFirmbankingUseCase;

	@PostMapping(path = "/banking/firmbanking/request")
	FirmbankingRequest requestFirmbanking(@RequestBody RequestFirmbankingRequest request) {
		RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
			.toBankName(request.getToBankName())
			.toBankAccountNumber(request.getToBankAccountNumber())
			.fromBankName(request.getFromBankName())
			.fromBankAccountNumber(request.getFromBankAccountNumber())
			.moneyAmount(request.getMoneyAmount())
			.build();

		return requestFirmbankingUseCase.requestFirmbanking(command);
	}
}
