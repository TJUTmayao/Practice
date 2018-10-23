package project.service;

import org.springframework.web.multipart.MultipartFile;
import project.entity.ResultPojo;
import project.entity.UserLogin;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/10 15:19
 * @Description:
 */
public interface UserLoginService {

    ResultPojo getUserInfoById(int id);
    ResultPojo updateUserInfo(UserLogin userInfo);
    ResultPojo deleteUserInfoById(int id);
    ResultPojo selectAll();
    ResultPojo insertUser(UserLogin user);
    ResultPojo upFile(List<MultipartFile> files);
    ResultPojo upFileBuffer(List<MultipartFile> files);
}
