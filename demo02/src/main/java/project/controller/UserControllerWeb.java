package project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import project.utils.JsonUtils;
import project.entity.ResultPojo;
import project.entity.UserLogin;
import project.service.UserLoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/11 10:36
 * @Description:
 */
@Controller
@RequestMapping("/web")
public class UserControllerWeb {

    @Resource
    private UserLoginService userLoginService;

    @RequestMapping("/delete")
    @ResponseBody
    public ResultPojo del(UserLogin userLogin){
        ResultPojo resultPojo = userLoginService.deleteUserInfoById(userLogin.getUserLoginId());
        return resultPojo;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultPojo ins(UserLogin userLogin){
        ResultPojo resultPojo = userLoginService.insertUser(userLogin);
        return resultPojo;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultPojo upd(UserLogin userLogin){
        ResultPojo resultPojo = userLoginService.updateUserInfo(userLogin);
        System.out.println(JsonUtils.objectToJson(resultPojo));
        return resultPojo;
    }


    @RequestMapping("show/list")
    @ResponseBody
    public Map showList(){
        ResultPojo resultPojo = userLoginService.selectAll();
        List<UserLogin> data = (List<UserLogin>) resultPojo.getData();
        Map map =new HashMap();
        map.put("users",data);
        return map;
    }

    /** 多文件上传 */
    @RequestMapping(value = "/upload1" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo upload(HttpServletRequest request){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest request1 = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = request1.getFiles("UpFile");
        ResultPojo resultPojo = userLoginService.upFile(files);
        return resultPojo;
    }

    /** 单文件上传 */
    @RequestMapping(value = "/upload2" ,method = RequestMethod.POST)
    @ResponseBody
    public String singleFileUpload(@RequestParam("UpFile") MultipartFile file){
        /* 文件保存路径 */
        String path = "D://TestFileUpAndDownload//";
        if (file == null || file.isEmpty()){
            return "失败";
        }
        BufferedOutputStream outputStream;
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
                return "成功";
            } catch (IOException e) {
                e.printStackTrace();
                return "失败";
            }
    }

    /** 文件下载，修改响应版 */
    @RequestMapping(value = "/download1/{fileName}")
    public String download(HttpServletResponse response , @PathVariable String fileName){
        String path = "D://TestFileUpAndDownload//";
        File file = new File(path + fileName);
        if (!file.exists()){
            return null;
        }
        response.setContentType("application/force-download");
        try {
            /* 防止中文乱码 */
            fileName=new String(fileName.getBytes("gbk"),"iso8859-1");
            response.setHeader("Content-Disposition" ,"attachment;fileName=" + fileName);
            OutputStream os = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream buff = new BufferedInputStream(fileInputStream);
            byte[] bytes = new byte[fileInputStream.available()];
            int read = buff.read(bytes);
            while (read != -1){
                os.write(bytes);
                read = buff.read();
            }
            os.close();
            buff.close();
        }catch (Exception e){

        }
        return null;
    }

    /** 文件下载，自定义响应 */
    @RequestMapping("/download2/{fileName}")
    public ResponseEntity<byte[]> downloadTwo(HttpServletRequest request , @PathVariable String fileName){
        String path = "D://TestFileUpAndDownload//";
        File file = new File(path + fileName);
        byte[] bytes;
        try {
            InputStream in = new FileInputStream(new File(path + fileName));
            bytes = new byte[in.available()];
            in.read(bytes);
            /* 防止中文乱码 */
            fileName=new String(fileName.getBytes("gbk"),"iso8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+fileName);
            HttpStatus status = HttpStatus.OK;
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes ,headers ,status);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/testSerializable")
    @ResponseBody
    public void testSerializable(@RequestParam String name, @RequestParam String time){
        System.out.println(name + "---" + time);
    }

}
