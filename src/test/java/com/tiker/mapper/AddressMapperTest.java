package com.tiker.mapper;

import com.tiker.dao.AddressMapper;
import com.tiker.entity.dto.AddressDTO;
import com.tiker.entity.vo.ShowAddressVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddressMapperTest {
    @Resource
    private AddressMapper addressMapper;
    @Test
    public void testGetAddressByDefaultOrNot() {
        List<ShowAddressVO> addresses = addressMapper.getAddressByDefaultOrNot("testUser123", 1);
        System.out.println(addresses);
        assertEquals(1, addresses.size());
        assertEquals(1, addresses.get(0).getIsDefault());
    }

    @Test
    public void testGetUpdateAddressIsDefault() {
        List<ShowAddressVO> addresses = addressMapper.getAddressByDefaultOrNot("testUser123", 1);
        addresses.get(0).setIsDefault(0);
        addressMapper.updateStatus(addresses.get(0).getId(), 0);
    }

    @Test
    public void testUpdateAddress() {
        AddressDTO address = new AddressDTO();
        address.setId("testAddressid12112233");
        address.setUniversity("newNudt");
        address.setCampus("new3Haoyuan");
        address.setIsDefault(1);

        addressMapper.updateAddress(address);
    }
}
