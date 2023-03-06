package com.tiker.service;

import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.ShowAddressVO;

import java.util.List;

public interface AddressService {
    int createAddress(AddressDTO addressDTO);

    int editAddress(AddressDTO addressDTO);

    List<ShowAddressVO> getUserAddressList(String userId);

    ShowAddressVO getUserDefaultAddress(String userId);

    int deleteAddress(String addressId);
}
