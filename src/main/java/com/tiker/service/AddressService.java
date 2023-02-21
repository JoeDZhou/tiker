package com.tiker.service;

import com.tiker.entity.dto.AddressDTO;

public interface AddressService {
    int createAddress(AddressDTO addressDTO);

    int editAddress(AddressDTO addressDTO);
}
