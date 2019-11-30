package cn.wangkx.mall;

import cn.wangkx.mall.mbg.mapper.PmsBrandMapper;
import cn.wangkx.mall.mbg.model.PmsBrand;
import cn.wangkx.mall.mbg.model.PmsBrandExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@MapperScan("cn.wangkx.mall.mbg.mapper")
public class MybatisGeneratorDemoApplication implements ApplicationRunner {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    public static void main(String[] args){
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        playWithArtifacts();
    }

    private void playWithArtifacts(){
        PmsBrand addidas=new PmsBrand();
        addidas.setName("addidas");
        addidas.setFirstLetter("A");
        addidas.setSort(0);
        addidas.setFactoryStatus(1);
        addidas.setShowStatus(1);
        addidas.setProductCount(22);
        addidas.setProductCommentCount(100);
        int a=pmsBrandMapper.insert(addidas);
        System.out.println(a);

        PmsBrand pmsBrand=pmsBrandMapper.selectByPrimaryKey(1L);
        System.out.println("PmsBrand {}" + pmsBrand + "");

        PmsBrandExample example=new PmsBrandExample();
        example.createCriteria().andNameEqualTo("NIKE");
        List<PmsBrand> list=pmsBrandMapper.selectByExample(example);
        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
