package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DongwubaikeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DongwubaikeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwubaikeView;


/**
 * 动物百科
 *
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwubaikeService extends IService<DongwubaikeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwubaikeVO> selectListVO(Wrapper<DongwubaikeEntity> wrapper);
   	
   	DongwubaikeVO selectVO(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
   	
   	List<DongwubaikeView> selectListView(Wrapper<DongwubaikeEntity> wrapper);
   	
   	DongwubaikeView selectView(@Param("ew") Wrapper<DongwubaikeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwubaikeEntity> wrapper);
   	

}

