package com.tiker.dao;

import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.ShowAddressVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    int insertAddress(AddressDTO addressDTO);

    List<ShowAddressVO> getAddressByDefaultOrNot(int isDefault);

    int updateStatus(@Param("addressId") String addressId, @Param("isDefault") int isDefault);

    int updateAddress(AddressDTO addressDTO);
}
