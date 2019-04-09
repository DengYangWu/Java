package org.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.dto.SeckillResult;
import org.entity.Seckill;
import org.enumeration.SeckillEnum;
import org.error.RepeatKillException;
import org.error.SeckillCloseException;
import org.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/seckill_2")
public class SeckillController {
	@Autowired
	private SeckillService seckillService;
	@Autowired
	private ServletContext servletContext;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("1ist");
		List<Seckill> seckill=seckillService.getSeckillList();
		model.addAttribute("list",seckill);
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model) {
		if(seckillId==null) 
		{
			return "redirect:/seckill_2/list";
		}
		Seckill seckill=seckillService.getById(seckillId);
		if (seckill==null){
			return "forward:/seckill_2/list";
		}
		model.addAttribute("seckill",seckill);
		System.out.println(seckill);
		return "detail";
	}
	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
    	System.out.println("exposer");
        SeckillResult<Exposer> result;

        try {
            Exposer exposer = seckillService.exposerSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
           // LOG.error(e.getMessage());
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }

        return result;
    }
	
	@RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,
	          produces = {"application/json;charset=UTF-8"})
	  @ResponseBody
	  public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId, @PathVariable("md5") String md5,
	                                                 @CookieValue(value = "userPhone", required = false) Long userPhone) {
		  System.out.println("execution");
	      if (userPhone == null) {
	    	  SeckillExecution execution = new SeckillExecution(seckillId, SeckillEnum.NOT_LOGIN);
	          return new SeckillResult<SeckillExecution>(true,execution);
	      }

	      try {
	          SeckillExecution execution = seckillService.seckillExecution(seckillId, userPhone, md5);
	          //SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, killPhone, md5);
	          return new SeckillResult<SeckillExecution>(true, execution);
	      } catch (RepeatKillException e) {
	          SeckillExecution execution = new SeckillExecution(seckillId, SeckillEnum.INNER_ERROR);
	          return new SeckillResult<SeckillExecution>(true, execution);

	      } catch (SeckillCloseException e2) {
	          SeckillExecution execution = new SeckillExecution(seckillId, SeckillEnum.END);
	          return new SeckillResult<SeckillExecution>(true, execution);

	      } catch (Exception e) {
	          //LOG.error(e.getMessage());
	          SeckillExecution execution = new SeckillExecution(seckillId, SeckillEnum.REPEAT_KILL);
	          return new SeckillResult<SeckillExecution>(true, execution);
	      }

	  }
	//传递当前时间
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		System.out.println("Time");
		Date now = new Date();
		return new SeckillResult(true,now.getTime());
	}
}
