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

import com.entity.DongwulingyangEntity;
import com.entity.view.DongwulingyangView;

import com.service.DongwulingyangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 动物领养
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@RestController
@RequestMapping("/dongwulingyang")
public class DongwulingyangController {
    @Autowired
    private DongwulingyangService dongwulingyangService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwulingyangEntity dongwulingyang, 
		HttpServletRequest request){

        EntityWrapper<DongwulingyangEntity> ew = new EntityWrapper<DongwulingyangEntity>();


		String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
		if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("lingyangzhanghao", (String)request.getSession().getAttribute("username"));
		}
		PageUtils page = dongwulingyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwulingyang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwulingyangEntity dongwulingyang, 
		HttpServletRequest request){
        EntityWrapper<DongwulingyangEntity> ew = new EntityWrapper<DongwulingyangEntity>();

		PageUtils page = dongwulingyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwulingyang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwulingyangEntity dongwulingyang){
       	EntityWrapper<DongwulingyangEntity> ew = new EntityWrapper<DongwulingyangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwulingyang, "dongwulingyang")); 
        return R.ok().put("data", dongwulingyangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwulingyangEntity dongwulingyang){
        EntityWrapper< DongwulingyangEntity> ew = new EntityWrapper< DongwulingyangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwulingyang, "dongwulingyang")); 
		DongwulingyangView dongwulingyangView =  dongwulingyangService.selectView(ew);
		return R.ok("查询动物领养成功").put("data", dongwulingyangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwulingyangEntity dongwulingyang = dongwulingyangService.selectById(id);
        return R.ok().put("data", dongwulingyang);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwulingyangEntity dongwulingyang = dongwulingyangService.selectById(id);
        return R.ok().put("data", dongwulingyang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwulingyangEntity dongwulingyang, HttpServletRequest request){
    	dongwulingyang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwulingyang);

        dongwulingyangService.insert(dongwulingyang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwulingyangEntity dongwulingyang, HttpServletRequest request){
    	dongwulingyang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwulingyang);

        dongwulingyangService.insert(dongwulingyang);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwulingyangEntity dongwulingyang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwulingyang);
        dongwulingyangService.updateById(dongwulingyang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DongwulingyangEntity> list = new ArrayList<DongwulingyangEntity>();
        for(Long id : ids) {
            DongwulingyangEntity dongwulingyang = dongwulingyangService.selectById(id);
            dongwulingyang.setSfsh(sfsh);
            dongwulingyang.setShhf(shhf);
            list.add(dongwulingyang);
        }
        dongwulingyangService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwulingyangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}