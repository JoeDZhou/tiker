package com.tiker.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SearchUniversityAndCampusResultVO {
    private String Id;
    private String name;
    private List<CampusVO> campusVOList;

    @Data
    @Accessors(chain = true)
    public class CampusVO {
        private String id;
        private String name;
    }

    public void addCampusToList(String id, String name) {
        this.campusVOList.add(new CampusVO().setId(id).setName(name));
    }
}
