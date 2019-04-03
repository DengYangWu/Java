package org.web;

import java.util.List;

import javax.annotation.Resource;

import org.entity.Seckill;
import org.service.SeckillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/seckill")
public class SeckillController {
	@Resource
	private SeckillService seckillService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("1ist");
		List<Seckill> seckill=seckillService.getSeckillList();
		model.addAttribute("list",seckill);
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")long seckillId,Model model) {
		if(seckillId==0) 
		{
			return "/redirect:/seckill/list";
		}
		Seckill seckill=seckillService.getById(seckillId);
		if (seckill==null){
			return "/redirect:/seckill/list";
		}
		model.addAttribute("seckill",seckill);
		
		return "detail";
	}
}
