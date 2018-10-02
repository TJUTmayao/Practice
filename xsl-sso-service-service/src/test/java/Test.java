import cn.xsl.mapper.XslManagerMapper;
import cn.xsl.pojo.XslManager;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;
import pojo.JWTpojo;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import sso.utils.JedisClient;
import sso.utils.JedisClientCluster;
import sso.utils.JsonUtils;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/9/21 21:44
 * @Description:
 */
public class Test {
     private static final byte[] se = "geiwodiangasfdjsikolkjikolkijswe".getBytes();
     //jwt 新版本测试.
//    @org.junit.Test
    public void test1()throws Exception{
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MINUTE,15);
//        Date date = calendar.getTime();
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        Map map = new HashMap();
        map.put("s","s");
        Payload payload = new Payload(JsonUtils.objectToJson(map));
        JWSObject jwsObject = new JWSObject(header,payload);
        JWSSigner jwsSigner = new MACSigner(se);
        jwsObject.sign(jwsSigner);
//        System.out.println(date);
        System.out.println(header+"   "+payload+"  "+jwsObject);
        System.out.println(jwsObject.serialize());
        System.out.println(payload.toJSONObject().get("s"));
    }

//需要添加依赖
    //JWT 老版本测试。
//    @org.junit.Test
//    public void test2(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MINUTE,15);
//        Date date = calendar.getTime();
//        //header设置
//        Map<String,String> header = new HashMap<String, String>();
//        header.put("typ","JWT");
//        header.put("alg","HS256");
//        //设置payload
//        String token = JWT.create().withClaim("iss", "Service")
//                .withExpiresAt(date).sign(Algorithm.HMAC256(se));
//        System.out.println(token);
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(se)).build();
//        DecodedJWT verify = verifier.verify(token);
//        System.out.println(verify.getClaims());
//        System.out.println(verifier);
//    }


    //JSONObject测试
//    @org.junit.Test
    public void test3(){
        JWTpojo tpojo = new JWTpojo();
        tpojo.setIss("mayao");
        Payload payload = new Payload(JsonUtils.objectToJson(tpojo));
        System.out.println(payload);
        String s = payload.toString();
        System.out.println(s);
        JWTpojo tpojo1 = JsonUtils.jsonToPojo(payload.toString(), JWTpojo.class);
        System.out.println(tpojo1.getIss());
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.valueOf(new Date().getTime()));
        try {
            URL url = new URL("http://www.baidu.com");
            //获取链接
            URLConnection urlConnection = url.openConnection();
            //连接
            urlConnection.connect();
            long date = urlConnection.getDate();
            Date date1 = new Date(date);
            System.out.println(date);
            System.out.println(date1 + "  "+ new Date() );
        }catch (Exception e){

        }
    }
    //连接外网服务器
//    @org.junit.Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        XslManagerMapper xslManagerMapper = context.getBean(XslManagerMapper.class);
        XslManager xslManager = xslManagerMapper.selectByPrimaryKey("123456789");
        System.out.println(JsonUtils.objectToJson(xslManager));
    }

    //连接外网dubbo
    @org.junit.Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        JedisClient bean = context.getBean(JedisClient.class);
        if (bean == null){
            System.out.println("nullde");
        }else {
            bean.set("maao","1997");
            bean.expire("maao",10);
            System.out.println("成功");
            System.out.println(bean.get("maao"));
        }

    }

//    @org.junit.Test
    public void test6(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7000));
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7001));
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7002));
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7003));
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7004));
        jedisClusterNodes.add(new HostAndPort("39.108.211.37", 7005));

        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("name","123456");
        String string = jc.get("name");
        System.out.println(string);
    }

    @org.junit.Test
    public void md5(){
        String md5DigestAsHex = DigestUtils.md5DigestAsHex("123456789".getBytes());
        System.out.println(md5DigestAsHex);
    }

}
