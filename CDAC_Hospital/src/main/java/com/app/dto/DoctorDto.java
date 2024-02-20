package com.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Validated
public class DoctorDto {

    @JsonProperty(value = "doctorId", access = Access.READ_ONLY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @JsonProperty(access=Access.READ_ONLY)
    private String email;

    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotNull
    @Size(min = 2, max = 100, message = "Doctor name must be between 2 and 100 characters")
    private String dName;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits")
    private String dContactNo;

    @NotNull
    private String dSpecialisation;
    
   
    @Min(value = 0, message = "Experience must be a positive value")
    @Max(value = 60, message = "Experience cannot exceed 50 years")
    private int experience;

}
