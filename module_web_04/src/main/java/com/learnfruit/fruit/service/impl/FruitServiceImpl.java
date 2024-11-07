package com.learnfruit.fruit.service.impl;

import com.learnfruit.fruit.dao.FruitDAO;
import com.learnfruit.fruit.dao.impl.FruitDAOImpl;
import com.learnfruit.fruit.pojo.Fruit;
import com.learnfruit.fruit.service.FruitService;
import com.learnfruit.myssm.util.ConnUtil;

import java.util.List;

/**
 * ClassName:FruitServiceImpl
 * Package:com.learnfruit.fruit.service.impl
 * Description:
 *
 */
public class FruitServiceImpl implements FruitService {
    private FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        System.out.println("getFruitList ---->" + ConnUtil.getConn());
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        System.out.println("getPageCount ---->" + ConnUtil.getConn());
        int fruitCount = fruitDAO.getFruitCount(keyword);
        //总页数
        return (fruitCount+5-1)/5;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
