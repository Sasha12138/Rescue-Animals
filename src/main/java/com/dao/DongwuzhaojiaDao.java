package com.dao;

import com.entity.DongwuzhaojiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DongwuzhaojiaVO;
import com.entity.view.DongwuzhaojiaView;


/**
 * 动物找家
 * 
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwuzhaojiaDao extends BaseMapper<DongwuzhaojiaEntity> {
	
	List<DongwuzhaojiaVO> selectListVO(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
	
	DongwuzhaojiaVO selectVO(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
	
	List<DongwuzhaojiaView> selectListView(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);

	List<DongwuzhaojiaView> selectListView(Pagination page,@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
	
	DongwuzhaojiaView selectView(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
	

}
