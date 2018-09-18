package homework03;

import bean.Order;

public interface OrderDao {

   Order findOrderByOid(int oid);
}
