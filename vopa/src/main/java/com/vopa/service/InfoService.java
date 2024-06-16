package com.vopa.service;

import java.util.List;

import com.vopa.payload.InfoDto;

public interface InfoService {
	public InfoDto getInfoById(Integer infoId);
	public List<InfoDto> getAllInfos();
	public InfoDto createInfo(InfoDto infoDto);
}
