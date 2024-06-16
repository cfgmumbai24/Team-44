package com.vopa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vopa.entities.Info;
import com.vopa.payload.InfoDto;
import com.vopa.payload.StudentDto;
import com.vopa.repository.InfoRepository;
import com.vopa.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{

	@Autowired
	private InfoRepository infoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public InfoDto getInfoById(Integer infoId) {
		Info info = infoRepository.findById(infoId).orElseThrow();
		return infoToDto(info);
	}

	@Override
	public List<InfoDto> getAllInfos() {
		List<Info> infos = infoRepository.findAll();
		List<InfoDto> infoDtos=infos.stream().map((info)-> infoToDto(info)).collect(Collectors.toList());
		return infoDtos;
	}

	@Override
	public InfoDto createInfo(InfoDto infoDto) {
		Info info = dtoToInfo(infoDto);
		Info savedInfo = infoRepository.save(info);
		return infoToDto(savedInfo);
	}

	//dto to info
	public Info dtoToInfo(InfoDto infoDto) {
		return modelMapper.map(infoDto, Info.class);
	}
	//info to dto
	public InfoDto infoToDto(Info info) {
		return modelMapper.map(info, InfoDto.class);
	}
	
}
