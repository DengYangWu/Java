package org.seckill.web;


import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill")  //url:/模板/资源/{id}/细分
public class SeckillController {
	private static final Logger LOG=LoggerFactory.getLogger(SeckillController.class);
	
	@Autowired
	private SeckillService seckillService;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		//list.jsp + model = ModelAndView
		//获取列表页
		List<Seckill> list=seckillService.getSeckillList();
		System.out.println("list");
		model.addAttribute("list",list);
		return "list";
	}
//	@RequestMapping(value="/list",method=RequestMethod.GET)
//	public String list(@PathVariable("seckillId")Long seckilld,Model model) {
//		//list.jsp + model = ModelAndView
//		//获取列表页
//		List<Seckill> list=seckillService.getSeckillList();
//		System.out.println("list");
//		model.addAttribute("list",list);
//		return "list";
//	}
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId,Model model) {
		//System.out.println("123");
		if(seckillId==null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if (seckill == null) {
            return "forward:/seckill/list";
        }
		
        model.addAttribute("seckill", seckill);
        System.out.println(seckill);
		return "detail";
	}
	//返回秒杀地址
	 //    ajax json
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
    	System.out.println("exposer");
        SeckillResult<Exposer> result;

        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }

        return result;
    }
//  ajax json
  @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,
          produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId, @PathVariable("md5") String md5,
                                                 @CookieValue(value = "userPhone", required = false) Long userPhone) {
	  System.out.println("execution");
      if (userPhone == null) {
          return new SeckillResult<SeckillExecution>(false, SeckillStatEnum.NOT_LOGIN.getStateInfo());
      }

      try {
          SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
          //SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, killPhone, md5);
          return new SeckillResult<SeckillExecution>(true, execution);
      } catch (RepeatKillException e) {
          SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
          return new SeckillResult<SeckillExecution>(true, execution);

      } catch (SeckillCloseException e2) {
          SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
          return new SeckillResult<SeckillExecution>(true, execution);

      } catch (Exception e) {
          LOG.error(e.getMessage());
          SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
          return new SeckillResult<SeckillExecution>(true, execution);
      }

  }

  @RequestMapping(value = "/time/now", method = RequestMethod.GET)
  @ResponseBody
  public SeckillResult<Long> time() {
	  System.out.println("time");
      Date now = new Date();
      return new SeckillResult(true, now.getTime());
  }
}
