package study.studyspringboot.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import study.studyspringboot.Service.EmployeeService;
import study.studyspringboot.entity.Employee;

import java.util.List;
import java.util.Map;

@Controller
//@ResponseBody
@RequestMapping(value = "employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/test1", method = {RequestMethod.GET})
    public String test1(
            @RequestParam(required = false) String input,
            HttpServletRequest request,
            HttpServletResponse response) {
//		String output = "输入字符串为：" + input;
        return "study";
    }

    @ResponseBody
    @RequestMapping(value = "/test2", method = {RequestMethod.GET})
    public String test2(
            @RequestParam(required = false) String input,
            HttpServletRequest request,
            HttpServletResponse response) {
//		String output = "输入字符串为：" + input;
        return "study";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = {RequestMethod.GET})
    public String test3(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer age,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        System.out.println(employeeService.getClass().getName());
        return employeeService.save(name, age);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String test4(
            @RequestParam(required = true) Integer id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        return employeeService.deleteById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/savePage", method = {RequestMethod.GET})
    public String savePage(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer age,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        System.out.println(employeeService.getClass().getName());
        return employeeService.save(name, age);
    }


    @RequestMapping(value="/employeeSearchPage",method = {RequestMethod.GET})
    public ModelAndView getAll(ModelAndView mv){
        List<Employee> employeeList = employeeService.getAll();
        mv.addObject("employeeList",employeeList);
        mv.addObject("name","zhangshan");
        mv.setViewName("employeeSearchPage");
        return mv;
    }

    @GetMapping(value = "/addPage")
    public ModelAndView addPage(
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false,defaultValue = "0") Integer age,
            HttpServletRequest request,
            HttpServletResponse response,
            ModelAndView mv
    ){
        Employee employee = new Employee(name,age);
        mv.addObject("employee",employee);
        mv.setViewName("employeeAddPage");
        return mv;
    }

    @GetMapping(value = "/addOne")
    public ModelAndView addOne(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer age,
            HttpServletRequest request,
            HttpServletResponse response,
            ModelAndView mv
    ){
        Employee employee = employeeService.addOne(name, age);
        mv.addObject(employee);
        mv.setViewName("employeeAddPage");
        return mv;
    }

    public ModelAndView changeInfo(ModelAndView mv){
        return mv;
    }

    public ModelAndView advanceSearch(ModelAndView mv){
        return mv;
    }
    @RequestMapping(value="/homePage",method = {RequestMethod.GET})
    public ModelAndView homePage(ModelAndView mv,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        mv.setViewName("homePage");
        return mv;
    }
    @RequestMapping(value="/navigator",method = {RequestMethod.GET})
    public ModelAndView navigator(ModelAndView mv,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        mv.setViewName("navigator");
        return mv;
    }
}
