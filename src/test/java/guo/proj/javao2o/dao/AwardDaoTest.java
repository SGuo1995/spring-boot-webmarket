package guo.proj.javao2o.dao;

import guo.proj.javao2o.entity.Award;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AwardDaoTest {
    @Autowired
    private AwardDao awardDao;

    @Test
    public void testAInsertAward() {
            long shopId = 36;
            Award award = new Award();
            award.setShopId(shopId);
            award.setAwardName("testAward1");
            award.setAwardDesc("test");
            award.setAwardImg("test");
            award.setPoint(4);
            award.setCreateTime(new Date());
            award.setPriority(1);
            award.setEnableStatus(1);
            award.setLastEditTime(new Date());
            int effectedNum = awardDao.insertAward(award);
            assertEquals(effectedNum, 1);

            Award award2 = new Award();
            award2.setAwardName("testAward2");
            award2.setAwardImg("testImg");
            award2.setPriority(2);
            award2.setPoint(1);
            award2.setEnableStatus(0);
            award2.setCreateTime(new Date());
            award2.setLastEditTime(new Date());
            award2.setShopId(shopId);
            award2.setAwardDesc("another test awards");
            effectedNum = awardDao.insertAward(award2);
            assertEquals(1, effectedNum);
    }

    @Test
    public void testBQueryAwardList() {
        Award award = new Award();
        List<Award> awardList = awardDao.queryAwardList(award, 0 ,2);
        assertEquals(2, awardList.size());
        int count = awardDao.queryAwardCount(award);
        assertEquals(2, count);
        award.setAwardName("test");
        awardList = awardDao.queryAwardList(award, 0 , 2);
        assertEquals(2, awardList.size());
        count  = awardDao.queryAwardCount(award);
        assertEquals(2, count);
    }

    @Test
    public void testCQueryAwardByAwardId() {
        Award awardCondition = new Award();
        awardCondition.setAwardName("testAward2");
        List<Award> list = awardDao.queryAwardList(awardCondition, 0, 1);
        Long id = list.get(0).getAwardId();
        Award award = awardDao.queryAwardByAwardId(id);
        assertEquals("testAward2", award.getAwardName());
    }

    @Test
    public void testDUpdateAward() {
        Award awardCondition = new Award();
        awardCondition.setAwardName("testAward1");
        List<Award> awardList = awardDao.queryAwardList(awardCondition, 0 ,1);
        awardList.get(0).setAwardName("testAward3");
        int effecteNum = awardDao.updateAward(awardList.get(0));
        assertEquals(1, effecteNum);
        Award award = awardDao.queryAwardByAwardId(awardList.get(0).getAwardId());
        assertEquals("testAward3", award.getAwardName());
    }

    @Test
    public void testEDeleteAward() {
        Award awardCondition = new Award();
        awardCondition.setAwardName("test");
        List<Award> awardList = awardDao.queryAwardList(awardCondition, 0, 2);
        assertEquals(2, awardList.size());
        for (Award award : awardList) {
            int effectedNum = awardDao.deleteAward(award.getAwardId(), award.getShopId());
            assertEquals(1, effectedNum);
        }
    }
}
