package com.dilmen.manager;

import com.dilmen.dto.request.UserProfileSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.dilmen.constants.RestEndPoints.SAVE;

@FeignClient(
        name = "user-service-feign",
        url = "http://localhost:9999/api/v1/dev/elastic/user",
        decode404 = true
)
public interface IElasticServiceManager {
        @PostMapping(SAVE)
        ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto);
}
