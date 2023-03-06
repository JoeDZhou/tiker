package com.tiker.service.impl;

import com.alibaba.fastjson.JSON;
import com.tiker.dao.UserMapper;
import com.tiker.entity.bo.UserBO;
import com.tiker.entity.bo.WxUserBo;
import com.tiker.entity.dto.WXLoginResultDTO;
import com.tiker.entity.vo.ShowUserVO;
import com.tiker.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RestTemplate restTemplate;

//    @Override
//    public int userRegister(CreateUserDTO createUserDTO) {
//        validPhoneNumber(createUserDTO.getPhone());
//        validPassword(createUserDTO.getPassword());
//        UserBO user = new UserBO();
//        user.setId(IDGenerator.generateUUID(64));
//        user.setAccount(IDGenerator.generateUUID(32));
//        BeanUtils.copyProperties(createUserDTO, user);
//
//        return userMapper.insertUser(user);
//    }

    @Override
    @Transactional
    public WXLoginResultDTO userLogin(String code) throws Exception {
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wx6662b5baa78b2601";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "60a0eb2a0c72d7b00fce77ced023325c";

        String url="https://api.weixin.qq.com/sns/jscode2session?appid="
                + wxspAppid +"&secret="+ wxspSecret +"&js_code="+code+"&grant_type=authorization_code";

        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Result: " + result);
        WXLoginResultDTO loginResult = JSON.parseObject(result, WXLoginResultDTO.class);
        if (loginResult.getOpenid() != null) {
            String wxUser = userMapper.getUserByOpenid(loginResult.getOpenid());
            if (wxUser == null) {
                createNewWxUser(loginResult.getOpenid());
            }
        }

        return loginResult;
    }

    @Override
    public ShowUserVO getUserBaseInfo(String userId) {
        ShowUserVO userBaseInfo = userMapper.getUserBaseInfoByOpenid(userId);

        return userBaseInfo;
    }

    private void createNewWxUser(String openid) throws Exception {
        String randomNickname = "TikerUser" + new Random().nextInt(Integer.MAX_VALUE);
        WxUserBo wxUserBo = new WxUserBo()
                .setOpenid(openid)
                .setNickname(randomNickname)
                .setCreatedTime(new Date())
                .setLastLoginTime(new Date());

        int insertNum = userMapper.insertNewWxUser(wxUserBo);
        if (insertNum < 1) {
            throw new Exception("Create new WX user failed");
        }
    }

    private boolean validPhoneNumber(String phoneNumber) {
        String regex = "^((13[0-9])|(14(0|[5-7]|9))|(15([0-3]|[5-9]))|(16(2|[5-7]))|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phoneNumber);
        if (!m.matches()) {
            return false;
        }

        UserBO user = userMapper.getUserByIdOrPhone(null, phoneNumber);
        if (user != null) {
            return false;
        }

        return true;
    }


    //   private boolean validPassword(String password) {
//        if (password.length() < 8 || password.length() > 32){
//            return false;
//        }
//
//        return true;
//    }
}
