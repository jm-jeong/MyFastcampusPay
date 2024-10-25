package com.fastcampus.banking.application.service;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.banking.adpater.out.external.bank.ExternalFirmbankingRequest;
import com.fastcampus.banking.adpater.out.external.bank.FirmbankingResult;
import com.fastcampus.banking.adpater.out.persistence.FirmbankingRequestJpaEntity;
import com.fastcampus.banking.adpater.out.persistence.FirmbankingRequestMapper;
import com.fastcampus.banking.application.port.in.RequestFirmbankingCommand;
import com.fastcampus.banking.application.port.in.RequestFirmbankingUseCase;
import com.fastcampus.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fastcampus.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampus.banking.domain.FirmbankingRequest;
import com.fastcampus.common.UseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {
	private final FirmbankingRequestMapper mapper;
	private final RequestFirmbankingPort requestFirmbankingPort;
	private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

	@Override
	public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {
		//Business Logic
		// a-> b 계좌

		// 1. 요청에 대해 정보를 먼저 write "요청" 상태로
		FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
			new FirmbankingRequest.FromBankName(command.getFromBankName()),
			new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
			new FirmbankingRequest.ToBankName(command.getToBankName()),
			new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
			new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
			new FirmbankingRequest.FirmbankingStatus(0)
		);

		// 2. 외부 은행에 펌뱅킹 요청
		FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(
			new ExternalFirmbankingRequest(
				command.getFromBankName(),
				command.getFromBankAccountNumber(),
				command.getToBankName(),
				command.getToBankAccountNumber()
			));

		//Transactional UUID
		UUID randomUUID = UUID.randomUUID();
		requestedEntity.setUuid(randomUUID.toString());

		//3. 결과에 따라서 1번에서 작성했던 FirmbankingReuqest 정보를 Update
		if (result.getResultCode() == 0) {
			//성공
			requestedEntity.setFirmbankingStatus(1);
		} else {
			//실패
			requestedEntity.setFirmbankingStatus(2);
		}

		//4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
		return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
	}
}
