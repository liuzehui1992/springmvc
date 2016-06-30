package com.springmvc.controller;

import com.springmvc.entity.*;
import com.springmvc.eto.AddressList;
import com.springmvc.eto.AddressSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 * Springmvc的数据绑定
 */
@Controller
public class SpringmvcController {

    /***
     * 1.绑定基本数据类型
     */
    // TODO: 2016/6/28 http://localhost:8080/baseType/12
    @RequestMapping(value = "baseType/{age}", method = RequestMethod.GET)
    public String baseTye(@PathVariable int age, Model model) {
        System.out.print("age:" + age);
        model.addAttribute("age", age);
        return "test";
    }

    /***
     * 2.接受字符串
     */
    // TODO: 2016/6/28 http://localhost:8080/string/zhangsan
    @RequestMapping(value = "string/{username}", method = RequestMethod.GET)
    public String string(@PathVariable("username") String username, Model model) {
        System.out.print("username:" + username);
        model.addAttribute("username" + username);
        return "test";
    }

    /***
     * 3.Stringmvc默认支持的类型：
     * HttpServletRequest、HttpServletResponse、HttpSession、Model
     */
    // TODO: 2016/6/28 http://localhost:8080/request.do?username=zhangfei
    @RequestMapping("request")
    public String request(HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.print(username);
        return "test";
    }

    /***
     * 4.接受简单对象类型User
     * 可以提交表单
     */
    // TODO: 2016/6/28 http://localhost:8080/user.do?username=xxx&password=2333
    @RequestMapping("user")
    public String user(User user, Model model) {
        System.out.print(user);
        model.addAttribute("user", user);
        return "test";
    }

    /***
     * 5.接受复杂类型的对象
     */
    // TODO: 2016/6/28 http://localhost:8080/index.jsp
    @RequestMapping(value = "person", method = RequestMethod.POST)
    public String person(Person person) {
        System.out.print(person);
        //Person{name='张三', age=23, idCard=IdCard{id='13234566444376', address='北京'}}
        return "test";
    }

    /****
     * 含有同属性的多对象处理方法
     * Teacher类中有username属性,Student类中也有username属性
     */
    // TODO: 2016/6/28  http://localhost:8080/test1.do?username=admin&age=12
    @RequestMapping("test1")
    public void test1(Student student, Teacher teacher) {
        System.out.print(student);
        System.out.print(teacher);
        //Student{username='admin', age=12}Teacher{username='admin', gender='null'}
        /***
         * 由上可见，当传入username=admin时，Student中的username属性和Teacher中的username属性
         * 同时被赋值为admin，
         * 怎么在传递username参数时能让他们被赋予不同的值呢--->WebDateBinder
         */
    }

    // TODO: http://localhost:8080/test2.do?student.username=zhangsan&age=23&teacher.username=admin&gender=man
    @RequestMapping("test2")
    public void test2(Student student, Teacher teacher) {
        System.out.print(student);
        System.out.print(teacher);
        //Student{username='zhangsan', age=23}Teacher{username='admin', gender='man'}
    }

    /***
     * 通过WebDateBinder设置默认前缀
     */
    @InitBinder("student") //指定student对象
    public void initStudent(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("student.");
    }

    @InitBinder("teacher") //指定teacher对象
    public void initTeacher(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("teacher.");
    }

    /***
     * 绑定List集合
     * Springmvc不支持直接绑定List，需要把list包装成对象
     */
    // TODO: 2016/6/29  http://localhost:8080/list.jsp
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public String list(AddressList addressList) {
        for (Address addr : addressList.getAddressList()) {
            System.out.print(addr);
        }
        System.out.print(addressList.getAddressList().size());
        /***
         *Address{number='001', street='xx街道'} Address{number='002', street='xx路口'}
         * 2
         * list这里有个坑，如果索引不连续，中间会出现null值。
         */
        return "test";
    }


    /***
     * Set：同样也需要包装对象
     */
    // TODO: 2016/6/29 http://localhost:8080/set.jsp
    @RequestMapping(value = "set", method = RequestMethod.POST)
    public String set(AddressSet addressSet) {
        for (Address addr : addressSet.getAddressSet()) {
            System.out.print(addr);
        }
        /***
         * Address{number='003', street='xx街道'}
         * Address{number='004', street='xx路口'}
         * Address{number='005', street='xx巷子'}size:3
         */
        System.out.print("size:" + addressSet.getAddressSet().size());
        return "test";
    }

    /***
     * Spring绑定json
     * 可以直接把前端提交的json字符串转换成pojo对象
     * @RequestBody：可以把json字符串转换成pojo对象
     */
    // TODO: 2016/6/30 http://localhost:8080/json.jsp
    @ResponseBody
    @RequestMapping(value = "json.do", method = RequestMethod.POST)
    public void json(@RequestBody Teacher teacher) {
        System.out.print("in...");
        System.out.print(teacher);
        /***
         * in...Teacher{username='zhangsan', gender='12'}
         */

    }


    /***
     * 通过serialize()提交表单
     *
     */
    // TODO: 2016/6/30 http://localhost:8080/form.jsp
    @RequestMapping(value = "form",method = RequestMethod.POST)
    public void form(Teacher teacher){
        System.out.print("in,,");
        System.out.print(teacher);
        //in,,Teacher{username='liu', gender='男'}
    }
}
