package homework02;

import bean.Order;

public interface OrderDao {

   Order findOrderByOid(int oid);
}
