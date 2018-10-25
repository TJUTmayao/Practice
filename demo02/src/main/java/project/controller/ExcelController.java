package project.controller;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import project.entity.ResultPojo;
import project.service.impl.CreditInfoBean;
import project.service.impl.ExcelService;
import project.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/24 10:08
 * @Description:
 */
@Controller
@RequestMapping("/web/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/export")
    public void exportExcel(HttpServletRequest request , HttpServletResponse response , HttpSession session){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String dateStr = sdf.format(new Date());
        /* 可设置公司名*/
        Map<String ,Object> map = new HashMap<>();
        /* 设置响应 */
        /* 设置文件名 */
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;
        try {
            /* 导出Excel */
            workbook = excelService.exportPayerCreditInfoExcel((long) 15);
            OutputStream out = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
            bufferedOutputStream.flush();
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping("/import")
    @ResponseBody
    public ResultPojo importExcel(HttpServletRequest request ,HttpServletResponse response ,HttpSession session){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("upExcel");
        if (file.isEmpty()){
            return getResult(500 , "文件为空" ,null);
        }
        try {
            InputStream inputStream = file.getInputStream();
            List list = excelService.uploadPayerCreditInfoExcel(inputStream, file);
            show(list);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResult(200 ,"文件导入成功" ,null);
    }
    private ResultPojo getResult(int code ,String message ,Object data){
        ResultPojo resultPojo = new ResultPojo();
        resultPojo.setCode(code);
        resultPojo.setMessage(message);
        resultPojo.setData(data);
        return resultPojo;
    }

    private void show(List list){
        List<CreditInfoBean> creditInfoBeans = list;
        Iterator<CreditInfoBean> iterator = creditInfoBeans.iterator();
        while(iterator.hasNext()){
            System.out.println(JsonUtils.objectToJson(iterator.next()));
        }
    }
}
