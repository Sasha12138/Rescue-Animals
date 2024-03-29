package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DongwulingyangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DongwulingyangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwulingyangView;


/**
 * 动物领养
 *
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwulingyangService extends IService<DongwulingyangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwulingyangVO> selectListVO(Wrapper<DongwulingyangEntity> wrapper);
   	
   	DongwulingyangVO selectVO(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
   	
   	List<DongwulingyangView> selectListView(Wrapper<DongwulingyangEntity> wrapper);
   	
   	DongwulingyangView selectView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwulingyangEntity> wrapper);
   	

}

