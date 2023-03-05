package com.dilmen.manager;

import com.dilmen.dto.request.AuthRegisterRequestDto;
import com.dilmen.dto.response.AuthRegisterResponseDto;
import com.dilmen.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
        IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

        Auth authFromAuthRegisterRequestDto(final AuthRegisterRequestDto dto);

        AuthRegisterResponseDto authRegisterResponseDtoFromAuth(final Auth auth);


}
