package com.hw.mapper;

import com.hw.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有数据
     * @return 返回Brand数据
     */
    @Select("select * from mybatis.tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status}) ")
    @ResultMap("brandResultMap")
    int addBrand(Brand brand);

    @Delete("delete from tb_brand where id = #{id};")
    @ResultMap("brandResultMap")
    int deleteById(int index);

    @Update("update tb_brand set brand_name=#{brandName}, company_name=#{companyName}, ordered=#{ordered},\n" +
            "                            description=#{description}, status=#{status}\n" +
            "        where id = #{id};")
    @ResultMap("brandResultMap")
    int updateById(Brand brand);

    /**
     * 根据提供的条件 动态查询
     * @return
     */
    Brand[] selectByConditions(@Param("status")Integer status, @Param("companyName")String companyName,
                               @Param("brandName")String brandName );

    Brand[] selectByConditionsTwo(Brand brand);

    int deleteByIds(@Param("ids") Integer[] ids);

    Brand[] selectByPage(@Param("firstId") int firstId, @Param("lastId") int lastId);


/*    //查询所有数据
    List<Brand> selectAll();
    // 通过ID查找数据
    List<Brand> selectById(int id);
    // 动态 条件查找
    List<Brand> selectByCondition(@Param("status")int status, @Param("brandName")String brandName,
                                  @Param("companyName") String companyName);
    // 条件查找
    Brand selectByConditionMap(Map map);

    // 添加数据
    void add(Brand brand);
    // 根据ID 更新其所有数据
    void update(Brand brand);
    // 删除一个数据
    int deleteOne(Brand brand);*/


}
