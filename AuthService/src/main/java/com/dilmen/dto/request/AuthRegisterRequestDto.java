package com.dilmen.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRegisterRequestDto {
        @NotNull(message = "Please enter Username")
        @Size(min = 3, max = 20)
        String username;
        @NotNull(message = "Please enter Password")
        @Size(min = 8, max = 64)
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!.?,-])(?=\\S+$).{8,}$",
                message = "Password must include at least 8 character, at least 1 uppercase, 1 lowercase and a special character ")
        String password;
        @NotNull(message = "Please enter Repassword")
        String repassword;
        @Email(message = "Lütfen geçerli bir e-mail adresi giriniz.")
        String email;
}
