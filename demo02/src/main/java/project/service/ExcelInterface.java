package project.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/24 10:27
 * @Description:
 */
public interface ExcelInterface {

    List uploadPayerCreditInfoExcel(InputStream in, MultipartFile file, Long companyId, Long userId) throws Exception;
    List uploadPayerCreditInfoExcel(InputStream in, MultipartFile file) throws Exception;
    public XSSFWorkbook exportPayerCreditInfoExcel(Long companyId) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IntrospectionException, com.sun.tools.example.debug.expr.ParseException;
}
