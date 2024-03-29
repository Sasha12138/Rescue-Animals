package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussdongwubaikeDao;
import com.entity.DiscussdongwubaikeEntity;
import com.service.DiscussdongwubaikeService;
import com.entity.vo.DiscussdongwubaikeVO;
import com.entity.view.DiscussdongwubaikeView;

@Service("discussdongwubaikeService")
public class DiscussdongwubaikeServiceImpl extends ServiceImpl<DiscussdongwubaikeDao, DiscussdongwubaikeEntity> implements DiscussdongwubaikeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdongwubaikeEntity> page = this.selectPage(
                new Query<DiscussdongwubaikeEntity>(params).getPage(),
                new EntityWrapper<DiscussdongwubaikeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdongwubaikeEntity> wrapper) {
		  Page<DiscussdongwubaikeView> page =new Query<DiscussdongwubaikeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdongwubaikeVO> selectListVO(Wrapper<DiscussdongwubaikeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdongwubaikeVO selectVO(Wrapper<DiscussdongwubaikeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdongwubaikeView> selectListView(Wrapper<DiscussdongwubaikeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdongwubaikeView selectView(Wrapper<DiscussdongwubaikeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
