package project.service.impl;

import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import project.dao.UserLoginMapper;
import project.entity.ResultPojo;
import project.entity.UserLogin;
import project.entity.UserLoginExample;
import org.springframework.stereotype.Service;
import project.service.UserLoginService;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/10 17:08
 * @Description:
 */
@Service
public class UserServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginDao;

    @Override
    public ResultPojo getUserInfoById(int id) {
        UserLogin userLogin = userLoginDao.selectByPrimaryKey(id);
        if (userLogin == null){
            return getResult(404, "用户不存在" ,null);
        }
        return getResult(200 , "成功" , userLogin);
    }

    @Override
    public ResultPojo updateUserInfo(UserLogin userInfo) {
        if (userInfo.getUserLoginId() != null){
            int i = userLoginDao.updateByPrimaryKeySelective(userInfo);
            System.out.println(i);
            if (i <= 0){
                return getResult(500,"更新失败",null);
            }
            return getResult(200 , "更新成功" ,null);
        }
        return getResult(500,"更新失败",null);
    }

    @Override
    public ResultPojo deleteUserInfoById(int id) {
        int i = userLoginDao.deleteByPrimaryKey(id);
        if (i <= 0){
            return getResult(500 , "删除失败", null);
        }
        return getResult(200 , "删除成功", null);
    }

    @Override
    public ResultPojo selectAll() {
        UserLoginExample example = new UserLoginExample();
        UserLoginExample.Criteria criteria = example.createCriteria();
        List<UserLogin> userLogins = userLoginDao.selectByExample(example);
        if (userLogins != null && userLogins.size() > 0){
            return getResult(200 , "成功", userLogins);
        }
       return getResult(500 , "查询出错" , null);
    }

    @Override
    public ResultPojo insertUser(UserLogin user) {
        if (user.getUserAccount() != null && !"".equals(user.getUserAccount()) && user.getUserPassword() != null && !"".equals(user.getUserPassword())){
            int i = userLoginDao.insertSelective(user);
            if (i <= 0){
                return getResult(500, "添加失败" ,null);
            }
            return getResult(200 , "添加成功" ,null);
        }
        return getResult(500 , "必须添加用户名密码", null);
    }

    @Override
    public ResultPojo upFile(List<MultipartFile> files) {
        /* 文件保存路径 */
        String path = "D://TestFileUpAndDownload//";
        if (files == null || files.isEmpty() || files.size() <= 0){
            return getResult(500 ,"文件为空" ,null);
        }
        for (MultipartFile file : files){
            String filename = file.getOriginalFilename();
            String fileSuffix = filename.substring(filename.indexOf("."));
            /* 可添加文件类型检测 */
            File newFile = new File(path + filename);
            /* 检查父目录是否存在 */
            if (!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdir();
            }
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                return getResult(500 ,"文件上传失败" ,null);
            }
        }
        return getResult(200 ,"上传成功" ,null);
    }

    @Override
    public ResultPojo upFileBuffer(List<MultipartFile> files) {
        int empty = 0;
        /* 文件保存路径 */
        String path = "D://TestFileUpAndDownload";
        if (files == null || files.isEmpty() || files.size() <= 0){
            return getResult(500 ,"文件为空" ,null);
        }
        BufferedOutputStream outputStream;
        for (MultipartFile file : files){
            if (file.isEmpty()){
                empty ++;
                continue;
            }
            String filename = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                File newFile = new File(path + filename);
                if (newFile.getParentFile().exists()){
                    newFile.getParentFile().mkdir();
                }
                outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
                outputStream.write(bytes);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return getResult(500 ,"文件上传失败", null);
            }
        }
        return getResult(200 ,"文件上传成功,空文件：" + empty + "个" ,null);
    }


    private ResultPojo getResult(int code ,String message ,Object data){
        ResultPojo resultPojo = new ResultPojo();
        resultPojo.setCode(code);
        resultPojo.setMessage(message);
        resultPojo.setData(data);
        return resultPojo;
    }
}
