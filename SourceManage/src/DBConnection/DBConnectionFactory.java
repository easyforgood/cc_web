package DBConnection;
/**
 * 产生数据库连接的工厂
 * @author sunyibo
 *
 */
public class DBConnectionFactory {
	private static DBConnectionFactory dbFactory = null;
    private DBConnectionFactory() {// 将构造方法私有
    } 
    public static DBConnectionFactory getFactoryInstance() {// 实例化引用
    if (dbFactory == null) {
    	dbFactory = new DBConnectionFactory();
    }
        return dbFactory;
    } 
	
	private static DBConnection instance;
    //同步锁
    private static Object initLock = new Object();
    public DBConnection getInstance() {
        if (instance == null) {
            synchronized (initLock) {
                try {
                    try {
                        instance = (DBConnection) Class.forName(
                                DBConnectionConfig.className).newInstance();
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();          
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }
}
