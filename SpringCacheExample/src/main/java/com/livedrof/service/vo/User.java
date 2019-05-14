package com.livedrof.service.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    public User(Long userId) {
        this.userId = userId;
    }

    private Long userId;
    private String username;
    private String email;
}
