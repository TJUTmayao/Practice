package project.controller;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.entity.ResultPojo;
import project.service.impl.ExcelService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    private ResultPojo getResult(int code ,String message ,Object data){
        ResultPojo resultPojo = new ResultPojo();
        resultPojo.setCode(code);
        resultPojo.setMessage(message);
        resultPojo.setData(data);
        return resultPojo;
    }
}
