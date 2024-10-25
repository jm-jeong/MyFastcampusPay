package com.fastcampus.banking.application.port.in;

import com.fastcampus.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
	FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
