package com.example.week3daily3homework.events;

import com.example.week3daily3homework.model.user.UserResponse;

public class UserEvent {
    private UserResponse userResponse;

    public UserEvent(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
