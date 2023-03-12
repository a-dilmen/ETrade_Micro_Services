package com.dilmen.mapper;

import com.dilmen.dto.request.UserProfileSaveRequestDto;
import com.dilmen.dto.request.UserSaveRequestDto;
import com.dilmen.dto.response.AuthRegisterResponseDto;
import com.dilmen.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
        IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

        User userFromUserSaveRequestDto(final UserSaveRequestDto dto);

        AuthRegisterResponseDto authRegisterResponseDtoFromAuth(final User user);

        UserProfileSaveRequestDto userProfileSaveRequestDtofromUser(final User user);


}
