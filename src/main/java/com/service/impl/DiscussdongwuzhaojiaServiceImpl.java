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


import com.dao.DiscussdongwuzhaojiaDao;
import com.entity.DiscussdongwuzhaojiaEntity;
import com.service.DiscussdongwuzhaojiaService;
import com.entity.vo.DiscussdongwuzhaojiaVO;
import com.entity.view.DiscussdongwuzhaojiaView;

@Service("discussdongwuzhaojiaService")
public class DiscussdongwuzhaojiaServiceImpl extends ServiceImpl<DiscussdongwuzhaojiaDao, DiscussdongwuzhaojiaEntity> implements DiscussdongwuzhaojiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdongwuzhaojiaEntity> page = this.selectPage(
                new Query<DiscussdongwuzhaojiaEntity>(params).getPage(),
                new EntityWrapper<DiscussdongwuzhaojiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdongwuzhaojiaEntity> wrapper) {
		  Page<DiscussdongwuzhaojiaView> page =new Query<DiscussdongwuzhaojiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdongwuzhaojiaVO> selectListVO(Wrapper<DiscussdongwuzhaojiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdongwuzhaojiaVO selectVO(Wrapper<DiscussdongwuzhaojiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdongwuzhaojiaView> selectListView(Wrapper<DiscussdongwuzhaojiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdongwuzhaojiaView selectView(Wrapper<DiscussdongwuzhaojiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
