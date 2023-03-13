package com.tiker.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class SearchUniversityAndCampusBO {
    private String universityId;
    private String universityName;
    private String campusId;
    private String campusName;
}
