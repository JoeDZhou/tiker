package com.tiker.service.impl;

import com.tiker.dao.AddressMapper;
import com.tiker.entity.bo.SearchUniversityAndCampusBO;
import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.SearchUniversityAndCampusResultVO;
import com.tiker.entity.vo.ShowAddressVO;
import com.tiker.service.AddressService;
import com.tiker.util.IDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
        if (addressDTO.getIsDefault() == 1) {
            cancelCurrentDefaultAddress(addressDTO.getUser());
        }

        addressDTO.setId(IDGenerator.generateUUID(32));

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
    public ShowAddressVO getUserDefaultAddress(String userId) {
        List<ShowAddressVO> addresses = addressMapper.getAddressByDefaultOrNot(userId, DEFAULT_ADDRESS);

        if (addresses.isEmpty()) {
            return null;
        }

        return addresses.get(0);
    }

    @Override
    public int deleteAddress(String addressId) {
        return addressMapper.deleteAddress(addressId);
    }

    @Override
    public List<SearchUniversityAndCampusResultVO> searchUniversityAndCampus(String searchKey) {
        List<SearchUniversityAndCampusBO> universitySearchResult = addressMapper.searchUniversityAndCampus(searchKey);
        Map<String, SearchUniversityAndCampusResultVO> universityIdToResultMap = new HashMap<>();
        for (SearchUniversityAndCampusBO bo : universitySearchResult) {
            if (!universityIdToResultMap.containsKey(bo.getUniversityId())) {
                universityIdToResultMap.put(bo.getUniversityId(),
                        new SearchUniversityAndCampusResultVO()
                                .setId(bo.getUniversityId())
                                .setName(bo.getUniversityName())
                                .setCampusVOList(new ArrayList<>()));
            }
            universityIdToResultMap.get(bo.getUniversityId()).addCampusToList(bo.getCampusId(), bo.getCampusName());
        }
        return new ArrayList<>(universityIdToResultMap.values());
    }

    private void cancelCurrentDefaultAddress(String userId) {
        List<ShowAddressVO> currentDefaultAddress = addressMapper.getAddressByDefaultOrNot(userId, DEFAULT_ADDRESS);
        if (!currentDefaultAddress.isEmpty()) {
            addressMapper.updateStatus(currentDefaultAddress.get(0).getId(), NOT_DEFAULT_ADDRESS);
        }
    }
}
