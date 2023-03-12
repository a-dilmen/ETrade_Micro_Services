package com.dilmen.dto.request;

import com.dilmen.repository.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileSaveRequestDto extends BaseEntity {
        private Long id;
        private Long authId;
        private String username;
        private String email;
        private String photo;
        private String phone;
        private String about;
        private String age;
        private String website;
}
