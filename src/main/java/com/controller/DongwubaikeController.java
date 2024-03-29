package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DongwubaikeEntity;
import com.entity.view.DongwubaikeView;

import com.service.DongwubaikeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 动物百科
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@RestController
@RequestMapping("/dongwubaike")
public class DongwubaikeController {
    @Autowired
    private DongwubaikeService dongwubaikeService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwubaikeEntity dongwubaike, 
		HttpServletRequest request){

        EntityWrapper<DongwubaikeEntity> ew = new EntityWrapper<DongwubaikeEntity>();


		PageUtils page = dongwubaikeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwubaike), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwubaikeEntity dongwubaike, 
		HttpServletRequest request){
        EntityWrapper<DongwubaikeEntity> ew = new EntityWrapper<DongwubaikeEntity>();

		PageUtils page = dongwubaikeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwubaike), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwubaikeEntity dongwubaike){
       	EntityWrapper<DongwubaikeEntity> ew = new EntityWrapper<DongwubaikeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwubaike, "dongwubaike")); 
        return R.ok().put("data", dongwubaikeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwubaikeEntity dongwubaike){
        EntityWrapper< DongwubaikeEntity> ew = new EntityWrapper< DongwubaikeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwubaike, "dongwubaike")); 
		DongwubaikeView dongwubaikeView =  dongwubaikeService.selectView(ew);
		return R.ok("查询动物百科成功").put("data", dongwubaikeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwubaikeEntity dongwubaike = dongwubaikeService.selectById(id);
        return R.ok().put("data", dongwubaike);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwubaikeEntity dongwubaike = dongwubaikeService.selectById(id);
        return R.ok().put("data", dongwubaike);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwubaikeEntity dongwubaike, HttpServletRequest request){
    	dongwubaike.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwubaike);

        dongwubaikeService.insert(dongwubaike);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwubaikeEntity dongwubaike, HttpServletRequest request){
    	dongwubaike.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwubaike);

        dongwubaikeService.insert(dongwubaike);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwubaikeEntity dongwubaike, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwubaike);
        dongwubaikeService.updateById(dongwubaike);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwubaikeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
