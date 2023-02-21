package com.tiker.controller;

import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.dto.RestResultDTO;
import com.tiker.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;
    @PostMapping("/createAddress")
    public RestResultDTO createAddress(@RequestBody AddressDTO addressDTO) {
        int insertNum = addressService.createAddress(addressDTO);
        if (insertNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Insert address error", null);
        }
    }

    @PostMapping("/editAddress")
    public RestResultDTO edit(@RequestBody AddressDTO addressDTO) {
        int editNum = addressService.editAddress(addressDTO);
        if (editNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Edit address error", null);
        }
    }
}
