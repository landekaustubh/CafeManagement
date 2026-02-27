package com.velocity.cafe.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.velocity.cafe.dto.request.CafeRequestDto;
import com.velocity.cafe.dto.response.CafeResponseDto;
import com.velocity.cafe.entities.Cafe;

@Mapper(componentModel = "spring")
public interface CafeMapper {

	@Mapping(source = "id" , target = "cafeId")
	CafeResponseDto toDto(Cafe cafe);
	
	
	Cafe toEntity(CafeRequestDto cafeRes);
	
	List<CafeResponseDto> list(List<Cafe> cafe);
	
	@Mapping(target = "id", ignore = true)
	void updateCafeFromDto(CafeRequestDto dto, @MappingTarget Cafe entity);
}
