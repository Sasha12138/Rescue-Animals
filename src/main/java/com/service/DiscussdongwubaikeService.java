package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdongwubaikeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdongwubaikeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdongwubaikeView;


/**
 * 动物百科评论表
 *
 * @author 
 * @email 
 * @date 2023-06-24 08:54:47
 */
public interface DiscussdongwubaikeService extends IService<DiscussdongwubaikeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdongwubaikeVO> selectListVO(Wrapper<DiscussdongwubaikeEntity> wrapper);
   	
   	DiscussdongwubaikeVO selectVO(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
   	
   	List<DiscussdongwubaikeView> selectListView(Wrapper<DiscussdongwubaikeEntity> wrapper);
   	
   	DiscussdongwubaikeView selectView(@Param("ew") Wrapper<DiscussdongwubaikeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdongwubaikeEntity> wrapper);
   	

}

