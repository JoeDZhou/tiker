package com.tiker.dao;

import com.tiker.entity.bo.SearchUniversityAndCampusBO;
import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.SearchUniversityAndCampusResultVO;
import com.tiker.entity.vo.ShowAddressVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    int insertAddress(AddressDTO addressDTO);

    List<ShowAddressVO> getAddressByDefaultOrNot(@Param("userId") String userId, @Param("isDefault") int isDefault);

    int updateStatus(@Param("addressId") String addressId, @Param("isDefault") int isDefault);

    int updateAddress(AddressDTO addressDTO);

    int deleteAddress(@Param("addressId") String addressId);

    List<SearchUniversityAndCampusBO> searchUniversityAndCampus(@Param("searchKey") String searchKey);
}
