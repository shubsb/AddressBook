package com.shub.addressBook

class GlobalConfig {

    public static final def USER_TYPE = [
            ADMINISTRATOR: "ADMINISTRATOR",
            REGULAR_PERSON: "REGULAR_PERSON",
    ]


    public static Integer itemsPerPage() {
        return 7
    }
}
