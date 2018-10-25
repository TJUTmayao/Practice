package project.service.impl;

import com.sun.tools.example.debug.expr.ParseException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.service.ExcelInterface;
import project.utils.ExcelBean;
import project.utils.ExcelUtils;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/24 10:28
 * @Description:
 */
@Service
public class ExcelService implements ExcelInterface {

    @Override
    public List uploadPayerCreditInfoExcel(InputStream in, MultipartFile file, Long companyId, Long userId) throws Exception {
        List<List<Object>> listob = ExcelUtils.getBankListByExcel(in,file.getOriginalFilename());
        List<CreditInfoBean> creditInfoList=new ArrayList<CreditInfoBean>();
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            CreditInfoBean creditInfoBean = new CreditInfoBean();
            creditInfoBean.setCompanyName(String.valueOf(ob.get(0)));
            creditInfoBean.setBillType(String.valueOf(ob.get(1)));
            creditInfoBean.setBillNumber(String.valueOf(ob.get(2)));
            BigDecimal bd=new BigDecimal(String.valueOf(ob.get(3)));
            creditInfoBean.setBuyerBillAmount(bd.setScale(2, BigDecimal.ROUND_HALF_UP));
            creditInfoBean.setReceiveTime(String.valueOf(ob.get(4)));
            creditInfoBean.setBuyerRemark(String.valueOf(ob.get(5)));
            creditInfoList.add(creditInfoBean);
        }
        return creditInfoList;
    }

    @Override
    public List uploadPayerCreditInfoExcel(InputStream in, MultipartFile file) throws Exception {
       return uploadPayerCreditInfoExcel(in ,file ,(long) 1 ,(long) 1);
    }
    @Override
    public XSSFWorkbook exportPayerCreditInfoExcel(Long companyId) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException {
        /* 可以更换其他的实体类 */
        List<CreditInfoBean> creditInfoList = new ArrayList<>();
        initcreditInfoList(creditInfoList);
        List<ExcelBean> ems=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook book = null;
        /* 设置Excel表格的字段（注意与实体类中的属性对应） */
        ems.add(new ExcelBean("供应商名称","companyName",0));
        ems.add(new ExcelBean("票据类型","billType",0));
        ems.add(new ExcelBean("票据号","billNumber",0));
//		ems.add(new ExcelBean("买方是否参与","isBuyerIquidation",0));
        ems.add(new ExcelBean("票据金额","buyerBillAmount",0));
        ems.add(new ExcelBean("应付日期","receiveTime",0));
//        ems.add(new ExcelBean("剩余天数","overplusDays",0));
        ems.add(new ExcelBean("状态","buyerBillStatus",0));
        map.put(0, ems);
        /* 更新状态（数据库） */
//        List<CreditInfoBean> afterChangeList = changeBuyerStatus(creditInfoList);
        try {
            book = ExcelUtils.createExcelFile(CreditInfoBean.class, creditInfoList, map, "应付账款信息");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return book;
    }

    private void initcreditInfoList(List<CreditInfoBean> list){
        CreditInfoBean creditInfoBean = new CreditInfoBean();
        creditInfoBean.setBillNumber("测试数据1");
        creditInfoBean.setBillType("测试数据2");
        creditInfoBean.setBuyerRemark("测试数据3");
        creditInfoBean.setCompanyName("测试数据4");
        creditInfoBean.setReceiveTime("测试数据5");
        creditInfoBean.setBuyerBillStatus("已付款");
        BigDecimal bd=new BigDecimal(String.valueOf("52.3231"));
        creditInfoBean.setBuyerBillAmount(bd.setScale(2, BigDecimal.ROUND_HALF_UP));
        list.add(creditInfoBean);
    }
}
