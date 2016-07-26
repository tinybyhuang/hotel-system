package com.distinct.hotel.log.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.distinct.hotel.log.service.LogGetIPService;

@Service
public class LogGetIPServiceImpl implements LogGetIPService {

	@Override
	public String getUserId(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

}
