package com.dao;

import com.entity.DiscussdongwubaikeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdongwubaikeVO;
import com.entity.view.DiscussdongwubaikeView;


/**
 * 动物百科评论表
 * 
 * @author 
 * @email 
 * @date 2023-06-24 08:54:47
 */
public interface DiscussdongwubaikeDao extends BaseMapper<DiscussdongwubaikeEntity> {
	
	List<DiscussdongwubaikeVO> selectListVO(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
	
	DiscussdongwubaikeVO selectVO(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
	
	List<DiscussdongwubaikeView> selectListView(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);

	List<DiscussdongwubaikeView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
	
	DiscussdongwubaikeView selectView(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
	

}
