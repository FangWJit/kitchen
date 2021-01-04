package com.dhf.kitchen;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.mp.Generator;
import com.dhf.kitchen.system.pc.userrelation.mapper.UserRelationMapper;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsintDemoApplicationTests {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    UserRelationMapper userRelationMapper;

    @Test
    public void contextLoads() {

       Generator gse = new Generator();
        //要给那些表生成
        gse.generateByTables(false, "food_list","user","user_detail");
    }

    @Test
    public void detailTest() {
        KitResult kitResult = userDetailService.queryUserDetail("18290514177");
        System.out.println(kitResult);
    }

    @Test
    public void RelationTest() {
        int i = userRelationMapper.selectNoricorNum("111f35d9-ecd0-499d-8d8c-782bbf88c762");

        UserRelation userRelation = new UserRelation();
        userRelation.setNoricorId("5");
        userRelation.setUserId("111f35d9-ecd0-499d-8d8c-782bbf88c762");
        int i1 = userRelationMapper.insertFansNum(userRelation);
        if (i1 == 0) {
            int i2 = userRelationMapper.insertFirstFansNum(userRelation);
            System.out.println(i2);
        }
        System.out.println(i1);
    }

}
