package com.dilmen.mapper;

import com.dilmen.dto.request.UserProfileSaveRequestDto;
import com.dilmen.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

        IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

        @Mapping(source = "id", target = "userId")
        User userFromUserSaveRequestDto(final UserProfileSaveRequestDto dto);
}
