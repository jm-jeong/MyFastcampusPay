package com.fastcampus.banking.domain;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmbankingRequest {
	@Getter private final String firmbankingRequestId;
	@Getter private final String fromBankName;
	@Getter private final String fromBankAccountNumber;
	@Getter private final String toBankName;
	@Getter private final String toBankAccountNumber;
	@Getter private final int moneyAmount; //only won
	@Getter private final int firmbankingStatus; // 0:요청, 1:완료, 2:실패
	@Getter private final UUID uuid;

	public static FirmbankingRequest generateFirmbankingRequest(
		FirmbankingRequestId firmbankingRequestId,
		FromBankName fromBankName,
		FromBankAccountNumber fromBankAccountNumber,
		ToBankName toBankName,
		ToBankAccountNumber toBankAccountNumber,
		MoneyAmount moneyAmount,
		FirmbankingStatus firmbankingStatus,
		UUID uuid
	) {
		return new FirmbankingRequest(
			firmbankingRequestId.getFirmbankingRequestId(),
			fromBankName.getFromBankName(),
			fromBankAccountNumber.getFromBankAccountNumber(),
			toBankName.getToBankName(),
			toBankAccountNumber.getToBankAccountNumber(),
			moneyAmount.getMoneyAmount(),
			firmbankingStatus.firmBankingStatus,
			uuid
		);
	}


	@Value
	public static class FirmbankingRequestId {
		public FirmbankingRequestId(String firmbankingRequestId) {
			this.firmbankingRequestId = firmbankingRequestId;
		}
		String firmbankingRequestId;
	}

	@Value
	public static class FromBankName{
		public FromBankName(String fromBankName) {
			this.fromBankName = fromBankName;
		}
		String fromBankName;
	}

	@Value
	public static class FromBankAccountNumber{
		public FromBankAccountNumber(String fromBankAccountNumber) {
			this.fromBankAccountNumber = fromBankAccountNumber;
		}
		String fromBankAccountNumber;
	}

	@Value
	public static class ToBankName {
		public ToBankName(String value) {
			this.toBankName = value;
		}
		String toBankName ;
	}

	@Value
	public static class ToBankAccountNumber {
		public ToBankAccountNumber(String value) {
			this.toBankAccountNumber = value;
		}
		String toBankAccountNumber ;
	}

	@Value
	public static class MoneyAmount {
		public MoneyAmount(int value) {
			this.moneyAmount = value;
		}
		int moneyAmount;
	}

	@Value
	public static class FirmbankingStatus {
		public FirmbankingStatus(int value) {
			this.firmBankingStatus = value;
		}
		int firmBankingStatus;
	}

}
