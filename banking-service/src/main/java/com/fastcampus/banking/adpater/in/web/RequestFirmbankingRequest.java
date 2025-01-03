package com.fastcampus.banking.adpater.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmbankingRequest {
	// a -> b 실물 계좌로 요청을 하기 위한 Request
	private String fromBankName;
	private String fromBankAccountNumber;
	private String toBankName;
	private String toBankAccountNumber;
	private int moneyAmount;
}
