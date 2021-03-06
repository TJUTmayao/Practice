package cn.xsl.mapper;

import cn.xsl.pojo.XslOrder;
import cn.xsl.pojo.XslOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslOrderMapper {
    int countByExample(XslOrderExample example);

    int deleteByExample(XslOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslOrder record);

    int insertSelective(XslOrder record);

    List<XslOrder> selectByExample(XslOrderExample example);

    XslOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslOrder record, @Param("example") XslOrderExample example);

    int updateByExample(@Param("record") XslOrder record, @Param("example") XslOrderExample example);

    int updateByPrimaryKeySelective(XslOrder record);

    int updateByPrimaryKey(XslOrder record);
}