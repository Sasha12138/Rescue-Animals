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


import com.dao.DongwubaikeDao;
import com.entity.DongwubaikeEntity;
import com.service.DongwubaikeService;
import com.entity.vo.DongwubaikeVO;
import com.entity.view.DongwubaikeView;

@Service("dongwubaikeService")
public class DongwubaikeServiceImpl extends ServiceImpl<DongwubaikeDao, DongwubaikeEntity> implements DongwubaikeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwubaikeEntity> page = this.selectPage(
                new Query<DongwubaikeEntity>(params).getPage(),
                new EntityWrapper<DongwubaikeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwubaikeEntity> wrapper) {
		  Page<DongwubaikeView> page =new Query<DongwubaikeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DongwubaikeVO> selectListVO(Wrapper<DongwubaikeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DongwubaikeVO selectVO(Wrapper<DongwubaikeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DongwubaikeView> selectListView(Wrapper<DongwubaikeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwubaikeView selectView(Wrapper<DongwubaikeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
