package com.learnfruit.fruit.exceptions;

/**
 * ClassName:FruitDAOException
 * Package:com.learnfruit.fruit.exceptions
 * Description:
 *
 */
public class FruitDAOException extends RuntimeException{
    public FruitDAOException(){
        super();
    }
    public FruitDAOException(String msg){
        super(msg);
    }
}
