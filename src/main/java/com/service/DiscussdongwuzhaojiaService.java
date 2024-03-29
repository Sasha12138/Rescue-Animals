package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdongwuzhaojiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdongwuzhaojiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdongwuzhaojiaView;


/**
 * 动物找家评论表
 *
 * @author 
 * @email 
 * @date 2023-06-24 08:54:47
 */
public interface DiscussdongwuzhaojiaService extends IService<DiscussdongwuzhaojiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdongwuzhaojiaVO> selectListVO(Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
   	
   	DiscussdongwuzhaojiaVO selectVO(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
   	
   	List<DiscussdongwuzhaojiaView> selectListView(Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
   	
   	DiscussdongwuzhaojiaView selectView(@Param("ew") Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdongwuzhaojiaEntity> wrapper);
   	

}

