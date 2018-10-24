package project.utils;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/23 16:56
 * @Description:
 */
public class ExcelBean implements java.io.Serializable {
    /**列头（标题）名*/
    private String headTextName;
    /**对应字段名*/
    private String propertyName;
    /**合并单元格数*/
    private Integer cols;

    private XSSFCellStyle cellStyle;

    public ExcelBean(){

    }
    public ExcelBean(String headTextName, String propertyName){
        this.headTextName = headTextName;
        this.propertyName = propertyName;
    }

    public ExcelBean(String headTextName, String propertyName, Integer cols) {
        super();
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols = cols;
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public XSSFCellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }
}
