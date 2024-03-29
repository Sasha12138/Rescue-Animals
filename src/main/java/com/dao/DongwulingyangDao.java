package com.dao;

import com.entity.DongwulingyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DongwulingyangVO;
import com.entity.view.DongwulingyangView;


/**
 * 动物领养
 * 
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwulingyangDao extends BaseMapper<DongwulingyangEntity> {
	
	List<DongwulingyangVO> selectListVO(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	
	DongwulingyangVO selectVO(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	
	List<DongwulingyangView> selectListView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);

	List<DongwulingyangView> selectListView(Pagination page,@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	
	DongwulingyangView selectView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	

}
