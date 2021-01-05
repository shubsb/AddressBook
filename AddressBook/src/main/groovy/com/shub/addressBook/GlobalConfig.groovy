package com.shub.addressBook

// Global Configuration for each user and list length
class GlobalConfig {

    // The type of users
    public static final def USER_TYPE = [
            ADMINISTRATOR: "ADMINISTRATOR",
            REGULAR_PERSON: "REGULAR_PERSON",
    ]

    // The amount of id's displayed on each page
    public static Integer itemsPerPage() {
        return 7
    }
}
