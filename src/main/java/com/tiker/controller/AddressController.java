package com.tiker.controller;

import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.dto.RestResultDTO;
import com.tiker.entity.vo.SearchUniversityAndCampusResultVO;
import com.tiker.entity.vo.ShowAddressVO;
import com.tiker.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public RestResultDTO editAddress(@RequestBody AddressDTO addressDTO) {
        int editNum = addressService.editAddress(addressDTO);
        if (editNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Edit address error", null);
        }
    }

    @GetMapping("/addressList")
    public RestResultDTO addressList(@RequestParam("userId") String userId) {
        List<ShowAddressVO> result = addressService.getUserAddressList(userId);
        if (result != null) {
            return new RestResultDTO(0, "Success", result);
        } else {
            return new RestResultDTO(1, "Get address list error", null);
        }
    }

    @GetMapping("/getDefaultAddress")
    public RestResultDTO getDefaultAddress(@RequestParam("userId") String userId) {
        return new RestResultDTO(0, "Success", addressService.getUserDefaultAddress(userId));
    }

    @PostMapping("/deleteAddress")
    public RestResultDTO deleteAddress(@RequestParam("addressId") String addressId) {
        int deleteNum = addressService.deleteAddress(addressId);
        if (deleteNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Delete address error", null);
        }
    }

    @GetMapping("/searchUniversityAndCampus")
    public RestResultDTO searchUniversityAndCampus(@RequestParam("searchKey") String searchKey) {
        List<SearchUniversityAndCampusResultVO> searchResults = addressService.searchUniversityAndCampus(searchKey);

        return new RestResultDTO(0, "Success", searchResults);
    }
}
