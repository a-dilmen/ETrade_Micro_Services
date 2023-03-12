package com.dilmen.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(indexName = "userprofile")
public class User extends BaseEntity{
        @Id
        private String id;
        private Long userId;
        private Long authId;
        private String username;
        private String email;
        private String photo;
        private String phone;
        private String about;
        private String age;
        private String website;
}
