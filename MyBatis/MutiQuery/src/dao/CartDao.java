package dao;

import bean.Cart;
import bean.CartExt;

public interface CartDao {

    Cart findCartById(int cid);

    CartExt findCartById2(int cid);

}
