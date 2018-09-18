import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4Jdemo {
    public static Logger logger=LogManager.getLogger(Log4Jdemo.class);

    public static void main(String[] args) {
        try {
            int i=1/0;
        }catch (Exception e){
            logger.trace("这条是一个debug信息");
            logger.debug("这条是一个debug信息",e);
            logger.info("除0的时候报异常了");
            logger.warn("这条log是一个警告信息");
            logger.error("这条log是一个错误信息");
            logger.fatal("这是致命错误！");
        }
    }
}
