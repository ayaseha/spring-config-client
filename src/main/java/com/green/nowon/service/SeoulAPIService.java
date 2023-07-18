package com.green.nowon.service;

import org.springframework.ui.Model;

public interface SeoulAPIService {

	void getElevatorInfo(Model model)throws Exception;

	void busStopLocationXyInfo(Model model)throws Exception;

}
