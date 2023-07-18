package com.green.nowon.openapi.seoul.bus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BusStopLocatonXyInfoItem {
	
	@JsonProperty("STOP_NO")
	private String STOP_NO; // 01001,//정류소번호
	@JsonProperty("STOP_NM")
	private String STOP_NM; // 종로2가사거리,//정류소명
	@JsonProperty("XCODE")
	private String XCODE; // 126.9877498816,//x
	@JsonProperty("YCODE")
	private String YCODE; // 37.5697651251 //y

}
