package com.green.nowon.openapi.seoul.bus;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.nowon.openapi.seoul.Result;

import lombok.Data;

@Data
public class BusStopLocationXyInfo {
	
	@JsonProperty("list_total_count")
	private int listTotalCount;
	@JsonProperty("RESULT")
	private Result result;
	private List<BusStopLocatonXyInfoItem> row;

}
