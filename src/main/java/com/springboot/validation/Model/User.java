package com.springboot.validation.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank(message = "Name must not be blank")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name cannot be numbers and special character")
    private String name;

    @Id
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "email must be vaid")
    private String email;

    @NotNull(message = "age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;

    @NotNull(message = "phone number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "no must be exactly 10 digits")
    private String phone;
}
