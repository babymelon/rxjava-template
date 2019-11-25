package com.learn.rxjava.model.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegistrationForm {
    private String id;
    private String name;
    private String address;
    private String phone;
}
