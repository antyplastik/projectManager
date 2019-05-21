package com.pl.ptaq.project_manager.user.domain;

enum UserType {

    PROJECT_MANAGER("project_manager"),
    PRODUCT_OWNER("product_owner"),
    SCRUM_MASTER("scrum_master"),
    DEVELOPER("developer");

    private String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return userType;
    }
}
