package com.fastcampus.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseMoneyChangingRequest {
	private String targetMembershipId;

	//무조건 증액 요청(충전
	private int amount;
}
