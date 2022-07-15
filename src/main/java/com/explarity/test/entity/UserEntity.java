package com.explarity.test.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "FirstName should Not Be Blank")
    @Size(min = 3,message = "firstName should be minimum 3 character")
    @Column(name="firstName",nullable = false)
    private String firstName;


    @NotBlank(message = "LastName should Not Be Blank")
    @Size(min = 3,message = "lastName should be minimum 3 character")
    @Column(name="lastName",nullable = false)
    private String lastName;


    @NotBlank(message = "UserName should Not Be Blank")
    @Size(min = 3,message = "UserName should be minimum 3 character")
    @Column(name = "userName",nullable = false)
    private String userName;


    @Size(min=0,max=10)
    @Pattern(regexp="([6-9]{1}[0-9]{2}[0-9]{3}[0-9]{4})" ,message = "Enter Valid Mobile Number ex-9237256788")
    @Column(name="mobileNumber",nullable = false)
    private String mobileNumber;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name="emailId",nullable = false,unique = true)
    private String userEmail;

    @Column(name="password")
    private String password;

    @Column(name="createdDate")
    private LocalDateTime createdDate=LocalDateTime.now();

    @Column(name = "updatedDate")
    private LocalDateTime updatedDate=LocalDateTime.now();


}
