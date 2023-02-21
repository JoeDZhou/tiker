package com.tiker.service.impl;

import com.tiker.dao.AddressMapper;
import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.ShowAddressVO;
import com.tiker.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    public static final int DEFAULT_ADDRESS = 1;
    public static final int NOT_DEFAULT_ADDRESS = 0;
    public static final int NON_TYPE_DEFAULT = -1;

    @Resource
    private AddressMapper addressMapper;
    @Override
    @Transactional
    public int createAddress(AddressDTO addressDTO) {
        cancelCurrentDefaultAddress(addressDTO.getUser());

        return addressMapper.insertAddress(addressDTO);
    }

    @Override
    @Transactional
    public int editAddress(AddressDTO addressDTO) {
        if (addressDTO.getIsDefault() == DEFAULT_ADDRESS) {
            cancelCurrentDefaultAddress(addressDTO.getUser());
        }

        return addressMapper.updateAddress(addressDTO);
    }

    @Override
    public List<ShowAddressVO> getUserAddressList(String userId) {
        return addressMapper.getAddressByDefaultOrNot(userId, NON_TYPE_DEFAULT);
    }

    @Override
    public int deleteAddress(String addressId) {
        return addressMapper.deleteAddress(addressId);
    }

    private void cancelCurrentDefaultAddress(String userId) {
        List<ShowAddressVO> currentDefaultAddress = addressMapper.getAddressByDefaultOrNot(userId, DEFAULT_ADDRESS);
        if (!currentDefaultAddress.isEmpty()) {
            addressMapper.updateStatus(currentDefaultAddress.get(0).getId(), NOT_DEFAULT_ADDRESS);
        }
    }
}
