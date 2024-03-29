package com.dao;

import com.entity.DiscussdongwuzhaojiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdongwuzhaojiaVO;
import com.entity.view.DiscussdongwuzhaojiaView;


/**
 * 动物找家评论表
 * 
 * @author 
 * @email 
 * @date 2023-06-24 08:54:47
 */
public interface DiscussdongwuzhaojiaDao extends BaseMapper<DiscussdongwuzhaojiaEntity> {
	
	List<DiscussdongwuzhaojiaVO> selectListVO(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
	
	DiscussdongwuzhaojiaVO selectVO(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
	
	List<DiscussdongwuzhaojiaView> selectListView(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);

	List<DiscussdongwuzhaojiaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
	
	DiscussdongwuzhaojiaView selectView(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
	

}
