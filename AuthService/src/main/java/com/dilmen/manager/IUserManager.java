package com.dilmen.manager;

import com.dilmen.dto.request.UserSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.dilmen.constants.RestEndPoints.SAVE;

@FeignClient(
        name = "user-service-feign",
        url = "${myUrls.userServiceUrl}",
        decode404 = true
)
public interface IUserManager {
        @PostMapping(SAVE)
        ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto);
}
