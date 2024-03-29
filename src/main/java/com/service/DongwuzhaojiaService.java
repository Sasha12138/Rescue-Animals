package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DongwuzhaojiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DongwuzhaojiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DongwuzhaojiaView;


/**
 * 动物找家
 *
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
public interface DongwuzhaojiaService extends IService<DongwuzhaojiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwuzhaojiaVO> selectListVO(Wrapper<DongwuzhaojiaEntity> wrapper);
   	
   	DongwuzhaojiaVO selectVO(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
   	
   	List<DongwuzhaojiaView> selectListView(Wrapper<DongwuzhaojiaEntity> wrapper);
   	
   	DongwuzhaojiaView selectView(@Param("ew") Wrapper<DongwuzhaojiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwuzhaojiaEntity> wrapper);
   	

}

