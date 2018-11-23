import TestAnnotation.TestA;
import TestAnnotation.TestB;
import TestAnnotation.TestC;
import TestAnnotation.TestD;
import TestAopApi.SaveInterface;
import TestAopApi.TestSave;
import TestAopAspect.BusinessService;
import TestAopAspect.ParentInImpl;
import TestAopAspect.ParentInterface;
import TestAspectJ.MyAspectTest;
import TestBean.TestAut;
import TestBean.TestInitAndDestroy;
import TestBeanArray.ArrayBeans;
import TestBeanArray.BeanInteface;
import TestFanXing.*;
import TestResources.ResourcesMaster;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/31 11:16
 * @Description:
 */
public class TestMethod {

//    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/springMVC.xml");
        TestInitAndDestroy bean = context.getBean(TestInitAndDestroy.class);
        System.out.println(bean.getName() + ":" + bean.getInfo().getIDCardNumber());
        ((ClassPathXmlApplicationContext) context).destroy();
    }


//    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/springMVC.xml");
        TestAut bean = context.getBean(TestAut.class);
        bean.show();
        Resource resource = context.getResource("classpath:a.txt");
        System.out.println(resource.getFilename());
        try {
            System.out.println("文件长度:" + resource.contentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/springMVC.xml");
        ResourcesMaster bean = context.getBean(ResourcesMaster.class);
        ApplicationContext applicationContext = bean.getApplicationContext();
        Resource resource = applicationContext.getResource("classpath:b.txt");
        System.out.println(resource.getFilename());
    }

//    @Test
    public void tes4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        /*TestC bean = context.getBean(TestC.class);
        bean.say();*/
       /* TestB testB = (TestB) context.getBean("testB");
        if (testB == null){
            System.out.println("取不到TestB");
        }else {
            testB.say();
        }*/
        /*TestA bean1 = context.getBean(TestA.class);
        TestA bean2 = context.getBean(TestA.class);
        bean1.say();
        bean2.say();*/
        TestD bean1 = context.getBean(TestD.class);
        bean1.say();
        ArrayBeans bean = context.getBean(ArrayBeans.class);
        List<BeanInteface> list = bean.getList();
        Iterator<BeanInteface> iterator = list.iterator();
        while(iterator.hasNext()){
            BeanInteface next = iterator.next();
            next.say();
        }
        BeanInteface beanInteface = bean.getBeanInteface();
        beanInteface.say();
        /*Map<String, BeanInteface> list = bean.getList();
        for (Map.Entry entry :list.entrySet()){
            System.out.print(entry.getKey() + " ");
            ((BeanInteface)entry.getValue()).say();
            System.out.println();
        }*/
    }
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-aop.xml");
       /* ParentInterface bean =(ParentInterface) context.getBean("businessService");*/
        BusinessService bean = context.getBean(BusinessService.class);
        try {
            bean.showOther("mayao" ,18);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-aopapi.xml");
        SaveInterface bean = (SaveInterface) context.getBean("testImpl");
        bean.save();
    }

    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        FanXingInterface bean = (FanXingInterface) context.getBean("fanXing");
        bean.save("IG NB");
        FanXingInterface bean2 = (FanXingInterface) context.getBean("fanXing");
        bean2.save("IG NB");
    }
}
