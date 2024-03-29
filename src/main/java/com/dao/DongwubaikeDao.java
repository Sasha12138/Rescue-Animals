package com.dao;

import com.entity.DongwubaikeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DongwubaikeVO;
import com.entity.view.DongwubaikeView;


/**
 * 动物百科
 * 
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwubaikeDao extends BaseMapper<DongwubaikeEntity> {
	
	List<DongwubaikeVO> selectListVO(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
	
	DongwubaikeVO selectVO(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
	
	List<DongwubaikeView> selectListView(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);

	List<DongwubaikeView> selectListView(Pagination page,@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
	
	DongwubaikeView selectView(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
	

}
